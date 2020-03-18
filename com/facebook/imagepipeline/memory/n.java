package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n lWp = null;

    private n() {
    }

    public static synchronized n drz() {
        n nVar;
        synchronized (n.class) {
            if (lWp == null) {
                lWp = new n();
            }
            nVar = lWp;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IJ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void drA() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void drB() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IK(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IL(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IM(int i) {
    }
}
