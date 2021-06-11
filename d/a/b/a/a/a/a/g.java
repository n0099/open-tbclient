package d.a.b.a.a.a.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f41922a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f41923b;

    /* renamed from: c  reason: collision with root package name */
    public int f41924c;

    public g() {
        int i2;
        i2 = c.f41915d;
        this.f41922a = i2;
        this.f41923b = new byte[i2];
    }

    public f a() {
        return new f(Arrays.copyOf(this.f41923b, this.f41924c));
    }

    public g b(byte b2) {
        c(this.f41924c + 1);
        byte[] bArr = this.f41923b;
        int i2 = this.f41924c;
        this.f41924c = i2 + 1;
        bArr[i2] = b2;
        return this;
    }

    public final void c(int i2) {
        byte[] bArr = this.f41923b;
        if (i2 - bArr.length > 0) {
            int length = bArr.length;
            int i3 = length + (length >> 1);
            if (i3 - i2 >= 0) {
                i2 = i3;
            }
            this.f41923b = Arrays.copyOf(this.f41923b, i2);
        }
    }
}
