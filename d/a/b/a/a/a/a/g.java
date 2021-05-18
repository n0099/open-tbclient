package d.a.b.a.a.a.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f38514a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f38515b;

    /* renamed from: c  reason: collision with root package name */
    public int f38516c;

    public g() {
        int i2;
        i2 = c.f38507d;
        this.f38514a = i2;
        this.f38515b = new byte[i2];
    }

    public f a() {
        return new f(Arrays.copyOf(this.f38515b, this.f38516c));
    }

    public g b(byte b2) {
        c(this.f38516c + 1);
        byte[] bArr = this.f38515b;
        int i2 = this.f38516c;
        this.f38516c = i2 + 1;
        bArr[i2] = b2;
        return this;
    }

    public final void c(int i2) {
        byte[] bArr = this.f38515b;
        if (i2 - bArr.length > 0) {
            int length = bArr.length;
            int i3 = length + (length >> 1);
            if (i3 - i2 >= 0) {
                i2 = i3;
            }
            this.f38515b = Arrays.copyOf(this.f38515b, i2);
        }
    }
}
