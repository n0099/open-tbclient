package d.b.q.g.b.d.a;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class c implements d.b.q.g.b.e.a {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f64426a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f64427b;

    public c(byte[] bArr, byte[] bArr2) {
        this.f64426a = new BigInteger(bArr);
        this.f64427b = new BigInteger(bArr2);
    }

    @Override // d.b.q.g.b.e.a
    public BigInteger a() {
        return this.f64427b;
    }

    @Override // d.b.q.g.b.e.a
    public BigInteger b() {
        return this.f64426a;
    }
}
