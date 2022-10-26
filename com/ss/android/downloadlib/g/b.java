package com.ss.android.downloadlib.g;

import android.os.AsyncTask;
/* loaded from: classes8.dex */
public class b {
    public static final a a = new C0659b();

    /* loaded from: classes8.dex */
    public class a {
        public a() {
        }

        public void a(AsyncTask asyncTask, Object... objArr) {
            try {
                asyncTask.execute(objArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0659b extends a {
        public C0659b() {
            super();
        }

        @Override // com.ss.android.downloadlib.g.b.a
        public void a(AsyncTask asyncTask, Object... objArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(AsyncTask asyncTask, Object... objArr) {
        a.a(asyncTask, objArr);
    }
}
