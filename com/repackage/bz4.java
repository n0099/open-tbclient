package com.repackage;

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
import com.repackage.vy4;
import com.repackage.yy4;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class bz4 {
    public static /* synthetic */ Interceptable $ic;
    public static bz4 l;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public List<String> e;
    public boolean f;
    public final Object g;
    public List<String> h;
    public boolean i;
    public BDHttpDnsResult j;
    public final nj k;

    /* loaded from: classes5.dex */
    public class a implements nj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz4 a;

        public a(bz4 bz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bz4Var;
        }

        @Override // com.repackage.nj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.nj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if ((i == 2 || i == 9) && ni.z()) {
                    bz4.d(this.a);
                    if (UseHttpdnsSdkSwitch.isOn()) {
                        if (this.a.h == null || this.a.h.isEmpty()) {
                            this.a.w();
                        } else {
                            this.a.a();
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("retryiplist_");
                        stringBuffer.append(da.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.c());
                        }
                        ea.a("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                        if (this.a.a >= 5) {
                            BdSocketLinkService.setAvailable(false);
                            this.a.B();
                        }
                    } else if (this.a.a >= 5) {
                        ea.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + da.d());
                        this.a.C();
                    }
                }
            }
        }

        @Override // com.repackage.nj
        public void c(jj jjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jjVar) == null) {
            }
        }

        @Override // com.repackage.nj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            }
        }

        @Override // com.repackage.nj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.repackage.nj
        public void f(rj rjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, rjVar) == null) {
            }
        }

        @Override // com.repackage.nj
        public void g(int i, jj jjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i, jjVar) == null) {
            }
        }

        @Override // com.repackage.nj
        public void h(jj jjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, jjVar) == null) {
            }
        }

        @Override // com.repackage.nj
        public void i(jj jjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jjVar) == null) {
            }
        }

        @Override // com.repackage.nj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (this.a.a > 0) {
                        this.a.i = false;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("URL_");
                        stringBuffer.append(da.d());
                        if (this.a.j != null) {
                            stringBuffer.append("-dnsResolveIp_");
                            stringBuffer.append(this.a.j.a());
                            stringBuffer.append("-dnsResolveType_");
                            stringBuffer.append(this.a.j.d());
                            stringBuffer.append("-dnsResolveStatus_");
                            stringBuffer.append(this.a.j.c());
                        }
                        ea.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                    }
                } else if (this.a.a >= 5) {
                    ea.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + da.d());
                    vy4.f().l(da.d());
                    vy4.f().k();
                }
                this.a.a = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BDHttpDns.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz4 a;

        public b(bz4 bz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bz4Var;
        }

        @Override // com.baidu.bdhttpdns.BDHttpDns.e
        public void a(BDHttpDnsResult bDHttpDnsResult) {
            ArrayList<String> a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDHttpDnsResult) == null) {
                this.a.i = false;
                this.a.j = bDHttpDnsResult;
                if (bDHttpDnsResult == null || (a = bDHttpDnsResult.a()) == null || a.isEmpty()) {
                    return;
                }
                synchronized (this.a.g) {
                    this.a.h = a;
                }
                this.a.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements vy4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bz4 b;

        public c(bz4 bz4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bz4Var;
            this.a = str;
        }

        @Override // com.repackage.vy4.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b = 0;
                this.b.e = vy4.f().g();
                if (this.b.e != null) {
                    this.b.A(this.a);
                } else {
                    this.b.f = false;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements yy4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz4 a;

        /* loaded from: classes5.dex */
        public class a implements vy4.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.repackage.vy4.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.b = 0;
                    this.a.a.e = vy4.f().g();
                    if (this.a.a.e != null) {
                        this.a.a.A("change ip to reconnect with DNS' failed.");
                    } else {
                        this.a.a.f = false;
                    }
                }
            }
        }

        public d(bz4 bz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bz4Var;
        }

        @Override // com.repackage.yy4.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                wy4.e().a(z ? 2 : 1);
                if (z) {
                    this.a.e = vy4.f().g();
                    if (this.a.e != null) {
                        this.a.A("change ip to reconnect with DNS' failed.");
                        return;
                    } else {
                        vy4.f().m(new a(this));
                        return;
                    }
                }
                this.a.f = false;
                this.a.D();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755809707, "Lcom/repackage/bz4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755809707, "Lcom/repackage/bz4;");
        }
    }

    public bz4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = false;
        this.g = new Object();
        this.h = new ArrayList();
        this.i = false;
        this.j = null;
        this.k = new a(this);
    }

    public static /* synthetic */ int d(bz4 bz4Var) {
        int i = bz4Var.a;
        bz4Var.a = i + 1;
        return i;
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

    public static synchronized bz4 y() {
        InterceptResult invokeV;
        bz4 bz4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            synchronized (bz4.class) {
                if (l == null) {
                    synchronized (bz4.class) {
                        if (l == null) {
                            l = new bz4();
                        }
                    }
                }
                bz4Var = l;
            }
            return bz4Var;
        }
        return (bz4) invokeV.objValue;
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            String x = x();
            if (x == null) {
                if (!vy4.f().i()) {
                    vy4.f().m(new c(this, str));
                }
                da.h(TiebaIMConfig.url);
                BdSocketLinkService.setAvailable(false);
                D();
            } else if (u(x) == null) {
                D();
            } else {
                this.f = false;
                BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
                da.h(x);
                BdSocketLinkService.init();
                BdSocketLinkService.startService(true, str);
                this.c = true;
                this.b++;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView.f();
            this.b = 0;
            this.i = false;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f) {
            return;
        }
        this.f = true;
        if (this.c) {
            this.c = false;
            wy4.e().d(TiebaIMConfig.url);
        }
        wy4.e().b();
        if (!this.d) {
            new yy4("www.baidu.com", new d(this));
            this.d = true;
            return;
        }
        A("change ip to reconnect with DNS' failed.");
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NoNetworkView.f();
            this.d = false;
            this.b = 0;
            this.f = false;
            this.c = false;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.g) {
                if (this.h != null && !this.h.isEmpty()) {
                    String remove = this.h.remove(0);
                    if (!TextUtils.isEmpty(remove)) {
                        da.h("ws://" + remove + ":" + v(TiebaIMConfig.url));
                        BdSocketLinkService.init();
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.i) {
            return;
        }
        try {
            String u = u(TiebaIMConfig.url);
            if (oi.isEmpty(u)) {
                B();
                return;
            }
            this.i = true;
            BDHttpDns.h(BdBaseApplication.getInst().getApplicationContext()).b(u, new b(this));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public final String x() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<String> list = this.e;
            if (list == null || (i = this.b) <= -1 || i >= list.size()) {
                return null;
            }
            return vy4.f().g().get(this.b);
        }
        return (String) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            oj.j().c(this.k);
        }
    }
}
