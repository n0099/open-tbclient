package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ex4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public String h;
    public int i;
    public int j;

    public ex4() {
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

    @Nullable
    public static ex4 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("[pic-tab]")) {
                String[] split = str.split(" ");
                if (split.length != 5) {
                    return null;
                }
                try {
                    ex4 ex4Var = new ex4();
                    ex4Var.g = split[1];
                    ex4Var.h = split[2];
                    ex4Var.i = Integer.parseInt(split[3]);
                    ex4Var.j = Integer.parseInt(split[4]);
                    return ex4Var;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (ex4) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d()) {
                return "[pic-tab] " + this.g + " " + this.h + " " + this.i + " " + this.j;
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.b) || this.a <= 0 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(this.h) && this.i > 0 && this.j > 0 : invokeV.booleanValue;
    }

    public void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("tab_type");
        this.b = jSONObject.optString("tab_name");
        this.c = jSONObject.optString("tab_code");
        this.d = jSONObject.optString("tab_url");
        this.e = jSONObject.optString("tab_version");
        this.g = jSONObject.optString("selected_pic_url");
        this.h = jSONObject.optString("unselected_pic_url");
        this.i = jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH);
        this.j = jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ex4.class != obj.getClass()) {
                return false;
            }
            ex4 ex4Var = (ex4) obj;
            return this.a == ex4Var.a && this.f == ex4Var.f && this.i == ex4Var.i && this.j == ex4Var.j && Objects.equals(this.b, ex4Var.b) && Objects.equals(this.c, ex4Var.c) && Objects.equals(this.d, ex4Var.d) && Objects.equals(this.e, ex4Var.e) && Objects.equals(this.g, ex4Var.g) && Objects.equals(this.h, ex4Var.h);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Objects.hash(Integer.valueOf(this.a), this.b, this.c, this.d, this.e, Boolean.valueOf(this.f), this.g, this.h, Integer.valueOf(this.i), Integer.valueOf(this.j)) : invokeV.intValue;
    }
}
