package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class e<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67727e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f67728f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f67729e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f67730f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67731g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f67729e = jVar;
            this.f67730f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67731g) {
                return;
            }
            try {
                this.f67730f.onCompleted();
                this.f67731g = true;
                this.f67729e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67731g) {
                h.r.c.j(th);
                return;
            }
            this.f67731g = true;
            try {
                this.f67730f.onError(th);
                this.f67729e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f67729e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f67731g) {
                return;
            }
            try {
                this.f67730f.onNext(t);
                this.f67729e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public e(h.d<T> dVar, h.e<? super T> eVar) {
        this.f67728f = dVar;
        this.f67727e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f67728f.I(new a(jVar, this.f67727e));
    }
}
