package d.b.r.a.c;

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
import d.b.r.a.a.a;
import d.b.r.a.c.a;
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
    public static volatile d.b.r.a.b.b C = new d.b.r.a.b.b();
    public static volatile f D;
    public j l;
    public i m;
    public Context q;
    public d.b.r.a.c.d r;
    public HandlerThread t;
    public g u;
    public long v;
    public long z;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Boolean> f65308a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f65309b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public int f65310c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65311d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile LinkedList<d.b.r.a.c.b> f65312e = new LinkedList<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<Long, d.b.r.a.c.b> f65313f = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Object f65314g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public final Object f65315h = new Object();
    public d.b.r.a.d.b i = new d.b.r.a.d.b();
    public Map<Long, d.b.r.a.b.d.b> j = new LinkedHashMap();
    public Map<Long, d.b.r.a.b.d.b> k = new LinkedHashMap();
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
        public final /* synthetic */ String f65316a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f65317b;

        public a(String str, String str2) {
            this.f65316a = str;
            this.f65317b = str2;
        }

        @Override // d.b.r.a.c.a.d
        public void a(int i, String str, String str2) {
            d.b.r.a.g.d.a("SocketTransceiver", "-----try to connect ip:" + str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f65316a;
            }
            f fVar = f.this;
            fVar.w = str2;
            Context context = fVar.q;
            d.b.r.a.a.d.w(context, "14N_0", "socketConnect :" + f.this.w);
            if (i == 0) {
                d.b.r.a.f.a a2 = d.b.r.a.f.a.a(f.this.q);
                f fVar2 = f.this;
                a2.b(new e(str2, this.f65317b, Integer.valueOf(fVar2.f65309b.incrementAndGet())));
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
            fVar.g0(fVar.i.b(f.this.q, 1L));
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65321a;

        static {
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            f65321a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65321a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65321a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f65321a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f65322e;

        /* renamed from: f  reason: collision with root package name */
        public String f65323f;

        /* renamed from: g  reason: collision with root package name */
        public Integer f65324g;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.r.a.g.c.c(f.this.q);
                d.b.r.a.g.c.e("lcp connect:" + (System.currentTimeMillis() - f.this.z));
            }
        }

        public e(String str, String str2, Integer num) {
            this.f65323f = str;
            this.f65322e = str2;
            this.f65324g = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
            } catch (Exception e2) {
                d.b.r.a.g.d.c("SocketTransceiver", "connectRunnable", e2);
                d.b.r.a.a.d.w(f.this.q, "16N", "connect exception");
            }
            if (!f.this.J()) {
                if (f.this.m != null && f.this.m.isAlive()) {
                    f.this.m.interrupt();
                    d.b.r.a.g.d.a("SocketTransceiver", "readThread interrupt");
                }
                if (f.this.l != null && f.this.l.isAlive()) {
                    f.this.l.interrupt();
                    d.b.r.a.g.d.a("SocketTransceiver", "sendThread interrupt");
                }
                RunnableC1782f runnableC1782f = new RunnableC1782f(this.f65324g, this.f65323f);
                f.this.u.a(this.f65323f);
                f.this.u.postDelayed(runnableC1782f, 5000L);
                try {
                    d.b.r.a.a.d.w(f.this.q, "14N", "socketConnect :" + f.this.w);
                    d.b.r.a.c.e e3 = f.this.r.e(this.f65323f, Integer.valueOf(this.f65322e).intValue());
                    if (f.this.J()) {
                        d.b.r.a.g.d.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                        f.this.K(e3);
                        return;
                    } else if (!e3.f65304b.booleanValue()) {
                        d.b.r.a.a.d.w(f.this.q, "15N", "connect env error");
                        f.this.O(401213, "connect env error", this.f65323f);
                        f.this.u.removeCallbacks(runnableC1782f);
                        f.this.j0("connect env error:", this.f65323f);
                        return;
                    } else {
                        synchronized (f.this.f65308a) {
                            d.b.r.a.g.d.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                            f.this.u.removeCallbacks(runnableC1782f);
                            runnableC1782f.a();
                            if (!f.this.J()) {
                                if (f.this.f65308a.get(this.f65324g) == null) {
                                    d.b.r.a.g.d.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                    f.this.r.c(e3);
                                }
                                d.b.r.a.g.e.B(f.this.q, f.this.p.get() == 0 ? 1 : 2);
                                d.b.r.a.g.d.d("SocketTransceiver", "create Socket ok");
                                f.this.O(401211, "connect ok", this.f65323f);
                                d.b.r.a.a.d.w(f.this.q, "16Y", "connect ok");
                                d.b.r.a.c.a.h(f.this.q, this.f65323f);
                                f.this.g0(f.this.i.b(f.this.q, 1L));
                                f.this.v = SystemClock.currentThreadTimeMillis();
                                if (d.b.r.a.g.b.a(f.this.q) != 0) {
                                    d.b.r.a.f.a.a(f.this.q).b(new a());
                                }
                                d.b.r.a.g.d.a("SocketTransceiver", "connectImpl time:" + f.this.v);
                                f.C.f65275a = -2;
                                f.this.o = false;
                                f.this.l = new j(this.f65323f);
                                f.this.l.start();
                                f.this.m = new i(this.f65323f);
                                f.this.m.start();
                                return;
                            }
                            d.b.r.a.g.d.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                            f.this.K(e3);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    String str = "Throwable : " + th;
                    d.b.r.a.g.d.c("SocketTransceiver", str, th);
                    d.b.r.a.a.d.w(f.this.q, "16N", str);
                    f.this.O(401215, str, this.f65323f);
                    f.this.u.removeCallbacks(runnableC1782f);
                    runnableC1782f.a();
                    synchronized (f.this.f65308a) {
                        if (f.this.f65308a.get(this.f65324g) != null) {
                            f.this.f65308a.remove(this.f65324g);
                            return;
                        }
                        f.this.Q("ConnectTask exception:" + str, this.f65323f);
                        return;
                    }
                }
            }
            d.b.r.a.g.d.a("SocketTransceiver", "socket create begin, but socket has created ok.");
        }
    }

    /* renamed from: d.b.r.a.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1782f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Integer f65327e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65328f = false;

        /* renamed from: g  reason: collision with root package name */
        public String f65329g;

        public RunnableC1782f(Integer num, String str) {
            this.f65327e = num;
            this.f65329g = str;
        }

        public void a() {
            this.f65328f = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f65308a) {
                if (!this.f65328f && f.C.f65275a != 0) {
                    f.this.f65308a.put(this.f65327e, Boolean.TRUE);
                    Context context = f.this.q;
                    d.b.r.a.a.d.w(context, "14N_1", "socketConnect_timeout :" + f.this.w);
                    f.this.O(401214, "time out", this.f65329g);
                    f.this.Q("time out:", this.f65329g);
                    return;
                }
                d.b.r.a.g.d.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.u.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public String f65331a;

        public g(Looper looper) {
            super(looper);
        }

        public void a(String str) {
            this.f65331a = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            long j = message.arg1;
            synchronized (f.this.f65315h) {
                f.this.Z(j, this.f65331a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public String f65335e;

        public i(String str) {
            this.f65335e = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.b.r.a.c.b bVar;
            while (!f.this.o) {
                try {
                    try {
                        d.b.r.a.c.b c2 = f.this.i.c(f.this.r.b());
                        if (c2 != null && c2.n > 0) {
                            f.this.u.removeCallbacks(f.this.s);
                            c2.m = false;
                            d.b.r.a.g.d.d("SocketTransceiver", "ReadThread :" + c2.toString());
                            if (!c2.k) {
                                if (c2.l) {
                                    d.b.r.a.a.d.w(f.this.q, "17N_1", "Read LoginMsg Response");
                                }
                                if (c2.i == 1 && c2.f65300h == 4) {
                                    Context context = f.this.q;
                                    d.b.r.a.g.a.a(context, 1L, "read", c2.n + "");
                                }
                                if (c2.i == 50 && c2.f65300h == 2) {
                                    Context context2 = f.this.q;
                                    d.b.r.a.g.a.a(context2, 50L, "read", c2.n + "");
                                }
                                synchronized (f.this.f65315h) {
                                    d.b.r.a.g.d.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                    bVar = (d.b.r.a.c.b) f.this.f65313f.remove(Long.valueOf(c2.n));
                                }
                                f.this.X(c2, bVar, this.f65335e);
                            }
                            synchronized (f.this.f65315h) {
                                if (f.this.f65313f.size() != 0) {
                                    d.b.r.a.g.d.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.s.b(c2.n);
                                    f.this.s.a(this.f65335e);
                                    f.this.u.a(this.f65335e);
                                    f.this.u.postDelayed(f.this.s, c2.f65294b);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (f.this.o) {
                            return;
                        }
                        d.b.r.a.g.d.c("SocketTransceiver", "ReadThread exception: " + e2, e2);
                        f.this.f65311d = false;
                        f fVar = f.this;
                        fVar.Q("ReadThread exception: " + e2, this.f65335e);
                        return;
                    }
                } catch (Exception e3) {
                    if (f.this.o) {
                        return;
                    }
                    d.b.r.a.g.d.c("SocketTransceiver", "onStartCommand", e3);
                    f.this.f65311d = false;
                    f fVar2 = f.this;
                    fVar2.Q("onStartCommand:" + e3, this.f65335e);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public String f65337e;

        public j(String str) {
            this.f65337e = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!f.this.o) {
                try {
                    d.b.r.a.c.b bVar = null;
                    try {
                        synchronized (f.this.f65312e) {
                            if (f.this.f65312e.size() == 0) {
                                f.this.f65312e.wait();
                            } else {
                                bVar = (d.b.r.a.c.b) f.this.f65312e.removeFirst();
                            }
                        }
                    } catch (InterruptedException e2) {
                        d.b.r.a.g.d.b("SocketTransceiver", "SendThread wait exception: " + e2);
                        f fVar = f.this;
                        fVar.Q("SendThread wait exception: " + e2, this.f65337e);
                    }
                    if (bVar != null) {
                        try {
                            if (f.this.o) {
                                f.this.Y(bVar.n, this.f65337e);
                                return;
                            }
                            bVar.m = true;
                            bVar.j = f.C.f65275a;
                            if (bVar.o) {
                                synchronized (f.this.f65315h) {
                                    if (f.this.f65313f.isEmpty()) {
                                        f.this.u.removeCallbacks(f.this.s);
                                        f.this.s.b(bVar.n);
                                        f.this.s.a(this.f65337e);
                                        f.this.u.a(this.f65337e);
                                        f.this.u.postDelayed(f.this.s, 5000L);
                                    }
                                }
                            }
                            d.b.r.a.g.d.e("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.l) {
                                d.b.r.a.a.d.w(f.this.q, "17N", "Send LoginMsg request");
                            }
                            if (bVar.i == 1 && bVar.f65300h == 4) {
                                Context context = f.this.q;
                                d.b.r.a.g.a.a(context, 1L, "send", bVar.n + "");
                            }
                            if (bVar.i == 50 && bVar.f65300h == 2) {
                                Context context2 = f.this.q;
                                d.b.r.a.g.a.a(context2, 50L, "send", bVar.n + "");
                            }
                            synchronized (f.this.f65314g) {
                                f.this.r.f(bVar);
                            }
                            if (!bVar.k && bVar.o) {
                                synchronized (f.this.f65315h) {
                                    f.this.f65313f.put(Long.valueOf(bVar.n), bVar);
                                }
                            }
                        } catch (Exception e3) {
                            d.b.r.a.g.d.c("SocketTransceiver", "SendThread sendMessage Exception:", e3);
                            f.this.U(bVar.n, e3.toString(), this.f65337e);
                            f fVar2 = f.this;
                            fVar2.Q("SendThread sendMessage Exception:" + e3, this.f65337e);
                            return;
                        }
                    }
                } catch (Exception e4) {
                    d.b.r.a.g.d.c("SocketTransceiver", "SendThread Exception:", e4);
                    f fVar3 = f.this;
                    fVar3.Q("SendThread Exception:" + e4, this.f65337e);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f65339e;

        /* renamed from: f  reason: collision with root package name */
        public String f65340f;

        public k() {
        }

        public void a(String str) {
            this.f65340f = str;
        }

        public void b(long j) {
            this.f65339e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.Z(this.f65339e, this.f65340f);
            f.this.Q("read and write thread timeout:", this.f65340f);
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

    public synchronized void I(BLCPRequest bLCPRequest, d.b.r.a.b.d.b bVar) {
        if (d.b.r.a.g.e.m(this.q)) {
            d.b.r.a.c.b bVar2 = new d.b.r.a.c.b();
            bVar2.f65300h = bLCPRequest.f6413a;
            bVar2.i = bLCPRequest.f6414b;
            bVar2.f65293a = bLCPRequest.f6415c;
            if (bLCPRequest.f6416d < 0) {
                bVar2.n = System.currentTimeMillis();
            } else {
                bVar2.n = bLCPRequest.f6416d;
            }
            int i2 = d.f65321a[bLCPRequest.f6417e.ordinal()];
            if (i2 == 1) {
                bVar2.f65294b = 20000L;
            } else if (i2 == 2) {
                bVar2.f65294b = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
            } else if (i2 != 3) {
                bVar2.f65294b = 5000L;
            } else {
                bVar2.f65294b = 50000L;
            }
            if (bLCPRequest instanceof d.b.r.a.b.d.a) {
                long j2 = (bVar2.f65300h * 10000) + bVar2.i;
                bVar2.n = j2;
                h0(bVar2.f65300h, bVar2.i, j2, true, bVar);
            } else {
                h0(bVar2.f65300h, bVar2.i, bVar2.n, false, bVar);
                this.i.a(bVar2, true);
                g0(bVar2);
            }
        }
    }

    public final boolean J() {
        d.b.r.a.c.d dVar = this.r;
        return (dVar == null || dVar.a() == null || this.r.a().f65305c == null || !this.r.a().f65305c.isConnected()) ? false : true;
    }

    public final void K(d.b.r.a.c.e eVar) {
        if (eVar == null || !eVar.f65303a.booleanValue()) {
            return;
        }
        try {
            if (eVar.f65305c != null) {
                if (eVar.f65305c.hashCode() == this.r.a().f65305c.hashCode()) {
                    d.b.r.a.g.d.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                    return;
                }
                eVar.f65305c.close();
                eVar.f65305c = null;
                if (eVar.f65306d != null) {
                    eVar.f65306d.close();
                    eVar.f65306d = null;
                }
                if (eVar.f65307e != null) {
                    eVar.f65307e.close();
                    eVar.f65307e = null;
                }
                d.b.r.a.g.d.a("SocketTransceiver", "closeExistedConnection ok");
            }
        } catch (IOException e2) {
            d.b.r.a.g.d.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
        }
    }

    public final long L(int i2) {
        if (i2 < 3) {
            return i2 * 1000;
        }
        return 3000L;
    }

    public final synchronized void M(String str, String str2) {
        d.b.r.a.a.d.w(this.q, "10Y", "DNS begin");
        d.b.r.a.c.a.d(this.q).b(str, new a(str, str2));
    }

    public final synchronized void N() {
        if (!RequsetNetworkUtils.isConnected(this.q)) {
            e0();
            return;
        }
        if (C.f65275a != 0 && C.f65275a != -2) {
            d.b.r.a.a.d.w(this.q, "10N_0", "connect begin");
            this.u.removeCallbacks(this.A);
            this.u.removeCallbacks(this.B);
            this.u.removeCallbacks(this.n);
            d0();
            return;
        }
        d.b.r.a.g.d.d("SocketTransceiver", "connectImpl connect state:" + C.f65275a);
        Context context = this.q;
        d.b.r.a.a.d.w(context, "17N_2", "connectState is " + C.f65275a);
    }

    public final void O(int i2, String str, String str2) {
        this.w += ":" + d.b.r.a.c.a.c() + ":" + RequsetNetworkUtils.getNetInfo(this.q);
        d.b.r.a.g.d.a("SocketTransceiver", "connectTrack ext:" + this.w + ", retry :" + this.p.get() + ", reason :" + str);
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
        if (d.b.r.a.a.d.i(this.q, 401216) && this.p.get() >= 5 && i2 != 401211) {
            d.b.r.a.a.b.j(this.q, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.v).setStopTime(System.currentTimeMillis()).setAliasId(401216L).setReason(str).setExt(str2).setRetryCount(this.p.get()).build()).build());
        }
        this.w = "";
    }

    public final synchronized void P(String str, String str2) {
        if (d.b.r.a.g.e.m(this.q)) {
            d.b.r.a.g.d.d("SocketTransceiver", "destroy");
            O(401212, "connect stop, " + str, str2);
            C.f65275a = -1;
            setChanged();
            notifyObservers(C);
            a0();
            this.u.removeCallbacks(this.s);
            this.o = true;
            if (this.r != null) {
                synchronized (this.f65312e) {
                    this.f65312e.notifyAll();
                    d.b.r.a.g.d.d("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.r.d();
                    d.b.r.a.g.d.a("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.r.c(null);
                    d.b.r.a.g.d.c("SocketTransceiver", "Exception destroy:", e2);
                }
            }
        }
    }

    public final synchronized void Q(String str, String str2) {
        d.b.r.a.g.d.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.f65311d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + d.b.r.a.g.e.m(this.q));
        if (d.b.r.a.g.e.m(this.q)) {
            R(str2);
            if (this.f65311d) {
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
            d.b.r.a.g.d.a("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.f65312e) {
                while (this.f65312e.size() > 0) {
                    S(this.f65312e.removeFirst(), str);
                }
                d.b.r.a.g.d.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.f65315h) {
                d.b.r.a.g.d.a("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.f65313f.keySet()) {
                    S(this.f65313f.get(l), str);
                }
                this.f65313f.clear();
                d.b.r.a.g.d.a("SocketTransceiver", "fatalAllMessage mSync end");
            }
        } catch (Exception e2) {
            d.b.r.a.g.d.c("SocketTransceiver", "fatalAllMessage Exception", e2);
        }
    }

    public final void S(d.b.r.a.c.b bVar, String str) {
        if (bVar == null || bVar.f65300h == 1) {
            return;
        }
        d.b.r.a.g.d.b("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.n + ", serviceId :" + bVar.f65300h + ", methodId :" + bVar.i);
        X(new d.b.r.a.c.b(), bVar, str);
    }

    public final void U(long j2, String str, String str2) {
        try {
            if (this.f65313f.size() <= 0 || !this.f65313f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.b.r.a.g.d.a("SocketTransceiver", "handle msg exception!!! " + this.f65313f.get(Long.valueOf(j2)).toString());
            d.b.r.a.c.b remove = this.f65313f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f65295c = 8005;
            remove.f65296d = "socket exception :" + str;
            X(remove, remove, str2);
        } catch (Exception e2) {
            d.b.r.a.g.d.a("SocketTransceiver", "handle msg exception!!! " + e2);
        }
    }

    public final void V(d.b.r.a.c.b bVar, String str) {
        int i2;
        int i3 = bVar.f65295c;
        if (i3 == 0) {
            long j2 = bVar.f65299g;
            long j3 = j2 > 0 ? j2 : 60000L;
            long j4 = bVar.i;
            if (j4 == 1) {
                W(j3, true, str);
            } else if (j4 != 2) {
                if (j4 == 3) {
                    this.n.a(j3);
                }
            } else {
                j0("LCP logout:", str);
                C.f65275a = bVar.j;
                setChanged();
                notifyObservers(C);
                a0();
            }
        } else if (String.valueOf(i3).startsWith("30") || (i2 = bVar.f65295c) == 1011) {
            d.b.r.a.g.d.a("SocketTransceiver", "login error, then request token, error :" + bVar.f65295c);
            j0("errorCode:" + String.valueOf(bVar.f65295c), str);
            d.b.r.a.g.e.z(this.q, "");
            d.b.r.a.b.c.f().k();
        } else if (i2 == 1012) {
            d.b.r.a.g.d.a("SocketTransceiver", "login error :" + bVar.f65295c);
        } else if (i2 == 1013) {
            W(60000L, false, str);
        } else {
            C.f65275a = -1;
            setChanged();
            notifyObservers(C);
            a0();
            f0(true);
        }
    }

    public final void W(long j2, boolean z, String str) {
        try {
            this.p.set(0);
            C.f65275a = 0;
            setChanged();
            notifyObservers(C);
            a0();
            if (z) {
                this.u.a(str);
                this.u.postDelayed(this.n, j2);
                d.b.r.a.g.d.a("SocketTransceiver", "ping every 1分钟 ");
                d.b.r.a.a.d.w(this.q, "17Y", "login success");
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
            d.b.r.a.g.d.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public final void X(d.b.r.a.c.b bVar, d.b.r.a.c.b bVar2, String str) {
        long j2 = bVar.f65300h;
        if (j2 == 1) {
            V(bVar, str);
        } else if (j2 != -1) {
            b0(bVar);
        } else if (bVar2 == null) {
        } else {
            if (bVar2.f65300h == 1) {
                V(bVar2, str);
            } else {
                b0(bVar2);
            }
        }
    }

    public final void Y(long j2, String str) {
        try {
            if (this.f65313f.size() <= 0 || !this.f65313f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.b.r.a.g.d.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f65313f.get(Long.valueOf(j2)).toString());
            d.b.r.a.c.b remove = this.f65313f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f65295c = 8006;
            remove.f65296d = "socket stopped :";
            X(remove, remove, str);
        } catch (Exception e2) {
            d.b.r.a.g.d.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
        }
    }

    public final void Z(long j2, String str) {
        try {
            if (this.f65313f.size() <= 0 || !this.f65313f.containsKey(Long.valueOf(j2))) {
                return;
            }
            d.b.r.a.g.d.a("SocketTransceiver", "handle msg timeout!!! " + this.f65313f.get(Long.valueOf(j2)).toString());
            d.b.r.a.c.b remove = this.f65313f.remove(Long.valueOf(j2));
            if (remove == null) {
                return;
            }
            remove.f65295c = 8004;
            remove.f65296d = "socket timeout";
            X(remove, remove, str);
        } catch (Exception e2) {
            d.b.r.a.g.d.a("SocketTransceiver", "handle msg timeout!!! " + e2);
        }
    }

    public void a0() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", C.f65275a);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
    }

    public final synchronized void b0(d.b.r.a.c.b bVar) {
        d.b.r.a.b.d.b bVar2 = null;
        try {
            Long valueOf = Long.valueOf(!bVar.f65297e ? bVar.n : (bVar.f65300h * 10000) + bVar.i);
            d.b.r.a.g.d.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
            if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                bVar2 = this.k.get(valueOf);
            } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                bVar2 = this.j.remove(valueOf);
            }
            if (bVar2 != null) {
                d.b.r.a.g.d.a("SocketTransceiver", "onBLCPResponse methodId :" + bVar.i + ", serviceId :" + bVar.f65300h + ", error :" + bVar.f65295c + ", msgId :" + bVar.n + ", errMsg :" + bVar.f65296d + ", invoke keys :" + this.j.keySet().toString());
                bVar2.onResponse(bVar.f65295c, bVar.f65296d, bVar.f65300h, bVar.i, bVar.n, bVar.f65298f);
                if (bVar.f65295c == 1011) {
                    d.b.r.a.g.d.a("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.f65295c + ", and will send lcm login msg .");
                    g0(this.i.b(this.q, 1L));
                }
            }
        } catch (Exception e2) {
            d.b.r.a.g.d.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
        }
    }

    public void c0() {
        d.b.r.a.g.d.a("SocketTransceiver", "customPingRunnable send PingRequest ");
        g0(this.i.b(this.q, 3L));
    }

    public final synchronized void d0() {
        this.z = System.currentTimeMillis();
        if (!this.x.isEmpty() && !this.y.isEmpty() && d.b.r.a.c.a.e()) {
            d.b.r.a.a.d.w(this.q, "10N_2", "connecting");
            M(this.x, this.y);
            return;
        }
        d.b.r.a.a.d.w(this.q, "10N_1", "connecting");
        d.b.r.a.g.d.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.f65310c);
        String[] split = d.b.r.a.g.e.h(this.q, this.f65310c).split(":");
        if (split.length < 3) {
            return;
        }
        String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
        String str2 = split[1];
        String str3 = split[2];
        if (this.f65310c >= d.b.r.a.g.e.i(this.q)) {
            this.f65310c = 0;
            d.b.r.a.a.d.w(this.q, "10N_1", "connect failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
            d.b.r.a.g.d.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
            this.r = new d.b.r.a.c.g(this.q, "tls");
            this.x = "lcs.baidu.com";
            this.y = "443";
            M("lcs.baidu.com", "443");
            return;
        }
        if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
            this.r = new QuicMessageHandler(this.q);
        } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof d.b.r.a.c.g))) {
            this.r = new d.b.r.a.c.g(this.q, str);
        }
        this.f65310c++;
        if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            d.b.r.a.g.d.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
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
        this.f65310c = 0;
        this.p.set(0);
        d.b.r.a.c.a.j();
    }

    public final void f0(boolean z) {
        try {
            this.p.incrementAndGet();
            if (this.p.get() > 10 || C.f65275a != -1) {
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
            d.b.r.a.g.d.d("SocketTransceiver", sb.toString());
        } catch (Exception e2) {
            d.b.r.a.g.d.c("SocketTransceiver", "retry Exception", e2);
        }
    }

    public final synchronized void g0(d.b.r.a.c.b bVar) {
        try {
        } catch (Exception e2) {
            d.b.r.a.g.d.c("SocketTransceiver", "sendMessage Exception :", e2);
        }
        synchronized (this.f65312e) {
            boolean z = false;
            Iterator<d.b.r.a.c.b> it = this.f65312e.iterator();
            while (it.hasNext()) {
                d.b.r.a.c.b next = it.next();
                d.b.r.a.g.d.a("SocketTransceiver", "sendMessage queue :" + next.n);
                if (next.l) {
                    z = true;
                }
            }
            if (bVar.l) {
                if (!z && C.f65275a == -1) {
                    this.f65312e.addFirst(bVar);
                    this.f65312e.notifyAll();
                    d.b.r.a.a.d.w(this.q, "16Y_2", "send Logig msg");
                }
                d.b.r.a.g.d.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + C.f65275a);
            } else if (C.f65275a == -1) {
                if (J()) {
                    if (this.f65312e.size() <= 0 || !z) {
                        this.f65312e.addFirst(this.i.b(this.q, 1L));
                        this.f65312e.notifyAll();
                        d.b.r.a.a.d.w(this.q, "16Y_3", "heart rate and send Logig msg");
                    }
                    if (!bVar.k) {
                        this.f65312e.add(bVar);
                        this.f65312e.notifyAll();
                    }
                } else {
                    if (bVar.k) {
                        d0();
                    }
                    this.f65312e.add(bVar);
                }
            } else {
                this.f65312e.add(bVar);
                this.f65312e.notifyAll();
            }
        }
    }

    public final void h0(long j2, long j3, long j4, boolean z, d.b.r.a.b.d.b bVar) {
        Long valueOf = Long.valueOf(j4);
        if (!z) {
            this.j.put(valueOf, bVar);
        } else if (bVar != null) {
            this.k.put(valueOf, bVar);
        }
        d.b.r.a.g.d.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
    }

    public void i0() {
        if (d.b.r.a.g.e.m(this.q)) {
            e0();
            N();
        }
    }

    public synchronized void j0(String str, String str2) {
        if (d.b.r.a.g.e.m(this.q)) {
            d.b.r.a.g.d.d("SocketTransceiver", "---socketDisconnect---");
            this.o = true;
            this.f65311d = true;
            R(str2);
            e0();
            this.u.removeCallbacks(this.A);
            this.u.removeCallbacks(this.B);
            this.u.removeCallbacks(this.n);
            d.b.r.a.c.a.i(this.q, null, false);
            P(str, str2);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f65333e;

        public h() {
            this.f65333e = 60000L;
        }

        public void a(long j) {
            this.f65333e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.u.removeCallbacks(f.this.n);
            if (d.b.r.a.g.e.m(f.this.q)) {
                f.this.u.postDelayed(f.this.n, this.f65333e);
                f fVar = f.this;
                fVar.g0(fVar.i.b(f.this.q, 3L));
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this();
        }
    }
}
