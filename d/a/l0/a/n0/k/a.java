package d.a.l0.a.n0.k;

import androidx.annotation.NonNull;
import d.a.l0.n.l.b;
/* loaded from: classes3.dex */
public final class a implements d.a.l0.n.l.b {

    /* renamed from: a  reason: collision with root package name */
    public String f47309a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47310b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.n.l.b f47311c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f47312a;

        public a a() {
            a aVar = this.f47312a;
            this.f47312a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f47310b = z;
            return this;
        }

        public final a c() {
            if (this.f47312a == null) {
                this.f47312a = new a();
            }
            return this.f47312a;
        }

        public b d(String str) {
            c().f47309a = str;
            return this;
        }

        public b e(d.a.l0.n.l.b bVar) {
            c().f47311c = bVar;
            return this;
        }
    }

    @Override // d.a.l0.n.l.b
    public void a(String str, b.a aVar) {
        d.a.l0.n.l.b bVar = this.f47311c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f47309a;
    }

    public boolean f() {
        return this.f47310b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f47309a + " buildin=" + this.f47310b;
    }

    public a() {
    }
}
