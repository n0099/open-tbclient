package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e kyf = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> kyd;
    private boolean kye;

    public static <T> BufferUntilSubscriber<T> cOv() {
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
        final State<T> kyd;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.kyd = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.kyd.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.kyd.set(BufferUntilSubscriber.kyf);
                    }
                }));
                synchronized (this.kyd.guard) {
                    if (this.kyd.emitting) {
                        z = false;
                    } else {
                        this.kyd.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.kyd.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.kyd.get(), poll);
                    } else {
                        synchronized (this.kyd.guard) {
                            if (this.kyd.buffer.isEmpty()) {
                                this.kyd.emitting = false;
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
        this.kyd = state;
    }

    private void bk(Object obj) {
        synchronized (this.kyd.guard) {
            this.kyd.buffer.add(obj);
            if (this.kyd.get() != null && !this.kyd.emitting) {
                this.kye = true;
                this.kyd.emitting = true;
            }
        }
        if (!this.kye) {
            return;
        }
        while (true) {
            Object poll = this.kyd.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.kyd.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kye) {
            this.kyd.get().onCompleted();
        } else {
            bk(NotificationLite.cOx());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kye) {
            this.kyd.get().onError(th);
        } else {
            bk(NotificationLite.N(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kye) {
            this.kyd.get().onNext(t);
        } else {
            bk(NotificationLite.bl(t));
        }
    }
}
