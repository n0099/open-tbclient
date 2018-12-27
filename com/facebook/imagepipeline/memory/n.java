package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n isp = null;

    private n() {
    }

    public static synchronized n bZm() {
        n nVar;
        synchronized (n.class) {
            if (isp == null) {
                isp = new n();
            }
            nVar = isp;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yS(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bZn() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void bZo() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yT(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yU(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void yV(int i) {
    }
}
