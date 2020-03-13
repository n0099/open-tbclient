package com.facebook.imagepipeline.memory;
/* loaded from: classes12.dex */
public class n implements s {
    private static n lUJ = null;

    private n() {
    }

    public static synchronized n drc() {
        n nVar;
        synchronized (n.class) {
            if (lUJ == null) {
                lUJ = new n();
            }
            nVar = lUJ;
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
    public void drd() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dre() {
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
