package d.n.a.a.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.a.b.b.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f75058a;

    /* renamed from: b  reason: collision with root package name */
    public Context f75059b;

    /* renamed from: c  reason: collision with root package name */
    public d f75060c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f75061d;

    /* renamed from: e  reason: collision with root package name */
    public long f75062e;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f75063f;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75060c = null;
        this.f75061d = new CountDownLatch(1);
        this.f75062e = 0L;
        this.f75063f = new b(this);
        this.f75059b = context;
    }

    public final void c() {
        ServiceConnection serviceConnection;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.f75063f) == null || (context = this.f75059b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.f75058a = bVar;
                this.f75059b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                this.f75062e = System.currentTimeMillis();
                d.n.a.a.c.b.b.e("hua wei lala  : " + this.f75062e);
                if (!this.f75059b.bindService(intent, this.f75063f, 1)) {
                    e(false);
                    return;
                }
                this.f75061d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.f75060c == null) {
                    e(false);
                    return;
                }
                d.n.a.a.c.b.b.e("lalala " + Long.toString(System.currentTimeMillis() - currentTimeMillis));
                e(true);
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                e(false);
            }
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                if (z) {
                    this.f75058a.a(this.f75060c);
                } else {
                    this.f75058a.e();
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }
}
