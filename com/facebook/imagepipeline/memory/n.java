package com.facebook.imagepipeline.memory;
/* loaded from: classes15.dex */
public class n implements s {
    private static n pnT = null;

    private n() {
    }

    public static synchronized n ewa() {
        n nVar;
        synchronized (n.class) {
            if (pnT == null) {
                pnT = new n();
            }
            nVar = pnT;
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
    public void ewb() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ewc() {
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
