package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n jJy = null;

    private n() {
    }

    public static synchronized n czj() {
        n nVar;
        synchronized (n.class) {
            if (jJy == null) {
                jJy = new n();
            }
            nVar = jJy;
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
    public void czk() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void czl() {
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
