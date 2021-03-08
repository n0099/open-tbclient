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
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private static String f5121a = "";
    private static String b = null;
    private static String c = null;

    public static boolean a(Context context, String str) {
        Intent b2;
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!c(context)) {
                    Intent b3 = b(context, str);
                    if (b3 != null) {
                        b3.putExtra("START_ONLY_FOR_ANDROID", true);
                        context.startActivity(b3);
                        z = true;
                    }
                } else if (c(context, str) && (b2 = b(context, str)) != null) {
                    b2.putExtra("START_ONLY_FOR_ANDROID", true);
                    b.a(context, b2, null);
                    z = true;
                }
            } catch (Throwable th) {
            }
        }
        return z;
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
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean c(Context context, String str) {
        if (context == null || !c(context) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable th) {
            return false;
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
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a() {
        return (com.bytedance.sdk.openadsdk.core.i.d() == null || com.bytedance.sdk.openadsdk.core.i.d().a()) ? false : true;
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
        } catch (Exception e) {
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

    public static String a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null) {
            return null;
        }
        try {
            return b(c(lVar.aj()));
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        jSONObject = null;
        return jSONObject;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.aj()) == 9;
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.aj() == null) {
            return false;
        }
        return c(lVar.aj()) == 5 || c(lVar.aj()) == 1 || c(lVar.aj()) == 2;
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar != null) {
            return c(lVar.aj()) == 3 || c(lVar.aj()) == 4;
        }
        return false;
    }

    public static boolean e(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.aj()) == 7;
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return lVar != null && c(lVar.aj()) == 8;
    }

    public static boolean g(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return (lVar == null || lVar.ai() == null || TextUtils.isEmpty(lVar.ai().a())) ? false : true;
    }

    public static String h(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        return g(lVar) ? "deeplink_fail" : "installed";
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

    public static String i(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null || lVar.ah() == null || TextUtils.isEmpty(lVar.ah().b())) {
            return null;
        }
        return lVar.ah().b();
    }

    public static String b() {
        if (!TextUtils.isEmpty(f5121a)) {
            return f5121a;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                f5121a = new SSWebView(com.bytedance.sdk.openadsdk.core.p.a()).getSettings().getUserAgentString();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.aj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String unused = aj.f5121a = new SSWebView(com.bytedance.sdk.openadsdk.core.p.a()).getSettings().getUserAgentString();
                        } catch (Exception e) {
                        }
                    }
                });
            }
        } catch (Exception e) {
        }
        return f5121a;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static String d() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return j.a(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static synchronized String e() {
        String packageName;
        synchronized (aj.class) {
            packageName = com.bytedance.sdk.openadsdk.core.p.a() != null ? com.bytedance.sdk.openadsdk.core.p.a().getPackageName() : null;
        }
        return packageName;
    }

    public static synchronized String f() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(b) && com.bytedance.sdk.openadsdk.core.p.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(e(), 0);
                b = String.valueOf(packageInfo.versionCode);
                c = packageInfo.versionName;
            }
            str = b;
        }
        return str;
    }

    public static synchronized String g() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(c) && com.bytedance.sdk.openadsdk.core.p.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.p.a().getPackageManager().getPackageInfo(e(), 0);
                b = String.valueOf(packageInfo.versionCode);
                c = packageInfo.versionName;
            }
            str = c;
        }
        return str;
    }

    public static String a(Context context) {
        String b2 = com.bytedance.sdk.openadsdk.core.d.a(context).b("total_memory", (String) null);
        if (b2 == null) {
            String e = e(context, "MemTotal");
            com.bytedance.sdk.openadsdk.core.d.a(context).a("total_memory", e);
            return e;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [640=4, 641=4, 632=5, 634=4, 638=4] */
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

    public static Map<String, Object> a(long j, com.bytedance.sdk.openadsdk.core.d.l lVar, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j));
        if (lVar != null) {
            if (!TextUtils.isEmpty(lVar.ag())) {
                hashMap.put("creative_id", lVar.ag());
            }
            com.bytedance.sdk.openadsdk.core.d.t R = lVar.R();
            if (R != null) {
                hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, R.f());
                hashMap.put("video_size", Long.valueOf(R.d()));
            }
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(boolean z, com.bytedance.sdk.openadsdk.core.d.l lVar, long j, long j2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.ag());
        hashMap.put("load_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.t R = lVar.R();
        if (R != null) {
            hashMap.put("video_size", Long.valueOf(R.d()));
            hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, R.f());
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
        hashMap.put("creative_id", lVar.ag());
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

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.l lVar, int i, int i2, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.ag());
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("extra_error_code", Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.core.d.t R = lVar.R();
        if (R != null) {
            hashMap.put("video_size", Long.valueOf(R.d()));
            hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, R.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.l lVar, long j, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", lVar.ag());
        hashMap.put("buffers_time", Long.valueOf(j));
        com.bytedance.sdk.openadsdk.core.d.t R = lVar.R();
        if (R != null) {
            hashMap.put("video_size", Long.valueOf(R.d()));
            hashMap.put(AlaRecorderLog.KEY_VIDEO_RESOLUTION, R.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    private static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.d.d dVar) {
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
            } catch (Exception e) {
                u.b(e.toString());
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                        return null;
                    } catch (Exception e2) {
                        u.b(e2.toString());
                        return null;
                    }
                }
                return null;
            }
        } finally {
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (Exception e3) {
                    u.b(e3.toString());
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
        } catch (Exception e) {
            u.f("ToolUtils", e.toString());
            return str;
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar, boolean z) {
        if (cVar == null || cVar.u() == null || !cVar.u().g()) {
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
            return com.bytedance.sdk.openadsdk.core.a.b(str.substring(17), o(str.substring(1, 17)));
        }
        return str;
    }

    private static String o(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str == null) {
            String a3 = com.bytedance.sdk.openadsdk.core.b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar, String str) {
        if (lVar != null) {
            try {
                String W = lVar.W();
                if (TextUtils.isEmpty(W) && lVar.ai() != null && lVar.ai().c() == 1 && !TextUtils.isEmpty(lVar.ai().b())) {
                    W = lVar.ai().b();
                }
                if (!TextUtils.isEmpty(W)) {
                    com.bytedance.sdk.openadsdk.core.z.a(com.bytedance.sdk.openadsdk.core.p.a(), W, lVar, a(str), str, false, null);
                    return true;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    public static boolean j(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        boolean z = false;
        if (lVar == null) {
            return true;
        }
        switch (com.bytedance.sdk.openadsdk.core.p.h().c(d(lVar.aj()))) {
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

    public static String l(String str) {
        String format = String.format("https://%s%s", com.bytedance.sdk.openadsdk.core.p.h().b(), str);
        if (ai.a()) {
            String b2 = ai.b(format);
            String a2 = ai.a("testIp.txt");
            if (a2 != null) {
                return ai.a(b2, a2);
            }
            return b2;
        }
        return format;
    }

    public static String h() {
        return ai.b(String.format("https://%s", com.bytedance.sdk.openadsdk.core.p.h().c()));
    }

    public static String i() {
        return ai.b(String.format("https://%s", "log.snssdk.com/service/2/app_log_test/"));
    }

    public static int j() {
        try {
            return (int) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        } catch (Exception e) {
            return -1;
        }
    }

    public static int k() {
        try {
            return (int) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
        } catch (Exception e) {
            return -1;
        }
    }

    public static int l() {
        try {
            return (int) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        } catch (Exception e) {
            return -1;
        }
    }

    public static String m(String str) {
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

    public static boolean a(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && a(j) == a(j2);
    }

    public static long a(long j) {
        return (TimeZone.getDefault().getOffset(j) + j) / 86400000;
    }

    public static String a(com.bytedance.sdk.openadsdk.core.d.l lVar, View view) {
        if (lVar == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", d(lVar.aj()));
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.i.d().f());
            jSONObject.put("creative_id", lVar.ag());
            jSONObject.put("ad_sdk_version", 3401);
            jSONObject.put("ad_slot_type", c(lVar.aj()));
            if (view != null) {
                jSONObject.put("ad_width", view.getWidth());
                jSONObject.put("ad_height", view.getHeight());
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                jSONObject.put("ad_x", iArr[0]);
                jSONObject.put("ad_y", iArr[1]);
            }
            jSONObject.put("screen_width", ak.c(com.bytedance.sdk.openadsdk.core.p.a()));
            jSONObject.put("screen_height", ak.d(com.bytedance.sdk.openadsdk.core.p.a()));
        } catch (Exception e) {
        }
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.b.a());
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    public static boolean c(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("params context is null");
        }
        boolean z = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
        u.c("ToolUtils", "can query all package = " + (!z));
        return !z;
    }
}
