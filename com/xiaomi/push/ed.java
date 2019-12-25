package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class ed {

    /* loaded from: classes5.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f254a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f255b;
        private boolean d;
        private boolean e;
        private int a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f256c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f253a = Collections.emptyList();
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
            this.f254a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m129a = bVar.m129a();
                switch (m129a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 16:
                        a(bVar.m135a());
                        break;
                    case 24:
                        b(bVar.m138b());
                        break;
                    case 32:
                        b(bVar.m135a());
                        break;
                    case 42:
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

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f253a.isEmpty()) {
                this.f253a = new ArrayList();
            }
            this.f253a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f255b = true;
            this.f256c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            return this.f253a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (a()) {
                cVar.m172b(1, c());
            }
            if (m215c()) {
                cVar.m164a(2, b());
            }
            if (m216d()) {
                cVar.m159a(3, d());
            }
            if (f()) {
                cVar.m164a(4, m217e());
            }
            for (String str : a()) {
                cVar.m163a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f254a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = a() ? c.b(1, c()) + 0 : 0;
            if (m215c()) {
                b += c.a(2, b());
            }
            if (m216d()) {
                b += c.a(3, d());
            }
            int a = f() ? b + c.a(4, m217e()) : b;
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
            return this.f256c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m215c() {
            return this.f255b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m216d() {
            return this.d;
        }

        public int e() {
            return this.f253a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m217e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
