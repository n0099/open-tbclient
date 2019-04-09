package com.facebook.imagepipeline.memory;
/* loaded from: classes2.dex */
public class n implements s {
    private static n jIL = null;

    private n() {
    }

    public static synchronized n czf() {
        n nVar;
        synchronized (n.class) {
            if (jIL == null) {
                jIL = new n();
            }
            nVar = jIL;
        }
        return nVar;
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void a(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Cx(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void czg() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void czh() {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Cy(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void Cz(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.s
    public void CA(int i) {
    }
}
