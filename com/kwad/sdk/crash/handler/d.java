package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes5.dex */
public final class d implements Thread.UncaughtExceptionHandler {
    public volatile boolean a = false;
    public Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    public Context c;

    public d(Context context) {
        this.c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.a) {
                com.kwad.sdk.core.d.b.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
                return;
            }
            this.a = true;
            com.kwad.sdk.core.d.b.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
            if (th != null && com.kwad.sdk.crash.a.a.a(th)) {
                JavaExceptionMessage javaExceptionMessage = new JavaExceptionMessage();
                javaExceptionMessage.mCrashSource = 1;
                c.a().a(th, javaExceptionMessage, this.c);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.b;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
        } catch (Throwable unused) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.b;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
        }
    }
}
