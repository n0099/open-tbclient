package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e jVL = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> jVJ;
    private boolean jVK;

    public static <T> BufferUntilSubscriber<T> cDW() {
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
        final State<T> jVJ;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.jVJ = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.jVJ.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.jVJ.set(BufferUntilSubscriber.jVL);
                    }
                }));
                synchronized (this.jVJ.guard) {
                    if (this.jVJ.emitting) {
                        z = false;
                    } else {
                        this.jVJ.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.jVJ.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.jVJ.get(), poll);
                    } else {
                        synchronized (this.jVJ.guard) {
                            if (this.jVJ.buffer.isEmpty()) {
                                this.jVJ.emitting = false;
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
        this.jVJ = state;
    }

    private void bp(Object obj) {
        synchronized (this.jVJ.guard) {
            this.jVJ.buffer.add(obj);
            if (this.jVJ.get() != null && !this.jVJ.emitting) {
                this.jVK = true;
                this.jVJ.emitting = true;
            }
        }
        if (!this.jVK) {
            return;
        }
        while (true) {
            Object poll = this.jVJ.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.jVJ.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.jVK) {
            this.jVJ.get().onCompleted();
        } else {
            bp(NotificationLite.cDZ());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.jVK) {
            this.jVJ.get().onError(th);
        } else {
            bp(NotificationLite.O(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.jVK) {
            this.jVJ.get().onNext(t);
        } else {
            bp(NotificationLite.bq(t));
        }
    }
}
