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
import com.repackage.el2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k73 extends j73 {
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

    public k73() {
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
        z63.i(this);
        z63.h(this);
        z63.f(this);
        z63.g(this);
    }

    @Override // com.repackage.j73
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                h03 D = ul2.U().D();
                String i = m93.i(this.k, TextUtils.equals(this.a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
                if (D != null && D.Y() != null) {
                    el2.a Y = D.Y();
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = D.k0();
                    }
                    if (TextUtils.isEmpty(this.m)) {
                        this.m = Y.w1();
                    }
                    Bundle P = Y.P();
                    if (P != null) {
                        this.o = P.getString("aiapp_extra_need_download", "");
                    }
                    if (TextUtils.isEmpty(this.p)) {
                        this.p = Y.W();
                    }
                    this.p = z63.b(this.p);
                    if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(Y.e0())) {
                        this.s = Y.e0();
                    }
                    String b = z63.b(this.s);
                    this.s = b;
                    if (b == null) {
                        this.s = "";
                    }
                    if (TextUtils.isEmpty(this.u)) {
                        this.u = Y.V();
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
                if (j73.j) {
                    Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.h + "\t " + Thread.currentThread().getId());
                }
            } catch (JSONException e) {
                if (j73.j) {
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

    public void h(hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hl2Var) == null) {
            if (hl2Var == null) {
                if (j73.j) {
                    Log.w("SwanAppUBCEvent", "launchinfo is null");
                    return;
                }
                return;
            }
            this.f = hl2Var.H();
            this.c = hl2Var.T();
            this.o = hl2Var.s0().getString("aiapp_extra_need_download", "");
            this.p = hl2Var.W();
            this.s = hl2Var.e0();
            this.u = hl2Var.V();
        }
    }

    public void i(hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hl2Var) == null) {
            h(hl2Var);
        }
    }

    public void j(hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hl2Var) == null) {
            h(hl2Var);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }
}
