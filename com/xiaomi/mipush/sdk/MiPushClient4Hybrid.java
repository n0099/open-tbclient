package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.mipush.sdk.d;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class MiPushClient4Hybrid {
    private static Map<String, d.a> a = new HashMap();
    private static Map<String, Long> b = new HashMap();
    private static MiPushClientCallbackV2 c;
    private static HybridProvider d;

    private static short a(MiPushMessage miPushMessage, String str) {
        String str2 = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = !TextUtils.isEmpty(str2) ? Integer.valueOf(str2).intValue() : 0;
        if (d != null && !d.isAllowNotification(str)) {
            intValue = (intValue & (-4)) + a.EnumC0483a.NOT_ALLOWED.a();
        }
        return (short) intValue;
    }

    private static void a(Context context, MiPushMessage miPushMessage) {
        Intent intent;
        String str = miPushMessage.getExtra().get("web_uri");
        String str2 = miPushMessage.getExtra().get("intent_uri");
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    intent = Intent.parseUri(str2, 0);
                } catch (URISyntaxException e) {
                    com.xiaomi.channel.commonutils.logger.b.a("intent uri parse failed", e);
                }
            }
            intent = null;
        } else {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str));
            intent = intent2;
        }
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.a("web uri and intent uri all are empty");
            return;
        }
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("start activity failed from web uri or intent uri", th);
        }
    }

    private static void a(Context context, MiPushMessage miPushMessage, String str, short s) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.a("do not ack message, message is null");
            return;
        }
        try {
            com.xiaomi.xmpush.thrift.z zVar = new com.xiaomi.xmpush.thrift.z();
            zVar.b(d.a(context).c());
            zVar.a(miPushMessage.getMessageId());
            zVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            zVar.a(s);
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                zVar.c(miPushMessage.getTopic());
            }
            az.a(context).a((az) zVar, com.xiaomi.xmpush.thrift.a.AckMessage, false, PushMessageHelper.generateMessage(miPushMessage));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, app is :" + str + ", messageId is " + miPushMessage.getMessageId());
        } catch (Throwable th) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            } finally {
                miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
                miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            }
        }
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static boolean a(MiPushMessage miPushMessage) {
        return TextUtils.equals(miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION), Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    public static void ackMessage(Context context, MiPushMessage miPushMessage) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.a("do not ack message, message is null");
            return;
        }
        String str = miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_PKGNAME);
        a(context, miPushMessage, str, a(miPushMessage, str));
    }

    private static boolean b(Context context, String str) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong(new StringBuilder().append("last_pull_notification_").append(str).toString(), -1L)) > ReportUserInfoModel.TIME_INTERVAL;
    }

    public static boolean isRegistered(Context context, String str) {
        return d.a(context).b(str) != null;
    }

    public static void onNotificationMessageArrived(Context context, String str, MiPushMessage miPushMessage) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ackMessage(context, miPushMessage);
        if (c != null) {
            c.onNotificationMessageArrived(str, miPushMessage);
        }
    }

    public static void onNotificationMessageClicked(Context context, String str, MiPushMessage miPushMessage) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a(miPushMessage)) {
            a(context, miPushMessage);
        } else if (c != null) {
            c.onNotificationMessageClicked(str, miPushMessage);
        }
    }

    public static void onPlatformNotificationMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        int intValue = Integer.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS)).intValue();
        if (!z) {
            intValue = (intValue & (-4)) + a.EnumC0483a.NOT_ALLOWED.a();
        }
        a(context, miPushMessage, context.getPackageName(), (short) intValue);
    }

    public static void onReceivePassThroughMessage(Context context, String str, MiPushMessage miPushMessage) {
        if (TextUtils.isEmpty(str) || c == null) {
            return;
        }
        c.onReceivePassThroughMessage(str, miPushMessage);
    }

    public static void onReceiveRegisterResult(Context context, com.xiaomi.xmpush.thrift.ak akVar) {
        ArrayList arrayList;
        d.a aVar;
        String k = akVar.k();
        if (akVar.f() == 0 && (aVar = a.get(k)) != null) {
            aVar.a(akVar.g, akVar.h);
            d.a(context).a(k, aVar);
        }
        if (TextUtils.isEmpty(akVar.g)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(akVar.g);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_REGISTER.k, arrayList, akVar.e, akVar.f, null);
        if (c != null) {
            c.onReceiveRegisterResult(k, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, com.xiaomi.xmpush.thrift.aq aqVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_UNREGISTER.k, null, aqVar.e, aqVar.f, null);
        String g = aqVar.g();
        if (c != null) {
            c.onReceiveUnregisterResult(g, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (d.a(context).c(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            d.a b2 = d.a(context).b(str);
            if (b2 != null) {
                arrayList.add(b2.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_REGISTER.k, arrayList, 0L, null, null);
                if (c != null) {
                    c.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (b(context, str)) {
                com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
                aiVar.b(str2);
                aiVar.c(com.xiaomi.xmpush.thrift.r.PullOfflineMessage.aa);
                aiVar.a(com.xiaomi.push.service.aq.a());
                aiVar.a(false);
                az.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                a(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (b.get(str) != null ? b.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        b.put(str, Long.valueOf(currentTimeMillis));
        String a2 = com.xiaomi.channel.commonutils.string.d.a(6);
        d.a aVar = new d.a(context);
        aVar.c(str2, str3, a2);
        a.put(str, aVar);
        com.xiaomi.xmpush.thrift.aj ajVar = new com.xiaomi.xmpush.thrift.aj();
        ajVar.a(com.xiaomi.push.service.aq.a());
        ajVar.b(str2);
        ajVar.e(str3);
        ajVar.d(str);
        ajVar.f(a2);
        ajVar.c(com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName()));
        ajVar.b(com.xiaomi.channel.commonutils.android.a.b(context, context.getPackageName()));
        ajVar.g("3_6_9");
        ajVar.a(30609);
        ajVar.h(com.xiaomi.channel.commonutils.android.d.d(context));
        ajVar.a(com.xiaomi.xmpush.thrift.w.Init);
        if (!com.xiaomi.channel.commonutils.android.f.g()) {
            String f = com.xiaomi.channel.commonutils.android.d.f(context);
            if (!TextUtils.isEmpty(f)) {
                if (com.xiaomi.channel.commonutils.android.f.b()) {
                    ajVar.i(f);
                }
                ajVar.k(com.xiaomi.channel.commonutils.string.d.a(f));
            }
        }
        ajVar.j(com.xiaomi.channel.commonutils.android.d.a());
        int b3 = com.xiaomi.channel.commonutils.android.d.b();
        if (b3 >= 0) {
            ajVar.c(b3);
        }
        com.xiaomi.xmpush.thrift.ai aiVar2 = new com.xiaomi.xmpush.thrift.ai();
        aiVar2.c(com.xiaomi.xmpush.thrift.r.HybridRegister.aa);
        aiVar2.b(d.a(context).c());
        aiVar2.d(context.getPackageName());
        aiVar2.a(com.xiaomi.xmpush.thrift.at.a(ajVar));
        aiVar2.a(com.xiaomi.push.service.aq.a());
        az.a(context).a((az) aiVar2, com.xiaomi.xmpush.thrift.a.Notification, (com.xiaomi.xmpush.thrift.u) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        aw.a(context, str);
    }

    public static void setCallback(MiPushClientCallbackV2 miPushClientCallbackV2) {
        c = miPushClientCallbackV2;
    }

    public static void setProvider(HybridProvider hybridProvider) {
        d = hybridProvider;
    }

    public static void unregisterPush(Context context, String str) {
        b.remove(str);
        d.a b2 = d.a(context).b(str);
        if (b2 == null) {
            return;
        }
        com.xiaomi.xmpush.thrift.ap apVar = new com.xiaomi.xmpush.thrift.ap();
        apVar.a(com.xiaomi.push.service.aq.a());
        apVar.d(str);
        apVar.b(b2.a);
        apVar.c(b2.c);
        apVar.e(b2.b);
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.c(com.xiaomi.xmpush.thrift.r.HybridUnregister.aa);
        aiVar.b(d.a(context).c());
        aiVar.d(context.getPackageName());
        aiVar.a(com.xiaomi.xmpush.thrift.at.a(apVar));
        aiVar.a(com.xiaomi.push.service.aq.a());
        az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, (com.xiaomi.xmpush.thrift.u) null);
        d.a(context).c(str);
        MIPushNotificationHelper4Hybrid.clearNotification(context, str);
    }
}
