package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public interface e {
    void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch);

    File wv();
}
