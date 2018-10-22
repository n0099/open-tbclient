package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes2.dex */
public final class cf<T> implements d.b<List<T>, T> {
    private static final Comparator iAt = new a();
    final Comparator<? super T> iAs;
    final int ivn;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public cf(int i) {
        this.iAs = iAt;
        this.ivn = i;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Comparator<T>, java.util.Comparator<? super T> */
    public cf(final rx.functions.g<? super T, ? super T, Integer> gVar, int i) {
        this.ivn = i;
        this.iAs = (Comparator<T>) new Comparator<T>() { // from class: rx.internal.operators.cf.1
            @Override // java.util.Comparator
            public int compare(T t, T t2) {
                return ((Integer) gVar.j(t, t2)).intValue();
            }
        };
    }

    public rx.j<? super T> call(final rx.j<? super List<T>> jVar) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.cf.2
            boolean completed;
            List<T> list;

            {
                this.list = new ArrayList(cf.this.ivn);
            }

            @Override // rx.j
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    List<T> list = this.list;
                    this.list = null;
                    try {
                        Collections.sort(list, cf.this.iAs);
                        singleDelayedProducer.setValue(list);
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, this);
                    }
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            @Override // rx.e
            public void onNext(T t) {
                if (!this.completed) {
                    this.list.add(t);
                }
            }
        };
        jVar.add(jVar2);
        jVar.setProducer(singleDelayedProducer);
        return jVar2;
    }

    /* loaded from: classes2.dex */
    static final class a implements Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }
}
