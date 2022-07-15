package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʽﹶ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0390 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final String f344 = "plc001_t_re";

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final String f345 = "wlpauct2";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final String f346 = "plc001_pd_ptip_pi";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final String f347 = "wiipaot";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final int f348 = 1;

    /* renamed from: ˉ  reason: contains not printable characters */
    public static final String f349 = "a1_p_s_p_s";

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final String f350 = "a1_p_s_p_s_c_b";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0390 f351;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public SharedPreferences f352;

    /* renamed from: ʼ  reason: contains not printable characters */
    public SharedPreferences.Editor f353;

    public C0390(Context context) {
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
            SharedPreferences sharedPreferences = context.getSharedPreferences(C0453.f717, 4);
            this.f352 = sharedPreferences;
            this.f353 = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0390 m478() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f351 : (C0390) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static synchronized C0390 m479(Context context) {
        InterceptResult invokeL;
        C0390 c0390;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (C0390.class) {
                try {
                    if (f351 == null) {
                        f351 = new C0390(context);
                    }
                    c0390 = f351;
                } catch (Exception unused) {
                    return null;
                }
            }
            return c0390;
        }
        return (C0390) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m480(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            try {
                return this.f352.getInt(str, i);
            } catch (Throwable unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m481(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? this.f352.getString(str, str2) : (String) invokeLL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m482(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                this.f353.putInt(str, i);
                if (z) {
                    this.f353.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m483(String str, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            try {
                this.f353.putLong(str, j);
                if (z) {
                    this.f353.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m484(String str, Boolean bool, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, bool, z) == null) {
            try {
                if (this.f353 != null) {
                    this.f353.putBoolean(str, bool.booleanValue());
                    if (z) {
                        this.f353.apply();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m485(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f352.getBoolean(str, false) : invokeL.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public long m486(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f352.getLong(str, 0L) : invokeL.longValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m487(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            try {
                this.f353.putString(str, str2);
                this.f353.apply();
            } catch (Exception unused) {
            }
        }
    }
}
