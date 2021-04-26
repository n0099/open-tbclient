package d.r.b.a.a.j.d;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy;
/* loaded from: classes7.dex */
public abstract class a implements RetryPolicy {

    /* renamed from: a  reason: collision with root package name */
    public Handler f67192a;

    /* renamed from: b  reason: collision with root package name */
    public int f67193b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67194c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f67195d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f67196e;

    /* renamed from: f  reason: collision with root package name */
    public final int f67197f;

    /* renamed from: g  reason: collision with root package name */
    public int f67198g;

    /* renamed from: d.r.b.a.a.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1839a implements Runnable {
        public RunnableC1839a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry currentRetryCount=" + a.this.f67193b);
            a.this.j();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry currentRetryCount=" + a.this.f67193b);
            a.this.j();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry currentRetryCount=" + a.this.f67193b);
            a.this.j();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j();
        }
    }

    public a(Handler handler, int i2, int i3, int i4, int i5) {
        this.f67192a = handler;
        this.f67198g = i2;
        this.f67194c = i3;
        this.f67196e = i4;
        this.f67197f = i5;
    }

    public void g() {
        this.f67193b = 1;
        this.f67195d = 0;
        this.f67192a.post(new d());
    }

    public void h() {
        this.f67195d = 1;
        d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
    }

    public final boolean i() {
        return this.f67193b < this.f67194c;
    }

    public abstract void j();

    public void k() {
        d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry mTimeoutMs=" + this.f67198g + ", mMaxNumRetries=" + this.f67194c + ",mIntervalMs=" + this.f67196e);
        if (this.f67195d != 0) {
            return;
        }
        if (i()) {
            if (this.f67197f == 1) {
                int i2 = this.f67193b + 1;
                this.f67193b = i2;
                if (i2 <= this.f67194c / 2) {
                    this.f67192a.postDelayed(new RunnableC1839a(), this.f67196e);
                    return;
                } else {
                    this.f67192a.postDelayed(new b(), 60000L);
                    return;
                }
            }
            this.f67193b++;
            this.f67192a.postDelayed(new c(), this.f67196e);
            return;
        }
        d();
        d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retryCountExhaust");
    }
}
