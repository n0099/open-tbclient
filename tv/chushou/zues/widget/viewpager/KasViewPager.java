package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class KasViewPager extends ViewPager {
    private boolean oaJ;
    private int[] oaK;
    private boolean oaL;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oaJ = false;
        this.oaL = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.oaJ) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oaJ || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.oaJ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oaK != null && motionEvent.getX() >= this.oaK[0] && motionEvent.getX() <= this.oaK[1] && motionEvent.getY() >= this.oaK[2] && motionEvent.getY() <= this.oaK[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.oaL;
            this.oaL = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.oaK = iArr;
        }
    }
}
