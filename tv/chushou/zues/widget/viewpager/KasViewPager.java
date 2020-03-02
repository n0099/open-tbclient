package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean obA;
    private int[] obB;
    private boolean obC;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.obA = false;
        this.obC = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.obA) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.obA || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.obA = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.obB != null && motionEvent.getX() >= this.obB[0] && motionEvent.getX() <= this.obB[1] && motionEvent.getY() >= this.obB[2] && motionEvent.getY() <= this.obB[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.obC;
            this.obC = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.obB = iArr;
        }
    }
}
