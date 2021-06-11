package d.a.m0.m0;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class a implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f53195f;

    /* renamed from: g  reason: collision with root package name */
    public long f53196g;

    /* renamed from: e  reason: collision with root package name */
    public long f53194e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f53197h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f53198i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f53196g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.f53198i > 0) {
            return;
        }
        this.f53198i = (int) (60 - ((this.f53197h * 1000) / j3));
    }

    public int b() {
        return this.f53198i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f53196g = currentTimeMillis;
        this.f53195f = currentTimeMillis + 1000;
        this.f53194e = 0L;
        this.f53197h = 0;
        this.f53198i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f53197h = 0;
        this.f53196g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f53194e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f53197h = (int) (this.f53197h + (j3 / 16));
            }
        }
        this.f53194e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f53195f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f53197h = 0;
        this.f53196g = 0L;
    }
}
