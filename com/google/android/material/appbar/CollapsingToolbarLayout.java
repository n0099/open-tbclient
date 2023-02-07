package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
    public static final int DEF_STYLE_RES = 2131755828;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(0, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(1, 0.5f));
            obtainStyledAttributes.recycle();
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

        public int getCollapseMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.collapseMode;
            }
            return invokeV.intValue;
        }

        public float getParallaxMultiplier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.parallaxMult;
            }
            return invokeV.floatValue;
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
    }

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
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                CollapsingToolbarLayout collapsingToolbarLayout = this.this$0;
                collapsingToolbarLayout.currentOffset = i;
                WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.lastInsets;
                if (windowInsetsCompat != null) {
                    i2 = windowInsetsCompat.getSystemWindowInsetTop();
                } else {
                    i2 = 0;
                }
                int childCount = this.this$0.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.this$0.getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                    int i4 = layoutParams.collapseMode;
                    if (i4 != 1) {
                        if (i4 == 2) {
                            viewOffsetHelper.setTopAndBottomOffset(Math.round((-i) * layoutParams.parallaxMult));
                        }
                    } else {
                        viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i, 0, this.this$0.getMaxOffsetForPinChild(childAt)));
                    }
                }
                this.this$0.updateScrimVisibility();
                CollapsingToolbarLayout collapsingToolbarLayout2 = this.this$0;
                if (collapsingToolbarLayout2.statusBarScrim != null && i2 > 0) {
                    ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
                }
                this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(i) / ((this.this$0.getHeight() - ViewCompat.getMinimumHeight(this.this$0)) - i2));
            }
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

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, drawable) == null) && (drawable2 = this.contentScrim) != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.contentScrim = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            super.setVisibility(i);
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            Drawable drawable = this.statusBarScrim;
            if (drawable != null && drawable.isVisible() != z) {
                this.statusBarScrim.setVisible(z, false);
            }
            Drawable drawable2 = this.contentScrim;
            if (drawable2 != null && drawable2.isVisible() != z) {
                this.contentScrim.setVisible(z, false);
            }
        }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        Context context2 = getContext();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i, DEF_STYLE_RES, new int[0]);
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
        this.collapsingTextHelper.setExpandedTextAppearance(com.baidu.tieba.R.style.obfuscated_res_0x7f1001f9);
        this.collapsingTextHelper.setCollapsedTextAppearance(com.baidu.tieba.R.style.obfuscated_res_0x7f1001dd);
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
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, windowInsetsCompat)) == null) {
                    return this.this$0.onWindowInsetChanged(windowInsetsCompat);
                }
                return (WindowInsetsCompat) invokeLL.objValue;
            }
        });
    }

    private void animateScrim(int i) {
        TimeInterpolator timeInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            ensureToolbar();
            ValueAnimator valueAnimator = this.scrimAnimator;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.scrimAnimator = valueAnimator2;
                valueAnimator2.setDuration(this.scrimAnimationDuration);
                ValueAnimator valueAnimator3 = this.scrimAnimator;
                if (i > this.scrimAlpha) {
                    timeInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
                } else {
                    timeInterpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
                }
                valueAnimator3.setInterpolator(timeInterpolator);
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
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator4) == null) {
                            this.this$0.setScrimAlpha(((Integer) valueAnimator4.getAnimatedValue()).intValue());
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

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, drawable) == null) && (drawable2 = this.statusBarScrim) != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarScrim = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.statusBarScrim;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable4.setVisible(z, false);
                this.statusBarScrim.setCallback(this);
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void ensureToolbar() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65541, this) != null) || !this.refreshToolbar) {
            return;
        }
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
            if (this.collapsingTitleEnabled && this.toolbar != null) {
                if (this.dummyView == null) {
                    this.dummyView = new View(getContext());
                }
                if (this.dummyView.getParent() == null) {
                    this.toolbar.addView(this.dummyView, -1, -1);
                }
            }
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
            ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926c4);
            if (viewOffsetHelper == null) {
                ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view2);
                view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926c4, viewOffsetHelper2);
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
            if (view3 != null && view3 != this) {
                if (view2 == view3) {
                    return true;
                }
            } else if (view2 == this.toolbar) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    public final int getMaxOffsetForPinChild(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view2)) == null) {
            return ((getHeight() - getViewOffsetHelper(view2).getLayoutTop()) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view2.getLayoutParams())).bottomMargin;
        }
        return invokeL.intValue;
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        WindowInsetsCompat windowInsetsCompat2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, windowInsetsCompat)) == null) {
            if (ViewCompat.getFitsSystemWindows(this)) {
                windowInsetsCompat2 = windowInsetsCompat;
            } else {
                windowInsetsCompat2 = null;
            }
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
        if ((interceptable == null || interceptable.invokeI(1048629, this, i) == null) && i != this.scrimAlpha) {
            if (this.contentScrim != null && (toolbar = this.toolbar) != null) {
                ViewCompat.postInvalidateOnAnimation(toolbar);
            }
            this.scrimAlpha = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048630, this, j) == null) {
            this.scrimAnimationDuration = j;
        }
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048631, this, i) == null) && this.scrimVisibleHeightTrigger != i) {
            this.scrimVisibleHeightTrigger = i;
            updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            if (ViewCompat.isLaidOut(this) && !isInEditMode()) {
                z2 = true;
            } else {
                z2 = false;
            }
            setScrimsShown(z, z2);
        }
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
        if ((interceptable == null || interceptable.invokeZ(1048638, this, z) == null) && z != this.collapsingTitleEnabled) {
            this.collapsingTitleEnabled = z;
            updateContentDescriptionFromTitle();
            updateDummyView();
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, drawable)) == null) {
            if (!super.verifyDrawable(drawable) && drawable != this.contentScrim && drawable != this.statusBarScrim) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void updateContentDescriptionFromTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            setContentDescription(getTitle());
        }
    }

    public int getCollapsedTitleGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.collapsingTextHelper.getCollapsedTextGravity();
        }
        return invokeV.intValue;
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.collapsingTextHelper.getCollapsedTypeface();
        }
        return (Typeface) invokeV.objValue;
    }

    @Nullable
    public Drawable getContentScrim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.contentScrim;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getExpandedTitleGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.collapsingTextHelper.getExpandedTextGravity();
        }
        return invokeV.intValue;
    }

    public int getExpandedTitleMarginBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.expandedMarginBottom;
        }
        return invokeV.intValue;
    }

    public int getExpandedTitleMarginEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.expandedMarginEnd;
        }
        return invokeV.intValue;
    }

    public int getExpandedTitleMarginStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.expandedMarginStart;
        }
        return invokeV.intValue;
    }

    public int getExpandedTitleMarginTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.expandedMarginTop;
        }
        return invokeV.intValue;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.collapsingTextHelper.getExpandedTypeface();
        }
        return (Typeface) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.collapsingTextHelper.getMaxLines();
        }
        return invokeV.intValue;
    }

    public int getScrimAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.scrimAlpha;
        }
        return invokeV.intValue;
    }

    public long getScrimAnimationDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.scrimAnimationDuration;
        }
        return invokeV.longValue;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.statusBarScrim;
        }
        return (Drawable) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.collapsingTitleEnabled;
        }
        return invokeV.booleanValue;
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

    public final void updateScrimVisibility() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.contentScrim != null || this.statusBarScrim != null) {
                if (getHeight() + this.currentOffset < getScrimVisibleHeightTrigger()) {
                    z = true;
                } else {
                    z = false;
                }
                setScrimsShown(z);
            }
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i;
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
            if (this.statusBarScrim != null && this.scrimAlpha > 0) {
                WindowInsetsCompat windowInsetsCompat = this.lastInsets;
                if (windowInsetsCompat != null) {
                    i = windowInsetsCompat.getSystemWindowInsetTop();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), i - this.currentOffset);
                    this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
                    this.statusBarScrim.draw(canvas);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            if (this.contentScrim != null && this.scrimAlpha > 0 && isToolbarChild(view2)) {
                this.contentScrim.mutate().setAlpha(this.scrimAlpha);
                this.contentScrim.draw(canvas);
                z = true;
            } else {
                z = false;
            }
            if (super.drawChild(canvas, view2, j) || z) {
                return true;
            }
            return false;
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

    public int getScrimVisibleHeightTrigger() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i2 = this.scrimVisibleHeightTrigger;
            if (i2 >= 0) {
                return i2;
            }
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                i = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i = 0;
            }
            int minimumHeight = ViewCompat.getMinimumHeight(this);
            if (minimumHeight > 0) {
                return Math.min((minimumHeight * 2) + i, getHeight());
            }
            return getHeight() / 3;
        }
        return invokeV.intValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new LayoutParams(-1, -1);
        }
        return (LayoutParams) invokeV.objValue;
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, colorStateList) == null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (FrameLayout.LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, layoutParams)) == null) {
            return new LayoutParams(layoutParams);
        }
        return (FrameLayout.LayoutParams) invokeL.objValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view2;
        boolean z2;
        int titleMarginStart;
        int titleMarginEnd;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                int childCount = getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                        ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                    }
                }
            }
            int childCount2 = getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                getViewOffsetHelper(getChildAt(i8)).onViewLayout();
            }
            if (this.collapsingTitleEnabled && (view2 = this.dummyView) != null) {
                boolean z3 = true;
                if (ViewCompat.isAttachedToWindow(view2) && this.dummyView.getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.drawCollapsingTitle = z2;
                if (z2) {
                    if (ViewCompat.getLayoutDirection(this) != 1) {
                        z3 = false;
                    }
                    View view3 = this.toolbarDirectChild;
                    if (view3 == null) {
                        view3 = this.toolbar;
                    }
                    int maxOffsetForPinChild = getMaxOffsetForPinChild(view3);
                    DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
                    CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
                    int i9 = this.tmpRect.left;
                    if (z3) {
                        titleMarginStart = this.toolbar.getTitleMarginEnd();
                    } else {
                        titleMarginStart = this.toolbar.getTitleMarginStart();
                    }
                    int i10 = i9 + titleMarginStart;
                    int titleMarginTop = this.tmpRect.top + maxOffsetForPinChild + this.toolbar.getTitleMarginTop();
                    int i11 = this.tmpRect.right;
                    if (z3) {
                        titleMarginEnd = this.toolbar.getTitleMarginStart();
                    } else {
                        titleMarginEnd = this.toolbar.getTitleMarginEnd();
                    }
                    collapsingTextHelper.setCollapsedBounds(i10, titleMarginTop, i11 - titleMarginEnd, (this.tmpRect.bottom + maxOffsetForPinChild) - this.toolbar.getTitleMarginBottom());
                    CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
                    if (z3) {
                        i5 = this.expandedMarginEnd;
                    } else {
                        i5 = this.expandedMarginStart;
                    }
                    int i12 = this.tmpRect.top + this.expandedMarginTop;
                    int i13 = i3 - i;
                    if (z3) {
                        i6 = this.expandedMarginStart;
                    } else {
                        i6 = this.expandedMarginEnd;
                    }
                    collapsingTextHelper2.setExpandedBounds(i5, i12, i13 - i6, (i4 - i2) - this.expandedMarginBottom);
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
            for (int i14 = 0; i14 < childCount3; i14++) {
                getViewOffsetHelper(getChildAt(i14)).applyOffsets();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i, i2) == null) {
            ensureToolbar();
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i2);
            WindowInsetsCompat windowInsetsCompat = this.lastInsets;
            if (windowInsetsCompat != null) {
                i3 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i3 = 0;
            }
            if (mode == 0 && i3 > 0) {
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i3, 1073741824));
            }
        }
    }

    public void setScrimsShown(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.scrimsAreShown != z) {
            int i = 255;
            if (z2) {
                if (!z) {
                    i = 0;
                }
                animateScrim(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.scrimsAreShown = z;
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
}
