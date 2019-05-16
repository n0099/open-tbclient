package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n kby = null;

    private n() {
    }

    public static synchronized n cHb() {
        n nVar;
        synchronized (n.class) {
            if (kby == null) {
                kby = new n();
            }
            nVar = kby;
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
    public void cHc() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void cHd() {
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
