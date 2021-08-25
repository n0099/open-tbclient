package com.bytedance.sdk.openadsdk.n;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.n.i;
import com.bytedance.sdk.openadsdk.n.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public abstract class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicLong m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.n.a.a f67956a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.n.b.c f67957b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f67958c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f67959d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.n.d.a f67960e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<i.b> f67961f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f67962g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f67963h;

    /* renamed from: i  reason: collision with root package name */
    public volatile i f67964i;

    /* renamed from: j  reason: collision with root package name */
    public volatile l f67965j;
    public volatile boolean k;
    public final long l;
    public final AtomicInteger n;
    public int o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98019920, "Lcom/bytedance/sdk/openadsdk/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98019920, "Lcom/bytedance/sdk/openadsdk/n/a;");
                return;
            }
        }
        m = new AtomicLong();
    }

    public a(com.bytedance.sdk.openadsdk.n.a.a aVar, com.bytedance.sdk.openadsdk.n.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67958c = new AtomicInteger();
        this.f67959d = new AtomicLong();
        this.k = false;
        this.l = m.incrementAndGet();
        this.n = new AtomicInteger(0);
        this.o = -1;
        this.f67956a = aVar;
        this.f67957b = cVar;
    }

    public void a(Boolean bool, String str, @NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bool, str, th) == null) {
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n.get() == 1 : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n.compareAndSet(0, 2);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n.get() == 2 : invokeV.booleanValue;
    }

    public void e() throws com.bytedance.sdk.openadsdk.n.c.a {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b()) {
            throw new com.bytedance.sdk.openadsdk.n.c.a();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f67964i != null) {
                return this.f67964i.f68128c.f68129a;
            }
            return this.f67956a instanceof com.bytedance.sdk.openadsdk.n.a.b ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? f() == 1 : invokeV.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.n.compareAndSet(0, 1);
        }
    }

    public com.bytedance.sdk.openadsdk.n.e.a a(l.a aVar, int i2, int i3, String str) throws IOException, VAdError {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{aVar, Integer.valueOf(i2), Integer.valueOf(i3), str})) == null) {
            com.bytedance.sdk.openadsdk.n.e.b b2 = com.bytedance.sdk.openadsdk.n.e.c.a().b();
            com.bytedance.sdk.openadsdk.n.e.f fVar = new com.bytedance.sdk.openadsdk.n.e.f();
            HashMap hashMap = new HashMap();
            fVar.f68055b = aVar.f68152a;
            fVar.f68054a = 0;
            if ("HEAD".equalsIgnoreCase(str)) {
                fVar.f68054a = 4;
            }
            List<i.b> list = this.f67961f;
            if (list != null && !list.isEmpty()) {
                for (i.b bVar : list) {
                    if (!"Range".equalsIgnoreCase(bVar.f68136a) && !HTTP.CONN_DIRECTIVE.equalsIgnoreCase(bVar.f68136a) && !"Proxy-Connection".equalsIgnoreCase(bVar.f68136a) && !"Host".equalsIgnoreCase(bVar.f68136a)) {
                        hashMap.put(bVar.f68136a, bVar.f68137b);
                    }
                }
            }
            String a2 = com.bytedance.sdk.openadsdk.n.g.d.a(i2, i3);
            if (a2 != null) {
                hashMap.put("Range", a2);
            }
            if (e.f68045f) {
                hashMap.put("Cache-Control", "no-cache");
            }
            d c2 = d.c();
            f a3 = f.a();
            boolean z = this.f67964i == null;
            c a4 = z ? c2.a() : a3.b();
            c b3 = z ? c2.b() : a3.c();
            if (a4 != null || b3 != null) {
                if (a4 != null) {
                    fVar.f68056c = a4.a(aVar.f68153b);
                }
                if (b3 != null) {
                    fVar.f68057d = b3.a(aVar.f68153b);
                }
            }
            fVar.f68058e = hashMap;
            if (this.k) {
                this.k = false;
                return null;
            }
            return b2.a(fVar);
        }
        return (com.bytedance.sdk.openadsdk.n.e.a) invokeCommon.objValue;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || i2 <= 0 || i3 < 0) {
            return;
        }
        int i4 = e.f68046g;
        int f2 = f();
        if (i4 == 1 || (i4 == 2 && f2 == 1)) {
            int i5 = (int) ((i3 / i2) * 100.0f);
            if (i5 > 100) {
                i5 = 100;
            }
            synchronized (this) {
                if (i5 <= this.o) {
                    return;
                }
                this.o = i5;
                com.bytedance.sdk.openadsdk.n.g.d.a(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.n.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f67966a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67966a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar;
                        com.bytedance.sdk.openadsdk.n.d.a aVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar2 = (aVar = this.f67966a).f67960e) == null) {
                            return;
                        }
                        aVar2.a(aVar.f67965j, this.f67966a.o);
                    }
                });
            }
        }
    }
}
