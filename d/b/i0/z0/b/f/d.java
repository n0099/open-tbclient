package d.b.i0.z0.b.f;

import com.baidu.adp.BdUniqueId;
import d.b.b.j.e.n;
import d.b.i0.x.e0.k;
/* loaded from: classes3.dex */
public class d implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f62796e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62797f;

    /* renamed from: g  reason: collision with root package name */
    public String f62798g;

    /* renamed from: h  reason: collision with root package name */
    public a[] f62799h = new a[3];

    /* loaded from: classes3.dex */
    public static class a implements n {

        /* renamed from: e  reason: collision with root package name */
        public String f62800e;

        /* renamed from: f  reason: collision with root package name */
        public String f62801f;

        /* renamed from: g  reason: collision with root package name */
        public String f62802g;

        /* renamed from: h  reason: collision with root package name */
        public String f62803h;
        public int i;
        public int j;
        public boolean k;
        public long l;
        public long m;

        public int a() {
            return this.i;
        }

        public String e() {
            return this.f62800e;
        }

        public String f() {
            return this.f62801f;
        }

        public int g() {
            return this.j;
        }

        @Override // d.b.b.j.e.n
        public BdUniqueId getType() {
            return k.u0;
        }

        public long j() {
            return this.l;
        }

        public String k() {
            return this.f62803h;
        }

        public long l() {
            return this.m;
        }

        public String n() {
            return this.f62802g;
        }

        public boolean o() {
            return this.k;
        }

        public a p(boolean z) {
            this.k = z;
            return this;
        }

        public a q(int i) {
            this.i = i;
            return this;
        }

        public a r(String str) {
            this.f62800e = str;
            return this;
        }

        public a s(String str) {
            this.f62801f = str;
            return this;
        }

        public a t(int i) {
            this.j = i;
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
            this.f62803h = str;
            return this;
        }

        public a w(long j) {
            this.m = j;
            return this;
        }

        public a x(String str) {
            this.f62802g = str;
            return this;
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.f62799h) {
            sb.append(aVar.j());
            sb.append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return k.u0;
    }
}
