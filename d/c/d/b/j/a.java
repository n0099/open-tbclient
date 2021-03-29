package d.c.d.b.j;

import android.os.Handler;
/* loaded from: classes6.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f65872e;

    /* renamed from: f  reason: collision with root package name */
    public final long f65873f;

    /* renamed from: g  reason: collision with root package name */
    public final long f65874g;

    public a(Handler handler, long j, long j2) {
        this.f65872e = handler;
        this.f65873f = j;
        this.f65874g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f65872e.postDelayed(this, c());
        } else {
            this.f65872e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f65872e.postDelayed(this, j);
        } else {
            this.f65872e.post(this);
        }
    }

    public long c() {
        return this.f65873f;
    }

    public long d() {
        return this.f65874g;
    }
}
