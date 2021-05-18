package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class e<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f68407e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68408f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f68409e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f68410f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68411g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f68409e = jVar;
            this.f68410f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68411g) {
                return;
            }
            try {
                this.f68410f.onCompleted();
                this.f68411g = true;
                this.f68409e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68411g) {
                h.r.c.j(th);
                return;
            }
            this.f68411g = true;
            try {
                this.f68410f.onError(th);
                this.f68409e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68409e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f68411g) {
                return;
            }
            try {
                this.f68410f.onNext(t);
                this.f68409e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public e(h.d<T> dVar, h.e<? super T> eVar) {
        this.f68408f = dVar;
        this.f68407e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f68408f.I(new a(jVar, this.f68407e));
    }
}
