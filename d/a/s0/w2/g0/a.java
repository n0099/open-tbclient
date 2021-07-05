package d.a.s0.w2.g0;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.r0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f69189f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69190a;

    /* renamed from: b  reason: collision with root package name */
    public String f69191b;

    /* renamed from: c  reason: collision with root package name */
    public long f69192c;

    /* renamed from: d  reason: collision with root package name */
    public String f69193d;

    /* renamed from: e  reason: collision with root package name */
    public String f69194e;

    public a() {
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
        this.f69194e = b.j().p("asp_shown_info", "");
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f69189f == null) {
                synchronized (d.a.s0.h3.m0.b.class) {
                    if (f69189f == null) {
                        f69189f = new a();
                    }
                }
            }
            return f69189f;
        }
        return (a) invokeV.objValue;
    }

    public AppPosInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = d();
            builder.ap_connected = Boolean.valueOf(j.H());
            builder.latitude = this.f69191b;
            builder.longitude = this.f69190a;
            builder.addr_timestamp = Long.valueOf(this.f69192c);
            builder.coordinate_type = "bd09ll";
            builder.asp_shown_info = this.f69194e;
            MercatorModel.MercatorData e2 = MercatorModel.d().e();
            if (e2 != null) {
                builder.mercator_lat = e2.x();
                builder.mercator_lon = e2.y();
                builder.mercator_city = Integer.valueOf(e2.w());
                builder.mercator_radius = e2.z();
                builder.mercator_time = Long.valueOf(e2.A());
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AppPosInfo c2 = c();
            JSONObject jSONObject = new JSONObject();
            if (c2 != null) {
                try {
                    jSONObject.put("ap_mac", c2.ap_mac);
                    jSONObject.put("ap_connected", c2.ap_connected);
                    jSONObject.put("latitude", c2.latitude);
                    jSONObject.put("longitude", c2.longitude);
                    jSONObject.put("addr_timestamp", c2.addr_timestamp);
                    jSONObject.put("coordinate_type", c2.coordinate_type);
                    jSONObject.put("asp_shown_info", c2.asp_shown_info);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LAT, c2.mercator_lat);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LON, c2.mercator_lon);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_CITY, c2.mercator_city);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_RADIUS, c2.mercator_radius);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_TIME, c2.mercator_time);
                } catch (JSONException unused) {
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public AppPosInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = d();
            builder.ap_connected = Boolean.valueOf(j.H());
            String str = this.f69191b;
            builder.latitude = str;
            builder.longitude = this.f69190a;
            if (k.isEmpty(str) || k.isEmpty(this.f69190a)) {
                String p = b.j().p("key_last_receive_location_latitude_and_longitude", "");
                if (!k.isEmpty(p)) {
                    String[] split = p.split(",");
                    if (split.length >= 2) {
                        builder.latitude = split[0];
                        builder.longitude = split[1];
                    }
                }
            }
            builder.addr_timestamp = Long.valueOf(this.f69192c);
            builder.coordinate_type = "BD09LL";
            builder.asp_shown_info = this.f69194e;
            MercatorModel.MercatorData e2 = MercatorModel.d().e();
            if (e2 != null) {
                builder.mercator_lat = e2.x();
                builder.mercator_lon = e2.y();
                builder.mercator_city = Integer.valueOf(e2.w());
                builder.mercator_radius = e2.z();
                builder.mercator_time = Long.valueOf(e2.A());
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f69193d)) {
                f();
            }
            return this.f69193d;
        }
        return (String) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        this.f69193d = connectionInfo.getBSSID();
                    } else {
                        this.f69193d = "";
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.j().x("asp_shown_info", this.f69194e);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f69194e = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f69191b = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f69190a = str;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.f69192c = j;
        }
    }
}
