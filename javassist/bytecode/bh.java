package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends bk {

    /* renamed from: a  reason: collision with root package name */
    int f2789a;
    int b;
    int c;
    byte[] d;
    boolean e;
    private StackMapTable h;

    public bh(StackMapTable stackMapTable, int i, int i2, boolean z) {
        super(stackMapTable);
        this.h = stackMapTable;
        this.f2789a = i;
        this.b = i2;
        this.c = 0;
        this.d = null;
        this.e = z;
    }

    public void a() {
        b();
        if (this.d != null) {
            this.h.a(this.d);
        }
    }

    @Override // javassist.bytecode.bk
    public void a_(int i, int i2) {
        b(i, i2, 0, 251);
    }

    @Override // javassist.bytecode.bk
    public void a(int i, int i2, int i3, int i4) {
        b(i, i2, 64, 247);
    }

    void b(int i, int i2, int i3, int i4) {
        boolean z = true;
        int i5 = this.c;
        this.c = (i5 == 0 ? 0 : 1) + i5 + i2;
        if (this.e) {
            if (i5 >= this.f2789a || this.f2789a > this.c) {
                z = false;
            }
        } else if (i5 > this.f2789a || this.f2789a >= this.c) {
            z = false;
        }
        if (z) {
            int i6 = this.b + i2;
            this.c += this.b;
            if (i6 < 64) {
                this.f[i] = (byte) (i6 + i3);
            } else if (i2 < 64) {
                byte[] a2 = a(this.f, i, 2);
                a2[i] = (byte) i4;
                g.a(i6, a2, i + 1);
                this.d = a2;
            } else {
                g.a(i6, this.f, i + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length + i2];
        int i3 = 0;
        while (i3 < length) {
            bArr2[(i3 < i ? 0 : i2) + i3] = bArr[i3];
            i3++;
        }
        return bArr2;
    }

    @Override // javassist.bytecode.bk
    public void b(int i, int i2, int i3) {
        b(i, i2);
    }

    @Override // javassist.bytecode.bk
    public void a(int i, int i2, int[] iArr, int[] iArr2) {
        b(i, i2);
    }

    @Override // javassist.bytecode.bk
    public void a(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        b(i, i2);
    }

    void b(int i, int i2) {
        boolean z = true;
        int i3 = this.c;
        this.c = (i3 == 0 ? 0 : 1) + i3 + i2;
        if (this.e) {
            if (i3 >= this.f2789a || this.f2789a > this.c) {
                z = false;
            }
        } else if (i3 > this.f2789a || this.f2789a >= this.c) {
            z = false;
        }
        if (z) {
            g.a(this.b + i2, this.f, i + 1);
            this.c += this.b;
        }
    }
}
