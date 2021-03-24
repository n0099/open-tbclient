package h.t;

import h.d;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes7.dex */
public final class a<T> extends d<T, T> {

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f68003g = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public final SubjectSubscriptionManager<T> f68004f;

    /* renamed from: h.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1885a implements h.n.b<SubjectSubscriptionManager.c<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f68005e;

        public C1885a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f68005e = subjectSubscriptionManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(SubjectSubscriptionManager.c<T> cVar) {
            cVar.b(this.f68005e.getLatest());
        }
    }

    public a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.f68004f = subjectSubscriptionManager;
    }

    public static <T> a<T> L() {
        return M(null, false);
    }

    public static <T> a<T> M(T t, boolean z) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.g(t));
        }
        C1885a c1885a = new C1885a(subjectSubscriptionManager);
        subjectSubscriptionManager.onAdded = c1885a;
        subjectSubscriptionManager.onTerminated = c1885a;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68004f.getLatest() == null || this.f68004f.active) {
            Object b2 = NotificationLite.b();
            for (SubjectSubscriptionManager.c<T> cVar : this.f68004f.terminate(b2)) {
                cVar.d(b2);
            }
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f68004f.getLatest() == null || this.f68004f.active) {
            Object c2 = NotificationLite.c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.c<T> cVar : this.f68004f.terminate(c2)) {
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
        if (this.f68004f.getLatest() == null || this.f68004f.active) {
            Object g2 = NotificationLite.g(t);
            for (SubjectSubscriptionManager.c<T> cVar : this.f68004f.next(g2)) {
                cVar.d(g2);
            }
        }
    }
}
