package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.doc;
import com.baidu.tieba.foc;
import com.baidu.tieba.goc;
import com.baidu.tieba.hqc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import com.baidu.tieba.poc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.qsc;
import com.baidu.tieba.tsc;
import com.baidu.tieba.woc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ScalarSynchronousObservable<T> extends doc<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T b;

    /* loaded from: classes2.dex */
    public class b implements woc<qoc, koc> {
        public final /* synthetic */ goc a;

        /* loaded from: classes2.dex */
        public class a implements qoc {
            public final /* synthetic */ qoc a;
            public final /* synthetic */ goc.a b;

            public a(b bVar, qoc qocVar, goc.a aVar) {
                this.a = qocVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.qoc
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, goc gocVar) {
            this.a = gocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public koc call(qoc qocVar) {
            goc.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, qocVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements foc, qoc {
        public static final long serialVersionUID = -2466317989629281651L;
        public final joc<? super T> actual;
        public final woc<qoc, koc> onSchedule;
        public final T value;

        public ScalarAsyncProducer(joc<? super T> jocVar, T t, woc<qoc, koc> wocVar) {
            this.actual = jocVar;
            this.value = t;
            this.onSchedule = wocVar;
        }

        @Override // com.baidu.tieba.qoc
        public void call() {
            joc<? super T> jocVar = this.actual;
            if (jocVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                jocVar.onNext(obj);
                if (jocVar.isUnsubscribed()) {
                    return;
                }
                jocVar.onCompleted();
            } catch (Throwable th) {
                poc.g(th, jocVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.foc
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
    public class a implements woc<qoc, koc> {
        public final /* synthetic */ hqc a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, hqc hqcVar) {
            this.a = hqcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public koc call(qoc qocVar) {
            return this.a.a(qocVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes2.dex */
    public class c<R> implements doc.a<R> {
        public final /* synthetic */ woc a;

        public c(woc wocVar) {
            this.a = wocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super R> jocVar) {
            doc docVar = (doc) this.a.call(ScalarSynchronousObservable.this.b);
            if (docVar instanceof ScalarSynchronousObservable) {
                jocVar.f(ScalarSynchronousObservable.Q(jocVar, ((ScalarSynchronousObservable) docVar).b));
            } else {
                docVar.O(qsc.c(jocVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<T> implements doc.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super T> jocVar) {
            jocVar.f(ScalarSynchronousObservable.Q(jocVar, this.a));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e<T> implements doc.a<T> {
        public final T a;
        public final woc<qoc, koc> b;

        public e(T t, woc<qoc, koc> wocVar) {
            this.a = t;
            this.b = wocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super T> jocVar) {
            jocVar.f(new ScalarAsyncProducer(jocVar, this.a, this.b));
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<T> implements foc {
        public final joc<? super T> a;
        public final T b;
        public boolean c;

        public f(joc<? super T> jocVar, T t) {
            this.a = jocVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.foc
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
                joc<? super T> jocVar = this.a;
                if (jocVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    jocVar.onNext(obj);
                    if (jocVar.isUnsubscribed()) {
                        return;
                    }
                    jocVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    poc.g(th, jocVar, obj);
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
        super(tsc.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> P(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> doc<R> S(woc<? super T, ? extends doc<? extends R>> wocVar) {
        return doc.d(new c(wocVar));
    }

    public doc<T> T(goc gocVar) {
        woc bVar;
        if (gocVar instanceof hqc) {
            bVar = new a(this, (hqc) gocVar);
        } else {
            bVar = new b(this, gocVar);
        }
        return doc.d(new e(this.b, bVar));
    }

    public static <T> foc Q(joc<? super T> jocVar, T t) {
        if (c) {
            return new SingleProducer(jocVar, t);
        }
        return new f(jocVar, t);
    }
}
