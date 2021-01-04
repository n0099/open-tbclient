package com.kwad.sdk.api.loader;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f8507a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f8508b = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Future<?> a(Runnable runnable) {
        return f8507a.submit(runnable);
    }
}
