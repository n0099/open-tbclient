package d.a.q.g.b.d.a;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class c implements d.a.q.g.b.e.a {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f64341a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f64342b;

    public c(byte[] bArr, byte[] bArr2) {
        this.f64341a = new BigInteger(bArr);
        this.f64342b = new BigInteger(bArr2);
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger a() {
        return this.f64342b;
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger b() {
        return this.f64341a;
    }
}
