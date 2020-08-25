package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private boolean oRQ;
    private int[] oRR;
    private boolean oRS;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oRQ = false;
        this.oRS = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.oRQ) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oRQ || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.oRQ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oRR != null && motionEvent.getX() >= this.oRR[0] && motionEvent.getX() <= this.oRR[1] && motionEvent.getY() >= this.oRR[2] && motionEvent.getY() <= this.oRR[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.oRS;
            this.oRS = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.oRR = iArr;
        }
    }
}
