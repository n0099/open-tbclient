package d.c.d.b.j;

import android.os.Handler;
/* loaded from: classes5.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Handler f66812e;

    /* renamed from: f  reason: collision with root package name */
    public final long f66813f;

    /* renamed from: g  reason: collision with root package name */
    public final long f66814g;

    public a(Handler handler, long j, long j2) {
        this.f66812e = handler;
        this.f66813f = j;
        this.f66814g = j2;
    }

    public void a() {
        if (c() > 0) {
            this.f66812e.postDelayed(this, c());
        } else {
            this.f66812e.post(this);
        }
    }

    public void b(long j) {
        if (j > 0) {
            this.f66812e.postDelayed(this, j);
        } else {
            this.f66812e.post(this);
        }
    }

    public long c() {
        return this.f66813f;
    }

    public long d() {
        return this.f66814g;
    }
}
