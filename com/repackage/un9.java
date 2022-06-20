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
public class un9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONStringer b;
    public String c;

    public un9(yn9 yn9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yn9Var, context};
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

    public un9 a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = yn9.c();
                l("e", "bce");
                l("timeis", yn9.e());
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeCommon.objValue;
    }

    public un9 b(co9 co9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, co9Var)) == null) {
            try {
                this.b = yn9.d("ao", co9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeL.objValue;
    }

    public un9 c(co9 co9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, co9Var, i)) == null) {
            try {
                this.b = yn9.d("rle", co9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLI.objValue;
    }

    public un9 d(co9 co9Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, co9Var, i, i2)) == null) {
            try {
                this.b = yn9.d("asr", co9Var);
                k("width", i);
                k("height", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLII.objValue;
    }

    public un9 e(co9 co9Var, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{co9Var, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            try {
                this.b = yn9.d("bpe", co9Var);
                k("co", i);
                k("dr", j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeCommon.objValue;
    }

    public un9 f(co9 co9Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, co9Var, i, str)) == null) {
            try {
                this.b = yn9.d("wbe", co9Var);
                k("co", i);
                l("msg", yn9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLIL.objValue;
    }

    public un9 g(co9 co9Var, long j, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{co9Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                this.b = yn9.d("be", co9Var);
                k("dr", j);
                k("co", i);
                k("num", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeCommon.objValue;
    }

    public un9 h(co9 co9Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, co9Var, str)) == null) {
            try {
                this.b = yn9.d(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, co9Var);
                l("msg", yn9.b(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLL.objValue;
    }

    public un9 i(co9 co9Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, co9Var, str, i)) == null) {
            try {
                this.b = yn9.d("dplop", co9Var);
                l("msg", yn9.b(str));
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLLI.objValue;
    }

    public un9 j(co9 co9Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, co9Var, str, i, i2)) == null) {
            try {
                this.b = yn9.d("wdre", co9Var);
                try {
                    str = sl9.g(str);
                } catch (Exception unused) {
                }
                l("pkg", str);
                k("vsc", i);
                k("co", i2);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (un9) invokeLLII.objValue;
    }

    public un9 k(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            try {
                this.b.key(str).value(j);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLJ.objValue;
    }

    public un9 l(String str, String str2) {
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
        return (un9) invokeLL.objValue;
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
                boolean z = !sl9.u(yn9.a, optString);
                jSONArray.put(jSONObject);
                pn9.b(new rn9(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (in9.G(this.a) < 0) {
                return false;
            }
            return sl9.u(yn9.a, str) ? in9.G(this.a) < 1 : sl9.u(yn9.b, str) ? in9.G(this.a) < 2 : sl9.u(yn9.c, str) ? in9.G(this.a) < 3 : sl9.u(yn9.d, str) && in9.G(this.a) < 4;
        }
        return invokeL.booleanValue;
    }

    public un9 o(co9 co9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, co9Var)) == null) {
            try {
                this.b = yn9.d("as", co9Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeL.objValue;
    }

    public un9 p(co9 co9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, co9Var, i)) == null) {
            try {
                this.b = yn9.d("wde", co9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLI.objValue;
    }

    public un9 q(co9 co9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, co9Var, i)) == null) {
            try {
                this.b = yn9.d("wdin", co9Var);
                k("co", i);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (un9) invokeLI.objValue;
    }
}
