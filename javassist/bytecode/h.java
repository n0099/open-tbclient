package javassist.bytecode;
/* loaded from: classes.dex */
class h implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f2797a = new byte[64];
    private int b = 0;

    public Object clone() {
        h hVar = (h) super.clone();
        hVar.f2797a = (byte[]) this.f2797a.clone();
        return hVar;
    }

    public final int a() {
        return this.b;
    }

    public final byte[] b() {
        byte[] bArr = new byte[this.b];
        System.arraycopy(this.f2797a, 0, bArr, 0, this.b);
        return bArr;
    }

    public void a(int i, int i2) {
        if (i < 0 || this.b <= i) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        this.f2797a[i] = (byte) i2;
    }

    public void a(int i) {
        b(1);
        this.f2797a[this.b - 1] = (byte) i;
    }

    public void b(int i, int i2) {
        b(2);
        this.f2797a[this.b - 2] = (byte) i;
        this.f2797a[this.b - 1] = (byte) i2;
    }

    public void a(int i, int i2, int i3, int i4) {
        b(4);
        this.f2797a[this.b - 4] = (byte) i;
        this.f2797a[this.b - 3] = (byte) i2;
        this.f2797a[this.b - 2] = (byte) i3;
        this.f2797a[this.b - 1] = (byte) i4;
    }

    public void b(int i) {
        if (this.b + i > this.f2797a.length) {
            int i2 = this.b << 1;
            if (i2 < this.b + i) {
                i2 = this.b + i;
            }
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f2797a, 0, bArr, 0, this.b);
            this.f2797a = bArr;
        }
        this.b += i;
    }
}
