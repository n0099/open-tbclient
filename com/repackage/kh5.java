package com.repackage;

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
/* loaded from: classes6.dex */
public class kh5 {
    public static /* synthetic */ Interceptable $ic;
    public static final kh5 l;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755558855, "Lcom/repackage/kh5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755558855, "Lcom/repackage/kh5;");
                return;
            }
        }
        l = new kh5();
    }

    public kh5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
    }

    public static kh5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? l : (kh5) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("tieba_pic_ad_req_num", 3) : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("video_flow_first_floor", -1) : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("video_flow_floor_interval", -1) : invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g == 1 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0).getInt("ad_photo_browser_insert_mode", -1) == 1 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b == 1 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k == 1 : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h == 1 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.i == 1 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d == 1 : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j == 1 : invokeV.booleanValue;
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            boolean z = this.a.get();
            if (jSONObject == null || z) {
                return;
            }
            this.a.set(true);
            this.b = jSONObject.optInt("tieba_lazy_launch_switch", 1);
            this.c = jSONObject.optInt("tieba_lazy_launch_internal", 60);
            jSONObject.optInt("tieba_max_fake_progress", 50);
            jSONObject.optInt("tieba_max_fake_time", 60);
            jSONObject.optLong("tieba_max_fake_speed", 768000L);
            SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("ad_sp_workplace", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("pic_page_insert_mode", jSONObject.optInt("pic_page_insert_mode", 2));
            edit.putInt("pic_page_request_num", jSONObject.optInt("pic_page_request_num", 5));
            edit.putInt("pic_page_cache_time", jSONObject.optInt("pic_page_cache_time", 20));
            edit.putInt("pic_page_first_floor", jSONObject.optInt("pic_page_first_floor", 2));
            edit.putInt("pic_page_floor_interval", jSONObject.optInt("pic_page_floor_interval", 5));
            edit.putInt("pic_page_pre_load_num", jSONObject.optInt("pic_page_pre_load_num", 5));
            edit.putInt("pic_page_max_ad_num", jSONObject.optInt("pic_page_max_ad_num", 5));
            edit.putInt("pic_page_req_gap_time", jSONObject.optInt("pic_page_req_gap_time", 30));
            edit.commit();
            this.k = jSONObject.optInt("tieba_video_mobile_net_autoplay", 1);
            this.g = jSONObject.optInt("tieba_12.4_download_path", 1);
            jSONObject.optInt("tieba_landing_page_type_switch", -1);
            this.d = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
            this.e = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
            this.f = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
            jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
            jSONObject.optInt("tieba_follow_up_expire_time", 7);
            jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
            jSONObject.optInt("tieba_follow_up_gap_time", 5);
            this.h = jSONObject.optInt("tieba_video_ad_jump_switch", 0);
            this.i = jSONObject.optInt("tieba_video_load_optimize_switch", 0);
            this.j = jSONObject.optInt("hide_landing_page_ad_download_tip", 0);
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("video_flow_first_floor", jSONObject.optInt("video_flow_first_floor", -1));
            edit2.putInt("video_flow_floor_interval", jSONObject.optInt("video_flow_floor_interval", -1));
            int optInt = jSONObject.optInt("ad_photo_browser_insert_mode", -1);
            if (optInt != -1) {
                edit2.putInt("ad_photo_browser_insert_mode", optInt);
            }
            int optInt2 = jSONObject.optInt("tieba_pic_ad_req_num", -1);
            if (optInt2 != -1) {
                edit2.putInt("tieba_pic_ad_req_num", optInt2);
            }
            edit2.commit();
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f == 1 : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e == 1 : invokeV.booleanValue;
    }
}
