package com.facebook.imagepipeline.memory;
/* loaded from: classes9.dex */
public class n implements s {
    private static n lPY = null;

    private n() {
    }

    public static synchronized n doC() {
        n nVar;
        synchronized (n.class) {
            if (lPY == null) {
                lPY = new n();
            }
            nVar = lPY;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ip(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void doD() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void doE() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Iq(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ir(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Is(int i) {
    }
}
