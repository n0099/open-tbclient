package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* loaded from: classes9.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    public static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final AccessibilityManager accessibilityManager;
    @Nullable
    public BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    public boolean hasAction;

    /* loaded from: classes9.dex */
    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public Callback() {
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
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(Snackbar snackbar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, snackbar, i2) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onShown(Snackbar snackbar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, snackbar) == null) {
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes9.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SnackbarLayout(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                super.onMeasure(i2, i3);
                int childCount = getChildCount();
                int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getLayoutParams().width == -1) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                    }
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2145880776, "Lcom/google/android/material/snackbar/Snackbar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2145880776, "Lcom/google/android/material/snackbar/Snackbar;");
                return;
            }
        }
        int i2 = R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{i2};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{i2, R.attr.snackbarTextViewStyle};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Snackbar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        super(viewGroup, view, contentViewCallback);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, view, contentViewCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ViewGroup) objArr2[0], (View) objArr2[1], (ContentViewCallback) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Nullable
    public static ViewGroup findSuitableParent(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            ViewGroup viewGroup = null;
            while (!(view instanceof CoordinatorLayout)) {
                if (view instanceof FrameLayout) {
                    if (view.getId() == 16908290) {
                        return (ViewGroup) view;
                    }
                    viewGroup = (ViewGroup) view;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                        continue;
                    } else {
                        view = null;
                        continue;
                    }
                }
                if (view == null) {
                    return viewGroup;
                }
            }
            return (ViewGroup) view;
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Deprecated
    public static boolean hasSnackbarButtonStyleAttr(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            return resourceId != -1;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasSnackbarContentStyleAttrs(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            return (resourceId == -1 || resourceId2 == -1) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, view, charSequence, i2)) == null) {
            ViewGroup findSuitableParent = findSuitableParent(view);
            if (findSuitableParent != null) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(findSuitableParent.getContext()).inflate(hasSnackbarContentStyleAttrs(findSuitableParent.getContext()) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, findSuitableParent, false);
                Snackbar snackbar = new Snackbar(findSuitableParent, snackbarContentLayout, snackbarContentLayout);
                snackbar.setText(charSequence);
                snackbar.setDuration(i2);
                return snackbar;
            }
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        return (Snackbar) invokeLLI.objValue;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int duration = super.getDuration();
            if (duration == -2) {
                return -2;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return this.accessibilityManager.getRecommendedTimeoutMillis(duration, (this.hasAction ? 4 : 0) | 1 | 2);
            } else if (this.hasAction && this.accessibilityManager.isTouchExplorationEnabled()) {
                return -2;
            } else {
                return duration;
            }
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isShown() : invokeV.booleanValue;
    }

    @NonNull
    public Snackbar setAction(@StringRes int i2, View.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, onClickListener)) == null) ? setAction(getContext().getText(i2), onClickListener) : (Snackbar) invokeIL.objValue;
    }

    @NonNull
    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, colorStateList)) == null) {
            ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(colorStateList);
            return this;
        }
        return (Snackbar) invokeL.objValue;
    }

    @NonNull
    public Snackbar setBackgroundTint(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? setBackgroundTintList(ColorStateList.valueOf(i2)) : (Snackbar) invokeI.objValue;
    }

    @NonNull
    public Snackbar setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, colorStateList)) == null) {
            this.view.setBackgroundTintList(colorStateList);
            return this;
        }
        return (Snackbar) invokeL.objValue;
    }

    @NonNull
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, mode)) == null) {
            this.view.setBackgroundTintMode(mode);
            return this;
        }
        return (Snackbar) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public Snackbar setCallback(@Nullable Callback callback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, callback)) == null) {
            BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
            if (baseCallback != null) {
                removeCallback(baseCallback);
            }
            if (callback != null) {
                addCallback(callback);
            }
            this.callback = callback;
            return this;
        }
        return (Snackbar) invokeL.objValue;
    }

    @NonNull
    public Snackbar setMaxInlineActionWidth(@Dimension int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            ((SnackbarContentLayout) this.view.getChildAt(0)).setMaxInlineActionWidth(i2);
            return this;
        }
        return (Snackbar) invokeI.objValue;
    }

    @NonNull
    public Snackbar setText(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, charSequence)) == null) {
            ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(charSequence);
            return this;
        }
        return (Snackbar) invokeL.objValue;
    }

    @NonNull
    public Snackbar setTextColor(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, colorStateList)) == null) {
            ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(colorStateList);
            return this;
        }
        return (Snackbar) invokeL.objValue;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.show();
        }
    }

    @NonNull
    public Snackbar setAction(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, charSequence, onClickListener)) == null) {
            Button actionView = ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
            if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
                this.hasAction = true;
                actionView.setVisibility(0);
                actionView.setText(charSequence);
                actionView.setOnClickListener(new View.OnClickListener(this, onClickListener) { // from class: com.google.android.material.snackbar.Snackbar.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Snackbar this$0;
                    public final /* synthetic */ View.OnClickListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onClickListener};
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
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.val$listener.onClick(view);
                            this.this$0.dispatchDismiss(1);
                        }
                    }
                });
            } else {
                actionView.setVisibility(8);
                actionView.setOnClickListener(null);
                this.hasAction = false;
            }
            return this;
        }
        return (Snackbar) invokeLL.objValue;
    }

    @NonNull
    public Snackbar setActionTextColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(i2);
            return this;
        }
        return (Snackbar) invokeI.objValue;
    }

    @NonNull
    public Snackbar setText(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? setText(getContext().getText(i2)) : (Snackbar) invokeI.objValue;
    }

    @NonNull
    public Snackbar setTextColor(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(i2);
            return this;
        }
        return (Snackbar) invokeI.objValue;
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @StringRes int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, view, i2, i3)) == null) ? make(view, view.getResources().getText(i2), i3) : (Snackbar) invokeLII.objValue;
    }
}
