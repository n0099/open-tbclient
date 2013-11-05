package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends bk {

    /* renamed from: a  reason: collision with root package name */
    int f2756a;
    int b;

    public bg(StackMapTable stackMapTable, int i, int i2) {
        super(stackMapTable);
        this.f2756a = i;
        this.b = i2;
    }

    @Override // javassist.bytecode.bk
    public void a(int i, int i2, int i3) {
        if (i == 8 && this.f2756a <= i2) {
            g.a(this.b + i2, this.f, i3);
        }
    }
}
