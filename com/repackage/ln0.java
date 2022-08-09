package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ln0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public final String e;
    public final int f;
    public String g;
    public String h;
    public final String i;
    public String j;
    public String k;
    public String l;
    public um0 m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public String t;

    public ln0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.q = false;
        jSONObject.optString("style");
        this.a = jSONObject.optString("user_name");
        this.b = jSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
        this.c = jSONObject.optString("scheme");
        this.d = jSONObject.optString("button_scheme");
        this.e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f = jSONObject.optInt("duration") * 1000;
        this.g = jSONObject.optString("trade");
        jSONObject.optString("score");
        this.h = jSONObject.optString("title");
        jSONObject.optString("sub_title");
        this.i = jSONObject.optString("popularity_text");
        this.j = jSONObject.optString("cover_url");
        this.s = jSONObject.optString("bottom_button_text");
        this.r = jSONObject.optString("bottom_button_icon");
        this.t = jSONObject.optString("bottom_button_scheme");
    }

    @Nullable
    public static ln0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new ln0(jSONObject);
        }
        return (ln0) invokeL.objValue;
    }

    public ln0 b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.d = i01.a(this.d, str, "__BTN_SCHEME__");
            return this;
        }
        return (ln0) invokeL.objValue;
    }

    public ln0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (ln0) invokeL.objValue;
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            jn0 jn0Var = adBaseModel.j;
            if (jn0Var != null && !TextUtils.isEmpty(jn0Var.c)) {
                c(adBaseModel.j.c);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.d)) {
                f(adBaseModel.f.d);
            }
            um0 um0Var = adBaseModel.l;
            if (um0Var != null) {
                e(um0Var);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.c)) {
                g(adBaseModel.f.c);
            }
            AdOperator adOperator = adBaseModel.h;
            if (adOperator != null && !TextUtils.isEmpty(adOperator.d)) {
                b(adBaseModel.h.d);
            }
            if (adBaseModel.f != null) {
                if (TextUtils.isEmpty(this.h)) {
                    this.h = adBaseModel.f.g;
                }
                if (TextUtils.isEmpty(this.g)) {
                    this.g = adBaseModel.f.h;
                }
            }
        }
    }

    public ln0 e(@NonNull um0 um0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, um0Var)) == null) {
            this.m = um0Var;
            return this;
        }
        return (ln0) invokeL.objValue;
    }

    public ln0 f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (ln0) invokeL.objValue;
    }

    public ln0 g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = i01.a(this.c, str, "__SCHEME__");
            return this;
        }
        return (ln0) invokeL.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            um0 um0Var = this.m;
            return um0Var != null && um0Var.e;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? h() || !TextUtils.isEmpty(this.c) : invokeV.booleanValue;
    }
}
