package d.r.b.a.a.j.d;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy;
/* loaded from: classes7.dex */
public abstract class a implements RetryPolicy {

    /* renamed from: a  reason: collision with root package name */
    public Handler f67878a;

    /* renamed from: b  reason: collision with root package name */
    public int f67879b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67880c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f67881d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f67882e;

    /* renamed from: f  reason: collision with root package name */
    public final int f67883f;

    /* renamed from: g  reason: collision with root package name */
    public int f67884g;

    /* renamed from: d.r.b.a.a.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1903a implements Runnable {
        public RunnableC1903a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry currentRetryCount=" + a.this.f67879b);
            a.this.j();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry currentRetryCount=" + a.this.f67879b);
            a.this.j();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry currentRetryCount=" + a.this.f67879b);
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
        this.f67878a = handler;
        this.f67884g = i2;
        this.f67880c = i3;
        this.f67882e = i4;
        this.f67883f = i5;
    }

    public void g() {
        this.f67879b = 1;
        this.f67881d = 0;
        this.f67878a.post(new d());
    }

    public void h() {
        this.f67881d = 1;
        d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
    }

    public final boolean i() {
        return this.f67879b < this.f67880c;
    }

    public abstract void j();

    public void k() {
        d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retry mTimeoutMs=" + this.f67884g + ", mMaxNumRetries=" + this.f67880c + ",mIntervalMs=" + this.f67882e);
        if (this.f67881d != 0) {
            return;
        }
        if (i()) {
            if (this.f67883f == 1) {
                int i2 = this.f67879b + 1;
                this.f67879b = i2;
                if (i2 <= this.f67880c / 2) {
                    this.f67878a.postDelayed(new RunnableC1903a(), this.f67882e);
                    return;
                } else {
                    this.f67878a.postDelayed(new b(), 60000L);
                    return;
                }
            }
            this.f67879b++;
            this.f67878a.postDelayed(new c(), this.f67882e);
            return;
        }
        d();
        d.r.b.a.a.f.d.d.f("DefaultRetryPolicy", "retryCountExhaust");
    }
}
