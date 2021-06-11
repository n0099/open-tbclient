package h.t;

import h.d;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes8.dex */
public final class a<T> extends d<T, T> {

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f72008g = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public final SubjectSubscriptionManager<T> f72009f;

    /* renamed from: h.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1988a implements h.n.b<SubjectSubscriptionManager.c<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f72010e;

        public C1988a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f72010e = subjectSubscriptionManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(SubjectSubscriptionManager.c<T> cVar) {
            cVar.b(this.f72010e.getLatest());
        }
    }

    public a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.f72009f = subjectSubscriptionManager;
    }

    public static <T> a<T> K() {
        return L(null, false);
    }

    public static <T> a<T> L(T t, boolean z) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.h(t));
        }
        C1988a c1988a = new C1988a(subjectSubscriptionManager);
        subjectSubscriptionManager.onAdded = c1988a;
        subjectSubscriptionManager.onTerminated = c1988a;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f72009f.getLatest() == null || this.f72009f.active) {
            Object b2 = NotificationLite.b();
            for (SubjectSubscriptionManager.c<T> cVar : this.f72009f.terminate(b2)) {
                cVar.d(b2);
            }
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f72009f.getLatest() == null || this.f72009f.active) {
            Object c2 = NotificationLite.c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.c<T> cVar : this.f72009f.terminate(c2)) {
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
        if (this.f72009f.getLatest() == null || this.f72009f.active) {
            Object h2 = NotificationLite.h(t);
            for (SubjectSubscriptionManager.c<T> cVar : this.f72009f.next(h2)) {
                cVar.d(h2);
            }
        }
    }
}
