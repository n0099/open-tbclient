package com.cmic.sso.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.a.a;
import com.cmic.sso.sdk.e.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, Object> a;

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>(i);
    }

    public com.cmic.sso.sdk.d.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.cmic.sso.sdk.d.a aVar = (com.cmic.sso.sdk.d.a) this.a.get("logBean");
            if (aVar != null) {
                return aVar;
            }
            return new com.cmic.sso.sdk.d.a();
        }
        return (com.cmic.sso.sdk.d.a) invokeV.objValue;
    }

    public com.cmic.sso.sdk.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.cmic.sso.sdk.a.a aVar = (com.cmic.sso.sdk.a.a) this.a.get("current_config");
            if (aVar != null) {
                return aVar;
            }
            c.a("UmcConfigBean为空", "请核查");
            return new a.C0564a().a();
        }
        return (com.cmic.sso.sdk.a.a) invokeV.objValue;
    }

    public void a(com.cmic.sso.sdk.a.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && aVar != null) {
            this.a.put("current_config", aVar);
        }
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return b(str, "");
        }
        return (String) invokeL.objValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return b(str, 0);
        }
        return invokeL.intValue;
    }

    public void a(com.cmic.sso.sdk.d.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) && aVar != null) {
            this.a.put("logBean", aVar);
        }
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) && str != null) {
            this.a.put(str, Integer.valueOf(i));
        }
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            if (str != null && this.a.containsKey(str)) {
                return ((Integer) this.a.get(str)).intValue();
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public void a(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) && str != null) {
            this.a.put(str, Long.valueOf(j));
        }
    }

    public long b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            if (str != null && this.a.containsKey(str)) {
                return ((Long) this.a.get(str)).longValue();
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (str != null && this.a.containsKey(str)) {
                return (String) this.a.get(str);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) && str != null) {
            this.a.put(str, Boolean.valueOf(z));
        }
    }

    public boolean b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            if (str != null && this.a.containsKey(str)) {
                return ((Boolean) this.a.get(str)).booleanValue();
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    public void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, str, bArr) == null) && str != null && bArr != null) {
            this.a.put(str, bArr);
        }
    }

    public byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null) {
                return (byte[]) this.a.get(str);
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
