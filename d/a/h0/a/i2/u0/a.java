package d.a.h0.a.i2.u0;

import android.os.Handler;
import java.util.Collection;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d.a.h0.a.i2.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0674a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f42830e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f42831f;

        public RunnableC0674a(b bVar, Object obj) {
            this.f42830e = bVar;
            this.f42831f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42830e.onCallback(this.f42831f);
        }
    }

    public static <T> void a(Handler handler, b<T> bVar, Collection<T> collection) {
        if (bVar == null || collection == null || collection.isEmpty()) {
            return;
        }
        for (T t : collection) {
            e(handler, bVar, t);
        }
    }

    public static <T> void b(Handler handler, b<T> bVar, T... tArr) {
        if (bVar == null || tArr == null || tArr.length < 1) {
            return;
        }
        for (T t : tArr) {
            e(handler, bVar, t);
        }
    }

    public static <T> void c(b<T> bVar, Collection<T> collection) {
        a(null, bVar, collection);
    }

    public static <T> void d(b<T> bVar, T... tArr) {
        b(null, bVar, tArr);
    }

    public static <T> void e(Handler handler, b<T> bVar, T t) {
        if (handler == null) {
            bVar.onCallback(t);
        } else {
            handler.post(new RunnableC0674a(bVar, t));
        }
    }
}
