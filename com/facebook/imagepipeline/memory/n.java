package com.facebook.imagepipeline.memory;
/* loaded from: classes15.dex */
public class n implements s {
    private static n oZc = null;

    private n() {
    }

    public static synchronized n eqx() {
        n nVar;
        synchronized (n.class) {
            if (oZc == null) {
                oZc = new n();
            }
            nVar = oZc;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qf(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eqy() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eqz() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qg(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qh(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qi(int i) {
    }
}
