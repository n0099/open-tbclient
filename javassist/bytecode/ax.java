package javassist.bytecode;

import java.util.Map;
/* loaded from: classes.dex */
class ax extends bc {

    /* renamed from: a  reason: collision with root package name */
    byte[] f2748a;
    y b;
    y c;
    Map d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(StackMap stackMap, y yVar, Map map) {
        super(stackMap);
        this.b = stackMap.c();
        this.f2748a = new byte[this.e.length];
        this.c = yVar;
        this.d = map;
    }

    @Override // javassist.bytecode.bc
    public void a() {
        g.a(g.a(this.e, 0), this.f2748a, 0);
        super.a();
    }

    @Override // javassist.bytecode.bc
    public int a(int i, int i2, int i3) {
        g.a(i2, this.f2748a, i - 4);
        return super.a(i, i2, i3);
    }

    @Override // javassist.bytecode.bc
    public int a(int i, int i2, int i3, boolean z) {
        g.a(i3, this.f2748a, i - 2);
        return super.a(i, i2, i3, z);
    }

    @Override // javassist.bytecode.bc
    public void a(int i, byte b) {
        this.f2748a[i] = b;
    }

    @Override // javassist.bytecode.bc
    public void a(int i, int i2) {
        this.f2748a[i] = 7;
        g.a(this.b.a(i2, this.c, this.d), this.f2748a, i + 1);
    }

    @Override // javassist.bytecode.bc
    public void b(int i, int i2) {
        this.f2748a[i] = 8;
        g.a(i2, this.f2748a, i + 1);
    }

    public StackMap b() {
        return new StackMap(this.c, this.f2748a);
    }
}
