package com.xiaomi.push;
/* loaded from: classes7.dex */
public final class du {

    /* loaded from: classes7.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f247a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f249b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f251c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f253d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f255e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f256f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f40384g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f40385h;
        public boolean i;
        public boolean j;
        public boolean k;

        /* renamed from: a  reason: collision with root package name */
        public int f40378a = 0;

        /* renamed from: a  reason: collision with other field name */
        public long f245a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f246a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f248b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f250c = "";

        /* renamed from: d  reason: collision with other field name */
        public String f252d = "";

        /* renamed from: e  reason: collision with other field name */
        public String f254e = "";

        /* renamed from: b  reason: collision with root package name */
        public int f40379b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f40380c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f40381d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f40383f = "";

        /* renamed from: e  reason: collision with root package name */
        public int f40382e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40382e < 0) {
                b();
            }
            return this.f40382e;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f245a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f256f = false;
            this.f252d = "";
            return this;
        }

        public a a(int i) {
            this.f247a = true;
            this.f40378a = i;
            return this;
        }

        public a a(long j) {
            this.f249b = true;
            this.f245a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m147b());
                        break;
                    case 16:
                        a(bVar.m148b());
                        break;
                    case 26:
                        a(bVar.m141a());
                        break;
                    case 34:
                        b(bVar.m141a());
                        break;
                    case 42:
                        c(bVar.m141a());
                        break;
                    case 50:
                        d(bVar.m141a());
                        break;
                    case 58:
                        e(bVar.m141a());
                        break;
                    case 64:
                        b(bVar.m147b());
                        break;
                    case 72:
                        c(bVar.m147b());
                        break;
                    case 80:
                        d(bVar.m147b());
                        break;
                    case 90:
                        f(bVar.m141a());
                        break;
                    default:
                        if (a(bVar, m138a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f251c = true;
            this.f246a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f246a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m176a(1, c());
            }
            if (b()) {
                cVar.m190b(2, a());
            }
            if (m236c()) {
                cVar.m180a(3, a());
            }
            if (m238d()) {
                cVar.m180a(4, b());
            }
            if (m240e()) {
                cVar.m180a(5, m235c());
            }
            if (m242f()) {
                cVar.m180a(6, m237d());
            }
            if (g()) {
                cVar.m180a(7, m239e());
            }
            if (h()) {
                cVar.m176a(8, d());
            }
            if (i()) {
                cVar.m176a(9, e());
            }
            if (j()) {
                cVar.m176a(10, f());
            }
            if (k()) {
                cVar.m180a(11, m241f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f247a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.b(2, a());
            }
            if (m236c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m238d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m240e()) {
                a2 += com.xiaomi.push.c.a(5, m235c());
            }
            if (m242f()) {
                a2 += com.xiaomi.push.c.a(6, m237d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m239e());
            }
            if (h()) {
                a2 += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                a2 += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                a2 += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                a2 += com.xiaomi.push.c.a(11, m241f());
            }
            this.f40382e = a2;
            return a2;
        }

        public a b(int i) {
            this.f40385h = true;
            this.f40379b = i;
            return this;
        }

        public a b(String str) {
            this.f253d = true;
            this.f248b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f248b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f249b;
        }

        public int c() {
            return this.f40378a;
        }

        public a c(int i) {
            this.i = true;
            this.f40380c = i;
            return this;
        }

        public a c(String str) {
            this.f255e = true;
            this.f250c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m235c() {
            return this.f250c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m236c() {
            return this.f251c;
        }

        public int d() {
            return this.f40379b;
        }

        public a d(int i) {
            this.j = true;
            this.f40381d = i;
            return this;
        }

        public a d(String str) {
            this.f256f = true;
            this.f252d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m237d() {
            return this.f252d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m238d() {
            return this.f253d;
        }

        public int e() {
            return this.f40380c;
        }

        public a e(String str) {
            this.f40384g = true;
            this.f254e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m239e() {
            return this.f254e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m240e() {
            return this.f255e;
        }

        public int f() {
            return this.f40381d;
        }

        public a f(String str) {
            this.k = true;
            this.f40383f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m241f() {
            return this.f40383f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m242f() {
            return this.f256f;
        }

        public boolean g() {
            return this.f40384g;
        }

        public boolean h() {
            return this.f40385h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f257a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f259c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f260d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40390e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f258b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f40386a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f40387b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f40388c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f40389d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40389d < 0) {
                b();
            }
            return this.f40389d;
        }

        public b a(int i) {
            this.f259c = true;
            this.f40386a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 8) {
                    a(bVar.m144a());
                } else if (m138a == 24) {
                    a(bVar.m147b());
                } else if (m138a == 32) {
                    b(bVar.m147b());
                } else if (m138a == 40) {
                    c(bVar.m147b());
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f257a = true;
            this.f258b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m181a(1, a());
            }
            if (m243c()) {
                cVar.m176a(3, c());
            }
            if (m244d()) {
                cVar.m176a(4, d());
            }
            if (m245e()) {
                cVar.m176a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f258b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m243c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m244d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m245e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.f40389d = a2;
            return a2;
        }

        public b b(int i) {
            this.f260d = true;
            this.f40387b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f257a;
        }

        public int c() {
            return this.f40386a;
        }

        public b c(int i) {
            this.f40390e = true;
            this.f40388c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m243c() {
            return this.f259c;
        }

        public int d() {
            return this.f40387b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m244d() {
            return this.f260d;
        }

        public int e() {
            return this.f40388c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m245e() {
            return this.f40390e;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f262a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f263b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f264c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f265d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f266e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f267f;

        /* renamed from: a  reason: collision with other field name */
        public String f261a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f40392b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f40393c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f40394d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f40395e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f40396f = "";

        /* renamed from: a  reason: collision with root package name */
        public int f40391a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40391a < 0) {
                b();
            }
            return this.f40391a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 10) {
                    a(bVar.m141a());
                } else if (m138a == 18) {
                    b(bVar.m141a());
                } else if (m138a == 26) {
                    c(bVar.m141a());
                } else if (m138a == 34) {
                    d(bVar.m141a());
                } else if (m138a == 42) {
                    e(bVar.m141a());
                } else if (m138a == 50) {
                    f(bVar.m141a());
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.f262a = true;
            this.f261a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f261a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (m246c()) {
                cVar.m180a(3, c());
            }
            if (m247d()) {
                cVar.m180a(4, d());
            }
            if (m248e()) {
                cVar.m180a(5, e());
            }
            if (m249f()) {
                cVar.m180a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f262a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m246c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m247d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m248e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m249f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f40391a = a2;
            return a2;
        }

        public c b(String str) {
            this.f263b = true;
            this.f40392b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40392b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f263b;
        }

        public c c(String str) {
            this.f264c = true;
            this.f40393c = str;
            return this;
        }

        public String c() {
            return this.f40393c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m246c() {
            return this.f264c;
        }

        public c d(String str) {
            this.f265d = true;
            this.f40394d = str;
            return this;
        }

        public String d() {
            return this.f40394d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m247d() {
            return this.f265d;
        }

        public c e(String str) {
            this.f266e = true;
            this.f40395e = str;
            return this;
        }

        public String e() {
            return this.f40395e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m248e() {
            return this.f266e;
        }

        public c f(String str) {
            this.f267f = true;
            this.f40396f = str;
            return this;
        }

        public String f() {
            return this.f40396f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m249f() {
            return this.f267f;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f269a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f271c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40400d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40401e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f270b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f268a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f40398b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f40399c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f40397a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40397a < 0) {
                b();
            }
            return this.f40397a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 8) {
                    a(bVar.m144a());
                } else if (m138a == 18) {
                    a(bVar.m141a());
                } else if (m138a == 26) {
                    b(bVar.m141a());
                } else if (m138a == 34) {
                    c(bVar.m141a());
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f271c = true;
            this.f268a = str;
            return this;
        }

        public d a(boolean z) {
            this.f269a = true;
            this.f270b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f268a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m181a(1, a());
            }
            if (m250c()) {
                cVar.m180a(2, a());
            }
            if (d()) {
                cVar.m180a(3, b());
            }
            if (e()) {
                cVar.m180a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f270b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m250c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f40397a = a2;
            return a2;
        }

        public d b(String str) {
            this.f40400d = true;
            this.f40398b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40398b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f269a;
        }

        public d c(String str) {
            this.f40401e = true;
            this.f40399c = str;
            return this;
        }

        public String c() {
            return this.f40399c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m250c() {
            return this.f271c;
        }

        public boolean d() {
            return this.f40400d;
        }

        public boolean e() {
            return this.f40401e;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f274a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f276b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f278c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f280d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f281e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f282f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f40408g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f40409h;
        public boolean i;
        public boolean j;

        /* renamed from: a  reason: collision with root package name */
        public int f40402a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f273a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f275b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f277c = "";

        /* renamed from: b  reason: collision with root package name */
        public int f40403b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f279d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f40406e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f40407f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f272a = null;

        /* renamed from: c  reason: collision with root package name */
        public int f40404c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f40405d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40405d < 0) {
                b();
            }
            return this.f40405d;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f272a;
        }

        public e a(int i) {
            this.f274a = true;
            this.f40402a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m141a());
                        break;
                    case 26:
                        b(bVar.m141a());
                        break;
                    case 34:
                        c(bVar.m141a());
                        break;
                    case 40:
                        b(bVar.m147b());
                        break;
                    case 50:
                        d(bVar.m141a());
                        break;
                    case 58:
                        e(bVar.m141a());
                        break;
                    case 66:
                        f(bVar.m141a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m147b());
                        break;
                    default:
                        if (a(bVar, m138a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.i = true;
                this.f272a = bVar;
                return this;
            }
            throw null;
        }

        public e a(String str) {
            this.f276b = true;
            this.f273a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f273a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m189b(1, c());
            }
            if (b()) {
                cVar.m180a(2, a());
            }
            if (m252c()) {
                cVar.m180a(3, b());
            }
            if (m254d()) {
                cVar.m180a(4, m251c());
            }
            if (m256e()) {
                cVar.m176a(5, d());
            }
            if (m257f()) {
                cVar.m180a(6, m253d());
            }
            if (g()) {
                cVar.m180a(7, m255e());
            }
            if (h()) {
                cVar.m180a(8, f());
            }
            if (i()) {
                cVar.m179a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m176a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f274a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b2 = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b2 += com.xiaomi.push.c.a(2, a());
            }
            if (m252c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m254d()) {
                b2 += com.xiaomi.push.c.a(4, m251c());
            }
            if (m256e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m257f()) {
                b2 += com.xiaomi.push.c.a(6, m253d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m255e());
            }
            if (h()) {
                b2 += com.xiaomi.push.c.a(8, f());
            }
            if (i()) {
                b2 += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                b2 += com.xiaomi.push.c.a(10, e());
            }
            this.f40405d = b2;
            return b2;
        }

        public e b(int i) {
            this.f281e = true;
            this.f40403b = i;
            return this;
        }

        public e b(String str) {
            this.f278c = true;
            this.f275b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f275b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f276b;
        }

        public int c() {
            return this.f40402a;
        }

        public e c(int i) {
            this.j = true;
            this.f40404c = i;
            return this;
        }

        public e c(String str) {
            this.f280d = true;
            this.f277c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m251c() {
            return this.f277c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m252c() {
            return this.f278c;
        }

        public int d() {
            return this.f40403b;
        }

        public e d(String str) {
            this.f282f = true;
            this.f279d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m253d() {
            return this.f279d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m254d() {
            return this.f280d;
        }

        public int e() {
            return this.f40404c;
        }

        public e e(String str) {
            this.f40408g = true;
            this.f40406e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m255e() {
            return this.f40406e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m256e() {
            return this.f281e;
        }

        public e f(String str) {
            this.f40409h = true;
            this.f40407f = str;
            return this;
        }

        public String f() {
            return this.f40407f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m257f() {
            return this.f282f;
        }

        public boolean g() {
            return this.f40408g;
        }

        public boolean h() {
            return this.f40409h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f285a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f286b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40412c;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f40411b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f283a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f40410a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40410a < 0) {
                b();
            }
            return this.f40410a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f283a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 10) {
                    a(bVar.m141a());
                } else if (m138a == 18) {
                    b(bVar.m141a());
                } else if (m138a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f40412c = true;
                this.f283a = bVar;
                return this;
            }
            throw null;
        }

        public f a(String str) {
            this.f285a = true;
            this.f284a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (c()) {
                cVar.m179a(3, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f285a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (c()) {
                a2 += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) a());
            }
            this.f40410a = a2;
            return a2;
        }

        public f b(String str) {
            this.f286b = true;
            this.f40411b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40411b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f286b;
        }

        public boolean c() {
            return this.f40412c;
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f288a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f289b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f290c;

        /* renamed from: a  reason: collision with other field name */
        public String f287a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f40414b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f40415c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f40413a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40413a < 0) {
                b();
            }
            return this.f40413a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 10) {
                    a(bVar.m141a());
                } else if (m138a == 18) {
                    b(bVar.m141a());
                } else if (m138a == 26) {
                    c(bVar.m141a());
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.f288a = true;
            this.f287a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f287a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (m258c()) {
                cVar.m180a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f288a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m258c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f40413a = a2;
            return a2;
        }

        public g b(String str) {
            this.f289b = true;
            this.f40414b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40414b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f289b;
        }

        public g c(String str) {
            this.f290c = true;
            this.f40415c = str;
            return this;
        }

        public String c() {
            return this.f40415c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m258c() {
            return this.f290c;
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f292a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f293b;

        /* renamed from: a  reason: collision with root package name */
        public int f40416a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f291a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f40417b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40417b < 0) {
                b();
            }
            return this.f40417b;
        }

        public h a(int i) {
            this.f292a = true;
            this.f40416a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 8) {
                    a(bVar.m147b());
                } else if (m138a == 18) {
                    a(bVar.m141a());
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f293b = true;
            this.f291a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f291a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m176a(1, c());
            }
            if (b()) {
                cVar.m180a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f292a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            this.f40417b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f293b;
        }

        public int c() {
            return this.f40416a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f294a = com.xiaomi.push.a.f40213a;

        /* renamed from: a  reason: collision with root package name */
        public int f40418a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40418a < 0) {
                b();
            }
            return this.f40418a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f294a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f295a = true;
            this.f294a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 10) {
                    a(bVar.m140a());
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m178a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f40418a = a2;
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f298a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f40420b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f296a = com.xiaomi.push.a.f40213a;

        /* renamed from: a  reason: collision with other field name */
        public b f297a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f40419a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40419a < 0) {
                b();
            }
            return this.f40419a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f296a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f297a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f298a = true;
            this.f296a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 10) {
                    a(bVar.m140a());
                } else if (m138a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f40420b = true;
                this.f297a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m178a(1, a());
            }
            if (b()) {
                cVar.m179a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f298a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
            }
            this.f40419a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f40420b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f301a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40423c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40424d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40425e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f40427g;

        /* renamed from: a  reason: collision with other field name */
        public String f300a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f303b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f299a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f302b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f40426f = false;

        /* renamed from: a  reason: collision with root package name */
        public int f40421a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f40422b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40422b < 0) {
                b();
            }
            return this.f40422b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f299a;
        }

        public k a(int i) {
            this.f40427g = true;
            this.f40421a = i;
            return this;
        }

        public k a(long j) {
            this.f40423c = true;
            this.f299a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 10) {
                    a(bVar.m141a());
                } else if (m138a == 18) {
                    b(bVar.m141a());
                } else if (m138a == 24) {
                    a(bVar.m139a());
                } else if (m138a == 32) {
                    b(bVar.m139a());
                } else if (m138a == 40) {
                    a(bVar.m144a());
                } else if (m138a == 48) {
                    a(bVar.m147b());
                } else if (!a(bVar, m138a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.f301a = true;
            this.f300a = str;
            return this;
        }

        public k a(boolean z) {
            this.f40425e = true;
            this.f40426f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f300a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (m259c()) {
                cVar.m177a(3, a());
            }
            if (d()) {
                cVar.m177a(4, b());
            }
            if (f()) {
                cVar.m181a(5, e());
            }
            if (g()) {
                cVar.m176a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f301a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m259c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (f()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(6, c());
            }
            this.f40422b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f302b;
        }

        public k b(long j) {
            this.f40424d = true;
            this.f302b = j;
            return this;
        }

        public k b(String str) {
            this.f304b = true;
            this.f303b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f303b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f304b;
        }

        public int c() {
            return this.f40421a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m259c() {
            return this.f40423c;
        }

        public boolean d() {
            return this.f40424d;
        }

        public boolean e() {
            return this.f40426f;
        }

        public boolean f() {
            return this.f40425e;
        }

        public boolean g() {
            return this.f40427g;
        }
    }
}
