package d.b.b.a.a.a.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f42087a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f42088b;

    /* renamed from: c  reason: collision with root package name */
    public int f42089c;

    public g() {
        int i;
        i = c.f42080d;
        this.f42087a = i;
        this.f42088b = new byte[i];
    }

    public f a() {
        return new f(Arrays.copyOf(this.f42088b, this.f42089c));
    }

    public g b(byte b2) {
        c(this.f42089c + 1);
        byte[] bArr = this.f42088b;
        int i = this.f42089c;
        this.f42089c = i + 1;
        bArr[i] = b2;
        return this;
    }

    public final void c(int i) {
        byte[] bArr = this.f42088b;
        if (i - bArr.length > 0) {
            int length = bArr.length;
            int i2 = length + (length >> 1);
            if (i2 - i >= 0) {
                i = i2;
            }
            this.f42088b = Arrays.copyOf(this.f42088b, i);
        }
    }
}
