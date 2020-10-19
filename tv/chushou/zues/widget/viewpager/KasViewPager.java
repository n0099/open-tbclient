package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private boolean pqU;
    private int[] pqV;
    private boolean pqW;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pqU = false;
        this.pqW = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.pqU) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.pqU || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.pqU = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.pqV != null && motionEvent.getX() >= this.pqV[0] && motionEvent.getX() <= this.pqV[1] && motionEvent.getY() >= this.pqV[2] && motionEvent.getY() <= this.pqV[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.pqW;
            this.pqW = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.pqV = iArr;
        }
    }
}
