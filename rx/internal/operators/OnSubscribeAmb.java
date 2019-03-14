package rx.internal.operators;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb<T> implements d.a<T> {
    final Iterable<? extends rx.d<? extends T>> jVR;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        private final Selection<T> jVW;
        private boolean jVX;
        private final rx.j<? super T> subscriber;

        a(long j, rx.j<? super T> jVar, Selection<T> selection) {
            this.subscriber = jVar;
            this.jVW = selection;
            request(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ek(long j) {
            request(j);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (isSelected()) {
                this.subscriber.onNext(t);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (isSelected()) {
                this.subscriber.onCompleted();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (isSelected()) {
                this.subscriber.onError(th);
            }
        }

        private boolean isSelected() {
            if (this.jVX) {
                return true;
            }
            if (this.jVW.get() == this) {
                this.jVX = true;
                return true;
            } else if (this.jVW.compareAndSet(null, this)) {
                this.jVW.unsubscribeOthers(this);
                this.jVX = true;
                return true;
            } else {
                this.jVW.unsubscribeLosers();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Selection<T> extends AtomicReference<a<T>> {
        final Collection<a<T>> ambSubscribers = new ConcurrentLinkedQueue();

        Selection() {
        }

        public void unsubscribeLosers() {
            a<T> aVar = get();
            if (aVar != null) {
                unsubscribeOthers(aVar);
            }
        }

        public void unsubscribeOthers(a<T> aVar) {
            for (a<T> aVar2 : this.ambSubscribers) {
                if (aVar2 != aVar) {
                    aVar2.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }

    public void call(rx.j<? super T> jVar) {
        final Selection selection = new Selection();
        jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.OnSubscribeAmb.1
            @Override // rx.functions.a
            public void call() {
                a<T> aVar = selection.get();
                if (aVar != null) {
                    aVar.unsubscribe();
                }
                OnSubscribeAmb.m(selection.ambSubscribers);
            }
        }));
        for (rx.d<? extends T> dVar : this.jVR) {
            if (jVar.isUnsubscribed()) {
                break;
            }
            a<T> aVar = new a<>(0L, jVar, selection);
            selection.ambSubscribers.add(aVar);
            a<T> aVar2 = selection.get();
            if (aVar2 != null) {
                selection.unsubscribeOthers(aVar2);
                return;
            }
            dVar.a((rx.j<? super Object>) aVar);
        }
        if (jVar.isUnsubscribed()) {
            m(selection.ambSubscribers);
        }
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.OnSubscribeAmb.2
            @Override // rx.f
            public void request(long j) {
                a<T> aVar3 = selection.get();
                if (aVar3 != null) {
                    aVar3.ek(j);
                    return;
                }
                for (a<T> aVar4 : selection.ambSubscribers) {
                    if (!aVar4.isUnsubscribed()) {
                        if (selection.get() == aVar4) {
                            aVar4.ek(j);
                            return;
                        }
                        aVar4.ek(j);
                    }
                }
            }
        });
    }

    static <T> void m(Collection<a<T>> collection) {
        if (!collection.isEmpty()) {
            for (a<T> aVar : collection) {
                aVar.unsubscribe();
            }
            collection.clear();
        }
    }
}
