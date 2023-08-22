package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.a8c;
import com.baidu.tieba.bcc;
import com.baidu.tieba.g8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.p9c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import com.baidu.tieba.ybc;
import com.baidu.tieba.z7c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends n7c<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements g8c<a8c, u7c> {
        public final /* synthetic */ q7c a;

        /* loaded from: classes2.dex */
        public class a implements a8c {
            public final /* synthetic */ a8c a;
            public final /* synthetic */ q7c.a b;

            public a(b bVar, a8c a8cVar, q7c.a aVar) {
                this.a = a8cVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.a8c
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, q7c q7cVar) {
            this.a = q7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public u7c call(a8c a8cVar) {
            q7c.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, a8cVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements p7c, a8c {
        public static final long serialVersionUID = -2466317989629281651L;
        public final t7c<? super T> actual;
        public final g8c<a8c, u7c> onSchedule;
        public final T value;

        public ScalarAsyncProducer(t7c<? super T> t7cVar, T t, g8c<a8c, u7c> g8cVar) {
            this.actual = t7cVar;
            this.value = t;
            this.onSchedule = g8cVar;
        }

        @Override // com.baidu.tieba.a8c
        public void call() {
            t7c<? super T> t7cVar = this.actual;
            if (t7cVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                t7cVar.onNext(obj);
                if (t7cVar.isUnsubscribed()) {
                    return;
                }
                t7cVar.onCompleted();
            } catch (Throwable th) {
                z7c.g(th, t7cVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.p7c
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
    public class a implements g8c<a8c, u7c> {
        public final /* synthetic */ p9c a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, p9c p9cVar) {
            this.a = p9cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public u7c call(a8c a8cVar) {
            return this.a.a(a8cVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements n7c.a<R> {
        public final /* synthetic */ g8c a;

        public c(g8c g8cVar) {
            this.a = g8cVar;
        }

        public void call(t7c<? super R> t7cVar) {
            n7c n7cVar = (n7c) this.a.call(ScalarSynchronousObservable.this.b);
            if (n7cVar instanceof ScalarSynchronousObservable) {
                t7cVar.f(ScalarSynchronousObservable.Q(t7cVar, ((ScalarSynchronousObservable) n7cVar).b));
            } else {
                n7cVar.O(ybc.c(t7cVar));
            }
        }

        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t7c) ((t7c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements n7c.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(t7c<? super T> t7cVar) {
            t7cVar.f(ScalarSynchronousObservable.Q(t7cVar, this.a));
        }

        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t7c) ((t7c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements n7c.a<T> {
        public final T a;
        public final g8c<a8c, u7c> b;

        public e(T t, g8c<a8c, u7c> g8cVar) {
            this.a = t;
            this.b = g8cVar;
        }

        public void call(t7c<? super T> t7cVar) {
            t7cVar.f(new ScalarAsyncProducer(t7cVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t7c) ((t7c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements p7c {
        public final t7c<? super T> a;
        public final T b;
        public boolean c;

        public f(t7c<? super T> t7cVar, T t) {
            this.a = t7cVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.p7c
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
                t7c<? super T> t7cVar = this.a;
                if (t7cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    t7cVar.onNext(obj);
                    if (t7cVar.isUnsubscribed()) {
                        return;
                    }
                    t7cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    z7c.g(th, t7cVar, obj);
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
        super(bcc.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> n7c<R> S(g8c<? super T, ? extends n7c<? extends R>> g8cVar) {
        return n7c.d(new c(g8cVar));
    }

    public n7c<T> T(q7c q7cVar) {
        g8c bVar;
        if (q7cVar instanceof p9c) {
            bVar = new a(this, (p9c) q7cVar);
        } else {
            bVar = new b(this, q7cVar);
        }
        return n7c.d(new e(this.b, bVar));
    }

    public static <T> p7c Q(t7c<? super T> t7cVar, T t) {
        if (c) {
            return new SingleProducer(t7cVar, t);
        }
        return new f(t7cVar, t);
    }
}
