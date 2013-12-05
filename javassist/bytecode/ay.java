package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends ba {

    /* renamed from: a  reason: collision with root package name */
    int f2962a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(StackMap stackMap, int i) {
        super(stackMap);
        this.f2962a = i;
    }

    @Override // javassist.bytecode.bc
    public int b(int i, int i2, int i3) {
        return c(i, i2, i3);
    }

    private int c(int i, int i2, int i3) {
        int i4;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            byte b = this.e[i6];
            if (b == 7) {
                i6 += 3;
            } else if (b == 8) {
                if (g.a(this.e, i6 + 1) == this.f2962a) {
                    i5++;
                }
                i6 += 3;
            } else {
                i6++;
            }
        }
        this.b.a(i3 - i5);
        int i8 = 0;
        while (i8 < i3) {
            byte b2 = this.e[i];
            if (b2 == 7) {
                a(i, g.a(this.e, i + 1));
                i4 = i + 3;
            } else if (b2 == 8) {
                int a2 = g.a(this.e, i + 1);
                if (a2 != this.f2962a) {
                    b(i, a2);
                }
                i4 = i + 3;
            } else {
                a(i, b2);
                i4 = i + 1;
            }
            i8++;
            i = i4;
        }
        return i;
    }
}
