package d.b.h0.a.j0.i;

import androidx.annotation.NonNull;
import d.b.h0.l.o.b;
/* loaded from: classes2.dex */
public final class a implements d.b.h0.l.o.b {

    /* renamed from: a  reason: collision with root package name */
    public String f45541a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45542b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.l.o.b f45543c;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f45544a;

        public a a() {
            a aVar = this.f45544a;
            this.f45544a = null;
            return aVar;
        }

        public b b(boolean z) {
            c().f45542b = z;
            return this;
        }

        public final a c() {
            if (this.f45544a == null) {
                this.f45544a = new a();
            }
            return this.f45544a;
        }

        public b d(String str) {
            c().f45541a = str;
            return this;
        }

        public b e(d.b.h0.l.o.b bVar) {
            c().f45543c = bVar;
            return this;
        }
    }

    @Override // d.b.h0.l.o.b
    public void a(String str, b.a aVar) {
        d.b.h0.l.o.b bVar = this.f45543c;
        if (bVar != null) {
            bVar.a(str, aVar);
        } else if (aVar != null) {
            aVar.a(true);
        }
    }

    public String e() {
        return this.f45541a;
    }

    public boolean f() {
        return this.f45542b;
    }

    @NonNull
    public String toString() {
        return "SoLib:: libName=" + this.f45541a + " buildin=" + this.f45542b;
    }

    public a() {
    }
}
