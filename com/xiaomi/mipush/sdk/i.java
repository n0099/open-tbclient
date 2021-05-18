package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.bg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f37340a = new HashMap<>();

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(MiPushMessage.KEY_MESSAGE_ID)) {
                    miPushMessage.setMessageId(jSONObject.getString(MiPushMessage.KEY_MESSAGE_ID));
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
                if (jSONObject.has(MiPushMessage.KEY_PASS_THROUGH)) {
                    miPushMessage.setPassThrough(jSONObject.getInt(MiPushMessage.KEY_PASS_THROUGH));
                }
                if (jSONObject.has(MiPushMessage.KEY_NOTIFY_TYPE)) {
                    miPushMessage.setNotifyType(jSONObject.getInt(MiPushMessage.KEY_NOTIFY_TYPE));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has(MiPushMessage.KEY_USER_ACCOUNT)) {
                    miPushMessage.setUserAccount(jSONObject.getString(MiPushMessage.KEY_USER_ACCOUNT));
                }
                if (jSONObject.has(MiPushMessage.KEY_NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has(MiPushMessage.KEY_NOTIFIED)) {
                    miPushMessage.setNotified(jSONObject.getBoolean(MiPushMessage.KEY_NOTIFIED));
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
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
        }
        return miPushMessage;
    }

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
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            return null;
        }
    }

    public static synchronized String a(Context context, String str) {
        String str2;
        synchronized (i.class) {
            str2 = f37340a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(e eVar) {
        int i2 = k.f37342a[eVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token";
        }
        return "hms_push_token";
    }

    public static HashMap<String, String> a(Context context, e eVar) {
        StringBuilder sb;
        af afVar;
        HashMap<String, String> hashMap = new HashMap<>();
        String a2 = a(eVar);
        if (TextUtils.isEmpty(a2)) {
            return hashMap;
        }
        int i2 = k.f37342a[eVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i2 != 1) {
            if (i2 == 2) {
                sb = new StringBuilder();
                sb.append("brand:");
                afVar = af.FCM;
            } else if (i2 == 3) {
                sb = new StringBuilder();
                sb.append("brand:");
                afVar = af.OPPO;
            } else if (i2 == 4) {
                sb = new StringBuilder();
                sb.append("brand:");
                afVar = af.VIVO;
            }
            sb.append(afVar.name());
            sb.append(Constants.WAVE_SEPARATOR);
            sb.append("token");
            sb.append(":");
            sb.append(a(context, a2));
            sb.append(Constants.WAVE_SEPARATOR);
            sb.append("package_name");
            sb.append(":");
            sb.append(context.getPackageName());
            str = sb.toString();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
            str = "brand:" + n.a(context).name() + Constants.WAVE_SEPARATOR + "token:" + a(context, a2) + Constants.WAVE_SEPARATOR + "package_name:" + context.getPackageName() + Constants.WAVE_SEPARATOR + Constants.APP_ID + ":" + (applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1);
        }
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m117a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(e.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(e.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            an.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m118a(Context context, e eVar) {
        String a2 = a(eVar);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
    }

    public static void a(Context context, e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(eVar);
        if (TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return;
        }
        String string = sharedPreferences.getString(a2, "");
        if (!TextUtils.isEmpty(string) && str.equals(string)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : send token upload");
        a(eVar, str);
        at a3 = l.a(eVar);
        if (a3 == null) {
            return;
        }
        an.a(context).a((String) null, a3, eVar);
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static synchronized void a(e eVar, String str) {
        synchronized (i.class) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : token is null");
            } else {
                f37340a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i2) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m119a(Context context) {
        if (context == null) {
            return false;
        }
        return bg.b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m120a(Context context, e eVar) {
        if (l.m122a(eVar) != null) {
            return com.xiaomi.push.service.aq.a(context).a(l.m122a(eVar).a(), true);
        }
        return false;
    }

    public static String b(e eVar) {
        int i2 = k.f37342a[eVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return "ftos_push_error";
                }
                return "cos_push_error";
            }
            return "fcm_push_error";
        }
        return "hms_push_error";
    }

    public static void b(Context context) {
        f.a(context).register();
    }

    public static void b(Context context, e eVar, String str) {
        com.xiaomi.push.ai.a(context).a(new j(str, context, eVar));
    }

    public static void c(Context context) {
        f.a(context).unregister();
    }

    public static synchronized void d(Context context, e eVar, String str) {
        synchronized (i.class) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            com.xiaomi.push.r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, str));
            com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
