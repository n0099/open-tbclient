package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n lUy = null;

    private n() {
    }

    public static synchronized n drb() {
        n nVar;
        synchronized (n.class) {
            if (lUy == null) {
                lUy = new n();
            }
            nVar = lUy;
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
    public void drc() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void drd() {
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
