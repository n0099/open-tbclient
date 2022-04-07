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
public class rr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONStringer b;
    public String c;

    public rr9(vr9 vr9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vr9Var, context};
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

    public rr9 a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = vr9.c();
                l("e", "bce");
                l("timeis", vr9.e());
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeCommon.objValue;
    }

    public rr9 b(zr9 zr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zr9Var)) == null) {
            try {
                this.b = vr9.d("ao", zr9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeL.objValue;
    }

    public rr9 c(zr9 zr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, zr9Var, i)) == null) {
            try {
                this.b = vr9.d("rle", zr9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLI.objValue;
    }

    public rr9 d(zr9 zr9Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, zr9Var, i, i2)) == null) {
            try {
                this.b = vr9.d("asr", zr9Var);
                k("width", i);
                k("height", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLII.objValue;
    }

    public rr9 e(zr9 zr9Var, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{zr9Var, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = vr9.d("bpe", zr9Var);
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeCommon.objValue;
    }

    public rr9 f(zr9 zr9Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, zr9Var, i, str)) == null) {
            try {
                this.b = vr9.d("wbe", zr9Var);
                k("co", i);
                l("msg", vr9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLIL.objValue;
    }

    public rr9 g(zr9 zr9Var, long j, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{zr9Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                this.b = vr9.d("be", zr9Var);
                k("dr", j);
                k("co", i);
                k("num", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeCommon.objValue;
    }

    public rr9 h(zr9 zr9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, zr9Var, str)) == null) {
            try {
                this.b = vr9.d(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, zr9Var);
                l("msg", vr9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLL.objValue;
    }

    public rr9 i(zr9 zr9Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, zr9Var, str, i)) == null) {
            try {
                this.b = vr9.d("dplop", zr9Var);
                l("msg", vr9.b(str));
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLLI.objValue;
    }

    public rr9 j(zr9 zr9Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, zr9Var, str, i, i2)) == null) {
            try {
                this.b = vr9.d("wdre", zr9Var);
                try {
                    str = pp9.g(str);
                } catch (Exception unused) {
                }
                l("pkg", str);
                k("vsc", i);
                k("co", i2);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (rr9) invokeLLII.objValue;
    }

    public rr9 k(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLJ.objValue;
    }

    public rr9 l(String str, String str2) {
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
        return (rr9) invokeLL.objValue;
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
                boolean z = !pp9.u(vr9.a, optString);
                jSONArray.put(jSONObject);
                mr9.b(new or9(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (fr9.G(this.a) < 0) {
                return false;
            }
            return pp9.u(vr9.a, str) ? fr9.G(this.a) < 1 : pp9.u(vr9.b, str) ? fr9.G(this.a) < 2 : pp9.u(vr9.c, str) ? fr9.G(this.a) < 3 : pp9.u(vr9.d, str) && fr9.G(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public rr9 o(zr9 zr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, zr9Var)) == null) {
            try {
                this.b = vr9.d("as", zr9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeL.objValue;
    }

    public rr9 p(zr9 zr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, zr9Var, i)) == null) {
            try {
                this.b = vr9.d("wde", zr9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLI.objValue;
    }

    public rr9 q(zr9 zr9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, zr9Var, i)) == null) {
            try {
                this.b = vr9.d("wdin", zr9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (rr9) invokeLI.objValue;
    }
}
