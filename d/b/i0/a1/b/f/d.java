package d.b.i0.a1.b.f;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import d.b.i0.x.e0.k;
/* loaded from: classes4.dex */
public class d implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f52415e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52416f;

    /* renamed from: g  reason: collision with root package name */
    public String f52417g;

    /* renamed from: h  reason: collision with root package name */
    public a[] f52418h = new a[3];

    /* loaded from: classes4.dex */
    public static class a implements n {

        /* renamed from: e  reason: collision with root package name */
        public String f52419e;

        /* renamed from: f  reason: collision with root package name */
        public String f52420f;

        /* renamed from: g  reason: collision with root package name */
        public String f52421g;

        /* renamed from: h  reason: collision with root package name */
        public String f52422h;
        public int i;
        public int j;
        public boolean k;
        public long l;
        public long m;

        public int a() {
            return this.i;
        }

        public String e() {
            return this.f52419e;
        }

        public String f() {
            return this.f52420f;
        }

        public int g() {
            return this.j;
        }

        @Override // d.b.c.j.e.n
        public BdUniqueId getType() {
            return k.u0;
        }

        public long j() {
            return this.l;
        }

        public String k() {
            return this.f52422h;
        }

        public long l() {
            return this.m;
        }

        public String n() {
            return this.f52421g;
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
            this.f52419e = str;
            return this;
        }

        public a s(String str) {
            this.f52420f = str;
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
            this.f52422h = str;
            return this;
        }

        public a w(long j) {
            this.m = j;
            return this;
        }

        public a x(String str) {
            this.f52421g = str;
            return this;
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        for (a aVar : this.f52418h) {
            sb.append(aVar.j());
            sb.append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return k.u0;
    }
}
