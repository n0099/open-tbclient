package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends bc {
    bd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(StackMap stackMap) {
        super(stackMap);
        this.b = new bd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() {
        a();
        return this.b.a();
    }

    @Override // javassist.bytecode.bc
    public void a() {
        this.b.a(g.a(this.e, 0));
        super.a();
    }

    @Override // javassist.bytecode.bc
    public int a(int i, int i2, int i3) {
        this.b.a(i2);
        return super.a(i, i2, i3);
    }

    @Override // javassist.bytecode.bc
    public int a(int i, int i2, int i3, boolean z) {
        this.b.a(i3);
        return super.a(i, i2, i3, z);
    }

    @Override // javassist.bytecode.bc
    public void a(int i, byte b) {
        this.b.a(b, 0);
    }

    @Override // javassist.bytecode.bc
    public void a(int i, int i2) {
        this.b.a(7, i2);
    }

    @Override // javassist.bytecode.bc
    public void b(int i, int i2) {
        this.b.a(8, i2);
    }
}
