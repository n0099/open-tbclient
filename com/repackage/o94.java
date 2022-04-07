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
import com.repackage.r94;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class o94<T> implements r94.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d84 a;
    public ob4 b;
    public String c;

    public o94(d84 d84Var, ob4 ob4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d84Var, ob4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d84Var;
        this.b = ob4Var;
    }

    @Override // com.repackage.r94.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            d84 d84Var = this.a;
            if (d84Var != null) {
                d84Var.J(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.r94.a
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            d84 d84Var = this.a;
            if (d84Var != null) {
                d84Var.I(str, i);
            }
            if (i != 200) {
                c94 c94Var = new c94(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                c94Var.f = i;
                d84 d84Var2 = this.a;
                if (d84Var2 != null) {
                    d84Var2.D(c94Var);
                }
                c(c94Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            n94 a = n94.a(str);
            if (a == null) {
                JSONObject p = pd4.p(str);
                c94 c94Var2 = new c94(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                d84 d84Var3 = this.a;
                if (d84Var3 != null) {
                    d84Var3.D(c94Var2);
                }
                c(c94Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                c94 c94Var3 = new c94(d, a.e(), a.g(), i(a));
                d84 d84Var4 = this.a;
                if (d84Var4 != null) {
                    d84Var4.D(c94Var3);
                }
                if (a.d() != 1010) {
                    d(c94Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                c94 c94Var4 = new c94(2102, "response data empty");
                d84 d84Var5 = this.a;
                if (d84Var5 != null) {
                    d84Var5.D(c94Var4);
                }
                d(c94Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                c94 e = e(str, u);
                if (e != null) {
                    d84 d84Var6 = this.a;
                    if (d84Var6 != null) {
                        d84Var6.D(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void c(c94 c94Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, c94Var, str, str2, str3) == null) {
            d(c94Var, str, str2, str3, null);
        }
    }

    public void d(c94 c94Var, String str, String str2, String str3, @Nullable n94 n94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, c94Var, str, str2, str3, n94Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (c94Var != null) {
                try {
                    if (c94Var.a != 0) {
                        i = c94Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && c94Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", t74.b().c());
                        jSONObject.put("network", kg4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof kb4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((kb4) this.b).g());
            }
            if (n94Var != null && n94Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, n94Var.f());
            }
            r74 b = t74.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            id4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public c94 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new c94(2103, str);
        }
        return (c94) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<j94> g(@Nullable List<j94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (j94 j94Var : list) {
                if (j94Var != null && !arrayList.contains(j94Var)) {
                    f84 i = f84.i();
                    String str = j94Var.g;
                    long j = j94Var.i;
                    if (!t74.b().r(i.q(str, j, j))) {
                        arrayList.add(j94Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(n94 n94Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n94Var)) == null) {
            if (n94Var == null || n94Var.c() == null || (optJSONObject = n94Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public c94 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new c94(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new c94(2101, Log.getStackTraceString(exc));
        }
        return (c94) invokeLL.objValue;
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

    public void l(d94 d94Var, qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, d94Var, qd4Var) == null) || d94Var == null) {
            return;
        }
        qd4Var.a(d94Var, PMSPkgStatus.WAIT);
    }

    public void m(f94 f94Var, qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, f94Var, qd4Var) == null) || f94Var == null) {
            return;
        }
        qd4Var.a(f94Var, PMSPkgStatus.WAIT);
    }

    public void n(List<j94> list, qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, qd4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (j94 j94Var : list) {
            qd4Var.a(j94Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(h94 h94Var, qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, h94Var, qd4Var) == null) || h94Var == null) {
            return;
        }
        qd4Var.a(h94Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.r94.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            c94 j = j(exc, k(exc.getMessage()));
            this.a.D(j);
            c(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.r94.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c(new c94(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<i94> list, qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, qd4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (i94 i94Var : list) {
            qd4Var.a(i94Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(j94 j94Var, qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, j94Var, qd4Var) == null) || j94Var == null) {
            return;
        }
        qd4Var.a(j94Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        c84 q;
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

    public abstract c94 t(T t);

    public abstract T u(JSONObject jSONObject);
}
