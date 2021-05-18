package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f34134a = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        f34134a.execute(runnable);
    }
}
