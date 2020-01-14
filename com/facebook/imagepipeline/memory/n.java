package com.facebook.imagepipeline.memory;
/* loaded from: classes10.dex */
public class n implements s {
    private static n lTP = null;

    private n() {
    }

    public static synchronized n dpN() {
        n nVar;
        synchronized (n.class) {
            if (lTP == null) {
                lTP = new n();
            }
            nVar = lTP;
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
    public void dpO() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dpP() {
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
