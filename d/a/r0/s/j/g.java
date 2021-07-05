package d.a.r0.s.j;

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
import d.a.r0.s.j.a;
import d.a.r0.s.j.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static g l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f56670a;

    /* renamed from: b  reason: collision with root package name */
    public int f56671b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56672c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56673d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f56674e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56675f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f56676g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f56677h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56678i;
    public BDHttpDnsResult j;
    public final d.a.c.e.r.g k;

    /* loaded from: classes9.dex */
    public class a implements d.a.c.e.r.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f56679a;

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
            this.f56679a = gVar;
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
                    g.d(this.f56679a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.f56679a.f56677h == null || this.f56679a.f56677h.isEmpty()) {
                            this.f56679a.w();
                        } else {
                            this.f56679a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(d.a.c.c.e.c.h.d());
                        if (this.f56679a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f56679a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f56679a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f56679a.j.c());
                        }
                        d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.f56679a.f56670a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.f56679a.B();
                        }
                    } else if (this.f56679a.f56670a >= 5) {
                        d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + d.a.c.c.e.c.h.d());
                        this.f56679a.C();
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
                    if (this.f56679a.f56670a > 0) {
                        this.f56679a.f56678i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(d.a.c.c.e.c.h.d());
                        if (this.f56679a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.f56679a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.f56679a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.f56679a.j.c());
                        }
                        d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.f56679a.f56670a >= 5) {
                    d.a.c.c.e.c.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + d.a.c.c.e.c.h.d());
                    d.a.r0.s.j.a.f().l(d.a.c.c.e.c.h.d());
                    d.a.r0.s.j.a.f().k();
                }
                this.f56679a.f56670a = 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BDHttpDns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f56680a;

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
            this.f56680a = gVar;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.a
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDHttpDnsResult) == null) {
                this.f56680a.f56678i = false;
                this.f56680a.j = bDHttpDnsResult;
                if (bDHttpDnsResult == null || (a2 = bDHttpDnsResult.a()) == null || a2.isEmpty()) {
                    return;
                }
                synchronized (this.f56680a.f56676g) {
                    this.f56680a.f56677h = a2;
                }
                this.f56680a.a();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f56681a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f56682b;

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
            this.f56682b = gVar;
            this.f56681a = str;
        }

        @Override // d.a.r0.s.j.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56682b.f56671b = 0;
                this.f56682b.f56674e = d.a.r0.s.j.a.f().g();
                if (this.f56682b.f56674e != null) {
                    this.f56682b.A(this.f56681a);
                } else {
                    this.f56682b.f56675f = false;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f56683a;

        /* loaded from: classes9.dex */
        public class a implements a.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f56684a;

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
                this.f56684a = dVar;
            }

            @Override // d.a.r0.s.j.a.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f56684a.f56683a.f56671b = 0;
                    this.f56684a.f56683a.f56674e = d.a.r0.s.j.a.f().g();
                    if (this.f56684a.f56683a.f56674e != null) {
                        this.f56684a.f56683a.A("change ip to reconnect with DNS' failed.");
                    } else {
                        this.f56684a.f56683a.f56675f = false;
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
            this.f56683a = gVar;
        }

        @Override // d.a.r0.s.j.d.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.r0.s.j.b.e().a(z ? 2 : 1);
                if (z) {
                    this.f56683a.f56674e = d.a.r0.s.j.a.f().g();
                    if (this.f56683a.f56674e != null) {
                        this.f56683a.A("change ip to reconnect with DNS' failed.");
                        return;
                    } else {
                        d.a.r0.s.j.a.f().m(new a(this));
                        return;
                    }
                }
                this.f56683a.f56675f = false;
                this.f56683a.D();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-457013343, "Ld/a/r0/s/j/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-457013343, "Ld/a/r0/s/j/g;");
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
        this.f56671b = 0;
        this.f56672c = false;
        this.f56673d = false;
        this.f56674e = null;
        this.f56675f = false;
        this.f56676g = new Object();
        this.f56677h = new ArrayList();
        this.f56678i = false;
        this.j = null;
        this.k = new a(this);
    }

    public static /* synthetic */ int d(g gVar) {
        int i2 = gVar.f56670a;
        gVar.f56670a = i2 + 1;
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
                if (!d.a.r0.s.j.a.f().i()) {
                    d.a.r0.s.j.a.f().m(new c(this, str));
                }
                d.a.c.c.e.c.h.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f56675f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                d.a.c.c.e.c.h.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.f56672c = true;
                this.f56671b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.f();
            this.f56671b = 0;
            this.f56678i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f56675f) {
            return;
        }
        this.f56675f = true;
        if (this.f56672c) {
            this.f56672c = false;
            d.a.r0.s.j.b.e().d(TiebaIMConfig.url);
        }
        d.a.r0.s.j.b.e().b();
        if (!this.f56673d) {
            new d.a.r0.s.j.d("www.baidu.com", new d(this));
            this.f56673d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.f();
            this.f56673d = false;
            this.f56671b = 0;
            this.f56675f = false;
            this.f56672c = false;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f56676g) {
                if (this.f56677h != null && !this.f56677h.isEmpty()) {
                    String remove = this.f56677h.remove(0);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f56678i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (d.a.c.e.p.k.isEmpty(u)) {
                B();
                return;
            }
            this.f56678i = true;
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
            List<String> list = this.f56674e;
            if (list == null || (i2 = this.f56671b) <= -1 || i2 >= list.size()) {
                return null;
            }
            return d.a.r0.s.j.a.f().g().get(this.f56671b);
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
