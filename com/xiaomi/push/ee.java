package com.xiaomi.push;
/* loaded from: classes5.dex */
public final class ee {

    /* loaded from: classes5.dex */
    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f259a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f261b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f263c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f265d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f267e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f268f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f257a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f258a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f260b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f262c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f264d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f266e = "";
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
            return this.f257a;
        }

        @Override // com.xiaomi.push.e
        public a a() {
            this.f268f = false;
            this.f264d = "";
            return this;
        }

        public a a(int i) {
            this.f259a = true;
            this.a = i;
            return this;
        }

        public a a(long j) {
            this.f261b = true;
            this.f257a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m138b());
                        break;
                    case 16:
                        a(bVar.m139b());
                        break;
                    case 26:
                        a(bVar.m132a());
                        break;
                    case 34:
                        b(bVar.m132a());
                        break;
                    case 42:
                        c(bVar.m132a());
                        break;
                    case 50:
                        d(bVar.m132a());
                        break;
                    case 58:
                        e(bVar.m132a());
                        break;
                    case 64:
                        b(bVar.m138b());
                        break;
                    case 72:
                        c(bVar.m138b());
                        break;
                    case 80:
                        d(bVar.m138b());
                        break;
                    case 90:
                        f(bVar.m132a());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public a a(String str) {
            this.f263c = true;
            this.f258a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f258a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m159a(1, c());
            }
            if (b()) {
                cVar.m173b(2, a());
            }
            if (m219c()) {
                cVar.m163a(3, a());
            }
            if (m221d()) {
                cVar.m163a(4, b());
            }
            if (m223e()) {
                cVar.m163a(5, m218c());
            }
            if (m225f()) {
                cVar.m163a(6, m220d());
            }
            if (g()) {
                cVar.m163a(7, m222e());
            }
            if (h()) {
                cVar.m159a(8, d());
            }
            if (i()) {
                cVar.m159a(9, e());
            }
            if (j()) {
                cVar.m159a(10, f());
            }
            if (k()) {
                cVar.m163a(11, m224f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.b(2, a());
            }
            if (m219c()) {
                a += com.xiaomi.push.c.a(3, a());
            }
            if (m221d()) {
                a += com.xiaomi.push.c.a(4, b());
            }
            if (m223e()) {
                a += com.xiaomi.push.c.a(5, m218c());
            }
            if (m225f()) {
                a += com.xiaomi.push.c.a(6, m220d());
            }
            if (g()) {
                a += com.xiaomi.push.c.a(7, m222e());
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
                a += com.xiaomi.push.c.a(11, m224f());
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
            this.f265d = true;
            this.f260b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f260b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f261b;
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
            this.f267e = true;
            this.f262c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m218c() {
            return this.f262c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m219c() {
            return this.f263c;
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
            this.f268f = true;
            this.f264d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m220d() {
            return this.f264d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m221d() {
            return this.f265d;
        }

        public int e() {
            return this.c;
        }

        public a e(String str) {
            this.g = true;
            this.f266e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m222e() {
            return this.f266e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m223e() {
            return this.f267e;
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
        public String m224f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m225f() {
            return this.f268f;
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

    /* loaded from: classes5.dex */
    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f269a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f271c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f272d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f270b = false;
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
            this.f271c = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m135a());
                        break;
                    case 24:
                        a(bVar.m138b());
                        break;
                    case 32:
                        b(bVar.m138b());
                        break;
                    case 40:
                        c(bVar.m138b());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public b a(boolean z) {
            this.f269a = true;
            this.f270b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m164a(1, a());
            }
            if (m226c()) {
                cVar.m159a(3, c());
            }
            if (m227d()) {
                cVar.m159a(4, d());
            }
            if (m228e()) {
                cVar.m159a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f270b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m226c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m227d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m228e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public b b(int i) {
            this.f272d = true;
            this.b = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f269a;
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
        public boolean m226c() {
            return this.f271c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m227d() {
            return this.f272d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m228e() {
            return this.e;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f274a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f275b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f276c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f277d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f278e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f279f;

        /* renamed from: a  reason: collision with other field name */
        private String f273a = "";
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
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m132a());
                        break;
                    case 18:
                        b(bVar.m132a());
                        break;
                    case 26:
                        c(bVar.m132a());
                        break;
                    case 34:
                        d(bVar.m132a());
                        break;
                    case 42:
                        e(bVar.m132a());
                        break;
                    case 50:
                        f(bVar.m132a());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c a(String str) {
            this.f274a = true;
            this.f273a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f273a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m163a(1, a());
            }
            if (b()) {
                cVar.m163a(2, b());
            }
            if (m229c()) {
                cVar.m163a(3, c());
            }
            if (m230d()) {
                cVar.m163a(4, d());
            }
            if (m231e()) {
                cVar.m163a(5, e());
            }
            if (m232f()) {
                cVar.m163a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f274a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m229c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            if (m230d()) {
                a += com.xiaomi.push.c.a(4, d());
            }
            if (m231e()) {
                a += com.xiaomi.push.c.a(5, e());
            }
            if (m232f()) {
                a += com.xiaomi.push.c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public c b(String str) {
            this.f275b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f275b;
        }

        public c c(String str) {
            this.f276c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m229c() {
            return this.f276c;
        }

        public c d(String str) {
            this.f277d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m230d() {
            return this.f277d;
        }

        public c e(String str) {
            this.f278e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m231e() {
            return this.f278e;
        }

        public c f(String str) {
            this.f279f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m232f() {
            return this.f279f;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f281a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f283c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f282b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f280a = "";
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
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m135a());
                        break;
                    case 18:
                        a(bVar.m132a());
                        break;
                    case 26:
                        b(bVar.m132a());
                        break;
                    case 34:
                        c(bVar.m132a());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d a(String str) {
            this.f283c = true;
            this.f280a = str;
            return this;
        }

        public d a(boolean z) {
            this.f281a = true;
            this.f282b = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f280a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (b()) {
                cVar.m164a(1, a());
            }
            if (m233c()) {
                cVar.m163a(2, a());
            }
            if (d()) {
                cVar.m163a(3, b());
            }
            if (e()) {
                cVar.m163a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f282b;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = b() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (m233c()) {
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
            return this.f281a;
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
        public boolean m233c() {
            return this.f283c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f286a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f288b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f290c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f292d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f293e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f294f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f285a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f287b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f289c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f291d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private b f284a = null;
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
            return this.f284a;
        }

        public e a(int i) {
            this.f286a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m132a());
                        break;
                    case 26:
                        b(bVar.m132a());
                        break;
                    case 34:
                        c(bVar.m132a());
                        break;
                    case 40:
                        b(bVar.m138b());
                        break;
                    case 50:
                        d(bVar.m132a());
                        break;
                    case 58:
                        e(bVar.m132a());
                        break;
                    case 66:
                        f(bVar.m132a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m138b());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
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
            this.f284a = bVar;
            return this;
        }

        public e a(String str) {
            this.f288b = true;
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
                cVar.m172b(1, c());
            }
            if (b()) {
                cVar.m163a(2, a());
            }
            if (m235c()) {
                cVar.m163a(3, b());
            }
            if (m237d()) {
                cVar.m163a(4, m234c());
            }
            if (m239e()) {
                cVar.m159a(5, d());
            }
            if (m240f()) {
                cVar.m163a(6, m236d());
            }
            if (g()) {
                cVar.m163a(7, m238e());
            }
            if (h()) {
                cVar.m163a(8, f());
            }
            if (i()) {
                cVar.m162a(9, (com.xiaomi.push.e) a());
            }
            if (j()) {
                cVar.m159a(10, e());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f286a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int b = a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (b()) {
                b += com.xiaomi.push.c.a(2, a());
            }
            if (m235c()) {
                b += com.xiaomi.push.c.a(3, b());
            }
            if (m237d()) {
                b += com.xiaomi.push.c.a(4, m234c());
            }
            if (m239e()) {
                b += com.xiaomi.push.c.a(5, d());
            }
            if (m240f()) {
                b += com.xiaomi.push.c.a(6, m236d());
            }
            if (g()) {
                b += com.xiaomi.push.c.a(7, m238e());
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
            this.f293e = true;
            this.b = i;
            return this;
        }

        public e b(String str) {
            this.f290c = true;
            this.f287b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f287b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f288b;
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
            this.f292d = true;
            this.f289c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m234c() {
            return this.f289c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m235c() {
            return this.f290c;
        }

        public int d() {
            return this.b;
        }

        public e d(String str) {
            this.f294f = true;
            this.f291d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m236d() {
            return this.f291d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m237d() {
            return this.f292d;
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
        public String m238e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m239e() {
            return this.f293e;
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
        public boolean m240f() {
            return this.f294f;
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

    /* loaded from: classes5.dex */
    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f297a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f298b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f296a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private b f295a = null;
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
            return this.f295a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m132a());
                        break;
                    case 18:
                        b(bVar.m132a());
                        break;
                    case 26:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m129a)) {
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
            this.f295a = bVar;
            return this;
        }

        public f a(String str) {
            this.f297a = true;
            this.f296a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f296a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m163a(1, a());
            }
            if (b()) {
                cVar.m163a(2, b());
            }
            if (c()) {
                cVar.m162a(3, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f297a;
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
            this.f298b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f298b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f300a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f301b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f302c;

        /* renamed from: a  reason: collision with other field name */
        private String f299a = "";
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
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m132a());
                        break;
                    case 18:
                        b(bVar.m132a());
                        break;
                    case 26:
                        c(bVar.m132a());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public g a(String str) {
            this.f300a = true;
            this.f299a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f299a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m163a(1, a());
            }
            if (b()) {
                cVar.m163a(2, b());
            }
            if (m241c()) {
                cVar.m163a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f300a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m241c()) {
                a += com.xiaomi.push.c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public g b(String str) {
            this.f301b = true;
            this.b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f301b;
        }

        public g c(String str) {
            this.f302c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m241c() {
            return this.f302c;
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f304a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f305b;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f303a = "";
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
            this.f304a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.m138b());
                        break;
                    case 18:
                        a(bVar.m132a());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public h a(String str) {
            this.f305b = true;
            this.f303a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f303a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m159a(1, c());
            }
            if (b()) {
                cVar.m163a(2, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f304a;
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
            return this.f305b;
        }

        public int c() {
            return this.a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f307a;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f306a = com.xiaomi.push.a.a;
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
            return this.f306a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f307a = true;
            this.f306a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m131a());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
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
                cVar.m161a(1, a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f307a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f310a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private com.xiaomi.push.a f308a = com.xiaomi.push.a.a;

        /* renamed from: a  reason: collision with other field name */
        private b f309a = null;
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
            return this.f308a;
        }

        @Override // com.xiaomi.push.e
        public b a() {
            return this.f309a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f310a = true;
            this.f308a = aVar;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m131a());
                        break;
                    case 18:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    default:
                        if (!a(bVar, m129a)) {
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
            this.f309a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m161a(1, a());
            }
            if (b()) {
                cVar.m162a(2, (com.xiaomi.push.e) a());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f310a;
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

    /* loaded from: classes5.dex */
    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f313a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f316b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f312a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f315b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f311a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f314b = 0;
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
            return this.f311a;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f311a = j;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 10:
                        a(bVar.m132a());
                        break;
                    case 18:
                        b(bVar.m132a());
                        break;
                    case 24:
                        a(bVar.m130a());
                        break;
                    case 32:
                        b(bVar.m130a());
                        break;
                    case 40:
                        a(bVar.m135a());
                        break;
                    case 48:
                        a(bVar.m138b());
                        break;
                    default:
                        if (!a(bVar, m129a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public k a(String str) {
            this.f313a = true;
            this.f312a = str;
            return this;
        }

        public k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String a() {
            return this.f312a;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) {
            if (a()) {
                cVar.m163a(1, a());
            }
            if (b()) {
                cVar.m163a(2, b());
            }
            if (m242c()) {
                cVar.m160a(3, a());
            }
            if (d()) {
                cVar.m160a(4, b());
            }
            if (f()) {
                cVar.m164a(5, e());
            }
            if (g()) {
                cVar.m159a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f313a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int a = a() ? 0 + com.xiaomi.push.c.a(1, a()) : 0;
            if (b()) {
                a += com.xiaomi.push.c.a(2, b());
            }
            if (m242c()) {
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
            return this.f314b;
        }

        public k b(long j) {
            this.d = true;
            this.f314b = j;
            return this;
        }

        public k b(String str) {
            this.f316b = true;
            this.f315b = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public String b() {
            return this.f315b;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f316b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m242c() {
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
