package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.a2b;
import com.baidu.tieba.f2b;
import com.baidu.tieba.i3b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.r5b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.u5b;
import com.baidu.tieba.z1b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes9.dex */
public final class ScalarSynchronousObservable<T> extends n1b<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements f2b<a2b, u1b> {
        public final /* synthetic */ q1b a;

        /* loaded from: classes9.dex */
        public class a implements a2b {
            public final /* synthetic */ a2b a;
            public final /* synthetic */ q1b.a b;

            public a(b bVar, a2b a2bVar, q1b.a aVar) {
                this.a = a2bVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.a2b
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, q1b q1bVar) {
            this.a = q1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public u1b call(a2b a2bVar) {
            q1b.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, a2bVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements p1b, a2b {
        public static final long serialVersionUID = -2466317989629281651L;
        public final t1b<? super T> actual;
        public final f2b<a2b, u1b> onSchedule;
        public final T value;

        public ScalarAsyncProducer(t1b<? super T> t1bVar, T t, f2b<a2b, u1b> f2bVar) {
            this.actual = t1bVar;
            this.value = t;
            this.onSchedule = f2bVar;
        }

        @Override // com.baidu.tieba.a2b
        public void call() {
            t1b<? super T> t1bVar = this.actual;
            if (t1bVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                t1bVar.onNext(obj);
                if (t1bVar.isUnsubscribed()) {
                    return;
                }
                t1bVar.onCompleted();
            } catch (Throwable th) {
                z1b.g(th, t1bVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.p1b
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

    /* loaded from: classes9.dex */
    public class a implements f2b<a2b, u1b> {
        public final /* synthetic */ i3b a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, i3b i3bVar) {
            this.a = i3bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public u1b call(a2b a2bVar) {
            return this.a.a(a2bVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes9.dex */
    public class c<R> implements n1b.a<R> {
        public final /* synthetic */ f2b a;

        public c(f2b f2bVar) {
            this.a = f2bVar;
        }

        public void call(t1b<? super R> t1bVar) {
            n1b n1bVar = (n1b) this.a.call(ScalarSynchronousObservable.this.b);
            if (n1bVar instanceof ScalarSynchronousObservable) {
                t1bVar.f(ScalarSynchronousObservable.D(t1bVar, ((ScalarSynchronousObservable) n1bVar).b));
            } else {
                n1bVar.B(r5b.c(t1bVar));
            }
        }

        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t1b) ((t1b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements n1b.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(t1b<? super T> t1bVar) {
            t1bVar.f(ScalarSynchronousObservable.D(t1bVar, this.a));
        }

        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t1b) ((t1b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements n1b.a<T> {
        public final T a;
        public final f2b<a2b, u1b> b;

        public e(T t, f2b<a2b, u1b> f2bVar) {
            this.a = t;
            this.b = f2bVar;
        }

        public void call(t1b<? super T> t1bVar) {
            t1bVar.f(new ScalarAsyncProducer(t1bVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t1b) ((t1b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements p1b {
        public final t1b<? super T> a;
        public final T b;
        public boolean c;

        public f(t1b<? super T> t1bVar, T t) {
            this.a = t1bVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.p1b
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
                t1b<? super T> t1bVar = this.a;
                if (t1bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    t1bVar.onNext(obj);
                    if (t1bVar.isUnsubscribed()) {
                        return;
                    }
                    t1bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    z1b.g(th, t1bVar, obj);
                    return;
                }
            }
            throw new IllegalStateException("n >= required but it was " + j);
        }
    }

    public T E() {
        return this.b;
    }

    public ScalarSynchronousObservable(T t) {
        super(u5b.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> C(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> n1b<R> F(f2b<? super T, ? extends n1b<? extends R>> f2bVar) {
        return n1b.a(new c(f2bVar));
    }

    public n1b<T> G(q1b q1bVar) {
        f2b bVar;
        if (q1bVar instanceof i3b) {
            bVar = new a(this, (i3b) q1bVar);
        } else {
            bVar = new b(this, q1bVar);
        }
        return n1b.a(new e(this.b, bVar));
    }

    public static <T> p1b D(t1b<? super T> t1bVar, T t) {
        if (c) {
            return new SingleProducer(t1bVar, t);
        }
        return new f(t1bVar, t);
    }
}
