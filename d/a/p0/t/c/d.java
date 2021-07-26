package d.a.p0.t.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53730a;

    /* renamed from: b  reason: collision with root package name */
    public j f53731b;

    /* renamed from: c  reason: collision with root package name */
    public int f53732c;

    /* renamed from: d  reason: collision with root package name */
    public long f53733d;

    /* renamed from: e  reason: collision with root package name */
    public long f53734e;

    /* renamed from: f  reason: collision with root package name */
    public String f53735f;

    /* renamed from: g  reason: collision with root package name */
    public int f53736g;

    /* renamed from: h  reason: collision with root package name */
    public int f53737h;

    /* renamed from: i  reason: collision with root package name */
    public int f53738i;
    public int j;
    public int k;
    public int l;
    public String m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public String r;
    public String s;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53730a = 1;
        this.f53736g = 0;
        this.f53737h = 1;
        this.f53738i = 0;
        this.j = 0;
        this.k = 300;
        this.l = 1;
        this.n = 4;
        this.o = 4;
        this.p = 7;
        this.f53731b = new j();
    }

    public j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53731b : (j) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53737h == 1 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53730a > 0 : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53736g == 1 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f53738i == 0 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f53732c == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                return this.f53733d < currentTimeMillis && currentTimeMillis < this.f53734e;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j == 1 : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f53735f : (String) invokeV.objValue;
    }

    public void k(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f53730a = jSONObject.optInt("als_control", 1);
        jSONObject.optInt("not_use_lego_patch", 0);
        this.f53737h = jSONObject.optInt("ad_video_not_autoplay", 1);
        this.j = jSONObject.optInt("lp_video_not_autoplay", 0);
        this.f53731b.a(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
        if (optJSONObject != null) {
            this.f53732c = optJSONObject.optInt("log_feed_switch", 0);
            this.f53733d = optJSONObject.optLong("start_time", -1L);
            this.f53734e = optJSONObject.optLong(ResultTB.ENDTIME, -1L);
            this.f53735f = optJSONObject.optString("ext_info");
        }
        this.f53736g = jSONObject.optInt("ad_collect_switch", 0);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
        if (optJSONObject2 != null) {
            this.k = optJSONObject2.optInt("interval", 300);
        }
        this.l = jSONObject.optInt("video_page_style", 1);
        d.a.p0.s.d0.b.j().v("video_page_style", this.l);
        this.f53738i = jSONObject.optInt("ad_download_lib", 0);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
        if (optJSONObject3 != null) {
            this.n = optJSONObject3.optInt("first_floor");
            this.o = optJSONObject3.optInt("prefetch_step");
            this.p = optJSONObject3.optInt(ShaderParams.VALUE_TYPE_STEP);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
        if (optJSONObject4 != null) {
            this.m = optJSONObject4.optString("url");
            optJSONObject4.optString("name");
            optJSONObject4.optString("text_color");
            optJSONObject4.optString("text_color_pressed");
        }
        this.q = jSONObject.optInt("afd_jump_pb") == 1;
        this.r = jSONObject.optString("afd_eid");
        JSONObject optJSONObject5 = jSONObject.optJSONObject("iadex_sniff_list_url");
        if (optJSONObject5 != null) {
            String optString = optJSONObject5.optString("os_type2_iadex_url");
            this.s = optString;
            d.a.p0.b1.d.i(optString);
            return;
        }
        d.a.p0.b1.d.i(null);
    }
}
