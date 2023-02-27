package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public static h0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1528400796, "Lcom/huawei/hms/hatool/h0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1528400796, "Lcom/huawei/hms/hatool/h0;");
                return;
            }
        }
        new HashMap();
    }

    public h0() {
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

    public static h0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b() : (h0) invokeV.objValue;
    }

    public static synchronized h0 b() {
        InterceptResult invokeV;
        h0 h0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (h0.class) {
                if (b == null) {
                    b = new h0();
                }
                h0Var = b;
            }
            return h0Var;
        }
        return (h0) invokeV.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            b(context);
            i.c().b().h(f.a());
        }
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            if (this.a == null) {
                y.e("hmsSdk", "onReport() null context or SDK was not init.");
                return;
            }
            y.c("hmsSdk", "onReport: Before calling runtaskhandler()");
            a(str, u0.a(i), b.g());
        }
    }

    public void a(String str, int i, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (2 == i) {
                currentTimeMillis = u0.a("yyyy-MM-dd", currentTimeMillis);
            }
            o0.c().a(new j0(str2, jSONObject, str, u0.a(i), currentTimeMillis));
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            if (!c.a(str, str2)) {
                y.c("hmsSdk", "auto report is closed tag:" + str);
                return;
            }
            long j = c.j(str, str2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j <= 30000) {
                y.f("hmsSdk", "autoReport timeout. interval < 30s ");
                return;
            }
            y.a("hmsSdk", "begin to call onReport!");
            c.a(str, str2, currentTimeMillis);
            a(str, str2, b.g());
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            Context context = this.a;
            if (context == null) {
                y.e("hmsSdk", "onReport() null context or SDK was not init.");
                return;
            }
            String a = h.a(context);
            if (c.e(str, str2) && !"WIFI".equals(a)) {
                y.c("hmsSdk", "strNetworkType is :" + a);
            } else if (TextUtils.isEmpty(a) || "2G".equals(a)) {
                y.e("hmsSdk", "The network is bad.");
            } else {
                o0.c().a(new k0(str, str2, str3));
            }
        }
    }

    public final void b(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            String d = f.d(context);
            b.a(d);
            if (w0.b().a()) {
                String a = g0.a(context, "global_v2", "app_ver", "");
                g0.b(context, "global_v2", "app_ver", d);
                b.b(a);
                if (!TextUtils.isEmpty(a)) {
                    if (a.equals(d)) {
                        return;
                    }
                    y.c("hmsSdk", "the appVers are different!");
                    a().a("", "alltype", a);
                    return;
                }
                str = "app ver is first save!";
            } else {
                str = "userManager.isUserUnlocked() == false";
            }
            y.c("hmsSdk", str);
        }
    }
}
