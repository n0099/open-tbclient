package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.acc;
import com.baidu.tieba.b8c;
import com.baidu.tieba.c8c;
import com.baidu.tieba.dcc;
import com.baidu.tieba.i8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.r9c;
import com.baidu.tieba.s7c;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends p7c<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements i8c<c8c, w7c> {
        public final /* synthetic */ s7c a;

        /* loaded from: classes2.dex */
        public class a implements c8c {
            public final /* synthetic */ c8c a;
            public final /* synthetic */ s7c.a b;

            public a(b bVar, c8c c8cVar, s7c.a aVar) {
                this.a = c8cVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.c8c
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, s7c s7cVar) {
            this.a = s7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public w7c call(c8c c8cVar) {
            s7c.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, c8cVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements r7c, c8c {
        public static final long serialVersionUID = -2466317989629281651L;
        public final v7c<? super T> actual;
        public final i8c<c8c, w7c> onSchedule;
        public final T value;

        public ScalarAsyncProducer(v7c<? super T> v7cVar, T t, i8c<c8c, w7c> i8cVar) {
            this.actual = v7cVar;
            this.value = t;
            this.onSchedule = i8cVar;
        }

        @Override // com.baidu.tieba.c8c
        public void call() {
            v7c<? super T> v7cVar = this.actual;
            if (v7cVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                v7cVar.onNext(obj);
                if (v7cVar.isUnsubscribed()) {
                    return;
                }
                v7cVar.onCompleted();
            } catch (Throwable th) {
                b8c.g(th, v7cVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.r7c
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
    public class a implements i8c<c8c, w7c> {
        public final /* synthetic */ r9c a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, r9c r9cVar) {
            this.a = r9cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public w7c call(c8c c8cVar) {
            return this.a.a(c8cVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements p7c.a<R> {
        public final /* synthetic */ i8c a;

        public c(i8c i8cVar) {
            this.a = i8cVar;
        }

        public void call(v7c<? super R> v7cVar) {
            p7c p7cVar = (p7c) this.a.call(ScalarSynchronousObservable.this.b);
            if (p7cVar instanceof ScalarSynchronousObservable) {
                v7cVar.f(ScalarSynchronousObservable.Q(v7cVar, ((ScalarSynchronousObservable) p7cVar).b));
            } else {
                p7cVar.O(acc.c(v7cVar));
            }
        }

        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((v7c) ((v7c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements p7c.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(v7c<? super T> v7cVar) {
            v7cVar.f(ScalarSynchronousObservable.Q(v7cVar, this.a));
        }

        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((v7c) ((v7c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements p7c.a<T> {
        public final T a;
        public final i8c<c8c, w7c> b;

        public e(T t, i8c<c8c, w7c> i8cVar) {
            this.a = t;
            this.b = i8cVar;
        }

        public void call(v7c<? super T> v7cVar) {
            v7cVar.f(new ScalarAsyncProducer(v7cVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.p7c.a, com.baidu.tieba.d8c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((v7c) ((v7c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements r7c {
        public final v7c<? super T> a;
        public final T b;
        public boolean c;

        public f(v7c<? super T> v7cVar, T t) {
            this.a = v7cVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.r7c
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
                v7c<? super T> v7cVar = this.a;
                if (v7cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    v7cVar.onNext(obj);
                    if (v7cVar.isUnsubscribed()) {
                        return;
                    }
                    v7cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    b8c.g(th, v7cVar, obj);
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
        super(dcc.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> p7c<R> S(i8c<? super T, ? extends p7c<? extends R>> i8cVar) {
        return p7c.d(new c(i8cVar));
    }

    public p7c<T> T(s7c s7cVar) {
        i8c bVar;
        if (s7cVar instanceof r9c) {
            bVar = new a(this, (r9c) s7cVar);
        } else {
            bVar = new b(this, s7cVar);
        }
        return p7c.d(new e(this.b, bVar));
    }

    public static <T> r7c Q(v7c<? super T> v7cVar, T t) {
        if (c) {
            return new SingleProducer(v7cVar, t);
        }
        return new f(v7cVar, t);
    }
}
