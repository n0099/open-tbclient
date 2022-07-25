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
/* loaded from: classes8.dex */
public class d1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONStringer b;
    public String c;

    public d1(e1 e1Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e1Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new JSONStringer();
        this.c = "";
        this.a = context;
    }

    public d1 a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = e1.b();
                a("e", "bce").a("timeis", e1.a()).a("co", i).a("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeCommon.objValue;
    }

    public d1 a(f1 f1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f1Var)) == null) {
            try {
                this.b = e1.a("ao", f1Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeL.objValue;
    }

    public d1 a(f1 f1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, f1Var, i)) == null) {
            try {
                this.b = e1.a("rle", f1Var);
                a("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLI.objValue;
    }

    public d1 a(f1 f1Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, f1Var, i, i2)) == null) {
            try {
                this.b = e1.a("as", f1Var);
                a("width", i);
                a("height", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLII.objValue;
    }

    public d1 a(f1 f1Var, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{f1Var, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = e1.a("bpe", f1Var);
                a("co", i).a("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeCommon.objValue;
    }

    public d1 a(f1 f1Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, f1Var, i, str)) == null) {
            try {
                this.b = e1.a("wbe", f1Var);
                a("co", i).a("msg", e1.a(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLIL.objValue;
    }

    public d1 a(f1 f1Var, long j, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{f1Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                this.b = e1.a("be", f1Var);
                a("dr", j).a("co", i).a("num", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeCommon.objValue;
    }

    public d1 a(f1 f1Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, f1Var, str)) == null) {
            try {
                this.b = e1.a("ac", f1Var);
                a("msg", e1.a(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLL.objValue;
    }

    public d1 a(f1 f1Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, f1Var, str, i)) == null) {
            try {
                this.b = e1.a("dplop", f1Var);
                a("msg", e1.a(str));
                a("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLLI.objValue;
    }

    public d1 a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLJ.objValue;
    }

    public d1 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.b.key(str).value(str2);
                }
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLL.objValue;
    }

    public d1 b(f1 f1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, f1Var)) == null) {
            try {
                this.b = e1.a("irs", f1Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeL.objValue;
    }

    public d1 b(f1 f1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, f1Var, i)) == null) {
            try {
                this.b = e1.a("wde", f1Var);
                a("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLI.objValue;
    }

    public d1 c(f1 f1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, f1Var, i)) == null) {
            try {
                this.b = e1.a("wdin", f1Var);
                a("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (d1) invokeLI.objValue;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (Z1.n(this.a) < 0) {
                return false;
            }
            return M.a(e1.a, str) ? Z1.n(this.a) < 1 : M.a(e1.b, str) ? Z1.n(this.a) < 2 : M.a(e1.c, str) ? Z1.n(this.a) < 3 : M.a(e1.d, str) && Z1.n(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.b.toString())) {
                    this.b.endObject();
                    this.c = this.b.toString();
                }
                JSONObject jSONObject = new JSONObject(this.c);
                String optString = jSONObject.optString("e");
                if (a(optString)) {
                    return;
                }
                boolean z = !M.a(e1.a, optString);
                jSONArray.put(jSONObject);
                b2.a(new c1(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public d1 a(f1 f1Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, f1Var, str, i, i2)) == null) {
            try {
                this.b = e1.a("wdre", f1Var);
                try {
                    str = M.a(str);
                } catch (Exception unused) {
                }
                a("pkg", str);
                a("vsc", i);
                a("co", i2);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (d1) invokeLLII.objValue;
    }
}
