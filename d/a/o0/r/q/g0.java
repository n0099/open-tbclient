package d.a.o0.r.q;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
    public int f52664a;

    /* renamed from: b  reason: collision with root package name */
    public String f52665b;

    /* renamed from: c  reason: collision with root package name */
    public String f52666c;

    /* renamed from: d  reason: collision with root package name */
    public int f52667d;

    /* renamed from: e  reason: collision with root package name */
    public String f52668e;

    /* renamed from: f  reason: collision with root package name */
    public String f52669f;

    /* renamed from: g  reason: collision with root package name */
    public String f52670g;

    /* renamed from: h  reason: collision with root package name */
    public float f52671h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52672i;

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
        this.f52672i = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52664a : invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52665b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52669f : (String) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52667d : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52666c : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (StringUtils.isNull(this.f52666c)) {
                return false;
            }
            int i2 = this.f52667d;
            if (i2 != 1) {
                return i2 == 2 && !StringUtils.isNull(this.f52668e);
            }
            int i3 = this.f52664a;
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
            int d2 = d.a.c.e.m.b.d(split[0], 1);
            int d3 = d.a.c.e.m.b.d(split[1], 1);
            if (d3 != 0) {
                this.f52671h = d2 / d3;
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
            this.f52664a = jSONObject.optInt("bannerType");
            this.f52665b = jSONObject.optString("bannerUrl");
            this.f52666c = jSONObject.optString("value");
            this.f52667d = jSONObject.optInt("type");
            this.f52668e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f52669f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.f52670g = jSONObject.optString("tag_name_url");
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
        this.f52664a = banner.banner_type.intValue();
        this.f52665b = banner.banner_url;
        this.f52666c = banner.value;
        this.f52667d = banner.type.intValue();
        this.f52668e = banner.desc;
        banner.template_id.intValue();
        this.f52669f = banner.obj_id;
        String str = banner.tag_name;
        this.f52670g = banner.tag_name_url;
        g(banner.tag_name_wh);
    }
}
