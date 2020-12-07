package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ft;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static k f4879a;

    /* renamed from: a  reason: collision with other field name */
    private static a f917a;

    /* loaded from: classes18.dex */
    public interface a {
        void a();
    }

    public static synchronized k a(Context context) {
        k kVar = null;
        synchronized (l.class) {
            if (f4879a != null) {
                kVar = f4879a;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                String string = sharedPreferences.getString("uuid", null);
                String string2 = sharedPreferences.getString("token", null);
                String string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString("app_id", null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString("package_name", null);
                String string7 = sharedPreferences.getString("device_id", null);
                int i = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.m384a(string7)) {
                    string7 = com.xiaomi.push.i.k(context);
                    sharedPreferences.edit().putString("device_id", string7).commit();
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                    String k = com.xiaomi.push.i.k(context);
                    if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(string7) && !string7.equals(k)) {
                        com.xiaomi.channel.commonutils.logger.b.m47a("read_phone_state permission changes.");
                    }
                    f4879a = new k(string, string2, string3, string4, string5, string6, i);
                    kVar = f4879a;
                }
            }
        }
        return kVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:3|4|(2:8|(27:10|11|(1:13)|14|(1:16)|17|(1:19)(1:73)|20|(1:22)(1:72)|23|(1:25)(1:71)|26|27|28|29|(1:31)(1:67)|32|(6:34|(1:36)|37|(1:41)|42|(1:44))|45|(1:47)|48|(1:50)|51|(1:53)|54|(2:56|(3:58|(1:60)(1:62)|61)(1:63))|64))|74|11|(0)|14|(0)|17|(0)(0)|20|(0)(0)|23|(0)(0)|26|27|28|29|(0)(0)|32|(0)|45|(0)|48|(0)|51|(0)|54|(0)|64) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0261, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0262, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r1);
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072 A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082 A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00be A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016d A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0181 A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d2 A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01dc A[Catch: all -> 0x0282, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0039, B:8:0x0043, B:10:0x005b, B:11:0x0065, B:13:0x0072, B:14:0x0078, B:16:0x0082, B:17:0x0088, B:20:0x0091, B:23:0x009a, B:26:0x00a3, B:27:0x00af, B:30:0x00be, B:31:0x00c4, B:33:0x00ef, B:35:0x00fc, B:36:0x0111, B:38:0x011b, B:40:0x0121, B:41:0x0139, B:43:0x013f, B:44:0x0145, B:46:0x016d, B:47:0x0177, B:49:0x0181, B:50:0x018b, B:52:0x01d2, B:53:0x01d6, B:55:0x01dc, B:57:0x01ea, B:59:0x020c, B:60:0x0226, B:69:0x026d, B:67:0x0262), top: B:76:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0268  */
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
            String a4 = com.xiaomi.push.i.a(context, false);
            com.xiaomi.channel.commonutils.logger.b.m47a("account register:" + a4);
            treeMap.put("devid", a4);
            treeMap.put("devid1", com.xiaomi.push.i.a(context));
            if (f4879a != null && !TextUtils.isEmpty(f4879a.f916a)) {
                treeMap.put("uuid", f4879a.f916a);
                int lastIndexOf = f4879a.f916a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = f4879a.f916a.substring(lastIndexOf + 1);
                    com.xiaomi.push.au.a(context).a(treeMap);
                    c = com.xiaomi.push.i.c(context);
                    if (c != null) {
                        treeMap.put("vdevid", c);
                    }
                    b = com.xiaomi.push.i.b(context);
                    if (!TextUtils.isEmpty(b)) {
                        treeMap.put("gaid", b);
                    }
                    String str5 = !m572a(context) ? "1000271" : str2;
                    String str6 = !m572a(context) ? "420100086271" : str3;
                    String str7 = !m572a(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str5);
                    treeMap.put("apptoken", str6);
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str7, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(30705));
                    treeMap.put("packagename", str7);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
                    if (!com.xiaomi.push.l.d()) {
                        String str8 = TextUtils.isEmpty(com.xiaomi.push.i.f(context)) ? "" : "" + com.xiaomi.push.bf.a(f);
                        String h = com.xiaomi.push.i.h(context);
                        if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(h)) {
                            str8 = str8 + "," + h;
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
                        treeMap.put("mac_address", com.xiaomi.push.bf.a(n));
                    }
                    treeMap.put("android_id", com.xiaomi.push.i.e(context));
                    treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
                    treeMap.put("ram", com.xiaomi.push.i.m385b());
                    treeMap.put(Config.ROM, com.xiaomi.push.i.m387c());
                    com.xiaomi.push.ax a5 = com.xiaomi.push.az.a(context, m570a(context), treeMap);
                    a3 = a5 != null ? a5.a() : "";
                    if (!TextUtils.isEmpty(a3)) {
                        JSONObject jSONObject = new JSONObject(a3);
                        if (jSONObject.getInt("code") == 0) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            kVar = new k(jSONObject2.getString(TbEnum.SystemMessage.KEY_USER_ID) + "@xiaomi.com/" + (TextUtils.isEmpty(str4) ? "an" + com.xiaomi.push.bf.a(6) : str4), jSONObject2.getString("token"), jSONObject2.getString("ssecurity"), str5, str6, str7, com.xiaomi.push.ab.a());
                            a(context, kVar);
                            com.xiaomi.push.i.a(context, jSONObject2.optString("vdevid"));
                            f4879a = kVar;
                        } else {
                            o.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                            com.xiaomi.channel.commonutils.logger.b.m47a(a3);
                        }
                    }
                }
            }
            str4 = null;
            com.xiaomi.push.au.a(context).a(treeMap);
            c = com.xiaomi.push.i.c(context);
            if (c != null) {
            }
            b = com.xiaomi.push.i.b(context);
            if (!TextUtils.isEmpty(b)) {
            }
            if (!m572a(context)) {
            }
            if (!m572a(context)) {
            }
            if (!m572a(context)) {
            }
            treeMap.put("appid", str5);
            treeMap.put("apptoken", str6);
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str7, 16384);
            treeMap.put("appversion", packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(30705));
            treeMap.put("packagename", str7);
            treeMap.put("model", Build.MODEL);
            treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
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
            treeMap.put("ram", com.xiaomi.push.i.m385b());
            treeMap.put(Config.ROM, com.xiaomi.push.i.m387c());
            com.xiaomi.push.ax a52 = com.xiaomi.push.az.a(context, m570a(context), treeMap);
            if (a52 != null) {
            }
            if (!TextUtils.isEmpty(a3)) {
            }
        }
        return kVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m570a(Context context) {
        String a2 = com.xiaomi.push.service.a.a(context).a();
        if (com.xiaomi.push.ab.b()) {
            return "http://" + ft.b + ":9085/pass/v2/register";
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
        return SapiUtils.COOKIE_HTTPS_URL_PREFIX + (com.xiaomi.push.ab.m118a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com") + "/pass/v2/register";
    }

    public static void a() {
        if (f917a != null) {
            f917a.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m571a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f4879a = null;
        a();
    }

    public static void a(Context context, k kVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", kVar.f916a);
        edit.putString("security", kVar.c);
        edit.putString("token", kVar.b);
        edit.putString("app_id", kVar.d);
        edit.putString("package_name", kVar.f);
        edit.putString("app_token", kVar.e);
        edit.putString("device_id", com.xiaomi.push.i.k(context));
        edit.putInt("env_type", kVar.f4878a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f917a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m572a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
