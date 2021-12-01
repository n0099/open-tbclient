package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
@ViewPager.DecorView
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_DURATION = 300;
    @Dimension(unit = 0)
    public static final int DEFAULT_GAP_TEXT_ICON = 8;
    @Dimension(unit = 0)
    public static final int DEFAULT_HEIGHT = 48;
    @Dimension(unit = 0)
    public static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    public static final int DEF_STYLE_RES;
    @Dimension(unit = 0)
    public static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    public static final int INVALID_WIDTH = -1;
    public static final String LOG_TAG = "TabLayout";
    @Dimension(unit = 0)
    public static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    @Dimension(unit = 0)
    public static final int TAB_MIN_WIDTH_MARGIN = 56;
    public static final Pools.Pool<Tab> tabPool;
    public transient /* synthetic */ FieldHolder $fh;
    public AdapterChangeListener adapterChangeListener;
    public int contentInsetStart;
    @Nullable
    public BaseOnTabSelectedListener currentVpSelectedListener;
    public boolean inlineLabel;
    public int mode;
    public TabLayoutOnPageChangeListener pageChangeListener;
    @Nullable
    public PagerAdapter pagerAdapter;
    public DataSetObserver pagerAdapterObserver;
    public final int requestedTabMaxWidth;
    public final int requestedTabMinWidth;
    public ValueAnimator scrollAnimator;
    public final int scrollableTabMinWidth;
    @Nullable
    public BaseOnTabSelectedListener selectedListener;
    public final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    @Nullable
    public Tab selectedTab;
    public boolean setupViewPagerImplicitly;
    @NonNull
    public final SlidingTabIndicator slidingTabIndicator;
    public final int tabBackgroundResId;
    public int tabGravity;
    public ColorStateList tabIconTint;
    public PorterDuff.Mode tabIconTintMode;
    public int tabIndicatorAnimationDuration;
    public boolean tabIndicatorFullWidth;
    public int tabIndicatorGravity;
    public int tabMaxWidth;
    public int tabPaddingBottom;
    public int tabPaddingEnd;
    public int tabPaddingStart;
    public int tabPaddingTop;
    public ColorStateList tabRippleColorStateList;
    @Nullable
    public Drawable tabSelectedIndicator;
    public int tabTextAppearance;
    public ColorStateList tabTextColors;
    public float tabTextMultiLineSize;
    public float tabTextSize;
    public final RectF tabViewContentBounds;
    public final Pools.Pool<TabView> tabViewPool;
    public final ArrayList<Tab> tabs;
    public boolean unboundedRipple;
    @Nullable
    public ViewPager viewPager;

    /* loaded from: classes2.dex */
    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean autoRefresh;
        public final /* synthetic */ TabLayout this$0;

        public AdapterChangeListener(TabLayout tabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, viewPager, pagerAdapter, pagerAdapter2) == null) {
                TabLayout tabLayout = this.this$0;
                if (tabLayout.viewPager == viewPager) {
                    tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
                }
            }
        }

        public void setAutoRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.autoRefresh = z;
            }
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    /* loaded from: classes2.dex */
    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface Mode {
    }

    /* loaded from: classes2.dex */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* loaded from: classes2.dex */
    public class PagerAdapterObserver extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabLayout this$0;

        public PagerAdapterObserver(TabLayout tabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayout;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.populateFromPagerAdapter();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.populateFromPagerAdapter();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SlidingTabIndicator extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int animationStartLeft;
        public int animationStartRight;
        @NonNull
        public final GradientDrawable defaultSelectionIndicator;
        public ValueAnimator indicatorAnimator;
        public int indicatorLeft;
        public int indicatorRight;
        public int layoutDirection;
        public int selectedIndicatorHeight;
        @NonNull
        public final Paint selectedIndicatorPaint;
        public int selectedPosition;
        public float selectionOffset;
        public final /* synthetic */ TabLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlidingTabIndicator(TabLayout tabLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayout;
            this.selectedPosition = -1;
            this.layoutDirection = -1;
            this.indicatorLeft = -1;
            this.indicatorRight = -1;
            this.animationStartLeft = -1;
            this.animationStartRight = -1;
            setWillNotDraw(false);
            this.selectedIndicatorPaint = new Paint();
            this.defaultSelectionIndicator = new GradientDrawable();
        }

        private void calculateTabViewContentBounds(@NonNull TabView tabView, @NonNull RectF rectF) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, tabView, rectF) == null) {
                int contentWidth = tabView.getContentWidth();
                int dpToPx = (int) ViewUtils.dpToPx(getContext(), 24);
                if (contentWidth < dpToPx) {
                    contentWidth = dpToPx;
                }
                int left = (tabView.getLeft() + tabView.getRight()) / 2;
                int i2 = contentWidth / 2;
                rectF.set(left - i2, 0.0f, left + i2, 0.0f);
            }
        }

        private void updateIndicatorPosition() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                View childAt = getChildAt(this.selectedPosition);
                if (childAt == null || childAt.getWidth() <= 0) {
                    i2 = -1;
                    i3 = -1;
                } else {
                    i2 = childAt.getLeft();
                    i3 = childAt.getRight();
                    TabLayout tabLayout = this.this$0;
                    if (!tabLayout.tabIndicatorFullWidth && (childAt instanceof TabView)) {
                        calculateTabViewContentBounds((TabView) childAt, tabLayout.tabViewContentBounds);
                        i2 = (int) this.this$0.tabViewContentBounds.left;
                        i3 = (int) this.this$0.tabViewContentBounds.right;
                    }
                    if (this.selectionOffset > 0.0f && this.selectedPosition < getChildCount() - 1) {
                        View childAt2 = getChildAt(this.selectedPosition + 1);
                        int left = childAt2.getLeft();
                        int right = childAt2.getRight();
                        TabLayout tabLayout2 = this.this$0;
                        if (!tabLayout2.tabIndicatorFullWidth && (childAt2 instanceof TabView)) {
                            calculateTabViewContentBounds((TabView) childAt2, tabLayout2.tabViewContentBounds);
                            left = (int) this.this$0.tabViewContentBounds.left;
                            right = (int) this.this$0.tabViewContentBounds.right;
                        }
                        float f2 = this.selectionOffset;
                        i2 = (int) ((left * f2) + ((1.0f - f2) * i2));
                        i3 = (int) ((right * f2) + ((1.0f - f2) * i3));
                    }
                }
                setIndicatorPosition(i2, i3);
            }
        }

        private void updateOrRecreateIndicatorAnimation(boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                View childAt = getChildAt(i2);
                if (childAt == null) {
                    updateIndicatorPosition();
                    return;
                }
                int left = childAt.getLeft();
                int right = childAt.getRight();
                TabLayout tabLayout = this.this$0;
                if (!tabLayout.tabIndicatorFullWidth && (childAt instanceof TabView)) {
                    calculateTabViewContentBounds((TabView) childAt, tabLayout.tabViewContentBounds);
                    left = (int) this.this$0.tabViewContentBounds.left;
                    right = (int) this.this$0.tabViewContentBounds.right;
                }
                int i4 = this.indicatorLeft;
                int i5 = this.indicatorRight;
                if (i4 == left && i5 == right) {
                    return;
                }
                if (z) {
                    this.animationStartLeft = i4;
                    this.animationStartRight = i5;
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(this, left, right) { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SlidingTabIndicator this$1;
                    public final /* synthetic */ int val$finalTargetLeft;
                    public final /* synthetic */ int val$finalTargetRight;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(left), Integer.valueOf(right)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$finalTargetLeft = left;
                        this.val$finalTargetRight = right;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            SlidingTabIndicator slidingTabIndicator = this.this$1;
                            slidingTabIndicator.setIndicatorPosition(AnimationUtils.lerp(slidingTabIndicator.animationStartLeft, this.val$finalTargetLeft, animatedFraction), AnimationUtils.lerp(this.this$1.animationStartRight, this.val$finalTargetRight, animatedFraction));
                        }
                    }
                };
                if (z) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.indicatorAnimator = valueAnimator;
                    valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                    valueAnimator.setDuration(i3);
                    valueAnimator.setFloatValues(0.0f, 1.0f);
                    valueAnimator.addUpdateListener(animatorUpdateListener);
                    valueAnimator.addListener(new AnimatorListenerAdapter(this, i2) { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SlidingTabIndicator this$1;
                        public final /* synthetic */ int val$position;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$position = i2;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                                SlidingTabIndicator slidingTabIndicator = this.this$1;
                                slidingTabIndicator.selectedPosition = this.val$position;
                                slidingTabIndicator.selectionOffset = 0.0f;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                                this.this$1.selectedPosition = this.val$position;
                            }
                        }
                    });
                    valueAnimator.start();
                    return;
                }
                this.indicatorAnimator.removeAllUpdateListeners();
                this.indicatorAnimator.addUpdateListener(animatorUpdateListener);
            }
        }

        public void animateIndicatorToPosition(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                ValueAnimator valueAnimator = this.indicatorAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.indicatorAnimator.cancel();
                }
                updateOrRecreateIndicatorAnimation(true, i2, i3);
            }
        }

        public boolean childrenNeedLayout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (getChildAt(i2).getWidth() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
                Drawable drawable = this.this$0.tabSelectedIndicator;
                int i2 = 0;
                int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
                int i3 = this.selectedIndicatorHeight;
                if (i3 >= 0) {
                    intrinsicHeight = i3;
                }
                int i4 = this.this$0.tabIndicatorGravity;
                if (i4 == 0) {
                    i2 = getHeight() - intrinsicHeight;
                    intrinsicHeight = getHeight();
                } else if (i4 == 1) {
                    i2 = (getHeight() - intrinsicHeight) / 2;
                    intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
                } else if (i4 != 2) {
                    intrinsicHeight = i4 != 3 ? 0 : getHeight();
                }
                int i5 = this.indicatorLeft;
                if (i5 >= 0 && this.indicatorRight > i5) {
                    Drawable drawable2 = this.this$0.tabSelectedIndicator;
                    if (drawable2 == null) {
                        drawable2 = this.defaultSelectionIndicator;
                    }
                    Drawable mutate = DrawableCompat.wrap(drawable2).mutate();
                    mutate.setBounds(this.indicatorLeft, i2, this.indicatorRight, intrinsicHeight);
                    Paint paint = this.selectedIndicatorPaint;
                    if (paint != null) {
                        if (Build.VERSION.SDK_INT == 21) {
                            mutate.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                        } else {
                            DrawableCompat.setTint(mutate, paint.getColor());
                        }
                    }
                    mutate.draw(canvas);
                }
                super.draw(canvas);
            }
        }

        public float getIndicatorPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.selectedPosition + this.selectionOffset : invokeV.floatValue;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onLayout(z, i2, i3, i4, i5);
                ValueAnimator valueAnimator = this.indicatorAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
                } else {
                    updateIndicatorPosition();
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                super.onMeasure(i2, i3);
                if (View.MeasureSpec.getMode(i2) != 1073741824) {
                    return;
                }
                TabLayout tabLayout = this.this$0;
                boolean z = true;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 <= 0) {
                        return;
                    }
                    if (i4 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                        boolean z2 = false;
                        for (int i6 = 0; i6 < childCount; i6++) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                            if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                z2 = true;
                            }
                        }
                        z = z2;
                    } else {
                        TabLayout tabLayout2 = this.this$0;
                        tabLayout2.tabGravity = 0;
                        tabLayout2.updateTabViews(false);
                    }
                    if (z) {
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                super.onRtlPropertiesChanged(i2);
                if (Build.VERSION.SDK_INT >= 23 || this.layoutDirection == i2) {
                    return;
                }
                requestLayout();
                this.layoutDirection = i2;
            }
        }

        public void setIndicatorPosition(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
                if (i2 == this.indicatorLeft && i3 == this.indicatorRight) {
                    return;
                }
                this.indicatorLeft = i2;
                this.indicatorRight = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void setIndicatorPositionFromTabPosition(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
                ValueAnimator valueAnimator = this.indicatorAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.indicatorAnimator.cancel();
                }
                this.selectedPosition = i2;
                this.selectionOffset = f2;
                updateIndicatorPosition();
            }
        }

        public void setSelectedIndicatorColor(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.selectedIndicatorPaint.getColor() == i2) {
                return;
            }
            this.selectedIndicatorPaint.setColor(i2);
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public void setSelectedIndicatorHeight(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.selectedIndicatorHeight == i2) {
                return;
            }
            this.selectedIndicatorHeight = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface TabIndicatorGravity {
    }

    /* loaded from: classes2.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int previousScrollState;
        public int scrollState;
        @NonNull
        public final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.previousScrollState = this.scrollState;
                this.scrollState = i2;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (tabLayout = this.tabLayoutRef.get()) == null) {
                return;
            }
            boolean z = false;
            tabLayout.setScrollPosition(i2, f2, this.scrollState != 2 || this.previousScrollState == 1, (this.scrollState == 2 && this.previousScrollState == 0) ? true : true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabLayout tabLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (tabLayout = this.tabLayoutRef.get()) == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.scrollState;
            tabLayout.selectTab(tabLayout.getTabAt(i2), i3 == 0 || (i3 == 2 && this.previousScrollState == 0));
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.scrollState = 0;
                this.previousScrollState = 0;
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class TabView extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public View badgeAnchorView;
        @Nullable
        public BadgeDrawable badgeDrawable;
        @Nullable
        public Drawable baseBackgroundDrawable;
        @Nullable
        public ImageView customIconView;
        @Nullable
        public TextView customTextView;
        @Nullable
        public View customView;
        public int defaultMaxLines;
        public ImageView iconView;
        public Tab tab;
        public TextView textView;
        public final /* synthetic */ TabLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabView(@NonNull TabLayout tabLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayout;
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(context);
            ViewCompat.setPaddingRelative(this, tabLayout.tabPaddingStart, tabLayout.tabPaddingTop, tabLayout.tabPaddingEnd, tabLayout.tabPaddingBottom);
            setGravity(17);
            setOrientation(!tabLayout.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void addOnLayoutChangeListener(@Nullable View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65546, this, view) == null) || view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this, view) { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TabView this$1;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$view = view;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) && this.val$view.getVisibility() == 0) {
                        this.this$1.tryUpdateBadgeDrawableBounds(this.val$view);
                    }
                }
            });
        }

        private float approximateLineWidth(@NonNull Layout layout, int i2, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{layout, Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize()) : invokeCommon.floatValue;
        }

        private void clipViewToPaddingForBadge(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
                setClipChildren(z);
                setClipToPadding(z);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(z);
                    viewGroup.setClipToPadding(z);
                }
            }
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                return frameLayout;
            }
            return (FrameLayout) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(@NonNull Canvas canvas) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65550, this, canvas) == null) || (drawable = this.baseBackgroundDrawable) == null) {
                return;
            }
            drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(canvas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.badgeDrawable : (BadgeDrawable) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
                View[] viewArr = {this.textView, this.iconView, this.customView};
                int i2 = 0;
                int i3 = 0;
                boolean z = false;
                for (int i4 = 0; i4 < 3; i4++) {
                    View view = viewArr[i4];
                    if (view != null && view.getVisibility() == 0) {
                        i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                        i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                        z = true;
                    }
                }
                return i2 - i3;
            }
            return invokeV.intValue;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, view)) == null) {
                if ((view == this.iconView || view == this.textView) && BadgeUtils.USE_COMPAT_PARENT) {
                    return (FrameLayout) view.getParent();
                }
                return null;
            }
            return (FrameLayout) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
                if (this.badgeDrawable == null) {
                    this.badgeDrawable = BadgeDrawable.create(getContext());
                }
                tryUpdateBadgeAnchor();
                BadgeDrawable badgeDrawable = this.badgeDrawable;
                if (badgeDrawable != null) {
                    return badgeDrawable;
                }
                throw new IllegalStateException("Unable to create badge");
            }
            return (BadgeDrawable) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? this.badgeDrawable != null : invokeV.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.material.tabs.TabLayout$TabView */
        /* JADX WARN: Multi-variable type inference failed */
        private void inflateAndAddDefaultIconView() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65556, this) == null) {
                if (BadgeUtils.USE_COMPAT_PARENT) {
                    frameLayout = createPreApi18BadgeAnchorRoot();
                    addView(frameLayout, 0);
                } else {
                    frameLayout = this;
                }
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
                this.iconView = imageView;
                frameLayout.addView(imageView, 0);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.material.tabs.TabLayout$TabView */
        /* JADX WARN: Multi-variable type inference failed */
        private void inflateAndAddDefaultTextView() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65557, this) == null) {
                if (BadgeUtils.USE_COMPAT_PARENT) {
                    frameLayout = createPreApi18BadgeAnchorRoot();
                    addView(frameLayout);
                } else {
                    frameLayout = this;
                }
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
                this.textView = textView;
                frameLayout.addView(textView);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeBadge() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65558, this) == null) {
                if (this.badgeAnchorView != null) {
                    tryRemoveBadgeFromAnchor();
                }
                this.badgeDrawable = null;
            }
        }

        private void tryAttachBadgeToAnchor(@Nullable View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65559, this, view) == null) && hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65560, this) == null) && hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                View view = this.badgeAnchorView;
                if (view != null) {
                    BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            Tab tab;
            Tab tab2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65561, this) == null) && hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                } else if (this.iconView != null && (tab2 = this.tab) != null && tab2.getIcon() != null) {
                    View view = this.badgeAnchorView;
                    ImageView imageView = this.iconView;
                    if (view != imageView) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(imageView);
                } else if (this.textView != null && (tab = this.tab) != null && tab.getTabLabelVisibility() == 1) {
                    View view2 = this.badgeAnchorView;
                    TextView textView = this.textView;
                    if (view2 != textView) {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.textView);
                        return;
                    }
                    tryUpdateBadgeDrawableBounds(textView);
                } else {
                    tryRemoveBadgeFromAnchor();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(@NonNull View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65562, this, view) == null) && hasBadgeDrawable() && view == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void updateBackgroundDrawable(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65563, this, context) == null) {
                int i2 = this.this$0.tabBackgroundResId;
                if (i2 != 0) {
                    Drawable drawable = AppCompatResources.getDrawable(context, i2);
                    this.baseBackgroundDrawable = drawable;
                    if (drawable != null && drawable.isStateful()) {
                        this.baseBackgroundDrawable.setState(getDrawableState());
                    }
                } else {
                    this.baseBackgroundDrawable = null;
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(0);
                if (this.this$0.tabRippleColorStateList != null) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(1.0E-5f);
                    gradientDrawable2.setColor(-1);
                    ColorStateList convertToRippleDrawableColor = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (this.this$0.unboundedRipple) {
                            gradientDrawable = null;
                        }
                        gradientDrawable = new RippleDrawable(convertToRippleDrawableColor, gradientDrawable, this.this$0.unboundedRipple ? null : gradientDrawable2);
                    } else {
                        Drawable wrap = DrawableCompat.wrap(gradientDrawable2);
                        DrawableCompat.setTintList(wrap, convertToRippleDrawableColor);
                        gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, wrap});
                    }
                }
                ViewCompat.setBackground(this, gradientDrawable);
                this.this$0.invalidate();
            }
        }

        private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65564, this, textView, imageView) == null) {
                Tab tab = this.tab;
                Drawable mutate = (tab == null || tab.getIcon() == null) ? null : DrawableCompat.wrap(this.tab.getIcon()).mutate();
                Tab tab2 = this.tab;
                CharSequence text = tab2 != null ? tab2.getText() : null;
                if (imageView != null) {
                    if (mutate != null) {
                        imageView.setImageDrawable(mutate);
                        imageView.setVisibility(0);
                        setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                        imageView.setImageDrawable(null);
                    }
                }
                boolean z = !TextUtils.isEmpty(text);
                if (textView != null) {
                    if (z) {
                        textView.setText(text);
                        if (this.tab.labelVisibilityMode == 1) {
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                        setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                        textView.setText((CharSequence) null);
                    }
                }
                if (imageView != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    int dpToPx = (z && imageView.getVisibility() == 0) ? (int) ViewUtils.dpToPx(getContext(), 8) : 0;
                    if (this.this$0.inlineLabel) {
                        if (dpToPx != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, dpToPx);
                            marginLayoutParams.bottomMargin = 0;
                            imageView.setLayoutParams(marginLayoutParams);
                            imageView.requestLayout();
                        }
                    } else if (dpToPx != marginLayoutParams.bottomMargin) {
                        marginLayoutParams.bottomMargin = dpToPx;
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                }
                Tab tab3 = this.tab;
                TooltipCompat.setTooltipText(this, z ? null : tab3 != null ? tab3.contentDesc : null);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.drawableStateChanged();
                int[] drawableState = getDrawableState();
                Drawable drawable = this.baseBackgroundDrawable;
                boolean z = false;
                if (drawable != null && drawable.isStateful()) {
                    z = false | this.baseBackgroundDrawable.setState(drawableState);
                }
                if (z) {
                    invalidate();
                    this.this$0.invalidate();
                }
            }
        }

        @Nullable
        public Tab getTab() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.tab : (Tab) invokeV.objValue;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accessibilityNodeInfo) == null) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                BadgeDrawable badgeDrawable = this.badgeDrawable;
                if (badgeDrawable != null && badgeDrawable.isVisible()) {
                    CharSequence contentDescription = getContentDescription();
                    accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + StringUtil.ARRAY_ELEMENT_SEPARATOR + ((Object) this.badgeDrawable.getContentDescription()));
                }
                AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
                wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
                if (isSelected()) {
                    wrap.setClickable(false);
                    wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                }
                wrap.setRoleDescription("Tab");
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
                int size = View.MeasureSpec.getSize(i2);
                int mode = View.MeasureSpec.getMode(i2);
                int tabMaxWidth = this.this$0.getTabMaxWidth();
                if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                    i2 = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
                }
                super.onMeasure(i2, i3);
                if (this.textView != null) {
                    float f2 = this.this$0.tabTextSize;
                    int i4 = this.defaultMaxLines;
                    ImageView imageView = this.iconView;
                    boolean z = true;
                    if (imageView == null || imageView.getVisibility() != 0) {
                        TextView textView = this.textView;
                        if (textView != null && textView.getLineCount() > 1) {
                            f2 = this.this$0.tabTextMultiLineSize;
                        }
                    } else {
                        i4 = 1;
                    }
                    float textSize = this.textView.getTextSize();
                    int lineCount = this.textView.getLineCount();
                    int maxLines = TextViewCompat.getMaxLines(this.textView);
                    int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                    if (i5 != 0 || (maxLines >= 0 && i4 != maxLines)) {
                        if (this.this$0.mode == 1 && i5 > 0 && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                            z = false;
                        }
                        if (z) {
                            this.textView.setTextSize(0, f2);
                            this.textView.setMaxLines(i4);
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean performClick = super.performClick();
                if (this.tab != null) {
                    if (!performClick) {
                        playSoundEffect(0);
                    }
                    this.tab.select();
                    return true;
                }
                return performClick;
            }
            return invokeV.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                setTab(null);
                setSelected(false);
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                boolean z2 = isSelected() != z;
                super.setSelected(z);
                if (z2 && z && Build.VERSION.SDK_INT < 16) {
                    sendAccessibilityEvent(4);
                }
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setSelected(z);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setSelected(z);
                }
                View view = this.customView;
                if (view != null) {
                    view.setSelected(z);
                }
            }
        }

        public void setTab(@Nullable Tab tab) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, tab) == null) || tab == this.tab) {
                return;
            }
            this.tab = tab;
            update();
        }

        public final void update() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                Tab tab = this.tab;
                Drawable drawable = null;
                View customView = tab != null ? tab.getCustomView() : null;
                if (customView != null) {
                    ViewParent parent = customView.getParent();
                    if (parent != this) {
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(customView);
                        }
                        addView(customView);
                    }
                    this.customView = customView;
                    TextView textView = this.textView;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    ImageView imageView = this.iconView;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                        this.iconView.setImageDrawable(null);
                    }
                    TextView textView2 = (TextView) customView.findViewById(16908308);
                    this.customTextView = textView2;
                    if (textView2 != null) {
                        this.defaultMaxLines = TextViewCompat.getMaxLines(textView2);
                    }
                    this.customIconView = (ImageView) customView.findViewById(16908294);
                } else {
                    View view = this.customView;
                    if (view != null) {
                        removeView(view);
                        this.customView = null;
                    }
                    this.customTextView = null;
                    this.customIconView = null;
                }
                if (this.customView == null) {
                    if (this.iconView == null) {
                        inflateAndAddDefaultIconView();
                    }
                    if (tab != null && tab.getIcon() != null) {
                        drawable = DrawableCompat.wrap(tab.getIcon()).mutate();
                    }
                    if (drawable != null) {
                        DrawableCompat.setTintList(drawable, this.this$0.tabIconTint);
                        PorterDuff.Mode mode = this.this$0.tabIconTintMode;
                        if (mode != null) {
                            DrawableCompat.setTintMode(drawable, mode);
                        }
                    }
                    if (this.textView == null) {
                        inflateAndAddDefaultTextView();
                        this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
                    }
                    TextViewCompat.setTextAppearance(this.textView, this.this$0.tabTextAppearance);
                    ColorStateList colorStateList = this.this$0.tabTextColors;
                    if (colorStateList != null) {
                        this.textView.setTextColor(colorStateList);
                    }
                    updateTextAndIcon(this.textView, this.iconView);
                    tryUpdateBadgeAnchor();
                    addOnLayoutChangeListener(this.iconView);
                    addOnLayoutChangeListener(this.textView);
                } else if (this.customTextView != null || this.customIconView != null) {
                    updateTextAndIcon(this.customTextView, this.customIconView);
                }
                if (tab != null && !TextUtils.isEmpty(tab.contentDesc)) {
                    setContentDescription(tab.contentDesc);
                }
                setSelected(tab != null && tab.isSelected());
            }
        }

        public final void updateOrientation() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                setOrientation(!this.this$0.inlineLabel ? 1 : 0);
                if (this.customTextView == null && this.customIconView == null) {
                    updateTextAndIcon(this.textView, this.iconView);
                } else {
                    updateTextAndIcon(this.customTextView, this.customIconView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewPager = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) {
                this.viewPager.setCurrentItem(tab.getPosition());
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1635412417, "Lcom/google/android/material/tabs/TabLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1635412417, "Lcom/google/android/material/tabs/TabLayout;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
        tabPool = new Pools.SynchronizedPool(16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayout(@NonNull Context context) {
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

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, tabItem) == null) {
            Tab newTab = newTab();
            CharSequence charSequence = tabItem.text;
            if (charSequence != null) {
                newTab.setText(charSequence);
            }
            Drawable drawable = tabItem.icon;
            if (drawable != null) {
                newTab.setIcon(drawable);
            }
            int i2 = tabItem.customLayout;
            if (i2 != 0) {
                newTab.setCustomView(i2);
            }
            if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
                newTab.setContentDescription(tabItem.getContentDescription());
            }
            addTab(newTab);
        }
    }

    private void addTabView(@NonNull Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, tab) == null) {
            TabView tabView = tab.view;
            tabView.setSelected(false);
            tabView.setActivated(false);
            this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
        }
    }

    private void addViewInternal(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, view) == null) {
            if (view instanceof TabItem) {
                addTabFromItemView((TabItem) view);
                return;
            }
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
    }

    private void animateToTab(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i2) == null) || i2 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.slidingTabIndicator.childrenNeedLayout()) {
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i2, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.scrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                this.scrollAnimator.start();
            }
            this.slidingTabIndicator.animateIndicatorToPosition(i2, this.tabIndicatorAnimationDuration);
            return;
        }
        setScrollPosition(i2, 0.0f, true);
    }

    private void applyGravityForModeScrollable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1) {
                    this.slidingTabIndicator.setGravity(1);
                    return;
                } else if (i2 != 2) {
                    return;
                }
            }
            this.slidingTabIndicator.setGravity(GravityCompat.START);
        }
    }

    private void applyModeAndGravity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int i2 = this.mode;
            ViewCompat.setPaddingRelative(this.slidingTabIndicator, (i2 == 0 || i2 == 2) ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
            int i3 = this.mode;
            if (i3 == 0) {
                applyGravityForModeScrollable(this.tabGravity);
            } else if (i3 == 1 || i3 == 2) {
                int i4 = this.tabGravity;
                this.slidingTabIndicator.setGravity(1);
            }
            updateTabViews(true);
        }
    }

    private int calculateScrollXForTab(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            int i3 = this.mode;
            if (i3 == 0 || i3 == 2) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                int i4 = i2 + 1;
                View childAt2 = i4 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i4) : null;
                int width = childAt != null ? childAt.getWidth() : 0;
                int width2 = childAt2 != null ? childAt2.getWidth() : 0;
                int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
                int i5 = (int) ((width + width2) * 0.5f * f2);
                return ViewCompat.getLayoutDirection(this) == 0 ? left + i5 : left - i5;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    private void configureTab(@NonNull Tab tab, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLI(65548, this, tab, i2) != null) {
            return;
        }
        tab.setPosition(i2);
        this.tabs.add(i2, tab);
        int size = this.tabs.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            }
            this.tabs.get(i2).setPosition(i2);
        }
    }

    @NonNull
    public static ColorStateList createColorStateList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65549, null, i2, i3)) == null) ? new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2}) : (ColorStateList) invokeII.objValue;
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            updateTabViewLayoutParams(layoutParams);
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, tab)) == null) {
            Pools.Pool<TabView> pool = this.tabViewPool;
            TabView acquire = pool != null ? pool.acquire() : null;
            if (acquire == null) {
                acquire = new TabView(this, getContext());
            }
            acquire.setTab(tab);
            acquire.setFocusable(true);
            acquire.setMinimumWidth(getTabMinWidth());
            if (TextUtils.isEmpty(tab.contentDesc)) {
                acquire.setContentDescription(tab.text);
            } else {
                acquire.setContentDescription(tab.contentDesc);
            }
            return acquire;
        }
        return (TabView) invokeL.objValue;
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, tab) == null) {
            for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
                this.selectedListeners.get(size).onTabReselected(tab);
            }
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, tab) == null) {
            for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
                this.selectedListeners.get(size).onTabSelected(tab);
            }
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, tab) == null) {
            for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
                this.selectedListeners.get(size).onTabUnselected(tab);
            }
        }
    }

    private void ensureScrollAnimator() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.tabs.TabLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TabLayout this$0;

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

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.this$0.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                    }
                }
            });
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            int size = this.tabs.size();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    Tab tab = this.tabs.get(i2);
                    if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            return (!z || this.inlineLabel) ? 48 : 72;
        }
        return invokeV.intValue;
    }

    private int getTabMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int i2 = this.requestedTabMinWidth;
            if (i2 != -1) {
                return i2;
            }
            int i3 = this.mode;
            if (i3 == 0 || i3 == 2) {
                return this.scrollableTabMinWidth;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getTabScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) ? Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) : invokeV.intValue;
    }

    private void removeTabViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, this, i2) == null) {
            TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i2);
            this.slidingTabIndicator.removeViewAt(i2);
            if (tabView != null) {
                tabView.reset();
                this.tabViewPool.release(tabView);
            }
            requestLayout();
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65560, this, i2) == null) || i2 >= (childCount = this.slidingTabIndicator.getChildCount())) {
            return;
        }
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.slidingTabIndicator.getChildAt(i3);
            boolean z = true;
            childAt.setSelected(i3 == i2);
            if (i3 != i2) {
                z = false;
            }
            childAt.setActivated(z);
            i3++;
        }
    }

    private void updateAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            int size = this.tabs.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.tabs.get(i2).updateView();
            }
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, layoutParams) == null) {
            if (this.mode == 1 && this.tabGravity == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                return;
            }
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onTabSelectedListener) == null) {
            addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
        }
    }

    public void addTab(@NonNull Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
            addTab(tab, this.tabs.isEmpty());
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            addViewInternal(view);
        }
    }

    public void clearOnTabSelectedListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.selectedListeners.clear();
        }
    }

    public Tab createTabFromPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Tab acquire = tabPool.acquire();
            return acquire == null ? new Tab() : acquire;
        }
        return (Tab) invokeV.objValue;
    }

    public int getSelectedTabPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Tab tab = this.selectedTab;
            if (tab != null) {
                return tab.getPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Tab getTabAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 < 0 || i2 >= getTabCount()) {
                return null;
            }
            return this.tabs.get(i2);
        }
        return (Tab) invokeI.objValue;
    }

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.tabs.size() : invokeV.intValue;
    }

    public int getTabGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.tabGravity : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.tabIconTint : (ColorStateList) invokeV.objValue;
    }

    public int getTabIndicatorGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.tabIndicatorGravity : invokeV.intValue;
    }

    public int getTabMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.tabMaxWidth : invokeV.intValue;
    }

    public int getTabMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mode : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.tabRippleColorStateList : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public Drawable getTabSelectedIndicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.tabSelectedIndicator : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.tabTextColors : (ColorStateList) invokeV.objValue;
    }

    public boolean hasUnboundedRipple() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.unboundedRipple : invokeV.booleanValue;
    }

    public boolean isInlineLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.inlineLabel : invokeV.booleanValue;
    }

    public boolean isTabIndicatorFullWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.tabIndicatorFullWidth : invokeV.booleanValue;
    }

    @NonNull
    public Tab newTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Tab createTabFromPool = createTabFromPool();
            createTabFromPool.parent = this;
            createTabFromPool.view = createTabView(createTabFromPool);
            return createTabFromPool;
        }
        return (Tab) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onAttachedToWindow();
            MaterialShapeUtils.setParentAbsoluteElevation(this);
            if (this.viewPager == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewPager) {
                    setupWithViewPager((ViewPager) parent, true, true);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onDetachedFromWindow();
            if (this.setupViewPagerImplicitly) {
                setupWithViewPager(null);
                this.setupViewPagerImplicitly = false;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, canvas) == null) {
            for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).drawBackground(canvas);
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
        if (r0 != 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L27;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeII(1048609, this, i2, i3) != null) {
            return;
        }
        int round = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i3);
        boolean z = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i3) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.requestedTabMaxWidth;
            if (i4 <= 0) {
                i4 = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() != 1) {
            return;
        }
        View childAt = getChildAt(0);
        int i5 = this.mode;
        if (i5 != 0) {
            if (i5 != 1) {
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void populateFromPagerAdapter() {
        int currentItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            removeAllTabs();
            PagerAdapter pagerAdapter = this.pagerAdapter;
            if (pagerAdapter != null) {
                int count = pagerAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    addTab(newTab().setText(this.pagerAdapter.getPageTitle(i2)), false);
                }
                ViewPager viewPager = this.viewPager;
                if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                    return;
                }
                selectTab(getTabAt(currentItem));
            }
        }
    }

    public boolean releaseFromTabPool(Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, tab)) == null) ? tabPool.release(tab) : invokeL.booleanValue;
    }

    public void removeAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
                removeTabViewAt(childCount);
            }
            Iterator<Tab> it = this.tabs.iterator();
            while (it.hasNext()) {
                Tab next = it.next();
                it.remove();
                next.reset();
                releaseFromTabPool(next);
            }
            this.selectedTab = null;
        }
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onTabSelectedListener) == null) {
            removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
        }
    }

    public void removeTab(@NonNull Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, tab) == null) {
            if (tab.parent == this) {
                removeTabAt(tab.getPosition());
                return;
            }
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
    }

    public void removeTabAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            Tab tab = this.selectedTab;
            int position = tab != null ? tab.getPosition() : 0;
            removeTabViewAt(i2);
            Tab remove = this.tabs.remove(i2);
            if (remove != null) {
                remove.reset();
                releaseFromTabPool(remove);
            }
            int size = this.tabs.size();
            for (int i3 = i2; i3 < size; i3++) {
                this.tabs.get(i3).setPosition(i3);
            }
            if (position == i2) {
                selectTab(this.tabs.isEmpty() ? null : this.tabs.get(Math.max(0, i2 - 1)));
            }
        }
    }

    public void selectTab(@Nullable Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, tab) == null) {
            selectTab(tab, true);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            super.setElevation(f2);
            MaterialShapeUtils.setElevation(this, f2);
        }
    }

    public void setInlineLabel(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048620, this, z) == null) || this.inlineLabel == z) {
            return;
        }
        this.inlineLabel = z;
        for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
            View childAt = this.slidingTabIndicator.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).updateOrientation();
            }
        }
        applyModeAndGravity();
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            setInlineLabel(getResources().getBoolean(i2));
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onTabSelectedListener) == null) {
            setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
        }
    }

    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, pagerAdapter, z) == null) {
            PagerAdapter pagerAdapter2 = this.pagerAdapter;
            if (pagerAdapter2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
                pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
            this.pagerAdapter = pagerAdapter;
            if (z && pagerAdapter != null) {
                if (this.pagerAdapterObserver == null) {
                    this.pagerAdapterObserver = new PagerAdapterObserver(this);
                }
                pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
            }
            populateFromPagerAdapter();
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, animatorListener) == null) {
            ensureScrollAnimator();
            this.scrollAnimator.addListener(animatorListener);
        }
    }

    public void setScrollPosition(int i2, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            setScrollPosition(i2, f2, z, true);
        }
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, drawable) == null) || this.tabSelectedIndicator == drawable) {
            return;
        }
        this.tabSelectedIndicator = drawable;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.slidingTabIndicator.setSelectedIndicatorColor(i2);
        }
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i2) == null) || this.tabIndicatorGravity == i2) {
            return;
        }
        this.tabIndicatorGravity = i2;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.slidingTabIndicator.setSelectedIndicatorHeight(i2);
        }
    }

    public void setTabGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i2) == null) || this.tabGravity == i2) {
            return;
        }
        this.tabGravity = i2;
        applyModeAndGravity();
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, colorStateList) == null) || this.tabIconTint == colorStateList) {
            return;
        }
        this.tabIconTint = colorStateList;
        updateAllTabs();
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.tabIndicatorFullWidth = z;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    public void setTabMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048637, this, i2) == null) || i2 == this.mode) {
            return;
        }
        this.mode = i2;
        applyModeAndGravity();
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, colorStateList) == null) || this.tabRippleColorStateList == colorStateList) {
            return;
        }
        this.tabRippleColorStateList = colorStateList;
        for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
            View childAt = this.slidingTabIndicator.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).updateBackgroundDrawable(getContext());
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, colorStateList) == null) || this.tabTextColors == colorStateList) {
            return;
        }
        this.tabTextColors = colorStateList;
        updateAllTabs();
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, pagerAdapter) == null) {
            setPagerAdapter(pagerAdapter, false);
        }
    }

    public void setUnboundedRipple(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048643, this, z) == null) || this.unboundedRipple == z) {
            return;
        }
        this.unboundedRipple = z;
        for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
            View childAt = this.slidingTabIndicator.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).updateBackgroundDrawable(getContext());
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            setUnboundedRipple(getResources().getBoolean(i2));
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, viewPager) == null) {
            setupWithViewPager(viewPager, true);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? getTabScrollRange() > 0 : invokeV.booleanValue;
    }

    public void updateTabViews(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            for (int i2 = 0; i2 < this.slidingTabIndicator.getChildCount(); i2++) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Tab {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_POSITION = -1;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public CharSequence contentDesc;
        @Nullable
        public View customView;
        @Nullable
        public Drawable icon;
        @LabelVisibility
        public int labelVisibilityMode;
        @Nullable
        public TabLayout parent;
        public int position;
        @Nullable
        public Object tag;
        @Nullable
        public CharSequence text;
        @NonNull
        public TabView view;

        public Tab() {
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
            this.position = -1;
            this.labelVisibilityMode = 1;
        }

        @Nullable
        public BadgeDrawable getBadge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.view.getBadge() : (BadgeDrawable) invokeV.objValue;
        }

        @Nullable
        public CharSequence getContentDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TabView tabView = this.view;
                if (tabView == null) {
                    return null;
                }
                return tabView.getContentDescription();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Nullable
        public View getCustomView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.customView : (View) invokeV.objValue;
        }

        @Nullable
        public Drawable getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.icon : (Drawable) invokeV.objValue;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.view.getOrCreateBadge() : (BadgeDrawable) invokeV.objValue;
        }

        public int getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.position : invokeV.intValue;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.labelVisibilityMode : invokeV.intValue;
        }

        @Nullable
        public Object getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.tag : invokeV.objValue;
        }

        @Nullable
        public CharSequence getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.text : (CharSequence) invokeV.objValue;
        }

        public boolean isSelected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    return tabLayout.getSelectedTabPosition() == this.position;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return invokeV.booleanValue;
        }

        public void removeBadge() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.view.removeBadge();
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.parent = null;
                this.view = null;
                this.tag = null;
                this.icon = null;
                this.text = null;
                this.contentDesc = null;
                this.position = -1;
                this.customView = null;
            }
        }

        public void select() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    tabLayout.selectTab(this);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }

        @NonNull
        public Tab setContentDescription(@StringRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    return setContentDescription(tabLayout.getResources().getText(i2));
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return (Tab) invokeI.objValue;
        }

        @NonNull
        public Tab setCustomView(@Nullable View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
                this.customView = view;
                updateView();
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        @NonNull
        public Tab setIcon(@Nullable Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, drawable)) == null) {
                this.icon = drawable;
                TabLayout tabLayout = this.parent;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    this.parent.updateTabViews(true);
                }
                updateView();
                if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                    this.view.invalidate();
                }
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        public void setPosition(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
                this.position = i2;
            }
        }

        @NonNull
        public Tab setTabLabelVisibility(@LabelVisibility int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
                this.labelVisibilityMode = i2;
                TabLayout tabLayout = this.parent;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    this.parent.updateTabViews(true);
                }
                updateView();
                if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                    this.view.invalidate();
                }
                return this;
            }
            return (Tab) invokeI.objValue;
        }

        @NonNull
        public Tab setTag(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
                this.tag = obj;
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        @NonNull
        public Tab setText(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, charSequence)) == null) {
                if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                    this.view.setContentDescription(charSequence);
                }
                this.text = charSequence;
                updateView();
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        public void updateView() {
            TabView tabView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (tabView = this.view) == null) {
                return;
            }
            tabView.update();
        }

        @NonNull
        public Tab setCustomView(@LayoutRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i2, (ViewGroup) this.view, false)) : (Tab) invokeI.objValue;
        }

        @NonNull
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
                this.contentDesc = charSequence;
                updateView();
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        @NonNull
        public Tab setText(@StringRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    return setText(tabLayout.getResources().getText(i2));
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return (Tab) invokeI.objValue;
        }

        @NonNull
        public Tab setIcon(@DrawableRes int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i2));
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return (Tab) invokeI.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
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

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, baseOnTabSelectedListener) == null) || this.selectedListeners.contains(baseOnTabSelectedListener)) {
            return;
        }
        this.selectedListeners.add(baseOnTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tab, i2) == null) {
            addTab(tab, i2, this.tabs.isEmpty());
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) {
            addViewInternal(view);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, attributeSet)) == null) ? generateDefaultLayoutParams() : (FrameLayout.LayoutParams) invokeL.objValue;
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, baseOnTabSelectedListener) == null) {
            this.selectedListeners.remove(baseOnTabSelectedListener);
        }
    }

    public void selectTab(@Nullable Tab tab, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048618, this, tab, z) == null) {
            Tab tab2 = this.selectedTab;
            if (tab2 == tab) {
                if (tab2 != null) {
                    dispatchTabReselected(tab);
                    animateToTab(tab.getPosition());
                    return;
                }
                return;
            }
            int position = tab != null ? tab.getPosition() : -1;
            if (z) {
                if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                    setScrollPosition(position, 0.0f, true);
                } else {
                    animateToTab(position);
                }
                if (position != -1) {
                    setSelectedTabView(position);
                }
            }
            this.selectedTab = tab;
            if (tab2 != null) {
                dispatchTabUnselected(tab2);
            }
            if (tab != null) {
                dispatchTabSelected(tab);
            }
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, baseOnTabSelectedListener) == null) {
            BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
            if (baseOnTabSelectedListener2 != null) {
                removeOnTabSelectedListener(baseOnTabSelectedListener2);
            }
            this.selectedListener = baseOnTabSelectedListener;
            if (baseOnTabSelectedListener != null) {
                addOnTabSelectedListener(baseOnTabSelectedListener);
            }
        }
    }

    public void setScrollPosition(int i2, float f2, boolean z, boolean z2) {
        int round;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (round = Math.round(i2 + f2)) < 0 || round >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z2) {
            this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i2, f2);
        }
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048646, this, viewPager, z) == null) {
            setupWithViewPager(viewPager, z, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.tabs = new ArrayList<>();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(this, context2);
        this.slidingTabIndicator = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.TabLayout, i2, DEF_STYLE_RES, R.styleable.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            materialShapeDrawable.setElevation(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        this.slidingTabIndicator.setSelectedIndicatorColor(obtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(MaterialResources.getDrawable(context2, obtainStyledAttributes, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(obtainStyledAttributes.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(obtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.tabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = resourceId;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.tabTextSize = obtainStyledAttributes2.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.tabTextColors = MaterialResources.getColorStateList(context2, obtainStyledAttributes2, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.tabTextColors = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), obtainStyledAttributes.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.tabIconTint = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.tabRippleColorStateList = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.requestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = obtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.mode = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabMode, 1);
            this.tabGravity = obtainStyledAttributes.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.inlineLabel = obtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = obtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, this, new Object[]{viewPager, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ViewPager viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
                if (tabLayoutOnPageChangeListener != null) {
                    viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
                }
                AdapterChangeListener adapterChangeListener = this.adapterChangeListener;
                if (adapterChangeListener != null) {
                    this.viewPager.removeOnAdapterChangeListener(adapterChangeListener);
                }
            }
            BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
            if (baseOnTabSelectedListener != null) {
                removeOnTabSelectedListener(baseOnTabSelectedListener);
                this.currentVpSelectedListener = null;
            }
            if (viewPager != null) {
                this.viewPager = viewPager;
                if (this.pageChangeListener == null) {
                    this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
                }
                this.pageChangeListener.reset();
                viewPager.addOnPageChangeListener(this.pageChangeListener);
                ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
                this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
                addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
                PagerAdapter adapter = viewPager.getAdapter();
                if (adapter != null) {
                    setPagerAdapter(adapter, z);
                }
                if (this.adapterChangeListener == null) {
                    this.adapterChangeListener = new AdapterChangeListener(this);
                }
                this.adapterChangeListener.setAutoRefresh(z);
                viewPager.addOnAdapterChangeListener(this.adapterChangeListener);
                setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
            } else {
                this.viewPager = null;
                setPagerAdapter(null, false);
            }
            this.setupViewPagerImplicitly = z2;
        }
    }

    public void addTab(@NonNull Tab tab, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, tab, z) == null) {
            addTab(tab, this.tabs.size(), z);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view, layoutParams) == null) {
            addViewInternal(view);
        }
    }

    public void addTab(@NonNull Tab tab, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tab, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (tab.parent == this) {
                configureTab(tab, i2);
                addTabView(tab);
                if (z) {
                    tab.select();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2, layoutParams) == null) {
            addViewInternal(view);
        }
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            if (i2 != 0) {
                setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
            } else {
                setSelectedTabIndicator((Drawable) null);
            }
        }
    }

    public void setTabTextColors(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i2, i3) == null) {
            setTabTextColors(createColorStateList(i2, i3));
        }
    }
}
