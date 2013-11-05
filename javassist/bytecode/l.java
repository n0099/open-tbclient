package javassist.bytecode;
/* loaded from: classes.dex */
abstract class l {

    /* renamed from: a  reason: collision with root package name */
    int f2769a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a(int i, byte[] bArr, int i2, byte[] bArr2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i) {
        this.b = i;
        this.f2769a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, boolean z) {
        if (i < this.f2769a || (i == this.f2769a && z)) {
            this.f2769a += i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2, int i3, int i4, boolean z) {
        int i5 = i + i2;
        if (i < i3) {
            if (i3 < i5 || (z && i3 == i5)) {
                return i2 + i4;
            }
            return i2;
        } else if (i == i3) {
            if (i5 < i3 && z) {
                return i2 - i4;
            }
            if (i3 < i5 && !z) {
                return i2 + i4;
            }
            return i2;
        } else if (i5 < i3 || (!z && i3 == i5)) {
            return i2 - i4;
        } else {
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return 0;
    }
}
