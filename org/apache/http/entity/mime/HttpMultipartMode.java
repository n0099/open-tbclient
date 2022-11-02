package org.apache.http.entity.mime;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class HttpMultipartMode {
    public static final /* synthetic */ HttpMultipartMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HttpMultipartMode BROWSER_COMPATIBLE;
    public static final HttpMultipartMode STRICT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1792185984, "Lorg/apache/http/entity/mime/HttpMultipartMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1792185984, "Lorg/apache/http/entity/mime/HttpMultipartMode;");
                return;
            }
        }
        STRICT = new HttpMultipartMode("STRICT", 0);
        HttpMultipartMode httpMultipartMode = new HttpMultipartMode("BROWSER_COMPATIBLE", 1);
        BROWSER_COMPATIBLE = httpMultipartMode;
        $VALUES = new HttpMultipartMode[]{STRICT, httpMultipartMode};
    }

    public HttpMultipartMode(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HttpMultipartMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (HttpMultipartMode) Enum.valueOf(HttpMultipartMode.class, str);
        }
        return (HttpMultipartMode) invokeL.objValue;
    }

    public static final HttpMultipartMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (HttpMultipartMode[]) $VALUES.clone();
        }
        return (HttpMultipartMode[]) invokeV.objValue;
    }
}
