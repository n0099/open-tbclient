package com.kwad.sdk.crash.c;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes6.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f34834a = false;

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f34835b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c  reason: collision with root package name */
    public Context f34836c;

    public d(Context context) {
        this.f34836c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f34834a) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
            this.f34835b.uncaughtException(thread, th);
            return;
        }
        this.f34834a = true;
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
        if (th != null && com.kwad.sdk.crash.b.a.a(th)) {
            c.d().a(th, new JavaExceptionMessage(), this.f34836c);
        }
        this.f34835b.uncaughtException(thread, th);
    }
}
