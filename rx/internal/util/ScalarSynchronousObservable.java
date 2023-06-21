package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.eqb;
import com.baidu.tieba.gob;
import com.baidu.tieba.iob;
import com.baidu.tieba.job;
import com.baidu.tieba.mob;
import com.baidu.tieba.nob;
import com.baidu.tieba.nsb;
import com.baidu.tieba.qsb;
import com.baidu.tieba.sob;
import com.baidu.tieba.tob;
import com.baidu.tieba.yob;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends gob<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements yob<tob, nob> {
        public final /* synthetic */ job a;

        /* loaded from: classes2.dex */
        public class a implements tob {
            public final /* synthetic */ tob a;
            public final /* synthetic */ job.a b;

            public a(b bVar, tob tobVar, job.a aVar) {
                this.a = tobVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.tob
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, job jobVar) {
            this.a = jobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public nob call(tob tobVar) {
            job.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, tobVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements iob, tob {
        public static final long serialVersionUID = -2466317989629281651L;
        public final mob<? super T> actual;
        public final yob<tob, nob> onSchedule;
        public final T value;

        public ScalarAsyncProducer(mob<? super T> mobVar, T t, yob<tob, nob> yobVar) {
            this.actual = mobVar;
            this.value = t;
            this.onSchedule = yobVar;
        }

        @Override // com.baidu.tieba.tob
        public void call() {
            mob<? super T> mobVar = this.actual;
            if (mobVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                mobVar.onNext(obj);
                if (mobVar.isUnsubscribed()) {
                    return;
                }
                mobVar.onCompleted();
            } catch (Throwable th) {
                sob.g(th, mobVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.iob
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
    public class a implements yob<tob, nob> {
        public final /* synthetic */ eqb a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, eqb eqbVar) {
            this.a = eqbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public nob call(tob tobVar) {
            return this.a.a(tobVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements gob.a<R> {
        public final /* synthetic */ yob a;

        public c(yob yobVar) {
            this.a = yobVar;
        }

        public void call(mob<? super R> mobVar) {
            gob gobVar = (gob) this.a.call(ScalarSynchronousObservable.this.b);
            if (gobVar instanceof ScalarSynchronousObservable) {
                mobVar.f(ScalarSynchronousObservable.H(mobVar, ((ScalarSynchronousObservable) gobVar).b));
            } else {
                gobVar.F(nsb.c(mobVar));
            }
        }

        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((mob) ((mob) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements gob.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(mob<? super T> mobVar) {
            mobVar.f(ScalarSynchronousObservable.H(mobVar, this.a));
        }

        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((mob) ((mob) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements gob.a<T> {
        public final T a;
        public final yob<tob, nob> b;

        public e(T t, yob<tob, nob> yobVar) {
            this.a = t;
            this.b = yobVar;
        }

        public void call(mob<? super T> mobVar) {
            mobVar.f(new ScalarAsyncProducer(mobVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((mob) ((mob) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements iob {
        public final mob<? super T> a;
        public final T b;
        public boolean c;

        public f(mob<? super T> mobVar, T t) {
            this.a = mobVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.iob
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
                mob<? super T> mobVar = this.a;
                if (mobVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    mobVar.onNext(obj);
                    if (mobVar.isUnsubscribed()) {
                        return;
                    }
                    mobVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    sob.g(th, mobVar, obj);
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
        super(qsb.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> G(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> gob<R> J(yob<? super T, ? extends gob<? extends R>> yobVar) {
        return gob.a(new c(yobVar));
    }

    public gob<T> K(job jobVar) {
        yob bVar;
        if (jobVar instanceof eqb) {
            bVar = new a(this, (eqb) jobVar);
        } else {
            bVar = new b(this, jobVar);
        }
        return gob.a(new e(this.b, bVar));
    }

    public static <T> iob H(mob<? super T> mobVar, T t) {
        if (c) {
            return new SingleProducer(mobVar, t);
        }
        return new f(mobVar, t);
    }
}
