package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.bkc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.mlc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.ujc;
import com.baidu.tieba.vjc;
import com.baidu.tieba.vnc;
import com.baidu.tieba.ync;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends ijc<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements bkc<vjc, pjc> {
        public final /* synthetic */ ljc a;

        /* loaded from: classes2.dex */
        public class a implements vjc {
            public final /* synthetic */ vjc a;
            public final /* synthetic */ ljc.a b;

            public a(b bVar, vjc vjcVar, ljc.a aVar) {
                this.a = vjcVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.vjc
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, ljc ljcVar) {
            this.a = ljcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public pjc call(vjc vjcVar) {
            ljc.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, vjcVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements kjc, vjc {
        public static final long serialVersionUID = -2466317989629281651L;
        public final ojc<? super T> actual;
        public final bkc<vjc, pjc> onSchedule;
        public final T value;

        public ScalarAsyncProducer(ojc<? super T> ojcVar, T t, bkc<vjc, pjc> bkcVar) {
            this.actual = ojcVar;
            this.value = t;
            this.onSchedule = bkcVar;
        }

        @Override // com.baidu.tieba.vjc
        public void call() {
            ojc<? super T> ojcVar = this.actual;
            if (ojcVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                ojcVar.onNext(obj);
                if (ojcVar.isUnsubscribed()) {
                    return;
                }
                ojcVar.onCompleted();
            } catch (Throwable th) {
                ujc.g(th, ojcVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.kjc
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
    public class a implements bkc<vjc, pjc> {
        public final /* synthetic */ mlc a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, mlc mlcVar) {
            this.a = mlcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public pjc call(vjc vjcVar) {
            return this.a.a(vjcVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements ijc.a<R> {
        public final /* synthetic */ bkc a;

        public c(bkc bkcVar) {
            this.a = bkcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(ojc<? super R> ojcVar) {
            ijc ijcVar = (ijc) this.a.call(ScalarSynchronousObservable.this.b);
            if (ijcVar instanceof ScalarSynchronousObservable) {
                ojcVar.f(ScalarSynchronousObservable.Q(ojcVar, ((ScalarSynchronousObservable) ijcVar).b));
            } else {
                ijcVar.O(vnc.c(ojcVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements ijc.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(ojc<? super T> ojcVar) {
            ojcVar.f(ScalarSynchronousObservable.Q(ojcVar, this.a));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements ijc.a<T> {
        public final T a;
        public final bkc<vjc, pjc> b;

        public e(T t, bkc<vjc, pjc> bkcVar) {
            this.a = t;
            this.b = bkcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(ojc<? super T> ojcVar) {
            ojcVar.f(new ScalarAsyncProducer(ojcVar, this.a, this.b));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements kjc {
        public final ojc<? super T> a;
        public final T b;
        public boolean c;

        public f(ojc<? super T> ojcVar, T t) {
            this.a = ojcVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.kjc
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
                ojc<? super T> ojcVar = this.a;
                if (ojcVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    ojcVar.onNext(obj);
                    if (ojcVar.isUnsubscribed()) {
                        return;
                    }
                    ojcVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    ujc.g(th, ojcVar, obj);
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
        super(ync.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> ijc<R> S(bkc<? super T, ? extends ijc<? extends R>> bkcVar) {
        return ijc.d(new c(bkcVar));
    }

    public ijc<T> T(ljc ljcVar) {
        bkc bVar;
        if (ljcVar instanceof mlc) {
            bVar = new a(this, (mlc) ljcVar);
        } else {
            bVar = new b(this, ljcVar);
        }
        return ijc.d(new e(this.b, bVar));
    }

    public static <T> kjc Q(ojc<? super T> ojcVar, T t) {
        if (c) {
            return new SingleProducer(ojcVar, t);
        }
        return new f(ojcVar, t);
    }
}
