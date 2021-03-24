package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
@Keep
/* loaded from: classes6.dex */
public abstract class KSHeaderBehavior<V extends View> extends KSViewOffsetBehavior<V> {
    public static final int INVALID_POINTER = -1;
    public int mActivePointerId;
    public Runnable mFlingRunnable;
    public boolean mIsBeingDragged;
    public int mLastMotionY;
    public OverScroller mScroller;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;

    /* loaded from: classes6.dex */
    public class FlingRunnable implements Runnable {
        public final V mLayout;
        public final KSCoordinatorLayout mParent;

        public FlingRunnable(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.mLayout == null || (overScroller = KSHeaderBehavior.this.mScroller) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                KSHeaderBehavior.this.onFlingFinished(this.mParent, this.mLayout);
                return;
            }
            KSHeaderBehavior kSHeaderBehavior = KSHeaderBehavior.this;
            kSHeaderBehavior.setHeaderTopBottomOffset(this.mParent, this.mLayout, kSHeaderBehavior.mScroller.getCurrY());
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

    public boolean canDragView(V v) {
        return false;
    }

    public final boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, float f2) {
        Runnable runnable = this.mFlingRunnable;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f2), 0, 0, i, i2);
        if (!this.mScroller.computeScrollOffset()) {
            onFlingFinished(kSCoordinatorLayout, v);
            return false;
        }
        FlingRunnable flingRunnable = new FlingRunnable(kSCoordinatorLayout, v);
        this.mFlingRunnable = flingRunnable;
        ViewCompat.postOnAnimation(v, flingRunnable);
        return true;
    }

    public int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    public int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, V v) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mActivePointerId;
                    if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y - this.mLastMotionY) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = y;
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        } else {
            this.mIsBeingDragged = false;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (canDragView(v) && kSCoordinatorLayout.isPointInChildBounds(v, x, y2)) {
                this.mLastMotionY = y2;
                this.mActivePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
            }
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    fling(kSCoordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.mVelocityTracker.getYVelocity(this.mActivePointerId));
                }
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                int i = this.mLastMotionY - y;
                if (!this.mIsBeingDragged) {
                    int abs = Math.abs(i);
                    int i2 = this.mTouchSlop;
                    if (abs > i2) {
                        this.mIsBeingDragged = true;
                        i = i > 0 ? i - i2 : i + i2;
                    }
                }
                int i3 = i;
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = y;
                    scroll(kSCoordinatorLayout, v, i3, getMaxDragOffset(v), 0);
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
        } else {
            int y2 = (int) motionEvent.getY();
            if (!kSCoordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), y2) || !canDragView(v)) {
                return false;
            }
            this.mLastMotionY = y2;
            this.mActivePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
        }
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    public final int scroll(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (clamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }
}
