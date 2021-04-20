package d.b.h0.m0;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes3.dex */
public class a implements Choreographer.FrameCallback {

    /* renamed from: f  reason: collision with root package name */
    public long f50712f;

    /* renamed from: g  reason: collision with root package name */
    public long f50713g;

    /* renamed from: e  reason: collision with root package name */
    public long f50711e = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f50714h = 0;
    public int i = -1;
    public boolean j = false;

    public final void a(long j) {
        long j2 = this.f50713g;
        if (j2 <= 0) {
            return;
        }
        long j3 = j - j2;
        if (j3 <= 0 || this.i > 0) {
            return;
        }
        this.i = (int) (60 - ((this.f50714h * 1000) / j3));
    }

    public int b() {
        return this.i;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f50713g = currentTimeMillis;
        this.f50712f = currentTimeMillis + 1000;
        this.f50711e = 0L;
        this.f50714h = 0;
        this.i = -1;
        this.j = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void d() {
        this.j = true;
        Choreographer.getInstance().removeFrameCallback(this);
        a(System.currentTimeMillis());
        this.f50714h = 0;
        this.f50713g = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.f50711e;
        if (j2 != 0) {
            long j3 = (j - j2) / 1000000;
            if (j3 > 16 && j3 < 960) {
                this.f50714h = (int) (this.f50714h + (j3 / 16));
            }
        }
        this.f50711e = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f50712f && !this.j) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        a(currentTimeMillis);
        this.f50714h = 0;
        this.f50713g = 0L;
    }
}
