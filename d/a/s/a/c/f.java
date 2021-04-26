package d.a.s.a.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import d.a.s.a.a.a;
import d.a.s.a.c.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class f extends Observable {
    public static volatile d.a.s.a.b.b C = new d.a.s.a.b.b();
    public static volatile f D;
    public j l;
    public i m;
    public Context q;
    public d.a.s.a.c.d r;
    public HandlerThread t;
    public g u;
    public long v;
    public long z;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f63895a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f63896b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public int f63897c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63898d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<d.a.s.a.c.b> f63899e = new LinkedList<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, d.a.s.a.c.b> f63900f = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Object f63901g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public final Object f63902h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public d.a.s.a.d.b f63903i = new d.a.s.a.d.b();
    public Map<Long, d.a.s.a.b.d.b> j = new LinkedHashMap();
    public Map<Long, d.a.s.a.b.d.b> k = new LinkedHashMap();
    public h n = new h(this, null);
    public boolean o = false;
    public AtomicInteger p = new AtomicInteger(0);
    public k s = new k(this, null);
    public String w = "";
    public String x = "";
    public String y = "";
    public Runnable A = new b();
    public Runnable B = new c();

    /* loaded from: classes2.dex */
    public class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f63904a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63905b;

        public a(String str, String str2) {
            this.f63904a = str;
            this.f63905b = str2;
        }

        @Override // d.a.s.a.c.a.d
        public void a(int i2, String str, String str2) {
            d.a.s.a.g.d.a("SocketTransceiver", "-----try to connect ip:" + str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f63904a;
            }
            f fVar = f.this;
            fVar.w = str2;
            Context context = fVar.q;
            d.a.s.a.a.d.w(context, "14N_0", "socketConnect :" + f.this.w);
            if (i2 == 0) {
                d.a.s.a.f.a a2 = d.a.s.a.f.a.a(f.this.q);
                f fVar2 = f.this;
                a2.b(new e(str2, this.f63905b, Integer.valueOf(fVar2.f63896b.incrementAndGet())));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.N();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.g0(fVar.f63903i.b(f.this.q, 1L));
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63909a;

        static {
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f63909a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f63909a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f63909a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f63909a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63910e;

        /* renamed from: f  reason: collision with root package name */
        public String f63911f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f63912g;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.s.a.g.c.c(f.this.q);
                d.a.s.a.g.c.e("lcp connect:" + (System.currentTimeMillis() - f.this.z));
            }
        }

        public e(String str, String str2, Integer num) {
            this.f63911f = str;
            this.f63910e = str2;
            this.f63912g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
            } catch (Exception e2) {
                d.a.s.a.g.d.c("SocketTransceiver", "connectRunnable", e2);
                d.a.s.a.a.d.w(f.this.q, "16N", "connect exception");
            }
            if (!f.this.J()) {
                if (f.this.m != null && f.this.m.isAlive()) {
                    f.this.m.interrupt();
                    d.a.s.a.g.d.a("SocketTransceiver", "readThread interrupt");
                }
                if (f.this.l != null && f.this.l.isAlive()) {
                    f.this.l.interrupt();
                    d.a.s.a.g.d.a("SocketTransceiver", "sendThread interrupt");
                }
                RunnableC1739f runnableC1739f = new RunnableC1739f(this.f63912g, this.f63911f);
                f.this.u.a(this.f63911f);
                f.this.u.postDelayed(runnableC1739f, 5000L);
                try {
                    d.a.s.a.a.d.w(f.this.q, "14N", "socketConnect :" + f.this.w);
                    d.a.s.a.c.e e3 = f.this.r.e(this.f63911f, Integer.valueOf(this.f63910e).intValue());
                    if (f.this.J()) {
                        d.a.s.a.g.d.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                        f.this.K(e3);
                        return;
                    } else if (!e3.f63891b.booleanValue()) {
                        d.a.s.a.a.d.w(f.this.q, "15N", "connect env error");
                        f.this.O(401213, "connect env error", this.f63911f);
                        f.this.u.removeCallbacks(runnableC1739f);
                        f.this.j0("connect env error:", this.f63911f);
                        return;
                    } else {
                        synchronized (f.this.f63895a) {
                            d.a.s.a.g.d.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                            f.this.u.removeCallbacks(runnableC1739f);
                            runnableC1739f.a();
                            if (!f.this.J()) {
                                if (f.this.f63895a.get(this.f63912g) == null) {
                                    d.a.s.a.g.d.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                    f.this.r.c(e3);
                                }
                                d.a.s.a.g.e.B(f.this.q, f.this.p.get() == 0 ? 1 : 2);
                                d.a.s.a.g.d.d("SocketTransceiver", "create Socket ok");
                                f.this.O(401211, "connect ok", this.f63911f);
                                d.a.s.a.a.d.w(f.this.q, "16Y", "connect ok");
                                d.a.s.a.c.a.h(f.this.q, this.f63911f);
                                f.this.g0(f.this.f63903i.b(f.this.q, 1L));
                                f.this.v = SystemClock.currentThreadTimeMillis();
                                if (d.a.s.a.g.b.a(f.this.q) != 0) {
                                    d.a.s.a.f.a.a(f.this.q).b(new a());
                                }
                                d.a.s.a.g.d.a("SocketTransceiver", "connectImpl time:" + f.this.v);
                                f.C.f63860a = -2;
                                f.this.o = false;
                                f.this.l = new j(this.f63911f);
                                f.this.l.start();
                                f.this.m = new i(this.f63911f);
                                f.this.m.start();
                                return;
                            }
                            d.a.s.a.g.d.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                            f.this.K(e3);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    String str = "Throwable : " + th;
                    d.a.s.a.g.d.c("SocketTransceiver", str, th);
                    d.a.s.a.a.d.w(f.this.q, "16N", str);
                    f.this.O(401215, str, this.f63911f);
                    f.this.u.removeCallbacks(runnableC1739f);
                    runnableC1739f.a();
                    synchronized (f.this.f63895a) {
                        if (f.this.f63895a.get(this.f63912g) != null) {
                            f.this.f63895a.remove(this.f63912g);
                            return;
                        }
                        f.this.Q("ConnectTask exception:" + str, this.f63911f);
                        return;
                    }
                }
            }
            d.a.s.a.g.d.a("SocketTransceiver", "socket create begin, but socket has created ok.");
        }
    }

    /* renamed from: d.a.s.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1739f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Integer f63915e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63916f = false;

        /* renamed from: g  reason: collision with root package name */
        public String f63917g;

        public RunnableC1739f(Integer num, String str) {
            this.f63915e = num;
            this.f63917g = str;
        }

        public void a() {
            this.f63916f = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f63895a) {
                if (!this.f63916f && f.C.f63860a != 0) {
                    f.this.f63895a.put(this.f63915e, Boolean.TRUE);
                    Context context = f.this.q;
                    d.a.s.a.a.d.w(context, "14N_1", "socketConnect_timeout :" + f.this.w);
                    f.this.O(401214, "time out", this.f63917g);
                    f.this.Q("time out:", this.f63917g);
                    return;
                }
                d.a.s.a.g.d.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.u.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public String f63919a;

        public g(Looper looper) {
            super(looper);
        }

        public void a(String str) {
            this.f63919a = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            long j = message.arg1;
            synchronized (f.this.f63902h) {
                f.this.Z(j, this.f63919a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public String f63923e;

        public i(String str) {
            this.f63923e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.a.s.a.c.b bVar;
            while (!f.this.o) {
                try {
                    try {
                        d.a.s.a.c.b c2 = f.this.f63903i.c(f.this.r.b());
                        if (c2 != null && c2.n > 0) {
                            f.this.u.removeCallbacks(f.this.s);
                            c2.m = false;
                            d.a.s.a.g.d.d("SocketTransceiver", "ReadThread :" + c2.toString());
                            if (!c2.k) {
                                if (c2.l) {
                                    d.a.s.a.a.d.w(f.this.q, "17N_1", "Read LoginMsg Response");
                                }
                                if (c2.f63887i == 1 && c2.f63886h == 4) {
                                    Context context = f.this.q;
                                    d.a.s.a.g.a.a(context, 1L, "read", c2.n + "");
                                }
                                if (c2.f63887i == 50 && c2.f63886h == 2) {
                                    Context context2 = f.this.q;
                                    d.a.s.a.g.a.a(context2, 50L, "read", c2.n + "");
                                }
                                synchronized (f.this.f63902h) {
                                    d.a.s.a.g.d.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                    bVar = (d.a.s.a.c.b) f.this.f63900f.remove(Long.valueOf(c2.n));
                                }
                                f.this.X(c2, bVar, this.f63923e);
                            }
                            synchronized (f.this.f63902h) {
                                if (f.this.f63900f.size() != 0) {
                                    d.a.s.a.g.d.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.s.b(c2.n);
                                    f.this.s.a(this.f63923e);
                                    f.this.u.a(this.f63923e);
                                    f.this.u.postDelayed(f.this.s, c2.f63880b);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (f.this.o) {
                            return;
                        }
                        d.a.s.a.g.d.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                        f.this.f63898d = false;
                        f fVar = f.this;
                        fVar.Q("ReadThread exception: " + e2, this.f63923e);
                        return;
                    }
                } catch (Exception e3) {
                    if (f.this.o) {
                        return;
                    }
                    d.a.s.a.g.d.c("SocketTransceiver", "onStartCommand", e3);
                    f.this.f63898d = false;
                    f fVar2 = f.this;
                    fVar2.Q("onStartCommand:" + e3, this.f63923e);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public String f63925e;

        public j(String str) {
            this.f63925e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!f.this.o) {
                try {
                    d.a.s.a.c.b bVar = null;
                    try {
                        synchronized (f.this.f63899e) {
                            if (f.this.f63899e.size() == 0) {
                                f.this.f63899e.wait();
                            } else {
                                bVar = (d.a.s.a.c.b) f.this.f63899e.removeFirst();
                            }
                        }
                    } catch (InterruptedException e2) {
                        d.a.s.a.g.d.b("SocketTransceiver", "SendThread wait exception: " + e2);
                        f fVar = f.this;
                        fVar.Q("SendThread wait exception: " + e2, this.f63925e);
                    }
                    if (bVar != null) {
                        try {
                            if (f.this.o) {
                                f.this.Y(bVar.n, this.f63925e);
                                return;
                            }
                            bVar.m = true;
                            bVar.j = f.C.f63860a;
                            if (bVar.o) {
                                synchronized (f.this.f63902h) {
                                    if (f.this.f63900f.isEmpty()) {
                                        f.this.u.removeCallbacks(f.this.s);
                                        f.this.s.b(bVar.n);
                                        f.this.s.a(this.f63925e);
                                        f.this.u.a(this.f63925e);
                                        f.this.u.postDelayed(f.this.s, 5000L);
                                    }
                                }
                            }
                            d.a.s.a.g.d.e("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.l) {
                                d.a.s.a.a.d.w(f.this.q, "17N", "Send LoginMsg request");
                            }
                            if (bVar.f63887i == 1 && bVar.f63886h == 4) {
                                Context context = f.this.q;
                                d.a.s.a.g.a.a(context, 1L, "send", bVar.n + "");
                            }
                            if (bVar.f63887i == 50 && bVar.f63886h == 2) {
                                Context context2 = f.this.q;
                                d.a.s.a.g.a.a(context2, 50L, "send", bVar.n + "");
                            }
                            synchronized (f.this.f63901g) {
                                f.this.r.f(bVar);
                            }
                            if (!bVar.k && bVar.o) {
                                synchronized (f.this.f63902h) {
                                    f.this.f63900f.put(Long.valueOf(bVar.n), bVar);
                                }
                            }
                        } catch (Exception e3) {
                            d.a.s.a.g.d.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                            f.this.U(bVar.n, e3.toString(), this.f63925e);
                            f fVar2 = f.this;
                            fVar2.Q("SendThread sendMessage Exception:" + e3, this.f63925e);
                            return;
                        }
                    }
                } catch (Exception e4) {
                    d.a.s.a.g.d.c("SocketTransceiver", "SendThread Exception:", e4);
                    f fVar3 = f.this;
                    fVar3.Q("SendThread Exception:" + e4, this.f63925e);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f63927e;

        /* renamed from: f  reason: collision with root package name */
        public String f63928f;

        public k() {
        }

        public void a(String str) {
            this.f63928f = str;
        }

        public void b(long j) {
            this.f63927e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.Z(this.f63927e, this.f63928f);
            f.this.Q("read and write thread timeout:", this.f63928f);
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

    public static synchronized f T(Context context) {
        f fVar;
        synchronized (f.class) {
            if (D == null) {
                D = new f(context.getApplicationContext());
            }
            fVar = D;
        }
        return fVar;
    }

    public synchronized void I(BLCPRequest bLCPRequest, d.a.s.a.b.d.b bVar) {
        if (d.a.s.a.g.e.m(this.q)) {
            d.a.s.a.c.b bVar2 = new d.a.s.a.c.b();
            bVar2.f63886h = bLCPRequest.f6598a;
            bVar2.f63887i = bLCPRequest.f6599b;
            bVar2.f63879a = bLCPRequest.f6600c;
            if (bLCPRequest.f6601d < 0) {
                bVar2.n = System.currentTimeMillis();
            } else {
                bVar2.n = bLCPRequest.f6601d;
            }
            int i2 = d.f63909a[bLCPRequest.f6602e.ordinal()];
            if (i2 == 1) {
                bVar2.f63880b = 20000L;
            } else if (i2 == 2) {
                bVar2.f63880b = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
            } else if (i2 != 3) {
                bVar2.f63880b = 5000L;
            } else {
                bVar2.f63880b = 50000L;
            }
            if (bLCPRequest instanceof d.a.s.a.b.d.a) {
                long j2 = (bVar2.f63886h * 10000) + bVar2.f63887i;
                bVar2.n = j2;
                h0(bVar2.f63886h, bVar2.f63887i, j2, true, bVar);
            } else {
                h0(bVar2.f63886h, bVar2.f63887i, bVar2.n, false, bVar);
                this.f63903i.a(bVar2, true);
                g0(bVar2);
            }
        }
    }

    public final boolean J() {
        d.a.s.a.c.d dVar = this.r;
        return (dVar == null || dVar.a() == null || this.r.a().f63892c == null || !this.r.a().f63892c.isConnected()) ? false : true;
    }

    public final void K(d.a.s.a.c.e eVar) {
        if (eVar == null || !eVar.f63890a.booleanValue()) {
            return;
        }
        try {
            if (eVar.f63892c != null) {
                if (eVar.f63892c.hashCode() == this.r.a().f63892c.hashCode()) {
                    d.a.s.a.g.d.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                    return;
                }
                eVar.f63892c.close();
                eVar.f63892c = null;
                if (eVar.f63893d != null) {
                    eVar.f63893d.close();
                    eVar.f63893d = null;
                }
                if (eVar.f63894e != null) {
                    eVar.f63894e.close();
                    eVar.f63894e = null;
                }
                d.a.s.a.g.d.a("SocketTransceiver", "closeExistedConnection ok");
            }
        } catch (IOException e2) {
            d.a.s.a.g.d.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
        }
    }

    public final long L(int i2) {
        if (i2 < 3) {
            return i2 * 1000;
        }
        return 3000L;
    }

    public final synchronized void M(String str, String str2) {
        d.a.s.a.a.d.w(this.q, "10Y", "DNS begin");
        d.a.s.a.c.a.d(this.q).b(str, new a(str, str2));
    }

    public final synchronized void N() {
        if (!RequsetNetworkUtils.isConnected(this.q)) {
            e0();
            return;
        }
        if (C.f63860a != 0 && C.f63860a != -2) {
            d.a.s.a.a.d.w(this.q, "10N_0", "connect begin");
            this.u.removeCallbacks(this.A);
            this.u.removeCallbacks(this.B);
            this.u.removeCallbacks(this.n);
            d0();
            return;
        }
        d.a.s.a.g.d.d("SocketTransceiver", "connectImpl connect state:" + C.f63860a);
        Context context = this.q;
        d.a.s.a.a.d.w(context, "17N_2", "connectState is " + C.f63860a);
    }

    public final void O(int i2, String str, String str2) {
        this.w += ":" + d.a.s.a.c.a.c() + ":" + RequsetNetworkUtils.getNetInfo(this.q);
        d.a.s.a.g.d.a("SocketTransceiver", "connectTrack ext:" + this.w + ", retry :" + this.p.get() + ", reason :" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        a.c cVar = new a.c(this.q);
        cVar.f(this.v);
        cVar.g(System.currentTimeMillis());
        cVar.a(i2);
        cVar.d(str);
        cVar.c(str2);
        cVar.e(this.p.get());
        cVar.b();
        if (d.a.s.a.a.d.i(this.q, 401216) && this.p.get() >= 5 && i2 != 401211) {
            d.a.s.a.a.b.j(this.q, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.v).setStopTime(System.currentTimeMillis()).setAliasId(401216L).setReason(str).setExt(str2).setRetryCount(this.p.get()).build()).build());
        }
        this.w = "";
    }

    public final synchronized void P(String str, String str2) {
        if (d.a.s.a.g.e.m(this.q)) {
            d.a.s.a.g.d.d("SocketTransceiver", "destroy");
            O(401212, "connect stop, " + str, str2);
            C.f63860a = -1;
            setChanged();
            notifyObservers(C);
            a0();
            this.u.removeCallbacks(this.s);
            this.o = true;
            if (this.r != null) {
                synchronized (this.f63899e) {
                    this.f63899e.notifyAll();
                    d.a.s.a.g.d.d("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.r.d();
                    d.a.s.a.g.d.a("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.r.c(null);
                    d.a.s.a.g.d.c("SocketTransceiver", "Exception destroy:", e2);
                }
            }
        }
    }

    public final synchronized void Q(String str, String str2) {
        d.a.s.a.g.d.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f63898d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + d.a.s.a.g.e.m(this.q));
        if (d.a.s.a.g.e.m(this.q)) {
            R(str2);
            if (this.f63898d) {
                e0();
                return;
            }
            P(str, str2);
            if (!RequsetNetworkUtils.isConnected(this.q)) {
                e0();
            } else {
                f0(false);
            }
        }
    }

    public final void R(String str) {
        try {
            d.a.s.a.g.d.a("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.f63899e) {
                while (this.f63899e.size() > 0) {
                    S(this.f63899e.removeFirst(), str);
                }
                d.a.s.a.g.d.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.f63902h) {
                d.a.s.a.g.d.a("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.f63900f.keySet()) {
                    S(this.f63900f.get(l), str);
                }
                this.f63900f.clear();
                d.a.s.a.g.d.a("SocketTransceiver", "fatalAllMessage mSync end");
            }
        } catch (Exception e2) {
            d.a.s.a.g.d.c("SocketTransceiver", "fatalAllMessage Exception", e2);
        }
    }

    public final void S(d.a.s.a.c.b bVar, String str) {
        if (bVar == null || bVar.f63886h == 1) {
            return;
        }
        d.a.s.a.g.d.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f63886h + ", methodId :" + bVar.f63887i);
        X(new d.a.s.a.c.b(), bVar, str);
    }

    public final void U(long j2, String str, String str2) {
        try {
            if (this.f63900f.size() <= 0 || !this.f63900f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.a.s.a.g.d.a("SocketTransceiver", "handle msg exception!!! " + this.f63900f.get(Long.valueOf(j2)).toString());
            d.a.s.a.c.b remove = this.f63900f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f63881c = 8005;
            remove.f63882d = "socket exception :" + str;
            X(remove, remove, str2);
        } catch (Exception e2) {
            d.a.s.a.g.d.a("SocketTransceiver", "handle msg exception!!! " + e2);
        }
    }

    public final void V(d.a.s.a.c.b bVar, String str) {
        int i2;
        int i3 = bVar.f63881c;
        if (i3 == 0) {
            long j2 = bVar.f63885g;
            long j3 = j2 > 0 ? j2 : 60000L;
            long j4 = bVar.f63887i;
            if (j4 == 1) {
                W(j3, true, str);
            } else if (j4 != 2) {
                if (j4 == 3) {
                    this.n.a(j3);
                }
            } else {
                j0("LCP logout:", str);
                C.f63860a = bVar.j;
                setChanged();
                notifyObservers(C);
                a0();
            }
        } else if (String.valueOf(i3).startsWith("30") || (i2 = bVar.f63881c) == 1011) {
            d.a.s.a.g.d.a("SocketTransceiver", "login error, then request token, error :" + bVar.f63881c);
            j0("errorCode:" + String.valueOf(bVar.f63881c), str);
            d.a.s.a.g.e.z(this.q, "");
            d.a.s.a.b.c.f().k();
        } else if (i2 == 1012) {
            d.a.s.a.g.d.a("SocketTransceiver", "login error :" + bVar.f63881c);
        } else if (i2 == 1013) {
            W(60000L, false, str);
        } else {
            C.f63860a = -1;
            setChanged();
            notifyObservers(C);
            a0();
            f0(true);
        }
    }

    public final void W(long j2, boolean z, String str) {
        try {
            this.p.set(0);
            C.f63860a = 0;
            setChanged();
            notifyObservers(C);
            a0();
            if (z) {
                this.u.a(str);
                this.u.postDelayed(this.n, j2);
                d.a.s.a.g.d.a("SocketTransceiver", "ping every 1分钟 ");
                d.a.s.a.a.d.w(this.q, "17Y", "login success");
                a.d dVar = new a.d(this.q);
                dVar.e("login ok");
                dVar.f("login");
                dVar.g(System.currentTimeMillis());
                dVar.h(System.currentTimeMillis());
                dVar.c(0L);
                dVar.d("");
                dVar.a(501111L);
                dVar.b();
            }
        } catch (Exception e2) {
            d.a.s.a.g.d.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public final void X(d.a.s.a.c.b bVar, d.a.s.a.c.b bVar2, String str) {
        long j2 = bVar.f63886h;
        if (j2 == 1) {
            V(bVar, str);
        } else if (j2 != -1) {
            b0(bVar);
        } else if (bVar2 == null) {
        } else {
            if (bVar2.f63886h == 1) {
                V(bVar2, str);
            } else {
                b0(bVar2);
            }
        }
    }

    public final void Y(long j2, String str) {
        try {
            if (this.f63900f.size() <= 0 || !this.f63900f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.a.s.a.g.d.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f63900f.get(Long.valueOf(j2)).toString());
            d.a.s.a.c.b remove = this.f63900f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f63881c = 8006;
            remove.f63882d = "socket stopped :";
            X(remove, remove, str);
        } catch (Exception e2) {
            d.a.s.a.g.d.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
        }
    }

    public final void Z(long j2, String str) {
        try {
            if (this.f63900f.size() <= 0 || !this.f63900f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.a.s.a.g.d.a("SocketTransceiver", "handle msg timeout!!! " + this.f63900f.get(Long.valueOf(j2)).toString());
            d.a.s.a.c.b remove = this.f63900f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f63881c = 8004;
            remove.f63882d = "socket timeout";
            X(remove, remove, str);
        } catch (Exception e2) {
            d.a.s.a.g.d.a("SocketTransceiver", "handle msg timeout!!! " + e2);
        }
    }

    public void a0() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", C.f63860a);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
    }

    public final synchronized void b0(d.a.s.a.c.b bVar) {
        d.a.s.a.b.d.b bVar2 = null;
        try {
            Long valueOf = Long.valueOf(!bVar.f63883e ? bVar.n : (bVar.f63886h * 10000) + bVar.f63887i);
            d.a.s.a.g.d.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
            if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                bVar2 = this.k.get(valueOf);
            } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                bVar2 = this.j.remove(valueOf);
            }
            if (bVar2 != null) {
                d.a.s.a.g.d.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.f63887i + ", serviceId :" + bVar.f63886h + ", error :" + bVar.f63881c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f63882d + ", invoke keys :" + this.j.keySet().toString());
                bVar2.onResponse(bVar.f63881c, bVar.f63882d, bVar.f63886h, bVar.f63887i, bVar.n, bVar.f63884f);
                if (bVar.f63881c == 1011) {
                    d.a.s.a.g.d.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f63881c + ", and will send lcm login msg .");
                    g0(this.f63903i.b(this.q, 1L));
                }
            }
        } catch (Exception e2) {
            d.a.s.a.g.d.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
        }
    }

    public void c0() {
        d.a.s.a.g.d.a("SocketTransceiver", "customPingRunnable send PingRequest ");
        g0(this.f63903i.b(this.q, 3L));
    }

    public final synchronized void d0() {
        this.z = System.currentTimeMillis();
        if (!this.x.isEmpty() && !this.y.isEmpty() && d.a.s.a.c.a.e()) {
            d.a.s.a.a.d.w(this.q, "10N_2", "connecting");
            M(this.x, this.y);
            return;
        }
        d.a.s.a.a.d.w(this.q, "10N_1", "connecting");
        d.a.s.a.g.d.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f63897c);
        String[] split = d.a.s.a.g.e.h(this.q, this.f63897c).split(":");
        if (split.length < 3) {
            return;
        }
        String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
        String str2 = split[1];
        String str3 = split[2];
        if (this.f63897c >= d.a.s.a.g.e.i(this.q)) {
            this.f63897c = 0;
            d.a.s.a.a.d.w(this.q, "10N_1", "connect failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
            d.a.s.a.g.d.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
            this.r = new d.a.s.a.c.g(this.q, "tls");
            this.x = "lcs.baidu.com";
            this.y = "443";
            M("lcs.baidu.com", "443");
            return;
        }
        if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
            this.r = new QuicMessageHandler(this.q);
        } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof d.a.s.a.c.g))) {
            this.r = new d.a.s.a.c.g(this.q, str);
        }
        this.f63897c++;
        if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            d.a.s.a.g.d.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
            this.x = str2;
            this.y = str3;
            M(str2, str3);
        } else {
            this.x = "";
            this.y = "";
            d0();
        }
    }

    public final void e0() {
        this.f63897c = 0;
        this.p.set(0);
        d.a.s.a.c.a.j();
    }

    public final void f0(boolean z) {
        try {
            this.p.incrementAndGet();
            if (this.p.get() > 10 || C.f63860a != -1) {
                return;
            }
            long L = L(this.p.get());
            this.u.removeCallbacks(this.n);
            this.u.removeCallbacks(z ? this.A : this.B);
            this.u.postDelayed(z ? this.B : this.A, L);
            StringBuilder sb = new StringBuilder();
            sb.append("Schedule retry ");
            sb.append(z ? "login" : "connect");
            sb.append(" -- retry times: ");
            sb.append(this.p.get());
            sb.append(" time delay: ");
            sb.append(L);
            d.a.s.a.g.d.d("SocketTransceiver", sb.toString());
        } catch (Exception e2) {
            d.a.s.a.g.d.c("SocketTransceiver", "retry Exception", e2);
        }
    }

    public final synchronized void g0(d.a.s.a.c.b bVar) {
        try {
        } catch (Exception e2) {
            d.a.s.a.g.d.c("SocketTransceiver", "sendMessage Exception :", e2);
        }
        synchronized (this.f63899e) {
            boolean z = false;
            Iterator<d.a.s.a.c.b> it = this.f63899e.iterator();
            while (it.hasNext()) {
                d.a.s.a.c.b next = it.next();
                d.a.s.a.g.d.a("SocketTransceiver", "sendMessage queue :" + next.n);
                if (next.l) {
                    z = true;
                }
            }
            if (bVar.l) {
                if (!z && C.f63860a == -1) {
                    this.f63899e.addFirst(bVar);
                    this.f63899e.notifyAll();
                    d.a.s.a.a.d.w(this.q, "16Y_2", "send Logig msg");
                }
                d.a.s.a.g.d.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + C.f63860a);
            } else if (C.f63860a == -1) {
                if (J()) {
                    if (this.f63899e.size() <= 0 || !z) {
                        this.f63899e.addFirst(this.f63903i.b(this.q, 1L));
                        this.f63899e.notifyAll();
                        d.a.s.a.a.d.w(this.q, "16Y_3", "heart rate and send Logig msg");
                    }
                    if (!bVar.k) {
                        this.f63899e.add(bVar);
                        this.f63899e.notifyAll();
                    }
                } else {
                    if (bVar.k) {
                        d0();
                    }
                    this.f63899e.add(bVar);
                }
            } else {
                this.f63899e.add(bVar);
                this.f63899e.notifyAll();
            }
        }
    }

    public final void h0(long j2, long j3, long j4, boolean z, d.a.s.a.b.d.b bVar) {
        Long valueOf = Long.valueOf(j4);
        if (!z) {
            this.j.put(valueOf, bVar);
        } else if (bVar != null) {
            this.k.put(valueOf, bVar);
        }
        d.a.s.a.g.d.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
    }

    public void i0() {
        if (d.a.s.a.g.e.m(this.q)) {
            e0();
            N();
        }
    }

    public synchronized void j0(String str, String str2) {
        if (d.a.s.a.g.e.m(this.q)) {
            d.a.s.a.g.d.d("SocketTransceiver", "---socketDisconnect---");
            this.o = true;
            this.f63898d = true;
            R(str2);
            e0();
            this.u.removeCallbacks(this.A);
            this.u.removeCallbacks(this.B);
            this.u.removeCallbacks(this.n);
            d.a.s.a.c.a.i(this.q, null, false);
            P(str, str2);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f63921e;

        public h() {
            this.f63921e = 60000L;
        }

        public void a(long j) {
            this.f63921e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.u.removeCallbacks(f.this.n);
            if (d.a.s.a.g.e.m(f.this.q)) {
                f.this.u.postDelayed(f.this.n, this.f63921e);
                f fVar = f.this;
                fVar.g0(fVar.f63903i.b(f.this.q, 3L));
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this();
        }
    }
}
