package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n itx = null;

    private n() {
    }

    public static synchronized n bZU() {
        n nVar;
        synchronized (n.class) {
            if (itx == null) {
                itx = new n();
            }
            nVar = itx;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yU(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bZV() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bZW() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yV(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yW(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yX(int i) {
    }
}
