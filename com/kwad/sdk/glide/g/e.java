package com.kwad.sdk.glide.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f10320a = new Executor() { // from class: com.kwad.sdk.glide.g.e.1

        /* renamed from: a  reason: collision with root package name */
        private final Handler f10322a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f10322a.post(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f10321b = new Executor() { // from class: com.kwad.sdk.glide.g.e.2
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor a() {
        return f10320a;
    }

    public static Executor b() {
        return f10321b;
    }
}
