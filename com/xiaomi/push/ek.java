package com.xiaomi.push;
/* loaded from: classes7.dex */
public final class ek {

    /* loaded from: classes7.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f242a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f244b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f246c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f248d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f250e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f251f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f240a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f241a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f243b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f245c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f247d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f249e = "";
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
            return this.f240a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f251f = false;
            this.f247d = "";
            return this;
        }

        public a a(int i) {
            this.f242a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f244b = true;
            this.f240a = j;
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
            this.f246c = true;
            this.f241a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f241a;
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
            return this.f242a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.b(2, a());
            }
            if (m242c()) {
                a += com.xiaomi.push.c.a(3, a());
            }
            if (m244d()) {
                a += com.xiaomi.push.c.a(4, b());
            }
            if (m246e()) {
                a += com.xiaomi.push.c.a(5, m241c());
            }
            if (m248f()) {
                a += com.xiaomi.push.c.a(6, m243d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m245e());
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
                a += com.xiaomi.push.c.a(11, m247f());
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
            this.f248d = true;
            this.f243b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f243b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f244b;
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
            this.f250e = true;
            this.f245c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m241c() {
            return this.f245c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m242c() {
            return this.f246c;
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
            this.f251f = true;
            this.f247d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m243d() {
            return this.f247d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m244d() {
            return this.f248d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f249e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m245e() {
            return this.f249e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m246e() {
            return this.f250e;
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
            return this.f251f;
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

    /* loaded from: classes7.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f252a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f254c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f255d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f253b = false;
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
            this.f254c = true;
            this.a = i;
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
            this.f252a = true;
            this.f253b = z;
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
            return this.f253b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m249c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m250d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m251e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f255d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f252a;
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
        public boolean m249c() {
            return this.f254c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m250d() {
            return this.f255d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m251e() {
            return this.e;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f257a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f258b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f259c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f260d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f261e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f262f;

        /* renamed from: a  reason: collision with other field name */
        private String f256a = "";
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
            this.f257a = true;
            this.f256a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f256a;
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
            return this.f257a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m252c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m253d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m254e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m255f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f258b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f258b;
        }

        public c c(String str) {
            this.f259c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m252c() {
            return this.f259c;
        }

        public c d(String str) {
            this.f260d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m253d() {
            return this.f260d;
        }

        public c e(String str) {
            this.f261e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m254e() {
            return this.f261e;
        }

        public c f(String str) {
            this.f262f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m255f() {
            return this.f262f;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f264a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f266c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f265b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f263a = "";
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
            this.f266c = true;
            this.f263a = str;
            return this;
        }

        public d a(boolean z) {
            this.f264a = true;
            this.f265b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f263a;
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
            return this.f265b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m256c()) {
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
            return this.f264a;
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
            return this.f266c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f269a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f271b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f273c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f275d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f276e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f277f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f268a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f270b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f272c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f274d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f267a = null;
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
            return this.f267a;
        }

        public e a(int i) {
            this.f269a = true;
            this.a = i;
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
            this.f267a = bVar;
            return this;
        }

        public e a(String str) {
            this.f271b = true;
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
            return this.f269a;
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
            this.f276e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f273c = true;
            this.f270b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f270b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f271b;
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
            this.f275d = true;
            this.f272c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m257c() {
            return this.f272c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m258c() {
            return this.f273c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f277f = true;
            this.f274d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m259d() {
            return this.f274d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m260d() {
            return this.f275d;
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
            return this.f276e;
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
            return this.f277f;
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

    /* loaded from: classes7.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f280a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f281b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f279a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f278a = null;
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
            return this.f278a;
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
            this.f278a = bVar;
            return this;
        }

        public f a(String str) {
            this.f280a = true;
            this.f279a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f279a;
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
            return this.f280a;
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
            this.f281b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f281b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f283a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f284b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f285c;

        /* renamed from: a  reason: collision with other field name */
        private String f282a = "";
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
            return this.f283a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m264c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
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

        public g c(String str) {
            this.f285c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m264c() {
            return this.f285c;
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f287a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f288b;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f286a = "";
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
            this.f287a = true;
            this.a = i;
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
            this.f288b = true;
            this.f286a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f286a;
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
            return this.f287a;
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
            return this.f288b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f290a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f289a = com.xiaomi.push.a.a;
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
            return this.f289a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f290a = true;
            this.f289a = aVar;
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
            return this.f290a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f293a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f291a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f292a = null;
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
            return this.f291a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f292a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f293a = true;
            this.f291a = aVar;
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
            this.f292a = bVar;
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
            return this.f293a;
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

    /* loaded from: classes7.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f296a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f299b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f295a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f298b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f294a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f297b = 0;
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
            return this.f294a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f294a = j;
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
            this.f296a = true;
            this.f295a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f295a;
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
            return this.f296a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m265c()) {
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
            return this.f297b;
        }

        public k b(long j) {
            this.d = true;
            this.f297b = j;
            return this;
        }

        public k b(String str) {
            this.f299b = true;
            this.f298b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f298b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f299b;
        }

        public int c() {
            return this.a;
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
