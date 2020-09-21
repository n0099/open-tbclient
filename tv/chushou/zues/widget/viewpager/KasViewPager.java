package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private int[] pbA;
    private boolean pbB;
    private boolean pbz;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pbz = false;
        this.pbB = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.pbz) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.pbz || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.pbz = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.pbA != null && motionEvent.getX() >= this.pbA[0] && motionEvent.getX() <= this.pbA[1] && motionEvent.getY() >= this.pbA[2] && motionEvent.getY() <= this.pbA[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.pbB;
            this.pbB = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.pbA = iArr;
        }
    }
}
