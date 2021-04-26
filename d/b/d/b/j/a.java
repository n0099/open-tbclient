package d.b.d.b.j;

import android.os.Handler;
/* loaded from: classes5.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f65218e;

    /* renamed from: f  reason: collision with root package name */
    public final long f65219f;

    /* renamed from: g  reason: collision with root package name */
    public final long f65220g;

    public a(Handler handler, long j, long j2) {
        this.f65218e = handler;
        this.f65219f = j;
        this.f65220g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f65218e.postDelayed(this, c());
        } else {
            this.f65218e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f65218e.postDelayed(this, j);
        } else {
            this.f65218e.post(this);
        }
    }

    public long c() {
        return this.f65219f;
    }

    public long d() {
        return this.f65220g;
    }
}
