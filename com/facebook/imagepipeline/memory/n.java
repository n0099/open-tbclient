package com.facebook.imagepipeline.memory;
/* loaded from: classes3.dex */
public class n implements s {
    private static n pAD = null;

    private n() {
    }

    public static synchronized n ewt() {
        n nVar;
        synchronized (n.class) {
            if (pAD == null) {
                pAD = new n();
            }
            nVar = pAD;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PI(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ewu() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ewv() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PJ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PK(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PL(int i) {
    }
}
