package javassist.bytecode.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ab;
import javassist.bytecode.an;
import javassist.bytecode.as;
/* loaded from: classes.dex */
public class SubroutineScanner implements as {

    /* renamed from: a  reason: collision with root package name */
    Map f2720a = new HashMap();
    Set b = new HashSet();
    private g[] c;

    public g[] a(an anVar) {
        CodeAttribute i = anVar.i();
        CodeIterator j = i.j();
        this.c = new g[i.h()];
        this.f2720a.clear();
        this.b.clear();
        a(0, j, null);
        ab k = i.k();
        for (int i2 = 0; i2 < k.a(); i2++) {
            a(k.c(i2), j, this.c[k.a(i2)]);
        }
        return this.c;
    }

    private void a(int i, CodeIterator codeIterator, g gVar) {
        boolean z;
        if (!this.b.contains(new Integer(i))) {
            this.b.add(new Integer(i));
            int g = codeIterator.g();
            codeIterator.a(i);
            do {
                if (b(codeIterator.f(), codeIterator, gVar) && codeIterator.e()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (z);
            codeIterator.a(g);
        }
    }

    private boolean b(int i, CodeIterator codeIterator, g gVar) {
        this.c[i] = gVar;
        int c = codeIterator.c(i);
        if (c == 170) {
            d(i, codeIterator, gVar);
            return false;
        } else if (c == 171) {
            c(i, codeIterator, gVar);
            return false;
        } else if (Util.d(c) || c == 169 || c == 191) {
            return false;
        } else {
            if (Util.a(c)) {
                int a2 = Util.a(i, codeIterator);
                if (c == 168 || c == 201) {
                    g gVar2 = (g) this.f2720a.get(new Integer(a2));
                    if (gVar2 == null) {
                        g gVar3 = new g(a2, i);
                        this.f2720a.put(new Integer(a2), gVar3);
                        a(a2, codeIterator, gVar3);
                    } else {
                        gVar2.a(i);
                    }
                } else {
                    a(a2, codeIterator, gVar);
                    if (Util.b(c)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private void c(int i, CodeIterator codeIterator, g gVar) {
        int i2 = (i & (-4)) + 4;
        a(codeIterator.f(i2) + i, codeIterator, gVar);
        int i3 = i2 + 4;
        int i4 = i3 + 4;
        int f = (codeIterator.f(i3) * 8) + i4;
        for (int i5 = i4 + 4; i5 < f; i5 += 8) {
            a(codeIterator.f(i5) + i, codeIterator, gVar);
        }
    }

    private void d(int i, CodeIterator codeIterator, g gVar) {
        int i2 = (i & (-4)) + 4;
        a(codeIterator.f(i2) + i, codeIterator, gVar);
        int i3 = i2 + 4;
        int f = codeIterator.f(i3);
        int i4 = i3 + 4;
        int i5 = i4 + 4;
        int f2 = (((codeIterator.f(i4) - f) + 1) * 4) + i5;
        while (i5 < f2) {
            a(codeIterator.f(i5) + i, codeIterator, gVar);
            i5 += 4;
        }
    }
}
