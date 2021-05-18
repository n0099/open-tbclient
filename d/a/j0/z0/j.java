package d.a.j0.z0;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public long f50957b;

    /* renamed from: c  reason: collision with root package name */
    public long f50958c;

    /* renamed from: d  reason: collision with root package name */
    public long f50959d;

    /* renamed from: e  reason: collision with root package name */
    public long f50960e;

    /* renamed from: f  reason: collision with root package name */
    public long f50961f;

    /* renamed from: g  reason: collision with root package name */
    public long f50962g;

    /* renamed from: i  reason: collision with root package name */
    public b f50964i;

    /* renamed from: a  reason: collision with root package name */
    public Handler f50956a = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f50963h = false;
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.f50962g > j.this.f50961f) {
                j jVar = j.this;
                jVar.f50961f = currentTimeMillis - jVar.f50959d;
                j jVar2 = j.this;
                jVar2.f50962g = jVar2.f50961f;
            }
            long j = currentTimeMillis - j.this.f50961f;
            j.this.f50958c += j.this.f50959d;
            if (j.this.f50958c < j.this.f50957b) {
                j.this.f50956a.postDelayed(j.this.j, (j.this.f50959d * 2) - j);
                if (j.this.f50964i != null) {
                    j.this.f50964i.a(j.this.f50957b, j.this.f50957b - j.this.f50958c);
                }
            } else {
                j jVar3 = j.this;
                jVar3.f50958c = jVar3.f50957b;
                j.this.m();
            }
            j.this.f50961f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j, long j2);

        void b(long j);
    }

    public j(long j, long j2) {
        this.f50957b = j;
        this.f50959d = j2;
    }

    public final void m() {
        b bVar = this.f50964i;
        if (bVar != null) {
            bVar.b(this.f50957b);
        }
    }

    public long n() {
        return this.f50958c;
    }

    public void o() {
        if (this.f50963h) {
            return;
        }
        this.f50963h = true;
        this.f50962g = System.currentTimeMillis();
        this.f50956a.removeCallbacks(this.j);
    }

    public void p() {
        if (this.f50963h) {
            this.f50963h = false;
            this.f50956a.postDelayed(this.j, this.f50959d - (this.f50962g - this.f50961f));
        }
    }

    public void q(b bVar) {
        this.f50964i = bVar;
    }

    public void r() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f50960e = currentTimeMillis;
        this.f50961f = currentTimeMillis;
        b bVar = this.f50964i;
        if (bVar != null) {
            long j = this.f50957b;
            bVar.a(j, j - this.f50958c);
        }
        this.f50956a.postDelayed(this.j, this.f50959d);
    }

    public void s() {
        this.f50963h = false;
        long j = this.f50960e;
        this.f50961f = j;
        this.f50962g = j;
        this.f50956a.removeCallbacks(this.j);
    }
}
