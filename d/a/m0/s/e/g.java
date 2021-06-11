package d.a.m0.s.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f54324a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f54325b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f54326c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f54327d;

    /* renamed from: e  reason: collision with root package name */
    public static int f54328e;

    /* renamed from: f  reason: collision with root package name */
    public static int f54329f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f54330g;

    /* renamed from: h  reason: collision with root package name */
    public static String f54331h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f54332i;
    public static int j;
    public static int k;
    public static boolean l;

    public static int a() {
        if (!f54326c) {
            return d.a.m0.r.d0.b.j().k("video_report_config_upload_number", 5);
        }
        return f54329f;
    }

    public static int b() {
        if (!f54326c) {
            return d.a.m0.r.d0.b.j().k("video_report_config_upload_type", 0);
        }
        return f54328e;
    }

    public static boolean c() {
        if (!f54326c) {
            return d.a.m0.r.d0.b.j().g("video_report_config_switch", true);
        }
        return f54327d;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        f54326c = true;
        f54327d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.a.m0.r.d0.b.j().t("video_report_config_switch", f54327d);
        f54328e = jSONObject.optInt("upload_type", 0);
        d.a.m0.r.d0.b.j().v("video_report_config_upload_type", f54328e);
        f54329f = jSONObject.optInt("upload_number", 5);
        d.a.m0.r.d0.b.j().v("video_report_config_upload_number", f54329f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.a.m0.r.d0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.a.m0.r.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.a.m0.r.d0.b.j().t("video_report_is_open_prepare_time", l);
        f54330g = jSONObject.optInt("moov_check", 0) != 0;
        d.a.m0.r.d0.b.j().t("video_report_config_moov_check", f54330g);
        String optString = jSONObject.optString("android_debug_type");
        f54331h = optString;
        if (!StringUtils.isNull(optString)) {
            d.a.m0.r.d0.b.j().x("video_report_config_debug_type", f54331h);
            e(f54331h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f54324a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.a.m0.r.d0.b.j().x("video_report_config_step_cache_strategy", f54324a);
        f(f54324a);
    }

    public static void e(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (f54332i == null) {
            f54332i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f54332i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f54332i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f54332i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (f54325b == null) {
            f54325b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f54325b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f54325b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f54325b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f54325b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f54325b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
