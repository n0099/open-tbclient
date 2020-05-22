package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean nSw;
    private int[] nSx;
    private boolean nSy;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nSw = false;
        this.nSy = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.nSw) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nSw || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.nSw = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.nSx != null && motionEvent.getX() >= this.nSx[0] && motionEvent.getX() <= this.nSx[1] && motionEvent.getY() >= this.nSx[2] && motionEvent.getY() <= this.nSx[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.nSy;
            this.nSy = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.nSx = iArr;
        }
    }
}
