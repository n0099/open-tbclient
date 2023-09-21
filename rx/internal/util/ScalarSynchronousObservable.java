package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.ddc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.mec;
import com.baidu.tieba.ncc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.vgc;
import com.baidu.tieba.wcc;
import com.baidu.tieba.xcc;
import com.baidu.tieba.ygc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends kcc<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements ddc<xcc, rcc> {
        public final /* synthetic */ ncc a;

        /* loaded from: classes2.dex */
        public class a implements xcc {
            public final /* synthetic */ xcc a;
            public final /* synthetic */ ncc.a b;

            public a(b bVar, xcc xccVar, ncc.a aVar) {
                this.a = xccVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.xcc
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, ncc nccVar) {
            this.a = nccVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public rcc call(xcc xccVar) {
            ncc.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, xccVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements mcc, xcc {
        public static final long serialVersionUID = -2466317989629281651L;
        public final qcc<? super T> actual;
        public final ddc<xcc, rcc> onSchedule;
        public final T value;

        public ScalarAsyncProducer(qcc<? super T> qccVar, T t, ddc<xcc, rcc> ddcVar) {
            this.actual = qccVar;
            this.value = t;
            this.onSchedule = ddcVar;
        }

        @Override // com.baidu.tieba.xcc
        public void call() {
            qcc<? super T> qccVar = this.actual;
            if (qccVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                qccVar.onNext(obj);
                if (qccVar.isUnsubscribed()) {
                    return;
                }
                qccVar.onCompleted();
            } catch (Throwable th) {
                wcc.g(th, qccVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.mcc
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
    public class a implements ddc<xcc, rcc> {
        public final /* synthetic */ mec a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, mec mecVar) {
            this.a = mecVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public rcc call(xcc xccVar) {
            return this.a.a(xccVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements kcc.a<R> {
        public final /* synthetic */ ddc a;

        public c(ddc ddcVar) {
            this.a = ddcVar;
        }

        public void call(qcc<? super R> qccVar) {
            kcc kccVar = (kcc) this.a.call(ScalarSynchronousObservable.this.b);
            if (kccVar instanceof ScalarSynchronousObservable) {
                qccVar.f(ScalarSynchronousObservable.Q(qccVar, ((ScalarSynchronousObservable) kccVar).b));
            } else {
                kccVar.O(vgc.c(qccVar));
            }
        }

        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((qcc) ((qcc) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements kcc.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(qcc<? super T> qccVar) {
            qccVar.f(ScalarSynchronousObservable.Q(qccVar, this.a));
        }

        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((qcc) ((qcc) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements kcc.a<T> {
        public final T a;
        public final ddc<xcc, rcc> b;

        public e(T t, ddc<xcc, rcc> ddcVar) {
            this.a = t;
            this.b = ddcVar;
        }

        public void call(qcc<? super T> qccVar) {
            qccVar.f(new ScalarAsyncProducer(qccVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((qcc) ((qcc) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements mcc {
        public final qcc<? super T> a;
        public final T b;
        public boolean c;

        public f(qcc<? super T> qccVar, T t) {
            this.a = qccVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.mcc
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
                qcc<? super T> qccVar = this.a;
                if (qccVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    qccVar.onNext(obj);
                    if (qccVar.isUnsubscribed()) {
                        return;
                    }
                    qccVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    wcc.g(th, qccVar, obj);
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
        super(ygc.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> kcc<R> S(ddc<? super T, ? extends kcc<? extends R>> ddcVar) {
        return kcc.d(new c(ddcVar));
    }

    public kcc<T> T(ncc nccVar) {
        ddc bVar;
        if (nccVar instanceof mec) {
            bVar = new a(this, (mec) nccVar);
        } else {
            bVar = new b(this, nccVar);
        }
        return kcc.d(new e(this.b, bVar));
    }

    public static <T> mcc Q(qcc<? super T> qccVar, T t) {
        if (c) {
            return new SingleProducer(qccVar, t);
        }
        return new f(qccVar, t);
    }
}
