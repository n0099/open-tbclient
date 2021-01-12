package com.ss.android.downloadlib.f;

import android.annotation.TargetApi;
import android.os.AsyncTask;
/* loaded from: classes4.dex */
public class b {
    static final a pSy = new C1221b();

    /* loaded from: classes4.dex */
    private static class a {
        private a() {
        }

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable th) {
            }
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C1221b extends a {
        private C1221b() {
            super();
        }

        @Override // com.ss.android.downloadlib.f.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable th) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        pSy.a(asyncTask, tArr);
    }
}
