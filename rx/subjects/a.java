package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] iRo = new Object[0];
    private final SubjectSubscriptionManager<T> iRp;

    public static <T> a<T> cfY() {
        return g(null, false);
    }

    private static <T> a<T> g(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.aY(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.bv(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.iRp = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iRp.getLatest() == null || this.iRp.active) {
            Object cdX = NotificationLite.cdX();
            for (SubjectSubscriptionManager.b<T> bVar : this.iRp.terminate(cdX)) {
                bVar.bu(cdX);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iRp.getLatest() == null || this.iRp.active) {
            Object M = NotificationLite.M(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.iRp.terminate(M)) {
                try {
                    bVar.bu(M);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.eA(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iRp.getLatest() == null || this.iRp.active) {
            Object aY = NotificationLite.aY(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.iRp.next(aY)) {
                bVar.bu(aY);
            }
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        return this.iRp.observers().length > 0;
    }
}
