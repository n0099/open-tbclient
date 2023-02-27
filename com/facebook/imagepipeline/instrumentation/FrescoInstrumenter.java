package com.facebook.imagepipeline.instrumentation;

import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public final class FrescoInstrumenter {
    @Nullable
    public static volatile Instrumenter sInstance;

    /* loaded from: classes7.dex */
    public interface Instrumenter {
        @Nullable
        Runnable decorateRunnable(Runnable runnable, String str);

        boolean isTracing();

        void markFailure(Object obj, Throwable th);

        @Nullable
        Object onBeforeSubmitWork(String str);

        @Nullable
        Object onBeginWork(Object obj, @Nullable String str);

        @Nullable
        void onEndWork(Object obj);
    }

    public static boolean isTracing() {
        Instrumenter instrumenter = sInstance;
        if (instrumenter == null) {
            return false;
        }
        return instrumenter.isTracing();
    }

    @Nullable
    public static Runnable decorateRunnable(@Nullable Runnable runnable, @Nullable String str) {
        Instrumenter instrumenter = sInstance;
        if (instrumenter != null && runnable != null && str != null) {
            return instrumenter.decorateRunnable(runnable, str);
        }
        return runnable;
    }

    public static void markFailure(@Nullable Object obj, Throwable th) {
        Instrumenter instrumenter = sInstance;
        if (instrumenter != null && obj != null) {
            instrumenter.markFailure(obj, th);
        }
    }

    @Nullable
    public static Object onBeginWork(@Nullable Object obj, @Nullable String str) {
        Instrumenter instrumenter = sInstance;
        if (instrumenter != null && obj != null) {
            return instrumenter.onBeginWork(obj, str);
        }
        return null;
    }

    @Nullable
    public static Object onBeforeSubmitWork(@Nullable String str) {
        Instrumenter instrumenter = sInstance;
        if (instrumenter != null && str != null) {
            return instrumenter.onBeforeSubmitWork(str);
        }
        return null;
    }

    public static void onEndWork(@Nullable Object obj) {
        Instrumenter instrumenter = sInstance;
        if (instrumenter != null && obj != null) {
            instrumenter.onEndWork(obj);
        }
    }

    public static void provide(@Nullable Instrumenter instrumenter) {
        sInstance = instrumenter;
    }
}
