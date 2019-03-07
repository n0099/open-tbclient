package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] kcu = new Object[0];
    private final SubjectSubscriptionManager<T> kcv;

    public static <T> a<T> cFh() {
        return g(null, false);
    }

    private static <T> a<T> g(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.bp(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.bF(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.kcv = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kcv.getLatest() == null || this.kcv.active) {
            Object cDP = NotificationLite.cDP();
            for (SubjectSubscriptionManager.b<T> bVar : this.kcv.terminate(cDP)) {
                bVar.bE(cDP);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kcv.getLatest() == null || this.kcv.active) {
            Object O = NotificationLite.O(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.kcv.terminate(O)) {
                try {
                    bVar.bE(O);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.eF(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kcv.getLatest() == null || this.kcv.active) {
            Object bp = NotificationLite.bp(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.kcv.next(bp)) {
                bVar.bE(bp);
            }
        }
    }
}
