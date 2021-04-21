package d.b.q.g.b.d.a;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class c implements d.b.q.g.b.e.a {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f65385a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f65386b;

    public c(byte[] bArr, byte[] bArr2) {
        this.f65385a = new BigInteger(bArr);
        this.f65386b = new BigInteger(bArr2);
    }

    @Override // d.b.q.g.b.e.a
    public BigInteger a() {
        return this.f65386b;
    }

    @Override // d.b.q.g.b.e.a
    public BigInteger b() {
        return this.f65385a;
    }
}
