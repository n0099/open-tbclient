package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.push.Cif;
import com.xiaomi.push.fa;
import com.xiaomi.push.g;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.iq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes8.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, d.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* loaded from: classes8.dex */
    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = !TextUtils.isEmpty(str) ? Integer.valueOf(str).intValue() : 0;
        if (!z) {
            intValue = (intValue & (-4)) + g.a.NOT_ALLOWED.a();
        }
        return (short) intValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return d.m85a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, ih ihVar) {
        ArrayList arrayList;
        d.a aVar;
        String b = ihVar.b();
        if (ihVar.a() == 0 && (aVar = dataMap.get(b)) != null) {
            aVar.a(ihVar.f683e, ihVar.f684f);
            d.m85a(context).a(b, aVar);
        }
        if (TextUtils.isEmpty(ihVar.f683e)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(ihVar.f683e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fa.COMMAND_REGISTER.f333a, arrayList, ihVar.f673a, ihVar.f682d, null);
        if (sCallback != null) {
            sCallback.onReceiveRegisterResult(b, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, in inVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fa.COMMAND_UNREGISTER.f333a, null, inVar.f749a, inVar.f757d, null);
        String a = inVar.a();
        if (sCallback != null) {
            sCallback.onReceiveUnregisterResult(a, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (d.m85a(context).m90a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            d.a a = d.m85a(context).a(str);
            if (a != null) {
                arrayList.add(a.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fa.COMMAND_REGISTER.f333a, arrayList, 0L, null, null);
                if (sCallback != null) {
                    sCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                Cif cif = new Cif();
                cif.b(str2);
                cif.c(hq.PullOfflineMessage.f490a);
                cif.a(com.xiaomi.push.service.aj.a());
                cif.a(false);
                ay.a(context).a(cif, hg.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m47a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = com.xiaomi.push.ay.a(6);
        d.a aVar = new d.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        ig igVar = new ig();
        igVar.a(com.xiaomi.push.service.aj.a());
        igVar.b(str2);
        igVar.e(str3);
        igVar.d(str);
        igVar.f(a2);
        igVar.c(com.xiaomi.push.g.m296a(context, context.getPackageName()));
        igVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        igVar.g("3_6_19");
        igVar.a(30619);
        igVar.h(com.xiaomi.push.i.e(context));
        igVar.a(hu.Init);
        if (!com.xiaomi.push.l.d()) {
            String g = com.xiaomi.push.i.g(context);
            if (!TextUtils.isEmpty(g)) {
                if (com.xiaomi.push.l.m484b()) {
                    igVar.i(g);
                }
                igVar.k(com.xiaomi.push.ay.a(g));
            }
        }
        igVar.j(com.xiaomi.push.i.m389a());
        int a3 = com.xiaomi.push.i.a();
        if (a3 >= 0) {
            igVar.c(a3);
        }
        Cif cif2 = new Cif();
        cif2.c(hq.HybridRegister.f490a);
        cif2.b(d.m85a(context).m86a());
        cif2.d(context.getPackageName());
        cif2.a(iq.a(igVar));
        cif2.a(com.xiaomi.push.service.aj.a());
        ay.a(context).a((ay) cif2, hg.Notification, (ht) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        av.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m47a("do not ack message, message is null");
            return;
        }
        try {
            hw hwVar = new hw();
            hwVar.b(d.m85a(context).m86a());
            hwVar.a(miPushMessage.getMessageId());
            hwVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            hwVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                hwVar.c(miPushMessage.getTopic());
            }
            ay.a(context).a((ay) hwVar, hg.AckMessage, false, PushMessageHelper.generateMessage(miPushMessage));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } catch (Throwable th) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            } finally {
                miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
                miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong(new StringBuilder().append("last_pull_notification_").append(str).toString(), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        d.a a = d.m85a(context).a(str);
        if (a == null) {
            return;
        }
        im imVar = new im();
        imVar.a(com.xiaomi.push.service.aj.a());
        imVar.d(str);
        imVar.b(a.f64a);
        imVar.c(a.c);
        imVar.e(a.b);
        Cif cif = new Cif();
        cif.c(hq.HybridUnregister.f490a);
        cif.b(d.m85a(context).m86a());
        cif.d(context.getPackageName());
        cif.a(iq.a(imVar));
        cif.a(com.xiaomi.push.service.aj.a());
        ay.a(context).a((ay) cif, hg.Notification, (ht) null);
        d.m85a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.z.a(context, linkedList);
    }
}
