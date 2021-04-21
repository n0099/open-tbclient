package d.c.c.b.d;

import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes5.dex */
public class g implements d.c.c.b.f.e {

    /* renamed from: a  reason: collision with root package name */
    public int f66634a;

    /* renamed from: b  reason: collision with root package name */
    public int f66635b;

    /* renamed from: c  reason: collision with root package name */
    public int f66636c;

    /* renamed from: d  reason: collision with root package name */
    public final float f66637d;

    public g() {
        this(2500, 1, 1.0f);
    }

    @Override // d.c.c.b.f.e
    public int a() {
        return this.f66634a;
    }

    public g b(int i) {
        this.f66634a = i;
        return this;
    }

    public g c(int i) {
        this.f66636c = i;
        return this;
    }

    public boolean d() {
        return this.f66635b <= this.f66636c;
    }

    public g(int i, int i2, float f2) {
        this.f66634a = i;
        this.f66636c = i2;
        this.f66637d = f2;
    }

    @Override // d.c.c.b.f.e
    public void a(VAdError vAdError) throws VAdError {
        this.f66635b++;
        int i = this.f66634a;
        this.f66634a = i + ((int) (i * this.f66637d));
        if (!d()) {
            throw vAdError;
        }
    }

    @Override // d.c.c.b.f.e
    public int b() {
        return this.f66635b;
    }
}
