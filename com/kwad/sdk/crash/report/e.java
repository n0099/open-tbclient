package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public interface e {
    File a();

    void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch);
}
