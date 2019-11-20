package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] kFe = new Object[0];
    private final SubjectSubscriptionManager<T> kFf;

    public static <T> a<T> cPR() {
        return h(null, false);
    }

    private static <T> a<T> h(T t, boolean z) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.bl(t));
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
        this.kFf = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kFf.getLatest() == null || this.kFf.active) {
            Object cOx = NotificationLite.cOx();
            for (SubjectSubscriptionManager.b<T> bVar : this.kFf.terminate(cOx)) {
                bVar.bB(cOx);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kFf.getLatest() == null || this.kFf.active) {
            Object N = NotificationLite.N(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.kFf.terminate(N)) {
                try {
                    bVar.bB(N);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.fa(arrayList);
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kFf.getLatest() == null || this.kFf.active) {
            Object bl = NotificationLite.bl(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.kFf.next(bl)) {
                bVar.bB(bl);
            }
        }
    }
}
