package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasViewPager extends ViewPager {
    private boolean obL;
    private int[] obM;
    private boolean obN;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.obL = false;
        this.obN = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.obL) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.obL || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.obL = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.obM != null && motionEvent.getX() >= this.obM[0] && motionEvent.getX() <= this.obM[1] && motionEvent.getY() >= this.obM[2] && motionEvent.getY() <= this.obM[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.obN;
            this.obN = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.obM = iArr;
        }
    }
}
