package com.facebook.imagepipeline.memory;
/* loaded from: classes8.dex */
public class n implements s {
    private static n nxA = null;

    private n() {
    }

    public static synchronized n dVb() {
        n nVar;
        synchronized (n.class) {
            if (nxA == null) {
                nxA = new n();
            }
            nVar = nxA;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mf(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dVc() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dVd() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mg(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mh(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mi(int i) {
    }
}
