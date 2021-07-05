package com.bytedance.sdk.openadsdk.o;

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
import com.bytedance.sdk.openadsdk.o.i;
import com.bytedance.sdk.openadsdk.o.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public abstract class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicLong m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.o.a.a f31515a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.o.b.c f31516b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f31517c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f31518d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.o.d.a f31519e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<i.b> f31520f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f31521g;

    /* renamed from: h  reason: collision with root package name */
    public volatile String f31522h;

    /* renamed from: i  reason: collision with root package name */
    public volatile i f31523i;
    public volatile l j;
    public volatile boolean k;
    public final long l;
    public final AtomicInteger n;
    public int o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98049711, "Lcom/bytedance/sdk/openadsdk/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98049711, "Lcom/bytedance/sdk/openadsdk/o/a;");
                return;
            }
        }
        m = new AtomicLong();
    }

    public a(com.bytedance.sdk.openadsdk.o.a.a aVar, com.bytedance.sdk.openadsdk.o.b.c cVar) {
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
        this.f31517c = new AtomicInteger();
        this.f31518d = new AtomicLong();
        this.k = false;
        this.l = m.incrementAndGet();
        this.n = new AtomicInteger(0);
        this.o = -1;
        this.f31515a = aVar;
        this.f31516b = cVar;
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

    public void e() throws com.bytedance.sdk.openadsdk.o.c.a {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b()) {
            throw new com.bytedance.sdk.openadsdk.o.c.a();
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f31523i != null) {
                return this.f31523i.f31680c.f31681a;
            }
            return this.f31515a instanceof com.bytedance.sdk.openadsdk.o.a.b ? 1 : 0;
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

    public com.bytedance.sdk.openadsdk.o.e.a a(l.a aVar, int i2, int i3, String str) throws IOException, VAdError {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{aVar, Integer.valueOf(i2), Integer.valueOf(i3), str})) == null) {
            com.bytedance.sdk.openadsdk.o.e.b b2 = com.bytedance.sdk.openadsdk.o.e.c.a().b();
            com.bytedance.sdk.openadsdk.o.e.f fVar = new com.bytedance.sdk.openadsdk.o.e.f();
            HashMap hashMap = new HashMap();
            fVar.f31609b = aVar.f31704a;
            fVar.f31608a = 0;
            if ("HEAD".equalsIgnoreCase(str)) {
                fVar.f31608a = 4;
            }
            List<i.b> list = this.f31520f;
            if (list != null && !list.isEmpty()) {
                for (i.b bVar : list) {
                    if (!"Range".equalsIgnoreCase(bVar.f31688a) && !HTTP.CONN_DIRECTIVE.equalsIgnoreCase(bVar.f31688a) && !"Proxy-Connection".equalsIgnoreCase(bVar.f31688a) && !"Host".equalsIgnoreCase(bVar.f31688a)) {
                        hashMap.put(bVar.f31688a, bVar.f31689b);
                    }
                }
            }
            String a2 = com.bytedance.sdk.openadsdk.o.g.d.a(i2, i3);
            if (a2 != null) {
                hashMap.put("Range", a2);
            }
            if (e.f31600f) {
                hashMap.put("Cache-Control", "no-cache");
            }
            d c2 = d.c();
            f a3 = f.a();
            boolean z = this.f31523i == null;
            c a4 = z ? c2.a() : a3.b();
            c b3 = z ? c2.b() : a3.c();
            if (a4 != null || b3 != null) {
                if (a4 != null) {
                    fVar.f31610c = a4.a(aVar.f31705b);
                }
                if (b3 != null) {
                    fVar.f31611d = b3.a(aVar.f31705b);
                }
            }
            fVar.f31612e = hashMap;
            if (this.k) {
                this.k = false;
                return null;
            }
            return b2.a(fVar);
        }
        return (com.bytedance.sdk.openadsdk.o.e.a) invokeCommon.objValue;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || i2 <= 0 || i3 < 0) {
            return;
        }
        int i4 = e.f31601g;
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
                com.bytedance.sdk.openadsdk.o.g.d.a(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.o.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f31524a;

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
                        this.f31524a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar;
                        com.bytedance.sdk.openadsdk.o.d.a aVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar2 = (aVar = this.f31524a).f31519e) == null) {
                            return;
                        }
                        aVar2.a(aVar.j, this.f31524a.o);
                    }
                });
            }
        }
    }
}
