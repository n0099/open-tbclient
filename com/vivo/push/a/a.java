package com.vivo.push.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.cache.b;
import com.vivo.push.cache.e;
import com.vivo.push.sdk.LinkProxyClientActivity;
import com.vivo.push.sdk.service.LinkProxyActivity;
import com.vivo.push.util.h;
import com.vivo.push.util.m;
import com.vivo.push.util.p;
import com.vivo.push.util.w;
import com.vivo.push.v;
import java.util.List;
/* loaded from: classes3.dex */
public final class a {
    public static void a(Context context, String str, v vVar) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setClassName(str, vVar.c() ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        if (TextUtils.isEmpty(vVar.a())) {
            vVar.a(context.getPackageName());
        }
        vVar.a(intent);
        try {
            a(context, intent, false);
        } catch (Exception e) {
            m.a("CommandBridge", "CommandBridge startService exception: ", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(Context context, Intent intent, boolean z) throws Exception {
        boolean z2;
        ComponentName componentName;
        String str;
        if (context == null) {
            m.d("CommandBridge", "enter startLinkProxyActivityOrService context is null");
            throw new Exception("context is null");
        }
        String str2 = intent.getPackage();
        if (context.getPackageName().equals(str2)) {
            z2 = true;
        } else {
            e a = b.a().a(context);
            if (a != null) {
                str = a.getSuitTag();
                m.d("CommandBridge", "get app suit Tag success");
            } else {
                m.d("CommandBridge", "get app suit Tag is null");
                str = null;
            }
            if (!"1".equals(str)) {
                if ("0".equals(str)) {
                    z2 = true;
                } else if ((h.b() && w.b(context, str2)) || h.c()) {
                    z2 = true;
                }
                if (!z2) {
                    long a2 = w.a(context, str2);
                    if (a2 >= 100 && a2 < 200) {
                        a2 -= 100;
                    } else if ((a2 / 1000) % 2 == 1) {
                        a2 -= 1000;
                    }
                    if (!(a2 >= 50)) {
                        z2 = true;
                    }
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        if (z2) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e) {
                m.a("CommandBridge", "start service error", e);
                return;
            }
        }
        try {
            Intent intent2 = new Intent();
            if (z) {
                componentName = new ComponentName(str2, LinkProxyClientActivity.class.getName());
            } else {
                componentName = new ComponentName(str2, LinkProxyActivity.class.getName());
            }
            intent2.setComponent(componentName);
            intent2.addFlags(402653184);
            intent2.putExtra("previous_intent", intent);
            context.startActivity(intent2);
        } catch (Exception e2) {
            m.d("CommandBridge", "start activity error");
            try {
                context.startService(intent);
            } catch (Exception e3) {
                m.a("CommandBridge", "start service error", e3);
            }
        }
    }

    public static void a(Context context, v vVar, String str) {
        try {
            boolean b = p.b(context, str);
            String str2 = b ? "com.vivo.pushclient.action.RECEIVE" : "com.vivo.pushservice.action.RECEIVE";
            if (TextUtils.isEmpty(str)) {
                m.c(context, "消息接受者包名为空！");
                throw new Exception("消息接受者包名为空！");
            } else if (!a(context, str2, str)) {
                throw new Exception("校验action异常");
            } else {
                Intent intent = new Intent();
                intent.setFlags(1048576);
                if (!TextUtils.isEmpty(str2)) {
                    intent.setAction(str2);
                }
                intent.setPackage(str);
                if (TextUtils.isEmpty(vVar.a())) {
                    vVar.a(context.getPackageName());
                }
                vVar.b(intent);
                intent.putExtra("command_type", "reflect_receiver");
                intent.setClassName(str, b ? "com.vivo.push.sdk.service.CommandClientService" : "com.vivo.push.sdk.service.CommandService");
                a(context, intent, b);
            }
        } catch (Exception e) {
            m.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                m.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
                return false;
            }
            return true;
        } catch (Exception e) {
            m.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
