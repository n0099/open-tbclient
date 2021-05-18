package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class dt {

    /* loaded from: classes7.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        public boolean f242a;

        /* renamed from: b  reason: collision with other field name */
        public boolean f243b;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37522d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37523e;

        /* renamed from: a  reason: collision with root package name */
        public int f37519a = 0;

        /* renamed from: c  reason: collision with other field name */
        public boolean f244c = false;

        /* renamed from: b  reason: collision with root package name */
        public int f37520b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37524f = false;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f241a = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public int f37521c = -1;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f37521c < 0) {
                b();
            }
            return this.f37521c;
        }

        public a a(int i2) {
            this.f242a = true;
            this.f37519a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m144a = bVar.m144a();
                if (m144a == 0) {
                    return this;
                }
                if (m144a == 8) {
                    a(bVar.c());
                } else if (m144a == 16) {
                    a(bVar.m150a());
                } else if (m144a == 24) {
                    b(bVar.m153b());
                } else if (m144a == 32) {
                    b(bVar.m150a());
                } else if (m144a == 42) {
                    a(bVar.m147a());
                } else if (!a(bVar, m144a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            if (str != null) {
                if (this.f241a.isEmpty()) {
                    this.f241a = new ArrayList();
                }
                this.f241a.add(str);
                return this;
            }
            throw null;
        }

        public a a(boolean z) {
            this.f243b = true;
            this.f244c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            return this.f241a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (a()) {
                cVar.m195b(1, c());
            }
            if (m238c()) {
                cVar.m187a(2, b());
            }
            if (m239d()) {
                cVar.m182a(3, d());
            }
            if (f()) {
                cVar.m187a(4, m240e());
            }
            for (String str : a()) {
                cVar.m186a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f242a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i2 = 0;
            int b2 = a() ? c.b(1, c()) + 0 : 0;
            if (m238c()) {
                b2 += c.a(2, b());
            }
            if (m239d()) {
                b2 += c.a(3, d());
            }
            if (f()) {
                b2 += c.a(4, m240e());
            }
            for (String str : a()) {
                i2 += c.a(str);
            }
            int size = b2 + i2 + (a().size() * 1);
            this.f37521c = size;
            return size;
        }

        public a b(int i2) {
            this.f37522d = true;
            this.f37520b = i2;
            return this;
        }

        public a b(boolean z) {
            this.f37523e = true;
            this.f37524f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f244c;
        }

        public int c() {
            return this.f37519a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m238c() {
            return this.f243b;
        }

        public int d() {
            return this.f37520b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m239d() {
            return this.f37522d;
        }

        public int e() {
            return this.f241a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m240e() {
            return this.f37524f;
        }

        public boolean f() {
            return this.f37523e;
        }
    }
}
