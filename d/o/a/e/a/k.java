package d.o.a.e.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.a.a;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Integer> f67134a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67135b;

    /* renamed from: c  reason: collision with root package name */
    public long f67136c;

    /* renamed from: d  reason: collision with root package name */
    public long f67137d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f67138e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f67139f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f67140g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.l();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.o.a.e.b.a.a.b
        public void b() {
            if (k.this.f67134a.isEmpty()) {
                return;
            }
            long c2 = d.o.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - k.this.f67137d;
            if (currentTimeMillis < c2) {
                if (k.this.f67139f.hasCallbacks(k.this.f67140g)) {
                    return;
                }
                k.this.f67139f.postDelayed(k.this.f67140g, c2 - currentTimeMillis);
                return;
            }
            k.this.f67137d = System.currentTimeMillis();
            k.this.l();
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f67143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f67144f;

        public c(Context context, Integer num) {
            this.f67143e = context;
            this.f67144f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.h(this.f67143e, this.f67144f.intValue(), false);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f67146e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f67147f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f67148g;

        public d(Context context, int i2, boolean z) {
            this.f67146e = context;
            this.f67147f = i2;
            this.f67148g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a(this.f67146e, this.f67147f, this.f67148g);
        }
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final k f67150a = new k(null);
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        return e.f67150a;
    }

    public int a(Context context, int i2, boolean z) {
        if (z) {
            return h(context, i2, z);
        }
        if (n()) {
            this.f67139f.postDelayed(new d(context, i2, z), 1000L);
            return 1;
        } else if (d.o.a.e.b.a.a.c().j()) {
            d.o.a.e.b.c.a.h("leaves", "on Foreground");
            return h(context, i2, z);
        } else if (d.o.a.e.a.c.k()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f67134a.isEmpty() && !this.f67135b && z2) {
                return h(context, i2, z);
            }
            int b2 = d.o.a.e.b.j.a.r().b("install_queue_size", 3);
            synchronized (this.f67134a) {
                while (this.f67134a.size() > b2) {
                    this.f67134a.poll();
                }
            }
            if (z2) {
                this.f67139f.removeCallbacks(this.f67140g);
                this.f67139f.postDelayed(this.f67140g, d.o.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f67134a) {
                if (!this.f67134a.contains(Integer.valueOf(i2))) {
                    this.f67134a.offer(Integer.valueOf(i2));
                }
            }
            return 1;
        }
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f67138e = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public void g(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        l();
    }

    public final int h(Context context, int i2, boolean z) {
        int D = d.o.a.e.a.d.D(context, i2, z);
        if (D == 1) {
            this.f67135b = true;
        }
        this.f67136c = System.currentTimeMillis();
        return D;
    }

    public JumpUnknownSourceActivity i() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f67138e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f67138e = null;
        return jumpUnknownSourceActivity;
    }

    public final void l() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || d.o.a.e.b.a.a.c().j()) {
            synchronized (this.f67134a) {
                poll = this.f67134a.poll();
            }
            this.f67139f.removeCallbacks(this.f67140g);
            if (poll != null) {
                Context l = d.o.a.e.b.g.d.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f67139f.post(new c(l, poll));
                } else {
                    h(l, poll.intValue(), false);
                }
                this.f67139f.postDelayed(this.f67140g, 20000L);
                return;
            }
            this.f67135b = false;
        }
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.f67136c < 1000;
    }

    public k() {
        this.f67134a = new ArrayDeque();
        this.f67135b = false;
        this.f67139f = new Handler(Looper.getMainLooper());
        this.f67140g = new a();
        d.o.a.e.b.a.a.c().f(new b());
    }
}
