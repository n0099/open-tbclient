package d.c.d.b.j;

import android.os.Handler;
/* loaded from: classes6.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f65871e;

    /* renamed from: f  reason: collision with root package name */
    public final long f65872f;

    /* renamed from: g  reason: collision with root package name */
    public final long f65873g;

    public a(Handler handler, long j, long j2) {
        this.f65871e = handler;
        this.f65872f = j;
        this.f65873g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f65871e.postDelayed(this, c());
        } else {
            this.f65871e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f65871e.postDelayed(this, j);
        } else {
            this.f65871e.post(this);
        }
    }

    public long c() {
        return this.f65872f;
    }

    public long d() {
        return this.f65873g;
    }
}
