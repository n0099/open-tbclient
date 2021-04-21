package d.b.i0.m0;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class a implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f51048f;

    /* renamed from: g  reason: collision with root package name */
    public long f51049g;

    /* renamed from: e  reason: collision with root package name */
    public long f51047e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f51050h = 0;
    public int i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f51049g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.i > 0) {
            return;
        }
        this.i = (int) (60 - ((this.f51050h * 1000) / j3));
    }

    public int b() {
        return this.i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f51049g = currentTimeMillis;
        this.f51048f = currentTimeMillis + 1000;
        this.f51047e = 0L;
        this.f51050h = 0;
        this.i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f51050h = 0;
        this.f51049g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f51047e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f51050h = (int) (this.f51050h + (j3 / 16));
            }
        }
        this.f51047e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f51048f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f51050h = 0;
        this.f51049g = 0L;
    }
}
