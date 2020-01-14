package com.xiaomi.push;
/* loaded from: classes6.dex */
public final class ee {

    /* loaded from: classes6.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f258a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f260b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f262c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f264d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f266e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f267f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f256a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f257a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f259b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f261c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f263d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f265e = "";
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
            return this.f256a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f267f = false;
            this.f263d = "";
            return this;
        }

        public a a(int i) {
            this.f258a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f260b = true;
            this.f256a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m147b());
                        break;
                    case 16:
                        a(bVar.m148b());
                        break;
                    case 26:
                        a(bVar.m141a());
                        break;
                    case 34:
                        b(bVar.m141a());
                        break;
                    case 42:
                        c(bVar.m141a());
                        break;
                    case 50:
                        d(bVar.m141a());
                        break;
                    case 58:
                        e(bVar.m141a());
                        break;
                    case 64:
                        b(bVar.m147b());
                        break;
                    case 72:
                        c(bVar.m147b());
                        break;
                    case 80:
                        d(bVar.m147b());
                        break;
                    case 90:
                        f(bVar.m141a());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f262c = true;
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
                cVar.m168a(1, c());
            }
            if (b()) {
                cVar.m182b(2, a());
            }
            if (m228c()) {
                cVar.m172a(3, a());
            }
            if (m230d()) {
                cVar.m172a(4, b());
            }
            if (m232e()) {
                cVar.m172a(5, m227c());
            }
            if (m234f()) {
                cVar.m172a(6, m229d());
            }
            if (g()) {
                cVar.m172a(7, m231e());
            }
            if (h()) {
                cVar.m168a(8, d());
            }
            if (i()) {
                cVar.m168a(9, e());
            }
            if (j()) {
                cVar.m168a(10, f());
            }
            if (k()) {
                cVar.m172a(11, m233f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f258a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.b(2, a());
            }
            if (m228c()) {
                a += com.xiaomi.push.c.a(3, a());
            }
            if (m230d()) {
                a += com.xiaomi.push.c.a(4, b());
            }
            if (m232e()) {
                a += com.xiaomi.push.c.a(5, m227c());
            }
            if (m234f()) {
                a += com.xiaomi.push.c.a(6, m229d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m231e());
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
                a += com.xiaomi.push.c.a(11, m233f());
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
            this.f264d = true;
            this.f259b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f259b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f260b;
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
            this.f266e = true;
            this.f261c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m227c() {
            return this.f261c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m228c() {
            return this.f262c;
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
            this.f267f = true;
            this.f263d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m229d() {
            return this.f263d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m230d() {
            return this.f264d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f265e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m231e() {
            return this.f265e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m232e() {
            return this.f266e;
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
        public String m233f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m234f() {
            return this.f267f;
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
        private boolean f268a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f270c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f271d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f269b = false;
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
            this.f270c = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m144a());
                        break;
                    case 24:
                        a(bVar.m147b());
                        break;
                    case 32:
                        b(bVar.m147b());
                        break;
                    case 40:
                        c(bVar.m147b());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f268a = true;
            this.f269b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m173a(1, a());
            }
            if (m235c()) {
                cVar.m168a(3, c());
            }
            if (m236d()) {
                cVar.m168a(4, d());
            }
            if (m237e()) {
                cVar.m168a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f269b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m235c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m236d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m237e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f271d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f268a;
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
        public boolean m235c() {
            return this.f270c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m236d() {
            return this.f271d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m237e() {
            return this.e;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f273a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f274b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f275c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f276d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f277e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f278f;

        /* renamed from: a  reason: collision with other field name */
        private String f272a = "";
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
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m141a());
                        break;
                    case 18:
                        b(bVar.m141a());
                        break;
                    case 26:
                        c(bVar.m141a());
                        break;
                    case 34:
                        d(bVar.m141a());
                        break;
                    case 42:
                        e(bVar.m141a());
                        break;
                    case 50:
                        f(bVar.m141a());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f273a = true;
            this.f272a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f272a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m172a(1, a());
            }
            if (b()) {
                cVar.m172a(2, b());
            }
            if (m238c()) {
                cVar.m172a(3, c());
            }
            if (m239d()) {
                cVar.m172a(4, d());
            }
            if (m240e()) {
                cVar.m172a(5, e());
            }
            if (m241f()) {
                cVar.m172a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f273a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m238c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m239d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m240e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m241f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f274b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f274b;
        }

        public c c(String str) {
            this.f275c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m238c() {
            return this.f275c;
        }

        public c d(String str) {
            this.f276d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m239d() {
            return this.f276d;
        }

        public c e(String str) {
            this.f277e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m240e() {
            return this.f277e;
        }

        public c f(String str) {
            this.f278f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m241f() {
            return this.f278f;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f280a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f282c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f281b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f279a = "";
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
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m144a());
                        break;
                    case 18:
                        a(bVar.m141a());
                        break;
                    case 26:
                        b(bVar.m141a());
                        break;
                    case 34:
                        c(bVar.m141a());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f282c = true;
            this.f279a = str;
            return this;
        }

        public d a(boolean z) {
            this.f280a = true;
            this.f281b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f279a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m173a(1, a());
            }
            if (m242c()) {
                cVar.m172a(2, a());
            }
            if (d()) {
                cVar.m172a(3, b());
            }
            if (e()) {
                cVar.m172a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f281b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m242c()) {
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
            return this.f280a;
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
        public boolean m242c() {
            return this.f282c;
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
        private boolean f285a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f287b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f289c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f291d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f292e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f293f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f284a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f286b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f288c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f290d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f283a = null;
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
            return this.f283a;
        }

        public e a(int i) {
            this.f285a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m141a());
                        break;
                    case 26:
                        b(bVar.m141a());
                        break;
                    case 34:
                        c(bVar.m141a());
                        break;
                    case 40:
                        b(bVar.m147b());
                        break;
                    case 50:
                        d(bVar.m141a());
                        break;
                    case 58:
                        e(bVar.m141a());
                        break;
                    case 66:
                        f(bVar.m141a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m147b());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
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
            this.f283a = bVar;
            return this;
        }

        public e a(String str) {
            this.f287b = true;
            this.f284a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m181b(1, c());
            }
            if (b()) {
                cVar.m172a(2, a());
            }
            if (m244c()) {
                cVar.m172a(3, b());
            }
            if (m246d()) {
                cVar.m172a(4, m243c());
            }
            if (m248e()) {
                cVar.m168a(5, d());
            }
            if (m249f()) {
                cVar.m172a(6, m245d());
            }
            if (g()) {
                cVar.m172a(7, m247e());
            }
            if (h()) {
                cVar.m172a(8, f());
            }
            if (i()) {
                cVar.m171a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m168a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f285a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m244c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m246d()) {
                b += com.xiaomi.push.c.a(4, m243c());
            }
            if (m248e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m249f()) {
                b += com.xiaomi.push.c.a(6, m245d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m247e());
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
            this.f292e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f289c = true;
            this.f286b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f286b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f287b;
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
            this.f291d = true;
            this.f288c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m243c() {
            return this.f288c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m244c() {
            return this.f289c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f293f = true;
            this.f290d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m245d() {
            return this.f290d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m246d() {
            return this.f291d;
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
        public String m247e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m248e() {
            return this.f292e;
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
        public boolean m249f() {
            return this.f293f;
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
        private boolean f296a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f297b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f295a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f294a = null;
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
            return this.f294a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m141a());
                        break;
                    case 18:
                        b(bVar.m141a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m138a)) {
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
            this.f294a = bVar;
            return this;
        }

        public f a(String str) {
            this.f296a = true;
            this.f295a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f295a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m172a(1, a());
            }
            if (b()) {
                cVar.m172a(2, b());
            }
            if (c()) {
                cVar.m171a(3, (com.xiaomi.push.e) a());
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
            if (c()) {
                a += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) a());
            }
            this.a = a;
            return a;
        }

        public f b(String str) {
            this.f297b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f297b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f299a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f300b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f301c;

        /* renamed from: a  reason: collision with other field name */
        private String f298a = "";
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
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m141a());
                        break;
                    case 18:
                        b(bVar.m141a());
                        break;
                    case 26:
                        c(bVar.m141a());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f299a = true;
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
                cVar.m172a(1, a());
            }
            if (b()) {
                cVar.m172a(2, b());
            }
            if (m250c()) {
                cVar.m172a(3, c());
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
            if (m250c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
            this.f300b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f300b;
        }

        public g c(String str) {
            this.f301c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m250c() {
            return this.f301c;
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f303a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f304b;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f302a = "";
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
            this.f303a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m147b());
                        break;
                    case 18:
                        a(bVar.m141a());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f304b = true;
            this.f302a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f302a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m168a(1, c());
            }
            if (b()) {
                cVar.m172a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f303a;
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
            return this.f304b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f306a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f305a = com.xiaomi.push.a.a;
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
            return this.f305a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f306a = true;
            this.f305a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m140a());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
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
                cVar.m170a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f306a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f309a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f307a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f308a = null;
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
            return this.f307a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f308a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f309a = true;
            this.f307a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m140a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m138a)) {
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
            this.f308a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m170a(1, a());
            }
            if (b()) {
                cVar.m171a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f309a;
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

    /* loaded from: classes6.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f312a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f315b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f311a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f314b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f310a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f313b = 0;
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
            return this.f310a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f310a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m141a());
                        break;
                    case 18:
                        b(bVar.m141a());
                        break;
                    case 24:
                        a(bVar.m139a());
                        break;
                    case 32:
                        b(bVar.m139a());
                        break;
                    case 40:
                        a(bVar.m144a());
                        break;
                    case 48:
                        a(bVar.m147b());
                        break;
                    default:
                        if (!a(bVar, m138a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f312a = true;
            this.f311a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f311a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m172a(1, a());
            }
            if (b()) {
                cVar.m172a(2, b());
            }
            if (m251c()) {
                cVar.m169a(3, a());
            }
            if (d()) {
                cVar.m169a(4, b());
            }
            if (f()) {
                cVar.m173a(5, e());
            }
            if (g()) {
                cVar.m168a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f312a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m251c()) {
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
            return this.f313b;
        }

        public k b(long j) {
            this.d = true;
            this.f313b = j;
            return this;
        }

        public k b(String str) {
            this.f315b = true;
            this.f314b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f314b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f315b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m251c() {
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
