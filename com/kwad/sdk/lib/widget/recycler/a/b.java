package com.kwad.sdk.lib.widget.recycler.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public final class b<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Executor f36263a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f36264b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f36265c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f36266d;

    /* loaded from: classes6.dex */
    public static final class a<T> {

        /* renamed from: f  reason: collision with root package name */
        public static Executor f36268f;

        /* renamed from: a  reason: collision with root package name */
        public Executor f36270a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f36271b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f36272c;

        /* renamed from: d  reason: collision with root package name */
        public final e<T> f36273d;

        /* renamed from: e  reason: collision with root package name */
        public static final Object f36267e = new Object();

        /* renamed from: g  reason: collision with root package name */
        public static final Executor f36269g = new ExecutorC0440a();

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class ExecutorC0440a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f36274a;

            public ExecutorC0440a() {
                this.f36274a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f36274a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.f36273d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f36271b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f36270a == null) {
                this.f36270a = f36269g;
            }
            if (this.f36271b == null) {
                synchronized (f36267e) {
                    if (f36268f == null) {
                        f36268f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f36271b = f36268f;
            }
            return new b<>(this.f36270a, this.f36271b, this.f36273d, this.f36272c);
        }
    }

    public b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f36263a = executor;
        this.f36264b = executor2;
        this.f36265c = eVar;
        this.f36266d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f36263a;
    }

    @NonNull
    public Executor b() {
        return this.f36264b;
    }

    @NonNull
    public e<T> c() {
        return this.f36265c;
    }

    @Nullable
    public Runnable d() {
        return this.f36266d;
    }
}
