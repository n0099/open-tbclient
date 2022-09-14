package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes7.dex */
public class MaterialCardView extends CardView implements Checkable, Shapeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    public static final int[] CHECKABLE_STATE_SET;
    public static final int[] CHECKED_STATE_SET;
    public static final int DEF_STYLE_RES = 2131755867;
    public static final int[] DRAGGED_STATE_SET;
    public static final String LOG_TAG = "MaterialCardView";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MaterialCardViewHelper cardViewHelper;
    public boolean checked;
    public boolean dragged;
    public boolean isParentCardViewDoneInitializing;
    public OnCheckedChangeListener onCheckedChangeListener;

    /* loaded from: classes7.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView materialCardView, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(537892428, "Lcom/google/android/material/card/MaterialCardView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(537892428, "Lcom/google/android/material/card/MaterialCardView;");
                return;
            }
        }
        CHECKABLE_STATE_SET = new int[]{16842911};
        CHECKED_STATE_SET = new int[]{16842912};
        DRAGGED_STATE_SET = new int[]{R.attr.obfuscated_res_0x7f040658};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialCardView(Context context) {
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

    private void forceRippleRedrawIfNeeded() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || Build.VERSION.SDK_INT <= 26) {
            return;
        }
        this.cardViewHelper.forceRippleRedraw();
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            RectF rectF = new RectF();
            rectF.set(this.cardViewHelper.getBackground().getBounds());
            return rectF;
        }
        return (RectF) invokeV.objValue;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cardViewHelper.getCardBackgroundColor() : (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cardViewHelper.getCardForegroundColor() : (ColorStateList) invokeV.objValue;
    }

    public float getCardViewRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.getRadius() : invokeV.floatValue;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cardViewHelper.getCheckedIcon() : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cardViewHelper.getCheckedIconTint() : (ColorStateList) invokeV.objValue;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cardViewHelper.getUserContentPadding().bottom : invokeV.intValue;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.cardViewHelper.getUserContentPadding().left : invokeV.intValue;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.cardViewHelper.getUserContentPadding().right : invokeV.intValue;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.cardViewHelper.getUserContentPadding().top : invokeV.intValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.cardViewHelper.getProgress() : invokeV.floatValue;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.cardViewHelper.getCornerRadius() : invokeV.floatValue;
    }

    public ColorStateList getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.cardViewHelper.getRippleColor() : (ColorStateList) invokeV.objValue;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.cardViewHelper.getShapeAppearanceModel() : (ShapeAppearanceModel) invokeV.objValue;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.cardViewHelper.getStrokeColor() : invokeV.intValue;
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.cardViewHelper.getStrokeColorStateList() : (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public int getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.cardViewHelper.getStrokeWidth() : invokeV.intValue;
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
            return materialCardViewHelper != null && materialCardViewHelper.isCheckable();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.checked : invokeV.booleanValue;
    }

    public boolean isDragged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.dragged : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onAttachedToWindow();
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.cardViewHelper.getBackground());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
            if (isCheckable()) {
                FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
            }
            if (isChecked()) {
                FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
            }
            if (isDragged()) {
                FrameLayout.mergeDrawableStates(onCreateDrawableState, DRAGGED_STATE_SET);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
            accessibilityEvent.setChecked(isChecked());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
            accessibilityNodeInfo.setCheckable(isCheckable());
            accessibilityNodeInfo.setClickable(isClickable());
            accessibilityNodeInfo.setChecked(isChecked());
        }
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.cardViewHelper.onMeasure(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setAncestorContentPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) {
            super.setContentPadding(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, drawable) == null) {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, drawable) == null) && this.isParentCardViewDoneInitializing) {
            if (!this.cardViewHelper.isBackgroundOverwritten()) {
                Log.i(LOG_TAG, "Setting a custom background is not supported.");
                this.cardViewHelper.setBackgroundOverwritten(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, drawable) == null) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.cardViewHelper.setCardBackgroundColor(ColorStateList.valueOf(i));
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f) == null) {
            super.setCardElevation(f);
            this.cardViewHelper.updateElevation();
        }
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, colorStateList) == null) {
            this.cardViewHelper.setCardForegroundColor(colorStateList);
        }
    }

    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.cardViewHelper.setCheckable(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.checked == z) {
            return;
        }
        toggle();
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, drawable) == null) {
            this.cardViewHelper.setCheckedIcon(drawable);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.cardViewHelper.setCheckedIcon(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, colorStateList) == null) {
            this.cardViewHelper.setCheckedIconTint(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            super.setClickable(z);
            MaterialCardViewHelper materialCardViewHelper = this.cardViewHelper;
            if (materialCardViewHelper != null) {
                materialCardViewHelper.updateClickable();
            }
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048614, this, i, i2, i3, i4) == null) {
            this.cardViewHelper.setUserContentPadding(i, i2, i3, i4);
        }
    }

    public void setDragged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || this.dragged == z) {
            return;
        }
        this.dragged = z;
        refreshDrawableState();
        forceRippleRedrawIfNeeded();
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048616, this, f) == null) {
            super.setMaxCardElevation(f);
            this.cardViewHelper.updateInsets();
        }
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onCheckedChangeListener) == null) {
            this.onCheckedChangeListener = onCheckedChangeListener;
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            super.setPreventCornerOverlap(z);
            this.cardViewHelper.updateInsets();
            this.cardViewHelper.updateContentPadding();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f) == null) {
            this.cardViewHelper.setProgress(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f) == null) {
            super.setRadius(f);
            this.cardViewHelper.setCornerRadius(f);
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, colorStateList) == null) {
            this.cardViewHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.cardViewHelper.setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, shapeAppearanceModel) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                setClipToOutline(shapeAppearanceModel.isRoundRect(getBoundsAsRectF()));
            }
            this.cardViewHelper.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public void setStrokeColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.cardViewHelper.setStrokeColor(ColorStateList.valueOf(i));
        }
    }

    public void setStrokeWidth(@Dimension int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.cardViewHelper.setStrokeWidth(i);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            super.setUseCompatPadding(z);
            this.cardViewHelper.updateInsets();
            this.cardViewHelper.updateContentPadding();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && isCheckable() && isEnabled()) {
            this.checked = !this.checked;
            refreshDrawableState();
            forceRippleRedrawIfNeeded();
            OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.checked);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0404b7);
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

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, colorStateList) == null) {
            this.cardViewHelper.setCardBackgroundColor(colorStateList);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, colorStateList) == null) {
            this.cardViewHelper.setStrokeColor(colorStateList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
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
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i, DEF_STYLE_RES, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this, attributeSet, i, DEF_STYLE_RES);
        this.cardViewHelper = materialCardViewHelper;
        materialCardViewHelper.setCardBackgroundColor(super.getCardBackgroundColor());
        this.cardViewHelper.setUserContentPadding(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        this.cardViewHelper.loadFromAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
