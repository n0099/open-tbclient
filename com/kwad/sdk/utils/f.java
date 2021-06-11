package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Executor f37527a = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        f37527a.execute(runnable);
    }
}
