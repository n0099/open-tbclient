package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67725e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f67726f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f67727e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f67728f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67729g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f67727e = jVar;
            this.f67728f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67729g) {
                return;
            }
            try {
                this.f67728f.onCompleted();
                this.f67729g = true;
                this.f67727e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67729g) {
                h.r.c.j(th);
                return;
            }
            this.f67729g = true;
            try {
                this.f67728f.onError(th);
                this.f67727e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f67727e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f67729g) {
                return;
            }
            try {
                this.f67728f.onNext(t);
                this.f67727e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public f(h.d<T> dVar, h.e<? super T> eVar) {
        this.f67726f = dVar;
        this.f67725e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f67726f.J(new a(jVar, this.f67725e));
    }
}
