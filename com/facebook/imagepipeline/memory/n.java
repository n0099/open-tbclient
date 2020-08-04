package com.facebook.imagepipeline.memory;
/* loaded from: classes4.dex */
public class n implements s {
    private static n nds = null;

    private n() {
    }

    public static synchronized n dIT() {
        n nVar;
        synchronized (n.class) {
            if (nds == null) {
                nds = new n();
            }
            nVar = nds;
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
    public void dIU() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dIV() {
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
