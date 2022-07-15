package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o94;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class l94<T> implements o94.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a84 a;
    public lb4 b;
    public String c;

    public l94(a84 a84Var, lb4 lb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a84Var, lb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a84Var;
        this.b = lb4Var;
    }

    public void a(z84 z84Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, z84Var, str, str2, str3) == null) {
            d(z84Var, str, str2, str3, null);
        }
    }

    @Override // com.repackage.o94.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            a84 a84Var = this.a;
            if (a84Var != null) {
                a84Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.o94.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            a84 a84Var = this.a;
            if (a84Var != null) {
                a84Var.H(str, i);
            }
            if (i != 200) {
                z84 z84Var = new z84(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                z84Var.f = i;
                a84 a84Var2 = this.a;
                if (a84Var2 != null) {
                    a84Var2.C(z84Var);
                }
                a(z84Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            k94 a = k94.a(str);
            if (a == null) {
                JSONObject p = md4.p(str);
                z84 z84Var2 = new z84(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                a84 a84Var3 = this.a;
                if (a84Var3 != null) {
                    a84Var3.C(z84Var2);
                }
                a(z84Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                z84 z84Var3 = new z84(d, a.e(), a.g(), i(a));
                a84 a84Var4 = this.a;
                if (a84Var4 != null) {
                    a84Var4.C(z84Var3);
                }
                if (a.d() != 1010) {
                    d(z84Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                z84 z84Var4 = new z84(2102, "response data empty");
                a84 a84Var5 = this.a;
                if (a84Var5 != null) {
                    a84Var5.C(z84Var4);
                }
                d(z84Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                z84 e = e(str, u);
                if (e != null) {
                    a84 a84Var6 = this.a;
                    if (a84Var6 != null) {
                        a84Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(z84 z84Var, String str, String str2, String str3, @Nullable k94 k94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, z84Var, str, str2, str3, k94Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (z84Var != null) {
                try {
                    if (z84Var.a != 0) {
                        i = z84Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && z84Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", q74.b().c());
                        jSONObject.put("network", gg4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof hb4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((hb4) this.b).g());
            }
            if (k94Var != null && k94Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, k94Var.f());
            }
            o74 b = q74.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            fd4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public z84 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new z84(2103, str);
        }
        return (z84) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<g94> g(@Nullable List<g94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (g94 g94Var : list) {
                if (g94Var != null && !arrayList.contains(g94Var)) {
                    c84 i = c84.i();
                    String str = g94Var.g;
                    long j = g94Var.i;
                    if (!q74.b().r(i.q(str, j, j))) {
                        arrayList.add(g94Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(k94 k94Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k94Var)) == null) {
            if (k94Var == null || k94Var.c() == null || (optJSONObject = k94Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public z84 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new z84(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new z84(2101, Log.getStackTraceString(exc));
        }
        return (z84) invokeLL.objValue;
    }

    public JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split("request fail : ");
                if (split.length > 1) {
                    return new JSONObject(split[1]);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void l(a94 a94Var, nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, a94Var, nd4Var) == null) || a94Var == null) {
            return;
        }
        nd4Var.a(a94Var, PMSPkgStatus.WAIT);
    }

    public void m(c94 c94Var, nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, c94Var, nd4Var) == null) || c94Var == null) {
            return;
        }
        nd4Var.a(c94Var, PMSPkgStatus.WAIT);
    }

    public void n(List<g94> list, nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, nd4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (g94 g94Var : list) {
            nd4Var.a(g94Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(e94 e94Var, nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, e94Var, nd4Var) == null) || e94Var == null) {
            return;
        }
        nd4Var.a(e94Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.o94.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            z84 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.o94.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new z84(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<f94> list, nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, nd4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (f94 f94Var : list) {
            nd4Var.a(f94Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(g94 g94Var, nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, g94Var, nd4Var) == null) || g94Var == null) {
            return;
        }
        nd4Var.a(g94Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        z74 p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null || (p = this.a.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public boolean s(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract z84 t(T t);

    public abstract T u(JSONObject jSONObject);
}
