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
import android.util.Log;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class TabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_DURATION = 300;
    public static final int DEFAULT_GAP_TEXT_ICON = 8;
    public static final int DEFAULT_HEIGHT = 48;
    public static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    public static final int DEF_STYLE_RES = 2131755832;
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
    public static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    public static final int TAB_MIN_WIDTH_MARGIN = 56;
    public static final Pools.Pool tabPool;
    public transient /* synthetic */ FieldHolder $fh;
    public AdapterChangeListener adapterChangeListener;
    public int contentInsetStart;
    public BaseOnTabSelectedListener currentVpSelectedListener;
    public boolean inlineLabel;
    public int mode;
    public TabLayoutOnPageChangeListener pageChangeListener;
    public PagerAdapter pagerAdapter;
    public DataSetObserver pagerAdapterObserver;
    public final int requestedTabMaxWidth;
    public final int requestedTabMinWidth;
    public ValueAnimator scrollAnimator;
    public final int scrollableTabMinWidth;
    public BaseOnTabSelectedListener selectedListener;
    public final ArrayList selectedListeners;
    public Tab selectedTab;
    public boolean setupViewPagerImplicitly;
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
    public Drawable tabSelectedIndicator;
    public int tabTextAppearance;
    public ColorStateList tabTextColors;
    public float tabTextMultiLineSize;
    public float tabTextSize;
    public final RectF tabViewContentBounds;
    public final Pools.Pool tabViewPool;
    public final ArrayList tabs;
    public boolean unboundedRipple;
    public ViewPager viewPager;

    @Deprecated
    /* loaded from: classes7.dex */
    public interface BaseOnTabSelectedListener {
        void onTabReselected(Tab tab);

        void onTabSelected(Tab tab);

        void onTabUnselected(Tab tab);
    }

    /* loaded from: classes7.dex */
    public @interface LabelVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface Mode {
    }

    /* loaded from: classes7.dex */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface TabIndicatorGravity {
    }

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayout;
        }

        public void setAutoRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.autoRefresh = z;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, viewPager, pagerAdapter, pagerAdapter2) == null) {
                TabLayout tabLayout = this.this$0;
                if (tabLayout.viewPager == viewPager) {
                    tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes7.dex */
    public class SlidingTabIndicator extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int animationStartLeft;
        public int animationStartRight;
        public final GradientDrawable defaultSelectionIndicator;
        public ValueAnimator indicatorAnimator;
        public int indicatorLeft;
        public int indicatorRight;
        public int layoutDirection;
        public int selectedIndicatorHeight;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                super.onRtlPropertiesChanged(i);
                if (Build.VERSION.SDK_INT < 23 && this.layoutDirection != i) {
                    requestLayout();
                    this.layoutDirection = i;
                }
            }
        }

        public void setSelectedIndicatorColor(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && this.selectedIndicatorPaint.getColor() != i) {
                this.selectedIndicatorPaint.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void setSelectedIndicatorHeight(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.selectedIndicatorHeight != i) {
                this.selectedIndicatorHeight = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        private void calculateTabViewContentBounds(TabView tabView, RectF rectF) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, tabView, rectF) == null) {
                int contentWidth = tabView.getContentWidth();
                int dpToPx = (int) ViewUtils.dpToPx(getContext(), 24);
                if (contentWidth < dpToPx) {
                    contentWidth = dpToPx;
                }
                int left = (tabView.getLeft() + tabView.getRight()) / 2;
                int i = contentWidth / 2;
                rectF.set(left - i, 0.0f, left + i, 0.0f);
            }
        }

        public void setIndicatorPositionFromTabPosition(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
                ValueAnimator valueAnimator = this.indicatorAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.indicatorAnimator.cancel();
                }
                this.selectedPosition = i;
                this.selectionOffset = f;
                updateIndicatorPosition();
            }
        }

        private void updateIndicatorPosition() {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                View childAt = getChildAt(this.selectedPosition);
                if (childAt != null && childAt.getWidth() > 0) {
                    i = childAt.getLeft();
                    i2 = childAt.getRight();
                    TabLayout tabLayout = this.this$0;
                    if (!tabLayout.tabIndicatorFullWidth && (childAt instanceof TabView)) {
                        calculateTabViewContentBounds((TabView) childAt, tabLayout.tabViewContentBounds);
                        i = (int) this.this$0.tabViewContentBounds.left;
                        i2 = (int) this.this$0.tabViewContentBounds.right;
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
                        float f = this.selectionOffset;
                        i = (int) ((left * f) + ((1.0f - f) * i));
                        i2 = (int) ((right * f) + ((1.0f - f) * i2));
                    }
                } else {
                    i = -1;
                    i2 = -1;
                }
                setIndicatorPosition(i, i2);
            }
        }

        private void updateOrRecreateIndicatorAnimation(boolean z, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                View childAt = getChildAt(i);
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
                int i3 = this.indicatorLeft;
                int i4 = this.indicatorRight;
                if (i3 == left && i4 == right) {
                    return;
                }
                if (z) {
                    this.animationStartLeft = i3;
                    this.animationStartRight = i4;
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
                            int i5 = newInitContext.flag;
                            if ((i5 & 1) != 0) {
                                int i6 = i5 & 2;
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
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
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
                    valueAnimator.setDuration(i2);
                    valueAnimator.setFloatValues(0.0f, 1.0f);
                    valueAnimator.addUpdateListener(animatorUpdateListener);
                    valueAnimator.addListener(new AnimatorListenerAdapter(this, i) { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SlidingTabIndicator this$1;
                        public final /* synthetic */ int val$position;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$position = i;
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

        public void animateIndicatorToPosition(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                ValueAnimator valueAnimator = this.indicatorAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.indicatorAnimator.cancel();
                }
                updateOrRecreateIndicatorAnimation(true, i, i2);
            }
        }

        public void setIndicatorPosition(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
                if (i != this.indicatorLeft || i2 != this.indicatorRight) {
                    this.indicatorLeft = i;
                    this.indicatorRight = i2;
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        }

        public boolean childrenNeedLayout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (getChildAt(i).getWidth() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public float getIndicatorPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.selectedPosition + this.selectionOffset;
            }
            return invokeV.floatValue;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
                Drawable drawable = this.this$0.tabSelectedIndicator;
                int i2 = 0;
                if (drawable != null) {
                    i = drawable.getIntrinsicHeight();
                } else {
                    i = 0;
                }
                int i3 = this.selectedIndicatorHeight;
                if (i3 >= 0) {
                    i = i3;
                }
                int i4 = this.this$0.tabIndicatorGravity;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                i = 0;
                            } else {
                                i = getHeight();
                            }
                        }
                    } else {
                        i2 = (getHeight() - i) / 2;
                        i = (getHeight() + i) / 2;
                    }
                } else {
                    i2 = getHeight() - i;
                    i = getHeight();
                }
                int i5 = this.indicatorLeft;
                if (i5 >= 0 && this.indicatorRight > i5) {
                    Drawable drawable2 = this.this$0.tabSelectedIndicator;
                    if (drawable2 == null) {
                        drawable2 = this.defaultSelectionIndicator;
                    }
                    Drawable mutate = DrawableCompat.wrap(drawable2).mutate();
                    mutate.setBounds(this.indicatorLeft, i2, this.indicatorRight, i);
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

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                super.onLayout(z, i, i2, i3, i4);
                ValueAnimator valueAnimator = this.indicatorAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
                } else {
                    updateIndicatorPosition();
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                super.onMeasure(i, i2);
                if (View.MeasureSpec.getMode(i) != 1073741824) {
                    return;
                }
                TabLayout tabLayout = this.this$0;
                boolean z = true;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 <= 0) {
                        return;
                    }
                    if (i3 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                        boolean z2 = false;
                        for (int i5 = 0; i5 < childCount; i5++) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                            if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                layoutParams.width = i3;
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
                        super.onMeasure(i, i2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class Tab {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_POSITION = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence contentDesc;
        public View customView;
        public Drawable icon;
        public int labelVisibilityMode;
        public TabLayout parent;
        public int position;
        public Object tag;
        public CharSequence text;

        /* renamed from: view  reason: collision with root package name */
        public TabView f1076view;

        public Tab() {
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
            this.position = -1;
            this.labelVisibilityMode = 1;
        }

        public BadgeDrawable getBadge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (BadgeDrawable) invokeV.objValue;
            }
            return this.f1076view.getBadge();
        }

        public CharSequence getContentDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TabView tabView = this.f1076view;
                if (tabView == null) {
                    return null;
                }
                return tabView.getContentDescription();
            }
            return (CharSequence) invokeV.objValue;
        }

        public View getCustomView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.customView;
            }
            return (View) invokeV.objValue;
        }

        public Drawable getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.icon;
            }
            return (Drawable) invokeV.objValue;
        }

        public BadgeDrawable getOrCreateBadge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
                return (BadgeDrawable) invokeV.objValue;
            }
            return this.f1076view.getOrCreateBadge();
        }

        public int getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.position;
            }
            return invokeV.intValue;
        }

        public int getTabLabelVisibility() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.labelVisibilityMode;
            }
            return invokeV.intValue;
        }

        public Object getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.tag;
            }
            return invokeV.objValue;
        }

        public CharSequence getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.text;
            }
            return (CharSequence) invokeV.objValue;
        }

        public boolean isSelected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    if (tabLayout.getSelectedTabPosition() == this.position) {
                        return true;
                    }
                    return false;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return invokeV.booleanValue;
        }

        public void removeBadge() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048586, this) != null) {
                return;
            }
            this.f1076view.removeBadge();
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.parent = null;
                this.f1076view = null;
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

        public void updateView() {
            TabView tabView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (tabView = this.f1076view) != null) {
                tabView.update();
            }
        }

        public Tab setContentDescription(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    return setContentDescription(tabLayout.getResources().getText(i));
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return (Tab) invokeI.objValue;
        }

        public Tab setCustomView(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
                return setCustomView(LayoutInflater.from(this.f1076view.getContext()).inflate(i, (ViewGroup) this.f1076view, false));
            }
            return (Tab) invokeI.objValue;
        }

        public Tab setIcon(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i));
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return (Tab) invokeI.objValue;
        }

        public void setPosition(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
                this.position = i;
            }
        }

        public Tab setTag(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
                this.tag = obj;
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        public Tab setText(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                TabLayout tabLayout = this.parent;
                if (tabLayout != null) {
                    return setText(tabLayout.getResources().getText(i));
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return (Tab) invokeI.objValue;
        }

        public Tab setContentDescription(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
                this.contentDesc = charSequence;
                updateView();
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        public Tab setCustomView(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view2)) == null) {
                this.customView = view2;
                updateView();
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        public Tab setText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, charSequence)) == null) {
                if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                    this.f1076view.setContentDescription(charSequence);
                }
                this.text = charSequence;
                updateView();
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        public Tab setIcon(Drawable drawable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, drawable)) == null) {
                this.icon = drawable;
                TabLayout tabLayout = this.parent;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    this.parent.updateTabViews(true);
                }
                updateView();
                if (BadgeUtils.USE_COMPAT_PARENT && this.f1076view.hasBadgeDrawable() && this.f1076view.badgeDrawable.isVisible()) {
                    this.f1076view.invalidate();
                }
                return this;
            }
            return (Tab) invokeL.objValue;
        }

        public Tab setTabLabelVisibility(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                this.labelVisibilityMode = i;
                TabLayout tabLayout = this.parent;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    this.parent.updateTabViews(true);
                }
                updateView();
                if (BadgeUtils.USE_COMPAT_PARENT && this.f1076view.hasBadgeDrawable() && this.f1076view.badgeDrawable.isVisible()) {
                    this.f1076view.invalidate();
                }
                return this;
            }
            return (Tab) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int previousScrollState;
        public int scrollState;
        public final WeakReference tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tabLayoutRef = new WeakReference(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (tabLayout = (TabLayout) this.tabLayoutRef.get()) != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.scrollState;
                if (i2 != 0 && (i2 != 2 || this.previousScrollState != 0)) {
                    z = false;
                } else {
                    z = true;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i), z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.previousScrollState = this.scrollState;
                this.scrollState = i;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && (tabLayout = (TabLayout) this.tabLayoutRef.get()) != null) {
                boolean z2 = false;
                if (this.scrollState == 2 && this.previousScrollState != 1) {
                    z = false;
                } else {
                    z = true;
                }
                tabLayout.setScrollPosition(i, f, z, (this.scrollState == 2 && this.previousScrollState == 0) ? true : true);
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.scrollState = 0;
                this.previousScrollState = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class TabView extends LinearLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View badgeAnchorView;
        public BadgeDrawable badgeDrawable;
        public Drawable baseBackgroundDrawable;
        public ImageView customIconView;
        public TextView customTextView;
        public View customView;
        public int defaultMaxLines;
        public ImageView iconView;
        public Tab tab;
        public TextView textView;
        public final /* synthetic */ TabLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabView(TabLayout tabLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        private void addOnLayoutChangeListener(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65546, this, view2) != null) || view2 == null) {
                return;
            }
            view2.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this, view2) { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TabView this$1;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$view = view2;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) && this.val$view.getVisibility() == 0) {
                        this.this$1.tryUpdateBadgeDrawableBounds(this.val$view);
                    }
                }
            });
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

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(Canvas canvas) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65550, this, canvas) == null) && (drawable = this.baseBackgroundDrawable) != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        private FrameLayout getCustomParentForBadge(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, view2)) == null) {
                if ((view2 != this.iconView && view2 != this.textView) || !BadgeUtils.USE_COMPAT_PARENT) {
                    return null;
                }
                return (FrameLayout) view2.getParent();
            }
            return (FrameLayout) invokeL.objValue;
        }

        private void tryAttachBadgeToAnchor(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65559, this, view2) == null) && hasBadgeDrawable() && view2 != null) {
                clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view2, getCustomParentForBadge(view2));
                this.badgeAnchorView = view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65562, this, view2) == null) && hasBadgeDrawable() && view2 == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view2, getCustomParentForBadge(view2));
            }
        }

        public void setTab(Tab tab) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, tab) == null) && tab != this.tab) {
                this.tab = tab;
                update();
            }
        }

        private float approximateLineWidth(Layout layout, int i, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{layout, Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
            }
            return invokeCommon.floatValue;
        }

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
        public BadgeDrawable getBadge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
                return this.badgeDrawable;
            }
            return (BadgeDrawable) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
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
            if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
                if (this.badgeDrawable != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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

        private void tryRemoveBadgeFromAnchor() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(65560, this) != null) || !hasBadgeDrawable()) {
                return;
            }
            clipViewToPaddingForBadge(true);
            View view2 = this.badgeAnchorView;
            if (view2 != null) {
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view2, getCustomParentForBadge(view2));
                this.badgeAnchorView = null;
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

        public Tab getTab() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.tab;
            }
            return (Tab) invokeV.objValue;
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

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
                View[] viewArr = {this.textView, this.iconView, this.customView};
                int i = 0;
                int i2 = 0;
                boolean z = false;
                for (int i3 = 0; i3 < 3; i3++) {
                    View view2 = viewArr[i3];
                    if (view2 != null && view2.getVisibility() == 0) {
                        if (z) {
                            i2 = Math.min(i2, view2.getLeft());
                        } else {
                            i2 = view2.getLeft();
                        }
                        if (z) {
                            i = Math.max(i, view2.getRight());
                        } else {
                            i = view2.getRight();
                        }
                        z = true;
                    }
                }
                return i - i2;
            }
            return invokeV.intValue;
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
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0217, (ViewGroup) frameLayout, false);
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
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0218, (ViewGroup) frameLayout, false);
                this.textView = textView;
                frameLayout.addView(textView);
            }
        }

        private void tryUpdateBadgeAnchor() {
            Tab tab;
            Tab tab2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(65561, this) != null) || !hasBadgeDrawable()) {
                return;
            }
            if (this.customView != null) {
                tryRemoveBadgeFromAnchor();
            } else if (this.iconView != null && (tab2 = this.tab) != null && tab2.getIcon() != null) {
                View view2 = this.badgeAnchorView;
                ImageView imageView = this.iconView;
                if (view2 != imageView) {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.iconView);
                    return;
                }
                tryUpdateBadgeDrawableBounds(imageView);
            } else if (this.textView != null && (tab = this.tab) != null && tab.getTabLabelVisibility() == 1) {
                View view3 = this.badgeAnchorView;
                TextView textView = this.textView;
                if (view3 != textView) {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.textView);
                    return;
                }
                tryUpdateBadgeDrawableBounds(textView);
            } else {
                tryRemoveBadgeFromAnchor();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void updateBackgroundDrawable(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65563, this, context) == null) {
                int i = this.this$0.tabBackgroundResId;
                GradientDrawable gradientDrawable = null;
                if (i != 0) {
                    Drawable drawable = AppCompatResources.getDrawable(context, i);
                    this.baseBackgroundDrawable = drawable;
                    if (drawable != null && drawable.isStateful()) {
                        this.baseBackgroundDrawable.setState(getDrawableState());
                    }
                } else {
                    this.baseBackgroundDrawable = null;
                }
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(0);
                if (this.this$0.tabRippleColorStateList != null) {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setCornerRadius(1.0E-5f);
                    gradientDrawable3.setColor(-1);
                    ColorStateList convertToRippleDrawableColor = RippleUtils.convertToRippleDrawableColor(this.this$0.tabRippleColorStateList);
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (this.this$0.unboundedRipple) {
                            gradientDrawable2 = null;
                        }
                        if (!this.this$0.unboundedRipple) {
                            gradientDrawable = gradientDrawable3;
                        }
                        gradientDrawable2 = new RippleDrawable(convertToRippleDrawableColor, gradientDrawable2, gradientDrawable);
                    } else {
                        Drawable wrap = DrawableCompat.wrap(gradientDrawable3);
                        DrawableCompat.setTintList(wrap, convertToRippleDrawableColor);
                        gradientDrawable2 = new LayerDrawable(new Drawable[]{gradientDrawable2, wrap});
                    }
                }
                ViewCompat.setBackground(this, gradientDrawable2);
                this.this$0.invalidate();
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
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

        private void updateTextAndIcon(TextView textView, ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65564, this, textView, imageView) == null) {
                Tab tab = this.tab;
                CharSequence charSequence3 = null;
                if (tab != null && tab.getIcon() != null) {
                    drawable = DrawableCompat.wrap(this.tab.getIcon()).mutate();
                } else {
                    drawable = null;
                }
                Tab tab2 = this.tab;
                if (tab2 != null) {
                    charSequence = tab2.getText();
                } else {
                    charSequence = null;
                }
                if (imageView != null) {
                    if (drawable != null) {
                        imageView.setImageDrawable(drawable);
                        imageView.setVisibility(0);
                        setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                        imageView.setImageDrawable(null);
                    }
                }
                boolean z = !TextUtils.isEmpty(charSequence);
                if (textView != null) {
                    if (z) {
                        textView.setText(charSequence);
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
                    if (z && imageView.getVisibility() == 0) {
                        i = (int) ViewUtils.dpToPx(getContext(), 8);
                    } else {
                        i = 0;
                    }
                    if (this.this$0.inlineLabel) {
                        if (i != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, i);
                            marginLayoutParams.bottomMargin = 0;
                            imageView.setLayoutParams(marginLayoutParams);
                            imageView.requestLayout();
                        }
                    } else if (i != marginLayoutParams.bottomMargin) {
                        marginLayoutParams.bottomMargin = i;
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                }
                Tab tab3 = this.tab;
                if (tab3 != null) {
                    charSequence2 = tab3.contentDesc;
                } else {
                    charSequence2 = null;
                }
                if (!z) {
                    charSequence3 = charSequence2;
                }
                TooltipCompat.setTooltipText(this, charSequence3);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                int size = View.MeasureSpec.getSize(i);
                int mode = View.MeasureSpec.getMode(i);
                int tabMaxWidth = this.this$0.getTabMaxWidth();
                if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                    i = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
                }
                super.onMeasure(i, i2);
                if (this.textView != null) {
                    float f = this.this$0.tabTextSize;
                    int i3 = this.defaultMaxLines;
                    ImageView imageView = this.iconView;
                    boolean z = true;
                    if (imageView != null && imageView.getVisibility() == 0) {
                        i3 = 1;
                    } else {
                        TextView textView = this.textView;
                        if (textView != null && textView.getLineCount() > 1) {
                            f = this.this$0.tabTextMultiLineSize;
                        }
                    }
                    float textSize = this.textView.getTextSize();
                    int lineCount = this.textView.getLineCount();
                    int maxLines = TextViewCompat.getMaxLines(this.textView);
                    int i4 = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                    if (i4 != 0 || (maxLines >= 0 && i3 != maxLines)) {
                        if (this.this$0.mode == 1 && i4 > 0 && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                            z = false;
                        }
                        if (z) {
                            this.textView.setTextSize(0, f);
                            this.textView.setMaxLines(i3);
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                if (isSelected() != z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
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
                View view2 = this.customView;
                if (view2 != null) {
                    view2.setSelected(z);
                }
            }
        }

        public final void update() {
            View view2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                Tab tab = this.tab;
                Drawable drawable = null;
                if (tab != null) {
                    view2 = tab.getCustomView();
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    ViewParent parent = view2.getParent();
                    if (parent != this) {
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(view2);
                        }
                        addView(view2);
                    }
                    this.customView = view2;
                    TextView textView = this.textView;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    ImageView imageView = this.iconView;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                        this.iconView.setImageDrawable(null);
                    }
                    TextView textView2 = (TextView) view2.findViewById(16908308);
                    this.customTextView = textView2;
                    if (textView2 != null) {
                        this.defaultMaxLines = TextViewCompat.getMaxLines(textView2);
                    }
                    this.customIconView = (ImageView) view2.findViewById(16908294);
                } else {
                    View view3 = this.customView;
                    if (view3 != null) {
                        removeView(view3);
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
                if (tab != null && tab.isSelected()) {
                    z = true;
                } else {
                    z = false;
                }
                setSelected(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ViewPager viewPager;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
            }
        }

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewPager = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) {
                this.viewPager.setCurrentItem(tab.getPosition());
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
        tabPool = new Pools.SynchronizedPool(16);
    }

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

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        this.this$0.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                    }
                }
            });
        }
    }

    private int getTabMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int i = this.requestedTabMinWidth;
            if (i != -1) {
                return i;
            }
            int i2 = this.mode;
            if (i2 != 0 && i2 != 2) {
                return 0;
            }
            return this.scrollableTabMinWidth;
        }
        return invokeV.intValue;
    }

    private int getTabScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
        }
        return invokeV.intValue;
    }

    private void updateAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            int size = this.tabs.size();
            for (int i = 0; i < size; i++) {
                ((Tab) this.tabs.get(i)).updateView();
            }
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
            Tab tab = (Tab) tabPool.acquire();
            if (tab == null) {
                return new Tab();
            }
            return tab;
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

    public int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.tabs.size();
        }
        return invokeV.intValue;
    }

    public int getTabGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.tabGravity;
        }
        return invokeV.intValue;
    }

    public ColorStateList getTabIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.tabIconTint;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public int getTabIndicatorGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.tabIndicatorGravity;
        }
        return invokeV.intValue;
    }

    public int getTabMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.tabMaxWidth;
        }
        return invokeV.intValue;
    }

    public int getTabMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mode;
        }
        return invokeV.intValue;
    }

    public ColorStateList getTabRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.tabRippleColorStateList;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public Drawable getTabSelectedIndicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.tabSelectedIndicator;
        }
        return (Drawable) invokeV.objValue;
    }

    public ColorStateList getTabTextColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.tabTextColors;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public boolean hasUnboundedRipple() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.unboundedRipple;
        }
        return invokeV.booleanValue;
    }

    public boolean isInlineLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.inlineLabel;
        }
        return invokeV.booleanValue;
    }

    public boolean isTabIndicatorFullWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.tabIndicatorFullWidth;
        }
        return invokeV.booleanValue;
    }

    public Tab newTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Tab createTabFromPool = createTabFromPool();
            createTabFromPool.parent = this;
            createTabFromPool.f1076view = createTabView(createTabFromPool);
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

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (getTabScrollRange() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addTabFromItemView(TabItem tabItem) {
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
            int i = tabItem.customLayout;
            if (i != 0) {
                newTab.setCustomView(i);
            }
            if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
                newTab.setContentDescription(tabItem.getContentDescription());
            }
            addTab(newTab);
        }
    }

    private void setSelectedTabView(int i) {
        int childCount;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65560, this, i) == null) && i < (childCount = this.slidingTabIndicator.getChildCount())) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                boolean z2 = true;
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
                if (i2 != i) {
                    z2 = false;
                }
                childAt.setActivated(z2);
            }
        }
    }

    public void setInlineLabel(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && this.inlineLabel != z) {
            this.inlineLabel = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, colorStateList) == null) && this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRipple(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048643, this, z) == null) && this.unboundedRipple != z) {
            this.unboundedRipple = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void updateTabViews(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                childAt.setMinimumWidth(getTabMinWidth());
                updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040691);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void selectTab(Tab tab, boolean z) {
        int i;
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
            if (tab != null) {
                i = tab.getPosition();
            } else {
                i = -1;
            }
            if (z) {
                if ((tab2 == null || tab2.getPosition() == -1) && i != -1) {
                    setScrollPosition(i, 0.0f, true);
                } else {
                    animateToTab(i);
                }
                if (i != -1) {
                    setSelectedTabView(i);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.tabs = new ArrayList();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList();
        this.tabViewPool = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(this, context2);
        this.slidingTabIndicator = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.TabLayout, i, DEF_STYLE_RES, 22);
        if (getBackground() instanceof ColorDrawable) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            materialShapeDrawable.setElevation(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(10, -1));
        this.slidingTabIndicator.setSelectedIndicatorColor(obtainStyledAttributes.getColor(7, 0));
        setSelectedTabIndicator(MaterialResources.getDrawable(context2, obtainStyledAttributes, 5));
        setSelectedTabIndicatorGravity(obtainStyledAttributes.getInt(9, 0));
        setTabIndicatorFullWidth(obtainStyledAttributes.getBoolean(8, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(18, dimensionPixelSize);
        this.tabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(19, this.tabPaddingTop);
        this.tabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(17, this.tabPaddingEnd);
        this.tabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(16, this.tabPaddingBottom);
        int resourceId = obtainStyledAttributes.getResourceId(22, R.style.obfuscated_res_0x7f100205);
        this.tabTextAppearance = resourceId;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.tabTextSize = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            this.tabTextColors = MaterialResources.getColorStateList(context2, obtainStyledAttributes2, 3);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(23)) {
                this.tabTextColors = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 23);
            }
            if (obtainStyledAttributes.hasValue(21)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), obtainStyledAttributes.getColor(21, 0));
            }
            this.tabIconTint = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 3);
            this.tabIconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(4, -1), null);
            this.tabRippleColorStateList = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 20);
            this.tabIndicatorAnimationDuration = obtainStyledAttributes.getInt(6, 300);
            this.requestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(13, -1);
            this.requestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(12, -1);
            this.tabBackgroundResId = obtainStyledAttributes.getResourceId(0, 0);
            this.contentInsetStart = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.mode = obtainStyledAttributes.getInt(14, 1);
            this.tabGravity = obtainStyledAttributes.getInt(2, 0);
            this.inlineLabel = obtainStyledAttributes.getBoolean(11, false);
            this.unboundedRipple = obtainStyledAttributes.getBoolean(24, false);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070223);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070221);
            applyModeAndGravity();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void addTabView(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, tab) == null) {
            TabView tabView = tab.f1076view;
            tabView.setSelected(false);
            tabView.setActivated(false);
            this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
        }
    }

    private void addViewInternal(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, view2) == null) {
            if (view2 instanceof TabItem) {
                addTabFromItemView((TabItem) view2);
                return;
            }
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
    }

    private void applyGravityForModeScrollable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                } else {
                    this.slidingTabIndicator.setGravity(1);
                    return;
                }
            } else {
                Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            }
            this.slidingTabIndicator.setGravity(GravityCompat.START);
        }
    }

    private void dispatchTabReselected(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, tab) == null) {
            for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
                ((BaseOnTabSelectedListener) this.selectedListeners.get(size)).onTabReselected(tab);
            }
        }
    }

    private void dispatchTabSelected(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, tab) == null) {
            for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
                ((BaseOnTabSelectedListener) this.selectedListeners.get(size)).onTabSelected(tab);
            }
        }
    }

    private void dispatchTabUnselected(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, tab) == null) {
            for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
                ((BaseOnTabSelectedListener) this.selectedListeners.get(size)).onTabUnselected(tab);
            }
        }
    }

    private void removeTabViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, this, i) == null) {
            TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i);
            this.slidingTabIndicator.removeViewAt(i);
            if (tabView != null) {
                tabView.reset();
                this.tabViewPool.release(tabView);
            }
            requestLayout();
        }
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
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

    @Deprecated
    public void addOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, baseOnTabSelectedListener) == null) && !this.selectedListeners.contains(baseOnTabSelectedListener)) {
            this.selectedListeners.add(baseOnTabSelectedListener);
        }
    }

    public void addTab(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
            addTab(tab, this.tabs.isEmpty());
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            addViewInternal(view2);
        }
    }

    public Tab getTabAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            if (i >= 0 && i < getTabCount()) {
                return (Tab) this.tabs.get(i);
            }
            return null;
        }
        return (Tab) invokeI.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, canvas) == null) {
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).drawBackground(canvas);
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
        }
    }

    public boolean releaseFromTabPool(Tab tab) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, tab)) == null) {
            return tabPool.release(tab);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public void removeOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, baseOnTabSelectedListener) == null) {
            this.selectedListeners.remove(baseOnTabSelectedListener);
        }
    }

    public void removeTab(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, tab) == null) {
            if (tab.parent == this) {
                removeTabAt(tab.getPosition());
                return;
            }
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
    }

    public void selectTab(Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, tab) == null) {
            selectTab(tab, true);
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
            super.setElevation(f);
            MaterialShapeUtils.setElevation(this, f);
        }
    }

    public void setInlineLabelResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            setInlineLabel(getResources().getBoolean(i));
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
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

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, animatorListener) == null) {
            ensureScrollAnimator();
            this.scrollAnimator.addListener(animatorListener);
        }
    }

    public void setSelectedTabIndicator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            if (i != 0) {
                setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i));
            } else {
                setSelectedTabIndicator((Drawable) null);
            }
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.slidingTabIndicator.setSelectedIndicatorColor(i);
        }
    }

    public void setSelectedTabIndicatorGravity(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048631, this, i) == null) && this.tabIndicatorGravity != i) {
            this.tabIndicatorGravity = i;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.slidingTabIndicator.setSelectedIndicatorHeight(i);
        }
    }

    public void setTabGravity(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048633, this, i) == null) && this.tabGravity != i) {
            this.tabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, colorStateList) == null) && this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            setTabIconTint(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.tabIndicatorFullWidth = z;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    public void setTabMode(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048637, this, i) == null) && i != this.mode) {
            this.mode = i;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColorResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048641, this, colorStateList) == null) && this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, pagerAdapter) == null) {
            setPagerAdapter(pagerAdapter, false);
        }
    }

    public void setUnboundedRippleResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            setUnboundedRipple(getResources().getBoolean(i));
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, viewPager) == null) {
            setupWithViewPager(viewPager, true);
        }
    }

    private void animateToTab(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65544, this, i) != null) || i == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.slidingTabIndicator.childrenNeedLayout()) {
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.scrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                this.scrollAnimator.start();
            }
            this.slidingTabIndicator.animateIndicatorToPosition(i, this.tabIndicatorAnimationDuration);
            return;
        }
        setScrollPosition(i, 0.0f, true);
    }

    private TabView createTabView(Tab tab) {
        InterceptResult invokeL;
        TabView tabView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, tab)) == null) {
            Pools.Pool pool = this.tabViewPool;
            if (pool != null) {
                tabView = (TabView) pool.acquire();
            } else {
                tabView = null;
            }
            if (tabView == null) {
                tabView = new TabView(this, getContext());
            }
            tabView.setTab(tab);
            tabView.setFocusable(true);
            tabView.setMinimumWidth(getTabMinWidth());
            if (TextUtils.isEmpty(tab.contentDesc)) {
                tabView.setContentDescription(tab.text);
            } else {
                tabView.setContentDescription(tab.contentDesc);
            }
            return tabView;
        }
        return (TabView) invokeL.objValue;
    }

    public void removeTabAt(int i) {
        int i2;
        Tab tab;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            Tab tab2 = this.selectedTab;
            if (tab2 != null) {
                i2 = tab2.getPosition();
            } else {
                i2 = 0;
            }
            removeTabViewAt(i);
            Tab tab3 = (Tab) this.tabs.remove(i);
            if (tab3 != null) {
                tab3.reset();
                releaseFromTabPool(tab3);
            }
            int size = this.tabs.size();
            for (int i3 = i; i3 < size; i3++) {
                ((Tab) this.tabs.get(i3)).setPosition(i3);
            }
            if (i2 == i) {
                if (this.tabs.isEmpty()) {
                    tab = null;
                } else {
                    tab = (Tab) this.tabs.get(Math.max(0, i - 1));
                }
                selectTab(tab);
            }
        }
    }

    private void applyModeAndGravity() {
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int i = this.mode;
            if (i != 0 && i != 2) {
                max = 0;
            } else {
                max = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
            }
            ViewCompat.setPaddingRelative(this.slidingTabIndicator, max, 0, 0, 0);
            int i2 = this.mode;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
                    if (this.tabGravity == 2) {
                        Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                    }
                    this.slidingTabIndicator.setGravity(1);
                }
            } else {
                applyGravityForModeScrollable(this.tabGravity);
            }
            updateTabViews(true);
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
                for (int i = 0; i < count; i++) {
                    addTab(newTab().setText(this.pagerAdapter.getPageTitle(i)), false);
                }
                ViewPager viewPager = this.viewPager;
                if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                    selectTab(getTabAt(currentItem));
                }
            }
        }
    }

    private int calculateScrollXForTab(int i, float f) {
        InterceptResult invokeCommon;
        View view2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            int i3 = this.mode;
            int i4 = 0;
            if (i3 != 0 && i3 != 2) {
                return 0;
            }
            View childAt = this.slidingTabIndicator.getChildAt(i);
            int i5 = i + 1;
            if (i5 < this.slidingTabIndicator.getChildCount()) {
                view2 = this.slidingTabIndicator.getChildAt(i5);
            } else {
                view2 = null;
            }
            if (childAt != null) {
                i2 = childAt.getWidth();
            } else {
                i2 = 0;
            }
            if (view2 != null) {
                i4 = view2.getWidth();
            }
            int left = (childAt.getLeft() + (i2 / 2)) - (getWidth() / 2);
            int i6 = (int) ((i2 + i4) * 0.5f * f);
            if (ViewCompat.getLayoutDirection(this) == 0) {
                return left + i6;
            }
            return left - i6;
        }
        return invokeCommon.intValue;
    }

    private void configureTab(Tab tab, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, this, tab, i) == null) {
            tab.setPosition(i);
            this.tabs.add(i, tab);
            int size = this.tabs.size();
            while (true) {
                i++;
                if (i < size) {
                    ((Tab) this.tabs.get(i)).setPosition(i);
                } else {
                    return;
                }
            }
        }
    }

    public static ColorStateList createColorStateList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65549, null, i, i2)) == null) {
            return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
        }
        return (ColorStateList) invokeII.objValue;
    }

    public void addTab(Tab tab, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tab, i) == null) {
            addTab(tab, i, this.tabs.isEmpty());
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
            addViewInternal(view2);
        }
    }

    public void setTabTextColors(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i, i2) == null) {
            setTabTextColors(createColorStateList(i, i2));
        }
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048646, this, viewPager, z) == null) {
            setupWithViewPager(viewPager, z, false);
        }
    }

    private int getDefaultHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            int size = this.tabs.size();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < size) {
                    Tab tab = (Tab) this.tabs.get(i);
                    if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (z && !this.inlineLabel) {
                return 72;
            }
            return 48;
        }
        return invokeV.intValue;
    }

    public void removeAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
                removeTabViewAt(childCount);
            }
            Iterator it = this.tabs.iterator();
            while (it.hasNext()) {
                Tab tab = (Tab) it.next();
                it.remove();
                tab.reset();
                releaseFromTabPool(tab);
            }
            this.selectedTab = null;
        }
    }

    private void setupWithViewPager(ViewPager viewPager, boolean z, boolean z2) {
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

    public void addOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onTabSelectedListener) == null) {
            addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, attributeSet)) == null) {
            return generateDefaultLayoutParams();
        }
        return (FrameLayout.LayoutParams) invokeL.objValue;
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onTabSelectedListener) == null) {
            removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onTabSelectedListener) == null) {
            setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
        }
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, drawable) == null) && this.tabSelectedIndicator != drawable) {
            this.tabSelectedIndicator = drawable;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    public void addTab(Tab tab, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tab, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (tab.parent == this) {
                configureTab(tab, i);
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

    public void addTab(Tab tab, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, tab, z) == null) {
            addTab(tab, this.tabs.size(), z);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, layoutParams) == null) {
            addViewInternal(view2);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i, layoutParams) == null) {
            addViewInternal(view2);
        }
    }

    public void setScrollPosition(int i, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            setScrollPosition(i, f, z, true);
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
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i, i2) == null) {
            int round = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
            int mode = View.MeasureSpec.getMode(i2);
            boolean z = false;
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    i2 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
                }
            } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i2) >= round) {
                getChildAt(0).setMinimumHeight(round);
            }
            int size = View.MeasureSpec.getSize(i);
            if (View.MeasureSpec.getMode(i) != 0) {
                int i3 = this.requestedTabMaxWidth;
                if (i3 <= 0) {
                    i3 = (int) (size - ViewUtils.dpToPx(getContext(), 56));
                }
                this.tabMaxWidth = i3;
            }
            super.onMeasure(i, i2);
            if (getChildCount() == 1) {
                View childAt = getChildAt(0);
                int i4 = this.mode;
                if (i4 != 0) {
                    if (i4 != 1) {
                    }
                    if (z) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                    }
                }
            }
        }
    }

    public void setPagerAdapter(PagerAdapter pagerAdapter, boolean z) {
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

    public void setScrollPosition(int i, float f, boolean z, boolean z2) {
        int round;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (round = Math.round(i + f)) >= 0 && round < this.slidingTabIndicator.getChildCount()) {
            if (z2) {
                this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i, f);
            }
            ValueAnimator valueAnimator = this.scrollAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.scrollAnimator.cancel();
            }
            scrollTo(calculateScrollXForTab(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }
}
