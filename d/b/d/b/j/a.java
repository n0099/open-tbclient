package d.b.d.b.j;

import android.os.Handler;
/* loaded from: classes6.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f65904e;

    /* renamed from: f  reason: collision with root package name */
    public final long f65905f;

    /* renamed from: g  reason: collision with root package name */
    public final long f65906g;

    public a(Handler handler, long j, long j2) {
        this.f65904e = handler;
        this.f65905f = j;
        this.f65906g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f65904e.postDelayed(this, c());
        } else {
            this.f65904e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f65904e.postDelayed(this, j);
        } else {
            this.f65904e.post(this);
        }
    }

    public long c() {
        return this.f65905f;
    }

    public long d() {
        return this.f65906g;
    }
}
