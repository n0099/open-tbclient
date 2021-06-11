package d.b.c.b.d;

import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes6.dex */
public class g implements d.b.c.b.f.e {

    /* renamed from: a  reason: collision with root package name */
    public int f69493a;

    /* renamed from: b  reason: collision with root package name */
    public int f69494b;

    /* renamed from: c  reason: collision with root package name */
    public int f69495c;

    /* renamed from: d  reason: collision with root package name */
    public final float f69496d;

    public g() {
        this(2500, 1, 1.0f);
    }

    @Override // d.b.c.b.f.e
    public int a() {
        return this.f69493a;
    }

    public g b(int i2) {
        this.f69493a = i2;
        return this;
    }

    public g c(int i2) {
        this.f69495c = i2;
        return this;
    }

    public boolean d() {
        return this.f69494b <= this.f69495c;
    }

    public g(int i2, int i3, float f2) {
        this.f69493a = i2;
        this.f69495c = i3;
        this.f69496d = f2;
    }

    @Override // d.b.c.b.f.e
    public void a(VAdError vAdError) throws VAdError {
        this.f69494b++;
        int i2 = this.f69493a;
        this.f69493a = i2 + ((int) (i2 * this.f69496d));
        if (!d()) {
            throw vAdError;
        }
    }

    @Override // d.b.c.b.f.e
    public int b() {
        return this.f69494b;
    }
}
