package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e kyW = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> kyU;
    private boolean kyV;

    public static <T> BufferUntilSubscriber<T> cOx() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    static final class a<T> implements d.a<T> {
        final State<T> kyU;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.kyU = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.kyU.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.kyU.set(BufferUntilSubscriber.kyW);
                    }
                }));
                synchronized (this.kyU.guard) {
                    if (this.kyU.emitting) {
                        z = false;
                    } else {
                        this.kyU.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.kyU.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.kyU.get(), poll);
                    } else {
                        synchronized (this.kyU.guard) {
                            if (this.kyU.buffer.isEmpty()) {
                                this.kyU.emitting = false;
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
        this.kyU = state;
    }

    private void bk(Object obj) {
        synchronized (this.kyU.guard) {
            this.kyU.buffer.add(obj);
            if (this.kyU.get() != null && !this.kyU.emitting) {
                this.kyV = true;
                this.kyU.emitting = true;
            }
        }
        if (!this.kyV) {
            return;
        }
        while (true) {
            Object poll = this.kyU.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.kyU.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kyV) {
            this.kyU.get().onCompleted();
        } else {
            bk(NotificationLite.cOz());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kyV) {
            this.kyU.get().onError(th);
        } else {
            bk(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kyV) {
            this.kyU.get().onNext(t);
        } else {
            bk(NotificationLite.bl(t));
        }
    }
}
