package d.b.h0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f52123b;

    /* renamed from: c  reason: collision with root package name */
    public long f52124c;

    /* renamed from: d  reason: collision with root package name */
    public long f52125d;

    /* renamed from: e  reason: collision with root package name */
    public long f52126e;

    /* renamed from: f  reason: collision with root package name */
    public long f52127f;

    /* renamed from: g  reason: collision with root package name */
    public long f52128g;
    public b i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f52122a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f52129h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f52128g > j.this.f52127f) {
                j jVar = j.this;
                jVar.f52127f = currentTimeMillis - jVar.f52125d;
                j jVar2 = j.this;
                jVar2.f52128g = jVar2.f52127f;
            }
            long j = currentTimeMillis - j.this.f52127f;
            j.this.f52124c += j.this.f52125d;
            if (j.this.f52124c < j.this.f52123b) {
                j.this.f52122a.postDelayed(j.this.j, (j.this.f52125d * 2) - j);
                if (j.this.i != null) {
                    j.this.i.b(j.this.f52123b, j.this.f52123b - j.this.f52124c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f52124c = jVar3.f52123b;
                j.this.m();
            }
            j.this.f52127f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.f52123b = j;
        this.f52125d = j2;
    }

    public final void m() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(this.f52123b);
        }
    }

    public long n() {
        return this.f52124c;
    }

    public void o() {
        if (this.f52129h) {
            return;
        }
        this.f52129h = true;
        this.f52128g = System.currentTimeMillis();
        this.f52122a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f52129h) {
            this.f52129h = false;
            this.f52122a.postDelayed(this.j, this.f52125d - (this.f52128g - this.f52127f));
        }
    }

    public void q(b bVar) {
        this.i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f52126e = currentTimeMillis;
        this.f52127f = currentTimeMillis;
        b bVar = this.i;
        if (bVar != null) {
            long j = this.f52123b;
            bVar.b(j, j - this.f52124c);
        }
        this.f52122a.postDelayed(this.j, this.f52125d);
    }

    public void s() {
        this.f52129h = false;
        long j = this.f52126e;
        this.f52127f = j;
        this.f52128g = j;
        this.f52122a.removeCallbacks(this.j);
    }
}
