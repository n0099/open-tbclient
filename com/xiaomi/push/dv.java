package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public final class dv {

    /* loaded from: classes10.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f239a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f240b;
        public boolean d;
        public boolean e;
        public int a = 0;

        /* renamed from: c  reason: collision with other field name */
        public boolean f241c = false;
        public int b = 0;
        public boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f238a = Collections.emptyList();
        public int c = -1;

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
            this.f239a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m270a = bVar.m270a();
                if (m270a == 0) {
                    return this;
                }
                if (m270a == 8) {
                    a(bVar.c());
                } else if (m270a == 16) {
                    a(bVar.m276a());
                } else if (m270a == 24) {
                    b(bVar.m279b());
                } else if (m270a == 32) {
                    b(bVar.m276a());
                } else if (m270a == 42) {
                    a(bVar.m273a());
                } else if (!a(bVar, m270a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            if (str != null) {
                if (this.f238a.isEmpty()) {
                    this.f238a = new ArrayList();
                }
                this.f238a.add(str);
                return this;
            }
            throw null;
        }

        public a a(boolean z) {
            this.f240b = true;
            this.f241c = z;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public List<String> m371a() {
            return this.f238a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m372a()) {
                cVar.m326b(1, c());
            }
            if (m374c()) {
                cVar.m318a(2, m373b());
            }
            if (m375d()) {
                cVar.m313a(3, d());
            }
            if (f()) {
                cVar.m318a(4, m376e());
            }
            for (String str : m371a()) {
                cVar.m317a(5, str);
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m372a() {
            return this.f239a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = m372a() ? c.b(1, c()) + 0 : 0;
            if (m374c()) {
                b += c.a(2, m373b());
            }
            if (m375d()) {
                b += c.a(3, d());
            }
            if (f()) {
                b += c.a(4, m376e());
            }
            for (String str : m371a()) {
                i += c.a(str);
            }
            int size = b + i + (m371a().size() * 1);
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

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.b()I */
        /* renamed from: b  reason: collision with other method in class */
        public boolean m373b() {
            return this.f241c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m374c() {
            return this.f240b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m375d() {
            return this.d;
        }

        public int e() {
            return this.f238a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m376e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
