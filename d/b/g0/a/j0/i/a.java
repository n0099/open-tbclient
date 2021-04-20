package d.b.g0.a.j0.i;

import androidx.annotation.NonNull;
import d.b.g0.l.o.b;
/* loaded from: classes2.dex */
public final class a implements d.b.g0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public String f45212a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45213b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.l.o.b f45214c;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f45215a;

        public a a() {
            a aVar = this.f45215a;
            this.f45215a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f45213b = z;
            return this;
        }

        public final a c() {
            if (this.f45215a == null) {
                this.f45215a = new a();
            }
            return this.f45215a;
        }

        public b d(String str) {
            c().f45212a = str;
            return this;
        }

        public b e(d.b.g0.l.o.b bVar) {
            c().f45214c = bVar;
            return this;
        }
    }

    @Override // d.b.g0.l.o.b
    public void a(String str, b.a aVar) {
        d.b.g0.l.o.b bVar = this.f45214c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f45212a;
    }

    public boolean f() {
        return this.f45213b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f45212a + " buildin=" + this.f45213b;
    }

    public a() {
    }
}
