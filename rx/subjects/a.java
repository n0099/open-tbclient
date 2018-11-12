package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] iGX = new Object[0];
    private final SubjectSubscriptionManager<T> iGY;

    public static <T> a<T> cdf() {
        return g(null, false);
    }

    private static <T> a<T> g(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.aX(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.bu(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.iGY = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iGY.getLatest() == null || this.iGY.active) {
            Object cbe = NotificationLite.cbe();
            for (SubjectSubscriptionManager.b<T> bVar : this.iGY.terminate(cbe)) {
                bVar.bt(cbe);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iGY.getLatest() == null || this.iGY.active) {
            Object M = NotificationLite.M(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.iGY.terminate(M)) {
                try {
                    bVar.bt(M);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.ev(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iGY.getLatest() == null || this.iGY.active) {
            Object aX = NotificationLite.aX(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.iGY.next(aX)) {
                bVar.bt(aX);
            }
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        return this.iGY.observers().length > 0;
    }
}
