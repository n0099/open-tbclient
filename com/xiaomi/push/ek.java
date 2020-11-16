package com.xiaomi.push;
/* loaded from: classes18.dex */
public final class ek {

    /* loaded from: classes18.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f243a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f245b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f247c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f249d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f251e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f252f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        /* renamed from: a  reason: collision with root package name */
        private int f4878a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f241a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f242a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f244b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f246c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f248d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f250e = "";
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
            return this.f241a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f252f = false;
            this.f248d = "";
            return this;
        }

        public a a(int i) {
            this.f243a = true;
            this.f4878a = i;
            return this;
        }

        public a a(long j) {
            this.f245b = true;
            this.f241a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m156b());
                        break;
                    case 16:
                        a(bVar.m157b());
                        break;
                    case 26:
                        a(bVar.m150a());
                        break;
                    case 34:
                        b(bVar.m150a());
                        break;
                    case 42:
                        c(bVar.m150a());
                        break;
                    case 50:
                        d(bVar.m150a());
                        break;
                    case 58:
                        e(bVar.m150a());
                        break;
                    case 64:
                        b(bVar.m156b());
                        break;
                    case 72:
                        c(bVar.m156b());
                        break;
                    case 80:
                        d(bVar.m156b());
                        break;
                    case 90:
                        f(bVar.m150a());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f247c = true;
            this.f242a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f242a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m181a(1, c());
            }
            if (b()) {
                cVar.m195b(2, a());
            }
            if (m245c()) {
                cVar.m185a(3, a());
            }
            if (m247d()) {
                cVar.m185a(4, b());
            }
            if (m249e()) {
                cVar.m185a(5, m244c());
            }
            if (m251f()) {
                cVar.m185a(6, m246d());
            }
            if (g()) {
                cVar.m185a(7, m248e());
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
                cVar.m185a(11, m250f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f243a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.b(2, a());
            }
            if (m245c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m247d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m249e()) {
                a2 += com.xiaomi.push.c.a(5, m244c());
            }
            if (m251f()) {
                a2 += com.xiaomi.push.c.a(6, m246d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m248e());
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
                a2 += com.xiaomi.push.c.a(11, m250f());
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
            this.f249d = true;
            this.f244b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f244b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f245b;
        }

        public int c() {
            return this.f4878a;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a c(String str) {
            this.f251e = true;
            this.f246c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m244c() {
            return this.f246c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m245c() {
            return this.f247c;
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
            this.f252f = true;
            this.f248d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m246d() {
            return this.f248d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m247d() {
            return this.f249d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f250e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m248e() {
            return this.f250e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m249e() {
            return this.f251e;
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
        public String m250f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m251f() {
            return this.f252f;
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

    /* loaded from: classes18.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f253a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f255c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f256d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f254b = false;

        /* renamed from: a  reason: collision with root package name */
        private int f4879a = 0;
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
            this.f255c = true;
            this.f4879a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m153a());
                        break;
                    case 24:
                        a(bVar.m156b());
                        break;
                    case 32:
                        b(bVar.m156b());
                        break;
                    case 40:
                        c(bVar.m156b());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f253a = true;
            this.f254b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m186a(1, a());
            }
            if (m252c()) {
                cVar.m181a(3, c());
            }
            if (m253d()) {
                cVar.m181a(4, d());
            }
            if (m254e()) {
                cVar.m181a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f254b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m252c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m253d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m254e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.d = a2;
            return a2;
        }

        public b b(int i) {
            this.f256d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f253a;
        }

        public int c() {
            return this.f4879a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m252c() {
            return this.f255c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m253d() {
            return this.f256d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m254e() {
            return this.e;
        }
    }

    /* loaded from: classes18.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f258a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f259b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f260c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f261d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f262e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f263f;

        /* renamed from: a  reason: collision with other field name */
        private String f257a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with root package name */
        private int f4880a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4880a < 0) {
                b();
            }
            return this.f4880a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m150a());
                        break;
                    case 18:
                        b(bVar.m150a());
                        break;
                    case 26:
                        c(bVar.m150a());
                        break;
                    case 34:
                        d(bVar.m150a());
                        break;
                    case 42:
                        e(bVar.m150a());
                        break;
                    case 50:
                        f(bVar.m150a());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f258a = true;
            this.f257a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f257a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m185a(2, b());
            }
            if (m255c()) {
                cVar.m185a(3, c());
            }
            if (m256d()) {
                cVar.m185a(4, d());
            }
            if (m257e()) {
                cVar.m185a(5, e());
            }
            if (m258f()) {
                cVar.m185a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f258a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m255c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m256d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m257e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m258f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f4880a = a2;
            return a2;
        }

        public c b(String str) {
            this.f259b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f259b;
        }

        public c c(String str) {
            this.f260c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m255c() {
            return this.f260c;
        }

        public c d(String str) {
            this.f261d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m256d() {
            return this.f261d;
        }

        public c e(String str) {
            this.f262e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m257e() {
            return this.f262e;
        }

        public c f(String str) {
            this.f263f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m258f() {
            return this.f263f;
        }
    }

    /* loaded from: classes18.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f265a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f267c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f266b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f264a = "";
        private String b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f4881a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4881a < 0) {
                b();
            }
            return this.f4881a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m153a());
                        break;
                    case 18:
                        a(bVar.m150a());
                        break;
                    case 26:
                        b(bVar.m150a());
                        break;
                    case 34:
                        c(bVar.m150a());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f267c = true;
            this.f264a = str;
            return this;
        }

        public d a(boolean z) {
            this.f265a = true;
            this.f266b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f264a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m186a(1, a());
            }
            if (m259c()) {
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
            return this.f266b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m259c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f4881a = a2;
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
            return this.f265a;
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
        public boolean m259c() {
            return this.f267c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes18.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f270a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f272b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f274c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f276d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f277e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f278f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private int f4882a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f269a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f271b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f273c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f275d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f268a = null;
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
            return this.f268a;
        }

        public e a(int i) {
            this.f270a = true;
            this.f4882a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m150a());
                        break;
                    case 26:
                        b(bVar.m150a());
                        break;
                    case 34:
                        c(bVar.m150a());
                        break;
                    case 40:
                        b(bVar.m156b());
                        break;
                    case 50:
                        d(bVar.m150a());
                        break;
                    case 58:
                        e(bVar.m150a());
                        break;
                    case 66:
                        f(bVar.m150a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m156b());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
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
            this.f268a = bVar;
            return this;
        }

        public e a(String str) {
            this.f272b = true;
            this.f269a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f269a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m194b(1, c());
            }
            if (b()) {
                cVar.m185a(2, a());
            }
            if (m261c()) {
                cVar.m185a(3, b());
            }
            if (m263d()) {
                cVar.m185a(4, m260c());
            }
            if (m265e()) {
                cVar.m181a(5, d());
            }
            if (m266f()) {
                cVar.m185a(6, m262d());
            }
            if (g()) {
                cVar.m185a(7, m264e());
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
            return this.f270a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m261c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m263d()) {
                b += com.xiaomi.push.c.a(4, m260c());
            }
            if (m265e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m266f()) {
                b += com.xiaomi.push.c.a(6, m262d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m264e());
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
            this.f277e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f274c = true;
            this.f271b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f271b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f272b;
        }

        public int c() {
            return this.f4882a;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e c(String str) {
            this.f276d = true;
            this.f273c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m260c() {
            return this.f273c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m261c() {
            return this.f274c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f278f = true;
            this.f275d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m262d() {
            return this.f275d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m263d() {
            return this.f276d;
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
        public String m264e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m265e() {
            return this.f277e;
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
        public boolean m266f() {
            return this.f278f;
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

    /* loaded from: classes18.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f281a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f282b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f280a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f279a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f4883a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4883a < 0) {
                b();
            }
            return this.f4883a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f279a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m150a());
                        break;
                    case 18:
                        b(bVar.m150a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m147a)) {
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
            this.f279a = bVar;
            return this;
        }

        public f a(String str) {
            this.f281a = true;
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
            return this.f281a;
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
            this.f4883a = a2;
            return a2;
        }

        public f b(String str) {
            this.f282b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f282b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes18.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f284a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f285b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f286c;

        /* renamed from: a  reason: collision with other field name */
        private String f283a = "";
        private String b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f4884a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4884a < 0) {
                b();
            }
            return this.f4884a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m150a());
                        break;
                    case 18:
                        b(bVar.m150a());
                        break;
                    case 26:
                        c(bVar.m150a());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f284a = true;
            this.f283a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f283a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m185a(2, b());
            }
            if (m267c()) {
                cVar.m185a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m267c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f4884a = a2;
            return a2;
        }

        public g b(String str) {
            this.f285b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f285b;
        }

        public g c(String str) {
            this.f286c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m267c() {
            return this.f286c;
        }
    }

    /* loaded from: classes18.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f288a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f289b;

        /* renamed from: a  reason: collision with root package name */
        private int f4885a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f287a = "";
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
            this.f288a = true;
            this.f4885a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m156b());
                        break;
                    case 18:
                        a(bVar.m150a());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f289b = true;
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
                cVar.m181a(1, c());
            }
            if (b()) {
                cVar.m185a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f288a;
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
            return this.f289b;
        }

        public int c() {
            return this.f4885a;
        }
    }

    /* loaded from: classes18.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f291a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f290a = com.xiaomi.push.a.f4785a;

        /* renamed from: a  reason: collision with root package name */
        private int f4886a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4886a < 0) {
                b();
            }
            return this.f4886a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f290a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f291a = true;
            this.f290a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m149a());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
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
                cVar.m183a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f291a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f4886a = a2;
            return a2;
        }
    }

    /* loaded from: classes18.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f294a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f292a = com.xiaomi.push.a.f4785a;

        /* renamed from: a  reason: collision with other field name */
        private b f293a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f4887a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f4887a < 0) {
                b();
            }
            return this.f4887a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f292a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f293a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f294a = true;
            this.f292a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m149a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m147a)) {
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
            this.f293a = bVar;
            return this;
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
            return this.f294a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
            }
            this.f4887a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.b;
        }
    }

    /* loaded from: classes18.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f297a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f300b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f296a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f299b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f295a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f298b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with root package name */
        private int f4888a = 0;
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
            return this.f295a;
        }

        public k a(int i) {
            this.g = true;
            this.f4888a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f295a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m150a());
                        break;
                    case 18:
                        b(bVar.m150a());
                        break;
                    case 24:
                        a(bVar.m148a());
                        break;
                    case 32:
                        b(bVar.m148a());
                        break;
                    case 40:
                        a(bVar.m153a());
                        break;
                    case 48:
                        a(bVar.m156b());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f297a = true;
            this.f296a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f296a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m185a(1, a());
            }
            if (b()) {
                cVar.m185a(2, b());
            }
            if (m268c()) {
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
            return this.f297a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m268c()) {
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
            return this.f298b;
        }

        public k b(long j) {
            this.d = true;
            this.f298b = j;
            return this;
        }

        public k b(String str) {
            this.f300b = true;
            this.f299b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f299b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f300b;
        }

        public int c() {
            return this.f4888a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m268c() {
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
