package com.facebook.imagepipeline.memory;
/* loaded from: classes5.dex */
public class n implements s {
    private static n pDw = null;

    private n() {
    }

    public static synchronized n ezH() {
        n nVar;
        synchronized (n.class) {
            if (pDw == null) {
                pDw = new n();
            }
            nVar = pDw;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void QZ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ezI() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ezJ() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ra(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rb(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rc(int i) {
    }
}
