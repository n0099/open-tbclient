package d.n.a.a.a.b.k;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f75118f = "com.mdid.msa";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.j.a f75119a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f75120b;

    /* renamed from: c  reason: collision with root package name */
    public Context f75121c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f75122d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f75123e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(727064781, "Ld/n/a/a/a/b/k/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(727064781, "Ld/n/a/a/a/b/k/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75119a = null;
        this.f75122d = new CountDownLatch(1);
        this.f75123e = new b(this);
    }

    public static a f() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            aVar = c.f75125a;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            try {
                context.getPackageManager().getPackageInfo(f75118f, 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f75119a != null) {
                    return this.f75119a.a();
                }
                return null;
            } catch (RemoteException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            try {
                if (this.f75123e != null && context != null) {
                    context.unbindService(this.f75123e);
                }
                if (this.f75119a != null) {
                    this.f75119a.c();
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) {
            try {
                this.f75120b = bVar;
                this.f75121c = context;
                if (g(context)) {
                    String packageName = context.getPackageName();
                    Intent intent = new Intent();
                    intent.setClassName(f75118f, "com.mdid.msa.service.MsaKlService");
                    intent.setAction("com.bun.msa.action.start.service");
                    intent.putExtra("com.bun.msa.param.pkgname", packageName);
                    try {
                        intent.putExtra("com.bun.msa.param.runinset", true);
                        context.startService(intent);
                    } catch (Exception e2) {
                        d.n.a.a.c.b.b.c(e2);
                    }
                }
                Intent intent2 = new Intent();
                intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
                intent2.setAction("com.bun.msa.action.bindto.service");
                intent2.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
                if (!context.bindService(intent2, this.f75123e, 1)) {
                    d.n.a.a.c.b.b.e("zte off");
                    e(false);
                    return;
                }
                this.f75122d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.f75119a != null) {
                    e(true);
                } else {
                    e(false);
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                e(false);
            }
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            try {
                if (z) {
                    this.f75120b.a(this.f75119a);
                } else {
                    this.f75120b.e();
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.f75119a == null) {
                    return false;
                }
                return this.f75119a.b();
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
