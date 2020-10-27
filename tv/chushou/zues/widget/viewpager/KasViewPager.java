package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private boolean qif;
    private int[] qig;
    private boolean qih;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qif = false;
        this.qih = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.qif) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.qif || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.qif = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.qig != null && motionEvent.getX() >= this.qig[0] && motionEvent.getX() <= this.qig[1] && motionEvent.getY() >= this.qig[2] && motionEvent.getY() <= this.qig[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.qih;
            this.qih = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.qig = iArr;
        }
    }
}
