package d.a.o0.s.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f53291a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f53292b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f53293c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f53294d;

    /* renamed from: e  reason: collision with root package name */
    public static int f53295e;

    /* renamed from: f  reason: collision with root package name */
    public static int f53296f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f53297g;

    /* renamed from: h  reason: collision with root package name */
    public static String f53298h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f53299i;
    public static int j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(670233795, "Ld/a/o0/s/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(670233795, "Ld/a/o0/s/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f53293c) {
                return d.a.o0.r.d0.b.j().k("video_report_config_upload_number", 5);
            }
            return f53296f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f53293c) {
                return d.a.o0.r.d0.b.j().k("video_report_config_upload_type", 0);
            }
            return f53295e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f53293c) {
                return d.a.o0.r.d0.b.j().g("video_report_config_switch", true);
            }
            return f53294d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f53293c = true;
        f53294d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        d.a.o0.r.d0.b.j().t("video_report_config_switch", f53294d);
        f53295e = jSONObject.optInt("upload_type", 0);
        d.a.o0.r.d0.b.j().v("video_report_config_upload_type", f53295e);
        f53296f = jSONObject.optInt("upload_number", 5);
        d.a.o0.r.d0.b.j().v("video_report_config_upload_number", f53296f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        d.a.o0.r.d0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        d.a.o0.r.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        d.a.o0.r.d0.b.j().t("video_report_is_open_prepare_time", l);
        f53297g = jSONObject.optInt("moov_check", 0) != 0;
        d.a.o0.r.d0.b.j().t("video_report_config_moov_check", f53297g);
        String optString = jSONObject.optString("android_debug_type");
        f53298h = optString;
        if (!StringUtils.isNull(optString)) {
            d.a.o0.r.d0.b.j().x("video_report_config_debug_type", f53298h);
            e(f53298h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f53291a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        d.a.o0.r.d0.b.j().x("video_report_config_step_cache_strategy", f53291a);
        f(f53291a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f53299i == null) {
            f53299i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f53299i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f53299i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f53299i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f53292b == null) {
            f53292b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f53292b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f53292b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f53292b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f53292b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f53292b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
