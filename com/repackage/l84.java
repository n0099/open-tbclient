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
import com.repackage.o84;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class l84<T> implements o84.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a74 a;
    public la4 b;
    public String c;

    public l84(a74 a74Var, la4 la4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a74Var, la4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a74Var;
        this.b = la4Var;
    }

    @Override // com.repackage.o84.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            a74 a74Var = this.a;
            if (a74Var != null) {
                a74Var.J(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.o84.a
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            a74 a74Var = this.a;
            if (a74Var != null) {
                a74Var.I(str, i);
            }
            if (i != 200) {
                z74 z74Var = new z74(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                z74Var.f = i;
                a74 a74Var2 = this.a;
                if (a74Var2 != null) {
                    a74Var2.D(z74Var);
                }
                c(z74Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            k84 a = k84.a(str);
            if (a == null) {
                JSONObject p = mc4.p(str);
                z74 z74Var2 = new z74(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                a74 a74Var3 = this.a;
                if (a74Var3 != null) {
                    a74Var3.D(z74Var2);
                }
                c(z74Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                z74 z74Var3 = new z74(d, a.e(), a.g(), i(a));
                a74 a74Var4 = this.a;
                if (a74Var4 != null) {
                    a74Var4.D(z74Var3);
                }
                if (a.d() != 1010) {
                    d(z74Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                z74 z74Var4 = new z74(2102, "response data empty");
                a74 a74Var5 = this.a;
                if (a74Var5 != null) {
                    a74Var5.D(z74Var4);
                }
                d(z74Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                z74 e = e(str, u);
                if (e != null) {
                    a74 a74Var6 = this.a;
                    if (a74Var6 != null) {
                        a74Var6.D(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void c(z74 z74Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, z74Var, str, str2, str3) == null) {
            d(z74Var, str, str2, str3, null);
        }
    }

    public void d(z74 z74Var, String str, String str2, String str3, @Nullable k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, z74Var, str, str2, str3, k84Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (z74Var != null) {
                try {
                    if (z74Var.a != 0) {
                        i = z74Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && z74Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", q64.b().c());
                        jSONObject.put("network", hf4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ha4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ha4) this.b).g());
            }
            if (k84Var != null && k84Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, k84Var.f());
            }
            o64 b = q64.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            fc4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public z74 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new z74(2103, str);
        }
        return (z74) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<g84> g(@Nullable List<g84> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (g84 g84Var : list) {
                if (g84Var != null && !arrayList.contains(g84Var)) {
                    c74 i = c74.i();
                    String str = g84Var.g;
                    long j = g84Var.i;
                    if (!q64.b().r(i.q(str, j, j))) {
                        arrayList.add(g84Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(k84 k84Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k84Var)) == null) {
            if (k84Var == null || k84Var.c() == null || (optJSONObject = k84Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public z74 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new z74(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new z74(2101, Log.getStackTraceString(exc));
        }
        return (z74) invokeLL.objValue;
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

    public void l(a84 a84Var, nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, a84Var, nc4Var) == null) || a84Var == null) {
            return;
        }
        nc4Var.a(a84Var, PMSPkgStatus.WAIT);
    }

    public void m(c84 c84Var, nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, c84Var, nc4Var) == null) || c84Var == null) {
            return;
        }
        nc4Var.a(c84Var, PMSPkgStatus.WAIT);
    }

    public void n(List<g84> list, nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, nc4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (g84 g84Var : list) {
            nc4Var.a(g84Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(e84 e84Var, nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, e84Var, nc4Var) == null) || e84Var == null) {
            return;
        }
        nc4Var.a(e84Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.o84.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            z74 j = j(exc, k(exc.getMessage()));
            this.a.D(j);
            c(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.o84.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c(new z74(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<f84> list, nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, nc4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (f84 f84Var : list) {
            nc4Var.a(f84Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(g84 g84Var, nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, g84Var, nc4Var) == null) || g84Var == null) {
            return;
        }
        nc4Var.a(g84Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        z64 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null || (q = this.a.q()) == null) {
            return;
        }
        q.a(pMSAppInfo);
    }

    public boolean s(T t, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract z74 t(T t);

    public abstract T u(JSONObject jSONObject);
}
