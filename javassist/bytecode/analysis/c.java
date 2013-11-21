package javassist.bytecode.analysis;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private h[] f2754a;
    private h[] b;
    private int c;
    private boolean d;
    private boolean e;

    public c(int i, int i2) {
        this.f2754a = new h[i];
        this.b = new h[i2];
    }

    public h a(int i) {
        return this.f2754a[i];
    }

    public void a(int i, h hVar) {
        this.f2754a[i] = hVar;
    }

    public h b(int i) {
        return this.b[i];
    }

    public void b(int i, h hVar) {
        this.b[i] = hVar;
    }

    public void a() {
        this.c = 0;
    }

    public int b() {
        return this.c - 1;
    }

    public int c() {
        return this.f2754a.length;
    }

    public h d() {
        if (this.c < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return this.b[this.c - 1];
    }

    public h e() {
        if (this.c < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        h[] hVarArr = this.b;
        int i = this.c - 1;
        this.c = i;
        return hVarArr[i];
    }

    public void a(h hVar) {
        h[] hVarArr = this.b;
        int i = this.c;
        this.c = i + 1;
        hVarArr[i] = hVar;
    }

    public c f() {
        c cVar = new c(this.f2754a.length, this.b.length);
        System.arraycopy(this.f2754a, 0, cVar.f2754a, 0, this.f2754a.length);
        System.arraycopy(this.b, 0, cVar.b, 0, this.b.length);
        cVar.c = this.c;
        return cVar;
    }

    public c g() {
        c cVar = new c(this.f2754a.length, this.b.length);
        System.arraycopy(this.b, 0, cVar.b, 0, this.b.length);
        cVar.c = this.c;
        return cVar;
    }

    public boolean a(c cVar) {
        if (this.c != cVar.c) {
            throw new RuntimeException("Operand stacks could not be merged, they are different sizes!");
        }
        boolean z = false;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != null) {
                h hVar = this.b[i];
                h c = hVar.c(cVar.b[i]);
                if (c == h.m) {
                    throw new RuntimeException("Operand stacks could not be merged due to differing primitive types: pos = " + i);
                }
                this.b[i] = c;
                if (!c.equals(hVar) || c.b()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean b(c cVar) {
        boolean z = false;
        for (int i = 0; i < this.f2754a.length; i++) {
            if (this.f2754a[i] != null) {
                h hVar = this.f2754a[i];
                h c = hVar.c(cVar.f2754a[i]);
                this.f2754a[i] = c;
                if (!c.equals(hVar) || c.b()) {
                    z = true;
                }
            } else if (cVar.f2754a[i] != null) {
                this.f2754a[i] = cVar.f2754a[i];
                z = true;
            }
        }
        return a(cVar) | z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("locals = [");
        for (int i = 0; i < this.f2754a.length; i++) {
            stringBuffer.append(this.f2754a[i] == null ? "empty" : this.f2754a[i].toString());
            if (i < this.f2754a.length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("] stack = [");
        for (int i2 = 0; i2 < this.c; i2++) {
            stringBuffer.append(this.b[i2]);
            if (i2 < this.c - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.e = z;
    }
}
