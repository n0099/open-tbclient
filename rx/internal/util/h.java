package rx.internal.util;

import rx.g;
import rx.h;
/* loaded from: classes6.dex */
public final class h<T> extends rx.h<T> {
    final T value;

    public static <T> h<T> ck(T t) {
        return new h<>(t);
    }

    protected h(final T t) {
        super(new h.a<T>() { // from class: rx.internal.util.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: b */
            public void call(rx.i<? super T> iVar) {
                iVar.onSuccess((Object) t);
            }
        });
        this.value = t;
    }

    public rx.h<T> h(rx.g gVar) {
        return gVar instanceof rx.internal.schedulers.b ? a(new a((rx.internal.schedulers.b) gVar, this.value)) : a(new b(gVar, this.value));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> implements h.a<T> {
        private final rx.internal.schedulers.b nSA;
        private final T value;

        a(rx.internal.schedulers.b bVar, T t) {
            this.nSA = bVar;
            this.value = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: b */
        public void call(rx.i<? super T> iVar) {
            iVar.add(this.nSA.g(new c(iVar, this.value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b<T> implements h.a<T> {
        private final rx.g scheduler;
        private final T value;

        b(rx.g gVar, T t) {
            this.scheduler = gVar;
            this.value = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: b */
        public void call(rx.i<? super T> iVar) {
            g.a createWorker = this.scheduler.createWorker();
            iVar.add(createWorker);
            createWorker.c(new c(iVar, this.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c<T> implements rx.functions.a {
        private final rx.i<? super T> nSB;
        private final T value;

        c(rx.i<? super T> iVar, T t) {
            this.nSB = iVar;
            this.value = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // rx.functions.a
        public void call() {
            try {
                this.nSB.onSuccess((T) this.value);
            } catch (Throwable th) {
                this.nSB.onError(th);
            }
        }
    }
}
