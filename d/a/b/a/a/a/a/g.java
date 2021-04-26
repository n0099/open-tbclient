package d.a.b.a.a.a.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f39269a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f39270b;

    /* renamed from: c  reason: collision with root package name */
    public int f39271c;

    public g() {
        int i2;
        i2 = c.f39262d;
        this.f39269a = i2;
        this.f39270b = new byte[i2];
    }

    public f a() {
        return new f(Arrays.copyOf(this.f39270b, this.f39271c));
    }

    public g b(byte b2) {
        c(this.f39271c + 1);
        byte[] bArr = this.f39270b;
        int i2 = this.f39271c;
        this.f39271c = i2 + 1;
        bArr[i2] = b2;
        return this;
    }

    public final void c(int i2) {
        byte[] bArr = this.f39270b;
        if (i2 - bArr.length > 0) {
            int length = bArr.length;
            int i3 = length + (length >> 1);
            if (i3 - i2 >= 0) {
                i2 = i3;
            }
            this.f39270b = Arrays.copyOf(this.f39270b, i2);
        }
    }
}
