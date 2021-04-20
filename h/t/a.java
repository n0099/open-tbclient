package h.t;

import h.d;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes7.dex */
public final class a<T> extends d<T, T> {

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f69018g = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public final SubjectSubscriptionManager<T> f69019f;

    /* renamed from: h.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1921a implements h.n.b<SubjectSubscriptionManager.c<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f69020e;

        public C1921a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f69020e = subjectSubscriptionManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(SubjectSubscriptionManager.c<T> cVar) {
            cVar.b(this.f69020e.getLatest());
        }
    }

    public a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.f69019f = subjectSubscriptionManager;
    }

    public static <T> a<T> N() {
        return O(null, false);
    }

    public static <T> a<T> O(T t, boolean z) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.h(t));
        }
        C1921a c1921a = new C1921a(subjectSubscriptionManager);
        subjectSubscriptionManager.onAdded = c1921a;
        subjectSubscriptionManager.onTerminated = c1921a;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f69019f.getLatest() == null || this.f69019f.active) {
            Object b2 = NotificationLite.b();
            for (SubjectSubscriptionManager.c<T> cVar : this.f69019f.terminate(b2)) {
                cVar.d(b2);
            }
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f69019f.getLatest() == null || this.f69019f.active) {
            Object c2 = NotificationLite.c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.c<T> cVar : this.f69019f.terminate(c2)) {
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
        if (this.f69019f.getLatest() == null || this.f69019f.active) {
            Object h2 = NotificationLite.h(t);
            for (SubjectSubscriptionManager.c<T> cVar : this.f69019f.next(h2)) {
                cVar.d(h2);
            }
        }
    }
}
