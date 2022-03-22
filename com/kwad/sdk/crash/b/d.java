package com.kwad.sdk.crash.b;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes7.dex */
public class d implements Thread.UncaughtExceptionHandler {
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f40169b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c  reason: collision with root package name */
    public Context f40170c;

    public d(Context context) {
        this.f40170c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.a) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
            this.f40169b.uncaughtException(thread, th);
            return;
        }
        this.a = true;
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
        if (th != null && com.kwad.sdk.crash.a.a.a(th)) {
            c.d().a(th, new JavaExceptionMessage(), this.f40170c);
        }
        this.f40169b.uncaughtException(thread, th);
    }
}
