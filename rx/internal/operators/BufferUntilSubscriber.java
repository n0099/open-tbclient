package rx.internal.operators;

import com.baidu.tieba.c6b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.g1b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.x5b;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class BufferUntilSubscriber<T> extends x5b<T, T> {
    public static final g1b d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes9.dex */
    public static class a implements g1b {
        @Override // com.baidu.tieba.g1b
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.g1b
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.g1b
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes9.dex */
    public static final class b<T> implements f1b.a<T> {
        public final State<T> a;

        /* loaded from: classes9.dex */
        public class a implements s1b {
            public a() {
            }

            @Override // com.baidu.tieba.s1b
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        @Override // com.baidu.tieba.f1b.a, com.baidu.tieba.t1b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l1b) ((l1b) obj));
        }

        public void call(l1b<? super T> l1bVar) {
            boolean z;
            if (this.a.casObserverRef(null, l1bVar)) {
                l1bVar.b(c6b.a(new a()));
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
                l1bVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> D() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.g1b
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            E(NotificationLite.b());
        }
    }

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicReference<g1b<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(g1b<? super T> g1bVar, g1b<? super T> g1bVar2) {
            return compareAndSet(g1bVar, g1bVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.g1b
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            E(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.g1b
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
