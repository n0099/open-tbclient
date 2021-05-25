package d.a.n0.b1.b.f;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import d.a.n0.z.e0.k;
/* loaded from: classes4.dex */
public class d implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f51393e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51394f;

    /* renamed from: g  reason: collision with root package name */
    public String f51395g;

    /* renamed from: h  reason: collision with root package name */
    public a[] f51396h = new a[3];

    /* loaded from: classes4.dex */
    public static class a implements n {

        /* renamed from: e  reason: collision with root package name */
        public String f51397e;

        /* renamed from: f  reason: collision with root package name */
        public String f51398f;

        /* renamed from: g  reason: collision with root package name */
        public String f51399g;

        /* renamed from: h  reason: collision with root package name */
        public String f51400h;

        /* renamed from: i  reason: collision with root package name */
        public int f51401i;
        public int j;
        public boolean k;
        public long l;
        public long m;

        public int c() {
            return this.f51401i;
        }

        public String e() {
            return this.f51397e;
        }

        public String f() {
            return this.f51398f;
        }

        @Override // d.a.c.j.e.n
        public BdUniqueId getType() {
            return k.v0;
        }

        public int h() {
            return this.j;
        }

        public long i() {
            return this.l;
        }

        public String k() {
            return this.f51400h;
        }

        public long l() {
            return this.m;
        }

        public String m() {
            return this.f51399g;
        }

        public boolean o() {
            return this.k;
        }

        public a p(boolean z) {
            this.k = z;
            return this;
        }

        public a q(int i2) {
            this.f51401i = i2;
            return this;
        }

        public a r(String str) {
            this.f51397e = str;
            return this;
        }

        public a s(String str) {
            this.f51398f = str;
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
            this.f51400h = str;
            return this;
        }

        public a w(long j) {
            this.m = j;
            return this;
        }

        public a x(String str) {
            this.f51399g = str;
            return this;
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.f51396h) {
            sb.append(aVar.i());
            sb.append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k.v0;
    }
}
