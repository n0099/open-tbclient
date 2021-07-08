package d.a.o0.s.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.r.k;
import d.a.o0.s.j.a;
import d.a.o0.s.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static g l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53389a;

    /* renamed from: b  reason: collision with root package name */
    public int f53390b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53391c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53392d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f53393e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53394f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f53395g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f53396h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53397i;
    public BDHttpDnsResult j;
    public final d.a.c.e.r.g k;

    /* loaded from: classes7.dex */
    public class a implements d.a.c.e.r.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f53398a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53398a = gVar;
        }

        @Override // d.a.c.e.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if ((i2 == 2 || i2 == 9) && j.z()) {
                    g.d(this.f53398a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.f53398a.f53396h == null || this.f53398a.f53396h.isEmpty()) {
                            this.f53398a.w();
                        } else {
                            this.f53398a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(d.a.c.c.e.c.h.d());
                        if (this.f53398a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f53398a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f53398a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f53398a.j.c());
                        }
                        d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.f53398a.f53389a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.f53398a.B();
                        }
                    } else if (this.f53398a.f53389a >= 5) {
                        d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + d.a.c.c.e.c.h.d());
                        this.f53398a.C();
                    }
                }
            }
        }

        @Override // d.a.c.e.r.g
        public void c(d.a.c.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void g(int i2, d.a.c.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, cVar) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void h(d.a.c.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void i(d.a.c.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            }
        }

        @Override // d.a.c.e.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.f53398a.f53389a > 0) {
                        this.f53398a.f53397i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(d.a.c.c.e.c.h.d());
                        if (this.f53398a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f53398a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f53398a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f53398a.j.c());
                        }
                        d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.f53398a.f53389a >= 5) {
                    d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + d.a.c.c.e.c.h.d());
                    d.a.o0.s.j.a.f().l(d.a.c.c.e.c.h.d());
                    d.a.o0.s.j.a.f().k();
                }
                this.f53398a.f53389a = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BDHttpDns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f53399a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53399a = gVar;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDHttpDnsResult) == null) {
                this.f53399a.f53397i = false;
                this.f53399a.j = bDHttpDnsResult;
                if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                    return;
                }
                synchronized (this.f53399a.f53395g) {
                    this.f53399a.f53396h = a2;
                }
                this.f53399a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53400a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f53401b;

        public c(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53401b = gVar;
            this.f53400a = str;
        }

        @Override // d.a.o0.s.j.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53401b.f53390b = 0;
                this.f53401b.f53393e = d.a.o0.s.j.a.f().g();
                if (this.f53401b.f53393e != null) {
                    this.f53401b.A(this.f53400a);
                } else {
                    this.f53401b.f53394f = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f53402a;

        /* loaded from: classes7.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f53403a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53403a = dVar;
            }

            @Override // d.a.o0.s.j.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f53403a.f53402a.f53390b = 0;
                    this.f53403a.f53402a.f53393e = d.a.o0.s.j.a.f().g();
                    if (this.f53403a.f53402a.f53393e != null) {
                        this.f53403a.f53402a.A("change ip to reconnect with DNS' failed.");
                    } else {
                        this.f53403a.f53402a.f53394f = false;
                    }
                }
            }
        }

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53402a = gVar;
        }

        @Override // d.a.o0.s.j.d.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.o0.s.j.b.e().a(z ? 2 : 1);
                if (z) {
                    this.f53402a.f53393e = d.a.o0.s.j.a.f().g();
                    if (this.f53402a.f53393e != null) {
                        this.f53402a.A("change ip to reconnect with DNS' failed.");
                        return;
                    } else {
                        d.a.o0.s.j.a.f().m(new a(this));
                        return;
                    }
                }
                this.f53402a.f53394f = false;
                this.f53402a.D();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(670382750, "Ld/a/o0/s/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(670382750, "Ld/a/o0/s/j/g;");
        }
    }

    public g() {
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
        this.f53390b = 0;
        this.f53391c = false;
        this.f53392d = false;
        this.f53393e = null;
        this.f53394f = false;
        this.f53395g = new Object();
        this.f53396h = new ArrayList();
        this.f53397i = false;
        this.j = null;
        this.k = new a(this);
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f53389a;
        gVar.f53389a = i2 + 1;
        return i2;
    }

    public static String u(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
                try {
                    return str.substring(5, lastIndexOf);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String v(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
                try {
                    return str.substring(lastIndexOf + 1);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized g y() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            synchronized (g.class) {
                if (l == null) {
                    synchronized (g.class) {
                        if (l == null) {
                            l = new g();
                        }
                    }
                }
                gVar = l;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String x = x();
            if (x == null) {
                if (!d.a.o0.s.j.a.f().i()) {
                    d.a.o0.s.j.a.f().m(new c(this, str));
                }
                d.a.c.c.e.c.h.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f53394f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                d.a.c.c.e.c.h.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.f53391c = true;
                this.f53390b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.f();
            this.f53390b = 0;
            this.f53397i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f53394f) {
            return;
        }
        this.f53394f = true;
        if (this.f53391c) {
            this.f53391c = false;
            d.a.o0.s.j.b.e().d(TiebaIMConfig.url);
        }
        d.a.o0.s.j.b.e().b();
        if (!this.f53392d) {
            new d.a.o0.s.j.d("www.baidu.com", new d(this));
            this.f53392d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.f();
            this.f53392d = false;
            this.f53390b = 0;
            this.f53394f = false;
            this.f53391c = false;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f53395g) {
                if (this.f53396h != null && !this.f53396h.isEmpty()) {
                    String remove = this.f53396h.remove(0);
                    if (!TextUtils.isEmpty(remove)) {
                        d.a.c.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f53397i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (d.a.c.e.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.f53397i = true;
            BDHttpDns.j(BdBaseApplication.getInst().getApplicationContext()).c(u, new b(this));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final String x() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<String> list = this.f53393e;
            if (list == null || (i2 = this.f53390b) <= -1 || i2 >= list.size()) {
                return null;
            }
            return d.a.o0.s.j.a.f().g().get(this.f53390b);
        }
        return (String) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.c.e.r.h.j().c(this.k);
        }
    }
}
