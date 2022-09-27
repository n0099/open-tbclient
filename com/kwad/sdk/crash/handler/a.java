package com.kwad.sdk.crash.handler;

import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.CaughtExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.f;
import java.util.ArrayList;
import java.util.UUID;
/* loaded from: classes8.dex */
public final class a {
    public static void a(ExceptionMessage exceptionMessage) {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "upload msg=" + exceptionMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.c(exceptionMessage));
        new com.kwad.sdk.crash.report.request.b().a(arrayList, null);
    }

    public static void j(@NonNull Throwable th) {
        CaughtExceptionMessage caughtExceptionMessage = new CaughtExceptionMessage();
        caughtExceptionMessage.mLogUUID = UUID.randomUUID().toString();
        caughtExceptionMessage.mCrashDetail = th.toString();
        caughtExceptionMessage.mCrashSource = 1;
        f.b(th, caughtExceptionMessage, com.kwad.sdk.crash.d.wz().getContext());
        f.a(caughtExceptionMessage, 2);
        a(caughtExceptionMessage);
    }
}
