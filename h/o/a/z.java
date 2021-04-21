package h.o.a;

import h.d;
import h.h;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class z<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f69001e;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f69002e;

        /* renamed from: f  reason: collision with root package name */
        public T f69003f;

        /* renamed from: g  reason: collision with root package name */
        public int f69004g;

        public a(h.i<? super T> iVar) {
            this.f69002e = iVar;
        }

        @Override // h.e
        public void onCompleted() {
            int i = this.f69004g;
            if (i == 0) {
                this.f69002e.b(new NoSuchElementException());
            } else if (i == 1) {
                this.f69004g = 2;
                T t = this.f69003f;
                this.f69003f = null;
                this.f69002e.c(t);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f69004g == 2) {
                h.r.c.j(th);
                return;
            }
            this.f69003f = null;
            this.f69002e.b(th);
        }

        @Override // h.e
        public void onNext(T t) {
            int i = this.f69004g;
            if (i == 0) {
                this.f69004g = 1;
                this.f69003f = t;
            } else if (i == 1) {
                this.f69004g = 2;
                this.f69002e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public z(d.a<T> aVar) {
        this.f69001e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.a(aVar);
        this.f69001e.call(aVar);
    }
}
