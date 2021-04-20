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
    public final Queue<Integer> f67902a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67903b;

    /* renamed from: c  reason: collision with root package name */
    public long f67904c;

    /* renamed from: d  reason: collision with root package name */
    public long f67905d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f67906e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f67907f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f67908g;

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
            if (k.this.f67902a.isEmpty()) {
                return;
            }
            long c2 = d.o.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - k.this.f67905d;
            if (currentTimeMillis < c2) {
                if (k.this.f67907f.hasCallbacks(k.this.f67908g)) {
                    return;
                }
                k.this.f67907f.postDelayed(k.this.f67908g, c2 - currentTimeMillis);
                return;
            }
            k.this.f67905d = System.currentTimeMillis();
            k.this.l();
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f67911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f67912f;

        public c(Context context, Integer num) {
            this.f67911e = context;
            this.f67912f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.h(this.f67911e, this.f67912f.intValue(), false);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f67914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f67915f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f67916g;

        public d(Context context, int i, boolean z) {
            this.f67914e = context;
            this.f67915f = i;
            this.f67916g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a(this.f67914e, this.f67915f, this.f67916g);
        }
    }

    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final k f67918a = new k(null);
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        return e.f67918a;
    }

    public int a(Context context, int i, boolean z) {
        if (z) {
            return h(context, i, z);
        }
        if (n()) {
            this.f67907f.postDelayed(new d(context, i, z), 1000L);
            return 1;
        } else if (d.o.a.e.b.a.a.c().j()) {
            d.o.a.e.b.c.a.h("leaves", "on Foreground");
            return h(context, i, z);
        } else if (d.o.a.e.a.c.k()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f67902a.isEmpty() && !this.f67903b && z2) {
                return h(context, i, z);
            }
            int b2 = d.o.a.e.b.j.a.r().b("install_queue_size", 3);
            synchronized (this.f67902a) {
                while (this.f67902a.size() > b2) {
                    this.f67902a.poll();
                }
            }
            if (z2) {
                this.f67907f.removeCallbacks(this.f67908g);
                this.f67907f.postDelayed(this.f67908g, d.o.a.e.b.j.a.d(i).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f67902a) {
                if (!this.f67902a.contains(Integer.valueOf(i))) {
                    this.f67902a.offer(Integer.valueOf(i));
                }
            }
            return 1;
        }
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f67906e = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public void g(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        l();
    }

    public final int h(Context context, int i, boolean z) {
        int D = d.o.a.e.a.d.D(context, i, z);
        if (D == 1) {
            this.f67903b = true;
        }
        this.f67904c = System.currentTimeMillis();
        return D;
    }

    public JumpUnknownSourceActivity i() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f67906e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f67906e = null;
        return jumpUnknownSourceActivity;
    }

    public final void l() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || d.o.a.e.b.a.a.c().j()) {
            synchronized (this.f67902a) {
                poll = this.f67902a.poll();
            }
            this.f67907f.removeCallbacks(this.f67908g);
            if (poll != null) {
                Context l = d.o.a.e.b.g.d.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f67907f.post(new c(l, poll));
                } else {
                    h(l, poll.intValue(), false);
                }
                this.f67907f.postDelayed(this.f67908g, 20000L);
                return;
            }
            this.f67903b = false;
        }
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.f67904c < 1000;
    }

    public k() {
        this.f67902a = new ArrayDeque();
        this.f67903b = false;
        this.f67907f = new Handler(Looper.getMainLooper());
        this.f67908g = new a();
        d.o.a.e.b.a.a.c().f(new b());
    }
}
