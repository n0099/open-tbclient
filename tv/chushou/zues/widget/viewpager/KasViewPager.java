package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private boolean oSi;
    private int[] oSj;
    private boolean oSk;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oSi = false;
        this.oSk = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.oSi) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oSi || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.oSi = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oSj != null && motionEvent.getX() >= this.oSj[0] && motionEvent.getX() <= this.oSj[1] && motionEvent.getY() >= this.oSj[2] && motionEvent.getY() <= this.oSj[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.oSk;
            this.oSk = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.oSj = iArr;
        }
    }
}
