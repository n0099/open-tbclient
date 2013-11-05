package javassist.bytecode;
/* loaded from: classes.dex */
public class bc {
    byte[] e;

    public bc(StackMap stackMap) {
        this.e = stackMap.e();
    }

    public void a() {
        int a2 = g.a(this.e, 0);
        int i = 2;
        for (int i2 = 0; i2 < a2; i2++) {
            int a3 = g.a(this.e, i);
            int a4 = a(i + 4, a3, g.a(this.e, i + 2));
            i = b(a4 + 2, a3, g.a(this.e, a4));
        }
    }

    public int a(int i, int i2, int i3) {
        return a(i, i2, i3, true);
    }

    public int b(int i, int i2, int i3) {
        return a(i, i2, i3, false);
    }

    public int a(int i, int i2, int i3, boolean z) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = c(i4, i);
        }
        return i;
    }

    int c(int i, int i2) {
        byte b = this.e[i2];
        if (b == 7) {
            a(i2, g.a(this.e, i2 + 1));
            return i2 + 3;
        } else if (b == 8) {
            b(i2, g.a(this.e, i2 + 1));
            return i2 + 3;
        } else {
            a(i2, b);
            return i2 + 1;
        }
    }

    public void a(int i, byte b) {
    }

    public void a(int i, int i2) {
    }

    public void b(int i, int i2) {
    }
}
