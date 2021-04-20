package d.c.d.b.j;

import android.os.Handler;
/* loaded from: classes5.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f66717e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66718f;

    /* renamed from: g  reason: collision with root package name */
    public final long f66719g;

    public a(Handler handler, long j, long j2) {
        this.f66717e = handler;
        this.f66718f = j;
        this.f66719g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f66717e.postDelayed(this, c());
        } else {
            this.f66717e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f66717e.postDelayed(this, j);
        } else {
            this.f66717e.post(this);
        }
    }

    public long c() {
        return this.f66718f;
    }

    public long d() {
        return this.f66719g;
    }
}
