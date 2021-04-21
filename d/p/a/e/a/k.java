package d.p.a.e.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.b.a.a;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Integer> f68049a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68050b;

    /* renamed from: c  reason: collision with root package name */
    public long f68051c;

    /* renamed from: d  reason: collision with root package name */
    public long f68052d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f68053e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f68054f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f68055g;

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

        @Override // d.p.a.e.b.a.a.b
        public void b() {
            if (k.this.f68049a.isEmpty()) {
                return;
            }
            long c2 = d.p.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - k.this.f68052d;
            if (currentTimeMillis < c2) {
                if (k.this.f68054f.hasCallbacks(k.this.f68055g)) {
                    return;
                }
                k.this.f68054f.postDelayed(k.this.f68055g, c2 - currentTimeMillis);
                return;
            }
            k.this.f68052d = System.currentTimeMillis();
            k.this.l();
        }

        @Override // d.p.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f68058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f68059f;

        public c(Context context, Integer num) {
            this.f68058e = context;
            this.f68059f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.h(this.f68058e, this.f68059f.intValue(), false);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f68061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f68062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f68063g;

        public d(Context context, int i, boolean z) {
            this.f68061e = context;
            this.f68062f = i;
            this.f68063g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a(this.f68061e, this.f68062f, this.f68063g);
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final k f68065a = new k(null);
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        return e.f68065a;
    }

    public int a(Context context, int i, boolean z) {
        if (z) {
            return h(context, i, z);
        }
        if (n()) {
            this.f68054f.postDelayed(new d(context, i, z), 1000L);
            return 1;
        } else if (d.p.a.e.b.a.a.c().j()) {
            d.p.a.e.b.c.a.h("leaves", "on Foreground");
            return h(context, i, z);
        } else if (d.p.a.e.a.c.k()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f68049a.isEmpty() && !this.f68050b && z2) {
                return h(context, i, z);
            }
            int b2 = d.p.a.e.b.j.a.r().b("install_queue_size", 3);
            synchronized (this.f68049a) {
                while (this.f68049a.size() > b2) {
                    this.f68049a.poll();
                }
            }
            if (z2) {
                this.f68054f.removeCallbacks(this.f68055g);
                this.f68054f.postDelayed(this.f68055g, d.p.a.e.b.j.a.d(i).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f68049a) {
                if (!this.f68049a.contains(Integer.valueOf(i))) {
                    this.f68049a.offer(Integer.valueOf(i));
                }
            }
            return 1;
        }
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f68053e = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public void g(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        l();
    }

    public final int h(Context context, int i, boolean z) {
        int D = d.p.a.e.a.d.D(context, i, z);
        if (D == 1) {
            this.f68050b = true;
        }
        this.f68051c = System.currentTimeMillis();
        return D;
    }

    public JumpUnknownSourceActivity i() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f68053e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f68053e = null;
        return jumpUnknownSourceActivity;
    }

    public final void l() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || d.p.a.e.b.a.a.c().j()) {
            synchronized (this.f68049a) {
                poll = this.f68049a.poll();
            }
            this.f68054f.removeCallbacks(this.f68055g);
            if (poll != null) {
                Context l = d.p.a.e.b.g.d.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f68054f.post(new c(l, poll));
                } else {
                    h(l, poll.intValue(), false);
                }
                this.f68054f.postDelayed(this.f68055g, 20000L);
                return;
            }
            this.f68050b = false;
        }
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.f68051c < 1000;
    }

    public k() {
        this.f68049a = new ArrayDeque();
        this.f68050b = false;
        this.f68054f = new Handler(Looper.getMainLooper());
        this.f68055g = new a();
        d.p.a.e.b.a.a.c().f(new b());
    }
}
