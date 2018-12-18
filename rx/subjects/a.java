package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] iOe = new Object[0];
    private final SubjectSubscriptionManager<T> iOf;

    public static <T> a<T> cfh() {
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
        this.iOf = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iOf.getLatest() == null || this.iOf.active) {
            Object cdg = NotificationLite.cdg();
            for (SubjectSubscriptionManager.b<T> bVar : this.iOf.terminate(cdg)) {
                bVar.bu(cdg);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iOf.getLatest() == null || this.iOf.active) {
            Object M = NotificationLite.M(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.iOf.terminate(M)) {
                try {
                    bVar.bu(M);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.ez(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iOf.getLatest() == null || this.iOf.active) {
            Object aY = NotificationLite.aY(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.iOf.next(aY)) {
                bVar.bu(aY);
            }
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        return this.iOf.observers().length > 0;
    }
}
