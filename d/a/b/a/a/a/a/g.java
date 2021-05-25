package d.a.b.a.a.a.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f38269a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f38270b;

    /* renamed from: c  reason: collision with root package name */
    public int f38271c;

    public g() {
        int i2;
        i2 = c.f38262d;
        this.f38269a = i2;
        this.f38270b = new byte[i2];
    }

    public f a() {
        return new f(Arrays.copyOf(this.f38270b, this.f38271c));
    }

    public g b(byte b2) {
        c(this.f38271c + 1);
        byte[] bArr = this.f38270b;
        int i2 = this.f38271c;
        this.f38271c = i2 + 1;
        bArr[i2] = b2;
        return this;
    }

    public final void c(int i2) {
        byte[] bArr = this.f38270b;
        if (i2 - bArr.length > 0) {
            int length = bArr.length;
            int i3 = length + (length >> 1);
            if (i3 - i2 >= 0) {
                i2 = i3;
            }
            this.f38270b = Arrays.copyOf(this.f38270b, i2);
        }
    }
}
