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
/* loaded from: classes8.dex */
public class eg implements ed {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eg() {
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
        if (interceptable == null || interceptable.invokeLL(65537, this, service, intent) == null) {
            String stringExtra = intent.getStringExtra("awake_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                String b2 = dv.b(stringExtra);
                if (!TextUtils.isEmpty(b2)) {
                    dw.a(service.getApplicationContext(), b2, 1007, "play with service successfully");
                    return;
                }
            }
            dw.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
        }
    }

    private void b(Context context, dz dzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, dzVar) == null) {
            String m279a = dzVar.m279a();
            String b2 = dzVar.b();
            String d2 = dzVar.d();
            int a2 = dzVar.a();
            if (context == null || TextUtils.isEmpty(m279a) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d2)) {
                if (TextUtils.isEmpty(d2)) {
                    dw.a(context, "service", 1008, "argument error");
                } else {
                    dw.a(context, d2, 1008, "argument error");
                }
            } else if (!com.xiaomi.push.service.g.a(context, m279a, b2)) {
                dw.a(context, d2, 1003, "B is not ready");
            } else {
                dw.a(context, d2, 1002, "B is ready");
                dw.a(context, d2, 1004, "A is ready");
                try {
                    Intent intent = new Intent();
                    intent.setAction(b2);
                    intent.setPackage(m279a);
                    intent.putExtra("awake_info", dv.a(d2));
                    if (a2 == 1 && !ea.m282a(context)) {
                        dw.a(context, d2, 1008, "A not in foreground");
                    } else if (context.startService(intent) == null) {
                        dw.a(context, d2, 1008, "A is fail to help B's service");
                    } else {
                        dw.a(context, d2, 1005, "A is successful");
                        dw.a(context, d2, 1006, "The job is finished");
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    dw.a(context, d2, 1008, "A meet a exception when help B's service");
                }
            }
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, intent, str) == null) {
            if (context == null || !(context instanceof Service)) {
                dw.a(context, "service", 1008, "A receive incorrect message");
            } else {
                a((Service) context, intent);
            }
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, dz dzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dzVar) == null) {
            if (dzVar != null) {
                b(context, dzVar);
            } else {
                dw.a(context, "service", 1008, "A receive incorrect message");
            }
        }
    }
}
