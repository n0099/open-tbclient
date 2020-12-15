package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes12.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e pPA = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> pPy;
    private boolean pPz;

    public static <T> BufferUntilSubscriber<T> eFF() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    static final class a<T> implements d.a<T> {
        final State<T> pPy;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.pPy = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.pPy.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.pPy.set(BufferUntilSubscriber.pPA);
                    }
                }));
                synchronized (this.pPy.guard) {
                    if (this.pPy.emitting) {
                        z = false;
                    } else {
                        this.pPy.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.pPy.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.pPy.get(), poll);
                    } else {
                        synchronized (this.pPy.guard) {
                            if (this.pPy.buffer.isEmpty()) {
                                this.pPy.emitting = false;
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
        this.pPy = state;
    }

    private void bW(Object obj) {
        synchronized (this.pPy.guard) {
            this.pPy.buffer.add(obj);
            if (this.pPy.get() != null && !this.pPy.emitting) {
                this.pPz = true;
                this.pPy.emitting = true;
            }
        }
        if (!this.pPz) {
            return;
        }
        while (true) {
            Object poll = this.pPy.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.pPy.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.pPz) {
            this.pPy.get().onCompleted();
        } else {
            bW(NotificationLite.eFG());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.pPz) {
            this.pPy.get().onError(th);
        } else {
            bW(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.pPz) {
            this.pPy.get().onNext(t);
        } else {
            bW(NotificationLite.next(t));
        }
    }
}
