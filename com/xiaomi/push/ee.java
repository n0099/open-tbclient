package com.xiaomi.push;
/* loaded from: classes8.dex */
public final class ee {

    /* loaded from: classes8.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f254a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f256b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f258c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f260d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f262e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f263f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f252a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f253a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f255b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f257c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f259d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f261e = "";
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
            return this.f252a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f263f = false;
            this.f259d = "";
            return this;
        }

        public a a(int i) {
            this.f254a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f256b = true;
            this.f252a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m143a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f258c = true;
            this.f253a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f253a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m173a(1, c());
            }
            if (b()) {
                cVar.m187b(2, a());
            }
            if (m233c()) {
                cVar.m177a(3, a());
            }
            if (m235d()) {
                cVar.m177a(4, b());
            }
            if (m237e()) {
                cVar.m177a(5, m232c());
            }
            if (m239f()) {
                cVar.m177a(6, m234d());
            }
            if (g()) {
                cVar.m177a(7, m236e());
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
                cVar.m177a(11, m238f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f254a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.b(2, a());
            }
            if (m233c()) {
                a += com.xiaomi.push.c.a(3, a());
            }
            if (m235d()) {
                a += com.xiaomi.push.c.a(4, b());
            }
            if (m237e()) {
                a += com.xiaomi.push.c.a(5, m232c());
            }
            if (m239f()) {
                a += com.xiaomi.push.c.a(6, m234d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m236e());
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
                a += com.xiaomi.push.c.a(11, m238f());
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
            this.f260d = true;
            this.f255b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f255b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f256b;
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
            this.f262e = true;
            this.f257c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m232c() {
            return this.f257c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m233c() {
            return this.f258c;
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
            this.f263f = true;
            this.f259d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m234d() {
            return this.f259d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m235d() {
            return this.f260d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f261e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m236e() {
            return this.f261e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m237e() {
            return this.f262e;
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
        public String m238f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m239f() {
            return this.f263f;
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

    /* loaded from: classes8.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f264a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f266c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f267d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f265b = false;
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
            this.f266c = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m149a());
                        break;
                    case 24:
                        a(bVar.m152b());
                        break;
                    case 32:
                        b(bVar.m152b());
                        break;
                    case 40:
                        c(bVar.m152b());
                        break;
                    default:
                        if (!a(bVar, m143a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f264a = true;
            this.f265b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m178a(1, a());
            }
            if (m240c()) {
                cVar.m173a(3, c());
            }
            if (m241d()) {
                cVar.m173a(4, d());
            }
            if (m242e()) {
                cVar.m173a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f265b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m240c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m241d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m242e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f267d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f264a;
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
        public boolean m240c() {
            return this.f266c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m241d() {
            return this.f267d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m242e() {
            return this.e;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f269a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f270b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f271c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f272d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f273e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f274f;

        /* renamed from: a  reason: collision with other field name */
        private String f268a = "";
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
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m146a());
                        break;
                    case 18:
                        b(bVar.m146a());
                        break;
                    case 26:
                        c(bVar.m146a());
                        break;
                    case 34:
                        d(bVar.m146a());
                        break;
                    case 42:
                        e(bVar.m146a());
                        break;
                    case 50:
                        f(bVar.m146a());
                        break;
                    default:
                        if (!a(bVar, m143a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f269a = true;
            this.f268a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f268a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m177a(1, a());
            }
            if (b()) {
                cVar.m177a(2, b());
            }
            if (m243c()) {
                cVar.m177a(3, c());
            }
            if (m244d()) {
                cVar.m177a(4, d());
            }
            if (m245e()) {
                cVar.m177a(5, e());
            }
            if (m246f()) {
                cVar.m177a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f269a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m243c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m244d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m245e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m246f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f270b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f270b;
        }

        public c c(String str) {
            this.f271c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m243c() {
            return this.f271c;
        }

        public c d(String str) {
            this.f272d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m244d() {
            return this.f272d;
        }

        public c e(String str) {
            this.f273e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m245e() {
            return this.f273e;
        }

        public c f(String str) {
            this.f274f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m246f() {
            return this.f274f;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f276a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f278c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f277b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f275a = "";
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
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m149a());
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
                    default:
                        if (!a(bVar, m143a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f278c = true;
            this.f275a = str;
            return this;
        }

        public d a(boolean z) {
            this.f276a = true;
            this.f277b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f275a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m178a(1, a());
            }
            if (m247c()) {
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
            return this.f277b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m247c()) {
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
            return this.f276a;
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
        public boolean m247c() {
            return this.f278c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f281a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f283b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f285c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f287d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f288e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f289f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f280a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f282b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f284c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f286d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f279a = null;
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
            return this.f279a;
        }

        public e a(int i) {
            this.f281a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m143a)) {
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
            this.f279a = bVar;
            return this;
        }

        public e a(String str) {
            this.f283b = true;
            this.f280a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f280a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m186b(1, c());
            }
            if (b()) {
                cVar.m177a(2, a());
            }
            if (m249c()) {
                cVar.m177a(3, b());
            }
            if (m251d()) {
                cVar.m177a(4, m248c());
            }
            if (m253e()) {
                cVar.m173a(5, d());
            }
            if (m254f()) {
                cVar.m177a(6, m250d());
            }
            if (g()) {
                cVar.m177a(7, m252e());
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
            return this.f281a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m249c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m251d()) {
                b += com.xiaomi.push.c.a(4, m248c());
            }
            if (m253e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m254f()) {
                b += com.xiaomi.push.c.a(6, m250d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m252e());
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
            this.f288e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f285c = true;
            this.f282b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f282b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f283b;
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
            this.f287d = true;
            this.f284c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m248c() {
            return this.f284c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m249c() {
            return this.f285c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f289f = true;
            this.f286d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m250d() {
            return this.f286d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m251d() {
            return this.f287d;
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
        public String m252e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m253e() {
            return this.f288e;
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
        public boolean m254f() {
            return this.f289f;
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

    /* loaded from: classes8.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f292a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f293b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f291a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f290a = null;
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
            return this.f290a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m146a());
                        break;
                    case 18:
                        b(bVar.m146a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m143a)) {
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
            this.f290a = bVar;
            return this;
        }

        public f a(String str) {
            this.f292a = true;
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
            return this.f292a;
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
            this.f293b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f293b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes8.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f295a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f296b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f297c;

        /* renamed from: a  reason: collision with other field name */
        private String f294a = "";
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
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m146a());
                        break;
                    case 18:
                        b(bVar.m146a());
                        break;
                    case 26:
                        c(bVar.m146a());
                        break;
                    default:
                        if (!a(bVar, m143a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f295a = true;
            this.f294a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f294a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m177a(1, a());
            }
            if (b()) {
                cVar.m177a(2, b());
            }
            if (m255c()) {
                cVar.m177a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m255c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
            this.f296b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f296b;
        }

        public g c(String str) {
            this.f297c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m255c() {
            return this.f297c;
        }
    }

    /* loaded from: classes8.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f299a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f300b;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f298a = "";
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
            this.f299a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m152b());
                        break;
                    case 18:
                        a(bVar.m146a());
                        break;
                    default:
                        if (!a(bVar, m143a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f300b = true;
            this.f298a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f298a;
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
            return this.f299a;
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
            return this.f300b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes8.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f302a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f301a = com.xiaomi.push.a.a;
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
            return this.f301a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f302a = true;
            this.f301a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m145a());
                        break;
                    default:
                        if (!a(bVar, m143a)) {
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
            return this.f302a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes8.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f305a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f303a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f304a = null;
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
            return this.f303a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f304a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f305a = true;
            this.f303a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m145a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m143a)) {
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
            this.f304a = bVar;
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
            return this.f305a;
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

    /* loaded from: classes8.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f308a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f311b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f307a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f310b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f306a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f309b = 0;
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
            return this.f306a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f306a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                switch (m143a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m146a());
                        break;
                    case 18:
                        b(bVar.m146a());
                        break;
                    case 24:
                        a(bVar.m144a());
                        break;
                    case 32:
                        b(bVar.m144a());
                        break;
                    case 40:
                        a(bVar.m149a());
                        break;
                    case 48:
                        a(bVar.m152b());
                        break;
                    default:
                        if (!a(bVar, m143a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f308a = true;
            this.f307a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f307a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m177a(1, a());
            }
            if (b()) {
                cVar.m177a(2, b());
            }
            if (m256c()) {
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
            return this.f308a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m256c()) {
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
            return this.f309b;
        }

        public k b(long j) {
            this.d = true;
            this.f309b = j;
            return this;
        }

        public k b(String str) {
            this.f311b = true;
            this.f310b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f310b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f311b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m256c() {
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
