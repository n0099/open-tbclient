package d.b.h0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f51698b;

    /* renamed from: c  reason: collision with root package name */
    public long f51699c;

    /* renamed from: d  reason: collision with root package name */
    public long f51700d;

    /* renamed from: e  reason: collision with root package name */
    public long f51701e;

    /* renamed from: f  reason: collision with root package name */
    public long f51702f;

    /* renamed from: g  reason: collision with root package name */
    public long f51703g;
    public b i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f51697a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f51704h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f51703g > j.this.f51702f) {
                j jVar = j.this;
                jVar.f51702f = currentTimeMillis - jVar.f51700d;
                j jVar2 = j.this;
                jVar2.f51703g = jVar2.f51702f;
            }
            long j = currentTimeMillis - j.this.f51702f;
            j.this.f51699c += j.this.f51700d;
            if (j.this.f51699c < j.this.f51698b) {
                j.this.f51697a.postDelayed(j.this.j, (j.this.f51700d * 2) - j);
                if (j.this.i != null) {
                    j.this.i.b(j.this.f51698b, j.this.f51698b - j.this.f51699c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f51699c = jVar3.f51698b;
                j.this.m();
            }
            j.this.f51702f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.f51698b = j;
        this.f51700d = j2;
    }

    public final void m() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(this.f51698b);
        }
    }

    public long n() {
        return this.f51699c;
    }

    public void o() {
        if (this.f51704h) {
            return;
        }
        this.f51704h = true;
        this.f51703g = System.currentTimeMillis();
        this.f51697a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f51704h) {
            this.f51704h = false;
            this.f51697a.postDelayed(this.j, this.f51700d - (this.f51703g - this.f51702f));
        }
    }

    public void q(b bVar) {
        this.i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f51701e = currentTimeMillis;
        this.f51702f = currentTimeMillis;
        b bVar = this.i;
        if (bVar != null) {
            long j = this.f51698b;
            bVar.b(j, j - this.f51699c);
        }
        this.f51697a.postDelayed(this.j, this.f51700d);
    }

    public void s() {
        this.f51704h = false;
        long j = this.f51701e;
        this.f51702f = j;
        this.f51703g = j;
        this.f51697a.removeCallbacks(this.j);
    }
}
