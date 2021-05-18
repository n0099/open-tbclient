package h.t;

import h.d;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes7.dex */
public final class a<T> extends d<T, T> {

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f68709g = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    public final SubjectSubscriptionManager<T> f68710f;

    /* renamed from: h.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1935a implements h.n.b<SubjectSubscriptionManager.c<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f68711e;

        public C1935a(SubjectSubscriptionManager subjectSubscriptionManager) {
            this.f68711e = subjectSubscriptionManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(SubjectSubscriptionManager.c<T> cVar) {
            cVar.b(this.f68711e.getLatest());
        }
    }

    public a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        this.f68710f = subjectSubscriptionManager;
    }

    public static <T> a<T> K() {
        return L(null, false);
    }

    public static <T> a<T> L(T t, boolean z) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z) {
            subjectSubscriptionManager.setLatest(NotificationLite.h(t));
        }
        C1935a c1935a = new C1935a(subjectSubscriptionManager);
        subjectSubscriptionManager.onAdded = c1935a;
        subjectSubscriptionManager.onTerminated = c1935a;
        return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68710f.getLatest() == null || this.f68710f.active) {
            Object b2 = NotificationLite.b();
            for (SubjectSubscriptionManager.c<T> cVar : this.f68710f.terminate(b2)) {
                cVar.d(b2);
            }
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f68710f.getLatest() == null || this.f68710f.active) {
            Object c2 = NotificationLite.c(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.c<T> cVar : this.f68710f.terminate(c2)) {
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
        if (this.f68710f.getLatest() == null || this.f68710f.active) {
            Object h2 = NotificationLite.h(t);
            for (SubjectSubscriptionManager.c<T> cVar : this.f68710f.next(h2)) {
                cVar.d(h2);
            }
        }
    }
}
