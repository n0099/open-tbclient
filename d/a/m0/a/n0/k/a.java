package d.a.m0.a.n0.k;

import androidx.annotation.NonNull;
import d.a.m0.n.l.b;
/* loaded from: classes3.dex */
public final class a implements d.a.m0.n.l.b {

    /* renamed from: a  reason: collision with root package name */
    public String f47417a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47418b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.n.l.b f47419c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f47420a;

        public a a() {
            a aVar = this.f47420a;
            this.f47420a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f47418b = z;
            return this;
        }

        public final a c() {
            if (this.f47420a == null) {
                this.f47420a = new a();
            }
            return this.f47420a;
        }

        public b d(String str) {
            c().f47417a = str;
            return this;
        }

        public b e(d.a.m0.n.l.b bVar) {
            c().f47419c = bVar;
            return this;
        }
    }

    @Override // d.a.m0.n.l.b
    public void a(String str, b.a aVar) {
        d.a.m0.n.l.b bVar = this.f47419c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f47417a;
    }

    public boolean f() {
        return this.f47418b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f47417a + " buildin=" + this.f47418b;
    }

    public a() {
    }
}
