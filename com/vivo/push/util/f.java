package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes8.dex */
final class f implements ThreadFactory {
    final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.a);
        thread.setDaemon(true);
        return thread;
    }
}
