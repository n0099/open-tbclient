package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "re_po_rt";
    public static i e;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public SharedPreferences.Editor b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1651774762, "Lcom/kuaishou/weapon/p0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1651774762, "Lcom/kuaishou/weapon/p0/i;");
        }
    }

    public i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        try {
            this.c = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized i a(Context context, String str) {
        InterceptResult invokeLL;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (i.class) {
                if (e == null) {
                    synchronized (i.class) {
                        if (e == null) {
                            e = new i(context, str);
                        }
                    }
                }
                iVar = e;
            }
            return iVar;
        }
        return (i) invokeLL.objValue;
    }

    public static i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? e : (i) invokeV.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return this.a.getInt(str, 0);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            try {
                return this.a.getInt(str, i);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public long a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) ? this.a.getLong(str, j) : invokeLJ.longValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.a.getString(str, str2) : (String) invokeLL.objValue;
    }

    public String a(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, str, str2, z)) == null) {
            String a = a(str, "");
            return !TextUtils.isEmpty(a) ? z ? d.b(a, 2) : a : str2;
        }
        return (String) invokeLLZ.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.b.apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.c = context;
        }
    }

    public void a(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                this.b.putInt(str, i);
                if (z) {
                    this.b.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bool) == null) {
            this.b.putBoolean(str, bool.booleanValue());
            this.b.apply();
        }
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            try {
                return this.a.getInt(str, i);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c : (Context) invokeV.objValue;
    }

    public void b(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            this.b.putLong(str, j);
            this.b.apply();
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            try {
                this.b.putString(str, str2);
                this.b.apply();
            } catch (Exception unused) {
            }
        }
    }

    public void b(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, str, str2, z) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (z) {
                    str2 = d.c(str2.getBytes(), 2);
                }
                this.b.putString(str, str2);
                this.b.apply();
            } catch (Throwable unused) {
            }
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.a.getBoolean(str, false) : invokeL.booleanValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                return this.a.getInt(str, 0);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) {
            try {
                this.b.putInt(str, i);
                this.b.apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.b.putString(str, str2);
                this.b.apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048594, this, str, str2, z) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.b.putString(str, str2);
                if (z) {
                    this.b.apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? this.a.getLong(str, 0L) : invokeL.longValue;
    }

    public void d(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, str, i) == null) {
            this.b.putInt(str, i);
            this.b.apply();
        }
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? this.a.getString(str, "") : (String) invokeL.objValue;
    }
}
