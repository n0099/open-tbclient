package javassist.bytecode;

import javassist.CtPrimitiveType;
/* loaded from: classes.dex */
public class Bytecode extends h implements Cloneable, as {

    /* renamed from: a  reason: collision with root package name */
    public static final javassist.h f2698a = y.e;
    y b;
    int c;
    int d;
    ab e;
    private int g;

    @Override // javassist.bytecode.h
    public /* bridge */ /* synthetic */ void a(int i, int i2, int i3, int i4) {
        super.a(i, i2, i3, i4);
    }

    @Override // javassist.bytecode.h
    public /* bridge */ /* synthetic */ void b(int i, int i2) {
        super.b(i, i2);
    }

    public Bytecode(y yVar, int i, int i2) {
        this.b = yVar;
        this.c = i;
        this.d = i2;
        this.e = new ab(yVar);
        this.g = 0;
    }

    public Bytecode(y yVar) {
        this(yVar, 0, 0);
    }

    @Override // javassist.bytecode.h
    public Object clone() {
        try {
            Bytecode bytecode = (Bytecode) super.clone();
            bytecode.e = (ab) this.e.clone();
            return bytecode;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public y c() {
        return this.b;
    }

    public ab d() {
        return this.e;
    }

    public CodeAttribute e() {
        return new CodeAttribute(this.b, this.c, this.d, f(), this.e);
    }

    public byte[] f() {
        return b();
    }

    public void c(int i) {
        this.c = i;
    }

    public int g() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public void a(boolean z, javassist.h[] hVarArr, int i) {
        int i2 = !z ? i + 1 : i;
        if (hVarArr != null) {
            javassist.h hVar = javassist.h.k;
            javassist.h hVar2 = javassist.h.i;
            for (javassist.h hVar3 : hVarArr) {
                if (hVar3 == hVar || hVar3 == hVar2) {
                    i2 += 2;
                } else {
                    i2++;
                }
            }
        }
        this.d = i2;
    }

    public void e(int i) {
        this.d += i;
    }

    public void a(int i, int i2, int i3, javassist.h hVar) {
        b(i, i2, i3, this.b.a(hVar));
    }

    public void a(int i, int i2, int i3, String str) {
        b(i, i2, i3, this.b.a(str));
    }

    public void b(int i, int i2, int i3, int i4) {
        this.e.a(i, i2, i3, i4);
    }

    public int h() {
        return a();
    }

    @Override // javassist.bytecode.h
    public void a(int i, int i2) {
        super.a(i, i2);
    }

    public void c(int i, int i2) {
        a(i, i2 >> 8);
        a(i + 1, i2);
    }

    public void d(int i, int i2) {
        c(i, i2 >> 16);
        c(i + 2, i2);
    }

    @Override // javassist.bytecode.h
    public void a(int i) {
        super.a(i);
    }

    public void f(int i) {
        a(i >> 24, i >> 16, i >> 8, i);
    }

    @Override // javassist.bytecode.h
    public void b(int i) {
        super.b(i);
    }

    public void g(int i) {
        a(i);
        h(f[i]);
    }

    public void h(int i) {
        i(this.g + i);
    }

    public int i() {
        return this.g;
    }

    public void i(int i) {
        this.g = i;
        if (this.g > this.c) {
            this.c = this.g;
        }
    }

    public void j(int i) {
        b(i >> 8, i);
    }

    public void k(int i) {
        if (i < 4) {
            g(i + 42);
        } else if (i < 256) {
            g(25);
            a(i);
        } else {
            g(196);
            g(25);
            j(i);
        }
    }

    public void l(int i) {
        if (i < 4) {
            g(i + 75);
        } else if (i < 256) {
            g(58);
            a(i);
        } else {
            g(196);
            g(58);
            j(i);
        }
    }

    public void m(int i) {
        if (i < 6 && -2 < i) {
            g(i + 3);
        } else if (i <= 127 && -128 <= i) {
            g(16);
            a(i);
        } else if (i <= 32767 && -32768 <= i) {
            g(17);
            a(i >> 8);
            a(i);
        } else {
            v(this.b.y(i));
        }
    }

    public void n(int i) {
        if (i < 4) {
            g(i + 26);
        } else if (i < 256) {
            g(21);
            a(i);
        } else {
            g(196);
            g(21);
            j(i);
        }
    }

    public void o(int i) {
        if (i < 4) {
            g(i + 59);
        } else if (i < 256) {
            g(54);
            a(i);
        } else {
            g(196);
            g(54);
            j(i);
        }
    }

    public void a(long j) {
        if (j == 0 || j == 1) {
            g(((int) j) + 9);
        } else {
            b(j);
        }
    }

    public void p(int i) {
        if (i < 4) {
            g(i + 30);
        } else if (i < 256) {
            g(22);
            a(i);
        } else {
            g(196);
            g(22);
            j(i);
        }
    }

    public void q(int i) {
        if (i < 4) {
            g(i + 63);
        } else if (i < 256) {
            g(55);
            a(i);
        } else {
            g(196);
            g(55);
            j(i);
        }
    }

    public void a(double d) {
        if (d == 0.0d || d == 1.0d) {
            g(((int) d) + 14);
        } else {
            b(d);
        }
    }

    public void r(int i) {
        if (i < 4) {
            g(i + 38);
        } else if (i < 256) {
            g(24);
            a(i);
        } else {
            g(196);
            g(24);
            j(i);
        }
    }

    public void s(int i) {
        if (i < 4) {
            g(i + 71);
        } else if (i < 256) {
            g(57);
            a(i);
        } else {
            g(196);
            g(57);
            j(i);
        }
    }

    public void a(float f) {
        if (f == 0.0f || f == 1.0f || f == 2.0f) {
            g(((int) f) + 11);
        } else {
            v(this.b.a(f));
        }
    }

    public void t(int i) {
        if (i < 4) {
            g(i + 34);
        } else if (i < 256) {
            g(23);
            a(i);
        } else {
            g(196);
            g(23);
            j(i);
        }
    }

    public void u(int i) {
        if (i < 4) {
            g(i + 67);
        } else if (i < 256) {
            g(56);
            a(i);
        } else {
            g(196);
            g(56);
            j(i);
        }
    }

    public int a(int i, javassist.h hVar) {
        if (hVar.m()) {
            if (hVar == javassist.h.d || hVar == javassist.h.e || hVar == javassist.h.f || hVar == javassist.h.g || hVar == javassist.h.h) {
                n(i);
            } else if (hVar == javassist.h.i) {
                p(i);
                return 2;
            } else if (hVar == javassist.h.j) {
                t(i);
            } else if (hVar == javassist.h.k) {
                r(i);
                return 2;
            } else {
                throw new RuntimeException("void type?");
            }
        } else {
            k(i);
        }
        return 1;
    }

    public int b(int i, javassist.h hVar) {
        if (hVar.m()) {
            if (hVar == javassist.h.d || hVar == javassist.h.e || hVar == javassist.h.f || hVar == javassist.h.g || hVar == javassist.h.h) {
                o(i);
            } else if (hVar == javassist.h.i) {
                q(i);
                return 2;
            } else if (hVar == javassist.h.j) {
                u(i);
            } else if (hVar == javassist.h.k) {
                s(i);
                return 2;
            } else {
                throw new RuntimeException("void type?");
            }
        } else {
            l(i);
        }
        return 1;
    }

    public int a(javassist.h[] hVarArr, int i) {
        int i2 = 0;
        if (hVarArr != null) {
            int length = hVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                int a2 = a(i2 + i, hVarArr[i3]) + i2;
                i3++;
                i2 = a2;
            }
        }
        return i2;
    }

    public void a(javassist.h hVar) {
        g(192);
        j(this.b.a(hVar));
    }

    public void a(String str) {
        g(192);
        j(this.b.a(str));
    }

    public void b(String str) {
        g(193);
        j(this.b.a(str));
    }

    public void a(javassist.h hVar, String str, String str2) {
        a(180);
        j(this.b.a(this.b.a(hVar), str, str2));
        h(z.g(str2) - 1);
    }

    public void a(String str, String str2, String str3) {
        a(180);
        j(this.b.a(this.b.a(str), str2, str3));
        h(z.g(str3) - 1);
    }

    public void b(javassist.h hVar, String str, String str2) {
        a(178);
        j(this.b.a(this.b.a(hVar), str, str2));
        h(z.g(str2));
    }

    public void b(String str, String str2, String str3) {
        a(178);
        j(this.b.a(this.b.a(str), str2, str3));
        h(z.g(str3));
    }

    public void c(javassist.h hVar, String str, String str2) {
        a(this.b.a(hVar), str, str2);
    }

    public void c(String str, String str2, String str3) {
        a(this.b.a(str), str2, str3);
    }

    public void a(int i, String str, String str2) {
        a(183);
        j(this.b.b(i, str, str2));
        h(z.g(str2) - 1);
    }

    public void d(javassist.h hVar, String str, String str2) {
        b(this.b.a(hVar), str, str2);
    }

    public void d(String str, String str2, String str3) {
        b(this.b.a(str), str2, str3);
    }

    public void b(int i, String str, String str2) {
        a(184);
        j(this.b.b(i, str, str2));
        h(z.g(str2));
    }

    public void e(javassist.h hVar, String str, String str2) {
        c(this.b.a(hVar), str, str2);
    }

    public void e(String str, String str2, String str3) {
        c(this.b.a(str), str2, str3);
    }

    public void c(int i, String str, String str2) {
        a(182);
        j(this.b.b(i, str, str2));
        h(z.g(str2) - 1);
    }

    public void a(javassist.h hVar, String str, String str2, int i) {
        a(this.b.a(hVar), str, str2, i);
    }

    public void a(String str, String str2, String str3, int i) {
        a(this.b.a(str), str2, str3, i);
    }

    public void a(int i, String str, String str2, int i2) {
        a(185);
        j(this.b.c(i, str, str2));
        a(i2);
        a(0);
        h(z.g(str2) - 1);
    }

    public void c(String str) {
        v(this.b.b(str));
    }

    public void v(int i) {
        if (i > 255) {
            g(19);
            j(i);
            return;
        }
        g(18);
        a(i);
    }

    public void b(long j) {
        g(20);
        j(this.b.a(j));
    }

    public void b(double d) {
        g(20);
        j(this.b.a(d));
    }

    public void d(String str) {
        g(187);
        j(this.b.a(str));
    }

    public void e(String str) {
        g(189);
        j(this.b.a(str));
    }

    public int a(String str, int i) {
        a(197);
        j(this.b.a(str));
        a(i);
        h(1 - i);
        return i;
    }

    public void f(javassist.h hVar, String str, String str2) {
        a(hVar, (String) null, str, str2);
    }

    public void f(String str, String str2, String str3) {
        a((javassist.h) null, str, str2, str3);
    }

    private void a(javassist.h hVar, String str, String str2, String str3) {
        a(181);
        j(this.b.a(str == null ? this.b.a(hVar) : this.b.a(str), str2, str3));
        h((-1) - z.g(str3));
    }

    public void g(javassist.h hVar, String str, String str2) {
        b(hVar, (String) null, str, str2);
    }

    public void g(String str, String str2, String str3) {
        b((javassist.h) null, str, str2, str3);
    }

    private void b(javassist.h hVar, String str, String str2, String str3) {
        a(179);
        j(this.b.a(str == null ? this.b.a(hVar) : this.b.a(str), str2, str3));
        h(-z.g(str3));
    }

    public void b(javassist.h hVar) {
        if (hVar == null) {
            g(177);
        } else if (hVar.m()) {
            g(((CtPrimitiveType) hVar).C());
        } else {
            g(176);
        }
    }
}
