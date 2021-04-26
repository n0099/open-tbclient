package d.a.i0.m0;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class a implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f48647f;

    /* renamed from: g  reason: collision with root package name */
    public long f48648g;

    /* renamed from: e  reason: collision with root package name */
    public long f48646e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f48649h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f48650i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f48648g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.f48650i > 0) {
            return;
        }
        this.f48650i = (int) (60 - ((this.f48649h * 1000) / j3));
    }

    public int b() {
        return this.f48650i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f48648g = currentTimeMillis;
        this.f48647f = currentTimeMillis + 1000;
        this.f48646e = 0L;
        this.f48649h = 0;
        this.f48650i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f48649h = 0;
        this.f48648g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f48646e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f48649h = (int) (this.f48649h + (j3 / 16));
            }
        }
        this.f48646e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f48647f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f48649h = 0;
        this.f48648g = 0L;
    }
}
