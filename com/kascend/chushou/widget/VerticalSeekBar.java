package com.kascend.chushou.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.AbsSeekBar;
import com.kascend.chushou.a;
/* loaded from: classes5.dex */
public class VerticalSeekBar extends AbsSeekBar {
    private String TAG;
    private int height;
    private a mOnSeekBarChangeListener;
    private Drawable mThumb;
    private int width;

    /* loaded from: classes5.dex */
    public interface a {
        void a(VerticalSeekBar verticalSeekBar);

        void a(VerticalSeekBar verticalSeekBar, int i, boolean z);

        void b(VerticalSeekBar verticalSeekBar);
    }

    public VerticalSeekBar(Context context) {
        this(context, null);
        setThumbOffset(10000);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842875);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "VerticalSeekBar";
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.mOnSeekBarChangeListener = aVar;
    }

    void onStartTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.a(this);
        }
    }

    void onStopTrackingTouch() {
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.b(this);
        }
    }

    void onProgressRefresh(float f, boolean z) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getHeight(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
        if (this.mOnSeekBarChangeListener != null) {
            this.mOnSeekBarChangeListener.a(this, getProgress(), z);
        }
    }

    private void setThumbPos(int i, Drawable drawable, float f, int i2) {
        int i3;
        int paddingLeft = (getPaddingLeft() + i) - getPaddingRight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int thumbOffset = (int) (((paddingLeft - intrinsicWidth) + (getThumbOffset() * 2)) * f);
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.top;
            i3 = bounds.bottom;
        } else {
            i3 = i2 + intrinsicHeight;
        }
        drawable.setBounds(thumbOffset, i2, intrinsicWidth + thumbOffset, i3);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate(-this.height, 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        Drawable drawable = getResources().getDrawable(a.e.seek_bg);
        float f = getResources().getDisplayMetrics().density;
        this.width = 12;
        if (drawable != null) {
            this.width = drawable.getIntrinsicHeight();
            this.height = drawable.getIntrinsicWidth();
        }
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        this.mThumb = drawable;
        super.setThumb(null);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i3, i4);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    setPressed(true);
                    onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    break;
                case 1:
                    trackTouchEvent(motionEvent);
                    onStopTrackingTouch();
                    setPressed(false);
                    break;
                case 2:
                    trackTouchEvent(motionEvent);
                    attemptClaimDrag();
                    break;
                case 3:
                    onStopTrackingTouch();
                    setPressed(false);
                    break;
            }
            return true;
        }
        return false;
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        float paddingBottom;
        int height = getHeight();
        int paddingBottom2 = (height - getPaddingBottom()) - getPaddingTop();
        int y = (int) motionEvent.getY();
        if (y > height - getPaddingBottom()) {
            paddingBottom = 0.0f;
        } else if (y < getPaddingTop()) {
            paddingBottom = 1.0f;
        } else {
            paddingBottom = ((height - getPaddingBottom()) - y) / paddingBottom2;
        }
        setProgress((int) (paddingBottom * getMax()));
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent keyEvent2;
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 19:
                    keyEvent2 = new KeyEvent(0, 22);
                    break;
                case 20:
                    keyEvent2 = new KeyEvent(0, 21);
                    break;
                case 21:
                    keyEvent2 = new KeyEvent(0, 20);
                    break;
                case 22:
                    keyEvent2 = new KeyEvent(0, 19);
                    break;
                default:
                    keyEvent2 = new KeyEvent(0, keyEvent.getKeyCode());
                    break;
            }
            return keyEvent2.dispatch(this);
        }
        return false;
    }

    private int getScreenPra() {
        return 0;
    }
}
