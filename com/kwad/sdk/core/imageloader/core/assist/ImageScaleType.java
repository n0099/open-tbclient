package com.kwad.sdk.core.imageloader.core.assist;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ImageScaleType {
    public static final /* synthetic */ ImageScaleType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ImageScaleType EXACTLY;
    public static final ImageScaleType EXACTLY_STRETCHED;
    public static final ImageScaleType IN_SAMPLE_INT;
    public static final ImageScaleType IN_SAMPLE_POWER_OF_2;
    public static final ImageScaleType NONE;
    public static final ImageScaleType NONE_SAFE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1643169786, "Lcom/kwad/sdk/core/imageloader/core/assist/ImageScaleType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1643169786, "Lcom/kwad/sdk/core/imageloader/core/assist/ImageScaleType;");
                return;
            }
        }
        NONE = new ImageScaleType("NONE", 0);
        NONE_SAFE = new ImageScaleType("NONE_SAFE", 1);
        IN_SAMPLE_POWER_OF_2 = new ImageScaleType("IN_SAMPLE_POWER_OF_2", 2);
        IN_SAMPLE_INT = new ImageScaleType("IN_SAMPLE_INT", 3);
        EXACTLY = new ImageScaleType("EXACTLY", 4);
        ImageScaleType imageScaleType = new ImageScaleType("EXACTLY_STRETCHED", 5);
        EXACTLY_STRETCHED = imageScaleType;
        $VALUES = new ImageScaleType[]{NONE, NONE_SAFE, IN_SAMPLE_POWER_OF_2, IN_SAMPLE_INT, EXACTLY, imageScaleType};
    }

    public ImageScaleType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ImageScaleType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImageScaleType) Enum.valueOf(ImageScaleType.class, str) : (ImageScaleType) invokeL.objValue;
    }

    public static ImageScaleType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImageScaleType[]) $VALUES.clone() : (ImageScaleType[]) invokeV.objValue;
    }
}
