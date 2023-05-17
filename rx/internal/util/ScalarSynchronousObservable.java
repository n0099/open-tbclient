package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.f9b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.obb;
import com.baidu.tieba.rbb;
import com.baidu.tieba.t7b;
import com.baidu.tieba.u7b;
import com.baidu.tieba.z7b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes10.dex */
public final class ScalarSynchronousObservable<T> extends h7b<T> {
    public static final boolean c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", CommandUBCHelper.COMMAND_UBC_VALUE_FALSE)).booleanValue();
    public final T b;

    /* loaded from: classes10.dex */
    public class b implements z7b<u7b, o7b> {
        public final /* synthetic */ k7b a;

        /* loaded from: classes10.dex */
        public class a implements u7b {
            public final /* synthetic */ u7b a;
            public final /* synthetic */ k7b.a b;

            public a(b bVar, u7b u7bVar, k7b.a aVar) {
                this.a = u7bVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.u7b
            public void call() {
                try {
                    this.a.call();
                } finally {
                    this.b.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, k7b k7bVar) {
            this.a = k7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public o7b call(u7b u7bVar) {
            k7b.a createWorker = this.a.createWorker();
            createWorker.b(new a(this, u7bVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes10.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements j7b, u7b {
        public static final long serialVersionUID = -2466317989629281651L;
        public final n7b<? super T> actual;
        public final z7b<u7b, o7b> onSchedule;
        public final T value;

        public ScalarAsyncProducer(n7b<? super T> n7bVar, T t, z7b<u7b, o7b> z7bVar) {
            this.actual = n7bVar;
            this.value = t;
            this.onSchedule = z7bVar;
        }

        @Override // com.baidu.tieba.u7b
        public void call() {
            n7b<? super T> n7bVar = this.actual;
            if (n7bVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                n7bVar.onNext(obj);
                if (n7bVar.isUnsubscribed()) {
                    return;
                }
                n7bVar.onCompleted();
            } catch (Throwable th) {
                t7b.g(th, n7bVar, obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }

        @Override // com.baidu.tieba.j7b
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
    public class a implements z7b<u7b, o7b> {
        public final /* synthetic */ f9b a;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, f9b f9bVar) {
            this.a = f9bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public o7b call(u7b u7bVar) {
            return this.a.a(u7bVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes10.dex */
    public class c<R> implements h7b.a<R> {
        public final /* synthetic */ z7b a;

        public c(z7b z7bVar) {
            this.a = z7bVar;
        }

        public void call(n7b<? super R> n7bVar) {
            h7b h7bVar = (h7b) this.a.call(ScalarSynchronousObservable.this.b);
            if (h7bVar instanceof ScalarSynchronousObservable) {
                n7bVar.f(ScalarSynchronousObservable.H(n7bVar, ((ScalarSynchronousObservable) h7bVar).b));
            } else {
                h7bVar.F(obb.c(n7bVar));
            }
        }

        @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((n7b) ((n7b) obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class d<T> implements h7b.a<T> {
        public final T a;

        public d(T t) {
            this.a = t;
        }

        public void call(n7b<? super T> n7bVar) {
            n7bVar.f(ScalarSynchronousObservable.H(n7bVar, this.a));
        }

        @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((n7b) ((n7b) obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class e<T> implements h7b.a<T> {
        public final T a;
        public final z7b<u7b, o7b> b;

        public e(T t, z7b<u7b, o7b> z7bVar) {
            this.a = t;
            this.b = z7bVar;
        }

        public void call(n7b<? super T> n7bVar) {
            n7bVar.f(new ScalarAsyncProducer(n7bVar, this.a, this.b));
        }

        @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((n7b) ((n7b) obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class f<T> implements j7b {
        public final n7b<? super T> a;
        public final T b;
        public boolean c;

        public f(n7b<? super T> n7bVar, T t) {
            this.a = n7bVar;
            this.b = t;
        }

        @Override // com.baidu.tieba.j7b
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
                n7b<? super T> n7bVar = this.a;
                if (n7bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.b;
                try {
                    n7bVar.onNext(obj);
                    if (n7bVar.isUnsubscribed()) {
                        return;
                    }
                    n7bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    t7b.g(th, n7bVar, obj);
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
        super(rbb.h(new d(t)));
        this.b = t;
    }

    public static <T> ScalarSynchronousObservable<T> G(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public <R> h7b<R> J(z7b<? super T, ? extends h7b<? extends R>> z7bVar) {
        return h7b.a(new c(z7bVar));
    }

    public h7b<T> K(k7b k7bVar) {
        z7b bVar;
        if (k7bVar instanceof f9b) {
            bVar = new a(this, (f9b) k7bVar);
        } else {
            bVar = new b(this, k7bVar);
        }
        return h7b.a(new e(this.b, bVar));
    }

    public static <T> j7b H(n7b<? super T> n7bVar, T t) {
        if (c) {
            return new SingleProducer(n7bVar, t);
        }
        return new f(n7bVar, t);
    }
}
