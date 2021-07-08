package d.a.u.a.c;

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
import d.a.u.a.c.a;
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
    public static volatile d.a.u.a.b.b D;
    public static volatile f E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f67700a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f67701b;

    /* renamed from: c  reason: collision with root package name */
    public int f67702c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67703d;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<d.a.u.a.c.b> f67704e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, d.a.u.a.c.b> f67705f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f67706g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f67707h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.u.a.e.b f67708i;
    public Map<Long, d.a.u.a.b.d.b> j;
    public Map<Long, d.a.u.a.b.d.b> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public d.a.u.a.c.d r;
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
        public final /* synthetic */ String f67709a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f67710b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f67711c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f67712d;

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
            this.f67712d = fVar;
            this.f67709a = str;
            this.f67710b = str2;
            this.f67711c = str3;
        }

        @Override // d.a.u.a.c.a.d
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                d.a.u.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.f67709a;
                }
                f fVar = this.f67712d;
                fVar.w = str2;
                d.a.u.a.a.c d2 = d.a.u.a.a.a.h(fVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f67710b).d("ip", str2).d("domain", this.f67709a).d(ProbeTB.PROTOCOL, this.f67711c);
                d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
                if (i2 == 0) {
                    d.a.u.a.a.a.h(this.f67712d.q).g(601110).b("connect_state", 2);
                    d.a.u.a.g.a a2 = d.a.u.a.g.a.a(this.f67712d.q);
                    f fVar2 = this.f67712d;
                    a2.b(new e(fVar2, str2, this.f67710b, Integer.valueOf(fVar2.f67701b.incrementAndGet())));
                    return;
                }
                d.a.u.a.a.a.h(this.f67712d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f67712d.p.get()).e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67713e;

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
            this.f67713e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67713e.M();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67714e;

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
            this.f67714e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f67714e;
                fVar.f0(fVar.f67708i.b(this.f67714e.q, 1L));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67715a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1903298866, "Ld/a/u/a/c/f$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1903298866, "Ld/a/u/a/c/f$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f67715a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67715a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67715a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67715a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f67716e;

        /* renamed from: f  reason: collision with root package name */
        public String f67717f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f67718g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f67719h;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f67720e;

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
                this.f67720e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.u.a.h.d.c(this.f67720e.f67719h.q);
                    d.a.u.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - this.f67720e.f67719h.A));
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
            this.f67719h = fVar;
            this.f67717f = str;
            this.f67716e = str2;
            this.f67718g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e2) {
                        d.a.u.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
                    }
                    if (!this.f67719h.I()) {
                        if (this.f67719h.m != null && this.f67719h.m.isAlive()) {
                            this.f67719h.m.interrupt();
                            d.a.u.a.h.e.a("SocketTransceiver", "readThread interrupt");
                        }
                        if (this.f67719h.l != null && this.f67719h.l.isAlive()) {
                            this.f67719h.l.interrupt();
                            d.a.u.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                        }
                        RunnableC1921f runnableC1921f = new RunnableC1921f(this.f67719h, this.f67718g, this.f67717f);
                        this.f67719h.u.a(this.f67717f);
                        this.f67719h.u.postDelayed(runnableC1921f, 15000L);
                        try {
                            d.a.u.a.a.a.h(this.f67719h.q).g(601110).c("socket_begin", System.currentTimeMillis());
                            d.a.u.a.c.e e3 = this.f67719h.r.e(this.f67717f, Integer.valueOf(this.f67716e).intValue());
                            if (this.f67719h.I()) {
                                d.a.u.a.a.a.h(this.f67719h.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.f67719h.p.get()).e();
                                d.a.u.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                this.f67719h.J(e3);
                                return;
                            } else if (e3.f67696b.booleanValue()) {
                                synchronized (this.f67719h.f67700a) {
                                    d.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                    this.f67719h.u.removeCallbacks(runnableC1921f);
                                    runnableC1921f.a();
                                    if (!this.f67719h.I()) {
                                        if (this.f67719h.f67700a.get(this.f67718g) == null) {
                                            d.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                            this.f67719h.r.c(e3);
                                        }
                                        d.a.u.a.a.a.h(this.f67719h.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                        d.a.u.a.h.f.B(this.f67719h.q, this.f67719h.p.get() == 0 ? 1 : 2);
                                        d.a.u.a.h.e.d("SocketTransceiver", "create Socket ok");
                                        d.a.u.a.c.a.g(this.f67719h.q, this.f67717f);
                                        d.a.u.a.a.a.h(this.f67719h.q).g(601110).c("login_begin", System.currentTimeMillis());
                                        this.f67719h.f0(this.f67719h.f67708i.b(this.f67719h.q, 1L));
                                        this.f67719h.v = SystemClock.currentThreadTimeMillis();
                                        if (d.a.u.a.h.c.a(this.f67719h.q) != 0) {
                                            d.a.u.a.g.a.a(this.f67719h.q).b(new a(this));
                                        }
                                        d.a.u.a.h.e.a("SocketTransceiver", "connectImpl time:" + this.f67719h.v);
                                        f.D.f67665a = -2;
                                        this.f67719h.o = false;
                                        this.f67719h.l = new j(this.f67719h, this.f67717f);
                                        this.f67719h.l.start();
                                        this.f67719h.m = new i(this.f67719h, this.f67717f);
                                        this.f67719h.m.start();
                                        return;
                                    }
                                    d.a.u.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.f67719h.J(e3);
                                    return;
                                }
                            } else {
                                d.a.u.a.a.a.h(this.f67719h.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f67717f).d("con_err_code", "P14").b("retry_cout", this.f67719h.p.get()).e();
                                this.f67719h.u.removeCallbacks(runnableC1921f);
                                this.f67719h.i0("connect env error:", this.f67717f);
                                return;
                            }
                        } catch (Throwable th) {
                            String str = "Throwable : " + th;
                            d.a.u.a.h.e.c("SocketTransceiver", str, th);
                            this.f67719h.u.removeCallbacks(runnableC1921f);
                            runnableC1921f.a();
                            synchronized (this.f67719h.f67700a) {
                                if (this.f67719h.f67700a.get(this.f67718g) != null) {
                                    this.f67719h.f67700a.remove(this.f67718g);
                                    return;
                                }
                                this.f67719h.O("ConnectTask exception:" + str, this.f67717f);
                                return;
                            }
                        }
                    }
                    d.a.u.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                    d.a.u.a.a.a.h(this.f67719h.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.f67719h.p.get()).e();
                }
            }
        }
    }

    /* renamed from: d.a.u.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1921f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Integer f67721e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67722f;

        /* renamed from: g  reason: collision with root package name */
        public String f67723g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f67724h;

        public RunnableC1921f(f fVar, Integer num, String str) {
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
            this.f67724h = fVar;
            this.f67722f = false;
            this.f67721e = num;
            this.f67723g = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67722f = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f67724h.f67700a) {
                    if (!this.f67722f && f.D.f67665a != 0) {
                        this.f67724h.f67700a.put(this.f67721e, Boolean.TRUE);
                        d.a.u.a.a.a.h(this.f67724h.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.f67724h.O("time out:", this.f67723g);
                        return;
                    }
                    d.a.u.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.f67724h.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f67726b;

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
            this.f67726b = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f67725a = str;
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
                synchronized (this.f67726b.f67707h) {
                    this.f67726b.Y(j, this.f67725a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f67729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f67730f;

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
            this.f67730f = fVar;
            this.f67729e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.a.u.a.c.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f67730f.o) {
                    try {
                        try {
                            d.a.u.a.c.b c2 = this.f67730f.f67708i.c(this.f67730f.r.b());
                            if (c2 != null && c2.n > 0) {
                                this.f67730f.u.removeCallbacks(this.f67730f.s);
                                c2.m = false;
                                d.a.u.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                                if (!c2.k) {
                                    if (c2.f67692i == 1 && c2.f67691h == 4) {
                                        Context context = this.f67730f.q;
                                        d.a.u.a.h.b.a(context, 1L, "read", c2.n + "");
                                    }
                                    if (c2.f67692i == 50 && c2.f67691h == 2) {
                                        Context context2 = this.f67730f.q;
                                        d.a.u.a.h.b.a(context2, 50L, "read", c2.n + "");
                                    }
                                    synchronized (this.f67730f.f67707h) {
                                        d.a.u.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        bVar = (d.a.u.a.c.b) this.f67730f.f67705f.remove(Long.valueOf(c2.n));
                                    }
                                    this.f67730f.W(c2, bVar, this.f67729e);
                                }
                                synchronized (this.f67730f.f67707h) {
                                    if (this.f67730f.f67705f.size() != 0) {
                                        d.a.u.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.f67730f.s.b(c2.n);
                                        this.f67730f.s.a(this.f67729e);
                                        this.f67730f.u.a(this.f67729e);
                                        this.f67730f.u.postDelayed(this.f67730f.s, c2.f67685b);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            if (this.f67730f.o) {
                                return;
                            }
                            d.a.u.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                            this.f67730f.f67703d = false;
                            f fVar = this.f67730f;
                            fVar.O("ReadThread exception: " + e2, this.f67729e);
                            return;
                        }
                    } catch (Exception e3) {
                        if (this.f67730f.o) {
                            return;
                        }
                        d.a.u.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                        this.f67730f.f67703d = false;
                        f fVar2 = this.f67730f;
                        fVar2.O("onStartCommand:" + e3, this.f67729e);
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
        public String f67731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f67732f;

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
            this.f67732f = fVar;
            this.f67731e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.f67732f.o) {
                    try {
                        d.a.u.a.c.b bVar = null;
                        try {
                            synchronized (this.f67732f.f67704e) {
                                if (this.f67732f.f67704e.size() == 0) {
                                    this.f67732f.f67704e.wait();
                                } else {
                                    bVar = (d.a.u.a.c.b) this.f67732f.f67704e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e2) {
                            d.a.u.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                            f fVar = this.f67732f;
                            fVar.O("SendThread wait exception: " + e2, this.f67731e);
                        }
                        if (bVar != null) {
                            try {
                                if (this.f67732f.o) {
                                    this.f67732f.X(bVar.n, this.f67731e);
                                    return;
                                }
                                bVar.m = true;
                                bVar.j = f.D.f67665a;
                                if (bVar.o) {
                                    synchronized (this.f67732f.f67707h) {
                                        if (this.f67732f.f67705f.isEmpty()) {
                                            this.f67732f.u.removeCallbacks(this.f67732f.s);
                                            this.f67732f.s.b(bVar.n);
                                            this.f67732f.s.a(this.f67731e);
                                            this.f67732f.u.a(this.f67731e);
                                            this.f67732f.u.postDelayed(this.f67732f.s, 15000L);
                                        }
                                    }
                                }
                                d.a.u.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                                if (bVar.f67692i == 1 && bVar.f67691h == 4) {
                                    Context context = this.f67732f.q;
                                    d.a.u.a.h.b.a(context, 1L, "send", bVar.n + "");
                                }
                                if (bVar.f67692i == 50 && bVar.f67691h == 2) {
                                    Context context2 = this.f67732f.q;
                                    d.a.u.a.h.b.a(context2, 50L, "send", bVar.n + "");
                                }
                                synchronized (this.f67732f.f67706g) {
                                    this.f67732f.r.f(bVar);
                                }
                                if (!bVar.k && bVar.o) {
                                    synchronized (this.f67732f.f67707h) {
                                        this.f67732f.f67705f.put(Long.valueOf(bVar.n), bVar);
                                    }
                                }
                            } catch (Exception e3) {
                                d.a.u.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                                this.f67732f.T(bVar.n, e3.toString(), this.f67731e);
                                f fVar2 = this.f67732f;
                                fVar2.O("SendThread sendMessage Exception:" + e3, this.f67731e);
                                return;
                            }
                        }
                    } catch (Exception e4) {
                        d.a.u.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                        f fVar3 = this.f67732f;
                        fVar3.O("SendThread Exception:" + e4, this.f67731e);
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
        public long f67733e;

        /* renamed from: f  reason: collision with root package name */
        public String f67734f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f67735g;

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
            this.f67735g = fVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f67734f = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f67733e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f67735g.Y(this.f67733e, this.f67734f);
                this.f67735g.O("read and write thread timeout:", this.f67734f);
            }
        }

        public /* synthetic */ k(f fVar, a aVar) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-953934770, "Ld/a/u/a/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-953934770, "Ld/a/u/a/c/f;");
                return;
            }
        }
        D = new d.a.u.a.b.b();
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
        this.f67700a = new TreeMap();
        this.f67701b = new AtomicInteger(0);
        this.f67702c = 0;
        this.f67703d = false;
        this.f67704e = new LinkedList<>();
        this.f67705f = new LinkedHashMap();
        this.f67706g = new Object();
        this.f67707h = new Object();
        this.f67708i = new d.a.u.a.e.b();
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

    public synchronized void H(BLCPRequest bLCPRequest, d.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, bVar) == null) {
            synchronized (this) {
                if (d.a.u.a.h.f.m(this.q)) {
                    d.a.u.a.c.b bVar2 = new d.a.u.a.c.b();
                    bVar2.f67691h = bLCPRequest.f6412a;
                    bVar2.f67692i = bLCPRequest.f6413b;
                    bVar2.f67684a = bLCPRequest.f6414c;
                    if (bLCPRequest.f6415d < 0) {
                        bVar2.n = System.currentTimeMillis();
                    } else {
                        bVar2.n = bLCPRequest.f6415d;
                    }
                    int i2 = d.f67715a[bLCPRequest.f6416e.ordinal()];
                    if (i2 == 1) {
                        bVar2.f67685b = 20000L;
                    } else if (i2 == 2) {
                        bVar2.f67685b = 30000L;
                    } else if (i2 != 3) {
                        bVar2.f67685b = 15000L;
                    } else {
                        bVar2.f67685b = 50000L;
                    }
                    if (bLCPRequest instanceof d.a.u.a.b.d.a) {
                        long j2 = (bVar2.f67691h * 10000) + bVar2.f67692i;
                        bVar2.n = j2;
                        g0(bVar2.f67691h, bVar2.f67692i, j2, true, bVar);
                    } else {
                        g0(bVar2.f67691h, bVar2.f67692i, bVar2.n, false, bVar);
                        this.f67708i.a(bVar2, true);
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
            d.a.u.a.c.d dVar = this.r;
            return (dVar == null || dVar.a() == null || this.r.a().f67697c == null || !this.r.a().f67697c.isConnected()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void J(d.a.u.a.c.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) && eVar != null && eVar.f67695a.booleanValue()) {
            try {
                if (eVar.f67697c != null) {
                    if (eVar.f67697c.hashCode() == this.r.a().f67697c.hashCode()) {
                        d.a.u.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    eVar.f67697c.close();
                    eVar.f67697c = null;
                    if (eVar.f67698d != null) {
                        eVar.f67698d.close();
                        eVar.f67698d = null;
                    }
                    if (eVar.f67699e != null) {
                        eVar.f67699e.close();
                        eVar.f67699e = null;
                    }
                    d.a.u.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                d.a.u.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
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
                d.a.u.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                d.a.u.a.c.a.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    d.a.u.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                if (D.f67665a != 0 && D.f67665a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                d.a.u.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.f67665a);
                d.a.u.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.f67665a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (d.a.u.a.h.f.m(this.q)) {
                    d.a.u.a.h.e.d("SocketTransceiver", "destroy");
                    D.f67665a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    this.u.removeCallbacks(this.s);
                    this.o = true;
                    if (this.r != null) {
                        synchronized (this.f67704e) {
                            this.f67704e.notifyAll();
                            d.a.u.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                        }
                        try {
                            this.r.d();
                            d.a.u.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                        } catch (Exception e2) {
                            this.r.c(null);
                            d.a.u.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
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
                d.a.u.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f67703d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + d.a.u.a.h.f.m(this.q));
                d.a.u.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                d.a.u.a.a.c c2 = d.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (d.a.u.a.h.f.m(this.q)) {
                    P(str2);
                    if (this.f67703d) {
                        d.a.u.a.a.c c3 = d.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                        c3.d("P16", "disconnectedByLcp:" + this.f67703d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                        d0();
                        return;
                    }
                    N(str, str2);
                    if (!RequsetNetworkUtils.isConnected(this.q)) {
                        d.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
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
                d.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.f67704e) {
                    while (this.f67704e.size() > 0) {
                        Q(this.f67704e.removeFirst(), str);
                    }
                    d.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.f67707h) {
                    d.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f67705f.keySet()) {
                        Q(this.f67705f.get(l), str);
                    }
                    this.f67705f.clear();
                    d.a.u.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                d.a.u.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final void Q(d.a.u.a.c.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) || bVar == null || bVar.f67691h == 1) {
            return;
        }
        d.a.u.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f67691h + ", methodId :" + bVar.f67692i);
        W(new d.a.u.a.c.b(), bVar, str);
    }

    public d.a.u.a.b.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? D : (d.a.u.a.b.b) invokeV.objValue;
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f67705f.size() <= 0 || !this.f67705f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.u.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f67705f.get(Long.valueOf(j2)).toString());
                d.a.u.a.c.b remove = this.f67705f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f67686c = 8005;
                remove.f67687d = "socket exception :" + str;
                W(remove, remove, str2);
            } catch (Exception e2) {
                d.a.u.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void U(d.a.u.a.c.b bVar, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bVar, str) == null) {
            if (bVar.f67686c == 0) {
                long j2 = bVar.f67690g;
                long j3 = j2 > 0 ? j2 : 60000L;
                long j4 = bVar.f67692i;
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
                    D.f67665a = bVar.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                }
            }
            String str2 = " errorcode:" + bVar.f67686c + " errmsg:" + bVar.f67687d;
            if (!String.valueOf(bVar.f67686c).startsWith(EventType.GiftEventID.SEND_GIFT_TO_USER_SUCCESS) && (i2 = bVar.f67686c) != 1011 && i2 != 2003) {
                if (i2 != 1012) {
                    if (i2 == 1013) {
                        V(60000L, false, str);
                        return;
                    }
                    D.f67665a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
                d.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                d.a.u.a.h.e.a("SocketTransceiver", "login error :" + bVar.f67686c);
                return;
            }
            d.a.u.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f67686c);
            i0("errorCode:" + String.valueOf(bVar.f67686c), str);
            d.a.u.a.h.f.z(this.q, "");
            d.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            d.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            d.a.u.a.b.c.f().m();
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                d.a.u.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.f67665a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (z) {
                    this.u.a(str);
                    this.u.postDelayed(this.n, j2);
                    d.a.u.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                d.a.u.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void W(d.a.u.a.c.b bVar, d.a.u.a.c.b bVar2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bVar, bVar2, str) == null) {
            long j2 = bVar.f67691h;
            if (j2 == 1) {
                U(bVar, str);
            } else if (j2 != -1) {
                a0(bVar);
            } else if (bVar2 == null) {
            } else {
                if (bVar2.f67691h == 1) {
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
                if (this.f67705f.size() <= 0 || !this.f67705f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.u.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f67705f.get(Long.valueOf(j2)).toString());
                d.a.u.a.c.b remove = this.f67705f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f67686c = 8006;
                remove.f67687d = "socket stopped :";
                W(remove, remove, str);
            } catch (Exception e2) {
                d.a.u.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f67705f.size() <= 0 || !this.f67705f.containsKey(Long.valueOf(j2))) {
                    return;
                }
                d.a.u.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f67705f.get(Long.valueOf(j2)).toString());
                d.a.u.a.c.b remove = this.f67705f.remove(Long.valueOf(j2));
                if (remove == null) {
                    return;
                }
                remove.f67686c = 8004;
                remove.f67687d = "socket timeout";
                W(remove, remove, str);
            } catch (Exception e2) {
                d.a.u.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.f67665a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
        }
    }

    public final synchronized void a0(d.a.u.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            synchronized (this) {
                d.a.u.a.b.d.b bVar2 = null;
                try {
                    Long valueOf = Long.valueOf(!bVar.f67688e ? bVar.n : (bVar.f67691h * 10000) + bVar.f67692i);
                    d.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        bVar2 = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        bVar2 = this.j.remove(valueOf);
                    }
                    if (bVar2 != null) {
                        d.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f67692i + ", serviceId :" + bVar.f67691h + ", error :" + bVar.f67686c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f67687d + ", invoke keys :" + this.j.keySet().toString());
                        bVar2.onResponse(bVar.f67686c, bVar.f67687d, bVar.f67691h, bVar.f67692i, bVar.n, bVar.f67689f);
                        if (bVar.f67686c == 1011) {
                            d.a.u.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f67686c + ", and will send lcm login msg .");
                            f0(this.f67708i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    d.a.u.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d.a.u.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.f67708i.b(this.q, 3L));
        }
    }

    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && d.a.u.a.c.a.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                d.a.u.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f67702c);
                String[] split = d.a.u.a.h.f.h(this.q, this.f67702c).split(":");
                if (split.length < 3) {
                    return;
                }
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.f67702c >= d.a.u.a.h.f.i(this.q)) {
                    this.f67702c = 0;
                    d.a.u.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new d.a.u.a.c.g(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof d.a.u.a.c.g))) {
                    this.r = new d.a.u.a.c.g(this.q, str);
                }
                this.f67702c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    d.a.u.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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
            this.f67702c = 0;
            this.p.set(0);
            d.a.u.a.c.a.i();
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.f67665a == -1) {
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
                    d.a.u.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    d.a.u.a.h.e.d("SocketTransceiver", sb2);
                    return;
                }
                d.a.u.a.a.c c2 = d.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.f67665a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                d.a.u.a.a.c c3 = d.a.u.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                d.a.u.a.h.e.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void f0(d.a.u.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    d.a.u.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.f67704e) {
                    boolean z = false;
                    Iterator<d.a.u.a.c.b> it = this.f67704e.iterator();
                    while (it.hasNext()) {
                        d.a.u.a.c.b next = it.next();
                        d.a.u.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (bVar.l) {
                        if (!z && D.f67665a == -1) {
                            this.f67704e.addFirst(bVar);
                            this.f67704e.notifyAll();
                        }
                        d.a.u.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.f67665a);
                    } else if (D.f67665a == -1) {
                        if (I()) {
                            if (this.f67704e.size() <= 0 || !z) {
                                this.f67704e.addFirst(this.f67708i.b(this.q, 1L));
                                this.f67704e.notifyAll();
                            }
                            if (!bVar.k) {
                                this.f67704e.add(bVar);
                                this.f67704e.notifyAll();
                            }
                        } else {
                            if (bVar.k) {
                                d.a.u.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.f67704e.add(bVar);
                        }
                    } else {
                        this.f67704e.add(bVar);
                        this.f67704e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, d.a.u.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), bVar}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (!z) {
                this.j.put(valueOf, bVar);
            } else if (bVar != null) {
                this.k.put(valueOf, bVar);
            }
            d.a.u.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && d.a.u.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (d.a.u.a.h.f.m(this.q)) {
                    d.a.u.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
                    this.o = true;
                    this.f67703d = true;
                    P(str2);
                    d0();
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    d.a.u.a.c.a.h(this.q, null, false);
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
        public long f67727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f67728f;

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
            this.f67728f = fVar;
            this.f67727e = 60000L;
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f67727e = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f67728f.u.removeCallbacks(this.f67728f.n);
                if (d.a.u.a.h.f.m(this.f67728f.q)) {
                    this.f67728f.u.postDelayed(this.f67728f.n, this.f67727e);
                    f fVar = this.f67728f;
                    fVar.f0(fVar.f67708i.b(this.f67728f.q, 3L));
                }
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this(fVar);
        }
    }
}
