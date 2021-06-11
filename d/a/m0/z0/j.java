package d.a.m0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f54707b;

    /* renamed from: c  reason: collision with root package name */
    public long f54708c;

    /* renamed from: d  reason: collision with root package name */
    public long f54709d;

    /* renamed from: e  reason: collision with root package name */
    public long f54710e;

    /* renamed from: f  reason: collision with root package name */
    public long f54711f;

    /* renamed from: g  reason: collision with root package name */
    public long f54712g;

    /* renamed from: i  reason: collision with root package name */
    public b f54714i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f54706a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f54713h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f54712g > j.this.f54711f) {
                j jVar = j.this;
                jVar.f54711f = currentTimeMillis - jVar.f54709d;
                j jVar2 = j.this;
                jVar2.f54712g = jVar2.f54711f;
            }
            long j = currentTimeMillis - j.this.f54711f;
            j.this.f54708c += j.this.f54709d;
            if (j.this.f54708c < j.this.f54707b) {
                j.this.f54706a.postDelayed(j.this.j, (j.this.f54709d * 2) - j);
                if (j.this.f54714i != null) {
                    j.this.f54714i.a(j.this.f54707b, j.this.f54707b - j.this.f54708c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f54708c = jVar3.f54707b;
                j.this.m();
            }
            j.this.f54711f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j, long j2);

        void b(long j);
    }

    public j(long j, long j2) {
        this.f54707b = j;
        this.f54709d = j2;
    }

    public final void m() {
        b bVar = this.f54714i;
        if (bVar != null) {
            bVar.b(this.f54707b);
        }
    }

    public long n() {
        return this.f54708c;
    }

    public void o() {
        if (this.f54713h) {
            return;
        }
        this.f54713h = true;
        this.f54712g = System.currentTimeMillis();
        this.f54706a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f54713h) {
            this.f54713h = false;
            this.f54706a.postDelayed(this.j, this.f54709d - (this.f54712g - this.f54711f));
        }
    }

    public void q(b bVar) {
        this.f54714i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f54710e = currentTimeMillis;
        this.f54711f = currentTimeMillis;
        b bVar = this.f54714i;
        if (bVar != null) {
            long j = this.f54707b;
            bVar.a(j, j - this.f54708c);
        }
        this.f54706a.postDelayed(this.j, this.f54709d);
    }

    public void s() {
        this.f54713h = false;
        long j = this.f54710e;
        this.f54711f = j;
        this.f54712g = j;
        this.f54706a.removeCallbacks(this.j);
    }
}
