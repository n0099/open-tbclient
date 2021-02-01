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
        private int f13973a = 0;

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
        private int f13974b = 1;
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
            this.f13973a = i;
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
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m179b());
                        break;
                    case 16:
                        a(bVar.m180b());
                        break;
                    case 26:
                        a(bVar.m173a());
                        break;
                    case 34:
                        b(bVar.m173a());
                        break;
                    case 42:
                        c(bVar.m173a());
                        break;
                    case 50:
                        d(bVar.m173a());
                        break;
                    case 58:
                        e(bVar.m173a());
                        break;
                    case 64:
                        b(bVar.m179b());
                        break;
                    case 72:
                        c(bVar.m179b());
                        break;
                    case 80:
                        d(bVar.m179b());
                        break;
                    case 90:
                        f(bVar.m173a());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m204a(1, c());
            }
            if (b()) {
                cVar.m218b(2, a());
            }
            if (m268c()) {
                cVar.m208a(3, a());
            }
            if (m270d()) {
                cVar.m208a(4, b());
            }
            if (m272e()) {
                cVar.m208a(5, m267c());
            }
            if (m274f()) {
                cVar.m208a(6, m269d());
            }
            if (g()) {
                cVar.m208a(7, m271e());
            }
            if (h()) {
                cVar.m204a(8, d());
            }
            if (i()) {
                cVar.m204a(9, e());
            }
            if (j()) {
                cVar.m204a(10, f());
            }
            if (k()) {
                cVar.m208a(11, m273f());
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
            if (m268c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m270d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m272e()) {
                a2 += com.xiaomi.push.c.a(5, m267c());
            }
            if (m274f()) {
                a2 += com.xiaomi.push.c.a(6, m269d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m271e());
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
                a2 += com.xiaomi.push.c.a(11, m273f());
            }
            this.e = a2;
            return a2;
        }

        public a b(int i) {
            this.h = true;
            this.f13974b = i;
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
            return this.f13973a;
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
        public String m267c() {
            return this.f322c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m268c() {
            return this.f323c;
        }

        public int d() {
            return this.f13974b;
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
        public String m269d() {
            return this.f324d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m270d() {
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
        public String m271e() {
            return this.f326e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m272e() {
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
        public String m273f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m274f() {
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
        private int f13975a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f13976b = 0;
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
            this.f13975a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m176a());
                        break;
                    case 24:
                        a(bVar.m179b());
                        break;
                    case 32:
                        b(bVar.m179b());
                        break;
                    case 40:
                        c(bVar.m179b());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m209a(1, a());
            }
            if (m275c()) {
                cVar.m204a(3, c());
            }
            if (m276d()) {
                cVar.m204a(4, d());
            }
            if (m277e()) {
                cVar.m204a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f330b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m275c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m276d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m277e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.d = a2;
            return a2;
        }

        public b b(int i) {
            this.f332d = true;
            this.f13976b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f329a;
        }

        public int c() {
            return this.f13975a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m275c() {
            return this.f331c;
        }

        public int d() {
            return this.f13976b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m276d() {
            return this.f332d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m277e() {
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
        private String f13978b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with root package name */
        private int f13977a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13977a < 0) {
                b();
            }
            return this.f13977a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m173a());
                        break;
                    case 18:
                        b(bVar.m173a());
                        break;
                    case 26:
                        c(bVar.m173a());
                        break;
                    case 34:
                        d(bVar.m173a());
                        break;
                    case 42:
                        e(bVar.m173a());
                        break;
                    case 50:
                        f(bVar.m173a());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m208a(1, a());
            }
            if (b()) {
                cVar.m208a(2, b());
            }
            if (m278c()) {
                cVar.m208a(3, c());
            }
            if (m279d()) {
                cVar.m208a(4, d());
            }
            if (m280e()) {
                cVar.m208a(5, e());
            }
            if (m281f()) {
                cVar.m208a(6, f());
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
            if (m278c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m279d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m280e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m281f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f13977a = a2;
            return a2;
        }

        public c b(String str) {
            this.f335b = true;
            this.f13978b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f13978b;
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
        public boolean m278c() {
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
        public boolean m279d() {
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
        public boolean m280e() {
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
        public boolean m281f() {
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
        private String f13980b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f13979a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13979a < 0) {
                b();
            }
            return this.f13979a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m176a());
                        break;
                    case 18:
                        a(bVar.m173a());
                        break;
                    case 26:
                        b(bVar.m173a());
                        break;
                    case 34:
                        c(bVar.m173a());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m209a(1, a());
            }
            if (m282c()) {
                cVar.m208a(2, a());
            }
            if (d()) {
                cVar.m208a(3, b());
            }
            if (e()) {
                cVar.m208a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f342b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m282c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f13979a = a2;
            return a2;
        }

        public d b(String str) {
            this.d = true;
            this.f13980b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f13980b;
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
        public boolean m282c() {
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
        private int f13981a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f345a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f347b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f349c = "";

        /* renamed from: b  reason: collision with root package name */
        private int f13982b = 0;

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
            this.f13981a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m173a());
                        break;
                    case 26:
                        b(bVar.m173a());
                        break;
                    case 34:
                        c(bVar.m173a());
                        break;
                    case 40:
                        b(bVar.m179b());
                        break;
                    case 50:
                        d(bVar.m173a());
                        break;
                    case 58:
                        e(bVar.m173a());
                        break;
                    case 66:
                        f(bVar.m173a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m179b());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m217b(1, c());
            }
            if (b()) {
                cVar.m208a(2, a());
            }
            if (m284c()) {
                cVar.m208a(3, b());
            }
            if (m286d()) {
                cVar.m208a(4, m283c());
            }
            if (m288e()) {
                cVar.m204a(5, d());
            }
            if (m289f()) {
                cVar.m208a(6, m285d());
            }
            if (g()) {
                cVar.m208a(7, m287e());
            }
            if (h()) {
                cVar.m208a(8, f());
            }
            if (i()) {
                cVar.m207a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m204a(10, e());
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
            if (m284c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m286d()) {
                b2 += com.xiaomi.push.c.a(4, m283c());
            }
            if (m288e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m289f()) {
                b2 += com.xiaomi.push.c.a(6, m285d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m287e());
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
            this.f13982b = i;
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
            return this.f13981a;
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
        public String m283c() {
            return this.f349c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m284c() {
            return this.f350c;
        }

        public int d() {
            return this.f13982b;
        }

        public e d(String str) {
            this.f354f = true;
            this.f351d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m285d() {
            return this.f351d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m286d() {
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
        public String m287e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m288e() {
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
        public boolean m289f() {
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
        private String f13984b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f355a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f13983a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13983a < 0) {
                b();
            }
            return this.f13983a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f355a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m173a());
                        break;
                    case 18:
                        b(bVar.m173a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m208a(1, a());
            }
            if (b()) {
                cVar.m208a(2, b());
            }
            if (c()) {
                cVar.m207a(3, (com.xiaomi.push.e) a());
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
            this.f13983a = a2;
            return a2;
        }

        public f b(String str) {
            this.f358b = true;
            this.f13984b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f13984b;
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
        private String f13986b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f13985a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13985a < 0) {
                b();
            }
            return this.f13985a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m173a());
                        break;
                    case 18:
                        b(bVar.m173a());
                        break;
                    case 26:
                        c(bVar.m173a());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m208a(1, a());
            }
            if (b()) {
                cVar.m208a(2, b());
            }
            if (m290c()) {
                cVar.m208a(3, c());
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
            if (m290c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f13985a = a2;
            return a2;
        }

        public g b(String str) {
            this.f361b = true;
            this.f13986b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f13986b;
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
        public boolean m290c() {
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
        private int f13987a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f363a = "";

        /* renamed from: b  reason: collision with root package name */
        private int f13988b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13988b < 0) {
                b();
            }
            return this.f13988b;
        }

        public h a(int i) {
            this.f364a = true;
            this.f13987a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m179b());
                        break;
                    case 18:
                        a(bVar.m173a());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m204a(1, c());
            }
            if (b()) {
                cVar.m208a(2, a());
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
            this.f13988b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f365b;
        }

        public int c() {
            return this.f13987a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f367a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f366a = com.xiaomi.push.a.f13848a;

        /* renamed from: a  reason: collision with root package name */
        private int f13989a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13989a < 0) {
                b();
            }
            return this.f13989a;
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
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m172a());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m206a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f367a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f13989a = a2;
            return a2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f370a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13991b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f368a = com.xiaomi.push.a.f13848a;

        /* renamed from: a  reason: collision with other field name */
        private b f369a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f13990a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13990a < 0) {
                b();
            }
            return this.f13990a;
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
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m172a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
            this.f13991b = true;
            this.f369a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m206a(1, a());
            }
            if (b()) {
                cVar.m207a(2, (com.xiaomi.push.e) a());
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
            this.f13990a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f13991b;
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
        private int f13992a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f13993b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f13993b < 0) {
                b();
            }
            return this.f13993b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f371a;
        }

        public k a(int i) {
            this.g = true;
            this.f13992a = i;
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
                int m170a = bVar.m170a();
                switch (m170a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m173a());
                        break;
                    case 18:
                        b(bVar.m173a());
                        break;
                    case 24:
                        a(bVar.m171a());
                        break;
                    case 32:
                        b(bVar.m171a());
                        break;
                    case 40:
                        a(bVar.m176a());
                        break;
                    case 48:
                        a(bVar.m179b());
                        break;
                    default:
                        if (!a(bVar, m170a)) {
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
                cVar.m208a(1, a());
            }
            if (b()) {
                cVar.m208a(2, b());
            }
            if (m291c()) {
                cVar.m205a(3, a());
            }
            if (d()) {
                cVar.m205a(4, b());
            }
            if (f()) {
                cVar.m209a(5, e());
            }
            if (g()) {
                cVar.m204a(6, c());
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
            if (m291c()) {
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
            this.f13993b = a2;
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
            return this.f13992a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m291c() {
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
