package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f30071a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f30072b;

    /* renamed from: c  reason: collision with root package name */
    public static String f30073c;

    public static String a(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static boolean a(Context context, String str) {
        Intent b2;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!c(context)) {
                    Intent b3 = b(context, str);
                    if (b3 == null) {
                        return false;
                    }
                    b3.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(b3);
                    return true;
                } else if (!c(context, str) || (b2 = b(context, str)) == null) {
                    return false;
                } else {
                    b2.putExtra("START_ONLY_FOR_ANDROID", true);
                    b.a(context, b2, null);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static Intent b(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        return launchIntentForPackage;
    }

    public static String b(int i) {
        switch (i) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static boolean c(Context context, String str) {
        if (context == null || !c(context) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                b.a(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean e(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.ap()) == 7;
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.ap()) == 8;
    }

    public static boolean g(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return (lVar == null || lVar.ao() == null || TextUtils.isEmpty(lVar.ao().a())) ? false : true;
    }

    public static String h(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return g(lVar) ? "deeplink_fail" : "installed";
    }

    public static String i(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.an() == null || TextUtils.isEmpty(lVar.an().b())) {
            return null;
        }
        return lVar.an().b();
    }

    public static boolean j(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return com.bytedance.sdk.openadsdk.core.a.b(str.substring(17), o(str.substring(1, 17)));
    }

    public static String l(String str) {
        String format = String.format("https://%s%s", com.bytedance.sdk.openadsdk.core.p.h().b(), str);
        if (aj.a()) {
            String b2 = aj.b(format);
            String a2 = aj.a("testIp.txt");
            return a2 != null ? aj.a(b2, a2) : b2;
        }
        return format;
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", RomUtils.MANUFACTURER_OPPO) : "";
    }

    public static String o(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str == null) {
            String a3 = com.bytedance.sdk.openadsdk.core.b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    public static long e(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optLong("uid", 0L);
        }
        return 0L;
    }

    public static int f(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("ut", 0);
        }
        return 0;
    }

    public static String h(String str) {
        JSONObject b2 = b(str);
        return b2 != null ? b2.optString(IAdRequestParam.REQ_ID, "") : "";
    }

    public static double g(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static byte[] i(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            try {
                gZIPOutputStream.write(str.getBytes());
                try {
                    gZIPOutputStream.close();
                } catch (Exception e2) {
                    u.b(e2.toString());
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e3) {
                u.b(e3.toString());
                try {
                    gZIPOutputStream.close();
                } catch (Exception e4) {
                    u.b(e4.toString());
                }
                return null;
            }
        } catch (Throwable th) {
            try {
                gZIPOutputStream.close();
            } catch (Exception e5) {
                u.b(e5.toString());
            }
            throw th;
        }
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.ap() == null) {
            return false;
        }
        return c(lVar.ap()) == 5 || c(lVar.ap()) == 1 || c(lVar.ap()) == 2;
    }

    public static synchronized String e() {
        String packageName;
        synchronized (ak.class) {
            packageName = com.bytedance.sdk.openadsdk.core.p.a() != null ? com.bytedance.sdk.openadsdk.core.p.a().getPackageName() : null;
        }
        return packageName;
    }

    public static synchronized String f() {
        String str;
        synchronized (ak.class) {
            if (TextUtils.isEmpty(f30072b) && com.bytedance.sdk.openadsdk.core.p.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(e(), 0);
                f30072b = String.valueOf(packageInfo.versionCode);
                f30073c = packageInfo.versionName;
            }
            str = f30072b;
        }
        return str;
    }

    public static String h() {
        return aj.b(String.format("https://%s", com.bytedance.sdk.openadsdk.core.p.h().c()));
    }

    public static boolean j(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null) {
            return true;
        }
        int c2 = com.bytedance.sdk.openadsdk.core.p.h().c(d(lVar.ap()));
        if (c2 != 1) {
            return c2 != 2 ? c2 != 3 : x.e(com.bytedance.sdk.openadsdk.core.p.a()) || x.d(com.bytedance.sdk.openadsdk.core.p.a());
        }
        return x.d(com.bytedance.sdk.openadsdk.core.p.a());
    }

    public static int k() {
        try {
            return (int) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static synchronized String g() {
        String str;
        synchronized (ak.class) {
            if (TextUtils.isEmpty(f30073c) && com.bytedance.sdk.openadsdk.core.p.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(e(), 0);
                f30072b = String.valueOf(packageInfo.versionCode);
                f30073c = packageInfo.versionName;
            }
            str = f30073c;
        }
        return str;
    }

    public static JSONObject b(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar != null) {
            return c(lVar.ap()) == 3 || c(lVar.ap()) == 4;
        }
        return false;
    }

    public static int l() {
        try {
            return (int) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int c(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static int d(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("rit", 0);
        }
        return 0;
    }

    public static String e(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused5) {
                    }
                    return null;
                }
                String[] split = readLine.split("\\s+");
                u.b("ToolUtils", "getTotalMemory = " + split[1]);
                String str2 = split[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused6) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused7) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static int j() {
        try {
            return (int) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean a(Context context, Intent intent) {
        if (intent == null || context == null || !c(context)) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return queryIntentActivities.size() > 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static String d() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return j.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.ap()) == 9;
    }

    public static boolean c(Context context) {
        if (context != null) {
            boolean z = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
            StringBuilder sb = new StringBuilder();
            sb.append("can query all package = ");
            sb.append(!z);
            u.c("ToolUtils", sb.toString());
            return !z;
        }
        throw new IllegalArgumentException("params context is null");
    }

    public static String b() {
        if (!TextUtils.isEmpty(f30071a)) {
            return f30071a;
        }
        try {
            f30071a = com.bytedance.sdk.openadsdk.core.i.a("sdk_local_web_ua", 86400000L);
            if (TextUtils.isEmpty(f30071a)) {
                synchronized (TextUtils.class) {
                    if (TextUtils.isEmpty(f30071a)) {
                        if (Build.VERSION.SDK_INT < 17) {
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                f30071a = new SSWebView(com.bytedance.sdk.openadsdk.core.p.a()).getSettings().getUserAgentString();
                            } else {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.ak.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            String unused = ak.f30071a = new SSWebView(com.bytedance.sdk.openadsdk.core.p.a()).getSettings().getUserAgentString();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                });
                            }
                        } else {
                            f30071a = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.p.a());
                        }
                        com.bytedance.sdk.openadsdk.core.i.a("sdk_local_web_ua", f30071a);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return f30071a;
    }

    public static boolean a() {
        return (com.bytedance.sdk.openadsdk.core.i.d() == null || com.bytedance.sdk.openadsdk.core.i.d().a()) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 564365438:
                if (str.equals("cache_splash_ad")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 1:
                return 6;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 7;
            default:
                return 1;
        }
    }

    public static String a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null) {
            return null;
        }
        try {
            return b(c(lVar.ap()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String i() {
        return aj.b(String.format("https://%s", "log.snssdk.com/service/2/app_log_test/"));
    }

    public static String a(Context context) {
        String b2 = com.bytedance.sdk.openadsdk.core.d.a(context).b("total_memory", (String) null);
        if (b2 == null) {
            String e2 = e(context, "MemTotal");
            com.bytedance.sdk.openadsdk.core.d.a(context).a("total_memory", e2);
            return e2;
        }
        return b2;
    }

    public static Map<String, Object> a(long j, com.bytedance.sdk.openadsdk.core.d.l lVar, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j));
        if (lVar != null) {
            if (!TextUtils.isEmpty(lVar.am())) {
                hashMap.put("creative_id", lVar.am());
            }
            com.bytedance.sdk.openadsdk.core.d.v X = lVar.X();
            if (X != null) {
                hashMap.put("video_resolution", X.f());
                hashMap.put("video_size", Long.valueOf(X.d()));
            }
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> b(boolean z, com.bytedance.sdk.openadsdk.core.d.l lVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.am());
        hashMap.put("load_time", Long.valueOf(j));
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static Map<String, Object> a(boolean z, com.bytedance.sdk.openadsdk.core.d.l lVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.am());
        hashMap.put("load_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.v X = lVar.X();
        if (X != null) {
            hashMap.put("video_size", Long.valueOf(X.d()));
            hashMap.put("video_resolution", X.f());
        }
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static String b(@NonNull Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e2) {
            u.f("ToolUtils", e2.toString());
            return "";
        }
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.l lVar, int i, int i2, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.am());
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("extra_error_code", Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.core.d.v X = lVar.X();
        if (X != null) {
            hashMap.put("video_size", Long.valueOf(X.d()));
            hashMap.put("video_resolution", X.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.l lVar, long j, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.am());
        hashMap.put("buffers_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.v X = lVar.X();
        if (X != null) {
            hashMap.put("video_size", Long.valueOf(X.d()));
            hashMap.put("video_resolution", X.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        if (map.containsKey("video_resolution") || dVar == null) {
            return;
        }
        try {
            if (dVar.a() != null) {
                map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(dVar.a().getVideoWidth()), Integer.valueOf(dVar.a().getVideoHeight())));
            }
        } catch (Throwable unused) {
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar, boolean z) {
        if (cVar == null || cVar.u() == null || !cVar.u().g()) {
            return 3;
        }
        return !z ? 1 : 0;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String a2 = com.bytedance.sdk.openadsdk.core.a.a();
                String str = 2 + a2 + com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.a.a(a2));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        if (lVar != null) {
            try {
                String ac = lVar.ac();
                if (TextUtils.isEmpty(ac) && lVar.ao() != null && lVar.ao().c() == 1 && !TextUtils.isEmpty(lVar.ao().b())) {
                    ac = lVar.ao().b();
                }
                String str2 = ac;
                if (!TextUtils.isEmpty(str2)) {
                    com.bytedance.sdk.openadsdk.core.z.a(com.bytedance.sdk.openadsdk.core.p.a(), str2, lVar, a(str), str, false, null);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && a(j) == a(j2);
    }

    public static long a(long j) {
        return (j + TimeZone.getDefault().getOffset(j)) / 86400000;
    }

    public static String a(com.bytedance.sdk.openadsdk.core.d.l lVar, View view) {
        if (lVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", d(lVar.ap()));
            jSONObject.put(Constants.APP_ID, com.bytedance.sdk.openadsdk.core.i.d().g());
            jSONObject.put("creative_id", lVar.am());
            jSONObject.put("ad_sdk_version", 3455);
            jSONObject.put("ad_slot_type", c(lVar.ap()));
            if (view != null) {
                jSONObject.put("ad_width", view.getWidth());
                jSONObject.put("ad_height", view.getHeight());
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                jSONObject.put("ad_x", iArr[0]);
                jSONObject.put("ad_y", iArr[1]);
            }
            jSONObject.put("screen_width", al.c(com.bytedance.sdk.openadsdk.core.p.a()));
            jSONObject.put("screen_height", al.d(com.bytedance.sdk.openadsdk.core.p.a()));
        } catch (Exception unused) {
        }
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.b.a());
        return TextUtils.isEmpty(a2) ? "" : a2;
    }
}
