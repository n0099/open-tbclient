package com.qq.e.ads;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class ContentAdType {
    public static /* synthetic */ Interceptable $ic;
    public static final ContentAdType AD;
    public static final ContentAdType INFORMATION;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ ContentAdType[] f67812a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-29537629, "Lcom/qq/e/ads/ContentAdType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-29537629, "Lcom/qq/e/ads/ContentAdType;");
                return;
            }
        }
        AD = new ContentAdType("AD", 0);
        ContentAdType contentAdType = new ContentAdType("INFORMATION", 1);
        INFORMATION = contentAdType;
        f67812a = new ContentAdType[]{AD, contentAdType};
    }

    public ContentAdType(String str, int i2) {
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

    public static ContentAdType fromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if ("ad".equals(str)) {
                return AD;
            }
            if ("information".equals(str)) {
                return INFORMATION;
            }
            return null;
        }
        return (ContentAdType) invokeL.objValue;
    }

    public static ContentAdType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ContentAdType) Enum.valueOf(ContentAdType.class, str) : (ContentAdType) invokeL.objValue;
    }

    public static ContentAdType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ContentAdType[]) f67812a.clone() : (ContentAdType[]) invokeV.objValue;
    }
}
