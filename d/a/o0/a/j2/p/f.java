package d.a.o0.a.j2.p;

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
import d.a.o0.a.f1.e.b;
import d.a.o0.a.j2.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends e {
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

    public f() {
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
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        j.h(this);
        j.g(this);
        j.e(this);
        j.f(this);
    }

    @Override // d.a.o0.a.j2.p.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                d.a.o0.a.a2.e F = d.a.o0.a.g1.f.V().F();
                String i2 = d.a.o0.a.m2.b.i(this.k, TextUtils.equals(this.f46321a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
                if (F != null && F.N() != null) {
                    b.a N = F.N();
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = F.Z();
                    }
                    if (TextUtils.isEmpty(this.m)) {
                        this.m = N.v1();
                    }
                    Bundle P = N.P();
                    if (P != null) {
                        this.o = P.getString("aiapp_extra_need_download", "");
                    }
                    if (TextUtils.isEmpty(this.p)) {
                        this.p = N.W();
                    }
                    this.p = j.a(this.p);
                    if (TextUtils.isEmpty(this.f46327g) && !TextUtils.isEmpty(N.e0())) {
                        this.s = N.e0();
                    }
                    String a2 = j.a(this.s);
                    this.s = a2;
                    if (a2 == null) {
                        this.s = "";
                    }
                    if (TextUtils.isEmpty(this.u)) {
                        this.u = N.V();
                    }
                }
                this.n = SwanAppNetworkUtils.f().type;
                if (this.f46328h == null) {
                    this.f46328h = new JSONObject();
                }
                this.f46328h.put("swan", i2);
                this.f46328h.put("appversion", this.l);
                this.f46328h.put("thirdversion", this.m);
                this.f46328h.put("net", this.n);
                this.f46328h.put("needdown", this.o);
                this.f46328h.put("scheme", this.p);
                this.f46328h.put("page", this.s);
                this.f46328h.put("launchid", this.u);
                if (!TextUtils.isEmpty(this.t)) {
                    this.f46328h.put("error_code", this.t);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    this.f46328h.put("canceltime", this.q);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    this.f46328h.put("successtime", this.r);
                }
                if (e.j) {
                    Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.f46328h + "\t " + Thread.currentThread().getId());
                }
            } catch (JSONException e2) {
                if (e.j) {
                    e2.printStackTrace();
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

    public void h(d.a.o0.a.f1.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (eVar == null) {
                if (e.j) {
                    Log.w("SwanAppUBCEvent", "launchinfo is null");
                    return;
                }
                return;
            }
            this.f46326f = eVar.H();
            this.f46323c = eVar.T();
            this.o = eVar.r0().getString("aiapp_extra_need_download", "");
            this.p = eVar.W();
            this.s = eVar.e0();
            this.u = eVar.V();
        }
    }

    public void i(d.a.o0.a.f1.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            h(eVar);
        }
    }

    public void j(d.a.o0.a.f1.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            h(eVar);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }
}
