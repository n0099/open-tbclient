package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEF_STYLE_RES;
    public static final int INVALID_SCROLL_RANGE = -1;
    public static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    public static final int PENDING_ACTION_COLLAPSED = 2;
    public static final int PENDING_ACTION_EXPANDED = 1;
    public static final int PENDING_ACTION_FORCE = 8;
    public static final int PENDING_ACTION_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentOffset;
    public int downPreScrollRange;
    public int downScrollRange;
    @Nullable
    public ValueAnimator elevationOverlayAnimator;
    public boolean haveChildWithInterpolator;
    @Nullable
    public WindowInsetsCompat lastInsets;
    public boolean liftOnScroll;
    @Nullable
    public WeakReference<View> liftOnScrollTargetView;
    @IdRes
    public int liftOnScrollTargetViewId;
    public boolean liftable;
    public boolean liftableOverride;
    public boolean lifted;
    public List<BaseOnOffsetChangedListener> listeners;
    public int pendingAction;
    @Nullable
    public Drawable statusBarForeground;
    public int[] tmpStatesArray;
    public int totalScrollRange;

    /* loaded from: classes9.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_POSITION = -1;
        public static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public WeakReference<View> lastNestedScrollingChildRef;
        public int lastStartedType;
        public ValueAnimator offsetAnimator;
        public int offsetDelta;
        public int offsetToChildIndexOnLayout;
        public boolean offsetToChildIndexOnLayoutIsMinHeight;
        public float offsetToChildIndexOnLayoutPerc;
        public BaseDragCallback onDragCallback;

        /* loaded from: classes9.dex */
        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public BaseDragCallback() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public abstract boolean canDrag(@NonNull T t);
        }

        public BaseBehavior() {
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
            this.offsetToChildIndexOnLayout = -1;
        }

        private void addAccessibilityScrollActions(CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, this, coordinatorLayout, t, view) == null) {
                if (getTopBottomOffsetForScrollingSibling() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                    addActionToExpand(coordinatorLayout, t, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
                }
                if (getTopBottomOffsetForScrollingSibling() != 0) {
                    if (view.canScrollVertically(-1)) {
                        int i2 = -t.getDownNestedPreScrollRange();
                        if (i2 != 0) {
                            ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AccessibilityViewCommand(this, coordinatorLayout, t, view, i2) { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ BaseBehavior this$0;
                                public final /* synthetic */ AppBarLayout val$appBarLayout;
                                public final /* synthetic */ CoordinatorLayout val$coordinatorLayout;
                                public final /* synthetic */ int val$dy;
                                public final /* synthetic */ View val$scrollingView;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, coordinatorLayout, t, view, Integer.valueOf(i2)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$coordinatorLayout = coordinatorLayout;
                                    this.val$appBarLayout = t;
                                    this.val$scrollingView = view;
                                    this.val$dy = i2;
                                }

                                /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior */
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                                public boolean perform(@NonNull View view2, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                                    InterceptResult invokeLL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, commandArguments)) == null) {
                                        this.this$0.onNestedPreScroll(this.val$coordinatorLayout, (CoordinatorLayout) this.val$appBarLayout, this.val$scrollingView, 0, this.val$dy, new int[]{0, 0}, 1);
                                        return true;
                                    }
                                    return invokeLL.booleanValue;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    addActionToExpand(coordinatorLayout, t, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
                }
            }
        }

        private void addActionToExpand(CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{coordinatorLayout, t, accessibilityActionCompat, Boolean.valueOf(z)}) == null) {
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new AccessibilityViewCommand(this, t, z) { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaseBehavior this$0;
                    public final /* synthetic */ AppBarLayout val$appBarLayout;
                    public final /* synthetic */ boolean val$expand;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, t, Boolean.valueOf(z)};
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
                        this.val$appBarLayout = t;
                        this.val$expand = z;
                    }

                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, commandArguments)) == null) {
                            this.val$appBarLayout.setExpanded(this.val$expand);
                            return true;
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, float f2) {
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
                int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i2);
                float abs2 = Math.abs(f2);
                if (abs2 > 0.0f) {
                    height = Math.round((abs / abs2) * 1000.0f) * 3;
                } else {
                    height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
                }
                animateOffsetWithDuration(coordinatorLayout, t, i2, height);
            }
        }

        private void animateOffsetWithDuration(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(AdIconUtil.BAIDU_LOGO_ID, this, coordinatorLayout, t, i2, i3) == null) {
                int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
                if (topBottomOffsetForScrollingSibling == i2) {
                    ValueAnimator valueAnimator = this.offsetAnimator;
                    if (valueAnimator == null || !valueAnimator.isRunning()) {
                        return;
                    }
                    this.offsetAnimator.cancel();
                    return;
                }
                ValueAnimator valueAnimator2 = this.offsetAnimator;
                if (valueAnimator2 == null) {
                    ValueAnimator valueAnimator3 = new ValueAnimator();
                    this.offsetAnimator = valueAnimator3;
                    valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                    this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, coordinatorLayout, t) { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseBehavior this$0;
                        public final /* synthetic */ AppBarLayout val$child;
                        public final /* synthetic */ CoordinatorLayout val$coordinatorLayout;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, coordinatorLayout, t};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$coordinatorLayout = coordinatorLayout;
                            this.val$child = t;
                        }

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator4) == null) {
                                this.this$0.setHeaderTopBottomOffset(this.val$coordinatorLayout, this.val$child, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                            }
                        }
                    });
                } else {
                    valueAnimator2.cancel();
                }
                this.offsetAnimator.setDuration(Math.min(i3, 600));
                this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i2);
                this.offsetAnimator.start();
            }
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, coordinatorLayout, t, view)) == null) ? t.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight() : invokeLLL.booleanValue;
        }

        public static boolean checkFlag(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i2, i3)) == null) ? (i2 & i3) == i3 : invokeII.booleanValue;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, coordinatorLayout)) == null) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                        return childAt;
                    }
                }
                return null;
            }
            return (View) invokeL.objValue;
        }

        @Nullable
        public static View getAppBarChildOnOffset(@NonNull AppBarLayout appBarLayout, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, appBarLayout, i2)) == null) {
                int abs = Math.abs(i2);
                int childCount = appBarLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = appBarLayout.getChildAt(i3);
                    if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                        return childAt;
                    }
                }
                return null;
            }
            return (View) invokeLI.objValue;
        }

        private int getChildIndexOnOffset(@NonNull T t, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, this, t, i2)) == null) {
                int childCount = t.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = t.getChildAt(i3);
                    int top = childAt.getTop();
                    int bottom = childAt.getBottom();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (checkFlag(layoutParams.getScrollFlags(), 32)) {
                        top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    int i4 = -i2;
                    if (top <= i4 && bottom >= i4) {
                        return i3;
                    }
                }
                return -1;
            }
            return invokeLI.intValue;
        }

        private int interpolateOffset(@NonNull T t, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, this, t, i2)) == null) {
                int abs = Math.abs(i2);
                int childCount = t.getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    View childAt = t.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i4++;
                    } else if (scrollInterpolator != null) {
                        int scrollFlags = layoutParams.getScrollFlags();
                        if ((scrollFlags & 1) != 0) {
                            i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((scrollFlags & 2) != 0) {
                                i3 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i3 -= t.getTopInset();
                        }
                        if (i3 > 0) {
                            float f2 = i3;
                            return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * scrollInterpolator.getInterpolation((abs - childAt.getTop()) / f2)));
                        }
                    }
                }
                return i2;
            }
            return invokeLI.intValue;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, coordinatorLayout, t)) == null) {
                List<View> dependents = coordinatorLayout.getDependents(t);
                int size = dependents.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i2).getLayoutParams()).getBehavior();
                    if (behavior instanceof ScrollingViewBehavior) {
                        return ((ScrollingViewBehavior) behavior).getOverlayTop() != 0;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            int topBottomOffsetForScrollingSibling;
            int childIndexOnOffset;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65550, this, coordinatorLayout, t) == null) || (childIndexOnOffset = getChildIndexOnOffset(t, (topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling()))) < 0) {
                return;
            }
            View childAt = t.getChildAt(childIndexOnOffset);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int scrollFlags = layoutParams.getScrollFlags();
            if ((scrollFlags & 17) == 17) {
                int i2 = -childAt.getTop();
                int i3 = -childAt.getBottom();
                if (childIndexOnOffset == t.getChildCount() - 1) {
                    i3 += t.getTopInset();
                }
                if (checkFlag(scrollFlags, 2)) {
                    i3 += ViewCompat.getMinimumHeight(childAt);
                } else if (checkFlag(scrollFlags, 5)) {
                    int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i3;
                    if (topBottomOffsetForScrollingSibling < minimumHeight) {
                        i2 = minimumHeight;
                    } else {
                        i3 = minimumHeight;
                    }
                }
                if (checkFlag(scrollFlags, 32)) {
                    i2 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    i3 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                if (topBottomOffsetForScrollingSibling < (i3 + i2) / 2) {
                    i2 = i3;
                }
                animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(i2, -t.getTotalScrollRange(), 0), 0.0f);
            }
        }

        private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65551, this, coordinatorLayout, t) == null) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
                View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
                if (findFirstScrollingChild == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.LayoutParams) findFirstScrollingChild.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                    return;
                }
                addAccessibilityScrollActions(coordinatorLayout, t, findFirstScrollingChild);
            }
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i3, boolean z) {
            View appBarChildOnOffset;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (appBarChildOnOffset = getAppBarChildOnOffset(t, i2)) == null) {
                return;
            }
            int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
            boolean z2 = false;
            if ((scrollFlags & 1) != 0) {
                int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                if (i3 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i2) < (appBarChildOnOffset.getBottom() - minimumHeight) - t.getTopInset()) : (-i2) >= (appBarChildOnOffset.getBottom() - minimumHeight) - t.getTopInset()) {
                    z2 = true;
                }
            }
            if (t.isLiftOnScroll()) {
                z2 = t.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = t.setLiftedState(z2);
            if (z || (liftedState && shouldJumpElevationState(coordinatorLayout, t))) {
                t.jumpDrawablesToCurrentState();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View view) {
            return canDragView((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View view) {
            return getMaxDragOffset((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View view) {
            return getScrollRangeForDragFling((BaseBehavior<T>) ((AppBarLayout) view));
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getTopAndBottomOffset() + this.offsetDelta : invokeV.intValue;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                return valueAnimator != null && valueAnimator.isRunning();
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
            onFlingFinished(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            return onLayoutChild(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
            return onMeasureChild(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i2, i3, i4, i5);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i2, int i3, int[] iArr, int i4) {
            onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i2, i3, iArr, i4);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            onNestedScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i2, i3, i4, i5, i6, iArr);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, Parcelable parcelable) {
            onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), parcelable);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
            return onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, View view3, int i2, int i3) {
            return onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, view3, i2, i3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i2) {
            onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i2);
        }

        public void setDragCallback(@Nullable BaseDragCallback baseDragCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, baseDragCallback) == null) {
                this.onDragCallback = baseDragCallback;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.material.appbar.AppBarLayout$BaseBehavior<T extends com.google.android.material.appbar.AppBarLayout> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4) {
            return setHeaderTopBottomOffset(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i2, i3, i4);
        }

        public boolean canDragView(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                BaseDragCallback baseDragCallback = this.onDragCallback;
                if (baseDragCallback != null) {
                    return baseDragCallback.canDrag(t);
                }
                WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
                if (weakReference != null) {
                    View view = weakReference.get();
                    return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int getMaxDragOffset(@NonNull T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) ? -t.getDownNestedScrollRange() : invokeL.intValue;
        }

        public int getScrollRangeForDragFling(@NonNull T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) ? t.getTotalScrollRange() : invokeL.intValue;
        }

        public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, coordinatorLayout, t) == null) {
                snapToChildIfNeeded(coordinatorLayout, t);
                if (t.isLiftOnScroll()) {
                    t.setLiftedState(t.shouldLift(findFirstScrollingChild(coordinatorLayout)));
                }
            }
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2) {
            InterceptResult invokeLLI;
            int round;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, coordinatorLayout, t, i2)) == null) {
                boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) t, i2);
                int pendingAction = t.getPendingAction();
                int i3 = this.offsetToChildIndexOnLayout;
                if (i3 >= 0 && (pendingAction & 8) == 0) {
                    View childAt = t.getChildAt(i3);
                    int i4 = -childAt.getBottom();
                    if (this.offsetToChildIndexOnLayoutIsMinHeight) {
                        round = ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                    } else {
                        round = Math.round(childAt.getHeight() * this.offsetToChildIndexOnLayoutPerc);
                    }
                    setHeaderTopBottomOffset(coordinatorLayout, t, i4 + round);
                } else if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i5 = -t.getUpNestedPreScrollRange();
                        if (z) {
                            animateOffsetTo(coordinatorLayout, t, i5, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t, i5);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            animateOffsetTo(coordinatorLayout, t, 0, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t, 0);
                        }
                    }
                }
                t.resetPendingAction();
                this.offsetToChildIndexOnLayout = -1;
                setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t.getTotalScrollRange(), 0));
                updateAppBarLayoutDrawableState(coordinatorLayout, t, getTopAndBottomOffset(), 0, true);
                t.onOffsetChanged(getTopAndBottomOffset());
                updateAccessibilityActions(coordinatorLayout, t);
                return onLayoutChild;
            }
            return invokeLLI.booleanValue;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t.getLayoutParams())).height == -2) {
                    coordinatorLayout.onMeasureChild(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                    return true;
                }
                return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) t, i2, i3, i4, i5);
            }
            return invokeCommon.booleanValue;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{coordinatorLayout, t, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) {
                if (i3 != 0) {
                    if (i3 < 0) {
                        int i7 = -t.getTotalScrollRange();
                        i5 = i7;
                        i6 = t.getDownNestedPreScrollRange() + i7;
                    } else {
                        i5 = -t.getUpNestedPreScrollRange();
                        i6 = 0;
                    }
                    if (i5 != i6) {
                        iArr[1] = scroll(coordinatorLayout, t, i3, i5, i6);
                    }
                }
                if (t.isLiftOnScroll()) {
                    t.setLiftedState(t.shouldLift(view));
                }
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{coordinatorLayout, t, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), iArr}) == null) {
                if (i5 < 0) {
                    iArr[1] = scroll(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
                }
                if (i5 == 0) {
                    updateAccessibilityActions(coordinatorLayout, t);
                }
            }
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048595, this, coordinatorLayout, t, parcelable) == null) {
                if (parcelable instanceof SavedState) {
                    SavedState savedState = (SavedState) parcelable;
                    super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t, savedState.getSuperState());
                    this.offsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
                    this.offsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
                    this.offsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
                    return;
                }
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t, parcelable);
                this.offsetToChildIndexOnLayout = -1;
            }
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, coordinatorLayout, t)) == null) {
                Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) t);
                int topAndBottomOffset = getTopAndBottomOffset();
                int childCount = t.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = t.getChildAt(i2);
                    int bottom = childAt.getBottom() + topAndBottomOffset;
                    if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                        SavedState savedState = new SavedState(onSaveInstanceState);
                        savedState.firstVisibleChildIndex = i2;
                        savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                        savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                        return savedState;
                    }
                }
                return onSaveInstanceState;
            }
            return (Parcelable) invokeLL.objValue;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view, View view2, int i2, int i3) {
            InterceptResult invokeCommon;
            ValueAnimator valueAnimator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{coordinatorLayout, t, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                boolean z = (i2 & 2) != 0 && (t.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t, view));
                if (z && (valueAnimator = this.offsetAnimator) != null) {
                    valueAnimator.cancel();
                }
                this.lastNestedScrollingChildRef = null;
                this.lastStartedType = i3;
                return z;
            }
            return invokeCommon.booleanValue;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048601, this, coordinatorLayout, t, view, i2) == null) {
                if (this.lastStartedType == 0 || i2 == 1) {
                    snapToChildIfNeeded(coordinatorLayout, t);
                    if (t.isLiftOnScroll()) {
                        t.setLiftedState(t.shouldLift(view));
                    }
                }
                this.lastNestedScrollingChildRef = new WeakReference<>(view);
            }
        }

        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
                int i5 = 0;
                if (i3 != 0 && topBottomOffsetForScrollingSibling >= i3 && topBottomOffsetForScrollingSibling <= i4) {
                    int clamp = MathUtils.clamp(i2, i3, i4);
                    if (topBottomOffsetForScrollingSibling != clamp) {
                        int interpolateOffset = t.hasChildWithInterpolator() ? interpolateOffset(t, clamp) : clamp;
                        boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                        i5 = topBottomOffsetForScrollingSibling - clamp;
                        this.offsetDelta = clamp - interpolateOffset;
                        if (!topAndBottomOffset && t.hasChildWithInterpolator()) {
                            coordinatorLayout.dispatchDependentViewsChanged(t);
                        }
                        t.onOffsetChanged(getTopAndBottomOffset());
                        updateAppBarLayoutDrawableState(coordinatorLayout, t, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    }
                } else {
                    this.offsetDelta = 0;
                }
                updateAccessibilityActions(coordinatorLayout, t);
                return i5;
            }
            return invokeCommon.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseBehavior(Context context, AttributeSet attributeSet) {
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
            this.offsetToChildIndexOnLayout = -1;
        }

        /* loaded from: classes9.dex */
        public static class SavedState extends AbsSavedState {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<SavedState> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-813733657, "Lcom/google/android/material/appbar/AppBarLayout$BaseBehavior$SavedState;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-813733657, "Lcom/google/android/material/appbar/AppBarLayout$BaseBehavior$SavedState;");
                        return;
                    }
                }
                CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.Parcelable.Creator
                    @NonNull
                    public SavedState[] newArray(int i2) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.ClassLoaderCreator
                    @NonNull
                    public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.Parcelable.Creator
                    @Nullable
                    public SavedState createFromParcel(@NonNull Parcel parcel) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                    }
                };
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcel, classLoader};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                    super.writeToParcel(parcel, i2);
                    parcel.writeInt(this.firstVisibleChildIndex);
                    parcel.writeFloat(this.firstVisibleChildPercentageShown);
                    parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SavedState(Parcelable parcelable) {
                super(parcelable);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcelable};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Parcelable) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i2);
    }

    /* loaded from: classes9.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DragCallback() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public Behavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i2) {
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2, i3, iArr, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2, i3, i4, i5, i6, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i2, int i3) {
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i2, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2) {
            super.onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i2) {
            return super.setLeftAndRightOffset(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i2) {
            return super.setTopAndBottomOffset(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(Context context, AttributeSet attributeSet) {
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
        }
    }

    /* loaded from: classes9.dex */
    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout appBarLayout, int i2);
    }

    /* loaded from: classes9.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ScrollingViewBehavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static int getAppBarLayoutOffset(@NonNull AppBarLayout appBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, appBarLayout)) == null) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
                if (behavior instanceof BaseBehavior) {
                    return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
                }
                return 0;
            }
            return invokeL.intValue;
        }

        private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, view, view2) == null) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
                if (behavior instanceof BaseBehavior) {
                    ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
                }
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, view2) == null) && (view2 instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public float getOverlapRatioForOffset(View view) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
                if (view instanceof AppBarLayout) {
                    AppBarLayout appBarLayout = (AppBarLayout) view;
                    int totalScrollRange = appBarLayout.getTotalScrollRange();
                    int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                    int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                    if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                        return (appBarLayoutOffset / i2) + 1.0f;
                    }
                }
                return 0.0f;
            }
            return invokeL.floatValue;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                if (view instanceof AppBarLayout) {
                    return ((AppBarLayout) view).getTotalScrollRange();
                }
                return super.getScrollRange(view);
            }
            return invokeL.intValue;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, coordinatorLayout, view, view2)) == null) ? view2 instanceof AppBarLayout : invokeLLL.booleanValue;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, coordinatorLayout, view, view2)) == null) {
                offsetChildAsNeeded(view, view2);
                updateLiftedStateIfNeeded(view, view2);
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048586, this, coordinatorLayout, view, view2) == null) && (view2 instanceof AppBarLayout)) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            return super.onLayoutChild(coordinatorLayout, view, i2);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, view, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{coordinatorLayout, view, rect, Boolean.valueOf(z)})) == null) {
                AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
                if (findFirstDependency != null) {
                    rect.offset(view.getLeft(), view.getTop());
                    Rect rect2 = this.tempRect1;
                    rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                    if (!rect2.contains(rect)) {
                        findFirstDependency.setExpanded(false, !z);
                        return true;
                    }
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i2) {
            return super.setLeftAndRightOffset(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i2) {
            return super.setTopAndBottomOffset(i2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public AppBarLayout findFirstDependency(@NonNull List<View> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = list.get(i2);
                    if (view instanceof AppBarLayout) {
                        return (AppBarLayout) view;
                    }
                }
                return null;
            }
            return (AppBarLayout) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-292185682, "Lcom/google/android/material/appbar/AppBarLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-292185682, "Lcom/google/android/material/appbar/AppBarLayout;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppBarLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void clearLiftOnScrollTargetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            WeakReference<View> weakReference = this.liftOnScrollTargetView;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.liftOnScrollTargetView = null;
        }
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View view) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view)) == null) {
            if (this.liftOnScrollTargetView == null && (i2 = this.liftOnScrollTargetViewId) != -1) {
                View findViewById = view != null ? view.findViewById(i2) : null;
                if (findViewById == null && (getParent() instanceof ViewGroup)) {
                    findViewById = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
                }
                if (findViewById != null) {
                    this.liftOnScrollTargetView = new WeakReference<>(findViewById);
                }
            }
            WeakReference<View> weakReference = this.liftOnScrollTargetView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    private boolean hasCollapsibleChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (((LayoutParams) getChildAt(i2).getLayoutParams()).isCollapsible()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void invalidateScrollRanges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.totalScrollRange = -1;
            this.downPreScrollRange = -1;
            this.downScrollRange = -1;
        }
    }

    private boolean setLiftableState(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
            if (this.liftable != z) {
                this.liftable = z;
                refreshDrawableState();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    private boolean shouldDrawStatusBarForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.statusBarForeground != null && getTopInset() > 0 : invokeV.booleanValue;
    }

    private boolean shouldOffsetFirstChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void startLiftOnScrollElevationOverlayAnimation(@NonNull MaterialShapeDrawable materialShapeDrawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, this, materialShapeDrawable, z) == null) {
            float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
            float f2 = z ? 0.0f : dimension;
            if (!z) {
                dimension = 0.0f;
            }
            ValueAnimator valueAnimator = this.elevationOverlayAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, dimension);
            this.elevationOverlayAnimator = ofFloat;
            ofFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.elevationOverlayAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            this.elevationOverlayAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, materialShapeDrawable) { // from class: com.google.android.material.appbar.AppBarLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppBarLayout this$0;
                public final /* synthetic */ MaterialShapeDrawable val$background;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, materialShapeDrawable};
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
                    this.val$background = materialShapeDrawable;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.val$background.setElevation(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                    }
                }
            });
            this.elevationOverlayAnimator.start();
        }
    }

    private void updateWillNotDraw() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            setWillNotDraw(!shouldDrawStatusBarForeground());
        }
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseOnOffsetChangedListener) == null) {
            if (this.listeners == null) {
                this.listeners = new ArrayList();
            }
            if (baseOnOffsetChangedListener == null || this.listeners.contains(baseOnOffsetChangedListener)) {
                return;
            }
            this.listeners.add(baseOnOffsetChangedListener);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.draw(canvas);
            if (shouldDrawStatusBarForeground()) {
                int save = canvas.save();
                canvas.translate(0.0f, -this.currentOffset);
                this.statusBarForeground.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.statusBarForeground;
            if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
                invalidateDrawable(drawable);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new Behavior() : (CoordinatorLayout.Behavior) invokeV.objValue;
    }

    public int getDownNestedPreScrollRange() {
        InterceptResult invokeV;
        int i2;
        int minimumHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i3 = this.downPreScrollRange;
            if (i3 != -1) {
                return i3;
            }
            int i4 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = layoutParams.scrollFlags;
                if ((i5 & 5) == 5) {
                    int i6 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((i5 & 8) != 0) {
                        minimumHeight = ViewCompat.getMinimumHeight(childAt);
                    } else if ((i5 & 2) != 0) {
                        minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                    } else {
                        i2 = i6 + measuredHeight;
                        if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                            i2 = Math.min(i2, measuredHeight - getTopInset());
                        }
                        i4 += i2;
                    }
                    i2 = i6 + minimumHeight;
                    if (childCount == 0) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                } else if (i4 > 0) {
                    break;
                }
            }
            int max = Math.max(0, i4);
            this.downPreScrollRange = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getDownNestedScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i2 = this.downScrollRange;
            if (i2 != -1) {
                return i2;
            }
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int i5 = layoutParams.scrollFlags;
                if ((i5 & 1) == 0) {
                    break;
                }
                i4 += measuredHeight;
                if ((i5 & 2) != 0) {
                    i4 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
                i3++;
            }
            int max = Math.max(0, i4);
            this.downScrollRange = max;
            return max;
        }
        return invokeV.intValue;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.liftOnScrollTargetViewId : invokeV.intValue;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int topInset = getTopInset();
            int minimumHeight = ViewCompat.getMinimumHeight(this);
            if (minimumHeight == 0) {
                int childCount = getChildCount();
                minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
                if (minimumHeight == 0) {
                    return getHeight() / 3;
                }
            }
            return (minimumHeight * 2) + topInset;
        }
        return invokeV.intValue;
    }

    public int getPendingAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.pendingAction : invokeV.intValue;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.statusBarForeground : (Drawable) invokeV.objValue;
    }

    @Deprecated
    public float getTargetElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @VisibleForTesting
    public final int getTopInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getSystemWindowInsetTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int getTotalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i2 = this.totalScrollRange;
            if (i2 != -1) {
                return i2;
            }
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = layoutParams.scrollFlags;
                if ((i5 & 1) == 0) {
                    break;
                }
                i4 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if (i3 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                    i4 -= getTopInset();
                }
                if ((i5 & 2) != 0) {
                    i4 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
                i3++;
            }
            int max = Math.max(0, i4);
            this.totalScrollRange = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getUpNestedPreScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getTotalScrollRange() : invokeV.intValue;
    }

    public boolean hasChildWithInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.haveChildWithInterpolator : invokeV.booleanValue;
    }

    public boolean hasScrollableChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? getTotalScrollRange() != 0 : invokeV.booleanValue;
    }

    public boolean isLiftOnScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.liftOnScroll : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onAttachedToWindow();
            MaterialShapeUtils.setParentAbsoluteElevation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (this.tmpStatesArray == null) {
                this.tmpStatesArray = new int[4];
            }
            int[] iArr = this.tmpStatesArray;
            int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
            iArr[0] = this.liftable ? R.attr.state_liftable : -R.attr.state_liftable;
            iArr[1] = (this.liftable && this.lifted) ? R.attr.state_lifted : -R.attr.state_lifted;
            iArr[2] = this.liftable ? R.attr.state_collapsible : -R.attr.state_collapsible;
            iArr[3] = (this.liftable && this.lifted) ? R.attr.state_collapsed : -R.attr.state_collapsed;
            return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDetachedFromWindow();
            clearLiftOnScrollTargetView();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            boolean z2 = true;
            if (ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
                }
            }
            invalidateScrollRanges();
            this.haveChildWithInterpolator = false;
            int childCount2 = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount2) {
                    break;
                } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).getScrollInterpolator() != null) {
                    this.haveChildWithInterpolator = true;
                    break;
                } else {
                    i6++;
                }
            }
            Drawable drawable = this.statusBarForeground;
            if (drawable != null) {
                drawable.setBounds(0, 0, getWidth(), getTopInset());
            }
            if (this.liftableOverride) {
                return;
            }
            if (!this.liftOnScroll && !hasCollapsibleChild()) {
                z2 = false;
            }
            setLiftableState(z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i3);
            if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
            invalidateScrollRanges();
        }
    }

    public void onOffsetChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.currentOffset = i2;
            if (!willNotDraw()) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            List<BaseOnOffsetChangedListener> list = this.listeners;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i3);
                    if (baseOnOffsetChangedListener != null) {
                        baseOnOffsetChangedListener.onOffsetChanged(this, i2);
                    }
                }
            }
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, windowInsetsCompat)) == null) {
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
                this.lastInsets = windowInsetsCompat2;
                updateWillNotDraw();
                requestLayout();
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, baseOnOffsetChangedListener) == null) || (list = this.listeners) == null || baseOnOffsetChangedListener == null) {
            return;
        }
        list.remove(baseOnOffsetChangedListener);
    }

    public void resetPendingAction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.pendingAction = 0;
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048614, this, f2) == null) {
            super.setElevation(f2);
            MaterialShapeUtils.setElevation(this, f2);
        }
    }

    public void setExpanded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            setExpanded(z, ViewCompat.isLaidOut(this));
        }
    }

    public void setLiftOnScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.liftOnScroll = z;
        }
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.liftOnScrollTargetViewId = i2;
            clearLiftOnScrollTargetView();
        }
    }

    public boolean setLiftable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
            this.liftableOverride = true;
            return setLiftableState(z);
        }
        return invokeZ.booleanValue;
    }

    public boolean setLifted(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z)) == null) ? setLiftedState(z) : invokeZ.booleanValue;
    }

    public boolean setLiftedState(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
            if (this.lifted != z) {
                this.lifted = z;
                refreshDrawableState();
                if (this.liftOnScroll && (getBackground() instanceof MaterialShapeDrawable)) {
                    startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable) getBackground(), z);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            if (i2 == 1) {
                super.setOrientation(i2);
                return;
            }
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, drawable) == null) || (drawable2 = this.statusBarForeground) == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable mutate = drawable != null ? drawable.mutate() : null;
        this.statusBarForeground = mutate;
        if (mutate != null) {
            if (mutate.isStateful()) {
                this.statusBarForeground.setState(getDrawableState());
            }
            DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
            this.statusBarForeground.setVisible(getVisibility() == 0, false);
            this.statusBarForeground.setCallback(this);
        }
        updateWillNotDraw();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            setStatusBarForeground(new ColorDrawable(i2));
        }
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048626, this, f2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f2);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            super.setVisibility(i2);
            boolean z = i2 == 0;
            Drawable drawable = this.statusBarForeground;
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
        }
    }

    public boolean shouldLift(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, view)) == null) {
            View findLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
            if (findLiftOnScrollTargetView != null) {
                view = findLiftOnScrollTargetView;
            }
            return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.statusBarForeground : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void setExpanded(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            setExpanded(z, z2, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i2, DEF_STYLE_RES), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        Context context2 = getContext();
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
            ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, i2, DEF_STYLE_RES);
        }
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.AppBarLayout, i2, DEF_STYLE_RES, new int[0]);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.liftOnScroll = obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(obtainStyledAttributes.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.appbar.AppBarLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AppBarLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, windowInsetsCompat)) == null) ? this.this$0.onWindowInsetChanged(windowInsetsCompat) : (WindowInsetsCompat) invokeLL.objValue;
            }
        });
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.pendingAction = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
            requestLayout();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new LayoutParams(-1, -2) : (LayoutParams) invokeV.objValue;
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onOffsetChangedListener) == null) {
            removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
        }
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onOffsetChangedListener) == null) {
            addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, layoutParams)) == null) {
            if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
                return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (LayoutParams) invokeL.objValue;
    }

    /* loaded from: classes9.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int COLLAPSIBLE_FLAGS = 10;
        public static final int FLAG_QUICK_RETURN = 5;
        public static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        public transient /* synthetic */ FieldHolder $fh;
        public int scrollFlags;
        public Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes9.dex */
        public @interface ScrollFlags {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.scrollFlags = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int getScrollFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.scrollFlags : invokeV.intValue;
        }

        public Interpolator getScrollInterpolator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.scrollInterpolator : (Interpolator) invokeV.objValue;
        }

        public boolean isCollapsible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.scrollFlags;
                return (i2 & 1) == 1 && (i2 & 10) != 0;
            }
            return invokeV.booleanValue;
        }

        public void setScrollFlags(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.scrollFlags = i2;
            }
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, interpolator) == null) {
                this.scrollInterpolator = interpolator;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3, f2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.scrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.scrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.scrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LinearLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.scrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LinearLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                    return;
                }
            }
            this.scrollFlags = 1;
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }
    }
}
