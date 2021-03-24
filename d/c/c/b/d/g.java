package d.c.c.b.d;

import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes5.dex */
public class g implements d.c.c.b.f.e {

    /* renamed from: a  reason: collision with root package name */
    public int f65693a;

    /* renamed from: b  reason: collision with root package name */
    public int f65694b;

    /* renamed from: c  reason: collision with root package name */
    public int f65695c;

    /* renamed from: d  reason: collision with root package name */
    public final float f65696d;

    public g() {
        this(2500, 1, 1.0f);
    }

    @Override // d.c.c.b.f.e
    public int a() {
        return this.f65693a;
    }

    public g b(int i) {
        this.f65693a = i;
        return this;
    }

    public g c(int i) {
        this.f65695c = i;
        return this;
    }

    public boolean d() {
        return this.f65694b <= this.f65695c;
    }

    public g(int i, int i2, float f2) {
        this.f65693a = i;
        this.f65695c = i2;
        this.f65696d = f2;
    }

    @Override // d.c.c.b.f.e
    public void a(VAdError vAdError) throws VAdError {
        this.f65694b++;
        int i = this.f65693a;
        this.f65693a = i + ((int) (i * this.f65696d));
        if (!d()) {
            throw vAdError;
        }
    }

    @Override // d.c.c.b.f.e
    public int b() {
        return this.f65694b;
    }
}
