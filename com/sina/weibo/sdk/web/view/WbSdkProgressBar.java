package com.sina.weibo.sdk.web.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class WbSdkProgressBar extends View {
    private boolean addStart;
    private double growTime;
    private double growTimeMax;
    private Handler handler;
    private long lastTime;
    private float length;
    private final int maxLength;
    private final int minLength;
    private int miniSize;
    private int padding;
    private Paint paint;
    private int paintWidth;
    private float progress;
    private RectF rect;
    private boolean showView;
    private float speed;
    private long stopGrowTime;
    private long stopGrowTimeMax;
    int stopNum;

    public WbSdkProgressBar(Context context) {
        this(context, null);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WbSdkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.minLength = 20;
        this.maxLength = 300;
        this.lastTime = 0L;
        this.speed = 200.0f;
        this.stopGrowTimeMax = 180L;
        this.stopGrowTime = 0L;
        this.growTimeMax = 490.0d;
        this.addStart = false;
        this.showView = true;
        this.stopNum = 0;
        this.handler = new Handler() { // from class: com.sina.weibo.sdk.web.view.WbSdkProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        WbSdkProgressBar.this.showView = false;
                        return;
                    default:
                        return;
                }
            }
        };
        this.miniSize = dip2px(context, 50);
        this.paintWidth = dip2px(context, 5);
        this.padding = dip2px(context, 3);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(-48861);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.paintWidth);
        this.rect = new RectF(this.padding, this.padding, this.miniSize - this.padding, this.miniSize - this.padding);
    }

    private int dip2px(Context context, int i) {
        return (int) (context.getResources().getDisplayMetrics().density * i);
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        long abs = Math.abs(SystemClock.uptimeMillis() - this.lastTime) % 360;
        calculateProgress(abs);
        this.lastTime = SystemClock.uptimeMillis();
        this.progress += (this.speed * ((float) abs)) / 1000.0f;
        if (this.progress >= 360.0f) {
            this.progress -= 360.0f;
        }
        canvas.drawArc(this.rect, this.progress - 90.0f, this.length + 20.0f, false, this.paint);
        if (this.showView) {
            if (Build.VERSION.SDK_INT >= 21) {
                postInvalidate();
            } else {
                invalidate();
            }
        }
    }

    public void setProgressColor(int i) {
        this.paint.setColor(i);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8) {
            this.handler.sendEmptyMessageDelayed(0, 1000L);
        } else if (i == 0 && getVisibility() == 0) {
            this.handler.removeMessages(0);
            this.showView = true;
            invalidate();
        }
    }

    private void calculateProgress(long j) {
        if (this.stopGrowTime >= this.stopGrowTimeMax) {
            this.growTime += j;
            if (this.growTime >= this.growTimeMax) {
                this.growTime -= this.growTimeMax;
                this.stopGrowTime = 0L;
                this.addStart = !this.addStart;
            }
            float cos = (((float) Math.cos(((this.growTime / this.growTimeMax) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (!this.addStart) {
                this.length = cos * 280;
                return;
            }
            float f = (1.0f - cos) * 280;
            this.progress += this.length - f;
            this.length = f;
            return;
        }
        this.stopGrowTime += j;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.miniSize, this.miniSize);
    }
}
