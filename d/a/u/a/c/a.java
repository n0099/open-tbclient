package d.a.u.a.c;

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
    public static int f67672a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static Context f67673b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f67674c;

    /* renamed from: d  reason: collision with root package name */
    public static int f67675d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.u.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1918a implements b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static C1918a f67676a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.u.a.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1919a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f67677e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Timer f67678f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f67679g;

            /* renamed from: d.a.u.a.c.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1920a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AtomicBoolean f67680e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ RunnableC1919a f67681f;

                public C1920a(RunnableC1919a runnableC1919a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC1919a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67681f = runnableC1919a;
                    this.f67680e = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        d.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.f67681f.f67679g;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            a.f(true);
                            b c2 = a.c(a.f67673b);
                            RunnableC1919a runnableC1919a = this.f67681f;
                            c2.b(runnableC1919a.f67677e, runnableC1919a.f67679g);
                        }
                        this.f67680e.set(true);
                    }
                }
            }

            public RunnableC1919a(C1918a c1918a, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1918a, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67677e = str;
                this.f67678f = timer;
                this.f67679g = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.u.a.h.e.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.f67677e);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.f67678f.schedule(new C1920a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(a.f67673b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    a.j(dnsHelper.getIpList(this.f67677e));
                    List<String> list = a.f67674c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    d.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps = " + a.f67674c);
                    String str = a.f67674c.get(0);
                    if (this.f67679g != null && !atomicBoolean.get()) {
                        this.f67679g.a(0, "ok", str);
                        if (a.f67674c.size() > 1) {
                            a.f67675d++;
                            a.f(false);
                        }
                    }
                    d.a.u.a.h.e.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.f67678f.cancel();
                }
            }
        }

        public C1918a(Context context) {
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
            Context unused = a.f67673b = context.getApplicationContext();
            a.i();
        }

        public static synchronized C1918a c(Context context) {
            InterceptResult invokeL;
            C1918a c1918a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (C1918a.class) {
                    if (f67676a == null) {
                        f67676a = new C1918a(context);
                    }
                    c1918a = f67676a;
                }
                return c1918a;
            }
            return (C1918a) invokeL.objValue;
        }

        @Override // d.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    d.a.u.a.h.e.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (a.f67674c != null && a.f67674c.size() > 0) {
                        if (a.f67675d < a.f67674c.size()) {
                            if (dVar != null) {
                                dVar.a(0, "ok", a.f67674c.get(a.f67675d));
                                d.a.u.a.h.e.a("DNSUrlProvider", "retry bddns > return ip = " + a.f67674c.get(a.f67675d));
                            }
                            a.f67675d++;
                            return;
                        }
                        a.f(true);
                        a.c(a.f67673b).b(str, dVar);
                        return;
                    }
                    d.a.u.a.g.a.a(a.f67673b).b(new RunnableC1919a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    d.a.u.a.h.e.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    a.f(true);
                    a.c(a.f67673b).b(str, dVar);
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
        public static c f67682a;
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
                    if (f67682a == null) {
                        f67682a = new c();
                    }
                    cVar = f67682a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // d.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                d.a.u.a.h.e.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
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
        public static e f67683a;
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
            Context unused = a.f67673b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (f67683a == null) {
                        f67683a = new e(context);
                    }
                    eVar = f67683a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // d.a.u.a.c.a.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // d.a.u.a.c.a.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                d.a.u.a.h.e.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    d.a.u.a.f.d dVar2 = new d.a.u.a.f.d(a.f67673b);
                    dVar2.a(dVar);
                    d.a.u.a.f.c.e(dVar2, dVar2);
                } catch (Exception unused) {
                    a.f(true);
                    a.c(a.f67673b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-953934925, "Ld/a/u/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-953934925, "Ld/a/u/a/c/a;");
                return;
            }
        }
        f67674c = Collections.synchronizedList(new ArrayList());
        f67675d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            f67673b = context.getApplicationContext();
            int a2 = d.a.u.a.h.c.a(context);
            if (a2 != 1 && a2 != 2) {
                if (d.a.u.a.h.f.c(context) && f67672a == 2) {
                    return C1918a.c(context);
                }
                if (f67672a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            f67672a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = f67674c;
            return list != null && f67675d <= list.size();
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
                int a2 = d.a.u.a.h.c.a(f67673b);
                if (a2 != 1 && a2 != 2) {
                    int i2 = f67672a;
                    if (i2 == 0) {
                        f67672a = 2;
                    } else if (i2 == 2) {
                        f67672a = 3;
                    } else if (i2 == 3) {
                        f67672a = 0;
                    }
                } else {
                    f67672a = 0;
                }
            }
            d.a.u.a.h.e.a("DNSUrlProvider", "try to connect ip, now policy =" + f67672a);
            return f67672a;
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
                f67675d = 0;
                f67674c.clear();
                f67672a = 3;
            } catch (Exception e2) {
                d.a.u.a.h.e.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            f67674c.clear();
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
                int f2 = d.a.u.a.h.f.f(f67673b);
                d.a.u.a.h.e.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f2 == 1) {
                    f67674c.addAll(arrayList2);
                } else if (f2 == 2) {
                    f67674c.addAll(arrayList2);
                    f67674c.addAll(arrayList);
                } else if (f2 != 4) {
                    f67674c.addAll(arrayList);
                    f67674c.addAll(arrayList2);
                } else {
                    f67674c.addAll(arrayList);
                }
            }
        }
    }
}
