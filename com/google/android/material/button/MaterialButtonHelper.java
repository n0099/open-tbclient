package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class MaterialButtonHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean IS_LOLLIPOP;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean backgroundOverwritten;
    @Nullable
    public ColorStateList backgroundTint;
    @Nullable
    public PorterDuff.Mode backgroundTintMode;
    public boolean checkable;
    public int cornerRadius;
    public boolean cornerRadiusSet;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    @Nullable
    public Drawable maskDrawable;
    public final MaterialButton materialButton;
    @Nullable
    public ColorStateList rippleColor;
    public LayerDrawable rippleDrawable;
    @NonNull
    public ShapeAppearanceModel shapeAppearanceModel;
    public boolean shouldDrawSurfaceColorStroke;
    @Nullable
    public ColorStateList strokeColor;
    public int strokeWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2098112349, "Lcom/google/android/material/button/MaterialButtonHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2098112349, "Lcom/google/android/material/button/MaterialButtonHelper;");
                return;
            }
        }
        IS_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
    }

    public MaterialButtonHelper(MaterialButton materialButton, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {materialButton, shapeAppearanceModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.shouldDrawSurfaceColorStroke = false;
        this.backgroundOverwritten = false;
        this.cornerRadiusSet = false;
        this.materialButton = materialButton;
        this.shapeAppearanceModel = shapeAppearanceModel;
    }

    private Drawable createBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
            materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
            DrawableCompat.setTintList(materialShapeDrawable, this.backgroundTint);
            PorterDuff.Mode mode = this.backgroundTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(materialShapeDrawable, mode);
            }
            materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
            materialShapeDrawable2.setTint(0);
            materialShapeDrawable2.setStroke(this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, R.attr.colorSurface) : 0);
            if (IS_LOLLIPOP) {
                MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
                this.maskDrawable = materialShapeDrawable3;
                DrawableCompat.setTint(materialShapeDrawable3, -1);
                RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.maskDrawable);
                this.rippleDrawable = rippleDrawable;
                return rippleDrawable;
            }
            RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeAppearanceModel);
            this.maskDrawable = rippleDrawableCompat;
            DrawableCompat.setTintList(rippleDrawableCompat, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.maskDrawable});
            this.rippleDrawable = layerDrawable;
            return wrapDrawableWithInset(layerDrawable);
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            LayerDrawable layerDrawable = this.rippleDrawable;
            if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
                return null;
            }
            if (IS_LOLLIPOP) {
                return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
            }
            return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(!z ? 1 : 0);
        }
        return (MaterialShapeDrawable) invokeZ.objValue;
    }

    @Nullable
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? getMaterialShapeDrawable(true) : (MaterialShapeDrawable) invokeV.objValue;
    }

    private void updateButtonShape(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, shapeAppearanceModel) == null) {
            if (getMaterialShapeDrawable() != null) {
                getMaterialShapeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (getSurfaceColorStrokeDrawable() != null) {
                getSurfaceColorStrokeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (getMaskDrawable() != null) {
                getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel);
            }
        }
    }

    private void updateStroke() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
            MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
            if (materialShapeDrawable != null) {
                materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
                if (surfaceColorStrokeDrawable != null) {
                    surfaceColorStrokeDrawable.setStroke(this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, R.attr.colorSurface) : 0);
                }
            }
        }
    }

    @NonNull
    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, drawable)) == null) ? new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom) : (InsetDrawable) invokeL.objValue;
    }

    public int getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cornerRadius : invokeV.intValue;
    }

    @Nullable
    public Shapeable getMaskDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LayerDrawable layerDrawable = this.rippleDrawable;
            if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
                return null;
            }
            if (this.rippleDrawable.getNumberOfLayers() > 2) {
                return (Shapeable) this.rippleDrawable.getDrawable(2);
            }
            return (Shapeable) this.rippleDrawable.getDrawable(1);
        }
        return (Shapeable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.rippleColor : (ColorStateList) invokeV.objValue;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.shapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.strokeColor : (ColorStateList) invokeV.objValue;
    }

    public int getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.strokeWidth : invokeV.intValue;
    }

    public ColorStateList getSupportBackgroundTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.backgroundTint : (ColorStateList) invokeV.objValue;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.backgroundTintMode : (PorterDuff.Mode) invokeV.objValue;
    }

    public boolean isBackgroundOverwritten() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.backgroundOverwritten : invokeV.booleanValue;
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.checkable : invokeV.booleanValue;
    }

    public void loadFromAttributes(@NonNull TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, typedArray) == null) {
            this.insetLeft = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
            this.insetRight = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
            this.insetTop = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
            this.insetBottom = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
            if (typedArray.hasValue(R.styleable.MaterialButton_cornerRadius)) {
                int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
                this.cornerRadius = dimensionPixelSize;
                setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(dimensionPixelSize));
                this.cornerRadiusSet = true;
            }
            this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
            this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
            this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
            this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
            this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
            this.checkable = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
            int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
            int paddingTop = this.materialButton.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
            int paddingBottom = this.materialButton.getPaddingBottom();
            if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
                setBackgroundOverwritten();
            } else {
                this.materialButton.setInternalBackground(createBackground());
                MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
                if (materialShapeDrawable != null) {
                    materialShapeDrawable.setElevation(dimensionPixelSize2);
                }
            }
            ViewCompat.setPaddingRelative(this.materialButton, paddingStart + this.insetLeft, paddingTop + this.insetTop, paddingEnd + this.insetRight, paddingBottom + this.insetBottom);
        }
    }

    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || getMaterialShapeDrawable() == null) {
            return;
        }
        getMaterialShapeDrawable().setTint(i2);
    }

    public void setBackgroundOverwritten() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.backgroundOverwritten = true;
            this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
            this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
        }
    }

    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.checkable = z;
        }
    }

    public void setCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (this.cornerRadiusSet && this.cornerRadius == i2) {
                return;
            }
            this.cornerRadius = i2;
            this.cornerRadiusSet = true;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(i2));
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, colorStateList) == null) || this.rippleColor == colorStateList) {
            return;
        }
        this.rippleColor = colorStateList;
        if (IS_LOLLIPOP && (this.materialButton.getBackground() instanceof RippleDrawable)) {
            ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (IS_LOLLIPOP || !(this.materialButton.getBackground() instanceof RippleDrawableCompat)) {
        } else {
            ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, shapeAppearanceModel) == null) {
            this.shapeAppearanceModel = shapeAppearanceModel;
            updateButtonShape(shapeAppearanceModel);
        }
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.shouldDrawSurfaceColorStroke = z;
            updateStroke();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, colorStateList) == null) || this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    public void setStrokeWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || this.strokeWidth == i2) {
            return;
        }
        this.strokeWidth = i2;
        updateStroke();
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, colorStateList) == null) || this.backgroundTint == colorStateList) {
            return;
        }
        this.backgroundTint = colorStateList;
        if (getMaterialShapeDrawable() != null) {
            DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
        }
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, mode) == null) || this.backgroundTintMode == mode) {
            return;
        }
        this.backgroundTintMode = mode;
        if (getMaterialShapeDrawable() == null || this.backgroundTintMode == null) {
            return;
        }
        DrawableCompat.setTintMode(getMaterialShapeDrawable(), this.backgroundTintMode);
    }

    public void updateMaskBounds(int i2, int i3) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) || (drawable = this.maskDrawable) == null) {
            return;
        }
        drawable.setBounds(this.insetLeft, this.insetTop, i3 - this.insetRight, i2 - this.insetBottom);
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getMaterialShapeDrawable(false) : (MaterialShapeDrawable) invokeV.objValue;
    }
}
