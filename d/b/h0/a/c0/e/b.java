package d.b.h0.a.c0.e;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.b.h0.a.f2.e;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public class b {
    public static final boolean i = k.f45772a;
    public static final String j = d.b.h0.a.f2.d.f45184d.f45179a;
    public static final String k = d.b.h0.a.f2.d.f45182b.f45179a;
    public static final String l = d.b.h0.a.f2.d.f45183c.f45179a;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a  reason: collision with root package name */
    public e f44377a;

    /* renamed from: b  reason: collision with root package name */
    public f f44378b;

    /* renamed from: c  reason: collision with root package name */
    public c f44379c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0655b f44380d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f44381e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44382f;

    /* renamed from: g  reason: collision with root package name */
    public int f44383g;

    /* renamed from: h  reason: collision with root package name */
    public int f44384h;

    /* renamed from: d.b.h0.a.c0.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0655b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f44385e;

        public RunnableC0655b() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:4|(1:7)|8|(6:10|(1:13)|14|15|16|17)|(1:25)(1:30)|(1:29)|14|15|16|17) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
            if (d.b.h0.a.c0.e.b.i != false) goto L23;
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
            this.f44385e = true;
            if (b.i) {
                Log.d("PropertyMonitor", "start cpu monitor thread");
            }
            BufferedReader bufferedReader2 = null;
            int myPid = Process.myPid();
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IAdRequestParam.SCREEN_HEIGHT, "-c", "top -n 1 | grep " + myPid}).getInputStream()));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                String b2 = b(bufferedReader);
                b.this.f44381e.put("cpu", b2);
                if (b.i) {
                    Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + b2);
                }
                d.b.h0.p.d.a(bufferedReader);
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                if (b.i) {
                    Log.e("PropertyMonitor", "error in cpu monitor", e);
                }
                d.b.h0.p.d.a(bufferedReader2);
                this.f44385e = false;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                d.b.h0.p.d.a(bufferedReader2);
                this.f44385e = false;
                throw th;
            }
            this.f44385e = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: e  reason: collision with root package name */
        public long f44387e;

        /* renamed from: f  reason: collision with root package name */
        public int f44388f;

        public c() {
            this.f44387e = -1L;
            this.f44388f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            if (b.this.f44382f) {
                long j2 = this.f44387e;
                if (j2 > 0 && this.f44388f != (i = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f44388f = i;
                    b.this.f44381e.put("frame", Integer.valueOf(i));
                }
                this.f44387e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44390a = new b();
    }

    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.f44381e != null) {
                b.this.g();
                b.this.f44381e.put("mem", Long.valueOf(((ActivityManager) d.b.h0.a.w0.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.f44377a != null) {
                    b.this.f44377a.sendEmptyMessageDelayed(0, b.this.f44383g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements e.b {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Set<d.b.h0.a.f2.c<?>> set) {
            if (set == null || set.size() <= 0) {
                return;
            }
            for (d.b.h0.a.f2.c<?> cVar : set) {
                b.this.f44381e.put(cVar.f45179a, cVar.a());
            }
        }
    }

    static {
        String str = d.b.h0.a.f2.d.f45187g.f45179a;
        m = d.b.h0.a.f2.d.i.f45179a;
        n = d.b.h0.a.f2.d.f45185e.f45179a;
        o = d.b.h0.a.f2.d.f45186f.f45179a;
        p = d.b.h0.a.f2.d.f45188h.f45179a;
        q = d.b.h0.a.f2.d.j.f45179a;
        r = d.b.h0.a.f2.d.k.f45179a;
    }

    public static b h() {
        return d.f44390a;
    }

    public final void g() {
        if (this.f44380d.f44385e) {
            return;
        }
        p.k(this.f44380d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        this.f44384h++;
        k();
        return this.f44381e;
    }

    public void j() {
        int i2 = this.f44384h - 1;
        this.f44384h = i2;
        if (i2 <= 0) {
            l();
        }
    }

    public final void k() {
        if (this.f44382f) {
            if (i) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.f44382f = true;
        this.f44379c = new c();
        Choreographer.getInstance().postFrameCallback(this.f44379c);
        this.f44380d = new RunnableC0655b();
        this.f44378b = new f();
        d.b.h0.a.f2.e.a().g(this.f44378b, d.b.h0.a.f2.d.f45184d, d.b.h0.a.f2.d.f45182b, d.b.h0.a.f2.d.f45183c, d.b.h0.a.f2.d.i, d.b.h0.a.f2.d.f45185e, d.b.h0.a.f2.d.f45186f, d.b.h0.a.f2.d.f45187g, d.b.h0.a.f2.d.f45188h, d.b.h0.a.f2.d.j, d.b.h0.a.f2.d.k);
        e eVar = new e();
        this.f44377a = eVar;
        eVar.sendEmptyMessage(0);
        if (i) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    public final void l() {
        if (!this.f44382f) {
            if (i) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.f44382f = false;
        e eVar = this.f44377a;
        if (eVar != null) {
            eVar.removeMessages(0);
            this.f44377a = null;
        }
        if (this.f44378b != null) {
            d.b.h0.a.f2.e.a().j(this.f44378b, new d.b.h0.a.f2.c[0]);
            this.f44378b = null;
        }
        this.f44379c = null;
        this.f44380d = null;
        if (i) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    public b() {
        this.f44381e = new ConcurrentHashMap();
        this.f44383g = 1000;
    }
}
