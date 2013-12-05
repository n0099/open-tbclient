package javassist.bytecode.annotation;

import java.io.OutputStream;
import javassist.bytecode.g;
import javassist.bytecode.y;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f2955a;
    private y b;

    public c(OutputStream outputStream, y yVar) {
        this.f2955a = outputStream;
        this.b = yVar;
    }

    public void a() {
        this.f2955a.close();
    }

    public void a(int i) {
        this.f2955a.write(i);
    }

    public void b(int i) {
        f(i);
    }

    public void a(int i, int i2) {
        f(i);
        f(i2);
    }

    public void c(int i) {
        f(i);
    }

    public void b(int i, int i2) {
        this.f2955a.write(i);
        f(i2);
    }

    public void c(int i, int i2) {
        this.f2955a.write(101);
        f(i);
        f(i2);
    }

    public void d(int i) {
        this.f2955a.write(99);
        f(i);
    }

    public void b() {
        this.f2955a.write(64);
    }

    public void e(int i) {
        this.f2955a.write(91);
        f(i);
    }

    private void f(int i) {
        byte[] bArr = new byte[2];
        g.a(i, bArr, 0);
        this.f2955a.write(bArr);
    }
}
