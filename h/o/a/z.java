package h.o.a;

import h.d;
import h.h;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class z<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f68854e;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f68855e;

        /* renamed from: f  reason: collision with root package name */
        public T f68856f;

        /* renamed from: g  reason: collision with root package name */
        public int f68857g;

        public a(h.i<? super T> iVar) {
            this.f68855e = iVar;
        }

        @Override // h.e
        public void onCompleted() {
            int i = this.f68857g;
            if (i == 0) {
                this.f68855e.b(new NoSuchElementException());
            } else if (i == 1) {
                this.f68857g = 2;
                T t = this.f68856f;
                this.f68856f = null;
                this.f68855e.c(t);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68857g == 2) {
                h.r.c.j(th);
                return;
            }
            this.f68856f = null;
            this.f68855e.b(th);
        }

        @Override // h.e
        public void onNext(T t) {
            int i = this.f68857g;
            if (i == 0) {
                this.f68857g = 1;
                this.f68856f = t;
            } else if (i == 1) {
                this.f68857g = 2;
                this.f68855e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public z(d.a<T> aVar) {
        this.f68854e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.a(aVar);
        this.f68854e.call(aVar);
    }
}
