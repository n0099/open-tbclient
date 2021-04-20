package d.a.a.s.c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c  reason: collision with root package name */
    public final d<K> f41597c;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public d.a.a.y.c<A> f41599e;

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f41595a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    public boolean f41596b = false;

    /* renamed from: d  reason: collision with root package name */
    public float f41598d = 0.0f;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public A f41600f = null;

    /* renamed from: g  reason: collision with root package name */
    public float f41601g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f41602h = -1.0f;

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public static final class c<T> implements d<T> {
        public c() {
        }

        @Override // d.a.a.s.c.a.d
        public boolean a(float f2) {
            throw new IllegalStateException("not implemented");
        }

        @Override // d.a.a.s.c.a.d
        public d.a.a.y.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // d.a.a.s.c.a.d
        public boolean c(float f2) {
            return false;
        }

        @Override // d.a.a.s.c.a.d
        public float d() {
            return 0.0f;
        }

        @Override // d.a.a.s.c.a.d
        public float e() {
            return 1.0f;
        }

        @Override // d.a.a.s.c.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        boolean a(float f2);

        d.a.a.y.a<T> b();

        boolean c(float f2);

        @FloatRange(from = 0.0d, to = 1.0d)
        float d();

        @FloatRange(from = 0.0d, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    /* loaded from: classes.dex */
    public static final class e<T> implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        public final List<? extends d.a.a.y.a<T>> f41603a;

        /* renamed from: c  reason: collision with root package name */
        public d.a.a.y.a<T> f41605c = null;

        /* renamed from: d  reason: collision with root package name */
        public float f41606d = -1.0f;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public d.a.a.y.a<T> f41604b = f(0.0f);

        public e(List<? extends d.a.a.y.a<T>> list) {
            this.f41603a = list;
        }

        @Override // d.a.a.s.c.a.d
        public boolean a(float f2) {
            if (this.f41605c == this.f41604b && this.f41606d == f2) {
                return true;
            }
            this.f41605c = this.f41604b;
            this.f41606d = f2;
            return false;
        }

        @Override // d.a.a.s.c.a.d
        @NonNull
        public d.a.a.y.a<T> b() {
            return this.f41604b;
        }

        @Override // d.a.a.s.c.a.d
        public boolean c(float f2) {
            if (this.f41604b.a(f2)) {
                return !this.f41604b.h();
            }
            this.f41604b = f(f2);
            return true;
        }

        @Override // d.a.a.s.c.a.d
        public float d() {
            return this.f41603a.get(0).e();
        }

        @Override // d.a.a.s.c.a.d
        public float e() {
            List<? extends d.a.a.y.a<T>> list = this.f41603a;
            return list.get(list.size() - 1).b();
        }

        public final d.a.a.y.a<T> f(float f2) {
            List<? extends d.a.a.y.a<T>> list = this.f41603a;
            d.a.a.y.a<T> aVar = list.get(list.size() - 1);
            if (f2 >= aVar.e()) {
                return aVar;
            }
            for (int size = this.f41603a.size() - 2; size >= 1; size--) {
                d.a.a.y.a<T> aVar2 = this.f41603a.get(size);
                if (this.f41604b != aVar2 && aVar2.a(f2)) {
                    return aVar2;
                }
            }
            return this.f41603a.get(0);
        }

        @Override // d.a.a.s.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class f<T> implements d<T> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final d.a.a.y.a<T> f41607a;

        /* renamed from: b  reason: collision with root package name */
        public float f41608b = -1.0f;

        public f(List<? extends d.a.a.y.a<T>> list) {
            this.f41607a = list.get(0);
        }

        @Override // d.a.a.s.c.a.d
        public boolean a(float f2) {
            if (this.f41608b == f2) {
                return true;
            }
            this.f41608b = f2;
            return false;
        }

        @Override // d.a.a.s.c.a.d
        public d.a.a.y.a<T> b() {
            return this.f41607a;
        }

        @Override // d.a.a.s.c.a.d
        public boolean c(float f2) {
            return !this.f41607a.h();
        }

        @Override // d.a.a.s.c.a.d
        public float d() {
            return this.f41607a.e();
        }

        @Override // d.a.a.s.c.a.d
        public float e() {
            return this.f41607a.b();
        }

        @Override // d.a.a.s.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public a(List<? extends d.a.a.y.a<K>> list) {
        this.f41597c = n(list);
    }

    public static <T> d<T> n(List<? extends d.a.a.y.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.f41595a.add(bVar);
    }

    public d.a.a.y.a<K> b() {
        d.a.a.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        d.a.a.y.a<K> b2 = this.f41597c.b();
        d.a.a.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        if (this.f41602h == -1.0f) {
            this.f41602h = this.f41597c.e();
        }
        return this.f41602h;
    }

    public float d() {
        d.a.a.y.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return b2.f41803d.getInterpolation(e());
    }

    public float e() {
        if (this.f41596b) {
            return 0.0f;
        }
        d.a.a.y.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return (this.f41598d - b2.e()) / (b2.b() - b2.e());
    }

    public float f() {
        return this.f41598d;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float g() {
        if (this.f41601g == -1.0f) {
            this.f41601g = this.f41597c.d();
        }
        return this.f41601g;
    }

    public A h() {
        float d2 = d();
        if (this.f41599e == null && this.f41597c.a(d2)) {
            return this.f41600f;
        }
        A i = i(b(), d2);
        this.f41600f = i;
        return i;
    }

    public abstract A i(d.a.a.y.a<K> aVar, float f2);

    public void j() {
        for (int i = 0; i < this.f41595a.size(); i++) {
            this.f41595a.get(i).a();
        }
    }

    public void k() {
        this.f41596b = true;
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f41597c.isEmpty()) {
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.f41598d) {
            return;
        }
        this.f41598d = f2;
        if (this.f41597c.c(f2)) {
            j();
        }
    }

    public void m(@Nullable d.a.a.y.c<A> cVar) {
        d.a.a.y.c<A> cVar2 = this.f41599e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f41599e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
