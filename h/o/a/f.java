package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f68884e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f68885f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f68886e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f68887f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68888g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f68886e = jVar;
            this.f68887f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68888g) {
                return;
            }
            try {
                this.f68887f.onCompleted();
                this.f68888g = true;
                this.f68886e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68888g) {
                h.r.c.j(th);
                return;
            }
            this.f68888g = true;
            try {
                this.f68887f.onError(th);
                this.f68886e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68886e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f68888g) {
                return;
            }
            try {
                this.f68887f.onNext(t);
                this.f68886e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public f(h.d<T> dVar, h.e<? super T> eVar) {
        this.f68885f = dVar;
        this.f68884e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f68885f.L(new a(jVar, this.f68884e));
    }
}
