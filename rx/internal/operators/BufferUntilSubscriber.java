package rx.internal.operators;

import com.baidu.tieba.anb;
import com.baidu.tieba.irb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.nrb;
import com.baidu.tieba.omb;
import com.baidu.tieba.tmb;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends irb<T, T> {
    public static final omb d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes2.dex */
    public static class a implements omb {
        @Override // com.baidu.tieba.omb
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.omb
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.omb
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements nmb.a<T> {
        public final State<T> a;

        /* loaded from: classes2.dex */
        public class a implements anb {
            public a() {
            }

            @Override // com.baidu.tieba.anb
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((tmb) ((tmb) obj));
        }

        public void call(tmb<? super T> tmbVar) {
            boolean z;
            if (this.a.casObserverRef(null, tmbVar)) {
                tmbVar.b(nrb.a(new a()));
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
                tmbVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> H() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.omb
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            I(NotificationLite.b());
        }
    }

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicReference<omb<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(omb<? super T> ombVar, omb<? super T> ombVar2) {
            return compareAndSet(ombVar, ombVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.omb
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            I(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.omb
    public void onNext(T t) {
        if (this.c) {
            this.b.get().onNext(t);
        } else {
            I(NotificationLite.h(t));
        }
    }

    public final void I(Object obj) {
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
