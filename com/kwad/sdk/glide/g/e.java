package com.kwad.sdk.glide.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f10319a = new Executor() { // from class: com.kwad.sdk.glide.g.e.1

        /* renamed from: a  reason: collision with root package name */
        private final Handler f10321a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f10321a.post(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f10320b = new Executor() { // from class: com.kwad.sdk.glide.g.e.2
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor a() {
        return f10319a;
    }

    public static Executor b() {
        return f10320b;
    }
}
