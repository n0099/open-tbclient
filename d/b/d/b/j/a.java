package d.b.d.b.j;

import android.os.Handler;
/* loaded from: classes6.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f69782e;

    /* renamed from: f  reason: collision with root package name */
    public final long f69783f;

    /* renamed from: g  reason: collision with root package name */
    public final long f69784g;

    public a(Handler handler, long j, long j2) {
        this.f69782e = handler;
        this.f69783f = j;
        this.f69784g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f69782e.postDelayed(this, c());
        } else {
            this.f69782e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f69782e.postDelayed(this, j);
        } else {
            this.f69782e.post(this);
        }
    }

    public long c() {
        return this.f69783f;
    }

    public long d() {
        return this.f69784g;
    }
}
