package javassist.convert;

import javassist.NotFoundException;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.y;
import javassist.c;
import javassist.h;
/* loaded from: classes.dex */
public class TransformReadField extends Transformer {

    /* renamed from: a  reason: collision with root package name */
    protected String f2835a;
    protected h b;
    protected boolean c;
    protected String d;
    protected String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(c cVar, y yVar, h hVar, String str, boolean z, int i) {
        if (yVar.j(i).equals(str)) {
            try {
                h c = cVar.c(yVar.i(i));
                if (c == hVar || (!z && a(c, hVar, str))) {
                    return yVar.k(i);
                }
                return null;
            } catch (NotFoundException e) {
                return null;
            }
        }
        return null;
    }

    static boolean a(h hVar, h hVar2, String str) {
        if (hVar.b(hVar2)) {
            try {
                return hVar.a(str).c() == hVar2;
            } catch (NotFoundException e) {
                return false;
            }
        }
        return false;
    }

    @Override // javassist.convert.Transformer
    public int a(h hVar, int i, CodeIterator codeIterator, y yVar) {
        int c = codeIterator.c(i);
        if (c == 180 || c == 178) {
            String a2 = a(hVar.a(), yVar, this.b, this.f2835a, this.c, codeIterator.d(i + 1));
            if (a2 != null) {
                if (c == 178) {
                    codeIterator.a(i);
                    codeIterator.a(1, codeIterator.g(1));
                    i = codeIterator.f();
                }
                int b = yVar.b(yVar.a(this.d), this.e, "(Ljava/lang/Object;)" + a2);
                codeIterator.a(184, i);
                codeIterator.b(b, i + 1);
            }
        }
        return i;
    }
}
