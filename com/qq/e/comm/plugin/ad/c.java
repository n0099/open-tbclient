package com.qq.e.comm.plugin.ad;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.qq.e.ads.cfg.SDKSrcConfig;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.al;
import com.qq.e.comm.plugin.util.av;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.be;
import com.qq.e.comm.plugin.util.bh;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.util.x;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f12177a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final Random f12178b = new Random(System.currentTimeMillis());

    private static int a(b bVar) {
        if (bVar.i() == e.REWARDVIDEOAD2.b()) {
            return 0;
        }
        boolean z = GDTADManager.getInstance().getSM().getInteger("rewardEndCardLandingPageLandscape", 0) == 1;
        if (GDTADManager.getInstance().getSM().getInteger("rewardEndCardLandingPage", 1) == 1) {
            return (z || "p".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation())) ? 1 : 0;
        }
        return 0;
    }

    public static d a(e eVar, int i) {
        switch (eVar) {
            case BANNER:
                return i < 160 ? d.BANNER_240 : (i < 160 || i >= 240) ? (i < 240 || i >= 320) ? d.BANNER_640 : d.BANNER_480 : d.BANNER_320;
            case INTERSTITIAL:
                return i >= 320 ? d.INTERSTITIAL_600 : d.INTERSTITIAL_300;
            case APP_WALL:
                return d.APPWALL_72;
            case SPLASH:
                return i >= 320 ? d.SPLASH_640 : d.SPLASH_320;
            case FEEDS:
                return d.FEEDS_1000;
            default:
                return null;
        }
    }

    private static String a(JSONObject jSONObject, b bVar) {
        CRC32 crc32;
        String str = jSONObject.optString("sdkver") + jSONObject.optString("c_os") + jSONObject.optString("muidtype") + jSONObject.optString("muid") + jSONObject.optString("c_pkgname") + jSONObject.optInt("postype") + bVar.c();
        new CRC32().update(str.getBytes(com.qq.e.comm.plugin.f.a.f12289a));
        return "0001" + Long.toHexString(crc32.getValue());
    }

    public static Map<String, String> a(com.qq.e.comm.plugin.t.b.e eVar, GDTADManager gDTADManager, b bVar) throws JSONException {
        eVar.b("adposcount", String.valueOf(bVar.d()));
        eVar.b("count", String.valueOf(bVar.e()));
        eVar.b("posid", bVar.c());
        if (bVar.i() == e.CONTENTAD.b()) {
            eVar.b("page_number", bVar.n() + "");
            eVar.b("is_manual_operation", bVar.o() + "");
            eVar.b("channel", bVar.p() + "");
        }
        if (bVar.i() == e.SPLASH.b()) {
            eVar.b("spsa", "1");
        }
        if (bVar.i() == e.CONTENTAD.b()) {
            eVar.b("support_content_ad", "1");
        }
        int g = bVar.g();
        int h = bVar.h();
        if (g > 0 && h > 0) {
            eVar.b("posw", String.valueOf(bVar.g()));
            eVar.b("posh", String.valueOf(bVar.h()));
        }
        if (bVar.i() == e.NATIVEEXPRESSAD.b()) {
            eVar.b("template_count", String.valueOf(1));
            eVar.b("actual_width", String.valueOf(bVar.a()));
            eVar.b("actual_height", String.valueOf(bVar.b()));
        }
        if (bVar.f() > 0) {
            eVar.b("datatype", String.valueOf(bVar.f()));
        }
        if (bVar.l() > 0) {
            eVar.b("reqtype", String.valueOf(bVar.l()));
        }
        if (bVar.u() > 0) {
            eVar.b("flow_source", String.valueOf(bVar.u()));
        }
        if (bVar.x() != null && bVar.x().getValue() > 0) {
            eVar.b(Constants.KEY_LOGIN_TYPE, String.valueOf(bVar.x().getValue()));
        }
        if (!TextUtils.isEmpty(bVar.y())) {
            eVar.b("login_appid", bVar.y());
        }
        if (!TextUtils.isEmpty(bVar.v())) {
            eVar.b("login_openid", bVar.v());
        }
        if (!TextUtils.isEmpty(bVar.w())) {
            eVar.b("uin", bVar.w());
        }
        if (gDTADManager.getSM().getInteger(Constants.KEYS.FLOW_CONTROL, 0) == 1) {
            eVar.b("fc", "1");
        }
        if (gDTADManager.getSM().getInteger("support_https", 0) == 1) {
            eVar.b("support_https", "1");
        }
        eVar.b("ext", a(gDTADManager, eVar, bVar).toString());
        JSONObject b2 = b(gDTADManager, eVar, bVar);
        if (b2 != null) {
            eVar.b("outerext", b2.toString());
        }
        eVar.b("r", String.valueOf(Math.random()));
        if (!TextUtils.isEmpty(com.qq.e.comm.plugin.util.b.a(GDTADManager.getInstance().getAppContext()))) {
            eVar.b("last_ads", com.qq.e.comm.plugin.util.b.a(GDTADManager.getInstance().getAppContext()));
        }
        if (com.qq.e.comm.plugin.e.a.f12285a != null && !TextUtils.isEmpty(com.qq.e.comm.plugin.e.a.f12285a.a())) {
            eVar.b("uin", com.qq.e.comm.plugin.e.a.f12285a.a());
        }
        JSONObject a2 = a();
        if (com.qq.e.comm.plugin.util.m.a(a2)) {
            return eVar.e();
        }
        String jSONObject = a2.toString();
        String a3 = com.qq.e.comm.plugin.util.c.a(jSONObject);
        eVar.b("encext", a3);
        eVar.b("encver", com.qq.e.comm.plugin.util.c.f12880a);
        GDTLogger.d("原文：" + jSONObject);
        GDTLogger.d("密文：" + a3);
        return eVar.e();
    }

    private static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        int length2;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return jSONArray2;
        }
        if (jSONArray2 == null || (length2 = jSONArray2.length()) == 0) {
            return jSONArray;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < length; i++) {
            hashSet.add(jSONArray.opt(i));
        }
        for (int i2 = 0; i2 < length2; i2++) {
            hashSet.add(jSONArray2.opt(i2));
        }
        return new JSONArray((Collection) hashSet);
    }

    private static JSONObject a() {
        JSONArray b2 = b();
        if (com.qq.e.comm.plugin.util.m.a(b2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("blist", b2);
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    private static JSONObject a(GDTADManager gDTADManager) {
        JSONObject jSONObject = new JSONObject();
        String str = i.f12191a;
        String str2 = i.f12192b;
        String str3 = i.c;
        String str4 = i.d;
        String str5 = i.e;
        String str6 = Build.VERSION.SDK_INT >= 9 ? i.f : null;
        try {
            if (StringUtil.isEmpty(str)) {
                str = null;
            }
            jSONObject.put("br", str);
            if (StringUtil.isEmpty(str2)) {
                str2 = null;
            }
            jSONObject.put("de", str2);
            if (StringUtil.isEmpty(str3)) {
                str3 = null;
            }
            jSONObject.put("fp", str3);
            if (StringUtil.isEmpty(str4)) {
                str4 = null;
            }
            jSONObject.put("hw", str4);
            if (StringUtil.isEmpty(str5)) {
                str5 = null;
            }
            jSONObject.put(Config.PRINCIPAL_PART, str5);
            jSONObject.put("sr", StringUtil.isEmpty(str6) ? null : str6);
            jSONObject.put("is_d", i.a(gDTADManager.getAppContext()));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private static JSONObject a(GDTADManager gDTADManager, com.qq.e.comm.plugin.t.b.e eVar, b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("req", c(gDTADManager, eVar, bVar));
        return a(jSONObject, bVar.H());
    }

    private static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.has(next)) {
                    Object obj = jSONObject.get(next);
                    Object obj2 = jSONObject2.get(next);
                    if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                        a((JSONObject) obj, (JSONObject) obj2);
                    }
                } else {
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0163 A[Catch: JSONException -> 0x016b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {JSONException -> 0x016b, blocks: (B:22:0x00cc, B:24:0x00d2, B:25:0x00d8, B:43:0x0163, B:48:0x0177), top: B:64:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(GDTADManager gDTADManager, JSONObject jSONObject, b bVar) throws JSONException {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        String string;
        JSONObject jSONObject3;
        JSONArray jSONArray2;
        String a2 = com.qq.e.comm.plugin.h.b.IMEI.a().a(gDTADManager.getAppContext());
        ai.a("imei = %s", a2);
        jSONObject.putOpt(com.qq.e.comm.plugin.h.b.IMEI.b(), a2);
        jSONObject.putOpt(com.qq.e.comm.plugin.h.b.ANDROIDID.b(), com.qq.e.comm.plugin.h.b.ANDROIDID.a(gDTADManager.getAppContext()));
        jSONObject.putOpt(com.qq.e.comm.plugin.h.b.AAID.b(), com.qq.e.comm.plugin.h.b.AAID.a(gDTADManager.getAppContext()));
        SM sm = GDTADManager.getInstance().getSM();
        if (TextUtils.isEmpty(a2) && sm != null && 1 == sm.getInteger("support_ad_upload_qadid_" + bVar.i(), 0) && 1 == sm.getInteger("should_collect_qadid", 0)) {
            jSONObject.putOpt("m8", al.a(gDTADManager.getAppContext()));
        }
        if (sm != null) {
            String stringForPlacement = sm.getStringForPlacement("ex_exp_info", bVar.c());
            if (TextUtils.isEmpty(stringForPlacement)) {
                jSONObject2 = null;
                jSONArray = null;
            } else {
                try {
                    jSONObject2 = new JSONObject(stringForPlacement);
                    try {
                        jSONArray = jSONObject2.optJSONArray("exp_id");
                    } catch (JSONException e) {
                        e = e;
                        GDTLogger.w(e.getMessage(), e);
                        jSONArray = null;
                        string = sm.getString("ex_exp_info");
                        if (TextUtils.isEmpty(string)) {
                        }
                        if (jSONObject2 == null) {
                        }
                        if (jSONObject3 != null) {
                        }
                        if (!TextUtils.isEmpty(a2)) {
                        }
                        av.a(true, jSONObject, "/display");
                        if (GDTADManager.getInstance().getSM().getInteger("plainIdsOn", 1) == 1) {
                        }
                        if (GDTADManager.getInstance().getSM().getInteger("adson", 1) == 1) {
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = null;
                }
            }
            string = sm.getString("ex_exp_info");
            if (TextUtils.isEmpty(string)) {
                try {
                    jSONObject3 = new JSONObject(string);
                } catch (JSONException e3) {
                    e = e3;
                    jSONObject3 = null;
                }
                try {
                    jSONArray2 = jSONObject3.optJSONArray("exp_id");
                } catch (JSONException e4) {
                    e = e4;
                    GDTLogger.w(e.getMessage(), e);
                    jSONArray2 = null;
                    if (jSONObject2 == null) {
                    }
                    if (jSONObject3 != null) {
                    }
                    if (!TextUtils.isEmpty(a2)) {
                    }
                    av.a(true, jSONObject, "/display");
                    if (GDTADManager.getInstance().getSM().getInteger("plainIdsOn", 1) == 1) {
                    }
                    if (GDTADManager.getInstance().getSM().getInteger("adson", 1) == 1) {
                    }
                }
            } else {
                jSONArray2 = null;
                jSONObject3 = null;
            }
            try {
                if (jSONObject2 == null && jSONObject3 != null) {
                    JSONArray a3 = a(jSONArray2, jSONArray);
                    if (a3 != null) {
                        jSONObject3.putOpt("exp_id", a3);
                    }
                    jSONObject.putOpt("ex_exp_info", jSONObject3);
                } else if (jSONObject3 != null) {
                    jSONObject.putOpt("ex_exp_info", jSONObject3);
                } else if (jSONObject2 != null) {
                    jSONObject.putOpt("ex_exp_info", jSONObject2);
                }
            } catch (JSONException e5) {
                GDTLogger.w(e5.getMessage(), e5);
            }
        }
        if (!TextUtils.isEmpty(a2)) {
            jSONObject.put("muidtype", 1);
            jSONObject.put("muid", a2);
            ai.b("gdt_tag_p", "request muid(imei) = %s", a2);
        }
        av.a(true, jSONObject, "/display");
        if (GDTADManager.getInstance().getSM().getInteger("plainIdsOn", 1) == 1) {
            jSONObject.put("m9", c());
        }
        if (GDTADManager.getInstance().getSM().getInteger("adson", 1) == 1) {
            jSONObject.putOpt(com.qq.e.comm.plugin.h.b.ALLID.b(), ((com.qq.e.comm.plugin.h.a.c) com.qq.e.comm.plugin.h.b.ALLID.a()).d(gDTADManager.getAppContext()));
        }
    }

    private static void a(b bVar, JSONObject jSONObject) throws JSONException {
        int z = bVar.z();
        int A = bVar.A();
        if (A > 0 && A < z) {
            GDTLogger.e("参数设置错误 , minVideoDuration不能大于maxVideoDuration");
            return;
        }
        if (z > 0) {
            jSONObject.put("min_duration", z);
        }
        if (A > 0) {
            jSONObject.put("max_duration", A);
        }
    }

    private static boolean a(int i) {
        String string = GDTADManager.getInstance().getSM().getString("fixedDurationSupportPosTypes");
        return !TextUtils.isEmpty(string) ? Arrays.asList(string.split(",")).contains(Integer.toString(i)) : e.NATIVEMEDIAAD.b() == i || e.NATIVEEXPRESSAD.b() == i || e.UNIFIED_INTERSTITIAL.b() == i || e.NATIVEUNIFIEDAD.b() == i || e.EXPRESS2.b() == i;
    }

    private static JSONArray b() {
        int integer = GDTADManager.getInstance().getSM().getInteger("bssidCount", 1);
        if (integer <= 0) {
            return null;
        }
        List<String> a2 = bh.a(GDTADManager.getInstance().getAppContext(), integer);
        if (com.qq.e.comm.plugin.util.m.a(a2) || a2.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : a2) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    private static JSONObject b(GDTADManager gDTADManager, com.qq.e.comm.plugin.t.b.e eVar, b bVar) throws JSONException {
        if (bVar.q() == null || bVar.q().size() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", new JSONArray((Collection) bVar.q()));
        return jSONObject;
    }

    private static void b(JSONObject jSONObject, b bVar) throws JSONException {
        if (bVar.i() == e.BANNER.b()) {
            jSONObject.put("placement_type", 1);
            jSONObject.put("render_type", 1);
        }
        if (bVar.i() == e.INTERSTITIAL.b()) {
            jSONObject.put("placement_type", 2);
            jSONObject.put("render_type", 1);
        }
        if (bVar.i() == e.APP_WALL.b()) {
            jSONObject.put("placement_type", 3);
            jSONObject.put("render_type", 1);
        }
        if (bVar.i() == e.SPLASH.b()) {
            jSONObject.put("placement_type", 4);
            jSONObject.put("render_type", 1);
        }
        if (bVar.i() == e.NATIVEMEDIAAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 1);
        }
        if (bVar.i() == e.GDTNATIVEAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 1);
        }
        if (bVar.i() == e.NATIVEEXPRESSAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 3);
        }
        if (bVar.i() == e.EXPRESS2.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 3);
        }
        if (bVar.i() == e.REWARDVIDEOAD2.b()) {
            jSONObject.put("placement_type", 10);
            jSONObject.put("render_type", 3);
        }
        if (bVar.i() == e.REWARDVIDEOAD.b()) {
            jSONObject.put("placement_type", 10);
            jSONObject.put("render_type", 1);
        }
        if (bVar.i() == e.NATIVEUNIFIEDAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 1);
            jSONObject.put("support_container", true);
        }
        if (bVar.i() == e.UNIFIED_BANNER.b()) {
            jSONObject.put("placement_type", 1);
            jSONObject.put("render_type", 3);
        }
        if (bVar.i() == e.UNIFIED_INTERSTITIAL.b()) {
            jSONObject.put("placement_type", 2);
            jSONObject.put("render_type", 3);
        }
    }

    private static boolean b(int i) {
        return f12178b.nextDouble() < ((double) i) * 0.001d;
    }

    private static String c() {
        return (String) gdtadv.getobjresult(352, 1, new Object[0]);
    }

    private static JSONObject c(GDTADManager gDTADManager, com.qq.e.comm.plugin.t.b.e eVar, b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String screenOrientation = gDTADManager.getDeviceStatus().getScreenOrientation();
        int i = (screenOrientation == null || screenOrientation.equals("p")) ? 0 : 90;
        a(gDTADManager, jSONObject, bVar);
        b(jSONObject, bVar);
        jSONObject.put("conn", gDTADManager.getDeviceStatus().getNetworkType().getConnValue());
        String a2 = ab.a();
        if (!StringUtil.isEmpty(a2)) {
            jSONObject.put("cell_native", a2);
        }
        jSONObject.put("carrier", gDTADManager.getDeviceStatus().getCarrier().getValue());
        try {
            double a3 = v.a(gDTADManager.getAppContext()).a();
            double b2 = v.a(gDTADManager.getAppContext()).b();
            jSONObject.put("loc_src", v.a(gDTADManager.getAppContext()).c());
            if (!com.qq.e.comm.plugin.util.m.a(a3) && !com.qq.e.comm.plugin.util.m.a(b2)) {
                jSONObject.put("lat", (long) (1000000.0d * a3));
                jSONObject.put("lng", (long) (1000000.0d * b2));
                GDTLogger.d("[latitude, longitude]=" + a3 + "," + b2);
            }
        } catch (Exception e) {
            GDTLogger.d("Get location encountered exception: " + e.getMessage());
        }
        jSONObject.put("support_features", a(bVar));
        if (bVar.i() == e.REWARDVIDEOAD.b() || bVar.i() == e.REWARDVIDEOAD2.b()) {
            SM sm = GDTADManager.getInstance().getSM();
            if (bVar.i() == e.REWARDVIDEOAD.b()) {
                jSONObject.put("support_reward_page", sm.getIntegerForPlacement("supportRewardPage", bVar.c(), 0));
            }
            jSONObject.put("support_app_landing_page", sm.getInteger("rewardVideoSupportLandingPage", 0));
            int integerForPlacement = sm.getIntegerForPlacement("rewardVideoServerMaxDuration", bVar.c(), 31);
            if (integerForPlacement > 0) {
                jSONObject.put("max_duration", integerForPlacement);
            }
        } else if (bVar.i() == e.UNIFIED_INTERSTITIAL_FULLSCREEN.b()) {
            jSONObject.put("support_app_landing_page", GDTADManager.getInstance().getSM().getInteger("interstitialFullScreenSupportLandingPage", 0));
            bVar.h(e.UNIFIED_INTERSTITIAL.b());
            a(bVar, jSONObject);
        } else {
            jSONObject.put("support_app_landing_page", 1);
            a(bVar, jSONObject);
        }
        if (a(bVar.i())) {
            jSONObject.putOpt("fixed_duration", GDTADManager.getInstance().getSM().getString("fixedDurations"));
        }
        jSONObject.put("c_os", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("c_osver", Build.VERSION.RELEASE);
        jSONObject.put("c_pkgname", gDTADManager.getAppStatus().getAPPName());
        jSONObject.put("c_device", gDTADManager.getDeviceStatus().model);
        jSONObject.put("c_devicetype", ak.a(gDTADManager.getAppContext()));
        jSONObject.put("c_mf", Build.MANUFACTURER);
        jSONObject.put("c_ori", i);
        Pair<Integer, Integer> a4 = com.qq.e.comm.plugin.util.o.a();
        if (((Integer) a4.first).intValue() > ((Integer) a4.second).intValue()) {
            jSONObject.put("c_w", a4.second);
            jSONObject.put("c_h", a4.first);
        } else {
            jSONObject.put("c_w", a4.first);
            jSONObject.put("c_h", a4.second);
        }
        jSONObject.put("sdkver", SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion());
        jSONObject.put("jsver", bVar.k());
        jSONObject.put("tmpallpt", true);
        jSONObject.put("postype", bVar.i());
        jSONObject.put("deep_link_version", 1);
        jSONObject.put("c_sdfree", com.qq.e.comm.plugin.util.o.o());
        jSONObject.put("c_market", y.a());
        jSONObject.put("c_hl", Locale.getDefault().getLanguage());
        if (bVar.i() == e.FEEDS.b()) {
            jSONObject.put("feedreq", 1);
        }
        if (bVar.i() == e.INTERSTITIAL.b() || bVar.i() == e.UNIFIED_INTERSTITIAL.b()) {
            jSONObject.put("inline_full_screen", 1);
        }
        if (bVar.i() == e.NATIVEEXPRESSAD.b()) {
            jSONObject.put("native_jsver", "1.1.0");
        }
        try {
            String sdkSrc = SDKSrcConfig.getSdkSrc();
            if (!StringUtil.isEmpty(sdkSrc)) {
                jSONObject.put("sdk_src", sdkSrc);
            }
        } catch (Throwable th) {
            GDTLogger.w("SDKSrcConfig not exist", th);
        }
        if (bVar.m() != null) {
            JSONObject m = bVar.m();
            Iterator<String> keys = m.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, m.get(next));
            }
        }
        jSONObject.put("scs", a(jSONObject, bVar));
        if (b(GDTADManager.getInstance().getSM().getInteger("antiSpamTestRate", 1000))) {
            jSONObject.put("ast", a(gDTADManager));
        }
        if (bVar.i() == e.NATIVEEXPRESSAD.b() && bb.a()) {
            jSONObject.put("support_video", true);
        }
        if ((bVar.i() == e.EXPRESS2.b() || bVar.i() == e.REWARDVIDEOAD2.b()) && bb.b()) {
            jSONObject.put("support_video", true);
        }
        if (bVar.i() == e.UNIFIED_INTERSTITIAL.b() && bb.c()) {
            jSONObject.put("support_video", true);
        }
        if (bVar.i() == e.SPLASH.b()) {
            if (GDTADManager.getInstance().getSM().getIntegerForPlacement("skssv", bVar.c(), 0) == 1) {
                jSONObject.put("support_video", true);
            }
        }
        jSONObject.put("from_js", bVar.r());
        jSONObject.put("url", bVar.s());
        jSONObject.putOpt("xflow_pos_id", bVar.t());
        jSONObject.put("sdk_st", bVar.j().a());
        jSONObject.put("sdk_pt", 1);
        if (bVar.i() == e.SPLASH.b()) {
            jSONObject.put("hwmodel", Build.DEVICE);
            jSONObject.put("hwmachine", Build.MODEL);
            jSONObject.put("brands", Build.BRAND);
            jSONObject.put("mnc", com.qq.e.comm.plugin.util.o.f(GDTADManager.getInstance().getAppContext()));
            jSONObject.put("prld", bVar.B());
            jSONObject.put("rtld", bVar.C());
            jSONObject.put("wl", bVar.D());
            jSONObject.put("playround", bVar.F());
            jSONObject.put("block_effect", bVar.E());
            jSONObject.put("oneshot", bVar.G());
            jSONObject.put("warm_boot", false);
        }
        jSONObject.put("wx_api_ver", be.a());
        jSONObject.put("opensdk_ver", be.b());
        String a5 = com.qq.e.comm.plugin.util.h.a();
        if (!TextUtils.isEmpty(a5)) {
            jSONObject.put("qq_ver", a5);
        }
        int i2 = gDTADManager.getAppContext().getApplicationInfo().targetSdkVersion;
        jSONObject.put("target_ver", i2);
        if (Build.VERSION.SDK_INT >= 30 && i2 >= 30) {
            jSONObject.put("query_all_packages", com.qq.e.comm.plugin.util.b.c(gDTADManager.getAppContext()));
        }
        jSONObject.put("support_c2s", 2);
        if (SDKStatus.getSDKVersionCode() >= 30) {
            jSONObject.put("support_component", String.format("%d,%d,%d", 1, 2, 3));
        }
        Integer c = com.qq.e.comm.plugin.a.a().c();
        if (c != null) {
            jSONObject.put("m_ch", c.intValue());
        }
        if (x.a()) {
            jSONObject.put("support_app_store", 1);
        }
        if (bVar.i() == e.EXPRESS2.b() || bVar.i() == e.REWARDVIDEOAD2.b()) {
            jSONObject.put("support_tpl", 1);
            jSONObject.put("tpl_ids", bVar.I());
        }
        return jSONObject;
    }
}
