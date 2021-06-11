package h.o.a;

import h.d;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes8.dex */
public class e<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f71706e;

    /* renamed from: f  reason: collision with root package name */
    public final h.d<T> f71707f;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f71708e;

        /* renamed from: f  reason: collision with root package name */
        public final h.e<? super T> f71709f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71710g;

        public a(h.j<? super T> jVar, h.e<? super T> eVar) {
            super(jVar);
            this.f71708e = jVar;
            this.f71709f = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f71710g) {
                return;
            }
            try {
                this.f71709f.onCompleted();
                this.f71710g = true;
                this.f71708e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f71710g) {
                h.r.c.j(th);
                return;
            }
            this.f71710g = true;
            try {
                this.f71709f.onError(th);
                this.f71708e.onError(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f71708e.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f71710g) {
                return;
            }
            try {
                this.f71709f.onNext(t);
                this.f71708e.onNext(t);
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public e(h.d<T> dVar, h.e<? super T> eVar) {
        this.f71707f = dVar;
        this.f71706e = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        this.f71707f.I(new a(jVar, this.f71706e));
    }
}
