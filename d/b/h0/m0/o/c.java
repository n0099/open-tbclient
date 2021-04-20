package d.b.h0.m0.o;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class c implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f50767f;

    /* renamed from: g  reason: collision with root package name */
    public long f50768g;

    /* renamed from: e  reason: collision with root package name */
    public long f50766e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f50769h = 0;
    public int i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f50768g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.i > 0) {
            return;
        }
        this.i = (int) (60 - ((this.f50769h * 1000) / j3));
    }

    public int b() {
        return this.i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f50768g = currentTimeMillis;
        this.f50767f = currentTimeMillis + 1000;
        this.f50766e = 0L;
        this.f50769h = 0;
        this.i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f50769h = 0;
        this.f50768g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f50766e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f50769h = (int) (this.f50769h + (j3 / 16));
            }
        }
        this.f50766e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f50767f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f50769h = 0;
        this.f50768g = 0L;
    }
}
