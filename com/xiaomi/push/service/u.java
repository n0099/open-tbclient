package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.fw;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class u {
    public static t a;

    /* renamed from: a  reason: collision with other field name */
    public static a f1007a;

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    public static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized t m836a(Context context) {
        synchronized (u.class) {
            if (a != null) {
                return a;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.a(string7)) {
                string7 = com.xiaomi.push.i.g(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String g = com.xiaomi.push.i.g(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(g) && !TextUtils.isEmpty(string7) && !string7.equals(g)) {
                com.xiaomi.channel.commonutils.logger.b.m180a("read_phone_state permission changes.");
            }
            t tVar = new t(string, string2, string3, string4, string5, string6, i);
            a = tVar;
            return tVar;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|(2:8|(24:10|11|(1:13)(1:119)|14|(1:16)(1:118)|17|(1:19)(1:117)|20|21|22|23|(1:25)(1:113)|26|(6:28|(1:30)|31|(1:35)|36|(1:38))|39|(1:41)|42|(6:45|46|47|49|50|43)|54|55|(3:60|61|(2:63|64)(9:(1:67)|68|69|(2:73|(4:75|76|77|(7:79|(1:81)|82|83|84|85|86)(6:88|89|(1:93)|94|95|96)))|107|(2:91|93)|94|95|96))|112|61|(0)(0)))|120|11|(0)(0)|14|(0)(0)|17|(0)(0)|20|21|22|23|(0)(0)|26|(0)|39|(0)|42|(1:43)|54|55|(4:57|60|61|(0)(0))|112|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0087, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0314 A[Catch: all -> 0x0329, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:74:0x0212, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:100:0x02f7, B:106:0x0314, B:108:0x031a, B:109:0x0322, B:103:0x02fe, B:28:0x0087), top: B:115:0x0005, inners: #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f A[Catch: all -> 0x0329, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:74:0x0212, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:100:0x02f7, B:106:0x0314, B:108:0x031a, B:109:0x0322, B:103:0x02fe, B:28:0x0087), top: B:115:0x0005, inners: #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[Catch: all -> 0x0329, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:74:0x0212, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:100:0x02f7, B:106:0x0314, B:108:0x031a, B:109:0x0322, B:103:0x02fe, B:28:0x0087), top: B:115:0x0005, inners: #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131 A[Catch: all -> 0x0329, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:74:0x0212, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:100:0x02f7, B:106:0x0314, B:108:0x031a, B:109:0x0322, B:103:0x02fe, B:28:0x0087), top: B:115:0x0005, inners: #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0177 A[Catch: all -> 0x0329, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0131, B:49:0x013a, B:50:0x0171, B:52:0x0177, B:53:0x017e, B:56:0x018d, B:57:0x01be, B:59:0x01de, B:62:0x01e5, B:64:0x01fc, B:70:0x020b, B:74:0x0212, B:76:0x0229, B:78:0x022f, B:99:0x02e6, B:100:0x02f7, B:106:0x0314, B:108:0x031a, B:109:0x0322, B:103:0x02fe, B:28:0x0087), top: B:115:0x0005, inners: #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0206 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized t a(Context context, String str, String str2, String str3) {
        String str4;
        int a2;
        String a3;
        boolean z;
        String a4;
        com.xiaomi.push.bg bgVar;
        boolean z2;
        String str5;
        JSONObject jSONObject;
        String c;
        synchronized (u.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", com.xiaomi.push.i.a(context, false));
            if (a != null && !TextUtils.isEmpty(a.f1006a)) {
                treeMap.put("uuid", a.f1006a);
                int lastIndexOf = a.f1006a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = a.f1006a.substring(lastIndexOf + 1);
                    com.xiaomi.push.az.a(context).a(treeMap);
                    String str6 = !m839a(context) ? "1000271" : str2;
                    String str7 = !m839a(context) ? "420100086271" : str3;
                    String str8 = !m839a(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str6);
                    treeMap.put("apptoken", str7);
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str8, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(50005));
                    treeMap.put("packagename", str8);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
                    if (!com.xiaomi.push.j.m716d()) {
                        String str9 = TextUtils.isEmpty(com.xiaomi.push.i.c(context)) ? "" : "" + com.xiaomi.push.bo.a(c);
                        String e = com.xiaomi.push.i.e(context);
                        if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(e)) {
                            str9 = str9 + "," + e;
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str9);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                    a2 = com.xiaomi.push.i.a();
                    if (a2 >= 0) {
                        treeMap.put("space_id", Integer.toString(a2));
                    }
                    treeMap.put("brand", Build.BRAND + "");
                    treeMap.put("ram", com.xiaomi.push.i.m606a());
                    treeMap.put(Config.ROM, com.xiaomi.push.i.m609b());
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : treeMap.entrySet()) {
                        try {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        } catch (JSONException e2) {
                            com.xiaomi.channel.commonutils.logger.b.d("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e2);
                        }
                    }
                    a3 = bs.a(jSONObject2.toString());
                    TreeMap treeMap2 = new TreeMap();
                    treeMap2.put("requestData", a3);
                    treeMap2.put("keyPairVer", "1");
                    if (a(context) < 2 && !TextUtils.isEmpty(a3)) {
                        com.xiaomi.channel.commonutils.logger.b.m180a("r.data = " + a3);
                        z = true;
                        a4 = a(context, z);
                        if (TextUtils.isEmpty(a4)) {
                            if (z) {
                                treeMap = treeMap2;
                            }
                            try {
                                bgVar = com.xiaomi.push.bi.a(context, a4, treeMap);
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.d("device registration request failed. " + e3);
                                bgVar = null;
                            }
                            if (bgVar != null && bgVar.a == 200) {
                                String a5 = bgVar.a();
                                if (!TextUtils.isEmpty(a5)) {
                                    try {
                                        jSONObject = new JSONObject(a5);
                                        try {
                                        } catch (JSONException e4) {
                                            e = e4;
                                            str5 = "failed to parse respone json data. " + e;
                                            com.xiaomi.channel.commonutils.logger.b.d(str5);
                                            if (z2) {
                                            }
                                            com.xiaomi.channel.commonutils.logger.b.m180a("fail to register push account. meet error.");
                                            return null;
                                        } catch (Throwable th) {
                                            th = th;
                                            str5 = "unknow throwable. " + th;
                                            com.xiaomi.channel.commonutils.logger.b.d(str5);
                                            if (z2) {
                                            }
                                            com.xiaomi.channel.commonutils.logger.b.m180a("fail to register push account. meet error.");
                                            return null;
                                        }
                                    } catch (JSONException e5) {
                                        e = e5;
                                        z2 = z;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = z;
                                    }
                                    if (jSONObject.getInt("code") != 0) {
                                        z2 = z;
                                        x.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                                        com.xiaomi.channel.commonutils.logger.b.m180a("device registration resp: " + a5);
                                        if (z2 && com.xiaomi.push.bi.c(context)) {
                                            a(context, a(context) + 1);
                                        }
                                        com.xiaomi.channel.commonutils.logger.b.m180a("fail to register push account. meet error.");
                                        return null;
                                    }
                                    JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                                    String string = jSONObject3.getString("ssecurity");
                                    String string2 = jSONObject3.getString("token");
                                    String string3 = jSONObject3.getString("userId");
                                    if (TextUtils.isEmpty(str4)) {
                                        str4 = "an" + com.xiaomi.push.bo.a(6);
                                    }
                                    t tVar = new t(string3 + "@xiaomi.com/" + str4, string2, string, str6, str7, str8, com.xiaomi.push.ab.a());
                                    a(context, tVar);
                                    a = tVar;
                                    a(context, 0);
                                    com.xiaomi.channel.commonutils.logger.b.m180a("device registration is successful. " + string3);
                                    return tVar;
                                }
                            }
                            z2 = z;
                            if (z2) {
                                a(context, a(context) + 1);
                            }
                            com.xiaomi.channel.commonutils.logger.b.m180a("fail to register push account. meet error.");
                            return null;
                        }
                        return null;
                    }
                    z = false;
                    a4 = a(context, z);
                    if (TextUtils.isEmpty(a4)) {
                    }
                }
            }
            str4 = null;
            com.xiaomi.push.az.a(context).a(treeMap);
            if (!m839a(context)) {
            }
            if (!m839a(context)) {
            }
            if (!m839a(context)) {
            }
            treeMap.put("appid", str6);
            treeMap.put("apptoken", str7);
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str8, 16384);
            treeMap.put("appversion", packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(50005));
            treeMap.put("packagename", str8);
            treeMap.put("model", Build.MODEL);
            treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
            if (!com.xiaomi.push.j.m716d()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            a2 = com.xiaomi.push.i.a();
            if (a2 >= 0) {
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.i.m606a());
            treeMap.put(Config.ROM, com.xiaomi.push.i.m609b());
            JSONObject jSONObject22 = new JSONObject();
            while (r9.hasNext()) {
            }
            a3 = bs.a(jSONObject22.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put("requestData", a3);
            treeMap22.put("keyPairVer", "1");
            if (a(context) < 2) {
                com.xiaomi.channel.commonutils.logger.b.m180a("r.data = " + a3);
                z = true;
                a4 = a(context, z);
                if (TextUtils.isEmpty(a4)) {
                }
            }
            z = false;
            a4 = a(context, z);
            if (TextUtils.isEmpty(a4)) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m837a(Context context) {
        t m836a = m836a(context);
        if (m836a != null && !TextUtils.isEmpty(m836a.f1006a)) {
            String[] split = m836a.f1006a.split("@");
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }

    public static String a(Context context, boolean z) {
        StringBuilder sb;
        String str;
        String a2 = com.xiaomi.push.service.a.a(context).a();
        String str2 = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.ab.b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(fw.b);
            str = ":9085";
        } else if (!com.xiaomi.push.n.China.name().equals(a2)) {
            return null;
        } else {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void a() {
        a aVar = f1007a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m838a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    public static void a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    public static void a(Context context, t tVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", tVar.f1006a);
        edit.putString("security", tVar.c);
        edit.putString("token", tVar.b);
        edit.putString("app_id", tVar.d);
        edit.putString("package_name", tVar.f);
        edit.putString("app_token", tVar.e);
        edit.putString("device_id", com.xiaomi.push.i.g(context));
        edit.putInt("env_type", tVar.a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f1007a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m839a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
