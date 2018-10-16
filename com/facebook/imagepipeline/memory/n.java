package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n igi = null;

    private n() {
    }

    public static synchronized n bWV() {
        n nVar;
        synchronized (n.class) {
            if (igi == null) {
                igi = new n();
            }
            nVar = igi;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void xP(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bWW() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bWX() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void xQ(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void xR(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void xS(int i) {
    }
}
