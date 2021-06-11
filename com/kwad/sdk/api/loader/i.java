package com.kwad.sdk.api.loader;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f32346a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f32347b = new Handler(Looper.getMainLooper());

    public static Future<?> a(Runnable runnable) {
        return f32346a.submit(runnable);
    }
}
