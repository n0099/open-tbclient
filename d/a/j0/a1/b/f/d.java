package d.a.j0.a1.b.f;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import d.a.j0.x.e0.k;
/* loaded from: classes4.dex */
public class d implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f50531e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50532f;

    /* renamed from: g  reason: collision with root package name */
    public String f50533g;

    /* renamed from: h  reason: collision with root package name */
    public a[] f50534h = new a[3];

    /* loaded from: classes4.dex */
    public static class a implements n {

        /* renamed from: e  reason: collision with root package name */
        public String f50535e;

        /* renamed from: f  reason: collision with root package name */
        public String f50536f;

        /* renamed from: g  reason: collision with root package name */
        public String f50537g;

        /* renamed from: h  reason: collision with root package name */
        public String f50538h;

        /* renamed from: i  reason: collision with root package name */
        public int f50539i;
        public int j;
        public boolean k;
        public long l;
        public long m;

        public int c() {
            return this.f50539i;
        }

        public String e() {
            return this.f50535e;
        }

        public String f() {
            return this.f50536f;
        }

        @Override // d.a.c.j.e.n
        public BdUniqueId getType() {
            return k.u0;
        }

        public int h() {
            return this.j;
        }

        public long i() {
            return this.l;
        }

        public String k() {
            return this.f50538h;
        }

        public long l() {
            return this.m;
        }

        public String m() {
            return this.f50537g;
        }

        public boolean o() {
            return this.k;
        }

        public a p(boolean z) {
            this.k = z;
            return this;
        }

        public a q(int i2) {
            this.f50539i = i2;
            return this;
        }

        public a r(String str) {
            this.f50535e = str;
            return this;
        }

        public a s(String str) {
            this.f50536f = str;
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
            this.f50538h = str;
            return this;
        }

        public a w(long j) {
            this.m = j;
            return this;
        }

        public a x(String str) {
            this.f50537g = str;
            return this;
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.f50534h) {
            sb.append(aVar.i());
            sb.append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k.u0;
    }
}
