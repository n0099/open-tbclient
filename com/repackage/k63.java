package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ek2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k63 extends j63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;

    public k63() {
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
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        z53.i(this);
        z53.h(this);
        z53.f(this);
        z53.g(this);
    }

    @Override // com.repackage.j63
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                hz2 D = uk2.U().D();
                String i = m83.i(this.k, TextUtils.equals(this.a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
                if (D != null && D.X() != null) {
                    ek2.a X = D.X();
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = D.j0();
                    }
                    if (TextUtils.isEmpty(this.m)) {
                        this.m = X.w1();
                    }
                    Bundle P = X.P();
                    if (P != null) {
                        this.o = P.getString("aiapp_extra_need_download", "");
                    }
                    if (TextUtils.isEmpty(this.p)) {
                        this.p = X.W();
                    }
                    this.p = z53.b(this.p);
                    if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(X.e0())) {
                        this.s = X.e0();
                    }
                    String b = z53.b(this.s);
                    this.s = b;
                    if (b == null) {
                        this.s = "";
                    }
                    if (TextUtils.isEmpty(this.u)) {
                        this.u = X.V();
                    }
                }
                this.n = SwanAppNetworkUtils.f().type;
                if (this.h == null) {
                    this.h = new JSONObject();
                }
                this.h.put("swan", i);
                this.h.put("appversion", this.l);
                this.h.put("thirdversion", this.m);
                this.h.put("net", this.n);
                this.h.put("needdown", this.o);
                this.h.put("scheme", this.p);
                this.h.put("page", this.s);
                this.h.put("launchid", this.u);
                if (!TextUtils.isEmpty(this.t)) {
                    this.h.put("error_code", this.t);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    this.h.put("canceltime", this.q);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    this.h.put("successtime", this.r);
                }
                if (j63.j) {
                    Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.h + "\t " + Thread.currentThread().getId());
                }
            } catch (JSONException e) {
                if (j63.j) {
                    e.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public void h(hk2 hk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hk2Var) == null) {
            if (hk2Var == null) {
                if (j63.j) {
                    Log.w("SwanAppUBCEvent", "launchinfo is null");
                    return;
                }
                return;
            }
            this.f = hk2Var.H();
            this.c = hk2Var.T();
            this.o = hk2Var.s0().getString("aiapp_extra_need_download", "");
            this.p = hk2Var.W();
            this.s = hk2Var.e0();
            this.u = hk2Var.V();
        }
    }

    public void i(hk2 hk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hk2Var) == null) {
            h(hk2Var);
        }
    }

    public void j(hk2 hk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hk2Var) == null) {
            h(hk2Var);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }
}
