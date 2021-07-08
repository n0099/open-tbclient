package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes6.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39696a;

    /* renamed from: b  reason: collision with root package name */
    public JSONStringer f39697b;

    /* renamed from: c  reason: collision with root package name */
    public String f39698c;

    public w0(x0 x0Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39697b = new JSONStringer();
        this.f39698c = "";
        this.f39696a = context;
    }

    public w0 a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                this.f39697b = x0.a();
                a("e", "bce").a("timeis", x0.b()).a("co", i2).a("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeCommon.objValue;
    }

    public w0 a(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y0Var)) == null) {
            try {
                this.f39697b = x0.a("as", y0Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeL.objValue;
    }

    public w0 a(y0 y0Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, y0Var, i2)) == null) {
            try {
                this.f39697b = x0.a("wde", y0Var);
                a("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLI.objValue;
    }

    public w0 a(y0 y0Var, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, y0Var, i2, i3)) == null) {
            try {
                this.f39697b = x0.a("asr", y0Var);
                a("width", i2);
                a("height", i3);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLII.objValue;
    }

    public w0 a(y0 y0Var, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{y0Var, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                this.f39697b = x0.a("bpe", y0Var);
                a("co", i2).a("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeCommon.objValue;
    }

    public w0 a(y0 y0Var, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, y0Var, i2, str)) == null) {
            try {
                this.f39697b = x0.a("wbe", y0Var);
                a("co", i2).a("msg", x0.a(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLIL.objValue;
    }

    public w0 a(y0 y0Var, long j, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{y0Var, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            try {
                this.f39697b = x0.a("be", y0Var);
                a("dr", j).a("co", i2).a("num", i3);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeCommon.objValue;
    }

    public w0 a(y0 y0Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, y0Var, str)) == null) {
            try {
                this.f39697b = x0.a("ac", y0Var);
                a("msg", x0.a(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLL.objValue;
    }

    public w0 a(y0 y0Var, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, y0Var, str, i2)) == null) {
            try {
                this.f39697b = x0.a("dplop", y0Var);
                a("msg", x0.a(str));
                a("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLLI.objValue;
    }

    public w0 a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.f39697b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLJ.objValue;
    }

    public w0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.f39697b.key(str).value(str2);
                }
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLL.objValue;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (s1.l(this.f39696a) < 0) {
                return false;
            }
            return z.a(x0.f39711a, str) ? s1.l(this.f39696a) < 1 : z.a(x0.f39712b, str) ? s1.l(this.f39696a) < 2 : z.a(x0.f39713c, str) ? s1.l(this.f39696a) < 3 : z.a(x0.f39714d, str) && s1.l(this.f39696a) < 4;
        }
        return invokeL.booleanValue;
    }

    public w0 b(y0 y0Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, y0Var, i2)) == null) {
            try {
                this.f39697b = x0.a("wdin", y0Var);
                a("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (w0) invokeLI.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.f39697b.toString())) {
                    this.f39697b.endObject();
                    this.f39698c = this.f39697b.toString();
                }
                JSONObject jSONObject = new JSONObject(this.f39698c);
                String optString = jSONObject.optString("e");
                if (a(optString)) {
                    return;
                }
                boolean z = !z.a(x0.f39711a, optString);
                jSONArray.put(jSONObject);
                u1.a(new v0(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public w0 a(y0 y0Var, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, y0Var, str, i2, i3)) == null) {
            try {
                this.f39697b = x0.a("wdre", y0Var);
                try {
                    str = z.a(str);
                } catch (Exception unused) {
                }
                a("pkg", str);
                a("vsc", i2);
                a("co", i3);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (w0) invokeLLII.objValue;
    }
}
