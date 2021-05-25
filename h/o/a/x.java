package h.o.a;

import h.d;
import h.h;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class x<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f68570e;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f68571e;

        /* renamed from: f  reason: collision with root package name */
        public T f68572f;

        /* renamed from: g  reason: collision with root package name */
        public int f68573g;

        public a(h.i<? super T> iVar) {
            this.f68571e = iVar;
        }

        @Override // h.e
        public void onCompleted() {
            int i2 = this.f68573g;
            if (i2 == 0) {
                this.f68571e.b(new NoSuchElementException());
            } else if (i2 == 1) {
                this.f68573g = 2;
                T t = this.f68572f;
                this.f68572f = null;
                this.f68571e.c(t);
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68573g == 2) {
                h.r.c.j(th);
                return;
            }
            this.f68572f = null;
            this.f68571e.b(th);
        }

        @Override // h.e
        public void onNext(T t) {
            int i2 = this.f68573g;
            if (i2 == 0) {
                this.f68573g = 1;
                this.f68572f = t;
            } else if (i2 == 1) {
                this.f68573g = 2;
                this.f68571e.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public x(d.a<T> aVar) {
        this.f68570e = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.a(aVar);
        this.f68570e.call(aVar);
    }
}
