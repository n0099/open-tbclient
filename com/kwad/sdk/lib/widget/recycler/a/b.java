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
    public final Executor f35973a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f35974b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f35975c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f35976d;

    /* loaded from: classes6.dex */
    public static final class a<T> {

        /* renamed from: f  reason: collision with root package name */
        public static Executor f35978f;

        /* renamed from: a  reason: collision with root package name */
        public Executor f35980a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f35981b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f35982c;

        /* renamed from: d  reason: collision with root package name */
        public final e<T> f35983d;

        /* renamed from: e  reason: collision with root package name */
        public static final Object f35977e = new Object();

        /* renamed from: g  reason: collision with root package name */
        public static final Executor f35979g = new ExecutorC0425a();

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class ExecutorC0425a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f35984a;

            public ExecutorC0425a() {
                this.f35984a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f35984a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.f35983d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f35981b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f35980a == null) {
                this.f35980a = f35979g;
            }
            if (this.f35981b == null) {
                synchronized (f35977e) {
                    if (f35978f == null) {
                        f35978f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f35981b = f35978f;
            }
            return new b<>(this.f35980a, this.f35981b, this.f35983d, this.f35982c);
        }
    }

    public b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f35973a = executor;
        this.f35974b = executor2;
        this.f35975c = eVar;
        this.f35976d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f35973a;
    }

    @NonNull
    public Executor b() {
        return this.f35974b;
    }

    @NonNull
    public e<T> c() {
        return this.f35975c;
    }

    @Nullable
    public Runnable d() {
        return this.f35976d;
    }
}
