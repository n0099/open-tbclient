package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.push.az;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
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
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has(CommandMessage.TYPE_ALIAS)) {
                    miPushMessage.setAlias(jSONObject.getString(CommandMessage.TYPE_ALIAS));
                }
                if (jSONObject.has(UgcConstant.TOPIC)) {
                    miPushMessage.setTopic(jSONObject.getString(UgcConstant.TOPIC));
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
                return (PushMessageReceiver) com.xiaomi.push.t.a(context, resolveInfo.activityInfo.name).newInstance();
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
        synchronized (h.class) {
            str2 = a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(d dVar) {
        switch (j.a[dVar.ordinal()]) {
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

    public static HashMap<String, String> a(Context context, d dVar) {
        String a2;
        ApplicationInfo applicationInfo;
        String str = null;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(a(dVar))) {
            return hashMap;
        }
        switch (j.a[dVar.ordinal()]) {
            case 1:
                try {
                    applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                    applicationInfo = null;
                }
                str = "brand:" + m.a(context).name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName() + Constants.WAVE_SEPARATOR + "app_id:" + (applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1);
                break;
            case 2:
                str = "brand:" + ah.FCM.name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName();
                break;
            case 3:
                str = "brand:" + ah.OPPO.name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName();
                break;
            case 4:
                str = "brand:" + ah.VIVO.name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName();
                break;
        }
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m110a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(d.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            aq.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m111a(Context context, d dVar) {
        String a2 = a(dVar);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
    }

    public static void a(Context context, d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(dVar);
        if (TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m52a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return;
        }
        String string = sharedPreferences.getString(a2, "");
        if (!TextUtils.isEmpty(string) && str.equals(string)) {
            com.xiaomi.channel.commonutils.logger.b.m52a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m52a("ASSEMBLE_PUSH : send token upload");
        a(dVar, str);
        av a3 = k.a(dVar);
        if (a3 != null) {
            aq.a(context).a((String) null, a3, dVar);
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    private static synchronized void a(d dVar, String str) {
        synchronized (h.class) {
            String a2 = a(dVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m52a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m52a("ASSEMBLE_PUSH : token is null");
            } else {
                a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m112a(Context context) {
        if (context == null) {
            return false;
        }
        return az.b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m113a(Context context, d dVar) {
        if (k.m115a(dVar) != null) {
            return com.xiaomi.push.service.ak.a(context).a(k.m115a(dVar).a(), true);
        }
        return false;
    }

    public static String b(d dVar) {
        switch (j.a[dVar.ordinal()]) {
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
        e.a(context).register();
    }

    public static void b(Context context, d dVar, String str) {
        com.xiaomi.push.ai.a(context).a(new i(str, context, dVar));
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, d dVar, String str) {
        synchronized (h.class) {
            String a2 = a(dVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m52a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else {
                com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, str));
                com.xiaomi.channel.commonutils.logger.b.m52a("ASSEMBLE_PUSH : update sp file success!  " + str);
            }
        }
    }
}
