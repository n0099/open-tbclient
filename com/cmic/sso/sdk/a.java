package com.cmic.sso.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f68648a;

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68648a = new ConcurrentHashMap<>(i2);
    }

    public void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, bArr) == null) || str == null || bArr == null) {
            return;
        }
        this.f68648a.put(str, bArr);
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? b(str, "") : (String) invokeL.objValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? b(str, 0) : invokeL.intValue;
    }

    public byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (str != null) {
                return (byte[]) this.f68648a.get(str);
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) ? (str == null || !this.f68648a.containsKey(str)) ? str2 : (String) this.f68648a.get(str) : (String) invokeLL.objValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || str == null || str2 == null) {
            return;
        }
        this.f68648a.put(str, str2);
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) || str == null) {
            return;
        }
        this.f68648a.put(str, Boolean.valueOf(z));
    }

    public boolean b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) ? (str == null || !this.f68648a.containsKey(str)) ? z : ((Boolean) this.f68648a.get(str)).booleanValue() : invokeLZ.booleanValue;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) || str == null) {
            return;
        }
        this.f68648a.put(str, Integer.valueOf(i2));
    }

    public void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, str, j2) == null) || str == null) {
            return;
        }
        this.f68648a.put(str, Long.valueOf(j2));
    }

    public int b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) ? (str == null || !this.f68648a.containsKey(str)) ? i2 : ((Integer) this.f68648a.get(str)).intValue() : invokeLI.intValue;
    }

    public void a(com.cmic.sso.sdk.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f68648a.put("logBean", aVar);
    }

    public com.cmic.sso.sdk.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.cmic.sso.sdk.c.a aVar = (com.cmic.sso.sdk.c.a) this.f68648a.get("logBean");
            return aVar != null ? aVar : new com.cmic.sso.sdk.c.a();
        }
        return (com.cmic.sso.sdk.c.a) invokeV.objValue;
    }

    public long b(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j2)) == null) ? (str == null || !this.f68648a.containsKey(str)) ? j2 : ((Long) this.f68648a.get(str)).longValue() : invokeLJ.longValue;
    }
}
