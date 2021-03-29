package d.b.g0.a.c0.e;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import d.b.g0.a.f2.e;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public class b {
    public static final boolean i = k.f45051a;
    public static final String j = d.b.g0.a.f2.d.f44463d.f44458a;
    public static final String k = d.b.g0.a.f2.d.f44461b.f44458a;
    public static final String l = d.b.g0.a.f2.d.f44462c.f44458a;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a  reason: collision with root package name */
    public e f43656a;

    /* renamed from: b  reason: collision with root package name */
    public f f43657b;

    /* renamed from: c  reason: collision with root package name */
    public c f43658c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0623b f43659d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f43660e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43661f;

    /* renamed from: g  reason: collision with root package name */
    public int f43662g;

    /* renamed from: h  reason: collision with root package name */
    public int f43663h;

    /* renamed from: d.b.g0.a.c0.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0623b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f43664e;

        public RunnableC0623b() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:4|(1:7)|8|(6:10|(1:13)|14|15|16|17)|(1:25)(1:30)|(1:29)|14|15|16|17) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
            if (d.b.g0.a.c0.e.b.i != false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
            android.util.Log.e("PropertyMonitor", "get CPU Fail : " + r12.getMessage());
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(BufferedReader bufferedReader) throws IOException {
            char read;
            boolean z;
            char[] cArr = new char[4];
            int i = 0;
            if (Build.VERSION.SDK_INT < 26) {
                int i2 = 0;
                do {
                    read = (char) bufferedReader.read();
                    if (read == ' ' || i2 == 4) {
                        i2 = 0;
                    } else {
                        cArr[i2] = read;
                        i2++;
                    }
                    if (read == '%') {
                        break;
                    }
                } while (read != 65535);
                return String.valueOf(cArr, 0, i2);
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                char read2 = (char) bufferedReader.read();
                if (z && read2 != ' ') {
                    i3++;
                }
                if (i3 == 9) {
                    if (read2 != '.' && read2 != ' ') {
                        cArr[i4] = read2;
                        i4++;
                    }
                    i = Integer.parseInt(String.valueOf(cArr, 0, i4)) / Runtime.getRuntime().availableProcessors();
                    return i + "%";
                }
                z = (i3 <= 9 && read2 != 65535 && i4 < 4) ? read2 == ' ' : true;
                i = Integer.parseInt(String.valueOf(cArr, 0, i4)) / Runtime.getRuntime().availableProcessors();
                return i + "%";
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            this.f43664e = true;
            if (b.i) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            BufferedReader bufferedReader2 = null;
            int myPid = Process.myPid();
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IXAdRequestInfo.SCREEN_HEIGHT, "-c", "top -n 1 | grep " + myPid}).getInputStream()));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String b2 = b(bufferedReader);
                b.this.f43660e.put("cpu", b2);
                if (b.i) {
                    Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + b2);
                }
                d.b.g0.p.d.a(bufferedReader);
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                if (b.i) {
                    Log.e("PropertyMonitor", "error in cpu monitor", e);
                }
                d.b.g0.p.d.a(bufferedReader2);
                this.f43664e = false;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                d.b.g0.p.d.a(bufferedReader2);
                this.f43664e = false;
                throw th;
            }
            this.f43664e = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: e  reason: collision with root package name */
        public long f43666e;

        /* renamed from: f  reason: collision with root package name */
        public int f43667f;

        public c() {
            this.f43666e = -1L;
            this.f43667f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.f43661f) {
                long j2 = this.f43666e;
                if (j2 > 0 && this.f43667f != (i = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f43667f = i;
                    b.this.f43660e.put("frame", Integer.valueOf(i));
                }
                this.f43666e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f43669a = new b();
    }

    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.f43660e != null) {
                b.this.g();
                b.this.f43660e.put("mem", Long.valueOf(((ActivityManager) d.b.g0.a.w0.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.f43656a != null) {
                    b.this.f43656a.sendEmptyMessageDelayed(0, b.this.f43662g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements e.b {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Set<d.b.g0.a.f2.c<?>> set) {
            if (set == null || set.size() <= 0) {
                return;
            }
            for (d.b.g0.a.f2.c<?> cVar : set) {
                b.this.f43660e.put(cVar.f44458a, cVar.a());
            }
        }
    }

    static {
        String str = d.b.g0.a.f2.d.f44466g.f44458a;
        m = d.b.g0.a.f2.d.i.f44458a;
        n = d.b.g0.a.f2.d.f44464e.f44458a;
        o = d.b.g0.a.f2.d.f44465f.f44458a;
        p = d.b.g0.a.f2.d.f44467h.f44458a;
        q = d.b.g0.a.f2.d.j.f44458a;
        r = d.b.g0.a.f2.d.k.f44458a;
    }

    public static b h() {
        return d.f43669a;
    }

    public final void g() {
        if (this.f43659d.f43664e) {
            return;
        }
        p.k(this.f43659d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        this.f43663h++;
        k();
        return this.f43660e;
    }

    public void j() {
        int i2 = this.f43663h - 1;
        this.f43663h = i2;
        if (i2 <= 0) {
            l();
        }
    }

    public final void k() {
        if (this.f43661f) {
            if (i) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.f43661f = true;
        this.f43658c = new c();
        Choreographer.getInstance().postFrameCallback(this.f43658c);
        this.f43659d = new RunnableC0623b();
        this.f43657b = new f();
        d.b.g0.a.f2.e.a().g(this.f43657b, d.b.g0.a.f2.d.f44463d, d.b.g0.a.f2.d.f44461b, d.b.g0.a.f2.d.f44462c, d.b.g0.a.f2.d.i, d.b.g0.a.f2.d.f44464e, d.b.g0.a.f2.d.f44465f, d.b.g0.a.f2.d.f44466g, d.b.g0.a.f2.d.f44467h, d.b.g0.a.f2.d.j, d.b.g0.a.f2.d.k);
        e eVar = new e();
        this.f43656a = eVar;
        eVar.sendEmptyMessage(0);
        if (i) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    public final void l() {
        if (!this.f43661f) {
            if (i) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.f43661f = false;
        e eVar = this.f43656a;
        if (eVar != null) {
            eVar.removeMessages(0);
            this.f43656a = null;
        }
        if (this.f43657b != null) {
            d.b.g0.a.f2.e.a().j(this.f43657b, new d.b.g0.a.f2.c[0]);
            this.f43657b = null;
        }
        this.f43658c = null;
        this.f43659d = null;
        if (i) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    public b() {
        this.f43660e = new ConcurrentHashMap();
        this.f43662g = 1000;
    }
}
