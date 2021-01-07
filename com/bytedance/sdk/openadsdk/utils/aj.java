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
import androidx.annotation.NonNull;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.util.devices.RomUtils;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private static ai f7850a = new ai();

    /* renamed from: b  reason: collision with root package name */
    private static String f7851b = "";
    private static String c = null;
    private static String d = null;
    private static String e = null;

    public static Intent a(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        return (intent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536)) == null || queryIntentActivities.size() <= 0) ? false : true;
    }

    public static boolean c(Context context, String str) {
        return (com.bytedance.sdk.openadsdk.core.i.c() == null || com.bytedance.sdk.openadsdk.core.i.c().a()) ? false : true;
    }

    public static boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            b.a(context, intent, null);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

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

    public static int a(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 7;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 6;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c2 = 0;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c2 = 4;
                    break;
                }
                break;
            case 564365438:
                if (str.equals("cache_splash_ad")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            default:
                return 1;
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
        }
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
            case 6:
            default:
                return "embeded_ad";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static String a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null) {
            return null;
        }
        try {
            return b(c(lVar.W()));
        } catch (Throwable th) {
            return null;
        }
    }

    public static JSONObject b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str != null && !str.isEmpty()) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        jSONObject = null;
        return jSONObject;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.W()) == 9;
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar != null) {
            return c(lVar.W()) == 3 || c(lVar.W()) == 4;
        }
        return false;
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.W()) == 7;
    }

    public static boolean e(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.W()) == 8;
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return (lVar == null || lVar.V() == null || TextUtils.isEmpty(lVar.V().a())) ? false : true;
    }

    public static String g(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return f(lVar) ? "deeplink_fail" : "installed";
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

    public static double g(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static String h(String str) {
        JSONObject b2 = b(str);
        return b2 != null ? b2.optString("req_id", "") : "";
    }

    public static String h(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.U() == null || TextUtils.isEmpty(lVar.U().b())) {
            return null;
        }
        return lVar.U().b();
    }

    public static void a(@NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar, @NonNull final View view) {
        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.aj.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject b2 = aj.b(com.bytedance.sdk.openadsdk.core.d.l.this.W());
                if (b2 != null) {
                    com.bytedance.sdk.openadsdk.core.p.f().a(b2.optInt("rit", 0), b2.optString("req_id", ""), com.bytedance.sdk.openadsdk.core.d.l.this.T(), ak.b(view.getRootView(), 1048576));
                }
            }
        }, 5);
    }

    public static String a() {
        if (!TextUtils.isEmpty(f7851b)) {
            return f7851b;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                f7851b = new SSWebView(com.bytedance.sdk.openadsdk.core.p.a()).getSettings().getUserAgentString();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.aj.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String unused = aj.f7851b = new SSWebView(com.bytedance.sdk.openadsdk.core.p.a()).getSettings().getUserAgentString();
                        } catch (Exception e2) {
                        }
                    }
                });
            }
        } catch (Exception e2) {
        }
        return f7851b;
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String c() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return j.a(bArr);
        } catch (Exception e2) {
            return null;
        }
    }

    public static synchronized String d() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(c) && com.bytedance.sdk.openadsdk.core.p.a() != null) {
                c = com.bytedance.sdk.openadsdk.core.p.a().getPackageName();
            }
            str = c;
        }
        return str;
    }

    public static synchronized String e() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(d) && com.bytedance.sdk.openadsdk.core.p.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(d(), 0);
                d = String.valueOf(packageInfo.versionCode);
                e = packageInfo.versionName;
            }
            str = d;
        }
        return str;
    }

    public static synchronized String f() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(e) && com.bytedance.sdk.openadsdk.core.p.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(d(), 0);
                d = String.valueOf(packageInfo.versionCode);
                e = packageInfo.versionName;
            }
            str = e;
        }
        return str;
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [614=5, 616=4, 620=4, 622=4, 623=4] */
    public static java.lang.String e(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = "/proc/meminfo"
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L5d
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L90
            r1 = 4096(0x1000, float:5.74E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L90
        L10:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L1c
            boolean r4 = r1.contains(r8)     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L10
        L1c:
            if (r1 != 0) goto L29
            if (r2 == 0) goto L23
            r2.close()     // Catch: java.lang.Exception -> L7e
        L23:
            if (r3 == 0) goto L28
            r3.close()     // Catch: java.lang.Exception -> L80
        L28:
            return r0
        L29:
            java.lang.String r4 = "\\s+"
            java.lang.String[] r1 = r1.split(r4)     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = "ToolUtils"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r5.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r6 = "getTotalMemory = "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L93
            r6 = 1
            r6 = r1[r6]     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L93
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L93
            com.bytedance.sdk.openadsdk.utils.u.b(r4, r5)     // Catch: java.lang.Throwable -> L93
            r4 = 1
            r0 = r1[r4]     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L55
            r2.close()     // Catch: java.lang.Exception -> L82
        L55:
            if (r3 == 0) goto L28
            r3.close()     // Catch: java.lang.Exception -> L5b
            goto L28
        L5b:
            r1 = move-exception
            goto L28
        L5d:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L60:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L68
            r2.close()     // Catch: java.lang.Exception -> L84
        L68:
            if (r3 == 0) goto L28
            r3.close()     // Catch: java.lang.Exception -> L6e
            goto L28
        L6e:
            r1 = move-exception
            goto L28
        L70:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L73:
            if (r2 == 0) goto L78
            r2.close()     // Catch: java.lang.Exception -> L86
        L78:
            if (r3 == 0) goto L7d
            r3.close()     // Catch: java.lang.Exception -> L88
        L7d:
            throw r1
        L7e:
            r1 = move-exception
            goto L23
        L80:
            r1 = move-exception
            goto L28
        L82:
            r1 = move-exception
            goto L55
        L84:
            r1 = move-exception
            goto L68
        L86:
            r0 = move-exception
            goto L78
        L88:
            r0 = move-exception
            goto L7d
        L8a:
            r1 = move-exception
            r2 = r0
            goto L73
        L8d:
            r0 = move-exception
            r1 = r0
            goto L73
        L90:
            r1 = move-exception
            r2 = r0
            goto L60
        L93:
            r1 = move-exception
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.aj.e(android.content.Context, java.lang.String):java.lang.String");
    }

    public static Map<String, Object> a(long j, com.bytedance.sdk.openadsdk.core.d.l lVar, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j));
        if (lVar != null) {
            if (!TextUtils.isEmpty(lVar.T())) {
                hashMap.put("creative_id", lVar.T());
            }
            com.bytedance.sdk.openadsdk.core.d.s F = lVar.F();
            if (F != null) {
                hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, F.f());
                hashMap.put("video_size", Long.valueOf(F.d()));
            }
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(boolean z, com.bytedance.sdk.openadsdk.core.d.l lVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.T());
        hashMap.put("load_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.s F = lVar.F();
        if (F != null) {
            hashMap.put("video_size", Long.valueOf(F.d()));
            hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, F.f());
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

    public static Map<String, Object> b(boolean z, com.bytedance.sdk.openadsdk.core.d.l lVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.T());
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

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.l lVar, int i, int i2, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.T());
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("extra_error_code", Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.core.d.s F = lVar.F();
        if (F != null) {
            hashMap.put("video_size", Long.valueOf(F.d()));
            hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, F.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.l lVar, long j, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.T());
        hashMap.put("buffers_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.s F = lVar.F();
        if (F != null) {
            hashMap.put("video_size", Long.valueOf(F.d()));
            hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, F.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    private static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.c.d dVar) {
        if (map.containsKey(AlaRecorderLog.KEY_VIDEO_RESOLUTION) || dVar == null) {
            return;
        }
        try {
            if (dVar.a() != null) {
                map.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(dVar.a().getVideoWidth()), Integer.valueOf(dVar.a().getVideoHeight())));
            }
        } catch (Throwable th) {
        }
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
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e2) {
                u.b(e2.toString());
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                        return null;
                    } catch (Exception e3) {
                        u.b(e3.toString());
                        return null;
                    }
                }
                return null;
            }
        } finally {
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (Exception e4) {
                    u.b(e4.toString());
                }
            }
        }
    }

    public static boolean j(String str) {
        if (Pattern.compile("[一-龥]").matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static String b(@NonNull Context context) {
        Locale locale;
        String str = "";
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            str = locale.getLanguage();
            return str;
        } catch (Exception e2) {
            u.f("ToolUtils", e2.toString());
            return str;
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar, boolean z) {
        if (cVar == null || cVar.t() == null || !cVar.t().g()) {
            return 3;
        }
        return z ? 0 : 1;
    }

    public static JSONObject a(JSONObject jSONObject) {
        String a2;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                String str = 2 + com.bytedance.sdk.openadsdk.core.a.a() + com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.a.a(a2));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable th) {
                try {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                } catch (Throwable th2) {
                }
            }
        }
        return jSONObject2;
    }

    public static String k(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 17) {
            return com.bytedance.sdk.openadsdk.core.a.b(str.substring(17), t(str.substring(1, 17)));
        }
        return str;
    }

    private static String t(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str == null) {
            String a3 = com.bytedance.sdk.openadsdk.core.b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m(str) || n(str);
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", str);
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return o(str) || p(str);
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", str);
    }

    public static boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", str);
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        if (lVar != null) {
            try {
                String K = lVar.K();
                if (TextUtils.isEmpty(K) && lVar.V() != null && lVar.V().c() == 1 && !TextUtils.isEmpty(lVar.V().b())) {
                    K = lVar.V().b();
                }
                if (!TextUtils.isEmpty(K)) {
                    com.bytedance.sdk.openadsdk.core.z.a(com.bytedance.sdk.openadsdk.core.p.a(), K, lVar, a(str), str, false);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static boolean i(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        boolean z = false;
        if (lVar == null) {
            return true;
        }
        switch (com.bytedance.sdk.openadsdk.core.p.h().c(d(lVar.W()))) {
            case 1:
                return x.d(com.bytedance.sdk.openadsdk.core.p.a());
            case 2:
                if (x.e(com.bytedance.sdk.openadsdk.core.p.a()) || x.d(com.bytedance.sdk.openadsdk.core.p.a())) {
                    z = true;
                }
                return z;
            case 3:
                return false;
            case 4:
            default:
                return true;
        }
    }

    public static String q(String str) {
        String a2;
        String format = String.format("https://%s%s", com.bytedance.sdk.openadsdk.core.p.h().b(), str);
        if (f7850a.a(com.bytedance.sdk.openadsdk.core.p.a()) && (a2 = f7850a.a("testIp.txt")) != null) {
            return f7850a.a(format, a2);
        }
        return format;
    }

    public static String g() {
        return String.format("https://%s", com.bytedance.sdk.openadsdk.core.p.h().c());
    }

    public static String h() {
        return String.format("https://%s", "log.snssdk.com/service/2/app_log_test/");
    }

    public static int i() {
        try {
            return (int) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        } catch (Exception e2) {
            return -1;
        }
    }

    public static int j() {
        try {
            return (int) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
        } catch (Exception e2) {
            return -1;
        }
    }

    public static int k() {
        try {
            return (int) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        } catch (Exception e2) {
            return -1;
        }
    }

    public static String r(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", RomUtils.ROM_OPPO);
        }
        if (!str.contains("kllk")) {
            return "";
        }
        return str.replace("kllk", RomUtils.MANUFACTURER_OPPO);
    }
}
