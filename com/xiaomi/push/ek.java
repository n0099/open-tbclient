package com.xiaomi.push;
/* loaded from: classes12.dex */
public final class ek {

    /* loaded from: classes12.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f241a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f243b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f245c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f247d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f249e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f250f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;

        /* renamed from: a  reason: collision with root package name */
        private int f4878a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f239a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f240a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f242b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f244c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f246d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f248e = "";
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
            return this.f239a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f250f = false;
            this.f246d = "";
            return this;
        }

        public a a(int i) {
            this.f241a = true;
            this.f4878a = i;
            return this;
        }

        public a a(long j) {
            this.f243b = true;
            this.f239a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m145a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f245c = true;
            this.f240a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f240a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m179a(1, c());
            }
            if (b()) {
                cVar.m193b(2, a());
            }
            if (m243c()) {
                cVar.m183a(3, a());
            }
            if (m245d()) {
                cVar.m183a(4, b());
            }
            if (m247e()) {
                cVar.m183a(5, m242c());
            }
            if (m249f()) {
                cVar.m183a(6, m244d());
            }
            if (g()) {
                cVar.m183a(7, m246e());
            }
            if (h()) {
                cVar.m179a(8, d());
            }
            if (i()) {
                cVar.m179a(9, e());
            }
            if (j()) {
                cVar.m179a(10, f());
            }
            if (k()) {
                cVar.m183a(11, m248f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f241a;
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
            this.e = a2;
            return a2;
        }

        public a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public a b(String str) {
            this.f247d = true;
            this.f242b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f242b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f243b;
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
            this.f249e = true;
            this.f244c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m242c() {
            return this.f244c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m243c() {
            return this.f245c;
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
            this.f250f = true;
            this.f246d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m244d() {
            return this.f246d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m245d() {
            return this.f247d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f248e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m246e() {
            return this.f248e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m247e() {
            return this.f249e;
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
        public String m248f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m249f() {
            return this.f250f;
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
        private boolean f251a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f253c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f254d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f252b = false;

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
            this.f253c = true;
            this.f4879a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m151a());
                        break;
                    case 24:
                        a(bVar.m154b());
                        break;
                    case 32:
                        b(bVar.m154b());
                        break;
                    case 40:
                        c(bVar.m154b());
                        break;
                    default:
                        if (!a(bVar, m145a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f251a = true;
            this.f252b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m184a(1, a());
            }
            if (m250c()) {
                cVar.m179a(3, c());
            }
            if (m251d()) {
                cVar.m179a(4, d());
            }
            if (m252e()) {
                cVar.m179a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f252b;
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
            this.d = a2;
            return a2;
        }

        public b b(int i) {
            this.f254d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f251a;
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
        public boolean m250c() {
            return this.f253c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m251d() {
            return this.f254d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m252e() {
            return this.e;
        }
    }

    /* loaded from: classes12.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f256a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f257b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f258c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f259d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f260e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f261f;

        /* renamed from: a  reason: collision with other field name */
        private String f255a = "";
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
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m148a());
                        break;
                    case 18:
                        b(bVar.m148a());
                        break;
                    case 26:
                        c(bVar.m148a());
                        break;
                    case 34:
                        d(bVar.m148a());
                        break;
                    case 42:
                        e(bVar.m148a());
                        break;
                    case 50:
                        f(bVar.m148a());
                        break;
                    default:
                        if (!a(bVar, m145a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f256a = true;
            this.f255a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f255a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m183a(1, a());
            }
            if (b()) {
                cVar.m183a(2, b());
            }
            if (m253c()) {
                cVar.m183a(3, c());
            }
            if (m254d()) {
                cVar.m183a(4, d());
            }
            if (m255e()) {
                cVar.m183a(5, e());
            }
            if (m256f()) {
                cVar.m183a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f256a;
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
            this.f4880a = a2;
            return a2;
        }

        public c b(String str) {
            this.f257b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f257b;
        }

        public c c(String str) {
            this.f258c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m253c() {
            return this.f258c;
        }

        public c d(String str) {
            this.f259d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m254d() {
            return this.f259d;
        }

        public c e(String str) {
            this.f260e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m255e() {
            return this.f260e;
        }

        public c f(String str) {
            this.f261f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m256f() {
            return this.f261f;
        }
    }

    /* loaded from: classes12.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f263a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f265c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f264b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f262a = "";
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
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m151a());
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
                    default:
                        if (!a(bVar, m145a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f265c = true;
            this.f262a = str;
            return this;
        }

        public d a(boolean z) {
            this.f263a = true;
            this.f264b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f262a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m184a(1, a());
            }
            if (m257c()) {
                cVar.m183a(2, a());
            }
            if (d()) {
                cVar.m183a(3, b());
            }
            if (e()) {
                cVar.m183a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f264b;
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
            return this.f263a;
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
        public boolean m257c() {
            return this.f265c;
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
        private boolean f268a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f270b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f272c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f274d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f275e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f276f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private int f4882a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f267a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f269b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f271c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f273d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f266a = null;
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
            return this.f266a;
        }

        public e a(int i) {
            this.f268a = true;
            this.f4882a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
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
                        if (!a(bVar, m145a)) {
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
            this.f266a = bVar;
            return this;
        }

        public e a(String str) {
            this.f270b = true;
            this.f267a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f267a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m192b(1, c());
            }
            if (b()) {
                cVar.m183a(2, a());
            }
            if (m259c()) {
                cVar.m183a(3, b());
            }
            if (m261d()) {
                cVar.m183a(4, m258c());
            }
            if (m263e()) {
                cVar.m179a(5, d());
            }
            if (m264f()) {
                cVar.m183a(6, m260d());
            }
            if (g()) {
                cVar.m183a(7, m262e());
            }
            if (h()) {
                cVar.m183a(8, f());
            }
            if (i()) {
                cVar.m182a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m179a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f268a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m259c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m261d()) {
                b += com.xiaomi.push.c.a(4, m258c());
            }
            if (m263e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m264f()) {
                b += com.xiaomi.push.c.a(6, m260d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m262e());
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
            this.f275e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f272c = true;
            this.f269b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f269b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f270b;
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
            this.f274d = true;
            this.f271c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m258c() {
            return this.f271c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m259c() {
            return this.f272c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f276f = true;
            this.f273d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m260d() {
            return this.f273d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m261d() {
            return this.f274d;
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
        public String m262e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m263e() {
            return this.f275e;
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
        public boolean m264f() {
            return this.f276f;
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
        private boolean f279a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f280b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f278a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f277a = null;

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
            return this.f277a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m148a());
                        break;
                    case 18:
                        b(bVar.m148a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m145a)) {
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
            this.f277a = bVar;
            return this;
        }

        public f a(String str) {
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
                cVar.m183a(1, a());
            }
            if (b()) {
                cVar.m183a(2, b());
            }
            if (c()) {
                cVar.m182a(3, (com.xiaomi.push.e) a());
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
            if (c()) {
                a2 += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) a());
            }
            this.f4883a = a2;
            return a2;
        }

        public f b(String str) {
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

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes12.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f282a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f283b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f284c;

        /* renamed from: a  reason: collision with other field name */
        private String f281a = "";
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
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m148a());
                        break;
                    case 18:
                        b(bVar.m148a());
                        break;
                    case 26:
                        c(bVar.m148a());
                        break;
                    default:
                        if (!a(bVar, m145a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f282a = true;
            this.f281a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f281a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m183a(1, a());
            }
            if (b()) {
                cVar.m183a(2, b());
            }
            if (m265c()) {
                cVar.m183a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f282a;
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
            this.f4884a = a2;
            return a2;
        }

        public g b(String str) {
            this.f283b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f283b;
        }

        public g c(String str) {
            this.f284c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m265c() {
            return this.f284c;
        }
    }

    /* loaded from: classes12.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f286a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f287b;

        /* renamed from: a  reason: collision with root package name */
        private int f4885a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f285a = "";
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
            this.f286a = true;
            this.f4885a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m154b());
                        break;
                    case 18:
                        a(bVar.m148a());
                        break;
                    default:
                        if (!a(bVar, m145a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f287b = true;
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
                cVar.m179a(1, c());
            }
            if (b()) {
                cVar.m183a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f286a;
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
            return this.f287b;
        }

        public int c() {
            return this.f4885a;
        }
    }

    /* loaded from: classes12.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f289a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f288a = com.xiaomi.push.a.f4785a;

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
            return this.f288a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f289a = true;
            this.f288a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m147a());
                        break;
                    default:
                        if (!a(bVar, m145a)) {
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
                cVar.m181a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f289a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a2 = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.f4886a = a2;
            return a2;
        }
    }

    /* loaded from: classes12.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f292a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f290a = com.xiaomi.push.a.f4785a;

        /* renamed from: a  reason: collision with other field name */
        private b f291a = null;

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
            return this.f290a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f291a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f292a = true;
            this.f290a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m147a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m145a)) {
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
            this.f291a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m181a(1, a());
            }
            if (b()) {
                cVar.m182a(2, (com.xiaomi.push.e) a());
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

    /* loaded from: classes12.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f295a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f298b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f294a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f297b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f293a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f296b = 0;
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
            return this.f293a;
        }

        public k a(int i) {
            this.g = true;
            this.f4888a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f293a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m145a = bVar.m145a();
                switch (m145a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m148a());
                        break;
                    case 18:
                        b(bVar.m148a());
                        break;
                    case 24:
                        a(bVar.m146a());
                        break;
                    case 32:
                        b(bVar.m146a());
                        break;
                    case 40:
                        a(bVar.m151a());
                        break;
                    case 48:
                        a(bVar.m154b());
                        break;
                    default:
                        if (!a(bVar, m145a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f295a = true;
            this.f294a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f294a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m183a(1, a());
            }
            if (b()) {
                cVar.m183a(2, b());
            }
            if (m266c()) {
                cVar.m180a(3, a());
            }
            if (d()) {
                cVar.m180a(4, b());
            }
            if (f()) {
                cVar.m184a(5, e());
            }
            if (g()) {
                cVar.m179a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f295a;
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
            this.b = a2;
            return a2;
        }

        @Override // com.xiaomi.push.e
        public long b() {
            return this.f296b;
        }

        public k b(long j) {
            this.d = true;
            this.f296b = j;
            return this;
        }

        public k b(String str) {
            this.f298b = true;
            this.f297b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f297b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f298b;
        }

        public int c() {
            return this.f4888a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m266c() {
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
