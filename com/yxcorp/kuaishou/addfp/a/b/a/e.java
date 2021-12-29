package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.ComponentName;
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
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63880b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f63881c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f63882d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f63883e;

    public e(Context context) {
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
        this.f63882d = new CountDownLatch(1);
        this.f63883e = new f(this);
        this.f63880b = context;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            if (z) {
                try {
                    String a = this.a.a();
                    if (!TextUtils.isEmpty(a)) {
                        this.f63881c.a(a);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.f63881c.e();
        }
    }

    public final void a() {
        ServiceConnection serviceConnection;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (serviceConnection = this.f63883e) == null || (context = this.f63880b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f63881c = bVar;
                Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
                ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                if (!this.f63880b.bindService(intent2, this.f63883e, 1)) {
                    a(false);
                    return;
                }
                this.f63882d.await(10L, TimeUnit.SECONDS);
                if (this.a != null) {
                    a(true);
                } else {
                    a(false);
                }
            } catch (Throwable unused) {
                a(false);
            }
        }
    }
}
