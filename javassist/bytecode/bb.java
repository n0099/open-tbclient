package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends bc {

    /* renamed from: a  reason: collision with root package name */
    private int f2800a;
    private int b;

    public bb(StackMap stackMap, int i, int i2) {
        super(stackMap);
        this.f2800a = i;
        this.b = i2;
    }

    @Override // javassist.bytecode.bc
    public int a(int i, int i2, int i3) {
        if (this.f2800a == i + i2) {
            g.a(i2 - this.b, this.e, i - 4);
        } else if (this.f2800a == i) {
            g.a(this.b + i2, this.e, i - 4);
        }
        return super.a(i, i2, i3);
    }
}
