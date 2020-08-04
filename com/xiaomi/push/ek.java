package com.xiaomi.push;
/* loaded from: classes9.dex */
public final class ek {

    /* loaded from: classes9.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f245a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f247b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f249c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f251d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f253e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f254f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f243a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f244a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f246b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f248c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f250d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f252e = "";
        private int b = 1;
        private int c = 0;
        private int d = 0;
        private String f = "";
        private int e = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f243a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m148b());
                        break;
                    case 16:
                        a(bVar.m149b());
                        break;
                    case 26:
                        a(bVar.m142a());
                        break;
                    case 34:
                        b(bVar.m142a());
                        break;
                    case 42:
                        c(bVar.m142a());
                        break;
                    case 50:
                        d(bVar.m142a());
                        break;
                    case 58:
                        e(bVar.m142a());
                        break;
                    case 64:
                        b(bVar.m148b());
                        break;
                    case 72:
                        c(bVar.m148b());
                        break;
                    case 80:
                        d(bVar.m148b());
                        break;
                    case 90:
                        f(bVar.m142a());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f249c = true;
            this.f244a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f244a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m173a(1, c());
            }
            if (b()) {
                cVar.m187b(2, a());
            }
            if (m237c()) {
                cVar.m177a(3, a());
            }
            if (m239d()) {
                cVar.m177a(4, b());
            }
            if (m241e()) {
                cVar.m177a(5, m236c());
            }
            if (m243f()) {
                cVar.m177a(6, m238d());
            }
            if (g()) {
                cVar.m177a(7, m240e());
            }
            if (h()) {
                cVar.m173a(8, d());
            }
            if (i()) {
                cVar.m173a(9, e());
            }
            if (j()) {
                cVar.m173a(10, f());
            }
            if (k()) {
                cVar.m177a(11, m242f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f245a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.b(2, a());
            }
            if (m237c()) {
                a += com.xiaomi.push.c.a(3, a());
            }
            if (m239d()) {
                a += com.xiaomi.push.c.a(4, b());
            }
            if (m241e()) {
                a += com.xiaomi.push.c.a(5, m236c());
            }
            if (m243f()) {
                a += com.xiaomi.push.c.a(6, m238d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m240e());
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
                a += com.xiaomi.push.c.a(11, m242f());
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

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f246b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
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
        public String m236c() {
            return this.f248c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m237c() {
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
        public String m238d() {
            return this.f250d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m239d() {
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
        public String m240e() {
            return this.f252e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m241e() {
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
        public String m242f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m243f() {
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

    /* loaded from: classes9.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f255a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f257c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f258d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f256b = false;
        private int a = 0;
        private int b = 0;
        private int c = 0;
        private int d = -1;

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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m145a());
                        break;
                    case 24:
                        a(bVar.m148b());
                        break;
                    case 32:
                        b(bVar.m148b());
                        break;
                    case 40:
                        c(bVar.m148b());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f255a = true;
            this.f256b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m178a(1, a());
            }
            if (m244c()) {
                cVar.m173a(3, c());
            }
            if (m245d()) {
                cVar.m173a(4, d());
            }
            if (m246e()) {
                cVar.m173a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f256b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m244c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m245d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m246e()) {
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

        @Override // com.xiaomi.push.e
        public boolean b() {
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
        public boolean m244c() {
            return this.f257c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m245d() {
            return this.f258d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m246e() {
            return this.e;
        }
    }

    /* loaded from: classes9.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f260a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f261b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f262c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f263d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f264e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f265f;

        /* renamed from: a  reason: collision with other field name */
        private String f259a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private int a = -1;

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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m142a());
                        break;
                    case 18:
                        b(bVar.m142a());
                        break;
                    case 26:
                        c(bVar.m142a());
                        break;
                    case 34:
                        d(bVar.m142a());
                        break;
                    case 42:
                        e(bVar.m142a());
                        break;
                    case 50:
                        f(bVar.m142a());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f260a = true;
            this.f259a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m177a(1, a());
            }
            if (b()) {
                cVar.m177a(2, b());
            }
            if (m247c()) {
                cVar.m177a(3, c());
            }
            if (m248d()) {
                cVar.m177a(4, d());
            }
            if (m249e()) {
                cVar.m177a(5, e());
            }
            if (m250f()) {
                cVar.m177a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f260a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m247c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m248d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m249e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m250f()) {
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

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
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
        public boolean m247c() {
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
        public boolean m248d() {
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
        public boolean m249e() {
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
        public boolean m250f() {
            return this.f265f;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f267a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f269c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f268b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f266a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m145a());
                        break;
                    case 18:
                        a(bVar.m142a());
                        break;
                    case 26:
                        b(bVar.m142a());
                        break;
                    case 34:
                        c(bVar.m142a());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
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

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f266a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m178a(1, a());
            }
            if (m251c()) {
                cVar.m177a(2, a());
            }
            if (d()) {
                cVar.m177a(3, b());
            }
            if (e()) {
                cVar.m177a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f268b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m251c()) {
                a += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(3, b());
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

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
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
        public boolean m251c() {
            return this.f269c;
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
        private boolean f272a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f274b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f276c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f278d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f279e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f280f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f271a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f273b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f275c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f277d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f270a = null;
        private int c = 0;
        private int d = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        @Override // com.xiaomi.push.e
        public b a() {
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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m142a());
                        break;
                    case 26:
                        b(bVar.m142a());
                        break;
                    case 34:
                        c(bVar.m142a());
                        break;
                    case 40:
                        b(bVar.m148b());
                        break;
                    case 50:
                        d(bVar.m142a());
                        break;
                    case 58:
                        e(bVar.m142a());
                        break;
                    case 66:
                        f(bVar.m142a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m148b());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public e a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException();
            }
            this.i = true;
            this.f270a = bVar;
            return this;
        }

        public e a(String str) {
            this.f274b = true;
            this.f271a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f271a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m186b(1, c());
            }
            if (b()) {
                cVar.m177a(2, a());
            }
            if (m253c()) {
                cVar.m177a(3, b());
            }
            if (m255d()) {
                cVar.m177a(4, m252c());
            }
            if (m257e()) {
                cVar.m173a(5, d());
            }
            if (m258f()) {
                cVar.m177a(6, m254d());
            }
            if (g()) {
                cVar.m177a(7, m256e());
            }
            if (h()) {
                cVar.m177a(8, f());
            }
            if (i()) {
                cVar.m176a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m173a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f272a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m253c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m255d()) {
                b += com.xiaomi.push.c.a(4, m252c());
            }
            if (m257e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m258f()) {
                b += com.xiaomi.push.c.a(6, m254d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m256e());
            }
            if (h()) {
                b += com.xiaomi.push.c.a(8, f());
            }
            if (i()) {
                b += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) a());
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

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f273b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
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
        public String m252c() {
            return this.f275c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m253c() {
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
        public String m254d() {
            return this.f277d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m255d() {
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
        public String m256e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m257e() {
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
        public boolean m258f() {
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

    /* loaded from: classes9.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f283a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f284b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f282a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f281a = null;
        private int a = -1;

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

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f281a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m142a());
                        break;
                    case 18:
                        b(bVar.m142a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public f a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException();
            }
            this.c = true;
            this.f281a = bVar;
            return this;
        }

        public f a(String str) {
            this.f283a = true;
            this.f282a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f282a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m177a(1, a());
            }
            if (b()) {
                cVar.m177a(2, b());
            }
            if (c()) {
                cVar.m176a(3, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f283a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (c()) {
                a += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) a());
            }
            this.a = a;
            return a;
        }

        public f b(String str) {
            this.f284b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f284b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes9.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f286a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f287b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f288c;

        /* renamed from: a  reason: collision with other field name */
        private String f285a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m142a());
                        break;
                    case 18:
                        b(bVar.m142a());
                        break;
                    case 26:
                        c(bVar.m142a());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f286a = true;
            this.f285a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f285a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m177a(1, a());
            }
            if (b()) {
                cVar.m177a(2, b());
            }
            if (m259c()) {
                cVar.m177a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f286a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m259c()) {
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

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
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
        public boolean m259c() {
            return this.f288c;
        }
    }

    /* loaded from: classes9.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f290a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f291b;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f289a = "";
        private int b = -1;

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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m148b());
                        break;
                    case 18:
                        a(bVar.m142a());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f291b = true;
            this.f289a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f289a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m173a(1, c());
            }
            if (b()) {
                cVar.m177a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f290a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, a());
            }
            this.b = a;
            return a;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f291b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes9.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f293a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f292a = com.xiaomi.push.a.a;
        private int a = -1;

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

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m141a());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m175a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f293a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes9.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f296a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f294a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f295a = null;
        private int a = -1;

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

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f294a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m141a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public j a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException();
            }
            this.b = true;
            this.f295a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m175a(1, a());
            }
            if (b()) {
                cVar.m176a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f296a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
            }
            this.a = a;
            return a;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.b;
        }
    }

    /* loaded from: classes9.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f299a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f302b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f298a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f301b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f297a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f300b = 0;
        private boolean f = false;
        private int a = 0;
        private int b = -1;

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

        @Override // com.xiaomi.push.e
        public long a() {
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
                int m139a = bVar.m139a();
                switch (m139a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m142a());
                        break;
                    case 18:
                        b(bVar.m142a());
                        break;
                    case 24:
                        a(bVar.m140a());
                        break;
                    case 32:
                        b(bVar.m140a());
                        break;
                    case 40:
                        a(bVar.m145a());
                        break;
                    case 48:
                        a(bVar.m148b());
                        break;
                    default:
                        if (!a(bVar, m139a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
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

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f298a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m177a(1, a());
            }
            if (b()) {
                cVar.m177a(2, b());
            }
            if (m260c()) {
                cVar.m174a(3, a());
            }
            if (d()) {
                cVar.m174a(4, b());
            }
            if (f()) {
                cVar.m178a(5, e());
            }
            if (g()) {
                cVar.m173a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f299a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m260c()) {
                a += com.xiaomi.push.c.a(3, a());
            }
            if (d()) {
                a += com.xiaomi.push.c.a(4, b());
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

        @Override // com.xiaomi.push.e
        public long b() {
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

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f301b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f302b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m260c() {
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
