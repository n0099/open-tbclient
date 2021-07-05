package com.bytedance.sdk.openadsdk.r;

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
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f32217a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f32218b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98139332, "Lcom/bytedance/sdk/openadsdk/r/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98139332, "Lcom/bytedance/sdk/openadsdk/r/i;");
                return;
            }
        }
        String str = "";
        try {
            if (TextUtils.isEmpty(f32217a)) {
                f32217a = com.bytedance.sdk.openadsdk.core.c.a(com.bytedance.sdk.openadsdk.core.o.a()).b("oaid", "");
                if (f32217a != null) {
                    str = f32217a;
                }
                com.bytedance.sdk.openadsdk.p.a.a(7, str);
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || TextUtils.isEmpty(f32217a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.h.a("sdk_app_log_oaid", f32217a);
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            try {
                AppLog.setOaidObserver(new IOaidObserver() { // from class: com.bytedance.sdk.openadsdk.r.i.1
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
                                boolean unused = i.f32218b = true;
                                String unused2 = i.f32217a = oaid.id;
                                com.bytedance.sdk.openadsdk.p.a.a(7, i.f32217a == null ? "" : i.f32217a);
                                i.d();
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
            if (TextUtils.isEmpty(f32217a)) {
                f32217a = com.bytedance.sdk.openadsdk.core.h.a("sdk_app_log_oaid", 86400000L);
                com.bytedance.sdk.openadsdk.p.a.a(7, f32217a == null ? "" : f32217a);
            }
            if (TextUtils.isEmpty(f32217a) && !f32218b) {
                TTCustomController f2 = com.bytedance.sdk.openadsdk.core.h.d().f();
                if (f2 != null && !TextUtils.isEmpty(f2.getDevOaid())) {
                    f32217a = f2.getDevOaid();
                    d();
                }
                com.bytedance.sdk.openadsdk.p.a.a(7, f32217a == null ? "" : f32217a);
            }
            return f32217a == null ? "" : f32217a;
        }
        return (String) invokeV.objValue;
    }
}
