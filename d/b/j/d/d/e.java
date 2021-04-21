package d.b.j.d.d;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f52631a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f52632b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f52631a = new BigInteger(bArr);
        this.f52632b = new BigInteger(bArr2);
    }

    @Override // d.b.j.d.d.d
    public BigInteger a() {
        return this.f52631a;
    }

    @Override // d.b.j.d.d.d
    public BigInteger b() {
        return this.f52632b;
    }
}
