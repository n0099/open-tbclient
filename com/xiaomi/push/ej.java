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
public class ej implements eg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ej() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                String b = dy.b(stringExtra);
                if (!TextUtils.isEmpty(b)) {
                    dz.a(service.getApplicationContext(), b, 1007, "play with service successfully");
                    return;
                }
            }
            dz.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
        }
    }

    private void b(Context context, ec ecVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, ecVar) == null) {
            String m371a = ecVar.m371a();
            String b = ecVar.b();
            String d = ecVar.d();
            int a = ecVar.a();
            if (context == null || TextUtils.isEmpty(m371a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
                if (TextUtils.isEmpty(d)) {
                    dz.a(context, "service", 1008, "argument error");
                } else {
                    dz.a(context, d, 1008, "argument error");
                }
            } else if (!com.xiaomi.push.service.l.a(context, m371a, b)) {
                dz.a(context, d, 1003, "B is not ready");
            } else {
                dz.a(context, d, 1002, "B is ready");
                dz.a(context, d, 1004, "A is ready");
                try {
                    Intent intent = new Intent();
                    intent.setAction(b);
                    intent.setPackage(m371a);
                    intent.putExtra("awake_info", dy.a(d));
                    if (a == 1 && !ed.m372a(context)) {
                        dz.a(context, d, 1008, "A not in foreground");
                    } else if (context.startService(intent) == null) {
                        dz.a(context, d, 1008, "A is fail to help B's service");
                    } else {
                        dz.a(context, d, 1005, "A is successful");
                        dz.a(context, d, 1006, "The job is finished");
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    dz.a(context, d, 1008, "A meet a exception when help B's service");
                }
            }
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, intent, str) == null) {
            if (context == null || !(context instanceof Service)) {
                dz.a(context, "service", 1008, "A receive incorrect message");
            } else {
                a((Service) context, intent);
            }
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, ec ecVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ecVar) == null) {
            if (ecVar != null) {
                b(context, ecVar);
            } else {
                dz.a(context, "service", 1008, "A receive incorrect message");
            }
        }
    }
}
