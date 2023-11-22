package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.ckc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.mjc;
import com.baidu.tieba.nlc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.vjc;
import com.baidu.tieba.wjc;
import com.baidu.tieba.wnc;
import com.baidu.tieba.znc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends jjc<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements ckc<wjc, qjc> {
        public final /* synthetic */ mjc a;

        /* loaded from: classes2.dex */
        public class a implements wjc {
            public final /* synthetic */ wjc a;
            public final /* synthetic */ mjc.a b;

            public a(b bVar, wjc wjcVar, mjc.a aVar) {
                this.a = wjcVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.wjc
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, mjc mjcVar) {
            this.a = mjcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public qjc call(wjc wjcVar) {
            mjc.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, wjcVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements ljc, wjc {
        public static final long serialVersionUID = -2466317989629281651L;
        public final pjc<? super T> actual;
        public final ckc<wjc, qjc> onSchedule;
        public final T value;

        public ScalarAsyncProducer(pjc<? super T> pjcVar, T t, ckc<wjc, qjc> ckcVar) {
            this.actual = pjcVar;
            this.value = t;
            this.onSchedule = ckcVar;
        }

        @Override // com.baidu.tieba.wjc
        public void call() {
            pjc<? super T> pjcVar = this.actual;
            if (pjcVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                pjcVar.onNext(obj);
                if (pjcVar.isUnsubscribed()) {
                    return;
                }
                pjcVar.onCompleted();
            } catch (Throwable th) {
                vjc.g(th, pjcVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.ljc
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
    public class a implements ckc<wjc, qjc> {
        public final /* synthetic */ nlc a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, nlc nlcVar) {
            this.a = nlcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public qjc call(wjc wjcVar) {
            return this.a.a(wjcVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements jjc.a<R> {
        public final /* synthetic */ ckc a;

        public c(ckc ckcVar) {
            this.a = ckcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xjc
        /* renamed from: a */
        public void call(pjc<? super R> pjcVar) {
            jjc jjcVar = (jjc) this.a.call(ScalarSynchronousObservable.this.b);
            if (jjcVar instanceof ScalarSynchronousObservable) {
                pjcVar.f(ScalarSynchronousObservable.Q(pjcVar, ((ScalarSynchronousObservable) jjcVar).b));
            } else {
                jjcVar.O(wnc.c(pjcVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements jjc.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xjc
        /* renamed from: a */
        public void call(pjc<? super T> pjcVar) {
            pjcVar.f(ScalarSynchronousObservable.Q(pjcVar, this.a));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements jjc.a<T> {
        public final T a;
        public final ckc<wjc, qjc> b;

        public e(T t, ckc<wjc, qjc> ckcVar) {
            this.a = t;
            this.b = ckcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xjc
        /* renamed from: a */
        public void call(pjc<? super T> pjcVar) {
            pjcVar.f(new ScalarAsyncProducer(pjcVar, this.a, this.b));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements ljc {
        public final pjc<? super T> a;
        public final T b;
        public boolean c;

        public f(pjc<? super T> pjcVar, T t) {
            this.a = pjcVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.ljc
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
                pjc<? super T> pjcVar = this.a;
                if (pjcVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    pjcVar.onNext(obj);
                    if (pjcVar.isUnsubscribed()) {
                        return;
                    }
                    pjcVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    vjc.g(th, pjcVar, obj);
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
        super(znc.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> jjc<R> S(ckc<? super T, ? extends jjc<? extends R>> ckcVar) {
        return jjc.d(new c(ckcVar));
    }

    public jjc<T> T(mjc mjcVar) {
        ckc bVar;
        if (mjcVar instanceof nlc) {
            bVar = new a(this, (nlc) mjcVar);
        } else {
            bVar = new b(this, mjcVar);
        }
        return jjc.d(new e(this.b, bVar));
    }

    public static <T> ljc Q(pjc<? super T> pjcVar, T t) {
        if (c) {
            return new SingleProducer(pjcVar, t);
        }
        return new f(pjcVar, t);
    }
}
