package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.bo;
import com.xiaomi.push.ex;
import com.xiaomi.push.g;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import com.xiaomi.push.hx;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes10.dex */
public class MiPushClient4Hybrid {
    public static MiPushCallback sCallback;
    public static Map<String, b.a> dataMap = new HashMap();
    public static Map<String, Long> sRegisterTimeMap = new HashMap();

    /* loaded from: classes10.dex */
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
            intValue = (intValue & (-4)) + g.b.NOT_ALLOWED.a();
        }
        return (short) intValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m164a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, ii iiVar) {
        b.a aVar;
        String c = iiVar.c();
        if (iiVar.a() == 0 && (aVar = dataMap.get(c)) != null) {
            aVar.a(iiVar.f706e, iiVar.f707f);
            b.m164a(context).a(c, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(iiVar.f706e)) {
            arrayList = new ArrayList();
            arrayList.add(iiVar.f706e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ex.COMMAND_REGISTER.f336a, arrayList, iiVar.f694a, iiVar.f705d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(c, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, io ioVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ex.COMMAND_UNREGISTER.f336a, null, ioVar.f772a, ioVar.f780d, null, null);
        String a = ioVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m164a(context).m169a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a = b.m164a(context).a(str);
            if (a != null) {
                arrayList.add(a.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ex.COMMAND_REGISTER.f336a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                ig igVar = new ig();
                igVar.b(str2);
                igVar.c(hr.PullOfflineMessage.f508a);
                igVar.a(bd.a());
                igVar.a(false);
                ao.a(context).a(igVar, hh.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m120a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = bo.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        ih ihVar = new ih();
        ihVar.a(bd.a());
        ihVar.b(str2);
        ihVar.e(str3);
        ihVar.d(str);
        ihVar.f(a2);
        ihVar.c(com.xiaomi.push.g.m455a(context, context.getPackageName()));
        ihVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        ihVar.h(BuildConfig.VERSION_NAME);
        ihVar.a(50005);
        ihVar.a(hv.Init);
        if (!com.xiaomi.push.j.m656d()) {
            String d = com.xiaomi.push.i.d(context);
            if (!TextUtils.isEmpty(d)) {
                ihVar.i(bo.a(d));
            }
        }
        int a3 = com.xiaomi.push.i.a();
        if (a3 >= 0) {
            ihVar.c(a3);
        }
        ig igVar2 = new ig();
        igVar2.c(hr.HybridRegister.f508a);
        igVar2.b(b.m164a(context).m165a());
        igVar2.d(context.getPackageName());
        igVar2.a(ir.a(ihVar));
        igVar2.a(bd.a());
        ao.a(context).a((ao) igVar2, hh.Notification, (hu) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        am.a(context, str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m120a("do not ack message, message is null");
            return;
        }
        try {
            hx hxVar = new hx();
            hxVar.b(b.m164a(context).m165a());
            hxVar.a(miPushMessage.getMessageId());
            hxVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            hxVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                hxVar.c(miPushMessage.getTopic());
            }
            ao.a(context).a((ao) hxVar, hh.AckMessage, false, br.a(PushMessageHelper.generateMessage(miPushMessage)));
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
        b.a a = b.m164a(context).a(str);
        if (a == null) {
            return;
        }
        in inVar = new in();
        inVar.a(bd.a());
        inVar.d(str);
        inVar.b(a.f75a);
        inVar.c(a.c);
        inVar.e(a.b);
        ig igVar = new ig();
        igVar.c(hr.HybridUnregister.f508a);
        igVar.b(b.m164a(context).m165a());
        igVar.d(context.getPackageName());
        igVar.a(ir.a(inVar));
        igVar.a(bd.a());
        ao.a(context).a((ao) igVar, hh.Notification, (hu) null);
        b.m164a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.ak.a(context, linkedList);
    }
}
