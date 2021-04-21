package d.b.h0.a.i2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45514a = d.b.h0.a.k.f45772a;

    public static Map<String, ComponentName> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(RomUtils.MANUFACTURER_HUAWEI, new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        hashMap.put(ImmersiveOSUtils.LETV, new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
        hashMap.put("lg", new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
        hashMap.put("sony", new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
        return hashMap;
    }

    public static Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(RomUtils.MANUFACTURER_OPPO, "com.coloros.safecenter");
        hashMap.put(RomUtils.MANUFACTURER_VIVO, "com.bairenkeji.icaller");
        hashMap.put("coolpad", "com.yulong.android.security:remote");
        return hashMap;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0046: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:19:0x0046 */
    public static String c() {
        BufferedReader bufferedReader;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    String readLine = bufferedReader.readLine();
                    d.b.h0.p.d.a(bufferedReader);
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    if (f45514a) {
                        e.printStackTrace();
                    }
                    d.b.h0.p.d.a(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                d.b.h0.p.d.a(closeable2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.h0.p.d.a(closeable2);
            throw th;
        }
    }

    public static PackageInfo d(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e2) {
            if (f45514a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static ResolveInfo e(Context context, PackageInfo packageInfo) {
        List<ResolveInfo> list;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        try {
            list = context.getPackageManager().queryIntentActivities(intent, 0);
        } catch (Exception e2) {
            if (f45514a) {
                e2.printStackTrace();
            }
            list = null;
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public static void f(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        k(context, intent);
    }

    public static void g(Context context) {
        if (context == null) {
            return;
        }
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            f(context);
            return;
        }
        String lowerCase = str.toLowerCase();
        if (f45514a) {
            Log.d("SwanAppPermissionHelper", "goPermissionPage : " + lowerCase);
        }
        if (TextUtils.equals(lowerCase, RomUtils.MANUFACTURER_XIAOMI)) {
            i(context);
        } else if (TextUtils.equals(lowerCase, RomUtils.MANUFACTURER_MEIZU)) {
            h(context);
        } else {
            Map<String, ComponentName> a2 = a();
            if (a2.containsKey(lowerCase)) {
                l(context, a2.get(lowerCase));
                return;
            }
            Map<String, String> b2 = b();
            if (b2.containsKey(lowerCase)) {
                m(context, b2.get(lowerCase));
            } else {
                f(context);
            }
        }
    }

    public static void h(Context context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
            context.startActivity(intent);
        } catch (Exception e2) {
            if (f45514a) {
                e2.printStackTrace();
            }
            f(context);
        }
    }

    public static void i(Context context) {
        String c2 = c();
        if (f45514a) {
            Log.d("SwanAppPermissionHelper", "goPermissionPageForXiaomi rom version : " + c2);
        }
        Intent intent = new Intent();
        if (!"V10".equals(c2) && !"V9".equals(c2) && !"V8".equals(c2)) {
            if (!"V7".equals(c2) && !"V6".equals(c2)) {
                f(context);
                return;
            }
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            k(context, intent);
            return;
        }
        intent.setAction("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        k(context, intent);
    }

    public static boolean j(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT < 23) {
                return true;
            }
            int i = -1;
            try {
                i = ContextCompat.checkSelfPermission(context, str);
            } catch (Exception e2) {
                if (f45514a) {
                    throw e2;
                }
            }
            return i == 0;
        } else if (f45514a) {
            throw new IllegalArgumentException("context or permission is null");
        } else {
            return false;
        }
    }

    public static void k(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                context.startActivity(intent);
            } catch (Exception e2) {
                if (f45514a) {
                    e2.printStackTrace();
                }
            }
        } else if (f45514a) {
            Log.e("SwanAppPermissionHelper", "context or intent is null");
        }
    }

    public static void l(Context context, ComponentName componentName) {
        try {
            Intent intent = new Intent(context.getPackageName());
            intent.setComponent(componentName);
            context.startActivity(intent);
        } catch (Exception e2) {
            if (f45514a) {
                e2.printStackTrace();
            }
            f(context);
        }
    }

    public static void m(Context context, String str) {
        PackageInfo d2 = d(context, str);
        if (d2 == null) {
            f(context);
            return;
        }
        ResolveInfo e2 = e(context, d2);
        if (e2 == null) {
            f(context);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(e2.activityInfo.packageName, e2.activityInfo.name));
            context.startActivity(intent);
        } catch (Exception e3) {
            if (f45514a) {
                e3.printStackTrace();
            }
            f(context);
        }
    }
}
