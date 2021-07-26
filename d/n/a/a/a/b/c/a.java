package d.n.a.a.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.a.b.b.d;
import d.n.a.a.c.b.c;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f72568a;

    /* renamed from: b  reason: collision with root package name */
    public Context f72569b;

    /* renamed from: c  reason: collision with root package name */
    public d f72570c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f72571d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f72572e;

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
        this.f72570c = null;
        this.f72571d = new CountDownLatch(1);
        this.f72572e = new b(this);
        this.f72569b = context;
    }

    public final void c() {
        ServiceConnection serviceConnection;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.f72572e) == null || (context = this.f72569b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f72568a = bVar;
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                if (!this.f72569b.bindService(intent, this.f72572e, 1)) {
                    e(false);
                    return;
                }
                this.f72571d.await(10L, TimeUnit.SECONDS);
                if (this.f72570c != null) {
                    e(true);
                } else {
                    e(false);
                }
            } catch (Throwable th) {
                c.c(th);
                e(false);
            }
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                if (!z) {
                    this.f72568a.e();
                    return;
                }
                String a2 = this.f72570c.a();
                if (TextUtils.isEmpty(a2)) {
                    this.f72568a.a(a2);
                }
            } catch (Throwable th) {
                c.c(th);
            }
        }
    }
}
