package d.a.v.a.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import d.a.v.a.c.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes8.dex */
public final class f extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d.a.v.a.b.b D;
    public static volatile f E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f68378a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f68379b;

    /* renamed from: c  reason: collision with root package name */
    public int f68380c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68381d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<d.a.v.a.c.b> f68382e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, d.a.v.a.c.b> f68383f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f68384g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f68385h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.v.a.e.b f68386i;
    public Map<Long, d.a.v.a.b.d.b> j;
    public Map<Long, d.a.v.a.b.d.b> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public d.a.v.a.c.d r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes8.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f68387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68388b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f68389c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f68390d;

        public a(f fVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68390d = fVar;
            this.f68387a = str;
            this.f68388b = str2;
            this.f68389c = str3;
        }

        @Override // d.a.v.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                d.a.v.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.f68387a;
                }
                f fVar = this.f68390d;
                fVar.w = str2;
                d.a.v.a.a.c d2 = d.a.v.a.a.a.h(fVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f68388b).d("ip", str2).d("domain", this.f68387a).d(ProbeTB.PROTOCOL, this.f68389c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    d.a.v.a.a.a.h(this.f68390d.q).g(601110).b("connect_state", 2);
                    d.a.v.a.g.a a2 = d.a.v.a.g.a.a(this.f68390d.q);
                    f fVar2 = this.f68390d;
                    a2.b(new e(fVar2, str2, this.f68388b, Integer.valueOf(fVar2.f68379b.incrementAndGet())));
                    return;
                }
                d.a.v.a.a.a.h(this.f68390d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f68390d.p.get()).e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f68391e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68391e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68391e.M();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f68392e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68392e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f68392e;
                fVar.f0(fVar.f68386i.b(this.f68392e.q, 1L));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68393a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2099812371, "Ld/a/v/a/c/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2099812371, "Ld/a/v/a/c/f$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f68393a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68393a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68393a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68393a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f68394e;

        /* renamed from: f  reason: collision with root package name */
        public String f68395f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f68396g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f68397h;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68398e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68398e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.v.a.h.d.c(this.f68398e.f68397h.q);
                    d.a.v.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f68398e.f68397h.A));
                }
            }
        }

        public e(f fVar, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68397h = fVar;
            this.f68395f = str;
            this.f68394e = str2;
            this.f68396g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e2) {
                        d.a.v.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
                    }
                    if (!this.f68397h.I()) {
                        if (this.f68397h.m != null && this.f68397h.m.isAlive()) {
                            this.f68397h.m.interrupt();
                            d.a.v.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f68397h.l != null && this.f68397h.l.isAlive()) {
                            this.f68397h.l.interrupt();
                            d.a.v.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        RunnableC1926f runnableC1926f = new RunnableC1926f(this.f68397h, this.f68396g, this.f68395f);
                        this.f68397h.u.a(this.f68395f);
                        this.f68397h.u.postDelayed(runnableC1926f, 15000L);
                        try {
                            d.a.v.a.a.a.h(this.f68397h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            d.a.v.a.c.e e3 = this.f68397h.r.e(this.f68395f, Integer.valueOf(this.f68394e).intValue());
                            if (this.f68397h.I()) {
                                d.a.v.a.a.a.h(this.f68397h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f68397h.p.get()).e();
                                d.a.v.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f68397h.J(e3);
                                return;
                            } else if (e3.f68374b.booleanValue()) {
                                synchronized (this.f68397h.f68378a) {
                                    d.a.v.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f68397h.u.removeCallbacks(runnableC1926f);
                                    runnableC1926f.a();
                                    if (!this.f68397h.I()) {
                                        if (this.f68397h.f68378a.get(this.f68396g) == null) {
                                            d.a.v.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f68397h.r.c(e3);
                                        }
                                        d.a.v.a.a.a.h(this.f68397h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        d.a.v.a.h.f.B(this.f68397h.q, this.f68397h.p.get() == 0 ? 1 : 2);
                                        d.a.v.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        d.a.v.a.c.a.g(this.f68397h.q, this.f68395f);
                                        d.a.v.a.a.a.h(this.f68397h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f68397h.f0(this.f68397h.f68386i.b(this.f68397h.q, 1L));
                                        this.f68397h.v = SystemClock.currentThreadTimeMillis();
                                        if (d.a.v.a.h.c.a(this.f68397h.q) != 0) {
                                            d.a.v.a.g.a.a(this.f68397h.q).b(new a(this));
                                        }
                                        d.a.v.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f68397h.v);
                                        f.D.f68343a = -2;
                                        this.f68397h.o = false;
                                        this.f68397h.l = new j(this.f68397h, this.f68395f);
                                        this.f68397h.l.start();
                                        this.f68397h.m = new i(this.f68397h, this.f68395f);
                                        this.f68397h.m.start();
                                        return;
                                    }
                                    d.a.v.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f68397h.J(e3);
                                    return;
                                }
                            } else {
                                d.a.v.a.a.a.h(this.f68397h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f68395f).d("con_err_code", "P14").b("retry_cout", this.f68397h.p.get()).e();
                                this.f68397h.u.removeCallbacks(runnableC1926f);
                                this.f68397h.i0("connect env error:", this.f68395f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            d.a.v.a.h.e.c("SocketTransceiver", str, th);
                            this.f68397h.u.removeCallbacks(runnableC1926f);
                            runnableC1926f.a();
                            synchronized (this.f68397h.f68378a) {
                                if (this.f68397h.f68378a.get(this.f68396g) != null) {
                                    this.f68397h.f68378a.remove(this.f68396g);
                                    return;
                                }
                                this.f68397h.O("ConnectTask exception:" + str, this.f68395f);
                                return;
                            }
                        }
                    }
                    d.a.v.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    d.a.v.a.a.a.h(this.f68397h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f68397h.p.get()).e();
                }
            }
        }
    }

    /* renamed from: d.a.v.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1926f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f68399e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68400f;

        /* renamed from: g  reason: collision with root package name */
        public String f68401g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f68402h;

        public RunnableC1926f(f fVar, Integer num, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, num, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68402h = fVar;
            this.f68400f = false;
            this.f68399e = num;
            this.f68401g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68400f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f68402h.f68378a) {
                    if (!this.f68400f && f.D.f68343a != 0) {
                        this.f68402h.f68378a.put(this.f68399e, Boolean.TRUE);
                        d.a.v.a.a.a.h(this.f68402h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f68402h.O("time out:", this.f68401g);
                        return;
                    }
                    d.a.v.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f68402h.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f68403a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f68404b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(f fVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68404b = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f68403a = str;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                long j = message.arg1;
                synchronized (this.f68404b.f68385h) {
                    this.f68404b.Y(j, this.f68403a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f68407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f68408f;

        public i(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68408f = fVar;
            this.f68407e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.a.v.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f68408f.o) {
                    try {
                        try {
                            d.a.v.a.c.b c2 = this.f68408f.f68386i.c(this.f68408f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f68408f.u.removeCallbacks(this.f68408f.s);
                                c2.m = false;
                                d.a.v.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.k) {
                                    if (c2.f68370i == 1 && c2.f68369h == 4) {
                                        Context context = this.f68408f.q;
                                        d.a.v.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f68370i == 50 && c2.f68369h == 2) {
                                        Context context2 = this.f68408f.q;
                                        d.a.v.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f68408f.f68385h) {
                                        d.a.v.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (d.a.v.a.c.b) this.f68408f.f68383f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f68408f.W(c2, bVar, this.f68407e);
                                }
                                synchronized (this.f68408f.f68385h) {
                                    if (this.f68408f.f68383f.size() != 0) {
                                        d.a.v.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f68408f.s.b(c2.n);
                                        this.f68408f.s.a(this.f68407e);
                                        this.f68408f.u.a(this.f68407e);
                                        this.f68408f.u.postDelayed(this.f68408f.s, c2.f68363b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f68408f.o) {
                                return;
                            }
                            d.a.v.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f68408f.f68381d = false;
                            f fVar = this.f68408f;
                            fVar.O("ReadThread exception: " + e2, this.f68407e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f68408f.o) {
                            return;
                        }
                        d.a.v.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f68408f.f68381d = false;
                        f fVar2 = this.f68408f;
                        fVar2.O("onStartCommand:" + e3, this.f68407e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f68409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f68410f;

        public j(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68410f = fVar;
            this.f68409e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f68410f.o) {
                    try {
                        d.a.v.a.c.b bVar = null;
                        try {
                            synchronized (this.f68410f.f68382e) {
                                if (this.f68410f.f68382e.size() == 0) {
                                    this.f68410f.f68382e.wait();
                                } else {
                                    bVar = (d.a.v.a.c.b) this.f68410f.f68382e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            d.a.v.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            f fVar = this.f68410f;
                            fVar.O("SendThread wait exception: " + e2, this.f68409e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f68410f.o) {
                                    this.f68410f.X(bVar.n, this.f68409e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.j = f.D.f68343a;
                                if (bVar.o) {
                                    synchronized (this.f68410f.f68385h) {
                                        if (this.f68410f.f68383f.isEmpty()) {
                                            this.f68410f.u.removeCallbacks(this.f68410f.s);
                                            this.f68410f.s.b(bVar.n);
                                            this.f68410f.s.a(this.f68409e);
                                            this.f68410f.u.a(this.f68409e);
                                            this.f68410f.u.postDelayed(this.f68410f.s, 15000L);
                                        }
                                    }
                                }
                                d.a.v.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f68370i == 1 && bVar.f68369h == 4) {
                                    Context context = this.f68410f.q;
                                    d.a.v.a.h.b.a(context, 1L, "send", bVar.n + "");
                                }
                                if (bVar.f68370i == 50 && bVar.f68369h == 2) {
                                    Context context2 = this.f68410f.q;
                                    d.a.v.a.h.b.a(context2, 50L, "send", bVar.n + "");
                                }
                                synchronized (this.f68410f.f68384g) {
                                    this.f68410f.r.f(bVar);
                                }
                                if (!bVar.k && bVar.o) {
                                    synchronized (this.f68410f.f68385h) {
                                        this.f68410f.f68383f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                d.a.v.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f68410f.T(bVar.n, e3.toString(), this.f68409e);
                                f fVar2 = this.f68410f;
                                fVar2.O("SendThread sendMessage Exception:" + e3, this.f68409e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        d.a.v.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        f fVar3 = this.f68410f;
                        fVar3.O("SendThread Exception:" + e4, this.f68409e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f68411e;

        /* renamed from: f  reason: collision with root package name */
        public String f68412f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f68413g;

        public k(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68413g = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f68412f = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f68411e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f68413g.Y(this.f68411e, this.f68412f);
                this.f68413g.O("read and write thread timeout:", this.f68412f);
            }
        }

        public /* synthetic */ k(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(788875565, "Ld/a/v/a/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(788875565, "Ld/a/v/a/c/f;");
                return;
            }
        }
        D = new d.a.v.a.b.b();
    }

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68378a = new TreeMap();
        this.f68379b = new AtomicInteger(0);
        this.f68380c = 0;
        this.f68381d = false;
        this.f68382e = new LinkedList<>();
        this.f68383f = new LinkedHashMap();
        this.f68384g = new Object();
        this.f68385h = new Object();
        this.f68386i = new d.a.v.a.e.b();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.n = new h(this, null);
        this.o = false;
        this.p = new AtomicInteger(0);
        this.s = new k(this, null);
        this.x = "";
        this.y = "";
        this.z = "";
        this.B = new b(this);
        this.C = new c(this);
        this.q = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.t = handlerThread;
        handlerThread.start();
        this.u = new g(this, this.t.getLooper());
    }

    public static synchronized f S(Context context) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (f.class) {
                if (E == null) {
                    E = new f(context.getApplicationContext());
                }
                fVar = E;
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public synchronized void H(BLCPRequest bLCPRequest, d.a.v.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (d.a.v.a.h.f.m(this.q)) {
                    d.a.v.a.c.b bVar2 = new d.a.v.a.c.b();
                    bVar2.f68369h = bLCPRequest.f6438a;
                    bVar2.f68370i = bLCPRequest.f6439b;
                    bVar2.f68362a = bLCPRequest.f6440c;
                    if (bLCPRequest.f6441d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f6441d;
                    }
                    int i2 = d.f68393a[bLCPRequest.f6442e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f68363b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f68363b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f68363b = 15000L;
                    } else {
                        bVar2.f68363b = 50000L;
                    }
                    if (bLCPRequest instanceof d.a.v.a.b.d.a) {
                        long j2 = (bVar2.f68369h * 10000) + bVar2.f68370i;
                        bVar2.n = j2;
                        g0(bVar2.f68369h, bVar2.f68370i, j2, true, bVar);
                    } else {
                        g0(bVar2.f68369h, bVar2.f68370i, bVar2.n, false, bVar);
                        this.f68386i.a(bVar2, true);
                        f0(bVar2);
                    }
                }
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.v.a.c.d dVar = this.r;
            return (dVar == null || dVar.a() == null || this.r.a().f68375c == null || !this.r.a().f68375c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(d.a.v.a.c.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) && eVar != null && eVar.f68373a.booleanValue()) {
            try {
                if (eVar.f68375c != null) {
                    if (eVar.f68375c.hashCode() == this.r.a().f68375c.hashCode()) {
                        d.a.v.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    eVar.f68375c.close();
                    eVar.f68375c = null;
                    if (eVar.f68376d != null) {
                        eVar.f68376d.close();
                        eVar.f68376d = null;
                    }
                    if (eVar.f68377e != null) {
                        eVar.f68377e.close();
                        eVar.f68377e = null;
                    }
                    d.a.v.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                d.a.v.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
            }
        }
    }

    public final long K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 3) {
                return i2 * 1000;
            }
            return 3000L;
        }
        return invokeI.longValue;
    }

    public final synchronized void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            synchronized (this) {
                d.a.v.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                d.a.v.a.c.a.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    d.a.v.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                if (D.f68343a != 0 && D.f68343a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                d.a.v.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.f68343a);
                d.a.v.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.f68343a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (d.a.v.a.h.f.m(this.q)) {
                    d.a.v.a.h.e.d("SocketTransceiver", "destroy");
                    D.f68343a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f68382e) {
                            this.f68382e.notifyAll();
                            d.a.v.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            d.a.v.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            d.a.v.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
                        }
                    }
                }
            }
        }
    }

    public final synchronized void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            synchronized (this) {
                d.a.v.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f68381d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + d.a.v.a.h.f.m(this.q));
                d.a.v.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                d.a.v.a.a.c c2 = d.a.v.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (d.a.v.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f68381d) {
                        d.a.v.a.a.c c3 = d.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f68381d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        d.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    e0(false);
                }
            }
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                d.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.f68382e) {
                    while (this.f68382e.size() > 0) {
                        Q(this.f68382e.removeFirst(), str);
                    }
                    d.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f68385h) {
                    d.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f68383f.keySet()) {
                        Q(this.f68383f.get(l), str);
                    }
                    this.f68383f.clear();
                    d.a.v.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                d.a.v.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(d.a.v.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f68369h == 1) {
            return;
        }
        d.a.v.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f68369h + ", methodId :" + bVar.f68370i);
        W(new d.a.v.a.c.b(), bVar, str);
    }

    public d.a.v.a.b.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (d.a.v.a.b.b) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f68383f.size() <= 0 || !this.f68383f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.v.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f68383f.get(Long.valueOf(j2)).toString());
                d.a.v.a.c.b remove = this.f68383f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f68364c = 8005;
                remove.f68365d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                d.a.v.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(d.a.v.a.c.b bVar, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bVar, str) == null) {
            if (bVar.f68364c == 0) {
                long j2 = bVar.f68368g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f68370i;
                if (j4 == 1) {
                    V(j3, true, str);
                    return;
                } else if (j4 != 2) {
                    if (j4 == 3) {
                        this.n.a(j3);
                        return;
                    }
                    return;
                } else {
                    i0("LCP logout:", str);
                    D.f68343a = bVar.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f68364c + " errmsg:" + bVar.f68365d;
            if (!String.valueOf(bVar.f68364c).startsWith(EventType.GiftEventID.SEND_GIFT_TO_USER_SUCCESS) && (i2 = bVar.f68364c) != 1011 && i2 != 2003) {
                if (i2 != 1012) {
                    if (i2 == 1013) {
                        V(60000L, false, str);
                        return;
                    }
                    D.f68343a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
                d.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                d.a.v.a.h.e.a("SocketTransceiver", "login error :" + bVar.f68364c);
                return;
            }
            d.a.v.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f68364c);
            i0("errorCode:" + String.valueOf(bVar.f68364c), str);
            d.a.v.a.h.f.z(this.q, "");
            d.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            d.a.v.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            d.a.v.a.b.c.f().m();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                d.a.v.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.f68343a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    d.a.v.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                d.a.v.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(d.a.v.a.c.b bVar, d.a.v.a.c.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bVar, bVar2, str) == null) {
            long j2 = bVar.f68369h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f68369h == 1) {
                    U(bVar2, str);
                } else {
                    a0(bVar2);
                }
            }
        }
    }

    public final void X(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048591, this, j2, str) == null) {
            try {
                if (this.f68383f.size() <= 0 || !this.f68383f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.v.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f68383f.get(Long.valueOf(j2)).toString());
                d.a.v.a.c.b remove = this.f68383f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f68364c = 8006;
                remove.f68365d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                d.a.v.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f68383f.size() <= 0 || !this.f68383f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.v.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f68383f.get(Long.valueOf(j2)).toString());
                d.a.v.a.c.b remove = this.f68383f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f68364c = 8004;
                remove.f68365d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                d.a.v.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.f68343a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
        }
    }

    public final synchronized void a0(d.a.v.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            synchronized (this) {
                d.a.v.a.b.d.b bVar2 = null;
                try {
                    Long valueOf = Long.valueOf(!bVar.f68366e ? bVar.n : (bVar.f68369h * 10000) + bVar.f68370i);
                    d.a.v.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        bVar2 = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        bVar2 = this.j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        d.a.v.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f68370i + ", serviceId :" + bVar.f68369h + ", error :" + bVar.f68364c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f68365d + ", invoke keys :" + this.j.keySet().toString());
                        bVar2.onResponse(bVar.f68364c, bVar.f68365d, bVar.f68369h, bVar.f68370i, bVar.n, bVar.f68367f);
                        if (bVar.f68364c == 1011) {
                            d.a.v.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f68364c + ", and will send lcm login msg .");
                            f0(this.f68386i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    d.a.v.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d.a.v.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.f68386i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && d.a.v.a.c.a.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                d.a.v.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f68380c);
                String[] split = d.a.v.a.h.f.h(this.q, this.f68380c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f68380c >= d.a.v.a.h.f.i(this.q)) {
                    this.f68380c = 0;
                    d.a.v.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new d.a.v.a.c.g(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof d.a.v.a.c.g))) {
                    this.r = new d.a.v.a.c.g(this.q, str);
                }
                this.f68380c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    d.a.v.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                    this.x = str2;
                    this.y = str3;
                    this.z = str;
                    L(str2, str3, str);
                } else {
                    this.x = "";
                    this.y = "";
                    c0();
                }
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f68380c = 0;
            this.p.set(0);
            d.a.v.a.c.a.i();
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.f68343a == -1) {
                    long K = K(this.p.get());
                    this.u.removeCallbacks(this.n);
                    this.u.removeCallbacks(z ? this.B : this.C);
                    this.u.postDelayed(z ? this.C : this.B, K);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Schedule retry ");
                    sb.append(z ? "login" : "connect");
                    sb.append(" -- retry times: ");
                    sb.append(this.p.get());
                    sb.append(" time delay: ");
                    sb.append(K);
                    String sb2 = sb.toString();
                    d.a.v.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    d.a.v.a.h.e.d("SocketTransceiver", sb2);
                    return;
                }
                d.a.v.a.a.c c2 = d.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.f68343a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                d.a.v.a.a.c c3 = d.a.v.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                d.a.v.a.h.e.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(d.a.v.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    d.a.v.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.f68382e) {
                    boolean z = false;
                    Iterator<d.a.v.a.c.b> it = this.f68382e.iterator();
                    while (it.hasNext()) {
                        d.a.v.a.c.b next = it.next();
                        d.a.v.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.f68343a == -1) {
                            this.f68382e.addFirst(bVar);
                            this.f68382e.notifyAll();
                        }
                        d.a.v.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.f68343a);
                    } else if (D.f68343a == -1) {
                        if (I()) {
                            if (this.f68382e.size() <= 0 || !z) {
                                this.f68382e.addFirst(this.f68386i.b(this.q, 1L));
                                this.f68382e.notifyAll();
                            }
                            if (!bVar.k) {
                                this.f68382e.add(bVar);
                                this.f68382e.notifyAll();
                            }
                        } else {
                            if (bVar.k) {
                                d.a.v.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f68382e.add(bVar);
                        }
                    } else {
                        this.f68382e.add(bVar);
                        this.f68382e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, d.a.v.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), bVar}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.k.put(valueOf, bVar);
            }
            d.a.v.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && d.a.v.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (d.a.v.a.h.f.m(this.q)) {
                    d.a.v.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.f68381d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    d.a.v.a.c.a.h(this.q, null, false);
                    N(str, str2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f68405e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f68406f;

        public h(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68406f = fVar;
            this.f68405e = 60000L;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f68405e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f68406f.u.removeCallbacks(this.f68406f.n);
                if (d.a.v.a.h.f.m(this.f68406f.q)) {
                    this.f68406f.u.postDelayed(this.f68406f.n, this.f68405e);
                    f fVar = this.f68406f;
                    fVar.f0(fVar.f68386i.b(this.f68406f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this(fVar);
        }
    }
}
