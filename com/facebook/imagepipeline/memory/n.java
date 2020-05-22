package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n mxV = null;

    private n() {
    }

    public static synchronized n dAM() {
        n nVar;
        synchronized (n.class) {
            if (mxV == null) {
                mxV = new n();
            }
            nVar = mxV;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void HX(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dAN() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dAO() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void HY(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void HZ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ia(int i) {
    }
}
