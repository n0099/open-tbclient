package d.b.g0.a.j0.i;

import androidx.annotation.NonNull;
import d.b.g0.l.o.b;
/* loaded from: classes3.dex */
public final class a implements d.b.g0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public String f44819a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44820b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.l.o.b f44821c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f44822a;

        public a a() {
            a aVar = this.f44822a;
            this.f44822a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f44820b = z;
            return this;
        }

        public final a c() {
            if (this.f44822a == null) {
                this.f44822a = new a();
            }
            return this.f44822a;
        }

        public b d(String str) {
            c().f44819a = str;
            return this;
        }

        public b e(d.b.g0.l.o.b bVar) {
            c().f44821c = bVar;
            return this;
        }
    }

    @Override // d.b.g0.l.o.b
    public void a(String str, b.a aVar) {
        d.b.g0.l.o.b bVar = this.f44821c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f44819a;
    }

    public boolean f() {
        return this.f44820b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f44819a + " buildin=" + this.f44820b;
    }

    public a() {
    }
}
