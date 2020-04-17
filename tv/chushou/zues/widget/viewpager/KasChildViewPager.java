package tv.chushou.zues.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class KasChildViewPager extends ViewPager {
    private float lastX;
    private boolean nxq;
    private boolean nxr;

    public KasChildViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KasChildViewPager(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                this.lastX = motionEvent.getX();
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                this.lastX = motionEvent.getX();
                this.nxq = false;
                this.nxr = false;
                break;
            case 2:
                if (getCurrentItem() == 0) {
                    if (this.lastX <= motionEvent.getX() && !this.nxr) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    } else {
                        this.nxr = true;
                        this.lastX = motionEvent.getX();
                        getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                } else if (getCurrentItem() == getAdapter().getCount() - 1) {
                    if (this.lastX >= motionEvent.getX() && !this.nxq) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    } else {
                        this.nxq = true;
                        this.lastX = motionEvent.getX();
                        getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                }
                break;
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }
}
