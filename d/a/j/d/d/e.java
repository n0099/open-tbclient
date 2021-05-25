package d.a.j.d.d;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f40200a;

    /* renamed from: b  reason: collision with root package name */
    public BigInteger f40201b;

    public e(byte[] bArr, byte[] bArr2) {
        this.f40200a = new BigInteger(bArr);
        this.f40201b = new BigInteger(bArr2);
    }

    @Override // d.a.j.d.d.d
    public BigInteger a() {
        return this.f40200a;
    }

    @Override // d.a.j.d.d.d
    public BigInteger b() {
        return this.f40201b;
    }
}
