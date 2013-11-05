package javassist;
/* loaded from: classes.dex */
public class q {
    public static CtMethod a(int i, h hVar, String str, h[] hVarArr, h[] hVarArr2, String str2, h hVar2) {
        try {
            CtMethod ctMethod = new CtMethod(hVar, str, hVarArr, hVar2);
            ctMethod.a(i);
            ctMethod.a(hVarArr2);
            ctMethod.a(str2);
            return ctMethod;
        } catch (NotFoundException e) {
            throw new CannotCompileException(e);
        }
    }
}
