package rx.internal.operators;

import com.baidu.tieba.ayb;
import com.baidu.tieba.dtb;
import com.baidu.tieba.ktb;
import com.baidu.tieba.vxb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.ysb;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends vxb<T, T> {
    public static final ysb d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes2.dex */
    public static class a implements ysb {
        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.ysb
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements xsb.a<T> {
        public final State<T> a;

        /* loaded from: classes2.dex */
        public class a implements ktb {
            public a() {
            }

            @Override // com.baidu.tieba.ktb
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dtb) ((dtb) obj));
        }

        public void call(dtb<? super T> dtbVar) {
            boolean z;
            if (this.a.casObserverRef(null, dtbVar)) {
                dtbVar.b(ayb.a(new a()));
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
                dtbVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> O() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.ysb
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            P(NotificationLite.b());
        }
    }

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicReference<ysb<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(ysb<? super T> ysbVar, ysb<? super T> ysbVar2) {
            return compareAndSet(ysbVar, ysbVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.ysb
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            P(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.ysb
    public void onNext(T t) {
        if (this.c) {
            this.b.get().onNext(t);
        } else {
            P(NotificationLite.i(t));
        }
    }

    public final void P(Object obj) {
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
