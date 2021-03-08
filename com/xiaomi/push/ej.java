package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class ej {

    /* loaded from: classes5.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f235a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f236b;
        private boolean d;
        private boolean e;

        /* renamed from: a  reason: collision with root package name */
        private int f8340a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f237c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f234a = Collections.emptyList();
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
            this.f235a = true;
            this.f8340a = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m148a = bVar.m148a();
                switch (m148a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.c());
                        break;
                    case 16:
                        a(bVar.m154a());
                        break;
                    case 24:
                        b(bVar.m157b());
                        break;
                    case 32:
                        b(bVar.m154a());
                        break;
                    case 42:
                        a(bVar.m151a());
                        break;
                    default:
                        if (!a(bVar, m148a)) {
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
            if (this.f234a.isEmpty()) {
                this.f234a = new ArrayList();
            }
            this.f234a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f236b = true;
            this.f237c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public List<String> a() {
            return this.f234a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (a()) {
                cVar.m195b(1, c());
            }
            if (m242c()) {
                cVar.m187a(2, b());
            }
            if (m243d()) {
                cVar.m182a(3, d());
            }
            if (f()) {
                cVar.m187a(4, m244e());
            }
            for (String str : a()) {
                cVar.m186a(5, str);
            }
        }

        @Override // com.xiaomi.push.e
        public boolean a() {
            return this.f235a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = a() ? c.b(1, c()) + 0 : 0;
            if (m242c()) {
                b += c.a(2, b());
            }
            if (m243d()) {
                b += c.a(3, d());
            }
            int a2 = f() ? b + c.a(4, m244e()) : b;
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
            return this.f237c;
        }

        public int c() {
            return this.f8340a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m242c() {
            return this.f236b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m243d() {
            return this.d;
        }

        public int e() {
            return this.f234a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m244e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
