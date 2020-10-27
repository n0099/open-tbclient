package com.xiaomi.push;
/* loaded from: classes12.dex */
public final class ek {

    /* loaded from: classes12.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f238a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f240b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f242c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f244d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f246e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f247f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        /* renamed from: a  reason: collision with root package name */
        private int f4876a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f236a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f237a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f239b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f241c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f243d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f245e = "";
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
            return this.f236a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f247f = false;
            this.f243d = "";
            return this;
        }

        public a a(int i) {
            this.f238a = true;
            this.f4876a = i;
            return this;
        }

        public a a(long j) {
            this.f240b = true;
            this.f236a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m144a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f242c = true;
            this.f237a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f237a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m178a(1, c());
            }
            if (b()) {
                cVar.m192b(2, a());
            }
            if (m242c()) {
                cVar.m182a(3, a());
            }
            if (m244d()) {
                cVar.m182a(4, b());
            }
            if (m246e()) {
                cVar.m182a(5, m241c());
            }
            if (m248f()) {
                cVar.m182a(6, m243d());
            }
            if (g()) {
                cVar.m182a(7, m245e());
            }
            if (h()) {
                cVar.m178a(8, d());
            }
            if (i()) {
                cVar.m178a(9, e());
            }
            if (j()) {
                cVar.m178a(10, f());
            }
            if (k()) {
                cVar.m182a(11, m247f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f238a;
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
            this.e = a2;
            return a2;
        }

        public a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public a b(String str) {
            this.f244d = true;
            this.f239b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f239b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f240b;
        }

        public int c() {
            return this.f4876a;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a c(String str) {
            this.f246e = true;
            this.f241c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m241c() {
            return this.f241c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m242c() {
            return this.f242c;
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
            this.f247f = true;
            this.f243d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m243d() {
            return this.f243d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m244d() {
            return this.f244d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f245e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m245e() {
            return this.f245e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m246e() {
            return this.f246e;
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
        public String m247f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m248f() {
            return this.f247f;
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

    /* loaded from: classes12.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f248a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f250c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f251d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f249b = false;

        /* renamed from: a  reason: collision with root package name */
        private int f4877a = 0;
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
            this.f250c = true;
            this.f4877a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m150a());
                        break;
                    case 24:
                        a(bVar.m153b());
                        break;
                    case 32:
                        b(bVar.m153b());
                        break;
                    case 40:
                        c(bVar.m153b());
                        break;
                    default:
                        if (!a(bVar, m144a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f248a = true;
            this.f249b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m183a(1, a());
            }
            if (m249c()) {
                cVar.m178a(3, c());
            }
            if (m250d()) {
                cVar.m178a(4, d());
            }
            if (m251e()) {
                cVar.m178a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f249b;
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
            this.d = a2;
            return a2;
        }

        public b b(int i) {
            this.f251d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f248a;
        }

        public int c() {
            return this.f4877a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m249c() {
            return this.f250c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m250d() {
            return this.f251d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m251e() {
            return this.e;
        }
    }

    /* loaded from: classes12.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f253a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f254b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f255c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f256d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f257e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f258f;

        /* renamed from: a  reason: collision with other field name */
        private String f252a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with root package name */
        private int f4878a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4878a < 0) {
                b();
            }
            return this.f4878a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m147a());
                        break;
                    case 18:
                        b(bVar.m147a());
                        break;
                    case 26:
                        c(bVar.m147a());
                        break;
                    case 34:
                        d(bVar.m147a());
                        break;
                    case 42:
                        e(bVar.m147a());
                        break;
                    case 50:
                        f(bVar.m147a());
                        break;
                    default:
                        if (!a(bVar, m144a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f253a = true;
            this.f252a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f252a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m182a(1, a());
            }
            if (b()) {
                cVar.m182a(2, b());
            }
            if (m252c()) {
                cVar.m182a(3, c());
            }
            if (m253d()) {
                cVar.m182a(4, d());
            }
            if (m254e()) {
                cVar.m182a(5, e());
            }
            if (m255f()) {
                cVar.m182a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f253a;
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
            this.f4878a = a2;
            return a2;
        }

        public c b(String str) {
            this.f254b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f254b;
        }

        public c c(String str) {
            this.f255c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m252c() {
            return this.f255c;
        }

        public c d(String str) {
            this.f256d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m253d() {
            return this.f256d;
        }

        public c e(String str) {
            this.f257e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m254e() {
            return this.f257e;
        }

        public c f(String str) {
            this.f258f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m255f() {
            return this.f258f;
        }
    }

    /* loaded from: classes12.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f260a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f262c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f261b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f259a = "";
        private String b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f4879a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4879a < 0) {
                b();
            }
            return this.f4879a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m150a());
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
                    default:
                        if (!a(bVar, m144a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f262c = true;
            this.f259a = str;
            return this;
        }

        public d a(boolean z) {
            this.f260a = true;
            this.f261b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m183a(1, a());
            }
            if (m256c()) {
                cVar.m182a(2, a());
            }
            if (d()) {
                cVar.m182a(3, b());
            }
            if (e()) {
                cVar.m182a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f261b;
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
            this.f4879a = a2;
            return a2;
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
            return this.f260a;
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
        public boolean m256c() {
            return this.f262c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes12.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f265a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f267b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f269c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f271d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f272e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f273f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private int f4880a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f264a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f266b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f268c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f270d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f263a = null;
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
            return this.f263a;
        }

        public e a(int i) {
            this.f265a = true;
            this.f4880a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m144a)) {
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
            this.f263a = bVar;
            return this;
        }

        public e a(String str) {
            this.f267b = true;
            this.f264a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f264a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m191b(1, c());
            }
            if (b()) {
                cVar.m182a(2, a());
            }
            if (m258c()) {
                cVar.m182a(3, b());
            }
            if (m260d()) {
                cVar.m182a(4, m257c());
            }
            if (m262e()) {
                cVar.m178a(5, d());
            }
            if (m263f()) {
                cVar.m182a(6, m259d());
            }
            if (g()) {
                cVar.m182a(7, m261e());
            }
            if (h()) {
                cVar.m182a(8, f());
            }
            if (i()) {
                cVar.m181a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m178a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f265a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m258c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m260d()) {
                b += com.xiaomi.push.c.a(4, m257c());
            }
            if (m262e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m263f()) {
                b += com.xiaomi.push.c.a(6, m259d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m261e());
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
            this.f272e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f269c = true;
            this.f266b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f266b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f267b;
        }

        public int c() {
            return this.f4880a;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e c(String str) {
            this.f271d = true;
            this.f268c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m257c() {
            return this.f268c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m258c() {
            return this.f269c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f273f = true;
            this.f270d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m259d() {
            return this.f270d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m260d() {
            return this.f271d;
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
        public String m261e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m262e() {
            return this.f272e;
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
        public boolean m263f() {
            return this.f273f;
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

    /* loaded from: classes12.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f276a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f277b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f275a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f274a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f4881a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4881a < 0) {
                b();
            }
            return this.f4881a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f274a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m147a());
                        break;
                    case 18:
                        b(bVar.m147a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m144a)) {
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
            this.f274a = bVar;
            return this;
        }

        public f a(String str) {
            this.f276a = true;
            this.f275a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f275a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m182a(1, a());
            }
            if (b()) {
                cVar.m182a(2, b());
            }
            if (c()) {
                cVar.m181a(3, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f276a;
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
            this.f4881a = a2;
            return a2;
        }

        public f b(String str) {
            this.f277b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f277b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes12.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f279a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f280b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f281c;

        /* renamed from: a  reason: collision with other field name */
        private String f278a = "";
        private String b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f4882a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4882a < 0) {
                b();
            }
            return this.f4882a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m147a());
                        break;
                    case 18:
                        b(bVar.m147a());
                        break;
                    case 26:
                        c(bVar.m147a());
                        break;
                    default:
                        if (!a(bVar, m144a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f279a = true;
            this.f278a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f278a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m182a(1, a());
            }
            if (b()) {
                cVar.m182a(2, b());
            }
            if (m264c()) {
                cVar.m182a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f279a;
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
            this.f4882a = a2;
            return a2;
        }

        public g b(String str) {
            this.f280b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f280b;
        }

        public g c(String str) {
            this.f281c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m264c() {
            return this.f281c;
        }
    }

    /* loaded from: classes12.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f283a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f284b;

        /* renamed from: a  reason: collision with root package name */
        private int f4883a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f282a = "";
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
            this.f283a = true;
            this.f4883a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m153b());
                        break;
                    case 18:
                        a(bVar.m147a());
                        break;
                    default:
                        if (!a(bVar, m144a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f284b = true;
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
                cVar.m178a(1, c());
            }
            if (b()) {
                cVar.m182a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f283a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            this.b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f284b;
        }

        public int c() {
            return this.f4883a;
        }
    }

    /* loaded from: classes12.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f286a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f285a = com.xiaomi.push.a.f4783a;

        /* renamed from: a  reason: collision with root package name */
        private int f4884a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4884a < 0) {
                b();
            }
            return this.f4884a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f285a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f286a = true;
            this.f285a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m146a());
                        break;
                    default:
                        if (!a(bVar, m144a)) {
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
                cVar.m180a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f286a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f4884a = a2;
            return a2;
        }
    }

    /* loaded from: classes12.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f289a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f287a = com.xiaomi.push.a.f4783a;

        /* renamed from: a  reason: collision with other field name */
        private b f288a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f4885a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4885a < 0) {
                b();
            }
            return this.f4885a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f287a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f288a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f289a = true;
            this.f287a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m146a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m144a)) {
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
            this.f288a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m181a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f289a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
            }
            this.f4885a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.b;
        }
    }

    /* loaded from: classes12.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f292a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f295b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f291a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f294b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f290a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f293b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with root package name */
        private int f4886a = 0;
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
            return this.f290a;
        }

        public k a(int i) {
            this.g = true;
            this.f4886a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f290a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                switch (m144a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m147a());
                        break;
                    case 18:
                        b(bVar.m147a());
                        break;
                    case 24:
                        a(bVar.m145a());
                        break;
                    case 32:
                        b(bVar.m145a());
                        break;
                    case 40:
                        a(bVar.m150a());
                        break;
                    case 48:
                        a(bVar.m153b());
                        break;
                    default:
                        if (!a(bVar, m144a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f292a = true;
            this.f291a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f291a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m182a(1, a());
            }
            if (b()) {
                cVar.m182a(2, b());
            }
            if (m265c()) {
                cVar.m179a(3, a());
            }
            if (d()) {
                cVar.m179a(4, b());
            }
            if (f()) {
                cVar.m183a(5, e());
            }
            if (g()) {
                cVar.m178a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f292a;
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
            this.b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f293b;
        }

        public k b(long j) {
            this.d = true;
            this.f293b = j;
            return this;
        }

        public k b(String str) {
            this.f295b = true;
            this.f294b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f294b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f295b;
        }

        public int c() {
            return this.f4886a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m265c() {
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
