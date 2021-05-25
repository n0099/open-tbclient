package d.a.m0.m0;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class a implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f49520f;

    /* renamed from: g  reason: collision with root package name */
    public long f49521g;

    /* renamed from: e  reason: collision with root package name */
    public long f49519e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f49522h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f49523i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f49521g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.f49523i > 0) {
            return;
        }
        this.f49523i = (int) (60 - ((this.f49522h * 1000) / j3));
    }

    public int b() {
        return this.f49523i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f49521g = currentTimeMillis;
        this.f49520f = currentTimeMillis + 1000;
        this.f49519e = 0L;
        this.f49522h = 0;
        this.f49523i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f49522h = 0;
        this.f49521g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f49519e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f49522h = (int) (this.f49522h + (j3 / 16));
            }
        }
        this.f49519e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f49520f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f49522h = 0;
        this.f49521g = 0L;
    }
}
