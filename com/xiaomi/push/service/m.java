package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.fm;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static l f40693a;

    /* renamed from: a  reason: collision with other field name */
    public static a f963a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public static synchronized l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            synchronized (m.class) {
                if (f40693a != null) {
                    return f40693a;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                String string = sharedPreferences.getString("uuid", null);
                String string2 = sharedPreferences.getString("token", null);
                String string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString("app_id", null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString("package_name", null);
                String string7 = sharedPreferences.getString("device_id", null);
                int i2 = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.m438a(string7)) {
                    string7 = com.xiaomi.push.i.k(context);
                    sharedPreferences.edit().putString("device_id", string7).commit();
                }
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                    return null;
                }
                String k = com.xiaomi.push.i.k(context);
                if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(string7) && !string7.equals(k)) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("read_phone_state permission changes.");
                }
                l lVar = new l(string, string2, string3, string4, string5, string6, i2);
                f40693a = lVar;
                return lVar;
            }
        }
        return (l) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:5|6|(2:10|(26:12|13|(1:15)|16|(1:18)|19|(1:21)|22|(1:24)|25|(1:27)|28|29|30|31|(1:33)(1:67)|34|(6:36|(1:38)|39|(1:43)|44|(1:46))|47|(1:49)|50|(1:52)|53|(2:55|(5:57|(1:59)|60|61|62)(1:64))|65|66))|71|13|(0)|16|(0)|19|(0)|22|(0)|25|(0)|28|29|30|31|(0)(0)|34|(0)|47|(0)|50|(0)|53|(0)|65|66) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c0, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c1, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r10);
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c A[Catch: all -> 0x0236, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x003f, B:10:0x0049, B:12:0x005f, B:14:0x006b, B:16:0x007c, B:17:0x0081, B:19:0x008b, B:20:0x0090, B:23:0x0098, B:26:0x00a1, B:29:0x00aa, B:30:0x00b5, B:36:0x00c9, B:38:0x00d2, B:40:0x00f9, B:42:0x0105, B:43:0x0118, B:45:0x0122, B:47:0x0128, B:48:0x013c, B:50:0x0142, B:51:0x0147, B:53:0x016a, B:54:0x0173, B:56:0x01a9, B:57:0x01ad, B:59:0x01b3, B:61:0x01c0, B:63:0x01de, B:64:0x01f4, B:67:0x0222, B:33:0x00c1), top: B:79:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008b A[Catch: all -> 0x0236, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x003f, B:10:0x0049, B:12:0x005f, B:14:0x006b, B:16:0x007c, B:17:0x0081, B:19:0x008b, B:20:0x0090, B:23:0x0098, B:26:0x00a1, B:29:0x00aa, B:30:0x00b5, B:36:0x00c9, B:38:0x00d2, B:40:0x00f9, B:42:0x0105, B:43:0x0118, B:45:0x0122, B:47:0x0128, B:48:0x013c, B:50:0x0142, B:51:0x0147, B:53:0x016a, B:54:0x0173, B:56:0x01a9, B:57:0x01ad, B:59:0x01b3, B:61:0x01c0, B:63:0x01de, B:64:0x01f4, B:67:0x0222, B:33:0x00c1), top: B:79:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9 A[Catch: all -> 0x0236, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x003f, B:10:0x0049, B:12:0x005f, B:14:0x006b, B:16:0x007c, B:17:0x0081, B:19:0x008b, B:20:0x0090, B:23:0x0098, B:26:0x00a1, B:29:0x00aa, B:30:0x00b5, B:36:0x00c9, B:38:0x00d2, B:40:0x00f9, B:42:0x0105, B:43:0x0118, B:45:0x0122, B:47:0x0128, B:48:0x013c, B:50:0x0142, B:51:0x0147, B:53:0x016a, B:54:0x0173, B:56:0x01a9, B:57:0x01ad, B:59:0x01b3, B:61:0x01c0, B:63:0x01de, B:64:0x01f4, B:67:0x0222, B:33:0x00c1), top: B:79:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9 A[Catch: all -> 0x0236, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x003f, B:10:0x0049, B:12:0x005f, B:14:0x006b, B:16:0x007c, B:17:0x0081, B:19:0x008b, B:20:0x0090, B:23:0x0098, B:26:0x00a1, B:29:0x00aa, B:30:0x00b5, B:36:0x00c9, B:38:0x00d2, B:40:0x00f9, B:42:0x0105, B:43:0x0118, B:45:0x0122, B:47:0x0128, B:48:0x013c, B:50:0x0142, B:51:0x0147, B:53:0x016a, B:54:0x0173, B:56:0x01a9, B:57:0x01ad, B:59:0x01b3, B:61:0x01c0, B:63:0x01de, B:64:0x01f4, B:67:0x0222, B:33:0x00c1), top: B:79:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016a A[Catch: all -> 0x0236, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x003f, B:10:0x0049, B:12:0x005f, B:14:0x006b, B:16:0x007c, B:17:0x0081, B:19:0x008b, B:20:0x0090, B:23:0x0098, B:26:0x00a1, B:29:0x00aa, B:30:0x00b5, B:36:0x00c9, B:38:0x00d2, B:40:0x00f9, B:42:0x0105, B:43:0x0118, B:45:0x0122, B:47:0x0128, B:48:0x013c, B:50:0x0142, B:51:0x0147, B:53:0x016a, B:54:0x0173, B:56:0x01a9, B:57:0x01ad, B:59:0x01b3, B:61:0x01c0, B:63:0x01de, B:64:0x01f4, B:67:0x0222, B:33:0x00c1), top: B:79:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a9 A[Catch: all -> 0x0236, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x003f, B:10:0x0049, B:12:0x005f, B:14:0x006b, B:16:0x007c, B:17:0x0081, B:19:0x008b, B:20:0x0090, B:23:0x0098, B:26:0x00a1, B:29:0x00aa, B:30:0x00b5, B:36:0x00c9, B:38:0x00d2, B:40:0x00f9, B:42:0x0105, B:43:0x0118, B:45:0x0122, B:47:0x0128, B:48:0x013c, B:50:0x0142, B:51:0x0147, B:53:0x016a, B:54:0x0173, B:56:0x01a9, B:57:0x01ad, B:59:0x01b3, B:61:0x01c0, B:63:0x01de, B:64:0x01f4, B:67:0x0222, B:33:0x00c1), top: B:79:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b3 A[Catch: all -> 0x0236, TryCatch #1 {, blocks: (B:6:0x0007, B:8:0x003f, B:10:0x0049, B:12:0x005f, B:14:0x006b, B:16:0x007c, B:17:0x0081, B:19:0x008b, B:20:0x0090, B:23:0x0098, B:26:0x00a1, B:29:0x00aa, B:30:0x00b5, B:36:0x00c9, B:38:0x00d2, B:40:0x00f9, B:42:0x0105, B:43:0x0118, B:45:0x0122, B:47:0x0128, B:48:0x013c, B:50:0x0142, B:51:0x0147, B:53:0x016a, B:54:0x0173, B:56:0x01a9, B:57:0x01ad, B:59:0x01b3, B:61:0x01c0, B:63:0x01de, B:64:0x01f4, B:67:0x0222, B:33:0x00c1), top: B:79:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized l a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        String str4;
        String b2;
        String a2;
        int a3;
        String a4;
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, str2, str3)) == null) {
            synchronized (m.class) {
                TreeMap treeMap = new TreeMap();
                String a5 = com.xiaomi.push.i.a(context, false);
                com.xiaomi.channel.commonutils.logger.b.m70a("account register:" + a5 + " mim:" + com.xiaomi.push.ax.a(context).e());
                treeMap.put("devid", a5);
                if (f40693a != null && !TextUtils.isEmpty(f40693a.f962a)) {
                    treeMap.put("uuid", f40693a.f962a);
                    int lastIndexOf = f40693a.f962a.lastIndexOf("/");
                    if (lastIndexOf != -1) {
                        str4 = f40693a.f962a.substring(lastIndexOf + 1);
                        com.xiaomi.push.ax.a(context).a(treeMap);
                        b2 = com.xiaomi.push.i.b(context);
                        if (!TextUtils.isEmpty(b2)) {
                            treeMap.put("vdevid", b2);
                        }
                        a2 = com.xiaomi.push.i.a(context);
                        if (!TextUtils.isEmpty(a2)) {
                            treeMap.put("gaid", a2);
                        }
                        if (m632a(context)) {
                            str2 = "1000271";
                        }
                        String str5 = str2;
                        if (m632a(context)) {
                            str3 = "420100086271";
                        }
                        String str6 = str3;
                        if (m632a(context)) {
                            str = "com.xiaomi.xmsf";
                        }
                        String str7 = str;
                        treeMap.put("appid", str5);
                        treeMap.put("apptoken", str6);
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str7, 16384);
                        treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                        treeMap.put("sdkversion", Integer.toString(30805));
                        treeMap.put("packagename", str7);
                        treeMap.put("model", Build.MODEL);
                        treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
                        if (!com.xiaomi.push.l.d()) {
                            String str8 = "";
                            if (!TextUtils.isEmpty(com.xiaomi.push.i.f(context))) {
                                str8 = "" + com.xiaomi.push.bm.a(f2);
                            }
                            String h2 = com.xiaomi.push.i.h(context);
                            if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(h2)) {
                                str8 = str8 + "," + h2;
                            }
                            if (!TextUtils.isEmpty(str8)) {
                                treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str8);
                            }
                        }
                        treeMap.put(IAdRequestParam.OS, Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                        a3 = com.xiaomi.push.i.a();
                        if (a3 >= 0) {
                            treeMap.put("space_id", Integer.toString(a3));
                        }
                        treeMap.put("brand", Build.BRAND + "");
                        treeMap.put("ram", com.xiaomi.push.i.m435a());
                        treeMap.put(Config.ROM, com.xiaomi.push.i.m439b());
                        com.xiaomi.push.be a6 = com.xiaomi.push.bg.a(context, m630a(context), treeMap);
                        a4 = a6 != null ? a6.a() : "";
                        if (!TextUtils.isEmpty(a4)) {
                            JSONObject jSONObject = new JSONObject(a4);
                            if (jSONObject.getInt("code") == 0) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                String string = jSONObject2.getString("ssecurity");
                                String string2 = jSONObject2.getString("token");
                                String string3 = jSONObject2.getString("userId");
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = com.alipay.sdk.sys.a.f1937i + com.xiaomi.push.bm.a(6);
                                }
                                l lVar = new l(string3 + "@xiaomi.com/" + str4, string2, string, str5, str6, str7, com.xiaomi.push.ab.a());
                                a(context, lVar);
                                com.xiaomi.push.i.a(context, jSONObject2.optString("vdevid"));
                                f40693a = lVar;
                                return lVar;
                            }
                            p.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                            com.xiaomi.channel.commonutils.logger.b.m70a(a4);
                        }
                        return null;
                    }
                }
                str4 = null;
                com.xiaomi.push.ax.a(context).a(treeMap);
                b2 = com.xiaomi.push.i.b(context);
                if (!TextUtils.isEmpty(b2)) {
                }
                a2 = com.xiaomi.push.i.a(context);
                if (!TextUtils.isEmpty(a2)) {
                }
                if (m632a(context)) {
                }
                String str52 = str2;
                if (m632a(context)) {
                }
                String str62 = str3;
                if (m632a(context)) {
                }
                String str72 = str;
                treeMap.put("appid", str52);
                treeMap.put("apptoken", str62);
                PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str72, 16384);
                treeMap.put("appversion", packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
                treeMap.put("sdkversion", Integer.toString(30805));
                treeMap.put("packagename", str72);
                treeMap.put("model", Build.MODEL);
                treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
                if (!com.xiaomi.push.l.d()) {
                }
                treeMap.put(IAdRequestParam.OS, Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                a3 = com.xiaomi.push.i.a();
                if (a3 >= 0) {
                }
                treeMap.put("brand", Build.BRAND + "");
                treeMap.put("ram", com.xiaomi.push.i.m435a());
                treeMap.put(Config.ROM, com.xiaomi.push.i.m439b());
                com.xiaomi.push.be a62 = com.xiaomi.push.bg.a(context, m630a(context), treeMap);
                if (a62 != null) {
                }
                if (!TextUtils.isEmpty(a4)) {
                }
                return null;
            }
        }
        return (l) invokeLLLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m630a(Context context) {
        InterceptResult invokeL;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String a2 = com.xiaomi.push.service.a.a(context).a();
            if (com.xiaomi.push.ab.b()) {
                sb = new StringBuilder();
                sb.append("http://");
                sb.append(fm.f40134b);
                str = ":9085";
            } else if (com.xiaomi.push.o.f40532a.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://cn.register.xmpush.xiaomi.com";
            } else if (com.xiaomi.push.o.f40533b.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://register.xmpush.global.xiaomi.com";
            } else if (com.xiaomi.push.o.f40534c.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://fr.register.xmpush.global.xiaomi.com";
            } else if (com.xiaomi.push.o.f40535d.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://ru.register.xmpush.global.xiaomi.com";
            } else if (com.xiaomi.push.o.f40536e.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://idmb.register.xmpush.global.xiaomi.com";
            } else {
                sb = new StringBuilder();
                sb.append("https://");
                str = com.xiaomi.push.ab.m139a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
            }
            sb.append(str);
            sb.append("/pass/v2/register");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (aVar = f963a) == null) {
            return;
        }
        aVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m631a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
            f40693a = null;
            a();
        }
    }

    public static void a(Context context, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, lVar) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
            edit.putString("uuid", lVar.f962a);
            edit.putString("security", lVar.f40689c);
            edit.putString("token", lVar.f40688b);
            edit.putString("app_id", lVar.f40690d);
            edit.putString("package_name", lVar.f40692f);
            edit.putString("app_token", lVar.f40691e);
            edit.putString("device_id", com.xiaomi.push.i.k(context));
            edit.putInt("env_type", lVar.f40687a);
            edit.commit();
            a();
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, aVar) == null) {
            f963a = aVar;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m632a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? context.getPackageName().equals("com.xiaomi.xmsf") : invokeL.booleanValue;
    }
}
