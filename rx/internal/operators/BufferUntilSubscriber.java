package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e obm = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> obk;
    private boolean obl;

    public static <T> BufferUntilSubscriber<T> dUy() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    static final class a<T> implements d.a<T> {
        final State<T> obk;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.obk = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.obk.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.obk.set(BufferUntilSubscriber.obm);
                    }
                }));
                synchronized (this.obk.guard) {
                    if (this.obk.emitting) {
                        z = false;
                    } else {
                        this.obk.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.obk.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.obk.get(), poll);
                    } else {
                        synchronized (this.obk.guard) {
                            if (this.obk.buffer.isEmpty()) {
                                this.obk.emitting = false;
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
        this.obk = state;
    }

    private void bU(Object obj) {
        synchronized (this.obk.guard) {
            this.obk.buffer.add(obj);
            if (this.obk.get() != null && !this.obk.emitting) {
                this.obl = true;
                this.obk.emitting = true;
            }
        }
        if (!this.obl) {
            return;
        }
        while (true) {
            Object poll = this.obk.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.obk.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.obl) {
            this.obk.get().onCompleted();
        } else {
            bU(NotificationLite.dUz());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.obl) {
            this.obk.get().onError(th);
        } else {
            bU(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.obl) {
            this.obk.get().onNext(t);
        } else {
            bU(NotificationLite.next(t));
        }
    }
}
