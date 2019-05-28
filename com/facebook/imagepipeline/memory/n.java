package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n kbz = null;

    private n() {
    }

    public static synchronized n cHd() {
        n nVar;
        synchronized (n.class) {
            if (kbz == null) {
                kbz = new n();
            }
            nVar = kbz;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void DB(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cHe() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cHf() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void DC(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void DD(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void DE(int i) {
    }
}
