package com.repackage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class g80 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 3;
    public static Context b;
    public static List<String> c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.g80$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0419a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ Timer b;
            public final /* synthetic */ d c;

            /* renamed from: com.repackage.g80$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0420a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AtomicBoolean a;
                public final /* synthetic */ RunnableC0419a b;

                public C0420a(RunnableC0419a runnableC0419a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0419a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = runnableC0419a;
                    this.a = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        b90.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.b.c;
                        if (dVar != null) {
                            dVar.a(com.kuaishou.weapon.un.w0.i4, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            g80.f(true);
                            b c = g80.c(g80.b);
                            RunnableC0419a runnableC0419a = this.b;
                            c.b(runnableC0419a.a, runnableC0419a.c);
                        }
                        this.a.set(true);
                    }
                }
            }

            public RunnableC0419a(a aVar, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = timer;
                this.c = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b90.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.a);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.b.schedule(new C0420a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(g80.b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    g80.j(dnsHelper.getIpList(this.a));
                    List<String> list = g80.c;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b90.a("DNSUrlProvider", "bddns > bdDnsIps = " + g80.c);
                    String str = g80.c.get(0);
                    if (this.c != null && !atomicBoolean.get()) {
                        this.c.a(0, "ok", str);
                        if (g80.c.size() > 1) {
                            g80.d++;
                            g80.f(false);
                        }
                    }
                    b90.a("DNSUrlProvider", "bddns > return ip = " + str);
                    this.b.cancel();
                }
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context unused = g80.b = context.getApplicationContext();
            g80.i();
        }

        public static synchronized a c(Context context) {
            InterceptResult invokeL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a(context);
                    }
                    aVar = a;
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.repackage.g80.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // com.repackage.g80.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    b90.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (g80.c != null && g80.c.size() > 0) {
                        if (g80.d < g80.c.size()) {
                            if (dVar != null) {
                                dVar.a(0, "ok", g80.c.get(g80.d));
                                b90.a("DNSUrlProvider", "retry bddns > return ip = " + g80.c.get(g80.d));
                            }
                            g80.d++;
                            return;
                        }
                        g80.f(true);
                        g80.c(g80.b).b(str, dVar);
                        return;
                    }
                    w80.a(g80.b).b(new RunnableC0419a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    b90.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    g80.f(true);
                    g80.c(g80.b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes6.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public static c a;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    if (a == null) {
                        a = new c();
                    }
                    cVar = a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // com.repackage.g80.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // com.repackage.g80.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                b90.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    g80.i();
                    dVar.a(0, "ok", str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(int i, String str, String str2);
    }

    /* loaded from: classes6.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;
        public static e a;
        public transient /* synthetic */ FieldHolder $fh;

        public e(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context unused = g80.b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (a == null) {
                        a = new e(context);
                    }
                    eVar = a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.repackage.g80.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        @Override // com.repackage.g80.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                b90.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    v80 v80Var = new v80(g80.b);
                    v80Var.a(dVar);
                    u80.e(v80Var, v80Var);
                } catch (Exception unused) {
                    g80.f(true);
                    g80.c(g80.b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755724302, "Lcom/repackage/g80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755724302, "Lcom/repackage/g80;");
                return;
            }
        }
        c = Collections.synchronizedList(new ArrayList());
        d = 0;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            b = context.getApplicationContext();
            int a2 = z80.a(context);
            if (a2 != 1 && a2 != 2) {
                if (c90.c(context) && a == 2) {
                    return a.c(context);
                }
                if (a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = c;
            return list != null && d <= list.size();
        }
        return invokeV.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            if (z) {
                int a2 = z80.a(b);
                if (a2 != 1 && a2 != 2) {
                    int i = a;
                    if (i == 0) {
                        a = 2;
                    } else if (i == 2) {
                        a = 3;
                    } else if (i == 3) {
                        a = 0;
                    }
                } else {
                    a = 0;
                }
            }
            b90.a("DNSUrlProvider", "try to connect ip, now policy =" + a);
            return a;
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
                d = 0;
                c.clear();
                a = 3;
            } catch (Exception e2) {
                b90.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            c.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (e(list.get(i))) {
                        arrayList.add(list.get(i));
                    } else {
                        arrayList2.add(list.get(i));
                    }
                }
            }
            if (arrayList.size() + arrayList2.size() > 0) {
                int f = c90.f(b);
                b90.b("DNSUrlProvider", "getIpPriority :" + f + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f == 1) {
                    c.addAll(arrayList2);
                } else if (f == 2) {
                    c.addAll(arrayList2);
                    c.addAll(arrayList);
                } else if (f != 4) {
                    c.addAll(arrayList);
                    c.addAll(arrayList2);
                } else {
                    c.addAll(arrayList);
                }
            }
        }
    }
}
