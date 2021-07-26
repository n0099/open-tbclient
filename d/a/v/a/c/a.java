package d.a.v.a.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f68350a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f68351b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f68352c;

    /* renamed from: d  reason: collision with root package name */
    public static int f68353d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.v.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1923a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1923a f68354a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.v.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1924a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f68355e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f68356f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f68357g;

            /* renamed from: d.a.v.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1925a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f68358e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1924a f68359f;

                public C1925a(RunnableC1924a runnableC1924a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1924a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68359f = runnableC1924a;
                    this.f68358e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        d.a.v.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f68359f.f68357g;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f68351b);
                            RunnableC1924a runnableC1924a = this.f68359f;
                            c2.b(runnableC1924a.f68355e, runnableC1924a.f68357g);
                        }
                        this.f68358e.set(true);
                    }
                }
            }

            public RunnableC1924a(C1923a c1923a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1923a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68355e = str;
                this.f68356f = timer;
                this.f68357g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.v.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f68355e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f68356f.schedule(new C1925a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f68351b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f68355e));
                    List<String> list = a.f68352c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    d.a.v.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f68352c);
                    String str = a.f68352c.get(0);
                    if (this.f68357g != null && !atomicBoolean.get()) {
                        this.f68357g.a(0, "ok", str);
                        if (a.f68352c.size() > 1) {
                            a.f68353d++;
                            a.f(false);
                        }
                    }
                    d.a.v.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f68356f.cancel();
                }
            }
        }

        public C1923a(Context context) {
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
            Context unused = a.f68351b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1923a c(Context context) {
            InterceptResult invokeL;
            C1923a c1923a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1923a.class) {
                    if (f68354a == null) {
                        f68354a = new C1923a(context);
                    }
                    c1923a = f68354a;
                }
                return c1923a;
            }
            return (C1923a) invokeL.objValue;
        }

        @Override // d.a.v.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.v.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    d.a.v.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (a.f68352c != null && a.f68352c.size() > 0) {
                        if (a.f68353d < a.f68352c.size()) {
                            if (dVar != null) {
                                dVar.a(0, "ok", a.f68352c.get(a.f68353d));
                                d.a.v.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f68352c.get(a.f68353d));
                            }
                            a.f68353d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f68351b).b(str, dVar);
                        return;
                    }
                    d.a.v.a.g.a.a(a.f68351b).b(new RunnableC1924a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    d.a.v.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f68351b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes8.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f68360a;
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
                    if (f68360a == null) {
                        f68360a = new c();
                    }
                    cVar = f68360a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // d.a.v.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.v.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                d.a.v.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    a.i();
                    dVar.a(0, "ok", str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i2, String str, String str2);
    }

    /* loaded from: classes8.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f68361a;
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
            Context unused = a.f68351b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (f68361a == null) {
                        f68361a = new e(context);
                    }
                    eVar = f68361a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // d.a.v.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.v.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                d.a.v.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    d.a.v.a.f.d dVar2 = new d.a.v.a.f.d(a.f68351b);
                    dVar2.a(dVar);
                    d.a.v.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f68351b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(788875410, "Ld/a/v/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(788875410, "Ld/a/v/a/c/a;");
                return;
            }
        }
        f68352c = Collections.synchronizedList(new ArrayList());
        f68353d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f68351b = context.getApplicationContext();
            int a2 = d.a.v.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (d.a.v.a.h.f.c(context) && f68350a == 2) {
                    return C1923a.c(context);
                }
                if (f68350a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            f68350a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = f68352c;
            return list != null && f68353d <= list.size();
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
                int a2 = d.a.v.a.h.c.a(f68351b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = f68350a;
                    if (i2 == 0) {
                        f68350a = 2;
                    } else if (i2 == 2) {
                        f68350a = 3;
                    } else if (i2 == 3) {
                        f68350a = 0;
                    }
                } else {
                    f68350a = 0;
                }
            }
            d.a.v.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f68350a);
            return f68350a;
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
                f68353d = 0;
                f68352c.clear();
                f68350a = 3;
            } catch (Exception e2) {
                d.a.v.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f68352c.clear();
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
                int f2 = d.a.v.a.h.f.f(f68351b);
                d.a.v.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f68352c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f68352c.addAll(arrayList2);
                    f68352c.addAll(arrayList);
                } else if (f2 != 4) {
                    f68352c.addAll(arrayList);
                    f68352c.addAll(arrayList2);
                } else {
                    f68352c.addAll(arrayList);
                }
            }
        }
    }
}
