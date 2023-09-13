package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.hh;
import com.xiaomi.push.id;
import com.xiaomi.push.ik;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.bk;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class FCMPushHelper {
    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", String.valueOf(hh.AckMessage.a()));
        hashMap.put("deviceStatus", String.valueOf((int) ir.a(context, context.getPackageName())));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    public static void a(Context context, id idVar) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((ik) ai.a(context, idVar), idVar.m625a(), false);
            PushMessageReceiver a = i.a(context);
            if (a != null) {
                a.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm broadcast notification come error ", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, byte[] bArr) {
        String format;
        boolean m218a = ao.a(context).m218a();
        boolean z = true;
        boolean z2 = !"com.xiaomi.xmsf".equals(context.getPackageName());
        boolean m194a = m194a(context);
        boolean z3 = false;
        if (m218a && z2 && m194a) {
            bArr = com.xiaomi.push.service.n.a(bArr, b.m225a(context).d());
            if (bArr != null) {
                String encodeToString = Base64.encodeToString(bArr, 2);
                if (TextUtils.isEmpty(encodeToString)) {
                    com.xiaomi.channel.commonutils.logger.b.m181a("fcm message buf base64 encode failed");
                    z = false;
                } else {
                    Intent intent = new Intent(bk.n);
                    intent.setPackage("com.xiaomi.xmsf");
                    intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.push.service.XMPushService");
                    intent.putExtra("ext_fcm_container_buffer", encodeToString);
                    intent.putExtra("mipush_app_package", context.getPackageName());
                    context.startService(intent);
                    com.xiaomi.channel.commonutils.logger.b.m181a("fcm message reroute to xmsf");
                }
                z3 = z;
                if (z3) {
                    com.xiaomi.channel.commonutils.logger.b.b("fcm message post local");
                    com.xiaomi.push.service.ak.m762a(context, com.xiaomi.push.service.y.a(bArr), bArr);
                    return;
                }
                return;
            }
            format = "fcm message encrypt failed";
        } else {
            format = String.format("xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s", Boolean.valueOf(m218a), Boolean.valueOf(z2), Boolean.valueOf(m194a));
        }
        com.xiaomi.channel.commonutils.logger.b.m181a(format);
        if (z3) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m194a(Context context) {
        return ((long) com.xiaomi.push.j.b(context)) >= 50002000 && b(context);
    }

    public static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        i.m246a(context, e.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return i.m249a(context, e.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a = i.a(context)) == null) {
            return;
        }
        a.onNotificationMessageArrived(context, i.a(str));
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a;
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str) && (a = i.a(context)) != null) {
            a.onReceivePassThroughMessage(context, i.a(str));
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] decode = Base64.decode(str2, 2);
            a(context, com.xiaomi.push.service.y.a(decode));
            a(context, decode);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("fcm notify notification error ", th);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) com.xiaomi.push.j.b(context)) >= 50002000).apply();
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(i.c(e.ASSEMBLE_PUSH_FCM), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        i.m247a(context, e.ASSEMBLE_PUSH_FCM, str);
    }
}
