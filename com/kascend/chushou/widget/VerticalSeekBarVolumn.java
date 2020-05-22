package com.kascend.chushou.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.SeekBar;
/* loaded from: classes5.dex */
public class VerticalSeekBarVolumn extends AppCompatSeekBar {
    private a nac;

    /* loaded from: classes5.dex */
    public interface a {
        void a(SeekBar seekBar);

        void a(SeekBar seekBar, int i, boolean z);

        void b(SeekBar seekBar);
    }

    public VerticalSeekBarVolumn(Context context) {
        super(context);
    }

    public VerticalSeekBarVolumn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VerticalSeekBarVolumn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.nac = aVar;
    }

    void a() {
        if (this.nac != null) {
            this.nac.a(this);
        }
    }

    void b() {
        if (this.nac != null) {
            this.nac.b(this);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate(-getHeight(), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    setPressed(true);
                    a();
                    a(motionEvent);
                    break;
                case 1:
                    a(motionEvent);
                    b();
                    setPressed(false);
                    break;
                case 2:
                    a(motionEvent);
                    c();
                    break;
                case 3:
                    b();
                    setPressed(false);
                    break;
            }
            return true;
        }
        return false;
    }

    private void a(MotionEvent motionEvent) {
        setProgress(getMax() - ((int) ((getMax() * motionEvent.getY()) / getHeight())));
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    private void c() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        super.setProgress(i);
        if (this.nac != null) {
            this.nac.a(this, getProgress(), true);
        }
    }

    public void setProgressOnly(int i) {
        super.setProgress(i);
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
