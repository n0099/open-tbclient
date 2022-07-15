package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class to0 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] g;
    public static final to0 h;
    public transient /* synthetic */ FieldHolder $fh;
    public BodyStyle a;
    public String b;
    public String c;
    public byte[] d;
    public File e;
    public Map<String, String> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755284164, "Lcom/repackage/to0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755284164, "Lcom/repackage/to0;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        g = bArr;
        h = d(null, bArr);
        b(null, "");
        c(null, new HashMap());
    }

    public to0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static to0 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            to0 to0Var = new to0();
            to0Var.k(BodyStyle.STRING);
            to0Var.i(str);
            to0Var.h(str2);
            return to0Var;
        }
        return (to0) invokeLL.objValue;
    }

    public static to0 c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            to0 to0Var = new to0();
            to0Var.k(BodyStyle.FORM);
            to0Var.i(str);
            to0Var.j(map);
            return to0Var;
        }
        return (to0) invokeLL.objValue;
    }

    public static to0 d(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr)) == null) {
            to0 to0Var = new to0();
            to0Var.k(BodyStyle.BYTE);
            to0Var.i(str);
            to0Var.g(bArr);
            return to0Var;
        }
        return (to0) invokeLL.objValue;
    }

    public static to0 e(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) ? c("application/x-www-form-urlencoded", map) : (to0) invokeL.objValue;
    }

    public static to0 f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? d("application/octet-stream", bArr) : (to0) invokeL.objValue;
    }

    public to0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f == null) {
                this.f = new HashMap();
            }
            this.f.put(str, str2);
            return this;
        }
        return (to0) invokeLL.objValue;
    }

    public to0 g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            this.d = bArr;
            return this;
        }
        return (to0) invokeL.objValue;
    }

    public to0 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (to0) invokeL.objValue;
    }

    public to0 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (to0) invokeL.objValue;
    }

    public to0 j(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f = map;
            return this;
        }
        return (to0) invokeL.objValue;
    }

    public to0 k(BodyStyle bodyStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bodyStyle)) == null) {
            this.a = bodyStyle;
            return this;
        }
        return (to0) invokeL.objValue;
    }
}
