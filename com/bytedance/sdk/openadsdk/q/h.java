package com.bytedance.sdk.openadsdk.q;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f69163a;

        /* renamed from: b  reason: collision with root package name */
        public String f69164b;

        /* renamed from: c  reason: collision with root package name */
        public String f69165c;

        public a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69163a = str;
            this.f69164b = str2;
            this.f69165c = str3;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    String str2 = this.f69163a;
                    return str2 != null && str2.equals(aVar.f69163a) && (str = this.f69165c) != null && str.equals(aVar.f69165c);
                }
                return super.equals(obj);
            }
            return invokeL.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    return "<" + this.f69163a + " name=\"" + this.f69164b + "\" path=\"" + this.f69165c + "\" />";
                } catch (Throwable unused) {
                    return super.toString();
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        Context a2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (a2 = com.bytedance.sdk.openadsdk.core.o.a()) != null && com.bytedance.sdk.component.utils.k.c()) {
            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "==当前进程名：" + a(a2));
            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "==穿山甲sdk接入，环境为debug，初始化配置检测开始==");
            String packageName = a2.getPackageName();
            int i3 = a2.getApplicationInfo().targetSdkVersion;
            PackageManager packageManager = a2.getPackageManager();
            boolean z = false;
            boolean z2 = false;
            for (ProviderInfo providerInfo : packageManager.queryContentProviders(a2.getApplicationInfo().processName, a2.getApplicationInfo().uid, 131072)) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (!TextUtils.isEmpty(str) && str.equals(providerInfo.authority)) {
                        com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置正常");
                        com.bytedance.sdk.openadsdk.o.a.b(3, "1");
                    } else {
                        com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                        com.bytedance.sdk.openadsdk.o.a.b(3, "0");
                    }
                    z = true;
                } else {
                    if (providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                        if (Build.VERSION.SDK_INT >= 24 && i3 >= 24) {
                            if (providerInfo.exported) {
                                com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                                i2 = 3;
                                com.bytedance.sdk.openadsdk.o.a.b(3, "0");
                            } else {
                                i2 = 3;
                            }
                            if (!providerInfo.grantUriPermissions) {
                                com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                                com.bytedance.sdk.openadsdk.o.a.b(i2, "0");
                            }
                            try {
                                List<a> a3 = a(a2, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                                if (a3 != null && !a3.isEmpty()) {
                                    List<a> c2 = c();
                                    List<a> d2 = d();
                                    for (a aVar : a3) {
                                        if (aVar != null) {
                                            c2.remove(aVar);
                                            d2.remove(aVar);
                                        }
                                    }
                                    if (c2.isEmpty() && d2.isEmpty()) {
                                        com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置正常");
                                        com.bytedance.sdk.openadsdk.o.a.b(3, "1");
                                    } else {
                                        Iterator<a> it = c2.iterator();
                                        while (it.hasNext()) {
                                            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it.next().toString());
                                        }
                                        Iterator<a> it2 = d2.iterator();
                                        while (it2.hasNext()) {
                                            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it2.next().toString());
                                        }
                                        com.bytedance.sdk.openadsdk.o.a.b(3, "0");
                                    }
                                } else {
                                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                                    com.bytedance.sdk.openadsdk.o.a.b(3, "0");
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.k.c("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                                com.bytedance.sdk.openadsdk.o.a.b(3, "0");
                            }
                        } else {
                            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "TTFileProvider不需要适配：target=" + i3 + "&phone=" + Build.VERSION.SDK_INT + ", require=24");
                            com.bytedance.sdk.openadsdk.o.a.b(3, "1");
                        }
                        z2 = true;
                    }
                }
            }
            try {
                String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    List<String> b2 = b();
                    for (String str2 : strArr) {
                        if (str2 != null) {
                            b2.remove(str2);
                        }
                    }
                    if (b2.isEmpty()) {
                        com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中权限配置正常");
                    } else {
                        Iterator<String> it3 = b2.iterator();
                        while (it3.hasNext()) {
                            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "    可能缺少权限：" + it3.next() + "，请参考接入文档");
                        }
                    }
                } else {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.k.c("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th2);
            }
            try {
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.k.c("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th3);
            }
            if (Build.VERSION.SDK_INT >= 23 && i3 >= 23) {
                boolean a4 = com.bytedance.sdk.openadsdk.core.g.d.a().a(a2, "android.permission.READ_PHONE_STATE");
                boolean a5 = com.bytedance.sdk.openadsdk.core.g.d.a().a(a2, "android.permission.ACCESS_COARSE_LOCATION");
                boolean a6 = com.bytedance.sdk.openadsdk.core.g.d.a().a(a2, "android.permission.ACCESS_FINE_LOCATION");
                boolean a7 = com.bytedance.sdk.openadsdk.core.g.d.a().a(a2, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!a4) {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                } else {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.READ_PHONE_STATE");
                }
                if (!a5) {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                } else {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.ACCESS_COARSE_LOCATION");
                }
                if (!a6) {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                } else {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.ACCESS_FINE_LOCATION");
                }
                if (!a7) {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                } else {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.WRITE_EXTERNAL_STORAGE");
                }
                if (!z) {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
                }
                if (!z2) {
                    com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
                }
                com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "==穿山甲sdk初始化配置检测结束==");
            }
            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "动态权限不需要适配：target=" + i3 + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
            if (!z) {
            }
            if (!z2) {
            }
            com.bytedance.sdk.component.utils.k.f("TTAdSdk-InitChecker", "==穿山甲sdk初始化配置检测结束==");
        }
    }

    public static List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.INTERNET");
            arrayList.add(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION);
            arrayList.add("android.permission.ACCESS_WIFI_STATE");
            arrayList.add("android.permission.READ_PHONE_STATE");
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
            arrayList.add("android.permission.GET_TASKS");
            arrayList.add("android.permission.WAKE_LOCK");
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static List<a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new a("external-path", "tt_external_download", "Download"));
            arrayList.add(new a("external-files-path", "tt_external_files_download", "Download"));
            arrayList.add(new a("files-path", "tt_internal_file_download", "Download"));
            arrayList.add(new a("cache-path", "tt_internal_cache_download", "Download"));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static List<a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new a("external-path", "tt_external_root", "."));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return "unknown";
                }
                return "unknown";
            } catch (Throwable unused) {
                return "unknown";
            }
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static List<a> a(Context context, int i2) {
        InterceptResult invokeLI;
        XmlResourceParser xmlResourceParser;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            try {
                arrayList = new ArrayList();
                xmlResourceParser = context.getResources().getXml(i2);
            } catch (Throwable unused) {
                xmlResourceParser = null;
            }
            try {
                for (int eventType = xmlResourceParser.getEventType(); eventType != 1; eventType = xmlResourceParser.next()) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = xmlResourceParser.getName();
                        int attributeCount = xmlResourceParser.getAttributeCount();
                        String str = null;
                        String str2 = null;
                        for (int i3 = 0; i3 < attributeCount; i3++) {
                            String attributeName = xmlResourceParser.getAttributeName(i3);
                            if (attributeName.equals("name")) {
                                str = xmlResourceParser.getAttributeValue(i3);
                            } else if (attributeName.equals("path")) {
                                str2 = xmlResourceParser.getAttributeValue(i3);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            arrayList.add(new a(name, str, str2));
                            continue;
                        }
                    }
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return arrayList;
            } catch (Throwable unused2) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return null;
            }
        }
        return (List) invokeLI.objValue;
    }
}
