package javassist.convert;

import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.y;
import javassist.h;
/* loaded from: classes.dex */
public final class TransformWriteField extends TransformReadField {
    @Override // javassist.convert.TransformReadField, javassist.convert.Transformer
    public int a(h hVar, int i, CodeIterator codeIterator, y yVar) {
        int c = codeIterator.c(i);
        if (c == 181 || c == 179) {
            String a2 = a(hVar.a(), yVar, this.b, this.f2803a, this.c, codeIterator.d(i + 1));
            if (a2 != null) {
                if (c == 179) {
                    CodeAttribute c2 = codeIterator.c();
                    codeIterator.a(i);
                    char charAt = a2.charAt(0);
                    if (charAt == 'J' || charAt == 'D') {
                        int g = codeIterator.g(3);
                        codeIterator.a(1, g);
                        codeIterator.a(91, g + 1);
                        codeIterator.a(87, g + 2);
                        c2.a(c2.f() + 2);
                    } else {
                        int g2 = codeIterator.g(2);
                        codeIterator.a(1, g2);
                        codeIterator.a(95, g2 + 1);
                        c2.a(c2.f() + 1);
                    }
                    i = codeIterator.f();
                }
                int b = yVar.b(yVar.a(this.d), this.e, "(Ljava/lang/Object;" + a2 + ")V");
                codeIterator.a(184, i);
                codeIterator.b(b, i + 1);
            }
        }
        return i;
    }
}
