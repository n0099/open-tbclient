package javassist.convert;

import javassist.CannotCompileException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMapTable;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.h;
/* loaded from: classes.dex */
public final class TransformNew extends Transformer {

    /* renamed from: a  reason: collision with root package name */
    private int f2833a;
    private String b;
    private String c;
    private String d;

    @Override // javassist.convert.Transformer
    public void a(y yVar, CodeAttribute codeAttribute) {
        this.f2833a = 0;
    }

    @Override // javassist.convert.Transformer
    public int a(h hVar, int i, CodeIterator codeIterator, y yVar) {
        int c = codeIterator.c(i);
        if (c == 187) {
            if (yVar.d(codeIterator.d(i + 1)).equals(this.b)) {
                if (codeIterator.c(i + 3) != 89) {
                    throw new CannotCompileException("NEW followed by no DUP was found");
                }
                codeIterator.a(0, i);
                codeIterator.a(0, i + 1);
                codeIterator.a(0, i + 2);
                codeIterator.a(0, i + 3);
                this.f2833a++;
                StackMapTable stackMapTable = (StackMapTable) codeIterator.c().a("StackMapTable");
                if (stackMapTable != null) {
                    stackMapTable.a(i);
                }
                StackMap stackMap = (StackMap) codeIterator.c().a("StackMap");
                if (stackMap != null) {
                    stackMap.a(i);
                }
            }
        } else if (c == 183) {
            int a2 = yVar.a(this.b, codeIterator.d(i + 1));
            if (a2 != 0 && this.f2833a > 0) {
                int a3 = a(a2, yVar);
                codeIterator.a(184, i);
                codeIterator.b(a3, i + 1);
                this.f2833a--;
            }
        }
        return i;
    }

    private int a(int i, y yVar) {
        return yVar.c(yVar.a(this.c), yVar.a(yVar.c(this.d), yVar.c(z.c(this.b, yVar.w(i)))));
    }
}
