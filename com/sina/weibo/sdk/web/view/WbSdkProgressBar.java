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
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public class WbSdkProgressBar extends View {
    public boolean addStart;
    public double growTime;
    public double growTimeMax;
    public Handler handler;
    public long lastTime;
    public float length;
    public final int maxLength;
    public final int minLength;
    public int miniSize;
    public int padding;
    public Paint paint;
    public int paintWidth;
    public float progress;
    public RectF rect;
    public boolean showView;
    public float speed;
    public long stopGrowTime;
    public long stopGrowTimeMax;
    public int stopNum;

    public WbSdkProgressBar(Context context) {
        this(context, null);
    }

    private void calculateProgress(long j) {
        long j2 = this.stopGrowTime;
        if (j2 >= this.stopGrowTimeMax) {
            double d2 = this.growTime;
            double d3 = j;
            Double.isNaN(d3);
            double d4 = d2 + d3;
            this.growTime = d4;
            double d5 = this.growTimeMax;
            if (d4 >= d5) {
                this.growTime = d4 - d5;
                this.stopGrowTime = 0L;
                this.addStart = !this.addStart;
            }
            float cos = (((float) Math.cos(((this.growTime / this.growTimeMax) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (!this.addStart) {
                this.length = cos * ((float) InstallActivity.BOX_SIZE_DP);
                return;
            }
            float f2 = ((float) InstallActivity.BOX_SIZE_DP) * (1.0f - cos);
            this.progress += this.length - f2;
            this.length = f2;
            return;
        }
        this.stopGrowTime = j2 + j;
    }

    private int dip2px(Context context, int i) {
        return (int) (context.getResources().getDisplayMetrics().density * i);
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        long abs = Math.abs(SystemClock.uptimeMillis() - this.lastTime) % 360;
        calculateProgress(abs);
        this.lastTime = SystemClock.uptimeMillis();
        float f2 = this.progress + ((this.speed * ((float) abs)) / 1000.0f);
        this.progress = f2;
        if (f2 >= 360.0f) {
            this.progress = f2 - 360.0f;
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

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.miniSize;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8) {
            this.handler.sendEmptyMessageDelayed(0, 1000L);
        } else if (i == 0 && getVisibility() == 0) {
            this.handler.removeMessages(0);
            this.showView = true;
            invalidate();
        }
    }

    public void setProgressColor(int i) {
        this.paint.setColor(i);
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
                if (message.what != 0) {
                    return;
                }
                WbSdkProgressBar.this.showView = false;
            }
        };
        this.miniSize = dip2px(context, 50);
        this.paintWidth = dip2px(context, 5);
        this.padding = dip2px(context, 3);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setColor(-48861);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.paintWidth);
        int i2 = this.padding;
        int i3 = this.miniSize;
        this.rect = new RectF(i2, i2, i3 - i2, i3 - i2);
    }
}
