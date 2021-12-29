package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.text.TextUtils;
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
    public com.yxcorp.kuaishou.addfp.a.b.b f63929b;

    /* renamed from: c  reason: collision with root package name */
    public Context f63930c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f63931d;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f63932e;

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
        this.f63931d = new CountDownLatch(1);
        this.f63932e = new e(this);
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            if (z) {
                try {
                    String a = this.a.a();
                    if (!TextUtils.isEmpty(a)) {
                        this.f63929b.a(a);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            this.f63929b.e();
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                context.getPackageManager().getPackageInfo("com.mdid.msa", 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            try {
                if (this.f63932e == null || context == null) {
                    return;
                }
                context.unbindService(this.f63932e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) == null) {
            try {
                this.f63929b = bVar;
                this.f63930c = context;
                if (b(context)) {
                    String packageName = context.getPackageName();
                    Intent intent = new Intent();
                    intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                    intent.setAction("com.bun.msa.action.start.service");
                    intent.putExtra("com.bun.msa.param.pkgname", packageName);
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    context.startService(intent);
                }
                Intent intent2 = new Intent();
                intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
                intent2.setAction("com.bun.msa.action.bindto.service");
                intent2.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
                if (!context.bindService(intent2, this.f63932e, 1)) {
                    a(false);
                    return;
                }
                this.f63931d.await(10L, TimeUnit.SECONDS);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return this.f63930c.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
