package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.Advertisement;
/* loaded from: classes6.dex */
public class iz4 implements Comparable<iz4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    public iz4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(iz4 iz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iz4Var)) == null) ? k() > iz4Var.k() ? -1 : 1 : invokeL.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : invokeV.longValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (StringUtils.isNull(this.g) && StringUtils.isNull(this.h)) {
                return;
            }
            String c = ui.c(TbadkApplication.getInst().getAndroidId());
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            StringBuilder sb = new StringBuilder();
            sb.append("&ANDROIDID=");
            sb.append(c == null ? "" : c.toLowerCase());
            sb.append("&OAID=");
            sb.append(lastCachedOid != null ? lastCachedOid.toUpperCase() : "");
            String sb2 = sb.toString();
            if (!StringUtils.isNull(this.g) && !this.g.contains("ANDROIDID") && !this.g.contains("OAID")) {
                this.g += sb2;
            }
            if (StringUtils.isNull(this.h) || this.h.contains("ANDROIDID") || this.h.contains("OAID")) {
                return;
            }
            this.h += sb2;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? !"0".equals(this.l) : invokeV.booleanValue;
    }

    public void o(Advertisement advertisement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, advertisement) == null) {
            this.a = advertisement.time.longValue();
            this.b = advertisement.pic;
            this.c = advertisement.pic_click;
            this.d = advertisement.jump_link;
            this.e = advertisement.advertisement_id;
            this.g = advertisement.view_statistics_url;
            this.h = advertisement.click_statistics_url;
            this.i = advertisement.floating_text;
            this.j = advertisement.scheme;
            this.k = advertisement.package_name;
            this.l = advertisement.display_ad_icon;
            m();
        }
    }

    public void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) {
            this.b = jSONObject.optString("pic");
            this.c = jSONObject.optString("pic_click");
            this.d = jSONObject.optString("jump_link");
            this.e = jSONObject.optString("advertisement_id");
            this.g = jSONObject.optString("view_statistics_url");
            this.h = jSONObject.optString("click_statistics_url");
            this.i = jSONObject.optString("floating_text");
            this.j = jSONObject.optString("scheme");
            this.k = jSONObject.optString("package_name");
            this.l = jSONObject.optString("display_ad_icon");
            m();
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f = i;
        }
    }
}
