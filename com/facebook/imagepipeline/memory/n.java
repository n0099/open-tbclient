package com.facebook.imagepipeline.memory;
/* loaded from: classes15.dex */
public class n implements s {
    private static n pnR = null;

    private n() {
    }

    public static synchronized n evZ() {
        n nVar;
        synchronized (n.class) {
            if (pnR == null) {
                pnR = new n();
            }
            nVar = pnR;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rb(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ewa() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ewb() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rc(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Rd(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Re(int i) {
    }
}
