package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.coremedia.iso.boxes.UserBox;
import com.xiaomi.mipush.sdk.Constants;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class t {
    private static s a;
    private static a b;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public static synchronized s a(Context context) {
        s sVar = null;
        synchronized (t.class) {
            if (a != null) {
                sVar = a;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                String string = sharedPreferences.getString(UserBox.TYPE, null);
                String string2 = sharedPreferences.getString("token", null);
                String string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString(Constants.APP_ID, null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString(Constants.PACKAGE_NAME, null);
                String string7 = sharedPreferences.getString("device_id", null);
                int i = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && string7.startsWith("a-")) {
                    string7 = com.xiaomi.channel.commonutils.android.d.k(context);
                    sharedPreferences.edit().putString("device_id", string7).commit();
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                    String k = com.xiaomi.channel.commonutils.android.d.k(context);
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) || TextUtils.isEmpty(k) || TextUtils.isEmpty(string7) || string7.equals(k)) {
                        a = new s(string, string2, string3, string4, string5, string6, i);
                        sVar = a;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.d("erase the old account.");
                        c(context);
                    }
                }
            }
        }
        return sVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:3|4|(2:8|(25:10|11|(1:13)|14|(1:16)(1:70)|17|(1:19)(1:69)|20|(1:22)(1:68)|23|24|25|26|(1:28)(1:64)|29|(6:31|(1:33)|34|(1:38)|39|(1:41))|42|(1:44)|45|(1:47)|48|(1:50)|51|(2:53|(3:55|(1:57)(1:59)|58)(1:60))|61))|71|11|(0)|14|(0)(0)|17|(0)(0)|20|(0)(0)|23|24|25|26|(0)(0)|29|(0)|42|(0)|45|(0)|48|(0)|51|(0)|61) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x021f, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0220, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r1);
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:17:0x0063, B:20:0x006c, B:23:0x0075, B:24:0x0081, B:27:0x0090, B:28:0x0096, B:30:0x00c1, B:32:0x00ce, B:33:0x00e3, B:35:0x00ed, B:37:0x00f3, B:38:0x010b, B:40:0x0111, B:41:0x0117, B:43:0x013f, B:44:0x0149, B:46:0x0153, B:47:0x015d, B:49:0x0190, B:50:0x0194, B:52:0x019a, B:54:0x01a8, B:56:0x01ca, B:57:0x01e4, B:66:0x022b, B:64:0x0220), top: B:73:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090 A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:17:0x0063, B:20:0x006c, B:23:0x0075, B:24:0x0081, B:27:0x0090, B:28:0x0096, B:30:0x00c1, B:32:0x00ce, B:33:0x00e3, B:35:0x00ed, B:37:0x00f3, B:38:0x010b, B:40:0x0111, B:41:0x0117, B:43:0x013f, B:44:0x0149, B:46:0x0153, B:47:0x015d, B:49:0x0190, B:50:0x0194, B:52:0x019a, B:54:0x01a8, B:56:0x01ca, B:57:0x01e4, B:66:0x022b, B:64:0x0220), top: B:73:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:17:0x0063, B:20:0x006c, B:23:0x0075, B:24:0x0081, B:27:0x0090, B:28:0x0096, B:30:0x00c1, B:32:0x00ce, B:33:0x00e3, B:35:0x00ed, B:37:0x00f3, B:38:0x010b, B:40:0x0111, B:41:0x0117, B:43:0x013f, B:44:0x0149, B:46:0x0153, B:47:0x015d, B:49:0x0190, B:50:0x0194, B:52:0x019a, B:54:0x01a8, B:56:0x01ca, B:57:0x01e4, B:66:0x022b, B:64:0x0220), top: B:73:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013f A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:17:0x0063, B:20:0x006c, B:23:0x0075, B:24:0x0081, B:27:0x0090, B:28:0x0096, B:30:0x00c1, B:32:0x00ce, B:33:0x00e3, B:35:0x00ed, B:37:0x00f3, B:38:0x010b, B:40:0x0111, B:41:0x0117, B:43:0x013f, B:44:0x0149, B:46:0x0153, B:47:0x015d, B:49:0x0190, B:50:0x0194, B:52:0x019a, B:54:0x01a8, B:56:0x01ca, B:57:0x01e4, B:66:0x022b, B:64:0x0220), top: B:73:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0153 A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:17:0x0063, B:20:0x006c, B:23:0x0075, B:24:0x0081, B:27:0x0090, B:28:0x0096, B:30:0x00c1, B:32:0x00ce, B:33:0x00e3, B:35:0x00ed, B:37:0x00f3, B:38:0x010b, B:40:0x0111, B:41:0x0117, B:43:0x013f, B:44:0x0149, B:46:0x0153, B:47:0x015d, B:49:0x0190, B:50:0x0194, B:52:0x019a, B:54:0x01a8, B:56:0x01ca, B:57:0x01e4, B:66:0x022b, B:64:0x0220), top: B:73:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0190 A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:17:0x0063, B:20:0x006c, B:23:0x0075, B:24:0x0081, B:27:0x0090, B:28:0x0096, B:30:0x00c1, B:32:0x00ce, B:33:0x00e3, B:35:0x00ed, B:37:0x00f3, B:38:0x010b, B:40:0x0111, B:41:0x0117, B:43:0x013f, B:44:0x0149, B:46:0x0153, B:47:0x015d, B:49:0x0190, B:50:0x0194, B:52:0x019a, B:54:0x01a8, B:56:0x01ca, B:57:0x01e4, B:66:0x022b, B:64:0x0220), top: B:73:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019a A[Catch: all -> 0x0240, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0022, B:8:0x002c, B:10:0x0044, B:11:0x004e, B:13:0x0054, B:14:0x005a, B:17:0x0063, B:20:0x006c, B:23:0x0075, B:24:0x0081, B:27:0x0090, B:28:0x0096, B:30:0x00c1, B:32:0x00ce, B:33:0x00e3, B:35:0x00ed, B:37:0x00f3, B:38:0x010b, B:40:0x0111, B:41:0x0117, B:43:0x013f, B:44:0x0149, B:46:0x0153, B:47:0x015d, B:49:0x0190, B:50:0x0194, B:52:0x019a, B:54:0x01a8, B:56:0x01ca, B:57:0x01e4, B:66:0x022b, B:64:0x0220), top: B:73:0x0004, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized s a(Context context, String str, String str2, String str3) {
        String str4;
        String b2;
        int b3;
        String m;
        String a2;
        String e;
        s sVar = null;
        synchronized (t.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", com.xiaomi.channel.commonutils.android.d.a(context, false));
            treeMap.put("devid1", com.xiaomi.channel.commonutils.android.d.a(context));
            if (a != null && !TextUtils.isEmpty(a.a)) {
                treeMap.put(UserBox.TYPE, a.a);
                int lastIndexOf = a.a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = a.a.substring(lastIndexOf + 1);
                    b2 = com.xiaomi.channel.commonutils.android.d.b(context);
                    if (b2 != null) {
                        treeMap.put("vdevid", b2);
                    }
                    String str5 = !d(context) ? "1000271" : str2;
                    String str6 = !d(context) ? "420100086271" : str3;
                    String str7 = !d(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str5);
                    treeMap.put("apptoken", str6);
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str7, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(30609));
                    treeMap.put("packagename", str7);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put("board", Build.BOARD);
                    if (!com.xiaomi.channel.commonutils.android.f.g()) {
                        String str8 = TextUtils.isEmpty(com.xiaomi.channel.commonutils.android.d.e(context)) ? "" : "" + com.xiaomi.channel.commonutils.string.d.a(e);
                        String g = com.xiaomi.channel.commonutils.android.d.g(context);
                        if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(g)) {
                            str8 = str8 + Constants.ACCEPT_TIME_SEPARATOR_SP + g;
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str8);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
                    b3 = com.xiaomi.channel.commonutils.android.d.b();
                    if (b3 >= 0) {
                        treeMap.put("space_id", Integer.toString(b3));
                    }
                    m = com.xiaomi.channel.commonutils.android.d.m(context);
                    if (!TextUtils.isEmpty(m)) {
                        treeMap.put("mac_address", com.xiaomi.channel.commonutils.string.d.a(m));
                    }
                    treeMap.put("android_id", com.xiaomi.channel.commonutils.android.d.d(context));
                    treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
                    com.xiaomi.channel.commonutils.network.b a3 = com.xiaomi.channel.commonutils.network.d.a(context, b(context), treeMap);
                    a2 = a3 != null ? a3.a() : "";
                    if (!TextUtils.isEmpty(a2)) {
                        JSONObject jSONObject = new JSONObject(a2);
                        if (jSONObject.getInt("code") == 0) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            sVar = new s(jSONObject2.getString("userId") + "@xiaomi.com/" + (TextUtils.isEmpty(str4) ? "an" + com.xiaomi.channel.commonutils.string.d.a(6) : str4), jSONObject2.getString("token"), jSONObject2.getString("ssecurity"), str5, str6, str7, com.xiaomi.channel.commonutils.misc.a.c());
                            a(context, sVar);
                            com.xiaomi.channel.commonutils.android.d.a(context, jSONObject2.optString("vdevid"));
                            a = sVar;
                        } else {
                            w.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                            com.xiaomi.channel.commonutils.logger.b.a(a2);
                        }
                    }
                }
            }
            str4 = null;
            b2 = com.xiaomi.channel.commonutils.android.d.b(context);
            if (b2 != null) {
            }
            if (!d(context)) {
            }
            if (!d(context)) {
            }
            if (!d(context)) {
            }
            treeMap.put("appid", str5);
            treeMap.put("apptoken", str6);
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str7, 16384);
            treeMap.put("appversion", packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(30609));
            treeMap.put("packagename", str7);
            treeMap.put("model", Build.MODEL);
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.channel.commonutils.android.f.g()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            b3 = com.xiaomi.channel.commonutils.android.d.b();
            if (b3 >= 0) {
            }
            m = com.xiaomi.channel.commonutils.android.d.m(context);
            if (!TextUtils.isEmpty(m)) {
            }
            treeMap.put("android_id", com.xiaomi.channel.commonutils.android.d.d(context));
            treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
            com.xiaomi.channel.commonutils.network.b a32 = com.xiaomi.channel.commonutils.network.d.a(context, b(context), treeMap);
            if (a32 != null) {
            }
            if (!TextUtils.isEmpty(a2)) {
            }
        }
        return sVar;
    }

    public static void a() {
        if (b != null) {
            b.a();
        }
    }

    public static void a(Context context, s sVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString(UserBox.TYPE, sVar.a);
        edit.putString("security", sVar.c);
        edit.putString("token", sVar.b);
        edit.putString(Constants.APP_ID, sVar.d);
        edit.putString(Constants.PACKAGE_NAME, sVar.f);
        edit.putString("app_token", sVar.e);
        edit.putString("device_id", com.xiaomi.channel.commonutils.android.d.k(context));
        edit.putInt("env_type", sVar.g);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        b = aVar;
    }

    public static String b(Context context) {
        String a2 = com.xiaomi.push.service.a.a(context).a();
        if (com.xiaomi.channel.commonutils.misc.a.b()) {
            return "http://" + com.xiaomi.smack.b.c + ":9085/pass/v2/register";
        }
        if (com.xiaomi.channel.commonutils.android.i.Global.name().equals(a2)) {
            return "https://register.xmpush.global.xiaomi.com/pass/v2/register";
        }
        if (com.xiaomi.channel.commonutils.android.i.Europe.name().equals(a2)) {
            return "https://fr.register.xmpush.global.xiaomi.com/pass/v2/register";
        }
        if (com.xiaomi.channel.commonutils.android.i.Russia.name().equals(a2)) {
            return "https://ru.register.xmpush.global.xiaomi.com/pass/v2/register";
        }
        return "https://" + (com.xiaomi.channel.commonutils.misc.a.a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com") + "/pass/v2/register";
    }

    public static void c(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    private static boolean d(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
