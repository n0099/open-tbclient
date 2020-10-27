package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class GiftViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f4273a;
    private int b;

    public GiftViewPager(Context context) {
        super(context);
    }

    public GiftViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f4273a = (int) motionEvent.getX();
                this.b = (int) motionEvent.getY();
                break;
            case 2:
                int x = (int) motionEvent.getX();
                if (Math.abs(x - this.f4273a) > Math.abs(((int) motionEvent.getY()) - this.b) && ((x > this.f4273a && getCurrentItem() == 0) || (x < this.f4273a && getCurrentItem() == getAdapter().getCount() - 1))) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f4273a = (int) motionEvent.getX();
                this.b = (int) motionEvent.getY();
                break;
            case 2:
                int x = (int) motionEvent.getX();
                if (Math.abs(x - this.f4273a) > Math.abs(((int) motionEvent.getY()) - this.b)) {
                    if (x > this.f4273a) {
                        if (getCurrentItem() == 0) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return false;
                        }
                    } else if (getCurrentItem() == getAdapter().getCount() - 1) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        getParent().requestDisallowInterceptTouchEvent(onTouchEvent);
        return onTouchEvent;
    }
}
