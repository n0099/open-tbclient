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
import com.repackage.q94;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class n94<T> implements q94.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c84 a;
    public nb4 b;
    public String c;

    public n94(c84 c84Var, nb4 nb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c84Var, nb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c84Var;
        this.b = nb4Var;
    }

    @Override // com.repackage.q94.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            c84 c84Var = this.a;
            if (c84Var != null) {
                c84Var.J(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.q94.a
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            c84 c84Var = this.a;
            if (c84Var != null) {
                c84Var.I(str, i);
            }
            if (i != 200) {
                b94 b94Var = new b94(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                b94Var.f = i;
                c84 c84Var2 = this.a;
                if (c84Var2 != null) {
                    c84Var2.D(b94Var);
                }
                c(b94Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            m94 a = m94.a(str);
            if (a == null) {
                JSONObject p = od4.p(str);
                b94 b94Var2 = new b94(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                c84 c84Var3 = this.a;
                if (c84Var3 != null) {
                    c84Var3.D(b94Var2);
                }
                c(b94Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                b94 b94Var3 = new b94(d, a.e(), a.g(), i(a));
                c84 c84Var4 = this.a;
                if (c84Var4 != null) {
                    c84Var4.D(b94Var3);
                }
                if (a.d() != 1010) {
                    d(b94Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                b94 b94Var4 = new b94(2102, "response data empty");
                c84 c84Var5 = this.a;
                if (c84Var5 != null) {
                    c84Var5.D(b94Var4);
                }
                d(b94Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                b94 e = e(str, u);
                if (e != null) {
                    c84 c84Var6 = this.a;
                    if (c84Var6 != null) {
                        c84Var6.D(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void c(b94 b94Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, b94Var, str, str2, str3) == null) {
            d(b94Var, str, str2, str3, null);
        }
    }

    public void d(b94 b94Var, String str, String str2, String str3, @Nullable m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, b94Var, str, str2, str3, m94Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (b94Var != null) {
                try {
                    if (b94Var.a != 0) {
                        i = b94Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && b94Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", s74.b().c());
                        jSONObject.put("network", jg4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof jb4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((jb4) this.b).g());
            }
            if (m94Var != null && m94Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, m94Var.f());
            }
            q74 b = s74.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            hd4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public b94 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new b94(2103, str);
        }
        return (b94) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<i94> g(@Nullable List<i94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (i94 i94Var : list) {
                if (i94Var != null && !arrayList.contains(i94Var)) {
                    e84 i = e84.i();
                    String str = i94Var.g;
                    long j = i94Var.i;
                    if (!s74.b().r(i.q(str, j, j))) {
                        arrayList.add(i94Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(m94 m94Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m94Var)) == null) {
            if (m94Var == null || m94Var.c() == null || (optJSONObject = m94Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public b94 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new b94(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new b94(2101, Log.getStackTraceString(exc));
        }
        return (b94) invokeLL.objValue;
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

    public void l(c94 c94Var, pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, c94Var, pd4Var) == null) || c94Var == null) {
            return;
        }
        pd4Var.a(c94Var, PMSPkgStatus.WAIT);
    }

    public void m(e94 e94Var, pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, e94Var, pd4Var) == null) || e94Var == null) {
            return;
        }
        pd4Var.a(e94Var, PMSPkgStatus.WAIT);
    }

    public void n(List<i94> list, pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, pd4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (i94 i94Var : list) {
            pd4Var.a(i94Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(g94 g94Var, pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, g94Var, pd4Var) == null) || g94Var == null) {
            return;
        }
        pd4Var.a(g94Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.q94.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            b94 j = j(exc, k(exc.getMessage()));
            this.a.D(j);
            c(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.q94.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c(new b94(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<h94> list, pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, pd4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (h94 h94Var : list) {
            pd4Var.a(h94Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(i94 i94Var, pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, i94Var, pd4Var) == null) || i94Var == null) {
            return;
        }
        pd4Var.a(i94Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        b84 q;
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

    public abstract b94 t(T t);

    public abstract T u(JSONObject jSONObject);
}
