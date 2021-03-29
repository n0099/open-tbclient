package d.o.a.d.n;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.sina.weibo.sdk.constant.WBConstants;
import d.o.a.d.f.n;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d.o.a.d.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1836a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.o.a.e.a.h.c.i();
            a.g();
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public Object f66769e;

        public /* synthetic */ b(Object obj, RunnableC1836a runnableC1836a) {
            this(obj);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (WBConstants.SHARE_START_ACTIVITY.contains(method.getName())) {
                    a.d(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.f66769e, objArr);
        }

        public b(Object obj) {
            this.f66769e = obj;
        }
    }

    public static int a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return d.o.a.c.c.a(str, new File(str2));
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.o.a.c.c.f(new File(str));
    }

    public static void c() {
        if (n.s().optInt("hook", 0) != 1) {
            return;
        }
        d.o.a.d.i.a().c(new RunnableC1836a(), 10000L);
    }

    public static void d(Object[] objArr) {
        if (n.s().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && d.o.a.e.b.d.c.f66953a.equals(intent.getType())) {
                if (d.o.a.e.a.h.c.e()) {
                    String optString = n.s().optString("hook_vivo_arg", "com.android.settings");
                    if (StringUtil.NULL_STRING.equals(optString)) {
                        return;
                    }
                    objArr[1] = optString;
                } else if (d.o.a.e.a.h.c.f()) {
                    JSONObject s = n.s();
                    String optString2 = s.optString("hook_kllk_arg1", "com." + d.o.a.e.b.d.c.f66955c + ".market");
                    if (!StringUtil.NULL_STRING.equals(optString2)) {
                        objArr[1] = optString2;
                    }
                    String optString3 = n.s().optString("hook_kllk_arg2", "com.android.browser");
                    JSONObject s2 = n.s();
                    String optString4 = s2.optString("hook_kllk_arg3", "m.store." + d.o.a.e.b.d.c.f66955c + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(d.o.a.e.b.d.c.f66955c);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), optString3);
                    intent.putExtra("refererHost", optString4);
                    if (n.s().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(d.o.a.e.b.d.c.f66955c + "_extra_pkg_name", optString3);
                        intent2.putExtra("refererHost", optString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                    }
                } else if (d.o.a.e.a.h.c.a()) {
                    String optString5 = n.s().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!StringUtil.NULL_STRING.equals(optString5)) {
                        objArr[1] = optString5;
                    }
                    intent.putExtra("caller_package", n.s().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = n.a().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void g() {
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
            if (obj2 == null || (cls = Class.forName("android.app.IActivityManager")) == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new b(obj2, null)));
        } catch (Throwable unused) {
        }
    }
}
