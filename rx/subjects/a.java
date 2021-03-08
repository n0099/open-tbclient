package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes4.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] qte = new Object[0];
    private final SubjectSubscriptionManager<T> qFw;

    public static <T> a<T> eNR() {
        return g((Object) null, false);
    }

    private static <T> a<T> g(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.next(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.cm(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.qFw = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qFw.getLatest() == null || this.qFw.active) {
            Object eMI = NotificationLite.eMI();
            for (SubjectSubscriptionManager.b<T> bVar : this.qFw.terminate(eMI)) {
                bVar.cl(eMI);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qFw.getLatest() == null || this.qFw.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.qFw.terminate(error)) {
                try {
                    bVar.cl(error);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.hj(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qFw.getLatest() == null || this.qFw.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.qFw.next(next)) {
                bVar.cl(next);
            }
        }
    }
}
