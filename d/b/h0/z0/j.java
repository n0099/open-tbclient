package d.b.h0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f51699b;

    /* renamed from: c  reason: collision with root package name */
    public long f51700c;

    /* renamed from: d  reason: collision with root package name */
    public long f51701d;

    /* renamed from: e  reason: collision with root package name */
    public long f51702e;

    /* renamed from: f  reason: collision with root package name */
    public long f51703f;

    /* renamed from: g  reason: collision with root package name */
    public long f51704g;
    public b i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f51698a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f51705h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f51704g > j.this.f51703f) {
                j jVar = j.this;
                jVar.f51703f = currentTimeMillis - jVar.f51701d;
                j jVar2 = j.this;
                jVar2.f51704g = jVar2.f51703f;
            }
            long j = currentTimeMillis - j.this.f51703f;
            j.this.f51700c += j.this.f51701d;
            if (j.this.f51700c < j.this.f51699b) {
                j.this.f51698a.postDelayed(j.this.j, (j.this.f51701d * 2) - j);
                if (j.this.i != null) {
                    j.this.i.b(j.this.f51699b, j.this.f51699b - j.this.f51700c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f51700c = jVar3.f51699b;
                j.this.m();
            }
            j.this.f51703f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.f51699b = j;
        this.f51701d = j2;
    }

    public final void m() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(this.f51699b);
        }
    }

    public long n() {
        return this.f51700c;
    }

    public void o() {
        if (this.f51705h) {
            return;
        }
        this.f51705h = true;
        this.f51704g = System.currentTimeMillis();
        this.f51698a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f51705h) {
            this.f51705h = false;
            this.f51698a.postDelayed(this.j, this.f51701d - (this.f51704g - this.f51703f));
        }
    }

    public void q(b bVar) {
        this.i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f51702e = currentTimeMillis;
        this.f51703f = currentTimeMillis;
        b bVar = this.i;
        if (bVar != null) {
            long j = this.f51699b;
            bVar.b(j, j - this.f51700c);
        }
        this.f51698a.postDelayed(this.j, this.f51701d);
    }

    public void s() {
        this.f51705h = false;
        long j = this.f51702e;
        this.f51703f = j;
        this.f51704g = j;
        this.f51698a.removeCallbacks(this.j);
    }
}
