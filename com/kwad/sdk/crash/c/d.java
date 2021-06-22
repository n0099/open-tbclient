package com.kwad.sdk.crash.c;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes7.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f35197a = false;

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f35198b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c  reason: collision with root package name */
    public Context f35199c;

    public d(Context context) {
        this.f35199c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f35197a) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
            this.f35198b.uncaughtException(thread, th);
            return;
        }
        this.f35197a = true;
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
        if (th != null && com.kwad.sdk.crash.b.a.a(th)) {
            c.d().a(th, new JavaExceptionMessage(), this.f35199c);
        }
        this.f35198b.uncaughtException(thread, th);
    }
}
