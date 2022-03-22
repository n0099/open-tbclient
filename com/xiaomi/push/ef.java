package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ef implements ed {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ef() {
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

    private void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, str) == null) {
            try {
                if (!TextUtils.isEmpty(str) && context != null) {
                    String[] split = str.split("/");
                    if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                        String str2 = split[split.length - 1];
                        if (TextUtils.isEmpty(str2)) {
                            dw.a(context, "provider", 1008, "B get a incorrect message");
                            return;
                        }
                        String decode = Uri.decode(str2);
                        if (TextUtils.isEmpty(decode)) {
                            dw.a(context, "provider", 1008, "B get a incorrect message");
                            return;
                        }
                        String b2 = dv.b(decode);
                        if (!TextUtils.isEmpty(b2)) {
                            dw.a(context, b2, 1007, "play with provider successfully");
                            return;
                        }
                    }
                }
                dw.a(context, "provider", 1008, "B get a incorrect message");
            } catch (Exception e2) {
                dw.a(context, "provider", 1008, "B meet a exception" + e2.getMessage());
            }
        }
    }

    private void b(Context context, dz dzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, dzVar) == null) {
            String b2 = dzVar.b();
            String d2 = dzVar.d();
            int a = dzVar.a();
            if (context == null || TextUtils.isEmpty(b2) || TextUtils.isEmpty(d2)) {
                if (TextUtils.isEmpty(d2)) {
                    dw.a(context, "provider", 1008, "argument error");
                } else {
                    dw.a(context, d2, 1008, "argument error");
                }
            } else if (!com.xiaomi.push.service.g.b(context, b2)) {
                dw.a(context, d2, 1003, "B is not ready");
            } else {
                dw.a(context, d2, 1002, "B is ready");
                dw.a(context, d2, 1004, "A is ready");
                String a2 = dv.a(d2);
                try {
                    if (TextUtils.isEmpty(a2)) {
                        dw.a(context, d2, 1008, "info is empty");
                    } else if (a == 1 && !ea.m324a(context)) {
                        dw.a(context, d2, 1008, "A not in foreground");
                    } else {
                        String type = context.getContentResolver().getType(dv.a(b2, a2));
                        if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                            dw.a(context, d2, 1008, "A is fail to help B's provider");
                            return;
                        }
                        dw.a(context, d2, 1005, "A is successful");
                        dw.a(context, d2, 1006, "The job is finished");
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    dw.a(context, d2, 1008, "A meet a exception when help B's provider");
                }
            }
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, intent, str) == null) {
            a(context, str);
        }
    }

    @Override // com.xiaomi.push.ed
    public void a(Context context, dz dzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dzVar) == null) {
            if (dzVar != null) {
                b(context, dzVar);
            } else {
                dw.a(context, "provider", 1008, "A receive incorrect message");
            }
        }
    }
}
