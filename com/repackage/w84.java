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
import com.repackage.z84;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class w84<T> implements z84.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l74 a;
    public wa4 b;
    public String c;

    public w84(l74 l74Var, wa4 wa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l74Var, wa4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = l74Var;
        this.b = wa4Var;
    }

    public void a(k84 k84Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, k84Var, str, str2, str3) == null) {
            d(k84Var, str, str2, str3, null);
        }
    }

    @Override // com.repackage.z84.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            l74 l74Var = this.a;
            if (l74Var != null) {
                l74Var.I(str, str2, jSONObject);
            }
            this.c = str;
        }
    }

    @Override // com.repackage.z84.a
    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            l74 l74Var = this.a;
            if (l74Var != null) {
                l74Var.H(str, i);
            }
            if (i != 200) {
                k84 k84Var = new k84(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
                k84Var.f = i;
                l74 l74Var2 = this.a;
                if (l74Var2 != null) {
                    l74Var2.C(k84Var);
                }
                a(k84Var, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            v84 a = v84.a(str);
            if (a == null) {
                JSONObject p = xc4.p(str);
                k84 k84Var2 = new k84(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                l74 l74Var3 = this.a;
                if (l74Var3 != null) {
                    l74Var3.C(k84Var2);
                }
                a(k84Var2, str, String.valueOf(i), String.valueOf(this.b.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i)) {
                return;
            }
            int d = a.d();
            if (d != 0) {
                k84 k84Var3 = new k84(d, a.e(), a.g(), i(a));
                l74 l74Var4 = this.a;
                if (l74Var4 != null) {
                    l74Var4.C(k84Var3);
                }
                if (a.d() != 1010) {
                    d(k84Var3, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                }
            } else if (u == null) {
                k84 k84Var4 = new k84(2102, "response data empty");
                l74 l74Var5 = this.a;
                if (l74Var5 != null) {
                    l74Var5.C(k84Var4);
                }
                d(k84Var4, str, String.valueOf(i), String.valueOf(this.b.b()), a);
            } else {
                k84 e = e(str, u);
                if (e != null) {
                    l74 l74Var6 = this.a;
                    if (l74Var6 != null) {
                        l74Var6.C(e);
                    }
                    d(e, str, String.valueOf(i), String.valueOf(this.b.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void d(k84 k84Var, String str, String str2, String str3, @Nullable v84 v84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, k84Var, str, str2, str3, v84Var) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (k84Var != null) {
                try {
                    if (k84Var.a != 0) {
                        i = k84Var.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("statusCode", str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.c) && k84Var.a != 2000) {
                            jSONObject.put("request_url", this.c);
                        }
                        jSONObject.put("hostName", b74.b().c());
                        jSONObject.put("network", rf4.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.b instanceof sa4) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((sa4) this.b).g());
            }
            if (v84Var != null && v84Var.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, v84Var.f());
            }
            z64 b = b74.b();
            if (b != null && b.u() != null) {
                jSONObject.put("launchid", b.u());
            }
            qc4.a(this.b.a(), "cs_protocol", h(), i, jSONObject);
        }
    }

    @CallSuper
    public k84 e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new k84(2103, str);
        }
        return (k84) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<r84> g(@Nullable List<r84> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (r84 r84Var : list) {
                if (r84Var != null && !arrayList.contains(r84Var)) {
                    n74 i = n74.i();
                    String str = r84Var.g;
                    long j = r84Var.i;
                    if (!b74.b().r(i.q(str, j, j))) {
                        arrayList.add(r84Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(v84 v84Var) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v84Var)) == null) {
            if (v84Var == null || v84Var.c() == null || (optJSONObject = v84Var.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public k84 j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new k84(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new k84(2101, Log.getStackTraceString(exc));
        }
        return (k84) invokeLL.objValue;
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

    public void l(l84 l84Var, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, l84Var, yc4Var) == null) || l84Var == null) {
            return;
        }
        yc4Var.a(l84Var, PMSPkgStatus.WAIT);
    }

    public void m(n84 n84Var, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, n84Var, yc4Var) == null) || n84Var == null) {
            return;
        }
        yc4Var.a(n84Var, PMSPkgStatus.WAIT);
    }

    public void n(List<r84> list, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, yc4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (r84 r84Var : list) {
            yc4Var.a(r84Var, PMSPkgStatus.WAIT);
        }
    }

    public void o(p84 p84Var, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, p84Var, yc4Var) == null) || p84Var == null) {
            return;
        }
        yc4Var.a(p84Var, PMSPkgStatus.WAIT);
    }

    @Override // com.repackage.z84.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            k84 j = j(exc, k(exc.getMessage()));
            this.a.C(j);
            a(j, exc.getMessage(), null, String.valueOf(this.b.b()));
        }
    }

    @Override // com.repackage.z84.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(new k84(2000, "send request"), null, null, String.valueOf(this.b.b()));
        }
    }

    public void p(List<q84> list, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, yc4Var) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (q84 q84Var : list) {
            yc4Var.a(q84Var, PMSPkgStatus.WAIT);
        }
    }

    public void q(r84 r84Var, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, r84Var, yc4Var) == null) || r84Var == null) {
            return;
        }
        yc4Var.a(r84Var, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        k74 p;
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

    public abstract k84 t(T t);

    public abstract T u(JSONObject jSONObject);
}
