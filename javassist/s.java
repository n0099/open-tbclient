package javassist;

import java.util.Hashtable;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.SyntheticAttribute;
import javassist.bytecode.an;
import javassist.compiler.JvstCodeGen;
/* loaded from: classes.dex */
class s {
    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(h hVar, javassist.bytecode.i iVar, CtMethod ctMethod, boolean z, h[] hVarArr, h hVar2, n nVar, Bytecode bytecode) {
        String a2;
        int i = 0;
        if (!(hVar instanceof j)) {
            throw new CannotCompileException("bad declaring class" + hVar.n());
        }
        if (!z) {
            bytecode.k(0);
        }
        int a3 = a(bytecode, hVarArr, z ? 0 : 1);
        if (nVar == null) {
            a2 = n.b();
        } else {
            i = nVar.a(bytecode);
            a2 = nVar.a();
        }
        a(ctMethod, a2);
        try {
            String a4 = a((j) hVar, iVar, ctMethod);
            if (z) {
                bytecode.d(Bytecode.f2746a, a4, a2);
            } else {
                bytecode.c(Bytecode.f2746a, a4, a2);
            }
            a(bytecode, hVar2);
            return a3 < i + 2 ? i + 2 : a3;
        } catch (BadBytecode e) {
            throw new CannotCompileException(e);
        }
    }

    private static void a(CtMethod ctMethod, String str) {
        if (!str.equals(ctMethod.a().g())) {
            throw new CannotCompileException("wrapped method with a bad signature: " + ctMethod.c().n() + '.' + ctMethod.i());
        }
    }

    private static String a(j jVar, javassist.bytecode.i iVar, CtMethod ctMethod) {
        Hashtable A = jVar.A();
        String str = (String) A.get(ctMethod);
        if (str == null) {
            do {
                str = "_added_m$" + jVar.B();
            } while (iVar.c(str) != null);
            ClassMap classMap = new ClassMap();
            classMap.put(ctMethod.c().n(), jVar.n());
            an anVar = new an(iVar.c(), str, ctMethod.a(), classMap);
            anVar.a(javassist.bytecode.a.a(anVar.f()));
            anVar.a(new SyntheticAttribute(iVar.c()));
            iVar.a(anVar);
            A.put(ctMethod, str);
            m y = jVar.y();
            if (y != null) {
                y.a(new CtMethod(anVar, jVar));
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Bytecode bytecode, h[] hVarArr, int i) {
        return JvstCodeGen.a(bytecode, hVarArr, i);
    }

    private static void a(Bytecode bytecode, h hVar) {
        if (hVar.m()) {
            CtPrimitiveType ctPrimitiveType = (CtPrimitiveType) hVar;
            if (ctPrimitiveType != h.l) {
                String z = ctPrimitiveType.z();
                bytecode.a(z);
                bytecode.e(z, ctPrimitiveType.A(), ctPrimitiveType.B());
            }
            bytecode.g(ctPrimitiveType.C());
            return;
        }
        bytecode.a(hVar);
        bytecode.g(176);
    }
}
