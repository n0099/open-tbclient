package d.a.m0.s.c;

import d.a.n0.e3.n0.f;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public int f50484a;

    /* renamed from: b  reason: collision with root package name */
    public String f50485b;

    /* renamed from: c  reason: collision with root package name */
    public f.c f50486c;

    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f50487b;

        public a(boolean z, String str) {
            super(z);
            this.f50487b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f50488b;

        public b(boolean z, String str) {
            super(z);
            this.f50488b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f50489a;

        public c(boolean z) {
            this.f50489a = z;
        }
    }

    public l(int i2, String str) {
        this.f50484a = i2;
        this.f50485b = str;
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
        return this.f50485b;
    }

    public f.c f() {
        return this.f50486c;
    }

    public int g() {
        return this.f50484a;
    }

    public void h(f.c cVar) {
        this.f50486c = cVar;
    }
}
