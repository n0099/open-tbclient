package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] kBQ = new Object[0];
    private final SubjectSubscriptionManager<T> kBR;

    public static <T> a<T> cQH() {
        return g(null, false);
    }

    private static <T> a<T> g(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.bq(t));
        }
        subjectSubscriptionManager.onAdded = new rx.functions.b<SubjectSubscriptionManager.b<T>>() { // from class: rx.subjects.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(SubjectSubscriptionManager.b<T> bVar) {
                bVar.bH(SubjectSubscriptionManager.this.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    protected a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.kBR = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kBR.getLatest() == null || this.kBR.active) {
            Object cPn = NotificationLite.cPn();
            for (SubjectSubscriptionManager.b<T> bVar : this.kBR.terminate(cPn)) {
                bVar.bG(cPn);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kBR.getLatest() == null || this.kBR.active) {
            Object N = NotificationLite.N(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.kBR.terminate(N)) {
                try {
                    bVar.bG(N);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.eN(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kBR.getLatest() == null || this.kBR.active) {
            Object bq = NotificationLite.bq(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.kBR.next(bq)) {
                bVar.bG(bq);
            }
        }
    }
}
