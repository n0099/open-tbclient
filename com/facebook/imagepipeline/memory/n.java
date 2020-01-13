package com.facebook.imagepipeline.memory;
/* loaded from: classes10.dex */
public class n implements s {
    private static n lTK = null;

    private n() {
    }

    public static synchronized n dpL() {
        n nVar;
        synchronized (n.class) {
            if (lTK == null) {
                lTK = new n();
            }
            nVar = lTK;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Iy(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dpM() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dpN() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Iz(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IA(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void IB(int i) {
    }
}
