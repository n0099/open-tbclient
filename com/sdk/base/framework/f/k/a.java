package com.sdk.base.framework.f.k;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.packet.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.f;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f59314b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1066011879, "Lcom/sdk/base/framework/f/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1066011879, "Lcom/sdk/base/framework/f/k/a;");
                return;
            }
        }
        new TreeMap();
        a = a.class.getSimpleName();
        f59314b = Boolean.valueOf(f.f59281b);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String a2 = com.sdk.base.framework.f.h.b.a(jSONObject.optString("aesKey"), com.sdk.base.framework.f.b.a.a(context, e.o));
                return com.sdk.base.framework.f.i.a.b(jSONObject.optString("data"), a2.substring(0, 16), a2.substring(16));
            } catch (Throwable th) {
                com.sdk.base.framework.f.f.a.a(th.toString());
                String str2 = a;
                c.b(str2, "SDK解密异常：" + th.toString(), f59314b);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Context context, int i2, String str, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i2), str, str2, Integer.valueOf(i3)}) == null) {
            if (i2 == 101005 || i2 == 302001 || i2 == 302002 || i2 == 302003) {
                try {
                    com.sdk.base.framework.f.f.a.b().a(i3);
                    com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(context, new b());
                    String a2 = com.sdk.base.framework.f.f.a.a(i2);
                    DataInfo dataInfo = new DataInfo();
                    dataInfo.putData("status", String.valueOf(i2));
                    dataInfo.putData("msg", str);
                    dataInfo.putData("obj", a2);
                    dataInfo.putData("seq", str2);
                    aVar.a(aVar.f59289c, "/st/api/v1.0/ses", dataInfo, aVar.a(), 0, j.f59248b);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return new JSONObject(str).optLong("exp") < System.currentTimeMillis();
            } catch (Exception e2) {
                String str2 = a;
                c.c(str2, "out data error" + e2, f59314b);
                return true;
            }
        }
        return invokeL.booleanValue;
    }
}
