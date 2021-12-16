package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class eh implements ed {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(Service service, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, this, service, intent) == null) && "com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                dw.a(service.getApplicationContext(), "service", 1007, "old version message");
            } else if (TextUtils.isEmpty(stringExtra2)) {
                dw.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
            } else {
                String b2 = dv.b(stringExtra2);
                boolean isEmpty = TextUtils.isEmpty(b2);
                Context applicationContext = service.getApplicationContext();
                if (isEmpty) {
                    dw.a(applicationContext, "service", 1008, "B get a incorrect message");
                } else {
                    dw.a(applicationContext, b2, 1007, "old version message ");
                }
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, this, context, str, str2, str3) == null) {
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str3)) {
                    dw.a(context, "service", 1008, "argument error");
                } else {
                    dw.a(context, str3, 1008, "argument error");
                }
            } else if (!com.xiaomi.push.service.g.a(context, str)) {
                dw.a(context, str3, 1003, "B is not ready");
            } else {
                dw.a(context, str3, 1002, "B is ready");
                dw.a(context, str3, 1004, "A is ready");
                try {
                    Intent intent = new Intent();
                    intent.setClassName(str, str2);
                    intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                    intent.putExtra("waker_pkgname", context.getPackageName());
                    intent.putExtra("awake_info", dv.a(str3));
                    if (context.startService(intent) == null) {
                        dw.a(context, str3, 1008, "A is fail to help B's service");
                        return;
                    }
                    dw.a(context, str3, 1005, "A is successful");
                    dw.a(context, str3, 1006, "The job is finished");
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    dw.a(context, str3, 1008, "A meet a exception when help B's service");
                }
            }
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, context, intent, str) == null) && context != null && (context instanceof Service)) {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, dz dzVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dzVar) == null) || dzVar == null) {
            return;
        }
        a(context, dzVar.m331a(), dzVar.c(), dzVar.d());
    }
}
