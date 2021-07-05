package d.a.w.a.c;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f70779a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f70780b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f70781c;

    /* renamed from: d  reason: collision with root package name */
    public static int f70782d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.w.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1955a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1955a f70783a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.w.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1956a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f70784e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f70785f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f70786g;

            /* renamed from: d.a.w.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1957a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f70787e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1956a f70788f;

                public C1957a(RunnableC1956a runnableC1956a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1956a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f70788f = runnableC1956a;
                    this.f70787e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        d.a.w.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f70788f.f70786g;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f70780b);
                            RunnableC1956a runnableC1956a = this.f70788f;
                            c2.b(runnableC1956a.f70784e, runnableC1956a.f70786g);
                        }
                        this.f70787e.set(true);
                    }
                }
            }

            public RunnableC1956a(C1955a c1955a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1955a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70784e = str;
                this.f70785f = timer;
                this.f70786g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.w.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f70784e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f70785f.schedule(new C1957a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f70780b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f70784e));
                    List<String> list = a.f70781c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    d.a.w.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f70781c);
                    String str = a.f70781c.get(0);
                    if (this.f70786g != null && !atomicBoolean.get()) {
                        this.f70786g.a(0, "ok", str);
                        if (a.f70781c.size() > 1) {
                            a.f70782d++;
                            a.f(false);
                        }
                    }
                    d.a.w.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f70785f.cancel();
                }
            }
        }

        public C1955a(Context context) {
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
            Context unused = a.f70780b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1955a c(Context context) {
            InterceptResult invokeL;
            C1955a c1955a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1955a.class) {
                    if (f70783a == null) {
                        f70783a = new C1955a(context);
                    }
                    c1955a = f70783a;
                }
                return c1955a;
            }
            return (C1955a) invokeL.objValue;
        }

        @Override // d.a.w.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.w.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    d.a.w.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (a.f70781c != null && a.f70781c.size() > 0) {
                        if (a.f70782d < a.f70781c.size()) {
                            if (dVar != null) {
                                dVar.a(0, "ok", a.f70781c.get(a.f70782d));
                                d.a.w.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f70781c.get(a.f70782d));
                            }
                            a.f70782d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f70780b).b(str, dVar);
                        return;
                    }
                    d.a.w.a.g.a.a(a.f70780b).b(new RunnableC1956a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    d.a.w.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f70780b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes9.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f70789a;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static synchronized b c() {
            InterceptResult invokeV;
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (c.class) {
                    if (f70789a == null) {
                        f70789a = new c();
                    }
                    cVar = f70789a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // d.a.w.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.w.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                d.a.w.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    a.i();
                    dVar.a(0, "ok", str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(int i2, String str, String str2);
    }

    /* loaded from: classes9.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f70790a;
        public transient /* synthetic */ FieldHolder $fh;

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
            Context unused = a.f70780b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (f70790a == null) {
                        f70790a = new e(context);
                    }
                    eVar = f70790a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // d.a.w.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.w.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                d.a.w.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    d.a.w.a.f.d dVar2 = new d.a.w.a.f.d(a.f70780b);
                    dVar2.a(dVar);
                    d.a.w.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f70780b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1763281551, "Ld/a/w/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1763281551, "Ld/a/w/a/c/a;");
                return;
            }
        }
        f70781c = Collections.synchronizedList(new ArrayList());
        f70782d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f70780b = context.getApplicationContext();
            int a2 = d.a.w.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (d.a.w.a.h.f.c(context) && f70779a == 2) {
                    return C1955a.c(context);
                }
                if (f70779a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            f70779a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            List<String> list = f70781c;
            return list != null && f70782d <= list.size();
        }
        return invokeV.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null || str.isEmpty()) {
                return false;
            }
            return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        }
        return invokeL.booleanValue;
    }

    public static int f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z)) == null) {
            if (z) {
                int a2 = d.a.w.a.h.c.a(f70780b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = f70779a;
                    if (i2 == 0) {
                        f70779a = 2;
                    } else if (i2 == 2) {
                        f70779a = 3;
                    } else if (i2 == 3) {
                        f70779a = 0;
                    }
                } else {
                    f70779a = 0;
                }
            }
            d.a.w.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f70779a);
            return f70779a;
        }
        return invokeZ.intValue;
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            h(context, str, true);
        }
    }

    public static void h(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, context, str, z) == null) {
            i();
            c.c().a(str, true);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            try {
                f70782d = 0;
                f70781c.clear();
                f70779a = 3;
            } catch (Exception e2) {
                d.a.w.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f70781c.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (e(list.get(i2))) {
                        arrayList.add(list.get(i2));
                    } else {
                        arrayList2.add(list.get(i2));
                    }
                }
            }
            if (arrayList.size() + arrayList2.size() > 0) {
                int f2 = d.a.w.a.h.f.f(f70780b);
                d.a.w.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f70781c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f70781c.addAll(arrayList2);
                    f70781c.addAll(arrayList);
                } else if (f2 != 4) {
                    f70781c.addAll(arrayList);
                    f70781c.addAll(arrayList2);
                } else {
                    f70781c.addAll(arrayList);
                }
            }
        }
    }
}
