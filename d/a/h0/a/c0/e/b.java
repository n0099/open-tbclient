package d.a.h0.a.c0.e;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.a.h0.a.f2.e;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
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
    public static final boolean f41664i = k.f43101a;
    public static final String j = d.a.h0.a.f2.d.f42495d.f42490a;
    public static final String k = d.a.h0.a.f2.d.f42493b.f42490a;
    public static final String l = d.a.h0.a.f2.d.f42494c.f42490a;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a  reason: collision with root package name */
    public e f41665a;

    /* renamed from: b  reason: collision with root package name */
    public f f41666b;

    /* renamed from: c  reason: collision with root package name */
    public c f41667c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0594b f41668d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f41669e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41670f;

    /* renamed from: g  reason: collision with root package name */
    public int f41671g;

    /* renamed from: h  reason: collision with root package name */
    public int f41672h;

    /* renamed from: d.a.h0.a.c0.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0594b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public boolean f41673e;

        public RunnableC0594b() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:4|(1:7)|8|(6:10|(1:13)|14|15|16|17)|(1:25)(1:30)|(1:29)|14|15|16|17) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
            if (d.a.h0.a.c0.e.b.f41664i != false) goto L23;
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
            BufferedReader bufferedReader;
            this.f41673e = true;
            if (b.f41664i) {
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
                b.this.f41669e.put("cpu", b2);
                if (b.f41664i) {
                    Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + b2);
                }
                d.a.h0.p.d.a(bufferedReader);
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                if (b.f41664i) {
                    Log.e("PropertyMonitor", "error in cpu monitor", e);
                }
                d.a.h0.p.d.a(bufferedReader2);
                this.f41673e = false;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                d.a.h0.p.d.a(bufferedReader2);
                this.f41673e = false;
                throw th;
            }
            this.f41673e = false;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: e  reason: collision with root package name */
        public long f41675e;

        /* renamed from: f  reason: collision with root package name */
        public int f41676f;

        public c() {
            this.f41675e = -1L;
            this.f41676f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            if (b.this.f41670f) {
                long j2 = this.f41675e;
                if (j2 > 0 && this.f41676f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f41676f = i2;
                    b.this.f41669e.put("frame", Integer.valueOf(i2));
                }
                this.f41675e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f41678a = new b();
    }

    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.this.f41669e != null) {
                b.this.g();
                b.this.f41669e.put("mem", Long.valueOf(((ActivityManager) d.a.h0.a.w0.a.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (b.this.f41665a != null) {
                    b.this.f41665a.sendEmptyMessageDelayed(0, b.this.f41671g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements e.b {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Set<d.a.h0.a.f2.c<?>> set) {
            if (set == null || set.size() <= 0) {
                return;
            }
            for (d.a.h0.a.f2.c<?> cVar : set) {
                b.this.f41669e.put(cVar.f42490a, cVar.a());
            }
        }
    }

    static {
        String str = d.a.h0.a.f2.d.f42498g.f42490a;
        m = d.a.h0.a.f2.d.f42500i.f42490a;
        n = d.a.h0.a.f2.d.f42496e.f42490a;
        o = d.a.h0.a.f2.d.f42497f.f42490a;
        p = d.a.h0.a.f2.d.f42499h.f42490a;
        q = d.a.h0.a.f2.d.j.f42490a;
        r = d.a.h0.a.f2.d.k.f42490a;
    }

    public static b h() {
        return d.f41678a;
    }

    public final void g() {
        if (this.f41668d.f41673e) {
            return;
        }
        p.k(this.f41668d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        this.f41672h++;
        k();
        return this.f41669e;
    }

    public void j() {
        int i2 = this.f41672h - 1;
        this.f41672h = i2;
        if (i2 <= 0) {
            l();
        }
    }

    public final void k() {
        if (this.f41670f) {
            if (f41664i) {
                Log.d("PropertyMonitor", "System monitor already started");
                return;
            }
            return;
        }
        this.f41670f = true;
        this.f41667c = new c();
        Choreographer.getInstance().postFrameCallback(this.f41667c);
        this.f41668d = new RunnableC0594b();
        this.f41666b = new f();
        d.a.h0.a.f2.e.a().g(this.f41666b, d.a.h0.a.f2.d.f42495d, d.a.h0.a.f2.d.f42493b, d.a.h0.a.f2.d.f42494c, d.a.h0.a.f2.d.f42500i, d.a.h0.a.f2.d.f42496e, d.a.h0.a.f2.d.f42497f, d.a.h0.a.f2.d.f42498g, d.a.h0.a.f2.d.f42499h, d.a.h0.a.f2.d.j, d.a.h0.a.f2.d.k);
        e eVar = new e();
        this.f41665a = eVar;
        eVar.sendEmptyMessage(0);
        if (f41664i) {
            Log.d("PropertyMonitor", "Start system monitor");
        }
    }

    public final void l() {
        if (!this.f41670f) {
            if (f41664i) {
                Log.d("PropertyMonitor", "System monitor not started yet");
                return;
            }
            return;
        }
        this.f41670f = false;
        e eVar = this.f41665a;
        if (eVar != null) {
            eVar.removeMessages(0);
            this.f41665a = null;
        }
        if (this.f41666b != null) {
            d.a.h0.a.f2.e.a().j(this.f41666b, new d.a.h0.a.f2.c[0]);
            this.f41666b = null;
        }
        this.f41667c = null;
        this.f41668d = null;
        if (f41664i) {
            Log.d("PropertyMonitor", "Stop system monitor");
        }
    }

    public b() {
        this.f41669e = new ConcurrentHashMap();
        this.f41671g = 1000;
    }
}
