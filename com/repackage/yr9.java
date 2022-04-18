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
public class yr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONStringer b;
    public String c;

    public yr9(cs9 cs9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cs9Var, context};
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

    public yr9 a(int i, long j) {
        JSONStringer object;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                object = new JSONStringer().object();
                this.b = object;
                l("e", "bce");
                l("timeis", cs9.e());
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeCommon.objValue;
    }

    public yr9 b(gs9 gs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gs9Var)) == null) {
            try {
                this.b = cs9.d("ao", gs9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeL.objValue;
    }

    public yr9 c(gs9 gs9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gs9Var, i)) == null) {
            try {
                this.b = cs9.d("rle", gs9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLI.objValue;
    }

    public yr9 d(gs9 gs9Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, gs9Var, i, i2)) == null) {
            try {
                this.b = cs9.d("asr", gs9Var);
                k("width", i);
                k("height", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLII.objValue;
    }

    public yr9 e(gs9 gs9Var, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{gs9Var, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = cs9.d("bpe", gs9Var);
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeCommon.objValue;
    }

    public yr9 f(gs9 gs9Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, gs9Var, i, str)) == null) {
            try {
                this.b = cs9.d("wbe", gs9Var);
                k("co", i);
                l("msg", cs9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLIL.objValue;
    }

    public yr9 g(gs9 gs9Var, long j, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{gs9Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                this.b = cs9.d("be", gs9Var);
                k("dr", j);
                k("co", i);
                k("num", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeCommon.objValue;
    }

    public yr9 h(gs9 gs9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, gs9Var, str)) == null) {
            try {
                this.b = cs9.d(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, gs9Var);
                l("msg", cs9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLL.objValue;
    }

    public yr9 i(gs9 gs9Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, gs9Var, str, i)) == null) {
            try {
                this.b = cs9.d("dplop", gs9Var);
                l("msg", cs9.b(str));
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLLI.objValue;
    }

    public yr9 j(gs9 gs9Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, gs9Var, str, i, i2)) == null) {
            try {
                this.b = cs9.d("wdre", gs9Var);
                try {
                    str = wp9.g(str);
                } catch (Exception unused) {
                }
                l("pkg", str);
                k("vsc", i);
                k("co", i2);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (yr9) invokeLLII.objValue;
    }

    public yr9 k(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLJ.objValue;
    }

    public yr9 l(String str, String str2) {
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
        return (yr9) invokeLL.objValue;
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
                boolean z = !wp9.u(cs9.a, optString);
                jSONArray.put(jSONObject);
                tr9.b(new vr9(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (mr9.G(this.a) < 0) {
                return false;
            }
            return wp9.u(cs9.a, str) ? mr9.G(this.a) < 1 : wp9.u(cs9.b, str) ? mr9.G(this.a) < 2 : wp9.u(cs9.c, str) ? mr9.G(this.a) < 3 : wp9.u(cs9.d, str) && mr9.G(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public yr9 o(gs9 gs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, gs9Var)) == null) {
            try {
                this.b = cs9.d("as", gs9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeL.objValue;
    }

    public yr9 p(gs9 gs9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, gs9Var, i)) == null) {
            try {
                this.b = cs9.d("wde", gs9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLI.objValue;
    }

    public yr9 q(gs9 gs9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, gs9Var, i)) == null) {
            try {
                this.b = cs9.d("wdin", gs9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (yr9) invokeLI.objValue;
    }
}
