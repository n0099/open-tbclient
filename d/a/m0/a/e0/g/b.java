package d.a.m0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.a.m0.a.k;
import d.a.m0.a.q2.e;
import d.a.m0.a.v2.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45268i = k.f46983a;
    public static final String j = d.a.m0.a.q2.d.f48013d.f48008a;
    public static final String k = d.a.m0.a.q2.d.f48011b.f48008a;
    public static final String l = d.a.m0.a.q2.d.f48012c.f48008a;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a  reason: collision with root package name */
    public e f45269a;

    /* renamed from: b  reason: collision with root package name */
    public f f45270b;

    /* renamed from: c  reason: collision with root package name */
    public c f45271c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0662b f45272d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f45273e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45274f;

    /* renamed from: g  reason: collision with root package name */
    public int f45275g;

    /* renamed from: h  reason: collision with root package name */
    public int f45276h;

    /* renamed from: d.a.m0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0662b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f45277e;

        public RunnableC0662b() {
        }

        public synchronized String b() {
            BufferedReader bufferedReader;
            Throwable th;
            IOException e2;
            if (b.f45268i) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IAdRequestParam.SCREEN_HEIGHT, "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
                try {
                    try {
                        String c2 = c(bufferedReader);
                        if (b.f45268i) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + c2);
                        }
                        d.a.m0.t.d.d(bufferedReader);
                        return c2;
                    } catch (IOException e3) {
                        e2 = e3;
                        if (b.f45268i) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e2);
                        }
                        d.a.m0.t.d.d(bufferedReader);
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    d.a.m0.t.d.d(bufferedReader);
                    throw th;
                }
            } catch (IOException e4) {
                bufferedReader = null;
                e2 = e4;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                d.a.m0.t.d.d(bufferedReader);
                throw th;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:4|(1:7)|8|(6:10|(1:13)|14|15|16|17)|(1:25)(1:30)|(1:29)|14|15|16|17) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
            if (d.a.m0.a.e0.g.b.f45268i != false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
            android.util.Log.e("PropertyMonitor", "get CPU Fail : " + r12.getMessage());
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String c(BufferedReader bufferedReader) throws IOException {
            char read;
            boolean z;
            char[] cArr = new char[4];
            int i2 = 0;
            if (Build.VERSION.SDK_INT < 26) {
                int i3 = 0;
                do {
                    read = (char) bufferedReader.read();
                    if (read == ' ' || i3 == 4) {
                        i3 = 0;
                    } else {
                        cArr[i3] = read;
                        i3++;
                    }
                    if (read == '%') {
                        break;
                    }
                } while (read != 65535);
                return String.valueOf(cArr, 0, i3);
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                char read2 = (char) bufferedReader.read();
                if (z && read2 != ' ') {
                    i4++;
                }
                if (i4 == 9) {
                    if (read2 != '.' && read2 != ' ') {
                        cArr[i5] = read2;
                        i5++;
                    }
                    i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                    return i2 + "%";
                }
                z = (i4 <= 9 && read2 != 65535 && i5 < 4) ? read2 == ' ' : true;
                i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                return i2 + "%";
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45277e = true;
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                b.this.f45273e.put("cpu", b2);
            }
            this.f45277e = false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: e  reason: collision with root package name */
        public long f45279e;

        /* renamed from: f  reason: collision with root package name */
        public int f45280f;

        public c() {
            this.f45279e = -1L;
            this.f45280f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            if (b.this.f45274f) {
                long j2 = this.f45279e;
                if (j2 > 0 && this.f45280f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f45280f = i2;
                    b.this.f45273e.put("frame", Integer.valueOf(i2));
                }
                this.f45279e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f45282a = new b();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.f45273e != null) {
                b.this.g();
                b.this.f45273e.put("mem", Long.valueOf(((ActivityManager) d.a.m0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.f45269a != null) {
                    b.this.f45269a.sendEmptyMessageDelayed(0, b.this.f45275g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements e.b {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<d.a.m0.a.q2.c<?>> set) {
            if (set == null || set.size() <= 0) {
                return;
            }
            for (d.a.m0.a.q2.c<?> cVar : set) {
                b.this.f45273e.put(cVar.f48008a, cVar.a());
            }
        }
    }

    static {
        String str = d.a.m0.a.q2.d.f48016g.f48008a;
        m = d.a.m0.a.q2.d.f48018i.f48008a;
        n = d.a.m0.a.q2.d.f48014e.f48008a;
        o = d.a.m0.a.q2.d.f48015f.f48008a;
        p = d.a.m0.a.q2.d.f48017h.f48008a;
        q = d.a.m0.a.q2.d.j.f48008a;
        r = d.a.m0.a.q2.d.k.f48008a;
    }

    public static b h() {
        return d.f45282a;
    }

    public final void g() {
        if (this.f45272d.f45277e) {
            return;
        }
        q.j(this.f45272d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        this.f45276h++;
        k();
        return this.f45273e;
    }

    public void j() {
        int i2 = this.f45276h - 1;
        this.f45276h = i2;
        if (i2 <= 0) {
            l();
        }
    }

    public final void k() {
        if (this.f45274f) {
            if (f45268i) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.f45274f = true;
        this.f45271c = new c();
        Choreographer.getInstance().postFrameCallback(this.f45271c);
        this.f45272d = new RunnableC0662b();
        this.f45270b = new f();
        d.a.m0.a.q2.e.a().g(this.f45270b, d.a.m0.a.q2.d.f48013d, d.a.m0.a.q2.d.f48011b, d.a.m0.a.q2.d.f48012c, d.a.m0.a.q2.d.f48018i, d.a.m0.a.q2.d.f48014e, d.a.m0.a.q2.d.f48015f, d.a.m0.a.q2.d.f48016g, d.a.m0.a.q2.d.f48017h, d.a.m0.a.q2.d.j, d.a.m0.a.q2.d.k);
        e eVar = new e();
        this.f45269a = eVar;
        eVar.sendEmptyMessage(0);
        if (f45268i) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    public final void l() {
        if (!this.f45274f) {
            if (f45268i) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.f45274f = false;
        e eVar = this.f45269a;
        if (eVar != null) {
            eVar.removeMessages(0);
            this.f45269a = null;
        }
        if (this.f45270b != null) {
            d.a.m0.a.q2.e.a().j(this.f45270b, new d.a.m0.a.q2.c[0]);
            this.f45270b = null;
        }
        this.f45271c = null;
        this.f45272d = null;
        if (f45268i) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    public b() {
        this.f45273e = new ConcurrentHashMap();
        this.f45275g = 1000;
    }
}
