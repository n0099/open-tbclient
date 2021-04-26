package d.b.c.b.d;

import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes5.dex */
public class g implements d.b.c.b.f.e {

    /* renamed from: a  reason: collision with root package name */
    public int f65033a;

    /* renamed from: b  reason: collision with root package name */
    public int f65034b;

    /* renamed from: c  reason: collision with root package name */
    public int f65035c;

    /* renamed from: d  reason: collision with root package name */
    public final float f65036d;

    public g() {
        this(2500, 1, 1.0f);
    }

    @Override // d.b.c.b.f.e
    public int a() {
        return this.f65033a;
    }

    public g b(int i2) {
        this.f65033a = i2;
        return this;
    }

    public g c(int i2) {
        this.f65035c = i2;
        return this;
    }

    public boolean d() {
        return this.f65034b <= this.f65035c;
    }

    public g(int i2, int i3, float f2) {
        this.f65033a = i2;
        this.f65035c = i3;
        this.f65036d = f2;
    }

    @Override // d.b.c.b.f.e
    public void a(VAdError vAdError) throws VAdError {
        this.f65034b++;
        int i2 = this.f65033a;
        this.f65033a = i2 + ((int) (i2 * this.f65036d));
        if (!d()) {
            throw vAdError;
        }
    }

    @Override // d.b.c.b.f.e
    public int b() {
        return this.f65034b;
    }
}
