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
import com.repackage.ba4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class y94<T> implements ba4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n84 a;
    public yb4 b;
    public String c;

    public y94(n84 n84Var, yb4 yb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n84Var, yb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n84Var;
        this.b = yb4Var;
    }

    @Override // com.repackage.ba4.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            n84 n84Var = this.a;
            if (n84Var != null) {
                n84Var.J(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.ba4.a
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            n84 n84Var = this.a;
            if (n84Var != null) {
                n84Var.I(str, i);
            }
            if (i != 200) {
                m94 m94Var = new m94(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                m94Var.f = i;
                n84 n84Var2 = this.a;
                if (n84Var2 != null) {
                    n84Var2.D(m94Var);
                }
                c(m94Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            x94 a = x94.a(str);
            if (a == null) {
                JSONObject p = zd4.p(str);
                m94 m94Var2 = new m94(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                n84 n84Var3 = this.a;
                if (n84Var3 != null) {
                    n84Var3.D(m94Var2);
                }
                c(m94Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                m94 m94Var3 = new m94(d, a.e(), a.g(), i(a));
                n84 n84Var4 = this.a;
                if (n84Var4 != null) {
                    n84Var4.D(m94Var3);
                }
                if (a.d() != 1010) {
                    d(m94Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                m94 m94Var4 = new m94(2102, "response data empty");
                n84 n84Var5 = this.a;
                if (n84Var5 != null) {
                    n84Var5.D(m94Var4);
                }
                d(m94Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                m94 e = e(str, u);
                if (e != null) {
                    n84 n84Var6 = this.a;
                    if (n84Var6 != null) {
                        n84Var6.D(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void c(m94 m94Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, m94Var, str, str2, str3) == null) {
            d(m94Var, str, str2, str3, null);
        }
    }

    public void d(m94 m94Var, String str, String str2, String str3, @Nullable x94 x94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, m94Var, str, str2, str3, x94Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (m94Var != null) {
                try {
                    if (m94Var.a != 0) {
                        i = m94Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && m94Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", d84.b().c());
                        jSONObject.put("network", ug4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ub4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ub4) this.b).g());
            }
            if (x94Var != null && x94Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, x94Var.f());
            }
            b84 b = d84.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            sd4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public m94 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new m94(2103, str);
        }
        return (m94) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<t94> g(@Nullable List<t94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (t94 t94Var : list) {
                if (t94Var != null && !arrayList.contains(t94Var)) {
                    p84 i = p84.i();
                    String str = t94Var.g;
                    long j = t94Var.i;
                    if (!d84.b().r(i.q(str, j, j))) {
                        arrayList.add(t94Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(x94 x94Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x94Var)) == null) {
            if (x94Var == null || x94Var.c() == null || (optJSONObject = x94Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public m94 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new m94(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new m94(2101, Log.getStackTraceString(exc));
        }
        return (m94) invokeLL.objValue;
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

    public void l(n94 n94Var, ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, n94Var, ae4Var) == null) || n94Var == null) {
            return;
        }
        ae4Var.a(n94Var, PMSPkgStatus.WAIT);
    }

    public void m(p94 p94Var, ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, p94Var, ae4Var) == null) || p94Var == null) {
            return;
        }
        ae4Var.a(p94Var, PMSPkgStatus.WAIT);
    }

    public void n(List<t94> list, ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, ae4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (t94 t94Var : list) {
            ae4Var.a(t94Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(r94 r94Var, ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, r94Var, ae4Var) == null) || r94Var == null) {
            return;
        }
        ae4Var.a(r94Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.ba4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            m94 j = j(exc, k(exc.getMessage()));
            this.a.D(j);
            c(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.ba4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c(new m94(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<s94> list, ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, ae4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (s94 s94Var : list) {
            ae4Var.a(s94Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(t94 t94Var, ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, t94Var, ae4Var) == null) || t94Var == null) {
            return;
        }
        ae4Var.a(t94Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        m84 q;
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

    public abstract m94 t(T t);

    public abstract T u(JSONObject jSONObject);
}
