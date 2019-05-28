package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] kuo = new Object[0];
    private final SubjectSubscriptionManager<T> kup;

    public static <T> a<T> cMR() {
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
        this.kup = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kup.getLatest() == null || this.kup.active) {
            Object cLz = NotificationLite.cLz();
            for (SubjectSubscriptionManager.b<T> bVar : this.kup.terminate(cLz)) {
                bVar.bD(cLz);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kup.getLatest() == null || this.kup.active) {
            Object N = NotificationLite.N(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.kup.terminate(N)) {
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
        if (this.kup.getLatest() == null || this.kup.active) {
            Object bo = NotificationLite.bo(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.kup.next(bo)) {
                bVar.bD(bo);
            }
        }
    }
}
