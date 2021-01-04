package com.xiaomi.push;
/* loaded from: classes6.dex */
public final class ek {

    /* loaded from: classes6.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f319a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f321b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f323c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f325d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f327e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f328f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        /* renamed from: a  reason: collision with root package name */
        private int f14270a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f317a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f318a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f320b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f322c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f324d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f326e = "";

        /* renamed from: b  reason: collision with root package name */
        private int f14271b = 1;
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
            return this.f317a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f328f = false;
            this.f324d = "";
            return this;
        }

        public a a(int i) {
            this.f319a = true;
            this.f14270a = i;
            return this;
        }

        public a a(long j) {
            this.f321b = true;
            this.f317a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m172b());
                        break;
                    case 16:
                        a(bVar.m173b());
                        break;
                    case 26:
                        a(bVar.m166a());
                        break;
                    case 34:
                        b(bVar.m166a());
                        break;
                    case 42:
                        c(bVar.m166a());
                        break;
                    case 50:
                        d(bVar.m166a());
                        break;
                    case 58:
                        e(bVar.m166a());
                        break;
                    case 64:
                        b(bVar.m172b());
                        break;
                    case 72:
                        c(bVar.m172b());
                        break;
                    case 80:
                        d(bVar.m172b());
                        break;
                    case 90:
                        f(bVar.m166a());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f323c = true;
            this.f318a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f318a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m197a(1, c());
            }
            if (b()) {
                cVar.m211b(2, a());
            }
            if (m261c()) {
                cVar.m201a(3, a());
            }
            if (m263d()) {
                cVar.m201a(4, b());
            }
            if (m265e()) {
                cVar.m201a(5, m260c());
            }
            if (m267f()) {
                cVar.m201a(6, m262d());
            }
            if (g()) {
                cVar.m201a(7, m264e());
            }
            if (h()) {
                cVar.m197a(8, d());
            }
            if (i()) {
                cVar.m197a(9, e());
            }
            if (j()) {
                cVar.m197a(10, f());
            }
            if (k()) {
                cVar.m201a(11, m266f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f319a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.b(2, a());
            }
            if (m261c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m263d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m265e()) {
                a2 += com.xiaomi.push.c.a(5, m260c());
            }
            if (m267f()) {
                a2 += com.xiaomi.push.c.a(6, m262d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m264e());
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
                a2 += com.xiaomi.push.c.a(11, m266f());
            }
            this.e = a2;
            return a2;
        }

        public a b(int i) {
            this.h = true;
            this.f14271b = i;
            return this;
        }

        public a b(String str) {
            this.f325d = true;
            this.f320b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f320b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f321b;
        }

        public int c() {
            return this.f14270a;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a c(String str) {
            this.f327e = true;
            this.f322c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m260c() {
            return this.f322c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m261c() {
            return this.f323c;
        }

        public int d() {
            return this.f14271b;
        }

        public a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        public a d(String str) {
            this.f328f = true;
            this.f324d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m262d() {
            return this.f324d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m263d() {
            return this.f325d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f326e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m264e() {
            return this.f326e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m265e() {
            return this.f327e;
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
        public String m266f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m267f() {
            return this.f328f;
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

    /* loaded from: classes6.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f329a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f331c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f332d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f330b = false;

        /* renamed from: a  reason: collision with root package name */
        private int f14272a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f14273b = 0;
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
            this.f331c = true;
            this.f14272a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m169a());
                        break;
                    case 24:
                        a(bVar.m172b());
                        break;
                    case 32:
                        b(bVar.m172b());
                        break;
                    case 40:
                        c(bVar.m172b());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f329a = true;
            this.f330b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m202a(1, a());
            }
            if (m268c()) {
                cVar.m197a(3, c());
            }
            if (m269d()) {
                cVar.m197a(4, d());
            }
            if (m270e()) {
                cVar.m197a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f330b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m268c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m269d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m270e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.d = a2;
            return a2;
        }

        public b b(int i) {
            this.f332d = true;
            this.f14273b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f329a;
        }

        public int c() {
            return this.f14272a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m268c() {
            return this.f331c;
        }

        public int d() {
            return this.f14273b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m269d() {
            return this.f332d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m270e() {
            return this.e;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f334a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f335b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f336c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f337d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f338e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f339f;

        /* renamed from: a  reason: collision with other field name */
        private String f333a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14275b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with root package name */
        private int f14274a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14274a < 0) {
                b();
            }
            return this.f14274a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m166a());
                        break;
                    case 18:
                        b(bVar.m166a());
                        break;
                    case 26:
                        c(bVar.m166a());
                        break;
                    case 34:
                        d(bVar.m166a());
                        break;
                    case 42:
                        e(bVar.m166a());
                        break;
                    case 50:
                        f(bVar.m166a());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f334a = true;
            this.f333a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f333a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m201a(1, a());
            }
            if (b()) {
                cVar.m201a(2, b());
            }
            if (m271c()) {
                cVar.m201a(3, c());
            }
            if (m272d()) {
                cVar.m201a(4, d());
            }
            if (m273e()) {
                cVar.m201a(5, e());
            }
            if (m274f()) {
                cVar.m201a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f334a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m271c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m272d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m273e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m274f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f14274a = a2;
            return a2;
        }

        public c b(String str) {
            this.f335b = true;
            this.f14275b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14275b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f335b;
        }

        public c c(String str) {
            this.f336c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m271c() {
            return this.f336c;
        }

        public c d(String str) {
            this.f337d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m272d() {
            return this.f337d;
        }

        public c e(String str) {
            this.f338e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m273e() {
            return this.f338e;
        }

        public c f(String str) {
            this.f339f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m274f() {
            return this.f339f;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f341a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f343c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f342b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f340a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14277b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f14276a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14276a < 0) {
                b();
            }
            return this.f14276a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m169a());
                        break;
                    case 18:
                        a(bVar.m166a());
                        break;
                    case 26:
                        b(bVar.m166a());
                        break;
                    case 34:
                        c(bVar.m166a());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f343c = true;
            this.f340a = str;
            return this;
        }

        public d a(boolean z) {
            this.f341a = true;
            this.f342b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f340a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m202a(1, a());
            }
            if (m275c()) {
                cVar.m201a(2, a());
            }
            if (d()) {
                cVar.m201a(3, b());
            }
            if (e()) {
                cVar.m201a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f342b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m275c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f14276a = a2;
            return a2;
        }

        public d b(String str) {
            this.d = true;
            this.f14277b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14277b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f341a;
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
        public boolean m275c() {
            return this.f343c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f346a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f348b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f350c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f352d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f353e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f354f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private int f14278a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f345a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f347b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f349c = "";

        /* renamed from: b  reason: collision with root package name */
        private int f14279b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f351d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f344a = null;
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
            return this.f344a;
        }

        public e a(int i) {
            this.f346a = true;
            this.f14278a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m166a());
                        break;
                    case 26:
                        b(bVar.m166a());
                        break;
                    case 34:
                        c(bVar.m166a());
                        break;
                    case 40:
                        b(bVar.m172b());
                        break;
                    case 50:
                        d(bVar.m166a());
                        break;
                    case 58:
                        e(bVar.m166a());
                        break;
                    case 66:
                        f(bVar.m166a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m172b());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
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
            this.f344a = bVar;
            return this;
        }

        public e a(String str) {
            this.f348b = true;
            this.f345a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f345a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m210b(1, c());
            }
            if (b()) {
                cVar.m201a(2, a());
            }
            if (m277c()) {
                cVar.m201a(3, b());
            }
            if (m279d()) {
                cVar.m201a(4, m276c());
            }
            if (m281e()) {
                cVar.m197a(5, d());
            }
            if (m282f()) {
                cVar.m201a(6, m278d());
            }
            if (g()) {
                cVar.m201a(7, m280e());
            }
            if (h()) {
                cVar.m201a(8, f());
            }
            if (i()) {
                cVar.m200a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m197a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f346a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b2 = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b2 += com.xiaomi.push.c.a(2, a());
            }
            if (m277c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m279d()) {
                b2 += com.xiaomi.push.c.a(4, m276c());
            }
            if (m281e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m282f()) {
                b2 += com.xiaomi.push.c.a(6, m278d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m280e());
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
            this.d = b2;
            return b2;
        }

        public e b(int i) {
            this.f353e = true;
            this.f14279b = i;
            return this;
        }

        public e b(String str) {
            this.f350c = true;
            this.f347b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f347b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f348b;
        }

        public int c() {
            return this.f14278a;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e c(String str) {
            this.f352d = true;
            this.f349c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m276c() {
            return this.f349c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m277c() {
            return this.f350c;
        }

        public int d() {
            return this.f14279b;
        }

        public e d(String str) {
            this.f354f = true;
            this.f351d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m278d() {
            return this.f351d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m279d() {
            return this.f352d;
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
        public String m280e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m281e() {
            return this.f353e;
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
        public boolean m282f() {
            return this.f354f;
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

    /* loaded from: classes6.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f357a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f358b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f356a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14281b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f355a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f14280a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14280a < 0) {
                b();
            }
            return this.f14280a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f355a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m166a());
                        break;
                    case 18:
                        b(bVar.m166a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m163a)) {
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
            this.f355a = bVar;
            return this;
        }

        public f a(String str) {
            this.f357a = true;
            this.f356a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f356a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m201a(1, a());
            }
            if (b()) {
                cVar.m201a(2, b());
            }
            if (c()) {
                cVar.m200a(3, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f357a;
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
            this.f14280a = a2;
            return a2;
        }

        public f b(String str) {
            this.f358b = true;
            this.f14281b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14281b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f358b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f360a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f361b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f362c;

        /* renamed from: a  reason: collision with other field name */
        private String f359a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14283b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f14282a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14282a < 0) {
                b();
            }
            return this.f14282a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m166a());
                        break;
                    case 18:
                        b(bVar.m166a());
                        break;
                    case 26:
                        c(bVar.m166a());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f360a = true;
            this.f359a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f359a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m201a(1, a());
            }
            if (b()) {
                cVar.m201a(2, b());
            }
            if (m283c()) {
                cVar.m201a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f360a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m283c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f14282a = a2;
            return a2;
        }

        public g b(String str) {
            this.f361b = true;
            this.f14283b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14283b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f361b;
        }

        public g c(String str) {
            this.f362c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m283c() {
            return this.f362c;
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f364a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f365b;

        /* renamed from: a  reason: collision with root package name */
        private int f14284a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f363a = "";

        /* renamed from: b  reason: collision with root package name */
        private int f14285b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14285b < 0) {
                b();
            }
            return this.f14285b;
        }

        public h a(int i) {
            this.f364a = true;
            this.f14284a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m172b());
                        break;
                    case 18:
                        a(bVar.m166a());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f365b = true;
            this.f363a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f363a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m197a(1, c());
            }
            if (b()) {
                cVar.m201a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f364a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            this.f14285b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f365b;
        }

        public int c() {
            return this.f14284a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f367a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f366a = com.xiaomi.push.a.f14145a;

        /* renamed from: a  reason: collision with root package name */
        private int f14286a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14286a < 0) {
                b();
            }
            return this.f14286a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f366a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f367a = true;
            this.f366a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m165a());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
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
                cVar.m199a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f367a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f14286a = a2;
            return a2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f370a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14288b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f368a = com.xiaomi.push.a.f14145a;

        /* renamed from: a  reason: collision with other field name */
        private b f369a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f14287a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14287a < 0) {
                b();
            }
            return this.f14287a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f368a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f369a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f370a = true;
            this.f368a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m165a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m163a)) {
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
            this.f14288b = true;
            this.f369a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m199a(1, a());
            }
            if (b()) {
                cVar.m200a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f370a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
            }
            this.f14287a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f14288b;
        }
    }

    /* loaded from: classes6.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f373a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f376b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f372a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f375b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f371a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f374b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with root package name */
        private int f14289a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f14290b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14290b < 0) {
                b();
            }
            return this.f14290b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f371a;
        }

        public k a(int i) {
            this.g = true;
            this.f14289a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f371a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m163a = bVar.m163a();
                switch (m163a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m166a());
                        break;
                    case 18:
                        b(bVar.m166a());
                        break;
                    case 24:
                        a(bVar.m164a());
                        break;
                    case 32:
                        b(bVar.m164a());
                        break;
                    case 40:
                        a(bVar.m169a());
                        break;
                    case 48:
                        a(bVar.m172b());
                        break;
                    default:
                        if (!a(bVar, m163a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f373a = true;
            this.f372a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f372a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m201a(1, a());
            }
            if (b()) {
                cVar.m201a(2, b());
            }
            if (m284c()) {
                cVar.m198a(3, a());
            }
            if (d()) {
                cVar.m198a(4, b());
            }
            if (f()) {
                cVar.m202a(5, e());
            }
            if (g()) {
                cVar.m197a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f373a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m284c()) {
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
            this.f14290b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f374b;
        }

        public k b(long j) {
            this.d = true;
            this.f374b = j;
            return this;
        }

        public k b(String str) {
            this.f376b = true;
            this.f375b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f375b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f376b;
        }

        public int c() {
            return this.f14289a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m284c() {
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
