package com.kwai.library.widget.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class RefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATE_TO_REFRESH_DURATION = 500;
    public static final int ANIMATE_TO_START_DURATION = 300;
    public static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT_ANIMATE_DURATION = 400;
    public static final int DEFAULT_REFRESH_SIZE_DP = 70;
    public static final int DEFAULT_REFRESH_TARGET_OFFSET_DP = 70;
    public static final int INVALID_INDEX = -1;
    public static final int INVALID_POINTER = -1;
    public static final Handler UI_HANDLER;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public int mActivePointerId;
    public int mAnimateToRefreshDuration;
    public Interpolator mAnimateToRefreshInterpolator;
    public final Animation mAnimateToRefreshingAnimation;
    public final Animation mAnimateToStartAnimation;
    public int mAnimateToStartDuration;
    public Interpolator mAnimateToStartInterpolator;
    public float mCurrentTouchOffsetY;
    public boolean mDispatchTargetTouchDown;
    public com.kwai.library.widget.refresh.c mDragDistanceConverter;
    public int mFrom;
    public float mInitialDownY;
    public float mInitialMotionY;
    public float mInitialScrollY;
    public boolean mIsAnimatingToStart;
    public boolean mIsBeingDragged;
    public boolean mIsFitRefresh;
    public boolean mIsRefreshing;
    public boolean mIsStopNestScrollWhenUpOrCancel;
    public boolean mNestedScrollInProgress;
    public final NestedScrollingChildHelper mNestedScrollingChildHelper;
    public final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public boolean mNotifyListener;
    public b mOnRefreshListener;
    public c mOnRefreshStatusListener;
    public List<c> mOnRefreshStatusListeners;
    public d mOnScrollInterceptor;
    public boolean mOnlySupportPull;
    public final int[] mParentOffsetInWindow;
    public final int[] mParentScrollConsumed;
    public float mRefreshInitialOffset;
    public float mRefreshResistanceIncremental;
    public float mRefreshResistanceRate;
    public f mRefreshStatus;
    public RefreshStyle mRefreshStyle;
    public float mRefreshTargetOffset;
    public View mRefreshView;
    public int mRefreshViewIndex;
    public boolean mRefreshViewMeasured;
    public int mRefreshViewSize;
    public ValueAnimator mRefreshingAnimator;
    public final Animation.AnimationListener mRefreshingListener;
    public final Animation.AnimationListener mResetListener;
    public boolean mShowRefreshView;
    public View mStateView;
    public View mTarget;
    public float mTargetOrRefreshViewOffsetY;
    public float mTotalUnconsumed;
    public int mTouchSlop;
    public boolean mUsingCustomRefreshInitialOffset;
    public boolean mUsingCustomRefreshTargetOffset;

    /* renamed from: com.kwai.library.widget.refresh.RefreshLayout$6  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-830521234, "Lcom/kwai/library/widget/refresh/RefreshLayout$6;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-830521234, "Lcom/kwai/library/widget/refresh/RefreshLayout$6;");
                    return;
                }
            }
            int[] iArr = new int[RefreshStyle.values().length];
            a = iArr;
            try {
                iArr[RefreshStyle.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshStyle.PINNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RefreshStyle {
        public static final /* synthetic */ RefreshStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RefreshStyle FLOAT;
        public static final RefreshStyle NORMAL;
        public static final RefreshStyle PINNED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469251588, "Lcom/kwai/library/widget/refresh/RefreshLayout$RefreshStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-469251588, "Lcom/kwai/library/widget/refresh/RefreshLayout$RefreshStyle;");
                    return;
                }
            }
            NORMAL = new RefreshStyle("NORMAL", 0);
            PINNED = new RefreshStyle("PINNED", 1);
            RefreshStyle refreshStyle = new RefreshStyle("FLOAT", 2);
            FLOAT = refreshStyle;
            $VALUES = new RefreshStyle[]{NORMAL, PINNED, refreshStyle};
        }

        public RefreshStyle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RefreshStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RefreshStyle) Enum.valueOf(RefreshStyle.class, str) : (RefreshStyle) invokeL.objValue;
        }

        public static RefreshStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RefreshStyle[]) $VALUES.clone() : (RefreshStyle[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, AttributeSet attributeSet) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ViewGroup.LayoutParams layoutParams) {
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
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onRefresh();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void a(float f2, float f3, boolean z);

        void b();

        void c();
    }

    /* loaded from: classes3.dex */
    public interface d {
        boolean a(float f2, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1994158080, "Lcom/kwai/library/widget/refresh/RefreshLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1994158080, "Lcom/kwai/library/widget/refresh/RefreshLayout;");
                return;
            }
        }
        UI_HANDLER = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefreshLayout(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshLayout(Context context, AttributeSet attributeSet) {
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
        this.TAG = "RefreshLayout";
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshViewIndex = -1;
        this.mActivePointerId = -1;
        this.mAnimateToStartDuration = 300;
        this.mAnimateToRefreshDuration = 500;
        this.mUsingCustomRefreshTargetOffset = false;
        this.mUsingCustomRefreshInitialOffset = false;
        this.mRefreshViewMeasured = false;
        this.mRefreshStyle = RefreshStyle.NORMAL;
        this.mRefreshingAnimator = null;
        this.mAnimateToStartInterpolator = new DecelerateInterpolator(2.0f);
        this.mAnimateToRefreshInterpolator = new DecelerateInterpolator(2.0f);
        this.mShowRefreshView = true;
        this.mIsStopNestScrollWhenUpOrCancel = true;
        this.mAnimateToRefreshingAnimation = new Animation(this) { // from class: com.kwai.library.widget.refresh.RefreshLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RefreshLayout a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                float f3;
                RefreshLayout refreshLayout;
                View view;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) || this.a.mTarget == null) {
                    return;
                }
                if (AnonymousClass6.a[this.a.mRefreshStyle.ordinal()] != 1) {
                    refreshLayout = this.a;
                    f3 = refreshLayout.mRefreshTargetOffset;
                    view = refreshLayout.mTarget;
                } else {
                    RefreshLayout refreshLayout2 = this.a;
                    f3 = refreshLayout2.mRefreshTargetOffset + refreshLayout2.mRefreshInitialOffset;
                    refreshLayout = this.a;
                    view = refreshLayout.mRefreshView;
                }
                refreshLayout.animateToTargetOffset(f3, view.getTop(), f2);
            }
        };
        this.mAnimateToStartAnimation = new Animation(this) { // from class: com.kwai.library.widget.refresh.RefreshLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RefreshLayout a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                RefreshLayout refreshLayout;
                float f3;
                View view;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) || this.a.mTarget == null) {
                    return;
                }
                if (AnonymousClass6.a[this.a.mRefreshStyle.ordinal()] != 1) {
                    refreshLayout = this.a;
                    f3 = 0.0f;
                    view = refreshLayout.mTarget;
                } else {
                    refreshLayout = this.a;
                    f3 = refreshLayout.mRefreshInitialOffset;
                    view = this.a.mRefreshView;
                }
                refreshLayout.animateToTargetOffset(f3, view.getTop(), f2);
            }
        };
        this.mRefreshingListener = new Animation.AnimationListener(this) { // from class: com.kwai.library.widget.refresh.RefreshLayout.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RefreshLayout a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    if (this.a.mNotifyListener && ViewCompat.isAttachedToWindow(this.a) && this.a.mOnRefreshListener != null) {
                        this.a.mOnRefreshListener.onRefresh();
                    }
                    this.a.mIsAnimatingToStart = false;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    this.a.mIsAnimatingToStart = true;
                    this.a.mRefreshStatus.b();
                }
            }
        };
        this.mResetListener = new Animation.AnimationListener(this) { // from class: com.kwai.library.widget.refresh.RefreshLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RefreshLayout a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    this.a.reset();
                    if (this.a.mOnRefreshStatusListener != null) {
                        this.a.mOnRefreshStatusListener.c();
                    }
                    if (this.a.mOnRefreshStatusListeners != null) {
                        for (int i4 = 0; i4 < this.a.mOnRefreshStatusListeners.size(); i4++) {
                            ((c) this.a.mOnRefreshStatusListeners.get(i4)).c();
                        }
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    this.a.mIsAnimatingToStart = true;
                }
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = getResources().getDisplayMetrics().density;
        this.mRefreshViewSize = (int) (f2 * 70.0f);
        this.mRefreshTargetOffset = f2 * 70.0f;
        this.mTargetOrRefreshViewOffsetY = 0.0f;
        String str = "constructor: " + this.mTargetOrRefreshViewOffsetY;
        this.mRefreshInitialOffset = 0.0f;
        this.mRefreshResistanceRate = 1.0f;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        createRefreshView(attributeSet);
        createDragDistanceConverter();
        setNestedScrollingEnabled(true);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    private void animateToRefreshingPosition(int i2, Animation.AnimationListener animationListener) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65549, this, i2, animationListener) == null) {
            clearAnimation();
            if (computeAnimateToRefreshingDuration(i2) <= 0) {
                animationListener.onAnimationStart(null);
                animationListener.onAnimationEnd(null);
                return;
            }
            this.mFrom = i2;
            this.mAnimateToRefreshingAnimation.reset();
            this.mAnimateToRefreshingAnimation.setDuration(computeAnimateToRefreshingDuration(f2));
            this.mAnimateToRefreshingAnimation.setInterpolator(this.mAnimateToRefreshInterpolator);
            if (animationListener != null) {
                this.mAnimateToRefreshingAnimation.setAnimationListener(animationListener);
            }
            startAnimation(this.mAnimateToRefreshingAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateToTargetOffset(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            int i2 = this.mFrom;
            setTargetOrRefreshViewOffsetY((int) (((int) (i2 + ((f2 - i2) * f4))) - f3));
        }
    }

    private boolean canChildScrollUp(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, view)) == null) {
            if (view == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 14 && (view instanceof AbsListView)) {
                AbsListView absListView = (AbsListView) view;
                if (absListView.getChildCount() > 0) {
                    return absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop();
                }
                return false;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (canChildScrollUp(viewGroup.getChildAt(i2))) {
                        return true;
                    }
                }
            }
            return ViewCompat.canScrollVertically(view, -1);
        }
        return invokeL.booleanValue;
    }

    private int computeAnimateToRefreshingDuration(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65552, this, f2)) == null) {
            String str = "from -- refreshing " + f2;
            if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] == 1) {
                f2 -= this.mRefreshInitialOffset;
            }
            return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2 - this.mRefreshTargetOffset) / this.mRefreshTargetOffset)) * this.mAnimateToRefreshDuration);
        }
        return invokeF.intValue;
    }

    private int computeAnimateToStartDuration(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65553, this, f2)) == null) {
            String str = "from -- start " + f2;
            if (f2 < this.mRefreshInitialOffset) {
                return 0;
            }
            if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] == 1) {
                f2 -= this.mRefreshInitialOffset;
            }
            return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f2) / this.mRefreshTargetOffset)) * this.mAnimateToStartDuration);
        }
        return invokeF.intValue;
    }

    private void createDragDistanceConverter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mDragDistanceConverter = onCreateDragDistanceConvert();
        }
    }

    private void ensureTarget() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || isTargetValid()) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.mRefreshView) && !childAt.equals(this.mStateView)) {
                this.mTarget = childAt;
                return;
            }
        }
    }

    private void finishSpinner() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || this.mIsRefreshing || this.mIsAnimatingToStart) {
            return;
        }
        d dVar = this.mOnScrollInterceptor;
        if (dVar == null || !dVar.a(this.mCurrentTouchOffsetY, true)) {
            if (shouldRefresh()) {
                setRefreshing(true, true);
                return;
            }
            this.mIsRefreshing = false;
            animateOffsetToStartPosition((int) this.mTargetOrRefreshViewOffsetY, this.mResetListener);
        }
    }

    private float getMotionEventY(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getY(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    private int getTargetOrRefreshViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            return (AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1 ? this.mTarget : this.mRefreshView).getTop();
        }
        return invokeV.intValue;
    }

    private void initDragStatus(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65559, this, f2) == null) {
            float f3 = f2 - this.mInitialDownY;
            if (this.mIsRefreshing && (f3 > this.mTouchSlop || this.mTargetOrRefreshViewOffsetY > 0.0f)) {
                this.mIsBeingDragged = true;
                this.mInitialMotionY = this.mInitialDownY + this.mTouchSlop;
            } else if (this.mIsBeingDragged) {
            } else {
                int i2 = this.mTouchSlop;
                if (f3 > i2) {
                    this.mInitialMotionY = this.mInitialDownY + i2;
                    this.mIsBeingDragged = true;
                }
            }
        }
    }

    private boolean isTargetValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (this.mTarget == getChildAt(i2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void measureRefreshView(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65561, this, i2, i3) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRefreshView.getLayoutParams();
            this.mRefreshView.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        }
    }

    private void measureStateViewIfNecessary() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (view = this.mStateView) == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    private void measureTarget() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            this.mTarget.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    private void moveSpinner(float f2, boolean z) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            this.mCurrentTouchOffsetY = f2;
            d dVar = this.mOnScrollInterceptor;
            int i2 = 0;
            if (dVar == null || !dVar.a(f2, false)) {
                if (this.mIsRefreshing) {
                    f3 = this.mRefreshTargetOffset;
                    if (f2 <= f3) {
                        f3 = f2;
                    }
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                } else {
                    f3 = AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1 ? this.mDragDistanceConverter.a(f2, this.mRefreshTargetOffset) : this.mRefreshInitialOffset + this.mDragDistanceConverter.a(f2, this.mRefreshTargetOffset);
                }
                float f4 = this.mRefreshTargetOffset;
                if (!this.mIsRefreshing) {
                    if (f3 > f4 && !this.mIsFitRefresh) {
                        this.mIsFitRefresh = true;
                        this.mRefreshStatus.d();
                        c cVar = this.mOnRefreshStatusListener;
                        if (cVar != null) {
                            cVar.a();
                        }
                        if (this.mOnRefreshStatusListeners != null) {
                            while (i2 < this.mOnRefreshStatusListeners.size()) {
                                this.mOnRefreshStatusListeners.get(i2).a();
                                i2++;
                            }
                        }
                    } else if (f3 <= f4 && this.mIsFitRefresh) {
                        this.mIsFitRefresh = false;
                        this.mRefreshStatus.e();
                        c cVar2 = this.mOnRefreshStatusListener;
                        if (cVar2 != null) {
                            cVar2.b();
                        }
                        if (this.mOnRefreshStatusListeners != null) {
                            while (i2 < this.mOnRefreshStatusListeners.size()) {
                                this.mOnRefreshStatusListeners.get(i2).b();
                                i2++;
                            }
                        }
                    }
                }
                String str = f2 + " -- " + f4 + " -- " + f3 + " -- " + this.mTargetOrRefreshViewOffsetY + " -- " + this.mRefreshTargetOffset;
                setTargetOrRefreshViewOffsetY((int) (f3 - this.mTargetOrRefreshViewOffsetY), z);
            }
        }
    }

    private void onNewerPointerDown(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, motionEvent) == null) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
            this.mActivePointerId = pointerId;
            this.mInitialMotionY = getMotionEventY(motionEvent, pointerId) - this.mCurrentTouchOffsetY;
            String str = " onDown " + this.mInitialMotionY;
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
            }
            this.mInitialMotionY = getMotionEventY(motionEvent, this.mActivePointerId) - this.mCurrentTouchOffsetY;
            String str = " onUp " + this.mInitialMotionY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            setTargetOrRefreshViewToInitial();
            this.mCurrentTouchOffsetY = 0.0f;
            this.mRefreshResistanceIncremental = 0.0f;
            this.mRefreshStatus.a();
            this.mRefreshView.setVisibility(8);
            this.mIsRefreshing = false;
            this.mIsAnimatingToStart = false;
        }
    }

    private void resetTouchEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.mInitialScrollY = 0.0f;
            this.mIsBeingDragged = false;
            this.mDispatchTargetTouchDown = false;
            this.mActivePointerId = -1;
        }
    }

    private int reviseRefreshViewLayoutTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65569, this, i2)) == null) {
            int i3 = AnonymousClass6.a[this.mRefreshStyle.ordinal()];
            return (i3 == 1 || i3 != 2) ? i2 + ((int) this.mTargetOrRefreshViewOffsetY) : i2;
        }
        return invokeI.intValue;
    }

    private int reviseTargetLayoutTop(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65570, this, i2)) == null) ? AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1 ? i2 + ((int) this.mTargetOrRefreshViewOffsetY) : i2 : invokeI.intValue;
    }

    private void setRefreshing(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65571, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.mIsRefreshing == z) {
            return;
        }
        this.mNotifyListener = z2;
        this.mIsRefreshing = z;
        if (z) {
            animateToRefreshingPosition((int) this.mTargetOrRefreshViewOffsetY, this.mRefreshingListener);
            return;
        }
        this.mRefreshStatus.c();
        UI_HANDLER.postDelayed(new Runnable(this) { // from class: com.kwai.library.widget.refresh.RefreshLayout.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RefreshLayout a;

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
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    RefreshLayout refreshLayout = this.a;
                    refreshLayout.animateOffsetToStartPosition((int) refreshLayout.mTargetOrRefreshViewOffsetY, refreshLayout.mResetListener);
                }
            }
        }, this.mRefreshStatus.f());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setTargetOrRefreshViewOffsetY(int i2, boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65572, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.mTarget == null) {
            return;
        }
        int i3 = AnonymousClass6.a[this.mRefreshStyle.ordinal()];
        if (i3 == 1) {
            this.mRefreshView.offsetTopAndBottom(i2);
            view = this.mRefreshView;
        } else if (i3 != 2) {
            this.mTarget.offsetTopAndBottom(i2);
            View view2 = this.mStateView;
            if (view2 != null) {
                view2.offsetTopAndBottom(i2);
            } else {
                float f2 = (i2 / this.mRefreshResistanceRate) + this.mRefreshResistanceIncremental;
                int i4 = (int) f2;
                this.mRefreshResistanceIncremental = f2 - i4;
                this.mRefreshView.offsetTopAndBottom(i4);
            }
            this.mTargetOrRefreshViewOffsetY = this.mTarget.getTop();
            String str = "refresh style" + this.mTargetOrRefreshViewOffsetY;
            String str2 = "current offset" + this.mTargetOrRefreshViewOffsetY;
            if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] == 1) {
                f fVar = this.mRefreshStatus;
                float f3 = this.mTargetOrRefreshViewOffsetY;
                fVar.a(f3, f3 / this.mRefreshTargetOffset);
                c cVar = this.mOnRefreshStatusListener;
                if (cVar != null) {
                    float f4 = this.mTargetOrRefreshViewOffsetY;
                    cVar.a(f4, f4 / this.mRefreshTargetOffset, z);
                }
                if (this.mOnRefreshStatusListeners != null) {
                    for (int i5 = 0; i5 < this.mOnRefreshStatusListeners.size(); i5++) {
                        float f5 = this.mTargetOrRefreshViewOffsetY;
                        this.mOnRefreshStatusListeners.get(i5).a(f5, f5 / this.mRefreshTargetOffset, z);
                    }
                }
            } else {
                f fVar2 = this.mRefreshStatus;
                float f6 = this.mTargetOrRefreshViewOffsetY;
                fVar2.a(f6, (f6 - this.mRefreshInitialOffset) / this.mRefreshTargetOffset);
                c cVar2 = this.mOnRefreshStatusListener;
                if (cVar2 != null) {
                    float f7 = this.mTargetOrRefreshViewOffsetY;
                    cVar2.a(f7, (f7 - this.mRefreshInitialOffset) / this.mRefreshTargetOffset, z);
                }
                if (this.mOnRefreshStatusListeners != null) {
                    for (int i6 = 0; i6 < this.mOnRefreshStatusListeners.size(); i6++) {
                        float f8 = this.mTargetOrRefreshViewOffsetY;
                        this.mOnRefreshStatusListeners.get(i6).a(f8, (f8 - this.mRefreshInitialOffset) / this.mRefreshTargetOffset, z);
                    }
                }
            }
            if (this.mShowRefreshView && this.mRefreshView.getVisibility() != 0) {
                this.mRefreshView.setVisibility(0);
            }
            invalidate();
        } else {
            this.mTarget.offsetTopAndBottom(i2);
            View view3 = this.mStateView;
            if (view3 != null) {
                view3.offsetTopAndBottom(i2);
            }
            view = this.mTarget;
        }
        this.mTargetOrRefreshViewOffsetY = view.getTop();
        String str22 = "current offset" + this.mTargetOrRefreshViewOffsetY;
        if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] == 1) {
        }
        if (this.mShowRefreshView) {
            this.mRefreshView.setVisibility(0);
        }
        invalidate();
    }

    private void setTargetOrRefreshViewToInitial() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            setTargetOrRefreshViewOffsetY((int) ((AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1 ? 0.0f : this.mRefreshInitialOffset) - this.mTargetOrRefreshViewOffsetY));
        }
    }

    public void addOnRefreshStatusListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (this.mOnRefreshStatusListeners == null) {
                this.mOnRefreshStatusListeners = new ArrayList();
            }
            if (cVar == null || this.mOnRefreshStatusListeners.contains(cVar)) {
                return;
            }
            this.mOnRefreshStatusListeners.add(cVar);
        }
    }

    public void animateOffsetToStartPosition(int i2, Animation.AnimationListener animationListener) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, animationListener) == null) {
            clearAnimation();
            if (computeAnimateToStartDuration(i2) <= 0) {
                animationListener.onAnimationStart(null);
                animationListener.onAnimationEnd(null);
                return;
            }
            this.mFrom = i2;
            this.mAnimateToStartAnimation.reset();
            this.mAnimateToStartAnimation.setDuration(computeAnimateToStartDuration(f2));
            this.mAnimateToStartAnimation.setInterpolator(this.mAnimateToStartInterpolator);
            if (animationListener != null) {
                this.mAnimateToStartAnimation.setAnimationListener(animationListener);
            }
            startAnimation(this.mAnimateToStartAnimation);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? layoutParams instanceof a : invokeL.booleanValue;
    }

    public void createRefreshView(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, attributeSet) == null) {
            View onCreateRefreshView = onCreateRefreshView(attributeSet);
            this.mRefreshView = onCreateRefreshView;
            onCreateRefreshView.setVisibility(8);
            View view = this.mRefreshView;
            if (!(view instanceof f)) {
                throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
            }
            this.mRefreshStatus = (f) view;
            a onCreateLayoutParams = onCreateLayoutParams(attributeSet);
            if (onCreateLayoutParams == null) {
                int i2 = this.mRefreshViewSize;
                onCreateLayoutParams = new a(i2, i2);
            }
            addView(this.mRefreshView, onCreateLayoutParams);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.mNestedScrollingChildHelper.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.mNestedScrollingChildHelper.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.mNestedScrollingChildHelper.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int actionMasked;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.mIsStopNestScrollWhenUpOrCancel && ((actionMasked = MotionEventCompat.getActionMasked(motionEvent)) == 1 || actionMasked == 3)) {
                onStopNestedScroll(this);
            }
            String str = "dispatch " + this.mDispatchTargetTouchDown + " isRefreshing" + this.mIsRefreshing;
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new a(-2, -2) : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, attributeSet)) == null) ? new a(getContext(), attributeSet) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, layoutParams)) == null) ? new a(layoutParams) : (a) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) {
            if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1) {
                int i4 = this.mRefreshViewIndex;
                return i4 < 0 ? i3 : i3 == 0 ? i4 : i3 <= i4 ? i3 - 1 : i3;
            }
            int i5 = this.mRefreshViewIndex;
            return i5 < 0 ? i3 : i3 == i2 - 1 ? i5 : i3 >= i5 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mNestedScrollingParentHelper.getNestedScrollAxes() : invokeV.intValue;
    }

    public float getRefreshTargetOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mRefreshTargetOffset : invokeV.floatValue;
    }

    @Nullable
    public View getStateView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mStateView : (View) invokeV.objValue;
    }

    public int getTargetOrRefreshViewOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1) {
                View view = this.mTarget;
                if (view == null) {
                    return 0;
                }
                return view.getTop();
            }
            return (int) (this.mRefreshView.getTop() - this.mRefreshInitialOffset);
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mNestedScrollingChildHelper.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public void hideStateView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            View view = this.mStateView;
            if (view != null && view.getVisibility() != 8) {
                this.mStateView.setVisibility(8);
            }
            this.mStateView = null;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mNestedScrollingChildHelper.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public boolean isRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mIsRefreshing : invokeV.booleanValue;
    }

    public abstract com.kwai.library.widget.refresh.c onCreateDragDistanceConvert();

    public a onCreateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, attributeSet)) == null) {
            return null;
        }
        return (a) invokeL.objValue;
    }

    public abstract View onCreateRefreshView(AttributeSet attributeSet);

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            reset();
            clearAnimation();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, motionEvent)) == null) {
            ensureTarget();
            View view = this.mTarget;
            if (view == null) {
                return false;
            }
            if (!(view instanceof com.kwai.library.widget.refresh.d) || ((com.kwai.library.widget.refresh.d) view).canPullToRefresh()) {
                if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1) {
                    if (!isEnabled() || (canChildScrollUp(this.mTarget) && !this.mDispatchTargetTouchDown)) {
                        return false;
                    }
                } else if (!isEnabled() || canChildScrollUp(this.mTarget) || this.mIsRefreshing || this.mNestedScrollInProgress) {
                    return false;
                }
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked == 2) {
                            int i2 = this.mActivePointerId;
                            if (i2 == -1) {
                                return false;
                            }
                            float motionEventY = getMotionEventY(motionEvent, i2);
                            if (motionEventY == -1.0f) {
                                return false;
                            }
                            initDragStatus(motionEventY);
                            ValueAnimator valueAnimator = this.mRefreshingAnimator;
                            if (valueAnimator != null && valueAnimator.isRunning()) {
                                this.mRefreshingAnimator.cancel();
                                this.mRefreshStatus.c();
                                animateOffsetToStartPosition((int) this.mTargetOrRefreshViewOffsetY, this.mResetListener);
                            }
                        } else if (actionMasked != 3) {
                            if (actionMasked == 6) {
                                onSecondaryPointerUp(motionEvent);
                            }
                        }
                    }
                    this.mIsBeingDragged = false;
                    this.mActivePointerId = -1;
                } else {
                    int pointerId = motionEvent.getPointerId(0);
                    this.mActivePointerId = pointerId;
                    this.mIsBeingDragged = false;
                    float motionEventY2 = getMotionEventY(motionEvent, pointerId);
                    if (motionEventY2 == -1.0f) {
                        return false;
                    }
                    if (this.mAnimateToRefreshingAnimation.hasEnded() && this.mAnimateToStartAnimation.hasEnded()) {
                        this.mIsAnimatingToStart = false;
                    }
                    this.mInitialDownY = motionEventY2;
                    this.mInitialScrollY = this.mTargetOrRefreshViewOffsetY;
                    this.mDispatchTargetTouchDown = false;
                }
                return this.mIsBeingDragged;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || getChildCount() == 0) {
            return;
        }
        ensureTarget();
        if (this.mTarget == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.mTarget.getVisibility() != 8 || ((view = this.mStateView) != null && view.getVisibility() != 8)) {
            int reviseTargetLayoutTop = reviseTargetLayoutTop(getPaddingTop());
            int paddingLeft = getPaddingLeft();
            int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((measuredHeight + reviseTargetLayoutTop) - getPaddingTop()) - getPaddingBottom();
            if (this.mTarget.getVisibility() != 8) {
                this.mTarget.layout(paddingLeft, reviseTargetLayoutTop, paddingLeft2, paddingTop);
            }
            View view2 = this.mStateView;
            if (view2 != null && view2.getVisibility() != 8) {
                this.mStateView.layout(paddingLeft, reviseTargetLayoutTop, paddingLeft2, paddingTop);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRefreshView.getLayoutParams();
        int reviseRefreshViewLayoutTop = (reviseRefreshViewLayoutTop((int) this.mRefreshInitialOffset) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.mRefreshView.layout((measuredWidth - this.mRefreshView.getMeasuredWidth()) / 2, reviseRefreshViewLayoutTop, (measuredWidth + this.mRefreshView.getMeasuredWidth()) / 2, this.mRefreshView.getMeasuredHeight() + reviseRefreshViewLayoutTop);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            ensureTarget();
            if (this.mTarget == null) {
                return;
            }
            measureTarget();
            measureStateViewIfNecessary();
            measureRefreshView(i2, i3);
            if (!this.mRefreshViewMeasured && !this.mUsingCustomRefreshInitialOffset) {
                int i4 = AnonymousClass6.a[this.mRefreshStyle.ordinal()];
                if (i4 == 1) {
                    float f2 = -this.mRefreshView.getMeasuredHeight();
                    this.mRefreshInitialOffset = f2;
                    this.mTargetOrRefreshViewOffsetY = f2;
                } else if (i4 != 2) {
                    this.mTargetOrRefreshViewOffsetY = 0.0f;
                    this.mRefreshInitialOffset = -this.mRefreshView.getMeasuredHeight();
                } else {
                    this.mRefreshInitialOffset = 0.0f;
                    this.mTargetOrRefreshViewOffsetY = 0.0f;
                }
            }
            if (!this.mRefreshViewMeasured && !this.mUsingCustomRefreshTargetOffset && this.mRefreshTargetOffset < this.mRefreshView.getMeasuredHeight()) {
                this.mRefreshTargetOffset = this.mRefreshView.getMeasuredHeight();
            }
            this.mRefreshViewMeasured = true;
            this.mRefreshViewIndex = -1;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.mRefreshView) {
                    this.mRefreshViewIndex = i5;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) ? dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            if (i3 > 0) {
                float f2 = this.mTotalUnconsumed;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.mTotalUnconsumed = 0.0f;
                    } else {
                        this.mTotalUnconsumed = f2 - f3;
                        iArr[1] = i3;
                    }
                    moveSpinner(this.mTotalUnconsumed, false);
                }
            }
            int[] iArr2 = this.mParentScrollConsumed;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.mParentOffsetInWindow);
            if (i5 + this.mParentOffsetInWindow[1] < 0) {
                this.mTotalUnconsumed += Math.abs(i6);
                moveSpinner(this.mTotalUnconsumed, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048611, this, view, view2, i2) == null) {
            this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i2);
            startNestedScroll(i2 & 2);
            this.mTotalUnconsumed = 0.0f;
            this.mNestedScrollInProgress = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048612, this, view, view2, i2)) == null) ? AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1 ? isEnabled() && canChildScrollUp(this.mTarget) && (i2 & 2) != 0 : isEnabled() && canChildScrollUp(this.mTarget) && !this.mIsRefreshing && (i2 & 2) != 0 : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            this.mNestedScrollingParentHelper.onStopNestedScroll(view);
            this.mNestedScrollInProgress = false;
            if (this.mTotalUnconsumed > 0.0f) {
                finishSpinner();
                this.mTotalUnconsumed = 0.0f;
            }
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f2;
        StringBuilder sb;
        float f3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            ensureTarget();
            if (this.mTarget == null) {
                return false;
            }
            if (AnonymousClass6.a[this.mRefreshStyle.ordinal()] != 1) {
                if (!isEnabled() || (canChildScrollUp(this.mTarget) && !this.mDispatchTargetTouchDown)) {
                    return false;
                }
            } else if (!isEnabled() || canChildScrollUp(this.mTarget) || this.mNestedScrollInProgress) {
                return false;
            }
            if (this.mRefreshStyle == RefreshStyle.FLOAT && (canChildScrollUp(this.mTarget) || this.mNestedScrollInProgress)) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = this.mActivePointerId;
                        if (i2 == -1) {
                            return false;
                        }
                        float motionEventY = getMotionEventY(motionEvent, i2);
                        if (motionEventY == -1.0f) {
                            return false;
                        }
                        if (this.mIsAnimatingToStart) {
                            f2 = getTargetOrRefreshViewTop();
                            this.mInitialMotionY = motionEventY;
                            this.mInitialScrollY = f2;
                            sb = new StringBuilder();
                            sb.append("animatetostart overscrolly ");
                            sb.append(f2);
                            sb.append(" -- ");
                            f3 = this.mInitialMotionY;
                        } else {
                            f2 = (motionEventY - this.mInitialMotionY) + this.mInitialScrollY;
                            sb = new StringBuilder();
                            sb.append("overscrolly ");
                            sb.append(f2);
                            sb.append(" --");
                            sb.append(this.mInitialMotionY);
                            sb.append(" -- ");
                            f3 = this.mInitialScrollY;
                        }
                        sb.append(f3);
                        sb.toString();
                        if (this.mIsRefreshing) {
                            if (f2 > 0.0f) {
                                if (f2 > 0.0f && f2 < this.mRefreshTargetOffset && this.mDispatchTargetTouchDown) {
                                    motionEvent = MotionEvent.obtain(motionEvent);
                                    motionEvent.setAction(3);
                                    this.mDispatchTargetTouchDown = false;
                                }
                                r0 = "moveSpinner refreshing -- " + this.mInitialScrollY + " -- " + (motionEventY - this.mInitialMotionY);
                                moveSpinner(f2, true);
                            } else if (!this.mDispatchTargetTouchDown) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(0);
                                this.mDispatchTargetTouchDown = true;
                            }
                            this.mTarget.dispatchTouchEvent(motionEvent);
                            r0 = "moveSpinner refreshing -- " + this.mInitialScrollY + " -- " + (motionEventY - this.mInitialMotionY);
                            moveSpinner(f2, true);
                        } else if (!this.mIsBeingDragged) {
                            initDragStatus(motionEventY);
                        } else if (f2 <= 0.0f) {
                            return false;
                        } else {
                            moveSpinner(f2, true);
                            str = "moveSpinner not refreshing -- " + this.mInitialScrollY + " -- " + (motionEventY - this.mInitialMotionY);
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            onNewerPointerDown(motionEvent);
                        } else if (action == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                }
                int i3 = this.mActivePointerId;
                if (i3 == -1 || getMotionEventY(motionEvent, i3) == -1.0f) {
                    resetTouchEvent();
                    return false;
                } else if (!this.mIsRefreshing && !this.mIsAnimatingToStart) {
                    resetTouchEvent();
                    finishSpinner();
                    return false;
                } else {
                    if (this.mDispatchTargetTouchDown) {
                        this.mTarget.dispatchTouchEvent(motionEvent);
                    }
                    resetTouchEvent();
                    return false;
                }
            }
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mIsBeingDragged = false;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeOnRefreshStatusListener(c cVar) {
        List<c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, cVar) == null) || cVar == null || (list = this.mOnRefreshStatusListeners) == null || !list.contains(cVar)) {
            return;
        }
        this.mOnRefreshStatusListeners.remove(cVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) {
                View view = this.mTarget;
                if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    public void setAnimateToRefreshDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.mAnimateToRefreshDuration = i2;
        }
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, interpolator) == null) {
            this.mAnimateToRefreshInterpolator = interpolator;
        }
    }

    public void setAnimateToStartDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.mAnimateToStartDuration = i2;
        }
    }

    public void setAnimateToStartInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, interpolator) == null) {
            this.mAnimateToStartInterpolator = interpolator;
        }
    }

    public void setDragDistanceConverter(@NonNull com.kwai.library.widget.refresh.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, cVar) == null) {
            if (cVar == null) {
                throw new NullPointerException("the dragDistanceConverter can't be null");
            }
            this.mDragDistanceConverter = cVar;
        }
    }

    public void setIsStopNestScrollWhenUpOrCancel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.mIsStopNestScrollWhenUpOrCancel = z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
        }
    }

    public void setOnRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bVar) == null) {
            this.mOnRefreshListener = bVar;
        }
    }

    public void setOnRefreshStatusListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, cVar) == null) {
            this.mOnRefreshStatusListener = cVar;
        }
    }

    public void setOnScrollInterceptor(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, dVar) == null) {
            this.mOnScrollInterceptor = dVar;
        }
    }

    public void setOnlySupportPull(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.mOnlySupportPull = z;
        }
    }

    public void setRefreshInitialOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f2) == null) {
            this.mRefreshInitialOffset = f2;
            this.mUsingCustomRefreshInitialOffset = true;
            requestLayout();
        }
    }

    public void setRefreshStyle(@NonNull RefreshStyle refreshStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, refreshStyle) == null) {
            this.mRefreshStyle = refreshStyle;
        }
    }

    public void setRefreshTargetOffset(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048630, this, f2) == null) {
            this.mRefreshTargetOffset = f2;
            this.mUsingCustomRefreshTargetOffset = true;
            requestLayout();
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z) == null) || this.mIsRefreshing == z) {
            return;
        }
        if (!z) {
            setRefreshing(z, false);
            return;
        }
        if (getAnimation() != null && !getAnimation().hasEnded()) {
            getAnimation().setAnimationListener(null);
            clearAnimation();
            reset();
        }
        this.mIsRefreshing = z;
        this.mNotifyListener = false;
        animateToRefreshingPosition((int) this.mTargetOrRefreshViewOffsetY, this.mRefreshingListener);
    }

    public void setShowRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            setOnlySupportPull(!z);
            this.mShowRefreshView = z;
        }
    }

    public void setTargetOrRefreshViewOffsetY(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            setTargetOrRefreshViewOffsetY(i2, false);
        }
    }

    public boolean shouldRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? !this.mOnlySupportPull && ((float) getTargetOrRefreshViewOffset()) > this.mRefreshTargetOffset : invokeV.booleanValue;
    }

    public void showStateView(@Nullable View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, view) == null) || view == this.mStateView) {
            return;
        }
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (view != null) {
            view.setVisibility(0);
            addView(view);
        }
        this.mStateView = view;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) ? this.mNestedScrollingChildHelper.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.mNestedScrollingChildHelper.stopNestedScroll();
        }
    }
}
