package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.a1c;
import com.baidu.tieba.d1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.h5c;
import com.baidu.tieba.j1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.k5c;
import com.baidu.tieba.p1c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.y2c;
import com.baidu.tieba.z0c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends x0c<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements p1c<k1c, e1c> {
        public final /* synthetic */ a1c a;

        /* loaded from: classes2.dex */
        public class a implements k1c {
            public final /* synthetic */ k1c a;
            public final /* synthetic */ a1c.a b;

            public a(b bVar, k1c k1cVar, a1c.a aVar) {
                this.a = k1cVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.k1c
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, a1c a1cVar) {
            this.a = a1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public e1c call(k1c k1cVar) {
            a1c.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, k1cVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements z0c, k1c {
        public static final long serialVersionUID = -2466317989629281651L;
        public final d1c<? super T> actual;
        public final p1c<k1c, e1c> onSchedule;
        public final T value;

        public ScalarAsyncProducer(d1c<? super T> d1cVar, T t, p1c<k1c, e1c> p1cVar) {
            this.actual = d1cVar;
            this.value = t;
            this.onSchedule = p1cVar;
        }

        @Override // com.baidu.tieba.k1c
        public void call() {
            d1c<? super T> d1cVar = this.actual;
            if (d1cVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                d1cVar.onNext(obj);
                if (d1cVar.isUnsubscribed()) {
                    return;
                }
                d1cVar.onCompleted();
            } catch (Throwable th) {
                j1c.g(th, d1cVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.z0c
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
    public class a implements p1c<k1c, e1c> {
        public final /* synthetic */ y2c a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, y2c y2cVar) {
            this.a = y2cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public e1c call(k1c k1cVar) {
            return this.a.a(k1cVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements x0c.a<R> {
        public final /* synthetic */ p1c a;

        public c(p1c p1cVar) {
            this.a = p1cVar;
        }

        public void call(d1c<? super R> d1cVar) {
            x0c x0cVar = (x0c) this.a.call(ScalarSynchronousObservable.this.b);
            if (x0cVar instanceof ScalarSynchronousObservable) {
                d1cVar.f(ScalarSynchronousObservable.Q(d1cVar, ((ScalarSynchronousObservable) x0cVar).b));
            } else {
                x0cVar.O(h5c.c(d1cVar));
            }
        }

        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((d1c) ((d1c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements x0c.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(d1c<? super T> d1cVar) {
            d1cVar.f(ScalarSynchronousObservable.Q(d1cVar, this.a));
        }

        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((d1c) ((d1c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements x0c.a<T> {
        public final T a;
        public final p1c<k1c, e1c> b;

        public e(T t, p1c<k1c, e1c> p1cVar) {
            this.a = t;
            this.b = p1cVar;
        }

        public void call(d1c<? super T> d1cVar) {
            d1cVar.f(new ScalarAsyncProducer(d1cVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((d1c) ((d1c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements z0c {
        public final d1c<? super T> a;
        public final T b;
        public boolean c;

        public f(d1c<? super T> d1cVar, T t) {
            this.a = d1cVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.z0c
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
                d1c<? super T> d1cVar = this.a;
                if (d1cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    d1cVar.onNext(obj);
                    if (d1cVar.isUnsubscribed()) {
                        return;
                    }
                    d1cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    j1c.g(th, d1cVar, obj);
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
        super(k5c.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> x0c<R> S(p1c<? super T, ? extends x0c<? extends R>> p1cVar) {
        return x0c.d(new c(p1cVar));
    }

    public x0c<T> T(a1c a1cVar) {
        p1c bVar;
        if (a1cVar instanceof y2c) {
            bVar = new a(this, (y2c) a1cVar);
        } else {
            bVar = new b(this, a1cVar);
        }
        return x0c.d(new e(this.b, bVar));
    }

    public static <T> z0c Q(d1c<? super T> d1cVar, T t) {
        if (c) {
            return new SingleProducer(d1cVar, t);
        }
        return new f(d1cVar, t);
    }
}
