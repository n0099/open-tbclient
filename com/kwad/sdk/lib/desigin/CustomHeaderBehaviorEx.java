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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior;
@Keep
/* loaded from: classes7.dex */
public final class CustomHeaderBehaviorEx<V extends KSAppBarLayout, B extends KSAppBarLayout.KSBehavior & CustomAppBarFlingConsumer> extends KSViewOffsetBehavior<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLING_MAX_VELOCITY = 10000;
    public static final int INVALID_POINTER = -1;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mLastScrollY;
        public final V mLayout;
        public final KSCoordinatorLayout mParent;
        public final /* synthetic */ CustomHeaderBehaviorEx this$0;

        public FlingRunnable(CustomHeaderBehaviorEx customHeaderBehaviorEx, KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customHeaderBehaviorEx, kSCoordinatorLayout, v, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = customHeaderBehaviorEx;
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
            this.mLastScrollY = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mLayout == null || this.this$0.mScroller == null) {
                return;
            }
            if (!this.this$0.mScroller.computeScrollOffset()) {
                this.this$0.mBehavior.onFlingFinished(this.mParent, (KSAppBarLayout) this.mLayout);
                return;
            }
            int currY = this.this$0.mScroller.getCurrY();
            int i2 = currY - this.mLastScrollY;
            int bottom = this.mLayout.getBottom();
            int measuredHeight = (this.mLayout.getMeasuredHeight() - this.mLayout.getTotalScrollRange()) + this.this$0.mExtraFixedSize;
            if (bottom == measuredHeight) {
                ((CustomAppBarFlingConsumer) this.this$0.mBehavior).consumeAppBarFling(0, -i2);
            } else if (bottom <= 0 || bottom + i2 >= measuredHeight) {
                KSAppBarLayout.KSBehavior kSBehavior = this.this$0.mBehavior;
                KSCoordinatorLayout kSCoordinatorLayout = this.mParent;
                V v = this.mLayout;
                kSBehavior.setHeaderTopBottomOffset(kSCoordinatorLayout, v, v.getTop() + i2);
            } else {
                KSAppBarLayout.KSBehavior kSBehavior2 = this.this$0.mBehavior;
                KSCoordinatorLayout kSCoordinatorLayout2 = this.mParent;
                V v2 = this.mLayout;
                kSBehavior2.setHeaderTopBottomOffset(kSCoordinatorLayout2, v2, (v2.getTop() - bottom) + measuredHeight);
            }
            ViewCompat.postOnAnimation(this.mLayout, this);
            this.mLastScrollY = currY;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-993517735, "Lcom/kwad/sdk/lib/desigin/CustomHeaderBehaviorEx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-993517735, "Lcom/kwad/sdk/lib/desigin/CustomHeaderBehaviorEx;");
                return;
            }
        }
        TAG = CustomHeaderBehaviorEx.class.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHeaderBehaviorEx(Context context, AttributeSet attributeSet, B b2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, b2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b2;
    }

    public CustomHeaderBehaviorEx(B b2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b2;
    }

    private void ensureVelocityTracker() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{kSCoordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
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
            FlingRunnable flingRunnable = new FlingRunnable(this, kSCoordinatorLayout, v, this.mScroller.getCurrY());
            this.mFlingRunnable = flingRunnable;
            ViewCompat.postOnAnimation(v, flingRunnable);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mEnabled : invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.lib.desigin.CustomHeaderBehaviorEx<V extends com.kwad.sdk.lib.desigin.KSAppBarLayout, B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, View view, MotionEvent motionEvent) {
        return onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) ((KSAppBarLayout) view), motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r4 != 3) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, kSCoordinatorLayout, v, motionEvent)) == null) {
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
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.kwad.sdk.lib.desigin.CustomHeaderBehaviorEx<V extends com.kwad.sdk.lib.desigin.KSAppBarLayout, B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, View view, MotionEvent motionEvent) {
        return onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) ((KSAppBarLayout) view), motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r2 != 3) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, kSCoordinatorLayout, v, motionEvent)) == null) {
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
        return invokeLLL.booleanValue;
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mEnabled = z;
        }
    }

    public void setExtraFixedSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mExtraFixedSize = i2;
        }
    }

    public void stopFling() {
        OverScroller overScroller;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.mFlingRunnable == null || (overScroller = this.mScroller) == null || !overScroller.computeScrollOffset()) {
            return;
        }
        this.mScroller.abortAnimation();
    }
}
