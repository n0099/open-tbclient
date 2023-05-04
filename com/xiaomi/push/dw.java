package com.xiaomi.push;
/* loaded from: classes9.dex */
public final class dw {

    /* loaded from: classes9.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f244a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f246b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f248c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f250d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f252e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f253f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public long f242a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f243a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f245b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f247c = "";

        /* renamed from: d  reason: collision with other field name */
        public String f249d = "";

        /* renamed from: e  reason: collision with other field name */
        public String f251e = "";
        public int b = 1;
        public int c = 0;
        public int d = 0;
        public String f = "";
        public int e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public long m296a() {
            return this.f242a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public a m297a() {
            this.f253f = false;
            this.f249d = "";
            return this;
        }

        public a a(int i) {
            this.f244a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f246b = true;
            this.f242a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                switch (m189a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m198b());
                        break;
                    case 16:
                        a(bVar.m199b());
                        break;
                    case 26:
                        a(bVar.m192a());
                        break;
                    case 34:
                        b(bVar.m192a());
                        break;
                    case 42:
                        c(bVar.m192a());
                        break;
                    case 50:
                        d(bVar.m192a());
                        break;
                    case 58:
                        e(bVar.m192a());
                        break;
                    case 64:
                        b(bVar.m198b());
                        break;
                    case 72:
                        c(bVar.m198b());
                        break;
                    case 80:
                        d(bVar.m198b());
                        break;
                    case 90:
                        f(bVar.m192a());
                        break;
                    default:
                        if (a(bVar, m189a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f248c = true;
            this.f243a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m298a() {
            return this.f243a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m299a()) {
                cVar.m232a(1, c());
            }
            if (m301b()) {
                cVar.m246b(2, m296a());
            }
            if (m303c()) {
                cVar.m236a(3, m298a());
            }
            if (m305d()) {
                cVar.m236a(4, m300b());
            }
            if (m307e()) {
                cVar.m236a(5, m302c());
            }
            if (m309f()) {
                cVar.m236a(6, m304d());
            }
            if (g()) {
                cVar.m236a(7, m306e());
            }
            if (h()) {
                cVar.m232a(8, d());
            }
            if (i()) {
                cVar.m232a(9, e());
            }
            if (j()) {
                cVar.m232a(10, f());
            }
            if (k()) {
                cVar.m236a(11, m308f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m299a() {
            return this.f244a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m299a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m301b()) {
                a += com.xiaomi.push.c.b(2, m296a());
            }
            if (m303c()) {
                a += com.xiaomi.push.c.a(3, m298a());
            }
            if (m305d()) {
                a += com.xiaomi.push.c.a(4, m300b());
            }
            if (m307e()) {
                a += com.xiaomi.push.c.a(5, m302c());
            }
            if (m309f()) {
                a += com.xiaomi.push.c.a(6, m304d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m306e());
            }
            if (h()) {
                a += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                a += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                a += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                a += com.xiaomi.push.c.a(11, m308f());
            }
            this.e = a;
            return a;
        }

        public a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public a b(String str) {
            this.f250d = true;
            this.f245b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m300b() {
            return this.f245b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m301b() {
            return this.f246b;
        }

        public int c() {
            return this.a;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a c(String str) {
            this.f252e = true;
            this.f247c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m302c() {
            return this.f247c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m303c() {
            return this.f248c;
        }

        public int d() {
            return this.b;
        }

        public a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        public a d(String str) {
            this.f253f = true;
            this.f249d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m304d() {
            return this.f249d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m305d() {
            return this.f250d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f251e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m306e() {
            return this.f251e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m307e() {
            return this.f252e;
        }

        public int f() {
            return this.d;
        }

        public a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m308f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m309f() {
            return this.f253f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
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

    /* loaded from: classes9.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f254a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f256c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f257d;
        public boolean e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f255b = false;
        public int a = 0;
        public int b = 0;
        public int c = 0;
        public int d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        public b a(int i) {
            this.f256c = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 8) {
                    a(bVar.m195a());
                } else if (m189a == 24) {
                    a(bVar.m198b());
                } else if (m189a == 32) {
                    b(bVar.m198b());
                } else if (m189a == 40) {
                    c(bVar.m198b());
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f254a = true;
            this.f255b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m311b()) {
                cVar.m237a(1, m310a());
            }
            if (m312c()) {
                cVar.m232a(3, c());
            }
            if (m313d()) {
                cVar.m232a(4, d());
            }
            if (m314e()) {
                cVar.m232a(5, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m310a() {
            return this.f255b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m311b() ? 0 + com.xiaomi.push.c.a(1, m310a()) : 0;
            if (m312c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m313d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m314e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f257d = true;
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m311b() {
            return this.f254a;
        }

        public int c() {
            return this.a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m312c() {
            return this.f256c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m313d() {
            return this.f257d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m314e() {
            return this.e;
        }
    }

    /* loaded from: classes9.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f259a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f260b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f261c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f262d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f263e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f264f;

        /* renamed from: a  reason: collision with other field name */
        public String f258a = "";
        public String b = "";
        public String c = "";
        public String d = "";
        public String e = "";
        public String f = "";
        public int a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 10) {
                    a(bVar.m192a());
                } else if (m189a == 18) {
                    b(bVar.m192a());
                } else if (m189a == 26) {
                    c(bVar.m192a());
                } else if (m189a == 34) {
                    d(bVar.m192a());
                } else if (m189a == 42) {
                    e(bVar.m192a());
                } else if (m189a == 50) {
                    f(bVar.m192a());
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.f259a = true;
            this.f258a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m315a() {
            return this.f258a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m316a()) {
                cVar.m236a(1, m315a());
            }
            if (m318b()) {
                cVar.m236a(2, m317b());
            }
            if (m319c()) {
                cVar.m236a(3, c());
            }
            if (m320d()) {
                cVar.m236a(4, d());
            }
            if (m321e()) {
                cVar.m236a(5, e());
            }
            if (m322f()) {
                cVar.m236a(6, f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m316a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m316a() ? 0 + com.xiaomi.push.c.a(1, m315a()) : 0;
            if (m318b()) {
                a += com.xiaomi.push.c.a(2, m317b());
            }
            if (m319c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m320d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m321e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m322f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f260b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m317b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m318b() {
            return this.f260b;
        }

        public c c(String str) {
            this.f261c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m319c() {
            return this.f261c;
        }

        public c d(String str) {
            this.f262d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m320d() {
            return this.f262d;
        }

        public c e(String str) {
            this.f263e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m321e() {
            return this.f263e;
        }

        public c f(String str) {
            this.f264f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m322f() {
            return this.f264f;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f266a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f268c;
        public boolean d;
        public boolean e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f267b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f265a = "";
        public String b = "";
        public String c = "";
        public int a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 8) {
                    a(bVar.m195a());
                } else if (m189a == 18) {
                    a(bVar.m192a());
                } else if (m189a == 26) {
                    b(bVar.m192a());
                } else if (m189a == 34) {
                    c(bVar.m192a());
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f268c = true;
            this.f265a = str;
            return this;
        }

        public d a(boolean z) {
            this.f266a = true;
            this.f267b = z;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m323a() {
            return this.f265a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m326b()) {
                cVar.m237a(1, m324a());
            }
            if (m327c()) {
                cVar.m236a(2, m323a());
            }
            if (d()) {
                cVar.m236a(3, m325b());
            }
            if (e()) {
                cVar.m236a(4, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m324a() {
            return this.f267b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m326b() ? 0 + com.xiaomi.push.c.a(1, m324a()) : 0;
            if (m327c()) {
                a += com.xiaomi.push.c.a(2, m323a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(3, m325b());
            }
            if (e()) {
                a += com.xiaomi.push.c.a(4, c());
            }
            this.a = a;
            return a;
        }

        public d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m325b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m326b() {
            return this.f266a;
        }

        public d c(String str) {
            this.e = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m327c() {
            return this.f268c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f271a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f273b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f275c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f277d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f278e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f279f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f270a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f272b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f274c = "";
        public int b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f276d = "";
        public String e = "";
        public String f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f269a = null;
        public int c = 0;
        public int d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public b m328a() {
            return this.f269a;
        }

        public e a(int i) {
            this.f271a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                switch (m189a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m192a());
                        break;
                    case 26:
                        b(bVar.m192a());
                        break;
                    case 34:
                        c(bVar.m192a());
                        break;
                    case 40:
                        b(bVar.m198b());
                        break;
                    case 50:
                        d(bVar.m192a());
                        break;
                    case 58:
                        e(bVar.m192a());
                        break;
                    case 66:
                        f(bVar.m192a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m198b());
                        break;
                    default:
                        if (a(bVar, m189a)) {
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
                this.f269a = bVar;
                return this;
            }
            throw null;
        }

        public e a(String str) {
            this.f273b = true;
            this.f270a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m329a() {
            return this.f270a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m330a()) {
                cVar.m245b(1, c());
            }
            if (m332b()) {
                cVar.m236a(2, m329a());
            }
            if (m334c()) {
                cVar.m236a(3, m331b());
            }
            if (m336d()) {
                cVar.m236a(4, m333c());
            }
            if (m338e()) {
                cVar.m232a(5, d());
            }
            if (m339f()) {
                cVar.m236a(6, m335d());
            }
            if (g()) {
                cVar.m236a(7, m337e());
            }
            if (h()) {
                cVar.m236a(8, f());
            }
            if (i()) {
                cVar.m235a(9, (com.xiaomi.push.e) m328a());
            }
            if (j()) {
                cVar.m232a(10, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m330a() {
            return this.f271a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = m330a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m332b()) {
                b += com.xiaomi.push.c.a(2, m329a());
            }
            if (m334c()) {
                b += com.xiaomi.push.c.a(3, m331b());
            }
            if (m336d()) {
                b += com.xiaomi.push.c.a(4, m333c());
            }
            if (m338e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m339f()) {
                b += com.xiaomi.push.c.a(6, m335d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m337e());
            }
            if (h()) {
                b += com.xiaomi.push.c.a(8, f());
            }
            if (i()) {
                b += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m328a());
            }
            if (j()) {
                b += com.xiaomi.push.c.a(10, e());
            }
            this.d = b;
            return b;
        }

        public e b(int i) {
            this.f278e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f275c = true;
            this.f272b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m331b() {
            return this.f272b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m332b() {
            return this.f273b;
        }

        public int c() {
            return this.a;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e c(String str) {
            this.f277d = true;
            this.f274c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m333c() {
            return this.f274c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m334c() {
            return this.f275c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f279f = true;
            this.f276d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m335d() {
            return this.f276d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m336d() {
            return this.f277d;
        }

        public int e() {
            return this.c;
        }

        public e e(String str) {
            this.g = true;
            this.e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m337e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m338e() {
            return this.f278e;
        }

        public e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m339f() {
            return this.f279f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }
    }

    /* loaded from: classes9.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f282a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f283b;
        public boolean c;

        /* renamed from: a  reason: collision with other field name */
        public String f281a = "";
        public String b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f280a = null;
        public int a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public b m340a() {
            return this.f280a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 10) {
                    a(bVar.m192a());
                } else if (m189a == 18) {
                    b(bVar.m192a());
                } else if (m189a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.c = true;
                this.f280a = bVar;
                return this;
            }
            throw null;
        }

        public f a(String str) {
            this.f282a = true;
            this.f281a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m341a() {
            return this.f281a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m342a()) {
                cVar.m236a(1, m341a());
            }
            if (m344b()) {
                cVar.m236a(2, m343b());
            }
            if (c()) {
                cVar.m235a(3, (com.xiaomi.push.e) m340a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m342a() {
            return this.f282a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m342a() ? 0 + com.xiaomi.push.c.a(1, m341a()) : 0;
            if (m344b()) {
                a += com.xiaomi.push.c.a(2, m343b());
            }
            if (c()) {
                a += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m340a());
            }
            this.a = a;
            return a;
        }

        public f b(String str) {
            this.f283b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m343b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m344b() {
            return this.f283b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes9.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f285a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f286b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f287c;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";
        public String b = "";
        public String c = "";
        public int a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 10) {
                    a(bVar.m192a());
                } else if (m189a == 18) {
                    b(bVar.m192a());
                } else if (m189a == 26) {
                    c(bVar.m192a());
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.f285a = true;
            this.f284a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m345a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m346a()) {
                cVar.m236a(1, m345a());
            }
            if (m348b()) {
                cVar.m236a(2, m347b());
            }
            if (m349c()) {
                cVar.m236a(3, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m346a() {
            return this.f285a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m346a() ? 0 + com.xiaomi.push.c.a(1, m345a()) : 0;
            if (m348b()) {
                a += com.xiaomi.push.c.a(2, m347b());
            }
            if (m349c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
            this.f286b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m347b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m348b() {
            return this.f286b;
        }

        public g c(String str) {
            this.f287c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m349c() {
            return this.f287c;
        }
    }

    /* loaded from: classes9.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f289a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f290b;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f288a = "";
        public int b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        public h a(int i) {
            this.f289a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 8) {
                    a(bVar.m198b());
                } else if (m189a == 18) {
                    a(bVar.m192a());
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f290b = true;
            this.f288a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m350a() {
            return this.f288a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m351a()) {
                cVar.m232a(1, c());
            }
            if (m352b()) {
                cVar.m236a(2, m350a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m351a() {
            return this.f289a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m351a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m352b()) {
                a += com.xiaomi.push.c.a(2, m350a());
            }
            this.b = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m352b() {
            return this.f290b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes9.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f292a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f291a = com.xiaomi.push.a.a;
        public int a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public com.xiaomi.push.a m353a() {
            return this.f291a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f292a = true;
            this.f291a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 10) {
                    a(bVar.m191a());
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m354a()) {
                cVar.m234a(1, m353a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m354a() {
            return this.f292a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m354a() ? 0 + com.xiaomi.push.c.a(1, m353a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes9.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;
        public boolean b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f293a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        public b f294a = null;
        public int a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public com.xiaomi.push.a m355a() {
            return this.f293a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public b m356a() {
            return this.f294a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f295a = true;
            this.f293a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 10) {
                    a(bVar.m191a());
                } else if (m189a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.b = true;
                this.f294a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m357a()) {
                cVar.m234a(1, m355a());
            }
            if (m358b()) {
                cVar.m235a(2, (com.xiaomi.push.e) m356a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m357a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m357a() ? 0 + com.xiaomi.push.c.a(1, m355a()) : 0;
            if (m358b()) {
                a += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m356a());
            }
            this.a = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m358b() {
            return this.b;
        }
    }

    /* loaded from: classes9.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f298a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f301b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean g;

        /* renamed from: a  reason: collision with other field name */
        public String f297a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f300b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f296a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f299b = 0;
        public boolean f = false;
        public int a = 0;
        public int b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public long m359a() {
            return this.f296a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f296a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m189a = bVar.m189a();
                if (m189a == 0) {
                    return this;
                }
                if (m189a == 10) {
                    a(bVar.m192a());
                } else if (m189a == 18) {
                    b(bVar.m192a());
                } else if (m189a == 24) {
                    a(bVar.m190a());
                } else if (m189a == 32) {
                    b(bVar.m190a());
                } else if (m189a == 40) {
                    a(bVar.m195a());
                } else if (m189a == 48) {
                    a(bVar.m198b());
                } else if (!a(bVar, m189a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.f298a = true;
            this.f297a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m360a() {
            return this.f297a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m361a()) {
                cVar.m236a(1, m360a());
            }
            if (m364b()) {
                cVar.m236a(2, m363b());
            }
            if (m365c()) {
                cVar.m233a(3, m359a());
            }
            if (d()) {
                cVar.m233a(4, m362b());
            }
            if (f()) {
                cVar.m237a(5, e());
            }
            if (g()) {
                cVar.m232a(6, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m361a() {
            return this.f298a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m361a() ? 0 + com.xiaomi.push.c.a(1, m360a()) : 0;
            if (m364b()) {
                a += com.xiaomi.push.c.a(2, m363b());
            }
            if (m365c()) {
                a += com.xiaomi.push.c.a(3, m359a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(4, m362b());
            }
            if (f()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(6, c());
            }
            this.b = a;
            return a;
        }

        /* renamed from: b  reason: collision with other method in class */
        public long m362b() {
            return this.f299b;
        }

        public k b(long j) {
            this.d = true;
            this.f299b = j;
            return this;
        }

        public k b(String str) {
            this.f301b = true;
            this.f300b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m363b() {
            return this.f300b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m364b() {
            return this.f301b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m365c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.g;
        }
    }
}
