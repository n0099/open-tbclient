package d.a.n0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f54815b;

    /* renamed from: c  reason: collision with root package name */
    public long f54816c;

    /* renamed from: d  reason: collision with root package name */
    public long f54817d;

    /* renamed from: e  reason: collision with root package name */
    public long f54818e;

    /* renamed from: f  reason: collision with root package name */
    public long f54819f;

    /* renamed from: g  reason: collision with root package name */
    public long f54820g;

    /* renamed from: i  reason: collision with root package name */
    public b f54822i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f54814a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f54821h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f54820g > j.this.f54819f) {
                j jVar = j.this;
                jVar.f54819f = currentTimeMillis - jVar.f54817d;
                j jVar2 = j.this;
                jVar2.f54820g = jVar2.f54819f;
            }
            long j = currentTimeMillis - j.this.f54819f;
            j.this.f54816c += j.this.f54817d;
            if (j.this.f54816c < j.this.f54815b) {
                j.this.f54814a.postDelayed(j.this.j, (j.this.f54817d * 2) - j);
                if (j.this.f54822i != null) {
                    j.this.f54822i.a(j.this.f54815b, j.this.f54815b - j.this.f54816c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f54816c = jVar3.f54815b;
                j.this.m();
            }
            j.this.f54819f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j, long j2);

        void b(long j);
    }

    public j(long j, long j2) {
        this.f54815b = j;
        this.f54817d = j2;
    }

    public final void m() {
        b bVar = this.f54822i;
        if (bVar != null) {
            bVar.b(this.f54815b);
        }
    }

    public long n() {
        return this.f54816c;
    }

    public void o() {
        if (this.f54821h) {
            return;
        }
        this.f54821h = true;
        this.f54820g = System.currentTimeMillis();
        this.f54814a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f54821h) {
            this.f54821h = false;
            this.f54814a.postDelayed(this.j, this.f54817d - (this.f54820g - this.f54819f));
        }
    }

    public void q(b bVar) {
        this.f54822i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f54818e = currentTimeMillis;
        this.f54819f = currentTimeMillis;
        b bVar = this.f54822i;
        if (bVar != null) {
            long j = this.f54815b;
            bVar.a(j, j - this.f54816c);
        }
        this.f54814a.postDelayed(this.j, this.f54817d);
    }

    public void s() {
        this.f54821h = false;
        long j = this.f54818e;
        this.f54819f = j;
        this.f54820g = j;
        this.f54814a.removeCallbacks(this.j);
    }
}
