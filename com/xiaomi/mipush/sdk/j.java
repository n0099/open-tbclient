package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.coloros.mcssdk.PushManager;
import com.coloros.mcssdk.mode.CommandMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class j {
    private static HashMap<String, String> a = new HashMap<>();

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has(PushManager.MESSAGE_TYPE)) {
                    miPushMessage.setMessageType(jSONObject.getInt(PushManager.MESSAGE_TYPE));
                }
                if (jSONObject.has(CommandMessage.TYPE_ALIAS)) {
                    miPushMessage.setAlias(jSONObject.getString(CommandMessage.TYPE_ALIAS));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has("notifyId")) {
                    miPushMessage.setNotifyId(jSONObject.getInt("notifyId"));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    resolveInfo = it.next();
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo != null) {
                return (PushMessageReceiver) Class.forName(resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized String a(Context context, String str) {
        String str2;
        synchronized (j.class) {
            str2 = a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(f fVar) {
        switch (l.a[fVar.ordinal()]) {
            case 1:
                return "hms_push_token";
            case 2:
                return "fcm_push_token";
            case 3:
                return "cos_push_token";
            case 4:
                return "ftos_push_token";
            default:
                return null;
        }
    }

    public static HashMap<String, String> a(Context context, f fVar) {
        String a2;
        ApplicationInfo applicationInfo;
        String str = null;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(a(fVar))) {
            return hashMap;
        }
        switch (l.a[fVar.ordinal()]) {
            case 1:
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                    applicationInfo = null;
                }
                str = "brand:" + o.a(context).name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName() + Constants.WAVE_SEPARATOR + Constants.APP_ID + ":" + (applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1);
                break;
            case 2:
                str = "brand:" + ap.FCM.name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName();
                break;
            case 3:
                str = "brand:" + ap.OPPO.name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName();
                break;
            case 4:
                str = "brand:" + ap.VIVO.name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName();
                break;
        }
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m103a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(f.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(f.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            ay.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m104a(Context context, f fVar) {
        String a2 = a(fVar);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
    }

    public static void a(Context context, f fVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(fVar);
        if (TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return;
        }
        String string = sharedPreferences.getString(a2, "");
        if (!TextUtils.isEmpty(string) && str.equals(string)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : send token upload");
        a(fVar, str);
        bd a3 = m.a(fVar);
        if (a3 != null) {
            ay.a(context).a((String) null, a3, fVar);
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    private static synchronized void a(f fVar, String str) {
        synchronized (j.class) {
            String a2 = a(fVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : token is null");
            } else {
                a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m105a(Context context) {
        if (context == null) {
            return false;
        }
        return com.xiaomi.push.as.b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m106a(Context context, f fVar) {
        if (m.m108a(fVar) != null) {
            return com.xiaomi.push.service.ag.a(context).a(m.m108a(fVar).a(), true);
        }
        return false;
    }

    public static String b(f fVar) {
        switch (l.a[fVar.ordinal()]) {
            case 1:
                return "hms_push_error";
            case 2:
                return "fcm_push_error";
            case 3:
                return "cos_push_error";
            case 4:
                return "ftos_push_error";
            default:
                return null;
        }
    }

    public static void b(Context context) {
        g.a(context).register();
    }

    public static void b(Context context, f fVar, String str) {
        com.xiaomi.push.ai.a(context).a(new k(str, context, fVar));
    }

    public static void c(Context context) {
        g.a(context).unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, f fVar, String str) {
        synchronized (j.class) {
            String a2 = a(fVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else {
                com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, str));
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : update sp file success!  " + str);
            }
        }
    }
}
