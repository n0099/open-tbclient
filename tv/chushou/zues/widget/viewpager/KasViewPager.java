package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean opw;
    private int[] opx;
    private boolean opy;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.opw = false;
        this.opy = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.opw) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.opw || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.opw = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.opx != null && motionEvent.getX() >= this.opx[0] && motionEvent.getX() <= this.opx[1] && motionEvent.getY() >= this.opx[2] && motionEvent.getY() <= this.opx[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.opy;
            this.opy = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.opx = iArr;
        }
    }
}
