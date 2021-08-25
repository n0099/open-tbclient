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
/* loaded from: classes10.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<e, a> f77135a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f77136a;

        /* renamed from: b  reason: collision with root package name */
        public String f77137b;

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
            this.f77136a = str;
            this.f77137b = str2;
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
        f77135a = new HashMap<>();
        a(e.f77125a, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(e.f77126b, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(e.f77127c, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(e.f77128d, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static at a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eVar)) == null) {
            int i2 = m.f77138a[eVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return at.f77114f;
                    }
                    return at.f77113e;
                }
                return at.f77112d;
            }
            return at.f77111c;
        }
        return (at) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m137a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) ? f77135a.get(eVar) : (a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hk m138a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eVar)) == null) ? hk.ao : (hk) invokeL.objValue;
    }

    public static void a(e eVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar, aVar) == null) || aVar == null) {
            return;
        }
        f77135a.put(eVar, aVar);
    }
}
