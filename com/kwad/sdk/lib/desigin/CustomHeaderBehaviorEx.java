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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior;
@Keep
/* loaded from: classes5.dex */
public final class CustomHeaderBehaviorEx<V extends KSAppBarLayout, B extends KSAppBarLayout.KSBehavior & CustomAppBarFlingConsumer> extends KSViewOffsetBehavior<V> {
    private static final int FLING_MAX_VELOCITY = 10000;
    private static final int INVALID_POINTER = -1;
    private static final String TAG = CustomHeaderBehaviorEx.class.toString();
    private int mActivePointerId;
    private B mBehavior;
    private boolean mEnabled;
    private int mExtraFixedSize;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    private OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class FlingRunnable implements Runnable {
        private int mLastScrollY;
        private final V mLayout;
        private final KSCoordinatorLayout mParent;

        FlingRunnable(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
            this.mLastScrollY = i;
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
            int i = currY - this.mLastScrollY;
            int bottom = this.mLayout.getBottom();
            int measuredHeight = (this.mLayout.getMeasuredHeight() - this.mLayout.getTotalScrollRange()) + CustomHeaderBehaviorEx.this.mExtraFixedSize;
            if (bottom == measuredHeight) {
                ((CustomAppBarFlingConsumer) CustomHeaderBehaviorEx.this.mBehavior).consumeAppBarFling(0, -i);
            } else if (bottom <= 0 || bottom + i >= measuredHeight) {
                CustomHeaderBehaviorEx.this.mBehavior.setHeaderTopBottomOffset(this.mParent, this.mLayout, i + this.mLayout.getTop());
            } else {
                CustomHeaderBehaviorEx.this.mBehavior.setHeaderTopBottomOffset(this.mParent, this.mLayout, (this.mLayout.getTop() - bottom) + measuredHeight);
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

    private boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, float f) {
        if (this.mFlingRunnable != null) {
            v.removeCallbacks(this.mFlingRunnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.mScroller.computeScrollOffset()) {
            ((B) this.mBehavior).onFlingFinished(kSCoordinatorLayout, (KSAppBarLayout) v);
            return false;
        }
        this.mFlingRunnable = new FlingRunnable(kSCoordinatorLayout, v, this.mScroller.getCurrY());
        ViewCompat.postOnAnimation(v, this.mFlingRunnable);
        return true;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.lib.desigin.CustomHeaderBehaviorEx<V extends com.kwad.sdk.lib.desigin.KSAppBarLayout, B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, View view, MotionEvent motionEvent) {
        return onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) ((KSAppBarLayout) view), motionEvent);
    }

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
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mIsBeingDragged = false;
                stopFling();
                if (((B) this.mBehavior).canDragView((KSAppBarLayout) v) && kSCoordinatorLayout.isPointInChildBounds(v, x, y)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    this.mBehavior.onAppBarTouchDown();
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.lib.desigin.CustomHeaderBehaviorEx<V extends com.kwad.sdk.lib.desigin.KSAppBarLayout, B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, View view, MotionEvent motionEvent) {
        return onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) ((KSAppBarLayout) view), motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (kSCoordinatorLayout.isPointInChildBounds(v, x, y) && ((B) this.mBehavior).canDragView((KSAppBarLayout) v)) {
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
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    fling(kSCoordinatorLayout, v, yVelocity < 0.0f ? DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER : 0, yVelocity < 0.0f ? 0 : -v.getTop(), yVelocity);
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
                if (findPointerIndex != -1) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    int i = this.mLastMotionY - y2;
                    if (!this.mIsBeingDragged && Math.abs(i) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        i = i > 0 ? i - this.mTouchSlop : i + this.mTouchSlop;
                    }
                    if (this.mIsBeingDragged) {
                        this.mLastMotionY = y2;
                        ((B) this.mBehavior).scroll(kSCoordinatorLayout, v, i, ((B) this.mBehavior).getMaxDragOffset((KSAppBarLayout) v), 0);
                        break;
                    }
                } else {
                    return false;
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

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setExtraFixedSize(int i) {
        this.mExtraFixedSize = i;
    }

    public void stopFling() {
        if (this.mFlingRunnable == null || this.mScroller == null || !this.mScroller.computeScrollOffset()) {
            return;
        }
        this.mScroller.abortAnimation();
    }
}
