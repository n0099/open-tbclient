package javassist.bytecode.analysis;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private f f2755a;
    private f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        f fVar = new f(i);
        if (this.b != null) {
            this.b.f2756a = fVar;
        }
        this.b = fVar;
        if (this.f2755a == null) {
            this.f2755a = fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f2755a == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i;
        f fVar;
        if (this.f2755a != null) {
            i = this.f2755a.b;
            fVar = this.f2755a.f2756a;
            this.f2755a = fVar;
            if (this.f2755a == null) {
                this.b = null;
            }
            return i;
        }
        throw new NoSuchElementException();
    }
}
