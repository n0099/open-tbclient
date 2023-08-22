package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class p3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String c = "plc001_t_re";
    public static final String d = "wlpauct2";
    public static final String e = "plc001_pd_ptip_pi";
    public static final String f = "wiipaot";
    public static final int g = 1;
    public static final String h = "a1_p_s_p_s";
    public static final String i = "a1_p_s_p_s_c_b";
    public static p3 j;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public SharedPreferences.Editor b;

    public p3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(i1.r, 4);
            this.a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static p3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? j : (p3) invokeV.objValue;
    }

    public static synchronized p3 a(Context context) {
        InterceptResult invokeL;
        p3 p3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (p3.class) {
                try {
                    if (j == null) {
                        j = new p3(context);
                    }
                    p3Var = j;
                } catch (Exception unused) {
                    return null;
                }
            }
            return p3Var;
        }
        return (p3) invokeL.objValue;
    }

    public int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            try {
                return this.a.getInt(str, i2);
            } catch (Throwable unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? this.a.getString(str, str2) : (String) invokeLL.objValue;
    }

    public void a(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                this.b.putInt(str, i2);
                if (z) {
                    this.b.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            try {
                this.b.putLong(str, j2);
                if (z) {
                    this.b.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, Boolean bool, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, bool, z) == null) {
            try {
                if (this.b != null) {
                    this.b.putBoolean(str, bool.booleanValue());
                    if (z) {
                        this.b.apply();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.a.getBoolean(str, false) : invokeL.booleanValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.a.getLong(str, 0L) : invokeL.longValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            try {
                this.b.putString(str, str2);
                this.b.apply();
            } catch (Exception unused) {
            }
        }
    }
}
