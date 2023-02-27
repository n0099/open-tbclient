package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.vivo.push.e.b;
import com.vivo.push.o;
import com.vivo.push.util.aa;
import com.vivo.push.util.ab;
import com.vivo.push.util.u;
import java.util.List;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Intent intent) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, intent) == null) {
            if (context != null) {
                try {
                    context.startService(intent);
                    return;
                } catch (Exception e) {
                    u.a("CommandBridge", "start service error", e);
                    intent.setComponent(null);
                    context.sendBroadcast(intent);
                    return;
                }
            }
            u.d("CommandBridge", "enter startService context is null");
            throw new Exception("context is null");
        }
    }

    public static void a(Context context, o oVar, String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, oVar, str) == null) {
            try {
                boolean d = aa.d(context, str);
                if (d) {
                    str2 = "com.vivo.pushservice.action.RECEIVE";
                } else {
                    str2 = "com.vivo.pushclient.action.RECEIVE";
                }
                if (!TextUtils.isEmpty(str)) {
                    if (d || a(context, str2, str)) {
                        if (TextUtils.isEmpty(oVar.a())) {
                            oVar.a(context.getPackageName());
                        }
                        Intent intent = new Intent();
                        intent.setFlags(1048576);
                        if (!TextUtils.isEmpty(str2)) {
                            intent.setAction(str2);
                        }
                        intent.setPackage(str);
                        if (d) {
                            str3 = "com.vivo.push.sdk.service.CommandService";
                        } else {
                            str3 = "com.vivo.push.sdk.service.CommandClientService";
                        }
                        intent.setClassName(str, str3);
                        intent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(context).a("com.vivo.pushservice"));
                        oVar.b(intent);
                        intent.putExtra("command_type", "reflect_receiver");
                        if (Build.VERSION.SDK_INT >= 18) {
                            intent.putExtra("security_avoid_pull_rsa", b.a().a(context).a("com.vivo.pushservice"));
                            intent.putExtra("security_avoid_rsa_public_key", ab.a(b.a().a(context).a()));
                        }
                        a(context, intent);
                        return;
                    }
                    return;
                }
                u.c(context, "消息接受者包名为空！");
                throw new Exception("消息接受者包名为空！");
            } catch (Exception e) {
                u.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
            }
        }
    }

    public static void a(Context context, String str, o oVar) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, str, oVar) == null) {
            boolean c = oVar.c();
            if (c) {
                str2 = "com.vivo.vms.upstageservice";
            } else {
                str2 = "com.vivo.vms.aidlservice";
            }
            com.vivo.push.b a = com.vivo.push.b.a(context, str2);
            boolean a2 = a.a();
            if (TextUtils.isEmpty(oVar.a())) {
                oVar.a(context.getPackageName());
            }
            if (a2 && !"com.vivo.pushservice".equals(context.getPackageName())) {
                com.vivo.push.a aVar = new com.vivo.push.a(oVar.a(), str, new Bundle());
                oVar.a(aVar);
                if (a.a(aVar.b())) {
                    return;
                }
                u.b("CommandBridge", "send command error by aidl");
                u.c(context, "send command error by aidl");
            }
            Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
            intent.setPackage(str);
            if (c) {
                str3 = "com.vivo.push.sdk.service.UpstageService";
            } else {
                str3 = "com.vivo.push.sdk.service.PushService";
            }
            intent.setClassName(str, str3);
            oVar.a(intent);
            try {
                a(context, intent);
            } catch (Exception e) {
                u.a("CommandBridge", "CommandBridge startService exception: ", e);
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    return true;
                }
                u.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
                return false;
            } catch (Exception unused) {
                u.b("CommandBridge", "queryBroadcastReceivers error");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
