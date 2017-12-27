package com.xiaomi.push.protobuf;

import com.google.protobuf.micro.c;
import com.google.protobuf.micro.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.xiaomi.push.protobuf.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0200a extends e {
        private boolean a;
        private boolean c;
        private boolean e;
        private boolean g;
        private int b = 0;
        private boolean d = false;
        private int f = 0;
        private boolean h = false;
        private List<String> i = Collections.emptyList();
        private int j = -1;

        public static C0200a b(byte[] bArr) {
            return (C0200a) new C0200a().a(bArr);
        }

        public static C0200a c(com.google.protobuf.micro.b bVar) {
            return new C0200a().a(bVar);
        }

        @Override // com.google.protobuf.micro.e
        public int a() {
            if (this.j < 0) {
                b();
            }
            return this.j;
        }

        public C0200a a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public C0200a a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.i.isEmpty()) {
                this.i = new ArrayList();
            }
            this.i.add(str);
            return this;
        }

        public C0200a a(boolean z) {
            this.c = true;
            this.d = z;
            return this;
        }

        @Override // com.google.protobuf.micro.e
        public void a(c cVar) {
            if (e()) {
                cVar.b(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
            if (k()) {
                cVar.a(4, j());
            }
            for (String str : l()) {
                cVar.a(5, str);
            }
        }

        @Override // com.google.protobuf.micro.e
        public int b() {
            int i = 0;
            int df = e() ? c.df(1, d()) + 0 : 0;
            if (g()) {
                df += c.W(2, f());
            }
            if (i()) {
                df += c.c(3, h());
            }
            int W = k() ? df + c.W(4, j()) : df;
            for (String str : l()) {
                i += c.b(str);
            }
            int size = W + i + (l().size() * 1);
            this.j = size;
            return size;
        }

        public C0200a b(int i) {
            this.e = true;
            this.f = i;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.micro.e
        /* renamed from: b */
        public C0200a a(com.google.protobuf.micro.b bVar) {
            while (true) {
                int a = bVar.a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a(bVar.i());
                        break;
                    case 16:
                        a(bVar.f());
                        break;
                    case 24:
                        b(bVar.e());
                        break;
                    case 32:
                        b(bVar.f());
                        break;
                    case 42:
                        a(bVar.g());
                        break;
                    default:
                        if (!a(bVar, a)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public C0200a b(boolean z) {
            this.g = true;
            this.h = z;
            return this;
        }

        public int d() {
            return this.b;
        }

        public boolean e() {
            return this.a;
        }

        public boolean f() {
            return this.d;
        }

        public boolean g() {
            return this.c;
        }

        public int h() {
            return this.f;
        }

        public boolean i() {
            return this.e;
        }

        public boolean j() {
            return this.h;
        }

        public boolean k() {
            return this.g;
        }

        public List<String> l() {
            return this.i;
        }

        public int m() {
            return this.i.size();
        }
    }
}
