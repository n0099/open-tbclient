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
import com.repackage.z53;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kr1 extends ar1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;

    /* loaded from: classes6.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ kr1 d;

        public a(kr1 kr1Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kr1Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kr1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (!s53.h(x53Var)) {
                    int b = x53Var.b();
                    this.d.d(this.a, new us1(b, s53.f(b)));
                    return;
                }
                this.d.z(this.b, this.c);
                this.d.d(this.a, new us1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kr1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public us1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#openSystemSMSPanel", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                ux1.b("ShowSMSPanelApi", "params: ", jSONObject);
                String optString = jSONObject.optString("content");
                JSONArray optJSONArray = jSONObject.optJSONArray("recipients");
                if (optJSONArray == null) {
                    return new us1(202);
                }
                String y = y(optJSONArray);
                if (!TextUtils.isEmpty(y) && !TextUtils.isEmpty(optString)) {
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        return new us1(202);
                    }
                    t03.J().r().d0().g(getContext(), "scope_show_sms_panel", new a(this, optString2, y, optString));
                    return us1.f();
                }
                return new us1(202);
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ShowSMSPanelApi" : (String) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x73 x73Var = new x73();
            x73Var.b = "sms_panel";
            x73Var.e = String.valueOf(this.f);
            x73Var.a("appid", t03.J().getAppId());
            n73.x("1639", x73Var);
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
                    sb.append(";");
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
