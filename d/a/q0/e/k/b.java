package d.a.q0.e.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f52467b = "b";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f52468c;

    /* renamed from: d  reason: collision with root package name */
    public static SharedPreferences f52469d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52470a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(949662642, "Ld/a/q0/e/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(949662642, "Ld/a/q0/e/k/b;");
                return;
            }
        }
        f52468c = k.f49133a;
        f52469d = null;
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52470a = null;
        this.f52470a = context;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                if (f52468c) {
                    String str = f52467b;
                    Log.e(str, "error:" + e2.getMessage());
                    return -1;
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static SharedPreferences c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f52469d == null) {
                f52469d = context.getSharedPreferences("downgradefile", 0);
            }
            return f52469d;
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static b d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? new b(context) : (b) invokeL.objValue;
    }

    public static void j(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2) == null) {
            if (f52468c) {
                String str = f52467b;
                Log.d(str, "set last version code:" + i2);
            }
            SharedPreferences.Editor edit = c(context).edit();
            edit.putInt("last_versioncode_key", i2);
            edit.apply();
        }
    }

    public final int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            int i2 = c(context).getInt("old_versioncode_key", 0);
            if (f52468c) {
                String str = f52467b;
                Log.d(str, "get old versioncode:" + i2);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public final void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            d.a.q0.a.t2.a.d(0, i2);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && f52468c) {
            String str = f52467b;
            Log.d(str, "新旧版本一样:" + b(this.f52470a));
        }
    }

    public final void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            d.a.q0.a.t2.a.d(i3, i2);
            d.a.q0.w.a.c();
            d.a.q0.a.n0.k.c.f49579d.u();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int a2 = a(this.f52470a);
            int b2 = b(this.f52470a);
            if (f52468c) {
                String str = f52467b;
                Log.d(str, "处理升级逻辑：newVersionCode=" + a2 + " /oldVersionCode=" + b2);
            }
            if (b2 == 0) {
                f(a2);
                k(this.f52470a, a2);
                j(this.f52470a, b2);
            } else if (a2 > b2) {
                h(a2, b2);
                k(this.f52470a, a2);
                j(this.f52470a, b2);
            } else if (a2 < b2) {
                e(a2, b2);
                k(this.f52470a, a2);
                j(this.f52470a, b2);
            } else {
                g();
            }
        }
    }

    public final void k(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, context, i2) == null) {
            if (f52468c) {
                String str = f52467b;
                Log.d(str, "set new versioncode:" + i2);
            }
            SharedPreferences.Editor edit = c(context).edit();
            edit.putInt("old_versioncode_key", i2);
            edit.apply();
        }
    }
}
