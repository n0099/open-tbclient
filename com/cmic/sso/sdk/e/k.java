package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static Context a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SharedPreferences.Editor a;

        public a(SharedPreferences.Editor editor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editor;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.remove(d.a(str));
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.apply();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.commit();
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.a.clear();
            }
        }

        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                this.a.putInt(d.a(str), i);
            }
        }

        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
                this.a.putLong(d.a(str), j);
            }
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                this.a.putString(d.a(str), str2);
            }
        }
    }

    public static int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            return a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i);
        }
        return invokeLI.intValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            return a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
        }
        return (String) invokeLL.objValue;
    }

    public static int a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, str, str2, i)) == null) {
            return a.getSharedPreferences(str, 0).getInt(d.a(str2), i);
        }
        return invokeLLI.intValue;
    }

    public static long a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j)) == null) {
            return a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j);
        }
        return invokeLJ.longValue;
    }

    public static long a(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            return a.getSharedPreferences(str, 0).getLong(d.a(str2), j);
        }
        return invokeCommon.longValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new a(a.getSharedPreferences("ssoconfigs", 0).edit());
        }
        return (a) invokeV.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, str3)) == null) {
            return a.getSharedPreferences(str, 0).getString(d.a(str2), str3);
        }
        return (String) invokeLLL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            a = context.getApplicationContext();
        }
    }

    public static a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return new a(a.getSharedPreferences(str, 0).edit());
        }
        return (a) invokeL.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
            sharedPreferences.edit().remove(d.a(str)).commit();
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            SharedPreferences sharedPreferences = a.getSharedPreferences("ssoconfigs", 0);
            sharedPreferences.edit().putString(d.a(str), str2).commit();
        }
    }

    public static void a(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, map) == null) && map != null && !map.isEmpty()) {
            SharedPreferences.Editor edit = a.getSharedPreferences("ssoconfigs", 0).edit();
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                String a2 = d.a(str);
                if (obj instanceof String) {
                    edit.putString(a2, (String) obj);
                } else if (obj instanceof Integer) {
                    edit.putInt(a2, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    edit.putLong(a2, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(a2, ((Boolean) obj).booleanValue());
                }
            }
            edit.commit();
        }
    }
}
