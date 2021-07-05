package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.kwad.sdk.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class KSCoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Class<?>[] CONSTRUCTOR_PARAMS;
    public static final int EVENT_NESTED_SCROLL = 1;
    public static final int EVENT_PRE_DRAW = 0;
    public static final int EVENT_VIEW_REMOVED = 2;
    public static final String TAG = "CoordinatorLayout";
    public static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    public static final int TYPE_ON_INTERCEPT = 0;
    public static final int TYPE_ON_TOUCH = 1;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    public static final Pools.Pool<Rect> sRectPool;
    public transient /* synthetic */ FieldHolder $fh;
    public OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    public View mBehaviorTouchView;
    public final KSDirectedAcyclicGraph<View> mChildDag;
    public final List<View> mDependencySortedChildren;
    public boolean mDisallowInterceptReset;
    public boolean mDrawStatusBarBackground;
    public boolean mIsAttachedToWindow;
    public int[] mKeylines;
    public WindowInsetsCompat mLastInsets;
    public boolean mNeedsPreDrawListener;
    public final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public View mNestedScrollingTarget;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    public OnPreDrawListener mOnPreDrawListener;
    public Paint mScrimPaint;
    public Drawable mStatusBarBackground;
    public final List<View> mTempDependenciesList;
    public final int[] mTempIntPair;
    public final List<View> mTempList1;

    @Keep
    /* loaded from: classes7.dex */
    public static abstract class Behavior<V extends View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public Behavior(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Object getTag(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) ? ((LayoutParams) view.getLayoutParams()).mBehaviorTag : invokeL.objValue;
        }

        public static void setTag(View view, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, view, obj) == null) {
                ((LayoutParams) view.getLayoutParams()).mBehaviorTag = obj;
            }
        }

        public boolean blocksInteractionBelow(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kSCoordinatorLayout, v)) == null) ? getScrimOpacity(kSCoordinatorLayout, v) > 0.0f : invokeLL.booleanValue;
        }

        public boolean getInsetDodgeRect(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kSCoordinatorLayout, v, rect)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @ColorInt
        public int getScrimColor(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kSCoordinatorLayout, v)) == null) {
                return -16777216;
            }
            return invokeLL.intValue;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, kSCoordinatorLayout, v)) == null) {
                return 0.0f;
            }
            return invokeLL.floatValue;
        }

        public boolean layoutDependsOn(KSCoordinatorLayout kSCoordinatorLayout, V v, View view) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, kSCoordinatorLayout, v, view)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(KSCoordinatorLayout kSCoordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, kSCoordinatorLayout, v, windowInsetsCompat)) == null) ? windowInsetsCompat : (WindowInsetsCompat) invokeLLL.objValue;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, layoutParams) == null) {
            }
        }

        public boolean onDependentViewChanged(KSCoordinatorLayout kSCoordinatorLayout, V v, View view) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, kSCoordinatorLayout, v, view)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public void onDependentViewRemoved(KSCoordinatorLayout kSCoordinatorLayout, V v, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kSCoordinatorLayout, v, view) == null) {
            }
        }

        public void onDetachedFromLayoutParams() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            }
        }

        public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, kSCoordinatorLayout, v, motionEvent)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, kSCoordinatorLayout, v, i2)) == null) {
                return false;
            }
            return invokeLLI.booleanValue;
        }

        public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{kSCoordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean onNestedFling(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{kSCoordinatorLayout, v, view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean onNestedPreFling(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{kSCoordinatorLayout, v, view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{kSCoordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            }
        }

        public void onNestedPreScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{kSCoordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) && i4 == 0) {
                onNestedPreScroll(kSCoordinatorLayout, v, view, i2, i3, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{kSCoordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            }
        }

        public void onNestedScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{kSCoordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) && i6 == 0) {
                onNestedScroll(kSCoordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{kSCoordinatorLayout, v, view, view2, Integer.valueOf(i2)}) == null) {
            }
        }

        public void onNestedScrollAccepted(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{kSCoordinatorLayout, v, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && i3 == 0) {
                onNestedScrollAccepted(kSCoordinatorLayout, v, view, view2, i2);
            }
        }

        public boolean onRequestChildRectangleOnScreen(KSCoordinatorLayout kSCoordinatorLayout, V v, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{kSCoordinatorLayout, v, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public void onRestoreInstanceState(KSCoordinatorLayout kSCoordinatorLayout, V v, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048598, this, kSCoordinatorLayout, v, parcelable) == null) {
            }
        }

        public Parcelable onSaveInstanceState(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, kSCoordinatorLayout, v)) == null) ? View.BaseSavedState.EMPTY_STATE : (Parcelable) invokeLL.objValue;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{kSCoordinatorLayout, v, view, view2, Integer.valueOf(i2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean onStartNestedScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{kSCoordinatorLayout, v, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                if (i3 == 0) {
                    return onStartNestedScroll(kSCoordinatorLayout, v, view, view2, i2);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048602, this, kSCoordinatorLayout, v, view) == null) {
            }
        }

        public void onStopNestedScroll(@NonNull KSCoordinatorLayout kSCoordinatorLayout, @NonNull V v, @NonNull View view, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLI(1048603, this, kSCoordinatorLayout, v, view, i2) == null) && i2 == 0) {
                onStopNestedScroll(kSCoordinatorLayout, v, view);
            }
        }

        public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, kSCoordinatorLayout, v, motionEvent)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes7.dex */
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes7.dex */
    public @interface DispatchChangeEvent {
    }

    /* loaded from: classes7.dex */
    public class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KSCoordinatorLayout this$0;

        public HierarchyChangeListener(KSCoordinatorLayout kSCoordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kSCoordinatorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kSCoordinatorLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || (onHierarchyChangeListener = this.this$0.mOnHierarchyChangeListener) == null) {
                return;
            }
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) {
                this.this$0.onChildViewsChanged(2);
                ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.this$0.mOnHierarchyChangeListener;
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewRemoved(view, view2);
                }
            }
        }
    }

    @Keep
    /* loaded from: classes7.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        public View mAnchorDirectChild;
        public int mAnchorId;
        public View mAnchorView;
        public Behavior mBehavior;
        public boolean mBehaviorResolved;
        public Object mBehaviorTag;
        public boolean mDidAcceptNestedScrollNonTouch;
        public boolean mDidAcceptNestedScrollTouch;
        public boolean mDidBlockInteraction;
        public boolean mDidChangeAfterNestedScroll;
        public int mInsetOffsetX;
        public int mInsetOffsetY;
        public final Rect mLastChildRect;

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
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(R.styleable.ksad_CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(R.styleable.ksad_CoordinatorLayout_Layout_ksad_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(R.styleable.ksad_CoordinatorLayout_Layout_ksad_layout_anchorGravity, 0);
            this.keyline = obtainStyledAttributes.getInteger(R.styleable.ksad_CoordinatorLayout_Layout_ksad_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(R.styleable.ksad_CoordinatorLayout_Layout_ksad_layout_insetEdge, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(R.styleable.ksad_CoordinatorLayout_Layout_ksad_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.ksad_CoordinatorLayout_Layout_ksad_layout_behavior);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                this.mBehavior = KSCoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(R.styleable.ksad_CoordinatorLayout_Layout_ksad_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.mBehavior;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65540, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65540, newInitContext);
                    return;
                }
            }
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        private void resolveAnchorView(View view, KSCoordinatorLayout kSCoordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, view, kSCoordinatorLayout) == null) {
                View findViewById = kSCoordinatorLayout.findViewById(this.mAnchorId);
                this.mAnchorView = findViewById;
                if (findViewById != null) {
                    if (findViewById != kSCoordinatorLayout) {
                        for (ViewParent parent = findViewById.getParent(); parent != kSCoordinatorLayout && parent != null; parent = parent.getParent()) {
                            if (parent != view) {
                                if (parent instanceof View) {
                                    findViewById = (View) parent;
                                }
                            } else if (!kSCoordinatorLayout.isInEditMode()) {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        this.mAnchorDirectChild = findViewById;
                        return;
                    } else if (!kSCoordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (!kSCoordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + kSCoordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + view);
                }
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
            }
        }

        private boolean shouldDodge(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, this, view, i2)) == null) {
                int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).insetEdge, i2);
                return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i2) & absoluteGravity) == absoluteGravity;
            }
            return invokeLI.booleanValue;
        }

        private boolean verifyAnchorView(View view, KSCoordinatorLayout kSCoordinatorLayout) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, view, kSCoordinatorLayout)) == null) {
                if (this.mAnchorView.getId() != this.mAnchorId) {
                    return false;
                }
                View view2 = this.mAnchorView;
                for (ViewParent parent = view2.getParent(); parent != kSCoordinatorLayout; parent = parent.getParent()) {
                    if (parent == null || parent == view) {
                        this.mAnchorDirectChild = null;
                        this.mAnchorView = null;
                        return false;
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                this.mAnchorDirectChild = view2;
                return true;
            }
            return invokeLL.booleanValue;
        }

        public boolean checkAnchorChanged() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAnchorView == null && this.mAnchorId != -1 : invokeV.booleanValue;
        }

        public boolean dependsOn(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            InterceptResult invokeLLL;
            Behavior behavior;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kSCoordinatorLayout, view, view2)) == null) ? view2 == this.mAnchorDirectChild || shouldDodge(view2, ViewCompat.getLayoutDirection(kSCoordinatorLayout)) || ((behavior = this.mBehavior) != null && behavior.layoutDependsOn(kSCoordinatorLayout, view, view2)) : invokeLLL.booleanValue;
        }

        public boolean didBlockInteraction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.mBehavior == null) {
                    this.mDidBlockInteraction = false;
                }
                return this.mDidBlockInteraction;
            }
            return invokeV.booleanValue;
        }

        public View findAnchorView(KSCoordinatorLayout kSCoordinatorLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, kSCoordinatorLayout, view)) == null) {
                if (this.mAnchorId == -1) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                    return null;
                }
                if (this.mAnchorView == null || !verifyAnchorView(view, kSCoordinatorLayout)) {
                    resolveAnchorView(view, kSCoordinatorLayout);
                }
                return this.mAnchorView;
            }
            return (View) invokeLL.objValue;
        }

        @IdRes
        public int getAnchorId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAnchorId : invokeV.intValue;
        }

        @Nullable
        public Behavior getBehavior() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBehavior : (Behavior) invokeV.objValue;
        }

        public boolean getChangedAfterNestedScroll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDidChangeAfterNestedScroll : invokeV.booleanValue;
        }

        public Rect getLastChildRect() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLastChildRect : (Rect) invokeV.objValue;
        }

        public void invalidateAnchor() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
            }
        }

        public boolean isBlockingInteractionBelow(KSCoordinatorLayout kSCoordinatorLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, kSCoordinatorLayout, view)) == null) {
                boolean z = this.mDidBlockInteraction;
                if (z) {
                    return true;
                }
                Behavior behavior = this.mBehavior;
                boolean blocksInteractionBelow = (behavior != null ? behavior.blocksInteractionBelow(kSCoordinatorLayout, view) : false) | z;
                this.mDidBlockInteraction = blocksInteractionBelow;
                return blocksInteractionBelow;
            }
            return invokeLL.booleanValue;
        }

        public boolean isNestedScrollAccepted(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        return false;
                    }
                    return this.mDidAcceptNestedScrollNonTouch;
                }
                return this.mDidAcceptNestedScrollTouch;
            }
            return invokeI.booleanValue;
        }

        public void resetChangedAfterNestedScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.mDidChangeAfterNestedScroll = false;
            }
        }

        public void resetNestedScroll(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
                setNestedScrollAccepted(i2, false);
            }
        }

        public void resetTouchBehaviorTracking() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
                this.mDidBlockInteraction = false;
            }
        }

        public void setAnchorId(@IdRes int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
                invalidateAnchor();
                this.mAnchorId = i2;
            }
        }

        public void setBehavior(@Nullable Behavior behavior) {
            Behavior behavior2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048591, this, behavior) == null) || (behavior2 = this.mBehavior) == behavior) {
                return;
            }
            if (behavior2 != null) {
                behavior2.onDetachedFromLayoutParams();
            }
            this.mBehavior = behavior;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public void setChangedAfterNestedScroll(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
                this.mDidChangeAfterNestedScroll = z;
            }
        }

        public void setLastChildRect(Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, rect) == null) {
                this.mLastChildRect.set(rect);
            }
        }

        public void setNestedScrollAccepted(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (i2 == 0) {
                    this.mDidAcceptNestedScrollTouch = z;
                } else if (i2 != 1) {
                } else {
                    this.mDidAcceptNestedScrollNonTouch = z;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KSCoordinatorLayout this$0;

        public OnPreDrawListener(KSCoordinatorLayout kSCoordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kSCoordinatorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kSCoordinatorLayout;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.this$0.onChildViewsChanged(0);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<Parcelable> behaviorStates;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1829959648, "Lcom/kwad/sdk/lib/desigin/KSCoordinatorLayout$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1829959648, "Lcom/kwad/sdk/lib/desigin/KSCoordinatorLayout$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.kwad.sdk.lib.desigin.KSCoordinatorLayout.SavedState.1
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
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
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
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                this.behaviorStates.append(iArr[i4], readParcelableArray[i4]);
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

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                SparseArray<Parcelable> sparseArray = this.behaviorStates;
                int size = sparseArray != null ? sparseArray.size() : 0;
                parcel.writeInt(size);
                int[] iArr = new int[size];
                Parcelable[] parcelableArr = new Parcelable[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr[i3] = this.behaviorStates.keyAt(i3);
                    parcelableArr[i3] = this.behaviorStates.valueAt(i3);
                }
                parcel.writeIntArray(iArr);
                parcel.writeParcelableArray(parcelableArr, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class ViewElevationComparator implements Comparator<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ViewElevationComparator() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, view2)) == null) {
                float z = ViewCompat.getZ(view);
                float z2 = ViewCompat.getZ(view2);
                if (z > z2) {
                    return -1;
                }
                return z < z2 ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(752091816, "Lcom/kwad/sdk/lib/desigin/KSCoordinatorLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(752091816, "Lcom/kwad/sdk/lib/desigin/KSCoordinatorLayout;");
                return;
            }
        }
        Package r0 = KSCoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new Pools.SynchronizedPool(12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSCoordinatorLayout(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSCoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new KSDirectedAcyclicGraph<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mTempIntPair = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCoordinatorLayout, i2, R.style.ksad_Widget_Design_KSADCoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ksad_KSCoordinatorLayout_ksad_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i5 = 0; i5 < length; i5++) {
                int[] iArr = this.mKeylines;
                iArr[i5] = (int) (iArr[i5] * f2);
            }
        }
        this.mStatusBarBackground = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSCoordinatorLayout_ksad_statusBarBackground);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
    }

    @NonNull
    public static Rect acquireTempRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            Rect acquire = sRectPool.acquire();
            return acquire == null ? new Rect() : acquire;
        }
        return (Rect) invokeV.objValue;
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(AdIconUtil.AD_TEXT_ID, this, layoutParams, rect, i2, i3) == null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
            int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
            rect.set(max, max2, i2 + max, i3 + max2);
        }
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, windowInsetsCompat)) == null) {
            if (windowInsetsCompat.isConsumed()) {
                return windowInsetsCompat;
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (ViewCompat.getFitsSystemWindows(childAt) && (behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior()) != null) {
                    windowInsetsCompat = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                    if (windowInsetsCompat.isConsumed()) {
                        break;
                    }
                }
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i2, Rect rect, Rect rect2, LayoutParams layoutParams, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{view, Integer.valueOf(i2), rect, rect2, layoutParams, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), i2);
            int absoluteGravity2 = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), i2);
            int i5 = absoluteGravity & 7;
            int i6 = absoluteGravity & 112;
            int i7 = absoluteGravity2 & 7;
            int i8 = absoluteGravity2 & 112;
            int width = i7 != 1 ? i7 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
            int height = i8 != 16 ? i8 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
            if (i5 == 1) {
                width -= i3 / 2;
            } else if (i5 != 5) {
                width -= i3;
            }
            if (i6 == 16) {
                height -= i4 / 2;
            } else if (i6 != 80) {
                height -= i4;
            }
            rect2.set(width, height, i3 + width, i4 + height);
        }
    }

    private int getKeyline(int i2) {
        InterceptResult invokeI;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            int[] iArr = this.mKeylines;
            if (iArr == null) {
                sb = new StringBuilder();
                sb.append("No keylines defined for ");
                sb.append(this);
                sb.append(" - attempted index lookup ");
                sb.append(i2);
            } else if (i2 >= 0 && i2 < iArr.length) {
                return iArr[i2];
            } else {
                sb = new StringBuilder();
                sb.append("Keyline index ");
                sb.append(i2);
                sb.append(" out of range for ");
                sb.append(this);
            }
            Log.e("CoordinatorLayout", sb.toString());
            return 0;
        }
        return invokeI.intValue;
    }

    private void getTopSortedChildren(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, list) == null) {
            list.clear();
            boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
            int childCount = getChildCount();
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            }
            Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
            if (comparator != null) {
                Collections.sort(list, comparator);
            }
        }
    }

    private boolean hasDependencies(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, view)) == null) ? this.mChildDag.hasOutgoingEdges(view) : invokeL.booleanValue;
    }

    private void layoutChild(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, this, view, i2) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect acquireTempRect = acquireTempRect();
            acquireTempRect.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
                acquireTempRect.left += this.mLastInsets.getSystemWindowInsetLeft();
                acquireTempRect.top += this.mLastInsets.getSystemWindowInsetTop();
                acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
                acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
            }
            Rect acquireTempRect2 = acquireTempRect();
            GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithAnchor(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65548, this, view, view2, i2) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            try {
                getDescendantRect(view2, acquireTempRect);
                getDesiredAnchoredChildRect(view, i2, acquireTempRect, acquireTempRect2);
                view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
            } finally {
                releaseTempRect(acquireTempRect);
                releaseTempRect(acquireTempRect2);
            }
        }
    }

    private void layoutChildWithKeyline(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65549, this, view, i2, i3) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), i3);
            int i4 = absoluteGravity & 7;
            int i5 = absoluteGravity & 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (i3 == 1) {
                i2 = width - i2;
            }
            int keyline = getKeyline(i2) - measuredWidth;
            int i6 = 0;
            if (i4 == 1) {
                keyline += measuredWidth / 2;
            } else if (i4 == 5) {
                keyline += measuredWidth;
            }
            if (i5 == 16) {
                i6 = 0 + (measuredHeight / 2);
            } else if (i5 == 80) {
                i6 = measuredHeight + 0;
            }
            int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
            int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
            view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
        }
    }

    private void offsetChildByInset(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, this, view, rect, i2) == null) || !ViewCompat.isLaidOut(view) || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.getBehavior();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (behavior == null || !behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
            acquireTempRect.set(acquireTempRect2);
        } else if (!acquireTempRect2.contains(acquireTempRect)) {
            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect.toShortString() + " | Bounds:" + acquireTempRect2.toShortString());
        }
        releaseTempRect(acquireTempRect2);
        if (acquireTempRect.isEmpty()) {
            releaseTempRect(acquireTempRect);
            return;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i2);
        boolean z3 = true;
        if ((absoluteGravity & 48) != 48 || (i7 = (acquireTempRect.top - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - layoutParams.mInsetOffsetY) >= (i8 = rect.top)) {
            z = false;
        } else {
            setInsetOffsetY(view, i8 - i7);
            z = true;
        }
        if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - acquireTempRect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + layoutParams.mInsetOffsetY) < (i6 = rect.bottom)) {
            setInsetOffsetY(view, height - i6);
            z = true;
        }
        if (!z) {
            setInsetOffsetY(view, 0);
        }
        if ((absoluteGravity & 3) != 3 || (i4 = (acquireTempRect.left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - layoutParams.mInsetOffsetX) >= (i5 = rect.left)) {
            z2 = false;
        } else {
            setInsetOffsetX(view, i5 - i4);
            z2 = true;
        }
        if ((absoluteGravity & 5) != 5 || (width = ((getWidth() - acquireTempRect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + layoutParams.mInsetOffsetX) >= (i3 = rect.right)) {
            z3 = z2;
        } else {
            setInsetOffsetX(view, width - i3);
        }
        if (!z3) {
            setInsetOffsetX(view, 0);
        }
        releaseTempRect(acquireTempRect);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, context, attributeSet, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(".")) {
                str = context.getPackageName() + str;
            } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
                str = WIDGET_PACKAGE_NAME + IStringUtil.EXTENSION_SEPARATOR + str;
            }
            try {
                Map<String, Constructor<Behavior>> map = sConstructors.get();
                if (map == null) {
                    map = new HashMap<>();
                    sConstructors.set(map);
                }
                Constructor<Behavior> constructor = map.get(str);
                if (constructor == null) {
                    constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                    constructor.setAccessible(true);
                    map.put(str, constructor);
                }
                return constructor.newInstance(context, attributeSet);
            } catch (Exception e2) {
                throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
            }
        }
        return (Behavior) invokeLLL.objValue;
    }

    private boolean performIntercept(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, this, motionEvent, i2)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            List<View> list = this.mTempList1;
            getTopSortedChildren(list);
            int size = list.size();
            MotionEvent motionEvent2 = null;
            boolean z = false;
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                View view = list.get(i3);
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (!(z || z2) || actionMasked == 0) {
                    if (!z && behavior != null) {
                        if (i2 == 0) {
                            z = behavior.onInterceptTouchEvent(this, view, motionEvent);
                        } else if (i2 == 1) {
                            z = behavior.onTouchEvent(this, view, motionEvent);
                        }
                        if (z) {
                            this.mBehaviorTouchView = view;
                        }
                    }
                    boolean didBlockInteraction = layoutParams.didBlockInteraction();
                    boolean isBlockingInteractionBelow = layoutParams.isBlockingInteractionBelow(this, view);
                    z2 = isBlockingInteractionBelow && !didBlockInteraction;
                    if (isBlockingInteractionBelow && !z2) {
                        break;
                    }
                } else if (behavior != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i2 == 0) {
                        behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    } else if (i2 == 1) {
                        behavior.onTouchEvent(this, view, motionEvent2);
                    }
                }
            }
            list.clear();
            return z;
        }
        return invokeLI.booleanValue;
    }

    private void prepareChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mDependencySortedChildren.clear();
            this.mChildDag.clear();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
                resolvedLayoutParams.findAnchorView(this, childAt);
                this.mChildDag.addNode(childAt);
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i3 != i2) {
                        View childAt2 = getChildAt(i3);
                        if (resolvedLayoutParams.dependsOn(this, childAt, childAt2)) {
                            if (!this.mChildDag.contains(childAt2)) {
                                this.mChildDag.addNode(childAt2);
                            }
                            this.mChildDag.addEdge(childAt2, childAt);
                        }
                    }
                }
            }
            this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
            Collections.reverse(this.mDependencySortedChildren);
        }
    }

    public static void releaseTempRect(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, rect) == null) {
            rect.setEmpty();
            sRectPool.release(rect);
        }
    }

    private void resetTouchBehaviors(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, this, z) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    if (z) {
                        behavior.onInterceptTouchEvent(this, childAt, obtain);
                    } else {
                        behavior.onTouchEvent(this, childAt, obtain);
                    }
                    obtain.recycle();
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                ((LayoutParams) getChildAt(i3).getLayoutParams()).resetTouchBehaviorTracking();
            }
            this.mDisallowInterceptReset = false;
        }
    }

    public static int resolveAnchoredChildGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            if (i2 == 0) {
                return 17;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static int resolveGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) {
            if ((i2 & 7) == 0) {
                i2 |= GravityCompat.START;
            }
            return (i2 & 112) == 0 ? i2 | 48 : i2;
        }
        return invokeI.intValue;
    }

    public static int resolveKeylineGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i2)) == null) ? i2 == 0 ? BadgeDrawable.TOP_END : i2 : invokeI.intValue;
    }

    private void setInsetOffsetX(View view, int i2) {
        LayoutParams layoutParams;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65559, this, view, i2) == null) || (i3 = (layoutParams = (LayoutParams) view.getLayoutParams()).mInsetOffsetX) == i2) {
            return;
        }
        ViewCompat.offsetLeftAndRight(view, i2 - i3);
        layoutParams.mInsetOffsetX = i2;
    }

    private void setInsetOffsetY(View view, int i2) {
        LayoutParams layoutParams;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65560, this, view, i2) == null) || (i3 = (layoutParams = (LayoutParams) view.getLayoutParams()).mInsetOffsetY) == i2) {
            return;
        }
        ViewCompat.offsetTopAndBottom(view, i2 - i3);
        layoutParams.mInsetOffsetY = i2;
    }

    private void setupForInsets() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.setOnApplyWindowInsetsListener(this, null);
            return;
        }
        if (this.mApplyWindowInsetsListener == null) {
            this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener(this) { // from class: com.kwad.sdk.lib.desigin.KSCoordinatorLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KSCoordinatorLayout this$0;

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

                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, windowInsetsCompat)) == null) ? this.this$0.setWindowInsets(windowInsetsCompat) : (WindowInsetsCompat) invokeLL.objValue;
                }
            };
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    public void addPreDrawListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mIsAttachedToWindow) {
                if (this.mOnPreDrawListener == null) {
                    this.mOnPreDrawListener = new OnPreDrawListener(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
            }
            this.mNeedsPreDrawListener = true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams)) == null) ? (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    public void dispatchDependentViewsChanged(View view) {
        List incomingEdges;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (incomingEdges = this.mChildDag.getIncomingEdges(view)) == null || incomingEdges.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < incomingEdges.size(); i2++) {
            View view2 = (View) incomingEdges.get(i2);
            Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior != null) {
                behavior.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, view2)) == null) {
            boolean z = false;
            if (view.getVisibility() == 0 && view2.getVisibility() == 0) {
                Rect acquireTempRect = acquireTempRect();
                getChildRect(view, view.getParent() != this, acquireTempRect);
                Rect acquireTempRect2 = acquireTempRect();
                getChildRect(view2, view2.getParent() != this, acquireTempRect2);
                try {
                    if (acquireTempRect.left <= acquireTempRect2.right && acquireTempRect.top <= acquireTempRect2.bottom && acquireTempRect.right >= acquireTempRect2.left) {
                        if (acquireTempRect.bottom >= acquireTempRect2.top) {
                            z = true;
                        }
                    }
                    return z;
                } finally {
                    releaseTempRect(acquireTempRect);
                    releaseTempRect(acquireTempRect2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{canvas, view, Long.valueOf(j)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.mBehavior;
            if (behavior != null) {
                float scrimOpacity = behavior.getScrimOpacity(this, view);
                if (scrimOpacity > 0.0f) {
                    if (this.mScrimPaint == null) {
                        this.mScrimPaint = new Paint();
                    }
                    this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view));
                    this.mScrimPaint.setAlpha(MathUtils.clamp(Math.round(scrimOpacity * 255.0f), 0, 255));
                    int save = canvas.save();
                    if (view.isOpaque()) {
                        canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                    }
                    canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                    canvas.restoreToCount(save);
                }
            }
            return super.drawChild(canvas, view, j);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.mStatusBarBackground;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | drawable.setState(drawableState);
            }
            if (z) {
                invalidate();
            }
        }
    }

    public void ensurePreDrawListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                } else if (hasDependencies(getChildAt(i2))) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z != this.mNeedsPreDrawListener) {
                if (z) {
                    addPreDrawListener();
                } else {
                    removePreDrawListener();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new LayoutParams(-2, -2) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams) : (LayoutParams) invokeL.objValue;
    }

    public void getChildRect(View view, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{view, Boolean.valueOf(z), rect}) == null) {
            if (view.isLayoutRequested() || view.getVisibility() == 8) {
                rect.setEmpty();
            } else if (z) {
                getDescendantRect(view, rect);
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view)) == null) {
            List<View> outgoingEdges = this.mChildDag.getOutgoingEdges(view);
            this.mTempDependenciesList.clear();
            if (outgoingEdges != null) {
                this.mTempDependenciesList.addAll(outgoingEdges);
            }
            return this.mTempDependenciesList;
        }
        return (List) invokeL.objValue;
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            prepareChildren();
            return Collections.unmodifiableList(this.mDependencySortedChildren);
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            List incomingEdges = this.mChildDag.getIncomingEdges(view);
            this.mTempDependenciesList.clear();
            if (incomingEdges != null) {
                this.mTempDependenciesList.addAll(incomingEdges);
            }
            return this.mTempDependenciesList;
        }
        return (List) invokeL.objValue;
    }

    public void getDescendantRect(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, view, rect) == null) {
            KSViewGroupUtils.getDescendantRect(this, view, rect);
        }
    }

    public void getDesiredAnchoredChildRect(View view, int i2, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048594, this, view, i2, rect, rect2) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, i2, rect, rect2, layoutParams, measuredWidth, measuredHeight);
            constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
        }
    }

    public void getLastChildRect(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view, rect) == null) {
            rect.set(((LayoutParams) view.getLayoutParams()).getLastChildRect());
        }
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mLastInsets : (WindowInsetsCompat) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mNestedScrollingParentHelper.getNestedScrollAxes() : invokeV.intValue;
    }

    public LayoutParams getResolvedLayoutParams(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view)) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!layoutParams.mBehaviorResolved) {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.setBehavior(defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                layoutParams.mBehaviorResolved = true;
            }
            return layoutParams;
        }
        return (LayoutParams) invokeL.objValue;
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mStatusBarBackground : (Drawable) invokeV.objValue;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom()) : invokeV.intValue;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight()) : invokeV.intValue;
    }

    public boolean isPointInChildBounds(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048602, this, view, i2, i3)) == null) {
            Rect acquireTempRect = acquireTempRect();
            getDescendantRect(view, acquireTempRect);
            try {
                return acquireTempRect.contains(i2, i3);
            } finally {
                releaseTempRect(acquireTempRect);
            }
        }
        return invokeLII.booleanValue;
    }

    public void offsetChildToAnchor(View view, int i2) {
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, view, i2) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.mAnchorView != null) {
                Rect acquireTempRect = acquireTempRect();
                Rect acquireTempRect2 = acquireTempRect();
                Rect acquireTempRect3 = acquireTempRect();
                getDescendantRect(layoutParams.mAnchorView, acquireTempRect);
                boolean z = false;
                getChildRect(view, false, acquireTempRect2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                getDesiredAnchoredChildRectWithoutConstraints(view, i2, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
                z = (acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top) ? true : true;
                constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, measuredHeight);
                int i3 = acquireTempRect3.left - acquireTempRect2.left;
                int i4 = acquireTempRect3.top - acquireTempRect2.top;
                if (i3 != 0) {
                    ViewCompat.offsetLeftAndRight(view, i3);
                }
                if (i4 != 0) {
                    ViewCompat.offsetTopAndBottom(view, i4);
                }
                if (z && (behavior = layoutParams.getBehavior()) != null) {
                    behavior.onDependentViewChanged(this, view, layoutParams.mAnchorView);
                }
                releaseTempRect(acquireTempRect);
                releaseTempRect(acquireTempRect2);
                releaseTempRect(acquireTempRect3);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onAttachedToWindow();
            resetTouchBehaviors(false);
            if (this.mNeedsPreDrawListener) {
                if (this.mOnPreDrawListener == null) {
                    this.mOnPreDrawListener = new OnPreDrawListener(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
            }
            if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
                ViewCompat.requestApplyInsets(this);
            }
            this.mIsAttachedToWindow = true;
        }
    }

    public final void onChildViewsChanged(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int size = this.mDependencySortedChildren.size();
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.mDependencySortedChildren.get(i3);
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (i2 != 0 || view.getVisibility() != 8) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (layoutParams.mAnchorDirectChild == this.mDependencySortedChildren.get(i4)) {
                            offsetChildToAnchor(view, layoutDirection);
                        }
                    }
                    getChildRect(view, true, acquireTempRect2);
                    if (layoutParams.insetEdge != 0 && !acquireTempRect2.isEmpty()) {
                        int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                        int i5 = absoluteGravity & 112;
                        if (i5 == 48) {
                            acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                        } else if (i5 == 80) {
                            acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                        }
                        int i6 = absoluteGravity & 7;
                        if (i6 == 3) {
                            acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                        } else if (i6 == 5) {
                            acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                        }
                    }
                    if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0) {
                        offsetChildByInset(view, acquireTempRect, layoutDirection);
                    }
                    if (i2 != 2) {
                        getLastChildRect(view, acquireTempRect3);
                        if (!acquireTempRect3.equals(acquireTempRect2)) {
                            recordLastChildRect(view, acquireTempRect2);
                        }
                    }
                    for (int i7 = i3 + 1; i7 < size; i7++) {
                        View view2 = this.mDependencySortedChildren.get(i7);
                        LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                        Behavior behavior = layoutParams2.getBehavior();
                        if (behavior != null && behavior.layoutDependsOn(this, view2, view)) {
                            if (i2 == 0 && layoutParams2.getChangedAfterNestedScroll()) {
                                layoutParams2.resetChangedAfterNestedScroll();
                            } else {
                                if (i2 != 2) {
                                    z = behavior.onDependentViewChanged(this, view2, view);
                                } else {
                                    behavior.onDependentViewRemoved(this, view2, view);
                                    z = true;
                                }
                                if (i2 == 1) {
                                    layoutParams2.setChangedAfterNestedScroll(z);
                                }
                            }
                        }
                    }
                }
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDetachedFromWindow();
            resetTouchBehaviors(false);
            if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
            }
            View view = this.mNestedScrollingTarget;
            if (view != null) {
                onStopNestedScroll(view);
            }
            this.mIsAttachedToWindow = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, canvas) == null) {
            super.onDraw(canvas);
            if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
                return;
            }
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                resetTouchBehaviors(true);
            }
            boolean performIntercept = performIntercept(motionEvent, 0);
            if (actionMasked == 1 || actionMasked == 3) {
                resetTouchBehaviors(true);
            }
            return performIntercept;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int size = this.mDependencySortedChildren.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = this.mDependencySortedChildren.get(i6);
                if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).getBehavior()) == null || !behavior.onLayoutChild(this, view, layoutDirection))) {
                    onLayoutChild(view, layoutDirection);
                }
            }
        }
    }

    public void onLayoutChild(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, view, i2) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.checkAnchorChanged()) {
                throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
            }
            View view2 = layoutParams.mAnchorView;
            if (view2 != null) {
                layoutChildWithAnchor(view, view2, i2);
                return;
            }
            int i3 = layoutParams.keyline;
            if (i3 >= 0) {
                layoutChildWithKeyline(view, i3, i2);
            } else {
                layoutChild(view, i2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x011e, code lost:
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Behavior behavior;
        LayoutParams layoutParams;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
            prepareChildren();
            ensurePreDrawListener();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            boolean z = layoutDirection == 1;
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            int i14 = paddingLeft + paddingRight;
            int i15 = paddingTop + paddingBottom;
            int suggestedMinimumWidth = getSuggestedMinimumWidth();
            int suggestedMinimumHeight = getSuggestedMinimumHeight();
            boolean z2 = this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this);
            int size3 = this.mDependencySortedChildren.size();
            int i16 = suggestedMinimumWidth;
            int i17 = suggestedMinimumHeight;
            int i18 = 0;
            int i19 = 0;
            while (i19 < size3) {
                View view = this.mDependencySortedChildren.get(i19);
                if (view.getVisibility() == 8) {
                    i12 = i19;
                    i9 = size3;
                    i10 = paddingLeft;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    int i20 = layoutParams2.keyline;
                    if (i20 < 0 || mode == 0) {
                        i4 = i18;
                    } else {
                        int keyline = getKeyline(i20);
                        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams2.gravity), layoutDirection) & 7;
                        i4 = i18;
                        if ((absoluteGravity == 3 && !z) || (absoluteGravity == 5 && z)) {
                            i5 = Math.max(0, (size - paddingRight) - keyline);
                        } else if ((absoluteGravity == 5 && !z) || (absoluteGravity == 3 && z)) {
                            i5 = Math.max(0, keyline - paddingLeft);
                        }
                        if (z2 || ViewCompat.getFitsSystemWindows(view)) {
                            i6 = i2;
                            i7 = i3;
                        } else {
                            i6 = View.MeasureSpec.makeMeasureSpec(size - (this.mLastInsets.getSystemWindowInsetLeft() + this.mLastInsets.getSystemWindowInsetRight()), mode);
                            i7 = View.MeasureSpec.makeMeasureSpec(size2 - (this.mLastInsets.getSystemWindowInsetTop() + this.mLastInsets.getSystemWindowInsetBottom()), mode2);
                        }
                        behavior = layoutParams2.getBehavior();
                        if (behavior == null) {
                            layoutParams = layoutParams2;
                            i11 = i4;
                            i12 = i19;
                            i8 = i17;
                            i10 = paddingLeft;
                            i13 = i16;
                            i9 = size3;
                        } else {
                            layoutParams = layoutParams2;
                            i8 = i17;
                            i9 = size3;
                            i10 = paddingLeft;
                            i11 = i4;
                            i12 = i19;
                            i13 = i16;
                        }
                        onMeasureChild(view, i6, i5, i7, 0);
                        LayoutParams layoutParams3 = layoutParams;
                        int max = Math.max(i13, i14 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin);
                        int max2 = Math.max(i8, i15 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin);
                        i18 = View.combineMeasuredStates(i11, view.getMeasuredState());
                        i16 = max;
                        i17 = max2;
                    }
                    i5 = 0;
                    if (z2) {
                    }
                    i6 = i2;
                    i7 = i3;
                    behavior = layoutParams2.getBehavior();
                    if (behavior == null) {
                    }
                    onMeasureChild(view, i6, i5, i7, 0);
                    LayoutParams layoutParams32 = layoutParams;
                    int max3 = Math.max(i13, i14 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams32).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams32).rightMargin);
                    int max22 = Math.max(i8, i15 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams32).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams32).bottomMargin);
                    i18 = View.combineMeasuredStates(i11, view.getMeasuredState());
                    i16 = max3;
                    i17 = max22;
                }
                i19 = i12 + 1;
                paddingLeft = i10;
                size3 = i9;
            }
            int i21 = i18;
            setMeasuredDimension(View.resolveSizeAndState(i16, i2, (-16777216) & i21), View.resolveSizeAndState(i17, i3, i21 << 16));
        }
    }

    public void onMeasureChild(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            measureChildWithMargins(view, i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                        z2 |= behavior.onNestedFling(this, childAt, view, f2, f3, z);
                    }
                }
            }
            if (z2) {
                onChildViewsChanged(1);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.getBehavior()) != null) {
                        z |= behavior.onNestedPreFling(this, childAt, view, f2, f3);
                    }
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            onNestedPreScroll(view, i2, i3, iArr, 0);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isNestedScrollAccepted(i4) && (behavior = layoutParams.getBehavior()) != null) {
                        int[] iArr2 = this.mTempIntPair;
                        iArr2[1] = 0;
                        iArr2[0] = 0;
                        behavior.onNestedPreScroll(this, childAt, view, i2, i3, iArr2, i4);
                        int[] iArr3 = this.mTempIntPair;
                        i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                        int[] iArr4 = this.mTempIntPair;
                        i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                        z = true;
                    }
                }
            }
            iArr[0] = i5;
            iArr[1] = i6;
            if (z) {
                onChildViewsChanged(1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            onNestedScroll(view, i2, i3, i4, i5, 0);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isNestedScrollAccepted(i6) && (behavior = layoutParams.getBehavior()) != null) {
                        behavior.onNestedScroll(this, childAt, view, i2, i3, i4, i5, i6);
                        z = true;
                    }
                }
            }
            if (z) {
                onChildViewsChanged(1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048619, this, view, view2, i2) == null) {
            onNestedScrollAccepted(view, view2, i2, 0);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        Behavior behavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048620, this, view, view2, i2, i3) == null) {
            this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i2, i3);
            this.mNestedScrollingTarget = view2;
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i3) && (behavior = layoutParams.getBehavior()) != null) {
                    behavior.onNestedScrollAccepted(this, childAt, view, view2, i2, i3);
                }
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int id = childAt.getId();
                Behavior behavior = getResolvedLayoutParams(childAt).getBehavior();
                if (id != -1 && behavior != null && (parcelable2 = sparseArray.get(id)) != null) {
                    behavior.onRestoreInstanceState(this, childAt, parcelable2);
                }
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Parcelable onSaveInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int id = childAt.getId();
                Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
                if (id != -1 && behavior != null && (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) != null) {
                    sparseArray.append(id, onSaveInstanceState);
                }
            }
            savedState.behaviorStates = sparseArray;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048623, this, view, view2, i2)) == null) ? onStartNestedScroll(view, view2, i2, 0) : invokeLLI.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048624, this, view, view2, i2, i3)) == null) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i2, i3);
                        z |= onStartNestedScroll;
                        layoutParams.setNestedScrollAccepted(i3, onStartNestedScroll);
                    } else {
                        layoutParams.setNestedScrollAccepted(i3, false);
                    }
                }
            }
            return z;
        }
        return invokeLLII.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view) == null) {
            onStopNestedScroll(view, 0);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048626, this, view, i2) == null) {
            this.mNestedScrollingParentHelper.onStopNestedScroll(view, i2);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i2)) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        behavior.onStopNestedScroll(this, childAt, view, i2);
                    }
                    layoutParams.resetNestedScroll(i2);
                    layoutParams.resetChangedAfterNestedScroll();
                }
            }
            this.mNestedScrollingTarget = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r3 != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean onTouchEvent;
        MotionEvent motionEvent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.mBehaviorTouchView == null) {
                z = performIntercept(motionEvent, 1);
            } else {
                z = false;
            }
            Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
            if (behavior != null) {
                onTouchEvent = behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
                motionEvent2 = null;
                if (this.mBehaviorTouchView != null) {
                    onTouchEvent |= super.onTouchEvent(motionEvent);
                } else if (z) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (actionMasked != 1 || actionMasked == 3) {
                    resetTouchBehaviors(false);
                }
                return onTouchEvent;
            }
            onTouchEvent = false;
            motionEvent2 = null;
            if (this.mBehaviorTouchView != null) {
            }
            if (motionEvent2 != null) {
            }
            if (actionMasked != 1) {
            }
            resetTouchBehaviors(false);
            return onTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void recordLastChildRect(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, view, rect) == null) {
            ((LayoutParams) view.getLayoutParams()).setLastChildRect(rect);
        }
    }

    public void removePreDrawListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
            }
            this.mNeedsPreDrawListener = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, view, rect, z)) == null) {
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
            if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
                return super.requestChildRectangleOnScreen(view, rect, z);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            super.requestDisallowInterceptTouchEvent(z);
            if (!z || this.mDisallowInterceptReset) {
                return;
            }
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            super.setFitsSystemWindows(z);
            setupForInsets();
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onHierarchyChangeListener) == null) {
            this.mOnHierarchyChangeListener = onHierarchyChangeListener;
        }
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, drawable) == null) || (drawable2 = this.mStatusBarBackground) == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable mutate = drawable != null ? drawable.mutate() : null;
        this.mStatusBarBackground = mutate;
        if (mutate != null) {
            if (mutate.isStateful()) {
                this.mStatusBarBackground.setState(getDrawableState());
            }
            DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
            this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
            this.mStatusBarBackground.setCallback(this);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            setStatusBarBackground(new ColorDrawable(i2));
        }
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            setStatusBarBackground(i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            super.setVisibility(i2);
            boolean z = i2 == 0;
            Drawable drawable = this.mStatusBarBackground;
            if (drawable == null || drawable.isVisible() == z) {
                return;
            }
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, windowInsetsCompat)) == null) {
            if (ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat)) {
                return windowInsetsCompat;
            }
            this.mLastInsets = windowInsetsCompat;
            boolean z = true;
            boolean z2 = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
            this.mDrawStatusBarBackground = z2;
            setWillNotDraw((z2 || getBackground() != null) ? false : false);
            WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
            requestLayout();
            return dispatchApplyWindowInsetsToBehaviors;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground : invokeL.booleanValue;
    }
}
