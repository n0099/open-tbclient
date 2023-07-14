package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.e6c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.m2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.v3c;
import com.baidu.tieba.w1c;
import com.baidu.tieba.x1c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends u1c<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements m2c<h2c, b2c> {
        public final /* synthetic */ x1c a;

        /* loaded from: classes2.dex */
        public class a implements h2c {
            public final /* synthetic */ h2c a;
            public final /* synthetic */ x1c.a b;

            public a(b bVar, h2c h2cVar, x1c.a aVar) {
                this.a = h2cVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.h2c
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, x1c x1cVar) {
            this.a = x1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public b2c call(h2c h2cVar) {
            x1c.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, h2cVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements w1c, h2c {
        public static final long serialVersionUID = -2466317989629281651L;
        public final a2c<? super T> actual;
        public final m2c<h2c, b2c> onSchedule;
        public final T value;

        public ScalarAsyncProducer(a2c<? super T> a2cVar, T t, m2c<h2c, b2c> m2cVar) {
            this.actual = a2cVar;
            this.value = t;
            this.onSchedule = m2cVar;
        }

        @Override // com.baidu.tieba.h2c
        public void call() {
            a2c<? super T> a2cVar = this.actual;
            if (a2cVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                a2cVar.onNext(obj);
                if (a2cVar.isUnsubscribed()) {
                    return;
                }
                a2cVar.onCompleted();
            } catch (Throwable th) {
                g2c.g(th, a2cVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.w1c
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
    public class a implements m2c<h2c, b2c> {
        public final /* synthetic */ v3c a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, v3c v3cVar) {
            this.a = v3cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public b2c call(h2c h2cVar) {
            return this.a.a(h2cVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements u1c.a<R> {
        public final /* synthetic */ m2c a;

        public c(m2c m2cVar) {
            this.a = m2cVar;
        }

        public void call(a2c<? super R> a2cVar) {
            u1c u1cVar = (u1c) this.a.call(ScalarSynchronousObservable.this.b);
            if (u1cVar instanceof ScalarSynchronousObservable) {
                a2cVar.f(ScalarSynchronousObservable.Q(a2cVar, ((ScalarSynchronousObservable) u1cVar).b));
            } else {
                u1cVar.O(e6c.c(a2cVar));
            }
        }

        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((a2c) ((a2c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements u1c.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(a2c<? super T> a2cVar) {
            a2cVar.f(ScalarSynchronousObservable.Q(a2cVar, this.a));
        }

        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((a2c) ((a2c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements u1c.a<T> {
        public final T a;
        public final m2c<h2c, b2c> b;

        public e(T t, m2c<h2c, b2c> m2cVar) {
            this.a = t;
            this.b = m2cVar;
        }

        public void call(a2c<? super T> a2cVar) {
            a2cVar.f(new ScalarAsyncProducer(a2cVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((a2c) ((a2c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements w1c {
        public final a2c<? super T> a;
        public final T b;
        public boolean c;

        public f(a2c<? super T> a2cVar, T t) {
            this.a = a2cVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.w1c
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
                a2c<? super T> a2cVar = this.a;
                if (a2cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    a2cVar.onNext(obj);
                    if (a2cVar.isUnsubscribed()) {
                        return;
                    }
                    a2cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    g2c.g(th, a2cVar, obj);
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
        super(h6c.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> u1c<R> S(m2c<? super T, ? extends u1c<? extends R>> m2cVar) {
        return u1c.d(new c(m2cVar));
    }

    public u1c<T> T(x1c x1cVar) {
        m2c bVar;
        if (x1cVar instanceof v3c) {
            bVar = new a(this, (v3c) x1cVar);
        } else {
            bVar = new b(this, x1cVar);
        }
        return u1c.d(new e(this.b, bVar));
    }

    public static <T> w1c Q(a2c<? super T> a2cVar, T t) {
        if (c) {
            return new SingleProducer(a2cVar, t);
        }
        return new f(a2cVar, t);
    }
}
