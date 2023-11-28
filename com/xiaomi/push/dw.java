package com.xiaomi.push;
/* loaded from: classes10.dex */
public final class dw {

    /* loaded from: classes10.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f240a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f242b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f244c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f246d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f248e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f249f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public long f238a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f239a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f241b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f243c = "";

        /* renamed from: d  reason: collision with other field name */
        public String f245d = "";

        /* renamed from: e  reason: collision with other field name */
        public String f247e = "";
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
        public long m385a() {
            return this.f238a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public a m386a() {
            this.f249f = false;
            this.f245d = "";
            return this;
        }

        public a a(int i) {
            this.f240a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f242b = true;
            this.f238a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                switch (m278a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m287b());
                        break;
                    case 16:
                        a(bVar.m288b());
                        break;
                    case 26:
                        a(bVar.m281a());
                        break;
                    case 34:
                        b(bVar.m281a());
                        break;
                    case 42:
                        c(bVar.m281a());
                        break;
                    case 50:
                        d(bVar.m281a());
                        break;
                    case 58:
                        e(bVar.m281a());
                        break;
                    case 64:
                        b(bVar.m287b());
                        break;
                    case 72:
                        c(bVar.m287b());
                        break;
                    case 80:
                        d(bVar.m287b());
                        break;
                    case 90:
                        f(bVar.m281a());
                        break;
                    default:
                        if (a(bVar, m278a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f244c = true;
            this.f239a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m387a() {
            return this.f239a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m388a()) {
                cVar.m321a(1, c());
            }
            if (m390b()) {
                cVar.m335b(2, m385a());
            }
            if (m392c()) {
                cVar.m325a(3, m387a());
            }
            if (m394d()) {
                cVar.m325a(4, m389b());
            }
            if (m396e()) {
                cVar.m325a(5, m391c());
            }
            if (m398f()) {
                cVar.m325a(6, m393d());
            }
            if (g()) {
                cVar.m325a(7, m395e());
            }
            if (h()) {
                cVar.m321a(8, d());
            }
            if (i()) {
                cVar.m321a(9, e());
            }
            if (j()) {
                cVar.m321a(10, f());
            }
            if (k()) {
                cVar.m325a(11, m397f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m388a() {
            return this.f240a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m388a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m390b()) {
                a += com.xiaomi.push.c.b(2, m385a());
            }
            if (m392c()) {
                a += com.xiaomi.push.c.a(3, m387a());
            }
            if (m394d()) {
                a += com.xiaomi.push.c.a(4, m389b());
            }
            if (m396e()) {
                a += com.xiaomi.push.c.a(5, m391c());
            }
            if (m398f()) {
                a += com.xiaomi.push.c.a(6, m393d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m395e());
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
                a += com.xiaomi.push.c.a(11, m397f());
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
            this.f246d = true;
            this.f241b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m389b() {
            return this.f241b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m390b() {
            return this.f242b;
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
            this.f248e = true;
            this.f243c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m391c() {
            return this.f243c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m392c() {
            return this.f244c;
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
            this.f249f = true;
            this.f245d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m393d() {
            return this.f245d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m394d() {
            return this.f246d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f247e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m395e() {
            return this.f247e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m396e() {
            return this.f248e;
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
        public String m397f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m398f() {
            return this.f249f;
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
        public boolean f250a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f252c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f253d;
        public boolean e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f251b = false;
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
            this.f252c = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 8) {
                    a(bVar.m284a());
                } else if (m278a == 24) {
                    a(bVar.m287b());
                } else if (m278a == 32) {
                    b(bVar.m287b());
                } else if (m278a == 40) {
                    c(bVar.m287b());
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.f250a = true;
            this.f251b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m400b()) {
                cVar.m326a(1, m399a());
            }
            if (m401c()) {
                cVar.m321a(3, c());
            }
            if (m402d()) {
                cVar.m321a(4, d());
            }
            if (m403e()) {
                cVar.m321a(5, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m399a() {
            return this.f251b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m400b() ? 0 + com.xiaomi.push.c.a(1, m399a()) : 0;
            if (m401c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m402d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m403e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f253d = true;
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m400b() {
            return this.f250a;
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
        public boolean m401c() {
            return this.f252c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m402d() {
            return this.f253d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m403e() {
            return this.e;
        }
    }

    /* loaded from: classes10.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f255a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f256b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f257c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f258d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f259e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f260f;

        /* renamed from: a  reason: collision with other field name */
        public String f254a = "";
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
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 10) {
                    a(bVar.m281a());
                } else if (m278a == 18) {
                    b(bVar.m281a());
                } else if (m278a == 26) {
                    c(bVar.m281a());
                } else if (m278a == 34) {
                    d(bVar.m281a());
                } else if (m278a == 42) {
                    e(bVar.m281a());
                } else if (m278a == 50) {
                    f(bVar.m281a());
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.f255a = true;
            this.f254a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m404a() {
            return this.f254a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m405a()) {
                cVar.m325a(1, m404a());
            }
            if (m407b()) {
                cVar.m325a(2, m406b());
            }
            if (m408c()) {
                cVar.m325a(3, c());
            }
            if (m409d()) {
                cVar.m325a(4, d());
            }
            if (m410e()) {
                cVar.m325a(5, e());
            }
            if (m411f()) {
                cVar.m325a(6, f());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m405a() {
            return this.f255a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m405a() ? 0 + com.xiaomi.push.c.a(1, m404a()) : 0;
            if (m407b()) {
                a += com.xiaomi.push.c.a(2, m406b());
            }
            if (m408c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m409d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m410e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m411f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f256b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m406b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m407b() {
            return this.f256b;
        }

        public c c(String str) {
            this.f257c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m408c() {
            return this.f257c;
        }

        public c d(String str) {
            this.f258d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m409d() {
            return this.f258d;
        }

        public c e(String str) {
            this.f259e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m410e() {
            return this.f259e;
        }

        public c f(String str) {
            this.f260f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m411f() {
            return this.f260f;
        }
    }

    /* loaded from: classes10.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f262a;

        /* renamed from: c  reason: collision with other field name */
        public boolean f264c;
        public boolean d;
        public boolean e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f263b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f261a = "";
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
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 8) {
                    a(bVar.m284a());
                } else if (m278a == 18) {
                    a(bVar.m281a());
                } else if (m278a == 26) {
                    b(bVar.m281a());
                } else if (m278a == 34) {
                    c(bVar.m281a());
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f264c = true;
            this.f261a = str;
            return this;
        }

        public d a(boolean z) {
            this.f262a = true;
            this.f263b = z;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m412a() {
            return this.f261a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m415b()) {
                cVar.m326a(1, m413a());
            }
            if (m416c()) {
                cVar.m325a(2, m412a());
            }
            if (d()) {
                cVar.m325a(3, m414b());
            }
            if (e()) {
                cVar.m325a(4, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m413a() {
            return this.f263b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m415b() ? 0 + com.xiaomi.push.c.a(1, m413a()) : 0;
            if (m416c()) {
                a += com.xiaomi.push.c.a(2, m412a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(3, m414b());
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
        public String m414b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m415b() {
            return this.f262a;
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
        public boolean m416c() {
            return this.f264c;
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
        public boolean f267a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f269b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f271c;

        /* renamed from: d  reason: collision with other field name */
        public boolean f273d;

        /* renamed from: e  reason: collision with other field name */
        public boolean f274e;

        /* renamed from: f  reason: collision with other field name */
        public boolean f275f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f266a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f268b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f270c = "";
        public int b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f272d = "";
        public String e = "";
        public String f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f265a = null;
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
        public b m417a() {
            return this.f265a;
        }

        public e a(int i) {
            this.f267a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                switch (m278a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m281a());
                        break;
                    case 26:
                        b(bVar.m281a());
                        break;
                    case 34:
                        c(bVar.m281a());
                        break;
                    case 40:
                        b(bVar.m287b());
                        break;
                    case 50:
                        d(bVar.m281a());
                        break;
                    case 58:
                        e(bVar.m281a());
                        break;
                    case 66:
                        f(bVar.m281a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m287b());
                        break;
                    default:
                        if (a(bVar, m278a)) {
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
                this.f265a = bVar;
                return this;
            }
            throw null;
        }

        public e a(String str) {
            this.f269b = true;
            this.f266a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m418a() {
            return this.f266a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m419a()) {
                cVar.m334b(1, c());
            }
            if (m421b()) {
                cVar.m325a(2, m418a());
            }
            if (m423c()) {
                cVar.m325a(3, m420b());
            }
            if (m425d()) {
                cVar.m325a(4, m422c());
            }
            if (m427e()) {
                cVar.m321a(5, d());
            }
            if (m428f()) {
                cVar.m325a(6, m424d());
            }
            if (g()) {
                cVar.m325a(7, m426e());
            }
            if (h()) {
                cVar.m325a(8, f());
            }
            if (i()) {
                cVar.m324a(9, (com.xiaomi.push.e) m417a());
            }
            if (j()) {
                cVar.m321a(10, e());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m419a() {
            return this.f267a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = m419a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m421b()) {
                b += com.xiaomi.push.c.a(2, m418a());
            }
            if (m423c()) {
                b += com.xiaomi.push.c.a(3, m420b());
            }
            if (m425d()) {
                b += com.xiaomi.push.c.a(4, m422c());
            }
            if (m427e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m428f()) {
                b += com.xiaomi.push.c.a(6, m424d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m426e());
            }
            if (h()) {
                b += com.xiaomi.push.c.a(8, f());
            }
            if (i()) {
                b += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m417a());
            }
            if (j()) {
                b += com.xiaomi.push.c.a(10, e());
            }
            this.d = b;
            return b;
        }

        public e b(int i) {
            this.f274e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f271c = true;
            this.f268b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m420b() {
            return this.f268b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m421b() {
            return this.f269b;
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
            this.f273d = true;
            this.f270c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m422c() {
            return this.f270c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m423c() {
            return this.f271c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f275f = true;
            this.f272d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m424d() {
            return this.f272d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m425d() {
            return this.f273d;
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
        public String m426e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m427e() {
            return this.f274e;
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
        public boolean m428f() {
            return this.f275f;
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
        public boolean f278a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f279b;
        public boolean c;

        /* renamed from: a  reason: collision with other field name */
        public String f277a = "";
        public String b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f276a = null;
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
        public b m429a() {
            return this.f276a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 10) {
                    a(bVar.m281a());
                } else if (m278a == 18) {
                    b(bVar.m281a());
                } else if (m278a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.c = true;
                this.f276a = bVar;
                return this;
            }
            throw null;
        }

        public f a(String str) {
            this.f278a = true;
            this.f277a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m430a() {
            return this.f277a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m431a()) {
                cVar.m325a(1, m430a());
            }
            if (m433b()) {
                cVar.m325a(2, m432b());
            }
            if (c()) {
                cVar.m324a(3, (com.xiaomi.push.e) m429a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m431a() {
            return this.f278a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m431a() ? 0 + com.xiaomi.push.c.a(1, m430a()) : 0;
            if (m433b()) {
                a += com.xiaomi.push.c.a(2, m432b());
            }
            if (c()) {
                a += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m429a());
            }
            this.a = a;
            return a;
        }

        public f b(String str) {
            this.f279b = true;
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
            return this.f279b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes10.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f281a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f282b;

        /* renamed from: c  reason: collision with other field name */
        public boolean f283c;

        /* renamed from: a  reason: collision with other field name */
        public String f280a = "";
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
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 10) {
                    a(bVar.m281a());
                } else if (m278a == 18) {
                    b(bVar.m281a());
                } else if (m278a == 26) {
                    c(bVar.m281a());
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.f281a = true;
            this.f280a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m434a() {
            return this.f280a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m435a()) {
                cVar.m325a(1, m434a());
            }
            if (m437b()) {
                cVar.m325a(2, m436b());
            }
            if (m438c()) {
                cVar.m325a(3, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m435a() {
            return this.f281a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m435a() ? 0 + com.xiaomi.push.c.a(1, m434a()) : 0;
            if (m437b()) {
                a += com.xiaomi.push.c.a(2, m436b());
            }
            if (m438c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
            this.f282b = true;
            this.b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m436b() {
            return this.b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m437b() {
            return this.f282b;
        }

        public g c(String str) {
            this.f283c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m438c() {
            return this.f283c;
        }
    }

    /* loaded from: classes10.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f285a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f286b;
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";
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
            this.f285a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 8) {
                    a(bVar.m287b());
                } else if (m278a == 18) {
                    a(bVar.m281a());
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f286b = true;
            this.f284a = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public String m439a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m440a()) {
                cVar.m321a(1, c());
            }
            if (m441b()) {
                cVar.m325a(2, m439a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m440a() {
            return this.f285a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m440a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m441b()) {
                a += com.xiaomi.push.c.a(2, m439a());
            }
            this.b = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m441b() {
            return this.f286b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes10.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f288a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f287a = com.xiaomi.push.a.a;
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
        public com.xiaomi.push.a m442a() {
            return this.f287a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f288a = true;
            this.f287a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 10) {
                    a(bVar.m280a());
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m443a()) {
                cVar.m323a(1, m442a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m443a() {
            return this.f288a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m443a() ? 0 + com.xiaomi.push.c.a(1, m442a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes10.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f291a;
        public boolean b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f289a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        public b f290a = null;
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
        public com.xiaomi.push.a m444a() {
            return this.f289a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public b m445a() {
            return this.f290a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f291a = true;
            this.f289a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 10) {
                    a(bVar.m280a());
                } else if (m278a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.b = true;
                this.f290a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m446a()) {
                cVar.m323a(1, m444a());
            }
            if (m447b()) {
                cVar.m324a(2, (com.xiaomi.push.e) m445a());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m446a() {
            return this.f291a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m446a() ? 0 + com.xiaomi.push.c.a(1, m444a()) : 0;
            if (m447b()) {
                a += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m445a());
            }
            this.a = a;
            return a;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m447b() {
            return this.b;
        }
    }

    /* loaded from: classes10.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f294a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f297b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean g;

        /* renamed from: a  reason: collision with other field name */
        public String f293a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f296b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f292a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f295b = 0;
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
        public long m448a() {
            return this.f292a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f292a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m278a = bVar.m278a();
                if (m278a == 0) {
                    return this;
                }
                if (m278a == 10) {
                    a(bVar.m281a());
                } else if (m278a == 18) {
                    b(bVar.m281a());
                } else if (m278a == 24) {
                    a(bVar.m279a());
                } else if (m278a == 32) {
                    b(bVar.m279a());
                } else if (m278a == 40) {
                    a(bVar.m284a());
                } else if (m278a == 48) {
                    a(bVar.m287b());
                } else if (!a(bVar, m278a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.f294a = true;
            this.f293a = str;
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
        public String m449a() {
            return this.f293a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (m450a()) {
                cVar.m325a(1, m449a());
            }
            if (m453b()) {
                cVar.m325a(2, m452b());
            }
            if (m454c()) {
                cVar.m322a(3, m448a());
            }
            if (d()) {
                cVar.m322a(4, m451b());
            }
            if (f()) {
                cVar.m326a(5, e());
            }
            if (g()) {
                cVar.m321a(6, c());
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m450a() {
            return this.f294a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = m450a() ? 0 + com.xiaomi.push.c.a(1, m449a()) : 0;
            if (m453b()) {
                a += com.xiaomi.push.c.a(2, m452b());
            }
            if (m454c()) {
                a += com.xiaomi.push.c.a(3, m448a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(4, m451b());
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
        public long m451b() {
            return this.f295b;
        }

        public k b(long j) {
            this.d = true;
            this.f295b = j;
            return this;
        }

        public k b(String str) {
            this.f297b = true;
            this.f296b = str;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public String m452b() {
            return this.f296b;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m453b() {
            return this.f297b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m454c() {
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
