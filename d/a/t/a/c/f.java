package d.a.t.a.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import d.a.t.a.c.a;
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
/* loaded from: classes2.dex */
public final class f extends Observable {
    public static volatile d.a.t.a.b.b D = new d.a.t.a.b.b();
    public static volatile f E;
    public long A;
    public j l;
    public i m;
    public Context q;
    public d.a.t.a.c.d r;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f68380a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f68381b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public int f68382c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68383d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<d.a.t.a.c.b> f68384e = new LinkedList<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, d.a.t.a.c.b> f68385f = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Object f68386g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public final Object f68387h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public d.a.t.a.e.b f68388i = new d.a.t.a.e.b();
    public Map<Long, d.a.t.a.b.d.b> j = new LinkedHashMap();
    public Map<Long, d.a.t.a.b.d.b> k = new LinkedHashMap();
    public h n = new h(this, null);
    public boolean o = false;
    public AtomicInteger p = new AtomicInteger(0);
    public k s = new k(this, null);
    public String x = "";
    public String y = "";
    public String z = "";
    public Runnable B = new b();
    public Runnable C = new c();

    /* loaded from: classes2.dex */
    public class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f68389a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f68391c;

        public a(String str, String str2, String str3) {
            this.f68389a = str;
            this.f68390b = str2;
            this.f68391c = str3;
        }

        @Override // d.a.t.a.c.a.d
        public void a(int i2, String str, String str2) {
            d.a.t.a.h.e.a("SocketTransceiver", "-----try to connect ip:" + str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f68389a;
            }
            f fVar = f.this;
            fVar.w = str2;
            d.a.t.a.a.c d2 = d.a.t.a.a.a.h(fVar.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.f68390b).d("ip", str2).d("domain", this.f68389a).d(ProbeTB.PROTOCOL, this.f68391c);
            d2.d("P31", "DNS result:" + i2).d("con_err_code", "P31");
            if (i2 == 0) {
                d.a.t.a.a.a.h(f.this.q).g(601110).b("connect_state", 2);
                d.a.t.a.g.a a2 = d.a.t.a.g.a.a(f.this.q);
                f fVar2 = f.this;
                a2.b(new e(str2, this.f68390b, Integer.valueOf(fVar2.f68381b.incrementAndGet())));
                return;
            }
            d.a.t.a.a.a.h(f.this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", f.this.p.get()).e();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.M();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.f0(fVar.f68388i.b(f.this.q, 1L));
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68395a;

        static {
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f68395a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68395a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68395a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68395a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f68396e;

        /* renamed from: f  reason: collision with root package name */
        public String f68397f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f68398g;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.t.a.h.d.c(f.this.q);
                d.a.t.a.h.d.e("lcp connect:" + (System.currentTimeMillis() - f.this.A));
            }
        }

        public e(String str, String str2, Integer num) {
            this.f68397f = str;
            this.f68396e = str2;
            this.f68398g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
            } catch (Exception e2) {
                d.a.t.a.h.e.c("SocketTransceiver", "connectRunnable", e2);
            }
            if (!f.this.I()) {
                if (f.this.m != null && f.this.m.isAlive()) {
                    f.this.m.interrupt();
                    d.a.t.a.h.e.a("SocketTransceiver", "readThread interrupt");
                }
                if (f.this.l != null && f.this.l.isAlive()) {
                    f.this.l.interrupt();
                    d.a.t.a.h.e.a("SocketTransceiver", "sendThread interrupt");
                }
                RunnableC1870f runnableC1870f = new RunnableC1870f(this.f68398g, this.f68397f);
                f.this.u.a(this.f68397f);
                f.this.u.postDelayed(runnableC1870f, 15000L);
                try {
                    d.a.t.a.a.a.h(f.this.q).g(601110).c("socket_begin", System.currentTimeMillis());
                    d.a.t.a.c.e e3 = f.this.r.e(this.f68397f, Integer.valueOf(this.f68396e).intValue());
                    if (f.this.I()) {
                        d.a.t.a.a.a.h(f.this.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", f.this.p.get()).e();
                        d.a.t.a.h.e.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                        f.this.J(e3);
                        return;
                    } else if (e3.f68376b.booleanValue()) {
                        synchronized (f.this.f68380a) {
                            d.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                            f.this.u.removeCallbacks(runnableC1870f);
                            runnableC1870f.a();
                            if (!f.this.I()) {
                                if (f.this.f68380a.get(this.f68398g) == null) {
                                    d.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                    f.this.r.c(e3);
                                }
                                d.a.t.a.a.a.h(f.this.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                d.a.t.a.h.f.B(f.this.q, f.this.p.get() == 0 ? 1 : 2);
                                d.a.t.a.h.e.d("SocketTransceiver", "create Socket ok");
                                d.a.t.a.c.a.g(f.this.q, this.f68397f);
                                d.a.t.a.a.a.h(f.this.q).g(601110).c("login_begin", System.currentTimeMillis());
                                f.this.f0(f.this.f68388i.b(f.this.q, 1L));
                                f.this.v = SystemClock.currentThreadTimeMillis();
                                if (d.a.t.a.h.c.a(f.this.q) != 0) {
                                    d.a.t.a.g.a.a(f.this.q).b(new a());
                                }
                                d.a.t.a.h.e.a("SocketTransceiver", "connectImpl time:" + f.this.v);
                                f.D.f68345a = -2;
                                f.this.o = false;
                                f.this.l = new j(this.f68397f);
                                f.this.l.start();
                                f.this.m = new i(this.f68397f);
                                f.this.m.start();
                                return;
                            }
                            d.a.t.a.h.e.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                            f.this.J(e3);
                            return;
                        }
                    } else {
                        d.a.t.a.a.a.h(f.this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.f68397f).d("con_err_code", "P14").b("retry_cout", f.this.p.get()).e();
                        f.this.u.removeCallbacks(runnableC1870f);
                        f.this.i0("connect env error:", this.f68397f);
                        return;
                    }
                } catch (Throwable th) {
                    String str = "Throwable : " + th;
                    d.a.t.a.h.e.c("SocketTransceiver", str, th);
                    f.this.u.removeCallbacks(runnableC1870f);
                    runnableC1870f.a();
                    synchronized (f.this.f68380a) {
                        if (f.this.f68380a.get(this.f68398g) != null) {
                            f.this.f68380a.remove(this.f68398g);
                            return;
                        }
                        f.this.O("ConnectTask exception:" + str, this.f68397f);
                        return;
                    }
                }
            }
            d.a.t.a.h.e.a("SocketTransceiver", "socket create begin, but socket has created ok.");
            d.a.t.a.a.a.h(f.this.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", f.this.p.get()).e();
        }
    }

    /* renamed from: d.a.t.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1870f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Integer f68401e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68402f = false;

        /* renamed from: g  reason: collision with root package name */
        public String f68403g;

        public RunnableC1870f(Integer num, String str) {
            this.f68401e = num;
            this.f68403g = str;
        }

        public void a() {
            this.f68402f = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f68380a) {
                if (!this.f68402f && f.D.f68345a != 0) {
                    f.this.f68380a.put(this.f68401e, Boolean.TRUE);
                    d.a.t.a.a.a.h(f.this.q).g(601110).c("socket_end", System.currentTimeMillis());
                    f.this.O("time out:", this.f68403g);
                    return;
                }
                d.a.t.a.h.e.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.u.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public String f68405a;

        public g(Looper looper) {
            super(looper);
        }

        public void a(String str) {
            this.f68405a = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            long j = message.arg1;
            synchronized (f.this.f68387h) {
                f.this.Y(j, this.f68405a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public String f68409e;

        public i(String str) {
            this.f68409e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.a.t.a.c.b bVar;
            while (!f.this.o) {
                try {
                    try {
                        d.a.t.a.c.b c2 = f.this.f68388i.c(f.this.r.b());
                        if (c2 != null && c2.n > 0) {
                            f.this.u.removeCallbacks(f.this.s);
                            c2.m = false;
                            d.a.t.a.h.e.d("SocketTransceiver", "ReadThread :" + c2.toString());
                            if (!c2.k) {
                                if (c2.f68372i == 1 && c2.f68371h == 4) {
                                    Context context = f.this.q;
                                    d.a.t.a.h.b.a(context, 1L, "read", c2.n + "");
                                }
                                if (c2.f68372i == 50 && c2.f68371h == 2) {
                                    Context context2 = f.this.q;
                                    d.a.t.a.h.b.a(context2, 50L, "read", c2.n + "");
                                }
                                synchronized (f.this.f68387h) {
                                    d.a.t.a.h.e.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                    bVar = (d.a.t.a.c.b) f.this.f68385f.remove(Long.valueOf(c2.n));
                                }
                                f.this.W(c2, bVar, this.f68409e);
                            }
                            synchronized (f.this.f68387h) {
                                if (f.this.f68385f.size() != 0) {
                                    d.a.t.a.h.e.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.s.b(c2.n);
                                    f.this.s.a(this.f68409e);
                                    f.this.u.a(this.f68409e);
                                    f.this.u.postDelayed(f.this.s, c2.f68365b);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (f.this.o) {
                            return;
                        }
                        d.a.t.a.h.e.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                        f.this.f68383d = false;
                        f fVar = f.this;
                        fVar.O("ReadThread exception: " + e2, this.f68409e);
                        return;
                    }
                } catch (Exception e3) {
                    if (f.this.o) {
                        return;
                    }
                    d.a.t.a.h.e.c("SocketTransceiver", "onStartCommand", e3);
                    f.this.f68383d = false;
                    f fVar2 = f.this;
                    fVar2.O("onStartCommand:" + e3, this.f68409e);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public String f68411e;

        public j(String str) {
            this.f68411e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!f.this.o) {
                try {
                    d.a.t.a.c.b bVar = null;
                    try {
                        synchronized (f.this.f68384e) {
                            if (f.this.f68384e.size() == 0) {
                                f.this.f68384e.wait();
                            } else {
                                bVar = (d.a.t.a.c.b) f.this.f68384e.removeFirst();
                            }
                        }
                    } catch (InterruptedException e2) {
                        d.a.t.a.h.e.b("SocketTransceiver", "SendThread wait exception: " + e2);
                        f fVar = f.this;
                        fVar.O("SendThread wait exception: " + e2, this.f68411e);
                    }
                    if (bVar != null) {
                        try {
                            if (f.this.o) {
                                f.this.X(bVar.n, this.f68411e);
                                return;
                            }
                            bVar.m = true;
                            bVar.j = f.D.f68345a;
                            if (bVar.o) {
                                synchronized (f.this.f68387h) {
                                    if (f.this.f68385f.isEmpty()) {
                                        f.this.u.removeCallbacks(f.this.s);
                                        f.this.s.b(bVar.n);
                                        f.this.s.a(this.f68411e);
                                        f.this.u.a(this.f68411e);
                                        f.this.u.postDelayed(f.this.s, 15000L);
                                    }
                                }
                            }
                            d.a.t.a.h.e.e("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.f68372i == 1 && bVar.f68371h == 4) {
                                Context context = f.this.q;
                                d.a.t.a.h.b.a(context, 1L, "send", bVar.n + "");
                            }
                            if (bVar.f68372i == 50 && bVar.f68371h == 2) {
                                Context context2 = f.this.q;
                                d.a.t.a.h.b.a(context2, 50L, "send", bVar.n + "");
                            }
                            synchronized (f.this.f68386g) {
                                f.this.r.f(bVar);
                            }
                            if (!bVar.k && bVar.o) {
                                synchronized (f.this.f68387h) {
                                    f.this.f68385f.put(Long.valueOf(bVar.n), bVar);
                                }
                            }
                        } catch (Exception e3) {
                            d.a.t.a.h.e.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                            f.this.T(bVar.n, e3.toString(), this.f68411e);
                            f fVar2 = f.this;
                            fVar2.O("SendThread sendMessage Exception:" + e3, this.f68411e);
                            return;
                        }
                    }
                } catch (Exception e4) {
                    d.a.t.a.h.e.c("SocketTransceiver", "SendThread Exception:", e4);
                    f fVar3 = f.this;
                    fVar3.O("SendThread Exception:" + e4, this.f68411e);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f68413e;

        /* renamed from: f  reason: collision with root package name */
        public String f68414f;

        public k() {
        }

        public void a(String str) {
            this.f68414f = str;
        }

        public void b(long j) {
            this.f68413e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.Y(this.f68413e, this.f68414f);
            f.this.O("read and write thread timeout:", this.f68414f);
        }

        public /* synthetic */ k(f fVar, a aVar) {
            this();
        }
    }

    public f(Context context) {
        this.q = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.t = handlerThread;
        handlerThread.start();
        this.u = new g(this.t.getLooper());
    }

    public static synchronized f S(Context context) {
        f fVar;
        synchronized (f.class) {
            if (E == null) {
                E = new f(context.getApplicationContext());
            }
            fVar = E;
        }
        return fVar;
    }

    public synchronized void H(BLCPRequest bLCPRequest, d.a.t.a.b.d.b bVar) {
        if (d.a.t.a.h.f.m(this.q)) {
            d.a.t.a.c.b bVar2 = new d.a.t.a.c.b();
            bVar2.f68371h = bLCPRequest.f6365a;
            bVar2.f68372i = bLCPRequest.f6366b;
            bVar2.f68364a = bLCPRequest.f6367c;
            if (bLCPRequest.f6368d < 0) {
                bVar2.n = System.currentTimeMillis();
            } else {
                bVar2.n = bLCPRequest.f6368d;
            }
            int i2 = d.f68395a[bLCPRequest.f6369e.ordinal()];
            if (i2 == 1) {
                bVar2.f68365b = 20000L;
            } else if (i2 == 2) {
                bVar2.f68365b = 30000L;
            } else if (i2 != 3) {
                bVar2.f68365b = 15000L;
            } else {
                bVar2.f68365b = 50000L;
            }
            if (bLCPRequest instanceof d.a.t.a.b.d.a) {
                long j2 = (bVar2.f68371h * 10000) + bVar2.f68372i;
                bVar2.n = j2;
                g0(bVar2.f68371h, bVar2.f68372i, j2, true, bVar);
            } else {
                g0(bVar2.f68371h, bVar2.f68372i, bVar2.n, false, bVar);
                this.f68388i.a(bVar2, true);
                f0(bVar2);
            }
        }
    }

    public final boolean I() {
        d.a.t.a.c.d dVar = this.r;
        return (dVar == null || dVar.a() == null || this.r.a().f68377c == null || !this.r.a().f68377c.isConnected()) ? false : true;
    }

    public final void J(d.a.t.a.c.e eVar) {
        if (eVar == null || !eVar.f68375a.booleanValue()) {
            return;
        }
        try {
            if (eVar.f68377c != null) {
                if (eVar.f68377c.hashCode() == this.r.a().f68377c.hashCode()) {
                    d.a.t.a.h.e.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                    return;
                }
                eVar.f68377c.close();
                eVar.f68377c = null;
                if (eVar.f68378d != null) {
                    eVar.f68378d.close();
                    eVar.f68378d = null;
                }
                if (eVar.f68379e != null) {
                    eVar.f68379e.close();
                    eVar.f68379e = null;
                }
                d.a.t.a.h.e.a("SocketTransceiver", "closeExistedConnection ok");
            }
        } catch (IOException e2) {
            d.a.t.a.h.e.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
        }
    }

    public final long K(int i2) {
        if (i2 < 3) {
            return i2 * 1000;
        }
        return 3000L;
    }

    public final synchronized void L(String str, String str2, String str3) {
        d.a.t.a.a.a.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
        d.a.t.a.c.a.c(this.q).b(str, new a(str, str2, str3));
    }

    public final synchronized void M() {
        if (!RequsetNetworkUtils.isConnected(this.q)) {
            d.a.t.a.a.a.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            d0();
            return;
        }
        if (D.f68345a != 0 && D.f68345a != -2) {
            this.u.removeCallbacks(this.B);
            this.u.removeCallbacks(this.C);
            this.u.removeCallbacks(this.n);
            c0();
            return;
        }
        d.a.t.a.h.e.d("SocketTransceiver", "connectImpl connect state:" + D.f68345a);
        d.a.t.a.a.a.h(this.q).g(601110).b("inner_connect_state", D.f68345a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
    }

    public final synchronized void N(String str, String str2) {
        if (d.a.t.a.h.f.m(this.q)) {
            d.a.t.a.h.e.d("SocketTransceiver", "destroy");
            D.f68345a = -1;
            setChanged();
            notifyObservers(D);
            Z();
            this.u.removeCallbacks(this.s);
            this.o = true;
            if (this.r != null) {
                synchronized (this.f68384e) {
                    this.f68384e.notifyAll();
                    d.a.t.a.h.e.d("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.r.d();
                    d.a.t.a.h.e.a("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.r.c(null);
                    d.a.t.a.h.e.c("SocketTransceiver", "Exception destroy:", e2);
                }
            }
        }
    }

    public final synchronized void O(String str, String str2) {
        d.a.t.a.h.e.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f68383d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + d.a.t.a.h.f.m(this.q));
        d.a.t.a.a.a.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
        d.a.t.a.a.c c2 = d.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("disconnectedByLcp:");
        sb.append(str);
        c2.d("source", sb.toString());
        if (d.a.t.a.h.f.m(this.q)) {
            P(str2);
            if (this.f68383d) {
                d.a.t.a.a.c c3 = d.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P16", "disconnectedByLcp:" + this.f68383d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                d0();
                return;
            }
            N(str, str2);
            if (!RequsetNetworkUtils.isConnected(this.q)) {
                d.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
                d0();
                return;
            }
            e0(false);
        }
    }

    public final void P(String str) {
        try {
            d.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.f68384e) {
                while (this.f68384e.size() > 0) {
                    Q(this.f68384e.removeFirst(), str);
                }
                d.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.f68387h) {
                d.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.f68385f.keySet()) {
                    Q(this.f68385f.get(l), str);
                }
                this.f68385f.clear();
                d.a.t.a.h.e.a("SocketTransceiver", "fatalAllMessage mSync end");
            }
        } catch (Exception e2) {
            d.a.t.a.h.e.c("SocketTransceiver", "fatalAllMessage Exception", e2);
        }
    }

    public final void Q(d.a.t.a.c.b bVar, String str) {
        if (bVar == null || bVar.f68371h == 1) {
            return;
        }
        d.a.t.a.h.e.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f68371h + ", methodId :" + bVar.f68372i);
        W(new d.a.t.a.c.b(), bVar, str);
    }

    public d.a.t.a.b.b R() {
        return D;
    }

    public final void T(long j2, String str, String str2) {
        try {
            if (this.f68385f.size() <= 0 || !this.f68385f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.a.t.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + this.f68385f.get(Long.valueOf(j2)).toString());
            d.a.t.a.c.b remove = this.f68385f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f68366c = 8005;
            remove.f68367d = "socket exception :" + str;
            W(remove, remove, str2);
        } catch (Exception e2) {
            d.a.t.a.h.e.a("SocketTransceiver", "handle msg exception!!! " + e2);
        }
    }

    public final void U(d.a.t.a.c.b bVar, String str) {
        int i2;
        if (bVar.f68366c == 0) {
            long j2 = bVar.f68370g;
            long j3 = j2 > 0 ? j2 : 60000L;
            long j4 = bVar.f68372i;
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
                D.f68345a = bVar.j;
                setChanged();
                notifyObservers(D);
                Z();
                return;
            }
        }
        String str2 = " errorcode:" + bVar.f68366c + " errmsg:" + bVar.f68367d;
        if (!String.valueOf(bVar.f68366c).startsWith(EventType.GiftEventID.SEND_GIFT_TO_USER_SUCCESS) && (i2 = bVar.f68366c) != 1011 && i2 != 2003) {
            if (i2 != 1012) {
                if (i2 == 1013) {
                    V(60000L, false, str);
                    return;
                }
                D.f68345a = -1;
                setChanged();
                notifyObservers(D);
                Z();
                e0(true);
                return;
            }
            d.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            d.a.t.a.h.e.a("SocketTransceiver", "login error :" + bVar.f68366c);
            return;
        }
        d.a.t.a.h.e.a("SocketTransceiver", "login error, then request token, error :" + bVar.f68366c);
        i0("errorCode:" + String.valueOf(bVar.f68366c), str);
        d.a.t.a.h.f.z(this.q, "");
        d.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
        d.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
        d.a.t.a.b.c.f().m();
    }

    public final void V(long j2, boolean z, String str) {
        try {
            d.a.t.a.a.a.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
            this.p.set(0);
            D.f68345a = 0;
            setChanged();
            notifyObservers(D);
            Z();
            if (z) {
                this.u.a(str);
                this.u.postDelayed(this.n, j2);
                d.a.t.a.h.e.a("SocketTransceiver", "ping every 1分钟 ");
            }
        } catch (Exception e2) {
            d.a.t.a.h.e.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public final void W(d.a.t.a.c.b bVar, d.a.t.a.c.b bVar2, String str) {
        long j2 = bVar.f68371h;
        if (j2 == 1) {
            U(bVar, str);
        } else if (j2 != -1) {
            a0(bVar);
        } else if (bVar2 == null) {
        } else {
            if (bVar2.f68371h == 1) {
                U(bVar2, str);
            } else {
                a0(bVar2);
            }
        }
    }

    public final void X(long j2, String str) {
        try {
            if (this.f68385f.size() <= 0 || !this.f68385f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.a.t.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f68385f.get(Long.valueOf(j2)).toString());
            d.a.t.a.c.b remove = this.f68385f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f68366c = 8006;
            remove.f68367d = "socket stopped :";
            W(remove, remove, str);
        } catch (Exception e2) {
            d.a.t.a.h.e.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
        }
    }

    public final void Y(long j2, String str) {
        try {
            if (this.f68385f.size() <= 0 || !this.f68385f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.a.t.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + this.f68385f.get(Long.valueOf(j2)).toString());
            d.a.t.a.c.b remove = this.f68385f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f68366c = 8004;
            remove.f68367d = "socket timeout";
            W(remove, remove, str);
        } catch (Exception e2) {
            d.a.t.a.h.e.a("SocketTransceiver", "handle msg timeout!!! " + e2);
        }
    }

    public void Z() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", D.f68345a);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
    }

    public final synchronized void a0(d.a.t.a.c.b bVar) {
        d.a.t.a.b.d.b bVar2 = null;
        try {
            Long valueOf = Long.valueOf(!bVar.f68368e ? bVar.n : (bVar.f68371h * 10000) + bVar.f68372i);
            d.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
            if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                bVar2 = this.k.get(valueOf);
            } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                bVar2 = this.j.remove(valueOf);
            }
            if (bVar2 != null) {
                d.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f68372i + ", serviceId :" + bVar.f68371h + ", error :" + bVar.f68366c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f68367d + ", invoke keys :" + this.j.keySet().toString());
                bVar2.onResponse(bVar.f68366c, bVar.f68367d, bVar.f68371h, bVar.f68372i, bVar.n, bVar.f68369f);
                if (bVar.f68366c == 1011) {
                    d.a.t.a.h.e.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f68366c + ", and will send lcm login msg .");
                    f0(this.f68388i.b(this.q, 1L));
                }
            }
        } catch (Exception e2) {
            d.a.t.a.h.e.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
        }
    }

    public void b0() {
        d.a.t.a.h.e.a("SocketTransceiver", "customPingRunnable send PingRequest ");
        f0(this.f68388i.b(this.q, 3L));
    }

    public final synchronized void c0() {
        this.A = System.currentTimeMillis();
        if (!this.x.isEmpty() && !this.y.isEmpty() && d.a.t.a.c.a.d()) {
            L(this.x, this.y, this.z);
            return;
        }
        d.a.t.a.h.e.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f68382c);
        String[] split = d.a.t.a.h.f.h(this.q, this.f68382c).split(":");
        if (split.length < 3) {
            return;
        }
        String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
        String str2 = split[1];
        String str3 = split[2];
        if (this.f68382c >= d.a.t.a.h.f.i(this.q)) {
            this.f68382c = 0;
            d.a.t.a.h.e.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
            this.r = new d.a.t.a.c.g(this.q, "tls");
            this.x = "lcs.baidu.com";
            this.y = "443";
            this.z = "tls";
            L("lcs.baidu.com", "443", "tls");
            return;
        }
        if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
            this.r = new QuicMessageHandler(this.q);
        } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof d.a.t.a.c.g))) {
            this.r = new d.a.t.a.c.g(this.q, str);
        }
        this.f68382c++;
        if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            d.a.t.a.h.e.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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

    public final void d0() {
        this.f68382c = 0;
        this.p.set(0);
        d.a.t.a.c.a.i();
    }

    public final void e0(boolean z) {
        try {
            this.p.incrementAndGet();
            if (this.p.get() <= 10 && D.f68345a == -1) {
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
                d.a.t.a.a.a.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                d.a.t.a.h.e.d("SocketTransceiver", sb2);
                return;
            }
            d.a.t.a.a.c c2 = d.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
            c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.f68345a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
        } catch (Exception e2) {
            d.a.t.a.a.c c3 = d.a.t.a.a.a.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
            c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
            d.a.t.a.h.e.c("SocketTransceiver", "retry Exception", e2);
        }
    }

    public final synchronized void f0(d.a.t.a.c.b bVar) {
        try {
        } catch (Exception e2) {
            d.a.t.a.h.e.c("SocketTransceiver", "sendMessage Exception :", e2);
        }
        synchronized (this.f68384e) {
            boolean z = false;
            Iterator<d.a.t.a.c.b> it = this.f68384e.iterator();
            while (it.hasNext()) {
                d.a.t.a.c.b next = it.next();
                d.a.t.a.h.e.a("SocketTransceiver", "sendMessage queue :" + next.n);
                if (next.l) {
                    z = true;
                }
            }
            if (bVar.l) {
                if (!z && D.f68345a == -1) {
                    this.f68384e.addFirst(bVar);
                    this.f68384e.notifyAll();
                }
                d.a.t.a.h.e.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.f68345a);
            } else if (D.f68345a == -1) {
                if (I()) {
                    if (this.f68384e.size() <= 0 || !z) {
                        this.f68384e.addFirst(this.f68388i.b(this.q, 1L));
                        this.f68384e.notifyAll();
                    }
                    if (!bVar.k) {
                        this.f68384e.add(bVar);
                        this.f68384e.notifyAll();
                    }
                } else {
                    if (bVar.k) {
                        d.a.t.a.a.a.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                        c0();
                    }
                    this.f68384e.add(bVar);
                }
            } else {
                this.f68384e.add(bVar);
                this.f68384e.notifyAll();
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, d.a.t.a.b.d.b bVar) {
        Long valueOf = Long.valueOf(j4);
        if (!z) {
            this.j.put(valueOf, bVar);
        } else if (bVar != null) {
            this.k.put(valueOf, bVar);
        }
        d.a.t.a.h.e.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
    }

    public void h0() {
        if (d.a.t.a.h.f.m(this.q)) {
            d0();
            M();
        }
    }

    public synchronized void i0(String str, String str2) {
        if (d.a.t.a.h.f.m(this.q)) {
            d.a.t.a.h.e.d("SocketTransceiver", "---socketDisconnect---");
            this.o = true;
            this.f68383d = true;
            P(str2);
            d0();
            this.u.removeCallbacks(this.B);
            this.u.removeCallbacks(this.C);
            this.u.removeCallbacks(this.n);
            d.a.t.a.c.a.h(this.q, null, false);
            N(str, str2);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f68407e;

        public h() {
            this.f68407e = 60000L;
        }

        public void a(long j) {
            this.f68407e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.u.removeCallbacks(f.this.n);
            if (d.a.t.a.h.f.m(f.this.q)) {
                f.this.u.postDelayed(f.this.n, this.f68407e);
                f fVar = f.this;
                fVar.f0(fVar.f68388i.b(f.this.q, 3L));
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this();
        }
    }
}
