package com.xiaomi.push;
/* loaded from: classes8.dex */
public final class ek {

    /* loaded from: classes8.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f239a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f241b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f243c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f245d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f247e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f248f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f237a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f238a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f240b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f242c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f244d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f246e = "";
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
            return this.f237a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f248f = false;
            this.f244d = "";
            return this;
        }

        public a a(int i) {
            this.f239a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f241b = true;
            this.f237a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m142a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f243c = true;
            this.f238a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f238a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m176a(1, c());
            }
            if (b()) {
                cVar.m190b(2, a());
            }
            if (m240c()) {
                cVar.m180a(3, a());
            }
            if (m242d()) {
                cVar.m180a(4, b());
            }
            if (m244e()) {
                cVar.m180a(5, m239c());
            }
            if (m246f()) {
                cVar.m180a(6, m241d());
            }
            if (g()) {
                cVar.m180a(7, m243e());
            }
            if (h()) {
                cVar.m176a(8, d());
            }
            if (i()) {
                cVar.m176a(9, e());
            }
            if (j()) {
                cVar.m176a(10, f());
            }
            if (k()) {
                cVar.m180a(11, m245f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f239a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.b(2, a());
            }
            if (m240c()) {
                a += com.xiaomi.push.c.a(3, a());
            }
            if (m242d()) {
                a += com.xiaomi.push.c.a(4, b());
            }
            if (m244e()) {
                a += com.xiaomi.push.c.a(5, m239c());
            }
            if (m246f()) {
                a += com.xiaomi.push.c.a(6, m241d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m243e());
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
                a += com.xiaomi.push.c.a(11, m245f());
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
            this.f245d = true;
            this.f240b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f240b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f241b;
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
            this.f247e = true;
            this.f242c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m239c() {
            return this.f242c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m240c() {
            return this.f243c;
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
            this.f248f = true;
            this.f244d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m241d() {
            return this.f244d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m242d() {
            return this.f245d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f246e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m243e() {
            return this.f246e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m244e() {
            return this.f247e;
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
        public String m245f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m246f() {
            return this.f248f;
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
        private boolean f249a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f251c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f252d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f250b = false;
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
            this.f251c = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m148a());
                        break;
                    case 24:
                        a(bVar.m151b());
                        break;
                    case 32:
                        b(bVar.m151b());
                        break;
                    case 40:
                        c(bVar.m151b());
                        break;
                    default:
                        if (!a(bVar, m142a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f249a = true;
            this.f250b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m181a(1, a());
            }
            if (m247c()) {
                cVar.m176a(3, c());
            }
            if (m248d()) {
                cVar.m176a(4, d());
            }
            if (m249e()) {
                cVar.m176a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f250b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m247c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m248d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m249e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f252d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f249a;
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
        public boolean m247c() {
            return this.f251c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m248d() {
            return this.f252d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m249e() {
            return this.e;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f254a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f255b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f256c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f257d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f258e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f259f;

        /* renamed from: a  reason: collision with other field name */
        private String f253a = "";
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
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m145a());
                        break;
                    case 18:
                        b(bVar.m145a());
                        break;
                    case 26:
                        c(bVar.m145a());
                        break;
                    case 34:
                        d(bVar.m145a());
                        break;
                    case 42:
                        e(bVar.m145a());
                        break;
                    case 50:
                        f(bVar.m145a());
                        break;
                    default:
                        if (!a(bVar, m142a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f254a = true;
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
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (m250c()) {
                cVar.m180a(3, c());
            }
            if (m251d()) {
                cVar.m180a(4, d());
            }
            if (m252e()) {
                cVar.m180a(5, e());
            }
            if (m253f()) {
                cVar.m180a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f254a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m250c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m251d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m252e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m253f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f255b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f255b;
        }

        public c c(String str) {
            this.f256c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m250c() {
            return this.f256c;
        }

        public c d(String str) {
            this.f257d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m251d() {
            return this.f257d;
        }

        public c e(String str) {
            this.f258e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m252e() {
            return this.f258e;
        }

        public c f(String str) {
            this.f259f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m253f() {
            return this.f259f;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f261a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f263c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f262b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f260a = "";
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
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m148a());
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
                    default:
                        if (!a(bVar, m142a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f263c = true;
            this.f260a = str;
            return this;
        }

        public d a(boolean z) {
            this.f261a = true;
            this.f262b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f260a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m181a(1, a());
            }
            if (m254c()) {
                cVar.m180a(2, a());
            }
            if (d()) {
                cVar.m180a(3, b());
            }
            if (e()) {
                cVar.m180a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f262b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m254c()) {
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
            return this.f261a;
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
        public boolean m254c() {
            return this.f263c;
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
        private boolean f266a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f268b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f270c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f272d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f273e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f274f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f265a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f267b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f269c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f271d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f264a = null;
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
            return this.f264a;
        }

        public e a(int i) {
            this.f266a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m142a)) {
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
            this.f264a = bVar;
            return this;
        }

        public e a(String str) {
            this.f268b = true;
            this.f265a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f265a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m189b(1, c());
            }
            if (b()) {
                cVar.m180a(2, a());
            }
            if (m256c()) {
                cVar.m180a(3, b());
            }
            if (m258d()) {
                cVar.m180a(4, m255c());
            }
            if (m260e()) {
                cVar.m176a(5, d());
            }
            if (m261f()) {
                cVar.m180a(6, m257d());
            }
            if (g()) {
                cVar.m180a(7, m259e());
            }
            if (h()) {
                cVar.m180a(8, f());
            }
            if (i()) {
                cVar.m179a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m176a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f266a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m256c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m258d()) {
                b += com.xiaomi.push.c.a(4, m255c());
            }
            if (m260e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m261f()) {
                b += com.xiaomi.push.c.a(6, m257d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m259e());
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
            this.f273e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f270c = true;
            this.f267b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f267b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f268b;
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
            this.f272d = true;
            this.f269c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m255c() {
            return this.f269c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m256c() {
            return this.f270c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f274f = true;
            this.f271d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m257d() {
            return this.f271d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m258d() {
            return this.f272d;
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
        public String m259e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m260e() {
            return this.f273e;
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
        public boolean m261f() {
            return this.f274f;
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
        private boolean f277a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f278b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f276a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f275a = null;
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
            return this.f275a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m145a());
                        break;
                    case 18:
                        b(bVar.m145a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m142a)) {
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
            this.f275a = bVar;
            return this;
        }

        public f a(String str) {
            this.f277a = true;
            this.f276a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f276a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (c()) {
                cVar.m179a(3, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f277a;
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
            this.f278b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f278b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes8.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f280a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f281b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f282c;

        /* renamed from: a  reason: collision with other field name */
        private String f279a = "";
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
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m145a());
                        break;
                    case 18:
                        b(bVar.m145a());
                        break;
                    case 26:
                        c(bVar.m145a());
                        break;
                    default:
                        if (!a(bVar, m142a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
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
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (m262c()) {
                cVar.m180a(3, c());
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
            if (m262c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
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

        public g c(String str) {
            this.f282c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m262c() {
            return this.f282c;
        }
    }

    /* loaded from: classes8.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f284a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f285b;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f283a = "";
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
            this.f284a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m151b());
                        break;
                    case 18:
                        a(bVar.m145a());
                        break;
                    default:
                        if (!a(bVar, m142a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f285b = true;
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
                cVar.m176a(1, c());
            }
            if (b()) {
                cVar.m180a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f284a;
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
            return this.f285b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes8.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f287a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f286a = com.xiaomi.push.a.a;
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
            return this.f286a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f287a = true;
            this.f286a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m144a());
                        break;
                    default:
                        if (!a(bVar, m142a)) {
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
                cVar.m178a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f287a;
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
        private boolean f290a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f288a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f289a = null;
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
            return this.f288a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f289a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f290a = true;
            this.f288a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m144a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m142a)) {
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
            this.f289a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m178a(1, a());
            }
            if (b()) {
                cVar.m179a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f290a;
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
        private boolean f293a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f296b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f292a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f295b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f291a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f294b = 0;
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
            return this.f291a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f291a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m142a = bVar.m142a();
                switch (m142a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m145a());
                        break;
                    case 18:
                        b(bVar.m145a());
                        break;
                    case 24:
                        a(bVar.m143a());
                        break;
                    case 32:
                        b(bVar.m143a());
                        break;
                    case 40:
                        a(bVar.m148a());
                        break;
                    case 48:
                        a(bVar.m151b());
                        break;
                    default:
                        if (!a(bVar, m142a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f293a = true;
            this.f292a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f292a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m180a(1, a());
            }
            if (b()) {
                cVar.m180a(2, b());
            }
            if (m263c()) {
                cVar.m177a(3, a());
            }
            if (d()) {
                cVar.m177a(4, b());
            }
            if (f()) {
                cVar.m181a(5, e());
            }
            if (g()) {
                cVar.m176a(6, c());
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
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m263c()) {
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
            return this.f294b;
        }

        public k b(long j) {
            this.d = true;
            this.f294b = j;
            return this;
        }

        public k b(String str) {
            this.f296b = true;
            this.f295b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f295b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f296b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m263c() {
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
