package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes6.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] nAF = new Object[0];
    private final SubjectSubscriptionManager<T> nTM;

    public static <T> a<T> dPo() {
        return e(null, false);
    }

    private static <T> a<T> e(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.next(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.cp(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.nTM = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.nTM.getLatest() == null || this.nTM.active) {
            Object dOh = NotificationLite.dOh();
            for (SubjectSubscriptionManager.b<T> bVar : this.nTM.terminate(dOh)) {
                bVar.co(dOh);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.nTM.getLatest() == null || this.nTM.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.nTM.terminate(error)) {
                try {
                    bVar.co(error);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.fA(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.nTM.getLatest() == null || this.nTM.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.nTM.next(next)) {
                bVar.co(next);
            }
        }
    }
}
