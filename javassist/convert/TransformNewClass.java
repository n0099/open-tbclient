package javassist.convert;

import javassist.CannotCompileException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.y;
import javassist.h;
/* loaded from: classes.dex */
public final class TransformNewClass extends Transformer {

    /* renamed from: a  reason: collision with root package name */
    private int f3015a;
    private String b;
    private String c;
    private int d;
    private int e;
    private int g;

    @Override // javassist.convert.Transformer
    public void a(y yVar, CodeAttribute codeAttribute) {
        this.f3015a = 0;
        this.g = 0;
        this.e = 0;
        this.d = 0;
    }

    @Override // javassist.convert.Transformer
    public int a(h hVar, int i, CodeIterator codeIterator, y yVar) {
        int c = codeIterator.c(i);
        if (c == 187) {
            if (yVar.d(codeIterator.d(i + 1)).equals(this.b)) {
                if (codeIterator.c(i + 3) != 89) {
                    throw new CannotCompileException("NEW followed by no DUP was found");
                }
                if (this.d == 0) {
                    this.d = yVar.a(this.c);
                }
                codeIterator.b(this.d, i + 1);
                this.f3015a++;
            }
        } else if (c == 183) {
            int d = codeIterator.d(i + 1);
            if (yVar.a(this.b, d) != 0 && this.f3015a > 0) {
                int m = yVar.m(d);
                if (this.e != m) {
                    this.e = m;
                    this.g = yVar.c(this.d, m);
                }
                codeIterator.b(this.g, i + 1);
                this.f3015a--;
            }
        }
        return i;
    }
}
