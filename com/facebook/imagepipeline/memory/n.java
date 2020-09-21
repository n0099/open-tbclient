package com.facebook.imagepipeline.memory;
/* loaded from: classes25.dex */
public class n implements s {
    private static n nHx = null;

    private n() {
    }

    public static synchronized n dYZ() {
        n nVar;
        synchronized (n.class) {
            if (nHx == null) {
                nHx = new n();
            }
            nVar = nHx;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void MK(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dZa() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dZb() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ML(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void MM(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void MN(int i) {
    }
}
