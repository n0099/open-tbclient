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
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.TabPic;
import tbclient.TabPicDesc;
/* loaded from: classes6.dex */
public class iw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public TabPic g;
    public String h;

    public iw4() {
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
    public static iw4 a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("[pic-tab]")) {
                try {
                    jSONObject = new JSONObject(str.substring(9));
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                try {
                    iw4 iw4Var = new iw4();
                    iw4Var.g = b(jSONObject);
                    return iw4Var;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (iw4) invokeL.objValue;
    }

    public static TabPic b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            TabPic.Builder builder = new TabPic.Builder();
            JSONObject optJSONObject = jSONObject.optJSONObject("normal");
            if (optJSONObject != null) {
                TabPicDesc.Builder builder2 = new TabPicDesc.Builder();
                builder2.selected_pic_url = optJSONObject.optString("selected_pic_url");
                builder2.unselected_pic_url = optJSONObject.optString("unselected_pic_url");
                builder2.pic_height = Integer.valueOf(optJSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
                builder2.pic_width = Integer.valueOf(optJSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH));
                builder.normal = builder2.build(true);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("dark");
            if (optJSONObject2 != null) {
                TabPicDesc.Builder builder3 = new TabPicDesc.Builder();
                builder3.selected_pic_url = optJSONObject2.optString("selected_pic_url");
                builder3.unselected_pic_url = optJSONObject2.optString("unselected_pic_url");
                builder3.pic_height = Integer.valueOf(optJSONObject2.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
                builder3.pic_width = Integer.valueOf(optJSONObject2.optInt(VrPlayerActivityConfig.PIC_WIDTH));
                builder.dark = builder3.build(true);
            }
            return builder.build(true);
        }
        return (TabPic) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (e()) {
                return "[pic-tab]" + this.h;
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.b) || this.a <= 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        TabPic tabPic;
        TabPicDesc tabPicDesc;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (TextUtils.isEmpty(this.h) || (tabPic = this.g) == null || (tabPicDesc = tabPic.normal) == null || TextUtils.isEmpty(tabPicDesc.unselected_pic_url) || this.g.normal.pic_width.intValue() <= 0) ? false : true : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || iw4.class != obj.getClass()) {
                return false;
            }
            iw4 iw4Var = (iw4) obj;
            return this.a == iw4Var.a && this.f == iw4Var.f && Objects.equals(this.b, iw4Var.b) && Objects.equals(this.c, iw4Var.c) && Objects.equals(this.d, iw4Var.d) && Objects.equals(this.e, iw4Var.e) && Objects.equals(this.h, iw4Var.h);
        }
        return invokeL.booleanValue;
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("tab_type");
        this.b = jSONObject.optString("tab_name");
        this.c = jSONObject.optString("tab_code");
        this.d = jSONObject.optString("tab_url");
        this.e = jSONObject.optString("tab_version");
        JSONObject optJSONObject = jSONObject.optJSONObject("head_pics");
        if (optJSONObject != null) {
            this.h = optJSONObject.toString();
            this.g = b(optJSONObject);
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Objects.hash(Integer.valueOf(this.a), this.b, this.c, this.d, this.e, Boolean.valueOf(this.f), this.h) : invokeV.intValue;
    }
}
