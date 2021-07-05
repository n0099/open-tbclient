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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public abstract class KSHeaderBehavior<V extends View> extends KSViewOffsetBehavior<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POINTER = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivePointerId;
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
        public final V mLayout;
        public final KSCoordinatorLayout mParent;
        public final /* synthetic */ KSHeaderBehavior this$0;

        public FlingRunnable(KSHeaderBehavior kSHeaderBehavior, KSCoordinatorLayout kSCoordinatorLayout, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kSHeaderBehavior, kSCoordinatorLayout, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kSHeaderBehavior;
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mLayout == null || (overScroller = this.this$0.mScroller) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                this.this$0.onFlingFinished(this.mParent, this.mLayout);
                return;
            }
            KSHeaderBehavior kSHeaderBehavior = this.this$0;
            kSHeaderBehavior.setHeaderTopBottomOffset(this.mParent, this.mLayout, kSHeaderBehavior.mScroller.getCurrY());
            ViewCompat.postOnAnimation(this.mLayout, this);
        }
    }

    public KSHeaderBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSHeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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
    }

    private void ensureVelocityTracker() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    public boolean canDragView(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{kSCoordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
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
                onFlingFinished(kSCoordinatorLayout, v);
                return false;
            }
            FlingRunnable flingRunnable = new FlingRunnable(this, kSCoordinatorLayout, v);
            this.mFlingRunnable = flingRunnable;
            ViewCompat.postOnAnimation(v, flingRunnable);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public int getMaxDragOffset(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) ? -v.getHeight() : invokeL.intValue;
    }

    public int getScrollRangeForDragFling(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) ? v.getHeight() : invokeL.intValue;
    }

    public int getTopBottomOffsetForScrollingSibling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getTopAndBottomOffset() : invokeV.intValue;
    }

    public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, kSCoordinatorLayout, v) == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r0 != 3) goto L19;
     */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, kSCoordinatorLayout, v, motionEvent)) == null) {
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
                        int i2 = this.mActivePointerId;
                        if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
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
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, kSCoordinatorLayout, v, motionEvent)) == null) {
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
                    int i2 = this.mLastMotionY - y;
                    if (!this.mIsBeingDragged) {
                        int abs = Math.abs(i2);
                        int i3 = this.mTouchSlop;
                        if (abs > i3) {
                            this.mIsBeingDragged = true;
                            i2 = i2 > 0 ? i2 - i3 : i2 + i3;
                        }
                    }
                    int i4 = i2;
                    if (this.mIsBeingDragged) {
                        this.mLastMotionY = y;
                        scroll(kSCoordinatorLayout, v, i4, getMaxDragOffset(v), 0);
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
        return invokeLLL.booleanValue;
    }

    public final int scroll(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{kSCoordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? setHeaderTopBottomOffset(kSCoordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i2, i3, i4) : invokeCommon.intValue;
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, kSCoordinatorLayout, v, i2)) == null) ? setHeaderTopBottomOffset(kSCoordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE) : invokeLLI.intValue;
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int clamp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{kSCoordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if (i3 == 0 || topAndBottomOffset < i3 || topAndBottomOffset > i4 || topAndBottomOffset == (clamp = MathUtils.clamp(i2, i3, i4))) {
                return 0;
            }
            setTopAndBottomOffset(clamp);
            return topAndBottomOffset - clamp;
        }
        return invokeCommon.intValue;
    }
}
