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
        public boolean f38286g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38287h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f38288i;
        public boolean j;
        public boolean k;

        /* renamed from: a  reason: collision with root package name */
        public int f38280a = 0;

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
        public int f38281b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f38282c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f38283d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f38285f = "";

        /* renamed from: e  reason: collision with root package name */
        public int f38284e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38284e < 0) {
                b();
            }
            return this.f38284e;
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
            this.f38280a = i2;
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
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m154b());
                        break;
                    case 16:
                        a(bVar.m155b());
                        break;
                    case 26:
                        a(bVar.m148a());
                        break;
                    case 34:
                        b(bVar.m148a());
                        break;
                    case 42:
                        c(bVar.m148a());
                        break;
                    case 50:
                        d(bVar.m148a());
                        break;
                    case 58:
                        e(bVar.m148a());
                        break;
                    case 64:
                        b(bVar.m154b());
                        break;
                    case 72:
                        c(bVar.m154b());
                        break;
                    case 80:
                        d(bVar.m154b());
                        break;
                    case 90:
                        f(bVar.m148a());
                        break;
                    default:
                        if (a(bVar, m145a)) {
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
                cVar.m183a(1, c());
            }
            if (b()) {
                cVar.m197b(2, a());
            }
            if (m243c()) {
                cVar.m187a(3, a());
            }
            if (m245d()) {
                cVar.m187a(4, b());
            }
            if (m247e()) {
                cVar.m187a(5, m242c());
            }
            if (m249f()) {
                cVar.m187a(6, m244d());
            }
            if (g()) {
                cVar.m187a(7, m246e());
            }
            if (h()) {
                cVar.m183a(8, d());
            }
            if (i()) {
                cVar.m183a(9, e());
            }
            if (j()) {
                cVar.m183a(10, f());
            }
            if (k()) {
                cVar.m187a(11, m248f());
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
            if (m243c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m245d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m247e()) {
                a2 += com.xiaomi.push.c.a(5, m242c());
            }
            if (m249f()) {
                a2 += com.xiaomi.push.c.a(6, m244d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m246e());
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
                a2 += com.xiaomi.push.c.a(11, m248f());
            }
            this.f38284e = a2;
            return a2;
        }

        public a b(int i2) {
            this.f38287h = true;
            this.f38281b = i2;
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
            return this.f38280a;
        }

        public a c(int i2) {
            this.f38288i = true;
            this.f38282c = i2;
            return this;
        }

        public a c(String str) {
            this.f255e = true;
            this.f250c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m242c() {
            return this.f250c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m243c() {
            return this.f251c;
        }

        public int d() {
            return this.f38281b;
        }

        public a d(int i2) {
            this.j = true;
            this.f38283d = i2;
            return this;
        }

        public a d(String str) {
            this.f256f = true;
            this.f252d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m244d() {
            return this.f252d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m245d() {
            return this.f253d;
        }

        public int e() {
            return this.f38282c;
        }

        public a e(String str) {
            this.f38286g = true;
            this.f254e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m246e() {
            return this.f254e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m247e() {
            return this.f255e;
        }

        public int f() {
            return this.f38283d;
        }

        public a f(String str) {
            this.k = true;
            this.f38285f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m248f() {
            return this.f38285f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m249f() {
            return this.f256f;
        }

        public boolean g() {
            return this.f38286g;
        }

        public boolean h() {
            return this.f38287h;
        }

        public boolean i() {
            return this.f38288i;
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
        public boolean f38293e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f258b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f38289a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f38290b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f38291c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f38292d = -1;

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38292d < 0) {
                b();
            }
            return this.f38292d;
        }

        public b a(int i2) {
            this.f259c = true;
            this.f38289a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 8) {
                    a(bVar.m151a());
                } else if (m145a == 24) {
                    a(bVar.m154b());
                } else if (m145a == 32) {
                    b(bVar.m154b());
                } else if (m145a == 40) {
                    c(bVar.m154b());
                } else if (!a(bVar, m145a)) {
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
                cVar.m188a(1, a());
            }
            if (m250c()) {
                cVar.m183a(3, c());
            }
            if (m251d()) {
                cVar.m183a(4, d());
            }
            if (m252e()) {
                cVar.m183a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f258b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m250c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m251d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m252e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.f38292d = a2;
            return a2;
        }

        public b b(int i2) {
            this.f260d = true;
            this.f38290b = i2;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f257a;
        }

        public int c() {
            return this.f38289a;
        }

        public b c(int i2) {
            this.f38293e = true;
            this.f38291c = i2;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m250c() {
            return this.f259c;
        }

        public int d() {
            return this.f38290b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m251d() {
            return this.f260d;
        }

        public int e() {
            return this.f38291c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m252e() {
            return this.f38293e;
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
        public String f38295b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f38296c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f38297d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f38298e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f38299f = "";

        /* renamed from: a  reason: collision with root package name */
        public int f38294a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38294a < 0) {
                b();
            }
            return this.f38294a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 10) {
                    a(bVar.m148a());
                } else if (m145a == 18) {
                    b(bVar.m148a());
                } else if (m145a == 26) {
                    c(bVar.m148a());
                } else if (m145a == 34) {
                    d(bVar.m148a());
                } else if (m145a == 42) {
                    e(bVar.m148a());
                } else if (m145a == 50) {
                    f(bVar.m148a());
                } else if (!a(bVar, m145a)) {
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
                cVar.m187a(1, a());
            }
            if (b()) {
                cVar.m187a(2, b());
            }
            if (m253c()) {
                cVar.m187a(3, c());
            }
            if (m254d()) {
                cVar.m187a(4, d());
            }
            if (m255e()) {
                cVar.m187a(5, e());
            }
            if (m256f()) {
                cVar.m187a(6, f());
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
            if (m253c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m254d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m255e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m256f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f38294a = a2;
            return a2;
        }

        public c b(String str) {
            this.f263b = true;
            this.f38295b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f38295b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f263b;
        }

        public c c(String str) {
            this.f264c = true;
            this.f38296c = str;
            return this;
        }

        public String c() {
            return this.f38296c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m253c() {
            return this.f264c;
        }

        public c d(String str) {
            this.f265d = true;
            this.f38297d = str;
            return this;
        }

        public String d() {
            return this.f38297d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m254d() {
            return this.f265d;
        }

        public c e(String str) {
            this.f266e = true;
            this.f38298e = str;
            return this;
        }

        public String e() {
            return this.f38298e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m255e() {
            return this.f266e;
        }

        public c f(String str) {
            this.f267f = true;
            this.f38299f = str;
            return this;
        }

        public String f() {
            return this.f38299f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m256f() {
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
        public boolean f38303d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38304e;

        /* renamed from: b  reason: collision with other field name */
        public boolean f270b = false;

        /* renamed from: a  reason: collision with other field name */
        public String f268a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f38301b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f38302c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f38300a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38300a < 0) {
                b();
            }
            return this.f38300a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 8) {
                    a(bVar.m151a());
                } else if (m145a == 18) {
                    a(bVar.m148a());
                } else if (m145a == 26) {
                    b(bVar.m148a());
                } else if (m145a == 34) {
                    c(bVar.m148a());
                } else if (!a(bVar, m145a)) {
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
                cVar.m188a(1, a());
            }
            if (m257c()) {
                cVar.m187a(2, a());
            }
            if (d()) {
                cVar.m187a(3, b());
            }
            if (e()) {
                cVar.m187a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f270b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m257c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f38300a = a2;
            return a2;
        }

        public d b(String str) {
            this.f38303d = true;
            this.f38301b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f38301b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f269a;
        }

        public d c(String str) {
            this.f38304e = true;
            this.f38302c = str;
            return this;
        }

        public String c() {
            return this.f38302c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m257c() {
            return this.f271c;
        }

        public boolean d() {
            return this.f38303d;
        }

        public boolean e() {
            return this.f38304e;
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
        public boolean f38311g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38312h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f38313i;
        public boolean j;

        /* renamed from: a  reason: collision with root package name */
        public int f38305a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f273a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f275b = "";

        /* renamed from: c  reason: collision with other field name */
        public String f277c = "";

        /* renamed from: b  reason: collision with root package name */
        public int f38306b = 0;

        /* renamed from: d  reason: collision with other field name */
        public String f279d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f38309e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f38310f = "";

        /* renamed from: a  reason: collision with other field name */
        public b f272a = null;

        /* renamed from: c  reason: collision with root package name */
        public int f38307c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f38308d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38308d < 0) {
                b();
            }
            return this.f38308d;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f272a;
        }

        public e a(int i2) {
            this.f274a = true;
            this.f38305a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m148a());
                        break;
                    case 26:
                        b(bVar.m148a());
                        break;
                    case 34:
                        c(bVar.m148a());
                        break;
                    case 40:
                        b(bVar.m154b());
                        break;
                    case 50:
                        d(bVar.m148a());
                        break;
                    case 58:
                        e(bVar.m148a());
                        break;
                    case 66:
                        f(bVar.m148a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m154b());
                        break;
                    default:
                        if (a(bVar, m145a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(b bVar) {
            if (bVar != null) {
                this.f38313i = true;
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
                cVar.m196b(1, c());
            }
            if (b()) {
                cVar.m187a(2, a());
            }
            if (m259c()) {
                cVar.m187a(3, b());
            }
            if (m261d()) {
                cVar.m187a(4, m258c());
            }
            if (m263e()) {
                cVar.m183a(5, d());
            }
            if (m264f()) {
                cVar.m187a(6, m260d());
            }
            if (g()) {
                cVar.m187a(7, m262e());
            }
            if (h()) {
                cVar.m187a(8, f());
            }
            if (i()) {
                cVar.m186a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m183a(10, e());
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
            if (m259c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m261d()) {
                b2 += com.xiaomi.push.c.a(4, m258c());
            }
            if (m263e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m264f()) {
                b2 += com.xiaomi.push.c.a(6, m260d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m262e());
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
            this.f38308d = b2;
            return b2;
        }

        public e b(int i2) {
            this.f281e = true;
            this.f38306b = i2;
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
            return this.f38305a;
        }

        public e c(int i2) {
            this.j = true;
            this.f38307c = i2;
            return this;
        }

        public e c(String str) {
            this.f280d = true;
            this.f277c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m258c() {
            return this.f277c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m259c() {
            return this.f278c;
        }

        public int d() {
            return this.f38306b;
        }

        public e d(String str) {
            this.f282f = true;
            this.f279d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m260d() {
            return this.f279d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m261d() {
            return this.f280d;
        }

        public int e() {
            return this.f38307c;
        }

        public e e(String str) {
            this.f38311g = true;
            this.f38309e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m262e() {
            return this.f38309e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m263e() {
            return this.f281e;
        }

        public e f(String str) {
            this.f38312h = true;
            this.f38310f = str;
            return this;
        }

        public String f() {
            return this.f38310f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m264f() {
            return this.f282f;
        }

        public boolean g() {
            return this.f38311g;
        }

        public boolean h() {
            return this.f38312h;
        }

        public boolean i() {
            return this.f38313i;
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
        public boolean f38316c;

        /* renamed from: a  reason: collision with other field name */
        public String f284a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f38315b = "";

        /* renamed from: a  reason: collision with other field name */
        public b f283a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f38314a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38314a < 0) {
                b();
            }
            return this.f38314a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f283a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 10) {
                    a(bVar.m148a());
                } else if (m145a == 18) {
                    b(bVar.m148a());
                } else if (m145a == 26) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m145a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            if (bVar != null) {
                this.f38316c = true;
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
                cVar.m187a(1, a());
            }
            if (b()) {
                cVar.m187a(2, b());
            }
            if (c()) {
                cVar.m186a(3, (com.xiaomi.push.e) a());
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
            this.f38314a = a2;
            return a2;
        }

        public f b(String str) {
            this.f286b = true;
            this.f38315b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f38315b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f286b;
        }

        public boolean c() {
            return this.f38316c;
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
        public String f38318b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f38319c = "";

        /* renamed from: a  reason: collision with root package name */
        public int f38317a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38317a < 0) {
                b();
            }
            return this.f38317a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 10) {
                    a(bVar.m148a());
                } else if (m145a == 18) {
                    b(bVar.m148a());
                } else if (m145a == 26) {
                    c(bVar.m148a());
                } else if (!a(bVar, m145a)) {
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
                cVar.m187a(1, a());
            }
            if (b()) {
                cVar.m187a(2, b());
            }
            if (m265c()) {
                cVar.m187a(3, c());
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
            if (m265c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f38317a = a2;
            return a2;
        }

        public g b(String str) {
            this.f289b = true;
            this.f38318b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f38318b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f289b;
        }

        public g c(String str) {
            this.f290c = true;
            this.f38319c = str;
            return this;
        }

        public String c() {
            return this.f38319c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m265c() {
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
        public int f38320a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f291a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f38321b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38321b < 0) {
                b();
            }
            return this.f38321b;
        }

        public h a(int i2) {
            this.f292a = true;
            this.f38320a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 8) {
                    a(bVar.m154b());
                } else if (m145a == 18) {
                    a(bVar.m148a());
                } else if (!a(bVar, m145a)) {
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
                cVar.m183a(1, c());
            }
            if (b()) {
                cVar.m187a(2, a());
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
            this.f38321b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f293b;
        }

        public int c() {
            return this.f38320a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f295a;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f294a = com.xiaomi.push.a.f38113a;

        /* renamed from: a  reason: collision with root package name */
        public int f38322a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38322a < 0) {
                b();
            }
            return this.f38322a;
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
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 10) {
                    a(bVar.m147a());
                } else if (!a(bVar, m145a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m185a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f38322a = a2;
            return a2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f298a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38324b;

        /* renamed from: a  reason: collision with other field name */
        public com.xiaomi.push.a f296a = com.xiaomi.push.a.f38113a;

        /* renamed from: a  reason: collision with other field name */
        public b f297a = null;

        /* renamed from: a  reason: collision with root package name */
        public int f38323a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38323a < 0) {
                b();
            }
            return this.f38323a;
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
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 10) {
                    a(bVar.m147a());
                } else if (m145a == 18) {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                } else if (!a(bVar, m145a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            if (bVar != null) {
                this.f38324b = true;
                this.f297a = bVar;
                return this;
            }
            throw null;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m186a(2, (com.xiaomi.push.e) a());
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
            this.f38323a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f38324b;
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f301a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f304b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38327c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38328d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38329e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38331g;

        /* renamed from: a  reason: collision with other field name */
        public String f300a = "";

        /* renamed from: b  reason: collision with other field name */
        public String f303b = "";

        /* renamed from: a  reason: collision with other field name */
        public long f299a = 0;

        /* renamed from: b  reason: collision with other field name */
        public long f302b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38330f = false;

        /* renamed from: a  reason: collision with root package name */
        public int f38325a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f38326b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f38326b < 0) {
                b();
            }
            return this.f38326b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f299a;
        }

        public k a(int i2) {
            this.f38331g = true;
            this.f38325a = i2;
            return this;
        }

        public k a(long j) {
            this.f38327c = true;
            this.f299a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                if (m145a == 0) {
                    return this;
                }
                if (m145a == 10) {
                    a(bVar.m148a());
                } else if (m145a == 18) {
                    b(bVar.m148a());
                } else if (m145a == 24) {
                    a(bVar.m146a());
                } else if (m145a == 32) {
                    b(bVar.m146a());
                } else if (m145a == 40) {
                    a(bVar.m151a());
                } else if (m145a == 48) {
                    a(bVar.m154b());
                } else if (!a(bVar, m145a)) {
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
            this.f38329e = true;
            this.f38330f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f300a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m187a(1, a());
            }
            if (b()) {
                cVar.m187a(2, b());
            }
            if (m266c()) {
                cVar.m184a(3, a());
            }
            if (d()) {
                cVar.m184a(4, b());
            }
            if (f()) {
                cVar.m188a(5, e());
            }
            if (g()) {
                cVar.m183a(6, c());
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
            if (m266c()) {
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
            this.f38326b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f302b;
        }

        public k b(long j) {
            this.f38328d = true;
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
            return this.f38325a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m266c() {
            return this.f38327c;
        }

        public boolean d() {
            return this.f38328d;
        }

        public boolean e() {
            return this.f38330f;
        }

        public boolean f() {
            return this.f38329e;
        }

        public boolean g() {
            return this.f38331g;
        }
    }
}
