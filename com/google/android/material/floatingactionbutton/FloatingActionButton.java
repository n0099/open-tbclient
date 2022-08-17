package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes5.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout.AttachedBehavior {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;

    /* renamed from: DEF_STYLE_RES */
    public static final int obfuscated_res_0x7f100333 = 2131755827;
    public static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    public static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ColorStateList backgroundTint;
    @Nullable
    public PorterDuff.Mode backgroundTintMode;
    public int borderWidth;
    public boolean compatPadding;
    public int customSize;
    @NonNull
    public final ExpandableWidgetHelper expandableWidgetHelper;
    @NonNull
    public final AppCompatImageHelper imageHelper;
    @Nullable
    public PorterDuff.Mode imageMode;
    public int imagePadding;
    @Nullable
    public ColorStateList imageTint;
    public FloatingActionButtonImpl impl;
    public int maxImageSize;
    @Nullable
    public ColorStateList rippleColor;
    public final Rect shadowPadding;
    public int size;
    public final Rect touchArea;

    /* loaded from: classes5.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final boolean AUTO_HIDE_DEFAULT = true;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean autoHideEnabled;
        public OnVisibilityChangedListener internalAutoHideListener;
        public Rect tmpRect;

        public BaseBehavior() {
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
            this.autoHideEnabled = true;
        }

        public static boolean isBottomSheet(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        private void offsetIfNeeded(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            Rect rect;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65539, this, coordinatorLayout, floatingActionButton) == null) || (rect = floatingActionButton.shadowPadding) == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
            }
            if (i != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i);
            }
        }

        private boolean shouldUpdateVisibility(@NonNull View view2, @NonNull FloatingActionButton floatingActionButton) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, floatingActionButton)) == null) {
                return this.autoHideEnabled && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view2.getId() && floatingActionButton.getUserSetVisibility() == 0;
            }
            return invokeLL.booleanValue;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, coordinatorLayout, appBarLayout, floatingActionButton)) == null) {
                if (shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
                    if (this.tmpRect == null) {
                        this.tmpRect = new Rect();
                    }
                    Rect rect = this.tmpRect;
                    DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
                    if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                        floatingActionButton.hide(this.internalAutoHideListener, false);
                        return true;
                    }
                    floatingActionButton.show(this.internalAutoHideListener, false);
                    return true;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View view2, @NonNull FloatingActionButton floatingActionButton) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, view2, floatingActionButton)) == null) {
                if (shouldUpdateVisibility(view2, floatingActionButton)) {
                    if (view2.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                        floatingActionButton.hide(this.internalAutoHideListener, false);
                        return true;
                    }
                    floatingActionButton.show(this.internalAutoHideListener, false);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public boolean isAutoHideEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.autoHideEnabled : invokeV.booleanValue;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, layoutParams) == null) && layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public void setAutoHideEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                this.autoHideEnabled = z;
            }
        }

        @VisibleForTesting
        public void setInternalAutoHideListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, onVisibilityChangedListener) == null) {
                this.internalAutoHideListener = onVisibilityChangedListener;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, floatingActionButton, rect)) == null) {
                Rect rect2 = floatingActionButton.shadowPadding;
                rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
                return true;
            }
            return invokeLLL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, coordinatorLayout, floatingActionButton, view2)) == null) {
                if (view2 instanceof AppBarLayout) {
                    updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
                    return false;
                } else if (isBottomSheet(view2)) {
                    updateFabVisibilityForBottomSheet(view2, floatingActionButton);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, coordinatorLayout, floatingActionButton, i)) == null) {
                List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
                int size = dependencies.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view2 = dependencies.get(i2);
                    if (view2 instanceof AppBarLayout) {
                        if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                            break;
                        }
                    } else {
                        if (isBottomSheet(view2) && updateFabVisibilityForBottomSheet(view2, floatingActionButton)) {
                            break;
                        }
                    }
                }
                coordinatorLayout.onLayoutChild(floatingActionButton, i);
                offsetIfNeeded(coordinatorLayout, floatingActionButton);
                return true;
            }
            return invokeLLI.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400d2});
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes5.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Behavior() {
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

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            super.onAttachedToLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view2) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view2);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean z) {
            super.setAutoHideEnabled(z);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @VisibleForTesting
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(OnVisibilityChangedListener onVisibilityChangedListener) {
            super.setInternalAutoHideListener(onVisibilityChangedListener);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class OnVisibilityChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnVisibilityChangedListener() {
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

        public void onHidden(FloatingActionButton floatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, floatingActionButton) == null) {
            }
        }

        public void onShown(FloatingActionButton floatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, floatingActionButton) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class ShadowDelegateImpl implements ShadowViewDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FloatingActionButton this$0;

        public ShadowDelegateImpl(FloatingActionButton floatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButton;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public float getRadius() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.getSizeDimension() / 2.0f : invokeV.floatValue;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean isCompatPaddingEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.compatPadding : invokeV.booleanValue;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) || drawable == null) {
                return;
            }
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
                this.this$0.shadowPadding.set(i, i2, i3, i4);
                FloatingActionButton floatingActionButton = this.this$0;
                floatingActionButton.setPadding(i + floatingActionButton.imagePadding, i2 + this.this$0.imagePadding, i3 + this.this$0.imagePadding, i4 + this.this$0.imagePadding);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface Size {
    }

    /* loaded from: classes5.dex */
    public class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final TransformationCallback<T> listener;
        public final /* synthetic */ FloatingActionButton this$0;

        public TransformationCallbackWrapper(@NonNull FloatingActionButton floatingActionButton, TransformationCallback<T> transformationCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {floatingActionButton, transformationCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = floatingActionButton;
            this.listener = transformationCallback;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).listener.equals(this.listener) : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.listener.hashCode() : invokeV.intValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.material.animation.TransformationCallback<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onScaleChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.listener.onScaleChanged(this.this$0);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.material.animation.TransformationCallback<T extends com.google.android.material.floatingactionbutton.FloatingActionButton> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void onTranslationChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.listener.onTranslationChanged(this.this$0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1069555624, "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1069555624, "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingActionButton(@NonNull Context context) {
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

    @NonNull
    private FloatingActionButtonImpl createImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl(this));
            }
            return new FloatingActionButtonImpl(this, new ShadowDelegateImpl(this));
        }
        return (FloatingActionButtonImpl) invokeV.objValue;
    }

    private FloatingActionButtonImpl getImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.impl == null) {
                this.impl = createImpl();
            }
            return this.impl;
        }
        return (FloatingActionButtonImpl) invokeV.objValue;
    }

    private void offsetRectWithShadow(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, rect) == null) {
            int i = rect.left;
            Rect rect2 = this.shadowPadding;
            rect.left = i + rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
        }
    }

    private void onApplySupportImageTint() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (drawable = getDrawable()) == null) {
            return;
        }
        ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.imageMode;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    public static int resolveAdjustedSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode == 1073741824) {
                        return size;
                    }
                    throw new IllegalArgumentException();
                }
                return i;
            }
            return Math.min(i, size);
        }
        return invokeII.intValue;
    }

    @Nullable
    private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, onVisibilityChangedListener)) == null) {
            if (onVisibilityChangedListener == null) {
                return null;
            }
            return new FloatingActionButtonImpl.InternalVisibilityChangedListener(this, onVisibilityChangedListener) { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FloatingActionButton this$0;
                public final /* synthetic */ OnVisibilityChangedListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onVisibilityChangedListener};
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
                    this.val$listener = onVisibilityChangedListener;
                }

                @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
                public void onHidden() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$listener.onHidden(this.this$0);
                    }
                }

                @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
                public void onShown() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$listener.onShown(this.this$0);
                    }
                }
            };
        }
        return (FloatingActionButtonImpl.InternalVisibilityChangedListener) invokeL.objValue;
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            getImpl().addOnHideAnimationListener(animatorListener);
        }
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorListener) == null) {
            getImpl().addOnShowAnimationListener(animatorListener);
        }
    }

    public void addTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, transformationCallback) == null) {
            getImpl().addTransformationCallback(new TransformationCallbackWrapper(this, transformationCallback));
        }
    }

    public void clearCustomSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setCustomSize(0);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.drawableStateChanged();
            getImpl().onDrawableStateChanged(getDrawableState());
        }
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.backgroundTint : (ColorStateList) invokeV.objValue;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.backgroundTintMode : (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new Behavior() : (CoordinatorLayout.Behavior) invokeV.objValue;
    }

    public float getCompatElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getImpl().getElevation() : invokeV.floatValue;
    }

    public float getCompatHoveredFocusedTranslationZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getImpl().getHoveredFocusedTranslationZ() : invokeV.floatValue;
    }

    public float getCompatPressedTranslationZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getImpl().getPressedTranslationZ() : invokeV.floatValue;
    }

    @Nullable
    public Drawable getContentBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getImpl().getContentBackground() : (Drawable) invokeV.objValue;
    }

    @Deprecated
    public boolean getContentRect(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rect)) == null) {
            if (ViewCompat.isLaidOut(this)) {
                rect.set(0, 0, getWidth(), getHeight());
                offsetRectWithShadow(rect);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Px
    public int getCustomSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.customSize : invokeV.intValue;
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public int getExpandedComponentIdHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.expandableWidgetHelper.getExpandedComponentIdHint() : invokeV.intValue;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getImpl().getHideMotionSpec() : (MotionSpec) invokeV.objValue;
    }

    public void getMeasuredContentRect(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rect) == null) {
            rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            offsetRectWithShadow(rect);
        }
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ColorStateList colorStateList = this.rippleColor;
            if (colorStateList != null) {
                return colorStateList.getDefaultColor();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.rippleColor : (ColorStateList) invokeV.objValue;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (ShapeAppearanceModel) Preconditions.checkNotNull(getImpl().getShapeAppearance()) : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getImpl().getShowMotionSpec() : (MotionSpec) invokeV.objValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.size : invokeV.intValue;
    }

    public int getSizeDimension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? getSizeDimension(this.size) : invokeV.intValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? getBackgroundTintList() : (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? getBackgroundTintMode() : (PorterDuff.Mode) invokeV.objValue;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.imageTint : (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.imageMode : (PorterDuff.Mode) invokeV.objValue;
    }

    public boolean getUseCompatPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.compatPadding : invokeV.booleanValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            hide(null);
        }
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean isExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.expandableWidgetHelper.isExpanded() : invokeV.booleanValue;
    }

    public boolean isOrWillBeHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? getImpl().isOrWillBeHidden() : invokeV.booleanValue;
    }

    public boolean isOrWillBeShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? getImpl().isOrWillBeShown() : invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.jumpDrawablesToCurrentState();
            getImpl().jumpDrawableToCurrentState();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onAttachedToWindow();
            getImpl().onAttachedToWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDetachedFromWindow();
            getImpl().onDetachedFromWindow();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048613, this, i, i2) == null) {
            int sizeDimension = getSizeDimension();
            this.imagePadding = (sizeDimension - this.maxImageSize) / 2;
            getImpl().updatePadding();
            int min = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
            Rect rect = this.shadowPadding;
            setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, parcelable) == null) {
            if (!(parcelable instanceof ExtendableSavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
            super.onRestoreInstanceState(extendableSavedState.getSuperState());
            this.expandableWidgetHelper.onRestoreInstanceState((Bundle) Preconditions.checkNotNull(extendableSavedState.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState();
            if (onSaveInstanceState == null) {
                onSaveInstanceState = new Bundle();
            }
            ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
            extendableSavedState.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.onSaveInstanceState());
            return extendableSavedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0 && getContentRect(this.touchArea) && !this.touchArea.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, animatorListener) == null) {
            getImpl().removeOnHideAnimationListener(animatorListener);
        }
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, animatorListener) == null) {
            getImpl().removeOnShowAnimationListener(animatorListener);
        }
    }

    public void removeTransformationCallback(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, transformationCallback) == null) {
            getImpl().removeTransformationCallback(new TransformationCallbackWrapper(this, transformationCallback));
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            Log.i(LOG_TAG, "Setting a custom background is not supported.");
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, drawable) == null) {
            Log.i(LOG_TAG, "Setting a custom background is not supported.");
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            Log.i(LOG_TAG, "Setting a custom background is not supported.");
        }
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, colorStateList) == null) || this.backgroundTint == colorStateList) {
            return;
        }
        this.backgroundTint = colorStateList;
        getImpl().setBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, mode) == null) || this.backgroundTintMode == mode) {
            return;
        }
        this.backgroundTintMode = mode;
        getImpl().setBackgroundTintMode(mode);
    }

    public void setCompatElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f) == null) {
            getImpl().setElevation(f);
        }
    }

    public void setCompatElevationResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            setCompatElevation(getResources().getDimension(i));
        }
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f) == null) {
            getImpl().setHoveredFocusedTranslationZ(f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
        }
    }

    public void setCompatPressedTranslationZ(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048629, this, f) == null) {
            getImpl().setPressedTranslationZ(f);
        }
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            setCompatPressedTranslationZ(getResources().getDimension(i));
        }
    }

    public void setCustomSize(@Px int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            if (i >= 0) {
                if (i != this.customSize) {
                    this.customSize = i;
                    requestLayout();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048632, this, f) == null) {
            super.setElevation(f);
            getImpl().updateShapeElevation(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z) == null) || z == getImpl().getEnsureMinTouchTargetSize()) {
            return;
        }
        getImpl().setEnsureMinTouchTargetSize(z);
        requestLayout();
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean setExpanded(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048634, this, z)) == null) ? this.expandableWidgetHelper.setExpanded(z) : invokeZ.booleanValue;
    }

    @Override // com.google.android.material.expandable.ExpandableTransformationWidget
    public void setExpandedComponentIdHint(@IdRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.expandableWidgetHelper.setExpandedComponentIdHint(i);
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, motionSpec) == null) {
            getImpl().setHideMotionSpec(motionSpec);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, drawable) == null) || getDrawable() == drawable) {
            return;
        }
        super.setImageDrawable(drawable);
        getImpl().updateImageMatrixScale();
        if (this.imageTint != null) {
            onApplySupportImageTint();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.imageHelper.setImageResource(i);
            onApplySupportImageTint();
        }
    }

    public void setRippleColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            setRippleColor(ColorStateList.valueOf(i));
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048642, this, f) == null) {
            super.setScaleX(f);
            getImpl().onScaleChanged();
        }
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048643, this, f) == null) {
            super.setScaleY(f);
            getImpl().onScaleChanged();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            getImpl().setShadowPaddingEnabled(z);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, shapeAppearanceModel) == null) {
            getImpl().setShapeAppearance(shapeAppearanceModel);
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, motionSpec) == null) {
            getImpl().setShowMotionSpec(motionSpec);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
        }
    }

    public void setSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.customSize = 0;
            if (i != this.size) {
                this.size = i;
                requestLayout();
            }
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, colorStateList) == null) {
            setBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, mode) == null) {
            setBackgroundTintMode(mode);
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048651, this, colorStateList) == null) || this.imageTint == colorStateList) {
            return;
        }
        this.imageTint = colorStateList;
        onApplySupportImageTint();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, mode) == null) || this.imageMode == mode) {
            return;
        }
        this.imageMode = mode;
        onApplySupportImageTint();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048653, this, f) == null) {
            super.setTranslationX(f);
            getImpl().onTranslationChanged();
        }
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048654, this, f) == null) {
            super.setTranslationY(f);
            getImpl().onTranslationChanged();
        }
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048655, this, f) == null) {
            super.setTranslationZ(f);
            getImpl().onTranslationChanged();
        }
    }

    public void setUseCompatPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048656, this, z) == null) || this.compatPadding == z) {
            return;
        }
        this.compatPadding = z;
        getImpl().onCompatShadowChanged();
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i) == null) {
            super.setVisibility(i);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? getImpl().getEnsureMinTouchTargetSize() : invokeV.booleanValue;
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            show(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0402bc);
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

    private int getSizeDimension(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            int i2 = this.customSize;
            if (i2 != 0) {
                return i2;
            }
            Resources resources = getResources();
            if (i != -1) {
                if (i != 1) {
                    return resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070206);
                }
                return resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070205);
            } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                return getSizeDimension(1);
            } else {
                return getSizeDimension(0);
            }
        }
        return invokeI.intValue;
    }

    public void hide(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onVisibilityChangedListener) == null) {
            hide(onVisibilityChangedListener, true);
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, colorStateList) == null) || this.rippleColor == colorStateList) {
            return;
        }
        this.rippleColor = colorStateList;
        getImpl().setRippleColor(this.rippleColor);
    }

    public void show(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, onVisibilityChangedListener) == null) {
            show(onVisibilityChangedListener, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, obfuscated_res_0x7f100333), attributeSet, i);
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
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, new int[]{16842766, R.attr.obfuscated_res_0x7f0400b9, R.attr.obfuscated_res_0x7f0400ba, R.attr.obfuscated_res_0x7f0400ed, R.attr.obfuscated_res_0x7f04026e, R.attr.obfuscated_res_0x7f040287, R.attr.obfuscated_res_0x7f0402a4, R.attr.obfuscated_res_0x7f0402a5, R.attr.obfuscated_res_0x7f040305, R.attr.obfuscated_res_0x7f040328, R.attr.obfuscated_res_0x7f0404c2, R.attr.obfuscated_res_0x7f040567, R.attr.obfuscated_res_0x7f0405c8, R.attr.obfuscated_res_0x7f040615, R.attr.obfuscated_res_0x7f040618, R.attr.obfuscated_res_0x7f040620, R.attr.obfuscated_res_0x7f04074d}, i, obfuscated_res_0x7f100333, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 1);
        this.backgroundTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(2, -1), null);
        this.rippleColor = MaterialResources.getColorStateList(context2, obtainStyledAttributes, 12);
        this.size = obtainStyledAttributes.getInt(7, -1);
        this.customSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        float dimension = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(9, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(11, 0.0f);
        this.compatPadding = obtainStyledAttributes.getBoolean(16, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07049c);
        this.maxImageSize = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, 15);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, 8);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context2, attributeSet, i, obfuscated_res_0x7f100333, ShapeAppearanceModel.PILL).build();
        boolean z = obtainStyledAttributes.getBoolean(5, false);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.imageHelper = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(this);
        getImpl().setShapeAppearance(build);
        getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().setMinTouchTargetSize(dimensionPixelSize);
        getImpl().setElevation(dimension);
        getImpl().setHoveredFocusedTranslationZ(dimension2);
        getImpl().setPressedTranslationZ(dimension3);
        getImpl().setMaxImageSize(this.maxImageSize);
        getImpl().setShowMotionSpec(createFromAttribute);
        getImpl().setHideMotionSpec(createFromAttribute2);
        getImpl().setEnsureMinTouchTargetSize(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void hide(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, onVisibilityChangedListener, z) == null) {
            getImpl().hide(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
        }
    }

    public void show(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048661, this, onVisibilityChangedListener, z) == null) {
            getImpl().show(wrapOnVisibilityChangedListener(onVisibilityChangedListener), z);
        }
    }
}
