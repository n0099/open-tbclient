package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes14.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] qhY = new Object[0];
    private final SubjectSubscriptionManager<T> qur;

    public static <T> a<T> eLL() {
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
        this.qur = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qur.getLatest() == null || this.qur.active) {
            Object eKC = NotificationLite.eKC();
            for (SubjectSubscriptionManager.b<T> bVar : this.qur.terminate(eKC)) {
                bVar.ck(eKC);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qur.getLatest() == null || this.qur.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.qur.terminate(error)) {
                try {
                    bVar.ck(error);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.ho(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qur.getLatest() == null || this.qur.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.qur.next(next)) {
                bVar.ck(next);
            }
        }
    }
}
