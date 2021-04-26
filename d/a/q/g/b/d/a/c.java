package d.a.q.g.b.d.a;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class c implements d.a.q.g.b.e.a {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f63704a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f63705b;

    public c(byte[] bArr, byte[] bArr2) {
        this.f63704a = new BigInteger(bArr);
        this.f63705b = new BigInteger(bArr2);
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger a() {
        return this.f63705b;
    }

    @Override // d.a.q.g.b.e.a
    public BigInteger b() {
        return this.f63704a;
    }
}
