package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n kmm = null;

    private n() {
    }

    public static synchronized n cLp() {
        n nVar;
        synchronized (n.class) {
            if (kmm == null) {
                kmm = new n();
            }
            nVar = kmm;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Eo(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cLq() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cLr() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ep(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Eq(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Er(int i) {
    }
}
