package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.a3b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.h1b;
import com.baidu.tieba.i1b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.r1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.x1b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes9.dex */
public final class ScalarSynchronousObservable<T> extends f1b<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements x1b<s1b, m1b> {
        public final /* synthetic */ i1b a;

        /* loaded from: classes9.dex */
        public class a implements s1b {
            public final /* synthetic */ s1b a;
            public final /* synthetic */ i1b.a b;

            public a(b bVar, s1b s1bVar, i1b.a aVar) {
                this.a = s1bVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.s1b
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, i1b i1bVar) {
            this.a = i1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public m1b call(s1b s1bVar) {
            i1b.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, s1bVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements h1b, s1b {
        public static final long serialVersionUID = -2466317989629281651L;
        public final l1b<? super T> actual;
        public final x1b<s1b, m1b> onSchedule;
        public final T value;

        public ScalarAsyncProducer(l1b<? super T> l1bVar, T t, x1b<s1b, m1b> x1bVar) {
            this.actual = l1bVar;
            this.value = t;
            this.onSchedule = x1bVar;
        }

        @Override // com.baidu.tieba.s1b
        public void call() {
            l1b<? super T> l1bVar = this.actual;
            if (l1bVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                l1bVar.onNext(obj);
                if (l1bVar.isUnsubscribed()) {
                    return;
                }
                l1bVar.onCompleted();
            } catch (Throwable th) {
                r1b.g(th, l1bVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.h1b
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
    public class a implements x1b<s1b, m1b> {
        public final /* synthetic */ a3b a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, a3b a3bVar) {
            this.a = a3bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public m1b call(s1b s1bVar) {
            return this.a.a(s1bVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes9.dex */
    public class c<R> implements f1b.a<R> {
        public final /* synthetic */ x1b a;

        public c(x1b x1bVar) {
            this.a = x1bVar;
        }

        public void call(l1b<? super R> l1bVar) {
            f1b f1bVar = (f1b) this.a.call(ScalarSynchronousObservable.this.b);
            if (f1bVar instanceof ScalarSynchronousObservable) {
                l1bVar.f(ScalarSynchronousObservable.D(l1bVar, ((ScalarSynchronousObservable) f1bVar).b));
            } else {
                f1bVar.B(j5b.c(l1bVar));
            }
        }

        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l1b) ((l1b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements f1b.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(l1b<? super T> l1bVar) {
            l1bVar.f(ScalarSynchronousObservable.D(l1bVar, this.a));
        }

        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l1b) ((l1b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements f1b.a<T> {
        public final T a;
        public final x1b<s1b, m1b> b;

        public e(T t, x1b<s1b, m1b> x1bVar) {
            this.a = t;
            this.b = x1bVar;
        }

        public void call(l1b<? super T> l1bVar) {
            l1bVar.f(new ScalarAsyncProducer(l1bVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l1b) ((l1b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements h1b {
        public final l1b<? super T> a;
        public final T b;
        public boolean c;

        public f(l1b<? super T> l1bVar, T t) {
            this.a = l1bVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.h1b
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
                l1b<? super T> l1bVar = this.a;
                if (l1bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    l1bVar.onNext(obj);
                    if (l1bVar.isUnsubscribed()) {
                        return;
                    }
                    l1bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    r1b.g(th, l1bVar, obj);
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
        super(m5b.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> C(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> f1b<R> F(x1b<? super T, ? extends f1b<? extends R>> x1bVar) {
        return f1b.a(new c(x1bVar));
    }

    public f1b<T> G(i1b i1bVar) {
        x1b bVar;
        if (i1bVar instanceof a3b) {
            bVar = new a(this, (a3b) i1bVar);
        } else {
            bVar = new b(this, i1bVar);
        }
        return f1b.a(new e(this.b, bVar));
    }

    public static <T> h1b D(l1b<? super T> l1bVar, T t) {
        if (c) {
            return new SingleProducer(l1bVar, t);
        }
        return new f(l1bVar, t);
    }
}
