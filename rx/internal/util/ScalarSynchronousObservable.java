package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.dfc;
import com.baidu.tieba.ebc;
import com.baidu.tieba.fbc;
import com.baidu.tieba.gfc;
import com.baidu.tieba.lbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.uac;
import com.baidu.tieba.ucc;
import com.baidu.tieba.vac;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends sac<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements lbc<fbc, zac> {
        public final /* synthetic */ vac a;

        /* loaded from: classes2.dex */
        public class a implements fbc {
            public final /* synthetic */ fbc a;
            public final /* synthetic */ vac.a b;

            public a(b bVar, fbc fbcVar, vac.a aVar) {
                this.a = fbcVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.fbc
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, vac vacVar) {
            this.a = vacVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public zac call(fbc fbcVar) {
            vac.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, fbcVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements uac, fbc {
        public static final long serialVersionUID = -2466317989629281651L;
        public final yac<? super T> actual;
        public final lbc<fbc, zac> onSchedule;
        public final T value;

        public ScalarAsyncProducer(yac<? super T> yacVar, T t, lbc<fbc, zac> lbcVar) {
            this.actual = yacVar;
            this.value = t;
            this.onSchedule = lbcVar;
        }

        @Override // com.baidu.tieba.fbc
        public void call() {
            yac<? super T> yacVar = this.actual;
            if (yacVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                yacVar.onNext(obj);
                if (yacVar.isUnsubscribed()) {
                    return;
                }
                yacVar.onCompleted();
            } catch (Throwable th) {
                ebc.g(th, yacVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.uac
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
    public class a implements lbc<fbc, zac> {
        public final /* synthetic */ ucc a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, ucc uccVar) {
            this.a = uccVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public zac call(fbc fbcVar) {
            return this.a.a(fbcVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements sac.a<R> {
        public final /* synthetic */ lbc a;

        public c(lbc lbcVar) {
            this.a = lbcVar;
        }

        public void call(yac<? super R> yacVar) {
            sac sacVar = (sac) this.a.call(ScalarSynchronousObservable.this.b);
            if (sacVar instanceof ScalarSynchronousObservable) {
                yacVar.f(ScalarSynchronousObservable.Q(yacVar, ((ScalarSynchronousObservable) sacVar).b));
            } else {
                sacVar.O(dfc.c(yacVar));
            }
        }

        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yac) ((yac) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements sac.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(yac<? super T> yacVar) {
            yacVar.f(ScalarSynchronousObservable.Q(yacVar, this.a));
        }

        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yac) ((yac) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements sac.a<T> {
        public final T a;
        public final lbc<fbc, zac> b;

        public e(T t, lbc<fbc, zac> lbcVar) {
            this.a = t;
            this.b = lbcVar;
        }

        public void call(yac<? super T> yacVar) {
            yacVar.f(new ScalarAsyncProducer(yacVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yac) ((yac) obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements uac {
        public final yac<? super T> a;
        public final T b;
        public boolean c;

        public f(yac<? super T> yacVar, T t) {
            this.a = yacVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.uac
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
                yac<? super T> yacVar = this.a;
                if (yacVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    yacVar.onNext(obj);
                    if (yacVar.isUnsubscribed()) {
                        return;
                    }
                    yacVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    ebc.g(th, yacVar, obj);
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
        super(gfc.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> sac<R> S(lbc<? super T, ? extends sac<? extends R>> lbcVar) {
        return sac.d(new c(lbcVar));
    }

    public sac<T> T(vac vacVar) {
        lbc bVar;
        if (vacVar instanceof ucc) {
            bVar = new a(this, (ucc) vacVar);
        } else {
            bVar = new b(this, vacVar);
        }
        return sac.d(new e(this.b, bVar));
    }

    public static <T> uac Q(yac<? super T> yacVar, T t) {
        if (c) {
            return new SingleProducer(yacVar, t);
        }
        return new f(yacVar, t);
    }
}
