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
        public boolean f40769g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f40770h;
        public boolean i;
        public boolean j;
        public boolean k;

        /* renamed from: a  reason: collision with root package name */
        public int f40763a = 0;

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
        public int f40764b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f40765c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f40766d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f40768f = "";

        /* renamed from: e  reason: collision with root package name */
        public int f40767e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40767e < 0) {
                b();
            }
            return this.f40767e;
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
            this.f40763a = i;
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
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m151b());
                        break;
                    case 16:
                        a(bVar.m152b());
                        break;
                    case 26:
                        a(bVar.m145a());
                        break;
                    case 34:
                        b(bVar.m145a());
                        break;
                    case 42:
                        c(bVar.m145a());
                        break;
                    case 50:
                        d(bVar.m145a());
                        break;
                    case 58:
                        e(bVar.m145a());
                        break;
                    case 64:
                        b(bVar.m151b());
                        break;
                    case 72:
                        c(bVar.m151b());
                        break;
                    case 80:
                        d(bVar.m151b());
                        break;
                    case 90:
                        f(bVar.m145a());
                        break;
                    default:
                        if (a(bVar, m142a)) {
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
                cVar.m180a(1, c());
            }
            if (b()) {
                cVar.m194b(2, a());
            }
            if (m240c()) {
                cVar.m184a(3, a());
            }
            if (m242d()) {
                cVar.m184a(4, b());
            }
            if (m244e()) {
                cVar.m184a(5, m239c());
            }
            if (m246f()) {
                cVar.m184a(6, m241d());
            }
            if (g()) {
                cVar.m184a(7, m243e());
            }
            if (h()) {
                cVar.m180a(8, d());
            }
            if (i()) {
                cVar.m180a(9, e());
            }
            if (j()) {
                cVar.m180a(10, f());
            }
            if (k()) {
                cVar.m184a(11, m245f());
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
            if (m240c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m242d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m244e()) {
                a2 += com.xiaomi.push.c.a(5, m239c());
            }
            if (m246f()) {
                a2 += com.xiaomi.push.c.a(6, m241d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m243e());
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
                a2 += com.xiaomi.push.c.a(11, m245f());
            }
            this.f40767e = a2;
            return a2;
        }

        public a b(int i) {
            this.f40770h = true;
            this.f40764b = i;
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
            return this.f40763a;
        }

        public a c(int i) {
            this.i = true;
            this.f40765c = i;
            return this;
        }

        public a c(String str) {
            this.f255e = true;
            this.f250c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m239c() {
            return this.f250c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m240c() {
            return this.f251c;
        }

        public int d() {
            return this.f40764b;
        }

        public a d(int i) {
            this.j = true;
            this.f40766d = i;
            return this;
        }

        public a d(String str) {
            this.f256f = true;
            this.f252d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m241d() {
            return this.f252d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m242d() {
            return this.f253d;
        }

        public int e() {
            return this.f40765c;
        }

        public a e(String str) {
            this.f40769g = true;
            this.f254e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m243e() {
            return this.f254e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m244e() {
            return this.f255e;
        }

        public int f() {
            return this.f40766d;
        }

        public a f(String str) {
            this.k = true;
            this.f40768f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m245f() {
            return this.f40768f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m246f() {
            return this.f256f;
        }

        public boolean g() {
            return this.f40769g;
        }

        public boolean h() {
            return this.f40770h;
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
        public boolean f40775e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f258b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f40771a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f40772b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f40773c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f40774d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40774d < 0) {
                b();
            }
            return this.f40774d;
        }

        public b a(int i) {
            this.f259c = true;
            this.f40771a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 8) {
                    a(bVar.m148a());
                } else if (m142a == 24) {
                    a(bVar.m151b());
                } else if (m142a == 32) {
                    b(bVar.m151b());
                } else if (m142a == 40) {
                    c(bVar.m151b());
                } else if (!a(bVar, m142a)) {
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
                cVar.m185a(1, a());
            }
            if (m247c()) {
                cVar.m180a(3, c());
            }
            if (m248d()) {
                cVar.m180a(4, d());
            }
            if (m249e()) {
                cVar.m180a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f258b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m247c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m248d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m249e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.f40774d = a2;
            return a2;
        }

        public b b(int i) {
            this.f260d = true;
            this.f40772b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f257a;
        }

        public int c() {
            return this.f40771a;
        }

        public b c(int i) {
            this.f40775e = true;
            this.f40773c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m247c() {
            return this.f259c;
        }

        public int d() {
            return this.f40772b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m248d() {
            return this.f260d;
        }

        public int e() {
            return this.f40773c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m249e() {
            return this.f40775e;
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
        public String f40777b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f40778c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f40779d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f40780e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f40781f = "";

        /* renamed from: a  reason: collision with root package name */
        public int f40776a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40776a < 0) {
                b();
            }
            return this.f40776a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 10) {
                    a(bVar.m145a());
                } else if (m142a == 18) {
                    b(bVar.m145a());
                } else if (m142a == 26) {
                    c(bVar.m145a());
                } else if (m142a == 34) {
                    d(bVar.m145a());
                } else if (m142a == 42) {
                    e(bVar.m145a());
                } else if (m142a == 50) {
                    f(bVar.m145a());
                } else if (!a(bVar, m142a)) {
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
                cVar.m184a(1, a());
            }
            if (b()) {
                cVar.m184a(2, b());
            }
            if (m250c()) {
                cVar.m184a(3, c());
            }
            if (m251d()) {
                cVar.m184a(4, d());
            }
            if (m252e()) {
                cVar.m184a(5, e());
            }
            if (m253f()) {
                cVar.m184a(6, f());
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
            if (m250c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m251d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m252e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m253f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f40776a = a2;
            return a2;
        }

        public c b(String str) {
            this.f263b = true;
            this.f40777b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40777b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f263b;
        }

        public c c(String str) {
            this.f264c = true;
            this.f40778c = str;
            return this;
        }

        public String c() {
            return this.f40778c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m250c() {
            return this.f264c;
        }

        public c d(String str) {
            this.f265d = true;
            this.f40779d = str;
            return this;
        }

        public String d() {
            return this.f40779d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m251d() {
            return this.f265d;
        }

        public c e(String str) {
            this.f266e = true;
            this.f40780e = str;
            return this;
        }

        public String e() {
            return this.f40780e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m252e() {
            return this.f266e;
        }

        public c f(String str) {
            this.f267f = true;
            this.f40781f = str;
            return this;
        }

        public String f() {
            return this.f40781f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m253f() {
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
        public boolean f40785d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40786e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f270b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f268a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f40783b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f40784c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f40782a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40782a < 0) {
                b();
            }
            return this.f40782a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 8) {
                    a(bVar.m148a());
                } else if (m142a == 18) {
                    a(bVar.m145a());
                } else if (m142a == 26) {
                    b(bVar.m145a());
                } else if (m142a == 34) {
                    c(bVar.m145a());
                } else if (!a(bVar, m142a)) {
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
                cVar.m185a(1, a());
            }
            if (m254c()) {
                cVar.m184a(2, a());
            }
            if (d()) {
                cVar.m184a(3, b());
            }
            if (e()) {
                cVar.m184a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f270b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m254c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f40782a = a2;
            return a2;
        }

        public d b(String str) {
            this.f40785d = true;
            this.f40783b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40783b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f269a;
        }

        public d c(String str) {
            this.f40786e = true;
            this.f40784c = str;
            return this;
        }

        public String c() {
            return this.f40784c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m254c() {
            return this.f271c;
        }

        public boolean d() {
            return this.f40785d;
        }

        public boolean e() {
            return this.f40786e;
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
        public boolean f40793g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f40794h;
        public boolean i;
        public boolean j;

        /* renamed from: a  reason: collision with root package name */
        public int f40787a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f273a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f275b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f277c = "";

        /* renamed from: b  reason: collision with root package name */
        public int f40788b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f279d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f40791e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f40792f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f272a = null;

        /* renamed from: c  reason: collision with root package name */
        public int f40789c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f40790d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40790d < 0) {
                b();
            }
            return this.f40790d;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f272a;
        }

        public e a(int i) {
            this.f274a = true;
            this.f40787a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m145a());
                        break;
                    case 26:
                        b(bVar.m145a());
                        break;
                    case 34:
                        c(bVar.m145a());
                        break;
                    case 40:
                        b(bVar.m151b());
                        break;
                    case 50:
                        d(bVar.m145a());
                        break;
                    case 58:
                        e(bVar.m145a());
                        break;
                    case 66:
                        f(bVar.m145a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m151b());
                        break;
                    default:
                        if (a(bVar, m142a)) {
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
                cVar.m193b(1, c());
            }
            if (b()) {
                cVar.m184a(2, a());
            }
            if (m256c()) {
                cVar.m184a(3, b());
            }
            if (m258d()) {
                cVar.m184a(4, m255c());
            }
            if (m260e()) {
                cVar.m180a(5, d());
            }
            if (m261f()) {
                cVar.m184a(6, m257d());
            }
            if (g()) {
                cVar.m184a(7, m259e());
            }
            if (h()) {
                cVar.m184a(8, f());
            }
            if (i()) {
                cVar.m183a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m180a(10, e());
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
            if (m256c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m258d()) {
                b2 += com.xiaomi.push.c.a(4, m255c());
            }
            if (m260e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m261f()) {
                b2 += com.xiaomi.push.c.a(6, m257d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m259e());
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
            this.f40790d = b2;
            return b2;
        }

        public e b(int i) {
            this.f281e = true;
            this.f40788b = i;
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
            return this.f40787a;
        }

        public e c(int i) {
            this.j = true;
            this.f40789c = i;
            return this;
        }

        public e c(String str) {
            this.f280d = true;
            this.f277c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m255c() {
            return this.f277c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m256c() {
            return this.f278c;
        }

        public int d() {
            return this.f40788b;
        }

        public e d(String str) {
            this.f282f = true;
            this.f279d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m257d() {
            return this.f279d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m258d() {
            return this.f280d;
        }

        public int e() {
            return this.f40789c;
        }

        public e e(String str) {
            this.f40793g = true;
            this.f40791e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m259e() {
            return this.f40791e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m260e() {
            return this.f281e;
        }

        public e f(String str) {
            this.f40794h = true;
            this.f40792f = str;
            return this;
        }

        public String f() {
            return this.f40792f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m261f() {
            return this.f282f;
        }

        public boolean g() {
            return this.f40793g;
        }

        public boolean h() {
            return this.f40794h;
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
        public boolean f40797c;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f40796b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f283a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f40795a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40795a < 0) {
                b();
            }
            return this.f40795a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f283a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 10) {
                    a(bVar.m145a());
                } else if (m142a == 18) {
                    b(bVar.m145a());
                } else if (m142a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m142a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f40797c = true;
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
                cVar.m184a(1, a());
            }
            if (b()) {
                cVar.m184a(2, b());
            }
            if (c()) {
                cVar.m183a(3, (com.xiaomi.push.e) a());
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
            this.f40795a = a2;
            return a2;
        }

        public f b(String str) {
            this.f286b = true;
            this.f40796b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40796b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f286b;
        }

        public boolean c() {
            return this.f40797c;
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
        public String f40799b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f40800c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f40798a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40798a < 0) {
                b();
            }
            return this.f40798a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 10) {
                    a(bVar.m145a());
                } else if (m142a == 18) {
                    b(bVar.m145a());
                } else if (m142a == 26) {
                    c(bVar.m145a());
                } else if (!a(bVar, m142a)) {
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
                cVar.m184a(1, a());
            }
            if (b()) {
                cVar.m184a(2, b());
            }
            if (m262c()) {
                cVar.m184a(3, c());
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
            if (m262c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f40798a = a2;
            return a2;
        }

        public g b(String str) {
            this.f289b = true;
            this.f40799b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f40799b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f289b;
        }

        public g c(String str) {
            this.f290c = true;
            this.f40800c = str;
            return this;
        }

        public String c() {
            return this.f40800c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m262c() {
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
        public int f40801a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f291a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f40802b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40802b < 0) {
                b();
            }
            return this.f40802b;
        }

        public h a(int i) {
            this.f292a = true;
            this.f40801a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 8) {
                    a(bVar.m151b());
                } else if (m142a == 18) {
                    a(bVar.m145a());
                } else if (!a(bVar, m142a)) {
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
                cVar.m180a(1, c());
            }
            if (b()) {
                cVar.m184a(2, a());
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
            this.f40802b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f293b;
        }

        public int c() {
            return this.f40801a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f294a = com.xiaomi.push.a.f40598a;

        /* renamed from: a  reason: collision with root package name */
        public int f40803a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40803a < 0) {
                b();
            }
            return this.f40803a;
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
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 10) {
                    a(bVar.m144a());
                } else if (!a(bVar, m142a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m182a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f40803a = a2;
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f298a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f40805b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f296a = com.xiaomi.push.a.f40598a;

        /* renamed from: a  reason: collision with other field name */
        public b f297a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f40804a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40804a < 0) {
                b();
            }
            return this.f40804a;
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
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 10) {
                    a(bVar.m144a());
                } else if (m142a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m142a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f40805b = true;
                this.f297a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m182a(1, a());
            }
            if (b()) {
                cVar.m183a(2, (com.xiaomi.push.e) a());
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
            this.f40804a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f40805b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f301a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40808c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40809d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40810e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f40812g;

        /* renamed from: a  reason: collision with other field name */
        public String f300a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f303b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f299a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f302b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f40811f = false;

        /* renamed from: a  reason: collision with root package name */
        public int f40806a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f40807b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40807b < 0) {
                b();
            }
            return this.f40807b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f299a;
        }

        public k a(int i) {
            this.f40812g = true;
            this.f40806a = i;
            return this;
        }

        public k a(long j) {
            this.f40808c = true;
            this.f299a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                if (m142a == 0) {
                    return this;
                }
                if (m142a == 10) {
                    a(bVar.m145a());
                } else if (m142a == 18) {
                    b(bVar.m145a());
                } else if (m142a == 24) {
                    a(bVar.m143a());
                } else if (m142a == 32) {
                    b(bVar.m143a());
                } else if (m142a == 40) {
                    a(bVar.m148a());
                } else if (m142a == 48) {
                    a(bVar.m151b());
                } else if (!a(bVar, m142a)) {
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
            this.f40810e = true;
            this.f40811f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f300a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m184a(1, a());
            }
            if (b()) {
                cVar.m184a(2, b());
            }
            if (m263c()) {
                cVar.m181a(3, a());
            }
            if (d()) {
                cVar.m181a(4, b());
            }
            if (f()) {
                cVar.m185a(5, e());
            }
            if (g()) {
                cVar.m180a(6, c());
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
            if (m263c()) {
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
            this.f40807b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f302b;
        }

        public k b(long j) {
            this.f40809d = true;
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
            return this.f40806a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m263c() {
            return this.f40808c;
        }

        public boolean d() {
            return this.f40809d;
        }

        public boolean e() {
            return this.f40811f;
        }

        public boolean f() {
            return this.f40810e;
        }

        public boolean g() {
            return this.f40812g;
        }
    }
}
