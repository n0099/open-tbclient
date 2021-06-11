package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior;
@Keep
/* loaded from: classes7.dex */
public final class CustomHeaderBehaviorEx<V extends KSAppBarLayout, B extends KSAppBarLayout.KSBehavior & CustomAppBarFlingConsumer> extends KSViewOffsetBehavior<V> {
    public static final int FLING_MAX_VELOCITY = 10000;
    public static final int INVALID_POINTER = -1;
    public static final String TAG = CustomHeaderBehaviorEx.class.toString();
    public int mActivePointerId;
    public B mBehavior;
    public boolean mEnabled;
    public int mExtraFixedSize;
    public Runnable mFlingRunnable;
    public boolean mIsBeingDragged;
    public int mLastMotionY;
    public OverScroller mScroller;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;

    /* loaded from: classes7.dex */
    public class FlingRunnable implements Runnable {
        public int mLastScrollY;
        public final V mLayout;
        public final KSCoordinatorLayout mParent;

        public FlingRunnable(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
            this.mLastScrollY = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLayout == null || CustomHeaderBehaviorEx.this.mScroller == null) {
                return;
            }
            if (!CustomHeaderBehaviorEx.this.mScroller.computeScrollOffset()) {
                CustomHeaderBehaviorEx.this.mBehavior.onFlingFinished(this.mParent, (KSAppBarLayout) this.mLayout);
                return;
            }
            int currY = CustomHeaderBehaviorEx.this.mScroller.getCurrY();
            int i2 = currY - this.mLastScrollY;
            int bottom = this.mLayout.getBottom();
            int measuredHeight = (this.mLayout.getMeasuredHeight() - this.mLayout.getTotalScrollRange()) + CustomHeaderBehaviorEx.this.mExtraFixedSize;
            if (bottom == measuredHeight) {
                ((CustomAppBarFlingConsumer) CustomHeaderBehaviorEx.this.mBehavior).consumeAppBarFling(0, -i2);
            } else if (bottom <= 0 || bottom + i2 >= measuredHeight) {
                KSAppBarLayout.KSBehavior kSBehavior = CustomHeaderBehaviorEx.this.mBehavior;
                KSCoordinatorLayout kSCoordinatorLayout = this.mParent;
                V v = this.mLayout;
                kSBehavior.setHeaderTopBottomOffset(kSCoordinatorLayout, v, v.getTop() + i2);
            } else {
                KSAppBarLayout.KSBehavior kSBehavior2 = CustomHeaderBehaviorEx.this.mBehavior;
                KSCoordinatorLayout kSCoordinatorLayout2 = this.mParent;
                V v2 = this.mLayout;
                kSBehavior2.setHeaderTopBottomOffset(kSCoordinatorLayout2, v2, (v2.getTop() - bottom) + measuredHeight);
            }
            ViewCompat.postOnAnimation(this.mLayout, this);
            this.mLastScrollY = currY;
        }
    }

    public CustomHeaderBehaviorEx(Context context, AttributeSet attributeSet, B b2) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b2;
    }

    public CustomHeaderBehaviorEx(B b2) {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b2;
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2, int i3, float f2) {
        Runnable runnable = this.mFlingRunnable;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f2), 0, 0, i2, i3);
        if (!this.mScroller.computeScrollOffset()) {
            ((B) this.mBehavior).onFlingFinished(kSCoordinatorLayout, (KSAppBarLayout) v);
            return false;
        }
        FlingRunnable flingRunnable = new FlingRunnable(kSCoordinatorLayout, v, this.mScroller.getCurrY());
        this.mFlingRunnable = flingRunnable;
        ViewCompat.postOnAnimation(v, flingRunnable);
        return true;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.lib.desigin.CustomHeaderBehaviorEx<V extends com.kwad.sdk.lib.desigin.KSAppBarLayout, B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, View view, MotionEvent motionEvent) {
        return onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) ((KSAppBarLayout) view), motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r4 != 3) goto L17;
     */
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
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.mActivePointerId;
                    if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                        int y2 = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = y2;
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
            stopFling();
            if (((B) this.mBehavior).canDragView((KSAppBarLayout) v) && kSCoordinatorLayout.isPointInChildBounds(v, x, y)) {
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                this.mBehavior.onAppBarTouchDown();
            }
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.lib.desigin.CustomHeaderBehaviorEx<V extends com.kwad.sdk.lib.desigin.KSAppBarLayout, B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, View view, MotionEvent motionEvent) {
        return onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) ((KSAppBarLayout) view), motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r2 != 3) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    int i2 = (yVelocity > 0.0f ? 1 : (yVelocity == 0.0f ? 0 : -1));
                    fling(kSCoordinatorLayout, v, i2 < 0 ? -10000 : 0, i2 < 0 ? 0 : -v.getTop(), yVelocity);
                }
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(findPointerIndex);
                int i3 = this.mLastMotionY - y2;
                if (!this.mIsBeingDragged) {
                    int abs = Math.abs(i3);
                    int i4 = this.mTouchSlop;
                    if (abs > i4) {
                        this.mIsBeingDragged = true;
                        i3 = i3 > 0 ? i3 - i4 : i3 + i4;
                    }
                }
                int i5 = i3;
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = y2;
                    KSAppBarLayout.KSBehavior kSBehavior = (B) this.mBehavior;
                    kSBehavior.scroll(kSCoordinatorLayout, v, i5, kSBehavior.getMaxDragOffset((KSAppBarLayout) v), 0);
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
        } else if (!kSCoordinatorLayout.isPointInChildBounds(v, x, y) || !((B) this.mBehavior).canDragView((KSAppBarLayout) v)) {
            return false;
        } else {
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
        }
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setExtraFixedSize(int i2) {
        this.mExtraFixedSize = i2;
    }

    public void stopFling() {
        OverScroller overScroller;
        if (this.mFlingRunnable == null || (overScroller = this.mScroller) == null || !overScroller.computeScrollOffset()) {
            return;
        }
        this.mScroller.abortAnimation();
    }
}
