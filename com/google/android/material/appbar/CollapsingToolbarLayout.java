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
import androidx.appcompat.R$style;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes5.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;

    /* renamed from: DEF_STYLE_RES */
    public static final int obfuscated_res_0x7f100332 = 2131755826;
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

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = collapsingToolbarLayout;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                CollapsingToolbarLayout collapsingToolbarLayout = this.this$0;
                collapsingToolbarLayout.currentOffset = i;
                WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.lastInsets;
                int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
                int childCount = this.this$0.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.this$0.getChildAt(i2);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                    int i3 = layoutParams.collapseMode;
                    if (i3 == 1) {
                        viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i, 0, this.this$0.getMaxOffsetForPinChild(childAt)));
                    } else if (i3 == 2) {
                        viewOffsetHelper.setTopAndBottomOffset(Math.round((-i) * layoutParams.parallaxMult));
                    }
                }
                this.this$0.updateScrimVisibility();
                CollapsingToolbarLayout collapsingToolbarLayout2 = this.this$0;
                if (collapsingToolbarLayout2.statusBarScrim != null && systemWindowInsetTop > 0) {
                    ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
                }
                this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(i) / ((this.this$0.getHeight() - ViewCompat.getMinimumHeight(this.this$0)) - systemWindowInsetTop));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-381742895, "Lcom/google/android/material/appbar/CollapsingToolbarLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-381742895, "Lcom/google/android/material/appbar/CollapsingToolbarLayout;");
        }
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

    private void animateScrim(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            ensureToolbar();
            ValueAnimator valueAnimator = this.scrimAnimator;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.scrimAnimator = valueAnimator2;
                valueAnimator2.setDuration(this.scrimAnimationDuration);
                this.scrimAnimator.setInterpolator(i > this.scrimAlpha ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
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
            this.scrimAnimator.setIntValues(this.scrimAlpha, i);
            this.scrimAnimator.start();
        }
    }

    private void ensureToolbar() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.refreshToolbar) {
            Toolbar toolbar = null;
            this.toolbar = null;
            this.toolbarDirectChild = null;
            int i = this.toolbarId;
            if (i != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i);
                this.toolbar = toolbar2;
                if (toolbar2 != null) {
                    this.toolbarDirectChild = findDirectChild(toolbar2);
                }
            }
            if (this.toolbar == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i2);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i2++;
                }
                this.toolbar = toolbar;
            }
            updateDummyView();
            this.refreshToolbar = false;
        }
    }

    @NonNull
    private View findDirectChild(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, view2)) == null) {
            for (ViewParent parent = view2.getParent(); parent != this && parent != null; parent = parent.getParent()) {
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public static int getHeightWithMargins(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view2)) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                return view2.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
            return view2.getHeight();
        }
        return invokeL.intValue;
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view2)) == null) {
            ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view2.getTag(R.id.obfuscated_res_0x7f092561);
            if (viewOffsetHelper == null) {
                ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view2);
                view2.setTag(R.id.obfuscated_res_0x7f092561, viewOffsetHelper2);
                return viewOffsetHelper2;
            }
            return viewOffsetHelper;
        }
        return (ViewOffsetHelper) invokeL.objValue;
    }

    private boolean isToolbarChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, view2)) == null) {
            View view3 = this.toolbarDirectChild;
            if (view3 == null || view3 == this) {
                if (view2 == this.toolbar) {
                    return true;
                }
            } else if (view2 == view3) {
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
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (!this.collapsingTitleEnabled && (view2 = this.dummyView) != null) {
                ViewParent parent = view2.getParent();
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
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            if (this.contentScrim == null || this.scrimAlpha <= 0 || !isToolbarChild(view2)) {
                z = false;
            } else {
                this.contentScrim.mutate().setAlpha(this.scrimAlpha);
                this.contentScrim.draw(canvas);
                z = true;
            }
            return super.drawChild(canvas, view2, j) || z;
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

    public final int getMaxOffsetForPinChild(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view2)) == null) ? ((getHeight() - getViewOffsetHelper(view2).getLayoutTop()) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view2.getLayoutParams())).bottomMargin : invokeL.intValue;
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
            int i = this.scrimVisibleHeightTrigger;
            if (i >= 0) {
                return i;
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                        ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                    }
                }
            }
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                getViewOffsetHelper(getChildAt(i6)).onViewLayout();
            }
            if (this.collapsingTitleEnabled && (view2 = this.dummyView) != null) {
                boolean z2 = ViewCompat.isAttachedToWindow(view2) && this.dummyView.getVisibility() == 0;
                this.drawCollapsingTitle = z2;
                if (z2) {
                    boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
                    View view3 = this.toolbarDirectChild;
                    if (view3 == null) {
                        view3 = this.toolbar;
                    }
                    int maxOffsetForPinChild = getMaxOffsetForPinChild(view3);
                    DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
                    this.collapsingTextHelper.setCollapsedBounds(this.tmpRect.left + (z3 ? this.toolbar.getTitleMarginEnd() : this.toolbar.getTitleMarginStart()), this.tmpRect.top + maxOffsetForPinChild + this.toolbar.getTitleMarginTop(), this.tmpRect.right - (z3 ? this.toolbar.getTitleMarginStart() : this.toolbar.getTitleMarginEnd()), (this.tmpRect.bottom + maxOffsetForPinChild) - this.toolbar.getTitleMarginBottom());
                    this.collapsingTextHelper.setExpandedBounds(z3 ? this.expandedMarginEnd : this.expandedMarginStart, this.tmpRect.top + this.expandedMarginTop, (i3 - i) - (z3 ? this.expandedMarginStart : this.expandedMarginEnd), (i4 - i2) - this.expandedMarginBottom);
                    this.collapsingTextHelper.recalculate();
                }
            }
            if (this.toolbar != null) {
                if (this.collapsingTitleEnabled && TextUtils.isEmpty(this.collapsingTextHelper.getText())) {
                    setTitle(this.toolbar.getTitle());
                }
                View view4 = this.toolbarDirectChild;
                if (view4 != null && view4 != this) {
                    setMinimumHeight(getHeightWithMargins(view4));
                } else {
                    setMinimumHeight(getHeightWithMargins(this.toolbar));
                }
            }
            updateScrimVisibility();
            int childCount3 = getChildCount();
            for (int i7 = 0; i7 < childCount3; i7++) {
                getViewOffsetHelper(getChildAt(i7)).applyOffsets();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i, i2) == null) {
            ensureToolbar();
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i2);
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (mode != 0 || systemWindowInsetTop <= 0) {
                return;
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048608, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            Drawable drawable = this.contentScrim;
            if (drawable != null) {
                drawable.setBounds(0, 0, i, i2);
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

    public void setCollapsedTitleGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.collapsingTextHelper.setCollapsedTextGravity(i);
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.collapsingTextHelper.setCollapsedTextAppearance(i);
        }
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            setCollapsedTitleTextColor(ColorStateList.valueOf(i));
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

    public void setContentScrimColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            setContentScrim(new ColorDrawable(i));
        }
    }

    public void setContentScrimResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            setContentScrim(ContextCompat.getDrawable(getContext(), i));
        }
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            setExpandedTitleTextColor(ColorStateList.valueOf(i));
        }
    }

    public void setExpandedTitleGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.collapsingTextHelper.setExpandedTextGravity(i);
        }
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048620, this, i, i2, i3, i4) == null) {
            this.expandedMarginStart = i;
            this.expandedMarginTop = i2;
            this.expandedMarginEnd = i3;
            this.expandedMarginBottom = i4;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginBottom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.expandedMarginBottom = i;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.expandedMarginEnd = i;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginStart(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.expandedMarginStart = i;
            requestLayout();
        }
    }

    public void setExpandedTitleMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.expandedMarginTop = i;
            requestLayout();
        }
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.collapsingTextHelper.setExpandedTextAppearance(i);
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
    public void setMaxLines(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.collapsingTextHelper.setMaxLines(i);
        }
    }

    public void setScrimAlpha(int i) {
        Toolbar toolbar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048629, this, i) == null) || i == this.scrimAlpha) {
            return;
        }
        if (this.contentScrim != null && (toolbar = this.toolbar) != null) {
            ViewCompat.postInvalidateOnAnimation(toolbar);
        }
        this.scrimAlpha = i;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048630, this, j) == null) {
            this.scrimAnimationDuration = j;
        }
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i) == null) || this.scrimVisibleHeightTrigger == i) {
            return;
        }
        this.scrimVisibleHeightTrigger = i;
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

    public void setStatusBarScrimColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            setStatusBarScrim(new ColorDrawable(i));
        }
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
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
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            super.setVisibility(i);
            boolean z = i == 0;
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
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, obfuscated_res_0x7f100332), attributeSet, i);
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
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        Context context2 = getContext();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, new int[]{R.attr.obfuscated_res_0x7f040167, R.attr.obfuscated_res_0x7f040168, R.attr.obfuscated_res_0x7f040198, R.attr.obfuscated_res_0x7f040293, R.attr.obfuscated_res_0x7f040294, R.attr.obfuscated_res_0x7f040295, R.attr.obfuscated_res_0x7f040296, R.attr.obfuscated_res_0x7f040297, R.attr.obfuscated_res_0x7f040298, R.attr.obfuscated_res_0x7f040299, R.attr.obfuscated_res_0x7f0404c3, R.attr.obfuscated_res_0x7f0405e9, R.attr.obfuscated_res_0x7f0405eb, R.attr.obfuscated_res_0x7f04065d, R.attr.obfuscated_res_0x7f040714, R.attr.obfuscated_res_0x7f040716, R.attr.obfuscated_res_0x7f040725}, i, obfuscated_res_0x7f100332, new int[0]);
        this.collapsingTextHelper.setExpandedTextGravity(obtainStyledAttributes.getInt(3, BadgeDrawable.BOTTOM_START));
        this.collapsingTextHelper.setCollapsedTextGravity(obtainStyledAttributes.getInt(0, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.expandedMarginBottom = dimensionPixelSize;
        this.expandedMarginEnd = dimensionPixelSize;
        this.expandedMarginTop = dimensionPixelSize;
        this.expandedMarginStart = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(7)) {
            this.expandedMarginStart = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.expandedMarginEnd = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        if (obtainStyledAttributes.hasValue(8)) {
            this.expandedMarginTop = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.expandedMarginBottom = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        }
        this.collapsingTitleEnabled = obtainStyledAttributes.getBoolean(15, true);
        setTitle(obtainStyledAttributes.getText(14));
        this.collapsingTextHelper.setExpandedTextAppearance(R.style.obfuscated_res_0x7f1001f8);
        this.collapsingTextHelper.setCollapsedTextAppearance(R$style.obfuscated_res_0x7f1001dc);
        if (obtainStyledAttributes.hasValue(9)) {
            this.collapsingTextHelper.setExpandedTextAppearance(obtainStyledAttributes.getResourceId(9, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.collapsingTextHelper.setCollapsedTextAppearance(obtainStyledAttributes.getResourceId(1, 0));
        }
        this.scrimVisibleHeightTrigger = obtainStyledAttributes.getDimensionPixelSize(12, -1);
        if (obtainStyledAttributes.hasValue(10)) {
            this.collapsingTextHelper.setMaxLines(obtainStyledAttributes.getInt(10, 1));
        }
        this.scrimAnimationDuration = obtainStyledAttributes.getInt(11, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(2));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(13));
        this.toolbarId = obtainStyledAttributes.getResourceId(16, -1);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, windowInsetsCompat)) == null) ? this.this$0.onWindowInsetChanged(windowInsetsCompat) : (WindowInsetsCompat) invokeLL.objValue;
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

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040410, R.attr.obfuscated_res_0x7f040411});
            this.collapseMode = obtainStyledAttributes.getInt(0, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(1, 0.5f));
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

        public void setCollapseMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.collapseMode = i;
            }
        }

        public void setParallaxMultiplier(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.parallaxMult = f;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
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
                interceptable.invokeUnInit(65541, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FrameLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }
    }
}
