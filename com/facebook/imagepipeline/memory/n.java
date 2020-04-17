package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n mea = null;

    private n() {
    }

    public static synchronized n dtx() {
        n nVar;
        synchronized (n.class) {
            if (mea == null) {
                mea = new n();
            }
            nVar = mea;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Hl(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dty() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dtz() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Hm(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Hn(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ho(int i) {
    }
}
