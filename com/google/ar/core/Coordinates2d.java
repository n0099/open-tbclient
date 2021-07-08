package com.google.ar.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class Coordinates2d {
    public static final /* synthetic */ Coordinates2d[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Coordinates2d IMAGE_NORMALIZED;
    public static final Coordinates2d IMAGE_PIXELS;
    public static final Coordinates2d OPENGL_NORMALIZED_DEVICE_COORDINATES;
    public static final Coordinates2d TEXTURE_NORMALIZED;
    public static final Coordinates2d TEXTURE_TEXELS;
    public static final Coordinates2d VIEW;
    public static final Coordinates2d VIEW_NORMALIZED;
    public transient /* synthetic */ FieldHolder $fh;
    public final int nativeCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2124598372, "Lcom/google/ar/core/Coordinates2d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2124598372, "Lcom/google/ar/core/Coordinates2d;");
                return;
            }
        }
        TEXTURE_TEXELS = new Coordinates2d("TEXTURE_TEXELS", 0, 0);
        TEXTURE_NORMALIZED = new Coordinates2d("TEXTURE_NORMALIZED", 1, 1);
        IMAGE_PIXELS = new Coordinates2d("IMAGE_PIXELS", 2, 2);
        IMAGE_NORMALIZED = new Coordinates2d("IMAGE_NORMALIZED", 3, 3);
        OPENGL_NORMALIZED_DEVICE_COORDINATES = new Coordinates2d("OPENGL_NORMALIZED_DEVICE_COORDINATES", 4, 6);
        VIEW = new Coordinates2d("VIEW", 5, 7);
        Coordinates2d coordinates2d = new Coordinates2d("VIEW_NORMALIZED", 6, 8);
        VIEW_NORMALIZED = coordinates2d;
        $VALUES = new Coordinates2d[]{TEXTURE_TEXELS, TEXTURE_NORMALIZED, IMAGE_PIXELS, IMAGE_NORMALIZED, OPENGL_NORMALIZED_DEVICE_COORDINATES, VIEW, coordinates2d};
    }

    public Coordinates2d(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.nativeCode = i3;
    }

    public static Coordinates2d forNumber(int i2) {
        InterceptResult invokeI;
        Coordinates2d[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (Coordinates2d coordinates2d : values()) {
                if (coordinates2d.nativeCode == i2) {
                    return coordinates2d;
                }
            }
            StringBuilder sb = new StringBuilder(60);
            sb.append("Unexpected value for native Coordinates2d, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
        return (Coordinates2d) invokeI.objValue;
    }

    public static Coordinates2d valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Coordinates2d) Enum.valueOf(Coordinates2d.class, str) : (Coordinates2d) invokeL.objValue;
    }

    public static Coordinates2d[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Coordinates2d[]) $VALUES.clone() : (Coordinates2d[]) invokeV.objValue;
    }
}
