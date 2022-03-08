package com.kwad.sdk.crash.b;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes8.dex */
public class d implements Thread.UncaughtExceptionHandler {
    public volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f55092b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c  reason: collision with root package name */
    public Context f55093c;

    public d(Context context) {
        this.f55093c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.a) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
            this.f55092b.uncaughtException(thread, th);
            return;
        }
        this.a = true;
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
        if (th != null && com.kwad.sdk.crash.a.a.a(th)) {
            c.d().a(th, new JavaExceptionMessage(), this.f55093c);
        }
        this.f55092b.uncaughtException(thread, th);
    }
}
