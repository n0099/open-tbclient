package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bn;
import com.xiaomi.push.id;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    public static int a() {
        Integer num = (Integer) bj.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int a(Context context, e eVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a = a(eVar);
        String string = sharedPreferences.getString(a, "");
        String m153c = b.m145a(context).m153c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a)) {
            com.xiaomi.channel.commonutils.logger.b.m101a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        } else if (TextUtils.isEmpty(string)) {
            return 1;
        } else {
            if (string.equals(str)) {
                if (TextUtils.equals(m153c, string2)) {
                    if (m170a(eVar)) {
                        if (a() != sharedPreferences.getInt(b(eVar), 0)) {
                            return 4;
                        }
                    }
                    return 0;
                }
                return 3;
            }
            return 2;
        }
    }

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
                if (jSONObject.has("notifyId")) {
                    miPushMessage.setNotifyId(jSONObject.getInt("notifyId"));
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
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
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
                return (PushMessageReceiver) com.xiaomi.push.s.a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return null;
        }
    }

    public static String a(Context context, e eVar) {
        return a(context, eVar, false);
    }

    public static synchronized String a(Context context, e eVar, boolean z) {
        synchronized (i.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            if (z) {
                String string = sharedPreferences.getString("syncingToken", "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            }
            String a = a(eVar);
            if (TextUtils.isEmpty(a)) {
                return "";
            }
            return sharedPreferences.getString(a, "");
        }
    }

    public static String a(e eVar) {
        int i = k.a[eVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token_v2";
        }
        return "hms_push_token";
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004b, code lost:
        if (r12 != 0) goto L11;
     */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, String> m164a(Context context, e eVar) {
        t.a a;
        int a2;
        HashMap<String, String> hashMap = new HashMap<>();
        int i = k.a[eVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i != 1) {
            if (i == 2) {
                a = new t.a(":", Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, ag.FCM.name()).a("token", a(context, eVar, false)).a("package_name", context.getPackageName());
                a2 = a();
                if (a2 == 0) {
                    a2 = 50005;
                }
            } else if (i != 3) {
                if (i == 4) {
                    a = new t.a(":", Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, ag.VIVO.name()).a("token", a(context, eVar, true)).a("package_name", context.getPackageName());
                    a2 = a();
                }
                hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
                return hashMap;
            } else {
                a = new t.a(":", Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, ag.OPPO.name()).a("token", a(context, eVar, true)).a("package_name", context.getPackageName());
            }
            a.a("version", Integer.valueOf(a2));
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
            a = new t.a(":", Constants.WAVE_SEPARATOR).a(Constants.PHONE_BRAND, ag.HUAWEI.name()).a("token", a(context, eVar, true)).a("package_name", context.getPackageName()).a("app_id", Integer.valueOf(applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1));
        }
        str = a.toString();
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, str);
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m165a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a = a(e.ASSEMBLE_PUSH_HUAWEI);
        String a2 = a(e.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a, "")) && TextUtils.isEmpty(sharedPreferences.getString(a2, ""))) {
            z = true;
        }
        if (z) {
            ao.a(context).a(2, a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m166a(Context context, e eVar) {
        String a = a(eVar);
        if (TextUtils.isEmpty(a)) {
            return;
        }
        com.xiaomi.push.q.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a, ""));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m167a(Context context, e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int a = a(context, eVar, str);
        if (a == 0) {
            com.xiaomi.channel.commonutils.logger.b.m101a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m101a("ASSEMBLE_PUSH : send token upload, check:" + a);
        a(context, str);
        au a2 = l.a(eVar);
        if (a2 == null) {
            return;
        }
        ao.a(context).a((String) null, a2, eVar, StatConstants.VALUE_TYPE_UPLOAD);
    }

    public static synchronized void a(Context context, String str) {
        synchronized (i.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("syncingToken", str);
            edit.apply();
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m168a(Context context) {
        if (context == null) {
            return false;
        }
        return bi.b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m169a(Context context, e eVar) {
        if (l.m172a(eVar) != null) {
            return ba.a(context).a(l.m172a(eVar).a(), true);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m170a(e eVar) {
        return eVar == e.ASSEMBLE_PUSH_FTOS || eVar == e.ASSEMBLE_PUSH_FCM;
    }

    public static boolean a(id idVar, e eVar) {
        if (idVar == null || idVar.m545a() == null || idVar.m545a().m506a() == null) {
            return false;
        }
        return (eVar == e.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(idVar.m545a().m506a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, id idVar, e eVar) {
        if (a(idVar, eVar)) {
            return bn.m218a(a(context, eVar));
        }
        return null;
    }

    public static String b(e eVar) {
        return a(eVar) + "_version";
    }

    public static void b(Context context) {
        f.a(context).register();
    }

    public static void b(Context context, e eVar, String str) {
        com.xiaomi.push.aj.a(context).a(new j(str, context, eVar));
    }

    public static String c(e eVar) {
        int i = k.a[eVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
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

    public static void c(Context context) {
        f.a(context).unregister();
    }

    public static synchronized void d(Context context, e eVar, String str) {
        synchronized (i.class) {
            String a = a(eVar);
            if (TextUtils.isEmpty(a)) {
                com.xiaomi.channel.commonutils.logger.b.m101a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a, str).putString("last_check_token", b.m145a(context).m153c());
            if (m170a(eVar)) {
                edit.putInt(b(eVar), a());
            }
            edit.putString("syncingToken", "");
            com.xiaomi.push.q.a(edit);
            com.xiaomi.channel.commonutils.logger.b.m101a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
