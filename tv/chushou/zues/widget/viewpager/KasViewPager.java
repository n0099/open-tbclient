package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private int[] opA;
    private boolean opB;
    private boolean opz;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.opz = false;
        this.opB = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.opz) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.opz || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.opz = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.opA != null && motionEvent.getX() >= this.opA[0] && motionEvent.getX() <= this.opA[1] && motionEvent.getY() >= this.opA[2] && motionEvent.getY() <= this.opA[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.opB;
            this.opB = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.opA = iArr;
        }
    }
}
