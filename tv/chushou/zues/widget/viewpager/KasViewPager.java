package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean nxx;
    private int[] nxy;
    private boolean nxz;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nxx = false;
        this.nxz = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.nxx) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nxx || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.nxx = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.nxy != null && motionEvent.getX() >= this.nxy[0] && motionEvent.getX() <= this.nxy[1] && motionEvent.getY() >= this.nxy[2] && motionEvent.getY() <= this.nxy[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.nxz;
            this.nxz = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.nxy = iArr;
        }
    }
}
