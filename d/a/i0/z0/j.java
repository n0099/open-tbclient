package d.a.i0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f50138b;

    /* renamed from: c  reason: collision with root package name */
    public long f50139c;

    /* renamed from: d  reason: collision with root package name */
    public long f50140d;

    /* renamed from: e  reason: collision with root package name */
    public long f50141e;

    /* renamed from: f  reason: collision with root package name */
    public long f50142f;

    /* renamed from: g  reason: collision with root package name */
    public long f50143g;

    /* renamed from: i  reason: collision with root package name */
    public b f50145i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f50137a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f50144h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f50143g > j.this.f50142f) {
                j jVar = j.this;
                jVar.f50142f = currentTimeMillis - jVar.f50140d;
                j jVar2 = j.this;
                jVar2.f50143g = jVar2.f50142f;
            }
            long j = currentTimeMillis - j.this.f50142f;
            j.this.f50139c += j.this.f50140d;
            if (j.this.f50139c < j.this.f50138b) {
                j.this.f50137a.postDelayed(j.this.j, (j.this.f50140d * 2) - j);
                if (j.this.f50145i != null) {
                    j.this.f50145i.a(j.this.f50138b, j.this.f50138b - j.this.f50139c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f50139c = jVar3.f50138b;
                j.this.m();
            }
            j.this.f50142f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j, long j2);

        void b(long j);
    }

    public j(long j, long j2) {
        this.f50138b = j;
        this.f50140d = j2;
    }

    public final void m() {
        b bVar = this.f50145i;
        if (bVar != null) {
            bVar.b(this.f50138b);
        }
    }

    public long n() {
        return this.f50139c;
    }

    public void o() {
        if (this.f50144h) {
            return;
        }
        this.f50144h = true;
        this.f50143g = System.currentTimeMillis();
        this.f50137a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f50144h) {
            this.f50144h = false;
            this.f50137a.postDelayed(this.j, this.f50140d - (this.f50143g - this.f50142f));
        }
    }

    public void q(b bVar) {
        this.f50145i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f50141e = currentTimeMillis;
        this.f50142f = currentTimeMillis;
        b bVar = this.f50145i;
        if (bVar != null) {
            long j = this.f50138b;
            bVar.a(j, j - this.f50139c);
        }
        this.f50137a.postDelayed(this.j, this.f50140d);
    }

    public void s() {
        this.f50144h = false;
        long j = this.f50141e;
        this.f50142f = j;
        this.f50143g = j;
        this.f50137a.removeCallbacks(this.j);
    }
}
