package com.yy.hiidostatis.defs.monitor;

import android.view.MotionEvent;
/* loaded from: classes2.dex */
public enum ScreenMonitor {
    instance;
    
    public float x1 = 0.0f;
    public float x2 = 0.0f;
    public float y1 = 0.0f;
    public float y2 = 0.0f;
    public int slide = 0;
    public int click = 0;
    public long lastClickTime = 0;

    private void clickCount() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.lastClickTime;
        if (j == 0 || currentTimeMillis - j > 200) {
            this.click++;
        }
        this.lastClickTime = currentTimeMillis;
    }

    private void slideCount() {
        this.slide++;
    }

    public int getClick() {
        return this.click;
    }

    public int getSlide() {
        return this.slide;
    }

    public void reset() {
        this.slide = 0;
        this.click = 0;
    }

    ScreenMonitor() {
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            clickCount();
            this.x1 = motionEvent.getX();
            this.y1 = motionEvent.getY();
        }
        if (motionEvent.getAction() == 1) {
            this.x2 = motionEvent.getX();
            float y = motionEvent.getY();
            this.y2 = y;
            float f = this.y1;
            if (f - y > 50.0f) {
                slideCount();
            } else if (y - f > 50.0f) {
                slideCount();
            } else {
                float f2 = this.x1;
                float f3 = this.x2;
                if (f2 - f3 > 50.0f) {
                    slideCount();
                } else if (f3 - f2 > 50.0f) {
                    slideCount();
                }
            }
        }
    }
}
