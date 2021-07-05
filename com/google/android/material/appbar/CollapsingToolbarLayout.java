package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes7.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    public static final int DEF_STYLE_RES;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean collapsingTitleEnabled;
    @Nullable
    public Drawable contentScrim;
    public int currentOffset;
    public boolean drawCollapsingTitle;
    public View dummyView;
    public int expandedMarginBottom;
    public int expandedMarginEnd;
    public int expandedMarginStart;
    public int expandedMarginTop;
    @Nullable
    public WindowInsetsCompat lastInsets;
    public AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    public boolean refreshToolbar;
    public int scrimAlpha;
    public long scrimAnimationDuration;
    public ValueAnimator scrimAnimator;
    public int scrimVisibleHeightTrigger;
    public boolean scrimsAreShown;
    @Nullable
    public Drawable statusBarScrim;
    public final Rect tmpRect;
    @Nullable
    public Toolbar toolbar;
    @Nullable
    public View toolbarDirectChild;
    public int toolbarId;

    /* loaded from: classes7.dex */
    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CollapsingToolbarLayout this$0;

        public OffsetUpdateListener(CollapsingToolbarLayout collapsingToolbarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collapsingToolbarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = collapsingToolbarLayout;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                CollapsingToolbarLayout collapsingToolbarLayout = this.this$0;
                collapsingToolbarLayout.currentOffset = i2;
                WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.lastInsets;
                int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
                int childCount = this.this$0.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.this$0.getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                    int i4 = layoutParams.collapseMode;
                    if (i4 == 1) {
                        viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i2, 0, this.this$0.getMaxOffsetForPinChild(childAt)));
                    } else if (i4 == 2) {
                        viewOffsetHelper.setTopAndBottomOffset(Math.round((-i2) * layoutParams.parallaxMult));
                    }
                }
                this.this$0.updateScrimVisibility();
                CollapsingToolbarLayout collapsingToolbarLayout2 = this.this$0;
                if (collapsingToolbarLayout2.statusBarScrim != null && systemWindowInsetTop > 0) {
                    ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
                }
                this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(i2) / ((this.this$0.getHeight() - ViewCompat.getMinimumHeight(this.this$0)) - systemWindowInsetTop));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-381742895, "Lcom/google/android/material/appbar/CollapsingToolbarLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-381742895, "Lcom/google/android/material/appbar/CollapsingToolbarLayout;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CollapsingToolbarLayout(@NonNull Context context) {
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

    private void animateScrim(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65540, this, i2) == null) {
            ensureToolbar();
            ValueAnimator valueAnimator = this.scrimAnimator;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.scrimAnimator = valueAnimator2;
                valueAnimator2.setDuration(this.scrimAnimationDuration);
                this.scrimAnimator.setInterpolator(i2 > this.scrimAlpha ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CollapsingToolbarLayout this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            this.this$0.setScrimAlpha(((Integer) valueAnimator3.getAnimatedValue()).intValue());
                        }
                    }
                });
            } else if (valueAnimator.isRunning()) {
                this.scrimAnimator.cancel();
            }
            this.scrimAnimator.setIntValues(this.scrimAlpha, i2);
            this.scrimAnimator.start();
        }
    }

    private void ensureToolbar() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.refreshToolbar) {
            Toolbar toolbar = null;
            this.toolbar = null;
            this.toolbarDirectChild = null;
            int i2 = this.toolbarId;
            if (i2 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i2);
                this.toolbar = toolbar2;
                if (toolbar2 != null) {
                    this.toolbarDirectChild = findDirectChild(toolbar2);
                }
            }
            if (this.toolbar == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i3++;
                }
                this.toolbar = toolbar;
            }
            updateDummyView();
            this.refreshToolbar = false;
        }
    }

    @NonNull
    private View findDirectChild(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, view)) == null) {
            for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return view;
        }
        return (View) invokeL.objValue;
    }

    public static int getHeightWithMargins(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
            return view.getHeight();
        }
        return invokeL.intValue;
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) {
            ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(R.id.view_offset_helper);
            if (viewOffsetHelper == null) {
                ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
                view.setTag(R.id.view_offset_helper, viewOffsetHelper2);
                return viewOffsetHelper2;
            }
            return viewOffsetHelper;
        }
        return (ViewOffsetHelper) invokeL.objValue;
    }

    private boolean isToolbarChild(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, view)) == null) {
            View view2 = this.toolbarDirectChild;
            if (view2 == null || view2 == this) {
                if (view == this.toolbar) {
                    return true;
                }
            } else if (view == view2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void updateContentDescriptionFromTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            setContentDescription(getTitle());
        }
    }

    private void updateDummyView() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (!this.collapsingTitleEnabled && (view = this.dummyView) != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.dummyView);
                }
            }
            if (!this.collapsingTitleEnabled || this.toolbar == null) {
                return;
            }
            if (this.dummyView == null) {
                this.dummyView = new View(getContext());
            }
            if (this.dummyView.getParent() == null) {
                this.toolbar.addView(this.dummyView, -1, -1);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.draw(canvas);
            ensureToolbar();
            if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
                drawable.mutate().setAlpha(this.scrimAlpha);
                this.contentScrim.draw(canvas);
            }
            if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
                this.collapsingTextHelper.draw(canvas);
            }
            if (this.statusBarScrim == null || this.scrimAlpha <= 0) {
                return;
            }
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), systemWindowInsetTop - this.currentOffset);
                this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
                this.statusBarScrim.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, view, Long.valueOf(j)})) == null) {
            if (this.contentScrim == null || this.scrimAlpha <= 0 || !isToolbarChild(view)) {
                z = false;
            } else {
                this.contentScrim.mutate().setAlpha(this.scrimAlpha);
                this.contentScrim.draw(canvas);
                z = true;
            }
            return super.drawChild(canvas, view, j) || z;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.statusBarScrim;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | drawable.setState(drawableState);
            }
            Drawable drawable2 = this.contentScrim;
            if (drawable2 != null && drawable2.isStateful()) {
                z |= drawable2.setState(drawableState);
            }
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            if (collapsingTextHelper != null) {
                z |= collapsingTextHelper.setState(drawableState);
            }
            if (z) {
                invalidate();
            }
        }
    }

    public int getCollapsedTitleGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.collapsingTextHelper.getCollapsedTextGravity() : invokeV.intValue;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.collapsingTextHelper.getCollapsedTypeface() : (Typeface) invokeV.objValue;
    }

    @Nullable
    public Drawable getContentScrim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.contentScrim : (Drawable) invokeV.objValue;
    }

    public int getExpandedTitleGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.collapsingTextHelper.getExpandedTextGravity() : invokeV.intValue;
    }

    public int getExpandedTitleMarginBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.expandedMarginBottom : invokeV.intValue;
    }

    public int getExpandedTitleMarginEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.expandedMarginEnd : invokeV.intValue;
    }

    public int getExpandedTitleMarginStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.expandedMarginStart : invokeV.intValue;
    }

    public int getExpandedTitleMarginTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.expandedMarginTop : invokeV.intValue;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.collapsingTextHelper.getExpandedTypeface() : (Typeface) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.collapsingTextHelper.getMaxLines() : invokeV.intValue;
    }

    public final int getMaxOffsetForPinChild(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view)) == null) ? ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin : invokeL.intValue;
    }

    public int getScrimAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.scrimAlpha : invokeV.intValue;
    }

    public long getScrimAnimationDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.scrimAnimationDuration : invokeV.longValue;
    }

    public int getScrimVisibleHeightTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i2 = this.scrimVisibleHeightTrigger;
            if (i2 >= 0) {
                return i2;
            }
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int minimumHeight = ViewCompat.getMinimumHeight(this);
            if (minimumHeight > 0) {
                return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
            }
            return getHeight() / 3;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.statusBarScrim : (Drawable) invokeV.objValue;
    }

    @Nullable
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.collapsingTitleEnabled) {
                return this.collapsingTextHelper.getText();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public boolean isTitleEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.collapsingTitleEnabled : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onAttachedToWindow();
            ViewParent parent = getParent();
            if (parent instanceof AppBarLayout) {
                ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
                if (this.onOffsetChangedListener == null) {
                    this.onOffsetChangedListener = new OffsetUpdateListener(this);
                }
                ((AppBarLayout) parent).addOnOffsetChangedListener(this.onOffsetChangedListener);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ViewParent parent = getParent();
            AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
            if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
                ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = getChildAt(i6);
                    if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                        ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                    }
                }
            }
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                getViewOffsetHelper(getChildAt(i7)).onViewLayout();
            }
            if (this.collapsingTitleEnabled && (view = this.dummyView) != null) {
                boolean z2 = ViewCompat.isAttachedToWindow(view) && this.dummyView.getVisibility() == 0;
                this.drawCollapsingTitle = z2;
                if (z2) {
                    boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
                    View view2 = this.toolbarDirectChild;
                    if (view2 == null) {
                        view2 = this.toolbar;
                    }
                    int maxOffsetForPinChild = getMaxOffsetForPinChild(view2);
                    DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
                    this.collapsingTextHelper.setCollapsedBounds(this.tmpRect.left + (z3 ? this.toolbar.getTitleMarginEnd() : this.toolbar.getTitleMarginStart()), this.tmpRect.top + maxOffsetForPinChild + this.toolbar.getTitleMarginTop(), this.tmpRect.right - (z3 ? this.toolbar.getTitleMarginStart() : this.toolbar.getTitleMarginEnd()), (this.tmpRect.bottom + maxOffsetForPinChild) - this.toolbar.getTitleMarginBottom());
                    this.collapsingTextHelper.setExpandedBounds(z3 ? this.expandedMarginEnd : this.expandedMarginStart, this.tmpRect.top + this.expandedMarginTop, (i4 - i2) - (z3 ? this.expandedMarginStart : this.expandedMarginEnd), (i5 - i3) - this.expandedMarginBottom);
                    this.collapsingTextHelper.recalculate();
                }
            }
            if (this.toolbar != null) {
                if (this.collapsingTitleEnabled && TextUtils.isEmpty(this.collapsingTextHelper.getText())) {
                    setTitle(this.toolbar.getTitle());
                }
                View view3 = this.toolbarDirectChild;
                if (view3 != null && view3 != this) {
                    setMinimumHeight(getHeightWithMargins(view3));
                } else {
                    setMinimumHeight(getHeightWithMargins(this.toolbar));
                }
            }
            updateScrimVisibility();
            int childCount3 = getChildCount();
            for (int i8 = 0; i8 < childCount3; i8++) {
                getViewOffsetHelper(getChildAt(i8)).applyOffsets();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i2, i3) == null) {
            ensureToolbar();
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i3);
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (mode != 0 || systemWindowInsetTop <= 0) {
                return;
            }
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048608, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            Drawable drawable = this.contentScrim;
            if (drawable != null) {
                drawable.setBounds(0, 0, i2, i3);
            }
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, windowInsetsCompat)) == null) {
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
                this.lastInsets = windowInsetsCompat2;
                requestLayout();
            }
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void setCollapsedTitleGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.collapsingTextHelper.setCollapsedTextGravity(i2);
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.collapsingTextHelper.setCollapsedTextAppearance(i2);
        }
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
        }
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, typeface) == null) {
            this.collapsingTextHelper.setCollapsedTypeface(typeface);
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, drawable) == null) || (drawable2 = this.contentScrim) == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable mutate = drawable != null ? drawable.mutate() : null;
        this.contentScrim = mutate;
        if (mutate != null) {
            mutate.setBounds(0, 0, getWidth(), getHeight());
            this.contentScrim.setCallback(this);
            this.contentScrim.setAlpha(this.scrimAlpha);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setContentScrimColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            setContentScrim(new ColorDrawable(i2));
        }
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            setContentScrim(ContextCompat.getDrawable(getContext(), i2));
        }
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            setExpandedTitleTextColor(ColorStateList.valueOf(i2));
        }
    }

    public void setExpandedTitleGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.collapsingTextHelper.setExpandedTextGravity(i2);
        }
    }

    public void setExpandedTitleMargin(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048620, this, i2, i3, i4, i5) == null) {
            this.expandedMarginStart = i2;
            this.expandedMarginTop = i3;
            this.expandedMarginEnd = i4;
            this.expandedMarginBottom = i5;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.expandedMarginBottom = i2;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginEnd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.expandedMarginEnd = i2;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginStart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.expandedMarginStart = i2;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.expandedMarginTop = i2;
            requestLayout();
        }
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.collapsingTextHelper.setExpandedTextAppearance(i2);
        }
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, colorStateList) == null) {
            this.collapsingTextHelper.setExpandedTextColor(colorStateList);
        }
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, typeface) == null) {
            this.collapsingTextHelper.setExpandedTypeface(typeface);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.collapsingTextHelper.setMaxLines(i2);
        }
    }

    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048629, this, i2) == null) || i2 == this.scrimAlpha) {
            return;
        }
        if (this.contentScrim != null && (toolbar = this.toolbar) != null) {
            ViewCompat.postInvalidateOnAnimation(toolbar);
        }
        this.scrimAlpha = i2;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048630, this, j) == null) {
            this.scrimAnimationDuration = j;
        }
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i2) == null) || this.scrimVisibleHeightTrigger == i2) {
            return;
        }
        this.scrimVisibleHeightTrigger = i2;
        updateScrimVisibility();
    }

    public void setScrimsShown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
        }
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, drawable) == null) || (drawable2 = this.statusBarScrim) == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable mutate = drawable != null ? drawable.mutate() : null;
        this.statusBarScrim = mutate;
        if (mutate != null) {
            if (mutate.isStateful()) {
                this.statusBarScrim.setState(getDrawableState());
            }
            DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
            this.statusBarScrim.setVisible(getVisibility() == 0, false);
            this.statusBarScrim.setCallback(this);
            this.statusBarScrim.setAlpha(this.scrimAlpha);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            setStatusBarScrim(new ColorDrawable(i2));
        }
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, charSequence) == null) {
            this.collapsingTextHelper.setText(charSequence);
            updateContentDescriptionFromTitle();
        }
    }

    public void setTitleEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048638, this, z) == null) || z == this.collapsingTitleEnabled) {
            return;
        }
        this.collapsingTitleEnabled = z;
        updateContentDescriptionFromTitle();
        updateDummyView();
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            super.setVisibility(i2);
            boolean z = i2 == 0;
            Drawable drawable = this.statusBarScrim;
            if (drawable != null && drawable.isVisible() != z) {
                this.statusBarScrim.setVisible(z, false);
            }
            Drawable drawable2 = this.contentScrim;
            if (drawable2 == null || drawable2.isVisible() == z) {
                return;
            }
            this.contentScrim.setVisible(z, false);
        }
    }

    public final void updateScrimVisibility() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.contentScrim == null && this.statusBarScrim == null) {
                return;
            }
            setScrimsShown(getHeight() + this.currentOffset < getScrimVisibleHeightTrigger());
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, colorStateList) == null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
    }

    public void setScrimsShown(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.scrimsAreShown == z) {
            return;
        }
        if (z2) {
            animateScrim(z ? 255 : 0);
        } else {
            setScrimAlpha(z ? 255 : 0);
        }
        this.scrimsAreShown = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        Context context2 = getContext();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i2, DEF_STYLE_RES, new int[0]);
        this.collapsingTextHelper.setExpandedTextGravity(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, BadgeDrawable.BOTTOM_START));
        this.collapsingTextHelper.setCollapsedTextGravity(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = dimensionPixelSize;
        this.expandedMarginEnd = dimensionPixelSize;
        this.expandedMarginTop = dimensionPixelSize;
        this.expandedMarginStart = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.expandedMarginStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.expandedMarginEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.expandedMarginTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.expandedMarginBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.collapsingTitleEnabled = obtainStyledAttributes.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R.styleable.CollapsingToolbarLayout_title));
        this.collapsingTextHelper.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.collapsingTextHelper.setCollapsedTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.collapsingTextHelper.setExpandedTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.collapsingTextHelper.setCollapsedTextAppearance(obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.scrimVisibleHeightTrigger = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (obtainStyledAttributes.hasValue(R.styleable.CollapsingToolbarLayout_maxLines)) {
            this.collapsingTextHelper.setMaxLines(obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        this.scrimAnimationDuration = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.toolbarId = obtainStyledAttributes.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CollapsingToolbarLayout this$0;

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
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, windowInsetsCompat)) == null) ? this.this$0.onWindowInsetChanged(windowInsetsCompat) : (WindowInsetsCompat) invokeLL.objValue;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new LayoutParams(-1, -1) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (FrameLayout.LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (FrameLayout.LayoutParams) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        public static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        public transient /* synthetic */ FieldHolder $fh;
        public int collapseMode;
        public float parallaxMult;

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
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.collapseMode : invokeV.intValue;
        }

        public float getParallaxMultiplier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.parallaxMult : invokeV.floatValue;
        }

        public void setCollapseMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.collapseMode = i2;
            }
        }

        public void setParallaxMultiplier(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                this.parallaxMult = f2;
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
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
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
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
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
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
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
                    super((FrameLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }
    }
}
