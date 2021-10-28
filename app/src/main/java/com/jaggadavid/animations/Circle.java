package com.jaggadavid.animations;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


import androidx.annotation.Nullable;

import java.util.Random;

public class Circle extends View {
    private Paint p = new Paint(Color.BLUE);
    Random r = new Random();
    private int y;
    private int x;

    private int dy = r.nextInt(5)+3;
    private int dx = r.nextInt(5)+3;
    public Circle(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        p = new Paint(Color.BLUE);
        y = r.nextInt(getHeight());
        x = r.nextInt(getWidth());
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.drawCircle(x,y,105f, p);
        x+=dx;
        y+=dy;
        if (x>=getWidth() || x<=0){
            dx*=-1;
        }
        if (y>=getHeight() || y<=0){
            dy*=-1;
        }
        invalidate();


    }
}
