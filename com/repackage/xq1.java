package com.repackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xq1 extends nq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xq1 d;

        public a(xq1 xq1Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xq1Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (!f53.h(k53Var)) {
                    int b = k53Var.b();
                    this.d.d(this.a, new hs1(b, f53.f(b)));
                    return;
                }
                this.d.z(this.b, this.c);
                this.d.d(this.a, new hs1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xq1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#openSystemSMSPanel", false);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                hx1.b("ShowSMSPanelApi", "params: ", jSONObject);
                String optString = jSONObject.optString("content");
                JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
                if (optJSONArray == null) {
                    return new hs1(202);
                }
                String y = y(optJSONArray);
                if (!TextUtils.isEmpty(y) && !TextUtils.isEmpty(optString)) {
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        return new hs1(202);
                    }
                    g03.K().q().e0().g(getContext(), "scope_show_sms_panel", new a(this, optString2, y, optString));
                    return hs1.f();
                }
                return new hs1(202);
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ShowSMSPanelApi" : (String) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k73 k73Var = new k73();
            k73Var.b = "sms_panel";
            k73Var.e = String.valueOf(this.f);
            k73Var.a("appid", g03.K().getAppId());
            a73.x("1639", k73Var);
        }
    }

    public final String y(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f = jSONArray.length();
            for (int i = 0; i < this.f; i++) {
                String optString = jSONArray.optString(i);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                sb.append(optString);
                if (i != this.f - 1) {
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void z(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            getContext().startActivity(intent);
            x();
        }
    }
}
