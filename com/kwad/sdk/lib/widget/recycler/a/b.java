package com.kwad.sdk.lib.widget.recycler.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class b<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10439a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f10440b;
    @NonNull
    private final e<T> c;
    @Nullable
    private final Runnable d;

    /* loaded from: classes3.dex */
    public static final class a<T> {
        private static final Object e = new Object();
        private static Executor f = null;
        private static final Executor g = new ExecutorC1141a();

        /* renamed from: a  reason: collision with root package name */
        private Executor f10441a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f10442b;
        private Runnable c;
        private final e<T> d;

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static class ExecutorC1141a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            final Handler f10443a;

            private ExecutorC1141a() {
                this.f10443a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f10443a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f10442b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f10441a == null) {
                this.f10441a = g;
            }
            if (this.f10442b == null) {
                synchronized (e) {
                    if (f == null) {
                        f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f10442b = f;
            }
            return new b<>(this.f10441a, this.f10442b, this.d, this.c);
        }
    }

    private b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f10439a = executor;
        this.f10440b = executor2;
        this.c = eVar;
        this.d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f10439a;
    }

    @NonNull
    public Executor b() {
        return this.f10440b;
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
