package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n mzf = null;

    private n() {
    }

    public static synchronized n dBa() {
        n nVar;
        synchronized (n.class) {
            if (mzf == null) {
                mzf = new n();
            }
            nVar = mzf;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void HZ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dBb() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dBc() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ia(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ib(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ic(int i) {
    }
}
