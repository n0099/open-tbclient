package com.qq.e.comm.plugin.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes4.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f12889a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.qq.e.comm.plugin.util.s.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_IO_THREAD");
        }
    });
}
