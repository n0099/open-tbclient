package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.a8b;
import com.baidu.tieba.g9b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.l7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.p7b;
import com.baidu.tieba.pbb;
import com.baidu.tieba.sbb;
import com.baidu.tieba.u7b;
import com.baidu.tieba.v7b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes10.dex */
public final class ScalarSynchronousObservable<T> extends i7b<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", CommandUBCHelper.COMMAND_UBC_VALUE_FALSE)).booleanValue();
    public final T b;

    /* loaded from: classes10.dex */
    public class b implements a8b<v7b, p7b> {
        public final /* synthetic */ l7b a;

        /* loaded from: classes10.dex */
        public class a implements v7b {
            public final /* synthetic */ v7b a;
            public final /* synthetic */ l7b.a b;

            public a(b bVar, v7b v7bVar, l7b.a aVar) {
                this.a = v7bVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.v7b
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, l7b l7bVar) {
            this.a = l7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public p7b call(v7b v7bVar) {
            l7b.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, v7bVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes10.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements k7b, v7b {
        public static final long serialVersionUID = -2466317989629281651L;
        public final o7b<? super T> actual;
        public final a8b<v7b, p7b> onSchedule;
        public final T value;

        public ScalarAsyncProducer(o7b<? super T> o7bVar, T t, a8b<v7b, p7b> a8bVar) {
            this.actual = o7bVar;
            this.value = t;
            this.onSchedule = a8bVar;
        }

        @Override // com.baidu.tieba.v7b
        public void call() {
            o7b<? super T> o7bVar = this.actual;
            if (o7bVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                o7bVar.onNext(obj);
                if (o7bVar.isUnsubscribed()) {
                    return;
                }
                o7bVar.onCompleted();
            } catch (Throwable th) {
                u7b.g(th, o7bVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.k7b
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

    /* loaded from: classes10.dex */
    public class a implements a8b<v7b, p7b> {
        public final /* synthetic */ g9b a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, g9b g9bVar) {
            this.a = g9bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public p7b call(v7b v7bVar) {
            return this.a.a(v7bVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes10.dex */
    public class c<R> implements i7b.a<R> {
        public final /* synthetic */ a8b a;

        public c(a8b a8bVar) {
            this.a = a8bVar;
        }

        public void call(o7b<? super R> o7bVar) {
            i7b i7bVar = (i7b) this.a.call(ScalarSynchronousObservable.this.b);
            if (i7bVar instanceof ScalarSynchronousObservable) {
                o7bVar.f(ScalarSynchronousObservable.H(o7bVar, ((ScalarSynchronousObservable) i7bVar).b));
            } else {
                i7bVar.F(pbb.c(o7bVar));
            }
        }

        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((o7b) ((o7b) obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class d<T> implements i7b.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(o7b<? super T> o7bVar) {
            o7bVar.f(ScalarSynchronousObservable.H(o7bVar, this.a));
        }

        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((o7b) ((o7b) obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class e<T> implements i7b.a<T> {
        public final T a;
        public final a8b<v7b, p7b> b;

        public e(T t, a8b<v7b, p7b> a8bVar) {
            this.a = t;
            this.b = a8bVar;
        }

        public void call(o7b<? super T> o7bVar) {
            o7bVar.f(new ScalarAsyncProducer(o7bVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((o7b) ((o7b) obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class f<T> implements k7b {
        public final o7b<? super T> a;
        public final T b;
        public boolean c;

        public f(o7b<? super T> o7bVar, T t) {
            this.a = o7bVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.k7b
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
                o7b<? super T> o7bVar = this.a;
                if (o7bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    o7bVar.onNext(obj);
                    if (o7bVar.isUnsubscribed()) {
                        return;
                    }
                    o7bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    u7b.g(th, o7bVar, obj);
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
        super(sbb.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> G(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> i7b<R> J(a8b<? super T, ? extends i7b<? extends R>> a8bVar) {
        return i7b.a(new c(a8bVar));
    }

    public i7b<T> K(l7b l7bVar) {
        a8b bVar;
        if (l7bVar instanceof g9b) {
            bVar = new a(this, (g9b) l7bVar);
        } else {
            bVar = new b(this, l7bVar);
        }
        return i7b.a(new e(this.b, bVar));
    }

    public static <T> k7b H(o7b<? super T> o7bVar, T t) {
        if (c) {
            return new SingleProducer(o7bVar, t);
        }
        return new f(o7bVar, t);
    }
}
