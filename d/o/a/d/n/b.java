package d.o.a.d.n;

import android.annotation.TargetApi;
import android.os.AsyncTask;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final C1811b f66260a = new c();

    /* renamed from: d.o.a.d.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1811b {
        public C1811b() {
        }

        public abstract <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr);
    }

    @TargetApi(11)
    /* loaded from: classes6.dex */
    public static class c extends C1811b {
        public c() {
            super();
        }

        @Override // d.o.a.d.n.b.C1811b
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f66260a.a(asyncTask, tArr);
    }
}
