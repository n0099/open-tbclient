package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class MaterialCardViewHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    public static final int CHECKED_ICON_LAYER_INDEX = 2;
    public static final int[] CHECKED_STATE_SET;
    public static final double COS_45;
    public static final int DEFAULT_STROKE_VALUE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MaterialShapeDrawable bgDrawable;
    public boolean checkable;
    @Nullable
    public Drawable checkedIcon;
    @Dimension
    public final int checkedIconMargin;
    @Dimension
    public final int checkedIconSize;
    @Nullable
    public ColorStateList checkedIconTint;
    @Nullable
    public LayerDrawable clickableForegroundDrawable;
    @Nullable
    public MaterialShapeDrawable compatRippleDrawable;
    @Nullable
    public Drawable fgDrawable;
    @NonNull
    public final MaterialShapeDrawable foregroundContentDrawable;
    @Nullable
    public MaterialShapeDrawable foregroundShapeDrawable;
    public boolean isBackgroundOverwritten;
    @NonNull
    public final MaterialCardView materialCardView;
    @Nullable
    public ColorStateList rippleColor;
    @Nullable
    public Drawable rippleDrawable;
    @Nullable
    public ShapeAppearanceModel shapeAppearanceModel;
    @Nullable
    public ColorStateList strokeColor;
    @Dimension
    public int strokeWidth;
    @NonNull
    public final Rect userContentPadding;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1777237122, "Lcom/google/android/material/card/MaterialCardViewHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1777237122, "Lcom/google/android/material/card/MaterialCardViewHelper;");
                return;
            }
        }
        CHECKED_STATE_SET = new int[]{16842912};
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {materialCardView, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.userContentPadding = new Rect();
        this.isBackgroundOverwritten = false;
        this.materialCardView = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i, i2);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        this.bgDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = this.bgDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, new int[]{16843071, 16843072, R.attr.cardBackgroundColor, R.attr.cardCornerRadius, R.attr.cardElevation, R.attr.cardMaxElevation, R.attr.cardPreventCornerOverlap, R.attr.cardUseCompatPadding, R.attr.contentPadding, R.attr.contentPaddingBottom, R.attr.contentPaddingLeft, R.attr.contentPaddingRight, R.attr.contentPaddingTop}, i, R.style.obfuscated_res_0x7f1000fc);
        if (obtainStyledAttributes.hasValue(3)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        Resources resources = materialCardView.getResources();
        this.checkedIconMargin = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07047e);
        this.checkedIconSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07047f);
        obtainStyledAttributes.recycle();
    }

    private float calculateActualCornerPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize()))) : invokeV.floatValue;
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, this, cornerTreatment, f)) == null) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return (float) ((1.0d - COS_45) * f);
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return f / 2.0f;
            }
            return 0.0f;
        }
        return invokeLF.floatValue;
    }

    private float calculateHorizontalBackgroundPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
        }
        return invokeV.floatValue;
    }

    private float calculateVerticalBackgroundPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return (this.materialCardView.getMaxCardElevation() * 1.5f) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
        }
        return invokeV.floatValue;
    }

    private boolean canClipToOutline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? Build.VERSION.SDK_INT >= 21 && this.bgDrawable.isRoundRect() : invokeV.booleanValue;
    }

    @NonNull
    private Drawable createCheckedIconLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.checkedIcon;
            if (drawable != null) {
                stateListDrawable.addState(CHECKED_STATE_SET, drawable);
            }
            return stateListDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            MaterialShapeDrawable createForegroundShapeDrawable = createForegroundShapeDrawable();
            this.compatRippleDrawable = createForegroundShapeDrawable;
            createForegroundShapeDrawable.setFillColor(this.rippleColor);
            stateListDrawable.addState(new int[]{16842919}, this.compatRippleDrawable);
            return stateListDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.foregroundShapeDrawable = createForegroundShapeDrawable();
                return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
            }
            return createCompatRippleDrawable();
        }
        return (Drawable) invokeV.objValue;
    }

    @NonNull
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? new MaterialShapeDrawable(this.shapeAppearanceModel) : (MaterialShapeDrawable) invokeV.objValue;
    }

    @NonNull
    private Drawable getClickableForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.rippleDrawable == null) {
                this.rippleDrawable = createForegroundRippleDrawable();
            }
            if (this.clickableForegroundDrawable == null) {
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, createCheckedIconLayer()});
                this.clickableForegroundDrawable = layerDrawable;
                layerDrawable.setId(2, R.id.obfuscated_res_0x7f09156b);
            }
            return this.clickableForegroundDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.materialCardView.getPreventCornerOverlap()) {
                if (Build.VERSION.SDK_INT < 21 || this.materialCardView.getUseCompatPadding()) {
                    return (float) ((1.0d - COS_45) * this.materialCardView.getCardViewRadius());
                }
                return 0.0f;
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @NonNull
    private Drawable insetDrawable(Drawable drawable) {
        InterceptResult invokeL;
        int ceil;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, drawable)) == null) {
            if ((Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
                int ceil2 = (int) Math.ceil(calculateVerticalBackgroundPadding());
                ceil = (int) Math.ceil(calculateHorizontalBackgroundPadding());
                i = ceil2;
            } else {
                ceil = 0;
                i = 0;
            }
            return new InsetDrawable(this, drawable, ceil, i, ceil, i) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialCardViewHelper this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(drawable, ceil, i, ceil, i);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, drawable, Integer.valueOf(ceil), Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.graphics.drawable.Drawable
                public int getMinimumHeight() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return -1;
                    }
                    return invokeV.intValue;
                }

                @Override // android.graphics.drawable.Drawable
                public int getMinimumWidth() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return -1;
                    }
                    return invokeV.intValue;
                }

                @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
                public boolean getPadding(Rect rect) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect)) == null) {
                        return false;
                    }
                    return invokeL2.booleanValue;
                }
            };
        }
        return (Drawable) invokeL.objValue;
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.materialCardView.getPreventCornerOverlap() && !canClipToOutline() : invokeV.booleanValue;
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding() : invokeV.booleanValue;
    }

    private void updateInsetForeground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, drawable) == null) {
            if (Build.VERSION.SDK_INT >= 23 && (this.materialCardView.getForeground() instanceof InsetDrawable)) {
                ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
            } else {
                this.materialCardView.setForeground(insetDrawable(drawable));
            }
        }
    }

    private void updateRippleColor() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if (RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.rippleDrawable) != null) {
                ((RippleDrawable) drawable).setColor(this.rippleColor);
                return;
            }
            MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setFillColor(this.rippleColor);
            }
        }
    }

    @RequiresApi(api = 23)
    public void forceRippleRedraw() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (drawable = this.rippleDrawable) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i = bounds.bottom;
        this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @NonNull
    public MaterialShapeDrawable getBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bgDrawable : (MaterialShapeDrawable) invokeV.objValue;
    }

    public ColorStateList getCardBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bgDrawable.getFillColor() : (ColorStateList) invokeV.objValue;
    }

    public ColorStateList getCardForegroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.foregroundContentDrawable.getFillColor() : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.checkedIcon : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.checkedIconTint : (ColorStateList) invokeV.objValue;
    }

    public float getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.bgDrawable.getTopLeftCornerResolvedSize() : invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.bgDrawable.getInterpolation() : invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.rippleColor : (ColorStateList) invokeV.objValue;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.shapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    @ColorInt
    public int getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ColorStateList colorStateList = this.strokeColor;
            if (colorStateList == null) {
                return -1;
            }
            return colorStateList.getDefaultColor();
        }
        return invokeV.intValue;
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.strokeColor : (ColorStateList) invokeV.objValue;
    }

    @Dimension
    public int getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.strokeWidth : invokeV.intValue;
    }

    @NonNull
    public Rect getUserContentPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.userContentPadding : (Rect) invokeV.objValue;
    }

    public boolean isBackgroundOverwritten() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.isBackgroundOverwritten : invokeV.booleanValue;
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.checkable : invokeV.booleanValue;
    }

    public void loadFromAttributes(@NonNull TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, typedArray) == null) {
            ColorStateList colorStateList = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 8);
            this.strokeColor = colorStateList;
            if (colorStateList == null) {
                this.strokeColor = ColorStateList.valueOf(-1);
            }
            this.strokeWidth = typedArray.getDimensionPixelSize(9, 0);
            boolean z = typedArray.getBoolean(0, false);
            this.checkable = z;
            this.materialCardView.setLongClickable(z);
            this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 3);
            setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, 2));
            ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 4);
            this.rippleColor = colorStateList2;
            if (colorStateList2 == null) {
                this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, R.attr.obfuscated_res_0x7f04016f));
            }
            setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, 1));
            updateRippleColor();
            updateElevation();
            updateStroke();
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
            Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
            this.fgDrawable = clickableForeground;
            this.materialCardView.setForeground(insetDrawable(clickableForeground));
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) || this.clickableForegroundDrawable == null) {
            return;
        }
        int i5 = this.checkedIconMargin;
        int i6 = this.checkedIconSize;
        int i7 = (i - i5) - i6;
        int i8 = (i2 - i5) - i6;
        if ((Build.VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
            i8 -= (int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
            i7 -= (int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
        }
        int i9 = i8;
        int i10 = this.checkedIconMargin;
        if (ViewCompat.getLayoutDirection(this.materialCardView) == 1) {
            i4 = i7;
            i3 = i10;
        } else {
            i3 = i7;
            i4 = i10;
        }
        this.clickableForegroundDrawable.setLayerInset(2, i3, this.checkedIconMargin, i4, i9);
    }

    public void setBackgroundOverwritten(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.isBackgroundOverwritten = z;
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, colorStateList) == null) {
            this.bgDrawable.setFillColor(colorStateList);
        }
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, colorStateList) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.checkable = z;
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            this.checkedIcon = drawable;
            if (drawable != null) {
                Drawable wrap = DrawableCompat.wrap(drawable.mutate());
                this.checkedIcon = wrap;
                DrawableCompat.setTintList(wrap, this.checkedIconTint);
            }
            if (this.clickableForegroundDrawable != null) {
                this.clickableForegroundDrawable.setDrawableByLayerId(R.id.obfuscated_res_0x7f09156b, createCheckedIconLayer());
            }
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, colorStateList) == null) {
            this.checkedIconTint = colorStateList;
            Drawable drawable = this.checkedIcon;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
    }

    public void setCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f) == null) {
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f));
            this.fgDrawable.invalidateSelf();
            if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
                updateContentPadding();
            }
            if (shouldAddCornerPaddingOutsideCardBackground()) {
                updateInsets();
            }
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            this.bgDrawable.setInterpolation(f);
            MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setInterpolation(f);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
            if (materialShapeDrawable2 != null) {
                materialShapeDrawable2.setInterpolation(f);
            }
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, colorStateList) == null) {
            this.rippleColor = colorStateList;
            updateRippleColor();
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, shapeAppearanceModel) == null) {
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel);
            MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
            materialShapeDrawable.setShadowBitmapDrawingEnable(!materialShapeDrawable.isRoundRect());
            MaterialShapeDrawable materialShapeDrawable2 = this.foregroundContentDrawable;
            if (materialShapeDrawable2 != null) {
                materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
            }
            MaterialShapeDrawable materialShapeDrawable3 = this.foregroundShapeDrawable;
            if (materialShapeDrawable3 != null) {
                materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
            }
            MaterialShapeDrawable materialShapeDrawable4 = this.compatRippleDrawable;
            if (materialShapeDrawable4 != null) {
                materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel);
            }
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, colorStateList) == null) || this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    public void setStrokeWidth(@Dimension int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i) == null) || i == this.strokeWidth) {
            return;
        }
        this.strokeWidth = i;
        updateStroke();
    }

    public void setUserContentPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048606, this, i, i2, i3, i4) == null) {
            this.userContentPadding.set(i, i2, i3, i4);
            updateContentPadding();
        }
    }

    public void updateClickable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Drawable drawable = this.fgDrawable;
            Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
            this.fgDrawable = clickableForeground;
            if (drawable != clickableForeground) {
                updateInsetForeground(clickableForeground);
            }
        }
    }

    public void updateContentPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            int calculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f) - getParentCardViewCalculatedCornerPadding());
            MaterialCardView materialCardView = this.materialCardView;
            Rect rect = this.userContentPadding;
            materialCardView.setAncestorContentPadding(rect.left + calculateActualCornerPadding, rect.top + calculateActualCornerPadding, rect.right + calculateActualCornerPadding, rect.bottom + calculateActualCornerPadding);
        }
    }

    public void updateElevation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
        }
    }

    public void updateInsets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (!isBackgroundOverwritten()) {
                this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
            }
            this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
        }
    }

    public void updateStroke() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
        }
    }
}
