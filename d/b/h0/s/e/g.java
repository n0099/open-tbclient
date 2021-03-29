package d.b.h0.s.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f51340a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f51341b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f51342c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f51343d;

    /* renamed from: e  reason: collision with root package name */
    public static int f51344e;

    /* renamed from: f  reason: collision with root package name */
    public static int f51345f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f51346g;

    /* renamed from: h  reason: collision with root package name */
    public static String f51347h;
    public static Map<String, String> i;
    public static int j;
    public static int k;
    public static boolean l;

    public static int a() {
        if (!f51342c) {
            return d.b.h0.r.d0.b.i().j("video_report_config_upload_number", 5);
        }
        return f51345f;
    }

    public static int b() {
        if (!f51342c) {
            return d.b.h0.r.d0.b.i().j("video_report_config_upload_type", 0);
        }
        return f51344e;
    }

    public static boolean c() {
        if (!f51342c) {
            return d.b.h0.r.d0.b.i().g("video_report_config_switch", true);
        }
        return f51343d;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        f51342c = true;
        f51343d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.b.h0.r.d0.b.i().s("video_report_config_switch", f51343d);
        f51344e = jSONObject.optInt("upload_type", 0);
        d.b.h0.r.d0.b.i().u("video_report_config_upload_type", f51344e);
        f51345f = jSONObject.optInt("upload_number", 5);
        d.b.h0.r.d0.b.i().u("video_report_config_upload_number", f51345f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.b.h0.r.d0.b.i().u("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.b.h0.r.d0.b.i().u("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.b.h0.r.d0.b.i().s("video_report_is_open_prepare_time", l);
        f51346g = jSONObject.optInt("moov_check", 0) != 0;
        d.b.h0.r.d0.b.i().s("video_report_config_moov_check", f51346g);
        String optString = jSONObject.optString("android_debug_type");
        f51347h = optString;
        if (!StringUtils.isNull(optString)) {
            d.b.h0.r.d0.b.i().w("video_report_config_debug_type", f51347h);
            e(f51347h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f51340a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.b.h0.r.d0.b.i().w("video_report_config_step_cache_strategy", f51340a);
        f(f51340a);
    }

    public static void e(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i == null) {
            i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (f51341b == null) {
            f51341b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f51341b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f51341b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f51341b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f51341b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f51341b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
