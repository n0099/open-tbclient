package d.a.w.a.c;

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
import d.a.w.a.c.a;
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
/* loaded from: classes9.dex */
public final class f extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d.a.w.a.b.b D;
    public static volatile f E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f70807a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f70808b;

    /* renamed from: c  reason: collision with root package name */
    public int f70809c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70810d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<d.a.w.a.c.b> f70811e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, d.a.w.a.c.b> f70812f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f70813g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f70814h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.w.a.e.b f70815i;
    public Map<Long, d.a.w.a.b.d.b> j;
    public Map<Long, d.a.w.a.b.d.b> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public d.a.w.a.c.d r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* loaded from: classes9.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f70816a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f70817b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f70818c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f70819d;

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
            this.f70819d = fVar;
            this.f70816a = str;
            this.f70817b = str2;
            this.f70818c = str3;
        }

        @Override // d.a.w.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                d.a.w.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.f70816a;
                }
                f fVar = this.f70819d;
                fVar.w = str2;
                d.a.w.a.a.c d2 = d.a.w.a.a.a.h(fVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f70817b).d("ip", str2).d("domain", this.f70816a).d(ProbeTB.PROTOCOL, this.f70818c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    d.a.w.a.a.a.h(this.f70819d.q).g(601110).b("connect_state", 2);
                    d.a.w.a.g.a a2 = d.a.w.a.g.a.a(this.f70819d.q);
                    f fVar2 = this.f70819d;
                    a2.b(new e(fVar2, str2, this.f70817b, Integer.valueOf(fVar2.f70808b.incrementAndGet())));
                    return;
                }
                d.a.w.a.a.a.h(this.f70819d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f70819d.p.get()).e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f70820e;

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
            this.f70820e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70820e.M();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f70821e;

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
            this.f70821e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f70821e;
                fVar.f0(fVar.f70815i.b(this.f70821e.q, 1L));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f70822a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1998641420, "Ld/a/w/a/c/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1998641420, "Ld/a/w/a/c/f$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f70822a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70822a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f70822a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f70822a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f70823e;

        /* renamed from: f  reason: collision with root package name */
        public String f70824f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f70825g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f70826h;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f70827e;

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
                this.f70827e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.w.a.h.d.c(this.f70827e.f70826h.q);
                    d.a.w.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f70827e.f70826h.A));
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
            this.f70826h = fVar;
            this.f70824f = str;
            this.f70823e = str2;
            this.f70825g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e2) {
                        d.a.w.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
                    }
                    if (!this.f70826h.I()) {
                        if (this.f70826h.m != null && this.f70826h.m.isAlive()) {
                            this.f70826h.m.interrupt();
                            d.a.w.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f70826h.l != null && this.f70826h.l.isAlive()) {
                            this.f70826h.l.interrupt();
                            d.a.w.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        RunnableC1958f runnableC1958f = new RunnableC1958f(this.f70826h, this.f70825g, this.f70824f);
                        this.f70826h.u.a(this.f70824f);
                        this.f70826h.u.postDelayed(runnableC1958f, 15000L);
                        try {
                            d.a.w.a.a.a.h(this.f70826h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            d.a.w.a.c.e e3 = this.f70826h.r.e(this.f70824f, Integer.valueOf(this.f70823e).intValue());
                            if (this.f70826h.I()) {
                                d.a.w.a.a.a.h(this.f70826h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f70826h.p.get()).e();
                                d.a.w.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f70826h.J(e3);
                                return;
                            } else if (e3.f70803b.booleanValue()) {
                                synchronized (this.f70826h.f70807a) {
                                    d.a.w.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f70826h.u.removeCallbacks(runnableC1958f);
                                    runnableC1958f.a();
                                    if (!this.f70826h.I()) {
                                        if (this.f70826h.f70807a.get(this.f70825g) == null) {
                                            d.a.w.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f70826h.r.c(e3);
                                        }
                                        d.a.w.a.a.a.h(this.f70826h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        d.a.w.a.h.f.B(this.f70826h.q, this.f70826h.p.get() == 0 ? 1 : 2);
                                        d.a.w.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        d.a.w.a.c.a.g(this.f70826h.q, this.f70824f);
                                        d.a.w.a.a.a.h(this.f70826h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f70826h.f0(this.f70826h.f70815i.b(this.f70826h.q, 1L));
                                        this.f70826h.v = SystemClock.currentThreadTimeMillis();
                                        if (d.a.w.a.h.c.a(this.f70826h.q) != 0) {
                                            d.a.w.a.g.a.a(this.f70826h.q).b(new a(this));
                                        }
                                        d.a.w.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f70826h.v);
                                        f.D.f70772a = -2;
                                        this.f70826h.o = false;
                                        this.f70826h.l = new j(this.f70826h, this.f70824f);
                                        this.f70826h.l.start();
                                        this.f70826h.m = new i(this.f70826h, this.f70824f);
                                        this.f70826h.m.start();
                                        return;
                                    }
                                    d.a.w.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f70826h.J(e3);
                                    return;
                                }
                            } else {
                                d.a.w.a.a.a.h(this.f70826h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f70824f).d("con_err_code", "P14").b("retry_cout", this.f70826h.p.get()).e();
                                this.f70826h.u.removeCallbacks(runnableC1958f);
                                this.f70826h.i0("connect env error:", this.f70824f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            d.a.w.a.h.e.c("SocketTransceiver", str, th);
                            this.f70826h.u.removeCallbacks(runnableC1958f);
                            runnableC1958f.a();
                            synchronized (this.f70826h.f70807a) {
                                if (this.f70826h.f70807a.get(this.f70825g) != null) {
                                    this.f70826h.f70807a.remove(this.f70825g);
                                    return;
                                }
                                this.f70826h.O("ConnectTask exception:" + str, this.f70824f);
                                return;
                            }
                        }
                    }
                    d.a.w.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    d.a.w.a.a.a.h(this.f70826h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f70826h.p.get()).e();
                }
            }
        }
    }

    /* renamed from: d.a.w.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1958f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f70828e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70829f;

        /* renamed from: g  reason: collision with root package name */
        public String f70830g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f70831h;

        public RunnableC1958f(f fVar, Integer num, String str) {
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
            this.f70831h = fVar;
            this.f70829f = false;
            this.f70828e = num;
            this.f70830g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f70829f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f70831h.f70807a) {
                    if (!this.f70829f && f.D.f70772a != 0) {
                        this.f70831h.f70807a.put(this.f70828e, Boolean.TRUE);
                        d.a.w.a.a.a.h(this.f70831h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f70831h.O("time out:", this.f70830g);
                        return;
                    }
                    d.a.w.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f70831h.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70832a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f70833b;

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
            this.f70833b = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f70832a = str;
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
                synchronized (this.f70833b.f70814h) {
                    this.f70833b.Y(j, this.f70832a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f70836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f70837f;

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
            this.f70837f = fVar;
            this.f70836e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.a.w.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f70837f.o) {
                    try {
                        try {
                            d.a.w.a.c.b c2 = this.f70837f.f70815i.c(this.f70837f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f70837f.u.removeCallbacks(this.f70837f.s);
                                c2.m = false;
                                d.a.w.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.k) {
                                    if (c2.f70799i == 1 && c2.f70798h == 4) {
                                        Context context = this.f70837f.q;
                                        d.a.w.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f70799i == 50 && c2.f70798h == 2) {
                                        Context context2 = this.f70837f.q;
                                        d.a.w.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f70837f.f70814h) {
                                        d.a.w.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (d.a.w.a.c.b) this.f70837f.f70812f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f70837f.W(c2, bVar, this.f70836e);
                                }
                                synchronized (this.f70837f.f70814h) {
                                    if (this.f70837f.f70812f.size() != 0) {
                                        d.a.w.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f70837f.s.b(c2.n);
                                        this.f70837f.s.a(this.f70836e);
                                        this.f70837f.u.a(this.f70836e);
                                        this.f70837f.u.postDelayed(this.f70837f.s, c2.f70792b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f70837f.o) {
                                return;
                            }
                            d.a.w.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f70837f.f70810d = false;
                            f fVar = this.f70837f;
                            fVar.O("ReadThread exception: " + e2, this.f70836e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f70837f.o) {
                            return;
                        }
                        d.a.w.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f70837f.f70810d = false;
                        f fVar2 = this.f70837f;
                        fVar2.O("onStartCommand:" + e3, this.f70836e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f70838e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f70839f;

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
            this.f70839f = fVar;
            this.f70838e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f70839f.o) {
                    try {
                        d.a.w.a.c.b bVar = null;
                        try {
                            synchronized (this.f70839f.f70811e) {
                                if (this.f70839f.f70811e.size() == 0) {
                                    this.f70839f.f70811e.wait();
                                } else {
                                    bVar = (d.a.w.a.c.b) this.f70839f.f70811e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            d.a.w.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            f fVar = this.f70839f;
                            fVar.O("SendThread wait exception: " + e2, this.f70838e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f70839f.o) {
                                    this.f70839f.X(bVar.n, this.f70838e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.j = f.D.f70772a;
                                if (bVar.o) {
                                    synchronized (this.f70839f.f70814h) {
                                        if (this.f70839f.f70812f.isEmpty()) {
                                            this.f70839f.u.removeCallbacks(this.f70839f.s);
                                            this.f70839f.s.b(bVar.n);
                                            this.f70839f.s.a(this.f70838e);
                                            this.f70839f.u.a(this.f70838e);
                                            this.f70839f.u.postDelayed(this.f70839f.s, 15000L);
                                        }
                                    }
                                }
                                d.a.w.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f70799i == 1 && bVar.f70798h == 4) {
                                    Context context = this.f70839f.q;
                                    d.a.w.a.h.b.a(context, 1L, "send", bVar.n + "");
                                }
                                if (bVar.f70799i == 50 && bVar.f70798h == 2) {
                                    Context context2 = this.f70839f.q;
                                    d.a.w.a.h.b.a(context2, 50L, "send", bVar.n + "");
                                }
                                synchronized (this.f70839f.f70813g) {
                                    this.f70839f.r.f(bVar);
                                }
                                if (!bVar.k && bVar.o) {
                                    synchronized (this.f70839f.f70814h) {
                                        this.f70839f.f70812f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                d.a.w.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f70839f.T(bVar.n, e3.toString(), this.f70838e);
                                f fVar2 = this.f70839f;
                                fVar2.O("SendThread sendMessage Exception:" + e3, this.f70838e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        d.a.w.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        f fVar3 = this.f70839f;
                        fVar3.O("SendThread Exception:" + e4, this.f70838e);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f70840e;

        /* renamed from: f  reason: collision with root package name */
        public String f70841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f70842g;

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
            this.f70842g = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f70841f = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f70840e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f70842g.Y(this.f70840e, this.f70841f);
                this.f70842g.O("read and write thread timeout:", this.f70841f);
            }
        }

        public /* synthetic */ k(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1763281396, "Ld/a/w/a/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1763281396, "Ld/a/w/a/c/f;");
                return;
            }
        }
        D = new d.a.w.a.b.b();
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
        this.f70807a = new TreeMap();
        this.f70808b = new AtomicInteger(0);
        this.f70809c = 0;
        this.f70810d = false;
        this.f70811e = new LinkedList<>();
        this.f70812f = new LinkedHashMap();
        this.f70813g = new Object();
        this.f70814h = new Object();
        this.f70815i = new d.a.w.a.e.b();
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

    public synchronized void H(BLCPRequest bLCPRequest, d.a.w.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (d.a.w.a.h.f.m(this.q)) {
                    d.a.w.a.c.b bVar2 = new d.a.w.a.c.b();
                    bVar2.f70798h = bLCPRequest.f6395a;
                    bVar2.f70799i = bLCPRequest.f6396b;
                    bVar2.f70791a = bLCPRequest.f6397c;
                    if (bLCPRequest.f6398d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f6398d;
                    }
                    int i2 = d.f70822a[bLCPRequest.f6399e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f70792b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f70792b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f70792b = 15000L;
                    } else {
                        bVar2.f70792b = 50000L;
                    }
                    if (bLCPRequest instanceof d.a.w.a.b.d.a) {
                        long j2 = (bVar2.f70798h * 10000) + bVar2.f70799i;
                        bVar2.n = j2;
                        g0(bVar2.f70798h, bVar2.f70799i, j2, true, bVar);
                    } else {
                        g0(bVar2.f70798h, bVar2.f70799i, bVar2.n, false, bVar);
                        this.f70815i.a(bVar2, true);
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
            d.a.w.a.c.d dVar = this.r;
            return (dVar == null || dVar.a() == null || this.r.a().f70804c == null || !this.r.a().f70804c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(d.a.w.a.c.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) && eVar != null && eVar.f70802a.booleanValue()) {
            try {
                if (eVar.f70804c != null) {
                    if (eVar.f70804c.hashCode() == this.r.a().f70804c.hashCode()) {
                        d.a.w.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    eVar.f70804c.close();
                    eVar.f70804c = null;
                    if (eVar.f70805d != null) {
                        eVar.f70805d.close();
                        eVar.f70805d = null;
                    }
                    if (eVar.f70806e != null) {
                        eVar.f70806e.close();
                        eVar.f70806e = null;
                    }
                    d.a.w.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                d.a.w.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
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
                d.a.w.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                d.a.w.a.c.a.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    d.a.w.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                if (D.f70772a != 0 && D.f70772a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                d.a.w.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.f70772a);
                d.a.w.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.f70772a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (d.a.w.a.h.f.m(this.q)) {
                    d.a.w.a.h.e.d("SocketTransceiver", "destroy");
                    D.f70772a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f70811e) {
                            this.f70811e.notifyAll();
                            d.a.w.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            d.a.w.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            d.a.w.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
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
                d.a.w.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f70810d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + d.a.w.a.h.f.m(this.q));
                d.a.w.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                d.a.w.a.a.c c2 = d.a.w.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (d.a.w.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f70810d) {
                        d.a.w.a.a.c c3 = d.a.w.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f70810d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        d.a.w.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
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
                d.a.w.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.f70811e) {
                    while (this.f70811e.size() > 0) {
                        Q(this.f70811e.removeFirst(), str);
                    }
                    d.a.w.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f70814h) {
                    d.a.w.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f70812f.keySet()) {
                        Q(this.f70812f.get(l), str);
                    }
                    this.f70812f.clear();
                    d.a.w.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                d.a.w.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(d.a.w.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f70798h == 1) {
            return;
        }
        d.a.w.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f70798h + ", methodId :" + bVar.f70799i);
        W(new d.a.w.a.c.b(), bVar, str);
    }

    public d.a.w.a.b.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (d.a.w.a.b.b) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f70812f.size() <= 0 || !this.f70812f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.w.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f70812f.get(Long.valueOf(j2)).toString());
                d.a.w.a.c.b remove = this.f70812f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f70793c = 8005;
                remove.f70794d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                d.a.w.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(d.a.w.a.c.b bVar, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bVar, str) == null) {
            if (bVar.f70793c == 0) {
                long j2 = bVar.f70797g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f70799i;
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
                    D.f70772a = bVar.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f70793c + " errmsg:" + bVar.f70794d;
            if (!String.valueOf(bVar.f70793c).startsWith(EventType.GiftEventID.SEND_GIFT_TO_USER_SUCCESS) && (i2 = bVar.f70793c) != 1011 && i2 != 2003) {
                if (i2 != 1012) {
                    if (i2 == 1013) {
                        V(60000L, false, str);
                        return;
                    }
                    D.f70772a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
                d.a.w.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                d.a.w.a.h.e.a("SocketTransceiver", "login error :" + bVar.f70793c);
                return;
            }
            d.a.w.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f70793c);
            i0("errorCode:" + String.valueOf(bVar.f70793c), str);
            d.a.w.a.h.f.z(this.q, "");
            d.a.w.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            d.a.w.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            d.a.w.a.b.c.f().m();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                d.a.w.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.f70772a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    d.a.w.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                d.a.w.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(d.a.w.a.c.b bVar, d.a.w.a.c.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bVar, bVar2, str) == null) {
            long j2 = bVar.f70798h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f70798h == 1) {
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
                if (this.f70812f.size() <= 0 || !this.f70812f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.w.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f70812f.get(Long.valueOf(j2)).toString());
                d.a.w.a.c.b remove = this.f70812f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f70793c = 8006;
                remove.f70794d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                d.a.w.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f70812f.size() <= 0 || !this.f70812f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.w.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f70812f.get(Long.valueOf(j2)).toString());
                d.a.w.a.c.b remove = this.f70812f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f70793c = 8004;
                remove.f70794d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                d.a.w.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.f70772a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
        }
    }

    public final synchronized void a0(d.a.w.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            synchronized (this) {
                d.a.w.a.b.d.b bVar2 = null;
                try {
                    Long valueOf = Long.valueOf(!bVar.f70795e ? bVar.n : (bVar.f70798h * 10000) + bVar.f70799i);
                    d.a.w.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        bVar2 = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        bVar2 = this.j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        d.a.w.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f70799i + ", serviceId :" + bVar.f70798h + ", error :" + bVar.f70793c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f70794d + ", invoke keys :" + this.j.keySet().toString());
                        bVar2.onResponse(bVar.f70793c, bVar.f70794d, bVar.f70798h, bVar.f70799i, bVar.n, bVar.f70796f);
                        if (bVar.f70793c == 1011) {
                            d.a.w.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f70793c + ", and will send lcm login msg .");
                            f0(this.f70815i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    d.a.w.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d.a.w.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.f70815i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && d.a.w.a.c.a.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                d.a.w.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f70809c);
                String[] split = d.a.w.a.h.f.h(this.q, this.f70809c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f70809c >= d.a.w.a.h.f.i(this.q)) {
                    this.f70809c = 0;
                    d.a.w.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new d.a.w.a.c.g(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof d.a.w.a.c.g))) {
                    this.r = new d.a.w.a.c.g(this.q, str);
                }
                this.f70809c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    d.a.w.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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
            this.f70809c = 0;
            this.p.set(0);
            d.a.w.a.c.a.i();
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.f70772a == -1) {
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
                    d.a.w.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    d.a.w.a.h.e.d("SocketTransceiver", sb2);
                    return;
                }
                d.a.w.a.a.c c2 = d.a.w.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.f70772a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                d.a.w.a.a.c c3 = d.a.w.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                d.a.w.a.h.e.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(d.a.w.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    d.a.w.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.f70811e) {
                    boolean z = false;
                    Iterator<d.a.w.a.c.b> it = this.f70811e.iterator();
                    while (it.hasNext()) {
                        d.a.w.a.c.b next = it.next();
                        d.a.w.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.f70772a == -1) {
                            this.f70811e.addFirst(bVar);
                            this.f70811e.notifyAll();
                        }
                        d.a.w.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.f70772a);
                    } else if (D.f70772a == -1) {
                        if (I()) {
                            if (this.f70811e.size() <= 0 || !z) {
                                this.f70811e.addFirst(this.f70815i.b(this.q, 1L));
                                this.f70811e.notifyAll();
                            }
                            if (!bVar.k) {
                                this.f70811e.add(bVar);
                                this.f70811e.notifyAll();
                            }
                        } else {
                            if (bVar.k) {
                                d.a.w.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f70811e.add(bVar);
                        }
                    } else {
                        this.f70811e.add(bVar);
                        this.f70811e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, d.a.w.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), bVar}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.k.put(valueOf, bVar);
            }
            d.a.w.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && d.a.w.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (d.a.w.a.h.f.m(this.q)) {
                    d.a.w.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.f70810d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    d.a.w.a.c.a.h(this.q, null, false);
                    N(str, str2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f70834e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f70835f;

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
            this.f70835f = fVar;
            this.f70834e = 60000L;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f70834e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f70835f.u.removeCallbacks(this.f70835f.n);
                if (d.a.w.a.h.f.m(this.f70835f.q)) {
                    this.f70835f.u.postDelayed(this.f70835f.n, this.f70834e);
                    f fVar = this.f70835f;
                    fVar.f0(fVar.f70815i.b(this.f70835f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this(fVar);
        }
    }
}
