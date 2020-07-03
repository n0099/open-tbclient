package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n mVm = null;

    private n() {
    }

    public static synchronized n dFC() {
        n nVar;
        synchronized (n.class) {
            if (mVm == null) {
                mVm = new n();
            }
            nVar = mVm;
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
    public void dFD() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dFE() {
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
