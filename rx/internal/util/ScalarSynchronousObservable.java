package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.b6b;
import com.baidu.tieba.g7b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.p9b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.v5b;
import com.baidu.tieba.w5b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes9.dex */
public final class ScalarSynchronousObservable<T> extends j5b<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements b6b<w5b, q5b> {
        public final /* synthetic */ m5b a;

        /* loaded from: classes9.dex */
        public class a implements w5b {
            public final /* synthetic */ w5b a;
            public final /* synthetic */ m5b.a b;

            public a(b bVar, w5b w5bVar, m5b.a aVar) {
                this.a = w5bVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.w5b
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, m5b m5bVar) {
            this.a = m5bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public q5b call(w5b w5bVar) {
            m5b.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, w5bVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements l5b, w5b {
        public static final long serialVersionUID = -2466317989629281651L;
        public final p5b<? super T> actual;
        public final b6b<w5b, q5b> onSchedule;
        public final T value;

        public ScalarAsyncProducer(p5b<? super T> p5bVar, T t, b6b<w5b, q5b> b6bVar) {
            this.actual = p5bVar;
            this.value = t;
            this.onSchedule = b6bVar;
        }

        @Override // com.baidu.tieba.w5b
        public void call() {
            p5b<? super T> p5bVar = this.actual;
            if (p5bVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                p5bVar.onNext(obj);
                if (p5bVar.isUnsubscribed()) {
                    return;
                }
                p5bVar.onCompleted();
            } catch (Throwable th) {
                v5b.g(th, p5bVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.l5b
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
    public class a implements b6b<w5b, q5b> {
        public final /* synthetic */ g7b a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, g7b g7bVar) {
            this.a = g7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public q5b call(w5b w5bVar) {
            return this.a.a(w5bVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes9.dex */
    public class c<R> implements j5b.a<R> {
        public final /* synthetic */ b6b a;

        public c(b6b b6bVar) {
            this.a = b6bVar;
        }

        public void call(p5b<? super R> p5bVar) {
            j5b j5bVar = (j5b) this.a.call(ScalarSynchronousObservable.this.b);
            if (j5bVar instanceof ScalarSynchronousObservable) {
                p5bVar.f(ScalarSynchronousObservable.F(p5bVar, ((ScalarSynchronousObservable) j5bVar).b));
            } else {
                j5bVar.D(p9b.c(p5bVar));
            }
        }

        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((p5b) ((p5b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements j5b.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(p5b<? super T> p5bVar) {
            p5bVar.f(ScalarSynchronousObservable.F(p5bVar, this.a));
        }

        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((p5b) ((p5b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements j5b.a<T> {
        public final T a;
        public final b6b<w5b, q5b> b;

        public e(T t, b6b<w5b, q5b> b6bVar) {
            this.a = t;
            this.b = b6bVar;
        }

        public void call(p5b<? super T> p5bVar) {
            p5bVar.f(new ScalarAsyncProducer(p5bVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((p5b) ((p5b) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements l5b {
        public final p5b<? super T> a;
        public final T b;
        public boolean c;

        public f(p5b<? super T> p5bVar, T t) {
            this.a = p5bVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.l5b
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
                p5b<? super T> p5bVar = this.a;
                if (p5bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    p5bVar.onNext(obj);
                    if (p5bVar.isUnsubscribed()) {
                        return;
                    }
                    p5bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    v5b.g(th, p5bVar, obj);
                    return;
                }
            }
            throw new IllegalStateException("n >= required but it was " + j);
        }
    }

    public T G() {
        return this.b;
    }

    public ScalarSynchronousObservable(T t) {
        super(s9b.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> E(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> j5b<R> H(b6b<? super T, ? extends j5b<? extends R>> b6bVar) {
        return j5b.a(new c(b6bVar));
    }

    public j5b<T> I(m5b m5bVar) {
        b6b bVar;
        if (m5bVar instanceof g7b) {
            bVar = new a(this, (g7b) m5bVar);
        } else {
            bVar = new b(this, m5bVar);
        }
        return j5b.a(new e(this.b, bVar));
    }

    public static <T> l5b F(p5b<? super T> p5bVar, T t) {
        if (c) {
            return new SingleProducer(p5bVar, t);
        }
        return new f(p5bVar, t);
    }
}
