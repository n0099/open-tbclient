package d.b.j.d.d;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f64436a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f64437b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f64436a = new BigInteger(bArr);
        this.f64437b = new BigInteger(bArr2);
    }

    @Override // d.b.j.d.d.d
    public BigInteger a() {
        return this.f64436a;
    }

    @Override // d.b.j.d.d.d
    public BigInteger b() {
        return this.f64437b;
    }
}
