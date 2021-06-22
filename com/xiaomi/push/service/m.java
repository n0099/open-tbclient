package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.fm;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static l f41936a;

    /* renamed from: a  reason: collision with other field name */
    public static a f960a;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public static synchronized l a(Context context) {
        synchronized (m.class) {
            if (f41936a != null) {
                return f41936a;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString(Constants.APP_ID, null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, null);
            int i2 = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.m424a(string7)) {
                string7 = com.xiaomi.push.i.k(context);
                sharedPreferences.edit().putString(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String k = com.xiaomi.push.i.k(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(k) && !TextUtils.isEmpty(string7) && !string7.equals(k)) {
                com.xiaomi.channel.commonutils.logger.b.m56a("read_phone_state permission changes.");
            }
            l lVar = new l(string, string2, string3, string4, string5, string6, i2);
            f41936a = lVar;
            return lVar;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:3|4|(2:8|(26:10|11|(1:13)|14|(1:16)|17|(1:19)|20|(1:22)|23|(1:25)|26|27|28|29|(1:31)(1:65)|32|(6:34|(1:36)|37|(1:41)|42|(1:44))|45|(1:47)|48|(1:50)|51|(2:53|(5:55|(1:57)|58|59|60)(1:62))|63|64))|69|11|(0)|14|(0)|17|(0)|20|(0)|23|(0)|26|27|28|29|(0)(0)|32|(0)|45|(0)|48|(0)|51|(0)|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bc, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bd, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r10);
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: all -> 0x0232, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x003b, B:8:0x0045, B:10:0x005b, B:12:0x0067, B:14:0x0078, B:15:0x007d, B:17:0x0087, B:18:0x008c, B:21:0x0094, B:24:0x009d, B:27:0x00a6, B:28:0x00b1, B:34:0x00c5, B:36:0x00ce, B:38:0x00f5, B:40:0x0101, B:41:0x0114, B:43:0x011e, B:45:0x0124, B:46:0x0138, B:48:0x013e, B:49:0x0143, B:51:0x0166, B:52:0x016f, B:54:0x01a5, B:55:0x01a9, B:57:0x01af, B:59:0x01bc, B:61:0x01da, B:62:0x01f0, B:65:0x021e, B:31:0x00bd), top: B:71:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087 A[Catch: all -> 0x0232, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x003b, B:8:0x0045, B:10:0x005b, B:12:0x0067, B:14:0x0078, B:15:0x007d, B:17:0x0087, B:18:0x008c, B:21:0x0094, B:24:0x009d, B:27:0x00a6, B:28:0x00b1, B:34:0x00c5, B:36:0x00ce, B:38:0x00f5, B:40:0x0101, B:41:0x0114, B:43:0x011e, B:45:0x0124, B:46:0x0138, B:48:0x013e, B:49:0x0143, B:51:0x0166, B:52:0x016f, B:54:0x01a5, B:55:0x01a9, B:57:0x01af, B:59:0x01bc, B:61:0x01da, B:62:0x01f0, B:65:0x021e, B:31:0x00bd), top: B:71:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5 A[Catch: all -> 0x0232, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x003b, B:8:0x0045, B:10:0x005b, B:12:0x0067, B:14:0x0078, B:15:0x007d, B:17:0x0087, B:18:0x008c, B:21:0x0094, B:24:0x009d, B:27:0x00a6, B:28:0x00b1, B:34:0x00c5, B:36:0x00ce, B:38:0x00f5, B:40:0x0101, B:41:0x0114, B:43:0x011e, B:45:0x0124, B:46:0x0138, B:48:0x013e, B:49:0x0143, B:51:0x0166, B:52:0x016f, B:54:0x01a5, B:55:0x01a9, B:57:0x01af, B:59:0x01bc, B:61:0x01da, B:62:0x01f0, B:65:0x021e, B:31:0x00bd), top: B:71:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5 A[Catch: all -> 0x0232, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x003b, B:8:0x0045, B:10:0x005b, B:12:0x0067, B:14:0x0078, B:15:0x007d, B:17:0x0087, B:18:0x008c, B:21:0x0094, B:24:0x009d, B:27:0x00a6, B:28:0x00b1, B:34:0x00c5, B:36:0x00ce, B:38:0x00f5, B:40:0x0101, B:41:0x0114, B:43:0x011e, B:45:0x0124, B:46:0x0138, B:48:0x013e, B:49:0x0143, B:51:0x0166, B:52:0x016f, B:54:0x01a5, B:55:0x01a9, B:57:0x01af, B:59:0x01bc, B:61:0x01da, B:62:0x01f0, B:65:0x021e, B:31:0x00bd), top: B:71:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0166 A[Catch: all -> 0x0232, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x003b, B:8:0x0045, B:10:0x005b, B:12:0x0067, B:14:0x0078, B:15:0x007d, B:17:0x0087, B:18:0x008c, B:21:0x0094, B:24:0x009d, B:27:0x00a6, B:28:0x00b1, B:34:0x00c5, B:36:0x00ce, B:38:0x00f5, B:40:0x0101, B:41:0x0114, B:43:0x011e, B:45:0x0124, B:46:0x0138, B:48:0x013e, B:49:0x0143, B:51:0x0166, B:52:0x016f, B:54:0x01a5, B:55:0x01a9, B:57:0x01af, B:59:0x01bc, B:61:0x01da, B:62:0x01f0, B:65:0x021e, B:31:0x00bd), top: B:71:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a5 A[Catch: all -> 0x0232, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x003b, B:8:0x0045, B:10:0x005b, B:12:0x0067, B:14:0x0078, B:15:0x007d, B:17:0x0087, B:18:0x008c, B:21:0x0094, B:24:0x009d, B:27:0x00a6, B:28:0x00b1, B:34:0x00c5, B:36:0x00ce, B:38:0x00f5, B:40:0x0101, B:41:0x0114, B:43:0x011e, B:45:0x0124, B:46:0x0138, B:48:0x013e, B:49:0x0143, B:51:0x0166, B:52:0x016f, B:54:0x01a5, B:55:0x01a9, B:57:0x01af, B:59:0x01bc, B:61:0x01da, B:62:0x01f0, B:65:0x021e, B:31:0x00bd), top: B:71:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01af A[Catch: all -> 0x0232, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x003b, B:8:0x0045, B:10:0x005b, B:12:0x0067, B:14:0x0078, B:15:0x007d, B:17:0x0087, B:18:0x008c, B:21:0x0094, B:24:0x009d, B:27:0x00a6, B:28:0x00b1, B:34:0x00c5, B:36:0x00ce, B:38:0x00f5, B:40:0x0101, B:41:0x0114, B:43:0x011e, B:45:0x0124, B:46:0x0138, B:48:0x013e, B:49:0x0143, B:51:0x0166, B:52:0x016f, B:54:0x01a5, B:55:0x01a9, B:57:0x01af, B:59:0x01bc, B:61:0x01da, B:62:0x01f0, B:65:0x021e, B:31:0x00bd), top: B:71:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized l a(Context context, String str, String str2, String str3) {
        String str4;
        String b2;
        String a2;
        int a3;
        String a4;
        String f2;
        synchronized (m.class) {
            TreeMap treeMap = new TreeMap();
            String a5 = com.xiaomi.push.i.a(context, false);
            com.xiaomi.channel.commonutils.logger.b.m56a("account register:" + a5 + " mim:" + com.xiaomi.push.ax.a(context).e());
            treeMap.put("devid", a5);
            if (f41936a != null && !TextUtils.isEmpty(f41936a.f959a)) {
                treeMap.put("uuid", f41936a.f959a);
                int lastIndexOf = f41936a.f959a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = f41936a.f959a.substring(lastIndexOf + 1);
                    com.xiaomi.push.ax.a(context).a(treeMap);
                    b2 = com.xiaomi.push.i.b(context);
                    if (!TextUtils.isEmpty(b2)) {
                        treeMap.put("vdevid", b2);
                    }
                    a2 = com.xiaomi.push.i.a(context);
                    if (!TextUtils.isEmpty(a2)) {
                        treeMap.put("gaid", a2);
                    }
                    if (m618a(context)) {
                        str2 = "1000271";
                    }
                    String str5 = str2;
                    if (m618a(context)) {
                        str3 = "420100086271";
                    }
                    String str6 = str3;
                    if (m618a(context)) {
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
                    treeMap.put("board", Build.BOARD);
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
                    treeMap.put("ram", com.xiaomi.push.i.m421a());
                    treeMap.put(Config.ROM, com.xiaomi.push.i.m425b());
                    com.xiaomi.push.be a6 = com.xiaomi.push.bg.a(context, m616a(context), treeMap);
                    a4 = a6 != null ? a6.a() : "";
                    if (!TextUtils.isEmpty(a4)) {
                        JSONObject jSONObject = new JSONObject(a4);
                        if (jSONObject.getInt("code") == 0) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            String string = jSONObject2.getString("ssecurity");
                            String string2 = jSONObject2.getString("token");
                            String string3 = jSONObject2.getString("userId");
                            if (TextUtils.isEmpty(str4)) {
                                str4 = com.alipay.sdk.sys.a.f1933i + com.xiaomi.push.bm.a(6);
                            }
                            l lVar = new l(string3 + "@xiaomi.com/" + str4, string2, string, str5, str6, str7, com.xiaomi.push.ab.a());
                            a(context, lVar);
                            com.xiaomi.push.i.a(context, jSONObject2.optString("vdevid"));
                            f41936a = lVar;
                            return lVar;
                        }
                        p.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                        com.xiaomi.channel.commonutils.logger.b.m56a(a4);
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
            if (m618a(context)) {
            }
            String str52 = str2;
            if (m618a(context)) {
            }
            String str62 = str3;
            if (m618a(context)) {
            }
            String str72 = str;
            treeMap.put("appid", str52);
            treeMap.put("apptoken", str62);
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str72, 16384);
            treeMap.put("appversion", packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(30805));
            treeMap.put("packagename", str72);
            treeMap.put("model", Build.MODEL);
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.l.d()) {
            }
            treeMap.put(IAdRequestParam.OS, Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            a3 = com.xiaomi.push.i.a();
            if (a3 >= 0) {
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.i.m421a());
            treeMap.put(Config.ROM, com.xiaomi.push.i.m425b());
            com.xiaomi.push.be a62 = com.xiaomi.push.bg.a(context, m616a(context), treeMap);
            if (a62 != null) {
            }
            if (!TextUtils.isEmpty(a4)) {
            }
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m616a(Context context) {
        StringBuilder sb;
        String str;
        String a2 = com.xiaomi.push.service.a.a(context).a();
        if (com.xiaomi.push.ab.b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(fm.f41377b);
            str = ":9085";
        } else if (com.xiaomi.push.o.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (com.xiaomi.push.o.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.o.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.o.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (com.xiaomi.push.o.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            str = com.xiaomi.push.ab.m125a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append("/pass/v2/register");
        return sb.toString();
    }

    public static void a() {
        a aVar = f960a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m617a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f41936a = null;
        a();
    }

    public static void a(Context context, l lVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", lVar.f959a);
        edit.putString("security", lVar.f41932c);
        edit.putString("token", lVar.f41931b);
        edit.putString(Constants.APP_ID, lVar.f41933d);
        edit.putString("package_name", lVar.f41935f);
        edit.putString("app_token", lVar.f41934e);
        edit.putString(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, com.xiaomi.push.i.k(context));
        edit.putInt("env_type", lVar.f41930a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f960a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m618a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
