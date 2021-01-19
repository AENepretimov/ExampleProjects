package com.example.testandroid180121;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyDraw extends View {

    private Paint paint;
    private Path path;
    private float x, y;
    private Map<Path, Paint> store;


    public MyDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        path = new Path();

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);

        store = new LinkedHashMap<>();
        store.put(path, paint);
    }

    public void setColor(int color) {
        path = new Path();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(color);

        store.put(path, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Map.Entry<Path, Paint> entry : store.entrySet()) {
            canvas.drawPath(entry.getKey(), entry.getValue());
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
        }

        invalidate();
        return true;
    }

    public void back() {
        if (!store.isEmpty()) {
            Iterator<Map.Entry<Path, Paint>> iterator = store.entrySet().iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            iterator.remove();
            invalidate();
        }
    }

    public void clear() {
        store.clear();
        invalidate();
    }
}
