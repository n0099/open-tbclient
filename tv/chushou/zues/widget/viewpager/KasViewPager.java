package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private boolean oxX;
    private int[] oxY;
    private boolean oxZ;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oxX = false;
        this.oxZ = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.oxX) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oxX || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.oxX = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oxY != null && motionEvent.getX() >= this.oxY[0] && motionEvent.getX() <= this.oxY[1] && motionEvent.getY() >= this.oxY[2] && motionEvent.getY() <= this.oxY[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.oxZ;
            this.oxZ = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.oxY = iArr;
        }
    }
}
