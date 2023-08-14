package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.a1c;
import com.baidu.tieba.b1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.i5c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.l5c;
import com.baidu.tieba.q1c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.z2c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends y0c<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements q1c<l1c, f1c> {
        public final /* synthetic */ b1c a;

        /* loaded from: classes2.dex */
        public class a implements l1c {
            public final /* synthetic */ l1c a;
            public final /* synthetic */ b1c.a b;

            public a(b bVar, l1c l1cVar, b1c.a aVar) {
                this.a = l1cVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.l1c
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, b1c b1cVar) {
            this.a = b1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public f1c call(l1c l1cVar) {
            b1c.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, l1cVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements a1c, l1c {
        public static final long serialVersionUID = -2466317989629281651L;
        public final e1c<? super T> actual;
        public final q1c<l1c, f1c> onSchedule;
        public final T value;

        public ScalarAsyncProducer(e1c<? super T> e1cVar, T t, q1c<l1c, f1c> q1cVar) {
            this.actual = e1cVar;
            this.value = t;
            this.onSchedule = q1cVar;
        }

        @Override // com.baidu.tieba.l1c
        public void call() {
            e1c<? super T> e1cVar = this.actual;
            if (e1cVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                e1cVar.onNext(obj);
                if (e1cVar.isUnsubscribed()) {
                    return;
                }
                e1cVar.onCompleted();
            } catch (Throwable th) {
                k1c.g(th, e1cVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.a1c
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
    public class a implements q1c<l1c, f1c> {
        public final /* synthetic */ z2c a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, z2c z2cVar) {
            this.a = z2cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public f1c call(l1c l1cVar) {
            return this.a.a(l1cVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements y0c.a<R> {
        public final /* synthetic */ q1c a;

        public c(q1c q1cVar) {
            this.a = q1cVar;
        }

        public void call(e1c<? super R> e1cVar) {
            y0c y0cVar = (y0c) this.a.call(ScalarSynchronousObservable.this.b);
            if (y0cVar instanceof ScalarSynchronousObservable) {
                e1cVar.f(ScalarSynchronousObservable.Q(e1cVar, ((ScalarSynchronousObservable) y0cVar).b));
            } else {
                y0cVar.O(i5c.c(e1cVar));
            }
        }

        @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((e1c) ((e1c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements y0c.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(e1c<? super T> e1cVar) {
            e1cVar.f(ScalarSynchronousObservable.Q(e1cVar, this.a));
        }

        @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((e1c) ((e1c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements y0c.a<T> {
        public final T a;
        public final q1c<l1c, f1c> b;

        public e(T t, q1c<l1c, f1c> q1cVar) {
            this.a = t;
            this.b = q1cVar;
        }

        public void call(e1c<? super T> e1cVar) {
            e1cVar.f(new ScalarAsyncProducer(e1cVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.y0c.a, com.baidu.tieba.m1c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((e1c) ((e1c) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements a1c {
        public final e1c<? super T> a;
        public final T b;
        public boolean c;

        public f(e1c<? super T> e1cVar, T t) {
            this.a = e1cVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.a1c
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
                e1c<? super T> e1cVar = this.a;
                if (e1cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    e1cVar.onNext(obj);
                    if (e1cVar.isUnsubscribed()) {
                        return;
                    }
                    e1cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    k1c.g(th, e1cVar, obj);
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
        super(l5c.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> y0c<R> S(q1c<? super T, ? extends y0c<? extends R>> q1cVar) {
        return y0c.d(new c(q1cVar));
    }

    public y0c<T> T(b1c b1cVar) {
        q1c bVar;
        if (b1cVar instanceof z2c) {
            bVar = new a(this, (z2c) b1cVar);
        } else {
            bVar = new b(this, b1cVar);
        }
        return y0c.d(new e(this.b, bVar));
    }

    public static <T> a1c Q(e1c<? super T> e1cVar, T t) {
        if (c) {
            return new SingleProducer(e1cVar, t);
        }
        return new f(e1cVar, t);
    }
}
