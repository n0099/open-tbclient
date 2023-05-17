package rx.internal.operators;

import com.baidu.tieba.ccb;
import com.baidu.tieba.h7b;
import com.baidu.tieba.hcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.u7b;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class BufferUntilSubscriber<T> extends ccb<T, T> {
    public static final i7b d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes10.dex */
    public static class a implements i7b {
        @Override // com.baidu.tieba.i7b
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.i7b
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.i7b
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes10.dex */
    public static final class b<T> implements h7b.a<T> {
        public final State<T> a;

        /* loaded from: classes10.dex */
        public class a implements u7b {
            public a() {
            }

            @Override // com.baidu.tieba.u7b
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        @Override // com.baidu.tieba.h7b.a, com.baidu.tieba.v7b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((n7b) ((n7b) obj));
        }

        public void call(n7b<? super T> n7bVar) {
            boolean z;
            if (this.a.casObserverRef(null, n7bVar)) {
                n7bVar.b(hcb.a(new a()));
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
                n7bVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> H() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.i7b
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            I(NotificationLite.b());
        }
    }

    /* loaded from: classes10.dex */
    public static final class State<T> extends AtomicReference<i7b<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(i7b<? super T> i7bVar, i7b<? super T> i7bVar2) {
            return compareAndSet(i7bVar, i7bVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.i7b
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            I(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.i7b
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
