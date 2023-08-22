package com.xiaomi.push;
/* loaded from: classes10.dex */
public final class dw {

    /* loaded from: classes10.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f245a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f247b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f249c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f251d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f253e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f254f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public long f243a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f244a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f246b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f248c = "";

        /* renamed from: d  reason: collision with other field name */
        public String f250d = "";

        /* renamed from: e  reason: collision with other field name */
        public String f252e = "";
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
        public long m375a() {
            return this.f243a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public a m376a() {
            this.f254f = false;
            this.f250d = "";
            return this;
        }

        public a a(int i) {
            this.f245a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f247b = true;
            this.f243a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                switch (m268a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m277b());
                        break;
                    case 16:
                        a(bVar.m278b());
                        break;
                    case 26:
                        a(bVar.m271a());
                        break;
                    case 34:
                        b(bVar.m271a());
                        break;
                    case 42:
                        c(bVar.m271a());
                        break;
                    case 50:
                        d(bVar.m271a());
                        break;
                    case 58:
                        e(bVar.m271a());
                        break;
                    case 64:
                        b(bVar.m277b());
                        break;
                    case 72:
                        c(bVar.m277b());
                        break;
                    case 80:
                        d(bVar.m277b());
                        break;
                    case 90:
                        f(bVar.m271a());
                        break;
                    default:
                        if (a(bVar, m268a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f249c = true;
            this.f244a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m377a() {
            return this.f244a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m378a()) {
                cVar.m311a(1, c());
            }
            if (m380b()) {
                cVar.m325b(2, m375a());
            }
            if (m382c()) {
                cVar.m315a(3, m377a());
            }
            if (m384d()) {
                cVar.m315a(4, m379b());
            }
            if (m386e()) {
                cVar.m315a(5, m381c());
            }
            if (m388f()) {
                cVar.m315a(6, m383d());
            }
            if (g()) {
                cVar.m315a(7, m385e());
            }
            if (h()) {
                cVar.m311a(8, d());
            }
            if (i()) {
                cVar.m311a(9, e());
            }
            if (j()) {
                cVar.m311a(10, f());
            }
            if (k()) {
                cVar.m315a(11, m387f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m378a() {
            return this.f245a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m378a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m380b()) {
                a += com.xiaomi.push.c.b(2, m375a());
            }
            if (m382c()) {
                a += com.xiaomi.push.c.a(3, m377a());
            }
            if (m384d()) {
                a += com.xiaomi.push.c.a(4, m379b());
            }
            if (m386e()) {
                a += com.xiaomi.push.c.a(5, m381c());
            }
            if (m388f()) {
                a += com.xiaomi.push.c.a(6, m383d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m385e());
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
                a += com.xiaomi.push.c.a(11, m387f());
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
            this.f251d = true;
            this.f246b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m379b() {
            return this.f246b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m380b() {
            return this.f247b;
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
            this.f253e = true;
            this.f248c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m381c() {
            return this.f248c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m382c() {
            return this.f249c;
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
            this.f254f = true;
            this.f250d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m383d() {
            return this.f250d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m384d() {
            return this.f251d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f252e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m385e() {
            return this.f252e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m386e() {
            return this.f253e;
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
        public String m387f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m388f() {
            return this.f254f;
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

    /* loaded from: classes10.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f255a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f257c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f258d;
        public boolean e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f256b = false;
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
            this.f257c = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 8) {
                    a(bVar.m274a());
                } else if (m268a == 24) {
                    a(bVar.m277b());
                } else if (m268a == 32) {
                    b(bVar.m277b());
                } else if (m268a == 40) {
                    c(bVar.m277b());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f255a = true;
            this.f256b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m390b()) {
                cVar.m316a(1, m389a());
            }
            if (m391c()) {
                cVar.m311a(3, c());
            }
            if (m392d()) {
                cVar.m311a(4, d());
            }
            if (m393e()) {
                cVar.m311a(5, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m389a() {
            return this.f256b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m390b() ? 0 + com.xiaomi.push.c.a(1, m389a()) : 0;
            if (m391c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m392d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m393e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f258d = true;
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m390b() {
            return this.f255a;
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
        public boolean m391c() {
            return this.f257c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m392d() {
            return this.f258d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m393e() {
            return this.e;
        }
    }

    /* loaded from: classes10.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f260a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f261b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f262c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f263d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f264e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f265f;

        /* renamed from: a  reason: collision with other field name */
        public String f259a = "";
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
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 10) {
                    a(bVar.m271a());
                } else if (m268a == 18) {
                    b(bVar.m271a());
                } else if (m268a == 26) {
                    c(bVar.m271a());
                } else if (m268a == 34) {
                    d(bVar.m271a());
                } else if (m268a == 42) {
                    e(bVar.m271a());
                } else if (m268a == 50) {
                    f(bVar.m271a());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.f260a = true;
            this.f259a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m394a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m395a()) {
                cVar.m315a(1, m394a());
            }
            if (m397b()) {
                cVar.m315a(2, m396b());
            }
            if (m398c()) {
                cVar.m315a(3, c());
            }
            if (m399d()) {
                cVar.m315a(4, d());
            }
            if (m400e()) {
                cVar.m315a(5, e());
            }
            if (m401f()) {
                cVar.m315a(6, f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m395a() {
            return this.f260a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m395a() ? 0 + com.xiaomi.push.c.a(1, m394a()) : 0;
            if (m397b()) {
                a += com.xiaomi.push.c.a(2, m396b());
            }
            if (m398c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m399d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m400e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m401f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f261b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m396b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m397b() {
            return this.f261b;
        }

        public c c(String str) {
            this.f262c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m398c() {
            return this.f262c;
        }

        public c d(String str) {
            this.f263d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m399d() {
            return this.f263d;
        }

        public c e(String str) {
            this.f264e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m400e() {
            return this.f264e;
        }

        public c f(String str) {
            this.f265f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m401f() {
            return this.f265f;
        }
    }

    /* loaded from: classes10.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f267a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f269c;
        public boolean d;
        public boolean e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f268b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f266a = "";
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
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 8) {
                    a(bVar.m274a());
                } else if (m268a == 18) {
                    a(bVar.m271a());
                } else if (m268a == 26) {
                    b(bVar.m271a());
                } else if (m268a == 34) {
                    c(bVar.m271a());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f269c = true;
            this.f266a = str;
            return this;
        }

        public d a(boolean z) {
            this.f267a = true;
            this.f268b = z;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m402a() {
            return this.f266a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m405b()) {
                cVar.m316a(1, m403a());
            }
            if (m406c()) {
                cVar.m315a(2, m402a());
            }
            if (d()) {
                cVar.m315a(3, m404b());
            }
            if (e()) {
                cVar.m315a(4, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m403a() {
            return this.f268b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m405b() ? 0 + com.xiaomi.push.c.a(1, m403a()) : 0;
            if (m406c()) {
                a += com.xiaomi.push.c.a(2, m402a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(3, m404b());
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
        public String m404b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m405b() {
            return this.f267a;
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
        public boolean m406c() {
            return this.f269c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes10.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f272a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f274b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f276c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f278d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f279e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f280f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f271a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f273b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f275c = "";
        public int b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f277d = "";
        public String e = "";
        public String f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f270a = null;
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
        public b m407a() {
            return this.f270a;
        }

        public e a(int i) {
            this.f272a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                switch (m268a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m271a());
                        break;
                    case 26:
                        b(bVar.m271a());
                        break;
                    case 34:
                        c(bVar.m271a());
                        break;
                    case 40:
                        b(bVar.m277b());
                        break;
                    case 50:
                        d(bVar.m271a());
                        break;
                    case 58:
                        e(bVar.m271a());
                        break;
                    case 66:
                        f(bVar.m271a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m277b());
                        break;
                    default:
                        if (a(bVar, m268a)) {
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
                this.f270a = bVar;
                return this;
            }
            throw null;
        }

        public e a(String str) {
            this.f274b = true;
            this.f271a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m408a() {
            return this.f271a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m409a()) {
                cVar.m324b(1, c());
            }
            if (m411b()) {
                cVar.m315a(2, m408a());
            }
            if (m413c()) {
                cVar.m315a(3, m410b());
            }
            if (m415d()) {
                cVar.m315a(4, m412c());
            }
            if (m417e()) {
                cVar.m311a(5, d());
            }
            if (m418f()) {
                cVar.m315a(6, m414d());
            }
            if (g()) {
                cVar.m315a(7, m416e());
            }
            if (h()) {
                cVar.m315a(8, f());
            }
            if (i()) {
                cVar.m314a(9, (com.xiaomi.push.e) m407a());
            }
            if (j()) {
                cVar.m311a(10, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m409a() {
            return this.f272a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = m409a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m411b()) {
                b += com.xiaomi.push.c.a(2, m408a());
            }
            if (m413c()) {
                b += com.xiaomi.push.c.a(3, m410b());
            }
            if (m415d()) {
                b += com.xiaomi.push.c.a(4, m412c());
            }
            if (m417e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m418f()) {
                b += com.xiaomi.push.c.a(6, m414d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m416e());
            }
            if (h()) {
                b += com.xiaomi.push.c.a(8, f());
            }
            if (i()) {
                b += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m407a());
            }
            if (j()) {
                b += com.xiaomi.push.c.a(10, e());
            }
            this.d = b;
            return b;
        }

        public e b(int i) {
            this.f279e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f276c = true;
            this.f273b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m410b() {
            return this.f273b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m411b() {
            return this.f274b;
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
            this.f278d = true;
            this.f275c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m412c() {
            return this.f275c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m413c() {
            return this.f276c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f280f = true;
            this.f277d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m414d() {
            return this.f277d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m415d() {
            return this.f278d;
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
        public String m416e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m417e() {
            return this.f279e;
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
        public boolean m418f() {
            return this.f280f;
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

    /* loaded from: classes10.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f283a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f284b;
        public boolean c;

        /* renamed from: a  reason: collision with other field name */
        public String f282a = "";
        public String b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f281a = null;
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
        public b m419a() {
            return this.f281a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 10) {
                    a(bVar.m271a());
                } else if (m268a == 18) {
                    b(bVar.m271a());
                } else if (m268a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.c = true;
                this.f281a = bVar;
                return this;
            }
            throw null;
        }

        public f a(String str) {
            this.f283a = true;
            this.f282a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m420a() {
            return this.f282a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m421a()) {
                cVar.m315a(1, m420a());
            }
            if (m423b()) {
                cVar.m315a(2, m422b());
            }
            if (c()) {
                cVar.m314a(3, (com.xiaomi.push.e) m419a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m421a() {
            return this.f283a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m421a() ? 0 + com.xiaomi.push.c.a(1, m420a()) : 0;
            if (m423b()) {
                a += com.xiaomi.push.c.a(2, m422b());
            }
            if (c()) {
                a += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m419a());
            }
            this.a = a;
            return a;
        }

        public f b(String str) {
            this.f284b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m422b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m423b() {
            return this.f284b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes10.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f286a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f287b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f288c;

        /* renamed from: a  reason: collision with other field name */
        public String f285a = "";
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
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 10) {
                    a(bVar.m271a());
                } else if (m268a == 18) {
                    b(bVar.m271a());
                } else if (m268a == 26) {
                    c(bVar.m271a());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.f286a = true;
            this.f285a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m424a() {
            return this.f285a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m425a()) {
                cVar.m315a(1, m424a());
            }
            if (m427b()) {
                cVar.m315a(2, m426b());
            }
            if (m428c()) {
                cVar.m315a(3, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m425a() {
            return this.f286a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m425a() ? 0 + com.xiaomi.push.c.a(1, m424a()) : 0;
            if (m427b()) {
                a += com.xiaomi.push.c.a(2, m426b());
            }
            if (m428c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
            this.f287b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m426b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m427b() {
            return this.f287b;
        }

        public g c(String str) {
            this.f288c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m428c() {
            return this.f288c;
        }
    }

    /* loaded from: classes10.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f290a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f291b;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f289a = "";
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
            this.f290a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 8) {
                    a(bVar.m277b());
                } else if (m268a == 18) {
                    a(bVar.m271a());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f291b = true;
            this.f289a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m429a() {
            return this.f289a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m430a()) {
                cVar.m311a(1, c());
            }
            if (m431b()) {
                cVar.m315a(2, m429a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m430a() {
            return this.f290a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m430a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m431b()) {
                a += com.xiaomi.push.c.a(2, m429a());
            }
            this.b = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m431b() {
            return this.f291b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes10.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f293a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f292a = com.xiaomi.push.a.a;
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
        public com.xiaomi.push.a m432a() {
            return this.f292a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f293a = true;
            this.f292a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 10) {
                    a(bVar.m270a());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m433a()) {
                cVar.m313a(1, m432a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m433a() {
            return this.f293a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m433a() ? 0 + com.xiaomi.push.c.a(1, m432a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes10.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f296a;
        public boolean b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f294a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        public b f295a = null;
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
        public com.xiaomi.push.a m434a() {
            return this.f294a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public b m435a() {
            return this.f295a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f296a = true;
            this.f294a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 10) {
                    a(bVar.m270a());
                } else if (m268a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.b = true;
                this.f295a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m436a()) {
                cVar.m313a(1, m434a());
            }
            if (m437b()) {
                cVar.m314a(2, (com.xiaomi.push.e) m435a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m436a() {
            return this.f296a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m436a() ? 0 + com.xiaomi.push.c.a(1, m434a()) : 0;
            if (m437b()) {
                a += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m435a());
            }
            this.a = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m437b() {
            return this.b;
        }
    }

    /* loaded from: classes10.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f299a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f302b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean g;

        /* renamed from: a  reason: collision with other field name */
        public String f298a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f301b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f297a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f300b = 0;
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
        public long m438a() {
            return this.f297a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f297a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 10) {
                    a(bVar.m271a());
                } else if (m268a == 18) {
                    b(bVar.m271a());
                } else if (m268a == 24) {
                    a(bVar.m269a());
                } else if (m268a == 32) {
                    b(bVar.m269a());
                } else if (m268a == 40) {
                    a(bVar.m274a());
                } else if (m268a == 48) {
                    a(bVar.m277b());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.f299a = true;
            this.f298a = str;
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
        public String m439a() {
            return this.f298a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m440a()) {
                cVar.m315a(1, m439a());
            }
            if (m443b()) {
                cVar.m315a(2, m442b());
            }
            if (m444c()) {
                cVar.m312a(3, m438a());
            }
            if (d()) {
                cVar.m312a(4, m441b());
            }
            if (f()) {
                cVar.m316a(5, e());
            }
            if (g()) {
                cVar.m311a(6, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m440a() {
            return this.f299a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m440a() ? 0 + com.xiaomi.push.c.a(1, m439a()) : 0;
            if (m443b()) {
                a += com.xiaomi.push.c.a(2, m442b());
            }
            if (m444c()) {
                a += com.xiaomi.push.c.a(3, m438a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(4, m441b());
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
        public long m441b() {
            return this.f300b;
        }

        public k b(long j) {
            this.d = true;
            this.f300b = j;
            return this;
        }

        public k b(String str) {
            this.f302b = true;
            this.f301b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m442b() {
            return this.f301b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m443b() {
            return this.f302b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m444c() {
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
