package d.a.h0.a.j0.i;

import androidx.annotation.NonNull;
import d.a.h0.l.o.b;
/* loaded from: classes2.dex */
public final class a implements d.a.h0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public String f42862a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42863b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.l.o.b f42864c;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f42865a;

        public a a() {
            a aVar = this.f42865a;
            this.f42865a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f42863b = z;
            return this;
        }

        public final a c() {
            if (this.f42865a == null) {
                this.f42865a = new a();
            }
            return this.f42865a;
        }

        public b d(String str) {
            c().f42862a = str;
            return this;
        }

        public b e(d.a.h0.l.o.b bVar) {
            c().f42864c = bVar;
            return this;
        }
    }

    @Override // d.a.h0.l.o.b
    public void a(String str, b.a aVar) {
        d.a.h0.l.o.b bVar = this.f42864c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f42862a;
    }

    public boolean f() {
        return this.f42863b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f42862a + " buildin=" + this.f42863b;
    }

    public a() {
    }
}
