package com.facebook.imagepipeline.memory;
/* loaded from: classes18.dex */
public class n implements s {
    private static n nWO = null;

    private n() {
    }

    public static synchronized n ecK() {
        n nVar;
        synchronized (n.class) {
            if (nWO == null) {
                nWO = new n();
            }
            nVar = nWO;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Nq(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ecL() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ecM() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Nr(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ns(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Nt(int i) {
    }
}
