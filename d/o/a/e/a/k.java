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
    public final Queue<Integer> f70920a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70921b;

    /* renamed from: c  reason: collision with root package name */
    public long f70922c;

    /* renamed from: d  reason: collision with root package name */
    public long f70923d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f70924e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f70925f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f70926g;

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
            if (k.this.f70920a.isEmpty()) {
                return;
            }
            long c2 = d.o.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - k.this.f70923d;
            if (currentTimeMillis < c2) {
                if (k.this.f70925f.hasCallbacks(k.this.f70926g)) {
                    return;
                }
                k.this.f70925f.postDelayed(k.this.f70926g, c2 - currentTimeMillis);
                return;
            }
            k.this.f70923d = System.currentTimeMillis();
            k.this.l();
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f70929e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f70930f;

        public c(Context context, Integer num) {
            this.f70929e = context;
            this.f70930f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.h(this.f70929e, this.f70930f.intValue(), false);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f70932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f70933f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f70934g;

        public d(Context context, int i2, boolean z) {
            this.f70932e = context;
            this.f70933f = i2;
            this.f70934g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a(this.f70932e, this.f70933f, this.f70934g);
        }
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final k f70936a = new k(null);
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        return e.f70936a;
    }

    public int a(Context context, int i2, boolean z) {
        if (z) {
            return h(context, i2, z);
        }
        if (n()) {
            this.f70925f.postDelayed(new d(context, i2, z), 1000L);
            return 1;
        } else if (d.o.a.e.b.a.a.c().j()) {
            d.o.a.e.b.c.a.h("leaves", "on Foreground");
            return h(context, i2, z);
        } else if (d.o.a.e.a.c.k()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f70920a.isEmpty() && !this.f70921b && z2) {
                return h(context, i2, z);
            }
            int b2 = d.o.a.e.b.j.a.r().b("install_queue_size", 3);
            synchronized (this.f70920a) {
                while (this.f70920a.size() > b2) {
                    this.f70920a.poll();
                }
            }
            if (z2) {
                this.f70925f.removeCallbacks(this.f70926g);
                this.f70925f.postDelayed(this.f70926g, d.o.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f70920a) {
                if (!this.f70920a.contains(Integer.valueOf(i2))) {
                    this.f70920a.offer(Integer.valueOf(i2));
                }
            }
            return 1;
        }
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f70924e = new SoftReference<>(jumpUnknownSourceActivity);
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
            this.f70921b = true;
        }
        this.f70922c = System.currentTimeMillis();
        return D;
    }

    public JumpUnknownSourceActivity i() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f70924e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f70924e = null;
        return jumpUnknownSourceActivity;
    }

    public final void l() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || d.o.a.e.b.a.a.c().j()) {
            synchronized (this.f70920a) {
                poll = this.f70920a.poll();
            }
            this.f70925f.removeCallbacks(this.f70926g);
            if (poll != null) {
                Context l = d.o.a.e.b.g.d.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f70925f.post(new c(l, poll));
                } else {
                    h(l, poll.intValue(), false);
                }
                this.f70925f.postDelayed(this.f70926g, 20000L);
                return;
            }
            this.f70921b = false;
        }
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.f70922c < 1000;
    }

    public k() {
        this.f70920a = new ArrayDeque();
        this.f70921b = false;
        this.f70925f = new Handler(Looper.getMainLooper());
        this.f70926g = new a();
        d.o.a.e.b.a.a.c().f(new b());
    }
}
