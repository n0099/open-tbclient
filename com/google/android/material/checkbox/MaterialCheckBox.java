package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
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
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes7.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    public static /* synthetic */ Interceptable $ic;
    public static final int DEF_STYLE_RES;
    public static final int[][] ENABLED_CHECKED_STATES;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ColorStateList materialThemeColorsTintList;
    public boolean useMaterialThemeColors;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337090609, "Lcom/google/android/material/checkbox/MaterialCheckBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337090609, "Lcom/google/android/material/checkbox/MaterialCheckBox;");
                return;
            }
        }
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialCheckBox(Context context) {
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

    private ColorStateList getMaterialThemeColorsTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            if (this.materialThemeColorsTintList == null) {
                int[] iArr = new int[ENABLED_CHECKED_STATES.length];
                int color = MaterialColors.getColor(this, R.attr.colorControlActivated);
                int color2 = MaterialColors.getColor(this, R.attr.colorSurface);
                int color3 = MaterialColors.getColor(this, R.attr.colorOnSurface);
                iArr[0] = MaterialColors.layer(color2, color, 1.0f);
                iArr[1] = MaterialColors.layer(color2, color3, 0.54f);
                iArr[2] = MaterialColors.layer(color2, color3, 0.38f);
                iArr[3] = MaterialColors.layer(color2, color3, 0.38f);
                this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
            }
            return this.materialThemeColorsTintList;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public boolean isUseMaterialThemeColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.useMaterialThemeColors : invokeV.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            if (this.useMaterialThemeColors && CompoundButtonCompat.getButtonTintList(this) == null) {
                setUseMaterialThemeColors(true);
            }
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.useMaterialThemeColors = z;
            if (z) {
                CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
            } else {
                CompoundButtonCompat.setButtonTintList(this, null);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialCheckBox, i2, DEF_STYLE_RES, new int[0]);
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialCheckBox_buttonTint)) {
            CompoundButtonCompat.setButtonTintList(this, MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.MaterialCheckBox_buttonTint));
        }
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        obtainStyledAttributes.recycle();
    }
}
