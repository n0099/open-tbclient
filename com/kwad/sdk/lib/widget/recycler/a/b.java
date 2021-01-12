package com.kwad.sdk.lib.widget.recycler.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public final class b<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10437a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f10438b;
    @NonNull
    private final e<T> c;
    @Nullable
    private final Runnable d;

    /* loaded from: classes4.dex */
    public static final class a<T> {
        private static final Object e = new Object();
        private static Executor f = null;
        private static final Executor g = new ExecutorC1135a();

        /* renamed from: a  reason: collision with root package name */
        private Executor f10439a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f10440b;
        private Runnable c;
        private final e<T> d;

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private static class ExecutorC1135a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            final Handler f10441a;

            private ExecutorC1135a() {
                this.f10441a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f10441a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f10440b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f10439a == null) {
                this.f10439a = g;
            }
            if (this.f10440b == null) {
                synchronized (e) {
                    if (f == null) {
                        f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f10440b = f;
            }
            return new b<>(this.f10439a, this.f10440b, this.d, this.c);
        }
    }

    private b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f10437a = executor;
        this.f10438b = executor2;
        this.c = eVar;
        this.d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f10437a;
    }

    @NonNull
    public Executor b() {
        return this.f10438b;
    }

    @NonNull
    public e<T> c() {
        return this.c;
    }

    @Nullable
    public Runnable d() {
        return this.d;
    }
}
