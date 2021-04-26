package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes6.dex */
public final class f implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37529a;

    public f(String str) {
        this.f37529a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f37529a);
        thread.setDaemon(true);
        return thread;
    }
}
