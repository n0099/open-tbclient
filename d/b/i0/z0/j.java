package d.b.i0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f52459b;

    /* renamed from: c  reason: collision with root package name */
    public long f52460c;

    /* renamed from: d  reason: collision with root package name */
    public long f52461d;

    /* renamed from: e  reason: collision with root package name */
    public long f52462e;

    /* renamed from: f  reason: collision with root package name */
    public long f52463f;

    /* renamed from: g  reason: collision with root package name */
    public long f52464g;
    public b i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f52458a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f52465h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f52464g > j.this.f52463f) {
                j jVar = j.this;
                jVar.f52463f = currentTimeMillis - jVar.f52461d;
                j jVar2 = j.this;
                jVar2.f52464g = jVar2.f52463f;
            }
            long j = currentTimeMillis - j.this.f52463f;
            j.this.f52460c += j.this.f52461d;
            if (j.this.f52460c < j.this.f52459b) {
                j.this.f52458a.postDelayed(j.this.j, (j.this.f52461d * 2) - j);
                if (j.this.i != null) {
                    j.this.i.b(j.this.f52459b, j.this.f52459b - j.this.f52460c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f52460c = jVar3.f52459b;
                j.this.m();
            }
            j.this.f52463f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.f52459b = j;
        this.f52461d = j2;
    }

    public final void m() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(this.f52459b);
        }
    }

    public long n() {
        return this.f52460c;
    }

    public void o() {
        if (this.f52465h) {
            return;
        }
        this.f52465h = true;
        this.f52464g = System.currentTimeMillis();
        this.f52458a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f52465h) {
            this.f52465h = false;
            this.f52458a.postDelayed(this.j, this.f52461d - (this.f52464g - this.f52463f));
        }
    }

    public void q(b bVar) {
        this.i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f52462e = currentTimeMillis;
        this.f52463f = currentTimeMillis;
        b bVar = this.i;
        if (bVar != null) {
            long j = this.f52459b;
            bVar.b(j, j - this.f52460c);
        }
        this.f52458a.postDelayed(this.j, this.f52461d);
    }

    public void s() {
        this.f52465h = false;
        long j = this.f52462e;
        this.f52463f = j;
        this.f52464g = j;
        this.f52458a.removeCallbacks(this.j);
    }
}
