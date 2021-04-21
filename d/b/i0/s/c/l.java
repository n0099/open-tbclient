package d.b.i0.s.c;

import d.b.j0.d3.n0.f;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public int f51944a;

    /* renamed from: b  reason: collision with root package name */
    public String f51945b;

    /* renamed from: c  reason: collision with root package name */
    public f.c f51946c;

    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f51947b;

        public a(boolean z, String str) {
            super(z);
            this.f51947b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f51948b;

        public b(boolean z, String str) {
            super(z);
            this.f51948b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51949a;

        public c(boolean z) {
            this.f51949a = z;
        }
    }

    public l(int i, String str) {
        this.f51944a = i;
        this.f51945b = str;
    }

    public static l a(String str) {
        return new l(0, str);
    }

    public static l b() {
        return new l(2, null);
    }

    public static l c() {
        return new l(3, null);
    }

    public static l d() {
        return new l(1, null);
    }

    public String e() {
        return this.f51945b;
    }

    public f.c f() {
        return this.f51946c;
    }

    public int g() {
        return this.f51944a;
    }

    public void h(f.c cVar) {
        this.f51946c = cVar;
    }
}
