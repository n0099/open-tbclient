package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends bc {

    /* renamed from: a  reason: collision with root package name */
    private int f2798a;
    private int b;
    private boolean c;

    public az(StackMap stackMap, int i, int i2, boolean z) {
        super(stackMap);
        this.f2798a = i;
        this.b = i2;
        this.c = z;
    }

    @Override // javassist.bytecode.bc
    public int a(int i, int i2, int i3) {
        if (!this.c ? this.f2798a < i2 : this.f2798a <= i2) {
            g.a(this.b + i2, this.e, i - 4);
        }
        return super.a(i, i2, i3);
    }

    @Override // javassist.bytecode.bc
    public void b(int i, int i2) {
        if (this.f2798a <= i2) {
            g.a(this.b + i2, this.e, i + 1);
        }
    }
}
