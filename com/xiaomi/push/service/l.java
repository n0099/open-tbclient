package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.fn;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class l {
    private static k a;

    /* renamed from: a  reason: collision with other field name */
    private static a f917a;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public static synchronized k a(Context context) {
        k kVar = null;
        synchronized (l.class) {
            if (a != null) {
                kVar = a;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                String string = sharedPreferences.getString("uuid", null);
                String string2 = sharedPreferences.getString("token", null);
                String string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString(Constants.APP_ID, null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString("package_name", null);
                String string7 = sharedPreferences.getString(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, null);
                int i = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && string7.startsWith("a-")) {
                    string7 = com.xiaomi.push.i.k(context);
                    sharedPreferences.edit().putString(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, string7).commit();
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                    String k = com.xiaomi.push.i.k(context);
                    if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(string7) && !string7.equals(k)) {
                        com.xiaomi.channel.commonutils.logger.b.m47a("read_phone_state permission changes.");
                    }
                    a = new k(string, string2, string3, string4, string5, string6, i);
                    kVar = a;
                }
            }
        }
        return kVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:3|4|(2:8|(27:10|11|(1:13)|14|(1:16)|17|(1:19)(1:73)|20|(1:22)(1:72)|23|(1:25)(1:71)|26|27|28|29|(1:31)(1:67)|32|(6:34|(1:36)|37|(1:41)|42|(1:44))|45|(1:47)|48|(1:50)|51|(1:53)|54|(2:56|(3:58|(1:60)(1:62)|61)(1:63))|64))|74|11|(0)|14|(0)|17|(0)(0)|20|(0)(0)|23|(0)(0)|26|27|28|29|(0)(0)|32|(0)|45|(0)|48|(0)|51|(0)|54|(0)|64) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x022f, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0230, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r1);
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014f A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0163 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a0 A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01aa A[Catch: all -> 0x0250, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:16:0x0064, B:17:0x006a, B:20:0x0073, B:23:0x007c, B:26:0x0085, B:27:0x0091, B:30:0x00a0, B:31:0x00a6, B:33:0x00d1, B:35:0x00de, B:36:0x00f3, B:38:0x00fd, B:40:0x0103, B:41:0x011b, B:43:0x0121, B:44:0x0127, B:46:0x014f, B:47:0x0159, B:49:0x0163, B:50:0x016d, B:52:0x01a0, B:53:0x01a4, B:55:0x01aa, B:57:0x01b8, B:59:0x01da, B:60:0x01f4, B:69:0x023b, B:67:0x0230), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0236  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized k a(Context context, String str, String str2, String str3) {
        String str4;
        String c;
        String b;
        int a2;
        String n;
        String a3;
        String f;
        k kVar = null;
        synchronized (l.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", com.xiaomi.push.i.a(context, false));
            treeMap.put("devid1", com.xiaomi.push.i.a(context));
            if (a != null && !TextUtils.isEmpty(a.f916a)) {
                treeMap.put("uuid", a.f916a);
                int lastIndexOf = a.f916a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = a.f916a.substring(lastIndexOf + 1);
                    c = com.xiaomi.push.i.c(context);
                    if (c != null) {
                        treeMap.put("vdevid", c);
                    }
                    b = com.xiaomi.push.i.b(context);
                    if (!TextUtils.isEmpty(b)) {
                        treeMap.put("gaid", b);
                    }
                    String str5 = !m546a(context) ? "1000271" : str2;
                    String str6 = !m546a(context) ? "420100086271" : str3;
                    String str7 = !m546a(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str5);
                    treeMap.put("apptoken", str6);
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str7, 16384);
                    treeMap.put(ETAG.KEY_APP_VERSION, packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(30619));
                    treeMap.put("packagename", str7);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put("board", Build.BOARD);
                    if (!com.xiaomi.push.l.d()) {
                        String str8 = TextUtils.isEmpty(com.xiaomi.push.i.f(context)) ? "" : "" + com.xiaomi.push.ay.a(f);
                        String h = com.xiaomi.push.i.h(context);
                        if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(h)) {
                            str8 = str8 + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str8);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
                    a2 = com.xiaomi.push.i.a();
                    if (a2 >= 0) {
                        treeMap.put("space_id", Integer.toString(a2));
                    }
                    n = com.xiaomi.push.i.n(context);
                    if (!TextUtils.isEmpty(n)) {
                        treeMap.put("mac_address", com.xiaomi.push.ay.a(n));
                    }
                    treeMap.put("android_id", com.xiaomi.push.i.e(context));
                    treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
                    com.xiaomi.push.aq a4 = com.xiaomi.push.as.a(context, m544a(context), treeMap);
                    a3 = a4 != null ? a4.a() : "";
                    if (!TextUtils.isEmpty(a3)) {
                        JSONObject jSONObject = new JSONObject(a3);
                        if (jSONObject.getInt("code") == 0) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            kVar = new k(jSONObject2.getString(TbEnum.SystemMessage.KEY_USER_ID) + "@xiaomi.com/" + (TextUtils.isEmpty(str4) ? "an" + com.xiaomi.push.ay.a(6) : str4), jSONObject2.getString("token"), jSONObject2.getString("ssecurity"), str5, str6, str7, com.xiaomi.push.ab.a());
                            a(context, kVar);
                            com.xiaomi.push.i.a(context, jSONObject2.optString("vdevid"));
                            a = kVar;
                        } else {
                            o.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                            com.xiaomi.channel.commonutils.logger.b.m47a(a3);
                        }
                    }
                }
            }
            str4 = null;
            c = com.xiaomi.push.i.c(context);
            if (c != null) {
            }
            b = com.xiaomi.push.i.b(context);
            if (!TextUtils.isEmpty(b)) {
            }
            if (!m546a(context)) {
            }
            if (!m546a(context)) {
            }
            if (!m546a(context)) {
            }
            treeMap.put("appid", str5);
            treeMap.put("apptoken", str6);
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str7, 16384);
            treeMap.put(ETAG.KEY_APP_VERSION, packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(30619));
            treeMap.put("packagename", str7);
            treeMap.put("model", Build.MODEL);
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.l.d()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            a2 = com.xiaomi.push.i.a();
            if (a2 >= 0) {
            }
            n = com.xiaomi.push.i.n(context);
            if (!TextUtils.isEmpty(n)) {
            }
            treeMap.put("android_id", com.xiaomi.push.i.e(context));
            treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
            com.xiaomi.push.aq a42 = com.xiaomi.push.as.a(context, m544a(context), treeMap);
            if (a42 != null) {
            }
            if (!TextUtils.isEmpty(a3)) {
            }
        }
        return kVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m544a(Context context) {
        String a2 = com.xiaomi.push.service.a.a(context).a();
        if (com.xiaomi.push.ab.b()) {
            return "http://" + fn.b + ":9085/pass/v2/register";
        }
        if (com.xiaomi.push.o.China.name().equals(a2)) {
            return "https://cn.register.xmpush.xiaomi.com/pass/v2/register";
        }
        if (com.xiaomi.push.o.Global.name().equals(a2)) {
            return "https://register.xmpush.global.xiaomi.com/pass/v2/register";
        }
        if (com.xiaomi.push.o.Europe.name().equals(a2)) {
            return "https://fr.register.xmpush.global.xiaomi.com/pass/v2/register";
        }
        if (com.xiaomi.push.o.Russia.name().equals(a2)) {
            return "https://ru.register.xmpush.global.xiaomi.com/pass/v2/register";
        }
        if (com.xiaomi.push.o.India.name().equals(a2)) {
            return "https://idmb.register.xmpush.global.xiaomi.com/pass/v2/register";
        }
        return SapiUtils.COOKIE_HTTPS_URL_PREFIX + (com.xiaomi.push.ab.m124a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com") + "/pass/v2/register";
    }

    public static void a() {
        if (f917a != null) {
            f917a.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m545a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    public static void a(Context context, k kVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", kVar.f916a);
        edit.putString("security", kVar.c);
        edit.putString("token", kVar.b);
        edit.putString(Constants.APP_ID, kVar.d);
        edit.putString("package_name", kVar.f);
        edit.putString("app_token", kVar.e);
        edit.putString(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, com.xiaomi.push.i.k(context));
        edit.putInt("env_type", kVar.a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f917a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m546a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
