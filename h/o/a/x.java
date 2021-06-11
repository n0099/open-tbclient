package h.o.a;

import h.d;
import h.h;
import java.util.NoSuchElementException;
/* loaded from: classes8.dex */
public final class x<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f71826e;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f71827e;

        /* renamed from: f  reason: collision with root package name */
        public T f71828f;

        /* renamed from: g  reason: collision with root package name */
        public int f71829g;

        public a(h.i<? super T> iVar) {
            this.f71827e = iVar;
        }

        @Override // h.e
        public void onCompleted() {
            int i2 = this.f71829g;
            if (i2 == 0) {
                this.f71827e.b(new NoSuchElementException());
            } else if (i2 == 1) {
                this.f71829g = 2;
                T t = this.f71828f;
                this.f71828f = null;
                this.f71827e.c(t);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f71829g == 2) {
                h.r.c.j(th);
                return;
            }
            this.f71828f = null;
            this.f71827e.b(th);
        }

        @Override // h.e
        public void onNext(T t) {
            int i2 = this.f71829g;
            if (i2 == 0) {
                this.f71829g = 1;
                this.f71828f = t;
            } else if (i2 == 1) {
                this.f71829g = 2;
                this.f71827e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public x(d.a<T> aVar) {
        this.f71826e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.a(aVar);
        this.f71826e.call(aVar);
    }
}
