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
    public final Executor f35974a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f35975b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f35976c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f35977d;

    /* loaded from: classes6.dex */
    public static final class a<T> {

        /* renamed from: f  reason: collision with root package name */
        public static Executor f35979f;

        /* renamed from: a  reason: collision with root package name */
        public Executor f35981a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f35982b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f35983c;

        /* renamed from: d  reason: collision with root package name */
        public final e<T> f35984d;

        /* renamed from: e  reason: collision with root package name */
        public static final Object f35978e = new Object();

        /* renamed from: g  reason: collision with root package name */
        public static final Executor f35980g = new ExecutorC0426a();

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class ExecutorC0426a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f35985a;

            public ExecutorC0426a() {
                this.f35985a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f35985a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.f35984d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f35982b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f35981a == null) {
                this.f35981a = f35980g;
            }
            if (this.f35982b == null) {
                synchronized (f35978e) {
                    if (f35979f == null) {
                        f35979f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f35982b = f35979f;
            }
            return new b<>(this.f35981a, this.f35982b, this.f35984d, this.f35983c);
        }
    }

    public b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f35974a = executor;
        this.f35975b = executor2;
        this.f35976c = eVar;
        this.f35977d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f35974a;
    }

    @NonNull
    public Executor b() {
        return this.f35975b;
    }

    @NonNull
    public e<T> c() {
        return this.f35976c;
    }

    @Nullable
    public Runnable d() {
        return this.f35977d;
    }
}
