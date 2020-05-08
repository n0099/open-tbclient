package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean nxA;
    private int[] nxB;
    private boolean nxC;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nxA = false;
        this.nxC = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.nxA) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nxA || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.nxA = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.nxB != null && motionEvent.getX() >= this.nxB[0] && motionEvent.getX() <= this.nxB[1] && motionEvent.getY() >= this.nxB[2] && motionEvent.getY() <= this.nxB[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.nxC;
            this.nxC = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.nxB = iArr;
        }
    }
}
