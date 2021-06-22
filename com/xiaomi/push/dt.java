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
        public boolean f41233d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41234e;

        /* renamed from: a  reason: collision with root package name */
        public int f41230a = 0;

        /* renamed from: c  reason: collision with other field name */
        public boolean f244c = false;

        /* renamed from: b  reason: collision with root package name */
        public int f41231b = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f41235f = false;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f241a = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public int f41232c = -1;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f41232c < 0) {
                b();
            }
            return this.f41232c;
        }

        public a a(int i2) {
            this.f242a = true;
            this.f41230a = i2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m143a = bVar.m143a();
                if (m143a == 0) {
                    return this;
                }
                if (m143a == 8) {
                    a(bVar.c());
                } else if (m143a == 16) {
                    a(bVar.m149a());
                } else if (m143a == 24) {
                    b(bVar.m152b());
                } else if (m143a == 32) {
                    b(bVar.m149a());
                } else if (m143a == 42) {
                    a(bVar.m146a());
                } else if (!a(bVar, m143a)) {
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
                cVar.m194b(1, c());
            }
            if (m237c()) {
                cVar.m186a(2, b());
            }
            if (m238d()) {
                cVar.m181a(3, d());
            }
            if (f()) {
                cVar.m186a(4, m239e());
            }
            for (String str : a()) {
                cVar.m185a(5, str);
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
            if (m237c()) {
                b2 += c.a(2, b());
            }
            if (m238d()) {
                b2 += c.a(3, d());
            }
            if (f()) {
                b2 += c.a(4, m239e());
            }
            for (String str : a()) {
                i2 += c.a(str);
            }
            int size = b2 + i2 + (a().size() * 1);
            this.f41232c = size;
            return size;
        }

        public a b(int i2) {
            this.f41233d = true;
            this.f41231b = i2;
            return this;
        }

        public a b(boolean z) {
            this.f41234e = true;
            this.f41235f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f244c;
        }

        public int c() {
            return this.f41230a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m237c() {
            return this.f243b;
        }

        public int d() {
            return this.f41231b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m238d() {
            return this.f41233d;
        }

        public int e() {
            return this.f241a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m239e() {
            return this.f41235f;
        }

        public boolean f() {
            return this.f41234e;
        }
    }
}
