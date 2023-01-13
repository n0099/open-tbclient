package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.fx;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public static t a;

    /* renamed from: a  reason: collision with other field name */
    public static a f1029a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0) : invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized t m754a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
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
                if (!TextUtils.isEmpty(string7) && com.xiaomi.push.j.a(string7)) {
                    string7 = com.xiaomi.push.j.i(context);
                    sharedPreferences.edit().putString("device_id", string7).commit();
                }
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                    return null;
                }
                String i2 = com.xiaomi.push.j.i(context);
                if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(i2) && !TextUtils.isEmpty(string7) && !string7.equals(i2)) {
                    com.xiaomi.channel.commonutils.logger.b.m103a("read_phone_state permission changes.");
                }
                t tVar = new t(string, string2, string3, string4, string5, string6, i);
                a = tVar;
                return tVar;
            }
        }
        return (t) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(37:5|6|(2:10|(34:12|13|(1:15)|16|(1:18)(1:121)|19|(1:21)(1:120)|22|(1:24)(1:119)|25|26|27|28|(1:30)(1:115)|31|(6:33|(1:35)|36|(1:40)|41|(1:43))|44|(1:46)|47|(6:50|51|52|54|55|48)|59|60|(11:65|66|(1:68)|69|70|(2:74|(4:76|77|78|(7:80|(1:82)|83|84|85|86|87)(6:90|91|(1:95)|96|97|98)))|109|(2:93|95)|96|97|98)|114|66|(0)|69|70|(3:72|74|(0))|109|(0)|96|97|98))|122|13|(0)|16|(0)(0)|19|(0)(0)|22|(0)(0)|25|26|27|28|(0)(0)|31|(0)|44|(0)|47|(1:48)|59|60|(12:62|65|66|(0)|69|70|(0)|109|(0)|96|97|98)|114|66|(0)|69|70|(0)|109|(0)|96|97|98) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009a, code lost:
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x021b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x021d, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("device registration request failed. " + r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x031f A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x001e, B:10:0x0028, B:12:0x003e, B:14:0x004a, B:16:0x005b, B:17:0x0060, B:21:0x006c, B:25:0x0078, B:29:0x0084, B:30:0x008e, B:36:0x00a2, B:38:0x00ab, B:40:0x00d3, B:42:0x00df, B:43:0x00f2, B:45:0x00fc, B:47:0x0102, B:48:0x0116, B:50:0x011c, B:51:0x0121, B:53:0x0144, B:54:0x014d, B:55:0x0184, B:57:0x018a, B:58:0x0191, B:61:0x01a0, B:62:0x01d1, B:64:0x01f1, B:67:0x01f8, B:69:0x020f, B:72:0x0216, B:76:0x021d, B:78:0x0234, B:80:0x023a, B:101:0x02f1, B:102:0x0302, B:108:0x031f, B:110:0x0325, B:111:0x032d, B:105:0x0309, B:33:0x009a), top: B:121:0x0009, inners: #2, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0244 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x001e, B:10:0x0028, B:12:0x003e, B:14:0x004a, B:16:0x005b, B:17:0x0060, B:21:0x006c, B:25:0x0078, B:29:0x0084, B:30:0x008e, B:36:0x00a2, B:38:0x00ab, B:40:0x00d3, B:42:0x00df, B:43:0x00f2, B:45:0x00fc, B:47:0x0102, B:48:0x0116, B:50:0x011c, B:51:0x0121, B:53:0x0144, B:54:0x014d, B:55:0x0184, B:57:0x018a, B:58:0x0191, B:61:0x01a0, B:62:0x01d1, B:64:0x01f1, B:67:0x01f8, B:69:0x020f, B:72:0x0216, B:76:0x021d, B:78:0x0234, B:80:0x023a, B:101:0x02f1, B:102:0x0302, B:108:0x031f, B:110:0x0325, B:111:0x032d, B:105:0x0309, B:33:0x009a), top: B:121:0x0009, inners: #2, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x001e, B:10:0x0028, B:12:0x003e, B:14:0x004a, B:16:0x005b, B:17:0x0060, B:21:0x006c, B:25:0x0078, B:29:0x0084, B:30:0x008e, B:36:0x00a2, B:38:0x00ab, B:40:0x00d3, B:42:0x00df, B:43:0x00f2, B:45:0x00fc, B:47:0x0102, B:48:0x0116, B:50:0x011c, B:51:0x0121, B:53:0x0144, B:54:0x014d, B:55:0x0184, B:57:0x018a, B:58:0x0191, B:61:0x01a0, B:62:0x01d1, B:64:0x01f1, B:67:0x01f8, B:69:0x020f, B:72:0x0216, B:76:0x021d, B:78:0x0234, B:80:0x023a, B:101:0x02f1, B:102:0x0302, B:108:0x031f, B:110:0x0325, B:111:0x032d, B:105:0x0309, B:33:0x009a), top: B:121:0x0009, inners: #2, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3 A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x001e, B:10:0x0028, B:12:0x003e, B:14:0x004a, B:16:0x005b, B:17:0x0060, B:21:0x006c, B:25:0x0078, B:29:0x0084, B:30:0x008e, B:36:0x00a2, B:38:0x00ab, B:40:0x00d3, B:42:0x00df, B:43:0x00f2, B:45:0x00fc, B:47:0x0102, B:48:0x0116, B:50:0x011c, B:51:0x0121, B:53:0x0144, B:54:0x014d, B:55:0x0184, B:57:0x018a, B:58:0x0191, B:61:0x01a0, B:62:0x01d1, B:64:0x01f1, B:67:0x01f8, B:69:0x020f, B:72:0x0216, B:76:0x021d, B:78:0x0234, B:80:0x023a, B:101:0x02f1, B:102:0x0302, B:108:0x031f, B:110:0x0325, B:111:0x032d, B:105:0x0309, B:33:0x009a), top: B:121:0x0009, inners: #2, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0144 A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x001e, B:10:0x0028, B:12:0x003e, B:14:0x004a, B:16:0x005b, B:17:0x0060, B:21:0x006c, B:25:0x0078, B:29:0x0084, B:30:0x008e, B:36:0x00a2, B:38:0x00ab, B:40:0x00d3, B:42:0x00df, B:43:0x00f2, B:45:0x00fc, B:47:0x0102, B:48:0x0116, B:50:0x011c, B:51:0x0121, B:53:0x0144, B:54:0x014d, B:55:0x0184, B:57:0x018a, B:58:0x0191, B:61:0x01a0, B:62:0x01d1, B:64:0x01f1, B:67:0x01f8, B:69:0x020f, B:72:0x0216, B:76:0x021d, B:78:0x0234, B:80:0x023a, B:101:0x02f1, B:102:0x0302, B:108:0x031f, B:110:0x0325, B:111:0x032d, B:105:0x0309, B:33:0x009a), top: B:121:0x0009, inners: #2, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018a A[Catch: all -> 0x0334, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x001e, B:10:0x0028, B:12:0x003e, B:14:0x004a, B:16:0x005b, B:17:0x0060, B:21:0x006c, B:25:0x0078, B:29:0x0084, B:30:0x008e, B:36:0x00a2, B:38:0x00ab, B:40:0x00d3, B:42:0x00df, B:43:0x00f2, B:45:0x00fc, B:47:0x0102, B:48:0x0116, B:50:0x011c, B:51:0x0121, B:53:0x0144, B:54:0x014d, B:55:0x0184, B:57:0x018a, B:58:0x0191, B:61:0x01a0, B:62:0x01d1, B:64:0x01f1, B:67:0x01f8, B:69:0x020f, B:72:0x0216, B:76:0x021d, B:78:0x0234, B:80:0x023a, B:101:0x02f1, B:102:0x0302, B:108:0x031f, B:110:0x0325, B:111:0x032d, B:105:0x0309, B:33:0x009a), top: B:121:0x0009, inners: #2, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0234 A[Catch: all -> 0x0334, TryCatch #0 {, blocks: (B:6:0x0009, B:8:0x001e, B:10:0x0028, B:12:0x003e, B:14:0x004a, B:16:0x005b, B:17:0x0060, B:21:0x006c, B:25:0x0078, B:29:0x0084, B:30:0x008e, B:36:0x00a2, B:38:0x00ab, B:40:0x00d3, B:42:0x00df, B:43:0x00f2, B:45:0x00fc, B:47:0x0102, B:48:0x0116, B:50:0x011c, B:51:0x0121, B:53:0x0144, B:54:0x014d, B:55:0x0184, B:57:0x018a, B:58:0x0191, B:61:0x01a0, B:62:0x01d1, B:64:0x01f1, B:67:0x01f8, B:69:0x020f, B:72:0x0216, B:76:0x021d, B:78:0x0234, B:80:0x023a, B:101:0x02f1, B:102:0x0302, B:108:0x031f, B:110:0x0325, B:111:0x032d, B:105:0x0309, B:33:0x009a), top: B:121:0x0009, inners: #2, #6, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized t a(Context context, String str, String str2, String str3) {
        boolean z;
        String str4;
        String a2;
        int a3;
        String a4;
        boolean z2;
        com.xiaomi.push.bh bhVar;
        String a5;
        String str5;
        JSONObject jSONObject;
        String d;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            z = false;
            InterceptResult invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, str3);
            if (invokeLLLL != null) {
                return (t) invokeLLLL.objValue;
            }
        }
        synchronized (u.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", com.xiaomi.push.j.a(context, false));
            if (a != null && !TextUtils.isEmpty(a.f1028a)) {
                treeMap.put("uuid", a.f1028a);
                int lastIndexOf = a.f1028a.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str4 = a.f1028a.substring(lastIndexOf + 1);
                    com.xiaomi.push.ba.a(context).a(treeMap);
                    a2 = com.xiaomi.push.j.a(context);
                    if (!TextUtils.isEmpty(a2)) {
                        treeMap.put(Config.GAID, a2);
                    }
                    String str6 = !m757a(context) ? "1000271" : str2;
                    String str7 = !m757a(context) ? "420100086271" : str3;
                    String str8 = !m757a(context) ? "com.xiaomi.xmsf" : str;
                    treeMap.put("appid", str6);
                    treeMap.put("apptoken", str7);
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str8, 16384);
                    treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
                    treeMap.put("sdkversion", Integer.toString(40090));
                    treeMap.put("packagename", str8);
                    treeMap.put("model", Build.MODEL);
                    treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
                    if (!com.xiaomi.push.m.m640d()) {
                        String str9 = TextUtils.isEmpty(com.xiaomi.push.j.d(context)) ? "" : "" + com.xiaomi.push.bp.a(d);
                        String f = com.xiaomi.push.j.f(context);
                        if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(f)) {
                            str9 = str9 + "," + f;
                        }
                        if (!TextUtils.isEmpty(str9)) {
                            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, str9);
                        }
                    }
                    treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
                    a3 = com.xiaomi.push.j.a();
                    if (a3 >= 0) {
                        treeMap.put("space_id", Integer.toString(a3));
                    }
                    treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
                    treeMap.put("ram", com.xiaomi.push.j.m607a());
                    treeMap.put(Config.ROM, com.xiaomi.push.j.m610b());
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : treeMap.entrySet()) {
                        try {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        } catch (JSONException e) {
                            com.xiaomi.channel.commonutils.logger.b.d("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e);
                        }
                    }
                    a4 = bs.a(jSONObject2.toString());
                    TreeMap treeMap2 = new TreeMap();
                    treeMap2.put("requestData", a4);
                    treeMap2.put("keyPairVer", "1");
                    if (a(context) < 2 && !TextUtils.isEmpty(a4)) {
                        com.xiaomi.channel.commonutils.logger.b.m103a("r.data = " + a4);
                        z2 = true;
                        String a6 = a(context, z2);
                        if (z2) {
                            treeMap = treeMap2;
                        }
                        bhVar = com.xiaomi.push.bj.a(context, a6, treeMap);
                        if (bhVar != null && bhVar.a == 200) {
                            a5 = bhVar.a();
                            if (!TextUtils.isEmpty(a5)) {
                                try {
                                    jSONObject = new JSONObject(a5);
                                } catch (JSONException e2) {
                                    e = e2;
                                    z = z2;
                                } catch (Throwable th) {
                                    th = th;
                                    z = z2;
                                }
                                try {
                                } catch (JSONException e3) {
                                    e = e3;
                                    str5 = "failed to parse respone json data. " + e;
                                    com.xiaomi.channel.commonutils.logger.b.d(str5);
                                    if (z) {
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.m103a("fail to register push account. meet error.");
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    str5 = "unknow throwable. " + th;
                                    com.xiaomi.channel.commonutils.logger.b.d(str5);
                                    if (z) {
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.m103a("fail to register push account. meet error.");
                                    return null;
                                }
                                if (jSONObject.getInt("code") != 0) {
                                    z = z2;
                                    x.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                                    com.xiaomi.channel.commonutils.logger.b.m103a("device registration resp: " + a5);
                                    if (z && com.xiaomi.push.bj.c(context)) {
                                        a(context, a(context) + 1);
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.m103a("fail to register push account. meet error.");
                                    return null;
                                }
                                JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                                String string = jSONObject3.getString("ssecurity");
                                String string2 = jSONObject3.getString("token");
                                String string3 = jSONObject3.getString("userId");
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = com.alipay.sdk.sys.a.r + com.xiaomi.push.bp.a(6);
                                }
                                t tVar = new t(string3 + "@xiaomi.com/" + str4, string2, string, str6, str7, str8, com.xiaomi.push.ae.a());
                                a(context, tVar);
                                a = tVar;
                                a(context, 0);
                                com.xiaomi.channel.commonutils.logger.b.m103a("device registration is successful. " + string3);
                                return tVar;
                            }
                        }
                        z = z2;
                        if (z) {
                            a(context, a(context) + 1);
                        }
                        com.xiaomi.channel.commonutils.logger.b.m103a("fail to register push account. meet error.");
                        return null;
                    }
                    z2 = false;
                    String a62 = a(context, z2);
                    if (z2) {
                    }
                    bhVar = com.xiaomi.push.bj.a(context, a62, treeMap);
                    if (bhVar != null) {
                        a5 = bhVar.a();
                        if (!TextUtils.isEmpty(a5)) {
                        }
                    }
                    z = z2;
                    if (z) {
                    }
                    com.xiaomi.channel.commonutils.logger.b.m103a("fail to register push account. meet error.");
                    return null;
                }
            }
            str4 = null;
            com.xiaomi.push.ba.a(context).a(treeMap);
            a2 = com.xiaomi.push.j.a(context);
            if (!TextUtils.isEmpty(a2)) {
            }
            if (!m757a(context)) {
            }
            if (!m757a(context)) {
            }
            if (!m757a(context)) {
            }
            treeMap.put("appid", str6);
            treeMap.put("apptoken", str7);
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str8, 16384);
            treeMap.put("appversion", packageInfo2 == null ? String.valueOf(packageInfo2.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(40090));
            treeMap.put("packagename", str8);
            treeMap.put("model", Build.MODEL);
            treeMap.put(HttpConstants.HTTP_BOARD, Build.BOARD);
            if (!com.xiaomi.push.m.m640d()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            a3 = com.xiaomi.push.j.a();
            if (a3 >= 0) {
            }
            treeMap.put(Constants.PHONE_BRAND, Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.j.m607a());
            treeMap.put(Config.ROM, com.xiaomi.push.j.m610b());
            JSONObject jSONObject22 = new JSONObject();
            while (r9.hasNext()) {
            }
            a4 = bs.a(jSONObject22.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put("requestData", a4);
            treeMap22.put("keyPairVer", "1");
            if (a(context) < 2) {
                com.xiaomi.channel.commonutils.logger.b.m103a("r.data = " + a4);
                z2 = true;
                String a622 = a(context, z2);
                if (z2) {
                }
                bhVar = com.xiaomi.push.bj.a(context, a622, treeMap);
                if (bhVar != null) {
                }
                z = z2;
                if (z) {
                }
                com.xiaomi.channel.commonutils.logger.b.m103a("fail to register push account. meet error.");
                return null;
            }
            z2 = false;
            String a6222 = a(context, z2);
            if (z2) {
            }
            bhVar = com.xiaomi.push.bj.a(context, a6222, treeMap);
            if (bhVar != null) {
            }
            z = z2;
            if (z) {
            }
            com.xiaomi.channel.commonutils.logger.b.m103a("fail to register push account. meet error.");
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m755a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            t m754a = m754a(context);
            if (m754a != null && !TextUtils.isEmpty(m754a.f1028a)) {
                String[] split = m754a.f1028a.split("@");
                if (split.length > 0) {
                    return split[0];
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            String a2 = com.xiaomi.push.service.a.a(context).a();
            String str2 = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
            if (com.xiaomi.push.ae.b()) {
                sb = new StringBuilder();
                sb.append("http://");
                sb.append(fx.b);
                str = ":9085";
            } else if (com.xiaomi.push.q.a.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://cn.register.xmpush.xiaomi.com";
            } else if (com.xiaomi.push.q.b.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://register.xmpush.global.xiaomi.com";
            } else if (com.xiaomi.push.q.c.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://fr.register.xmpush.global.xiaomi.com";
            } else if (com.xiaomi.push.q.d.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://ru.register.xmpush.global.xiaomi.com";
            } else if (com.xiaomi.push.q.e.name().equals(a2)) {
                sb = new StringBuilder();
                str = "https://idmb.register.xmpush.global.xiaomi.com";
            } else {
                sb = new StringBuilder();
                sb.append("https://");
                str = com.xiaomi.push.ae.m177a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
            }
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static void a() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || (aVar = f1029a) == null) {
            return;
        }
        aVar.a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m756a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
            a = null;
            a();
        }
    }

    public static void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, context, i) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
            edit.putInt("enc_req_fail_count", i);
            edit.commit();
        }
    }

    public static void a(Context context, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, tVar) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
            edit.putString("uuid", tVar.f1028a);
            edit.putString("security", tVar.c);
            edit.putString("token", tVar.b);
            edit.putString("app_id", tVar.d);
            edit.putString("package_name", tVar.f);
            edit.putString("app_token", tVar.e);
            edit.putString("device_id", com.xiaomi.push.j.i(context));
            edit.putInt("env_type", tVar.a);
            edit.commit();
            a();
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, aVar) == null) {
            f1029a = aVar;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m757a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? context.getPackageName().equals("com.xiaomi.xmsf") : invokeL.booleanValue;
    }
}
