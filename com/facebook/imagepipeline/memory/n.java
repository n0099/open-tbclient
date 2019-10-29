package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n kky = null;

    private n() {
    }

    public static synchronized n cIm() {
        n nVar;
        synchronized (n.class) {
            if (kky == null) {
                kky = new n();
            }
            nVar = kky;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CK(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cIn() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cIo() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CL(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CM(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CN(int i) {
    }
}
