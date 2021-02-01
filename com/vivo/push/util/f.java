package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes15.dex */
final class f implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        this.f13687a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f13687a);
        thread.setDaemon(true);
        return thread;
    }
}
