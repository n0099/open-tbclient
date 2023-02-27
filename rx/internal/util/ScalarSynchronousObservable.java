package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.ena;
import com.baidu.tieba.fna;
import com.baidu.tieba.kna;
import com.baidu.tieba.noa;
import com.baidu.tieba.sma;
import com.baidu.tieba.uma;
import com.baidu.tieba.vma;
import com.baidu.tieba.wqa;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import com.baidu.tieba.zqa;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes9.dex */
public final class ScalarSynchronousObservable<T> extends sma<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes9.dex */
    public class b implements kna<fna, zma> {
        public final /* synthetic */ vma a;

        /* loaded from: classes9.dex */
        public class a implements fna {
            public final /* synthetic */ fna a;
            public final /* synthetic */ vma.a b;

            public a(b bVar, fna fnaVar, vma.a aVar) {
                this.a = fnaVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.fna
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, vma vmaVar) {
            this.a = vmaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public zma call(fna fnaVar) {
            vma.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, fnaVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements uma, fna {
        public static final long serialVersionUID = -2466317989629281651L;
        public final yma<? super T> actual;
        public final kna<fna, zma> onSchedule;
        public final T value;

        public ScalarAsyncProducer(yma<? super T> ymaVar, T t, kna<fna, zma> knaVar) {
            this.actual = ymaVar;
            this.value = t;
            this.onSchedule = knaVar;
        }

        @Override // com.baidu.tieba.fna
        public void call() {
            yma<? super T> ymaVar = this.actual;
            if (ymaVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                ymaVar.onNext(obj);
                if (ymaVar.isUnsubscribed()) {
                    return;
                }
                ymaVar.onCompleted();
            } catch (Throwable th) {
                ena.g(th, ymaVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.uma
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
    public class a implements kna<fna, zma> {
        public final /* synthetic */ noa a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, noa noaVar) {
            this.a = noaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public zma call(fna fnaVar) {
            return this.a.a(fnaVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes9.dex */
    public class c<R> implements sma.a<R> {
        public final /* synthetic */ kna a;

        public c(kna knaVar) {
            this.a = knaVar;
        }

        public void call(yma<? super R> ymaVar) {
            sma smaVar = (sma) this.a.call(ScalarSynchronousObservable.this.b);
            if (smaVar instanceof ScalarSynchronousObservable) {
                ymaVar.f(ScalarSynchronousObservable.D(ymaVar, ((ScalarSynchronousObservable) smaVar).b));
            } else {
                smaVar.B(wqa.c(ymaVar));
            }
        }

        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yma) ((yma) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class d<T> implements sma.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(yma<? super T> ymaVar) {
            ymaVar.f(ScalarSynchronousObservable.D(ymaVar, this.a));
        }

        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yma) ((yma) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class e<T> implements sma.a<T> {
        public final T a;
        public final kna<fna, zma> b;

        public e(T t, kna<fna, zma> knaVar) {
            this.a = t;
            this.b = knaVar;
        }

        public void call(yma<? super T> ymaVar) {
            ymaVar.f(new ScalarAsyncProducer(ymaVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yma) ((yma) obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class f<T> implements uma {
        public final yma<? super T> a;
        public final T b;
        public boolean c;

        public f(yma<? super T> ymaVar, T t) {
            this.a = ymaVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.uma
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
                yma<? super T> ymaVar = this.a;
                if (ymaVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    ymaVar.onNext(obj);
                    if (ymaVar.isUnsubscribed()) {
                        return;
                    }
                    ymaVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    ena.g(th, ymaVar, obj);
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
        super(zqa.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> C(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> sma<R> F(kna<? super T, ? extends sma<? extends R>> knaVar) {
        return sma.a(new c(knaVar));
    }

    public sma<T> G(vma vmaVar) {
        kna bVar;
        if (vmaVar instanceof noa) {
            bVar = new a(this, (noa) vmaVar);
        } else {
            bVar = new b(this, vmaVar);
        }
        return sma.a(new e(this.b, bVar));
    }

    public static <T> uma D(yma<? super T> ymaVar, T t) {
        if (c) {
            return new SingleProducer(ymaVar, t);
        }
        return new f(ymaVar, t);
    }
}
