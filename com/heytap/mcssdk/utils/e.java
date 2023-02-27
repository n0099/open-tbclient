package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import com.yy.hiidostatis.inner.util.cipher.Coder;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "shared_msg_sdk";
    public static final String b = "hasDefaultChannelCreated";
    public static final String c = "lastUpLoadInfoSDKVersionName";
    public static final String d = "lastUploadInfoUniqueID";
    public static final String e = "decryptTag";
    public transient /* synthetic */ FieldHolder $fh;
    public Context f;
    public SharedPreferences g;
    public Object h;

    /* renamed from: com.heytap.mcssdk.utils.e$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static e a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1142714085, "Lcom/heytap/mcssdk/utils/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1142714085, "Lcom/heytap/mcssdk/utils/e$a;");
                    return;
                }
            }
            a = new e(null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new Object();
        Context context = PushService.getInstance().getContext();
        if (context != null) {
            this.f = a(context);
        }
        Context context2 = this.f;
        if (context2 != null) {
            this.g = context2.getSharedPreferences(a, 0);
        }
    }

    public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    private Context a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            boolean a2 = com.heytap.mcssdk.utils.a.a();
            d.b("fbeVersion is " + a2);
            return (!a2 || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
        }
        return (Context) invokeL.objValue;
    }

    public static e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (e) invokeV.objValue;
    }

    private SharedPreferences g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            SharedPreferences sharedPreferences = this.g;
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            synchronized (this.h) {
                if (this.g != null || this.f == null) {
                    return this.g;
                }
                SharedPreferences sharedPreferences2 = this.f.getSharedPreferences(a, 0);
                this.g = sharedPreferences2;
                return sharedPreferences2;
            }
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            SharedPreferences g = g();
            return g != null ? g.getInt(str, i) : i;
        }
        return invokeLI.intValue;
    }

    public long a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            SharedPreferences g = g();
            return g != null ? g.getLong(str, j) : j;
        }
        return invokeLJ.longValue;
    }

    public void a(String str) {
        SharedPreferences g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (g = g()) == null) {
            return;
        }
        g.edit().putString(d, str).commit();
    }

    public void a(boolean z) {
        SharedPreferences g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (g = g()) == null) {
            return;
        }
        g.edit().putBoolean(b, z).commit();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SharedPreferences g = g();
            if (g != null) {
                return g.getBoolean(b, false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        SharedPreferences g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (g = g()) == null) {
            return;
        }
        g.edit().putString(c, "3.0.0").commit();
    }

    public void b(String str) {
        SharedPreferences g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (g = g()) == null) {
            return;
        }
        g.edit().putString(e, str).commit();
    }

    public void b(String str, int i) {
        SharedPreferences g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) || (g = g()) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void b(String str, long j) {
        SharedPreferences g;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j) == null) || (g = g()) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            SharedPreferences g = g();
            if (g != null) {
                return g.getInt(str, 0);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SharedPreferences g = g();
            return g != null ? g.getString(d, "") : "";
        }
        return (String) invokeV.objValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            SharedPreferences g = g();
            return g != null ? g.getLong(str, com.heytap.mcssdk.constant.a.b.longValue()) : com.heytap.mcssdk.constant.a.b.longValue();
        }
        return invokeL.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SharedPreferences g = g();
            return g != null ? g.getString(c, "") : "";
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SharedPreferences g = g();
            return g != null ? g.getString(e, Coder.KEY_DES) : Coder.KEY_DES;
        }
        return (String) invokeV.objValue;
    }
}
