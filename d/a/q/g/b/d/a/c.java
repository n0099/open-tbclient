package d.a.q.g.b.d.a;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class c implements d.a.q.g.b.e.a {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f64217a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f64218b;

    public c(byte[] bArr, byte[] bArr2) {
        this.f64217a = new BigInteger(bArr);
        this.f64218b = new BigInteger(bArr2);
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger a() {
        return this.f64218b;
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger b() {
        return this.f64217a;
    }
}
