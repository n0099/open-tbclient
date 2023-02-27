package rx.internal.operators;

import com.baidu.tieba.fna;
import com.baidu.tieba.kra;
import com.baidu.tieba.pra;
import com.baidu.tieba.sma;
import com.baidu.tieba.tma;
import com.baidu.tieba.yma;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class BufferUntilSubscriber<T> extends kra<T, T> {
    public static final tma d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes9.dex */
    public static class a implements tma {
        @Override // com.baidu.tieba.tma
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.tma
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.tma
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes9.dex */
    public static final class b<T> implements sma.a<T> {
        public final State<T> a;

        /* loaded from: classes9.dex */
        public class a implements fna {
            public a() {
            }

            @Override // com.baidu.tieba.fna
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yma) ((yma) obj));
        }

        public void call(yma<? super T> ymaVar) {
            boolean z;
            if (this.a.casObserverRef(null, ymaVar)) {
                ymaVar.b(pra.a(new a()));
                synchronized (this.a.guard) {
                    z = true;
                    if (!this.a.emitting) {
                        this.a.emitting = true;
                    } else {
                        z = false;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.a.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.a.get(), poll);
                    } else {
                        synchronized (this.a.guard) {
                            if (this.a.buffer.isEmpty()) {
                                this.a.emitting = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                ymaVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> D() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.tma
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            E(NotificationLite.b());
        }
    }

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicReference<tma<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(tma<? super T> tmaVar, tma<? super T> tmaVar2) {
            return compareAndSet(tmaVar, tmaVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.tma
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            E(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.tma
    public void onNext(T t) {
        if (this.c) {
            this.b.get().onNext(t);
        } else {
            E(NotificationLite.h(t));
        }
    }

    public final void E(Object obj) {
        synchronized (this.b.guard) {
            this.b.buffer.add(obj);
            if (this.b.get() != null && !this.b.emitting) {
                this.c = true;
                this.b.emitting = true;
            }
        }
        if (!this.c) {
            return;
        }
        while (true) {
            Object poll = this.b.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.b.get(), poll);
            } else {
                return;
            }
        }
    }
}
