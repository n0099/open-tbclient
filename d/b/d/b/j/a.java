package d.b.d.b.j;

import android.os.Handler;
/* loaded from: classes6.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f65947e;

    /* renamed from: f  reason: collision with root package name */
    public final long f65948f;

    /* renamed from: g  reason: collision with root package name */
    public final long f65949g;

    public a(Handler handler, long j, long j2) {
        this.f65947e = handler;
        this.f65948f = j;
        this.f65949g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f65947e.postDelayed(this, c());
        } else {
            this.f65947e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f65947e.postDelayed(this, j);
        } else {
            this.f65947e.post(this);
        }
    }

    public long c() {
        return this.f65948f;
    }

    public long d() {
        return this.f65949g;
    }
}
