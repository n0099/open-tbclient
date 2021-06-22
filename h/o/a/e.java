package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes8.dex */
public class e<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f71810e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f71811f;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f71812e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f71813f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71814g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f71812e = jVar;
            this.f71813f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f71814g) {
                return;
            }
            try {
                this.f71813f.onCompleted();
                this.f71814g = true;
                this.f71812e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f71814g) {
                h.r.c.j(th);
                return;
            }
            this.f71814g = true;
            try {
                this.f71813f.onError(th);
                this.f71812e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f71812e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f71814g) {
                return;
            }
            try {
                this.f71813f.onNext(t);
                this.f71812e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public e(h.d<T> dVar, h.e<? super T> eVar) {
        this.f71811f = dVar;
        this.f71810e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f71811f.I(new a(jVar, this.f71810e));
    }
}
