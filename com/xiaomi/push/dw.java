package com.xiaomi.push;
/* loaded from: classes10.dex */
public final class dw {

    /* loaded from: classes10.dex */
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
        public long m381a() {
            return this.f242a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public a m382a() {
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
                int m274a = bVar.m274a();
                switch (m274a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m283b());
                        break;
                    case 16:
                        a(bVar.m284b());
                        break;
                    case 26:
                        a(bVar.m277a());
                        break;
                    case 34:
                        b(bVar.m277a());
                        break;
                    case 42:
                        c(bVar.m277a());
                        break;
                    case 50:
                        d(bVar.m277a());
                        break;
                    case 58:
                        e(bVar.m277a());
                        break;
                    case 64:
                        b(bVar.m283b());
                        break;
                    case 72:
                        c(bVar.m283b());
                        break;
                    case 80:
                        d(bVar.m283b());
                        break;
                    case 90:
                        f(bVar.m277a());
                        break;
                    default:
                        if (a(bVar, m274a)) {
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
        public String m383a() {
            return this.f243a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m384a()) {
                cVar.m317a(1, c());
            }
            if (m386b()) {
                cVar.m331b(2, m381a());
            }
            if (m388c()) {
                cVar.m321a(3, m383a());
            }
            if (m390d()) {
                cVar.m321a(4, m385b());
            }
            if (m392e()) {
                cVar.m321a(5, m387c());
            }
            if (m394f()) {
                cVar.m321a(6, m389d());
            }
            if (g()) {
                cVar.m321a(7, m391e());
            }
            if (h()) {
                cVar.m317a(8, d());
            }
            if (i()) {
                cVar.m317a(9, e());
            }
            if (j()) {
                cVar.m317a(10, f());
            }
            if (k()) {
                cVar.m321a(11, m393f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m384a() {
            return this.f244a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m384a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m386b()) {
                a += com.xiaomi.push.c.b(2, m381a());
            }
            if (m388c()) {
                a += com.xiaomi.push.c.a(3, m383a());
            }
            if (m390d()) {
                a += com.xiaomi.push.c.a(4, m385b());
            }
            if (m392e()) {
                a += com.xiaomi.push.c.a(5, m387c());
            }
            if (m394f()) {
                a += com.xiaomi.push.c.a(6, m389d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m391e());
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
                a += com.xiaomi.push.c.a(11, m393f());
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
        public String m385b() {
            return this.f245b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m386b() {
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
        public String m387c() {
            return this.f247c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m388c() {
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
        public String m389d() {
            return this.f249d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m390d() {
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
        public String m391e() {
            return this.f251e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m392e() {
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
        public String m393f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m394f() {
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

    /* loaded from: classes10.dex */
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 8) {
                    a(bVar.m280a());
                } else if (m274a == 24) {
                    a(bVar.m283b());
                } else if (m274a == 32) {
                    b(bVar.m283b());
                } else if (m274a == 40) {
                    c(bVar.m283b());
                } else if (!a(bVar, m274a)) {
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
            if (m396b()) {
                cVar.m322a(1, m395a());
            }
            if (m397c()) {
                cVar.m317a(3, c());
            }
            if (m398d()) {
                cVar.m317a(4, d());
            }
            if (m399e()) {
                cVar.m317a(5, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m395a() {
            return this.f255b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m396b() ? 0 + com.xiaomi.push.c.a(1, m395a()) : 0;
            if (m397c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m398d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m399e()) {
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
        public boolean m396b() {
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
        public boolean m397c() {
            return this.f256c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m398d() {
            return this.f257d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m399e() {
            return this.e;
        }
    }

    /* loaded from: classes10.dex */
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 10) {
                    a(bVar.m277a());
                } else if (m274a == 18) {
                    b(bVar.m277a());
                } else if (m274a == 26) {
                    c(bVar.m277a());
                } else if (m274a == 34) {
                    d(bVar.m277a());
                } else if (m274a == 42) {
                    e(bVar.m277a());
                } else if (m274a == 50) {
                    f(bVar.m277a());
                } else if (!a(bVar, m274a)) {
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
        public String m400a() {
            return this.f258a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m401a()) {
                cVar.m321a(1, m400a());
            }
            if (m403b()) {
                cVar.m321a(2, m402b());
            }
            if (m404c()) {
                cVar.m321a(3, c());
            }
            if (m405d()) {
                cVar.m321a(4, d());
            }
            if (m406e()) {
                cVar.m321a(5, e());
            }
            if (m407f()) {
                cVar.m321a(6, f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m401a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m401a() ? 0 + com.xiaomi.push.c.a(1, m400a()) : 0;
            if (m403b()) {
                a += com.xiaomi.push.c.a(2, m402b());
            }
            if (m404c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m405d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m406e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m407f()) {
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
        public String m402b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m403b() {
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
        public boolean m404c() {
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
        public boolean m405d() {
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
        public boolean m406e() {
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
        public boolean m407f() {
            return this.f264f;
        }
    }

    /* loaded from: classes10.dex */
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 8) {
                    a(bVar.m280a());
                } else if (m274a == 18) {
                    a(bVar.m277a());
                } else if (m274a == 26) {
                    b(bVar.m277a());
                } else if (m274a == 34) {
                    c(bVar.m277a());
                } else if (!a(bVar, m274a)) {
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
        public String m408a() {
            return this.f265a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m411b()) {
                cVar.m322a(1, m409a());
            }
            if (m412c()) {
                cVar.m321a(2, m408a());
            }
            if (d()) {
                cVar.m321a(3, m410b());
            }
            if (e()) {
                cVar.m321a(4, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m409a() {
            return this.f267b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m411b() ? 0 + com.xiaomi.push.c.a(1, m409a()) : 0;
            if (m412c()) {
                a += com.xiaomi.push.c.a(2, m408a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(3, m410b());
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
        public String m410b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m411b() {
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
        public boolean m412c() {
            return this.f268c;
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
        public b m413a() {
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
                int m274a = bVar.m274a();
                switch (m274a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m277a());
                        break;
                    case 26:
                        b(bVar.m277a());
                        break;
                    case 34:
                        c(bVar.m277a());
                        break;
                    case 40:
                        b(bVar.m283b());
                        break;
                    case 50:
                        d(bVar.m277a());
                        break;
                    case 58:
                        e(bVar.m277a());
                        break;
                    case 66:
                        f(bVar.m277a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m283b());
                        break;
                    default:
                        if (a(bVar, m274a)) {
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
        public String m414a() {
            return this.f270a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m415a()) {
                cVar.m330b(1, c());
            }
            if (m417b()) {
                cVar.m321a(2, m414a());
            }
            if (m419c()) {
                cVar.m321a(3, m416b());
            }
            if (m421d()) {
                cVar.m321a(4, m418c());
            }
            if (m423e()) {
                cVar.m317a(5, d());
            }
            if (m424f()) {
                cVar.m321a(6, m420d());
            }
            if (g()) {
                cVar.m321a(7, m422e());
            }
            if (h()) {
                cVar.m321a(8, f());
            }
            if (i()) {
                cVar.m320a(9, (com.xiaomi.push.e) m413a());
            }
            if (j()) {
                cVar.m317a(10, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m415a() {
            return this.f271a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = m415a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m417b()) {
                b += com.xiaomi.push.c.a(2, m414a());
            }
            if (m419c()) {
                b += com.xiaomi.push.c.a(3, m416b());
            }
            if (m421d()) {
                b += com.xiaomi.push.c.a(4, m418c());
            }
            if (m423e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m424f()) {
                b += com.xiaomi.push.c.a(6, m420d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m422e());
            }
            if (h()) {
                b += com.xiaomi.push.c.a(8, f());
            }
            if (i()) {
                b += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m413a());
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
        public String m416b() {
            return this.f272b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m417b() {
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
        public String m418c() {
            return this.f274c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m419c() {
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
        public String m420d() {
            return this.f276d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m421d() {
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
        public String m422e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m423e() {
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
        public boolean m424f() {
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

    /* loaded from: classes10.dex */
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
        public b m425a() {
            return this.f280a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 10) {
                    a(bVar.m277a());
                } else if (m274a == 18) {
                    b(bVar.m277a());
                } else if (m274a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m274a)) {
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
        public String m426a() {
            return this.f281a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m427a()) {
                cVar.m321a(1, m426a());
            }
            if (m429b()) {
                cVar.m321a(2, m428b());
            }
            if (c()) {
                cVar.m320a(3, (com.xiaomi.push.e) m425a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m427a() {
            return this.f282a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m427a() ? 0 + com.xiaomi.push.c.a(1, m426a()) : 0;
            if (m429b()) {
                a += com.xiaomi.push.c.a(2, m428b());
            }
            if (c()) {
                a += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m425a());
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
        public String m428b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m429b() {
            return this.f283b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes10.dex */
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 10) {
                    a(bVar.m277a());
                } else if (m274a == 18) {
                    b(bVar.m277a());
                } else if (m274a == 26) {
                    c(bVar.m277a());
                } else if (!a(bVar, m274a)) {
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
        public String m430a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m431a()) {
                cVar.m321a(1, m430a());
            }
            if (m433b()) {
                cVar.m321a(2, m432b());
            }
            if (m434c()) {
                cVar.m321a(3, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m431a() {
            return this.f285a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m431a() ? 0 + com.xiaomi.push.c.a(1, m430a()) : 0;
            if (m433b()) {
                a += com.xiaomi.push.c.a(2, m432b());
            }
            if (m434c()) {
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
        public String m432b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m433b() {
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
        public boolean m434c() {
            return this.f287c;
        }
    }

    /* loaded from: classes10.dex */
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 8) {
                    a(bVar.m283b());
                } else if (m274a == 18) {
                    a(bVar.m277a());
                } else if (!a(bVar, m274a)) {
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
        public String m435a() {
            return this.f288a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m436a()) {
                cVar.m317a(1, c());
            }
            if (m437b()) {
                cVar.m321a(2, m435a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m436a() {
            return this.f289a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m436a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m437b()) {
                a += com.xiaomi.push.c.a(2, m435a());
            }
            this.b = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m437b() {
            return this.f290b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes10.dex */
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
        public com.xiaomi.push.a m438a() {
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 10) {
                    a(bVar.m276a());
                } else if (!a(bVar, m274a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m439a()) {
                cVar.m319a(1, m438a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m439a() {
            return this.f292a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m439a() ? 0 + com.xiaomi.push.c.a(1, m438a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes10.dex */
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
        public com.xiaomi.push.a m440a() {
            return this.f293a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public b m441a() {
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 10) {
                    a(bVar.m276a());
                } else if (m274a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m274a)) {
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
            if (m442a()) {
                cVar.m319a(1, m440a());
            }
            if (m443b()) {
                cVar.m320a(2, (com.xiaomi.push.e) m441a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m442a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m442a() ? 0 + com.xiaomi.push.c.a(1, m440a()) : 0;
            if (m443b()) {
                a += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m441a());
            }
            this.a = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m443b() {
            return this.b;
        }
    }

    /* loaded from: classes10.dex */
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
        public long m444a() {
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
                int m274a = bVar.m274a();
                if (m274a == 0) {
                    return this;
                }
                if (m274a == 10) {
                    a(bVar.m277a());
                } else if (m274a == 18) {
                    b(bVar.m277a());
                } else if (m274a == 24) {
                    a(bVar.m275a());
                } else if (m274a == 32) {
                    b(bVar.m275a());
                } else if (m274a == 40) {
                    a(bVar.m280a());
                } else if (m274a == 48) {
                    a(bVar.m283b());
                } else if (!a(bVar, m274a)) {
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
        public String m445a() {
            return this.f297a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m446a()) {
                cVar.m321a(1, m445a());
            }
            if (m449b()) {
                cVar.m321a(2, m448b());
            }
            if (m450c()) {
                cVar.m318a(3, m444a());
            }
            if (d()) {
                cVar.m318a(4, m447b());
            }
            if (f()) {
                cVar.m322a(5, e());
            }
            if (g()) {
                cVar.m317a(6, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m446a() {
            return this.f298a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m446a() ? 0 + com.xiaomi.push.c.a(1, m445a()) : 0;
            if (m449b()) {
                a += com.xiaomi.push.c.a(2, m448b());
            }
            if (m450c()) {
                a += com.xiaomi.push.c.a(3, m444a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(4, m447b());
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
        public long m447b() {
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
        public String m448b() {
            return this.f300b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m449b() {
            return this.f301b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m450c() {
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
