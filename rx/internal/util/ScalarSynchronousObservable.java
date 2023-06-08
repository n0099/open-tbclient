package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.anb;
import com.baidu.tieba.fnb;
import com.baidu.tieba.lob;
import com.baidu.tieba.nmb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.qmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import com.baidu.tieba.uqb;
import com.baidu.tieba.xqb;
import com.baidu.tieba.zmb;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends nmb<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements fnb<anb, umb> {
        public final /* synthetic */ qmb a;

        /* loaded from: classes2.dex */
        public class a implements anb {
            public final /* synthetic */ anb a;
            public final /* synthetic */ qmb.a b;

            public a(b bVar, anb anbVar, qmb.a aVar) {
                this.a = anbVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.anb
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, qmb qmbVar) {
            this.a = qmbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public umb call(anb anbVar) {
            qmb.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, anbVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements pmb, anb {
        public static final long serialVersionUID = -2466317989629281651L;
        public final tmb<? super T> actual;
        public final fnb<anb, umb> onSchedule;
        public final T value;

        public ScalarAsyncProducer(tmb<? super T> tmbVar, T t, fnb<anb, umb> fnbVar) {
            this.actual = tmbVar;
            this.value = t;
            this.onSchedule = fnbVar;
        }

        @Override // com.baidu.tieba.anb
        public void call() {
            tmb<? super T> tmbVar = this.actual;
            if (tmbVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                tmbVar.onNext(obj);
                if (tmbVar.isUnsubscribed()) {
                    return;
                }
                tmbVar.onCompleted();
            } catch (Throwable th) {
                zmb.g(th, tmbVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.pmb
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
    public class a implements fnb<anb, umb> {
        public final /* synthetic */ lob a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, lob lobVar) {
            this.a = lobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public umb call(anb anbVar) {
            return this.a.a(anbVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements nmb.a<R> {
        public final /* synthetic */ fnb a;

        public c(fnb fnbVar) {
            this.a = fnbVar;
        }

        public void call(tmb<? super R> tmbVar) {
            nmb nmbVar = (nmb) this.a.call(ScalarSynchronousObservable.this.b);
            if (nmbVar instanceof ScalarSynchronousObservable) {
                tmbVar.f(ScalarSynchronousObservable.H(tmbVar, ((ScalarSynchronousObservable) nmbVar).b));
            } else {
                nmbVar.F(uqb.c(tmbVar));
            }
        }

        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((tmb) ((tmb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements nmb.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(tmb<? super T> tmbVar) {
            tmbVar.f(ScalarSynchronousObservable.H(tmbVar, this.a));
        }

        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((tmb) ((tmb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements nmb.a<T> {
        public final T a;
        public final fnb<anb, umb> b;

        public e(T t, fnb<anb, umb> fnbVar) {
            this.a = t;
            this.b = fnbVar;
        }

        public void call(tmb<? super T> tmbVar) {
            tmbVar.f(new ScalarAsyncProducer(tmbVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((tmb) ((tmb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements pmb {
        public final tmb<? super T> a;
        public final T b;
        public boolean c;

        public f(tmb<? super T> tmbVar, T t) {
            this.a = tmbVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.pmb
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
                tmb<? super T> tmbVar = this.a;
                if (tmbVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    tmbVar.onNext(obj);
                    if (tmbVar.isUnsubscribed()) {
                        return;
                    }
                    tmbVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    zmb.g(th, tmbVar, obj);
                    return;
                }
            }
            throw new IllegalStateException("n >= required but it was " + j);
        }
    }

    public T I() {
        return this.b;
    }

    public ScalarSynchronousObservable(T t) {
        super(xqb.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> G(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> nmb<R> J(fnb<? super T, ? extends nmb<? extends R>> fnbVar) {
        return nmb.a(new c(fnbVar));
    }

    public nmb<T> K(qmb qmbVar) {
        fnb bVar;
        if (qmbVar instanceof lob) {
            bVar = new a(this, (lob) qmbVar);
        } else {
            bVar = new b(this, qmbVar);
        }
        return nmb.a(new e(this.b, bVar));
    }

    public static <T> pmb H(tmb<? super T> tmbVar, T t) {
        if (c) {
            return new SingleProducer(tmbVar, t);
        }
        return new f(tmbVar, t);
    }
}
