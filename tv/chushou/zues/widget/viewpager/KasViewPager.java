package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class KasViewPager extends ViewPager {
    private boolean qtc;
    private int[] qtd;
    private boolean qte;

    public KasViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qtc = false;
        this.qte = false;
    }

    public KasViewPager(Context context) {
        this(context, null);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.qtc) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.qtc || super.onTouchEvent(motionEvent);
    }

    public void setNoFocus(boolean z) {
        this.qtc = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.qtd != null && motionEvent.getX() >= this.qtd[0] && motionEvent.getX() <= this.qtd[1] && motionEvent.getY() >= this.qtd[2] && motionEvent.getY() <= this.qtd[3]) {
            super.dispatchTouchEvent(motionEvent);
            boolean z = this.qte;
            this.qte = false;
            return z;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setSurfaceLoc(int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            this.qtd = iArr;
        }
    }
}
