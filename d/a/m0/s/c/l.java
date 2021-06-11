package d.a.m0.s.c;

import d.a.n0.e3.n0.f;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public int f54160a;

    /* renamed from: b  reason: collision with root package name */
    public String f54161b;

    /* renamed from: c  reason: collision with root package name */
    public f.c f54162c;

    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f54163b;

        public a(boolean z, String str) {
            super(z);
            this.f54163b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f54164b;

        public b(boolean z, String str) {
            super(z);
            this.f54164b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f54165a;

        public c(boolean z) {
            this.f54165a = z;
        }
    }

    public l(int i2, String str) {
        this.f54160a = i2;
        this.f54161b = str;
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
        return this.f54161b;
    }

    public f.c f() {
        return this.f54162c;
    }

    public int g() {
        return this.f54160a;
    }

    public void h(f.c cVar) {
        this.f54162c = cVar;
    }
}
