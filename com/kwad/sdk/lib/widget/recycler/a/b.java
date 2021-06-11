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
    public final Executor f36678a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f36679b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f36680c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f36681d;

    /* loaded from: classes7.dex */
    public static final class a<T> {

        /* renamed from: f  reason: collision with root package name */
        public static Executor f36683f;

        /* renamed from: a  reason: collision with root package name */
        public Executor f36685a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f36686b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f36687c;

        /* renamed from: d  reason: collision with root package name */
        public final e<T> f36688d;

        /* renamed from: e  reason: collision with root package name */
        public static final Object f36682e = new Object();

        /* renamed from: g  reason: collision with root package name */
        public static final Executor f36684g = new ExecutorC0426a();

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class ExecutorC0426a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f36689a;

            public ExecutorC0426a() {
                this.f36689a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                this.f36689a.post(runnable);
            }
        }

        public a(@NonNull e<T> eVar) {
            this.f36688d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            this.f36686b = executor;
            return this;
        }

        @NonNull
        public b<T> a() {
            if (this.f36685a == null) {
                this.f36685a = f36684g;
            }
            if (this.f36686b == null) {
                synchronized (f36682e) {
                    if (f36683f == null) {
                        f36683f = Executors.newFixedThreadPool(2);
                    }
                }
                this.f36686b = f36683f;
            }
            return new b<>(this.f36685a, this.f36686b, this.f36688d, this.f36687c);
        }
    }

    public b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        this.f36678a = executor;
        this.f36679b = executor2;
        this.f36680c = eVar;
        this.f36681d = runnable;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        return this.f36678a;
    }

    @NonNull
    public Executor b() {
        return this.f36679b;
    }

    @NonNull
    public e<T> c() {
        return this.f36680c;
    }

    @Nullable
    public Runnable d() {
        return this.f36681d;
    }
}
