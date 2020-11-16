package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes14.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] pSD = new Object[0];
    private final SubjectSubscriptionManager<T> qlH;

    public static <T> a<T> eGN() {
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
                bVar.cs(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.qlH = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qlH.getLatest() == null || this.qlH.active) {
            Object eFG = NotificationLite.eFG();
            for (SubjectSubscriptionManager.b<T> bVar : this.qlH.terminate(eFG)) {
                bVar.cr(eFG);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qlH.getLatest() == null || this.qlH.active) {
            Object error = NotificationLite.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.qlH.terminate(error)) {
                try {
                    bVar.cr(error);
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
        if (this.qlH.getLatest() == null || this.qlH.active) {
            Object next = NotificationLite.next(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.qlH.next(next)) {
                bVar.cr(next);
            }
        }
    }
}
