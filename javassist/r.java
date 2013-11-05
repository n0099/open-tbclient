package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.z;
import javassist.compiler.ast.MethodDecl;
/* loaded from: classes.dex */
class r extends s {
    public static CtConstructor a(h[] hVarArr, h[] hVarArr2, int i, CtMethod ctMethod, n nVar, h hVar) {
        try {
            CtConstructor ctConstructor = new CtConstructor(hVarArr, hVar);
            ctConstructor.a(hVarArr2);
            ctConstructor.a().a(a(hVar, hVar.h(), i, ctMethod, hVarArr, nVar).e());
            return ctConstructor;
        } catch (NotFoundException e) {
            throw new CannotCompileException(e);
        }
    }

    protected static Bytecode a(h hVar, javassist.bytecode.i iVar, int i, CtMethod ctMethod, h[] hVarArr, n nVar) {
        int a2;
        String c;
        int a3;
        int i2 = 1;
        int h = iVar.h();
        Bytecode bytecode = new Bytecode(iVar.c(), 0, 0);
        bytecode.a(false, hVarArr, 0);
        bytecode.k(0);
        if (i == 0) {
            bytecode.a(h, MethodDecl.initName, "()V");
        } else if (i == 2) {
            i2 = bytecode.a(hVarArr, 1) + 1;
            bytecode.a(h, MethodDecl.initName, z.a(hVarArr));
        } else {
            int a4 = a(bytecode, hVarArr, 1);
            if (nVar == null) {
                a2 = 2;
                c = n.d();
            } else {
                a2 = nVar.a(bytecode) + 2;
                c = nVar.c();
            }
            if (a4 >= a2) {
                a2 = a4;
            }
            bytecode.a(h, MethodDecl.initName, c);
            i2 = a2;
        }
        if (ctMethod == null) {
            bytecode.a(177);
            a3 = i2;
        } else {
            a3 = a(hVar, iVar, ctMethod, false, hVarArr, h.l, nVar, bytecode);
            if (i2 >= a3) {
                a3 = i2;
            }
        }
        bytecode.c(a3);
        return bytecode;
    }
}
