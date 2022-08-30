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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class ViewUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    public ViewUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view2, @Nullable AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65537, null, view2, attributeSet, i, i2) == null) {
            doOnApplyWindowInsets(view2, attributeSet, i, i2, null);
        }
    }

    public static float dpToPx(@NonNull Context context, @Dimension(unit = 0) int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) ? TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics()) : invokeLI.floatValue;
    }

    @Nullable
    public static ViewGroup getContentView(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            View rootView = view2.getRootView();
            ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
            if (viewGroup != null) {
                return viewGroup;
            }
            if (rootView == view2 || !(rootView instanceof ViewGroup)) {
                return null;
            }
            return (ViewGroup) rootView;
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Nullable
    public static ViewOverlayImpl getContentViewOverlay(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view2)) == null) ? getOverlay(getContentView(view2)) : (ViewOverlayImpl) invokeL.objValue;
    }

    @Nullable
    public static ViewOverlayImpl getOverlay(@Nullable View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return new ViewOverlayApi18(view2);
            }
            return ViewOverlayApi14.createFrom(view2);
        }
        return (ViewOverlayImpl) invokeL.objValue;
    }

    public static float getParentAbsoluteElevation(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view2)) == null) {
            float f = 0.0f;
            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                f += ViewCompat.getElevation((View) parent);
            }
            return f;
        }
        return invokeL.floatValue;
    }

    public static boolean isLayoutRtl(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view2)) == null) ? ViewCompat.getLayoutDirection(view2) == 1 : invokeL.booleanValue;
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i, mode)) == null) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 9) {
                        switch (i) {
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

    public static void requestApplyInsetsWhenAttached(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, view2) == null) {
            if (ViewCompat.isAttachedToWindow(view2)) {
                ViewCompat.requestApplyInsets(view2);
            } else {
                view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NonNull View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            view3.removeOnAttachStateChangeListener(this);
                            ViewCompat.requestApplyInsets(view3);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view3) == null) {
                        }
                    }
                });
            }
        }
    }

    public static void requestFocusAndShowKeyboard(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, view2) == null) {
            view2.requestFocus();
            view2.post(new Runnable(view2) { // from class: com.google.android.material.internal.ViewUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View val$view;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$view = view2;
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

    public static void doOnApplyWindowInsets(@NonNull View view2, @Nullable AttributeSet attributeSet, int i, int i2, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{view2, attributeSet, Integer.valueOf(i), Integer.valueOf(i2), onApplyWindowInsetsListener}) == null) {
            TypedArray obtainStyledAttributes = view2.getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040519, R.attr.obfuscated_res_0x7f04051c, R.attr.obfuscated_res_0x7f04051e}, i, i2);
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            boolean z2 = obtainStyledAttributes.getBoolean(1, false);
            boolean z3 = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            doOnApplyWindowInsets(view2, new OnApplyWindowInsetsListener(z, z2, z3, onApplyWindowInsetsListener) { // from class: com.google.android.material.internal.ViewUtils.2
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
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
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
                public WindowInsetsCompat onApplyWindowInsets(View view3, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull RelativePadding relativePadding) {
                    InterceptResult invokeLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, view3, windowInsetsCompat, relativePadding)) == null) {
                        if (this.val$paddingBottomSystemWindowInsets) {
                            relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
                        }
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(view3);
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
                        relativePadding.applyToView(view3);
                        OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = this.val$listener;
                        return onApplyWindowInsetsListener2 != null ? onApplyWindowInsetsListener2.onApplyWindowInsets(view3, windowInsetsCompat, relativePadding) : windowInsetsCompat;
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

        public RelativePadding(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public void applyToView(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewCompat.setPaddingRelative(view2, this.start, this.top, this.end, this.bottom);
            }
        }

        public RelativePadding(@NonNull RelativePadding relativePadding) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relativePadding};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    public static void doOnApplyWindowInsets(@NonNull View view2, @NonNull OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view2, onApplyWindowInsetsListener) == null) {
            ViewCompat.setOnApplyWindowInsetsListener(view2, new androidx.core.view.OnApplyWindowInsetsListener(onApplyWindowInsetsListener, new RelativePadding(ViewCompat.getPaddingStart(view2), view2.getPaddingTop(), ViewCompat.getPaddingEnd(view2), view2.getPaddingBottom())) { // from class: com.google.android.material.internal.ViewUtils.3
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$listener = onApplyWindowInsetsListener;
                    this.val$initialPadding = r7;
                }

                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view3, WindowInsetsCompat windowInsetsCompat) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, windowInsetsCompat)) == null) ? this.val$listener.onApplyWindowInsets(view3, windowInsetsCompat, new RelativePadding(this.val$initialPadding)) : (WindowInsetsCompat) invokeLL.objValue;
                }
            });
            requestApplyInsetsWhenAttached(view2);
        }
    }
}
