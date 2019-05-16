package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] kun = new Object[0];
    private final SubjectSubscriptionManager<T> kuo;

    public static <T> a<T> cMP() {
        return g(null, false);
    }

    private static <T> a<T> g(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.bo(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.bE(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.kuo = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kuo.getLatest() == null || this.kuo.active) {
            Object cLx = NotificationLite.cLx();
            for (SubjectSubscriptionManager.b<T> bVar : this.kuo.terminate(cLx)) {
                bVar.bD(cLx);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kuo.getLatest() == null || this.kuo.active) {
            Object N = NotificationLite.N(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.kuo.terminate(N)) {
                try {
                    bVar.bD(N);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.eK(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kuo.getLatest() == null || this.kuo.active) {
            Object bo = NotificationLite.bo(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.kuo.next(bo)) {
                bVar.bD(bo);
            }
        }
    }
}
