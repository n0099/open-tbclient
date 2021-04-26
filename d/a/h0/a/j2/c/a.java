package d.a.h0.a.j2.c;

import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f43012a;

    /* renamed from: b  reason: collision with root package name */
    public int f43013b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43014c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43015d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43016e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43017f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43018g;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f43019a;

        /* renamed from: b  reason: collision with root package name */
        public int f43020b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43021c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f43022d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f43023e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f43024f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43025g = true;

        public static b b() {
            return new b();
        }

        public a a() {
            a aVar = new a();
            aVar.f43013b = this.f43020b;
            aVar.f43014c = this.f43021c;
            aVar.f43016e = this.f43023e;
            aVar.f43015d = this.f43022d;
            aVar.f43012a = this.f43019a;
            aVar.f43017f = this.f43024f;
            aVar.f43018g = this.f43025g;
            return aVar;
        }

        public b c(boolean z) {
            this.f43024f = z;
            return this;
        }

        public b d(boolean z) {
            this.f43025g = z;
            return this;
        }

        public b e(int i2) {
            this.f43020b = i2;
            return this;
        }

        public b f(int i2) {
            this.f43019a = i2;
            return this;
        }

        public b g(boolean z) {
            this.f43021c = z;
            return this;
        }

        public b h(boolean z) {
            this.f43023e = z;
            return this;
        }

        public b i(boolean z) {
            this.f43022d = z;
            return this;
        }
    }

    static {
        boolean z = k.f43101a;
    }

    public a() {
        this.f43018g = true;
    }
}
