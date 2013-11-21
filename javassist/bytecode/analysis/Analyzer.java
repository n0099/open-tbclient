package javassist.bytecode.analysis;

import java.util.Iterator;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ab;
import javassist.bytecode.an;
import javassist.bytecode.as;
import javassist.bytecode.y;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public class Analyzer implements as {

    /* renamed from: a  reason: collision with root package name */
    private final SubroutineScanner f2749a = new SubroutineScanner();
    private javassist.h b;
    private b[] c;
    private c[] d;
    private g[] e;

    public c[] a(javassist.h hVar, an anVar) {
        this.b = hVar;
        CodeAttribute i = anVar.i();
        if (i == null) {
            return null;
        }
        int g = i.g();
        int f = i.f();
        int h = i.h();
        CodeIterator j = i.j();
        d dVar = new d();
        this.c = a(anVar);
        this.e = this.f2749a.a(anVar);
        Executor executor = new Executor(hVar.a(), anVar.c());
        this.d = new c[h];
        this.d[j.g()] = a(anVar, g, f);
        dVar.a(j.f());
        while (!dVar.a()) {
            a(anVar, j, dVar, executor);
        }
        return this.d;
    }

    private void a(an anVar, CodeIterator codeIterator, d dVar, Executor executor) {
        int b = dVar.b();
        codeIterator.a(b);
        codeIterator.f();
        c f = this.d[b].f();
        g gVar = this.e[b];
        try {
            executor.a(anVar, b, codeIterator, f, gVar);
            int c = codeIterator.c(b);
            if (c == 170) {
                b(dVar, b, codeIterator, f);
            } else if (c == 171) {
                a(dVar, b, codeIterator, f);
            } else if (c == 169) {
                a(dVar, codeIterator, b, f, gVar);
            } else if (Util.a(c)) {
                int a2 = Util.a(b, codeIterator);
                if (Util.c(c)) {
                    a(dVar, this.d[b], this.e[a2], b, a(codeIterator, b));
                } else if (!Util.b(c)) {
                    a(dVar, f, a(codeIterator, b));
                }
                a(dVar, f, a2);
            } else if (c != 191 && !Util.d(c)) {
                a(dVar, f, a(codeIterator, b));
            }
            a(dVar, anVar, b, f);
        } catch (RuntimeException e) {
            throw new BadBytecode(e.getMessage() + "[pos = " + b + "]", e);
        }
    }

    private b[] a(an anVar) {
        h hVar;
        y c = anVar.c();
        javassist.c a2 = this.b.a();
        ab k = anVar.i().k();
        b[] bVarArr = new b[k.a()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < k.a()) {
                int d = k.d(i2);
                if (d != 0) {
                    hVar = h.a(a2.c(c.d(d)));
                } else {
                    try {
                        hVar = h.q;
                    } catch (NotFoundException e) {
                        throw new IllegalStateException(e.getMessage());
                    }
                }
                bVarArr[i2] = new b(k.a(i2), k.b(i2), k.c(i2), hVar);
                i = i2 + 1;
            } else {
                return bVarArr;
            }
        }
    }

    private c a(an anVar, int i, int i2) {
        int i3;
        c cVar = new c(i, i2);
        if ((anVar.f() & 8) == 0) {
            i3 = 1;
            cVar.a(0, h.a(this.b));
        } else {
            i3 = 0;
        }
        try {
            for (javassist.h hVar : z.a(anVar.g(), this.b.a())) {
                h a2 = a(h.a(hVar));
                int i4 = i3 + 1;
                cVar.a(i3, a2);
                if (a2.e() == 2) {
                    i3 = i4 + 1;
                    cVar.a(i4, h.l);
                } else {
                    i3 = i4;
                }
            }
            return cVar;
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private int a(CodeIterator codeIterator, int i, int i2) {
        codeIterator.a(i);
        codeIterator.f();
        int g = codeIterator.g();
        codeIterator.a(i2);
        codeIterator.f();
        return g;
    }

    private int a(CodeIterator codeIterator, int i) {
        if (!codeIterator.e()) {
            throw new BadBytecode("Execution falls off end! [pos = " + i + "]");
        }
        return codeIterator.g();
    }

    private void a(d dVar, c cVar, int i) {
        boolean b;
        c cVar2 = this.d[i];
        if (cVar2 == null) {
            this.d[i] = cVar.f();
            b = true;
        } else {
            b = cVar2.b(cVar);
        }
        if (b) {
            dVar.a(i);
        }
    }

    private void a(d dVar, an anVar, int i, c cVar) {
        int i2;
        int i3;
        h hVar;
        int i4;
        for (int i5 = 0; i5 < this.c.length; i5++) {
            b bVar = this.c[i5];
            i2 = bVar.c;
            if (i >= i2) {
                i3 = bVar.f2753a;
                if (i < i3) {
                    c f = cVar.f();
                    f.a();
                    hVar = bVar.d;
                    f.a(hVar);
                    i4 = bVar.b;
                    a(dVar, f, i4);
                }
            }
        }
    }

    private void a(d dVar, c cVar, g gVar, int i, int i2) {
        boolean z;
        c cVar2;
        boolean z2 = true;
        if (gVar == null) {
            throw new BadBytecode("No subroutine at jsr target! [pos = " + i + "]");
        }
        c cVar3 = this.d[i2];
        if (cVar3 == null) {
            c[] cVarArr = this.d;
            cVar2 = cVar.f();
            cVarArr[i2] = cVar2;
            z = true;
        } else {
            z = false;
            for (int i3 = 0; i3 < cVar.c(); i3++) {
                if (!gVar.c(i3)) {
                    h a2 = cVar3.a(i3);
                    h a3 = cVar.a(i3);
                    if (a2 == null) {
                        cVar3.a(i3, a3);
                        z = true;
                    } else {
                        h c = a2.c(a3);
                        cVar3.a(i3, c);
                        if (!c.equals(a2) || c.b()) {
                            z = true;
                        }
                    }
                }
            }
            cVar2 = cVar3;
        }
        if (cVar2.h()) {
            z2 = z;
        } else {
            cVar2.a(true);
        }
        if (z2 && cVar2.i()) {
            dVar.a(i2);
        }
    }

    private void a(d dVar, int i, CodeIterator codeIterator, c cVar) {
        int i2 = (i & (-4)) + 4;
        a(dVar, cVar, codeIterator.f(i2) + i);
        int i3 = i2 + 4;
        int i4 = i3 + 4;
        int f = (codeIterator.f(i3) * 8) + i4;
        for (int i5 = i4 + 4; i5 < f; i5 += 8) {
            a(dVar, cVar, codeIterator.f(i5) + i);
        }
    }

    private void a(d dVar, CodeIterator codeIterator, int i, c cVar, g gVar) {
        boolean a2;
        c cVar2;
        boolean z;
        if (gVar == null) {
            throw new BadBytecode("Ret on no subroutine! [pos = " + i + "]");
        }
        for (Integer num : gVar.b()) {
            int a3 = a(codeIterator, num.intValue(), i);
            c cVar3 = this.d[a3];
            if (cVar3 == null) {
                c[] cVarArr = this.d;
                c g = cVar.g();
                cVarArr[a3] = g;
                cVar2 = g;
                a2 = true;
            } else {
                a2 = cVar3.a(cVar);
                cVar2 = cVar3;
            }
            Iterator it = gVar.a().iterator();
            while (true) {
                z = a2;
                if (!it.hasNext()) {
                    break;
                }
                int intValue = ((Integer) it.next()).intValue();
                h a4 = cVar2.a(intValue);
                h a5 = cVar.a(intValue);
                if (a4 != a5) {
                    cVar2.a(intValue, a5);
                    a2 = true;
                } else {
                    a2 = z;
                }
            }
            if (!cVar2.i()) {
                cVar2.b(true);
                z = true;
            }
            if (z && cVar2.h()) {
                dVar.a(a3);
            }
        }
    }

    private void b(d dVar, int i, CodeIterator codeIterator, c cVar) {
        int i2 = (i & (-4)) + 4;
        a(dVar, cVar, codeIterator.f(i2) + i);
        int i3 = i2 + 4;
        int f = codeIterator.f(i3);
        int i4 = i3 + 4;
        int i5 = i4 + 4;
        int f2 = (((codeIterator.f(i4) - f) + 1) * 4) + i5;
        while (i5 < f2) {
            a(dVar, cVar, codeIterator.f(i5) + i);
            i5 += 4;
        }
    }

    private h a(h hVar) {
        if (hVar == h.f || hVar == h.e || hVar == h.d || hVar == h.b) {
            return h.g;
        }
        return hVar;
    }
}
