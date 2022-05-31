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
/* loaded from: classes6.dex */
public class nn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONStringer b;
    public String c;

    public nn9(rn9 rn9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rn9Var, context};
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

    public nn9 a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = rn9.c();
                l("e", "bce");
                l("timeis", rn9.e());
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeCommon.objValue;
    }

    public nn9 b(vn9 vn9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vn9Var)) == null) {
            try {
                this.b = rn9.d("ao", vn9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeL.objValue;
    }

    public nn9 c(vn9 vn9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, vn9Var, i)) == null) {
            try {
                this.b = rn9.d("rle", vn9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLI.objValue;
    }

    public nn9 d(vn9 vn9Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, vn9Var, i, i2)) == null) {
            try {
                this.b = rn9.d("asr", vn9Var);
                k("width", i);
                k("height", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLII.objValue;
    }

    public nn9 e(vn9 vn9Var, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{vn9Var, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = rn9.d("bpe", vn9Var);
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeCommon.objValue;
    }

    public nn9 f(vn9 vn9Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, vn9Var, i, str)) == null) {
            try {
                this.b = rn9.d("wbe", vn9Var);
                k("co", i);
                l("msg", rn9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLIL.objValue;
    }

    public nn9 g(vn9 vn9Var, long j, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{vn9Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                this.b = rn9.d("be", vn9Var);
                k("dr", j);
                k("co", i);
                k("num", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeCommon.objValue;
    }

    public nn9 h(vn9 vn9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, vn9Var, str)) == null) {
            try {
                this.b = rn9.d(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, vn9Var);
                l("msg", rn9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLL.objValue;
    }

    public nn9 i(vn9 vn9Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, vn9Var, str, i)) == null) {
            try {
                this.b = rn9.d("dplop", vn9Var);
                l("msg", rn9.b(str));
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLLI.objValue;
    }

    public nn9 j(vn9 vn9Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, vn9Var, str, i, i2)) == null) {
            try {
                this.b = rn9.d("wdre", vn9Var);
                try {
                    str = ll9.g(str);
                } catch (Exception unused) {
                }
                l("pkg", str);
                k("vsc", i);
                k("co", i2);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (nn9) invokeLLII.objValue;
    }

    public nn9 k(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLJ.objValue;
    }

    public nn9 l(String str, String str2) {
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
        return (nn9) invokeLL.objValue;
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
                boolean z = !ll9.u(rn9.a, optString);
                jSONArray.put(jSONObject);
                in9.b(new kn9(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (bn9.G(this.a) < 0) {
                return false;
            }
            return ll9.u(rn9.a, str) ? bn9.G(this.a) < 1 : ll9.u(rn9.b, str) ? bn9.G(this.a) < 2 : ll9.u(rn9.c, str) ? bn9.G(this.a) < 3 : ll9.u(rn9.d, str) && bn9.G(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public nn9 o(vn9 vn9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vn9Var)) == null) {
            try {
                this.b = rn9.d("as", vn9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeL.objValue;
    }

    public nn9 p(vn9 vn9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, vn9Var, i)) == null) {
            try {
                this.b = rn9.d("wde", vn9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLI.objValue;
    }

    public nn9 q(vn9 vn9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, vn9Var, i)) == null) {
            try {
                this.b = rn9.d("wdin", vn9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (nn9) invokeLI.objValue;
    }
}
