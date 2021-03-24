package d.b.h0.s.c;

import d.b.i0.c3.n0.f;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public int f51181a;

    /* renamed from: b  reason: collision with root package name */
    public String f51182b;

    /* renamed from: c  reason: collision with root package name */
    public f.c f51183c;

    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f51184b;

        public a(boolean z, String str) {
            super(z);
            this.f51184b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f51185b;

        public b(boolean z, String str) {
            super(z);
            this.f51185b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51186a;

        public c(boolean z) {
            this.f51186a = z;
        }
    }

    public j(int i, String str) {
        this.f51181a = i;
        this.f51182b = str;
    }

    public static j a(String str) {
        return new j(0, str);
    }

    public static j b() {
        return new j(2, null);
    }

    public static j c() {
        return new j(3, null);
    }

    public static j d() {
        return new j(1, null);
    }

    public String e() {
        return this.f51182b;
    }

    public f.c f() {
        return this.f51183c;
    }

    public int g() {
        return this.f51181a;
    }

    public void h(f.c cVar) {
        this.f51183c = cVar;
    }
}
