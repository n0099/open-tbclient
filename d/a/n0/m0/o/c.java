package d.a.n0.m0.o;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class c implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f53361f;

    /* renamed from: g  reason: collision with root package name */
    public long f53362g;

    /* renamed from: e  reason: collision with root package name */
    public long f53360e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f53363h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f53364i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f53362g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.f53364i > 0) {
            return;
        }
        this.f53364i = (int) (60 - ((this.f53363h * 1000) / j3));
    }

    public int b() {
        return this.f53364i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f53362g = currentTimeMillis;
        this.f53361f = currentTimeMillis + 1000;
        this.f53360e = 0L;
        this.f53363h = 0;
        this.f53364i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f53363h = 0;
        this.f53362g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f53360e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f53363h = (int) (this.f53363h + (j3 / 16));
            }
        }
        this.f53360e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f53361f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f53363h = 0;
        this.f53362g = 0L;
    }
}
