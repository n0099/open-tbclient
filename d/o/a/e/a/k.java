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
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Integer> f66405a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66406b;

    /* renamed from: c  reason: collision with root package name */
    public long f66407c;

    /* renamed from: d  reason: collision with root package name */
    public long f66408d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f66409e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f66410f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f66411g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.l();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.o.a.e.b.a.a.b
        public void b() {
            if (k.this.f66405a.isEmpty()) {
                return;
            }
            long c2 = d.o.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - k.this.f66408d;
            if (currentTimeMillis < c2) {
                if (k.this.f66410f.hasCallbacks(k.this.f66411g)) {
                    return;
                }
                k.this.f66410f.postDelayed(k.this.f66411g, c2 - currentTimeMillis);
                return;
            }
            k.this.f66408d = System.currentTimeMillis();
            k.this.l();
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66414e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f66415f;

        public c(Context context, Integer num) {
            this.f66414e = context;
            this.f66415f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.h(this.f66414e, this.f66415f.intValue(), false);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66418f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f66419g;

        public d(Context context, int i2, boolean z) {
            this.f66417e = context;
            this.f66418f = i2;
            this.f66419g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a(this.f66417e, this.f66418f, this.f66419g);
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final k f66421a = new k(null);
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        return e.f66421a;
    }

    public int a(Context context, int i2, boolean z) {
        if (z) {
            return h(context, i2, z);
        }
        if (n()) {
            this.f66410f.postDelayed(new d(context, i2, z), 1000L);
            return 1;
        } else if (d.o.a.e.b.a.a.c().j()) {
            d.o.a.e.b.c.a.h("leaves", "on Foreground");
            return h(context, i2, z);
        } else if (d.o.a.e.a.c.k()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f66405a.isEmpty() && !this.f66406b && z2) {
                return h(context, i2, z);
            }
            int b2 = d.o.a.e.b.j.a.r().b("install_queue_size", 3);
            synchronized (this.f66405a) {
                while (this.f66405a.size() > b2) {
                    this.f66405a.poll();
                }
            }
            if (z2) {
                this.f66410f.removeCallbacks(this.f66411g);
                this.f66410f.postDelayed(this.f66411g, d.o.a.e.b.j.a.d(i2).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f66405a) {
                if (!this.f66405a.contains(Integer.valueOf(i2))) {
                    this.f66405a.offer(Integer.valueOf(i2));
                }
            }
            return 1;
        }
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f66409e = new SoftReference<>(jumpUnknownSourceActivity);
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
            this.f66406b = true;
        }
        this.f66407c = System.currentTimeMillis();
        return D;
    }

    public JumpUnknownSourceActivity i() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f66409e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f66409e = null;
        return jumpUnknownSourceActivity;
    }

    public final void l() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || d.o.a.e.b.a.a.c().j()) {
            synchronized (this.f66405a) {
                poll = this.f66405a.poll();
            }
            this.f66410f.removeCallbacks(this.f66411g);
            if (poll != null) {
                Context l = d.o.a.e.b.g.d.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f66410f.post(new c(l, poll));
                } else {
                    h(l, poll.intValue(), false);
                }
                this.f66410f.postDelayed(this.f66411g, 20000L);
                return;
            }
            this.f66406b = false;
        }
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.f66407c < 1000;
    }

    public k() {
        this.f66405a = new ArrayDeque();
        this.f66406b = false;
        this.f66410f = new Handler(Looper.getMainLooper());
        this.f66411g = new a();
        d.o.a.e.b.a.a.c().f(new b());
    }
}
