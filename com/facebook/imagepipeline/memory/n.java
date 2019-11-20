package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n kjH = null;

    private n() {
    }

    public static synchronized n cIk() {
        n nVar;
        synchronized (n.class) {
            if (kjH == null) {
                kjH = new n();
            }
            nVar = kjH;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CJ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cIl() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cIm() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CK(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CL(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CM(int i) {
    }
}
