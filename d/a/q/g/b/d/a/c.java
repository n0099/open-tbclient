package d.a.q.g.b.d.a;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class c implements d.a.q.g.b.e.a {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f67935a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f67936b;

    public c(byte[] bArr, byte[] bArr2) {
        this.f67935a = new BigInteger(bArr);
        this.f67936b = new BigInteger(bArr2);
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger a() {
        return this.f67936b;
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger b() {
        return this.f67935a;
    }
}
