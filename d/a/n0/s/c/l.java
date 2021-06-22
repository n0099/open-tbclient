package d.a.n0.s.c;

import d.a.o0.e3.n0.f;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public int f54267a;

    /* renamed from: b  reason: collision with root package name */
    public String f54268b;

    /* renamed from: c  reason: collision with root package name */
    public f.c f54269c;

    /* loaded from: classes3.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f54270b;

        public a(boolean z, String str) {
            super(z);
            this.f54270b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        public String f54271b;

        public b(boolean z, String str) {
            super(z);
            this.f54271b = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f54272a;

        public c(boolean z) {
            this.f54272a = z;
        }
    }

    public l(int i2, String str) {
        this.f54267a = i2;
        this.f54268b = str;
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
        return this.f54268b;
    }

    public f.c f() {
        return this.f54269c;
    }

    public int g() {
        return this.f54267a;
    }

    public void h(f.c cVar) {
        this.f54269c = cVar;
    }
}
