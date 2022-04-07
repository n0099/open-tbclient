package com.kwad.yoga;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;
import com.kwad.proguard.annotations.DoNotStrip;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@DoNotStrip
/* loaded from: classes5.dex */
public final class YogaPrintOptions {
    public static final /* synthetic */ YogaPrintOptions[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaPrintOptions CHILDREN;
    public static final YogaPrintOptions LAYOUT;
    public static final YogaPrintOptions STYLE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1733112127, "Lcom/kwad/yoga/YogaPrintOptions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1733112127, "Lcom/kwad/yoga/YogaPrintOptions;");
                return;
            }
        }
        LAYOUT = new YogaPrintOptions("LAYOUT", 0, 1);
        STYLE = new YogaPrintOptions(WebvttDecoder.STYLE_START, 1, 2);
        YogaPrintOptions yogaPrintOptions = new YogaPrintOptions("CHILDREN", 2, 4);
        CHILDREN = yogaPrintOptions;
        $VALUES = new YogaPrintOptions[]{LAYOUT, STYLE, yogaPrintOptions};
    }

    public YogaPrintOptions(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIntValue = i2;
    }

    public static YogaPrintOptions fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 4) {
                        return CHILDREN;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i);
                }
                return STYLE;
            }
            return LAYOUT;
        }
        return (YogaPrintOptions) invokeI.objValue;
    }

    public static YogaPrintOptions valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaPrintOptions) Enum.valueOf(YogaPrintOptions.class, str) : (YogaPrintOptions) invokeL.objValue;
    }

    public static YogaPrintOptions[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaPrintOptions[]) $VALUES.clone() : (YogaPrintOptions[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
