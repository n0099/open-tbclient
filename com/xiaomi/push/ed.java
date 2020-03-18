package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class ed {

    /* loaded from: classes8.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f249a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f250b;
        private boolean d;
        private boolean e;
        private int a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f251c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f248a = Collections.emptyList();
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
            this.f249a = true;
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m141a = bVar.m141a();
                switch (m141a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 16:
                        a(bVar.m147a());
                        break;
                    case 24:
                        b(bVar.m150b());
                        break;
                    case 32:
                        b(bVar.m147a());
                        break;
                    case 42:
                        a(bVar.m144a());
                        break;
                    default:
                        if (!a(bVar, m141a)) {
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
            if (this.f248a.isEmpty()) {
                this.f248a = new ArrayList();
            }
            this.f248a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f250b = true;
            this.f251c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            return this.f248a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (a()) {
                cVar.m184b(1, c());
            }
            if (m227c()) {
                cVar.m176a(2, b());
            }
            if (m228d()) {
                cVar.m171a(3, d());
            }
            if (f()) {
                cVar.m176a(4, m229e());
            }
            for (String str : a()) {
                cVar.m175a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f249a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = a() ? c.b(1, c()) + 0 : 0;
            if (m227c()) {
                b += c.a(2, b());
            }
            if (m228d()) {
                b += c.a(3, d());
            }
            int a = f() ? b + c.a(4, m229e()) : b;
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
            return this.f251c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m227c() {
            return this.f250b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m228d() {
            return this.d;
        }

        public int e() {
            return this.f248a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m229e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
