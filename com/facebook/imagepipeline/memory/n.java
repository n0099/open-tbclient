package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n mee = null;

    private n() {
    }

    public static synchronized n dtv() {
        n nVar;
        synchronized (n.class) {
            if (mee == null) {
                mee = new n();
            }
            nVar = mee;
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
    public void dtw() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dtx() {
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
