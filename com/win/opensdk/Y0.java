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
/* loaded from: classes10.dex */
public class Y0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f76553a;

    /* renamed from: b  reason: collision with root package name */
    public JSONStringer f76554b;

    /* renamed from: c  reason: collision with root package name */
    public String f76555c;

    public Y0(Z0 z0, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z0, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76554b = new JSONStringer();
        this.f76555c = "";
        this.f76553a = context;
    }

    public Y0 a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                this.f76554b = Z0.a();
                a("e", "bce").a("timeis", Z0.b()).a("co", i2).a("dr", j2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeCommon.objValue;
    }

    public Y0 a(a1 a1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a1Var)) == null) {
            try {
                this.f76554b = Z0.a("ao", a1Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeL.objValue;
    }

    public Y0 a(a1 a1Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, a1Var, i2)) == null) {
            try {
                this.f76554b = Z0.a("wde", a1Var);
                a("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLI.objValue;
    }

    public Y0 a(a1 a1Var, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, a1Var, i2, i3)) == null) {
            try {
                this.f76554b = Z0.a("asr", a1Var);
                a("width", i2);
                a("height", i3);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLII.objValue;
    }

    public Y0 a(a1 a1Var, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{a1Var, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            try {
                this.f76554b = Z0.a("bpe", a1Var);
                a("co", i2).a("dr", j2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeCommon.objValue;
    }

    public Y0 a(a1 a1Var, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, a1Var, i2, str)) == null) {
            try {
                this.f76554b = Z0.a("wbe", a1Var);
                a("co", i2).a("msg", Z0.a(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLIL.objValue;
    }

    public Y0 a(a1 a1Var, long j2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{a1Var, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            try {
                this.f76554b = Z0.a("be", a1Var);
                a("dr", j2).a("co", i2).a("num", i3);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeCommon.objValue;
    }

    public Y0 a(a1 a1Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, a1Var, str)) == null) {
            try {
                this.f76554b = Z0.a("ac", a1Var);
                a("msg", Z0.a(str));
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLL.objValue;
    }

    public Y0 a(a1 a1Var, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, a1Var, str, i2)) == null) {
            try {
                this.f76554b = Z0.a("dplop", a1Var);
                a("msg", Z0.a(str));
                a("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLLI.objValue;
    }

    public Y0 a(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j2)) == null) {
            try {
                this.f76554b.key(str).value(j2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLJ.objValue;
    }

    public Y0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    this.f76554b.key(str).value(str2);
                }
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLL.objValue;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (U1.m(this.f76553a) < 0) {
                return false;
            }
            return N.a(Z0.f76559a, str) ? U1.m(this.f76553a) < 1 : N.a(Z0.f76560b, str) ? U1.m(this.f76553a) < 2 : N.a(Z0.f76561c, str) ? U1.m(this.f76553a) < 3 : N.a(Z0.f76562d, str) && U1.m(this.f76553a) < 4;
        }
        return invokeL.booleanValue;
    }

    public Y0 b(a1 a1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, a1Var)) == null) {
            try {
                this.f76554b = Z0.a("as", a1Var);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeL.objValue;
    }

    public Y0 b(a1 a1Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, a1Var, i2)) == null) {
            try {
                this.f76554b = Z0.a("wdin", a1Var);
                a("co", i2);
            } catch (JSONException unused) {
            }
            return this;
        }
        return (Y0) invokeLI.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            JSONArray jSONArray = new JSONArray();
            try {
                if (!TextUtils.isEmpty(this.f76554b.toString())) {
                    this.f76554b.endObject();
                    this.f76555c = this.f76554b.toString();
                }
                JSONObject jSONObject = new JSONObject(this.f76555c);
                String optString = jSONObject.optString("e");
                if (a(optString)) {
                    return;
                }
                boolean z = !N.a(Z0.f76559a, optString);
                jSONArray.put(jSONObject);
                W1.a(new X0(this, z, jSONArray.toString()));
            } catch (JSONException unused) {
            }
        }
    }

    public Y0 a(a1 a1Var, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, a1Var, str, i2, i3)) == null) {
            try {
                this.f76554b = Z0.a("wdre", a1Var);
                try {
                    str = N.a(str);
                } catch (Exception unused) {
                }
                a("pkg", str);
                a("vsc", i2);
                a("co", i3);
            } catch (JSONException unused2) {
            }
            return this;
        }
        return (Y0) invokeLLII.objValue;
    }
}
