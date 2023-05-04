package com.ss.android.downloadlib.g;

import android.annotation.TargetApi;
import android.os.AsyncTask;
/* loaded from: classes8.dex */
public class b {
    public static final a a = new C0692b();

    /* loaded from: classes8.dex */
    public static class a {
        public a() {
        }

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0692b extends a {
        public C0692b() {
            super();
        }

        @Override // com.ss.android.downloadlib.g.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        a.a(asyncTask, tArr);
    }
}
