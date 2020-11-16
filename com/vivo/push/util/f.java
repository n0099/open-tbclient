package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes11.dex */
final class f implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.f4700a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f4700a);
        thread.setDaemon(true);
        return thread;
    }
}
