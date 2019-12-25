package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes4.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e ndL = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> ndJ;
    private boolean ndK;

    public static <T> BufferUntilSubscriber<T> dGq() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    static final class a<T> implements d.a<T> {
        final State<T> ndJ;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.ndJ = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.ndJ.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.ndJ.set(BufferUntilSubscriber.ndL);
                    }
                }));
                synchronized (this.ndJ.guard) {
                    if (this.ndJ.emitting) {
                        z = false;
                    } else {
                        this.ndJ.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.ndJ.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.ndJ.get(), poll);
                    } else {
                        synchronized (this.ndJ.guard) {
                            if (this.ndJ.buffer.isEmpty()) {
                                this.ndJ.emitting = false;
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
        this.ndJ = state;
    }

    private void bU(Object obj) {
        synchronized (this.ndJ.guard) {
            this.ndJ.buffer.add(obj);
            if (this.ndJ.get() != null && !this.ndJ.emitting) {
                this.ndK = true;
                this.ndJ.emitting = true;
            }
        }
        if (!this.ndK) {
            return;
        }
        while (true) {
            Object poll = this.ndJ.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.ndJ.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.ndK) {
            this.ndJ.get().onCompleted();
        } else {
            bU(NotificationLite.dGr());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.ndK) {
            this.ndJ.get().onError(th);
        } else {
            bU(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.ndK) {
            this.ndJ.get().onNext(t);
        } else {
            bU(NotificationLite.next(t));
        }
    }
}
