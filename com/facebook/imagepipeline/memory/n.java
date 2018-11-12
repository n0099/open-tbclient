package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n ihT = null;

    private n() {
    }

    public static synchronized n bWq() {
        n nVar;
        synchronized (n.class) {
            if (ihT == null) {
                ihT = new n();
            }
            nVar = ihT;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yi(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bWr() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bWs() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yj(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yk(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yl(int i) {
    }
}
