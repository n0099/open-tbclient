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
        public boolean f41242g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f41243h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f41244i;
        public boolean j;
        public boolean k;

        /* renamed from: a  reason: collision with root package name */
        public int f41236a = 0;

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
        public int f41237b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f41238c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f41239d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f41241f = "";

        /* renamed from: e  reason: collision with root package name */
        public int f41240e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41240e < 0) {
                b();
            }
            return this.f41240e;
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
            this.f41236a = i2;
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
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m152b());
                        break;
                    case 16:
                        a(bVar.m153b());
                        break;
                    case 26:
                        a(bVar.m146a());
                        break;
                    case 34:
                        b(bVar.m146a());
                        break;
                    case 42:
                        c(bVar.m146a());
                        break;
                    case 50:
                        d(bVar.m146a());
                        break;
                    case 58:
                        e(bVar.m146a());
                        break;
                    case 64:
                        b(bVar.m152b());
                        break;
                    case 72:
                        c(bVar.m152b());
                        break;
                    case 80:
                        d(bVar.m152b());
                        break;
                    case 90:
                        f(bVar.m146a());
                        break;
                    default:
                        if (a(bVar, m143a)) {
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
                cVar.m181a(1, c());
            }
            if (b()) {
                cVar.m195b(2, a());
            }
            if (m241c()) {
                cVar.m185a(3, a());
            }
            if (m243d()) {
                cVar.m185a(4, b());
            }
            if (m245e()) {
                cVar.m185a(5, m240c());
            }
            if (m247f()) {
                cVar.m185a(6, m242d());
            }
            if (g()) {
                cVar.m185a(7, m244e());
            }
            if (h()) {
                cVar.m181a(8, d());
            }
            if (i()) {
                cVar.m181a(9, e());
            }
            if (j()) {
                cVar.m181a(10, f());
            }
            if (k()) {
                cVar.m185a(11, m246f());
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
            if (m241c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m243d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m245e()) {
                a2 += com.xiaomi.push.c.a(5, m240c());
            }
            if (m247f()) {
                a2 += com.xiaomi.push.c.a(6, m242d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m244e());
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
                a2 += com.xiaomi.push.c.a(11, m246f());
            }
            this.f41240e = a2;
            return a2;
        }

        public a b(int i2) {
            this.f41243h = true;
            this.f41237b = i2;
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
            return this.f41236a;
        }

        public a c(int i2) {
            this.f41244i = true;
            this.f41238c = i2;
            return this;
        }

        public a c(String str) {
            this.f255e = true;
            this.f250c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m240c() {
            return this.f250c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m241c() {
            return this.f251c;
        }

        public int d() {
            return this.f41237b;
        }

        public a d(int i2) {
            this.j = true;
            this.f41239d = i2;
            return this;
        }

        public a d(String str) {
            this.f256f = true;
            this.f252d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m242d() {
            return this.f252d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m243d() {
            return this.f253d;
        }

        public int e() {
            return this.f41238c;
        }

        public a e(String str) {
            this.f41242g = true;
            this.f254e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m244e() {
            return this.f254e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m245e() {
            return this.f255e;
        }

        public int f() {
            return this.f41239d;
        }

        public a f(String str) {
            this.k = true;
            this.f41241f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m246f() {
            return this.f41241f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m247f() {
            return this.f256f;
        }

        public boolean g() {
            return this.f41242g;
        }

        public boolean h() {
            return this.f41243h;
        }

        public boolean i() {
            return this.f41244i;
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
        public boolean f41249e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f258b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f41245a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f41246b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f41247c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f41248d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41248d < 0) {
                b();
            }
            return this.f41248d;
        }

        public b a(int i2) {
            this.f259c = true;
            this.f41245a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 8) {
                    a(bVar.m149a());
                } else if (m143a == 24) {
                    a(bVar.m152b());
                } else if (m143a == 32) {
                    b(bVar.m152b());
                } else if (m143a == 40) {
                    c(bVar.m152b());
                } else if (!a(bVar, m143a)) {
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
                cVar.m186a(1, a());
            }
            if (m248c()) {
                cVar.m181a(3, c());
            }
            if (m249d()) {
                cVar.m181a(4, d());
            }
            if (m250e()) {
                cVar.m181a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f258b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m248c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m249d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m250e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.f41248d = a2;
            return a2;
        }

        public b b(int i2) {
            this.f260d = true;
            this.f41246b = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f257a;
        }

        public int c() {
            return this.f41245a;
        }

        public b c(int i2) {
            this.f41249e = true;
            this.f41247c = i2;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m248c() {
            return this.f259c;
        }

        public int d() {
            return this.f41246b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m249d() {
            return this.f260d;
        }

        public int e() {
            return this.f41247c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m250e() {
            return this.f41249e;
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
        public String f41251b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f41252c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f41253d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f41254e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f41255f = "";

        /* renamed from: a  reason: collision with root package name */
        public int f41250a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41250a < 0) {
                b();
            }
            return this.f41250a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 10) {
                    a(bVar.m146a());
                } else if (m143a == 18) {
                    b(bVar.m146a());
                } else if (m143a == 26) {
                    c(bVar.m146a());
                } else if (m143a == 34) {
                    d(bVar.m146a());
                } else if (m143a == 42) {
                    e(bVar.m146a());
                } else if (m143a == 50) {
                    f(bVar.m146a());
                } else if (!a(bVar, m143a)) {
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
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m185a(2, b());
            }
            if (m251c()) {
                cVar.m185a(3, c());
            }
            if (m252d()) {
                cVar.m185a(4, d());
            }
            if (m253e()) {
                cVar.m185a(5, e());
            }
            if (m254f()) {
                cVar.m185a(6, f());
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
            if (m251c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m252d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m253e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m254f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f41250a = a2;
            return a2;
        }

        public c b(String str) {
            this.f263b = true;
            this.f41251b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f41251b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f263b;
        }

        public c c(String str) {
            this.f264c = true;
            this.f41252c = str;
            return this;
        }

        public String c() {
            return this.f41252c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m251c() {
            return this.f264c;
        }

        public c d(String str) {
            this.f265d = true;
            this.f41253d = str;
            return this;
        }

        public String d() {
            return this.f41253d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m252d() {
            return this.f265d;
        }

        public c e(String str) {
            this.f266e = true;
            this.f41254e = str;
            return this;
        }

        public String e() {
            return this.f41254e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m253e() {
            return this.f266e;
        }

        public c f(String str) {
            this.f267f = true;
            this.f41255f = str;
            return this;
        }

        public String f() {
            return this.f41255f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m254f() {
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
        public boolean f41259d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41260e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f270b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f268a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f41257b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f41258c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f41256a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41256a < 0) {
                b();
            }
            return this.f41256a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 8) {
                    a(bVar.m149a());
                } else if (m143a == 18) {
                    a(bVar.m146a());
                } else if (m143a == 26) {
                    b(bVar.m146a());
                } else if (m143a == 34) {
                    c(bVar.m146a());
                } else if (!a(bVar, m143a)) {
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
                cVar.m186a(1, a());
            }
            if (m255c()) {
                cVar.m185a(2, a());
            }
            if (d()) {
                cVar.m185a(3, b());
            }
            if (e()) {
                cVar.m185a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f270b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m255c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f41256a = a2;
            return a2;
        }

        public d b(String str) {
            this.f41259d = true;
            this.f41257b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f41257b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f269a;
        }

        public d c(String str) {
            this.f41260e = true;
            this.f41258c = str;
            return this;
        }

        public String c() {
            return this.f41258c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m255c() {
            return this.f271c;
        }

        public boolean d() {
            return this.f41259d;
        }

        public boolean e() {
            return this.f41260e;
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
        public boolean f41267g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f41268h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f41269i;
        public boolean j;

        /* renamed from: a  reason: collision with root package name */
        public int f41261a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f273a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f275b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f277c = "";

        /* renamed from: b  reason: collision with root package name */
        public int f41262b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f279d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f41265e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f41266f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f272a = null;

        /* renamed from: c  reason: collision with root package name */
        public int f41263c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f41264d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41264d < 0) {
                b();
            }
            return this.f41264d;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f272a;
        }

        public e a(int i2) {
            this.f274a = true;
            this.f41261a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m146a());
                        break;
                    case 26:
                        b(bVar.m146a());
                        break;
                    case 34:
                        c(bVar.m146a());
                        break;
                    case 40:
                        b(bVar.m152b());
                        break;
                    case 50:
                        d(bVar.m146a());
                        break;
                    case 58:
                        e(bVar.m146a());
                        break;
                    case 66:
                        f(bVar.m146a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m152b());
                        break;
                    default:
                        if (a(bVar, m143a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.f41269i = true;
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
                cVar.m194b(1, c());
            }
            if (b()) {
                cVar.m185a(2, a());
            }
            if (m257c()) {
                cVar.m185a(3, b());
            }
            if (m259d()) {
                cVar.m185a(4, m256c());
            }
            if (m261e()) {
                cVar.m181a(5, d());
            }
            if (m262f()) {
                cVar.m185a(6, m258d());
            }
            if (g()) {
                cVar.m185a(7, m260e());
            }
            if (h()) {
                cVar.m185a(8, f());
            }
            if (i()) {
                cVar.m184a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m181a(10, e());
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
            if (m257c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m259d()) {
                b2 += com.xiaomi.push.c.a(4, m256c());
            }
            if (m261e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m262f()) {
                b2 += com.xiaomi.push.c.a(6, m258d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m260e());
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
            this.f41264d = b2;
            return b2;
        }

        public e b(int i2) {
            this.f281e = true;
            this.f41262b = i2;
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
            return this.f41261a;
        }

        public e c(int i2) {
            this.j = true;
            this.f41263c = i2;
            return this;
        }

        public e c(String str) {
            this.f280d = true;
            this.f277c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m256c() {
            return this.f277c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m257c() {
            return this.f278c;
        }

        public int d() {
            return this.f41262b;
        }

        public e d(String str) {
            this.f282f = true;
            this.f279d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m258d() {
            return this.f279d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m259d() {
            return this.f280d;
        }

        public int e() {
            return this.f41263c;
        }

        public e e(String str) {
            this.f41267g = true;
            this.f41265e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m260e() {
            return this.f41265e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m261e() {
            return this.f281e;
        }

        public e f(String str) {
            this.f41268h = true;
            this.f41266f = str;
            return this;
        }

        public String f() {
            return this.f41266f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m262f() {
            return this.f282f;
        }

        public boolean g() {
            return this.f41267g;
        }

        public boolean h() {
            return this.f41268h;
        }

        public boolean i() {
            return this.f41269i;
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
        public boolean f41272c;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f41271b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f283a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f41270a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41270a < 0) {
                b();
            }
            return this.f41270a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f283a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 10) {
                    a(bVar.m146a());
                } else if (m143a == 18) {
                    b(bVar.m146a());
                } else if (m143a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m143a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f41272c = true;
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
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m185a(2, b());
            }
            if (c()) {
                cVar.m184a(3, (com.xiaomi.push.e) a());
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
            this.f41270a = a2;
            return a2;
        }

        public f b(String str) {
            this.f286b = true;
            this.f41271b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f41271b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f286b;
        }

        public boolean c() {
            return this.f41272c;
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
        public String f41274b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f41275c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f41273a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41273a < 0) {
                b();
            }
            return this.f41273a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 10) {
                    a(bVar.m146a());
                } else if (m143a == 18) {
                    b(bVar.m146a());
                } else if (m143a == 26) {
                    c(bVar.m146a());
                } else if (!a(bVar, m143a)) {
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
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m185a(2, b());
            }
            if (m263c()) {
                cVar.m185a(3, c());
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
            if (m263c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f41273a = a2;
            return a2;
        }

        public g b(String str) {
            this.f289b = true;
            this.f41274b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f41274b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f289b;
        }

        public g c(String str) {
            this.f290c = true;
            this.f41275c = str;
            return this;
        }

        public String c() {
            return this.f41275c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m263c() {
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
        public int f41276a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f291a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f41277b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41277b < 0) {
                b();
            }
            return this.f41277b;
        }

        public h a(int i2) {
            this.f292a = true;
            this.f41276a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 8) {
                    a(bVar.m152b());
                } else if (m143a == 18) {
                    a(bVar.m146a());
                } else if (!a(bVar, m143a)) {
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
                cVar.m181a(1, c());
            }
            if (b()) {
                cVar.m185a(2, a());
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
            this.f41277b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f293b;
        }

        public int c() {
            return this.f41276a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f294a = com.xiaomi.push.a.f41069a;

        /* renamed from: a  reason: collision with root package name */
        public int f41278a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41278a < 0) {
                b();
            }
            return this.f41278a;
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
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 10) {
                    a(bVar.m145a());
                } else if (!a(bVar, m143a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m183a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f41278a = a2;
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f298a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41280b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f296a = com.xiaomi.push.a.f41069a;

        /* renamed from: a  reason: collision with other field name */
        public b f297a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f41279a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41279a < 0) {
                b();
            }
            return this.f41279a;
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
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 10) {
                    a(bVar.m145a());
                } else if (m143a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m143a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f41280b = true;
                this.f297a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m183a(1, a());
            }
            if (b()) {
                cVar.m184a(2, (com.xiaomi.push.e) a());
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
            this.f41279a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f41280b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f301a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41283c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41284d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41285e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f41287g;

        /* renamed from: a  reason: collision with other field name */
        public String f300a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f303b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f299a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f302b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f41286f = false;

        /* renamed from: a  reason: collision with root package name */
        public int f41281a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f41282b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41282b < 0) {
                b();
            }
            return this.f41282b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f299a;
        }

        public k a(int i2) {
            this.f41287g = true;
            this.f41281a = i2;
            return this;
        }

        public k a(long j) {
            this.f41283c = true;
            this.f299a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 10) {
                    a(bVar.m146a());
                } else if (m143a == 18) {
                    b(bVar.m146a());
                } else if (m143a == 24) {
                    a(bVar.m144a());
                } else if (m143a == 32) {
                    b(bVar.m144a());
                } else if (m143a == 40) {
                    a(bVar.m149a());
                } else if (m143a == 48) {
                    a(bVar.m152b());
                } else if (!a(bVar, m143a)) {
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
            this.f41285e = true;
            this.f41286f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f300a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m185a(2, b());
            }
            if (m264c()) {
                cVar.m182a(3, a());
            }
            if (d()) {
                cVar.m182a(4, b());
            }
            if (f()) {
                cVar.m186a(5, e());
            }
            if (g()) {
                cVar.m181a(6, c());
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
            if (m264c()) {
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
            this.f41282b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f302b;
        }

        public k b(long j) {
            this.f41284d = true;
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
            return this.f41281a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m264c() {
            return this.f41283c;
        }

        public boolean d() {
            return this.f41284d;
        }

        public boolean e() {
            return this.f41286f;
        }

        public boolean f() {
            return this.f41285e;
        }

        public boolean g() {
            return this.f41287g;
        }
    }
}
