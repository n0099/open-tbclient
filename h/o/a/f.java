package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f68737e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68738f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f68739e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f68740f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68741g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f68739e = jVar;
            this.f68740f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68741g) {
                return;
            }
            try {
                this.f68740f.onCompleted();
                this.f68741g = true;
                this.f68739e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68741g) {
                h.r.c.j(th);
                return;
            }
            this.f68741g = true;
            try {
                this.f68740f.onError(th);
                this.f68739e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68739e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f68741g) {
                return;
            }
            try {
                this.f68740f.onNext(t);
                this.f68739e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public f(h.d<T> dVar, h.e<? super T> eVar) {
        this.f68738f = dVar;
        this.f68737e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f68738f.L(new a(jVar, this.f68737e));
    }
}
