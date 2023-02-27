package com.cmic.sso.sdk.c.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String y;
    public String z;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = "";
        this.z = "";
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.b + this.c + this.d + this.e + this.f + this.g + this.h + this.i + this.j + this.m + this.n + str + this.o + this.q + this.r + this.s + this.t + this.u + this.v + this.y + this.z + this.w + this.x;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.cmic.sso.sdk.c.b.a
    public void a_(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.v = t(str);
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.y = t(str);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.z = t(str);
        }
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ver", this.a);
                jSONObject.put(BaseStatisContent.SDKVER, this.b);
                jSONObject.put("appid", this.c);
                jSONObject.put(BaseStatisContent.IMSI, this.d);
                jSONObject.put("operatortype", this.e);
                jSONObject.put("networktype", this.f);
                jSONObject.put("mobilebrand", this.g);
                jSONObject.put("mobilemodel", this.h);
                jSONObject.put("mobilesystem", this.i);
                jSONObject.put("clienttype", this.j);
                jSONObject.put("interfacever", this.k);
                jSONObject.put("expandparams", this.l);
                jSONObject.put("msgid", this.m);
                jSONObject.put("timestamp", this.n);
                jSONObject.put("subimsi", this.o);
                jSONObject.put("sign", this.p);
                jSONObject.put("apppackage", this.q);
                jSONObject.put("appsign", this.r);
                jSONObject.put("ipv4_list", this.s);
                jSONObject.put("ipv6_list", this.t);
                jSONObject.put("sdkType", this.u);
                jSONObject.put("tempPDR", this.v);
                jSONObject.put("scrip", this.y);
                jSONObject.put("userCapaid", this.z);
                jSONObject.put("funcType", this.w);
                jSONObject.put("socketip", this.x);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a + "&" + this.b + "&" + this.c + "&" + this.d + "&" + this.e + "&" + this.f + "&" + this.g + "&" + this.h + "&" + this.i + "&" + this.j + "&" + this.k + "&" + this.l + "&" + this.m + "&" + this.n + "&" + this.o + "&" + this.p + "&" + this.q + "&" + this.r + "&&" + this.s + "&" + this.t + "&" + this.u + "&" + this.v + "&" + this.y + "&" + this.z + "&" + this.w + "&" + this.x;
        }
        return (String) invokeV.objValue;
    }
}
