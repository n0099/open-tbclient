package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f67730e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f67731f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f67732e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f67733f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67734g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f67732e = jVar;
            this.f67733f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67734g) {
                return;
            }
            try {
                this.f67733f.onCompleted();
                this.f67734g = true;
                this.f67732e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67734g) {
                h.r.c.j(th);
                return;
            }
            this.f67734g = true;
            try {
                this.f67733f.onError(th);
                this.f67732e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f67732e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f67734g) {
                return;
            }
            try {
                this.f67733f.onNext(t);
                this.f67732e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public f(h.d<T> dVar, h.e<? super T> eVar) {
        this.f67731f = dVar;
        this.f67730e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f67731f.J(new a(jVar, this.f67730e));
    }
}
