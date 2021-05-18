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
        public boolean f37531g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37532h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f37533i;
        public boolean j;
        public boolean k;

        /* renamed from: a  reason: collision with root package name */
        public int f37525a = 0;

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
        public int f37526b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f37527c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f37528d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f37530f = "";

        /* renamed from: e  reason: collision with root package name */
        public int f37529e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37529e < 0) {
                b();
            }
            return this.f37529e;
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

        public a a(int i2) {
            this.f247a = true;
            this.f37525a = i2;
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
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m153b());
                        break;
                    case 16:
                        a(bVar.m154b());
                        break;
                    case 26:
                        a(bVar.m147a());
                        break;
                    case 34:
                        b(bVar.m147a());
                        break;
                    case 42:
                        c(bVar.m147a());
                        break;
                    case 50:
                        d(bVar.m147a());
                        break;
                    case 58:
                        e(bVar.m147a());
                        break;
                    case 64:
                        b(bVar.m153b());
                        break;
                    case 72:
                        c(bVar.m153b());
                        break;
                    case 80:
                        d(bVar.m153b());
                        break;
                    case 90:
                        f(bVar.m147a());
                        break;
                    default:
                        if (a(bVar, m144a)) {
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
                cVar.m182a(1, c());
            }
            if (b()) {
                cVar.m196b(2, a());
            }
            if (m242c()) {
                cVar.m186a(3, a());
            }
            if (m244d()) {
                cVar.m186a(4, b());
            }
            if (m246e()) {
                cVar.m186a(5, m241c());
            }
            if (m248f()) {
                cVar.m186a(6, m243d());
            }
            if (g()) {
                cVar.m186a(7, m245e());
            }
            if (h()) {
                cVar.m182a(8, d());
            }
            if (i()) {
                cVar.m182a(9, e());
            }
            if (j()) {
                cVar.m182a(10, f());
            }
            if (k()) {
                cVar.m186a(11, m247f());
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
            if (m242c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m244d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m246e()) {
                a2 += com.xiaomi.push.c.a(5, m241c());
            }
            if (m248f()) {
                a2 += com.xiaomi.push.c.a(6, m243d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m245e());
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
                a2 += com.xiaomi.push.c.a(11, m247f());
            }
            this.f37529e = a2;
            return a2;
        }

        public a b(int i2) {
            this.f37532h = true;
            this.f37526b = i2;
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
            return this.f37525a;
        }

        public a c(int i2) {
            this.f37533i = true;
            this.f37527c = i2;
            return this;
        }

        public a c(String str) {
            this.f255e = true;
            this.f250c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m241c() {
            return this.f250c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m242c() {
            return this.f251c;
        }

        public int d() {
            return this.f37526b;
        }

        public a d(int i2) {
            this.j = true;
            this.f37528d = i2;
            return this;
        }

        public a d(String str) {
            this.f256f = true;
            this.f252d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m243d() {
            return this.f252d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m244d() {
            return this.f253d;
        }

        public int e() {
            return this.f37527c;
        }

        public a e(String str) {
            this.f37531g = true;
            this.f254e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m245e() {
            return this.f254e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m246e() {
            return this.f255e;
        }

        public int f() {
            return this.f37528d;
        }

        public a f(String str) {
            this.k = true;
            this.f37530f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m247f() {
            return this.f37530f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m248f() {
            return this.f256f;
        }

        public boolean g() {
            return this.f37531g;
        }

        public boolean h() {
            return this.f37532h;
        }

        public boolean i() {
            return this.f37533i;
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
        public boolean f37538e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f258b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f37534a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f37535b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f37536c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f37537d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37537d < 0) {
                b();
            }
            return this.f37537d;
        }

        public b a(int i2) {
            this.f259c = true;
            this.f37534a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 8) {
                    a(bVar.m150a());
                } else if (m144a == 24) {
                    a(bVar.m153b());
                } else if (m144a == 32) {
                    b(bVar.m153b());
                } else if (m144a == 40) {
                    c(bVar.m153b());
                } else if (!a(bVar, m144a)) {
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
                cVar.m187a(1, a());
            }
            if (m249c()) {
                cVar.m182a(3, c());
            }
            if (m250d()) {
                cVar.m182a(4, d());
            }
            if (m251e()) {
                cVar.m182a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f258b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m249c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m250d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m251e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.f37537d = a2;
            return a2;
        }

        public b b(int i2) {
            this.f260d = true;
            this.f37535b = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f257a;
        }

        public int c() {
            return this.f37534a;
        }

        public b c(int i2) {
            this.f37538e = true;
            this.f37536c = i2;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m249c() {
            return this.f259c;
        }

        public int d() {
            return this.f37535b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m250d() {
            return this.f260d;
        }

        public int e() {
            return this.f37536c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m251e() {
            return this.f37538e;
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
        public String f37540b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f37541c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f37542d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f37543e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f37544f = "";

        /* renamed from: a  reason: collision with root package name */
        public int f37539a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37539a < 0) {
                b();
            }
            return this.f37539a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 10) {
                    a(bVar.m147a());
                } else if (m144a == 18) {
                    b(bVar.m147a());
                } else if (m144a == 26) {
                    c(bVar.m147a());
                } else if (m144a == 34) {
                    d(bVar.m147a());
                } else if (m144a == 42) {
                    e(bVar.m147a());
                } else if (m144a == 50) {
                    f(bVar.m147a());
                } else if (!a(bVar, m144a)) {
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
                cVar.m186a(1, a());
            }
            if (b()) {
                cVar.m186a(2, b());
            }
            if (m252c()) {
                cVar.m186a(3, c());
            }
            if (m253d()) {
                cVar.m186a(4, d());
            }
            if (m254e()) {
                cVar.m186a(5, e());
            }
            if (m255f()) {
                cVar.m186a(6, f());
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
            if (m252c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m253d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m254e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m255f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f37539a = a2;
            return a2;
        }

        public c b(String str) {
            this.f263b = true;
            this.f37540b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37540b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f263b;
        }

        public c c(String str) {
            this.f264c = true;
            this.f37541c = str;
            return this;
        }

        public String c() {
            return this.f37541c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m252c() {
            return this.f264c;
        }

        public c d(String str) {
            this.f265d = true;
            this.f37542d = str;
            return this;
        }

        public String d() {
            return this.f37542d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m253d() {
            return this.f265d;
        }

        public c e(String str) {
            this.f266e = true;
            this.f37543e = str;
            return this;
        }

        public String e() {
            return this.f37543e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m254e() {
            return this.f266e;
        }

        public c f(String str) {
            this.f267f = true;
            this.f37544f = str;
            return this;
        }

        public String f() {
            return this.f37544f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m255f() {
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
        public boolean f37548d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37549e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f270b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f268a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f37546b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f37547c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f37545a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37545a < 0) {
                b();
            }
            return this.f37545a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 8) {
                    a(bVar.m150a());
                } else if (m144a == 18) {
                    a(bVar.m147a());
                } else if (m144a == 26) {
                    b(bVar.m147a());
                } else if (m144a == 34) {
                    c(bVar.m147a());
                } else if (!a(bVar, m144a)) {
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
                cVar.m187a(1, a());
            }
            if (m256c()) {
                cVar.m186a(2, a());
            }
            if (d()) {
                cVar.m186a(3, b());
            }
            if (e()) {
                cVar.m186a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f270b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m256c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f37545a = a2;
            return a2;
        }

        public d b(String str) {
            this.f37548d = true;
            this.f37546b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37546b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f269a;
        }

        public d c(String str) {
            this.f37549e = true;
            this.f37547c = str;
            return this;
        }

        public String c() {
            return this.f37547c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m256c() {
            return this.f271c;
        }

        public boolean d() {
            return this.f37548d;
        }

        public boolean e() {
            return this.f37549e;
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
        public boolean f37556g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37557h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f37558i;
        public boolean j;

        /* renamed from: a  reason: collision with root package name */
        public int f37550a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f273a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f275b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f277c = "";

        /* renamed from: b  reason: collision with root package name */
        public int f37551b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f279d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f37554e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f37555f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f272a = null;

        /* renamed from: c  reason: collision with root package name */
        public int f37552c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f37553d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37553d < 0) {
                b();
            }
            return this.f37553d;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f272a;
        }

        public e a(int i2) {
            this.f274a = true;
            this.f37550a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m147a());
                        break;
                    case 26:
                        b(bVar.m147a());
                        break;
                    case 34:
                        c(bVar.m147a());
                        break;
                    case 40:
                        b(bVar.m153b());
                        break;
                    case 50:
                        d(bVar.m147a());
                        break;
                    case 58:
                        e(bVar.m147a());
                        break;
                    case 66:
                        f(bVar.m147a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m153b());
                        break;
                    default:
                        if (a(bVar, m144a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.f37558i = true;
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
                cVar.m195b(1, c());
            }
            if (b()) {
                cVar.m186a(2, a());
            }
            if (m258c()) {
                cVar.m186a(3, b());
            }
            if (m260d()) {
                cVar.m186a(4, m257c());
            }
            if (m262e()) {
                cVar.m182a(5, d());
            }
            if (m263f()) {
                cVar.m186a(6, m259d());
            }
            if (g()) {
                cVar.m186a(7, m261e());
            }
            if (h()) {
                cVar.m186a(8, f());
            }
            if (i()) {
                cVar.m185a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m182a(10, e());
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
            if (m258c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m260d()) {
                b2 += com.xiaomi.push.c.a(4, m257c());
            }
            if (m262e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m263f()) {
                b2 += com.xiaomi.push.c.a(6, m259d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m261e());
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
            this.f37553d = b2;
            return b2;
        }

        public e b(int i2) {
            this.f281e = true;
            this.f37551b = i2;
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
            return this.f37550a;
        }

        public e c(int i2) {
            this.j = true;
            this.f37552c = i2;
            return this;
        }

        public e c(String str) {
            this.f280d = true;
            this.f277c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m257c() {
            return this.f277c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m258c() {
            return this.f278c;
        }

        public int d() {
            return this.f37551b;
        }

        public e d(String str) {
            this.f282f = true;
            this.f279d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m259d() {
            return this.f279d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m260d() {
            return this.f280d;
        }

        public int e() {
            return this.f37552c;
        }

        public e e(String str) {
            this.f37556g = true;
            this.f37554e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m261e() {
            return this.f37554e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m262e() {
            return this.f281e;
        }

        public e f(String str) {
            this.f37557h = true;
            this.f37555f = str;
            return this;
        }

        public String f() {
            return this.f37555f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m263f() {
            return this.f282f;
        }

        public boolean g() {
            return this.f37556g;
        }

        public boolean h() {
            return this.f37557h;
        }

        public boolean i() {
            return this.f37558i;
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
        public boolean f37561c;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f37560b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f283a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f37559a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37559a < 0) {
                b();
            }
            return this.f37559a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f283a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 10) {
                    a(bVar.m147a());
                } else if (m144a == 18) {
                    b(bVar.m147a());
                } else if (m144a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m144a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f37561c = true;
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
                cVar.m186a(1, a());
            }
            if (b()) {
                cVar.m186a(2, b());
            }
            if (c()) {
                cVar.m185a(3, (com.xiaomi.push.e) a());
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
            this.f37559a = a2;
            return a2;
        }

        public f b(String str) {
            this.f286b = true;
            this.f37560b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37560b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f286b;
        }

        public boolean c() {
            return this.f37561c;
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
        public String f37563b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f37564c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f37562a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37562a < 0) {
                b();
            }
            return this.f37562a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 10) {
                    a(bVar.m147a());
                } else if (m144a == 18) {
                    b(bVar.m147a());
                } else if (m144a == 26) {
                    c(bVar.m147a());
                } else if (!a(bVar, m144a)) {
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
                cVar.m186a(1, a());
            }
            if (b()) {
                cVar.m186a(2, b());
            }
            if (m264c()) {
                cVar.m186a(3, c());
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
            if (m264c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f37562a = a2;
            return a2;
        }

        public g b(String str) {
            this.f289b = true;
            this.f37563b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37563b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f289b;
        }

        public g c(String str) {
            this.f290c = true;
            this.f37564c = str;
            return this;
        }

        public String c() {
            return this.f37564c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m264c() {
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
        public int f37565a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f291a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f37566b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37566b < 0) {
                b();
            }
            return this.f37566b;
        }

        public h a(int i2) {
            this.f292a = true;
            this.f37565a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 8) {
                    a(bVar.m153b());
                } else if (m144a == 18) {
                    a(bVar.m147a());
                } else if (!a(bVar, m144a)) {
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
                cVar.m182a(1, c());
            }
            if (b()) {
                cVar.m186a(2, a());
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
            this.f37566b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f293b;
        }

        public int c() {
            return this.f37565a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f294a = com.xiaomi.push.a.f37358a;

        /* renamed from: a  reason: collision with root package name */
        public int f37567a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37567a < 0) {
                b();
            }
            return this.f37567a;
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
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 10) {
                    a(bVar.m146a());
                } else if (!a(bVar, m144a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m184a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f37567a = a2;
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f298a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37569b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f296a = com.xiaomi.push.a.f37358a;

        /* renamed from: a  reason: collision with other field name */
        public b f297a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f37568a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37568a < 0) {
                b();
            }
            return this.f37568a;
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
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 10) {
                    a(bVar.m146a());
                } else if (m144a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m144a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f37569b = true;
                this.f297a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m184a(1, a());
            }
            if (b()) {
                cVar.m185a(2, (com.xiaomi.push.e) a());
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
            this.f37568a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f37569b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f301a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37572c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37573d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37574e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f37576g;

        /* renamed from: a  reason: collision with other field name */
        public String f300a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f303b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f299a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f302b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37575f = false;

        /* renamed from: a  reason: collision with root package name */
        public int f37570a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f37571b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37571b < 0) {
                b();
            }
            return this.f37571b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f299a;
        }

        public k a(int i2) {
            this.f37576g = true;
            this.f37570a = i2;
            return this;
        }

        public k a(long j) {
            this.f37572c = true;
            this.f299a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 10) {
                    a(bVar.m147a());
                } else if (m144a == 18) {
                    b(bVar.m147a());
                } else if (m144a == 24) {
                    a(bVar.m145a());
                } else if (m144a == 32) {
                    b(bVar.m145a());
                } else if (m144a == 40) {
                    a(bVar.m150a());
                } else if (m144a == 48) {
                    a(bVar.m153b());
                } else if (!a(bVar, m144a)) {
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
            this.f37574e = true;
            this.f37575f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f300a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m186a(1, a());
            }
            if (b()) {
                cVar.m186a(2, b());
            }
            if (m265c()) {
                cVar.m183a(3, a());
            }
            if (d()) {
                cVar.m183a(4, b());
            }
            if (f()) {
                cVar.m187a(5, e());
            }
            if (g()) {
                cVar.m182a(6, c());
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
            if (m265c()) {
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
            this.f37571b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f302b;
        }

        public k b(long j) {
            this.f37573d = true;
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
            return this.f37570a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m265c() {
            return this.f37572c;
        }

        public boolean d() {
            return this.f37573d;
        }

        public boolean e() {
            return this.f37575f;
        }

        public boolean f() {
            return this.f37574e;
        }

        public boolean g() {
            return this.f37576g;
        }
    }
}
