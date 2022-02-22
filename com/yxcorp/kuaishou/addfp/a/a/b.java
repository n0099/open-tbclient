package com.yxcorp.kuaishou.addfp.a.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class b implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "KWE_NS";

    /* renamed from: c  reason: collision with root package name */
    public static AtomicBoolean f61680c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f61681b;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f61682d;

    /* renamed from: e  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.a f61683e;

    /* renamed from: f  reason: collision with root package name */
    public Context f61684f;

    /* renamed from: g  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.android.a.e f61685g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-39619473, "Lcom/yxcorp/kuaishou/addfp/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-39619473, "Lcom/yxcorp/kuaishou/addfp/a/a/b;");
                return;
            }
        }
        f61680c = new AtomicBoolean(false);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61682d = null;
        this.f61683e = null;
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            bVar = e.a;
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            d dVar = new d(this);
            try {
                if (f61680c.compareAndSet(false, true)) {
                    if (this.f61684f == null) {
                        this.f61684f = context;
                    }
                    this.f61685g = new com.yxcorp.kuaishou.addfp.android.a.e(this.f61684f);
                    Thread thread = new Thread(new c(this, context, dVar));
                    thread.setName("adsence-dfp");
                    thread.start();
                }
            } catch (Throwable unused) {
                a(false, (com.yxcorp.kuaishou.addfp.a.b.a) null);
            }
        }
    }

    @Override // com.yxcorp.kuaishou.addfp.a.a.a
    public final void a(boolean z, com.yxcorp.kuaishou.addfp.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, aVar) == null) {
            try {
                if (this.f61681b != null) {
                    this.f61681b.a(z, aVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b() {
        CountDownLatch countDownLatch;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (countDownLatch = this.f61682d) == null) {
            return;
        }
        countDownLatch.countDown();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f61682d == null || this.f61682d.getCount() <= 0) {
                    return;
                }
                this.f61682d.await(2000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
