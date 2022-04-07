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
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.yxcorp.kuaishou.addfp.a.b.b a;
    public Context b;
    public d c;
    public CountDownLatch d;
    public ServiceConnection e;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = new CountDownLatch(1);
        this.e = new b(this);
        this.b = context;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            try {
                if (!z) {
                    this.a.e();
                    return;
                }
                String a = this.c.a();
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.e) == null || (context = this.b) == null) {
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
                if (!this.b.bindService(intent, this.e, 1)) {
                    a(false);
                    return;
                }
                this.d.await(10L, TimeUnit.SECONDS);
                if (this.c != null) {
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
