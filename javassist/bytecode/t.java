package javassist.bytecode;
/* loaded from: classes.dex */
class t {

    /* renamed from: a  reason: collision with root package name */
    int f2830a;
    int b;
    int c;
    ab d;
    LineNumberAttribute e;
    LocalVariableAttribute f;
    LocalVariableAttribute g;
    StackMapTable h;
    StackMap i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(int i, int i2, int i3, ab abVar, CodeAttribute codeAttribute) {
        this.f2830a = i;
        this.c = i2;
        this.b = i3;
        this.d = abVar;
        this.e = (LineNumberAttribute) codeAttribute.a("LineNumberTable");
        this.f = (LocalVariableAttribute) codeAttribute.a("LocalVariableTable");
        this.g = (LocalVariableAttribute) codeAttribute.a("LocalVariableTypeTable");
        this.h = (StackMapTable) codeAttribute.a("StackMapTable");
        this.i = (StackMap) codeAttribute.a("StackMap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, boolean z) {
        if (i < this.f2830a || (i == this.f2830a && z)) {
            this.f2830a += i2;
        }
        if (i < this.c || (i == this.c && z)) {
            this.c += i2;
        }
        if (i < this.b || (i == this.b && z)) {
            this.b += i2;
        }
        this.d.a(i, i2, z);
        if (this.e != null) {
            this.e.a(i, i2, z);
        }
        if (this.f != null) {
            this.f.a(i, i2, z);
        }
        if (this.g != null) {
            this.g.a(i, i2, z);
        }
        if (this.h != null) {
            this.h.a(i, i2, z);
        }
        if (this.i != null) {
            this.i.a(i, i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (this.h != null) {
            this.h.a(i, i2);
        }
        if (this.i != null) {
            this.i.a(i, i2);
        }
    }
}
