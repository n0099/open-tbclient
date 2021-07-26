package d.n.a.a.a.b.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.g.a f72596a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f72597b;

    /* renamed from: c  reason: collision with root package name */
    public Context f72598c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f72599d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f72600e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72596a = null;
        this.f72599d = new CountDownLatch(1);
        this.f72600e = new b(this);
    }

    public final void c(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (serviceConnection = this.f72600e) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            try {
                this.f72597b = bVar;
                this.f72598c = context;
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                if (!context.bindService(intent, this.f72600e, 1)) {
                    e(false);
                    return;
                }
                this.f72599d.await(10L, TimeUnit.SECONDS);
                if (this.f72596a != null) {
                    e(true);
                } else {
                    e(false);
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.c.c(th);
                e(false);
            }
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                try {
                    String g2 = g();
                    if (!TextUtils.isEmpty(g2)) {
                        this.f72597b.a(g2);
                        return;
                    }
                } catch (Throwable th) {
                    d.n.a.a.c.b.c.c(th);
                    return;
                }
            }
            this.f72597b.e();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72596a != null : invokeV.booleanValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.f72596a != null) {
                    return this.f72596a.a();
                }
                return null;
            } catch (RemoteException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
