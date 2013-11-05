package javassist.bytecode.analysis;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private f f2723a;
    private f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        f fVar = new f(i);
        if (this.b != null) {
            this.b.f2724a = fVar;
        }
        this.b = fVar;
        if (this.f2723a == null) {
            this.f2723a = fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f2723a == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i;
        f fVar;
        if (this.f2723a != null) {
            i = this.f2723a.b;
            fVar = this.f2723a.f2724a;
            this.f2723a = fVar;
            if (this.f2723a == null) {
                this.b = null;
            }
            return i;
        }
        throw new NoSuchElementException();
    }
}
