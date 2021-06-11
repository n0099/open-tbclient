package d.a.l0.a.e0.g;

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
import d.a.l0.a.k;
import d.a.l0.a.q2.e;
import d.a.l0.a.v2.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45160i = k.f46875a;
    public static final String j = d.a.l0.a.q2.d.f47905d.f47900a;
    public static final String k = d.a.l0.a.q2.d.f47903b.f47900a;
    public static final String l = d.a.l0.a.q2.d.f47904c.f47900a;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a  reason: collision with root package name */
    public e f45161a;

    /* renamed from: b  reason: collision with root package name */
    public f f45162b;

    /* renamed from: c  reason: collision with root package name */
    public c f45163c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0659b f45164d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f45165e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45166f;

    /* renamed from: g  reason: collision with root package name */
    public int f45167g;

    /* renamed from: h  reason: collision with root package name */
    public int f45168h;

    /* renamed from: d.a.l0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0659b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f45169e;

        public RunnableC0659b() {
        }

        public synchronized String b() {
            BufferedReader bufferedReader;
            IOException e2;
            if (b.f45160i) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IAdRequestParam.SCREEN_HEIGHT, "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
                try {
                    String c2 = c(bufferedReader);
                    if (b.f45160i) {
                        Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + c2);
                    }
                    d.a.l0.t.d.d(bufferedReader);
                    return c2;
                } catch (IOException e3) {
                    e2 = e3;
                    if (b.f45160i) {
                        Log.e("PropertyMonitor", "error in cpu monitor", e2);
                    }
                    d.a.l0.t.d.d(bufferedReader);
                    return "";
                }
            } catch (IOException e4) {
                bufferedReader = null;
                e2 = e4;
            } catch (Throwable th2) {
                th = th2;
                d.a.l0.t.d.d(null);
                throw th;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:4|(1:7)|8|(6:10|(1:13)|14|15|16|17)|(1:25)(1:30)|(1:29)|14|15|16|17) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
            if (d.a.l0.a.e0.g.b.f45160i != false) goto L23;
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
            this.f45169e = true;
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                b.this.f45165e.put("cpu", b2);
            }
            this.f45169e = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: e  reason: collision with root package name */
        public long f45171e;

        /* renamed from: f  reason: collision with root package name */
        public int f45172f;

        public c() {
            this.f45171e = -1L;
            this.f45172f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            if (b.this.f45166f) {
                long j2 = this.f45171e;
                if (j2 > 0 && this.f45172f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f45172f = i2;
                    b.this.f45165e.put("frame", Integer.valueOf(i2));
                }
                this.f45171e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f45174a = new b();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.f45165e != null) {
                b.this.g();
                b.this.f45165e.put("mem", Long.valueOf(((ActivityManager) d.a.l0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.f45161a != null) {
                    b.this.f45161a.sendEmptyMessageDelayed(0, b.this.f45167g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements e.b {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<d.a.l0.a.q2.c<?>> set) {
            if (set == null || set.size() <= 0) {
                return;
            }
            for (d.a.l0.a.q2.c<?> cVar : set) {
                b.this.f45165e.put(cVar.f47900a, cVar.a());
            }
        }
    }

    static {
        String str = d.a.l0.a.q2.d.f47908g.f47900a;
        m = d.a.l0.a.q2.d.f47910i.f47900a;
        n = d.a.l0.a.q2.d.f47906e.f47900a;
        o = d.a.l0.a.q2.d.f47907f.f47900a;
        p = d.a.l0.a.q2.d.f47909h.f47900a;
        q = d.a.l0.a.q2.d.j.f47900a;
        r = d.a.l0.a.q2.d.k.f47900a;
    }

    public static b h() {
        return d.f45174a;
    }

    public final void g() {
        if (this.f45164d.f45169e) {
            return;
        }
        q.j(this.f45164d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        this.f45168h++;
        k();
        return this.f45165e;
    }

    public void j() {
        int i2 = this.f45168h - 1;
        this.f45168h = i2;
        if (i2 <= 0) {
            l();
        }
    }

    public final void k() {
        if (this.f45166f) {
            if (f45160i) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.f45166f = true;
        this.f45163c = new c();
        Choreographer.getInstance().postFrameCallback(this.f45163c);
        this.f45164d = new RunnableC0659b();
        this.f45162b = new f();
        d.a.l0.a.q2.e.a().g(this.f45162b, d.a.l0.a.q2.d.f47905d, d.a.l0.a.q2.d.f47903b, d.a.l0.a.q2.d.f47904c, d.a.l0.a.q2.d.f47910i, d.a.l0.a.q2.d.f47906e, d.a.l0.a.q2.d.f47907f, d.a.l0.a.q2.d.f47908g, d.a.l0.a.q2.d.f47909h, d.a.l0.a.q2.d.j, d.a.l0.a.q2.d.k);
        e eVar = new e();
        this.f45161a = eVar;
        eVar.sendEmptyMessage(0);
        if (f45160i) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    public final void l() {
        if (!this.f45166f) {
            if (f45160i) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.f45166f = false;
        e eVar = this.f45161a;
        if (eVar != null) {
            eVar.removeMessages(0);
            this.f45161a = null;
        }
        if (this.f45162b != null) {
            d.a.l0.a.q2.e.a().j(this.f45162b, new d.a.l0.a.q2.c[0]);
            this.f45162b = null;
        }
        this.f45163c = null;
        this.f45164d = null;
        if (f45160i) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    public b() {
        this.f45165e = new ConcurrentHashMap();
        this.f45167g = 1000;
    }
}
