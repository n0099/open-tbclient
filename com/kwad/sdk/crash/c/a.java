package com.kwad.sdk.crash.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.CaughtExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.f;
import java.util.ArrayList;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class a {
    public static int a() {
        return 2;
    }

    public static void a(ExceptionMessage exceptionMessage) {
        com.kwad.sdk.core.d.a.a("ExceptionCollector", "upload msg=" + exceptionMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.a(exceptionMessage));
        new com.kwad.sdk.crash.report.request.b().a(arrayList);
    }

    public static void a(@NonNull Throwable th) {
        CaughtExceptionMessage caughtExceptionMessage = new CaughtExceptionMessage();
        caughtExceptionMessage.mLogUUID = UUID.randomUUID().toString();
        caughtExceptionMessage.mCrashDetail = th.toString();
        f.a(th, caughtExceptionMessage, com.kwad.sdk.crash.d.a().f());
        f.a(caughtExceptionMessage, a());
        a(caughtExceptionMessage);
    }
}
