package javassist.convert;

import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.y;
import javassist.c;
import javassist.h;
/* loaded from: classes.dex */
public class TransformCall extends Transformer {
    protected String g;
    protected String h;
    protected String i;
    protected String j;
    protected String k;
    protected boolean l;
    protected int m;
    protected y n;

    @Override // javassist.convert.Transformer
    public void a(y yVar, CodeAttribute codeAttribute) {
        if (this.n != yVar) {
            this.m = 0;
        }
    }

    @Override // javassist.convert.Transformer
    public int a(h hVar, int i, CodeIterator codeIterator, y yVar) {
        int d;
        String b;
        int c = codeIterator.c(i);
        if ((c == 185 || c == 183 || c == 184 || c == 182) && (b = yVar.b(this.h, this.i, (d = codeIterator.d(i + 1)))) != null && a(b, hVar.a())) {
            return a(c, i, codeIterator, yVar.g(yVar.h(d)), yVar);
        }
        return i;
    }

    private boolean a(String str, c cVar) {
        if (this.g.equals(str)) {
            return true;
        }
        try {
            h c = cVar.c(str);
            if (c.a(cVar.c(this.g))) {
                try {
                    return c.a(this.h, this.i).c().n().equals(this.g);
                } catch (NotFoundException e) {
                    return true;
                }
            }
            return false;
        } catch (NotFoundException e2) {
            return false;
        }
    }

    protected int a(int i, int i2, CodeIterator codeIterator, int i3, y yVar) {
        if (this.m == 0) {
            int a2 = yVar.a(yVar.c(this.k), i3);
            int a3 = yVar.a(this.j);
            if (i == 185) {
                this.m = yVar.d(a3, a2);
            } else {
                if (this.l && i == 182) {
                    codeIterator.a(183, i2);
                }
                this.m = yVar.c(a3, a2);
            }
            this.n = yVar;
        }
        codeIterator.b(this.m, i2 + 1);
        return i2;
    }
}
