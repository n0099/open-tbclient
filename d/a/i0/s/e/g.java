package d.a.i0.s.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f49755a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f49756b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f49757c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f49758d;

    /* renamed from: e  reason: collision with root package name */
    public static int f49759e;

    /* renamed from: f  reason: collision with root package name */
    public static int f49760f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f49761g;

    /* renamed from: h  reason: collision with root package name */
    public static String f49762h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f49763i;
    public static int j;
    public static int k;
    public static boolean l;

    public static int a() {
        if (!f49757c) {
            return d.a.i0.r.d0.b.j().k("video_report_config_upload_number", 5);
        }
        return f49760f;
    }

    public static int b() {
        if (!f49757c) {
            return d.a.i0.r.d0.b.j().k("video_report_config_upload_type", 0);
        }
        return f49759e;
    }

    public static boolean c() {
        if (!f49757c) {
            return d.a.i0.r.d0.b.j().g("video_report_config_switch", true);
        }
        return f49758d;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        f49757c = true;
        f49758d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.a.i0.r.d0.b.j().t("video_report_config_switch", f49758d);
        f49759e = jSONObject.optInt("upload_type", 0);
        d.a.i0.r.d0.b.j().v("video_report_config_upload_type", f49759e);
        f49760f = jSONObject.optInt("upload_number", 5);
        d.a.i0.r.d0.b.j().v("video_report_config_upload_number", f49760f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.a.i0.r.d0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.a.i0.r.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.a.i0.r.d0.b.j().t("video_report_is_open_prepare_time", l);
        f49761g = jSONObject.optInt("moov_check", 0) != 0;
        d.a.i0.r.d0.b.j().t("video_report_config_moov_check", f49761g);
        String optString = jSONObject.optString("android_debug_type");
        f49762h = optString;
        if (!StringUtils.isNull(optString)) {
            d.a.i0.r.d0.b.j().x("video_report_config_debug_type", f49762h);
            e(f49762h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f49755a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.a.i0.r.d0.b.j().x("video_report_config_step_cache_strategy", f49755a);
        f(f49755a);
    }

    public static void e(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (f49763i == null) {
            f49763i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f49763i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f49763i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f49763i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        if (f49756b == null) {
            f49756b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f49756b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f49756b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f49756b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f49756b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f49756b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
