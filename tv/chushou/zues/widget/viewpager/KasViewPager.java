package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private int[] qrA;
    private boolean qrB;
    private boolean qrz;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qrz = false;
        this.qrB = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.qrz) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.qrz || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.qrz = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.qrA != null && motionEvent.getX() >= this.qrA[0] && motionEvent.getX() <= this.qrA[1] && motionEvent.getY() >= this.qrA[2] && motionEvent.getY() <= this.qrA[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.qrB;
            this.qrB = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.qrA = iArr;
        }
    }
}
