package d.a.j0.s.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f50574a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f50575b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f50576c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f50577d;

    /* renamed from: e  reason: collision with root package name */
    public static int f50578e;

    /* renamed from: f  reason: collision with root package name */
    public static int f50579f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f50580g;

    /* renamed from: h  reason: collision with root package name */
    public static String f50581h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f50582i;
    public static int j;
    public static int k;
    public static boolean l;

    public static int a() {
        if (!f50576c) {
            return d.a.j0.r.d0.b.j().k("video_report_config_upload_number", 5);
        }
        return f50579f;
    }

    public static int b() {
        if (!f50576c) {
            return d.a.j0.r.d0.b.j().k("video_report_config_upload_type", 0);
        }
        return f50578e;
    }

    public static boolean c() {
        if (!f50576c) {
            return d.a.j0.r.d0.b.j().g("video_report_config_switch", true);
        }
        return f50577d;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        f50576c = true;
        f50577d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.a.j0.r.d0.b.j().t("video_report_config_switch", f50577d);
        f50578e = jSONObject.optInt("upload_type", 0);
        d.a.j0.r.d0.b.j().v("video_report_config_upload_type", f50578e);
        f50579f = jSONObject.optInt("upload_number", 5);
        d.a.j0.r.d0.b.j().v("video_report_config_upload_number", f50579f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.a.j0.r.d0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.a.j0.r.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.a.j0.r.d0.b.j().t("video_report_is_open_prepare_time", l);
        f50580g = jSONObject.optInt("moov_check", 0) != 0;
        d.a.j0.r.d0.b.j().t("video_report_config_moov_check", f50580g);
        String optString = jSONObject.optString("android_debug_type");
        f50581h = optString;
        if (!StringUtils.isNull(optString)) {
            d.a.j0.r.d0.b.j().x("video_report_config_debug_type", f50581h);
            e(f50581h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f50574a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.a.j0.r.d0.b.j().x("video_report_config_step_cache_strategy", f50574a);
        f(f50574a);
    }

    public static void e(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (f50582i == null) {
            f50582i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f50582i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f50582i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f50582i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (f50575b == null) {
            f50575b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f50575b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f50575b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f50575b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f50575b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f50575b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
