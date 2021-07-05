package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class ViewUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    public ViewUtils() {
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

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65537, null, view, attributeSet, i2, i3) == null) {
            doOnApplyWindowInsets(view, attributeSet, i2, i3, null);
        }
    }

    public static float dpToPx(@NonNull Context context, @Dimension(unit = 0) int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65540, null, context, i2)) == null) ? TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics()) : invokeLI.floatValue;
    }

    @Nullable
    public static ViewGroup getContentView(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, view)) == null) {
            if (view == null) {
                return null;
            }
            View rootView = view.getRootView();
            ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
            if (viewGroup != null) {
                return viewGroup;
            }
            if (rootView == view || !(rootView instanceof ViewGroup)) {
                return null;
            }
            return (ViewGroup) rootView;
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Nullable
    public static ViewOverlayImpl getContentViewOverlay(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, view)) == null) ? getOverlay(getContentView(view)) : (ViewOverlayImpl) invokeL.objValue;
    }

    @Nullable
    public static ViewOverlayImpl getOverlay(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            if (view == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return new ViewOverlayApi18(view);
            }
            return ViewOverlayApi14.createFrom(view);
        }
        return (ViewOverlayImpl) invokeL.objValue;
    }

    public static float getParentAbsoluteElevation(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) {
            float f2 = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                f2 += ViewCompat.getElevation((View) parent);
            }
            return f2;
        }
        return invokeL.floatValue;
    }

    public static boolean isLayoutRtl(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view)) == null) ? ViewCompat.getLayoutDirection(view) == 1 : invokeL.booleanValue;
    }

    public static PorterDuff.Mode parseTintMode(int i2, PorterDuff.Mode mode) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, mode)) == null) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 9) {
                        switch (i2) {
                            case 14:
                                return PorterDuff.Mode.MULTIPLY;
                            case 15:
                                return PorterDuff.Mode.SCREEN;
                            case 16:
                                return PorterDuff.Mode.ADD;
                            default:
                                return mode;
                        }
                    }
                    return PorterDuff.Mode.SRC_ATOP;
                }
                return PorterDuff.Mode.SRC_IN;
            }
            return PorterDuff.Mode.SRC_OVER;
        }
        return (PorterDuff.Mode) invokeIL.objValue;
    }

    public static void requestApplyInsetsWhenAttached(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, view) == null) {
            if (ViewCompat.isAttachedToWindow(view)) {
                ViewCompat.requestApplyInsets(view);
            } else {
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.4
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

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NonNull View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            view2.removeOnAttachStateChangeListener(this);
                            ViewCompat.requestApplyInsets(view2);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        }
                    }
                });
            }
        }
    }

    public static void requestFocusAndShowKeyboard(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, view) == null) {
            view.requestFocus();
            view.post(new Runnable(view) { // from class: com.google.android.material.internal.ViewUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$view = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((InputMethodManager) this.val$view.getContext().getSystemService("input_method")).showSoftInput(this.val$view, 1);
                    }
                }
            });
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{view, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3), onApplyWindowInsetsListener}) == null) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i2, i3);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
            boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
            boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
            obtainStyledAttributes.recycle();
            doOnApplyWindowInsets(view, new OnApplyWindowInsetsListener(z, z2, z3, onApplyWindowInsetsListener) { // from class: com.google.android.material.internal.ViewUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OnApplyWindowInsetsListener val$listener;
                public final /* synthetic */ boolean val$paddingBottomSystemWindowInsets;
                public final /* synthetic */ boolean val$paddingLeftSystemWindowInsets;
                public final /* synthetic */ boolean val$paddingRightSystemWindowInsets;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), onApplyWindowInsetsListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$paddingBottomSystemWindowInsets = z;
                    this.val$paddingLeftSystemWindowInsets = z2;
                    this.val$paddingRightSystemWindowInsets = z3;
                    this.val$listener = onApplyWindowInsetsListener;
                }

                @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
                @NonNull
                public WindowInsetsCompat onApplyWindowInsets(View view2, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull RelativePadding relativePadding) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, view2, windowInsetsCompat, relativePadding)) == null) {
                        if (this.val$paddingBottomSystemWindowInsets) {
                            relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
                        }
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(view2);
                        if (this.val$paddingLeftSystemWindowInsets) {
                            if (isLayoutRtl) {
                                relativePadding.end += windowInsetsCompat.getSystemWindowInsetLeft();
                            } else {
                                relativePadding.start += windowInsetsCompat.getSystemWindowInsetLeft();
                            }
                        }
                        if (this.val$paddingRightSystemWindowInsets) {
                            if (isLayoutRtl) {
                                relativePadding.start += windowInsetsCompat.getSystemWindowInsetRight();
                            } else {
                                relativePadding.end += windowInsetsCompat.getSystemWindowInsetRight();
                            }
                        }
                        relativePadding.applyToView(view2);
                        OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = this.val$listener;
                        return onApplyWindowInsetsListener2 != null ? onApplyWindowInsetsListener2.onApplyWindowInsets(view2, windowInsetsCompat, relativePadding) : windowInsetsCompat;
                    }
                    return (WindowInsetsCompat) invokeLLL.objValue;
                }
            });
        }
    }

    /* loaded from: classes7.dex */
    public static class RelativePadding {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.start = i2;
            this.top = i3;
            this.end = i4;
            this.bottom = i5;
        }

        public void applyToView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewCompat.setPaddingRelative(view, this.start, this.top, this.end, this.bottom);
            }
        }

        public RelativePadding(@NonNull RelativePadding relativePadding) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativePadding};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @NonNull OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, onApplyWindowInsetsListener) == null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, new androidx.core.view.OnApplyWindowInsetsListener(onApplyWindowInsetsListener, new RelativePadding(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())) { // from class: com.google.android.material.internal.ViewUtils.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RelativePadding val$initialPadding;
                public final /* synthetic */ OnApplyWindowInsetsListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onApplyWindowInsetsListener, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = onApplyWindowInsetsListener;
                    this.val$initialPadding = r7;
                }

                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, windowInsetsCompat)) == null) ? this.val$listener.onApplyWindowInsets(view2, windowInsetsCompat, new RelativePadding(this.val$initialPadding)) : (WindowInsetsCompat) invokeLL.objValue;
                }
            });
            requestApplyInsetsWhenAttached(view);
        }
    }
}
