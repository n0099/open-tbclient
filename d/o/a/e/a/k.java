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
    public final Queue<Integer> f66909a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66910b;

    /* renamed from: c  reason: collision with root package name */
    public long f66911c;

    /* renamed from: d  reason: collision with root package name */
    public long f66912d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<JumpUnknownSourceActivity> f66913e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f66914f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f66915g;

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
            if (k.this.f66909a.isEmpty()) {
                return;
            }
            long c2 = d.o.a.e.b.j.a.r().c("install_on_resume_install_interval", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            long currentTimeMillis = System.currentTimeMillis() - k.this.f66912d;
            if (currentTimeMillis < c2) {
                if (k.this.f66914f.hasCallbacks(k.this.f66915g)) {
                    return;
                }
                k.this.f66914f.postDelayed(k.this.f66915g, c2 - currentTimeMillis);
                return;
            }
            k.this.f66912d = System.currentTimeMillis();
            k.this.l();
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Integer f66919f;

        public c(Context context, Integer num) {
            this.f66918e = context;
            this.f66919f = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.h(this.f66918e, this.f66919f.intValue(), false);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66922f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f66923g;

        public d(Context context, int i, boolean z) {
            this.f66921e = context;
            this.f66922f = i;
            this.f66923g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a(this.f66921e, this.f66922f, this.f66923g);
        }
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final k f66925a = new k(null);
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k d() {
        return e.f66925a;
    }

    public int a(Context context, int i, boolean z) {
        if (z) {
            return h(context, i, z);
        }
        if (n()) {
            this.f66914f.postDelayed(new d(context, i, z), 1000L);
            return 1;
        } else if (d.o.a.e.b.a.a.c().j()) {
            d.o.a.e.b.c.a.h("leaves", "on Foreground");
            return h(context, i, z);
        } else if (d.o.a.e.a.c.k()) {
            return 1;
        } else {
            boolean z2 = Build.VERSION.SDK_INT < 29;
            if (this.f66909a.isEmpty() && !this.f66910b && z2) {
                return h(context, i, z);
            }
            int b2 = d.o.a.e.b.j.a.r().b("install_queue_size", 3);
            synchronized (this.f66909a) {
                while (this.f66909a.size() > b2) {
                    this.f66909a.poll();
                }
            }
            if (z2) {
                this.f66914f.removeCallbacks(this.f66915g);
                this.f66914f.postDelayed(this.f66915g, d.o.a.e.b.j.a.d(i).c("install_queue_timeout", 20000L));
            }
            synchronized (this.f66909a) {
                if (!this.f66909a.contains(Integer.valueOf(i))) {
                    this.f66909a.offer(Integer.valueOf(i));
                }
            }
            return 1;
        }
    }

    public void f(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f66913e = new SoftReference<>(jumpUnknownSourceActivity);
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
            this.f66910b = true;
        }
        this.f66911c = System.currentTimeMillis();
        return D;
    }

    public JumpUnknownSourceActivity i() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f66913e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f66913e = null;
        return jumpUnknownSourceActivity;
    }

    public final void l() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || d.o.a.e.b.a.a.c().j()) {
            synchronized (this.f66909a) {
                poll = this.f66909a.poll();
            }
            this.f66914f.removeCallbacks(this.f66915g);
            if (poll != null) {
                Context l = d.o.a.e.b.g.d.l();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f66914f.post(new c(l, poll));
                } else {
                    h(l, poll.intValue(), false);
                }
                this.f66914f.postDelayed(this.f66915g, 20000L);
                return;
            }
            this.f66910b = false;
        }
    }

    public final boolean n() {
        return System.currentTimeMillis() - this.f66911c < 1000;
    }

    public k() {
        this.f66909a = new ArrayDeque();
        this.f66910b = false;
        this.f66914f = new Handler(Looper.getMainLooper());
        this.f66915g = new a();
        d.o.a.e.b.a.a.c().f(new b());
    }
}
