package d.b.g0.a.j0.i;

import androidx.annotation.NonNull;
import d.b.g0.l.o.b;
/* loaded from: classes2.dex */
public final class a implements d.b.g0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public String f44820a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44821b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.l.o.b f44822c;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f44823a;

        public a a() {
            a aVar = this.f44823a;
            this.f44823a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f44821b = z;
            return this;
        }

        public final a c() {
            if (this.f44823a == null) {
                this.f44823a = new a();
            }
            return this.f44823a;
        }

        public b d(String str) {
            c().f44820a = str;
            return this;
        }

        public b e(d.b.g0.l.o.b bVar) {
            c().f44822c = bVar;
            return this;
        }
    }

    @Override // d.b.g0.l.o.b
    public void a(String str, b.a aVar) {
        d.b.g0.l.o.b bVar = this.f44822c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f44820a;
    }

    public boolean f() {
        return this.f44821b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f44820a + " buildin=" + this.f44821b;
    }

    public a() {
    }
}
