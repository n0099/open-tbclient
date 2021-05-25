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
        public boolean f37460g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37461h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f37462i;
        public boolean j;
        public boolean k;

        /* renamed from: a  reason: collision with root package name */
        public int f37454a = 0;

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
        public int f37455b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f37456c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f37457d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f37459f = "";

        /* renamed from: e  reason: collision with root package name */
        public int f37458e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37458e < 0) {
                b();
            }
            return this.f37458e;
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
            this.f37454a = i2;
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
            this.f37458e = a2;
            return a2;
        }

        public a b(int i2) {
            this.f37461h = true;
            this.f37455b = i2;
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
            return this.f37454a;
        }

        public a c(int i2) {
            this.f37462i = true;
            this.f37456c = i2;
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
            return this.f37455b;
        }

        public a d(int i2) {
            this.j = true;
            this.f37457d = i2;
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
            return this.f37456c;
        }

        public a e(String str) {
            this.f37460g = true;
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
            return this.f37457d;
        }

        public a f(String str) {
            this.k = true;
            this.f37459f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m247f() {
            return this.f37459f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m248f() {
            return this.f256f;
        }

        public boolean g() {
            return this.f37460g;
        }

        public boolean h() {
            return this.f37461h;
        }

        public boolean i() {
            return this.f37462i;
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
        public boolean f37467e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f258b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f37463a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f37464b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f37465c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f37466d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37466d < 0) {
                b();
            }
            return this.f37466d;
        }

        public b a(int i2) {
            this.f259c = true;
            this.f37463a = i2;
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
            this.f37466d = a2;
            return a2;
        }

        public b b(int i2) {
            this.f260d = true;
            this.f37464b = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f257a;
        }

        public int c() {
            return this.f37463a;
        }

        public b c(int i2) {
            this.f37467e = true;
            this.f37465c = i2;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m249c() {
            return this.f259c;
        }

        public int d() {
            return this.f37464b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m250d() {
            return this.f260d;
        }

        public int e() {
            return this.f37465c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m251e() {
            return this.f37467e;
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
        public String f37469b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f37470c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f37471d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f37472e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f37473f = "";

        /* renamed from: a  reason: collision with root package name */
        public int f37468a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37468a < 0) {
                b();
            }
            return this.f37468a;
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
            this.f37468a = a2;
            return a2;
        }

        public c b(String str) {
            this.f263b = true;
            this.f37469b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37469b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f263b;
        }

        public c c(String str) {
            this.f264c = true;
            this.f37470c = str;
            return this;
        }

        public String c() {
            return this.f37470c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m252c() {
            return this.f264c;
        }

        public c d(String str) {
            this.f265d = true;
            this.f37471d = str;
            return this;
        }

        public String d() {
            return this.f37471d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m253d() {
            return this.f265d;
        }

        public c e(String str) {
            this.f266e = true;
            this.f37472e = str;
            return this;
        }

        public String e() {
            return this.f37472e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m254e() {
            return this.f266e;
        }

        public c f(String str) {
            this.f267f = true;
            this.f37473f = str;
            return this;
        }

        public String f() {
            return this.f37473f;
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
        public boolean f37477d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37478e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f270b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f268a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f37475b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f37476c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f37474a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37474a < 0) {
                b();
            }
            return this.f37474a;
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
            this.f37474a = a2;
            return a2;
        }

        public d b(String str) {
            this.f37477d = true;
            this.f37475b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37475b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f269a;
        }

        public d c(String str) {
            this.f37478e = true;
            this.f37476c = str;
            return this;
        }

        public String c() {
            return this.f37476c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m256c() {
            return this.f271c;
        }

        public boolean d() {
            return this.f37477d;
        }

        public boolean e() {
            return this.f37478e;
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
        public boolean f37485g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37486h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f37487i;
        public boolean j;

        /* renamed from: a  reason: collision with root package name */
        public int f37479a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f273a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f275b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f277c = "";

        /* renamed from: b  reason: collision with root package name */
        public int f37480b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f279d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f37483e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f37484f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f272a = null;

        /* renamed from: c  reason: collision with root package name */
        public int f37481c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f37482d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37482d < 0) {
                b();
            }
            return this.f37482d;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f272a;
        }

        public e a(int i2) {
            this.f274a = true;
            this.f37479a = i2;
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
                this.f37487i = true;
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
            this.f37482d = b2;
            return b2;
        }

        public e b(int i2) {
            this.f281e = true;
            this.f37480b = i2;
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
            return this.f37479a;
        }

        public e c(int i2) {
            this.j = true;
            this.f37481c = i2;
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
            return this.f37480b;
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
            return this.f37481c;
        }

        public e e(String str) {
            this.f37485g = true;
            this.f37483e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m261e() {
            return this.f37483e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m262e() {
            return this.f281e;
        }

        public e f(String str) {
            this.f37486h = true;
            this.f37484f = str;
            return this;
        }

        public String f() {
            return this.f37484f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m263f() {
            return this.f282f;
        }

        public boolean g() {
            return this.f37485g;
        }

        public boolean h() {
            return this.f37486h;
        }

        public boolean i() {
            return this.f37487i;
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
        public boolean f37490c;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f37489b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f283a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f37488a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37488a < 0) {
                b();
            }
            return this.f37488a;
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
                this.f37490c = true;
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
            this.f37488a = a2;
            return a2;
        }

        public f b(String str) {
            this.f286b = true;
            this.f37489b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37489b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f286b;
        }

        public boolean c() {
            return this.f37490c;
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
        public String f37492b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f37493c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f37491a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37491a < 0) {
                b();
            }
            return this.f37491a;
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
            this.f37491a = a2;
            return a2;
        }

        public g b(String str) {
            this.f289b = true;
            this.f37492b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f37492b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f289b;
        }

        public g c(String str) {
            this.f290c = true;
            this.f37493c = str;
            return this;
        }

        public String c() {
            return this.f37493c;
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
        public int f37494a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f291a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f37495b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37495b < 0) {
                b();
            }
            return this.f37495b;
        }

        public h a(int i2) {
            this.f292a = true;
            this.f37494a = i2;
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
            this.f37495b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f293b;
        }

        public int c() {
            return this.f37494a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f294a = com.xiaomi.push.a.f37287a;

        /* renamed from: a  reason: collision with root package name */
        public int f37496a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37496a < 0) {
                b();
            }
            return this.f37496a;
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
            this.f37496a = a2;
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f298a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37498b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f296a = com.xiaomi.push.a.f37287a;

        /* renamed from: a  reason: collision with other field name */
        public b f297a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f37497a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37497a < 0) {
                b();
            }
            return this.f37497a;
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
                this.f37498b = true;
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
            this.f37497a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f37498b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f301a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37501c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37502d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37503e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f37505g;

        /* renamed from: a  reason: collision with other field name */
        public String f300a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f303b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f299a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f302b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37504f = false;

        /* renamed from: a  reason: collision with root package name */
        public int f37499a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f37500b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37500b < 0) {
                b();
            }
            return this.f37500b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f299a;
        }

        public k a(int i2) {
            this.f37505g = true;
            this.f37499a = i2;
            return this;
        }

        public k a(long j) {
            this.f37501c = true;
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
            this.f37503e = true;
            this.f37504f = z;
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
            this.f37500b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f302b;
        }

        public k b(long j) {
            this.f37502d = true;
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
            return this.f37499a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m265c() {
            return this.f37501c;
        }

        public boolean d() {
            return this.f37502d;
        }

        public boolean e() {
            return this.f37504f;
        }

        public boolean f() {
            return this.f37503e;
        }

        public boolean g() {
            return this.f37505g;
        }
    }
}
