package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
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
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_DURATION = 250;
    public static final int ANIMATION_FADE_DURATION = 180;
    public static final int ANIMATION_FADE_IN_DURATION = 150;
    public static final int ANIMATION_FADE_OUT_DURATION = 75;
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    public static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    public static final int MSG_DISMISS = 1;
    public static final int MSG_SHOW = 0;
    public static final int[] SNACKBAR_STYLE_ATTR;
    public static final String TAG;
    public static final boolean USE_OFFSET_API;
    @NonNull
    public static final Handler handler;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final AccessibilityManager accessibilityManager;
    @Nullable
    public View anchorView;
    public Behavior behavior;
    @RequiresApi(29)
    public final Runnable bottomMarginGestureInsetRunnable;
    public List<BaseCallback<B>> callbacks;
    @NonNull
    public final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    public final Context context;
    public int duration;
    public int extraBottomMarginAnchorView;
    public int extraBottomMarginGestureInset;
    public int extraBottomMarginWindowInset;
    public int extraLeftMarginWindowInset;
    public int extraRightMarginWindowInset;
    public boolean gestureInsetBottomIgnored;
    @NonNull
    public SnackbarManager.Callback managerCallback;
    @Nullable
    public Rect originalMargins;
    @NonNull
    public final ViewGroup targetParent;
    @NonNull
    public final SnackbarBaseLayout view;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public @interface AnimationMode {
    }

    /* loaded from: classes3.dex */
    public static abstract class BaseCallback<B> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;
        public transient /* synthetic */ FieldHolder $fh;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes3.dex */
        public @interface DismissEvent {
        }

        public BaseCallback() {
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

        public void onDismissed(B b2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, b2, i2) == null) {
            }
        }

        public void onShown(B b2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final BehaviorDelegate delegate;

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
                    return;
                }
            }
            this.delegate = new BehaviorDelegate(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, baseTransientBottomBar) == null) {
                this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
            }
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.delegate.canSwipeDismissView(view) : invokeL.booleanValue;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, view, motionEvent)) == null) {
                this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
                return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            }
            return invokeLLL.booleanValue;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public static class BehaviorDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swipeDismissBehavior};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
            swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
            swipeDismissBehavior.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? view instanceof SnackbarBaseLayout : invokeL.booleanValue;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, view, motionEvent) == null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
                    }
                } else if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
                }
            }
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseTransientBottomBar) == null) {
                this.managerCallback = baseTransientBottomBar.managerCallback;
            }
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i2, int i3, int i4, int i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public static class SnackbarBaseLayout extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public static final View.OnTouchListener consumeAllTouchListener;
        public transient /* synthetic */ FieldHolder $fh;
        public final float actionTextColorAlpha;
        public int animationMode;
        public final float backgroundOverlayColorAlpha;
        public ColorStateList backgroundTint;
        public PorterDuff.Mode backgroundTintMode;
        public OnAttachStateChangeListener onAttachStateChangeListener;
        public OnLayoutChangeListener onLayoutChangeListener;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750104004, "Lcom/google/android/material/snackbar/BaseTransientBottomBar$SnackbarBaseLayout;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(750104004, "Lcom/google/android/material/snackbar/BaseTransientBottomBar$SnackbarBaseLayout;");
                    return;
                }
            }
            consumeAllTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout.1
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

                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        return true;
                    }
                    return invokeLL.booleanValue;
                }
            };
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SnackbarBaseLayout(@NonNull Context context) {
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

        @NonNull
        private Drawable createThemedBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
                if (this.backgroundTint != null) {
                    Drawable wrap = DrawableCompat.wrap(gradientDrawable);
                    DrawableCompat.setTintList(wrap, this.backgroundTint);
                    return wrap;
                }
                return DrawableCompat.wrap(gradientDrawable);
            }
            return (Drawable) invokeV.objValue;
        }

        public float getActionTextColorAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.actionTextColorAlpha : invokeV.floatValue;
        }

        public int getAnimationMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.animationMode : invokeV.intValue;
        }

        public float getBackgroundOverlayColorAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.backgroundOverlayColorAlpha : invokeV.floatValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onAttachedToWindow();
                OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
                if (onAttachStateChangeListener != null) {
                    onAttachStateChangeListener.onViewAttachedToWindow(this);
                }
                ViewCompat.requestApplyInsets(this);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onDetachedFromWindow();
                OnAttachStateChangeListener onAttachStateChangeListener = this.onAttachStateChangeListener;
                if (onAttachStateChangeListener != null) {
                    onAttachStateChangeListener.onViewDetachedFromWindow(this);
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                super.onLayout(z, i2, i3, i4, i5);
                OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
                if (onLayoutChangeListener != null) {
                    onLayoutChangeListener.onLayoutChange(this, i2, i3, i4, i5);
                }
            }
        }

        public void setAnimationMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.animationMode = i2;
            }
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) {
                setBackgroundDrawable(drawable);
            }
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
                if (drawable != null && this.backgroundTint != null) {
                    drawable = DrawableCompat.wrap(drawable.mutate());
                    DrawableCompat.setTintList(drawable, this.backgroundTint);
                    DrawableCompat.setTintMode(drawable, this.backgroundTintMode);
                }
                super.setBackgroundDrawable(drawable);
            }
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, colorStateList) == null) {
                this.backgroundTint = colorStateList;
                if (getBackground() != null) {
                    Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                    DrawableCompat.setTintList(wrap, colorStateList);
                    DrawableCompat.setTintMode(wrap, this.backgroundTintMode);
                    if (wrap != getBackground()) {
                        super.setBackgroundDrawable(wrap);
                    }
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, mode) == null) {
                this.backgroundTintMode = mode;
                if (getBackground() != null) {
                    Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                    DrawableCompat.setTintMode(wrap, mode);
                    if (wrap != getBackground()) {
                        super.setBackgroundDrawable(wrap);
                    }
                }
            }
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, onAttachStateChangeListener) == null) {
                this.onAttachStateChangeListener = onAttachStateChangeListener;
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
                setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
                super.setOnClickListener(onClickListener);
            }
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, onLayoutChangeListener) == null) {
                this.onLayoutChangeListener = onLayoutChangeListener;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.wrap(context, attributeSet, 0, 0), attributeSet);
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
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            this.animationMode = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, createThemedBackground());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-600010546, "Lcom/google/android/material/snackbar/BaseTransientBottomBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-600010546, "Lcom/google/android/material/snackbar/BaseTransientBottomBar;");
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        USE_OFFSET_API = i2 >= 16 && i2 <= 19;
        SNACKBAR_STYLE_ATTR = new int[]{R.attr.snackbarStyle};
        TAG = BaseTransientBottomBar.class.getSimpleName();
        handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    int i3 = message.what;
                    if (i3 == 0) {
                        ((BaseTransientBottomBar) message.obj).showView();
                        return true;
                    } else if (i3 != 1) {
                        return false;
                    } else {
                        ((BaseTransientBottomBar) message.obj).hideView(message.arg1);
                        return true;
                    }
                }
                return invokeL.booleanValue;
            }
        });
    }

    public BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, view, contentViewCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bottomMarginGestureInsetRunnable = new Runnable(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseTransientBottomBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // java.lang.Runnable
            public void run() {
                int screenHeight;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BaseTransientBottomBar baseTransientBottomBar = this.this$0;
                    if (baseTransientBottomBar.view == null || baseTransientBottomBar.context == null || (screenHeight = (this.this$0.getScreenHeight() - this.this$0.getViewAbsoluteBottom()) + ((int) this.this$0.view.getTranslationY())) >= this.this$0.extraBottomMarginGestureInset) {
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = this.this$0.view.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        String unused = BaseTransientBottomBar.TAG;
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += this.this$0.extraBottomMarginGestureInset - screenHeight;
                    this.this$0.view.requestLayout();
                }
            }
        };
        this.managerCallback = new SnackbarManager.Callback(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseTransientBottomBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // com.google.android.material.snackbar.SnackbarManager.Callback
            public void dismiss(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    Handler handler2 = BaseTransientBottomBar.handler;
                    handler2.sendMessage(handler2.obtainMessage(1, i4, 0, this.this$0));
                }
            }

            @Override // com.google.android.material.snackbar.SnackbarManager.Callback
            public void show() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    Handler handler2 = BaseTransientBottomBar.handler;
                    handler2.sendMessage(handler2.obtainMessage(0, this.this$0));
                }
            }
        };
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback != null) {
            this.targetParent = viewGroup;
            this.contentViewCallback = contentViewCallback;
            Context context = viewGroup.getContext();
            this.context = context;
            ThemeEnforcement.checkAppCompatTheme(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(this.context).inflate(getSnackbarBaseLayoutResId(), this.targetParent, false);
            this.view = snackbarBaseLayout;
            if (view instanceof SnackbarContentLayout) {
                ((SnackbarContentLayout) view).updateActionTextColorAlphaIfNeeded(snackbarBaseLayout.getActionTextColorAlpha());
            }
            this.view.addView(view);
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            ViewCompat.setAccessibilityLiveRegion(this.view, 1);
            ViewCompat.setImportantForAccessibility(this.view, 1);
            ViewCompat.setFitsSystemWindows(this.view, true);
            ViewCompat.setOnApplyWindowInsetsListener(this.view, new OnApplyWindowInsetsListener(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
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
                @NonNull
                public WindowInsetsCompat onApplyWindowInsets(View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, windowInsetsCompat)) == null) {
                        this.this$0.extraBottomMarginWindowInset = windowInsetsCompat.getSystemWindowInsetBottom();
                        this.this$0.extraLeftMarginWindowInset = windowInsetsCompat.getSystemWindowInsetLeft();
                        this.this$0.extraRightMarginWindowInset = windowInsetsCompat.getSystemWindowInsetRight();
                        this.this$0.updateMargins();
                        return windowInsetsCompat;
                    }
                    return (WindowInsetsCompat) invokeLL.objValue;
                }
            });
            ViewCompat.setAccessibilityDelegate(this.view, new AccessibilityDelegateCompat(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
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

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, accessibilityNodeInfoCompat) == null) {
                        super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.addAction(1048576);
                        accessibilityNodeInfoCompat.setDismissable(true);
                    }
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public boolean performAccessibilityAction(View view2, int i4, Bundle bundle) {
                    InterceptResult invokeLIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i4, bundle)) == null) {
                        if (i4 == 1048576) {
                            this.this$0.dismiss();
                            return true;
                        }
                        return super.performAccessibilityAction(view2, i4, bundle);
                    }
                    return invokeLIL.booleanValue;
                }
            });
            this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }

    private void animateViewOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i2) == null) {
            if (this.view.getAnimationMode() == 1) {
                startFadeOutAnimation(i2);
            } else {
                startSlideOutAnimation(i2);
            }
        }
    }

    private int calculateBottomMarginForAnchorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            View view = this.anchorView;
            if (view == null) {
                return 0;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            this.targetParent.getLocationOnScreen(iArr2);
            return (iArr2[1] + this.targetParent.getHeight()) - i2;
        }
        return invokeV.intValue;
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, fArr)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.this$0.view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            });
            return ofFloat;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    private ValueAnimator getScaleAnimator(float... fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, fArr)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
            ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.this$0.view.setScaleX(floatValue);
                        this.this$0.view.setScaleY(floatValue);
                    }
                }
            });
            return ofFloat;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(17)
    public int getScreenHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        return invokeV.intValue;
    }

    private int getTranslationYBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            int height = this.view.getHeight();
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewAbsoluteBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            int[] iArr = new int[2];
            this.view.getLocationOnScreen(iArr);
            return iArr[1] + this.view.getHeight();
        }
        return invokeV.intValue;
    }

    private boolean isSwipeDismissable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
        }
        return invokeV.booleanValue;
    }

    private void setUpBehavior(CoordinatorLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, layoutParams) == null) {
            SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.behavior;
            if (swipeDismissBehavior == null) {
                swipeDismissBehavior = getNewBehavior();
            }
            if (swipeDismissBehavior instanceof Behavior) {
                ((Behavior) swipeDismissBehavior).setBaseTransientBottomBar(this);
            }
            swipeDismissBehavior.setListener(new SwipeDismissBehavior.OnDismissListener(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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

                @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                public void onDismiss(@NonNull View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        view.setVisibility(8);
                        this.this$0.dispatchDismiss(0);
                    }
                }

                @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
                public void onDragStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        if (i2 == 0) {
                            SnackbarManager.getInstance().restoreTimeoutIfPaused(this.this$0.managerCallback);
                        } else if (i2 == 1 || i2 == 2) {
                            SnackbarManager.getInstance().pauseTimeout(this.this$0.managerCallback);
                        }
                    }
                }
            });
            layoutParams.setBehavior(swipeDismissBehavior);
            if (this.anchorView == null) {
                layoutParams.insetEdge = 80;
            }
        }
    }

    private boolean shouldUpdateGestureInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) ? this.extraBottomMarginGestureInset > 0 && !this.gestureInsetBottomIgnored && isSwipeDismissable() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showViewImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (shouldAnimate()) {
                animateViewIn();
                return;
            }
            this.view.setVisibility(0);
            onViewShown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFadeInAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
            ValueAnimator scaleAnimator = getScaleAnimator(0.8f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(alphaAnimator, scaleAnimator);
            animatorSet.setDuration(150L);
            animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.onViewShown();
                    }
                }
            });
            animatorSet.start();
        }
    }

    private void startFadeOutAnimation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65565, this, i2) == null) {
            ValueAnimator alphaAnimator = getAlphaAnimator(1.0f, 0.0f);
            alphaAnimator.setDuration(75L);
            alphaAnimator.addListener(new AnimatorListenerAdapter(this, i2) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;
                public final /* synthetic */ int val$event;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
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
                    this.val$event = i2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.onViewHidden(this.val$event);
                    }
                }
            });
            alphaAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSlideInAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            int translationYBottom = getTranslationYBottom();
            if (USE_OFFSET_API) {
                ViewCompat.offsetTopAndBottom(this.view, translationYBottom);
            } else {
                this.view.setTranslationY(translationYBottom);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(translationYBottom, 0);
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.onViewShown();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.this$0.contentViewCallback.animateContentIn(70, 180);
                    }
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, translationYBottom) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int previousAnimatedIntValue;
                public final /* synthetic */ BaseTransientBottomBar this$0;
                public final /* synthetic */ int val$translationYBottom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(translationYBottom)};
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
                    this.val$translationYBottom = translationYBottom;
                    this.previousAnimatedIntValue = this.val$translationYBottom;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                        if (BaseTransientBottomBar.USE_OFFSET_API) {
                            ViewCompat.offsetTopAndBottom(this.this$0.view, intValue - this.previousAnimatedIntValue);
                        } else {
                            this.this$0.view.setTranslationY(intValue);
                        }
                        this.previousAnimatedIntValue = intValue;
                    }
                }
            });
            valueAnimator.start();
        }
    }

    private void startSlideOutAnimation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65567, this, i2) == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(0, getTranslationYBottom());
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(250L);
            valueAnimator.addListener(new AnimatorListenerAdapter(this, i2) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;
                public final /* synthetic */ int val$event;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
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
                    this.val$event = i2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.this$0.onViewHidden(this.val$event);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.this$0.contentViewCallback.animateContentOut(0, 180);
                    }
                }
            });
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int previousAnimatedIntValue;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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
                    this.previousAnimatedIntValue = 0;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                        int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                        if (BaseTransientBottomBar.USE_OFFSET_API) {
                            ViewCompat.offsetTopAndBottom(this.this$0.view, intValue - this.previousAnimatedIntValue);
                        } else {
                            this.this$0.view.setTranslationY(intValue);
                        }
                        this.previousAnimatedIntValue = intValue;
                    }
                }
            });
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMargins() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.originalMargins == null) {
                return;
            }
            int i2 = this.anchorView != null ? this.extraBottomMarginAnchorView : this.extraBottomMarginWindowInset;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            Rect rect = this.originalMargins;
            marginLayoutParams.bottomMargin = rect.bottom + i2;
            marginLayoutParams.leftMargin = rect.left + this.extraLeftMarginWindowInset;
            marginLayoutParams.rightMargin = rect.right + this.extraRightMarginWindowInset;
            this.view.requestLayout();
            if (Build.VERSION.SDK_INT < 29 || !shouldUpdateGestureInset()) {
                return;
            }
            this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
            this.view.post(this.bottomMarginGestureInsetRunnable);
        }
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> baseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, baseCallback)) == null) {
            if (baseCallback == null) {
                return this;
            }
            if (this.callbacks == null) {
                this.callbacks = new ArrayList();
            }
            this.callbacks.add(baseCallback);
            return this;
        }
        return (B) invokeL.objValue;
    }

    public void animateViewIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.view.post(new Runnable(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    SnackbarBaseLayout snackbarBaseLayout;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (snackbarBaseLayout = this.this$0.view) == null) {
                        return;
                    }
                    snackbarBaseLayout.setVisibility(0);
                    if (this.this$0.view.getAnimationMode() == 1) {
                        this.this$0.startFadeInAnimation();
                    } else {
                        this.this$0.startSlideInAnimation();
                    }
                }
            });
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dispatchDismiss(3);
        }
    }

    public void dispatchDismiss(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SnackbarManager.getInstance().dismiss(this.managerCallback, i2);
        }
    }

    @Nullable
    public View getAnchorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.anchorView : (View) invokeV.objValue;
    }

    public int getAnimationMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.view.getAnimationMode() : invokeV.intValue;
    }

    public Behavior getBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.behavior : (Behavior) invokeV.objValue;
    }

    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.duration : invokeV.intValue;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new Behavior() : (SwipeDismissBehavior) invokeV.objValue;
    }

    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? hasSnackbarStyleAttr() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar : invokeV.intValue;
    }

    @NonNull
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.view : (View) invokeV.objValue;
    }

    public boolean hasSnackbarStyleAttr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            TypedArray obtainStyledAttributes = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            return resourceId != -1;
        }
        return invokeV.booleanValue;
    }

    public final void hideView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (shouldAnimate() && this.view.getVisibility() == 0) {
                animateViewOut(i2);
            } else {
                onViewHidden(i2);
            }
        }
    }

    public boolean isGestureInsetBottomIgnored() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.gestureInsetBottomIgnored : invokeV.booleanValue;
    }

    public boolean isShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? SnackbarManager.getInstance().isCurrent(this.managerCallback) : invokeV.booleanValue;
    }

    public boolean isShownOrQueued() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback) : invokeV.booleanValue;
    }

    public void onViewHidden(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            SnackbarManager.getInstance().onDismissed(this.managerCallback);
            List<BaseCallback<B>> list = this.callbacks;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.callbacks.get(size).onDismissed(this, i2);
                }
            }
            ViewParent parent = this.view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.view);
            }
        }
    }

    public void onViewShown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SnackbarManager.getInstance().onShown(this.managerCallback);
            List<BaseCallback<B>> list = this.callbacks;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.callbacks.get(size).onShown(this);
                }
            }
        }
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> baseCallback) {
        InterceptResult invokeL;
        List<BaseCallback<B>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, baseCallback)) == null) {
            if (baseCallback == null || (list = this.callbacks) == null) {
                return this;
            }
            list.remove(baseCallback);
            return this;
        }
        return (B) invokeL.objValue;
    }

    @NonNull
    public B setAnchorView(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view)) == null) {
            this.anchorView = view;
            return this;
        }
        return (B) invokeL.objValue;
    }

    @NonNull
    public B setAnimationMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            this.view.setAnimationMode(i2);
            return this;
        }
        return (B) invokeI.objValue;
    }

    @NonNull
    public B setBehavior(Behavior behavior) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, behavior)) == null) {
            this.behavior = behavior;
            return this;
        }
        return (B) invokeL.objValue;
    }

    @NonNull
    public B setDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.duration = i2;
            return this;
        }
        return (B) invokeI.objValue;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            this.gestureInsetBottomIgnored = z;
            return this;
        }
        return (B) invokeZ.objValue;
    }

    public boolean shouldAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.accessibilityManager.getEnabledAccessibilityServiceList(1);
            return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
        }
    }

    public final void showView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.view.setOnAttachStateChangeListener(new OnAttachStateChangeListener(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseTransientBottomBar this$0;

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

                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    WindowInsets rootWindowInsets;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.this$0.view.getRootWindowInsets()) == null) {
                        return;
                    }
                    this.this$0.extraBottomMarginGestureInset = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    this.this$0.updateMargins();
                }

                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.this$0.isShownOrQueued()) {
                        BaseTransientBottomBar.handler.post(new Runnable(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass6 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.this$0.onViewHidden(3);
                                }
                            }
                        });
                    }
                }
            });
            if (this.view.getParent() == null) {
                ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    setUpBehavior((CoordinatorLayout.LayoutParams) layoutParams);
                }
                this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
                updateMargins();
                this.view.setVisibility(4);
                this.targetParent.addView(this.view);
            }
            if (ViewCompat.isLaidOut(this.view)) {
                showViewImpl();
            } else {
                this.view.setOnLayoutChangeListener(new OnLayoutChangeListener(this) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BaseTransientBottomBar this$0;

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

                    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i2, int i3, int i4, int i5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                            this.this$0.view.setOnLayoutChangeListener(null);
                            this.this$0.showViewImpl();
                        }
                    }
                });
            }
        }
    }

    @NonNull
    public B setAnchorView(@IdRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            View findViewById = this.targetParent.findViewById(i2);
            this.anchorView = findViewById;
            if (findViewById != null) {
                return this;
            }
            throw new IllegalArgumentException("Unable to find anchor view with id: " + i2);
        }
        return (B) invokeI.objValue;
    }
}
