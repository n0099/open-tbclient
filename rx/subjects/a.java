package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] kbX = new Object[0];
    private final SubjectSubscriptionManager<T> kbY;

    public static <T> a<T> cFj() {
        return g(null, false);
    }

    private static <T> a<T> g(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.bm(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.bC(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.kbY = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kbY.getLatest() == null || this.kbY.active) {
            Object cDR = NotificationLite.cDR();
            for (SubjectSubscriptionManager.b<T> bVar : this.kbY.terminate(cDR)) {
                bVar.bB(cDR);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kbY.getLatest() == null || this.kbY.active) {
            Object O = NotificationLite.O(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.kbY.terminate(O)) {
                try {
                    bVar.bB(O);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.eC(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kbY.getLatest() == null || this.kbY.active) {
            Object bm = NotificationLite.bm(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.kbY.next(bm)) {
                bVar.bB(bm);
            }
        }
    }
}
