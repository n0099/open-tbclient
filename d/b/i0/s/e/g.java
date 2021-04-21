package d.b.i0.s.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f52093a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f52094b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f52095c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f52096d;

    /* renamed from: e  reason: collision with root package name */
    public static int f52097e;

    /* renamed from: f  reason: collision with root package name */
    public static int f52098f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f52099g;

    /* renamed from: h  reason: collision with root package name */
    public static String f52100h;
    public static Map<String, String> i;
    public static int j;
    public static int k;
    public static boolean l;

    public static int a() {
        if (!f52095c) {
            return d.b.i0.r.d0.b.j().k("video_report_config_upload_number", 5);
        }
        return f52098f;
    }

    public static int b() {
        if (!f52095c) {
            return d.b.i0.r.d0.b.j().k("video_report_config_upload_type", 0);
        }
        return f52097e;
    }

    public static boolean c() {
        if (!f52095c) {
            return d.b.i0.r.d0.b.j().g("video_report_config_switch", true);
        }
        return f52096d;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        f52095c = true;
        f52096d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.b.i0.r.d0.b.j().t("video_report_config_switch", f52096d);
        f52097e = jSONObject.optInt("upload_type", 0);
        d.b.i0.r.d0.b.j().v("video_report_config_upload_type", f52097e);
        f52098f = jSONObject.optInt("upload_number", 5);
        d.b.i0.r.d0.b.j().v("video_report_config_upload_number", f52098f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.b.i0.r.d0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.b.i0.r.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.b.i0.r.d0.b.j().t("video_report_is_open_prepare_time", l);
        f52099g = jSONObject.optInt("moov_check", 0) != 0;
        d.b.i0.r.d0.b.j().t("video_report_config_moov_check", f52099g);
        String optString = jSONObject.optString("android_debug_type");
        f52100h = optString;
        if (!StringUtils.isNull(optString)) {
            d.b.i0.r.d0.b.j().x("video_report_config_debug_type", f52100h);
            e(f52100h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f52093a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.b.i0.r.d0.b.j().x("video_report_config_step_cache_strategy", f52093a);
        f(f52093a);
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
        if (f52094b == null) {
            f52094b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f52094b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f52094b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f52094b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f52094b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f52094b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
