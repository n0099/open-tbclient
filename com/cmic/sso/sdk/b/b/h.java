package com.cmic.sso.sdk.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public String y;

    public h() {
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
        this.x = "";
        this.y = "";
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.f55500b + this.f55501c + this.f55502d + this.f55503e + this.f55504f + this.f55505g + this.f55506h + this.f55507i + this.f55508j + this.m + this.n + str + this.o + this.q + this.r + this.s + this.t + this.u + this.v + this.x + this.y + this.w;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.cmic.sso.sdk.b.b.a
    public void a_(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.v = v(str);
        }
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ver", this.a);
                jSONObject.put(BaseStatisContent.SDKVER, this.f55500b);
                jSONObject.put("appid", this.f55501c);
                jSONObject.put(BaseStatisContent.IMSI, this.f55502d);
                jSONObject.put("operatortype", this.f55503e);
                jSONObject.put("networktype", this.f55504f);
                jSONObject.put("mobilebrand", this.f55505g);
                jSONObject.put("mobilemodel", this.f55506h);
                jSONObject.put("mobilesystem", this.f55507i);
                jSONObject.put("clienttype", this.f55508j);
                jSONObject.put("interfacever", this.f55509k);
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
                jSONObject.put("scrip", this.x);
                jSONObject.put("userCapaid", this.y);
                jSONObject.put("funcType", this.w);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a + "&" + this.f55500b + "&" + this.f55501c + "&" + this.f55502d + "&" + this.f55503e + "&" + this.f55504f + "&" + this.f55505g + "&" + this.f55506h + "&" + this.f55507i + "&" + this.f55508j + "&" + this.f55509k + "&" + this.l + "&" + this.m + "&" + this.n + "&" + this.o + "&" + this.p + "&" + this.q + "&" + this.r + "&&" + this.s + "&" + this.t + "&" + this.u + "&" + this.v + "&" + this.x + "&" + this.y + "&" + this.w;
        }
        return (String) invokeV.objValue;
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.x = v(str);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.y = v(str);
        }
    }
}
