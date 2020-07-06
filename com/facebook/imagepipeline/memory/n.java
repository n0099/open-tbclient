package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n mVp = null;

    private n() {
    }

    public static synchronized n dFG() {
        n nVar;
        synchronized (n.class) {
            if (mVp == null) {
                mVp = new n();
            }
            nVar = mVp;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Jg(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dFH() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dFI() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Jh(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ji(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Jj(int i) {
    }
}
