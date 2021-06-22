package d.a.o0.b1.c.f;

import com.baidu.adp.BdUniqueId;
import d.a.c.k.e.n;
import d.a.o0.z.e0.k;
/* loaded from: classes4.dex */
public class d implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f55201e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55202f;

    /* renamed from: g  reason: collision with root package name */
    public String f55203g;

    /* renamed from: h  reason: collision with root package name */
    public a[] f55204h = new a[3];

    /* loaded from: classes4.dex */
    public static class a implements n {

        /* renamed from: e  reason: collision with root package name */
        public String f55205e;

        /* renamed from: f  reason: collision with root package name */
        public String f55206f;

        /* renamed from: g  reason: collision with root package name */
        public String f55207g;

        /* renamed from: h  reason: collision with root package name */
        public String f55208h;

        /* renamed from: i  reason: collision with root package name */
        public int f55209i;
        public int j;
        public boolean k;
        public long l;
        public long m;

        public int b() {
            return this.f55209i;
        }

        public String c() {
            return this.f55205e;
        }

        public String e() {
            return this.f55206f;
        }

        public int g() {
            return this.j;
        }

        @Override // d.a.c.k.e.n
        public BdUniqueId getType() {
            return k.A0;
        }

        public long h() {
            return this.l;
        }

        public String i() {
            return this.f55208h;
        }

        public long k() {
            return this.m;
        }

        public String l() {
            return this.f55207g;
        }

        public boolean n() {
            return this.k;
        }

        public a o(boolean z) {
            this.k = z;
            return this;
        }

        public a p(int i2) {
            this.f55209i = i2;
            return this;
        }

        public a q(String str) {
            this.f55205e = str;
            return this;
        }

        public a s(String str) {
            this.f55206f = str;
            return this;
        }

        public a t(int i2) {
            this.j = i2;
            return this;
        }

        public a u(Long l) {
            if (l == null) {
                this.l = 0L;
                return this;
            }
            this.l = l.longValue();
            return this;
        }

        public a v(String str) {
            this.f55208h = str;
            return this;
        }

        public a w(long j) {
            this.m = j;
            return this;
        }

        public a x(String str) {
            this.f55207g = str;
            return this;
        }
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.f55204h) {
            sb.append(aVar.h());
            sb.append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return k.A0;
    }
}
