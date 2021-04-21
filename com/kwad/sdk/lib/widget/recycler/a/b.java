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
    public final Executor f36358a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f36359b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f36360c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f36361d;

    /* loaded from: classes6.dex */
    public static final class a<T> {

        /* renamed from: f  reason: collision with root package name */
        public static Executor f36363f;

        /* renamed from: a  reason: collision with root package name */
        public Executor f36365a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f36366b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f36367c;

        /* renamed from: d  reason: collision with root package name */
        public final e<T> f36368d;

        /* renamed from: e  reason: collision with root package name */
        public static final Object f36362e = new Object();

        /* renamed from: g  reason: collision with root package name */
        public static final Executor f36364g = new ExecutorC0443a();

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class ExecutorC0443a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f36369a;

            public ExecutorC0443a() {
                this.f36369a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f36369a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.f36368d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f36366b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f36365a == null) {
                this.f36365a = f36364g;
            }
            if (this.f36366b == null) {
                synchronized (f36362e) {
                    if (f36363f == null) {
                        f36363f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f36366b = f36363f;
            }
            return new b<>(this.f36365a, this.f36366b, this.f36368d, this.f36367c);
        }
    }

    public b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f36358a = executor;
        this.f36359b = executor2;
        this.f36360c = eVar;
        this.f36361d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f36358a;
    }

    @NonNull
    public Executor b() {
        return this.f36359b;
    }

    @NonNull
    public e<T> c() {
        return this.f36360c;
    }

    @Nullable
    public Runnable d() {
        return this.f36361d;
    }
}
