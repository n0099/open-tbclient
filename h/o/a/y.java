package h.o.a;

import h.d;
import h.h;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class y<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f67843e;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f67844e;

        /* renamed from: f  reason: collision with root package name */
        public T f67845f;

        /* renamed from: g  reason: collision with root package name */
        public int f67846g;

        public a(h.i<? super T> iVar) {
            this.f67844e = iVar;
        }

        @Override // h.e
        public void onCompleted() {
            int i = this.f67846g;
            if (i == 0) {
                this.f67844e.b(new NoSuchElementException());
            } else if (i == 1) {
                this.f67846g = 2;
                T t = this.f67845f;
                this.f67845f = null;
                this.f67844e.c(t);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67846g == 2) {
                h.r.c.j(th);
                return;
            }
            this.f67845f = null;
            this.f67844e.b(th);
        }

        @Override // h.e
        public void onNext(T t) {
            int i = this.f67846g;
            if (i == 0) {
                this.f67846g = 1;
                this.f67845f = t;
            } else if (i == 1) {
                this.f67846g = 2;
                this.f67844e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public y(d.a<T> aVar) {
        this.f67843e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.a(aVar);
        this.f67843e.call(aVar);
    }
}
