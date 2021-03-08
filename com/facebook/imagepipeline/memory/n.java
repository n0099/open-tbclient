package com.facebook.imagepipeline.memory;
/* loaded from: classes5.dex */
public class n implements s {
    private static n pNq = null;

    private n() {
    }

    public static synchronized n ezc() {
        n nVar;
        synchronized (n.class) {
            if (pNq == null) {
                pNq = new n();
            }
            nVar = pNq;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qi(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void ezd() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void eze() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qj(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Qk(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Ql(int i) {
    }
}
