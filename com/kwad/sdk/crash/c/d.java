package com.kwad.sdk.crash.c;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes7.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f35099a = false;

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f35100b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c  reason: collision with root package name */
    public Context f35101c;

    public d(Context context) {
        this.f35101c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f35099a) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
            this.f35100b.uncaughtException(thread, th);
            return;
        }
        this.f35099a = true;
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
        if (th != null && com.kwad.sdk.crash.b.a.a(th)) {
            c.d().a(th, new JavaExceptionMessage(), this.f35101c);
        }
        this.f35100b.uncaughtException(thread, th);
    }
}
