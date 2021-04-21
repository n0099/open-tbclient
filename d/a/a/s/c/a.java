package d.a.a.s.c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c  reason: collision with root package name */
    public final d<K> f41692c;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public d.a.a.y.c<A> f41694e;

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f41690a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    public boolean f41691b = false;

    /* renamed from: d  reason: collision with root package name */
    public float f41693d = 0.0f;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public A f41695f = null;

    /* renamed from: g  reason: collision with root package name */
    public float f41696g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f41697h = -1.0f;

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
        public final List<? extends d.a.a.y.a<T>> f41698a;

        /* renamed from: c  reason: collision with root package name */
        public d.a.a.y.a<T> f41700c = null;

        /* renamed from: d  reason: collision with root package name */
        public float f41701d = -1.0f;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public d.a.a.y.a<T> f41699b = f(0.0f);

        public e(List<? extends d.a.a.y.a<T>> list) {
            this.f41698a = list;
        }

        @Override // d.a.a.s.c.a.d
        public boolean a(float f2) {
            if (this.f41700c == this.f41699b && this.f41701d == f2) {
                return true;
            }
            this.f41700c = this.f41699b;
            this.f41701d = f2;
            return false;
        }

        @Override // d.a.a.s.c.a.d
        @NonNull
        public d.a.a.y.a<T> b() {
            return this.f41699b;
        }

        @Override // d.a.a.s.c.a.d
        public boolean c(float f2) {
            if (this.f41699b.a(f2)) {
                return !this.f41699b.h();
            }
            this.f41699b = f(f2);
            return true;
        }

        @Override // d.a.a.s.c.a.d
        public float d() {
            return this.f41698a.get(0).e();
        }

        @Override // d.a.a.s.c.a.d
        public float e() {
            List<? extends d.a.a.y.a<T>> list = this.f41698a;
            return list.get(list.size() - 1).b();
        }

        public final d.a.a.y.a<T> f(float f2) {
            List<? extends d.a.a.y.a<T>> list = this.f41698a;
            d.a.a.y.a<T> aVar = list.get(list.size() - 1);
            if (f2 >= aVar.e()) {
                return aVar;
            }
            for (int size = this.f41698a.size() - 2; size >= 1; size--) {
                d.a.a.y.a<T> aVar2 = this.f41698a.get(size);
                if (this.f41699b != aVar2 && aVar2.a(f2)) {
                    return aVar2;
                }
            }
            return this.f41698a.get(0);
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
        public final d.a.a.y.a<T> f41702a;

        /* renamed from: b  reason: collision with root package name */
        public float f41703b = -1.0f;

        public f(List<? extends d.a.a.y.a<T>> list) {
            this.f41702a = list.get(0);
        }

        @Override // d.a.a.s.c.a.d
        public boolean a(float f2) {
            if (this.f41703b == f2) {
                return true;
            }
            this.f41703b = f2;
            return false;
        }

        @Override // d.a.a.s.c.a.d
        public d.a.a.y.a<T> b() {
            return this.f41702a;
        }

        @Override // d.a.a.s.c.a.d
        public boolean c(float f2) {
            return !this.f41702a.h();
        }

        @Override // d.a.a.s.c.a.d
        public float d() {
            return this.f41702a.e();
        }

        @Override // d.a.a.s.c.a.d
        public float e() {
            return this.f41702a.b();
        }

        @Override // d.a.a.s.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public a(List<? extends d.a.a.y.a<K>> list) {
        this.f41692c = n(list);
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
        this.f41690a.add(bVar);
    }

    public d.a.a.y.a<K> b() {
        d.a.a.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        d.a.a.y.a<K> b2 = this.f41692c.b();
        d.a.a.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        if (this.f41697h == -1.0f) {
            this.f41697h = this.f41692c.e();
        }
        return this.f41697h;
    }

    public float d() {
        d.a.a.y.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return b2.f41898d.getInterpolation(e());
    }

    public float e() {
        if (this.f41691b) {
            return 0.0f;
        }
        d.a.a.y.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return (this.f41693d - b2.e()) / (b2.b() - b2.e());
    }

    public float f() {
        return this.f41693d;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float g() {
        if (this.f41696g == -1.0f) {
            this.f41696g = this.f41692c.d();
        }
        return this.f41696g;
    }

    public A h() {
        float d2 = d();
        if (this.f41694e == null && this.f41692c.a(d2)) {
            return this.f41695f;
        }
        A i = i(b(), d2);
        this.f41695f = i;
        return i;
    }

    public abstract A i(d.a.a.y.a<K> aVar, float f2);

    public void j() {
        for (int i = 0; i < this.f41690a.size(); i++) {
            this.f41690a.get(i).a();
        }
    }

    public void k() {
        this.f41691b = true;
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f41692c.isEmpty()) {
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.f41693d) {
            return;
        }
        this.f41693d = f2;
        if (this.f41692c.c(f2)) {
            j();
        }
    }

    public void m(@Nullable d.a.a.y.c<A> cVar) {
        d.a.a.y.c<A> cVar2 = this.f41694e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f41694e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
