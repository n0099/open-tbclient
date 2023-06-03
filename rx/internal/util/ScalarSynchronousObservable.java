package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.anb;
import com.baidu.tieba.gob;
import com.baidu.tieba.imb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.lmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.pqb;
import com.baidu.tieba.sqb;
import com.baidu.tieba.umb;
import com.baidu.tieba.vmb;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends imb<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements anb<vmb, pmb> {
        public final /* synthetic */ lmb a;

        /* loaded from: classes2.dex */
        public class a implements vmb {
            public final /* synthetic */ vmb a;
            public final /* synthetic */ lmb.a b;

            public a(b bVar, vmb vmbVar, lmb.a aVar) {
                this.a = vmbVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.vmb
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, lmb lmbVar) {
            this.a = lmbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public pmb call(vmb vmbVar) {
            lmb.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, vmbVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements kmb, vmb {
        public static final long serialVersionUID = -2466317989629281651L;
        public final omb<? super T> actual;
        public final anb<vmb, pmb> onSchedule;
        public final T value;

        public ScalarAsyncProducer(omb<? super T> ombVar, T t, anb<vmb, pmb> anbVar) {
            this.actual = ombVar;
            this.value = t;
            this.onSchedule = anbVar;
        }

        @Override // com.baidu.tieba.vmb
        public void call() {
            omb<? super T> ombVar = this.actual;
            if (ombVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                ombVar.onNext(obj);
                if (ombVar.isUnsubscribed()) {
                    return;
                }
                ombVar.onCompleted();
            } catch (Throwable th) {
                umb.g(th, ombVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.kmb
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
    public class a implements anb<vmb, pmb> {
        public final /* synthetic */ gob a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, gob gobVar) {
            this.a = gobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public pmb call(vmb vmbVar) {
            return this.a.a(vmbVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements imb.a<R> {
        public final /* synthetic */ anb a;

        public c(anb anbVar) {
            this.a = anbVar;
        }

        public void call(omb<? super R> ombVar) {
            imb imbVar = (imb) this.a.call(ScalarSynchronousObservable.this.b);
            if (imbVar instanceof ScalarSynchronousObservable) {
                ombVar.f(ScalarSynchronousObservable.H(ombVar, ((ScalarSynchronousObservable) imbVar).b));
            } else {
                imbVar.F(pqb.c(ombVar));
            }
        }

        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((omb) ((omb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements imb.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(omb<? super T> ombVar) {
            ombVar.f(ScalarSynchronousObservable.H(ombVar, this.a));
        }

        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((omb) ((omb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements imb.a<T> {
        public final T a;
        public final anb<vmb, pmb> b;

        public e(T t, anb<vmb, pmb> anbVar) {
            this.a = t;
            this.b = anbVar;
        }

        public void call(omb<? super T> ombVar) {
            ombVar.f(new ScalarAsyncProducer(ombVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((omb) ((omb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements kmb {
        public final omb<? super T> a;
        public final T b;
        public boolean c;

        public f(omb<? super T> ombVar, T t) {
            this.a = ombVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.kmb
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
                omb<? super T> ombVar = this.a;
                if (ombVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    ombVar.onNext(obj);
                    if (ombVar.isUnsubscribed()) {
                        return;
                    }
                    ombVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    umb.g(th, ombVar, obj);
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
        super(sqb.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> G(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> imb<R> J(anb<? super T, ? extends imb<? extends R>> anbVar) {
        return imb.a(new c(anbVar));
    }

    public imb<T> K(lmb lmbVar) {
        anb bVar;
        if (lmbVar instanceof gob) {
            bVar = new a(this, (gob) lmbVar);
        } else {
            bVar = new b(this, lmbVar);
        }
        return imb.a(new e(this.b, bVar));
    }

    public static <T> kmb H(omb<? super T> ombVar, T t) {
        if (c) {
            return new SingleProducer(ombVar, t);
        }
        return new f(ombVar, t);
    }
}
