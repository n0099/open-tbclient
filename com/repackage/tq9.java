package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.d.D;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes7.dex */
public class tq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONStringer b;
    public String c;

    public tq9(xq9 xq9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xq9Var, context};
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

    public tq9 a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = xq9.c();
                l("e", "bce");
                l("timeis", xq9.e());
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeCommon.objValue;
    }

    public tq9 b(br9 br9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, br9Var)) == null) {
            try {
                this.b = xq9.d("ao", br9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeL.objValue;
    }

    public tq9 c(br9 br9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, br9Var, i)) == null) {
            try {
                this.b = xq9.d("rle", br9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLI.objValue;
    }

    public tq9 d(br9 br9Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, br9Var, i, i2)) == null) {
            try {
                this.b = xq9.d("asr", br9Var);
                k("width", i);
                k("height", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLII.objValue;
    }

    public tq9 e(br9 br9Var, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{br9Var, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = xq9.d("bpe", br9Var);
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeCommon.objValue;
    }

    public tq9 f(br9 br9Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, br9Var, i, str)) == null) {
            try {
                this.b = xq9.d("wbe", br9Var);
                k("co", i);
                l("msg", xq9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLIL.objValue;
    }

    public tq9 g(br9 br9Var, long j, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{br9Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                this.b = xq9.d("be", br9Var);
                k("dr", j);
                k("co", i);
                k("num", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeCommon.objValue;
    }

    public tq9 h(br9 br9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, br9Var, str)) == null) {
            try {
                this.b = xq9.d(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, br9Var);
                l("msg", xq9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLL.objValue;
    }

    public tq9 i(br9 br9Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, br9Var, str, i)) == null) {
            try {
                this.b = xq9.d("dplop", br9Var);
                l("msg", xq9.b(str));
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLLI.objValue;
    }

    public tq9 j(br9 br9Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, br9Var, str, i, i2)) == null) {
            try {
                this.b = xq9.d("wdre", br9Var);
                try {
                    str = ro9.g(str);
                } catch (Exception unused) {
                }
                l("pkg", str);
                k("vsc", i);
                k("co", i2);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (tq9) invokeLLII.objValue;
    }

    public tq9 k(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLJ.objValue;
    }

    public tq9 l(String str, String str2) {
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
        return (tq9) invokeLL.objValue;
    }

    public void m() {
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
                if (n(optString)) {
                    return;
                }
                boolean z = !ro9.u(xq9.a, optString);
                jSONArray.put(jSONObject);
                oq9.b(new qq9(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (hq9.G(this.a) < 0) {
                return false;
            }
            return ro9.u(xq9.a, str) ? hq9.G(this.a) < 1 : ro9.u(xq9.b, str) ? hq9.G(this.a) < 2 : ro9.u(xq9.c, str) ? hq9.G(this.a) < 3 : ro9.u(xq9.d, str) && hq9.G(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public tq9 o(br9 br9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, br9Var)) == null) {
            try {
                this.b = xq9.d("as", br9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeL.objValue;
    }

    public tq9 p(br9 br9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, br9Var, i)) == null) {
            try {
                this.b = xq9.d("wde", br9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLI.objValue;
    }

    public tq9 q(br9 br9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, br9Var, i)) == null) {
            try {
                this.b = xq9.d("wdin", br9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (tq9) invokeLI.objValue;
    }
}
