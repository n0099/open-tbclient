package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean nTG;
    private int[] nTH;
    private boolean nTI;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nTG = false;
        this.nTI = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.nTG) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nTG || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.nTG = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.nTH != null && motionEvent.getX() >= this.nTH[0] && motionEvent.getX() <= this.nTH[1] && motionEvent.getY() >= this.nTH[2] && motionEvent.getY() <= this.nTH[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.nTI;
            this.nTI = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.nTH = iArr;
        }
    }
}
