package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private boolean oxZ;
    private int[] oya;
    private boolean oyb;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oxZ = false;
        this.oyb = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.oxZ) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oxZ || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.oxZ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oya != null && motionEvent.getX() >= this.oya[0] && motionEvent.getX() <= this.oya[1] && motionEvent.getY() >= this.oya[2] && motionEvent.getY() <= this.oya[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.oyb;
            this.oyb = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.oya = iArr;
        }
    }
}
