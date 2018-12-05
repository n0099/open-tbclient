package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class OnSubscribeAmb<T> implements d.a<T> {
    final Iterable<? extends rx.d<? extends T>> iBR;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        return g(arrayList);
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, rx.d<? extends T> dVar3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        return g(arrayList);
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, rx.d<? extends T> dVar3, rx.d<? extends T> dVar4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        return g(arrayList);
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, rx.d<? extends T> dVar3, rx.d<? extends T> dVar4, rx.d<? extends T> dVar5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar5);
        return g(arrayList);
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, rx.d<? extends T> dVar3, rx.d<? extends T> dVar4, rx.d<? extends T> dVar5, rx.d<? extends T> dVar6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar5);
        arrayList.add(dVar6);
        return g(arrayList);
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, rx.d<? extends T> dVar3, rx.d<? extends T> dVar4, rx.d<? extends T> dVar5, rx.d<? extends T> dVar6, rx.d<? extends T> dVar7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar5);
        arrayList.add(dVar6);
        arrayList.add(dVar7);
        return g(arrayList);
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, rx.d<? extends T> dVar3, rx.d<? extends T> dVar4, rx.d<? extends T> dVar5, rx.d<? extends T> dVar6, rx.d<? extends T> dVar7, rx.d<? extends T> dVar8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar5);
        arrayList.add(dVar6);
        arrayList.add(dVar7);
        arrayList.add(dVar8);
        return g(arrayList);
    }

    public static <T> d.a<T> a(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, rx.d<? extends T> dVar3, rx.d<? extends T> dVar4, rx.d<? extends T> dVar5, rx.d<? extends T> dVar6, rx.d<? extends T> dVar7, rx.d<? extends T> dVar8, rx.d<? extends T> dVar9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar5);
        arrayList.add(dVar6);
        arrayList.add(dVar7);
        arrayList.add(dVar8);
        arrayList.add(dVar9);
        return g(arrayList);
    }

    public static <T> d.a<T> g(Iterable<? extends rx.d<? extends T>> iterable) {
        return new OnSubscribeAmb(iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        private final Selection<T> iBY;
        private boolean iBZ;
        private final rx.j<? super T> subscriber;

        a(long j, rx.j<? super T> jVar, Selection<T> selection) {
            this.subscriber = jVar;
            this.iBY = selection;
            request(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dC(long j) {
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
            if (this.iBZ) {
                return true;
            }
            if (this.iBY.get() == this) {
                this.iBZ = true;
                return true;
            } else if (this.iBY.compareAndSet(null, this)) {
                this.iBY.unsubscribeOthers(this);
                this.iBZ = true;
                return true;
            } else {
                this.iBY.unsubscribeLosers();
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

    private OnSubscribeAmb(Iterable<? extends rx.d<? extends T>> iterable) {
        this.iBR = iterable;
    }

    public void call(rx.j<? super T> jVar) {
        final Selection selection = new Selection();
        jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.OnSubscribeAmb.1
            @Override // rx.functions.a
            public void call() {
                a<T> aVar = selection.get();
                if (aVar != null) {
                    aVar.unsubscribe();
                }
                OnSubscribeAmb.m(selection.ambSubscribers);
            }
        }));
        for (rx.d<? extends T> dVar : this.iBR) {
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
            dVar.unsafeSubscribe(aVar);
        }
        if (jVar.isUnsubscribed()) {
            m(selection.ambSubscribers);
        }
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.OnSubscribeAmb.2
            @Override // rx.f
            public void request(long j) {
                a<T> aVar3 = selection.get();
                if (aVar3 != null) {
                    aVar3.dC(j);
                    return;
                }
                for (a<T> aVar4 : selection.ambSubscribers) {
                    if (!aVar4.isUnsubscribed()) {
                        if (selection.get() == aVar4) {
                            aVar4.dC(j);
                            return;
                        }
                        aVar4.dC(j);
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
