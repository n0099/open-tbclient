package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean obA;
    private boolean oby;
    private int[] obz;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oby = false;
        this.obA = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.oby) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oby || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.oby = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.obz != null && motionEvent.getX() >= this.obz[0] && motionEvent.getX() <= this.obz[1] && motionEvent.getY() >= this.obz[2] && motionEvent.getY() <= this.obz[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.obA;
            this.obA = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.obz = iArr;
        }
    }
}
