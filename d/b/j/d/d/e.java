package d.b.j.d.d;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f63736a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f63737b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f63736a = new BigInteger(bArr);
        this.f63737b = new BigInteger(bArr2);
    }

    @Override // d.b.j.d.d.d
    public BigInteger a() {
        return this.f63736a;
    }

    @Override // d.b.j.d.d.d
    public BigInteger b() {
        return this.f63737b;
    }
}
