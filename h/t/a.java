package h.t;

import h.d;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes7.dex */
public final class a<T> extends d<T, T> {

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f68008g = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public final SubjectSubscriptionManager<T> f68009f;

    /* renamed from: h.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1886a implements h.n.b<SubjectSubscriptionManager.c<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f68010e;

        public C1886a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f68010e = subjectSubscriptionManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(SubjectSubscriptionManager.c<T> cVar) {
            cVar.b(this.f68010e.getLatest());
        }
    }

    public a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.f68009f = subjectSubscriptionManager;
    }

    public static <T> a<T> L() {
        return M(null, false);
    }

    public static <T> a<T> M(T t, boolean z) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.h(t));
        }
        C1886a c1886a = new C1886a(subjectSubscriptionManager);
        subjectSubscriptionManager.onAdded = c1886a;
        subjectSubscriptionManager.onTerminated = c1886a;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68009f.getLatest() == null || this.f68009f.active) {
            Object b2 = NotificationLite.b();
            for (SubjectSubscriptionManager.c<T> cVar : this.f68009f.terminate(b2)) {
                cVar.d(b2);
            }
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f68009f.getLatest() == null || this.f68009f.active) {
            Object c2 = NotificationLite.c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.c<T> cVar : this.f68009f.terminate(c2)) {
                try {
                    cVar.d(c2);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            h.m.a.d(arrayList);
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f68009f.getLatest() == null || this.f68009f.active) {
            Object h2 = NotificationLite.h(t);
            for (SubjectSubscriptionManager.c<T> cVar : this.f68009f.next(h2)) {
                cVar.d(h2);
            }
        }
    }
}
