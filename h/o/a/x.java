package h.o.a;

import h.d;
import h.h;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class x<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f68527e;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f68528e;

        /* renamed from: f  reason: collision with root package name */
        public T f68529f;

        /* renamed from: g  reason: collision with root package name */
        public int f68530g;

        public a(h.i<? super T> iVar) {
            this.f68528e = iVar;
        }

        @Override // h.e
        public void onCompleted() {
            int i2 = this.f68530g;
            if (i2 == 0) {
                this.f68528e.b(new NoSuchElementException());
            } else if (i2 == 1) {
                this.f68530g = 2;
                T t = this.f68529f;
                this.f68529f = null;
                this.f68528e.c(t);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68530g == 2) {
                h.r.c.j(th);
                return;
            }
            this.f68529f = null;
            this.f68528e.b(th);
        }

        @Override // h.e
        public void onNext(T t) {
            int i2 = this.f68530g;
            if (i2 == 0) {
                this.f68530g = 1;
                this.f68529f = t;
            } else if (i2 == 1) {
                this.f68530g = 2;
                this.f68528e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public x(d.a<T> aVar) {
        this.f68527e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.a(aVar);
        this.f68527e.call(aVar);
    }
}
