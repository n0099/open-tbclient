package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class ed {

    /* loaded from: classes6.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f253a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f254b;
        private boolean d;
        private boolean e;
        private int a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f255c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f252a = Collections.emptyList();
        private int c = -1;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        public a a(int i) {
            this.f253a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                switch (m138a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 16:
                        a(bVar.m144a());
                        break;
                    case 24:
                        b(bVar.m147b());
                        break;
                    case 32:
                        b(bVar.m144a());
                        break;
                    case 42:
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

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f252a.isEmpty()) {
                this.f252a = new ArrayList();
            }
            this.f252a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f254b = true;
            this.f255c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            return this.f252a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (a()) {
                cVar.m181b(1, c());
            }
            if (m224c()) {
                cVar.m173a(2, b());
            }
            if (m225d()) {
                cVar.m168a(3, d());
            }
            if (f()) {
                cVar.m173a(4, m226e());
            }
            for (String str : a()) {
                cVar.m172a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f253a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = a() ? c.b(1, c()) + 0 : 0;
            if (m224c()) {
                b += c.a(2, b());
            }
            if (m225d()) {
                b += c.a(3, d());
            }
            int a = f() ? b + c.a(4, m226e()) : b;
            for (String str : a()) {
                i += c.a(str);
            }
            int size = a + i + (a().size() * 1);
            this.c = size;
            return size;
        }

        public a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f255c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m224c() {
            return this.f254b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m225d() {
            return this.d;
        }

        public int e() {
            return this.f252a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m226e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
