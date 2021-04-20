package d.b.p.g.b.d.a;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class c implements d.b.p.g.b.e.a {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f65121a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f65122b;

    public c(byte[] bArr, byte[] bArr2) {
        this.f65121a = new BigInteger(bArr);
        this.f65122b = new BigInteger(bArr2);
    }

    @Override // d.b.p.g.b.e.a
    public BigInteger a() {
        return this.f65122b;
    }

    @Override // d.b.p.g.b.e.a
    public BigInteger b() {
        return this.f65121a;
    }
}
