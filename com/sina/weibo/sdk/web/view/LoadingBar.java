package com.sina.weibo.sdk.web.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes6.dex */
public class LoadingBar extends TextView {
    public static final int MAX_PROGRESS = 100;
    public Handler mHander;
    public Paint mPaint;
    public int mProgress;
    public int mProgressColor;
    public Runnable mRunnable;

    public LoadingBar(Context context) {
        super(context);
        this.mRunnable = new Runnable() { // from class: com.sina.weibo.sdk.web.view.LoadingBar.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingBar.access$008(LoadingBar.this);
                LoadingBar loadingBar = LoadingBar.this;
                loadingBar.drawProgress(loadingBar.mProgress);
            }
        };
        init(context);
    }

    public static /* synthetic */ int access$008(LoadingBar loadingBar) {
        int i2 = loadingBar.mProgress;
        loadingBar.mProgress = i2 + 1;
        return i2;
    }

    private Rect getRect() {
        int left = getLeft();
        int top = getTop();
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.mProgress) / 100)) - left, getBottom() - top);
    }

    private void init(Context context) {
        this.mHander = new Handler();
        this.mPaint = new Paint();
        initSkin();
    }

    public void drawProgress(int i2) {
        if (i2 < 7) {
            this.mHander.postDelayed(this.mRunnable, 70L);
        } else {
            this.mHander.removeCallbacks(this.mRunnable);
            this.mProgress = i2;
        }
        invalidate();
    }

    public void initSkin() {
        this.mProgressColor = -11693826;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.mProgressColor);
        canvas.drawRect(getRect(), this.mPaint);
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRunnable = new Runnable() { // from class: com.sina.weibo.sdk.web.view.LoadingBar.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingBar.access$008(LoadingBar.this);
                LoadingBar loadingBar = LoadingBar.this;
                loadingBar.drawProgress(loadingBar.mProgress);
            }
        };
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mRunnable = new Runnable() { // from class: com.sina.weibo.sdk.web.view.LoadingBar.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingBar.access$008(LoadingBar.this);
                LoadingBar loadingBar = LoadingBar.this;
                loadingBar.drawProgress(loadingBar.mProgress);
            }
        };
        init(context);
    }
}
