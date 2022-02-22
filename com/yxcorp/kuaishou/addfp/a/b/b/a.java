package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.yxcorp.kuaishou.addfp.a.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61697b;

    /* renamed from: c  reason: collision with root package name */
    public d f61698c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f61699d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f61700e;

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
        this.f61698c = null;
        this.f61699d = new CountDownLatch(1);
        this.f61700e = new b(this);
        this.f61697b = context;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            try {
                if (!z) {
                    this.a.e();
                    return;
                }
                String a = this.f61698c.a();
                if (TextUtils.isEmpty(a)) {
                    this.a.a(a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a() {
        ServiceConnection serviceConnection;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.f61700e) == null || (context = this.f61697b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.a = bVar;
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                if (!this.f61697b.bindService(intent, this.f61700e, 1)) {
                    a(false);
                    return;
                }
                this.f61699d.await(10L, TimeUnit.SECONDS);
                if (this.f61698c != null) {
                    a(true);
                } else {
                    a(false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                a(false);
            }
        }
    }
}
