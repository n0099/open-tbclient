package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
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
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public String f63918b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f63919c;

    /* renamed from: d  reason: collision with root package name */
    public Context f63920d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownLatch f63921e;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f63922f;

    public d() {
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
        this.a = null;
        this.f63918b = null;
        this.f63921e = new CountDownLatch(1);
        this.f63922f = new e(this);
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            if (z) {
                try {
                    String b2 = b();
                    if (!TextUtils.isEmpty(b2)) {
                        this.f63919c.a(b2);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.f63919c.e();
        }
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.a();
                }
                return null;
            } catch (RemoteException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public final void a(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (serviceConnection = this.f63922f) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            try {
                this.f63919c = bVar;
                this.f63920d = context;
                Intent intent = new Intent();
                intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
                if (!context.bindService(intent, this.f63922f, 1)) {
                    a(false);
                    return;
                }
                this.f63921e.await(10L, TimeUnit.SECONDS);
                if (this.a != null) {
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

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a != null : invokeV.booleanValue;
    }
}
