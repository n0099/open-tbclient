package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POINTER = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public int activePointerId;
    @Nullable
    public Runnable flingRunnable;
    public boolean isBeingDragged;
    public int lastMotionY;
    public OverScroller scroller;
    public int touchSlop;
    @Nullable
    public VelocityTracker velocityTracker;

    public boolean canDragView(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onFlingFinished(CoordinatorLayout coordinatorLayout, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, coordinatorLayout, v) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class FlingRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final V layout;
        public final CoordinatorLayout parent;
        public final /* synthetic */ HeaderBehavior this$0;

        public FlingRunnable(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headerBehavior, coordinatorLayout, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = headerBehavior;
            this.parent = coordinatorLayout;
            this.layout = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.layout != null && (overScroller = this.this$0.scroller) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = this.this$0;
                    headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
                    ViewCompat.postOnAnimation(this.layout, this);
                    return;
                }
                this.this$0.onFlingFinished(this.parent, this.layout);
            }
        }
    }

    public HeaderBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    private void ensureVelocityTracker() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    public int getTopBottomOffsetForScrollingSibling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getTopAndBottomOffset();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public final boolean fling(CoordinatorLayout coordinatorLayout, @NonNull V v, int i, int i2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) {
            Runnable runnable = this.flingRunnable;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.flingRunnable = null;
            }
            if (this.scroller == null) {
                this.scroller = new OverScroller(v.getContext());
            }
            this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
            if (this.scroller.computeScrollOffset()) {
                FlingRunnable flingRunnable = new FlingRunnable(this, coordinatorLayout, v);
                this.flingRunnable = flingRunnable;
                ViewCompat.postOnAnimation(v, flingRunnable);
                return true;
            }
            onFlingFinished(coordinatorLayout, v);
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public int getMaxDragOffset(@NonNull V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v)) == null) {
            return -v.getHeight();
        }
        return invokeL.intValue;
    }

    public int getScrollRangeForDragFling(@NonNull V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) {
            return v.getHeight();
        }
        return invokeL.intValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        boolean z;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, coordinatorLayout, v, motionEvent)) == null) {
            if (this.touchSlop < 0) {
                this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
                int i = this.activePointerId;
                if (i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                if (Math.abs(y - this.lastMotionY) > this.touchSlop) {
                    this.lastMotionY = y;
                    return true;
                }
            }
            if (motionEvent.getActionMasked() == 0) {
                this.activePointerId = -1;
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y2)) {
                    z = true;
                } else {
                    z = false;
                }
                this.isBeingDragged = z;
                if (z) {
                    this.lastMotionY = y2;
                    this.activePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    OverScroller overScroller = this.scroller;
                    if (overScroller != null && !overScroller.isFinished()) {
                        this.scroller.abortAnimation();
                        return true;
                    }
                }
            }
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, coordinatorLayout, v, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            if (motionEvent.getActionIndex() == 0) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            this.activePointerId = motionEvent.getPointerId(i);
                            this.lastMotionY = (int) (motionEvent.getY(i) + 0.5f);
                        }
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    this.lastMotionY = y;
                    scroll(coordinatorLayout, v, this.lastMotionY - y, getMaxDragOffset(v), 0);
                }
                z = false;
                velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
                if (!this.isBeingDragged && !z) {
                    return false;
                }
            }
            VelocityTracker velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.velocityTracker.computeCurrentVelocity(1000);
                fling(coordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.velocityTracker.getYVelocity(this.activePointerId));
                z = true;
                this.isBeingDragged = false;
                this.activePointerId = -1;
                velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.velocityTracker = null;
                }
                velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                }
                return !this.isBeingDragged ? true : true;
            }
            z = false;
            this.isBeingDragged = false;
            this.activePointerId = -1;
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
            }
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
            }
            if (!this.isBeingDragged) {
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    public final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
        }
        return invokeCommon.intValue;
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, coordinatorLayout, v, i)) == null) {
            return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return invokeLLI.intValue;
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int clamp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if (i2 != 0 && topAndBottomOffset >= i2 && topAndBottomOffset <= i3 && topAndBottomOffset != (clamp = MathUtils.clamp(i, i2, i3))) {
                setTopAndBottomOffset(clamp);
                return topAndBottomOffset - clamp;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }
}
