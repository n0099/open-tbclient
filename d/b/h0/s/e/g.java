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
    public static String f51757a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f51758b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f51759c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f51760d;

    /* renamed from: e  reason: collision with root package name */
    public static int f51761e;

    /* renamed from: f  reason: collision with root package name */
    public static int f51762f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f51763g;

    /* renamed from: h  reason: collision with root package name */
    public static String f51764h;
    public static Map<String, String> i;
    public static int j;
    public static int k;
    public static boolean l;

    public static int a() {
        if (!f51759c) {
            return d.b.h0.r.d0.b.j().k("video_report_config_upload_number", 5);
        }
        return f51762f;
    }

    public static int b() {
        if (!f51759c) {
            return d.b.h0.r.d0.b.j().k("video_report_config_upload_type", 0);
        }
        return f51761e;
    }

    public static boolean c() {
        if (!f51759c) {
            return d.b.h0.r.d0.b.j().g("video_report_config_switch", true);
        }
        return f51760d;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        f51759c = true;
        f51760d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.b.h0.r.d0.b.j().t("video_report_config_switch", f51760d);
        f51761e = jSONObject.optInt("upload_type", 0);
        d.b.h0.r.d0.b.j().v("video_report_config_upload_type", f51761e);
        f51762f = jSONObject.optInt("upload_number", 5);
        d.b.h0.r.d0.b.j().v("video_report_config_upload_number", f51762f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.b.h0.r.d0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.b.h0.r.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.b.h0.r.d0.b.j().t("video_report_is_open_prepare_time", l);
        f51763g = jSONObject.optInt("moov_check", 0) != 0;
        d.b.h0.r.d0.b.j().t("video_report_config_moov_check", f51763g);
        String optString = jSONObject.optString("android_debug_type");
        f51764h = optString;
        if (!StringUtils.isNull(optString)) {
            d.b.h0.r.d0.b.j().x("video_report_config_debug_type", f51764h);
            e(f51764h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f51757a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.b.h0.r.d0.b.j().x("video_report_config_step_cache_strategy", f51757a);
        f(f51757a);
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
        if (f51758b == null) {
            f51758b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f51758b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f51758b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f51758b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f51758b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f51758b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
