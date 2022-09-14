package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes8.dex */
public final class a {
    public static void b(@NonNull ExceptionMessage exceptionMessage) {
        m mVar = new m(10211L);
        mVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.e.a2(mVar);
    }
}
