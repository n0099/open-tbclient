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
/* loaded from: classes8.dex */
public class ei implements eg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ei() {
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
                            dz.a(context, "provider", 1008, "B get a incorrect message");
                            return;
                        }
                        String decode = Uri.decode(str2);
                        if (TextUtils.isEmpty(decode)) {
                            dz.a(context, "provider", 1008, "B get a incorrect message");
                            return;
                        }
                        String b = dy.b(decode);
                        if (!TextUtils.isEmpty(b)) {
                            dz.a(context, b, 1007, "play with provider successfully");
                            return;
                        }
                    }
                }
                dz.a(context, "provider", 1008, "B get a incorrect message");
            } catch (Exception e) {
                dz.a(context, "provider", 1008, "B meet a exception" + e.getMessage());
            }
        }
    }

    private void b(Context context, ec ecVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, ecVar) == null) {
            String b = ecVar.b();
            String d = ecVar.d();
            int a = ecVar.a();
            if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
                if (TextUtils.isEmpty(d)) {
                    dz.a(context, "provider", 1008, "argument error");
                } else {
                    dz.a(context, d, 1008, "argument error");
                }
            } else if (!com.xiaomi.push.service.l.b(context, b)) {
                dz.a(context, d, 1003, "B is not ready");
            } else {
                dz.a(context, d, 1002, "B is ready");
                dz.a(context, d, 1004, "A is ready");
                String a2 = dy.a(d);
                try {
                    if (TextUtils.isEmpty(a2)) {
                        dz.a(context, d, 1008, "info is empty");
                    } else if (a == 1 && !ed.m372a(context)) {
                        dz.a(context, d, 1008, "A not in foreground");
                    } else {
                        String type = context.getContentResolver().getType(dy.a(b, a2));
                        if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                            dz.a(context, d, 1008, "A is fail to help B's provider");
                            return;
                        }
                        dz.a(context, d, 1005, "A is successful");
                        dz.a(context, d, 1006, "The job is finished");
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    dz.a(context, d, 1008, "A meet a exception when help B's provider");
                }
            }
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, intent, str) == null) {
            a(context, str);
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, ec ecVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ecVar) == null) {
            if (ecVar != null) {
                b(context, ecVar);
            } else {
                dz.a(context, "provider", 1008, "A receive incorrect message");
            }
        }
    }
}
