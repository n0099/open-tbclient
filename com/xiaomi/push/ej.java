package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class ej {

    /* loaded from: classes6.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f315a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f316b;
        private boolean d;
        private boolean e;

        /* renamed from: a  reason: collision with root package name */
        private int f14269a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f317c = false;

        /* renamed from: b  reason: collision with root package name */
        private int f14270b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f314a = Collections.emptyList();
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
            this.f315a = true;
            this.f14269a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m174a = bVar.m174a();
                switch (m174a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 16:
                        a(bVar.m180a());
                        break;
                    case 24:
                        b(bVar.m183b());
                        break;
                    case 32:
                        b(bVar.m180a());
                        break;
                    case 42:
                        a(bVar.m177a());
                        break;
                    default:
                        if (!a(bVar, m174a)) {
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
            if (this.f314a.isEmpty()) {
                this.f314a = new ArrayList();
            }
            this.f314a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f316b = true;
            this.f317c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            return this.f314a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (a()) {
                cVar.m221b(1, c());
            }
            if (m268c()) {
                cVar.m213a(2, b());
            }
            if (m269d()) {
                cVar.m208a(3, d());
            }
            if (f()) {
                cVar.m213a(4, m270e());
            }
            for (String str : a()) {
                cVar.m212a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f315a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b2 = a() ? c.b(1, c()) + 0 : 0;
            if (m268c()) {
                b2 += c.a(2, b());
            }
            if (m269d()) {
                b2 += c.a(3, d());
            }
            int a2 = f() ? b2 + c.a(4, m270e()) : b2;
            for (String str : a()) {
                i += c.a(str);
            }
            int size = a2 + i + (a().size() * 1);
            this.c = size;
            return size;
        }

        public a b(int i) {
            this.d = true;
            this.f14270b = i;
            return this;
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public boolean b() {
            return this.f317c;
        }

        public int c() {
            return this.f14269a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m268c() {
            return this.f316b;
        }

        public int d() {
            return this.f14270b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m269d() {
            return this.d;
        }

        public int e() {
            return this.f314a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m270e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
