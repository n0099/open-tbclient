package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n ipf = null;

    private n() {
    }

    public static synchronized n bYw() {
        n nVar;
        synchronized (n.class) {
            if (ipf == null) {
                ipf = new n();
            }
            nVar = ipf;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yF(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bYx() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bYy() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yG(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yH(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yI(int i) {
    }
}
