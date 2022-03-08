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

    /* renamed from: b  reason: collision with root package name */
    public Context f60047b;

    /* renamed from: c  reason: collision with root package name */
    public d f60048c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f60049d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f60050e;

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
        this.f60048c = null;
        this.f60049d = new CountDownLatch(1);
        this.f60050e = new b(this);
        this.f60047b = context;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            try {
                if (!z) {
                    this.a.e();
                    return;
                }
                String a = this.f60048c.a();
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.f60050e) == null || (context = this.f60047b) == null) {
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
                if (!this.f60047b.bindService(intent, this.f60050e, 1)) {
                    a(false);
                    return;
                }
                this.f60049d.await(10L, TimeUnit.SECONDS);
                if (this.f60048c != null) {
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
