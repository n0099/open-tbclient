package com.kwad.sdk.lib.widget.recycler.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public final class b<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Executor f36776a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f36777b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f36778c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f36779d;

    /* loaded from: classes7.dex */
    public static final class a<T> {

        /* renamed from: f  reason: collision with root package name */
        public static Executor f36781f;

        /* renamed from: a  reason: collision with root package name */
        public Executor f36783a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f36784b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f36785c;

        /* renamed from: d  reason: collision with root package name */
        public final e<T> f36786d;

        /* renamed from: e  reason: collision with root package name */
        public static final Object f36780e = new Object();

        /* renamed from: g  reason: collision with root package name */
        public static final Executor f36782g = new ExecutorC0429a();

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class ExecutorC0429a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f36787a;

            public ExecutorC0429a() {
                this.f36787a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f36787a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.f36786d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f36784b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f36783a == null) {
                this.f36783a = f36782g;
            }
            if (this.f36784b == null) {
                synchronized (f36780e) {
                    if (f36781f == null) {
                        f36781f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f36784b = f36781f;
            }
            return new b<>(this.f36783a, this.f36784b, this.f36786d, this.f36785c);
        }
    }

    public b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f36776a = executor;
        this.f36777b = executor2;
        this.f36778c = eVar;
        this.f36779d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f36776a;
    }

    @NonNull
    public Executor b() {
        return this.f36777b;
    }

    @NonNull
    public e<T> c() {
        return this.f36778c;
    }

    @Nullable
    public Runnable d() {
        return this.f36779d;
    }
}
