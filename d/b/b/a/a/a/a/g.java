package d.b.b.a.a.a.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f41921a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f41922b;

    /* renamed from: c  reason: collision with root package name */
    public int f41923c;

    public g() {
        int i;
        i = c.f41914d;
        this.f41921a = i;
        this.f41922b = new byte[i];
    }

    public f a() {
        return new f(Arrays.copyOf(this.f41922b, this.f41923c));
    }

    public g b(byte b2) {
        c(this.f41923c + 1);
        byte[] bArr = this.f41922b;
        int i = this.f41923c;
        this.f41923c = i + 1;
        bArr[i] = b2;
        return this;
    }

    public final void c(int i) {
        byte[] bArr = this.f41922b;
        if (i - bArr.length > 0) {
            int length = bArr.length;
            int i2 = length + (length >> 1);
            if (i2 - i >= 0) {
                i = i2;
            }
            this.f41922b = Arrays.copyOf(this.f41922b, i);
        }
    }
}
