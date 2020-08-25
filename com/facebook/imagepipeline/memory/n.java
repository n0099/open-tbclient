package com.facebook.imagepipeline.memory;
/* loaded from: classes8.dex */
public class n implements s {
    private static n nxi = null;

    private n() {
    }

    public static synchronized n dUS() {
        n nVar;
        synchronized (n.class) {
            if (nxi == null) {
                nxi = new n();
            }
            nVar = nxi;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mf(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dUT() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void dUU() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mg(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mh(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Mi(int i) {
    }
}
