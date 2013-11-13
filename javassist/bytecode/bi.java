package javassist.bytecode;
/* loaded from: classes.dex */
class bi extends bk {

    /* renamed from: a  reason: collision with root package name */
    private bl f2806a;

    public bi(byte[] bArr) {
        super(bArr);
        this.f2806a = new bl(bArr.length);
    }

    public byte[] a() {
        b();
        return this.f2806a.a();
    }

    @Override // javassist.bytecode.bk
    public void a_(int i, int i2) {
        this.f2806a.a(i2);
    }

    @Override // javassist.bytecode.bk
    public void a(int i, int i2, int i3, int i4) {
        this.f2806a.a(i2, i3, a(i3, i4));
    }

    @Override // javassist.bytecode.bk
    public void b(int i, int i2, int i3) {
        this.f2806a.a(i2, i3);
    }

    @Override // javassist.bytecode.bk
    public void a(int i, int i2, int[] iArr, int[] iArr2) {
        this.f2806a.a(i2, iArr, a(iArr, iArr2));
    }

    @Override // javassist.bytecode.bk
    public void a(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        this.f2806a.a(i2, iArr, a(iArr, iArr2), iArr3, a(iArr3, iArr4));
    }

    protected int a(int i, int i2) {
        return i2;
    }

    protected int[] a(int[] iArr, int[] iArr2) {
        return iArr2;
    }
}
