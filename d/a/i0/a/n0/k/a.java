package d.a.i0.a.n0.k;

import androidx.annotation.NonNull;
import d.a.i0.n.l.b;
/* loaded from: classes2.dex */
public final class a implements d.a.i0.n.l.b {

    /* renamed from: a  reason: collision with root package name */
    public String f43459a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43460b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.n.l.b f43461c;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f43462a;

        public a a() {
            a aVar = this.f43462a;
            this.f43462a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f43460b = z;
            return this;
        }

        public final a c() {
            if (this.f43462a == null) {
                this.f43462a = new a();
            }
            return this.f43462a;
        }

        public b d(String str) {
            c().f43459a = str;
            return this;
        }

        public b e(d.a.i0.n.l.b bVar) {
            c().f43461c = bVar;
            return this;
        }
    }

    @Override // d.a.i0.n.l.b
    public void a(String str, b.a aVar) {
        d.a.i0.n.l.b bVar = this.f43461c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f43459a;
    }

    public boolean f() {
        return this.f43460b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f43459a + " buildin=" + this.f43460b;
    }

    public a() {
    }
}
