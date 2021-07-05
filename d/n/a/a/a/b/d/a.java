package d.n.a.a.a.b.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f75065a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.c.a f75066b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f75067c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f75068d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f75069e;

    public a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75065a = null;
        this.f75068d = new CountDownLatch(1);
        this.f75069e = new b(this);
        try {
            this.f75065a = context;
            this.f75067c = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f75065a.bindService(intent, this.f75069e, 1)) {
                d(false);
                d.n.a.a.c.b.b.e("bindService Failed!");
                return;
            }
            d.n.a.a.c.b.b.e("bindService Successful!");
            this.f75068d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f75066b != null) {
                d(true);
            } else {
                d(false);
            }
        } catch (Throwable th) {
            d.n.a.a.c.b.b.c(th);
            d(false);
        }
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f75066b != null) {
                    return this.f75066b.a();
                }
                return null;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            try {
                if (z) {
                    this.f75067c.a(this.f75066b);
                } else {
                    this.f75067c.e();
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.f75066b != null) {
                    return this.f75066b.b();
                }
                return null;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.f75066b == null) {
                    return false;
                }
                return this.f75066b.c();
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String packageName = this.f75065a.getPackageName();
            if (packageName == null || packageName.equals("")) {
                d.n.a.a.c.b.b.e("empty pkg");
                return null;
            }
            try {
                if (this.f75066b != null) {
                    return this.f75066b.a(packageName);
                }
                return null;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String packageName = this.f75065a.getPackageName();
            if (packageName == null || packageName.equals("")) {
                d.n.a.a.c.b.b.e("empty pkg");
                return null;
            }
            try {
                if (this.f75066b != null) {
                    return this.f75066b.b(packageName);
                }
                return null;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                this.f75065a.unbindService(this.f75069e);
                d.n.a.a.c.b.b.e("unBind Service");
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
            this.f75066b = null;
        }
    }
}
