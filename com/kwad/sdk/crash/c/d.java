package com.kwad.sdk.crash.c;

import android.content.Context;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes4.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f9633a = false;

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f9634b = Thread.getDefaultUncaughtExceptionHandler();
    private Context c;

    public d(Context context) {
        this.c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.f9633a) {
                com.kwad.sdk.core.d.a.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
                this.f9634b.uncaughtException(thread, th);
                return;
            }
            this.f9633a = true;
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
            if (th != null && com.kwad.sdk.crash.b.a.a(th)) {
                c.d().a(th, new JavaExceptionMessage(), this.c);
            }
            this.f9634b.uncaughtException(thread, th);
        } catch (Throwable th2) {
            this.f9634b.uncaughtException(thread, th);
        }
    }
}
