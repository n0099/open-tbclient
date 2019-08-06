package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n kjP = null;

    private n() {
    }

    public static synchronized n cKB() {
        n nVar;
        synchronized (n.class) {
            if (kjP == null) {
                kjP = new n();
            }
            nVar = kjP;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ek(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cKC() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cKD() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void El(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Em(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void En(int i) {
    }
}
