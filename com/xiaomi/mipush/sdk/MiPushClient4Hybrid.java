package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bm;
import com.xiaomi.push.ev;
import com.xiaomi.push.g;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class MiPushClient4Hybrid {
    public static MiPushCallback sCallback;
    public static Map<String, b.a> dataMap = new HashMap();
    public static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* loaded from: classes7.dex */
    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    public static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    public static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int intValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
        if (!z) {
            intValue = (intValue & (-4)) + g.a.NOT_ALLOWED.a();
        }
        return (short) intValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m92a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, ig igVar) {
        b.a aVar;
        String b2 = igVar.b();
        if (igVar.a() == 0 && (aVar = dataMap.get(b2)) != null) {
            aVar.a(igVar.f701e, igVar.f702f);
            b.m92a(context).a(b2, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(igVar.f701e)) {
            arrayList = new ArrayList();
            arrayList.add(igVar.f701e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.COMMAND_REGISTER.f337a, arrayList, igVar.f691a, igVar.f700d, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(b2, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, im imVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.COMMAND_UNREGISTER.f337a, null, imVar.f767a, imVar.f775d, null);
        String a2 = imVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a2, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m92a(context).m97a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a2 = b.m92a(context).a(str);
            if (a2 != null) {
                arrayList.add(a2.f40182c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.COMMAND_REGISTER.f337a, arrayList, 0L, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                ie ieVar = new ie();
                ieVar.b(str2);
                ieVar.c(hp.PullOfflineMessage.f506a);
                ieVar.a(com.xiaomi.push.service.at.a());
                ieVar.a(false);
                an.a(context).a(ieVar, hf.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m51a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a3 = bm.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a3);
        dataMap.put(str, aVar);
        Cif cif = new Cif();
        cif.a(com.xiaomi.push.service.at.a());
        cif.b(str2);
        cif.e(str3);
        cif.d(str);
        cif.f(a3);
        cif.c(com.xiaomi.push.g.m319a(context, context.getPackageName()));
        cif.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        cif.h("3_8_5");
        cif.a(30805);
        cif.a(ht.Init);
        if (!com.xiaomi.push.l.d()) {
            String g2 = com.xiaomi.push.i.g(context);
            if (!TextUtils.isEmpty(g2)) {
                cif.i(bm.a(g2));
            }
        }
        int a4 = com.xiaomi.push.i.a();
        if (a4 >= 0) {
            cif.c(a4);
        }
        ie ieVar2 = new ie();
        ieVar2.c(hp.HybridRegister.f506a);
        ieVar2.b(b.m92a(context).m93a());
        ieVar2.d(context.getPackageName());
        ieVar2.a(ip.a(cif));
        ieVar2.a(com.xiaomi.push.service.at.a());
        an.a(context).a((an) ieVar2, hf.Notification, (hs) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        al.a(context, str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m51a("do not ack message, message is null");
            return;
        }
        try {
            hv hvVar = new hv();
            hvVar.b(b.m92a(context).m93a());
            hvVar.a(miPushMessage.getMessageId());
            hvVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            hvVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                hvVar.c(miPushMessage.getTopic());
            }
            an.a(context).a((an) hvVar, hf.AckMessage, false, PushMessageHelper.generateMessage(miPushMessage));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    public static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a a2 = b.m92a(context).a(str);
        if (a2 == null) {
            return;
        }
        il ilVar = new il();
        ilVar.a(com.xiaomi.push.service.at.a());
        ilVar.d(str);
        ilVar.b(a2.f81a);
        ilVar.c(a2.f40182c);
        ilVar.e(a2.f40181b);
        ie ieVar = new ie();
        ieVar.c(hp.HybridUnregister.f506a);
        ieVar.b(b.m92a(context).m93a());
        ieVar.d(context.getPackageName());
        ieVar.a(ip.a(ilVar));
        ieVar.a(com.xiaomi.push.service.at.a());
        an.a(context).a((an) ieVar, hf.Notification, (hs) null);
        b.m92a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.ac.a(context, linkedList);
    }
}
