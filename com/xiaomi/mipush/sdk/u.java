package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.xiaomi.push.service.az;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class u {

    /* loaded from: classes7.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f40496a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f93a;

        /* renamed from: b  reason: collision with root package name */
        public String f40497b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f94b;

        public b(String str, boolean z, boolean z2, String str2) {
            this.f40496a = str;
            this.f93a = z;
            this.f94b = z2;
            this.f40497b = str2;
        }
    }

    public static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void a(Context context) {
        new Thread(new v(context)).start();
    }

    public static void a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        boolean z = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (!z) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    public static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
        }
        if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
        }
    }

    public static boolean a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2 A[EDGE_INSN: B:43:0x00a2->B:30:0x00a2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(az.o);
        intent.setPackage(packageName);
        try {
            ActivityInfo a2 = a(packageManager, intent, com.xiaomi.push.t.a(context, "com.xiaomi.push.service.receivers.PingReceiver"));
            if (MiPushClient.shouldUseMIUIPush(context)) {
                if (a2 != null) {
                    a(a2, new Boolean[]{Boolean.TRUE, Boolean.FALSE});
                }
            } else if (a2 == null) {
                throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", "com.xiaomi.push.service.receivers.PingReceiver"));
            } else {
                a(a2, new Boolean[]{Boolean.TRUE, Boolean.FALSE});
            }
        } catch (ClassNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent2.setPackage(packageName);
        boolean z = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent2, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null) {
                try {
                } catch (ClassNotFoundException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                }
                if (!TextUtils.isEmpty(activityInfo.name) && PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.t.a(context, activityInfo.name)) && activityInfo.enabled) {
                    z = true;
                    if (!z) {
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        if (!z) {
            throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
        }
        if (MiPushClient.getOpenHmsPush(context)) {
            a(context, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
            a(context, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
        }
        if (MiPushClient.getOpenVIVOPush(context)) {
            a(context, "com.vivo.pushclient.action.RECEIVE", "com.xiaomi.assemble.control.FTOSPushMessageReceiver");
        }
    }

    public static void c(Context context, PackageInfo packageInfo) {
        boolean z;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList("android.permission.INTERNET", DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
        PermissionInfo[] permissionInfoArr = packageInfo.permissions;
        if (permissionInfoArr != null) {
            for (PermissionInfo permissionInfo : permissionInfoArr) {
                if (str.equals(permissionInfo.name)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
        }
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                    hashSet.remove(str2);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
        }
    }

    public static void d(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.shouldUseMIUIPush(context) || a(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.getOpenFCMPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.getOpenOPPOPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    b bVar = (b) hashMap2.remove(serviceInfo.name);
                    boolean z = bVar.f93a;
                    boolean z2 = bVar.f94b;
                    String str = bVar.f40497b;
                    if (z != serviceInfo.enabled) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z)));
                    }
                    if (z2 != serviceInfo.exported) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z2)));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, serviceInfo.permission)) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                    }
                    hashMap.put(serviceInfo.name, serviceInfo.processName);
                    if (hashMap2.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashMap2.isEmpty()) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.keySet().iterator().next()));
        }
        if (!TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        }
        if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
        }
    }
}
