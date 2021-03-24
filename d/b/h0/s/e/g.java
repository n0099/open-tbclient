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
    public static String f51339a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f51340b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f51341c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f51342d;

    /* renamed from: e  reason: collision with root package name */
    public static int f51343e;

    /* renamed from: f  reason: collision with root package name */
    public static int f51344f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f51345g;

    /* renamed from: h  reason: collision with root package name */
    public static String f51346h;
    public static Map<String, String> i;
    public static int j;
    public static int k;
    public static boolean l;

    public static int a() {
        if (!f51341c) {
            return d.b.h0.r.d0.b.i().j("video_report_config_upload_number", 5);
        }
        return f51344f;
    }

    public static int b() {
        if (!f51341c) {
            return d.b.h0.r.d0.b.i().j("video_report_config_upload_type", 0);
        }
        return f51343e;
    }

    public static boolean c() {
        if (!f51341c) {
            return d.b.h0.r.d0.b.i().g("video_report_config_switch", true);
        }
        return f51342d;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        f51341c = true;
        f51342d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.b.h0.r.d0.b.i().s("video_report_config_switch", f51342d);
        f51343e = jSONObject.optInt("upload_type", 0);
        d.b.h0.r.d0.b.i().u("video_report_config_upload_type", f51343e);
        f51344f = jSONObject.optInt("upload_number", 5);
        d.b.h0.r.d0.b.i().u("video_report_config_upload_number", f51344f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.b.h0.r.d0.b.i().u("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.b.h0.r.d0.b.i().u("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.b.h0.r.d0.b.i().s("video_report_is_open_prepare_time", l);
        f51345g = jSONObject.optInt("moov_check", 0) != 0;
        d.b.h0.r.d0.b.i().s("video_report_config_moov_check", f51345g);
        String optString = jSONObject.optString("android_debug_type");
        f51346h = optString;
        if (!StringUtils.isNull(optString)) {
            d.b.h0.r.d0.b.i().w("video_report_config_debug_type", f51346h);
            e(f51346h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f51339a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.b.h0.r.d0.b.i().w("video_report_config_step_cache_strategy", f51339a);
        f(f51339a);
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
        if (f51340b == null) {
            f51340b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f51340b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f51340b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f51340b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f51340b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f51340b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
