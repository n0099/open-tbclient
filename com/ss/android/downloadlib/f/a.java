package com.ss.android.downloadlib.f;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.c.c.aB(new File(str));
    }

    public static int a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.c.c.r(str, new File(str2));
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.a.j.a().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void a() {
        if (com.ss.android.downloadlib.a.j.i().optInt("hook", 0) == 1) {
            com.ss.android.downloadlib.f.eGz().a(new Runnable() { // from class: com.ss.android.downloadlib.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.ss.android.socialbase.downloader.m.g.f();
                    a.c();
                }
            }, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        Field declaredField;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 != null && (cls = Class.forName("android.app.IActivityManager")) != null) {
                declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C1237a(obj2)));
            }
        } catch (Throwable th) {
        }
    }

    public static void a(Object[] objArr) {
        if (com.ss.android.downloadlib.a.j.i().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.b.e.f13372a.equals(intent.getType())) {
                if (com.ss.android.socialbase.downloader.m.g.c()) {
                    String optString = com.ss.android.downloadlib.a.j.i().optString("hook_vivo_arg", "com.android.settings");
                    if (!"null".equals(optString)) {
                        objArr[1] = optString;
                    }
                } else if (com.ss.android.socialbase.downloader.m.g.d()) {
                    String optString2 = com.ss.android.downloadlib.a.j.i().optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.b.e.c + ".market");
                    if (!"null".equals(optString2)) {
                        objArr[1] = optString2;
                    }
                    String optString3 = com.ss.android.downloadlib.a.j.i().optString("hook_kllk_arg2", "com.android.browser");
                    String optString4 = com.ss.android.downloadlib.a.j.i().optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.b.e.c + "mobile.com");
                    intent.putExtra(com.ss.android.socialbase.downloader.b.e.c + "_extra_pkg_name", optString3);
                    intent.putExtra("refererHost", optString4);
                    if (com.ss.android.downloadlib.a.j.i().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(com.ss.android.socialbase.downloader.b.e.c + "_extra_pkg_name", optString3);
                        intent2.putExtra("refererHost", optString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                    }
                } else if (com.ss.android.socialbase.downloader.m.g.a()) {
                    String optString5 = com.ss.android.downloadlib.a.j.i().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(optString5)) {
                        objArr[1] = optString5;
                    }
                    intent.putExtra("caller_package", com.ss.android.downloadlib.a.j.i().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1237a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private Object f13286a;

        private C1237a(Object obj) {
            this.f13286a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (WBConstants.SHARE_START_ACTIVITY.contains(method.getName())) {
                    a.a(objArr);
                }
            } catch (Throwable th) {
            }
            return method.invoke(this.f13286a, objArr);
        }
    }
}
