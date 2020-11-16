package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes18.dex */
public final class ej {

    /* loaded from: classes18.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f238a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f239b;
        private boolean d;
        private boolean e;

        /* renamed from: a  reason: collision with root package name */
        private int f4877a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f240c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f237a = Collections.emptyList();
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
            this.f238a = true;
            this.f4877a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m147a = bVar.m147a();
                switch (m147a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 16:
                        a(bVar.m153a());
                        break;
                    case 24:
                        b(bVar.m156b());
                        break;
                    case 32:
                        b(bVar.m153a());
                        break;
                    case 42:
                        a(bVar.m150a());
                        break;
                    default:
                        if (!a(bVar, m147a)) {
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
            if (this.f237a.isEmpty()) {
                this.f237a = new ArrayList();
            }
            this.f237a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f239b = true;
            this.f240c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            return this.f237a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (a()) {
                cVar.m194b(1, c());
            }
            if (m241c()) {
                cVar.m186a(2, b());
            }
            if (m242d()) {
                cVar.m181a(3, d());
            }
            if (f()) {
                cVar.m186a(4, m243e());
            }
            for (String str : a()) {
                cVar.m185a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f238a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = a() ? c.b(1, c()) + 0 : 0;
            if (m241c()) {
                b += c.a(2, b());
            }
            if (m242d()) {
                b += c.a(3, d());
            }
            int a2 = f() ? b + c.a(4, m243e()) : b;
            for (String str : a()) {
                i += c.a(str);
            }
            int size = a2 + i + (a().size() * 1);
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
            return this.f240c;
        }

        public int c() {
            return this.f4877a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m241c() {
            return this.f239b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m242d() {
            return this.d;
        }

        public int e() {
            return this.f237a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m243e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
