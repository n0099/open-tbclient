package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes14.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e qfw = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
        @Override // rx.e
        public void onCompleted() {
        }

        @Override // rx.e
        public void onError(Throwable th) {
        }

        @Override // rx.e
        public void onNext(Object obj) {
        }
    };
    final State<T> qfu;
    private boolean qfv;

    public static <T> BufferUntilSubscriber<T> eFF() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class State<T> extends AtomicReference<rx.e<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        boolean emitting;
        final Object guard = new Object();
        final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        State() {
        }

        boolean casObserverRef(rx.e<? super T> eVar, rx.e<? super T> eVar2) {
            return compareAndSet(eVar, eVar2);
        }
    }

    /* loaded from: classes14.dex */
    static final class a<T> implements d.a<T> {
        final State<T> qfu;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.qfu = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.qfu.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.qfu.set(BufferUntilSubscriber.qfw);
                    }
                }));
                synchronized (this.qfu.guard) {
                    if (this.qfu.emitting) {
                        z = false;
                    } else {
                        this.qfu.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.qfu.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.qfu.get(), poll);
                    } else {
                        synchronized (this.qfu.guard) {
                            if (this.qfu.buffer.isEmpty()) {
                                this.qfu.emitting = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                jVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    private BufferUntilSubscriber(State<T> state) {
        super(new a(state));
        this.qfu = state;
    }

    private void cg(Object obj) {
        synchronized (this.qfu.guard) {
            this.qfu.buffer.add(obj);
            if (this.qfu.get() != null && !this.qfu.emitting) {
                this.qfv = true;
                this.qfu.emitting = true;
            }
        }
        if (!this.qfv) {
            return;
        }
        while (true) {
            Object poll = this.qfu.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.qfu.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qfv) {
            this.qfu.get().onCompleted();
        } else {
            cg(NotificationLite.eFG());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qfv) {
            this.qfu.get().onError(th);
        } else {
            cg(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qfv) {
            this.qfu.get().onNext(t);
        } else {
            cg(NotificationLite.next(t));
        }
    }
}
