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
        public boolean f40375d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40376e;

        /* renamed from: a  reason: collision with root package name */
        public int f40372a = 0;

        /* renamed from: c  reason: collision with other field name */
        public boolean f244c = false;

        /* renamed from: b  reason: collision with root package name */
        public int f40373b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f40377f = false;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f241a = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public int f40374c = -1;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f40374c < 0) {
                b();
            }
            return this.f40374c;
        }

        public a a(int i) {
            this.f242a = true;
            this.f40372a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m138a = bVar.m138a();
                if (m138a == 0) {
                    return this;
                }
                if (m138a == 8) {
                    a(bVar.c());
                } else if (m138a == 16) {
                    a(bVar.m144a());
                } else if (m138a == 24) {
                    b(bVar.m147b());
                } else if (m138a == 32) {
                    b(bVar.m144a());
                } else if (m138a == 42) {
                    a(bVar.m141a());
                } else if (!a(bVar, m138a)) {
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
                cVar.m189b(1, c());
            }
            if (m232c()) {
                cVar.m181a(2, b());
            }
            if (m233d()) {
                cVar.m176a(3, d());
            }
            if (f()) {
                cVar.m181a(4, m234e());
            }
            for (String str : a()) {
                cVar.m180a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f242a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b2 = a() ? c.b(1, c()) + 0 : 0;
            if (m232c()) {
                b2 += c.a(2, b());
            }
            if (m233d()) {
                b2 += c.a(3, d());
            }
            if (f()) {
                b2 += c.a(4, m234e());
            }
            for (String str : a()) {
                i += c.a(str);
            }
            int size = b2 + i + (a().size() * 1);
            this.f40374c = size;
            return size;
        }

        public a b(int i) {
            this.f40375d = true;
            this.f40373b = i;
            return this;
        }

        public a b(boolean z) {
            this.f40376e = true;
            this.f40377f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f244c;
        }

        public int c() {
            return this.f40372a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m232c() {
            return this.f243b;
        }

        public int d() {
            return this.f40373b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m233d() {
            return this.f40375d;
        }

        public int e() {
            return this.f241a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m234e() {
            return this.f40377f;
        }

        public boolean f() {
            return this.f40376e;
        }
    }
}
