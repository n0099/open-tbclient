package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.eoc;
import com.baidu.tieba.goc;
import com.baidu.tieba.hoc;
import com.baidu.tieba.iqc;
import com.baidu.tieba.koc;
import com.baidu.tieba.loc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.roc;
import com.baidu.tieba.rsc;
import com.baidu.tieba.usc;
import com.baidu.tieba.xoc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends eoc<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements xoc<roc, loc> {
        public final /* synthetic */ hoc a;

        /* loaded from: classes2.dex */
        public class a implements roc {
            public final /* synthetic */ roc a;
            public final /* synthetic */ hoc.a b;

            public a(b bVar, roc rocVar, hoc.a aVar) {
                this.a = rocVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.roc
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, hoc hocVar) {
            this.a = hocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public loc call(roc rocVar) {
            hoc.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, rocVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements goc, roc {
        public static final long serialVersionUID = -2466317989629281651L;
        public final koc<? super T> actual;
        public final xoc<roc, loc> onSchedule;
        public final T value;

        public ScalarAsyncProducer(koc<? super T> kocVar, T t, xoc<roc, loc> xocVar) {
            this.actual = kocVar;
            this.value = t;
            this.onSchedule = xocVar;
        }

        @Override // com.baidu.tieba.roc
        public void call() {
            koc<? super T> kocVar = this.actual;
            if (kocVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                kocVar.onNext(obj);
                if (kocVar.isUnsubscribed()) {
                    return;
                }
                kocVar.onCompleted();
            } catch (Throwable th) {
                qoc.g(th, kocVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.goc
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
    public class a implements xoc<roc, loc> {
        public final /* synthetic */ iqc a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, iqc iqcVar) {
            this.a = iqcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public loc call(roc rocVar) {
            return this.a.a(rocVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements eoc.a<R> {
        public final /* synthetic */ xoc a;

        public c(xoc xocVar) {
            this.a = xocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super R> kocVar) {
            eoc eocVar = (eoc) this.a.call(ScalarSynchronousObservable.this.b);
            if (eocVar instanceof ScalarSynchronousObservable) {
                kocVar.f(ScalarSynchronousObservable.Q(kocVar, ((ScalarSynchronousObservable) eocVar).b));
            } else {
                eocVar.O(rsc.c(kocVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements eoc.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super T> kocVar) {
            kocVar.f(ScalarSynchronousObservable.Q(kocVar, this.a));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements eoc.a<T> {
        public final T a;
        public final xoc<roc, loc> b;

        public e(T t, xoc<roc, loc> xocVar) {
            this.a = t;
            this.b = xocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super T> kocVar) {
            kocVar.f(new ScalarAsyncProducer(kocVar, this.a, this.b));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements goc {
        public final koc<? super T> a;
        public final T b;
        public boolean c;

        public f(koc<? super T> kocVar, T t) {
            this.a = kocVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.goc
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
                koc<? super T> kocVar = this.a;
                if (kocVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    kocVar.onNext(obj);
                    if (kocVar.isUnsubscribed()) {
                        return;
                    }
                    kocVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    qoc.g(th, kocVar, obj);
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
        super(usc.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> eoc<R> S(xoc<? super T, ? extends eoc<? extends R>> xocVar) {
        return eoc.d(new c(xocVar));
    }

    public eoc<T> T(hoc hocVar) {
        xoc bVar;
        if (hocVar instanceof iqc) {
            bVar = new a(this, (iqc) hocVar);
        } else {
            bVar = new b(this, hocVar);
        }
        return eoc.d(new e(this.b, bVar));
    }

    public static <T> goc Q(koc<? super T> kocVar, T t) {
        if (c) {
            return new SingleProducer(kocVar, t);
        }
        return new f(kocVar, t);
    }
}
