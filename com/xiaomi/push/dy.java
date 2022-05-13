package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class dy implements ed {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dy() {
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

    private void a(Activity activity, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, activity, intent) == null) {
            String stringExtra = intent.getStringExtra("awake_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                String b = dv.b(stringExtra);
                if (!TextUtils.isEmpty(b)) {
                    dw.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
                    return;
                }
            }
            dw.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
        }
    }

    private void b(Context context, dz dzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, dzVar) == null) {
            String m318a = dzVar.m318a();
            String b = dzVar.b();
            String d = dzVar.d();
            int a = dzVar.a();
            if (context == null || TextUtils.isEmpty(m318a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
                if (TextUtils.isEmpty(d)) {
                    dw.a(context, "activity", 1008, "argument error");
                } else {
                    dw.a(context, d, 1008, "argument error");
                }
            } else if (!com.xiaomi.push.service.g.b(context, m318a, b)) {
                dw.a(context, d, 1003, "B is not ready");
            } else {
                dw.a(context, d, 1002, "B is ready");
                dw.a(context, d, 1004, "A is ready");
                Intent intent = new Intent(b);
                intent.setPackage(m318a);
                intent.putExtra("awake_info", dv.a(d));
                intent.addFlags(276824064);
                intent.setAction(b);
                if (a == 1) {
                    try {
                        if (!ea.m321a(context)) {
                            dw.a(context, d, 1008, "A not in foreground");
                            return;
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        dw.a(context, d, 1008, "A meet a exception when help B's activity");
                        return;
                    }
                }
                context.startActivity(intent);
                dw.a(context, d, 1005, "A is successful");
                dw.a(context, d, 1006, "The job is finished");
            }
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, intent, str) == null) {
            if (context == null || !(context instanceof Activity) || intent == null) {
                dw.a(context, "activity", 1008, "B receive incorrect message");
            } else {
                a((Activity) context, intent);
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
                dw.a(context, "activity", 1008, "A receive incorrect message");
            }
        }
    }
}
