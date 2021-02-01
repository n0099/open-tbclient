package com.facebook.imagepipeline.memory;
/* loaded from: classes5.dex */
public class n implements s {
    private static n pKL = null;

    private n() {
    }

    public static synchronized n eyL() {
        n nVar;
        synchronized (n.class) {
            if (pKL == null) {
                pKL = new n();
            }
            nVar = pKL;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qd(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eyM() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eyN() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qe(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qf(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qg(int i) {
    }
}
