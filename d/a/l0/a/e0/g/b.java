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
    public static final boolean f41484i = k.f43199a;
    public static final String j = d.a.l0.a.q2.d.f44231d.f44226a;
    public static final String k = d.a.l0.a.q2.d.f44229b.f44226a;
    public static final String l = d.a.l0.a.q2.d.f44230c.f44226a;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a  reason: collision with root package name */
    public e f41485a;

    /* renamed from: b  reason: collision with root package name */
    public f f41486b;

    /* renamed from: c  reason: collision with root package name */
    public c f41487c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0603b f41488d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f41489e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41490f;

    /* renamed from: g  reason: collision with root package name */
    public int f41491g;

    /* renamed from: h  reason: collision with root package name */
    public int f41492h;

    /* renamed from: d.a.l0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0603b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f41493e;

        public RunnableC0603b() {
        }

        public synchronized String b() {
            BufferedReader bufferedReader;
            IOException e2;
            if (b.f41484i) {
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
                    if (b.f41484i) {
                        Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + c2);
                    }
                    d.a.l0.t.d.d(bufferedReader);
                    return c2;
                } catch (IOException e3) {
                    e2 = e3;
                    if (b.f41484i) {
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
            if (d.a.l0.a.e0.g.b.f41484i != false) goto L23;
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
            this.f41493e = true;
            String b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                b.this.f41489e.put("cpu", b2);
            }
            this.f41493e = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: e  reason: collision with root package name */
        public long f41495e;

        /* renamed from: f  reason: collision with root package name */
        public int f41496f;

        public c() {
            this.f41495e = -1L;
            this.f41496f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            if (b.this.f41490f) {
                long j2 = this.f41495e;
                if (j2 > 0 && this.f41496f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f41496f = i2;
                    b.this.f41489e.put("frame", Integer.valueOf(i2));
                }
                this.f41495e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f41498a = new b();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.f41489e != null) {
                b.this.g();
                b.this.f41489e.put("mem", Long.valueOf(((ActivityManager) d.a.l0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.f41485a != null) {
                    b.this.f41485a.sendEmptyMessageDelayed(0, b.this.f41491g);
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
                b.this.f41489e.put(cVar.f44226a, cVar.a());
            }
        }
    }

    static {
        String str = d.a.l0.a.q2.d.f44234g.f44226a;
        m = d.a.l0.a.q2.d.f44236i.f44226a;
        n = d.a.l0.a.q2.d.f44232e.f44226a;
        o = d.a.l0.a.q2.d.f44233f.f44226a;
        p = d.a.l0.a.q2.d.f44235h.f44226a;
        q = d.a.l0.a.q2.d.j.f44226a;
        r = d.a.l0.a.q2.d.k.f44226a;
    }

    public static b h() {
        return d.f41498a;
    }

    public final void g() {
        if (this.f41488d.f41493e) {
            return;
        }
        q.j(this.f41488d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        this.f41492h++;
        k();
        return this.f41489e;
    }

    public void j() {
        int i2 = this.f41492h - 1;
        this.f41492h = i2;
        if (i2 <= 0) {
            l();
        }
    }

    public final void k() {
        if (this.f41490f) {
            if (f41484i) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.f41490f = true;
        this.f41487c = new c();
        Choreographer.getInstance().postFrameCallback(this.f41487c);
        this.f41488d = new RunnableC0603b();
        this.f41486b = new f();
        d.a.l0.a.q2.e.a().g(this.f41486b, d.a.l0.a.q2.d.f44231d, d.a.l0.a.q2.d.f44229b, d.a.l0.a.q2.d.f44230c, d.a.l0.a.q2.d.f44236i, d.a.l0.a.q2.d.f44232e, d.a.l0.a.q2.d.f44233f, d.a.l0.a.q2.d.f44234g, d.a.l0.a.q2.d.f44235h, d.a.l0.a.q2.d.j, d.a.l0.a.q2.d.k);
        e eVar = new e();
        this.f41485a = eVar;
        eVar.sendEmptyMessage(0);
        if (f41484i) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    public final void l() {
        if (!this.f41490f) {
            if (f41484i) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.f41490f = false;
        e eVar = this.f41485a;
        if (eVar != null) {
            eVar.removeMessages(0);
            this.f41485a = null;
        }
        if (this.f41486b != null) {
            d.a.l0.a.q2.e.a().j(this.f41486b, new d.a.l0.a.q2.c[0]);
            this.f41486b = null;
        }
        this.f41487c = null;
        this.f41488d = null;
        if (f41484i) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    public b() {
        this.f41489e = new ConcurrentHashMap();
        this.f41491g = 1000;
    }
}
