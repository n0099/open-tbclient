package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes6.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] nOj = new Object[0];
    private final SubjectSubscriptionManager<T> ohv;

    public static <T> a<T> dVC() {
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
                bVar.cg(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.ohv = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.ohv.getLatest() == null || this.ohv.active) {
            Object dUv = NotificationLite.dUv();
            for (SubjectSubscriptionManager.b<T> bVar : this.ohv.terminate(dUv)) {
                bVar.cf(dUv);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.ohv.getLatest() == null || this.ohv.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.ohv.terminate(error)) {
                try {
                    bVar.cf(error);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.fJ(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.ohv.getLatest() == null || this.ohv.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.ohv.next(next)) {
                bVar.cf(next);
            }
        }
    }
}
