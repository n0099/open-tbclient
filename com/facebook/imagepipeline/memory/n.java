package com.facebook.imagepipeline.memory;
/* loaded from: classes18.dex */
public class n implements s {
    private static n oOg = null;

    private n() {
    }

    public static synchronized n emI() {
        n nVar;
        synchronized (n.class) {
            if (oOg == null) {
                oOg = new n();
            }
            nVar = oOg;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ph(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void emJ() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void emK() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Pi(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Pj(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Pk(int i) {
    }
}
