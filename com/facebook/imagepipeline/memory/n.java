package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n jJf = null;

    private n() {
    }

    public static synchronized n cyZ() {
        n nVar;
        synchronized (n.class) {
            if (jJf == null) {
                jJf = new n();
            }
            nVar = jJf;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CG(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cza() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void czb() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CH(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CI(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CJ(int i) {
    }
}
