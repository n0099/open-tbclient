package d.n.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
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
/* loaded from: classes10.dex */
public final class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f75044d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f75045a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f75046b;

    /* renamed from: c  reason: collision with root package name */
    public d.n.a.a.a.b.b f75047c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-647317463, "Ld/n/a/a/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-647317463, "Ld/n/a/a/a/a/b;");
                return;
            }
        }
        f75044d = new AtomicBoolean(false);
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
        this.f75046b = null;
        this.f75047c = null;
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final b c() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            bVar = d.f75051a;
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static /* synthetic */ String e(b bVar) {
        return !TextUtils.isEmpty(Build.MANUFACTURER) ? Build.MANUFACTURER.toLowerCase() : "";
    }

    @Override // d.n.a.a.a.a.a
    public final void a(boolean z, d.n.a.a.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, bVar) == null) {
            try {
                if (this.f75045a != null) {
                    this.f75045a.a(z, bVar);
                }
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
            }
        }
    }

    public final void f(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar) == null) {
            try {
                if (!f75044d.compareAndSet(false, true)) {
                    d.n.a.a.c.b.b.e("OaHelper has been initialized,return");
                    return;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    this.f75046b = new CountDownLatch(1);
                }
                new Thread(new c(this, aVar, context)).start();
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                a(false, null);
            }
        }
    }

    public final void h() {
        CountDownLatch countDownLatch;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (countDownLatch = this.f75046b) == null) {
            return;
        }
        countDownLatch.countDown();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f75046b == null || this.f75046b.getCount() <= 0) {
                    return;
                }
                d.n.a.a.c.b.b.e("awaitCdOaid");
                this.f75046b.await(2000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                d.n.a.a.c.b.b.c(e2);
            }
        }
    }
}
