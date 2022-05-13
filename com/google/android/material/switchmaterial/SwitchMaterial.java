package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
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
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes4.dex */
public class SwitchMaterial extends SwitchCompat {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: DEF_STYLE_RES */
    public static final int obfuscated_res_0x7f10035c = 2131755868;
    public static final int[][] ENABLED_CHECKED_STATES;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ElevationOverlayProvider elevationOverlayProvider;
    @Nullable
    public ColorStateList materialThemeColorsThumbTintList;
    @Nullable
    public ColorStateList materialThemeColorsTrackTintList;
    public boolean useMaterialThemeColors;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(845285720, "Lcom/google/android/material/switchmaterial/SwitchMaterial;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(845285720, "Lcom/google/android/material/switchmaterial/SwitchMaterial;");
                return;
            }
        }
        ENABLED_CHECKED_STATES = new int[][]{new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchMaterial(@NonNull Context context) {
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

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.materialThemeColorsThumbTintList == null) {
                int color = MaterialColors.getColor(this, R.attr.obfuscated_res_0x7f040171);
                int color2 = MaterialColors.getColor(this, R.attr.colorControlActivated);
                float dimension = getResources().getDimension(R.dimen.obfuscated_res_0x7f070472);
                if (this.elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
                    dimension += ViewUtils.getParentAbsoluteElevation(this);
                }
                int compositeOverlayIfNeeded = this.elevationOverlayProvider.compositeOverlayIfNeeded(color, dimension);
                int[] iArr = new int[ENABLED_CHECKED_STATES.length];
                iArr[0] = MaterialColors.layer(color, color2, 1.0f);
                iArr[1] = compositeOverlayIfNeeded;
                iArr[2] = MaterialColors.layer(color, color2, 0.38f);
                iArr[3] = compositeOverlayIfNeeded;
                this.materialThemeColorsThumbTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
            }
            return this.materialThemeColorsThumbTintList;
        }
        return (ColorStateList) invokeV.objValue;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.materialThemeColorsTrackTintList == null) {
                int[] iArr = new int[ENABLED_CHECKED_STATES.length];
                int color = MaterialColors.getColor(this, R.attr.obfuscated_res_0x7f040171);
                int color2 = MaterialColors.getColor(this, R.attr.colorControlActivated);
                int color3 = MaterialColors.getColor(this, R.attr.obfuscated_res_0x7f04016a);
                iArr[0] = MaterialColors.layer(color, color2, 0.54f);
                iArr[1] = MaterialColors.layer(color, color3, 0.32f);
                iArr[2] = MaterialColors.layer(color, color2, 0.12f);
                iArr[3] = MaterialColors.layer(color, color3, 0.12f);
                this.materialThemeColorsTrackTintList = new ColorStateList(ENABLED_CHECKED_STATES, iArr);
            }
            return this.materialThemeColorsTrackTintList;
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
            if (this.useMaterialThemeColors && getThumbTintList() == null) {
                setThumbTintList(getMaterialThemeColorsThumbTintList());
            }
            if (this.useMaterialThemeColors && getTrackTintList() == null) {
                setTrackTintList(getMaterialThemeColorsTrackTintList());
            }
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.useMaterialThemeColors = z;
            if (z) {
                setThumbTintList(getMaterialThemeColorsThumbTintList());
                setTrackTintList(getMaterialThemeColorsTrackTintList());
                return;
            }
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f0405ef);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, obfuscated_res_0x7f10035c), attributeSet, i);
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
        Context context2 = getContext();
        this.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, new int[]{R.attr.obfuscated_res_0x7f0406b7}, i, obfuscated_res_0x7f10035c, new int[0]);
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }
}
