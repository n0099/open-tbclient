package com.facebook.imagepipeline.memory;
/* loaded from: classes18.dex */
public class n implements s {
    private static n oXz = null;

    private n() {
    }

    public static synchronized n eqz() {
        n nVar;
        synchronized (n.class) {
            if (oXz == null) {
                oXz = new n();
            }
            nVar = oXz;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PC(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eqA() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eqB() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PD(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PE(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void PF(int i) {
    }
}
