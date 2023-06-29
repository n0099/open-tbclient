package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.atb;
import com.baidu.tieba.dtb;
import com.baidu.tieba.etb;
import com.baidu.tieba.hxb;
import com.baidu.tieba.jtb;
import com.baidu.tieba.ktb;
import com.baidu.tieba.kxb;
import com.baidu.tieba.ptb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.yub;
import com.baidu.tieba.zsb;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends xsb<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements ptb<ktb, etb> {
        public final /* synthetic */ atb a;

        /* loaded from: classes2.dex */
        public class a implements ktb {
            public final /* synthetic */ ktb a;
            public final /* synthetic */ atb.a b;

            public a(b bVar, ktb ktbVar, atb.a aVar) {
                this.a = ktbVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.ktb
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, atb atbVar) {
            this.a = atbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public etb call(ktb ktbVar) {
            atb.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, ktbVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements zsb, ktb {
        public static final long serialVersionUID = -2466317989629281651L;
        public final dtb<? super T> actual;
        public final ptb<ktb, etb> onSchedule;
        public final T value;

        public ScalarAsyncProducer(dtb<? super T> dtbVar, T t, ptb<ktb, etb> ptbVar) {
            this.actual = dtbVar;
            this.value = t;
            this.onSchedule = ptbVar;
        }

        @Override // com.baidu.tieba.ktb
        public void call() {
            dtb<? super T> dtbVar = this.actual;
            if (dtbVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                dtbVar.onNext(obj);
                if (dtbVar.isUnsubscribed()) {
                    return;
                }
                dtbVar.onCompleted();
            } catch (Throwable th) {
                jtb.g(th, dtbVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.zsb
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
    public class a implements ptb<ktb, etb> {
        public final /* synthetic */ yub a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, yub yubVar) {
            this.a = yubVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public etb call(ktb ktbVar) {
            return this.a.a(ktbVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements xsb.a<R> {
        public final /* synthetic */ ptb a;

        public c(ptb ptbVar) {
            this.a = ptbVar;
        }

        public void call(dtb<? super R> dtbVar) {
            xsb xsbVar = (xsb) this.a.call(ScalarSynchronousObservable.this.b);
            if (xsbVar instanceof ScalarSynchronousObservable) {
                dtbVar.f(ScalarSynchronousObservable.O(dtbVar, ((ScalarSynchronousObservable) xsbVar).b));
            } else {
                xsbVar.M(hxb.c(dtbVar));
            }
        }

        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dtb) ((dtb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements xsb.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(dtb<? super T> dtbVar) {
            dtbVar.f(ScalarSynchronousObservable.O(dtbVar, this.a));
        }

        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dtb) ((dtb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements xsb.a<T> {
        public final T a;
        public final ptb<ktb, etb> b;

        public e(T t, ptb<ktb, etb> ptbVar) {
            this.a = t;
            this.b = ptbVar;
        }

        public void call(dtb<? super T> dtbVar) {
            dtbVar.f(new ScalarAsyncProducer(dtbVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dtb) ((dtb) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements zsb {
        public final dtb<? super T> a;
        public final T b;
        public boolean c;

        public f(dtb<? super T> dtbVar, T t) {
            this.a = dtbVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.zsb
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
                dtb<? super T> dtbVar = this.a;
                if (dtbVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    dtbVar.onNext(obj);
                    if (dtbVar.isUnsubscribed()) {
                        return;
                    }
                    dtbVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    jtb.g(th, dtbVar, obj);
                    return;
                }
            }
            throw new IllegalStateException("n >= required but it was " + j);
        }
    }

    public T P() {
        return this.b;
    }

    public ScalarSynchronousObservable(T t) {
        super(kxb.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> N(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> xsb<R> Q(ptb<? super T, ? extends xsb<? extends R>> ptbVar) {
        return xsb.d(new c(ptbVar));
    }

    public xsb<T> R(atb atbVar) {
        ptb bVar;
        if (atbVar instanceof yub) {
            bVar = new a(this, (yub) atbVar);
        } else {
            bVar = new b(this, atbVar);
        }
        return xsb.d(new e(this.b, bVar));
    }

    public static <T> zsb O(dtb<? super T> dtbVar, T t) {
        if (c) {
            return new SingleProducer(dtbVar, t);
        }
        return new f(dtbVar, t);
    }
}
