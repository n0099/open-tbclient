package d.a.j0.s.c;

import d.a.k0.d3.n0.f;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public int f50417a;

    /* renamed from: b  reason: collision with root package name */
    public String f50418b;

    /* renamed from: c  reason: collision with root package name */
    public f.c f50419c;

    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f50420b;

        public a(boolean z, String str) {
            super(z);
            this.f50420b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f50421b;

        public b(boolean z, String str) {
            super(z);
            this.f50421b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f50422a;

        public c(boolean z) {
            this.f50422a = z;
        }
    }

    public l(int i2, String str) {
        this.f50417a = i2;
        this.f50418b = str;
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
        return this.f50418b;
    }

    public f.c f() {
        return this.f50419c;
    }

    public int g() {
        return this.f50417a;
    }

    public void h(f.c cVar) {
        this.f50419c = cVar;
    }
}
