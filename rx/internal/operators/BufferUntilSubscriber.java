package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e jUV = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> jUT;
    private boolean jUU;

    public static <T> BufferUntilSubscriber<T> cDO() {
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
        final State<T> jUT;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.jUT = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.jUT.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.jUT.set(BufferUntilSubscriber.jUV);
                    }
                }));
                synchronized (this.jUT.guard) {
                    if (this.jUT.emitting) {
                        z = false;
                    } else {
                        this.jUT.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.jUT.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.jUT.get(), poll);
                    } else {
                        synchronized (this.jUT.guard) {
                            if (this.jUT.buffer.isEmpty()) {
                                this.jUT.emitting = false;
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
        this.jUT = state;
    }

    private void bl(Object obj) {
        synchronized (this.jUT.guard) {
            this.jUT.buffer.add(obj);
            if (this.jUT.get() != null && !this.jUT.emitting) {
                this.jUU = true;
                this.jUT.emitting = true;
            }
        }
        if (!this.jUU) {
            return;
        }
        while (true) {
            Object poll = this.jUT.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.jUT.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.jUU) {
            this.jUT.get().onCompleted();
        } else {
            bl(NotificationLite.cDR());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.jUU) {
            this.jUT.get().onError(th);
        } else {
            bl(NotificationLite.O(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.jUU) {
            this.jUT.get().onNext(t);
        } else {
            bl(NotificationLite.bm(t));
        }
    }
}
