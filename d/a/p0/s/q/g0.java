package d.a.p0.s.q;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes7.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53328a;

    /* renamed from: b  reason: collision with root package name */
    public String f53329b;

    /* renamed from: c  reason: collision with root package name */
    public String f53330c;

    /* renamed from: d  reason: collision with root package name */
    public int f53331d;

    /* renamed from: e  reason: collision with root package name */
    public String f53332e;

    /* renamed from: f  reason: collision with root package name */
    public String f53333f;

    /* renamed from: g  reason: collision with root package name */
    public String f53334g;

    /* renamed from: h  reason: collision with root package name */
    public float f53335h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53336i;

    public g0() {
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
        this.f53336i = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53328a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53329b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53333f : (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53331d : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53330c : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (StringUtils.isNull(this.f53330c)) {
                return false;
            }
            int i2 = this.f53331d;
            if (i2 != 1) {
                return i2 == 2 && !StringUtils.isNull(this.f53332e);
            }
            int i3 = this.f53328a;
            return i3 == 1 || i3 == 4 || i3 == 2 || i3 == 3;
        }
        return invokeV.booleanValue;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split == null || split.length < 2) {
                return;
            }
            int d2 = d.a.d.e.m.b.d(split[0], 1);
            int d3 = d.a.d.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f53335h = d2 / d3;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f53328a = jSONObject.optInt("bannerType");
            this.f53329b = jSONObject.optString("bannerUrl");
            this.f53330c = jSONObject.optString("value");
            this.f53331d = jSONObject.optInt("type");
            this.f53332e = jSONObject.optString("desc");
            jSONObject.optInt(TiebaStatic.Params.TEMPLATE_ID);
            this.f53333f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f53334g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void i(Banner banner) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, banner) == null) || banner == null) {
            return;
        }
        this.f53328a = banner.banner_type.intValue();
        this.f53329b = banner.banner_url;
        this.f53330c = banner.value;
        this.f53331d = banner.type.intValue();
        this.f53332e = banner.desc;
        banner.template_id.intValue();
        this.f53333f = banner.obj_id;
        String str = banner.tag_name;
        this.f53334g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
