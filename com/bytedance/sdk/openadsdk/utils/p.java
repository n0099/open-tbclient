package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class p {
    public static void a() {
        boolean z;
        Context a2 = com.bytedance.sdk.openadsdk.core.p.a();
        if (a2 != null && u.c()) {
            u.f("TTAdSdk-InitChecker", "==当前进程名：" + a(a2));
            u.f("TTAdSdk-InitChecker", "==穿山甲sdk接入，环境为debug，初始化配置检测开始==");
            String packageName = a2.getPackageName();
            int i = a2.getApplicationInfo().targetSdkVersion;
            PackageManager packageManager = a2.getPackageManager();
            boolean z2 = false;
            boolean z3 = false;
            for (ProviderInfo providerInfo : packageManager.queryContentProviders(a2.getApplicationInfo().processName, a2.getApplicationInfo().uid, 131072)) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (TextUtils.isEmpty(str) || !str.equals(providerInfo.authority)) {
                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                    } else {
                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置正常");
                    }
                    z = z2;
                    z3 = true;
                } else if (!providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                    z = z2;
                } else if (Build.VERSION.SDK_INT < 24 || i < 24) {
                    u.f("TTAdSdk-InitChecker", "TTFileProvider不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=24");
                    z = true;
                } else {
                    if (providerInfo.exported) {
                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                    }
                    if (!providerInfo.grantUriPermissions) {
                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                    }
                    try {
                        List<a> a3 = a(a2, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                        if (a3 != null && !a3.isEmpty()) {
                            List<a> c = c();
                            List<a> d = d();
                            for (a aVar : a3) {
                                if (aVar != null) {
                                    c.remove(aVar);
                                    d.remove(aVar);
                                }
                            }
                            if (c.isEmpty() && d.isEmpty()) {
                                u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置正常");
                            } else {
                                Iterator<a> it = c.iterator();
                                while (it.hasNext()) {
                                    u.f("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it.next().toString());
                                }
                                Iterator<a> it2 = d.iterator();
                                while (it2.hasNext()) {
                                    u.f("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it2.next().toString());
                                }
                            }
                        } else {
                            u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                        }
                        z = true;
                    } catch (Throwable th) {
                        u.c("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                        z = true;
                    }
                }
                z2 = z;
            }
            try {
                String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    List<String> b = b();
                    for (String str2 : strArr) {
                        if (str2 != null) {
                            b.remove(str2);
                        }
                    }
                    if (b.isEmpty()) {
                        u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中权限配置正常");
                    } else {
                        Iterator<String> it3 = b.iterator();
                        while (it3.hasNext()) {
                            u.f("TTAdSdk-InitChecker", "    可能缺少权限：" + it3.next() + "，请参考接入文档");
                        }
                    }
                } else {
                    u.f("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
                }
            } catch (Throwable th2) {
                u.c("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th2);
            }
            try {
                if (Build.VERSION.SDK_INT < 23 || i < 23) {
                    u.f("TTAdSdk-InitChecker", "动态权限不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
                } else {
                    boolean a4 = com.bytedance.sdk.openadsdk.core.f.d.a().a(a2, "android.permission.READ_PHONE_STATE");
                    boolean a5 = com.bytedance.sdk.openadsdk.core.f.d.a().a(a2, "android.permission.ACCESS_COARSE_LOCATION");
                    boolean a6 = com.bytedance.sdk.openadsdk.core.f.d.a().a(a2, "android.permission.ACCESS_FINE_LOCATION");
                    boolean a7 = com.bytedance.sdk.openadsdk.core.f.d.a().a(a2, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a4) {
                        u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                    } else {
                        u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.READ_PHONE_STATE");
                    }
                    if (!a5) {
                        u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                    } else {
                        u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (!a6) {
                        u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                    } else {
                        u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.ACCESS_FINE_LOCATION");
                    }
                    if (!a7) {
                        u.f("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                    } else {
                        u.f("TTAdSdk-InitChecker", "动态权限正常：android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
            } catch (Throwable th3) {
                u.c("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th3);
            }
            if (!z3) {
                u.f("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
            }
            if (!z2) {
                u.f("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
            }
            u.f("TTAdSdk-InitChecker", "==穿山甲sdk初始化配置检测结束==");
        }
    }

    private static String a(Context context) {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return "unknown";
    }

    private static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
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

    private static List<a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("external-path", "tt_external_download", "Download"));
        arrayList.add(new a("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new a("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new a(CyberPlayerManager.OPT_CHCHE_PATH, "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<a> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a("external-path", "tt_external_root", "."));
        return arrayList;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [313=4] */
    @androidx.annotation.Nullable
    private static java.util.List<com.bytedance.sdk.openadsdk.utils.p.a> a(android.content.Context r10, int r11) {
        /*
            r3 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L81
            r2.<init>()     // Catch: java.lang.Throwable -> L81
            android.content.res.Resources r0 = r10.getResources()     // Catch: java.lang.Throwable -> L81
            android.content.res.XmlResourceParser r4 = r0.getXml(r11)     // Catch: java.lang.Throwable -> L81
            int r0 = r4.getEventType()     // Catch: java.lang.Throwable -> L67
        L12:
            r1 = 1
            if (r0 == r1) goto L70
            switch(r0) {
                case 0: goto L18;
                case 1: goto L18;
                case 2: goto L1d;
                default: goto L18;
            }     // Catch: java.lang.Throwable -> L67
        L18:
            int r0 = r4.next()     // Catch: java.lang.Throwable -> L67
            goto L12
        L1d:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L67
            int r7 = r4.getAttributeCount()     // Catch: java.lang.Throwable -> L67
            r5 = 0
            r0 = r3
            r1 = r3
        L28:
            if (r5 >= r7) goto L4c
            java.lang.String r8 = r4.getAttributeName(r5)     // Catch: java.lang.Throwable -> L67
            java.lang.String r9 = "name"
            boolean r9 = r8.equals(r9)     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto L3e
            java.lang.String r1 = r4.getAttributeValue(r5)     // Catch: java.lang.Throwable -> L67
        L3b:
            int r5 = r5 + 1
            goto L28
        L3e:
            java.lang.String r9 = "path"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Throwable -> L67
            if (r8 == 0) goto L3b
            java.lang.String r0 = r4.getAttributeValue(r5)     // Catch: java.lang.Throwable -> L67
            goto L3b
        L4c:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L67
            if (r5 != 0) goto L18
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L67
            if (r5 != 0) goto L18
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L67
            if (r5 != 0) goto L18
            com.bytedance.sdk.openadsdk.utils.p$a r5 = new com.bytedance.sdk.openadsdk.utils.p$a     // Catch: java.lang.Throwable -> L67
            r5.<init>(r6, r1, r0)     // Catch: java.lang.Throwable -> L67
            r2.add(r5)     // Catch: java.lang.Throwable -> L67
            goto L18
        L67:
            r0 = move-exception
            r0 = r4
        L69:
            if (r0 == 0) goto L6e
            r0.close()
        L6e:
            r0 = r3
        L6f:
            return r0
        L70:
            if (r4 == 0) goto L75
            r4.close()
        L75:
            r0 = r2
            goto L6f
        L77:
            r0 = move-exception
            r4 = r3
        L79:
            if (r4 == 0) goto L7e
            r4.close()
        L7e:
            throw r0
        L7f:
            r0 = move-exception
            goto L79
        L81:
            r0 = move-exception
            r0 = r3
            goto L69
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.p.a(android.content.Context, int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f5147a;
        String b;
        String c;

        a(String str, String str2, String str3) {
            this.f5147a = str;
            this.b = str2;
            this.c = str3;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f5147a != null && this.f5147a.equals(aVar.f5147a) && this.c != null && this.c.equals(aVar.c);
            }
            return super.equals(obj);
        }

        public String toString() {
            try {
                return "<" + this.f5147a + " name=\"" + this.b + "\" path=\"" + this.c + "\" />";
            } catch (Throwable th) {
                return super.toString();
            }
        }
    }
}
