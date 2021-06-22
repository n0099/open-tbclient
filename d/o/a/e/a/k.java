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
    public final Queue<Integer> f71024a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71025b;

    /* renamed from: c  reason: collision with root package name */
    public long f71026c;

    /* renamed from: d  reason: collision with root package name */
    public long f71027d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f71028e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f71029f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f71030g;

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
            if (k.this.f71024a.isEmpty()) {
                return;
            }
            long c2 = d.o.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - k.this.f71027d;
            if (currentTimeMillis < c2) {
                if (k.this.f71029f.hasCallbacks(k.this.f71030g)) {
                    return;
                }
                k.this.f71029f.postDelayed(k.this.f71030g, c2 - currentTimeMillis);
                return;
            }
            k.this.f71027d = System.currentTimeMillis();
            k.this.l();
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f71033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f71034f;

        public c(Context context, Integer num) {
            this.f71033e = context;
            this.f71034f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.h(this.f71033e, this.f71034f.intValue(), false);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f71036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f71037f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f71038g;

        public d(Context context, int i2, boolean z) {
            this.f71036e = context;
            this.f71037f = i2;
            this.f71038g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a(this.f71036e, this.f71037f, this.f71038g);
        }
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final k f71040a = new k(null);
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        return e.f71040a;
    }

    public int a(Context context, int i2, boolean z) {
        if (z) {
            return h(context, i2, z);
        }
        if (n()) {
            this.f71029f.postDelayed(new d(context, i2, z), 1000L);
            return 1;
        } else if (d.o.a.e.b.a.a.c().j()) {
            d.o.a.e.b.c.a.h("leaves", "on Foreground");
            return h(context, i2, z);
        } else if (d.o.a.e.a.c.k()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f71024a.isEmpty() && !this.f71025b && z2) {
                return h(context, i2, z);
            }
            int b2 = d.o.a.e.b.j.a.r().b("install_queue_size", 3);
            synchronized (this.f71024a) {
                while (this.f71024a.size() > b2) {
                    this.f71024a.poll();
                }
            }
            if (z2) {
                this.f71029f.removeCallbacks(this.f71030g);
                this.f71029f.postDelayed(this.f71030g, d.o.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f71024a) {
                if (!this.f71024a.contains(Integer.valueOf(i2))) {
                    this.f71024a.offer(Integer.valueOf(i2));
                }
            }
            return 1;
        }
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f71028e = new SoftReference<>(jumpUnknownSourceActivity);
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
            this.f71025b = true;
        }
        this.f71026c = System.currentTimeMillis();
        return D;
    }

    public JumpUnknownSourceActivity i() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f71028e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f71028e = null;
        return jumpUnknownSourceActivity;
    }

    public final void l() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || d.o.a.e.b.a.a.c().j()) {
            synchronized (this.f71024a) {
                poll = this.f71024a.poll();
            }
            this.f71029f.removeCallbacks(this.f71030g);
            if (poll != null) {
                Context l = d.o.a.e.b.g.d.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f71029f.post(new c(l, poll));
                } else {
                    h(l, poll.intValue(), false);
                }
                this.f71029f.postDelayed(this.f71030g, 20000L);
                return;
            }
            this.f71025b = false;
        }
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.f71026c < 1000;
    }

    public k() {
        this.f71024a = new ArrayDeque();
        this.f71025b = false;
        this.f71029f = new Handler(Looper.getMainLooper());
        this.f71030g = new a();
        d.o.a.e.b.a.a.c().f(new b());
    }
}
