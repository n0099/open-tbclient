package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.util.Map;
/* loaded from: classes.dex */
class b extends d {

    /* renamed from: a  reason: collision with root package name */
    ByteArrayOutputStream f2964a;
    javassist.bytecode.annotation.c b;
    y c;
    y d;
    Map e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(byte[] bArr, y yVar, y yVar2, Map map) {
        super(bArr);
        this.f2964a = new ByteArrayOutputStream();
        this.b = new javassist.bytecode.annotation.c(this.f2964a, yVar2);
        this.c = yVar;
        this.d = yVar2;
        this.e = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        this.b.a();
        return this.f2964a.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void a(int i, int i2) {
        this.b.a(i);
        super.a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int b(int i, int i2) {
        this.b.b(i2);
        return super.b(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int a(int i, int i2, int i3) {
        this.b.a(c(i2), i3);
        return super.a(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int c(int i, int i2) {
        this.b.c(b(i2));
        return super.c(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void d(int i, int i2) {
        this.b.b(i, b(i2));
        super.d(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void b(int i, int i2, int i3) {
        this.b.c(c(i2), b(i3));
        super.b(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public void e(int i, int i2) {
        this.b.d(c(i2));
        super.e(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int a(int i) {
        this.b.b();
        return super.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.d
    public int f(int i, int i2) {
        this.b.e(i2);
        return super.f(i, i2);
    }

    int b(int i) {
        return this.c.a(i, this.d, this.e);
    }

    int c(int i) {
        return this.d.c(z.a(this.c.w(i), this.e));
    }
}
