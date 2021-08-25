package com.bytedance.sdk.openadsdk.q;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.sdk.openadsdk.TTCustomController;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f68675a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f68676b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98109603, "Lcom/bytedance/sdk/openadsdk/q/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98109603, "Lcom/bytedance/sdk/openadsdk/q/k;");
                return;
            }
        }
        String str = "";
        try {
            if (TextUtils.isEmpty(f68675a)) {
                f68675a = com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.o.a()).b("oaid", "");
                if (f68675a != null) {
                    str = f68675a;
                }
                com.bytedance.sdk.openadsdk.o.a.a(7, str);
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || TextUtils.isEmpty(f68675a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.h.a("sdk_app_log_oaid", f68675a);
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            try {
                AppLog.setOaidObserver(new IOaidObserver() { // from class: com.bytedance.sdk.openadsdk.q.k.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.embedapplog.IOaidObserver
                    public void onOaidLoaded(@NonNull IOaidObserver.Oaid oaid) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, oaid) == null) {
                            try {
                                if (TextUtils.isEmpty(oaid.id)) {
                                    return;
                                }
                                boolean unused = k.f68676b = true;
                                String unused2 = k.f68675a = oaid.id;
                                com.bytedance.sdk.openadsdk.o.a.a(7, k.f68675a == null ? "" : k.f68675a);
                                k.d();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f68675a)) {
                f68675a = com.bytedance.sdk.openadsdk.core.h.a("sdk_app_log_oaid", 86400000L);
                com.bytedance.sdk.openadsdk.o.a.a(7, f68675a == null ? "" : f68675a);
            }
            if (TextUtils.isEmpty(f68675a) && !f68676b) {
                TTCustomController f2 = com.bytedance.sdk.openadsdk.core.h.d().f();
                if (f2 != null && !TextUtils.isEmpty(f2.getDevOaid())) {
                    f68675a = f2.getDevOaid();
                    d();
                }
                com.bytedance.sdk.openadsdk.o.a.a(7, f68675a == null ? "" : f68675a);
            }
            return f68675a == null ? "" : f68675a;
        }
        return (String) invokeV.objValue;
    }
}
