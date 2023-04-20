package rx.internal.operators;

import com.baidu.tieba.a2b;
import com.baidu.tieba.f6b;
import com.baidu.tieba.k6b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.t1b;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class BufferUntilSubscriber<T> extends f6b<T, T> {
    public static final o1b d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes9.dex */
    public static class a implements o1b {
        @Override // com.baidu.tieba.o1b
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.o1b
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.o1b
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes9.dex */
    public static final class b<T> implements n1b.a<T> {
        public final State<T> a;

        /* loaded from: classes9.dex */
        public class a implements a2b {
            public a() {
            }

            @Override // com.baidu.tieba.a2b
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((t1b) ((t1b) obj));
        }

        public void call(t1b<? super T> t1bVar) {
            boolean z;
            if (this.a.casObserverRef(null, t1bVar)) {
                t1bVar.b(k6b.a(new a()));
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
                t1bVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> D() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.o1b
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            E(NotificationLite.b());
        }
    }

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicReference<o1b<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(o1b<? super T> o1bVar, o1b<? super T> o1bVar2) {
            return compareAndSet(o1bVar, o1bVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.o1b
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            E(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.o1b
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
