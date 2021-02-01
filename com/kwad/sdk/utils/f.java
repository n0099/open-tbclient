package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Executor f10819a = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        f10819a.execute(runnable);
    }
}
