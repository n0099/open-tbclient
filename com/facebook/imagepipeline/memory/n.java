package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n kiJ = null;

    private n() {
    }

    public static synchronized n cKg() {
        n nVar;
        synchronized (n.class) {
            if (kiJ == null) {
                kiJ = new n();
            }
            nVar = kiJ;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ei(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cKh() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cKi() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ej(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ek(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void El(int i) {
    }
}
