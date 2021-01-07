package com.xiaomi.push;
/* loaded from: classes6.dex */
public final class ek {

    /* loaded from: classes6.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f320a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f322b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f324c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f326d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f328e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f329f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        /* renamed from: a  reason: collision with root package name */
        private int f14271a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f318a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f319a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f321b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f323c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f325d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f327e = "";

        /* renamed from: b  reason: collision with root package name */
        private int f14272b = 1;
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
            return this.f318a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f329f = false;
            this.f325d = "";
            return this;
        }

        public a a(int i) {
            this.f320a = true;
            this.f14271a = i;
            return this;
        }

        public a a(long j) {
            this.f322b = true;
            this.f318a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m183b());
                        break;
                    case 16:
                        a(bVar.m184b());
                        break;
                    case 26:
                        a(bVar.m177a());
                        break;
                    case 34:
                        b(bVar.m177a());
                        break;
                    case 42:
                        c(bVar.m177a());
                        break;
                    case 50:
                        d(bVar.m177a());
                        break;
                    case 58:
                        e(bVar.m177a());
                        break;
                    case 64:
                        b(bVar.m183b());
                        break;
                    case 72:
                        c(bVar.m183b());
                        break;
                    case 80:
                        d(bVar.m183b());
                        break;
                    case 90:
                        f(bVar.m177a());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f324c = true;
            this.f319a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f319a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m208a(1, c());
            }
            if (b()) {
                cVar.m222b(2, a());
            }
            if (m272c()) {
                cVar.m212a(3, a());
            }
            if (m274d()) {
                cVar.m212a(4, b());
            }
            if (m276e()) {
                cVar.m212a(5, m271c());
            }
            if (m278f()) {
                cVar.m212a(6, m273d());
            }
            if (g()) {
                cVar.m212a(7, m275e());
            }
            if (h()) {
                cVar.m208a(8, d());
            }
            if (i()) {
                cVar.m208a(9, e());
            }
            if (j()) {
                cVar.m208a(10, f());
            }
            if (k()) {
                cVar.m212a(11, m277f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f320a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.b(2, a());
            }
            if (m272c()) {
                a2 += com.xiaomi.push.c.a(3, a());
            }
            if (m274d()) {
                a2 += com.xiaomi.push.c.a(4, b());
            }
            if (m276e()) {
                a2 += com.xiaomi.push.c.a(5, m271c());
            }
            if (m278f()) {
                a2 += com.xiaomi.push.c.a(6, m273d());
            }
            if (g()) {
                a2 += com.xiaomi.push.c.a(7, m275e());
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
                a2 += com.xiaomi.push.c.a(11, m277f());
            }
            this.e = a2;
            return a2;
        }

        public a b(int i) {
            this.h = true;
            this.f14272b = i;
            return this;
        }

        public a b(String str) {
            this.f326d = true;
            this.f321b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f321b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f322b;
        }

        public int c() {
            return this.f14271a;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a c(String str) {
            this.f328e = true;
            this.f323c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m271c() {
            return this.f323c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m272c() {
            return this.f324c;
        }

        public int d() {
            return this.f14272b;
        }

        public a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        public a d(String str) {
            this.f329f = true;
            this.f325d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m273d() {
            return this.f325d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m274d() {
            return this.f326d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f327e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m275e() {
            return this.f327e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m276e() {
            return this.f328e;
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
        public String m277f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m278f() {
            return this.f329f;
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
        private boolean f330a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f332c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f333d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f331b = false;

        /* renamed from: a  reason: collision with root package name */
        private int f14273a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f14274b = 0;
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
            this.f332c = true;
            this.f14273a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m180a());
                        break;
                    case 24:
                        a(bVar.m183b());
                        break;
                    case 32:
                        b(bVar.m183b());
                        break;
                    case 40:
                        c(bVar.m183b());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f330a = true;
            this.f331b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m213a(1, a());
            }
            if (m279c()) {
                cVar.m208a(3, c());
            }
            if (m280d()) {
                cVar.m208a(4, d());
            }
            if (m281e()) {
                cVar.m208a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f331b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m279c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m280d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m281e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            this.d = a2;
            return a2;
        }

        public b b(int i) {
            this.f333d = true;
            this.f14274b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f330a;
        }

        public int c() {
            return this.f14273a;
        }

        public b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m279c() {
            return this.f332c;
        }

        public int d() {
            return this.f14274b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m280d() {
            return this.f333d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m281e() {
            return this.e;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f335a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f336b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f337c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f338d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f339e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f340f;

        /* renamed from: a  reason: collision with other field name */
        private String f334a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14276b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with root package name */
        private int f14275a = -1;

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14275a < 0) {
                b();
            }
            return this.f14275a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m177a());
                        break;
                    case 18:
                        b(bVar.m177a());
                        break;
                    case 26:
                        c(bVar.m177a());
                        break;
                    case 34:
                        d(bVar.m177a());
                        break;
                    case 42:
                        e(bVar.m177a());
                        break;
                    case 50:
                        f(bVar.m177a());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f335a = true;
            this.f334a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f334a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m212a(1, a());
            }
            if (b()) {
                cVar.m212a(2, b());
            }
            if (m282c()) {
                cVar.m212a(3, c());
            }
            if (m283d()) {
                cVar.m212a(4, d());
            }
            if (m284e()) {
                cVar.m212a(5, e());
            }
            if (m285f()) {
                cVar.m212a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f335a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m282c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            if (m283d()) {
                a2 += com.xiaomi.push.c.a(4, d());
            }
            if (m284e()) {
                a2 += com.xiaomi.push.c.a(5, e());
            }
            if (m285f()) {
                a2 += com.xiaomi.push.c.a(6, f());
            }
            this.f14275a = a2;
            return a2;
        }

        public c b(String str) {
            this.f336b = true;
            this.f14276b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14276b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f336b;
        }

        public c c(String str) {
            this.f337c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m282c() {
            return this.f337c;
        }

        public c d(String str) {
            this.f338d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m283d() {
            return this.f338d;
        }

        public c e(String str) {
            this.f339e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m284e() {
            return this.f339e;
        }

        public c f(String str) {
            this.f340f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m285f() {
            return this.f340f;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f342a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f344c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f343b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f341a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14278b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f14277a = -1;

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14277a < 0) {
                b();
            }
            return this.f14277a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m180a());
                        break;
                    case 18:
                        a(bVar.m177a());
                        break;
                    case 26:
                        b(bVar.m177a());
                        break;
                    case 34:
                        c(bVar.m177a());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f344c = true;
            this.f341a = str;
            return this;
        }

        public d a(boolean z) {
            this.f342a = true;
            this.f343b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f341a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m213a(1, a());
            }
            if (m286c()) {
                cVar.m212a(2, a());
            }
            if (d()) {
                cVar.m212a(3, b());
            }
            if (e()) {
                cVar.m212a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f343b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m286c()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            if (d()) {
                a2 += com.xiaomi.push.c.a(3, b());
            }
            if (e()) {
                a2 += com.xiaomi.push.c.a(4, c());
            }
            this.f14277a = a2;
            return a2;
        }

        public d b(String str) {
            this.d = true;
            this.f14278b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14278b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f342a;
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
        public boolean m286c() {
            return this.f344c;
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
        private boolean f347a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f349b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f351c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f353d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f354e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f355f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private int f14279a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f346a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f348b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f350c = "";

        /* renamed from: b  reason: collision with root package name */
        private int f14280b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f352d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f345a = null;
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
            return this.f345a;
        }

        public e a(int i) {
            this.f347a = true;
            this.f14279a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m177a());
                        break;
                    case 26:
                        b(bVar.m177a());
                        break;
                    case 34:
                        c(bVar.m177a());
                        break;
                    case 40:
                        b(bVar.m183b());
                        break;
                    case 50:
                        d(bVar.m177a());
                        break;
                    case 58:
                        e(bVar.m177a());
                        break;
                    case 66:
                        f(bVar.m177a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m183b());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
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
            this.f345a = bVar;
            return this;
        }

        public e a(String str) {
            this.f349b = true;
            this.f346a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f346a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m221b(1, c());
            }
            if (b()) {
                cVar.m212a(2, a());
            }
            if (m288c()) {
                cVar.m212a(3, b());
            }
            if (m290d()) {
                cVar.m212a(4, m287c());
            }
            if (m292e()) {
                cVar.m208a(5, d());
            }
            if (m293f()) {
                cVar.m212a(6, m289d());
            }
            if (g()) {
                cVar.m212a(7, m291e());
            }
            if (h()) {
                cVar.m212a(8, f());
            }
            if (i()) {
                cVar.m211a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m208a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f347a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b2 = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b2 += com.xiaomi.push.c.a(2, a());
            }
            if (m288c()) {
                b2 += com.xiaomi.push.c.a(3, b());
            }
            if (m290d()) {
                b2 += com.xiaomi.push.c.a(4, m287c());
            }
            if (m292e()) {
                b2 += com.xiaomi.push.c.a(5, d());
            }
            if (m293f()) {
                b2 += com.xiaomi.push.c.a(6, m289d());
            }
            if (g()) {
                b2 += com.xiaomi.push.c.a(7, m291e());
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
            this.f354e = true;
            this.f14280b = i;
            return this;
        }

        public e b(String str) {
            this.f351c = true;
            this.f348b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f348b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f349b;
        }

        public int c() {
            return this.f14279a;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e c(String str) {
            this.f353d = true;
            this.f350c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m287c() {
            return this.f350c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m288c() {
            return this.f351c;
        }

        public int d() {
            return this.f14280b;
        }

        public e d(String str) {
            this.f355f = true;
            this.f352d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m289d() {
            return this.f352d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m290d() {
            return this.f353d;
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
        public String m291e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m292e() {
            return this.f354e;
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
        public boolean m293f() {
            return this.f355f;
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
        private boolean f358a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f359b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f357a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14282b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f356a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f14281a = -1;

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14281a < 0) {
                b();
            }
            return this.f14281a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f356a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m177a());
                        break;
                    case 18:
                        b(bVar.m177a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m174a)) {
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
            this.f356a = bVar;
            return this;
        }

        public f a(String str) {
            this.f358a = true;
            this.f357a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f357a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m212a(1, a());
            }
            if (b()) {
                cVar.m212a(2, b());
            }
            if (c()) {
                cVar.m211a(3, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f358a;
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
            this.f14281a = a2;
            return a2;
        }

        public f b(String str) {
            this.f359b = true;
            this.f14282b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14282b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f359b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f361a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f362b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f363c;

        /* renamed from: a  reason: collision with other field name */
        private String f360a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f14284b = "";
        private String c = "";

        /* renamed from: a  reason: collision with root package name */
        private int f14283a = -1;

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14283a < 0) {
                b();
            }
            return this.f14283a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m177a());
                        break;
                    case 18:
                        b(bVar.m177a());
                        break;
                    case 26:
                        c(bVar.m177a());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f361a = true;
            this.f360a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f360a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m212a(1, a());
            }
            if (b()) {
                cVar.m212a(2, b());
            }
            if (m294c()) {
                cVar.m212a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f361a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m294c()) {
                a2 += com.xiaomi.push.c.a(3, c());
            }
            this.f14283a = a2;
            return a2;
        }

        public g b(String str) {
            this.f362b = true;
            this.f14284b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f14284b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f362b;
        }

        public g c(String str) {
            this.f363c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m294c() {
            return this.f363c;
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f365a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f366b;

        /* renamed from: a  reason: collision with root package name */
        private int f14285a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f364a = "";

        /* renamed from: b  reason: collision with root package name */
        private int f14286b = -1;

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14286b < 0) {
                b();
            }
            return this.f14286b;
        }

        public h a(int i) {
            this.f365a = true;
            this.f14285a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m183b());
                        break;
                    case 18:
                        a(bVar.m177a());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f366b = true;
            this.f364a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f364a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m208a(1, c());
            }
            if (b()) {
                cVar.m212a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f365a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, a());
            }
            this.f14286b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f366b;
        }

        public int c() {
            return this.f14285a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f368a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f367a = com.xiaomi.push.a.f14146a;

        /* renamed from: a  reason: collision with root package name */
        private int f14287a = -1;

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
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
            return this.f367a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f368a = true;
            this.f367a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m176a());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
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
                cVar.m210a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f368a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f14287a = a2;
            return a2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f371a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14289b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f369a = com.xiaomi.push.a.f14146a;

        /* renamed from: a  reason: collision with other field name */
        private b f370a = null;

        /* renamed from: a  reason: collision with root package name */
        private int f14288a = -1;

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14288a < 0) {
                b();
            }
            return this.f14288a;
        }

        @Override // com.xiaomi.push.e
        public com.xiaomi.push.a a() {
            return this.f369a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f370a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f371a = true;
            this.f369a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m176a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m174a)) {
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
            this.f14289b = true;
            this.f370a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m210a(1, a());
            }
            if (b()) {
                cVar.m211a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f371a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) a());
            }
            this.f14288a = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f14289b;
        }
    }

    /* loaded from: classes6.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f374a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f377b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f373a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f376b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f372a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f375b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with root package name */
        private int f14290a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f14291b = -1;

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f14291b < 0) {
                b();
            }
            return this.f14291b;
        }

        @Override // com.xiaomi.push.e
        public long a() {
            return this.f372a;
        }

        public k a(int i) {
            this.g = true;
            this.f14290a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f372a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m177a());
                        break;
                    case 18:
                        b(bVar.m177a());
                        break;
                    case 24:
                        a(bVar.m175a());
                        break;
                    case 32:
                        b(bVar.m175a());
                        break;
                    case 40:
                        a(bVar.m180a());
                        break;
                    case 48:
                        a(bVar.m183b());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f374a = true;
            this.f373a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f373a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m212a(1, a());
            }
            if (b()) {
                cVar.m212a(2, b());
            }
            if (m295c()) {
                cVar.m209a(3, a());
            }
            if (d()) {
                cVar.m209a(4, b());
            }
            if (f()) {
                cVar.m213a(5, e());
            }
            if (g()) {
                cVar.m208a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f374a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a2 += com.xiaomi.push.c.a(2, b());
            }
            if (m295c()) {
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
            this.f14291b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f375b;
        }

        public k b(long j) {
            this.d = true;
            this.f375b = j;
            return this;
        }

        public k b(String str) {
            this.f377b = true;
            this.f376b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f376b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f377b;
        }

        public int c() {
            return this.f14290a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m295c() {
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
