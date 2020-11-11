package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes16.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] pRa = new Object[0];
    private final SubjectSubscriptionManager<T> qke;

    public static <T> a<T> eGM() {
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
                bVar.cr(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.qke = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qke.getLatest() == null || this.qke.active) {
            Object eFF = NotificationLite.eFF();
            for (SubjectSubscriptionManager.b<T> bVar : this.qke.terminate(eFF)) {
                bVar.cq(eFF);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qke.getLatest() == null || this.qke.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.qke.terminate(error)) {
                try {
                    bVar.cq(error);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.gT(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qke.getLatest() == null || this.qke.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.qke.next(next)) {
                bVar.cq(next);
            }
        }
    }
}
