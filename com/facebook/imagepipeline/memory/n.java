package com.facebook.imagepipeline.memory;
/* loaded from: classes4.dex */
public class n implements s {
    private static n ndq = null;

    private n() {
    }

    public static synchronized n dIS() {
        n nVar;
        synchronized (n.class) {
            if (ndq == null) {
                ndq = new n();
            }
            nVar = ndq;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void JB(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dIT() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dIU() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void JC(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void JD(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void JE(int i) {
    }
}
