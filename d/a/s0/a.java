package d.a.s0;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final a r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f57022a;

    /* renamed from: b  reason: collision with root package name */
    public int f57023b;

    /* renamed from: c  reason: collision with root package name */
    public int f57024c;

    /* renamed from: d  reason: collision with root package name */
    public int f57025d;

    /* renamed from: e  reason: collision with root package name */
    public String f57026e;

    /* renamed from: f  reason: collision with root package name */
    public int f57027f;

    /* renamed from: g  reason: collision with root package name */
    public int f57028g;

    /* renamed from: h  reason: collision with root package name */
    public int f57029h;

    /* renamed from: i  reason: collision with root package name */
    public int f57030i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public long o;
    public int p;
    public int q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457472889, "Ld/a/s0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-457472889, "Ld/a/s0/a;");
                return;
            }
        }
        r = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57022a = new AtomicBoolean(false);
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? r : (a) invokeV.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57027f : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57029h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57028g : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f57026e : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_cache_time", 20) : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_first_floor", 5) : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_floor_interval", 7) : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_insert_mode", 1) : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_max_ad_num", 5) : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_pre_load_num", 5) : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_request_num", 5) : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("pic_page_req_gap_time", 30) : invokeV.intValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f57030i == 1 : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k == 1 : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.j == 1 : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.p == 1 : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f57023b == 1 : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.q == 1 : invokeV.booleanValue;
    }

    public void x(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jSONObject) == null) {
            boolean z = this.f57022a.get();
            if (jSONObject == null || z) {
                return;
            }
            this.f57022a.set(true);
            jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.f57023b = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
            this.f57024c = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
            this.f57025d = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
            this.f57026e = jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
            this.f57027f = jSONObject.optInt("tieba_follow_up_expire_time", 7);
            this.f57028g = jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
            this.f57029h = jSONObject.optInt("tieba_follow_up_gap_time", 5);
            this.f57030i = jSONObject.optInt("tieba_12.4_download_path", 0);
            this.j = jSONObject.optInt("tieba_video_ad_jump_switch", 0);
            this.k = jSONObject.optInt("tieba_lazy_launch_switch", 0);
            this.l = jSONObject.optInt("tieba_lazy_launch_internal", 0);
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).edit();
            edit.putInt("pic_page_insert_mode", jSONObject.optInt("pic_page_insert_mode", 1));
            edit.putInt("pic_page_request_num", jSONObject.optInt("pic_page_request_num", 5));
            edit.putInt("pic_page_cache_time", jSONObject.optInt("pic_page_cache_time", 20));
            edit.putInt("pic_page_first_floor", jSONObject.optInt("pic_page_first_floor", 5));
            edit.putInt("pic_page_floor_interval", jSONObject.optInt("pic_page_floor_interval", 7));
            edit.putInt("pic_page_pre_load_num", jSONObject.optInt("pic_page_pre_load_num", 5));
            edit.putInt("pic_page_max_ad_num", jSONObject.optInt("pic_page_max_ad_num", 5));
            edit.putInt("pic_page_req_gap_time", jSONObject.optInt("pic_page_req_gap_time", 30));
            edit.commit();
            this.m = jSONObject.optInt("tieba_max_fake_progress", 0);
            this.n = jSONObject.optInt("tieba_max_fake_time", 60);
            this.o = jSONObject.optLong("tieba_max_fake_speed", 0L);
            this.p = jSONObject.optInt("tieba_video_load_optimize_switch", 0);
            this.q = jSONObject.optInt("hide_landing_page_ad_download_tip", 0);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f57025d == 1 : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f57024c == 1 : invokeV.booleanValue;
    }
}
