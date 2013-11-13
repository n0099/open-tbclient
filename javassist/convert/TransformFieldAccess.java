package javassist.convert;

import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.y;
import javassist.h;
/* loaded from: classes.dex */
public final class TransformFieldAccess extends Transformer {

    /* renamed from: a  reason: collision with root package name */
    private String f2848a;
    private String b;
    private String c;
    private h d;
    private boolean e;
    private int g;
    private y h;

    @Override // javassist.convert.Transformer
    public void a(y yVar, CodeAttribute codeAttribute) {
        if (this.h != yVar) {
            this.g = 0;
        }
    }

    @Override // javassist.convert.Transformer
    public int a(h hVar, int i, CodeIterator codeIterator, y yVar) {
        int c = codeIterator.c(i);
        if (c == 180 || c == 178 || c == 181 || c == 179) {
            String a2 = TransformReadField.a(hVar.a(), yVar, this.d, this.c, this.e, codeIterator.d(i + 1));
            if (a2 != null) {
                if (this.g == 0) {
                    this.g = yVar.b(yVar.a(this.f2848a), yVar.a(this.b, a2));
                    this.h = yVar;
                }
                codeIterator.b(this.g, i + 1);
            }
        }
        return i;
    }
}
