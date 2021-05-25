package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class e<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f68450e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68451f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f68452e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f68453f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68454g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f68452e = jVar;
            this.f68453f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68454g) {
                return;
            }
            try {
                this.f68453f.onCompleted();
                this.f68454g = true;
                this.f68452e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68454g) {
                h.r.c.j(th);
                return;
            }
            this.f68454g = true;
            try {
                this.f68453f.onError(th);
                this.f68452e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68452e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f68454g) {
                return;
            }
            try {
                this.f68453f.onNext(t);
                this.f68452e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public e(h.d<T> dVar, h.e<? super T> eVar) {
        this.f68451f = dVar;
        this.f68450e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f68451f.I(new a(jVar, this.f68450e));
    }
}
