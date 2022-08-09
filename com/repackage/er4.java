package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.SimpleForum;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class er4 implements vv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public int f;
    public kp4 g;
    public int h;
    public int i;
    public String j;
    public ThemeColorInfo k;

    public er4() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : invokeV.intValue;
    }

    @Override // com.repackage.vv4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    @Override // com.repackage.vv4
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.repackage.vv4
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e = z;
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public ArrayList<Integer> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ThemeColorInfo themeColorInfo = this.k;
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                return null;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(cf7.b(this.k.day.light_color)));
            arrayList.add(Integer.valueOf(cf7.b(this.k.day.dark_color)));
            arrayList.add(Integer.valueOf(cf7.b(this.k.night.light_color)));
            arrayList.add(Integer.valueOf(cf7.b(this.k.night.dark_color)));
            arrayList.add(Integer.valueOf(cf7.b(this.k.dark.light_color)));
            arrayList.add(Integer.valueOf(cf7.b(this.k.dark.dark_color)));
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.repackage.sv4
    public boolean getIsLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public ThemeColorInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (ThemeColorInfo) invokeV.objValue;
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = String.valueOf(jSONObject.optLong("id", 0L));
        this.b = jSONObject.optString("name");
        this.c = jSONObject.optString("avatar");
        this.f = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            kp4 kp4Var = new kp4();
            this.g = kp4Var;
            kp4Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.i = optInt;
        if (optInt == 0) {
            this.i = jSONObject.optInt("member_num", 0);
        }
        this.h = jSONObject.optInt("post_num", 0);
    }

    public void j(SimpleForum simpleForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, simpleForum) == null) || simpleForum == null) {
            return;
        }
        this.a = String.valueOf(simpleForum.id);
        this.b = simpleForum.name;
        this.c = simpleForum.avatar;
        this.d = simpleForum.is_liked.intValue() == 1;
        this.f = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            kp4 kp4Var = new kp4();
            this.g = kp4Var;
            kp4Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.i = simpleForum.member_num.intValue();
        this.h = simpleForum.post_num.intValue();
        this.j = simpleForum.first_class;
        this.k = simpleForum.theme_color;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.repackage.sv4
    public void setIsLike(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.d = z;
        }
    }
}
