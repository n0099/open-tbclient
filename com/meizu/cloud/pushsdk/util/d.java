package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.init.ApsCloudControlProcessor;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.c.b.f;
import com.meizu.cloud.pushsdk.c.c.b;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {
    public static int a(Context context) {
        if (MzSystemUtils.isMeizu(context)) {
            return 1;
        }
        if (MzSystemUtils.isXiaoMi()) {
            return 2;
        }
        return MzSystemUtils.isHuaWei() ? 3 : 0;
    }

    public static com.meizu.cloud.pushsdk.handler.a.b.d a(String str) {
        String str2;
        com.meizu.cloud.pushsdk.handler.a.b.d dVar = new com.meizu.cloud.pushsdk.handler.a.b.d();
        if (TextUtils.isEmpty(str)) {
            str2 = "the platformExtra is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return com.meizu.cloud.pushsdk.handler.a.b.d.a().a(jSONObject.has("task_id") ? jSONObject.getString("task_id") : null).d(jSONObject.has("device_id") ? jSONObject.getString("device_id") : null).c(jSONObject.has("push_timestamp") ? jSONObject.getString("push_timestamp") : null).b(jSONObject.has("seq_id") ? jSONObject.getString("seq_id") : null).a();
            } catch (Exception unused) {
                str2 = "the platformExtra parse error";
            }
        }
        DebugLogger.e("UxIPUtils", str2);
        return dVar;
    }

    public static String a(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_TASK_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            try {
                MPushMessage mPushMessage = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                return mPushMessage != null ? mPushMessage.getTaskId() : stringExtra;
            } catch (Exception e) {
                DebugLogger.e("UxIPUtils", "paese MessageV2 error " + e.getMessage());
                return "no push platform task";
            }
        }
        return stringExtra;
    }

    public static void a(Context context, Intent intent, String str, int i) {
        a(context, intent, PushManager.TAG, str, i);
    }

    public static void a(Context context, Intent intent, String str, String str2, int i) {
        if (TextUtils.isEmpty(a(intent))) {
            return;
        }
        a(context, context.getPackageName(), intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), a(intent), str, str2, i);
    }

    public static void a(Context context, String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(context, context.getPackageName(), str3, str2, PushManager.TAG, str, i);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "spm", str5);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("taskId", str3);
        hashMap.put("deviceId", str2);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("package_name", str);
        hashMap.put("pushsdk_version", str4);
        hashMap.put("push_info", str5);
        hashMap.put("push_info_type", String.valueOf(i));
        a(context, false, "notification_service_message", (Map<String, String>) hashMap);
    }

    public static void a(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("en", str5);
        hashMap.put(Config.FEED_LIST_PART, str3);
        hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, str2);
        if (TextUtils.isEmpty(str6)) {
            str6 = String.valueOf(System.currentTimeMillis() / 1000);
        }
        hashMap.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, str6);
        hashMap.put("pn", str);
        hashMap.put("pv", PushManager.TAG);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("si", str4);
        }
        if (a(context, hashMap)) {
            return;
        }
        a(context, z, str5, hashMap);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [com.meizu.cloud.pushsdk.c.c.b$a] */
    public static void a(Context context, boolean z, String str, Map<String, String> map) {
        DebugLogger.e("UxIPUtils", "onLogEvent eventName [" + str + "] properties = " + map);
        if ("notification_service_message".equals(str)) {
            return;
        }
        com.meizu.cloud.pushsdk.c.a.a(context, (f) null).a(((b.a) com.meizu.cloud.pushsdk.c.c.b.d().a(str).a(a(context)).a(Long.valueOf(map.get(TimeDisplaySetting.TIME_DISPLAY_SETTING)).longValue())).h(String.valueOf(System.currentTimeMillis() / 1000)).c(map.get(AppIconSetting.DEFAULT_LARGE_ICON)).e(map.get("pn")).d(map.get("pv")).b(map.get(Config.FEED_LIST_PART)).f(TextUtils.isEmpty(map.get("si")) ? "" : map.get("si")).g(String.valueOf(b.j(context, map.get("pn")))).b(), z);
    }

    public static boolean a(Context context, Map<String, String> map) {
        String str;
        String str2;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION), 0);
        String str3 = null;
        if (queryIntentServices != null) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                }
                ResolveInfo next = it.next();
                if ("com.meizu.cloud".equals(next.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = next.serviceInfo;
                    str2 = serviceInfo.packageName;
                    str3 = serviceInfo.name;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str3) || queryIntentServices.size() <= 0) {
                str = str3;
                str3 = str2;
            } else {
                str3 = queryIntentServices.get(0).serviceInfo.packageName;
                str = queryIntentServices.get(0).serviceInfo.name;
            }
        } else {
            str = null;
        }
        DebugLogger.i("UxIPUtils", "current process packageName " + str3);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String jSONObject = e.a((Map) map).toString();
            Intent intent = new Intent();
            intent.setPackage(str3);
            intent.setAction(PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION);
            intent.putExtra(PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA, jSONObject);
            context.startService(intent);
            DebugLogger.i("UxIPUtils", "Start tracker data in mz_tracker process " + jSONObject);
            return true;
        } catch (Exception e) {
            DebugLogger.e("UxIPUtils", "start RemoteService error " + e.getMessage());
            return false;
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, ApsCloudControlProcessor.SERVER_DPM, str5);
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, false, str, str2, str3, str4, "rpe", str5);
    }

    public static void d(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "rpe", str5);
    }

    public static void e(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, true, str, str2, str3, str4, "cpm", str5);
    }

    public static void f(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, false, str, str2, str3, str4, "sipm", str5);
    }

    public static void g(Context context, String str, String str2, String str3, String str4, String str5) {
        a(context, false, str, str2, str3, str4, "npm", str5);
    }
}
