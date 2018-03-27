package com.xiaomi.push.protobuf;
/* loaded from: classes2.dex */
public final class b {

    /* loaded from: classes2.dex */
    public static final class a extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean i;
        private boolean k;
        private boolean m;
        private boolean o;
        private boolean q;
        private boolean s;
        private boolean u;
        private int b = 0;
        private long d = 0;
        private String f = "";
        private String h = "";
        private String j = "";
        private String l = "";
        private String n = "";
        private int p = 1;
        private int r = 0;
        private int t = 0;
        private String v = "";
        private int w = -1;

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.w < 0) {
                b();
            }
            return this.w;
        }

        public a a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public a a(long j) {
            this.c = true;
            this.d = j;
            return this;
        }

        public a a(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.j(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
            if (k()) {
                cVar.a(4, j());
            }
            if (m()) {
                cVar.a(5, l());
            }
            if (o()) {
                cVar.a(6, n());
            }
            if (r()) {
                cVar.a(7, q());
            }
            if (s()) {
                cVar.a(8, t());
            }
            if (v()) {
                cVar.a(9, u());
            }
            if (x()) {
                cVar.a(10, w());
            }
            if (z()) {
                cVar.a(11, y());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int c = e() ? 0 + com.google.protobuf.micro.c.c(1, d()) : 0;
            if (g()) {
                c += com.google.protobuf.micro.c.l(2, f());
            }
            if (i()) {
                c += com.google.protobuf.micro.c.b(3, h());
            }
            if (k()) {
                c += com.google.protobuf.micro.c.b(4, j());
            }
            if (m()) {
                c += com.google.protobuf.micro.c.b(5, l());
            }
            if (o()) {
                c += com.google.protobuf.micro.c.b(6, n());
            }
            if (r()) {
                c += com.google.protobuf.micro.c.b(7, q());
            }
            if (s()) {
                c += com.google.protobuf.micro.c.c(8, t());
            }
            if (v()) {
                c += com.google.protobuf.micro.c.c(9, u());
            }
            if (x()) {
                c += com.google.protobuf.micro.c.c(10, w());
            }
            if (z()) {
                c += com.google.protobuf.micro.c.b(11, y());
            }
            this.w = c;
            return c;
        }

        public a b(int i) {
            this.o = true;
            this.p = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public a a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.e());
                        break;
                    case 16:
                        a(bVar.d());
                        break;
                    case 26:
                        a(bVar.g());
                        break;
                    case 34:
                        b(bVar.g());
                        break;
                    case 42:
                        c(bVar.g());
                        break;
                    case 50:
                        d(bVar.g());
                        break;
                    case 58:
                        e(bVar.g());
                        break;
                    case 64:
                        b(bVar.e());
                        break;
                    case 72:
                        c(bVar.e());
                        break;
                    case 80:
                        d(bVar.e());
                        break;
                    case 90:
                        f(bVar.g());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a b(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public a c(int i) {
            this.q = true;
            this.r = i;
            return this;
        }

        public a c(String str) {
            this.i = true;
            this.j = str;
            return this;
        }

        public int d() {
            return this.b;
        }

        public a d(int i) {
            this.s = true;
            this.t = i;
            return this;
        }

        public a d(String str) {
            this.k = true;
            this.l = str;
            return this;
        }

        public a e(String str) {
            this.m = true;
            this.n = str;
            return this;
        }

        public boolean e() {
            return this.a;
        }

        public long f() {
            return this.d;
        }

        public a f(String str) {
            this.u = true;
            this.v = str;
            return this;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public String l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public String n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }

        public a p() {
            this.k = false;
            this.l = "";
            return this;
        }

        public String q() {
            return this.n;
        }

        public boolean r() {
            return this.m;
        }

        public boolean s() {
            return this.o;
        }

        public int t() {
            return this.p;
        }

        public int u() {
            return this.r;
        }

        public boolean v() {
            return this.q;
        }

        public int w() {
            return this.t;
        }

        public boolean x() {
            return this.s;
        }

        public String y() {
            return this.v;
        }

        public boolean z() {
            return this.u;
        }
    }

    /* renamed from: com.xiaomi.push.protobuf.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0291b extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean b = false;
        private int d = 0;
        private int f = 0;
        private int h = 0;
        private int i = -1;

        public static C0291b b(byte[] bArr) {
            return (C0291b) new C0291b().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.i < 0) {
                b();
            }
            return this.i;
        }

        public C0291b a(int i) {
            this.c = true;
            this.d = i;
            return this;
        }

        public C0291b a(boolean z) {
            this.a = true;
            this.b = z;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.a(3, f());
            }
            if (i()) {
                cVar.a(4, h());
            }
            if (k()) {
                cVar.a(5, j());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int ac = e() ? 0 + com.google.protobuf.micro.c.ac(1, d()) : 0;
            if (g()) {
                ac += com.google.protobuf.micro.c.c(3, f());
            }
            if (i()) {
                ac += com.google.protobuf.micro.c.c(4, h());
            }
            if (k()) {
                ac += com.google.protobuf.micro.c.c(5, j());
            }
            this.i = ac;
            return ac;
        }

        public C0291b b(int i) {
            this.e = true;
            this.f = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public C0291b a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.f());
                        break;
                    case 24:
                        a(bVar.e());
                        break;
                    case 32:
                        b(bVar.e());
                        break;
                    case 40:
                        c(bVar.e());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public C0291b c(int i) {
            this.g = true;
            this.h = i;
            return this;
        }

        public boolean d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public int f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public int h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public int j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean i;
        private boolean k;
        private String b = "";
        private String d = "";
        private String f = "";
        private String h = "";
        private String j = "";
        private String l = "";
        private int m = -1;

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.m < 0) {
                b();
            }
            return this.m;
        }

        public c a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
            if (k()) {
                cVar.a(4, j());
            }
            if (m()) {
                cVar.a(5, l());
            }
            if (o()) {
                cVar.a(6, n());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int b = e() ? 0 + com.google.protobuf.micro.c.b(1, d()) : 0;
            if (g()) {
                b += com.google.protobuf.micro.c.b(2, f());
            }
            if (i()) {
                b += com.google.protobuf.micro.c.b(3, h());
            }
            if (k()) {
                b += com.google.protobuf.micro.c.b(4, j());
            }
            if (m()) {
                b += com.google.protobuf.micro.c.b(5, l());
            }
            if (o()) {
                b += com.google.protobuf.micro.c.b(6, n());
            }
            this.m = b;
            return b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public c a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.g());
                        break;
                    case 18:
                        b(bVar.g());
                        break;
                    case 26:
                        c(bVar.g());
                        break;
                    case 34:
                        d(bVar.g());
                        break;
                    case 42:
                        e(bVar.g());
                        break;
                    case 50:
                        f(bVar.g());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public c c(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public c d(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public c e(String str) {
            this.i = true;
            this.j = str;
            return this;
        }

        public boolean e() {
            return this.a;
        }

        public c f(String str) {
            this.k = true;
            this.l = str;
            return this;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public String l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public String n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean b = false;
        private String d = "";
        private String f = "";
        private String h = "";
        private int i = -1;

        public static d b(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.i < 0) {
                b();
            }
            return this.i;
        }

        public d a(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public d a(boolean z) {
            this.a = true;
            this.b = z;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
            if (k()) {
                cVar.a(4, j());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int ac = e() ? 0 + com.google.protobuf.micro.c.ac(1, d()) : 0;
            if (g()) {
                ac += com.google.protobuf.micro.c.b(2, f());
            }
            if (i()) {
                ac += com.google.protobuf.micro.c.b(3, h());
            }
            if (k()) {
                ac += com.google.protobuf.micro.c.b(4, j());
            }
            this.i = ac;
            return ac;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public d a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.f());
                        break;
                    case 18:
                        a(bVar.g());
                        break;
                    case 26:
                        b(bVar.g());
                        break;
                    case 34:
                        c(bVar.g());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d b(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public d c(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public boolean d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean i;
        private boolean k;
        private boolean m;
        private boolean o;
        private boolean q;
        private boolean s;
        private int b = 0;
        private String d = "";
        private String f = "";
        private String h = "";
        private int j = 0;
        private String l = "";
        private String n = "";
        private String p = "";
        private C0291b r = null;
        private int t = 0;
        private int u = -1;

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.u < 0) {
                b();
            }
            return this.u;
        }

        public e a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public e a(C0291b c0291b) {
            if (c0291b == null) {
                throw new NullPointerException();
            }
            this.q = true;
            this.r = c0291b;
            return this;
        }

        public e a(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.b(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
            if (k()) {
                cVar.a(4, j());
            }
            if (m()) {
                cVar.a(5, l());
            }
            if (o()) {
                cVar.a(6, n());
            }
            if (q()) {
                cVar.a(7, p());
            }
            if (s()) {
                cVar.a(8, r());
            }
            if (t()) {
                cVar.a(9, u());
            }
            if (w()) {
                cVar.a(10, v());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int cV = e() ? 0 + com.google.protobuf.micro.c.cV(1, d()) : 0;
            if (g()) {
                cV += com.google.protobuf.micro.c.b(2, f());
            }
            if (i()) {
                cV += com.google.protobuf.micro.c.b(3, h());
            }
            if (k()) {
                cV += com.google.protobuf.micro.c.b(4, j());
            }
            if (m()) {
                cV += com.google.protobuf.micro.c.c(5, l());
            }
            if (o()) {
                cV += com.google.protobuf.micro.c.b(6, n());
            }
            if (q()) {
                cV += com.google.protobuf.micro.c.b(7, p());
            }
            if (s()) {
                cV += com.google.protobuf.micro.c.b(8, r());
            }
            if (t()) {
                cV += com.google.protobuf.micro.c.b(9, u());
            }
            if (w()) {
                cV += com.google.protobuf.micro.c.c(10, v());
            }
            this.u = cV;
            return cV;
        }

        public e b(int i) {
            this.i = true;
            this.j = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public e a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.i());
                        break;
                    case 18:
                        a(bVar.g());
                        break;
                    case 26:
                        b(bVar.g());
                        break;
                    case 34:
                        c(bVar.g());
                        break;
                    case 40:
                        b(bVar.e());
                        break;
                    case 50:
                        d(bVar.g());
                        break;
                    case 58:
                        e(bVar.g());
                        break;
                    case 66:
                        f(bVar.g());
                        break;
                    case 74:
                        C0291b c0291b = new C0291b();
                        bVar.a(c0291b);
                        a(c0291b);
                        break;
                    case 80:
                        c(bVar.e());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public e b(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public e c(int i) {
            this.s = true;
            this.t = i;
            return this;
        }

        public e c(String str) {
            this.g = true;
            this.h = str;
            return this;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.k = true;
            this.l = str;
            return this;
        }

        public e e(String str) {
            this.m = true;
            this.n = str;
            return this;
        }

        public boolean e() {
            return this.a;
        }

        public e f(String str) {
            this.o = true;
            this.p = str;
            return this;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public String j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public int l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public String n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }

        public String p() {
            return this.n;
        }

        public boolean q() {
            return this.m;
        }

        public String r() {
            return this.p;
        }

        public boolean s() {
            return this.o;
        }

        public boolean t() {
            return this.q;
        }

        public C0291b u() {
            return this.r;
        }

        public int v() {
            return this.t;
        }

        public boolean w() {
            return this.s;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private String b = "";
        private String d = "";
        private C0291b f = null;
        private int g = -1;

        public static f b(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.g < 0) {
                b();
            }
            return this.g;
        }

        public f a(C0291b c0291b) {
            if (c0291b == null) {
                throw new NullPointerException();
            }
            this.e = true;
            this.f = c0291b;
            return this;
        }

        public f a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (h()) {
                cVar.a(3, i());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int b = e() ? 0 + com.google.protobuf.micro.c.b(1, d()) : 0;
            if (g()) {
                b += com.google.protobuf.micro.c.b(2, f());
            }
            if (h()) {
                b += com.google.protobuf.micro.c.b(3, i());
            }
            this.g = b;
            return b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public f a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.g());
                        break;
                    case 18:
                        b(bVar.g());
                        break;
                    case 26:
                        C0291b c0291b = new C0291b();
                        bVar.a(c0291b);
                        a(c0291b);
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public f b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public boolean h() {
            return this.e;
        }

        public C0291b i() {
            return this.f;
        }
    }

    /* loaded from: classes2.dex */
    public static final class g extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private String b = "";
        private String d = "";
        private String f = "";
        private int g = -1;

        public static g b(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.g < 0) {
                b();
            }
            return this.g;
        }

        public g a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int b = e() ? 0 + com.google.protobuf.micro.c.b(1, d()) : 0;
            if (g()) {
                b += com.google.protobuf.micro.c.b(2, f());
            }
            if (i()) {
                b += com.google.protobuf.micro.c.b(3, h());
            }
            this.g = b;
            return b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public g a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.g());
                        break;
                    case 18:
                        b(bVar.g());
                        break;
                    case 26:
                        c(bVar.g());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public g c(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public String h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }
    }

    /* loaded from: classes2.dex */
    public static final class h extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private int b = 0;
        private String d = "";
        private int e = -1;

        public static h b(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        public h a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public h a(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int c = e() ? 0 + com.google.protobuf.micro.c.c(1, d()) : 0;
            if (g()) {
                c += com.google.protobuf.micro.c.b(2, f());
            }
            this.e = c;
            return c;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public h a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.e());
                        break;
                    case 18:
                        a(bVar.g());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public int d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }
    }

    /* loaded from: classes2.dex */
    public static final class i extends com.google.protobuf.micro.e {
        private boolean a;
        private com.google.protobuf.micro.a b = com.google.protobuf.micro.a.hYR;
        private int c = -1;

        public static i b(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        public i a(com.google.protobuf.micro.a aVar) {
            this.a = true;
            this.b = aVar;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int b = e() ? 0 + com.google.protobuf.micro.c.b(1, d()) : 0;
            this.c = b;
            return b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public i a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.bNb());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public com.google.protobuf.micro.a d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private com.google.protobuf.micro.a b = com.google.protobuf.micro.a.hYR;
        private C0291b d = null;
        private int e = -1;

        public static j b(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        public j a(com.google.protobuf.micro.a aVar) {
            this.a = true;
            this.b = aVar;
            return this;
        }

        public j a(C0291b c0291b) {
            if (c0291b == null) {
                throw new NullPointerException();
            }
            this.c = true;
            this.d = c0291b;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (f()) {
                cVar.a(2, g());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int b = e() ? 0 + com.google.protobuf.micro.c.b(1, d()) : 0;
            if (f()) {
                b += com.google.protobuf.micro.c.b(2, g());
            }
            this.e = b;
            return b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public j a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.bNb());
                        break;
                    case 18:
                        C0291b c0291b = new C0291b();
                        bVar.a(c0291b);
                        a(c0291b);
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public com.google.protobuf.micro.a d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public boolean f() {
            return this.c;
        }

        public C0291b g() {
            return this.d;
        }
    }

    /* loaded from: classes2.dex */
    public static final class k extends com.google.protobuf.micro.e {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private boolean i;
        private boolean k;
        private String b = "";
        private String d = "";
        private long f = 0;
        private long h = 0;
        private boolean j = false;
        private int l = 0;
        private int m = -1;

        public static k b(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.m < 0) {
                b();
            }
            return this.m;
        }

        public k a(int i) {
            this.k = true;
            this.l = i;
            return this;
        }

        public k a(long j) {
            this.e = true;
            this.f = j;
            return this;
        }

        public k a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public k a(boolean z) {
            this.i = true;
            this.j = z;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(com.google.protobuf.micro.c cVar) {
            if (e()) {
                cVar.a(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
            if (k()) {
                cVar.a(4, j());
            }
            if (m()) {
                cVar.a(5, l());
            }
            if (o()) {
                cVar.a(6, n());
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int b = e() ? 0 + com.google.protobuf.micro.c.b(1, d()) : 0;
            if (g()) {
                b += com.google.protobuf.micro.c.b(2, f());
            }
            if (i()) {
                b += com.google.protobuf.micro.c.k(3, h());
            }
            if (k()) {
                b += com.google.protobuf.micro.c.k(4, j());
            }
            if (m()) {
                b += com.google.protobuf.micro.c.ac(5, l());
            }
            if (o()) {
                b += com.google.protobuf.micro.c.c(6, n());
            }
            this.m = b;
            return b;
        }

        public k b(long j) {
            this.g = true;
            this.h = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public k a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.g());
                        break;
                    case 18:
                        b(bVar.g());
                        break;
                    case 24:
                        a(bVar.c());
                        break;
                    case 32:
                        b(bVar.c());
                        break;
                    case 40:
                        a(bVar.f());
                        break;
                    case 48:
                        a(bVar.e());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k b(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public String f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public long h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public long j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public boolean l() {
            return this.j;
        }

        public boolean m() {
            return this.i;
        }

        public int n() {
            return this.l;
        }

        public boolean o() {
            return this.k;
        }
    }
}
