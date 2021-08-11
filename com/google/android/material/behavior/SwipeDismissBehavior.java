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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i2);
    }

    /* loaded from: classes9.dex */
    public class SettleRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean dismiss;
        public final /* synthetic */ SwipeDismissBehavior this$0;
        public final View view;

        public SettleRunnable(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swipeDismissBehavior, view, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swipeDismissBehavior;
            this.view = view;
            this.dismiss = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ViewDragHelper viewDragHelper = this.this$0.viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    ViewCompat.postOnAnimation(this.view, this);
                } else if (!this.dismiss || (onDismissListener = this.this$0.listener) == null) {
                } else {
                    onDismissListener.onDismiss(this.view);
                }
            }
        }
    }

    public SwipeDismissBehavior() {
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.activePointerId = -1;
            }

            private boolean shouldDismiss(@NonNull View view, float f2) {
                InterceptResult invokeLF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLF = interceptable2.invokeLF(65537, this, view, f2)) == null) {
                    int i4 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i4 == 0) {
                        return Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * this.this$0.dragDismissThreshold);
                    }
                    boolean z = ViewCompat.getLayoutDirection(view) == 1;
                    int i5 = this.this$0.swipeDirection;
                    if (i5 == 2) {
                        return true;
                    }
                    if (i5 == 0) {
                        if (z) {
                            if (f2 >= 0.0f) {
                                return false;
                            }
                        } else if (i4 <= 0) {
                            return false;
                        }
                        return true;
                    } else if (i5 == 1) {
                        if (z) {
                            if (i4 <= 0) {
                                return false;
                            }
                        } else if (f2 >= 0.0f) {
                            return false;
                        }
                        return true;
                    } else {
                        return false;
                    }
                }
                return invokeLF.booleanValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i4, int i5) {
                InterceptResult invokeLII;
                int width;
                int width2;
                int width3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, view, i4, i5)) == null) {
                    boolean z = ViewCompat.getLayoutDirection(view) == 1;
                    int i6 = this.this$0.swipeDirection;
                    if (i6 == 0) {
                        if (z) {
                            width = this.originalCapturedViewLeft - view.getWidth();
                            width2 = this.originalCapturedViewLeft;
                        } else {
                            width = this.originalCapturedViewLeft;
                            width3 = view.getWidth();
                            width2 = width3 + width;
                        }
                    } else if (i6 != 1) {
                        width = this.originalCapturedViewLeft - view.getWidth();
                        width2 = view.getWidth() + this.originalCapturedViewLeft;
                    } else if (z) {
                        width = this.originalCapturedViewLeft;
                        width3 = view.getWidth();
                        width2 = width3 + width;
                    } else {
                        width = this.originalCapturedViewLeft - view.getWidth();
                        width2 = this.originalCapturedViewLeft;
                    }
                    return SwipeDismissBehavior.clamp(width, i4, width2);
                }
                return invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i4, int i5) {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLII = interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i4, i5)) == null) ? view.getTop() : invokeLII.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(@NonNull View view) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getWidth() : invokeL.intValue;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewCaptured(@NonNull View view, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048579, this, view, i4) == null) {
                    this.activePointerId = i4;
                    this.originalCapturedViewLeft = view.getLeft();
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i4) {
                OnDismissListener onDismissListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) || (onDismissListener = this.this$0.listener) == null) {
                    return;
                }
                onDismissListener.onDragStateChanged(i4);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i4, int i5, int i6, int i7) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{view, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
                    float width = this.originalCapturedViewLeft + (view.getWidth() * this.this$0.alphaStartSwipeDistance);
                    float width2 = this.originalCapturedViewLeft + (view.getWidth() * this.this$0.alphaEndSwipeDistance);
                    float f2 = i4;
                    if (f2 <= width) {
                        view.setAlpha(1.0f);
                    } else if (f2 >= width2) {
                        view.setAlpha(0.0f);
                    } else {
                        view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, f2), 1.0f));
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f2, float f3) {
                int i4;
                boolean z;
                OnDismissListener onDismissListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048582, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    this.activePointerId = -1;
                    int width = view.getWidth();
                    if (shouldDismiss(view, f2)) {
                        int left = view.getLeft();
                        int i5 = this.originalCapturedViewLeft;
                        i4 = left < i5 ? i5 - width : i5 + width;
                        z = true;
                    } else {
                        i4 = this.originalCapturedViewLeft;
                        z = false;
                    }
                    if (this.this$0.viewDragHelper.settleCapturedViewAt(i4, view.getTop())) {
                        ViewCompat.postOnAnimation(view, new SettleRunnable(this.this$0, view, z));
                    } else if (!z || (onDismissListener = this.this$0.listener) == null) {
                    } else {
                        onDismissListener.onDismiss(view);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i4) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048583, this, view, i4)) == null) {
                    int i5 = this.activePointerId;
                    return (i5 == -1 || i5 == i4) && this.this$0.canSwipeDismissView(view);
                }
                return invokeLI.booleanValue;
            }
        };
    }

    public static float clamp(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.min(Math.max(f2, f3), f4) : invokeCommon.floatValue;
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

    public static float fraction(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (f4 - f2) / (f3 - f2) : invokeCommon.floatValue;
    }

    private void updateAccessibilityActions(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view) == null) {
            ViewCompat.removeAccessibilityAction(view, 1048576);
            if (canSwipeDismissView(view)) {
                ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand(this) { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public boolean perform(@NonNull View view2, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, commandArguments)) == null) {
                            boolean z = false;
                            if (this.this$0.canSwipeDismissView(view2)) {
                                boolean z2 = ViewCompat.getLayoutDirection(view2) == 1;
                                if ((this.this$0.swipeDirection == 0 && z2) || (this.this$0.swipeDirection == 1 && !z2)) {
                                    z = true;
                                }
                                int width = view2.getWidth();
                                if (z) {
                                    width = -width;
                                }
                                ViewCompat.offsetLeftAndRight(view2, width);
                                view2.setAlpha(0.0f);
                                OnDismissListener onDismissListener = this.this$0.listener;
                                if (onDismissListener != null) {
                                    onDismissListener.onDismiss(view2);
                                }
                                return true;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
        }
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            return true;
        }
        return invokeL.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.listener : (OnDismissListener) invokeV.objValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, coordinatorLayout, v, motionEvent)) == null) {
            boolean z = this.interceptingEvents;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                this.interceptingEvents = z;
            } else if (actionMasked == 1 || actionMasked == 3) {
                this.interceptingEvents = false;
            }
            if (z) {
                ensureViewDragHelper(coordinatorLayout);
                return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, coordinatorLayout, v, i2)) == null) {
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i2);
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

    public void setDragDismissDistance(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.dragDismissThreshold = clamp(0.0f, f2, 1.0f);
        }
    }

    public void setEndAlphaSwipeDistance(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.alphaEndSwipeDistance = clamp(0.0f, f2, 1.0f);
        }
    }

    public void setListener(@Nullable OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onDismissListener) == null) {
            this.listener = onDismissListener;
        }
    }

    public void setSensitivity(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.sensitivity = f2;
            this.sensitivitySet = true;
        }
    }

    public void setStartAlphaSwipeDistance(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.alphaStartSwipeDistance = clamp(0.0f, f2, 1.0f);
        }
    }

    public void setSwipeDirection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.swipeDirection = i2;
        }
    }

    public static int clamp(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) ? Math.min(Math.max(i2, i3), i4) : invokeIII.intValue;
    }
}
