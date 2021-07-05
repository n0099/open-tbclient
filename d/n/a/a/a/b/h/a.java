package d.n.a.a.a.b.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
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
    public com.yxcorp.kuaishou.addfp.a.b.g.a f75094a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f75095b;

    /* renamed from: c  reason: collision with root package name */
    public Context f75096c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f75097d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f75098e;

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
        this.f75094a = null;
        this.f75097d = new CountDownLatch(1);
        this.f75098e = new b(this);
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f75094a != null) {
                    return this.f75094a.a();
                }
                return null;
            } catch (RemoteException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final void c(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || (serviceConnection = this.f75098e) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) {
            try {
                this.f75095b = bVar;
                this.f75096c = context;
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                if (!context.bindService(intent, this.f75098e, 1)) {
                    d.n.a.a.c.b.b.e("sumsang off");
                    e(false);
                    return;
                }
                this.f75097d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.f75094a != null) {
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
                    this.f75095b.a(this.f75094a);
                } else {
                    this.f75095b.e();
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f75094a != null : invokeV.booleanValue;
    }
}
