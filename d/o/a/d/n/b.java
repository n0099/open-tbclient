package d.o.a.d.n;

import android.annotation.TargetApi;
import android.os.AsyncTask;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final C1837b f66770a = new c();

    /* renamed from: d.o.a.d.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1837b {
        public C1837b() {
        }

        public abstract <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr);
    }

    @TargetApi(11)
    /* loaded from: classes7.dex */
    public static class c extends C1837b {
        public c() {
            super();
        }

        @Override // d.o.a.d.n.b.C1837b
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        f66770a.a(asyncTask, tArr);
    }
}
