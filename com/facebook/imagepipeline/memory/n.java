package com.facebook.imagepipeline.memory;
/* loaded from: classes5.dex */
public class n implements s {
    private static n pLl = null;

    private n() {
    }

    public static synchronized n eyT() {
        n nVar;
        synchronized (n.class) {
            if (pLl == null) {
                pLl = new n();
            }
            nVar = pLl;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qe(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eyU() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eyV() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qf(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qg(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qh(int i) {
    }
}
