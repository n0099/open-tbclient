package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Executor f11117a = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        f11117a.execute(runnable);
    }
}
