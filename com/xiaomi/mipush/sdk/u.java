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
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.xiaomi.push.service.az;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes10.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f76942a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f100a;

        /* renamed from: b  reason: collision with root package name */
        public String f76943b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f101b;

        public b(String str, boolean z, boolean z2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76942a = str;
            this.f100a = z;
            this.f101b = z2;
            this.f76943b = str2;
        }
    }

    public static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, packageManager, intent, cls)) == null) {
            for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                    return activityInfo;
                }
            }
            return null;
        }
        return (ActivityInfo) invokeLLL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            new Thread(new v(context)).start();
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
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
    }

    public static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activityInfo, boolArr) == null) {
            if (boolArr[0].booleanValue() != activityInfo.enabled) {
                throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
            }
            if (boolArr[1].booleanValue() != activityInfo.exported) {
                throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
            }
        }
    }

    public static boolean a(PackageInfo packageInfo, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, packageInfo, strArr)) == null) {
            for (ServiceInfo serviceInfo : packageInfo.services) {
                if (a(strArr, serviceInfo.name)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, strArr, str)) == null) {
            if (strArr != null && str != null) {
                for (String str2 : strArr) {
                    if (TextUtils.equals(str2, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6 A[EDGE_INSN: B:48:0x00a6->B:32:0x00a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0072 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
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
    }

    public static void c(Context context, PackageInfo packageInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, packageInfo) == null) {
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
    }

    public static void d(Context context, PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, packageInfo) == null) {
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
                        boolean z = bVar.f100a;
                        boolean z2 = bVar.f101b;
                        String str = bVar.f76943b;
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
}
