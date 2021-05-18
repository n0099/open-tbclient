package d.a.i0.a.e0.g;

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
import d.a.i0.a.k;
import d.a.i0.a.q2.e;
import d.a.i0.a.v2.q;
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
    public static final boolean f41310i = k.f43025a;
    public static final String j = d.a.i0.a.q2.d.f44055d.f44050a;
    public static final String k = d.a.i0.a.q2.d.f44053b.f44050a;
    public static final String l = d.a.i0.a.q2.d.f44054c.f44050a;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a  reason: collision with root package name */
    public e f41311a;

    /* renamed from: b  reason: collision with root package name */
    public f f41312b;

    /* renamed from: c  reason: collision with root package name */
    public c f41313c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0592b f41314d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f41315e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41316f;

    /* renamed from: g  reason: collision with root package name */
    public int f41317g;

    /* renamed from: h  reason: collision with root package name */
    public int f41318h;

    /* renamed from: d.a.i0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0592b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f41319e;

        public RunnableC0592b() {
        }

        public synchronized String b() {
            BufferedReader bufferedReader;
            IOException e2;
            if (b.f41310i) {
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
                    if (b.f41310i) {
                        Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + c2);
                    }
                    d.a.i0.t.d.d(bufferedReader);
                    return c2;
                } catch (IOException e3) {
                    e2 = e3;
                    if (b.f41310i) {
                        Log.e("PropertyMonitor", "error in cpu monitor", e2);
                    }
                    d.a.i0.t.d.d(bufferedReader);
                    return "";
                }
            } catch (IOException e4) {
                bufferedReader = null;
                e2 = e4;
            } catch (Throwable th2) {
                th = th2;
                d.a.i0.t.d.d(null);
                throw th;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:4|(1:7)|8|(6:10|(1:13)|14|15|16|17)|(1:25)(1:30)|(1:29)|14|15|16|17) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
            if (d.a.i0.a.e0.g.b.f41310i != false) goto L23;
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
            this.f41319e = true;
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                b.this.f41315e.put("cpu", b2);
            }
            this.f41319e = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: e  reason: collision with root package name */
        public long f41321e;

        /* renamed from: f  reason: collision with root package name */
        public int f41322f;

        public c() {
            this.f41321e = -1L;
            this.f41322f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            if (b.this.f41316f) {
                long j2 = this.f41321e;
                if (j2 > 0 && this.f41322f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f41322f = i2;
                    b.this.f41315e.put("frame", Integer.valueOf(i2));
                }
                this.f41321e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f41324a = new b();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.f41315e != null) {
                b.this.g();
                b.this.f41315e.put("mem", Long.valueOf(((ActivityManager) d.a.i0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.f41311a != null) {
                    b.this.f41311a.sendEmptyMessageDelayed(0, b.this.f41317g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements e.b {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<d.a.i0.a.q2.c<?>> set) {
            if (set == null || set.size() <= 0) {
                return;
            }
            for (d.a.i0.a.q2.c<?> cVar : set) {
                b.this.f41315e.put(cVar.f44050a, cVar.a());
            }
        }
    }

    static {
        String str = d.a.i0.a.q2.d.f44058g.f44050a;
        m = d.a.i0.a.q2.d.f44060i.f44050a;
        n = d.a.i0.a.q2.d.f44056e.f44050a;
        o = d.a.i0.a.q2.d.f44057f.f44050a;
        p = d.a.i0.a.q2.d.f44059h.f44050a;
        q = d.a.i0.a.q2.d.j.f44050a;
        r = d.a.i0.a.q2.d.k.f44050a;
    }

    public static b h() {
        return d.f41324a;
    }

    public final void g() {
        if (this.f41314d.f41319e) {
            return;
        }
        q.j(this.f41314d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        this.f41318h++;
        k();
        return this.f41315e;
    }

    public void j() {
        int i2 = this.f41318h - 1;
        this.f41318h = i2;
        if (i2 <= 0) {
            l();
        }
    }

    public final void k() {
        if (this.f41316f) {
            if (f41310i) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.f41316f = true;
        this.f41313c = new c();
        Choreographer.getInstance().postFrameCallback(this.f41313c);
        this.f41314d = new RunnableC0592b();
        this.f41312b = new f();
        d.a.i0.a.q2.e.a().g(this.f41312b, d.a.i0.a.q2.d.f44055d, d.a.i0.a.q2.d.f44053b, d.a.i0.a.q2.d.f44054c, d.a.i0.a.q2.d.f44060i, d.a.i0.a.q2.d.f44056e, d.a.i0.a.q2.d.f44057f, d.a.i0.a.q2.d.f44058g, d.a.i0.a.q2.d.f44059h, d.a.i0.a.q2.d.j, d.a.i0.a.q2.d.k);
        e eVar = new e();
        this.f41311a = eVar;
        eVar.sendEmptyMessage(0);
        if (f41310i) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    public final void l() {
        if (!this.f41316f) {
            if (f41310i) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.f41316f = false;
        e eVar = this.f41311a;
        if (eVar != null) {
            eVar.removeMessages(0);
            this.f41311a = null;
        }
        if (this.f41312b != null) {
            d.a.i0.a.q2.e.a().j(this.f41312b, new d.a.i0.a.q2.c[0]);
            this.f41312b = null;
        }
        this.f41313c = null;
        this.f41314d = null;
        if (f41310i) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    public b() {
        this.f41315e = new ConcurrentHashMap();
        this.f41317g = 1000;
    }
}
