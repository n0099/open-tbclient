package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a f63901b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f63902c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f63903d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f63904e;

    public e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
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
        this.a = null;
        this.f63903d = new CountDownLatch(1);
        this.f63904e = new f(this);
        try {
            this.a = context;
            this.f63902c = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.a.bindService(intent, this.f63904e, 1)) {
                a(false);
                return;
            }
            this.f63903d.await(10L, TimeUnit.SECONDS);
            if (this.f63901b != null) {
                a(true);
            } else {
                a(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a(false);
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            if (z) {
                try {
                    String c2 = c();
                    if (!TextUtils.isEmpty(c2)) {
                        this.f63902c.a(c2);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.f63902c.e();
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                if (this.f63901b != null) {
                    return this.f63901b.a();
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.a.unbindService(this.f63904e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f63901b = null;
        }
    }
}
