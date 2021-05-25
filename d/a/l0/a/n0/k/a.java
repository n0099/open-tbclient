package d.a.l0.a.n0.k;

import androidx.annotation.NonNull;
import d.a.l0.n.l.b;
/* loaded from: classes2.dex */
public final class a implements d.a.l0.n.l.b {

    /* renamed from: a  reason: collision with root package name */
    public String f43633a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43634b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.n.l.b f43635c;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f43636a;

        public a a() {
            a aVar = this.f43636a;
            this.f43636a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f43634b = z;
            return this;
        }

        public final a c() {
            if (this.f43636a == null) {
                this.f43636a = new a();
            }
            return this.f43636a;
        }

        public b d(String str) {
            c().f43633a = str;
            return this;
        }

        public b e(d.a.l0.n.l.b bVar) {
            c().f43635c = bVar;
            return this;
        }
    }

    @Override // d.a.l0.n.l.b
    public void a(String str, b.a aVar) {
        d.a.l0.n.l.b bVar = this.f43635c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f43633a;
    }

    public boolean f() {
        return this.f43634b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f43633a + " buildin=" + this.f43634b;
    }

    public a() {
    }
}
