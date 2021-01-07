package com.facebook.imagepipeline.memory;
/* loaded from: classes3.dex */
public class n implements s {
    private static n pFd = null;

    private n() {
    }

    public static synchronized n eAl() {
        n nVar;
        synchronized (n.class) {
            if (pFd == null) {
                pFd = new n();
            }
            nVar = pFd;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rp(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eAm() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eAn() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rq(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rr(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rs(int i) {
    }
}
