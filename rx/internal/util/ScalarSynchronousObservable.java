package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.asa;
import com.baidu.tieba.bsa;
import com.baidu.tieba.gsa;
import com.baidu.tieba.jta;
import com.baidu.tieba.ora;
import com.baidu.tieba.qra;
import com.baidu.tieba.rra;
import com.baidu.tieba.sva;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import com.baidu.tieba.vva;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes9.dex */
public final class ScalarSynchronousObservable<T> extends ora<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements gsa<bsa, vra> {
        public final /* synthetic */ rra a;

        /* loaded from: classes9.dex */
        public class a implements bsa {
            public final /* synthetic */ bsa a;
            public final /* synthetic */ rra.a b;

            public a(b bVar, bsa bsaVar, rra.a aVar) {
                this.a = bsaVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.bsa
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, rra rraVar) {
            this.a = rraVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public vra call(bsa bsaVar) {
            rra.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, bsaVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements qra, bsa {
        public static final long serialVersionUID = -2466317989629281651L;
        public final ura<? super T> actual;
        public final gsa<bsa, vra> onSchedule;
        public final T value;

        public ScalarAsyncProducer(ura<? super T> uraVar, T t, gsa<bsa, vra> gsaVar) {
            this.actual = uraVar;
            this.value = t;
            this.onSchedule = gsaVar;
        }

        @Override // com.baidu.tieba.bsa
        public void call() {
            ura<? super T> uraVar = this.actual;
            if (uraVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                uraVar.onNext(obj);
                if (uraVar.isUnsubscribed()) {
                    return;
                }
                uraVar.onCompleted();
            } catch (Throwable th) {
                asa.g(th, uraVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.qra
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
    public class a implements gsa<bsa, vra> {
        public final /* synthetic */ jta a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, jta jtaVar) {
            this.a = jtaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public vra call(bsa bsaVar) {
            return this.a.a(bsaVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes9.dex */
    public class c<R> implements ora.a<R> {
        public final /* synthetic */ gsa a;

        public c(gsa gsaVar) {
            this.a = gsaVar;
        }

        public void call(ura<? super R> uraVar) {
            ora oraVar = (ora) this.a.call(ScalarSynchronousObservable.this.b);
            if (oraVar instanceof ScalarSynchronousObservable) {
                uraVar.f(ScalarSynchronousObservable.D(uraVar, ((ScalarSynchronousObservable) oraVar).b));
            } else {
                oraVar.B(sva.c(uraVar));
            }
        }

        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((ura) ((ura) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements ora.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(ura<? super T> uraVar) {
            uraVar.f(ScalarSynchronousObservable.D(uraVar, this.a));
        }

        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((ura) ((ura) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements ora.a<T> {
        public final T a;
        public final gsa<bsa, vra> b;

        public e(T t, gsa<bsa, vra> gsaVar) {
            this.a = t;
            this.b = gsaVar;
        }

        public void call(ura<? super T> uraVar) {
            uraVar.f(new ScalarAsyncProducer(uraVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((ura) ((ura) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements qra {
        public final ura<? super T> a;
        public final T b;
        public boolean c;

        public f(ura<? super T> uraVar, T t) {
            this.a = uraVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.qra
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
                ura<? super T> uraVar = this.a;
                if (uraVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    uraVar.onNext(obj);
                    if (uraVar.isUnsubscribed()) {
                        return;
                    }
                    uraVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    asa.g(th, uraVar, obj);
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
        super(vva.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> C(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> ora<R> F(gsa<? super T, ? extends ora<? extends R>> gsaVar) {
        return ora.a(new c(gsaVar));
    }

    public ora<T> G(rra rraVar) {
        gsa bVar;
        if (rraVar instanceof jta) {
            bVar = new a(this, (jta) rraVar);
        } else {
            bVar = new b(this, rraVar);
        }
        return ora.a(new e(this.b, bVar));
    }

    public static <T> qra D(ura<? super T> uraVar, T t) {
        if (c) {
            return new SingleProducer(uraVar, t);
        }
        return new f(uraVar, t);
    }
}
