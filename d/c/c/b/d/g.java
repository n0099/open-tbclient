package d.c.c.b.d;

import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes5.dex */
public class g implements d.c.c.b.f.e {

    /* renamed from: a  reason: collision with root package name */
    public int f65694a;

    /* renamed from: b  reason: collision with root package name */
    public int f65695b;

    /* renamed from: c  reason: collision with root package name */
    public int f65696c;

    /* renamed from: d  reason: collision with root package name */
    public final float f65697d;

    public g() {
        this(2500, 1, 1.0f);
    }

    @Override // d.c.c.b.f.e
    public int a() {
        return this.f65694a;
    }

    public g b(int i) {
        this.f65694a = i;
        return this;
    }

    public g c(int i) {
        this.f65696c = i;
        return this;
    }

    public boolean d() {
        return this.f65695b <= this.f65696c;
    }

    public g(int i, int i2, float f2) {
        this.f65694a = i;
        this.f65696c = i2;
        this.f65697d = f2;
    }

    @Override // d.c.c.b.f.e
    public void a(VAdError vAdError) throws VAdError {
        this.f65695b++;
        int i = this.f65694a;
        this.f65694a = i + ((int) (i * this.f65697d));
        if (!d()) {
            throw vAdError;
        }
    }

    @Override // d.c.c.b.f.e
    public int b() {
        return this.f65695b;
    }
}
