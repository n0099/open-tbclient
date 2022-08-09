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
import com.repackage.ga4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class da4<T> implements ga4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s84 a;
    public dc4 b;
    public String c;

    public da4(s84 s84Var, dc4 dc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s84Var, dc4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = s84Var;
        this.b = dc4Var;
    }

    public void a(r94 r94Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, r94Var, str, str2, str3) == null) {
            d(r94Var, str, str2, str3, null);
        }
    }

    @Override // com.repackage.ga4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            s84 s84Var = this.a;
            if (s84Var != null) {
                s84Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.ga4.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            s84 s84Var = this.a;
            if (s84Var != null) {
                s84Var.H(str, i);
            }
            if (i != 200) {
                r94 r94Var = new r94(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                r94Var.f = i;
                s84 s84Var2 = this.a;
                if (s84Var2 != null) {
                    s84Var2.C(r94Var);
                }
                a(r94Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            ca4 a = ca4.a(str);
            if (a == null) {
                JSONObject p = ee4.p(str);
                r94 r94Var2 = new r94(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                s84 s84Var3 = this.a;
                if (s84Var3 != null) {
                    s84Var3.C(r94Var2);
                }
                a(r94Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                r94 r94Var3 = new r94(d, a.e(), a.g(), i(a));
                s84 s84Var4 = this.a;
                if (s84Var4 != null) {
                    s84Var4.C(r94Var3);
                }
                if (a.d() != 1010) {
                    d(r94Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                r94 r94Var4 = new r94(2102, "response data empty");
                s84 s84Var5 = this.a;
                if (s84Var5 != null) {
                    s84Var5.C(r94Var4);
                }
                d(r94Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                r94 e = e(str, u);
                if (e != null) {
                    s84 s84Var6 = this.a;
                    if (s84Var6 != null) {
                        s84Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(r94 r94Var, String str, String str2, String str3, @Nullable ca4 ca4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, r94Var, str, str2, str3, ca4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (r94Var != null) {
                try {
                    if (r94Var.a != 0) {
                        i = r94Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && r94Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", i84.b().c());
                        jSONObject.put("network", yg4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof zb4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((zb4) this.b).g());
            }
            if (ca4Var != null && ca4Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, ca4Var.f());
            }
            g84 b = i84.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            xd4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public r94 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new r94(2103, str);
        }
        return (r94) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<y94> g(@Nullable List<y94> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (y94 y94Var : list) {
                if (y94Var != null && !arrayList.contains(y94Var)) {
                    u84 i = u84.i();
                    String str = y94Var.g;
                    long j = y94Var.i;
                    if (!i84.b().r(i.q(str, j, j))) {
                        arrayList.add(y94Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(ca4 ca4Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ca4Var)) == null) {
            if (ca4Var == null || ca4Var.c() == null || (optJSONObject = ca4Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public r94 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new r94(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new r94(2101, Log.getStackTraceString(exc));
        }
        return (r94) invokeLL.objValue;
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

    public void l(s94 s94Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, s94Var, fe4Var) == null) || s94Var == null) {
            return;
        }
        fe4Var.a(s94Var, PMSPkgStatus.WAIT);
    }

    public void m(u94 u94Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, u94Var, fe4Var) == null) || u94Var == null) {
            return;
        }
        fe4Var.a(u94Var, PMSPkgStatus.WAIT);
    }

    public void n(List<y94> list, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, fe4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (y94 y94Var : list) {
            fe4Var.a(y94Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(w94 w94Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, w94Var, fe4Var) == null) || w94Var == null) {
            return;
        }
        fe4Var.a(w94Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.ga4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            r94 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.ga4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new r94(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<x94> list, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, fe4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (x94 x94Var : list) {
            fe4Var.a(x94Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(y94 y94Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, y94Var, fe4Var) == null) || y94Var == null) {
            return;
        }
        fe4Var.a(y94Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        r84 p;
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

    public abstract r94 t(T t);

    public abstract T u(JSONObject jSONObject);
}
