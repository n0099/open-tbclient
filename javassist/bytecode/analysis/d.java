package javassist.bytecode.analysis;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private f f2936a;
    private f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        f fVar = new f(i);
        if (this.b != null) {
            this.b.f2937a = fVar;
        }
        this.b = fVar;
        if (this.f2936a == null) {
            this.f2936a = fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f2936a == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i;
        f fVar;
        if (this.f2936a != null) {
            i = this.f2936a.b;
            fVar = this.f2936a.f2937a;
            this.f2936a = fVar;
            if (this.f2936a == null) {
                this.b = null;
            }
            return i;
        }
        throw new NoSuchElementException();
    }
}
