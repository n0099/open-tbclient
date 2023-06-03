package rx.internal.operators;

import com.baidu.tieba.drb;
import com.baidu.tieba.imb;
import com.baidu.tieba.irb;
import com.baidu.tieba.jmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.vmb;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends drb<T, T> {
    public static final jmb d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes2.dex */
    public static class a implements jmb {
        @Override // com.baidu.tieba.jmb
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.jmb
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.jmb
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements imb.a<T> {
        public final State<T> a;

        /* loaded from: classes2.dex */
        public class a implements vmb {
            public a() {
            }

            @Override // com.baidu.tieba.vmb
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        @Override // com.baidu.tieba.imb.a, com.baidu.tieba.wmb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((omb) ((omb) obj));
        }

        public void call(omb<? super T> ombVar) {
            boolean z;
            if (this.a.casObserverRef(null, ombVar)) {
                ombVar.b(irb.a(new a()));
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
                ombVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> H() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.jmb
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            I(NotificationLite.b());
        }
    }

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicReference<jmb<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(jmb<? super T> jmbVar, jmb<? super T> jmbVar2) {
            return compareAndSet(jmbVar, jmbVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.jmb
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            I(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.jmb
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
