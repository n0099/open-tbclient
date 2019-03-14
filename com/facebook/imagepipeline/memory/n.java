package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n jJq = null;

    private n() {
    }

    public static synchronized n czm() {
        n nVar;
        synchronized (n.class) {
            if (jJq == null) {
                jJq = new n();
            }
            nVar = jJq;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CH(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void czn() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void czo() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CI(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CJ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CK(int i) {
    }
}
