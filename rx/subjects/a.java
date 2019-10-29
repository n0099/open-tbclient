package rx.subjects;

import java.util.ArrayList;
import rx.d;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes2.dex */
public final class a<T> extends c<T, T> {
    private static final Object[] kFV = new Object[0];
    private final SubjectSubscriptionManager<T> kFW;

    public static <T> a<T> cPT() {
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
        this.kFW = subjectSubscriptionManager;
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kFW.getLatest() == null || this.kFW.active) {
            Object cOz = NotificationLite.cOz();
            for (SubjectSubscriptionManager.b<T> bVar : this.kFW.terminate(cOz)) {
                bVar.bB(cOz);
            }
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kFW.getLatest() == null || this.kFW.active) {
            Object M = NotificationLite.M(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.b<T> bVar : this.kFW.terminate(M)) {
                try {
                    bVar.bB(M);
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
        if (this.kFW.getLatest() == null || this.kFW.active) {
            Object bl = NotificationLite.bl(t);
            for (SubjectSubscriptionManager.b<T> bVar : this.kFW.next(bl)) {
                bVar.bB(bl);
            }
        }
    }
}
