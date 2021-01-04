package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.Keep;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
@Keep
/* loaded from: classes5.dex */
public abstract class KSHeaderBehavior<V extends View> extends KSViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class FlingRunnable implements Runnable {
        private final V mLayout;
        private final KSCoordinatorLayout mParent;

        FlingRunnable(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLayout == null || KSHeaderBehavior.this.mScroller == null) {
                return;
            }
            if (!KSHeaderBehavior.this.mScroller.computeScrollOffset()) {
                KSHeaderBehavior.this.onFlingFinished(this.mParent, this.mLayout);
                return;
            }
            KSHeaderBehavior.this.setHeaderTopBottomOffset(this.mParent, this.mLayout, KSHeaderBehavior.this.mScroller.getCurrY());
            ViewCompat.postOnAnimation(this.mLayout, this);
        }
    }

    public KSHeaderBehavior() {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    public KSHeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    boolean canDragView(V v) {
        return false;
    }

    final boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, float f) {
        if (this.mFlingRunnable != null) {
            v.removeCallbacks(this.mFlingRunnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.mScroller.computeScrollOffset()) {
            onFlingFinished(kSCoordinatorLayout, v);
            return false;
        }
        this.mFlingRunnable = new FlingRunnable(kSCoordinatorLayout, v);
        ViewCompat.postOnAnimation(v, this.mFlingRunnable);
        return true;
    }

    public int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, V v) {
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mIsBeingDragged = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (canDragView(v) && kSCoordinatorLayout.isPointInChildBounds(v, x, y)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    break;
                }
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y2;
                        break;
                    }
                }
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                int y = (int) motionEvent.getY();
                if (kSCoordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), y) && canDragView(v)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    break;
                } else {
                    return false;
                }
                break;
            case 1:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    fling(kSCoordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.mVelocityTracker.getYVelocity(this.mActivePointerId));
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(findPointerIndex);
                int i = this.mLastMotionY - y2;
                if (!this.mIsBeingDragged && Math.abs(i) > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                    i = i > 0 ? i - this.mTouchSlop : i + this.mTouchSlop;
                }
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = y2;
                    scroll(kSCoordinatorLayout, v, i, getMaxDragOffset(v), 0);
                    break;
                }
                break;
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                }
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return true;
    }

    public final int scroll(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, i, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (clamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }
}
