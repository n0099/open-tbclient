package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes5.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] qsc = new Object[0];
    private final SubjectSubscriptionManager<T> qEu;

    public static <T> a<T> eOb() {
        return f(null, false);
    }

    private static <T> a<T> f(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.next(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.cl(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.qEu = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qEu.getLatest() == null || this.qEu.active) {
            Object eMS = NotificationLite.eMS();
            for (SubjectSubscriptionManager.b<T> bVar : this.qEu.terminate(eMS)) {
                bVar.ck(eMS);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qEu.getLatest() == null || this.qEu.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.qEu.terminate(error)) {
                try {
                    bVar.ck(error);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.hk(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qEu.getLatest() == null || this.qEu.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.qEu.next(next)) {
                bVar.ck(next);
            }
        }
    }
}
