package d.a.p0.t.j;

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
import d.a.d.e.p.j;
import d.a.d.e.r.k;
import d.a.p0.t.j.a;
import d.a.p0.t.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static g l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f54064a;

    /* renamed from: b  reason: collision with root package name */
    public int f54065b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54066c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54067d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f54068e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54069f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f54070g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f54071h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54072i;
    public BDHttpDnsResult j;
    public final d.a.d.e.r.g k;

    /* loaded from: classes7.dex */
    public class a implements d.a.d.e.r.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f54073a;

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
            this.f54073a = gVar;
        }

        @Override // d.a.d.e.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if ((i2 == 2 || i2 == 9) && j.z()) {
                    g.d(this.f54073a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.f54073a.f54071h == null || this.f54073a.f54071h.isEmpty()) {
                            this.f54073a.w();
                        } else {
                            this.f54073a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(d.a.d.c.e.c.h.d());
                        if (this.f54073a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f54073a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f54073a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f54073a.j.c());
                        }
                        d.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.f54073a.f54064a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.f54073a.B();
                        }
                    } else if (this.f54073a.f54064a >= 5) {
                        d.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + d.a.d.c.e.c.h.d());
                        this.f54073a.C();
                    }
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void c(d.a.d.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void g(int i2, d.a.d.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, cVar) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void h(d.a.d.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void i(d.a.d.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            }
        }

        @Override // d.a.d.e.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.f54073a.f54064a > 0) {
                        this.f54073a.f54072i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(d.a.d.c.e.c.h.d());
                        if (this.f54073a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f54073a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f54073a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f54073a.j.c());
                        }
                        d.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.f54073a.f54064a >= 5) {
                    d.a.d.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + d.a.d.c.e.c.h.d());
                    d.a.p0.t.j.a.f().l(d.a.d.c.e.c.h.d());
                    d.a.p0.t.j.a.f().k();
                }
                this.f54073a.f54064a = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BDHttpDns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f54074a;

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
            this.f54074a = gVar;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDHttpDnsResult) == null) {
                this.f54074a.f54072i = false;
                this.f54074a.j = bDHttpDnsResult;
                if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                    return;
                }
                synchronized (this.f54074a.f54070g) {
                    this.f54074a.f54071h = a2;
                }
                this.f54074a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54075a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f54076b;

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
            this.f54076b = gVar;
            this.f54075a = str;
        }

        @Override // d.a.p0.t.j.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54076b.f54065b = 0;
                this.f54076b.f54068e = d.a.p0.t.j.a.f().g();
                if (this.f54076b.f54068e != null) {
                    this.f54076b.A(this.f54075a);
                } else {
                    this.f54076b.f54069f = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f54077a;

        /* loaded from: classes7.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f54078a;

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
                this.f54078a = dVar;
            }

            @Override // d.a.p0.t.j.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f54078a.f54077a.f54065b = 0;
                    this.f54078a.f54077a.f54068e = d.a.p0.t.j.a.f().g();
                    if (this.f54078a.f54077a.f54068e != null) {
                        this.f54078a.f54077a.A("change ip to reconnect with DNS' failed.");
                    } else {
                        this.f54078a.f54077a.f54069f = false;
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
            this.f54077a = gVar;
        }

        @Override // d.a.p0.t.j.d.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.p0.t.j.b.e().a(z ? 2 : 1);
                if (z) {
                    this.f54077a.f54068e = d.a.p0.t.j.a.f().g();
                    if (this.f54077a.f54068e != null) {
                        this.f54077a.A("change ip to reconnect with DNS' failed.");
                        return;
                    } else {
                        d.a.p0.t.j.a.f().m(new a(this));
                        return;
                    }
                }
                this.f54077a.f54069f = false;
                this.f54077a.D();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1108442562, "Ld/a/p0/t/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1108442562, "Ld/a/p0/t/j/g;");
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
        this.f54065b = 0;
        this.f54066c = false;
        this.f54067d = false;
        this.f54068e = null;
        this.f54069f = false;
        this.f54070g = new Object();
        this.f54071h = new ArrayList();
        this.f54072i = false;
        this.j = null;
        this.k = new a(this);
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f54064a;
        gVar.f54064a = i2 + 1;
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
                if (!d.a.p0.t.j.a.f().i()) {
                    d.a.p0.t.j.a.f().m(new c(this, str));
                }
                d.a.d.c.e.c.h.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f54069f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                d.a.d.c.e.c.h.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.f54066c = true;
                this.f54065b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.f();
            this.f54065b = 0;
            this.f54072i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f54069f) {
            return;
        }
        this.f54069f = true;
        if (this.f54066c) {
            this.f54066c = false;
            d.a.p0.t.j.b.e().d(TiebaIMConfig.url);
        }
        d.a.p0.t.j.b.e().b();
        if (!this.f54067d) {
            new d.a.p0.t.j.d("www.baidu.com", new d(this));
            this.f54067d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.f();
            this.f54067d = false;
            this.f54065b = 0;
            this.f54069f = false;
            this.f54066c = false;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f54070g) {
                if (this.f54071h != null && !this.f54071h.isEmpty()) {
                    String remove = this.f54071h.remove(0);
                    if (!TextUtils.isEmpty(remove)) {
                        d.a.d.c.e.c.h.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f54072i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (d.a.d.e.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.f54072i = true;
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
            List<String> list = this.f54068e;
            if (list == null || (i2 = this.f54065b) <= -1 || i2 >= list.size()) {
                return null;
            }
            return d.a.p0.t.j.a.f().g().get(this.f54065b);
        }
        return (String) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.d.e.r.h.j().c(this.k);
        }
    }
}
