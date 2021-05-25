package d.a.m0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f51030b;

    /* renamed from: c  reason: collision with root package name */
    public long f51031c;

    /* renamed from: d  reason: collision with root package name */
    public long f51032d;

    /* renamed from: e  reason: collision with root package name */
    public long f51033e;

    /* renamed from: f  reason: collision with root package name */
    public long f51034f;

    /* renamed from: g  reason: collision with root package name */
    public long f51035g;

    /* renamed from: i  reason: collision with root package name */
    public b f51037i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f51029a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f51036h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f51035g > j.this.f51034f) {
                j jVar = j.this;
                jVar.f51034f = currentTimeMillis - jVar.f51032d;
                j jVar2 = j.this;
                jVar2.f51035g = jVar2.f51034f;
            }
            long j = currentTimeMillis - j.this.f51034f;
            j.this.f51031c += j.this.f51032d;
            if (j.this.f51031c < j.this.f51030b) {
                j.this.f51029a.postDelayed(j.this.j, (j.this.f51032d * 2) - j);
                if (j.this.f51037i != null) {
                    j.this.f51037i.a(j.this.f51030b, j.this.f51030b - j.this.f51031c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f51031c = jVar3.f51030b;
                j.this.m();
            }
            j.this.f51034f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j, long j2);

        void b(long j);
    }

    public j(long j, long j2) {
        this.f51030b = j;
        this.f51032d = j2;
    }

    public final void m() {
        b bVar = this.f51037i;
        if (bVar != null) {
            bVar.b(this.f51030b);
        }
    }

    public long n() {
        return this.f51031c;
    }

    public void o() {
        if (this.f51036h) {
            return;
        }
        this.f51036h = true;
        this.f51035g = System.currentTimeMillis();
        this.f51029a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f51036h) {
            this.f51036h = false;
            this.f51029a.postDelayed(this.j, this.f51032d - (this.f51035g - this.f51034f));
        }
    }

    public void q(b bVar) {
        this.f51037i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f51033e = currentTimeMillis;
        this.f51034f = currentTimeMillis;
        b bVar = this.f51037i;
        if (bVar != null) {
            long j = this.f51030b;
            bVar.a(j, j - this.f51031c);
        }
        this.f51029a.postDelayed(this.j, this.f51032d);
    }

    public void s() {
        this.f51036h = false;
        long j = this.f51033e;
        this.f51034f = j;
        this.f51035g = j;
        this.f51029a.removeCallbacks(this.j);
    }
}
