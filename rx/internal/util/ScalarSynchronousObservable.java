package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.a7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.k6c;
import com.baidu.tieba.l8c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.t6c;
import com.baidu.tieba.u6c;
import com.baidu.tieba.uac;
import com.baidu.tieba.xac;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends h6c<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements a7c<u6c, o6c> {
        public final /* synthetic */ k6c a;

        /* loaded from: classes2.dex */
        public class a implements u6c {
            public final /* synthetic */ u6c a;
            public final /* synthetic */ k6c.a b;

            public a(b bVar, u6c u6cVar, k6c.a aVar) {
                this.a = u6cVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.u6c
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, k6c k6cVar) {
            this.a = k6cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public o6c call(u6c u6cVar) {
            k6c.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, u6cVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements j6c, u6c {
        public static final long serialVersionUID = -2466317989629281651L;
        public final n6c<? super T> actual;
        public final a7c<u6c, o6c> onSchedule;
        public final T value;

        public ScalarAsyncProducer(n6c<? super T> n6cVar, T t, a7c<u6c, o6c> a7cVar) {
            this.actual = n6cVar;
            this.value = t;
            this.onSchedule = a7cVar;
        }

        @Override // com.baidu.tieba.u6c
        public void call() {
            n6c<? super T> n6cVar = this.actual;
            if (n6cVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                n6cVar.onNext(obj);
                if (n6cVar.isUnsubscribed()) {
                    return;
                }
                n6cVar.onCompleted();
            } catch (Throwable th) {
                t6c.g(th, n6cVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.j6c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    this.actual.b(this.onSchedule.call(this));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements a7c<u6c, o6c> {
        public final /* synthetic */ l8c a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, l8c l8cVar) {
            this.a = l8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public o6c call(u6c u6cVar) {
            return this.a.a(u6cVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements h6c.a<R> {
        public final /* synthetic */ a7c a;

        public c(a7c a7cVar) {
            this.a = a7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super R> n6cVar) {
            h6c h6cVar = (h6c) this.a.call(ScalarSynchronousObservable.this.b);
            if (h6cVar instanceof ScalarSynchronousObservable) {
                n6cVar.f(ScalarSynchronousObservable.Q(n6cVar, ((ScalarSynchronousObservable) h6cVar).b));
            } else {
                h6cVar.O(uac.c(n6cVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements h6c.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super T> n6cVar) {
            n6cVar.f(ScalarSynchronousObservable.Q(n6cVar, this.a));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements h6c.a<T> {
        public final T a;
        public final a7c<u6c, o6c> b;

        public e(T t, a7c<u6c, o6c> a7cVar) {
            this.a = t;
            this.b = a7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super T> n6cVar) {
            n6cVar.f(new ScalarAsyncProducer(n6cVar, this.a, this.b));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements j6c {
        public final n6c<? super T> a;
        public final T b;
        public boolean c;

        public f(n6c<? super T> n6cVar, T t) {
            this.a = n6cVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.j6c
        public void request(long j) {
            if (this.c) {
                return;
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    return;
                }
                this.c = true;
                n6c<? super T> n6cVar = this.a;
                if (n6cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    n6cVar.onNext(obj);
                    if (n6cVar.isUnsubscribed()) {
                        return;
                    }
                    n6cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    t6c.g(th, n6cVar, obj);
                    return;
                }
            }
            throw new IllegalStateException("n >= required but it was " + j);
        }
    }

    public T R() {
        return this.b;
    }

    public ScalarSynchronousObservable(T t) {
        super(xac.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> h6c<R> S(a7c<? super T, ? extends h6c<? extends R>> a7cVar) {
        return h6c.d(new c(a7cVar));
    }

    public h6c<T> T(k6c k6cVar) {
        a7c bVar;
        if (k6cVar instanceof l8c) {
            bVar = new a(this, (l8c) k6cVar);
        } else {
            bVar = new b(this, k6cVar);
        }
        return h6c.d(new e(this.b, bVar));
    }

    public static <T> j6c Q(n6c<? super T> n6cVar, T t) {
        if (c) {
            return new SingleProducer(n6cVar, t);
        }
        return new f(n6cVar, t);
    }
}
