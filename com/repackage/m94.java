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
import com.repackage.p94;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class m94<T> implements p94.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b84 a;
    public mb4 b;
    public String c;

    public m94(b84 b84Var, mb4 mb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b84Var, mb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b84Var;
        this.b = mb4Var;
    }

    public void a(a94 a94Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, a94Var, str, str2, str3) == null) {
            d(a94Var, str, str2, str3, null);
        }
    }

    @Override // com.repackage.p94.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            b84 b84Var = this.a;
            if (b84Var != null) {
                b84Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.p94.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            b84 b84Var = this.a;
            if (b84Var != null) {
                b84Var.H(str, i);
            }
            if (i != 200) {
                a94 a94Var = new a94(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                a94Var.f = i;
                b84 b84Var2 = this.a;
                if (b84Var2 != null) {
                    b84Var2.C(a94Var);
                }
                a(a94Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            l94 a = l94.a(str);
            if (a == null) {
                JSONObject p = nd4.p(str);
                a94 a94Var2 = new a94(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                b84 b84Var3 = this.a;
                if (b84Var3 != null) {
                    b84Var3.C(a94Var2);
                }
                a(a94Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                a94 a94Var3 = new a94(d, a.e(), a.g(), i(a));
                b84 b84Var4 = this.a;
                if (b84Var4 != null) {
                    b84Var4.C(a94Var3);
                }
                if (a.d() != 1010) {
                    d(a94Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                a94 a94Var4 = new a94(2102, "response data empty");
                b84 b84Var5 = this.a;
                if (b84Var5 != null) {
                    b84Var5.C(a94Var4);
                }
                d(a94Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                a94 e = e(str, u);
                if (e != null) {
                    b84 b84Var6 = this.a;
                    if (b84Var6 != null) {
                        b84Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(a94 a94Var, String str, String str2, String str3, @Nullable l94 l94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, a94Var, str, str2, str3, l94Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (a94Var != null) {
                try {
                    if (a94Var.a != 0) {
                        i = a94Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && a94Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", r74.b().c());
                        jSONObject.put("network", hg4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof ib4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((ib4) this.b).g());
            }
            if (l94Var != null && l94Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, l94Var.f());
            }
            p74 b = r74.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            gd4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public a94 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new a94(2103, str);
        }
        return (a94) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<h94> g(@Nullable List<h94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (h94 h94Var : list) {
                if (h94Var != null && !arrayList.contains(h94Var)) {
                    d84 i = d84.i();
                    String str = h94Var.g;
                    long j = h94Var.i;
                    if (!r74.b().r(i.q(str, j, j))) {
                        arrayList.add(h94Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(l94 l94Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, l94Var)) == null) {
            if (l94Var == null || l94Var.c() == null || (optJSONObject = l94Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public a94 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new a94(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new a94(2101, Log.getStackTraceString(exc));
        }
        return (a94) invokeLL.objValue;
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

    public void l(b94 b94Var, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, b94Var, od4Var) == null) || b94Var == null) {
            return;
        }
        od4Var.a(b94Var, PMSPkgStatus.WAIT);
    }

    public void m(d94 d94Var, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, d94Var, od4Var) == null) || d94Var == null) {
            return;
        }
        od4Var.a(d94Var, PMSPkgStatus.WAIT);
    }

    public void n(List<h94> list, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, od4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (h94 h94Var : list) {
            od4Var.a(h94Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(f94 f94Var, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, f94Var, od4Var) == null) || f94Var == null) {
            return;
        }
        od4Var.a(f94Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.p94.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            a94 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.p94.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new a94(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<g94> list, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, od4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (g94 g94Var : list) {
            od4Var.a(g94Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(h94 h94Var, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, h94Var, od4Var) == null) || h94Var == null) {
            return;
        }
        od4Var.a(h94Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        a84 p;
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

    public abstract a94 t(T t);

    public abstract T u(JSONObject jSONObject);
}
