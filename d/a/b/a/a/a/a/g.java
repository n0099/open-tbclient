package d.a.b.a.a.a.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f42025a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f42026b;

    /* renamed from: c  reason: collision with root package name */
    public int f42027c;

    public g() {
        int i2;
        i2 = c.f42018d;
        this.f42025a = i2;
        this.f42026b = new byte[i2];
    }

    public f a() {
        return new f(Arrays.copyOf(this.f42026b, this.f42027c));
    }

    public g b(byte b2) {
        c(this.f42027c + 1);
        byte[] bArr = this.f42026b;
        int i2 = this.f42027c;
        this.f42027c = i2 + 1;
        bArr[i2] = b2;
        return this;
    }

    public final void c(int i2) {
        byte[] bArr = this.f42026b;
        if (i2 - bArr.length > 0) {
            int length = bArr.length;
            int i3 = length + (length >> 1);
            if (i3 - i2 >= 0) {
                i2 = i3;
            }
            this.f42026b = Arrays.copyOf(this.f42026b, i2);
        }
    }
}
