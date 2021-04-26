package d.a.i0.m0.o;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class c implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f48706f;

    /* renamed from: g  reason: collision with root package name */
    public long f48707g;

    /* renamed from: e  reason: collision with root package name */
    public long f48705e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f48708h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f48709i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f48707g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.f48709i > 0) {
            return;
        }
        this.f48709i = (int) (60 - ((this.f48708h * 1000) / j3));
    }

    public int b() {
        return this.f48709i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f48707g = currentTimeMillis;
        this.f48706f = currentTimeMillis + 1000;
        this.f48705e = 0L;
        this.f48708h = 0;
        this.f48709i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f48708h = 0;
        this.f48707g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f48705e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f48708h = (int) (this.f48708h + (j3 / 16));
            }
        }
        this.f48705e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f48706f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f48708h = 0;
        this.f48707g = 0L;
    }
}
