package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n lUw = null;

    private n() {
    }

    public static synchronized n dqZ() {
        n nVar;
        synchronized (n.class) {
            if (lUw == null) {
                lUw = new n();
            }
            nVar = lUw;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ID(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dra() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void drb() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IE(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IF(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IG(int i) {
    }
}
