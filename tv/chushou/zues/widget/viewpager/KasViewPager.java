package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class KasViewPager extends ViewPager {
    private boolean oaE;
    private int[] oaF;
    private boolean oaG;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oaE = false;
        this.oaG = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.oaE) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oaE || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.oaE = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oaF != null && motionEvent.getX() >= this.oaF[0] && motionEvent.getX() <= this.oaF[1] && motionEvent.getY() >= this.oaF[2] && motionEvent.getY() <= this.oaF[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.oaG;
            this.oaG = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.oaF = iArr;
        }
    }
}
