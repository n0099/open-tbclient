package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
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
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;
/* loaded from: classes7.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIM_STATE_HIDING = 1;
    public static final int ANIM_STATE_NONE = 0;
    public static final int ANIM_STATE_SHOWING = 2;
    public static final int DEF_STYLE_RES;
    public static final Property<View, Float> HEIGHT;
    public static final Property<View, Float> WIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    public int animState;
    @NonNull
    public final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    public final AnimatorTracker changeVisibilityTracker;
    @NonNull
    public final MotionStrategy extendStrategy;
    public final MotionStrategy hideStrategy;
    public boolean isExtended;
    public final MotionStrategy showStrategy;
    @NonNull
    public final MotionStrategy shrinkStrategy;

    /* loaded from: classes7.dex */
    public class ChangeSizeStrategy extends BaseMotionStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean extending;
        public final Size size;
        public final /* synthetic */ ExtendedFloatingActionButton this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeSizeStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker, Size size, boolean z) {
            super(extendedFloatingActionButton, animatorTracker);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extendedFloatingActionButton, animatorTracker, size, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ExtendedFloatingActionButton) objArr2[0], (AnimatorTracker) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = extendedFloatingActionButton;
            this.size = size;
            this.extending = z;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        @NonNull
        public AnimatorSet createAnimator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                MotionSpec currentMotionSpec = getCurrentMotionSpec();
                if (currentMotionSpec.hasPropertyValues("width")) {
                    PropertyValuesHolder[] propertyValues = currentMotionSpec.getPropertyValues("width");
                    propertyValues[0].setFloatValues(this.this$0.getWidth(), this.size.getWidth());
                    currentMotionSpec.setPropertyValues("width", propertyValues);
                }
                if (currentMotionSpec.hasPropertyValues("height")) {
                    PropertyValuesHolder[] propertyValues2 = currentMotionSpec.getPropertyValues("height");
                    propertyValues2[0].setFloatValues(this.this$0.getHeight(), this.size.getHeight());
                    currentMotionSpec.setPropertyValues("height", propertyValues2);
                }
                return super.createAnimator(currentMotionSpec);
            }
            return (AnimatorSet) invokeV.objValue;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.animator.mtrl_extended_fab_change_size_motion_spec : invokeV.intValue;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.onAnimationEnd();
                this.this$0.setHorizontallyScrolling(false);
                ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                layoutParams.width = this.size.getLayoutParams().width;
                layoutParams.height = this.size.getLayoutParams().height;
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                super.onAnimationStart(animator);
                this.this$0.isExtended = this.extending;
                this.this$0.setHorizontallyScrolling(true);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback onChangedCallback) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, onChangedCallback) == null) || onChangedCallback == null) {
                return;
            }
            if (this.extending) {
                onChangedCallback.onExtended(this.this$0);
            } else {
                onChangedCallback.onShrunken(this.this$0);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.this$0.isExtended = this.extending;
                ViewGroup.LayoutParams layoutParams = this.this$0.getLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                layoutParams.width = this.size.getLayoutParams().width;
                layoutParams.height = this.size.getLayoutParams().height;
                this.this$0.requestLayout();
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.extending == this.this$0.isExtended || this.this$0.getIcon() == null || TextUtils.isEmpty(this.this$0.getText()) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final boolean AUTO_HIDE_DEFAULT = false;
        public static final boolean AUTO_SHRINK_DEFAULT = true;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean autoHideEnabled;
        public boolean autoShrinkEnabled;
        @Nullable
        public OnChangedCallback internalAutoHideCallback;
        @Nullable
        public OnChangedCallback internalAutoShrinkCallback;
        public Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
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
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public static boolean isBottomSheet(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        private boolean shouldUpdateVisibility(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, view, extendedFloatingActionButton)) == null) {
                return (this.autoHideEnabled || this.autoShrinkEnabled) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
            }
            return invokeLL.booleanValue;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, this, coordinatorLayout, appBarLayout, extendedFloatingActionButton)) == null) {
                if (shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                    if (this.tmpRect == null) {
                        this.tmpRect = new Rect();
                    }
                    Rect rect = this.tmpRect;
                    DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
                    if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                        shrinkOrHide(extendedFloatingActionButton);
                        return true;
                    }
                    extendOrShow(extendedFloatingActionButton);
                    return true;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, view, extendedFloatingActionButton)) == null) {
                if (shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                    if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                        shrinkOrHide(extendedFloatingActionButton);
                        return true;
                    }
                    extendOrShow(extendedFloatingActionButton);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public void extendOrShow(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, extendedFloatingActionButton) == null) {
                extendedFloatingActionButton.performMotion(this.autoShrinkEnabled ? extendedFloatingActionButton.extendStrategy : extendedFloatingActionButton.showStrategy, this.autoShrinkEnabled ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
            }
        }

        public boolean isAutoHideEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.autoHideEnabled : invokeV.booleanValue;
        }

        public boolean isAutoShrinkEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.autoShrinkEnabled : invokeV.booleanValue;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, layoutParams) == null) && layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public void setAutoHideEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.autoHideEnabled = z;
            }
        }

        public void setAutoShrinkEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
                this.autoShrinkEnabled = z;
            }
        }

        @VisibleForTesting
        public void setInternalAutoHideCallback(@Nullable OnChangedCallback onChangedCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, onChangedCallback) == null) {
                this.internalAutoHideCallback = onChangedCallback;
            }
        }

        @VisibleForTesting
        public void setInternalAutoShrinkCallback(@Nullable OnChangedCallback onChangedCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, onChangedCallback) == null) {
                this.internalAutoShrinkCallback = onChangedCallback;
            }
        }

        public void shrinkOrHide(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, extendedFloatingActionButton) == null) {
                extendedFloatingActionButton.performMotion(this.autoShrinkEnabled ? extendedFloatingActionButton.shrinkStrategy : extendedFloatingActionButton.hideStrategy, this.autoShrinkEnabled ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, coordinatorLayout, extendedFloatingActionButton, rect)) == null) ? super.getInsetDodgeRect(coordinatorLayout, (CoordinatorLayout) extendedFloatingActionButton, rect) : invokeLLL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, coordinatorLayout, extendedFloatingActionButton, view)) == null) {
                if (view instanceof AppBarLayout) {
                    updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                    return false;
                } else if (isBottomSheet(view)) {
                    updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, coordinatorLayout, extendedFloatingActionButton, i2)) == null) {
                List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
                int size = dependencies.size();
                for (int i3 = 0; i3 < size; i3++) {
                    View view = dependencies.get(i3);
                    if (view instanceof AppBarLayout) {
                        if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                            break;
                        }
                    } else {
                        if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                            break;
                        }
                    }
                }
                coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i2);
                return true;
            }
            return invokeLLI.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes7.dex */
    public class HideStrategy extends BaseMotionStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isCancelled;
        public final /* synthetic */ ExtendedFloatingActionButton this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HideStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
            super(extendedFloatingActionButton, animatorTracker);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extendedFloatingActionButton, animatorTracker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ExtendedFloatingActionButton) objArr2[0], (AnimatorTracker) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = extendedFloatingActionButton;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.animator.mtrl_extended_fab_hide_motion_spec : invokeV.intValue;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onAnimationCancel();
                this.isCancelled = true;
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.onAnimationEnd();
                this.this$0.animState = 0;
                if (this.isCancelled) {
                    return;
                }
                this.this$0.setVisibility(8);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                super.onAnimationStart(animator);
                this.isCancelled = false;
                this.this$0.setVisibility(0);
                this.this$0.animState = 1;
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback onChangedCallback) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, onChangedCallback) == null) || onChangedCallback == null) {
                return;
            }
            onChangedCallback.onHidden(this.this$0);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.this$0.setVisibility(8);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.this$0.isOrWillBeHidden() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class OnChangedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OnChangedCallback() {
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

        public void onExtended(ExtendedFloatingActionButton extendedFloatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, extendedFloatingActionButton) == null) {
            }
        }

        public void onHidden(ExtendedFloatingActionButton extendedFloatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extendedFloatingActionButton) == null) {
            }
        }

        public void onShown(ExtendedFloatingActionButton extendedFloatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extendedFloatingActionButton) == null) {
            }
        }

        public void onShrunken(ExtendedFloatingActionButton extendedFloatingActionButton) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, extendedFloatingActionButton) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class ShowStrategy extends BaseMotionStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExtendedFloatingActionButton this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
            super(extendedFloatingActionButton, animatorTracker);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extendedFloatingActionButton, animatorTracker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ExtendedFloatingActionButton) objArr2[0], (AnimatorTracker) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = extendedFloatingActionButton;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.animator.mtrl_extended_fab_show_motion_spec : invokeV.intValue;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onAnimationEnd();
                this.this$0.animState = 0;
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                super.onAnimationStart(animator);
                this.this$0.setVisibility(0);
                this.this$0.animState = 2;
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback onChangedCallback) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, onChangedCallback) == null) || onChangedCallback == null) {
                return;
            }
            onChangedCallback.onShown(this.this$0);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.this$0.setVisibility(0);
                this.this$0.setAlpha(1.0f);
                this.this$0.setScaleY(1.0f);
                this.this$0.setScaleX(1.0f);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.this$0.isOrWillBeShown() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface Size {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getWidth();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-937380449, "Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-937380449, "Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
        WIDTH = new Property<View, Float>(Float.class, "width") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            @NonNull
            public Float get(@NonNull View view) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) ? Float.valueOf(view.getLayoutParams().width) : (Float) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(@NonNull View view, @NonNull Float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                    view.getLayoutParams().width = f2.intValue();
                    view.requestLayout();
                }
            }
        };
        HEIGHT = new Property<View, Float>(Float.class, "height") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            @NonNull
            public Float get(@NonNull View view) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) ? Float.valueOf(view.getLayoutParams().height) : (Float) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public void set(@NonNull View view, @NonNull Float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                    view.getLayoutParams().height = f2.intValue();
                    view.requestLayout();
                }
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedFloatingActionButton(@NonNull Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeHidden() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? getVisibility() == 0 ? this.animState == 1 : this.animState != 2 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrWillBeShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? getVisibility() != 0 ? this.animState == 2 : this.animState != 1 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performMotion(@NonNull MotionStrategy motionStrategy, @Nullable OnChangedCallback onChangedCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, this, motionStrategy, onChangedCallback) == null) || motionStrategy.shouldCancel()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            motionStrategy.performNow();
            motionStrategy.onChange(onChangedCallback);
            return;
        }
        measure(0, 0);
        AnimatorSet createAnimator = motionStrategy.createAnimator();
        createAnimator.addListener(new AnimatorListenerAdapter(this, motionStrategy, onChangedCallback) { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean cancelled;
            public final /* synthetic */ ExtendedFloatingActionButton this$0;
            public final /* synthetic */ OnChangedCallback val$callback;
            public final /* synthetic */ MotionStrategy val$strategy;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, motionStrategy, onChangedCallback};
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
                this.val$strategy = motionStrategy;
                this.val$callback = onChangedCallback;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.cancelled = true;
                    this.val$strategy.onAnimationCancel();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.val$strategy.onAnimationEnd();
                    if (this.cancelled) {
                        return;
                    }
                    this.val$strategy.onChange(this.val$callback);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    this.val$strategy.onAnimationStart(animator);
                    this.cancelled = false;
                }
            }
        });
        for (Animator.AnimatorListener animatorListener : motionStrategy.getListeners()) {
            createAnimator.addListener(animatorListener);
        }
        createAnimator.start();
    }

    private boolean shouldAnimateVisibilityChange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? ViewCompat.isLaidOut(this) && !isInEditMode() : invokeV.booleanValue;
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            this.extendStrategy.addAnimationListener(animatorListener);
        }
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorListener) == null) {
            this.hideStrategy.addAnimationListener(animatorListener);
        }
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animatorListener) == null) {
            this.showStrategy.addAnimationListener(animatorListener);
        }
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animatorListener) == null) {
            this.shrinkStrategy.addAnimationListener(animatorListener);
        }
    }

    public void extend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            performMotion(this.extendStrategy, null);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.behavior : (CoordinatorLayout.Behavior) invokeV.objValue;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : invokeV.intValue;
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.extendStrategy.getMotionSpec() : (MotionSpec) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.hideStrategy.getMotionSpec() : (MotionSpec) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.showStrategy.getMotionSpec() : (MotionSpec) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.shrinkStrategy.getMotionSpec() : (MotionSpec) invokeV.objValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            performMotion(this.hideStrategy, null);
        }
    }

    public final boolean isExtended() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.isExtended : invokeV.booleanValue;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onAttachedToWindow();
            if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
                this.isExtended = false;
                this.shrinkStrategy.performNow();
            }
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, animatorListener) == null) {
            this.extendStrategy.removeAnimationListener(animatorListener);
        }
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, animatorListener) == null) {
            this.hideStrategy.removeAnimationListener(animatorListener);
        }
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, animatorListener) == null) {
            this.showStrategy.removeAnimationListener(animatorListener);
        }
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, animatorListener) == null) {
            this.shrinkStrategy.removeAnimationListener(animatorListener);
        }
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, motionSpec) == null) {
            this.extendStrategy.setMotionSpec(motionSpec);
        }
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i2));
        }
    }

    public void setExtended(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || this.isExtended == z) {
            return;
        }
        MotionStrategy motionStrategy = z ? this.extendStrategy : this.shrinkStrategy;
        if (motionStrategy.shouldCancel()) {
            return;
        }
        motionStrategy.performNow();
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, motionSpec) == null) {
            this.hideStrategy.setMotionSpec(motionSpec);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            setHideMotionSpec(MotionSpec.createFromResource(getContext(), i2));
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, motionSpec) == null) {
            this.showStrategy.setMotionSpec(motionSpec);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            setShowMotionSpec(MotionSpec.createFromResource(getContext(), i2));
        }
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, motionSpec) == null) {
            this.shrinkStrategy.setMotionSpec(motionSpec);
        }
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i2));
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            performMotion(this.showStrategy, null);
        }
    }

    public void shrink() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            performMotion(this.shrinkStrategy, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
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

    public void extend(@NonNull OnChangedCallback onChangedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onChangedCallback) == null) {
            performMotion(this.extendStrategy, onChangedCallback);
        }
    }

    public void hide(@NonNull OnChangedCallback onChangedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onChangedCallback) == null) {
            performMotion(this.hideStrategy, onChangedCallback);
        }
    }

    public void show(@NonNull OnChangedCallback onChangedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onChangedCallback) == null) {
            performMotion(this.showStrategy, onChangedCallback);
        }
    }

    public void shrink(@NonNull OnChangedCallback onChangedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onChangedCallback) == null) {
            performMotion(this.shrinkStrategy, onChangedCallback);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.animState = 0;
        AnimatorTracker animatorTracker = new AnimatorTracker();
        this.changeVisibilityTracker = animatorTracker;
        this.showStrategy = new ShowStrategy(this, animatorTracker);
        this.hideStrategy = new HideStrategy(this, this.changeVisibilityTracker);
        this.isExtended = true;
        Context context2 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.ExtendedFloatingActionButton, i2, DEF_STYLE_RES, new int[0]);
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec createFromAttribute3 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec createFromAttribute4 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        AnimatorTracker animatorTracker2 = new AnimatorTracker();
        this.extendStrategy = new ChangeSizeStrategy(this, animatorTracker2, new Size(this) { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExtendedFloatingActionButton this$0;

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

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getHeight() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.getMeasuredHeight() : invokeV.intValue;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public ViewGroup.LayoutParams getLayoutParams() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ViewGroup.LayoutParams(-2, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getWidth() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.getMeasuredWidth() : invokeV.intValue;
            }
        }, true);
        this.shrinkStrategy = new ChangeSizeStrategy(this, animatorTracker2, new Size(this) { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExtendedFloatingActionButton this$0;

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

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getHeight() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.getCollapsedSize() : invokeV.intValue;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public ViewGroup.LayoutParams getLayoutParams() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ViewGroup.LayoutParams(getWidth(), getHeight()) : (ViewGroup.LayoutParams) invokeV.objValue;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getWidth() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.getCollapsedSize() : invokeV.intValue;
            }
        }, false);
        this.showStrategy.setMotionSpec(createFromAttribute);
        this.hideStrategy.setMotionSpec(createFromAttribute2);
        this.extendStrategy.setMotionSpec(createFromAttribute3);
        this.shrinkStrategy.setMotionSpec(createFromAttribute4);
        obtainStyledAttributes.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context2, attributeSet, i2, DEF_STYLE_RES, ShapeAppearanceModel.PILL).build());
    }
}
