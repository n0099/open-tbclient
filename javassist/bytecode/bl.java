package javassist.bytecode;

import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    ByteArrayOutputStream f2807a;
    int b = 0;

    public bl(int i) {
        this.f2807a = new ByteArrayOutputStream(i);
        this.f2807a.write(0);
        this.f2807a.write(0);
    }

    public byte[] a() {
        byte[] byteArray = this.f2807a.toByteArray();
        g.a(this.b, byteArray, 0);
        return byteArray;
    }

    public StackMapTable a(y yVar) {
        return new StackMapTable(yVar, a());
    }

    public void a(int i) {
        this.b++;
        if (i < 64) {
            this.f2807a.write(i);
            return;
        }
        this.f2807a.write(251);
        b(i);
    }

    public void a(int i, int i2, int i3) {
        this.b++;
        if (i < 64) {
            this.f2807a.write(i + 64);
        } else {
            this.f2807a.write(247);
            b(i);
        }
        b(i2, i3);
    }

    public void a(int i, int i2) {
        this.b++;
        this.f2807a.write(251 - i2);
        b(i);
    }

    public void a(int i, int[] iArr, int[] iArr2) {
        this.b++;
        int length = iArr.length;
        this.f2807a.write(length + 251);
        b(i);
        for (int i2 = 0; i2 < length; i2++) {
            b(iArr[i2], iArr2[i2]);
        }
    }

    public void a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        this.b++;
        this.f2807a.write(Util.MASK_8BIT);
        b(i);
        int length = iArr.length;
        b(length);
        for (int i2 = 0; i2 < length; i2++) {
            b(iArr[i2], iArr2[i2]);
        }
        int length2 = iArr3.length;
        b(length2);
        for (int i3 = 0; i3 < length2; i3++) {
            b(iArr3[i3], iArr4[i3]);
        }
    }

    private void b(int i, int i2) {
        this.f2807a.write(i);
        if (i == 7 || i == 8) {
            b(i2);
        }
    }

    private void b(int i) {
        this.f2807a.write((i >>> 8) & Util.MASK_8BIT);
        this.f2807a.write(i & Util.MASK_8BIT);
    }
}
