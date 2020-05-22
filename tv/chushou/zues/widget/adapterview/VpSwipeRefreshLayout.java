package tv.chushou.zues.widget.adapterview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes5.dex */
public class VpSwipeRefreshLayout extends SwipeRefreshLayout {
    private final int mTouchSlop;
    private boolean nNR;
    private float startX;
    private float startY;

    public VpSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.startY = motionEvent.getY();
                this.startX = motionEvent.getX();
                this.nNR = false;
                break;
            case 1:
            case 3:
                this.nNR = false;
                break;
            case 2:
                if (this.nNR) {
                    return false;
                }
                float y = motionEvent.getY();
                float abs = Math.abs(motionEvent.getX() - this.startX);
                float abs2 = Math.abs(y - this.startY);
                if (abs > this.mTouchSlop && abs > abs2) {
                    this.nNR = true;
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
