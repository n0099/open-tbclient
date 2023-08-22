package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public final class dv {

    /* loaded from: classes10.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f240a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f241b;
        public boolean d;
        public boolean e;
        public int a = 0;

        /* renamed from: c  reason: collision with other field name */
        public boolean f242c = false;
        public int b = 0;
        public boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f239a = Collections.emptyList();
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
            this.f240a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m268a = bVar.m268a();
                if (m268a == 0) {
                    return this;
                }
                if (m268a == 8) {
                    a(bVar.c());
                } else if (m268a == 16) {
                    a(bVar.m274a());
                } else if (m268a == 24) {
                    b(bVar.m277b());
                } else if (m268a == 32) {
                    b(bVar.m274a());
                } else if (m268a == 42) {
                    a(bVar.m271a());
                } else if (!a(bVar, m268a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            if (str != null) {
                if (this.f239a.isEmpty()) {
                    this.f239a = new ArrayList();
                }
                this.f239a.add(str);
                return this;
            }
            throw null;
        }

        public a a(boolean z) {
            this.f241b = true;
            this.f242c = z;
            return this;
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public List<String> m369a() {
            return this.f239a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m370a()) {
                cVar.m324b(1, c());
            }
            if (m372c()) {
                cVar.m316a(2, m371b());
            }
            if (m373d()) {
                cVar.m311a(3, d());
            }
            if (f()) {
                cVar.m316a(4, m374e());
            }
            for (String str : m369a()) {
                cVar.m315a(5, str);
            }
        }

        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()I */
        /* JADX DEBUG: Possible override for method com.xiaomi.push.e.a()[B */
        /* renamed from: a  reason: collision with other method in class */
        public boolean m370a() {
            return this.f240a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = m370a() ? c.b(1, c()) + 0 : 0;
            if (m372c()) {
                b += c.a(2, m371b());
            }
            if (m373d()) {
                b += c.a(3, d());
            }
            if (f()) {
                b += c.a(4, m374e());
            }
            for (String str : m369a()) {
                i += c.a(str);
            }
            int size = b + i + (m369a().size() * 1);
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
        public boolean m371b() {
            return this.f242c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m372c() {
            return this.f241b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m373d() {
            return this.d;
        }

        public int e() {
            return this.f239a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m374e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
