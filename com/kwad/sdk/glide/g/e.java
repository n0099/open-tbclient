package com.kwad.sdk.glide.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f35998a = new Executor() { // from class: com.kwad.sdk.glide.g.e.1

        /* renamed from: a  reason: collision with root package name */
        public final Handler f36000a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f36000a.post(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f35999b = new Executor() { // from class: com.kwad.sdk.glide.g.e.2
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor a() {
        return f35998a;
    }

    public static Executor b() {
        return f35999b;
    }
}
