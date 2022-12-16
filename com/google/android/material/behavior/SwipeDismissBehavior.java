package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    public static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    public static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public float alphaEndSwipeDistance;
    public float alphaStartSwipeDistance;
    public final ViewDragHelper.Callback dragCallback;
    public float dragDismissThreshold;
    public boolean interceptingEvents;
    public OnDismissListener listener;
    public float sensitivity;
    public boolean sensitivitySet;
    public int swipeDirection;
    public ViewDragHelper viewDragHelper;

    /* loaded from: classes7.dex */
    public interface OnDismissListener {
        void onDismiss(View view2);

        void onDragStateChanged(int i);
    }

    public static float fraction(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f3 - f) / (f2 - f) : invokeCommon.floatValue;
    }

    public boolean canSwipeDismissView(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class SettleRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean dismiss;
        public final /* synthetic */ SwipeDismissBehavior this$0;

        /* renamed from: view  reason: collision with root package name */
        public final View f1096view;

        public SettleRunnable(SwipeDismissBehavior swipeDismissBehavior, View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swipeDismissBehavior, view2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swipeDismissBehavior;
            this.f1096view = view2;
            this.dismiss = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewDragHelper viewDragHelper = this.this$0.viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    ViewCompat.postOnAnimation(this.f1096view, this);
                } else if (this.dismiss && (onDismissListener = this.this$0.listener) != null) {
                    onDismissListener.onDismiss(this.f1096view);
                }
            }
        }
    }

    public SwipeDismissBehavior() {
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
        this.sensitivity = 0.0f;
        this.swipeDirection = 2;
        this.dragDismissThreshold = 0.5f;
        this.alphaStartSwipeDistance = 0.0f;
        this.alphaEndSwipeDistance = 0.5f;
        this.dragCallback = new ViewDragHelper.Callback(this) { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
            public static /* synthetic */ Interceptable $ic = null;
            public static final int INVALID_POINTER_ID = -1;
            public transient /* synthetic */ FieldHolder $fh;
            public int activePointerId;
            public int originalCapturedViewLeft;
            public final /* synthetic */ SwipeDismissBehavior this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.activePointerId = -1;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(@NonNull View view2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
                    return view2.getWidth();
                }
                return invokeL.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i3) {
                OnDismissListener onDismissListener;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeI(1048580, this, i3) == null) && (onDismissListener = this.this$0.listener) != null) {
                    onDismissListener.onDragStateChanged(i3);
                }
            }

            private boolean shouldDismiss(@NonNull View view2, float f) {
                InterceptResult invokeLF;
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLF = interceptable2.invokeLF(65537, this, view2, f)) == null) {
                    int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                    if (i3 != 0) {
                        if (ViewCompat.getLayoutDirection(view2) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        int i4 = this.this$0.swipeDirection;
                        if (i4 == 2) {
                            return true;
                        }
                        if (i4 == 0) {
                            if (z) {
                                if (f >= 0.0f) {
                                    return false;
                                }
                            } else if (i3 <= 0) {
                                return false;
                            }
                            return true;
                        } else if (i4 != 1) {
                            return false;
                        } else {
                            if (z) {
                                if (i3 <= 0) {
                                    return false;
                                }
                            } else if (f >= 0.0f) {
                                return false;
                            }
                            return true;
                        }
                    }
                    if (Math.abs(view2.getLeft() - this.originalCapturedViewLeft) < Math.round(view2.getWidth() * this.this$0.dragDismissThreshold)) {
                        return false;
                    }
                    return true;
                }
                return invokeLF.booleanValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view2, int i3, int i4) {
                InterceptResult invokeLII;
                boolean z;
                int width;
                int width2;
                int width3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, view2, i3, i4)) == null) {
                    if (ViewCompat.getLayoutDirection(view2) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i5 = this.this$0.swipeDirection;
                    if (i5 == 0) {
                        if (z) {
                            width = this.originalCapturedViewLeft - view2.getWidth();
                            width2 = this.originalCapturedViewLeft;
                        } else {
                            width = this.originalCapturedViewLeft;
                            width3 = view2.getWidth();
                            width2 = width3 + width;
                        }
                    } else if (i5 == 1) {
                        if (z) {
                            width = this.originalCapturedViewLeft;
                            width3 = view2.getWidth();
                            width2 = width3 + width;
                        } else {
                            width = this.originalCapturedViewLeft - view2.getWidth();
                            width2 = this.originalCapturedViewLeft;
                        }
                    } else {
                        width = this.originalCapturedViewLeft - view2.getWidth();
                        width2 = view2.getWidth() + this.originalCapturedViewLeft;
                    }
                    return SwipeDismissBehavior.clamp(width, i3, width2);
                }
                return invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view2, int i3, int i4) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i3, i4)) == null) {
                    return view2.getTop();
                }
                return invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewCaptured(@NonNull View view2, int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048579, this, view2, i3) == null) {
                    this.activePointerId = i3;
                    this.originalCapturedViewLeft = view2.getLeft();
                    ViewParent parent = view2.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view2, int i3) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048583, this, view2, i3)) == null) {
                    int i4 = this.activePointerId;
                    if ((i4 == -1 || i4 == i3) && this.this$0.canSwipeDismissView(view2)) {
                        return true;
                    }
                    return false;
                }
                return invokeLI.booleanValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view2, int i3, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{view2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                    float width = this.originalCapturedViewLeft + (view2.getWidth() * this.this$0.alphaStartSwipeDistance);
                    float width2 = this.originalCapturedViewLeft + (view2.getWidth() * this.this$0.alphaEndSwipeDistance);
                    float f = i3;
                    if (f <= width) {
                        view2.setAlpha(1.0f);
                    } else if (f >= width2) {
                        view2.setAlpha(0.0f);
                    } else {
                        view2.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, f), 1.0f));
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view2, float f, float f2) {
                int i3;
                boolean z;
                OnDismissListener onDismissListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048582, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                    this.activePointerId = -1;
                    int width = view2.getWidth();
                    if (shouldDismiss(view2, f)) {
                        int left = view2.getLeft();
                        int i4 = this.originalCapturedViewLeft;
                        if (left < i4) {
                            i3 = i4 - width;
                        } else {
                            i3 = i4 + width;
                        }
                        z = true;
                    } else {
                        i3 = this.originalCapturedViewLeft;
                        z = false;
                    }
                    if (this.this$0.viewDragHelper.settleCapturedViewAt(i3, view2.getTop())) {
                        ViewCompat.postOnAnimation(view2, new SettleRunnable(this.this$0, view2, z));
                    } else if (z && (onDismissListener = this.this$0.listener) != null) {
                        onDismissListener.onDismiss(view2);
                    }
                }
            }
        };
    }

    public static float clamp(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return Math.min(Math.max(f, f2), f3);
        }
        return invokeCommon.floatValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, coordinatorLayout, v, motionEvent)) == null) {
            boolean z = this.interceptingEvents;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.interceptingEvents = false;
                }
            } else {
                z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.interceptingEvents = z;
            }
            if (!z) {
                return false;
            }
            ensureViewDragHelper(coordinatorLayout);
            return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public static int clamp(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i, i2, i3)) == null) {
            return Math.min(Math.max(i, i2), i3);
        }
        return invokeIII.intValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, coordinatorLayout, v, i)) == null) {
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i);
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
                updateAccessibilityActions(v);
            }
            return onLayoutChild;
        }
        return invokeLLI.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, coordinatorLayout, v, motionEvent)) == null) {
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(motionEvent);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        ViewDragHelper create;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, viewGroup) == null) && this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                create = ViewDragHelper.create(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                create = ViewDragHelper.create(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = create;
        }
    }

    private void updateAccessibilityActions(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, view2) == null) {
            ViewCompat.removeAccessibilityAction(view2, 1048576);
            if (canSwipeDismissView(view2)) {
                ViewCompat.replaceAccessibilityAction(view2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand(this) { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwipeDismissBehavior this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public boolean perform(@NonNull View view3, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                        InterceptResult invokeLL;
                        boolean z;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, commandArguments)) == null) {
                            boolean z2 = false;
                            if (!this.this$0.canSwipeDismissView(view3)) {
                                return false;
                            }
                            if (ViewCompat.getLayoutDirection(view3) == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if ((this.this$0.swipeDirection == 0 && z) || (this.this$0.swipeDirection == 1 && !z)) {
                                z2 = true;
                            }
                            int width = view3.getWidth();
                            if (z2) {
                                width = -width;
                            }
                            ViewCompat.offsetLeftAndRight(view3, width);
                            view3.setAlpha(0.0f);
                            OnDismissListener onDismissListener = this.this$0.listener;
                            if (onDismissListener != null) {
                                onDismissListener.onDismiss(view3);
                            }
                            return true;
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
        }
    }

    public void setDragDismissDistance(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.dragDismissThreshold = clamp(0.0f, f, 1.0f);
        }
    }

    public void setEndAlphaSwipeDistance(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.alphaEndSwipeDistance = clamp(0.0f, f, 1.0f);
        }
    }

    public void setListener(@Nullable OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onDismissListener) == null) {
            this.listener = onDismissListener;
        }
    }

    public void setSensitivity(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.sensitivity = f;
            this.sensitivitySet = true;
        }
    }

    public void setStartAlphaSwipeDistance(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.alphaStartSwipeDistance = clamp(0.0f, f, 1.0f);
        }
    }

    public void setSwipeDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.swipeDirection = i;
        }
    }

    public int getDragState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null) {
                return viewDragHelper.getViewDragState();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    @VisibleForTesting
    public OnDismissListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.listener;
        }
        return (OnDismissListener) invokeV.objValue;
    }
}
