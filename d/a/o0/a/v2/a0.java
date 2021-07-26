package d.a.o0.a.v2;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.PermissionRequest;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48483a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, String> f48484b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-968396464, "Ld/a/o0/a/v2/a0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-968396464, "Ld/a/o0/a/v2/a0;");
                return;
            }
        }
        f48483a = d.a.o0.a.k.f46335a;
        HashMap hashMap = new HashMap(14);
        f48484b = hashMap;
        hashMap.put("android.permission.ACCESS_FINE_LOCATION", "定位");
        f48484b.put("android.permission.ACCESS_COARSE_LOCATION", "定位");
        f48484b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, "录音");
        f48484b.put("android.permission.READ_CONTACTS", "读取联系人");
        f48484b.put(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, "访问网络状态");
        f48484b.put("android.permission.REORDER_TASKS", "开机自启");
        f48484b.put("android.permission.INTERNET", "网络");
        f48484b.put("android.permission.REQUEST_INSTALL_PACKAGES", "安装软件包");
        f48484b.put("android.permission.READ_CALENDAR", "读取日历");
        f48484b.put("android.permission.WRITE_CALENDAR", "写入日历");
        f48484b.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, "存储");
        f48484b.put("android.permission.READ_EXTERNAL_STORAGE", "存储");
        f48484b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, "相机");
        f48484b.put("android.permission.WRITE_SETTINGS", "系统设置");
        f48484b.put("android.permission.SYSTEM_ALERT_WINDOW", "悬浮窗");
    }

    public static Map<String, ComponentName> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(RomUtils.MANUFACTURER_HUAWEI, new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            hashMap.put(ImmersiveOSUtils.LETV, new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
            hashMap.put("lg", new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
            hashMap.put("sony", new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(RomUtils.MANUFACTURER_OPPO, "com.coloros.safecenter");
            hashMap.put(RomUtils.MANUFACTURER_VIVO, "com.bairenkeji.icaller");
            hashMap.put("coolpad", "com.yulong.android.security:remote");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    d.a.o0.t.d.d(bufferedReader);
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    if (f48483a) {
                        e.printStackTrace();
                    }
                    d.a.o0.t.d.d(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                d.a.o0.t.d.d(bufferedReader2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.o0.t.d.d(bufferedReader2);
            throw th;
        }
    }

    public static PackageInfo d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0);
            } catch (Exception e2) {
                if (f48483a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static ResolveInfo e(Context context, PackageInfo packageInfo) {
        InterceptResult invokeLL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, packageInfo)) == null) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            try {
                list = context.getPackageManager().queryIntentActivities(intent, 0);
            } catch (Exception e2) {
                if (f48483a) {
                    e2.printStackTrace();
                }
                list = null;
            }
            if (list == null || list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, context.getPackageName(), null));
            k(context, intent);
        }
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, context) == null) || context == null) {
            return;
        }
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            f(context);
            return;
        }
        String lowerCase = str.toLowerCase();
        if (f48483a) {
            Log.d("SwanAppPermissionHelper", "goPermissionPage : " + lowerCase);
        }
        if (TextUtils.equals(lowerCase, RomUtils.MANUFACTURER_XIAOMI)) {
            i(context);
        } else if (TextUtils.equals(lowerCase, "meizu")) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            try {
                Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("packageName", context.getPackageName());
                context.startActivity(intent);
            } catch (Exception e2) {
                if (f48483a) {
                    e2.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            String c2 = c();
            if (f48483a) {
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
    }

    public static boolean j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT < 23) {
                    return true;
                }
                int i2 = -1;
                try {
                    i2 = ContextCompat.checkSelfPermission(context, str);
                } catch (Exception e2) {
                    if (f48483a) {
                        throw e2;
                    }
                }
                return i2 == 0;
            } else if (f48483a) {
                throw new IllegalArgumentException("context or permission is null");
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void k(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, intent) == null) {
            if (context != null && intent != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e2) {
                    if (f48483a) {
                        e2.printStackTrace();
                    }
                }
            } else if (f48483a) {
                Log.e("SwanAppPermissionHelper", "context or intent is null");
            }
        }
    }

    public static void l(Context context, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, componentName) == null) {
            try {
                Intent intent = new Intent(context.getPackageName());
                intent.setComponent(componentName);
                context.startActivity(intent);
            } catch (Exception e2) {
                if (f48483a) {
                    e2.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static void m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
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
                if (f48483a) {
                    e3.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            String str2 = f48484b.get(str);
            return str2 == null ? "" : str2;
        }
        return (String) invokeL.objValue;
    }
}
