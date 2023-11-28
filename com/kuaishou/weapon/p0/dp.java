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
public class dp {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "plc001_t_re";
    public static final String b = "wlpauct2";
    public static final String c = "plc001_pd_ptip_pi";
    public static final String d = "wiipaot";
    public static final int e = 1;
    public static final String f = "a1_p_s_p_s";
    public static final String g = "a1_p_s_p_s_c_b";
    public static dp j;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences h;
    public SharedPreferences.Editor i;

    public dp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(bi.r, 4);
            this.h = sharedPreferences;
            this.i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static dp a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return j;
        }
        return (dp) invokeV.objValue;
    }

    public static synchronized dp a(Context context) {
        InterceptResult invokeL;
        dp dpVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (dp.class) {
                try {
                    if (j == null) {
                        j = new dp(context);
                    }
                    dpVar = j;
                } catch (Exception unused) {
                    return null;
                }
            }
            return dpVar;
        }
        return (dp) invokeL.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return this.h.getBoolean(str, false);
        }
        return invokeL.booleanValue;
    }

    public int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            try {
                return this.h.getInt(str, i);
            } catch (Throwable unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            try {
                this.i.putString(str, str2);
                this.i.apply();
            } catch (Exception unused) {
            }
        }
    }

    public long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.h.getLong(str, 0L);
        }
        return invokeL.longValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            return this.h.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void a(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                this.i.putInt(str, i);
                if (z) {
                    this.i.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            try {
                this.i.putLong(str, j2);
                if (z) {
                    this.i.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, Boolean bool, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, str, bool, z) == null) {
            try {
                if (this.i != null) {
                    this.i.putBoolean(str, bool.booleanValue());
                    if (z) {
                        this.i.apply();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
