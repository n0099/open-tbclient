package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bf;
import com.xiaomi.push.fg;
import com.xiaomi.push.g;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ic;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes6.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* loaded from: classes6.dex */
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
        return b.m124a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, in inVar) {
        ArrayList arrayList;
        b.a aVar;
        String b2 = inVar.b();
        if (inVar.a() == 0 && (aVar = dataMap.get(b2)) != null) {
            aVar.a(inVar.f750e, inVar.f751f);
            b.m124a(context).a(b2, aVar);
        }
        if (TextUtils.isEmpty(inVar.f750e)) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            arrayList.add(inVar.f750e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fg.COMMAND_REGISTER.f399a, arrayList, inVar.f740a, inVar.f749d, null);
        if (sCallback != null) {
            sCallback.onReceiveRegisterResult(b2, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, it itVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fg.COMMAND_UNREGISTER.f399a, null, itVar.f816a, itVar.f824d, null);
        String a2 = itVar.a();
        if (sCallback != null) {
            sCallback.onReceiveUnregisterResult(a2, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m124a(context).m129a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a2 = b.m124a(context).a(str);
            if (a2 != null) {
                arrayList.add(a2.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fg.COMMAND_REGISTER.f399a, arrayList, 0L, null, null);
                if (sCallback != null) {
                    sCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                il ilVar = new il();
                ilVar.b(str2);
                ilVar.c(hw.PullOfflineMessage.f556a);
                ilVar.a(com.xiaomi.push.service.an.a());
                ilVar.a(false);
                aq.a(context).a(ilVar, hm.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m84a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a3 = bf.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a3);
        dataMap.put(str, aVar);
        im imVar = new im();
        imVar.a(com.xiaomi.push.service.an.a());
        imVar.b(str2);
        imVar.e(str3);
        imVar.d(str);
        imVar.f(a3);
        imVar.c(com.xiaomi.push.g.m337a(context, context.getPackageName()));
        imVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        imVar.h("3_7_5");
        imVar.a(30705);
        imVar.i(com.xiaomi.push.i.e(context));
        imVar.a(ia.Init);
        if (!com.xiaomi.push.l.d()) {
            String g = com.xiaomi.push.i.g(context);
            if (!TextUtils.isEmpty(g)) {
                imVar.k(bf.a(g));
            }
        }
        imVar.j(com.xiaomi.push.i.m418a());
        int a4 = com.xiaomi.push.i.a();
        if (a4 >= 0) {
            imVar.c(a4);
        }
        il ilVar2 = new il();
        ilVar2.c(hw.HybridRegister.f556a);
        ilVar2.b(b.m124a(context).m125a());
        ilVar2.d(context.getPackageName());
        ilVar2.a(iw.a(imVar));
        ilVar2.a(com.xiaomi.push.service.an.a());
        aq.a(context).a((aq) ilVar2, hm.Notification, (hz) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        an.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("do not ack message, message is null");
            return;
        }
        try {
            ic icVar = new ic();
            icVar.b(b.m124a(context).m125a());
            icVar.a(miPushMessage.getMessageId());
            icVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            icVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                icVar.c(miPushMessage.getTopic());
            }
            aq.a(context).a((aq) icVar, hm.AckMessage, false, PushMessageHelper.generateMessage(miPushMessage));
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
        b.a a2 = b.m124a(context).a(str);
        if (a2 == null) {
            return;
        }
        is isVar = new is();
        isVar.a(com.xiaomi.push.service.an.a());
        isVar.d(str);
        isVar.b(a2.f147a);
        isVar.c(a2.c);
        isVar.e(a2.f14121b);
        il ilVar = new il();
        ilVar.c(hw.HybridUnregister.f556a);
        ilVar.b(b.m124a(context).m125a());
        ilVar.d(context.getPackageName());
        ilVar.a(iw.a(isVar));
        ilVar.a(com.xiaomi.push.service.an.a());
        aq.a(context).a((aq) ilVar, hm.Notification, (hz) null);
        b.m124a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.aa.a(context, linkedList);
    }
}
