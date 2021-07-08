package com.xiaomi.mipush.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hk;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<e, a> f39811a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f39812a;

        /* renamed from: b  reason: collision with root package name */
        public String f39813b;

        public a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39812a = str;
            this.f39813b = str2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78186115, "Lcom/xiaomi/mipush/sdk/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78186115, "Lcom/xiaomi/mipush/sdk/l;");
                return;
            }
        }
        f39811a = new HashMap<>();
        a(e.f39801a, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(e.f39802b, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(e.f39803c, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(e.f39804d, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static at a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eVar)) == null) {
            int i2 = m.f39814a[eVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return at.f39790f;
                    }
                    return at.f39789e;
                }
                return at.f39788d;
            }
            return at.f39787c;
        }
        return (at) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m134a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) ? f39811a.get(eVar) : (a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hk m135a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eVar)) == null) ? hk.ao : (hk) invokeL.objValue;
    }

    public static void a(e eVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar, aVar) == null) || aVar == null) {
            return;
        }
        f39811a.put(eVar, aVar);
    }
}
